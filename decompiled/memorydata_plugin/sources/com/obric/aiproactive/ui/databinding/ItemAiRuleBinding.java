package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ItemAiRuleBinding implements ViewBinding {
    public final OCardListItem cardItem;
    private final LinearLayout rootView;

    private ItemAiRuleBinding(LinearLayout r1, OCardListItem r2) {
        this.rootView = r1;
        this.cardItem = r2;
    }

    public static ItemAiRuleBinding bind(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.card_item, OaidModel.KEY_ID, "card_item");
        OCardListItem r1 = (OCardListItem) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), OCardListItem.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return new ItemAiRuleBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r4, LinearLayout.class, "com.obric.memorydata.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemAiRuleBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemAiRuleBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_ai_rule, "layout", "item_ai_rule"), r4, false, "com.obric.memorydata.plugin");
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
