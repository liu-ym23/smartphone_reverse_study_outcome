package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCalendarSelectionPanelBinding implements ViewBinding {
    public final LinearLayout checkboxContainer;
    public final ImageView ivEvent;
    public final ImageView ivTodo;
    public final OCheckBox oCheckbox;
    private final ConstraintLayout rootView;
    public final OTextView tvLocation;
    public final OTextView tvTime;
    public final OTextView tvTitle;

    private ItemCalendarSelectionPanelBinding(ConstraintLayout r1, LinearLayout r2, ImageView r3, ImageView r4, OCheckBox r5, OTextView r6, OTextView r7, OTextView r8) {
        this.rootView = r1;
        this.checkboxContainer = r2;
        this.ivEvent = r3;
        this.ivTodo = r4;
        this.oCheckbox = r5;
        this.tvLocation = r6;
        this.tvTime = r7;
        this.tvTitle = r8;
    }

    public static ItemCalendarSelectionPanelBinding bind(View r14) {
        int r0 = ZeusTransformUtils.mapRes(R.id.checkbox_container, OaidModel.KEY_ID, "checkbox_container");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.iv_event, OaidModel.KEY_ID, "iv_event");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.iv_todo, OaidModel.KEY_ID, "iv_todo");
        ImageView r9 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.o_checkbox, OaidModel.KEY_ID, "o_checkbox");
        OCheckBox r10 = (OCheckBox) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OCheckBox.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_location, OaidModel.KEY_ID, "tv_location");
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_time, OaidModel.KEY_ID, "tv_time");
        OTextView r12 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        OTextView r13 = (OTextView) ZeusTransformUtils.preCheckCast(r14.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L19;
        return new ItemCalendarSelectionPanelBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r14, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12, r13);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemCalendarSelectionPanelBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemCalendarSelectionPanelBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_calendar_selection_panel, "layout", "item_calendar_selection_panel"), r4, false, "com.obric.memorydata.plugin");
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
