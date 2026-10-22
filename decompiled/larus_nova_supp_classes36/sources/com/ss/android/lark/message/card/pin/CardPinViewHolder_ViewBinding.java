package com.ss.android.lark.message.card.pin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class CardPinViewHolder_ViewBinding implements Unbinder {
    public CardPinViewHolder a;

    public final void unbind() {
        CardPinViewHolder r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mNameTV = null;
        r0.mTimeTV = null;
        r0.mAvatarIV = null;
        r0.mNameAndTimeTV = null;
        r0.mRootView = null;
        r0.mNormalSenderLayout = null;
        r0.mItemMenuBtn = null;
        r0.mUnPinIV = null;
        r0.mJumpChatIV = null;
        r0.mForwardIV = null;
        r0.mFooterTV = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public CardPinViewHolder_ViewBinding(CardPinViewHolder r4, View r5) {
        this.a = r4;
        r4.mNameTV = (TextView) Utils.findRequiredViewAsType(r5, 2131390975, "field 'mNameTV'", TextView.class);
        r4.mTimeTV = (TextView) Utils.findRequiredViewAsType(r5, 2131391589, "field 'mTimeTV'", TextView.class);
        r4.mAvatarIV = (LKUIRoundedImageView) Utils.findRequiredViewAsType(r5, 2131363623, "field 'mAvatarIV'", LKUIRoundedImageView.class);
        r4.mNameAndTimeTV = (TextView) Utils.findRequiredViewAsType(r5, 2131390977, "field 'mNameAndTimeTV'", TextView.class);
        r4.mRootView = (ViewGroup) Utils.findRequiredViewAsType(r5, 2131375836, "field 'mRootView'", ViewGroup.class);
        r4.mNormalSenderLayout = (ViewGroup) Utils.findRequiredViewAsType(r5, 2131385933, "field 'mNormalSenderLayout'", ViewGroup.class);
        r4.mItemMenuBtn = (ImageView) Utils.findRequiredViewAsType(r5, 2131375805, "field 'mItemMenuBtn'", ImageView.class);
        r4.mUnPinIV = (ImageView) Utils.findRequiredViewAsType(r5, 2131375878, "field 'mUnPinIV'", ImageView.class);
        r4.mJumpChatIV = (ImageView) Utils.findRequiredViewAsType(r5, 2131375889, "field 'mJumpChatIV'", ImageView.class);
        r4.mForwardIV = (ImageView) Utils.findRequiredViewAsType(r5, 2131375767, "field 'mForwardIV'", ImageView.class);
        r4.mFooterTV = (TextView) Utils.findRequiredViewAsType(r5, 2131390660, "field 'mFooterTV'", TextView.class);
    }
}
