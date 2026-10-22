package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OInputLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class DialogEditAiRuleBinding implements ViewBinding {
    public final OButton btnCancel;
    public final OButton btnConfirm;
    public final OInputLayout editRuleInput;
    private final LinearLayout rootView;
    public final FrameLayout simpleFormBodyContainer;
    public final FrameLayout simpleFormFooterContainer;
    public final TextView tvOverLimitWarning;

    private DialogEditAiRuleBinding(LinearLayout r1, OButton r2, OButton r3, OInputLayout r4, FrameLayout r5, FrameLayout r6, TextView r7) {
        this.rootView = r1;
        this.btnCancel = r2;
        this.btnConfirm = r3;
        this.editRuleInput = r4;
        this.simpleFormBodyContainer = r5;
        this.simpleFormFooterContainer = r6;
        this.tvOverLimitWarning = r7;
    }

    public static DialogEditAiRuleBinding bind(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_cancel, OaidModel.KEY_ID, "btn_cancel");
        OButton r7 = (OButton) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.btn_confirm, OaidModel.KEY_ID, "btn_confirm");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.edit_rule_input, OaidModel.KEY_ID, "edit_rule_input");
        OInputLayout r9 = (OInputLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.simple_form_body_container, OaidModel.KEY_ID, "simple_form_body_container");
        FrameLayout r10 = (FrameLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.simple_form_footer_container, OaidModel.KEY_ID, "simple_form_footer_container");
        FrameLayout r11 = (FrameLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_over_limit_warning, OaidModel.KEY_ID, "tv_over_limit_warning");
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L17;
        return new DialogEditAiRuleBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r13, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static DialogEditAiRuleBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DialogEditAiRuleBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.dialog_edit_ai_rule, "layout", "dialog_edit_ai_rule"), r4, false, "com.obric.memorydata.plugin");
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
