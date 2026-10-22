package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemSensingEventBinding implements ViewBinding {
    public final LinearLayout eventTextContainer;
    private final ConstraintLayout rootView;
    public final TextView tvContent;
    public final TextView tvTime;
    public final View vDivider;
    public final View vDot;

    private ItemSensingEventBinding(ConstraintLayout r1, LinearLayout r2, TextView r3, TextView r4, View r5, View r6) {
        this.rootView = r1;
        this.eventTextContainer = r2;
        this.tvContent = r3;
        this.tvTime = r4;
        this.vDivider = r5;
        this.vDot = r6;
    }

    public static ItemSensingEventBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.event_text_container, OaidModel.KEY_ID, "event_text_container");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_content, OaidModel.KEY_ID, "tv_content");
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_time, OaidModel.KEY_ID, "tv_time");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.v_divider, OaidModel.KEY_ID, "v_divider");
        View r10 = r12.findViewById(r0);
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.v_dot, OaidModel.KEY_ID, "v_dot");
        View r11 = r12.findViewById(r0);
        if (r11 == null) goto L15;
        return new ItemSensingEventBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemSensingEventBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemSensingEventBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_sensing_event, "layout", "item_sensing_event"), r4, false, "com.obric.memorydata.plugin");
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
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
