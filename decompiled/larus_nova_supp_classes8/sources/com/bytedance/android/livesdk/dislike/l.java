package com.bytedance.android.livesdk.dislike;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l extends n {
    public final com.bytedance.android.live.base.model.user.f c;
    public final com.bytedance.android.livesdk.dislike.action.l d;

    @Override // com.bytedance.android.livesdk.dislike.n
    public final boolean a(n r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        if ((r5 instanceof l) == true) goto L5;
        return false;
    L5:
        com.bytedance.android.live.base.model.user.f r0 = ((l) r5).c;
        if (r0 == null) goto L14;
        this.c.getClass();
        if ((!Intrinsics.areEqual(null, null)) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        return false;
    L14:
        return super.a(r5);
    }

    public l(com.bytedance.android.live.base.model.user.f r2, com.bytedance.android.livesdk.dislike.action.l r3, ItemType r4) {
        Intrinsics.checkNotNullParameter(r2, "contact");
        Intrinsics.checkNotNullParameter(r3, "imShareAction");
        Intrinsics.checkNotNullParameter(r4, "identity");
        super(r4, r3);
        this.c = r2;
        this.d = r3;
    }
}
