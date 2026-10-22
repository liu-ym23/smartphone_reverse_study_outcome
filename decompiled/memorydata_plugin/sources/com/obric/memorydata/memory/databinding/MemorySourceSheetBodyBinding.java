package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class MemorySourceSheetBodyBinding implements ViewBinding {
    private final RecyclerView rootView;
    public final RecyclerView rvMemorySourceSheet;

    private MemorySourceSheetBodyBinding(RecyclerView r1, RecyclerView r2) {
        this.rootView = r1;
        this.rvMemorySourceSheet = r2;
    }

    public static MemorySourceSheetBodyBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        RecyclerView r0 = (RecyclerView) ZeusTransformUtils.preCheckCast(r4, RecyclerView.class, "com.obric.memorydata.plugin");
        return new MemorySourceSheetBodyBinding((RecyclerView) ZeusTransformUtils.preCheckCast(r4, RecyclerView.class, "com.obric.memorydata.plugin"), r0);
    }

    public static MemorySourceSheetBodyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemorySourceSheetBodyBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_source_sheet_body, "layout", "memory_source_sheet_body"), r4, false, "com.obric.memorydata.plugin");
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
    public RecyclerView getRoot() {
        return this.rootView;
    }
}
