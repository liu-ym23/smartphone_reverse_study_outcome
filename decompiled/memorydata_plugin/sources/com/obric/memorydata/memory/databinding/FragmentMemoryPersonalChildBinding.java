package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentMemoryPersonalChildBinding implements ViewBinding {
    public final OTextView emptyDescription;
    public final OTextView emptyTitle;
    public final LinearLayout layoutEmpty;
    private final ConstraintLayout rootView;
    public final RecyclerView rvMemoryList;

    private FragmentMemoryPersonalChildBinding(ConstraintLayout r1, OTextView r2, OTextView r3, LinearLayout r4, RecyclerView r5) {
        this.rootView = r1;
        this.emptyDescription = r2;
        this.emptyTitle = r3;
        this.layoutEmpty = r4;
        this.rvMemoryList = r5;
    }

    public static FragmentMemoryPersonalChildBinding bind(View r11) {
        int r0 = ZeusTransformUtils.mapRes(R.id.empty_description, OaidModel.KEY_ID, "empty_description");
        OTextView r7 = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.empty_title, OaidModel.KEY_ID, "empty_title");
        OTextView r8 = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.layout_empty, OaidModel.KEY_ID, "layout_empty");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.rv_memory_list, OaidModel.KEY_ID, "rv_memory_list");
        RecyclerView r10 = (RecyclerView) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L13;
        return new FragmentMemoryPersonalChildBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static FragmentMemoryPersonalChildBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentMemoryPersonalChildBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.fragment_memory_personal_child, "layout", "fragment_memory_personal_child"), r4, false, "com.obric.memorydata.plugin");
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
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
