package com.obric.memorydata.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class ViewIdentityLockOverlayBinding implements ViewBinding {
    public final OButton identityLockAction;
    public final ImageView identityLockIcon;
    public final FrameLayout identityLockOverlayRoot;
    public final TextView identityLockSubtitle;
    public final TextView identityLockTitle;
    private final FrameLayout rootView;

    private ViewIdentityLockOverlayBinding(FrameLayout r1, OButton r2, ImageView r3, FrameLayout r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.identityLockAction = r2;
        this.identityLockIcon = r3;
        this.identityLockOverlayRoot = r4;
        this.identityLockSubtitle = r5;
        this.identityLockTitle = r6;
    }

    public static ViewIdentityLockOverlayBinding bind(View r12) {
        int r0 = ZeusTransformUtils.mapRes(R.id.identity_lock_action, OaidModel.KEY_ID, "identity_lock_action");
        OButton r7 = (OButton) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), OButton.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.identity_lock_icon, OaidModel.KEY_ID, "identity_lock_icon");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), ImageView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L13;
        FrameLayout r9 = (FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin");
        r0 = ZeusTransformUtils.mapRes(R.id.identity_lock_subtitle, OaidModel.KEY_ID, "identity_lock_subtitle");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L13;
        r0 = ZeusTransformUtils.mapRes(R.id.identity_lock_title, OaidModel.KEY_ID, "identity_lock_title");
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r12.findViewById(r0), TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L13;
        return new ViewIdentityLockOverlayBinding((FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.memorydata.plugin"), r7, r8, r9, r10, r11);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getResourceName(r0)));
    }

    public static ViewIdentityLockOverlayBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewIdentityLockOverlayBinding inflate(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.view_identity_lock_overlay, "layout", "view_identity_lock_overlay"), r4, false, "com.obric.memorydata.plugin");
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
