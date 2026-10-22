package com.bytedance.ai.applet.login;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class o {

    public static final class a extends o {
    }

    public static final class b extends o {
        public final FinishReason a;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r10).a) goto L11;
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

        public b(FinishReason r10) {
            Intrinsics.checkNotNullParameter(r10, "reason");
            this.a = r10;
        }
    }

    public static final class c extends o {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends o {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public o() {
    }
}
