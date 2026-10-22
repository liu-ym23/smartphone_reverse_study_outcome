package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProItemMemoryInfoSectionRowBinding implements ViewBinding {
    private final DeviceAdaptiveCardListItem rootView;

    private AutoMemoryProItemMemoryInfoSectionRowBinding(DeviceAdaptiveCardListItem r1) {
        this.rootView = r1;
    }

    public static AutoMemoryProItemMemoryInfoSectionRowBinding bind(View r3) {
        Objects.requireNonNull(r3, "rootView");
        return new AutoMemoryProItemMemoryInfoSectionRowBinding((DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r3, DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin"));
    }

    public static AutoMemoryProItemMemoryInfoSectionRowBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AutoMemoryProItemMemoryInfoSectionRowBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.auto_memory_pro_item_memory_info_section_row, "layout", "auto_memory_pro_item_memory_info_section_row"), r4, false, "com.obric.memorydata.plugin");
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
    public DeviceAdaptiveCardListItem getRoot() {
        return this.rootView;
    }
}
