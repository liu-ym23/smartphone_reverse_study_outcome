package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class x {
    public n a;

    public x() {
    }

    public abstract void p(l r1);

    public abstract void q();

    public final l o() {
        n r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPublicScreenContext();
    }

    public final void n(PublicScreenConfig$ViewBinderType r2, j<? extends i, ? extends PSMessageViewHolder> r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "viewBinder");
        n r0 = this.a;
        if (r0 == null) goto L6;
        r0.addMessageViewBinder(r2, r3);
        return;
    }
}
