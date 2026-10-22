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
public final class PendingPersonalInfoSheetBodyBinding implements ViewBinding {
    private final RecyclerView rootView;
    public final RecyclerView rvPendingPersonalInfo;

    private PendingPersonalInfoSheetBodyBinding(RecyclerView r1, RecyclerView r2) {
        this.rootView = r1;
        this.rvPendingPersonalInfo = r2;
    }

    public static PendingPersonalInfoSheetBodyBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        RecyclerView r0 = (RecyclerView) ZeusTransformUtils.preCheckCast(r4, RecyclerView.class, "com.obric.memorydata.plugin");
        return new PendingPersonalInfoSheetBodyBinding((RecyclerView) ZeusTransformUtils.preCheckCast(r4, RecyclerView.class, "com.obric.memorydata.plugin"), r0);
    }

    public static PendingPersonalInfoSheetBodyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PendingPersonalInfoSheetBodyBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.pending_personal_info_sheet_body, "layout", "pending_personal_info_sheet_body"), r4, false, "com.obric.memorydata.plugin");
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
