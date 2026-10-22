package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.checkbox.OCheckBox;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemoryListBinding implements ViewBinding {
    public final ConstraintLayout cardContainer;
    public final FrameLayout cardContent;
    public final ViewStub cardContentVs;
    public final ConstraintLayout cardWrapper;
    public final OCheckBox memoryItemCheckbox;
    public final View overlay;
    private final ConstraintLayout rootView;
    public final View timeLine;

    private ItemMemoryListBinding(ConstraintLayout r1, ConstraintLayout r2, FrameLayout r3, ViewStub r4, ConstraintLayout r5, OCheckBox r6, View r7, View r8) {
        this.rootView = r1;
        this.cardContainer = r2;
        this.cardContent = r3;
        this.cardContentVs = r4;
        this.cardWrapper = r5;
        this.memoryItemCheckbox = r6;
        this.overlay = r7;
        this.timeLine = r8;
    }

    public static ItemMemoryListBinding bind(View r11) {
        ConstraintLayout r4 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.mapRes(R.id.card_content, OaidModel.KEY_ID, "card_content");
        FrameLayout r5 = (FrameLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.card_content_vs, OaidModel.KEY_ID, "card_content_vs");
        ViewStub r6 = (ViewStub) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ViewStub.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.card_wrapper, OaidModel.KEY_ID, "card_wrapper");
        ConstraintLayout r7 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_item_checkbox, OaidModel.KEY_ID, "memory_item_checkbox");
        OCheckBox r8 = (OCheckBox) ZeusTransformUtils.preCheckCast(r11.findViewById(r0), OCheckBox.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.overlay, OaidModel.KEY_ID, "overlay");
        View r9 = r11.findViewById(r0);
        if (r9 == null) goto L17;
        r0 = ZeusTransformUtils.mapRes(R.id.time_line, OaidModel.KEY_ID, "time_line");
        View r10 = r11.findViewById(r0);
        if (r10 == null) goto L17;
        return new ItemMemoryListBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r11, ConstraintLayout.class, "com.obric.memorydata.plugin"), r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemoryListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemoryListBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_list, "layout", "item_memory_list"), r4, false, "com.obric.memorydata.plugin");
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
