package com.bytedance.android.live.revenuelink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class i {
    public final String a;

    public static final class a extends i {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("JoinFailed");
        }
    }

    public static final class b extends i {
        public final String b;

        @Override // com.bytedance.android.live.revenuelink.i
        public final String toString() {
            return this.a + '_' + this.b;
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reqSrc");
            super("RTCEndSuccess");
            this.b = r2;
        }
    }

    public static final class c extends i {
        public final String b;

        @Override // com.bytedance.android.live.revenuelink.i
        public final String toString() {
            return this.a + '_' + this.b;
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "endReason");
            super("StopLiveBroadcast");
            this.b = r2;
        }
    }

    public static final class d extends i {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super("SwitchPk");
        }
    }

    public static final class e extends i {
        public final String b;

        @Override // com.bytedance.android.live.revenuelink.i
        public final String toString() {
            return this.a + '_' + this.b;
        }

        public e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reqSrc");
            super("UnExceptUnload");
            this.b = r2;
        }
    }

    public static final class f extends i {
        public static final f b = null;

        static {
            b = new f();
        }

        public f() {
            super("Unknown");
        }
    }

    public String toString() {
        return this.a;
    }

    public i(String r1) {
        this.a = r1;
    }
}
