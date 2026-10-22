package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMemorySourceSheetBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final OTextView sourceCount;
    public final ImageView sourceIcon;
    public final OTextView sourceName;
    public final ImageView sourceSelected;
    public final FrameLayout sourceTail;

    private ItemMemorySourceSheetBinding(ConstraintLayout r1, OTextView r2, ImageView r3, OTextView r4, ImageView r5, FrameLayout r6) {
        this.rootView = r1;
        this.sourceCount = r2;
        this.sourceIcon = r3;
        this.sourceName = r4;
        this.sourceSelected = r5;
        this.sourceTail = r6;
    }

    public static ItemMemorySourceSheetBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.source_count, OaidModel.KEY_ID, "source_count");
        OTextView r7 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.source_icon, OaidModel.KEY_ID, "source_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.source_name, OaidModel.KEY_ID, "source_name");
        OTextView r9 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.source_selected, OaidModel.KEY_ID, "source_selected");
        ImageView r10 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.source_tail, OaidModel.KEY_ID, "source_tail");
        FrameLayout r11 = (FrameLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), FrameLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        return new ItemMemorySourceSheetBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r12, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemMemorySourceSheetBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemMemorySourceSheetBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_memory_source_sheet, "layout", "item_memory_source_sheet"), r4, false, "com.obric.memorydata.plugin");
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
