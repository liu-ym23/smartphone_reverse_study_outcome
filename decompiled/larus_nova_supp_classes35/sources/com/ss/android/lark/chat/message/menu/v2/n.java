package com.ss.android.lark.chat.message.menu.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements com.ss.android.lark.newemoji.emoji_list.adapter.e {
    public final /* synthetic */ MessageActionPanel a;

    public n(MessageActionPanel r1) {
        this.a = r1;
    }

    public final void a(String r3, s5c.d r4) {
        Intrinsics.checkNotNullParameter(r3, "reactionKey");
        Intrinsics.checkNotNullParameter(r4, "param");
        o0 r5 = this.a.d;
        if (r5 == null) goto L5;
        r5.a(r3, 2);
    L5:
        i0.a(this.a, false, null, 7);
    }

    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "reactionKey");
        Intrinsics.checkNotNullParameter(r3, "skinedKey");
        k2c.a.a().Wc(r2, r3);
    }
}
