package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.forms.OInputView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryEditChipItemBinding implements ViewBinding {
    public final OChipGroup chipGroup;
    public final OInputView inputView;
    private final LinearLayoutCompat rootView;
    public final OTextView titleView;

    private MemoryEditChipItemBinding(LinearLayoutCompat r1, OChipGroup r2, OInputView r3, OTextView r4) {
        this.rootView = r1;
        this.chipGroup = r2;
        this.inputView = r3;
        this.titleView = r4;
    }

    public static MemoryEditChipItemBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.chip_group, OaidModel.KEY_ID, "chip_group");
        OChipGroup r2 = (OChipGroup) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OChipGroup.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.input_view, OaidModel.KEY_ID, "input_view");
        OInputView r3 = (OInputView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OInputView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.title_view, OaidModel.KEY_ID, "title_view");
        OTextView r1 = (OTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return new MemoryEditChipItemBinding((LinearLayoutCompat) ZeusTransformUtils.preCheckCast(r6, LinearLayoutCompat.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static MemoryEditChipItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryEditChipItemBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_edit_chip_item, "layout", "memory_edit_chip_item"), r4, false, "com.obric.memorydata.plugin");
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
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }
}
