package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemProactiveNowProcessedBinding implements ViewBinding {
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final TextView tvMessage;

    private ItemProactiveNowProcessedBinding(ConstraintLayout r1, ImageView r2, TextView r3) {
        this.rootView = r1;
        this.ivIcon = r2;
        this.tvMessage = r3;
    }

    public static ItemProactiveNowProcessedBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.iv_icon, OaidModel.KEY_ID, "iv_icon");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_message, OaidModel.KEY_ID, "tv_message");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new ItemProactiveNowProcessedBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemProactiveNowProcessedBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemProactiveNowProcessedBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_proactive_now_processed, "layout", "item_proactive_now_processed"), r4, false, "com.obric.memorydata.plugin");
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
