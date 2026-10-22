package com.bytedance.ai.applet.login;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class h {

    public static final class a extends h {
        public final LocalFinishReason a;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r10).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Finished(reason=" + this.a + ')';
        }

        public a(LocalFinishReason r10) {
            Intrinsics.checkNotNullParameter(r10, "reason");
            this.a = r10;
        }
    }

    public static final class b extends h {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends h {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends h {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e extends h {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public h() {
    }
}
