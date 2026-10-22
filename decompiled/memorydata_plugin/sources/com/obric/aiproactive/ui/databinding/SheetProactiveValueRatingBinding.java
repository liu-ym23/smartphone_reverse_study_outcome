package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.util.ProactiveTopBarIconButton;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OInputLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class SheetProactiveValueRatingBinding implements ViewBinding {
    public final ProactiveTopBarIconButton btnClose;
    public final OButton btnSubmit;
    public final View dragHandle;
    public final OInputLayout inputCustomAmount;
    private final ConstraintLayout rootView;
    public final TextView tvInputHint;
    public final TextView tvTitle;

    private SheetProactiveValueRatingBinding(ConstraintLayout r1, ProactiveTopBarIconButton r2, OButton r3, View r4, OInputLayout r5, TextView r6, TextView r7) {
        this.rootView = r1;
        this.btnClose = r2;
        this.btnSubmit = r3;
        this.dragHandle = r4;
        this.inputCustomAmount = r5;
        this.tvInputHint = r6;
        this.tvTitle = r7;
    }

    public static SheetProactiveValueRatingBinding bind(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_close, OaidModel.KEY_ID, "btn_close");
        ProactiveTopBarIconButton r7 = (ProactiveTopBarIconButton) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), ProactiveTopBarIconButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.btn_submit, OaidModel.KEY_ID, "btn_submit");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.drag_handle, OaidModel.KEY_ID, "drag_handle");
        View r9 = r13.findViewById(r0);
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.input_custom_amount, OaidModel.KEY_ID, "input_custom_amount");
        OInputLayout r10 = (OInputLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_input_hint, OaidModel.KEY_ID, "tv_input_hint");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L17;
        return new SheetProactiveValueRatingBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r13, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static SheetProactiveValueRatingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SheetProactiveValueRatingBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.sheet_proactive_value_rating, "layout", "sheet_proactive_value_rating"), r4, false, "com.obric.memorydata.plugin");
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
