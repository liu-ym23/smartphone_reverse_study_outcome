package com.ss.android.lark.message.card.view;

import android.view.View;
import android.view.ViewStub;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class CardViewHolder_ViewBinding implements Unbinder {
    public CardViewHolder a;

    public final void unbind() {
        CardViewHolder r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mRootLayout = null;
        r0.mHeaderContainer = null;
        r0.mCardContentLayout = null;
        r0.mTranslateStub = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public CardViewHolder_ViewBinding(CardViewHolder r4, View r5) {
        this.a = r4;
        r4.mRootLayout = (LKUIRoundLinearLayout) Utils.findRequiredViewAsType(r5, 2131384813, "field 'mRootLayout'", LKUIRoundLinearLayout.class);
        r4.mHeaderContainer = (LKUIRoundableLayout) Utils.findRequiredViewAsType(r5, 2131374285, "field 'mHeaderContainer'", LKUIRoundableLayout.class);
        r4.mCardContentLayout = (LKUIRoundableLayout) Utils.findRequiredViewAsType(r5, 2131365167, "field 'mCardContentLayout'", LKUIRoundableLayout.class);
        r4.mTranslateStub = (ViewStub) Utils.findRequiredViewAsType(r5, 2131392978, "field 'mTranslateStub'", ViewStub.class);
    }
}
