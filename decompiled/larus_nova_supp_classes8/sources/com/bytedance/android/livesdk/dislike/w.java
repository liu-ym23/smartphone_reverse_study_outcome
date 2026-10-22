package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.livesdk.dislike.action.OptionAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w extends n {
    public final nt1.b c;

    @Override // com.bytedance.android.livesdk.dislike.n
    public final boolean a(n r7) {
        Intrinsics.checkNotNullParameter(r7, "item");
        if ((r7 instanceof w) == true) goto L5;
        return false;
    L5:
        nt1.b r0 = ((w) r7).c;
        nt1.b r2 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "setting");
        boolean r5 = true;
        if (r2.c == r0.c) goto L8;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L17;
        r2 = null;
    L17:
        if (r2 == null) goto L19;
        r5 = false;
    L19:
        if (r5 == true) goto L22;
        return false;
    L22:
        return super.a(r7);
    L8:
        if (r2.b != r0.b) goto L13;
        if (r2.a != r0.a) goto L13;
        r1 = false;
        goto L14
    }

    public w(nt1.b r2, OptionAction r3, ItemType r4) {
        Intrinsics.checkNotNullParameter(r2, "notificationSettingVO");
        Intrinsics.checkNotNullParameter(r3, "optionAction");
        Intrinsics.checkNotNullParameter(r4, "identity");
        super(r4, r3);
        this.c = r2;
    }
}
