package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRecommendTodoDataBinding implements ViewBinding {
    public final TextView createTimeText;
    public final TextView eventTimeText;
    public final TextView extraText;
    public final LinearLayout memoryGeneralization;
    public final TextView possibilityText;
    private final LinearLayout rootView;
    public final TextView titleText;
    public final TextView updateTimeText;

    private ItemRecommendTodoDataBinding(LinearLayout r1, TextView r2, TextView r3, TextView r4, LinearLayout r5, TextView r6, TextView r7, TextView r8) {
        this.rootView = r1;
        this.createTimeText = r2;
        this.eventTimeText = r3;
        this.extraText = r4;
        this.memoryGeneralization = r5;
        this.possibilityText = r6;
        this.titleText = r7;
        this.updateTimeText = r8;
    }

    public static ItemRecommendTodoDataBinding bind(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.create_time_text, OaidModel.KEY_ID, "create_time_text");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.event_time_text, OaidModel.KEY_ID, "event_time_text");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.extra_text, OaidModel.KEY_ID, "extra_text");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14, LinearLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.possibility_text, OaidModel.KEY_ID, "possibility_text");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.title_text, OaidModel.KEY_ID, "title_text");
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.update_time_text, OaidModel.KEY_ID, "update_time_text");
        TextView r13 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L17;
        return new ItemRecommendTodoDataBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r14, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemRecommendTodoDataBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRecommendTodoDataBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_recommend_todo_data, "layout", "item_recommend_todo_data"), r4, false, "com.obric.memorydata.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return bind(r6);
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
