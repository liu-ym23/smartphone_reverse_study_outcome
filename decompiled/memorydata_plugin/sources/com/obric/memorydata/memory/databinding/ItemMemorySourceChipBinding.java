package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemorySourceChipBinding implements ViewBinding {
    private final OTextView rootView;
    public final OTextView sourceChipText;

    private ItemMemorySourceChipBinding(OTextView r1, OTextView r2) {
        this.rootView = r1;
        this.sourceChipText = r2;
    }

    public static ItemMemorySourceChipBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        OTextView r0 = (OTextView) ZeusTransformUtils.preCheckCast(r4, OTextView.class, "com.obric.memorydata.plugin");
        return new ItemMemorySourceChipBinding((OTextView) ZeusTransformUtils.preCheckCast(r4, OTextView.class, "com.obric.memorydata.plugin"), r0);
    }

    public static ItemMemorySourceChipBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemorySourceChipBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_source_chip, "layout", "item_memory_source_chip"), r4, false, "com.obric.memorydata.plugin");
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
    public OTextView getRoot() {
        return this.rootView;
    }
}
