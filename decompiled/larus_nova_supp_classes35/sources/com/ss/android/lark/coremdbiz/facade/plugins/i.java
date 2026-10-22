package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkEmojiThemeData;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public i() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        LarkEmojiThemeData r0 = (LarkEmojiThemeData) LarkThemeExtend.m.b(new EmojiPlugin$configureVisitor$1$showEmoji$1(r6));
        boolean r1 = ((Boolean) r0.d.getValue(r0, LarkEmojiThemeData.g[0])).booleanValue();
        int r2 = r6.g.length();
        String r3 = ((eab.c) r6.d).j;
        r6.g.d(r3);
        if (r1 == false) goto L7;
        com.ss.android.lark.coremd.base.parse.s.a.c(r6.g, r2, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.b(r6.g, r2);
        return;
    }
}
