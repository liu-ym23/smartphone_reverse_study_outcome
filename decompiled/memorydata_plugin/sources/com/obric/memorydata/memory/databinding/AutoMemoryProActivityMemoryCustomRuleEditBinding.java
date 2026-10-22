package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProActivityMemoryCustomRuleEditBinding implements ViewBinding {
    public final LinearLayout contentContainer;
    public final View cutOff;
    public final OInputLayout descInput;
    public final FrameLayout descInputLayer;
    private final FrameLayout rootView;
    public final OFloatingTitleBar viewTitle;

    private AutoMemoryProActivityMemoryCustomRuleEditBinding(FrameLayout r1, LinearLayout r2, View r3, OInputLayout r4, FrameLayout r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.contentContainer = r2;
        this.cutOff = r3;
        this.descInput = r4;
        this.descInputLayer = r5;
        this.viewTitle = r6;
    }

    public static AutoMemoryProActivityMemoryCustomRuleEditBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.content_container, OaidModel.KEY_ID, "content_container");
        LinearLayout r7 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r8 = r12.findViewById(r0);
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.desc_input, OaidModel.KEY_ID, "desc_input");
        OInputLayout r9 = (OInputLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.desc_input_layer, OaidModel.KEY_ID, "desc_input_layer");
        FrameLayout r10 = (FrameLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r11 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        return new AutoMemoryProActivityMemoryCustomRuleEditBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static AutoMemoryProActivityMemoryCustomRuleEditBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AutoMemoryProActivityMemoryCustomRuleEditBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.auto_memory_pro_activity_memory_custom_rule_edit, "layout", "auto_memory_pro_activity_memory_custom_rule_edit"), r4, false, "com.obric.memorydata.plugin");
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
