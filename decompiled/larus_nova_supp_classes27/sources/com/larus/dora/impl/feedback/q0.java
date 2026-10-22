package com.larus.dora.impl.feedback;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class q0 {

    public static final class a extends q0 {
        public final String a;

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "failMsg");
            this.a = r2;
        }
    }

    public static final class b extends q0 {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends q0 {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends q0 {
        public final String a;

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "successMsg");
            this.a = r2;
        }
    }

    public q0() {
    }
}
