package com.bytedance.android.live.revenuelink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class h {
    public final String a;

    public static final class a extends h {
        public final String b;

        @Override // com.bytedance.android.live.revenuelink.h
        public final String toString() {
            return this.a + '_' + this.b;
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super("Close");
            this.b = r2;
        }
    }

    public static final class b extends h {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("Leave");
        }
    }

    public static final class c extends h {
        public static final c b = null;

        static {
            b = new c();
        }

        public c() {
            super("SeiUnload");
        }
    }

    public String toString() {
        return this.a;
    }

    public h(String r1) {
        this.a = r1;
    }
}
