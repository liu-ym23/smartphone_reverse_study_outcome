package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemoryDetailCalendarSectionBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RecyclerView rvCalendar;

    private ItemMemoryDetailCalendarSectionBinding(LinearLayout r1, RecyclerView r2) {
        this.rootView = r1;
        this.rvCalendar = r2;
    }

    public static ItemMemoryDetailCalendarSectionBinding bind(View r4) {
        int r0 = ZeusTransformUtils.mapRes(R.id.rv_calendar, OaidModel.KEY_ID, "rv_calendar");
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r4.findViewById(r0), RecyclerView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return new ItemMemoryDetailCalendarSectionBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r4, LinearLayout.class, "com.obric.memorydata.plugin"), r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemoryDetailCalendarSectionBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryDetailCalendarSectionBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_detail_calendar_section, "layout", "item_memory_detail_calendar_section"), r4, false, "com.obric.memorydata.plugin");
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
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
