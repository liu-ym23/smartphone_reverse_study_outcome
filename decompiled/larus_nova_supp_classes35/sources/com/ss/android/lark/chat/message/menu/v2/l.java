package com.ss.android.lark.chat.message.menu.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements o0 {
    public final /* synthetic */ MessageActionPanel a;

    public l(MessageActionPanel r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.o0
    public final void a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "reactionKey");
        o0 r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
