package com.larus.browsertakeover.entry;

import com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor;
import hv8.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static String a;
    public static C0068a b;

    /* JADX INFO: renamed from: com.larus.browsertakeover.entry.a$a, reason: collision with other inner class name */
    public static final class C0068a {
        public final hv8.a a;
        public final d b;

        public C0068a(hv8.a r2, RequestActionBrowserOperationInterceptor.CompletionDelegate r3) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "delegate");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }
}
