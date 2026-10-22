package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OListItemSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRuleCategoryListBinding implements ViewBinding {
    public final View blockCardBottomBg;
    public final View blockCardTopBg;
    private final ConstraintLayout rootView;
    public final OListItemSwitch switchGuideApp;

    private ItemRuleCategoryListBinding(ConstraintLayout r1, View r2, View r3, OListItemSwitch r4) {
        this.rootView = r1;
        this.blockCardBottomBg = r2;
        this.blockCardTopBg = r3;
        this.switchGuideApp = r4;
    }

    public static ItemRuleCategoryListBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.block_card_bottom_bg, OaidModel.KEY_ID, "block_card_bottom_bg");
        View r2 = r6.findViewById(r0);
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.block_card_top_bg, OaidModel.KEY_ID, "block_card_top_bg");
        View r4 = r6.findViewById(r0);
        if (r4 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.switch_guide_app, OaidModel.KEY_ID, "switch_guide_app");
        OListItemSwitch r1 = (OListItemSwitch) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OListItemSwitch.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new ItemRuleCategoryListBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r4, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemRuleCategoryListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRuleCategoryListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_rule_category_list, "layout", "item_rule_category_list"), r4, false, "com.obric.memorydata.plugin");
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
