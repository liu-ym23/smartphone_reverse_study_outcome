package com.larksuite.arch.jack;

import androidx.arch.core.util.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g {
    public static final a a = null;
    public static Function<? super Runnable, ? extends Runnable> b;

    public static final class a {
        public a() {
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter("ISubscriber", "tag");
            Intrinsics.checkNotNullParameter(r3, "message");
        }
    }

    static {
        a = new a();
    }
}
