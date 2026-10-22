package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.livesdk.dislike.action.OptionAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends n {
    public final nt1.c c;

    @Override // com.bytedance.android.livesdk.dislike.n
    public final boolean a(n r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        if ((r4 instanceof j) == true) goto L6;
        return false;
    L6:
        if (((j) r4).c.a(this.c) == true) goto L9;
        return false;
    L9:
        return super.a(r4);
    }

    public j(nt1.c r2, OptionAction r3, ItemType r4) {
        Intrinsics.checkNotNullParameter(r2, "vo");
        Intrinsics.checkNotNullParameter(r3, "optionAction");
        Intrinsics.checkNotNullParameter(r4, "identity");
        super(r4, r3);
        this.c = r2;
    }
}
