package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.util.ProactiveTopBarIconButton;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.forms.OInputLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class SheetProactiveFeedbackFormBinding implements ViewBinding {
    public final ProactiveTopBarIconButton btnClose;
    public final TextView btnSubmit;
    public final OCheckBox cbFeedbackUpload;
    public final OChipGroup chipGroup;
    public final View dragHandle;
    public final OInputLayout etFeedbackDetail;
    public final FrameLayout layoutFeedbackInput;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;
    public final View viewBottomSpacing;

    private SheetProactiveFeedbackFormBinding(ConstraintLayout r1, ProactiveTopBarIconButton r2, TextView r3, OCheckBox r4, OChipGroup r5, View r6, OInputLayout r7, FrameLayout r8, TextView r9, View r10) {
        this.rootView = r1;
        this.btnClose = r2;
        this.btnSubmit = r3;
        this.cbFeedbackUpload = r4;
        this.chipGroup = r5;
        this.dragHandle = r6;
        this.etFeedbackDetail = r7;
        this.layoutFeedbackInput = r8;
        this.tvTitle = r9;
        this.viewBottomSpacing = r10;
    }

    public static SheetProactiveFeedbackFormBinding bind(View r17) {
        int r1 = ZeusTransformUtils.mapRes(R.id.btn_close, OaidModel.KEY_ID, "btn_close");
        ProactiveTopBarIconButton r8 = (ProactiveTopBarIconButton) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), ProactiveTopBarIconButton.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.btn_submit, OaidModel.KEY_ID, "btn_submit");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.cb_feedback_upload, OaidModel.KEY_ID, "cb_feedback_upload");
        OCheckBox r10 = (OCheckBox) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OCheckBox.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.chip_group, OaidModel.KEY_ID, "chip_group");
        OChipGroup r11 = (OChipGroup) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OChipGroup.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.drag_handle, OaidModel.KEY_ID, "drag_handle");
        View r12 = r17.findViewById(r1);
        if (r12 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.et_feedback_detail, OaidModel.KEY_ID, "et_feedback_detail");
        OInputLayout r13 = (OInputLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.layout_feedback_input, OaidModel.KEY_ID, "layout_feedback_input");
        FrameLayout r14 = (FrameLayout) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r17.findViewById(r1), TextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L23;
        r1 = ZeusTransformUtils.mapRes(R.id.view_bottom_spacing, OaidModel.KEY_ID, "view_bottom_spacing");
        View r16 = r17.findViewById(r1);
        if (r16 == null) goto L23;
        return new SheetProactiveFeedbackFormBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r17, ConstraintLayout.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r17, "com.obric.memorydata.plugin").getResourceName(r1)));
    }

    public static SheetProactiveFeedbackFormBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SheetProactiveFeedbackFormBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.sheet_proactive_feedback_form, "layout", "sheet_proactive_feedback_form"), r4, false, "com.obric.memorydata.plugin");
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
