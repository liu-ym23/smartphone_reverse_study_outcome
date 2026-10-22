package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MovableCallbackCacheKeysKt {
    public static final void a(final com.ss.android.lark.coremd.base.parse.b r3, m2b.a r4, String r5, boolean r6, y6b.a<?> r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatContext");
        Intrinsics.checkNotNullParameter(r5, "messageId");
        if (com.ss.android.lark.coremdbiz.facade.p.a() == true) goto L5;
        return;
    L5:
        b r2 = new b(r4);
        b r8 = null;
        final a r1 = new a(r2, r5, r6, null);
        if (r7 == null) goto L8;
        r8 = new b(r7);
    L8:
        b r9 = r1.a;
        String r10 = r1.b;
        boolean r11 = r1.c;
        Intrinsics.checkNotNullParameter(r9, "page");
        Intrinsics.checkNotNullParameter(r10, "messageId");
        final a r0 = new a(r9, r10, r11, r8);
        LarkContextExtend.s.b(new MovableCallbackCacheKeysKt$stabilizeMovableCallbackKeys$1(r3, r1, r0));
    }
}
