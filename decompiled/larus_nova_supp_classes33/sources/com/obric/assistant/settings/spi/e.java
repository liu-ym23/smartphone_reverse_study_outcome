package com.obric.assistant.settings.spi;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class e {
    public final String a;
    public final String b;
    public final CharSequence c;
    public final int d;

    public Object a(Continuation<? super Boolean> r1) {
        return Boxing.boxBoolean(true);
    }

    public e(String r2, String r3, CharSequence r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "groupId");
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
