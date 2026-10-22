package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProActivityMemoryInfoSectionEditBinding implements ViewBinding {
    public final View cutOff;
    public final OInputLayout descInput;
    public final FrameLayout descInputLayer;
    public final TextView emptyText;
    public final LinearLayout itemContainer;
    private final FrameLayout rootView;
    public final LinearLayout sceneContainer;
    public final NestedScrollView scrollContainer;
    public final OFloatingTitleBar viewTitle;

    private AutoMemoryProActivityMemoryInfoSectionEditBinding(FrameLayout r1, View r2, OInputLayout r3, FrameLayout r4, TextView r5, LinearLayout r6, LinearLayout r7, NestedScrollView r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.cutOff = r2;
        this.descInput = r3;
        this.descInputLayer = r4;
        this.emptyText = r5;
        this.itemContainer = r6;
        this.sceneContainer = r7;
        this.scrollContainer = r8;
        this.viewTitle = r9;
    }

    public static AutoMemoryProActivityMemoryInfoSectionEditBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.cut_off, OaidModel.KEY_ID, "cut_off");
        View r4 = r12.findViewById(r0);
        if (r4 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.desc_input, OaidModel.KEY_ID, "desc_input");
        OInputLayout r5 = (OInputLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.desc_input_layer, OaidModel.KEY_ID, "desc_input_layer");
        FrameLayout r6 = (FrameLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.empty_text, OaidModel.KEY_ID, "empty_text");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.item_container, OaidModel.KEY_ID, "item_container");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.scene_container, OaidModel.KEY_ID, "scene_container");
        LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.scroll_container, OaidModel.KEY_ID, "scroll_container");
        NestedScrollView r10 = (NestedScrollView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), NestedScrollView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        r0 = ZeusTransformUtils.mapRes(R.id.view_title, OaidModel.KEY_ID, "view_title");
        OFloatingTitleBar r11 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L21;
        return new AutoMemoryProActivityMemoryInfoSectionEditBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static AutoMemoryProActivityMemoryInfoSectionEditBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AutoMemoryProActivityMemoryInfoSectionEditBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.auto_memory_pro_activity_memory_info_section_edit, "layout", "auto_memory_pro_activity_memory_info_section_edit"), r4, false, "com.obric.memorydata.plugin");
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
