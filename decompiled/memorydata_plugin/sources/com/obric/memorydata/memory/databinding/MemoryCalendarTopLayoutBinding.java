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
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryCalendarTopLayoutBinding implements ViewBinding {
    public final ConstraintLayout calendarBarContainer;
    public final RecyclerView memoryCalendarTopDateList;
    public final View memoryCalendarTopDateListDisableMask;
    public final LinearLayout memoryCalendarWeekDay;
    private final ConstraintLayout rootView;

    private MemoryCalendarTopLayoutBinding(ConstraintLayout r1, ConstraintLayout r2, RecyclerView r3, View r4, LinearLayout r5) {
        this.rootView = r1;
        this.calendarBarContainer = r2;
        this.memoryCalendarTopDateList = r3;
        this.memoryCalendarTopDateListDisableMask = r4;
        this.memoryCalendarWeekDay = r5;
    }

    public static MemoryCalendarTopLayoutBinding bind(View r8) {
        ConstraintLayout r4 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r8, ConstraintLayout.class, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.mapRes(R.id.memory_calendar_top_date_list, OaidModel.KEY_ID, "memory_calendar_top_date_list");
        RecyclerView r5 = (RecyclerView) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_calendar_top_date_list_disable_mask, OaidModel.KEY_ID, "memory_calendar_top_date_list_disable_mask");
        View r6 = r8.findViewById(r0);
        if (r6 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_calendar_week_day, OaidModel.KEY_ID, "memory_calendar_week_day");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r8.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        return new MemoryCalendarTopLayoutBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r8, ConstraintLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static MemoryCalendarTopLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryCalendarTopLayoutBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_calendar_top_layout, "layout", "memory_calendar_top_layout"), r4, false, "com.obric.memorydata.plugin");
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
