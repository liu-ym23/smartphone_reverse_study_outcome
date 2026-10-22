package com.ss.android.lark.coremdbiz.facade.plugins;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public h() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        LarkThemeExtend.a r0 = LarkThemeExtend.m;
        int r8 = ((Number) r0.b(new EmojiPlugin$configureSpanFactory$1$emojiSize$1(r10))).intValue();
        int r7 = ((Number) r0.b(new EmojiPlugin$configureSpanFactory$1$alignment$1(r10))).intValue();
        Drawable r4 = EmojiHandler.c(((eab.c) r10.d).k, null, null);
        return new com.ss.android.lark.widget.linked_emojicon.base.a(r10.getContext(), r4, ((eab.c) r10.d).k, r8, r7, r8);
    }
}
