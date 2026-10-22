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
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class HARRecordAdapter extends BaseAdapter {
    private static final String TAG = "HARRecordAdapter";
    private final Context context;
    private boolean isMultiSelectMode;
    private Toast mToast;
    private final List<HARFeedbackInfo> records;
    private final Set<Long> selectedRecordIds;

    public static class ViewHolder {
        CheckBox checkbox;
        TextView contentText;
        TextView statusText;

        public ViewHolder() {
        }
    }

    public HARRecordAdapter(Context r8, List<HARFeedbackInfo> r10) {
        this.isMultiSelectMode = false;
        this.selectedRecordIds = new HashSet();
        this.context = r8;
        this.records = r10;
    }

    public static /* synthetic */ void b(HARRecordAdapter r8, HARFeedbackInfo r10, View r11) {
        r8.lambda$getView$0(r10, r11);
    }

    public static /* synthetic */ boolean c(HARRecordAdapter r8, HARFeedbackInfo r10, View r11) {
        return r8.lambda$getView$1(r10, r11);
    }

    private String getStringFromXML(int r8) {
        return UserAwareUtil.getStringValueFromXML(this.context, r8);
    }

    private /* synthetic */ void lambda$getView$0(HARFeedbackInfo r8, View r10) {
        if (this.isMultiSelectMode == false) goto L8;
        if (r8.getHasFeedback() == true) goto L8;
        toggleRecordSelection(r8.getId());
        return;
    L8:
        if (r8.getHasFeedback() == true) goto L11;
        ((HARStatusActivity) this.context).showFeedbackDialog(r8);
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

    private /* synthetic */ boolean lambda$getView$1(HARFeedbackInfo r8, View r10) {
        if (r8.getHasFeedback() == true) goto L6;
        ((HARStatusActivity) this.context).enterMultiSelectMode();
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
        r10 = LayoutInflater.from(this.context).inflate(R.layout.list_item_record, r11, false);
        ViewHolder r13 = new ViewHolder();
        r13.contentText = (TextView) r10.findViewById(R.id.content_text);
        r13.statusText = (TextView) r10.findViewById(R.id.status_text);
        r13.checkbox = (CheckBox) r10.findViewById(R.id.checkbox);
        r10.setTag(r13);
    L6:
        SimpleDateFormat r14 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        HARFeedbackInfo r15 = this.records.get(r8);
        if (r8 <= 0) goto L9;
        String r16 = defpackage.a.f(r14.format(new Date(r15.getTimeStamp())), " - ", r14.format(new Date(this.records.get(r8 - 1).getTimeStamp())));
    L10:
        StringBuilder r17 = android.aimedia.a.j(r16);
        r17.append(getStringFromXML(R.string.user_aware_har_status));
        r17.append(UserAwareUtil.getHarStateString(this.context, r15.getStateCode()));
        r13.contentText.setText(r17.toString());
        if (r15.getHasFeedback() == true) goto L13;
        Context r18 = this.context;
        Object r19 = androidx.core.content.a.f1674a;
        r10.setBackgroundColor(androidx.core.content.a.c.a(r18, R.color.yellow_f2a737_100));
        r13.statusText.setText(getStringFromXML(R.string.user_aware_har_no_select));
        TextView r20 = r13.statusText;
        Context r21 = this.context;
        int r22 = R.color.black_100;
    L17:
        r20.setTextColor(androidx.core.content.a.c.a(r21, r22));
        CheckBox r23 = r13.checkbox;
        if (this.isMultiSelectMode == true) goto L20;
    L22:
        int r24 = 8;
    L23:
        r23.setVisibility(r24);
        r13.checkbox.setChecked(this.selectedRecordIds.contains(Long.valueOf(r15.getId())));
        r10.setOnClickListener(new o(this, r15, r12));
        r10.setOnLongClickListener(new p(this, r15, r12));
        return r10;
    L20:
        if (r15.getHasFeedback() == true) goto L22;
        r24 = 0;
        goto L23
    L13:
        Context r25 = this.context;
        Object r26 = androidx.core.content.a.f1674a;
        r10.setBackgroundColor(androidx.core.content.a.c.a(r25, R.color.white));
        if (r15.getUserChoice() != 1) goto L16;
        r13.statusText.setText(getStringFromXML(R.string.user_aware_har_select_true));
        r20 = r13.statusText;
        r21 = this.context;
        r22 = R.color.green_3fc730_100;
        goto L17
    L16:
        r13.statusText.setText(getStringFromXML(R.string.user_aware_har_select_false));
        r20 = r13.statusText;
        r21 = this.context;
        r22 = R.color.red_f24c38_100;
        goto L17
    L9:
        r16 = r14.format(new Date(r15.getTimeStamp())) + getStringFromXML(R.string.user_aware_har_until_now);
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
