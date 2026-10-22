package com.obric.memorydata.recommend.databinding;

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
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.forms.OInputLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class DialogBlockMemoryBinding implements ViewBinding {
    public final OInputLayout blockContentInput;
    public final OButton blockMemoryCancel;
    public final OButton blockMemoryConfirm;
    public final OCheckBox cbDeleteMemory;
    public final LinearLayout llDeleteMemory;
    private final LinearLayout rootView;
    public final FrameLayout simpleFormBodyContainer;
    public final FrameLayout simpleFormFooterContainer;
    public final TextView tvDeleteMemoryConfirm;

    private DialogBlockMemoryBinding(LinearLayout r1, OInputLayout r2, OButton r3, OButton r4, OCheckBox r5, LinearLayout r6, FrameLayout r7, FrameLayout r8, TextView r9) {
        this.rootView = r1;
        this.blockContentInput = r2;
        this.blockMemoryCancel = r3;
        this.blockMemoryConfirm = r4;
        this.cbDeleteMemory = r5;
        this.llDeleteMemory = r6;
        this.simpleFormBodyContainer = r7;
        this.simpleFormFooterContainer = r8;
        this.tvDeleteMemoryConfirm = r9;
    }

    public static DialogBlockMemoryBinding bind(View r15) {
        int r0 = ZeusTransformUtils.mapRes(R.id.block_content_input, OaidModel.KEY_ID, "block_content_input");
        OInputLayout r7 = (OInputLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.block_memory_cancel, OaidModel.KEY_ID, "block_memory_cancel");
        OButton r8 = (OButton) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.block_memory_confirm, OaidModel.KEY_ID, "block_memory_confirm");
        OButton r9 = (OButton) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.cb_delete_memory, OaidModel.KEY_ID, "cb_delete_memory");
        OCheckBox r10 = (OCheckBox) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), OCheckBox.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.ll_delete_memory, OaidModel.KEY_ID, "ll_delete_memory");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.simple_form_body_container, OaidModel.KEY_ID, "simple_form_body_container");
        FrameLayout r12 = (FrameLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.simple_form_footer_container, OaidModel.KEY_ID, "simple_form_footer_container");
        FrameLayout r13 = (FrameLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_delete_memory_confirm, OaidModel.KEY_ID, "tv_delete_memory_confirm");
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L21;
        return new DialogBlockMemoryBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r15, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12, r13, r14);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static DialogBlockMemoryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DialogBlockMemoryBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.dialog_block_memory, "layout", "dialog_block_memory"), r4, false, "com.obric.memorydata.plugin");
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
