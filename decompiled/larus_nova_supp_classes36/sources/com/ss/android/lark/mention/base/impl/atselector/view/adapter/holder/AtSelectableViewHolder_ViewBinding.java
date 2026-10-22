package com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.joooonho.SelectableRoundedImageView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AtSelectableViewHolder_ViewBinding implements Unbinder {
    public AtSelectableViewHolder a;

    public final void unbind() {
        AtSelectableViewHolder r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mAtSelectCheckBox = null;
        r0.mSingleAvatarIV = null;
        r0.mNameTV = null;
        r0.mOwnerTV = null;
        r0.mDividerView = null;
        r0.mCustomStatus = null;
        r0.mTagWrapper = null;
        r0.mUserStatus = null;
        r0.mWorkStatus = null;
        r0.mShadow = null;
        r0.profileInfoCard = null;
        r0.departmentInfo = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public AtSelectableViewHolder_ViewBinding(AtSelectableViewHolder r4, View r5) {
        this.a = r4;
        r4.mAtSelectCheckBox = (UDCheckBox) Utils.findRequiredViewAsType(r5, 2131363313, "field 'mAtSelectCheckBox'", UDCheckBox.class);
        r4.mSingleAvatarIV = (SelectableRoundedImageView) Utils.findRequiredViewAsType(r5, 2131386551, "field 'mSingleAvatarIV'", SelectableRoundedImageView.class);
        r4.mNameTV = (TextView) Utils.findRequiredViewAsType(r5, 2131380593, "field 'mNameTV'", TextView.class);
        r4.mOwnerTV = (TextView) Utils.findRequiredViewAsType(r5, 2131388478, "field 'mOwnerTV'", TextView.class);
        r4.mDividerView = Utils.findRequiredView(r5, 2131369197, "field 'mDividerView'");
        r4.mCustomStatus = (ImageView) Utils.findRequiredViewAsType(r5, 2131368464, "field 'mCustomStatus'", ImageView.class);
        r4.mTagWrapper = (TextView) Utils.findRequiredViewAsType(r5, 2131388157, "field 'mTagWrapper'", TextView.class);
        r4.mUserStatus = (UserStatusLinearLayout) Utils.findRequiredViewAsType(r5, 2131392066, "field 'mUserStatus'", UserStatusLinearLayout.class);
        r4.mWorkStatus = (TextView) Utils.findRequiredViewAsType(r5, 2131393343, "field 'mWorkStatus'", TextView.class);
        r4.mShadow = Utils.findRequiredView(r5, 2131386031, "field 'mShadow'");
        r4.profileInfoCard = (ImageView) Utils.findRequiredViewAsType(r5, 2131383230, "field 'profileInfoCard'", ImageView.class);
        r4.departmentInfo = (TextView) Utils.findRequiredViewAsType(r5, 2131368812, "field 'departmentInfo'", TextView.class);
    }
}
