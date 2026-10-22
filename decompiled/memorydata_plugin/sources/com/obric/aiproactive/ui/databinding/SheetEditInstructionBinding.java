package com.obric.aiproactive.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class SheetEditInstructionBinding implements ViewBinding {
    public final EditText etContent;
    private final ConstraintLayout rootView;
    public final TextView tvCounter;

    private SheetEditInstructionBinding(ConstraintLayout r1, EditText r2, TextView r3) {
        this.rootView = r1;
        this.etContent = r2;
        this.tvCounter = r3;
    }

    public static SheetEditInstructionBinding bind(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.et_content, OaidModel.KEY_ID, "et_content");
        EditText r2 = (EditText) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), EditText.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_counter, OaidModel.KEY_ID, "tv_counter");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
        return new SheetEditInstructionBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.memorydata.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static SheetEditInstructionBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SheetEditInstructionBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.sheet_edit_instruction, "layout", "sheet_edit_instruction"), r4, false, "com.obric.memorydata.plugin");
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
