package com.obric.cae.userAware.ui;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.cae.R;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.datacollection.SubwayFeedbackInfo;
import com.obric.cae.userAware.db.PoiArrivalRecordDatabase;
import com.obric.cae.userAware.db.SubwayRecordDatabase;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OCTitleBar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayStatusActivity extends androidx.appcompat.app.e {
    private static final String TAG = "SubwayStatusActivity";
    private SubwayRecordAdapter adapter;
    private List<SubwayFeedbackInfo> allRecords;
    private View bottomActionBar;
    private SubwayRecordDatabase database;
    private TextView dateFilterTextview;
    private TextView emptyStateText;
    private final List<SubwayFeedbackInfo> filteredRecords;
    private boolean isMultiSelectMode;
    private ListView listView;
    private OSwitch mSubwayFeedbackSwitch;
    private Toast mToast;
    private String userSelectData;

    public SubwayStatusActivity() {
        this.allRecords = new ArrayList();
        this.filteredRecords = new ArrayList();
        this.isMultiSelectMode = false;
    }

    private void batchUpdate(boolean r10) {
        Set<Long> r8 = this.adapter.getSelectedRecordIds();
        CaeLog.d(TAG, "batchUpdate: selectedIds size: " + r8.size() + ", ids: " + r8);
        if (r8.isEmpty() == false) goto L6;
        showToast(getStringFromXML(R.string.user_aware_har_please_select_record));
        return;
    L6:
        Iterator<SubwayFeedbackInfo> r11 = this.filteredRecords.iterator();
    L7:
        int r12 = 0;
        if (r11.hasNext() == false) goto L18;
        SubwayFeedbackInfo r13 = r11.next();
        if (r8.contains(Long.valueOf(r13.getId())) == false) goto L7;
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L16
        r14.put("subway_type", r13.getSubwayStatus());     // Catch: Exception -> L16
        r14.put(SubwayRecordDatabase.COLUMN_STATION_NAME, r13.getStationName());     // Catch: Exception -> L16
        if (r10 == false) goto L14;
        r12 = 1;
    L14:
        r14.put(PoiArrivalRecordDatabase.COLUMN_USER_CHOICE, r12);     // Catch: Exception -> L16
        ByteIOUtils.trackEvent("subway_feedback", r14);     // Catch: Exception -> L16
        CaeLog.d(TAG, "Reported subway feedback event (batch): " + r14.toString());     // Catch: Exception -> L16
    L16:
        e = move-exception;
        CaeLog.e(TAG, "Failed to report subway feedback event (batch)", e);
        goto L7
    L18:
        new Thread(new c1(this, r8, r10, r12), "BatchUpdateThread").start();
    }

    public static /* synthetic */ void d(SubwayStatusActivity r8, List r10) {
        r8.lambda$filterRecordsByDate$9(r10);
    }

    public static /* synthetic */ void e(DialogInterface r8, int r10) {
        lambda$showDateDialog$18(r8, r10);
    }

    private void exitMultiSelectMode() {
        this.isMultiSelectMode = false;
        this.bottomActionBar.setVisibility(8);
        this.adapter.setMultiSelectMode(false);
        invalidateOptionsMenu();
    }

    public static /* synthetic */ void f(SubwayStatusActivity r8, SubwayFeedbackInfo r10, boolean r11) {
        r8.lambda$updateRecordFeedback$14(r10, r11);
    }

    private void filterRecordsByDate() {
        String r8 = this.dateFilterTextview.getText().toString().trim();
        if (r8.isEmpty() == false) goto L6;
        Toast.makeText(this, getStringFromXML(R.string.user_aware_har_please_select_date), 0).show();
        return;
    L6:
        this.userSelectData = r8;
        filterRecordsByDate(r8);
    }

    public static /* synthetic */ void g(SubwayStatusActivity r8, int r10) {
        r8.lambda$updateRecordFeedback$13(r10);
    }

    private String getStringFromXML(int r8) {
        return UserAwareUtil.getStringValueFromXML(this, r8);
    }

    private String getSubwayStateString(int r8) {
        return UserAwareUtil.getSubwayStateString(this, r8);
    }

    private String getSubwayStatusString(int r8) {
        return UserAwareUtil.getSubwayStateString(this, r8);
    }

    public static /* synthetic */ void h(SubwayStatusActivity r8, View r10) {
        r8.lambda$onCreate$5(r10);
    }

    public static /* synthetic */ void i(SubwayStatusActivity r8, String r10) {
        r8.lambda$filterRecordsByDate$10(r10);
    }

    private void initializeSwitchState() {
        boolean r8 = "1".equals(Settings.Global.getString(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH));     // Catch: Exception -> L5
        this.mSubwayFeedbackSwitch.setChecked(r8);     // Catch: Exception -> L5
        CaeLog.d(TAG, "initializeSwitchState: " + r8);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        defpackage.b.k(e, new StringBuilder("Error getting switch state: "), TAG);
        this.mSubwayFeedbackSwitch.setChecked(false);
    }

    public static /* synthetic */ void j(SubwayStatusActivity r8) {
        r8.lambda$loadAllRecords$7();
    }

    public static /* synthetic */ void k(SubwayStatusActivity r8) {
        r8.lambda$showClearDialog$21();
    }

    public static /* synthetic */ void l(SubwayStatusActivity r8, View r10) {
        r8.lambda$onCreate$3(r10);
    }

    private /* synthetic */ void lambda$batchUpdate$15(int r8) {
        if (r8 <= 0) goto L9;
        exitMultiSelectMode();
        String r10 = this.userSelectData;
        if (r10 == null) goto L6;
        filterRecordsByDate(r10);
    L7:
        showToast(getStringFromXML(R.string.user_aware_har_batch_update_success));
        return;
    L6:
        loadAllRecords();
        goto L7
    }

    private /* synthetic */ void lambda$batchUpdate$16(Set r8, boolean r10) {
        runOnUiThread(new a1(this.database.batchUpdateFeedback(new ArrayList(r8), r10), 0, this));
    }

    private /* synthetic */ void lambda$filterRecordsByDate$10(String r8) {
        int r10 = 5;
        runOnUiThread(new f1(r10, this, this.database.getRecordsByDate(r8)));
    }

    private /* synthetic */ void lambda$filterRecordsByDate$9(List r8) {
        this.filteredRecords.clear();
        this.filteredRecords.addAll(r8);
        this.adapter.notifyDataSetChanged();
        updateEmptyState();
    }

    private /* synthetic */ void lambda$loadAllRecords$7() {
        this.filteredRecords.clear();
        this.filteredRecords.addAll(this.allRecords);
        this.adapter.notifyDataSetChanged();
        updateEmptyState();
    }

    private /* synthetic */ void lambda$loadAllRecords$8() {
        this.allRecords = this.database.getAllRecords();
        runOnUiThread(new c0(this, 4));
    }

    private /* synthetic */ void lambda$onCreate$0(View r8) {
        showDateDialog();
    }

    private /* synthetic */ void lambda$onCreate$1(CompoundButton r8, boolean r10) {
        CaeLog.d(TAG, "Subway feedback switch changed, checked: " + r10);
        ContentResolver r11 = getContentResolver();
        if (r10 == false) goto L5;
        String r12 = "1";
    L6:
        Settings.Global.putString(r11, AwareStateListener.SETTINGS_GLOBAL_SUBWAY_FEEDBACK_SWITCH, r12);
        return;
    L5:
        r12 = "0";
        goto L6
    }

    private /* synthetic */ void lambda$onCreate$2(View r8) {
        batchUpdate(true);
    }

    private /* synthetic */ void lambda$onCreate$3(View r8) {
        batchUpdate(false);
    }

    private /* synthetic */ void lambda$onCreate$4(View r8) {
        exitMultiSelectMode();
    }

    private /* synthetic */ void lambda$onCreate$5(View r8) {
        finish();
    }

    private /* synthetic */ void lambda$onCreate$6(View r8) {
        finish();
    }

    private /* synthetic */ void lambda$showClearDialog$20() {
        loadAllRecords();
        showToast(getStringFromXML(R.string.user_aware_har_clear_success));
    }

    private /* synthetic */ void lambda$showClearDialog$21() {
        this.database.deleteAllRecords();
        runOnUiThread(new b1(this, 0));
    }

    private /* synthetic */ void lambda$showClearDialog$22(DialogInterface r8, int r10) {
        new Thread(new b1(this, 2), "showClearDialogThread").start();
    }

    private /* synthetic */ void lambda$showDateDialog$17(DialogInterface r8, int r10) {
        this.dateFilterTextview.setText(getStringFromXML(R.string.user_aware_har_all_dates));
        loadAllRecords();
    }

    private static /* synthetic */ void lambda$showDateDialog$18(DialogInterface r8, int r10) {
        r8.dismiss();
    }

    private /* synthetic */ void lambda$showDateDialog$19(DatePicker r8, Calendar r10, DialogInterface r11, int r12) {
        r10.set(r8.getYear(), r8.getMonth(), r8.getDayOfMonth());
        this.dateFilterTextview.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(r10.getTime()));
        CaeLog.d(TAG, "selected date:" + r10.getTime());
        filterRecordsByDate();
    }

    private /* synthetic */ void lambda$showFeedbackDialog$11(SubwayFeedbackInfo r8, DialogInterface r10, int r11) {
        updateRecordFeedback(r8, true);
    }

    private /* synthetic */ void lambda$showFeedbackDialog$12(SubwayFeedbackInfo r8, DialogInterface r10, int r11) {
        updateRecordFeedback(r8, false);
    }

    private /* synthetic */ void lambda$updateRecordFeedback$13(int r8) {
        if (r8 <= 0) goto L9;
        String r10 = this.userSelectData;
        if (r10 == null) goto L6;
        filterRecordsByDate(r10);
    L7:
        showToast(getStringFromXML(R.string.user_aware_har_feedback_updated));
        return;
    L6:
        loadAllRecords();
        goto L7
    }

    private /* synthetic */ void lambda$updateRecordFeedback$14(SubwayFeedbackInfo r8, boolean r10) {
        runOnUiThread(new a1(this.database.updateRecordFeedback(r8.getId(), r10), 1, this));
    }

    private void loadAllRecords() {
        new Thread(new b1(this, 1), "LoadAllRecordsThread").start();
    }

    public static /* synthetic */ void m(SubwayStatusActivity r8) {
        r8.lambda$loadAllRecords$8();
    }

    public static /* synthetic */ void n(SubwayStatusActivity r8, View r10) {
        r8.lambda$onCreate$6(r10);
    }

    public static /* synthetic */ void o(SubwayStatusActivity r8, SubwayFeedbackInfo r10, DialogInterface r11, int r12) {
        r8.lambda$showFeedbackDialog$11(r10, r11, r12);
    }

    public static /* synthetic */ void p(SubwayStatusActivity r8, View r10) {
        r8.lambda$onCreate$4(r10);
    }

    public static /* synthetic */ void q(SubwayStatusActivity r8, Set r10, boolean r11) {
        r8.lambda$batchUpdate$16(r10, r11);
    }

    public static /* synthetic */ void r(SubwayStatusActivity r8, int r10) {
        r8.lambda$batchUpdate$15(r10);
    }

    public static /* synthetic */ void s(SubwayStatusActivity r8, CompoundButton r10, boolean r11) {
        r8.lambda$onCreate$1(r10, r11);
    }

    private void selectAllUnfeedback() {
        HashSet r8 = new HashSet();
        Iterator<SubwayFeedbackInfo> r10 = this.filteredRecords.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        SubwayFeedbackInfo r11 = r10.next();
        if (r11.getHasFeedback() == true) goto L4;
        r8.add(Long.valueOf(r11.getId()));
        goto L4
    L8:
        this.adapter.setSelectedRecords(r8);
    }

    private void showClearDialog() {
        new AlertDialog.Builder(this).setTitle(getStringFromXML(R.string.user_aware_har_clear_tile)).setMessage(getStringFromXML(R.string.user_aware_har_clear_confirm)).setPositiveButton(getStringFromXML(R.string.user_aware_har_confirm), new x0(this, 0)).setNegativeButton(getStringFromXML(R.string.user_aware_har_cancel), null).show();
    }

    private void showDateDialog() {
        Calendar r8 = Calendar.getInstance();
        int r10 = 1;
        int r11 = r8.get(1);
        int r12 = r8.get(2);
        int r13 = r8.get(5);
        DatePicker r14 = new DatePicker(this);
        r14.init(r11, r12, r13, null);
        AlertDialog.Builder r15 = new AlertDialog.Builder(this);
        r15.setTitle(getStringFromXML(R.string.user_aware_har_select_date));
        r15.setView(r14);
        r15.setNeutralButton(getStringFromXML(R.string.user_aware_har_all_dates), new x0(this, r10));
        r15.setNegativeButton(getStringFromXML(R.string.user_aware_har_cancel), new s(r10));
        r15.setPositiveButton(getStringFromXML(R.string.user_aware_har_confirm), new t(this, r14, r8, r10));
        r15.show();
    }

    private void showToast(String r8) {
        Toast r10 = this.mToast;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        Toast r11 = Toast.makeText(this, r8, 0);
        this.mToast = r11;
        r11.show();
    }

    public static /* synthetic */ void t(SubwayStatusActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showDateDialog$17(r10, r11);
    }

    public static /* synthetic */ void u(SubwayStatusActivity r8, View r10) {
        r8.lambda$onCreate$2(r10);
    }

    private void updateEmptyState() {
        if (this.filteredRecords.isEmpty() == false) goto L5;
        this.emptyStateText.setVisibility(0);
        this.listView.setVisibility(8);
        return;
    L5:
        this.emptyStateText.setVisibility(8);
        this.listView.setVisibility(0);
    }

    private void updateRecordFeedback(SubwayFeedbackInfo r8, boolean r10) {
        int r11 = 1;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L9
        r12.put("subway_type", r8.getSubwayStatus());     // Catch: Exception -> L9
        r12.put(SubwayRecordDatabase.COLUMN_STATION_NAME, r8.getStationName());     // Catch: Exception -> L9
        if (r10 == false) goto L6;
        int r13 = 1;
    L7:
        r12.put(PoiArrivalRecordDatabase.COLUMN_USER_CHOICE, r13);     // Catch: Exception -> L9
        ByteIOUtils.trackEvent("subway_feedback", r12);     // Catch: Exception -> L9
        CaeLog.d(TAG, "Reported subway feedback event: " + r12.toString());     // Catch: Exception -> L9
    L11:
        new Thread(new c1(this, r8, r10, r11), "UpdateRecordFeedbackThread").start();
        return;
    L6:
        r13 = 0;
    L9:
        e = move-exception;
        CaeLog.e(TAG, "Failed to report subway feedback event", e);
        goto L11
    }

    public static /* synthetic */ void v(SubwayStatusActivity r8, DatePicker r10, Calendar r11, DialogInterface r12, int r13) {
        r8.lambda$showDateDialog$19(r10, r11, r12, r13);
    }

    public static /* synthetic */ void w(SubwayStatusActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showClearDialog$22(r10, r11);
    }

    public static /* synthetic */ void x(SubwayStatusActivity r8, View r10) {
        r8.lambda$onCreate$0(r10);
    }

    public static /* synthetic */ void y(SubwayStatusActivity r8, SubwayFeedbackInfo r10, DialogInterface r11, int r12) {
        r8.lambda$showFeedbackDialog$12(r10, r11, r12);
    }

    public static /* synthetic */ void z(SubwayStatusActivity r8) {
        r8.lambda$showClearDialog$20();
    }

    public void enterMultiSelectMode() {
        this.isMultiSelectMode = true;
        this.bottomActionBar.setVisibility(0);
        this.adapter.setMultiSelectMode(true);
        invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_subway_status);
        CaeLog.d(TAG, "onCreate");
        TextView r10 = (TextView) findViewById(R.id.date_filter_textview);
        this.dateFilterTextview = r10;
        r10.setText(getStringFromXML(R.string.user_aware_har_all_dates));
        this.listView = (ListView) findViewById(R.id.list_view);
        this.bottomActionBar = findViewById(R.id.bottom_action_bar);
        this.emptyStateText = (TextView) findViewById(R.id.empty_state_text);
        this.database = new SubwayRecordDatabase(this);
        SubwayRecordAdapter r11 = new SubwayRecordAdapter(this, this.filteredRecords);
        this.adapter = r11;
        this.listView.setAdapter(r11);
        final int r12 = 0;
        findViewById(R.id.date_filter_textview).setOnClickListener(new y0(this, r12));
        this.mSubwayFeedbackSwitch = (OSwitch) findViewById(R.id.subway_feedback_switch);
        initializeSwitchState();
        final int r13 = 2;
        this.mSubwayFeedbackSwitch.setOnCheckedChangeListener(new g1(this, r13));
        findViewById(R.id.btn_correct).setOnClickListener(new z0(this, r12));
        final int r14 = 1;
        findViewById(R.id.btn_incorrect).setOnClickListener(new y0(this, r14));
        findViewById(R.id.btn_cancel).setOnClickListener(new n(this, r13));
        OCTitleBar r15 = (OCTitleBar) findViewById(R.id.subway_current_title);
        getSubwayStateString(Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_SUBWAY_STATE, -1));     // Catch: Exception -> L7
        if (r15 == null) goto L11;
        r15.setTitleText(getString(R.string.user_aware_subway_status_title));     // Catch: Exception -> L7
        r15.getMLeftActionBack().setOnClickListener(new z0(this, r14));     // Catch: Exception -> L7
    L11:
        loadAllRecords();
        return;
    L7:
        e = move-exception;
        CaeLog.e(TAG, "Failed to get subway state", e);
        if (r15 == null) goto L11;
        r15.setTitleText(getString(R.string.user_aware_subway_status_title));
        r15.getMLeftActionBack().setOnClickListener(new y0(this, r13));
        goto L11
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu r8) {
        getMenuInflater().inflate(R.menu.record_menu, r8);
        return true;
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.database.close();
        this.userSelectData = null;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r8) {
        int r10 = r8.getItemId();
        if (r10 != R.id.action_select_all) goto L7;
        selectAllUnfeedback();
        return true;
    L7:
        if (r10 != R.id.action_clear_all) goto L11;
        showClearDialog();
        return true;
    L11:
        return super.onOptionsItemSelected(r8);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu r8) {
        r8.findItem(R.id.action_select_all).setVisible(this.isMultiSelectMode);
        return true;
    }

    public void showFeedbackDialog(final SubwayFeedbackInfo r8) {
        new AlertDialog.Builder(this).setTitle(getStringFromXML(R.string.user_aware_har_status) + getSubwayStatusString(r8.getSubwayStatus()) + getStringFromXML(R.string.user_aware_har_user_select)).setPositiveButton(getStringFromXML(R.string.user_aware_har_select_true), new w(this, r8, 1)).setNegativeButton(getStringFromXML(R.string.user_aware_har_select_false), new d1(this, r8)).show();
    }

    private void filterRecordsByDate(String r8) {
        new Thread(new e1(3, this, r8), "FilterRecordsThread").start();
    }
}
