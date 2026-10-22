package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemGuideAppListBinding implements ViewBinding {
    public final View guideAppCardBottomBg;
    public final View guideAppCardTopBg;
    private final ConstraintLayout rootView;
    public final OCardListItem switchGuideApp;

    private ItemGuideAppListBinding(ConstraintLayout r1, View r2, View r3, OCardListItem r4) {
        this.rootView = r1;
        this.guideAppCardBottomBg = r2;
        this.guideAppCardTopBg = r3;
        this.switchGuideApp = r4;
    }

    public static ItemGuideAppListBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.guide_app_card_bottom_bg, OaidModel.KEY_ID, "guide_app_card_bottom_bg");
        View r2 = r6.findViewById(r0);
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.guide_app_card_top_bg, OaidModel.KEY_ID, "guide_app_card_top_bg");
        View r4 = r6.findViewById(r0);
        if (r4 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.switch_guide_app, OaidModel.KEY_ID, "switch_guide_app");
        OCardListItem r1 = (OCardListItem) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ItemGuideAppListBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r4, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemGuideAppListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemGuideAppListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_guide_app_list, "layout", "item_guide_app_list"), r4, false, "com.obric.memorydata.plugin");
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
