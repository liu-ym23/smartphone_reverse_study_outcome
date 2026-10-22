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
public final class ItemAddressSearchBinding implements ViewBinding {
    public final DeviceAdaptiveCardListItem addressItem;
    private final DeviceAdaptiveCardListItem rootView;

    private ItemAddressSearchBinding(DeviceAdaptiveCardListItem r1, DeviceAdaptiveCardListItem r2) {
        this.rootView = r1;
        this.addressItem = r2;
    }

    public static ItemAddressSearchBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        DeviceAdaptiveCardListItem r0 = (DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r4, DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin");
        return new ItemAddressSearchBinding((DeviceAdaptiveCardListItem) ZeusTransformUtils.preCheckCast(r4, DeviceAdaptiveCardListItem.class, "com.obric.memorydata.plugin"), r0);
    }

    public static ItemAddressSearchBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemAddressSearchBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_address_search, "layout", "item_address_search"), r4, false, "com.obric.memorydata.plugin");
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
