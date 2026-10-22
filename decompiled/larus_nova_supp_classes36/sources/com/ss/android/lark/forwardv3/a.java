package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.a$a, reason: collision with other inner class name */
    public static final class C0071a extends a {
        public final String a;
        public final Throwable b;
        public final IExternalForwardExecutor.ExternalForwardFailureReason c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0071a) == true) goto L8;
            return false;
        L8:
            C0071a r6 = (C0071a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Throwable r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.c.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failure(rawErrorMsg=" + this.a + ", throwable=" + this.b + ", reason=" + this.c + ')';
        }

        public C0071a(String r3, Throwable r4, int r5) {
            IExternalForwardExecutor.ExternalForwardFailureReason r1 = null;
            if ((r5 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r1 = IExternalForwardExecutor.ExternalForwardFailureReason.UNKNOWN;
        L8:
            Intrinsics.checkNotNullParameter(r3, "rawErrorMsg");
            Intrinsics.checkNotNullParameter(r1, "reason");
            this.a = r3;
            this.b = r4;
            this.c = r1;
        }
    }

    public static final class b extends a {
        public final Map<String, ForwardTargetBaseInfoNew> a;

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
            return "Success(result=" + this.a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Map<String, ? extends ForwardTargetBaseInfoNew> r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            this.a = r2;
        }
    }

    public static final class c extends a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public a() {
    }
}
