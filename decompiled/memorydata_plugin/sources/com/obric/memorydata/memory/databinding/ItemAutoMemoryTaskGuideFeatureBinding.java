package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemAutoMemoryTaskGuideFeatureBinding implements ViewBinding {
    private final OCardListItem rootView;

    private ItemAutoMemoryTaskGuideFeatureBinding(OCardListItem r1) {
        this.rootView = r1;
    }

    public static ItemAutoMemoryTaskGuideFeatureBinding bind(View r3) {
        Objects.requireNonNull(r3, "rootView");
        return new ItemAutoMemoryTaskGuideFeatureBinding((OCardListItem) ZeusTransformUtils.preCheckCast(r3, OCardListItem.class, "com.obric.memorydata.plugin"));
    }

    public static ItemAutoMemoryTaskGuideFeatureBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemAutoMemoryTaskGuideFeatureBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_auto_memory_task_guide_feature, "layout", "item_auto_memory_task_guide_feature"), r4, false, "com.obric.memorydata.plugin");
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
    public OCardListItem getRoot() {
        return this.rootView;
    }
}
