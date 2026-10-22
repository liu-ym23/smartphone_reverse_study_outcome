package com.ss.android.lark.coremd.base.parse;

import com.ss.android.lark.coremd.impl.parse.MarkdownThemeImpl;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l {
    public static j b() {
        MarkdownThemeKt$markdownTheme$1 r0 = MarkdownThemeKt$markdownTheme$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, Keys.API_PARAM_KEY_ACTION);
        return a(k.b, r0);
    }

    public static final <T extends com.ss.android.lark.coremd.ext.f> j a(com.ss.android.lark.coremd.ext.h<T> r1, Function2<? super T, ? super j, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "themeProvider");
        Intrinsics.checkNotNullParameter(r2, Keys.API_PARAM_KEY_ACTION);
        MarkdownThemeImpl r0 = new MarkdownThemeImpl();
        com.ss.android.lark.coremd.ext.g.a(r0, r1, r2);
        return r0;
    }
}
