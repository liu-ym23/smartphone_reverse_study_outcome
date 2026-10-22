package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OListItemSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRuleAppHeaderBinding implements ViewBinding {
    public final OListItemSettings newAppSetting;
    private final OListItemSettings rootView;

    private ItemRuleAppHeaderBinding(OListItemSettings r1, OListItemSettings r2) {
        this.rootView = r1;
        this.newAppSetting = r2;
    }

    public static ItemRuleAppHeaderBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        OListItemSettings r0 = (OListItemSettings) ZeusTransformUtils.preCheckCast(r4, OListItemSettings.class, "com.obric.memorydata.plugin");
        return new ItemRuleAppHeaderBinding((OListItemSettings) ZeusTransformUtils.preCheckCast(r4, OListItemSettings.class, "com.obric.memorydata.plugin"), r0);
    }

    public static ItemRuleAppHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRuleAppHeaderBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_rule_app_header, "layout", "item_rule_app_header"), r4, false, "com.obric.memorydata.plugin");
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
    public OListItemSettings getRoot() {
        return this.rootView;
    }
}
