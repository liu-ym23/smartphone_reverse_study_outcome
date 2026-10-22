package com.larus.bmhome.bot.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements c {
    public static final b a = null;
    public static String b;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.larus.bmhome.bot.utils.c
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "newGlobalNickName");
        b = r2;
    }
}
