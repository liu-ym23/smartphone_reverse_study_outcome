package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCommonMemoryCardBinding implements ViewBinding {
    public final ImageView ivIcon;
    public final LinearLayout memoryBottomContainer;
    public final ConstraintLayout memoryListCard;
    public final ConstraintLayout memoryMainContainer;
    public final TextView memoryTime;
    private final ConstraintLayout rootView;
    public final TextView tvCategory;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private ItemCommonMemoryCardBinding(ConstraintLayout r1, ImageView r2, LinearLayout r3, ConstraintLayout r4, ConstraintLayout r5, TextView r6, TextView r7, TextView r8, TextView r9) {
        this.rootView = r1;
        this.ivIcon = r2;
        this.memoryBottomContainer = r3;
        this.memoryListCard = r4;
        this.memoryMainContainer = r5;
        this.memoryTime = r6;
        this.tvCategory = r7;
        this.tvSubtitle = r8;
        this.tvTitle = r9;
    }

    public static ItemCommonMemoryCardBinding bind(View r15) {
        int r0 = ZeusTransformUtils.mapRes(R.id.iv_icon, OaidModel.KEY_ID, "iv_icon");
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_bottom_container, OaidModel.KEY_ID, "memory_bottom_container");
        LinearLayout r8 = (LinearLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        ConstraintLayout r9 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r15, ConstraintLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.memory_main_container, OaidModel.KEY_ID, "memory_main_container");
        ConstraintLayout r10 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.memory_time, OaidModel.KEY_ID, "memory_time");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_category, OaidModel.KEY_ID, "tv_category");
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_subtitle, OaidModel.KEY_ID, "tv_subtitle");
        TextView r13 = (TextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title");
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r15.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L19;
        return new ItemCommonMemoryCardBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r15, ConstraintLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11, r12, r13, r14);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemCommonMemoryCardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemCommonMemoryCardBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_common_memory_card, "layout", "item_common_memory_card"), r4, false, "com.obric.memorydata.plugin");
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
