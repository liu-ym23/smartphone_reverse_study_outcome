package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class m1 {

    public static final class a {
    }

    public static final class b extends m1 {
        public final long a;
        public final long b;

        public final Long a() {
            return Long.valueOf(Long.valueOf(this.b).longValue() - Long.valueOf(this.a).longValue());
        }

        public b(e r5) {
            Intrinsics.checkNotNullParameter(r5, "prevState");
            long r0 = Long.valueOf(r5.a).longValue();
            long r2 = System.currentTimeMillis();
            this.a = r0;
            this.b = r2;
        }
    }

    public static final class c extends m1 {
        public final long a;
        public final long b;
        public final Throwable c;

        public c(e r5, Throwable r6) {
            Intrinsics.checkNotNullParameter(r5, "prevState");
            Intrinsics.checkNotNullParameter(r6, "throwable");
            long r0 = Long.valueOf(r5.a).longValue();
            long r2 = System.currentTimeMillis();
            this.a = r0;
            this.b = r2;
            this.c = r6;
        }
    }

    public static final class d extends m1 {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e extends m1 {
        public final long a;

        public e() {
            this.a = System.currentTimeMillis();
        }
    }

    public static final class f extends m1 {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }
    }

    static {
    }

    public m1() {
    }
}
