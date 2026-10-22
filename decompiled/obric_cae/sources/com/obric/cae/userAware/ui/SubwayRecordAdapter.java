package com.obric.cae.userAware.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.datacollection.SubwayFeedbackInfo;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayRecordAdapter extends BaseAdapter {
    private static final String TAG = "SubwayRecordAdapter";
    private final Context context;
    private boolean isMultiSelectMode;
    private Toast mToast;
    private final List<SubwayFeedbackInfo> records;
    private final Set<Long> selectedRecordIds;

    public static class ViewHolder {
        CheckBox checkbox;
        TextView feedbackStatus;
        TextView subwayStation;
        TextView subwayStatus;
        TextView subwayTime;

        public ViewHolder() {
        }
    }

    public SubwayRecordAdapter(Context r8, List<SubwayFeedbackInfo> r10) {
        this.isMultiSelectMode = false;
        this.selectedRecordIds = new HashSet();
        this.context = r8;
        this.records = r10;
    }

    public static /* synthetic */ boolean b(SubwayRecordAdapter r8, SubwayFeedbackInfo r10, View r11) {
        return r8.lambda$getView$1(r10, r11);
    }

    public static /* synthetic */ void c(SubwayRecordAdapter r8, SubwayFeedbackInfo r10, View r11) {
        r8.lambda$getView$0(r10, r11);
    }

    private String getStringFromXML(int r8) {
        return UserAwareUtil.getStringValueFromXML(this.context, r8);
    }

    private String getSubwayStatusString(int r8) {
        return UserAwareUtil.getSubwayStateString(this.context, r8);
    }

    private /* synthetic */ void lambda$getView$0(SubwayFeedbackInfo r8, View r10) {
        if (this.isMultiSelectMode == false) goto L8;
        if (r8.getHasFeedback() == true) goto L8;
        toggleRecordSelection(r8.getId());
        return;
    L8:
        if (r8.getHasFeedback() == true) goto L11;
        ((SubwayStatusActivity) this.context).showFeedbackDialog(r8);
        return;
    L11:
        if (r8.getUserChoice() != 1) goto L13;
        int r11 = R.string.user_aware_har_selected_true;
    L14:
        showToast(getStringFromXML(r11));
        return;
    L13:
        r11 = R.string.user_aware_har_selected_false;
        goto L14
    }

    private /* synthetic */ boolean lambda$getView$1(SubwayFeedbackInfo r8, View r10) {
        if (r8.getHasFeedback() == true) goto L6;
        ((SubwayStatusActivity) this.context).enterMultiSelectMode();
        toggleRecordSelection(r8.getId());
        return true;
    L6:
        return false;
    }

    private void showToast(String r8) {
        Toast r10 = this.mToast;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        Toast r11 = Toast.makeText(this.context, r8, 0);
        this.mToast = r11;
        r11.show();
    }

    private void toggleRecordSelection(long r8) {
        if (this.selectedRecordIds.contains(Long.valueOf(r8)) == false) goto L5;
        this.selectedRecordIds.remove(Long.valueOf(r8));
    L6:
        notifyDataSetChanged();
        return;
    L5:
        this.selectedRecordIds.add(Long.valueOf(r8));
        goto L6
    }

    public void clearSelection() {
        this.selectedRecordIds.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.records.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r8) {
        return this.records.get(r8);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r8) {
        return this.records.get(r8).getId();
    }

    public Set<Long> getSelectedRecordIds() {
        return new HashSet(this.selectedRecordIds);
    }

    @Override // android.widget.Adapter
    public View getView(int r8, View r10, ViewGroup r11) {
        int r12 = 0;
        if (r10 != null) goto L5;
        r10 = LayoutInflater.from(this.context).inflate(R.layout.list_item_subway, r11, false);
        ViewHolder r13 = new ViewHolder();
        r13.subwayTime = (TextView) r10.findViewById(R.id.subway_time);
        r13.subwayStatus = (TextView) r10.findViewById(R.id.subway_status);
        r13.subwayStation = (TextView) r10.findViewById(R.id.subway_station);
        r13.feedbackStatus = (TextView) r10.findViewById(R.id.feedback_status);
        r13.checkbox = (CheckBox) r10.findViewById(R.id.checkbox);
        r10.setTag(r13);
    L6:
        SimpleDateFormat r14 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        SubwayFeedbackInfo r15 = this.records.get(r8);
        r13.subwayTime.setText(r14.format(new Date(r15.getTimeStamp())));
        r13.subwayStatus.setText(getSubwayStatusString(r15.getSubwayStatus()));
        String r16 = r15.getStationName();
        CaeLog.d(TAG, "Displaying record - subwayStatus=" + r15.getSubwayStatus() + ", stationName=" + r16);
        if (r16 == null) goto L9;
        r13.subwayStation.setText(r16);
    L10:
        r13.subwayStation.setVisibility(0);
        int r17 = 1;
        if (r15.getHasFeedback() == true) goto L14;
        Context r18 = this.context;
        Object r19 = androidx.core.content.a.f1674a;
        r10.setBackgroundColor(androidx.core.content.a.c.a(r18, R.color.yellow_f2a737_100));
        r13.feedbackStatus.setText(getStringFromXML(R.string.user_aware_har_no_select));
        TextView r20 = r13.feedbackStatus;
        Context r21 = this.context;
        int r22 = R.color.black_100;
    L13:
        r20.setTextColor(androidx.core.content.a.c.a(r21, r22));
        CheckBox r23 = r13.checkbox;
        if (this.isMultiSelectMode == true) goto L21;
    L23:
        r12 = 8;
    L24:
        r23.setVisibility(r12);
        r13.checkbox.setChecked(this.selectedRecordIds.contains(Long.valueOf(r15.getId())));
        r10.setOnClickListener(new o(this, r15, r17));
        r10.setOnLongClickListener(new p(this, r15, r17));
        return r10;
    L21:
        if (r15.getHasFeedback() == true) goto L23;
    L14:
        Context r24 = this.context;
        Object r25 = androidx.core.content.a.f1674a;
        r10.setBackgroundColor(androidx.core.content.a.c.a(r24, R.color.white));
        if (r15.getUserChoice() != 1) goto L17;
        r13.feedbackStatus.setText(getStringFromXML(R.string.user_aware_har_select_true));
        r20 = r13.feedbackStatus;
        r21 = this.context;
        r22 = R.color.green_3fc730_100;
        goto L13
    L17:
        r13.feedbackStatus.setText(getStringFromXML(R.string.user_aware_har_select_false));
        r20 = r13.feedbackStatus;
        r21 = this.context;
        r22 = R.color.red_f24c38_40;
        goto L13
    L9:
        r13.subwayStation.setText("null");
        goto L10
    L5:
        r13 = (ViewHolder) r10.getTag();
        goto L6
    }

    public void setMultiSelectMode(boolean r8) {
        this.isMultiSelectMode = r8;
        if (r8 == true) goto L5;
        this.selectedRecordIds.clear();
    L5:
        notifyDataSetChanged();
    }

    public void setSelectedRecords(Set<Long> r8) {
        this.selectedRecordIds.clear();
        this.selectedRecordIds.addAll(r8);
        notifyDataSetChanged();
    }
}
