package com.obric.memorydata.recommend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.tab.OTabLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class ItemRuleMemoryTabBinding implements ViewBinding {
    private final OTabLayout rootView;

    private ItemRuleMemoryTabBinding(OTabLayout r1) {
        this.rootView = r1;
    }

    public static ItemRuleMemoryTabBinding bind(View r3) {
        Objects.requireNonNull(r3, "rootView");
        return new ItemRuleMemoryTabBinding((OTabLayout) ZeusTransformUtils.preCheckCast(r3, OTabLayout.class, "com.obric.memorydata.plugin"));
    }

    public static ItemRuleMemoryTabBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemRuleMemoryTabBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_rule_memory_tab, "layout", "item_rule_memory_tab"), r4, false, "com.obric.memorydata.plugin");
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
    public OTabLayout getRoot() {
        return this.rootView;
    }
}
