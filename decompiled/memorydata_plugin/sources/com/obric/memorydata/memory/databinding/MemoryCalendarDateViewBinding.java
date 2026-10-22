package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.ui.view.MemoryDateTextView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryCalendarDateViewBinding implements ViewBinding {
    public final OUIFrameLayout memoryDateContainer;
    public final MemoryDateTextView memoryDateText;
    public final View memoryNotEmptyPoint;
    private final ConstraintLayout rootView;

    private MemoryCalendarDateViewBinding(ConstraintLayout r1, OUIFrameLayout r2, MemoryDateTextView r3, View r4) {
        this.rootView = r1;
        this.memoryDateContainer = r2;
        this.memoryDateText = r3;
        this.memoryNotEmptyPoint = r4;
    }

    public static MemoryCalendarDateViewBinding bind(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.memory_date_container, OaidModel.KEY_ID, "memory_date_container");
        OUIFrameLayout r2 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), OUIFrameLayout.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_date_text, OaidModel.KEY_ID, "memory_date_text");
        MemoryDateTextView r3 = (MemoryDateTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), MemoryDateTextView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_not_empty_point, OaidModel.KEY_ID, "memory_not_empty_point");
        View r1 = r6.findViewById(r0);
        if (r1 == null) goto L11;
        return new MemoryCalendarDateViewBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static MemoryCalendarDateViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryCalendarDateViewBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_calendar_date_view, "layout", "memory_calendar_date_view"), r4, false, "com.obric.memorydata.plugin");
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
