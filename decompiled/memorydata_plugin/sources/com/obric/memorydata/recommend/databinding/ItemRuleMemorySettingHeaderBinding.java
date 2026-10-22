package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRuleMemorySettingHeaderBinding implements ViewBinding {
    public final TextView appCategoryTitle;
    public final OCardListItem openAll;
    public final OCardListItem openCustom;
    public final OCardListItem openNone;
    private final LinearLayout rootView;

    private ItemRuleMemorySettingHeaderBinding(LinearLayout r1, TextView r2, OCardListItem r3, OCardListItem r4, OCardListItem r5) {
        this.rootView = r1;
        this.appCategoryTitle = r2;
        this.openAll = r3;
        this.openCustom = r4;
        this.openNone = r5;
    }

    public static ItemRuleMemorySettingHeaderBinding bind(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.app_category_title, OaidModel.KEY_ID, "app_category_title");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.openAll, OaidModel.KEY_ID, "openAll");
        OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.openCustom, OaidModel.KEY_ID, "openCustom");
        OCardListItem r9 = (OCardListItem) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.openNone, OaidModel.KEY_ID, "openNone");
        OCardListItem r10 = (OCardListItem) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L13;
        return new ItemRuleMemorySettingHeaderBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r11, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemRuleMemorySettingHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRuleMemorySettingHeaderBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_rule_memory_setting_header, "layout", "item_rule_memory_setting_header"), r4, false, "com.obric.memorydata.plugin");
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
