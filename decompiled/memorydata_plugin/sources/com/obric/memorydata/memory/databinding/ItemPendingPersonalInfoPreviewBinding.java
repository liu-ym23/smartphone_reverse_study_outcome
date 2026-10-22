package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemPendingPersonalInfoPreviewBinding implements ViewBinding {
    public final ItemPendingPersonalInfoCardBinding pendingCard;
    public final ConstraintLayout pendingFront;
    public final OUIFrameLayout pendingFrontShadow;
    public final View pendingStackBack;
    public final OUIFrameLayout pendingStackMiddle;
    public final LinearLayout pendingViewAll;
    public final OTextView pendingViewAllText;
    private final ConstraintLayout rootView;

    private ItemPendingPersonalInfoPreviewBinding(ConstraintLayout r1, ItemPendingPersonalInfoCardBinding r2, ConstraintLayout r3, OUIFrameLayout r4, View r5, OUIFrameLayout r6, LinearLayout r7, OTextView r8) {
        this.rootView = r1;
        this.pendingCard = r2;
        this.pendingFront = r3;
        this.pendingFrontShadow = r4;
        this.pendingStackBack = r5;
        this.pendingStackMiddle = r6;
        this.pendingViewAll = r7;
        this.pendingViewAllText = r8;
    }

    public static ItemPendingPersonalInfoPreviewBinding bind(View r13) {
        int r0 = ZeusTransformUtils.mapRes(R.id.pending_card, OaidModel.KEY_ID, "pending_card");
        View r2 = r13.findViewById(r0);
        if (r2 == null) goto L19;
        ItemPendingPersonalInfoCardBinding r6 = ItemPendingPersonalInfoCardBinding.bind(r2);
        r0 = ZeusTransformUtils.mapRes(R.id.pending_front, OaidModel.KEY_ID, "pending_front");
        ConstraintLayout r7 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), ConstraintLayout.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.pending_front_shadow, OaidModel.KEY_ID, "pending_front_shadow");
        OUIFrameLayout r8 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OUIFrameLayout.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.pending_stack_back, OaidModel.KEY_ID, "pending_stack_back");
        View r9 = r13.findViewById(r0);
        if (r9 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.pending_stack_middle, OaidModel.KEY_ID, "pending_stack_middle");
        OUIFrameLayout r10 = (OUIFrameLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OUIFrameLayout.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.pending_view_all, OaidModel.KEY_ID, "pending_view_all");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L19;
        r0 = ZeusTransformUtils.mapRes(R.id.pending_view_all_text, OaidModel.KEY_ID, "pending_view_all_text");
        OTextView r12 = (OTextView) ZeusTransformUtils.preCheckCast(r13.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L19;
        return new ItemPendingPersonalInfoPreviewBinding((ConstraintLayout) ZeusTransformUtils.preCheckCast(r13, ConstraintLayout.class, "com.obric.memorydata.plugin"), r6, r7, r8, r9, r10, r11, r12);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemPendingPersonalInfoPreviewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemPendingPersonalInfoPreviewBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_pending_personal_info_preview, "layout", "item_pending_personal_info_preview"), r4, false, "com.obric.memorydata.plugin");
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
