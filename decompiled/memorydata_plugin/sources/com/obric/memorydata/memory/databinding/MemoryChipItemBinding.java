package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.chip.OChip;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryChipItemBinding implements ViewBinding {
    public final OChip chip;
    private final OChip rootView;

    private MemoryChipItemBinding(OChip r1, OChip r2) {
        this.rootView = r1;
        this.chip = r2;
    }

    public static MemoryChipItemBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        OChip r0 = (OChip) ZeusTransformUtils.preCheckCast(r4, OChip.class, "com.obric.memorydata.plugin");
        return new MemoryChipItemBinding((OChip) ZeusTransformUtils.preCheckCast(r4, OChip.class, "com.obric.memorydata.plugin"), r0);
    }

    public static MemoryChipItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryChipItemBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_chip_item, "layout", "memory_chip_item"), r4, false, "com.obric.memorydata.plugin");
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
    public OChip getRoot() {
        return this.rootView;
    }
}
