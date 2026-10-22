package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.ui.selection.SelectionPanelView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryCalendarDialogBodyBinding implements ViewBinding {
    public final FrameLayout calendarDialogBody;
    public final SelectionPanelView calendarSelectionPanel;
    private final FrameLayout rootView;

    private MemoryCalendarDialogBodyBinding(FrameLayout r1, FrameLayout r2, SelectionPanelView r3) {
        this.rootView = r1;
        this.calendarDialogBody = r2;
        this.calendarSelectionPanel = r3;
    }

    public static MemoryCalendarDialogBodyBinding bind(View r5) {
        FrameLayout r0 = (FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin");
        int r2 = ZeusTransformUtils.mapRes(R.id.calendar_selection_panel, OaidModel.KEY_ID, "calendar_selection_panel");
        SelectionPanelView r3 = (SelectionPanelView) ZeusTransformUtils.preCheckCast(r5.findViewById(r2), SelectionPanelView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        return new MemoryCalendarDialogBodyBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin"), r0, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r2)));
    }

    public static MemoryCalendarDialogBodyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MemoryCalendarDialogBodyBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.memory_calendar_dialog_body, "layout", "memory_calendar_dialog_body"), r4, false, "com.obric.memorydata.plugin");
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
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
