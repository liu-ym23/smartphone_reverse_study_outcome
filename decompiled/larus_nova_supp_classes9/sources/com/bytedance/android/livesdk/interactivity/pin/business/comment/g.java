package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.IPSHighlightCompLifecycle$State;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ PinCommentPSHighlightView a;

    public g(PinCommentPSHighlightView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        p42.a r3 = (p42.a) r2;
        if ((r3.a.getType() instanceof PSHighlightType.CommonHighlightComp) == false) goto L11;
        IPSHighlightCompLifecycle$State r4 = r3.b;
        if (r4 != IPSHighlightCompLifecycle$State.Showed) goto L8;
        PinCommentPSHighlightView r5 = this.a;
        int r0 = PinCommentPSHighlightView.j;
        r5.d(2);
        return;
    L8:
        if (r4 != IPSHighlightCompLifecycle$State.Hidden) goto L13;
        PinCommentPSHighlightView r6 = this.a;
        int r1 = PinCommentPSHighlightView.j;
        r6.d(3);
        return;
    L13:
        return;
    }
}
