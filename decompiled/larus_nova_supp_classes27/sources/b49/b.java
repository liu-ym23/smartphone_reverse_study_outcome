package b49;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class b {

    public static final class a extends b {
        public final int a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Failure(code=" + this.a + ", message=" + this.b + ')';
        }

        public a(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "message");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: b49.b$b, reason: collision with other inner class name */
    public static final class C0001b extends b {
        public final byte[] a;
        public final int b;

        public final String toString() {
            return "Success(data=" + Arrays.toString(this.a) + ", retryCount=" + this.b + ')';
        }

        public final int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (r3 == null) goto L8;
            Class<?> r1 = r3.getClass();
        L10:
            if (Intrinsics.areEqual(C0001b.class, r1) == true) goto L13;
            return false;
        L13:
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.dora.api.model.AlbumResult.Success");
            return Arrays.equals(this.a, ((C0001b) r3).a);
        L8:
            r1 = null;
            goto L10
        }

        public C0001b(byte[] r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
            this.b = r3;
        }
    }

    public b() {
    }
}
