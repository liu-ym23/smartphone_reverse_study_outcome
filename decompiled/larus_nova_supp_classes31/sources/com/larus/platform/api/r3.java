package com.larus.platform.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface r3 {
    public static final a a = null;

    public static final class a implements r3 {
        public static final /* synthetic */ a b = null;
        public static final Lazy<r3> c = null;

        public a() {
        }

        static {
            b = new a();
            c = LazyKt.lazy(new q3());
        }

        @Override // com.larus.platform.api.r3
        public final b a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
            r3 r0 = (r3) c.getValue();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a(r2);
        }
    }

    public interface b {
        void end();

        void start();
    }

    static {
        a = a.b;
    }

    b a(String r1);
}
