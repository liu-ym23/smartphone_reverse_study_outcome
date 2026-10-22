package com.obric.cae.userAware.ui;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.cae.R;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.datacollection.SubwayFeedbackInfo;
import com.obric.cae.userAware.datacollection.UserFeedbackInfo;
import com.obric.cae.userAware.db.PoiArrivalRecordDatabase;
import com.obric.cae.userAware.db.SubwayRecordDatabase;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.utils.UserAwareUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UserFeedbackActivity extends androidx.appcompat.app.e {
    private static final String TAG = "UserFeedbackActivity";
    private String mLocationStateValue;
    private String mStationName;
    private int mSubwayType;
    private String mType;
    private UserFeedbackInfo mUserFeedbackInfo;

    public UserFeedbackActivity() {
    }

    public static /* synthetic */ void d(UserFeedbackActivity r8, RadioGroup r10, View r11) {
        r8.lambda$onCreate$0(r10, r11);
    }

    public static /* synthetic */ void e(UserFeedbackActivity r8, int r10) {
        r8.lambda$saveSubwayFeedbackToDatabase$1(r10);
    }

    private void handleUserFeedbackData(UserFeedbackInfo r8) {
        String r10 = Settings.Global.getString(getApplication().getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_USER_PERIODIC_UPLOAD_MODE);
        if (r10 != null) goto L5;
    L7:
        CaeUserAwareReportBase r11 = CaeUserAwareReportFactory.getReportInstance();
        if (r11 == null) goto L11;
        r11.reportUserFeedbackInfo(r8);
        return;
    L11:
        return;
    L5:
        if (r10.equals("0") == true) goto L7;
        CaeLog.d(TAG, "handleUserFeedbackData: " + r8.toString());
        goto L7
    }

    private /* synthetic */ void lambda$onCreate$0(RadioGroup r8, View r10) {
        CaeLog.d(TAG, "submitButton clicked");
        RadioButton r11 = (RadioButton) findViewById(r8.getCheckedRadioButtonId());     // Catch: Exception -> L12
        if (r11 != null) goto L7;
        CaeLog.e(TAG, "Selected radio button is null");     // Catch: Exception -> L12
        Toast.makeText(this, R.string.user_aware_feedback_select_option, 0).show();     // Catch: Exception -> L12
        return;
    L7:
        String r12 = r11.getText().toString();     // Catch: Exception -> L12
        int r13 = r8.indexOfChild(r11);     // Catch: Exception -> L12
        this.mUserFeedbackInfo.setUserChoice(r13);     // Catch: Exception -> L12
        reportFeedbackEvent(r13);     // Catch: Exception -> L12
        if ("subway".equals(this.mType) == false) goto L10;
        saveSubwayFeedbackToDatabase(r13);     // Catch: Exception -> L12
    L10:
        handleUserFeedbackData(this.mUserFeedbackInfo);     // Catch: Exception -> L12
        Toast.makeText(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_feedback_select_context) + r12, 0).show();     // Catch: Exception -> L12
        finish();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        CaeLog.e(TAG, "Error while submitting feedback: " + e.getMessage());
        Toast.makeText(this, R.string.user_aware_feedback_submit_error, 0).show();
    }

    private /* synthetic */ void lambda$saveSubwayFeedbackToDatabase$1(int r10) {
        SubwayRecordDatabase r8 = new SubwayRecordDatabase(this);     // Catch: Exception -> L30
        SubwayFeedbackInfo r11 = r8.getLatestRecord();     // Catch: Exception -> L30
        if (r11 != null) goto L6;
    L28:
        String r12 = "No unfeedback subway record found to update";
    L27:
        CaeLog.w(TAG, r12);     // Catch: Exception -> L30
        return;
    L6:
        if (r11.getHasFeedback() == true) goto L28;
        boolean r13 = true;
        if (r11.getSubwayStatus() != this.mSubwayType) goto L10;
        boolean r14 = true;
    L11:
        String r15 = this.mStationName;     // Catch: Exception -> L30
        if (r15 == null) goto L18;
        if (r14 == true) goto L15;
    L19:
        r14 = false;
    L20:
        if (r14 == false) goto L26;
        long r16 = r11.getId();     // Catch: Exception -> L30
        if (r10 == 0) goto L25;
        r13 = false;
    L25:
        r8.updateRecordFeedback(r16, r13);     // Catch: Exception -> L30
        CaeLog.d(TAG, "Updated subway feedback to database: recordId=" + r11.getId() + ", userChoice=" + r10);     // Catch: Exception -> L30
        return;
    L26:
        r12 = "Latest record does not match subway state or station name";
        goto L27
    L15:
        if (r15.equals(r11.getStationName()) == false) goto L19;
        r14 = true;
        goto L20
    L18:
        if (r11.getStationName() == null) goto L20;
    L10:
        r14 = false;
    L30:
        e = move-exception;
        CaeLog.e(TAG, "Failed to save subway feedback to database", e);
    }

    private void reportFeedbackEvent(int r8) {
    L12:
        e = move-exception;
        CaeLog.e(TAG, "Failed to report feedback event", e);
        return;
    L5:
        if ("subway".equals(this.mType) == false) goto L9;
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L12
        r10.put("subway_type", this.mSubwayType);     // Catch: Exception -> L12
        r10.put(SubwayRecordDatabase.COLUMN_STATION_NAME, this.mStationName);     // Catch: Exception -> L12
        r10.put(PoiArrivalRecordDatabase.COLUMN_USER_CHOICE, r8);     // Catch: Exception -> L12
        ByteIOUtils.trackEvent("subway_feedback", r10);     // Catch: Exception -> L12
        String r11 = "Reported subway feedback event: " + r10.toString();     // Catch: Exception -> L12
    L7:
        CaeLog.d(TAG, r11);     // Catch: Exception -> L12
        return;
    L9:
        if ("home".equals(this.mType) == false) goto L18;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L12
        r12.put("location_state", this.mLocationStateValue);     // Catch: Exception -> L12
        r12.put(PoiArrivalRecordDatabase.COLUMN_USER_CHOICE, r8);     // Catch: Exception -> L12
        ByteIOUtils.trackEvent("home_status_feedback_submit", r12);     // Catch: Exception -> L12
        r11 = "Reported home feedback event: " + r12.toString();     // Catch: Exception -> L12
        goto L7
    }

    private void saveSubwayFeedbackToDatabase(int r8) {
        new Thread(new o0(r8, 2, this), "SaveSubwayFeedbackThread").start();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_aware_feedback);
        CaeLog.d(TAG, "onCreate");
        TextView r10 = (TextView) findViewById(R.id.title);
        String r11 = getIntent().getStringExtra("stateChange");
        String r12 = getIntent().getStringExtra("state");
        this.mType = getIntent().getStringExtra("type");
        StringBuilder r13 = defpackage.b.i("stateChange: ", r11, ", state: ", r12, ", type: ");
        r13.append(this.mType);
        CaeLog.d(TAG, r13.toString());
        if ("subway".equals(this.mType) == false) goto L19;
        this.mSubwayType = getIntent().getIntExtra("subway_type", 0);
        this.mStationName = getIntent().getStringExtra(SubwayRecordDatabase.COLUMN_STATION_NAME);
        UserFeedbackInfo r14 = new UserFeedbackInfo();
        this.mUserFeedbackInfo = r14;
        r14.setType(getString(R.string.user_aware_subway_feedback_type));
        this.mUserFeedbackInfo.setTimeStamp(System.currentTimeMillis());
        UserFeedbackInfo r15 = this.mUserFeedbackInfo;
        if (this.mSubwayType != 1) goto L7;
        int r16 = 100;
    L8:
        r15.setStateChange(r16);
        if (this.mSubwayType != 1) goto L11;
        int r17 = R.string.user_aware_subway_action_enter;
    L12:
        String r18 = getString(r17);
        String r19 = this.mStationName;
        if (r19 != null) goto L15;
    L17:
        String r20 = String.format(getString(R.string.user_aware_subway_prompt_without_station), new Object[]{r18});
    L27:
        r10.setText(r20);
        final RadioGroup r21 = (RadioGroup) findViewById(R.id.optionGroup1);
        ((Button) findViewById(R.id.submitButton)).setOnClickListener(new q1(this, r21));
        return;
    L15:
        if (r19.equals("NULL") == true) goto L17;
        r20 = String.format(getString(R.string.user_aware_subway_prompt_with_station), new Object[]{r18, this.mStationName});
        goto L27
    L11:
        r17 = R.string.user_aware_subway_action_exit;
        goto L12
    L7:
        r16 = 101;
        goto L8
    L19:
        if ("home".equals(this.mType) == false) goto L22;
        if (r12 == null) goto L22;
        this.mLocationStateValue = r12;
        UserFeedbackInfo r22 = new UserFeedbackInfo();
        this.mUserFeedbackInfo = r22;
        r22.setStateChange(UserAwareUtil.getStateChangeInteger(r12));
        this.mUserFeedbackInfo.setType("UserFeedback");
        this.mUserFeedbackInfo.setTimeStamp(System.currentTimeMillis());
        StringBuilder r23 = new StringBuilder();
        r23.append(UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_feedback_detected));
        String r24 = UserAwareUtil.getStateChangeString(getApplication(), r12);
    L26:
        r23.append(r24);
        r20 = r23.toString();
    L22:
        if (r11 != null) goto L24;
    L29:
        CaeLog.d(TAG, "state is null...return");
        r10.setText(R.string.user_aware_feedback_abnormal_function);
        return;
    L24:
        if (r11.equals("") == true) goto L29;
        UserFeedbackInfo r25 = new UserFeedbackInfo();
        this.mUserFeedbackInfo = r25;
        r25.setStateChange(UserAwareUtil.getStateChangeInteger(r11));
        this.mUserFeedbackInfo.setType("UserFeedback");
        this.mUserFeedbackInfo.setTimeStamp(System.currentTimeMillis());
        r23 = new StringBuilder();
        r23.append(UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_feedback_detected));
        r24 = UserAwareUtil.getStateChangeString(getApplication(), r11);
        goto L26
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CaeLog.d(TAG, "onCreate");
    }
}
