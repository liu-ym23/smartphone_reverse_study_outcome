package com.larus.common.account.platform.larklogin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class LarkOAuthSessionCoordinator$f {

    public static final class a extends LarkOAuthSessionCoordinator$f {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends LarkOAuthSessionCoordinator$f {
        public final LarkOAuthSessionCoordinator$e a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Started(session=" + this.a + ')';
        }

        public b(LarkOAuthSessionCoordinator$e r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
            this.a = r2;
        }
    }

    public LarkOAuthSessionCoordinator$f() {
    }
}
