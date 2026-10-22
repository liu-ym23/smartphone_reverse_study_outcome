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
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCalendarCardBinding implements ViewBinding {
    public final OButton btnAction;
    public final ConstraintLayout clCalendar;
    public final ImageView ivIcon;
    public final LinearLayout llCalendarContent;
    private final ConstraintLayout rootView;
    public final OTextView tvCalendarContent;
    public final OTextView tvCalendarTitle;

    private ItemCalendarCardBinding(ConstraintLayout r1, OButton r2, ConstraintLayout r3, ImageView r4, LinearLayout r5, OTextView r6, OTextView r7) {
        this.rootView = r1;
        this.btnAction = r2;
        this.clCalendar = r3;
        this.ivIcon = r4;
        this.llCalendarContent = r5;
        this.tvCalendarContent = r6;
        this.tvCalendarTitle = r7;
    }

    public static ItemCalendarCardBinding bind(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_action, OaidModel.KEY_ID, "btn_action");
        OButton r7 = (OButton) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        ConstraintLayout r8 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r13, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.iv_icon, OaidModel.KEY_ID, "iv_icon");
        ImageView r9 = (ImageView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.ll_calendar_content, OaidModel.KEY_ID, "ll_calendar_content");
        LinearLayout r10 = (LinearLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_calendar_content, OaidModel.KEY_ID, "tv_calendar_content");
        OTextView r11 = (OTextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_calendar_title, OaidModel.KEY_ID, "tv_calendar_title");
        OTextView r12 = (OTextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L15;
        return new ItemCalendarCardBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r13, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemCalendarCardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemCalendarCardBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_calendar_card, "layout", "item_calendar_card"), r4, false, "com.obric.memorydata.plugin");
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
