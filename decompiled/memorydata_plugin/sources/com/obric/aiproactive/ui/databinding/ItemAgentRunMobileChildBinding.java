package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.widget.GradientTextView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemAgentRunMobileChildBinding implements ViewBinding {
    public final TextView mobileChildOrdinal;
    public final GradientTextView mobileChildTitle;
    private final ConstraintLayout rootView;

    private ItemAgentRunMobileChildBinding(ConstraintLayout r1, TextView r2, GradientTextView r3) {
        this.rootView = r1;
        this.mobileChildOrdinal = r2;
        this.mobileChildTitle = r3;
    }

    public static ItemAgentRunMobileChildBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.mobile_child_ordinal, OaidModel.KEY_ID, "mobile_child_ordinal");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.mobile_child_title, OaidModel.KEY_ID, "mobile_child_title");
        GradientTextView r1 = (GradientTextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), GradientTextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new ItemAgentRunMobileChildBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemAgentRunMobileChildBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemAgentRunMobileChildBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_agent_run_mobile_child, "layout", "item_agent_run_mobile_child"), r4, false, "com.obric.memorydata.plugin");
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
