package com.larus.dora.impl.core.request.v2;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.core.request.v2.a$a, reason: collision with other inner class name */
    public static final class C0030a implements a {
        public final Throwable a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0030a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0030a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Failed(error=" + this.a + ')';
        }

        public C0030a(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a = r2;
        }
    }

    public static final class b implements a {
        public final byte[] a;

        public final String toString() {
            return "Success(data=" + Arrays.toString(this.a) + ')';
        }

        public final int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public b(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (r3 == null) goto L8;
            Class<?> r1 = r3.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r1) == true) goto L13;
            return false;
        L13:
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.dora.impl.core.request.v2.DoraRemoteResponseV2.Success");
            return Arrays.equals(this.a, ((b) r3).a);
        L8:
            r1 = null;
            goto L10
        }
    }
}
