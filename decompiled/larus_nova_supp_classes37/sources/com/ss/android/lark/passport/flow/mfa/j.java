package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.passport.flow.core.router.FlowStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class j {

    public static final class a extends j {
        public final com.ss.android.lark.passport.flow.mfa.b a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "CodeApplied(result=" + this.a + ')';
        }

        public a(com.ss.android.lark.passport.flow.mfa.b r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            this.a = r2;
        }
    }

    public static final class b extends j {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends j {
        public final FlowMfaError a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Error(error=" + this.a + ", terminal=" + this.b + ')';
        }

        public c(FlowMfaError r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends j {
        public final FlowStep a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Route(step=" + this.a + ')';
        }

        public d(FlowStep r2) {
            Intrinsics.checkNotNullParameter(r2, "step");
            this.a = r2;
        }
    }

    public j() {
    }
}
