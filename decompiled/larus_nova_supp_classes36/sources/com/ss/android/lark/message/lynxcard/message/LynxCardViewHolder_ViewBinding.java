package com.ss.android.lark.message.lynxcard.message;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ss.android.lark.widget.EllipsizeFrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LynxCardViewHolder_ViewBinding implements Unbinder {
    public LynxCardViewHolder a;

    public final void unbind() {
        LynxCardViewHolder r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mRootLayout = null;
        r0.contentLayout = null;
        r0.mFoldContainer = null;
        r0.mEllipsizeLayout = null;
        r0.mShowMoreView = null;
        r0.mShowMoreText = null;
        r0.mTranslateStub = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public LynxCardViewHolder_ViewBinding(LynxCardViewHolder r4, View r5) {
        this.a = r4;
        r4.mRootLayout = (LynxCardRoundLinearLayout) Utils.findRequiredViewAsType(r5, 2131384813, "field 'mRootLayout'", LynxCardRoundLinearLayout.class);
        r4.contentLayout = (LynxCardMessageContentLayout) Utils.findRequiredViewAsType(r5, 2131379272, "field 'contentLayout'", LynxCardMessageContentLayout.class);
        r4.mFoldContainer = (FrameLayout) Utils.findRequiredViewAsType(r5, 2131379274, "field 'mFoldContainer'", FrameLayout.class);
        r4.mEllipsizeLayout = (EllipsizeFrameLayout) Utils.findRequiredViewAsType(r5, 2131379273, "field 'mEllipsizeLayout'", EllipsizeFrameLayout.class);
        r4.mShowMoreView = Utils.findRequiredView(r5, 2131379276, "field 'mShowMoreView'");
        r4.mShowMoreText = (TextView) Utils.findRequiredViewAsType(r5, 2131379277, "field 'mShowMoreText'", TextView.class);
        r4.mTranslateStub = (ViewStub) Utils.findRequiredViewAsType(r5, 2131379315, "field 'mTranslateStub'", ViewStub.class);
    }
}
