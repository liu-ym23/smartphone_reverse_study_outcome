package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.chip.v2.OChip;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryFeedbackChipDefaultBinding implements ViewBinding {
    private final OChip rootView;

    private MemoryFeedbackChipDefaultBinding(OChip r1) {
        this.rootView = r1;
    }

    public static MemoryFeedbackChipDefaultBinding bind(View r3) {
        Objects.requireNonNull(r3, "rootView");
        return new MemoryFeedbackChipDefaultBinding((OChip) ZeusTransformUtils.preCheckCast(r3, OChip.class, "com.obric.memorydata.plugin"));
    }

    public static MemoryFeedbackChipDefaultBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryFeedbackChipDefaultBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_feedback_chip_default, "layout", "memory_feedback_chip_default"), r4, false, "com.obric.memorydata.plugin");
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
