package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryCalendarWeekViewBinding implements ViewBinding {
    public final LinearLayout memoryCalendarWeekView;
    private final LinearLayout rootView;

    private MemoryCalendarWeekViewBinding(LinearLayout r1, LinearLayout r2) {
        this.rootView = r1;
        this.memoryCalendarWeekView = r2;
    }

    public static MemoryCalendarWeekViewBinding bind(View r4) {
        Objects.requireNonNull(r4, "rootView");
        LinearLayout r0 = (LinearLayout) ZeusTransformUtils.preCheckCast(r4, LinearLayout.class, "com.obric.memorydata.plugin");
        return new MemoryCalendarWeekViewBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r4, LinearLayout.class, "com.obric.memorydata.plugin"), r0);
    }

    public static MemoryCalendarWeekViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryCalendarWeekViewBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_calendar_week_view, "layout", "memory_calendar_week_view"), r4, false, "com.obric.memorydata.plugin");
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
