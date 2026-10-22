package com.larksuite.framework.http.v2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class d {

    public static final class a extends d {
        public final String a;

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
        }
    }

    public static final class b extends d {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends d {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public d() {
    }
}
