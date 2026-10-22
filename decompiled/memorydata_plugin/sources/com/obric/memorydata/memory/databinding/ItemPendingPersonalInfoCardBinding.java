package com.obric.memorydata.memory.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemPendingPersonalInfoCardBinding implements ViewBinding {
    public final OButton pendingConfirm;
    public final OTextView pendingContent;
    public final OButton pendingIgnore;
    public final OTextView pendingSource;
    public final LinearLayout pendingSourceContainer;
    private final LinearLayout rootView;

    private ItemPendingPersonalInfoCardBinding(LinearLayout r1, OButton r2, OTextView r3, OButton r4, OTextView r5, LinearLayout r6) {
        this.rootView = r1;
        this.pendingConfirm = r2;
        this.pendingContent = r3;
        this.pendingIgnore = r4;
        this.pendingSource = r5;
        this.pendingSourceContainer = r6;
    }

    public static ItemPendingPersonalInfoCardBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.pending_confirm, OaidModel.KEY_ID, "pending_confirm");
        OButton r7 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.pending_content, OaidModel.KEY_ID, "pending_content");
        OTextView r8 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.pending_ignore, OaidModel.KEY_ID, "pending_ignore");
        OButton r9 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.pending_source, OaidModel.KEY_ID, "pending_source");
        OTextView r10 = (OTextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OTextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L15;
        r0 = ZeusTransformUtils.mapRes(R.id.pending_source_container, OaidModel.KEY_ID, "pending_source_container");
        LinearLayout r11 = (LinearLayout) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), LinearLayout.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L15;
        return new ItemPendingPersonalInfoCardBinding((LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ItemPendingPersonalInfoCardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemPendingPersonalInfoCardBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.item_pending_personal_info_card, "layout", "item_pending_personal_info_card"), r4, false, "com.obric.memorydata.plugin");
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
