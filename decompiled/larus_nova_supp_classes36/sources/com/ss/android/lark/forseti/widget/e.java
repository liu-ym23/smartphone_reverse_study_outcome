package com.ss.android.lark.forseti.widget;

import android.content.Context;
import cib.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final int a;
    public final int b;
    public final int c;

    public static final class a {
    }

    static {
    }

    public e(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = f.a(r3, 60.0f);
        this.a = r0;
        this.b = f.a(r3, 636.0f) - (r0 * 2);
        this.c = f.a(r3, 600.0f);
    }
}
