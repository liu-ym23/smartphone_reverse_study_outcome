package c19;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class d {

    public static final class a extends d {
        public final float a;
        public final float b;
        public final float c;
        public final float d;
        public final float[] e;
        public final List<j> f;
        public final float g;

        public a(float r2, float r3, float r4, float r5, float[] r6, List r7) {
            Intrinsics.checkNotNullParameter(r6, "transform");
            Intrinsics.checkNotNullParameter(r7, "stops");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = 1.0f;
        }
    }

    public static final class b extends d {
    }

    public static final class c extends d {
        public final String a;
        public final float b;

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
            if (Float.compare(this.b, r6.b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + Float.floatToIntBits(this.b);
        }

        public final String toString() {
            return "Solid(hex=" + this.a + ", alpha=" + this.b + ')';
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "hex");
            this.a = r2;
            this.b = 1.0f;
        }
    }

    /* JADX INFO: renamed from: c19.d$d, reason: collision with other inner class name */
    public static final class C0004d extends d {
        public final float a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0004d) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.a, ((C0004d) r4).a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.a);
        }

        public final String toString() {
            return "Tint(alpha=" + this.a + ')';
        }

        public C0004d() {
            this.a = 1.0f;
        }
    }

    public d() {
    }
}
