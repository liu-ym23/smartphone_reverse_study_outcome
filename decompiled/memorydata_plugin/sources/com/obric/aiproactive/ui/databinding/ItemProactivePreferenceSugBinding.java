package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemProactivePreferenceSugBinding implements ViewBinding {
    public final ImageView ivIcon;
    public final LinearLayout llActions;
    private final ConstraintLayout rootView;
    public final TextView tvContent;

    private ItemProactivePreferenceSugBinding(ConstraintLayout r1, ImageView r2, LinearLayout r3, TextView r4) {
        this.rootView = r1;
        this.ivIcon = r2;
        this.llActions = r3;
        this.tvContent = r4;
    }

    public static ItemProactivePreferenceSugBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.iv_icon, OaidModel.KEY_ID, "iv_icon");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.ll_actions, OaidModel.KEY_ID, "ll_actions");
        LinearLayout r3 = (LinearLayout) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_content, OaidModel.KEY_ID, "tv_content");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ItemProactivePreferenceSugBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemProactivePreferenceSugBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemProactivePreferenceSugBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_proactive_preference_sug, "layout", "item_proactive_preference_sug"), r4, false, "com.obric.memorydata.plugin");
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
