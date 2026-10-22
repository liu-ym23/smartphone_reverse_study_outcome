package com.ss.android.lark.passport.dpop;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.passport.dpop.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0083a extends b {
        public AbstractC0083a(int r1) {
        }
    }

    public static abstract class b {
        public b() {
        }
    }

    public static final class c extends b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends AbstractC0083a {
        public d() {
            super(0);
        }
    }

    public static final class e extends AbstractC0083a {
        public e() {
            super(0);
        }
    }

    public static final class f extends b {
        public final String a;

        public f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "dpopToken");
            this.a = r2;
        }
    }

    b a();
}
