package ix8;

import com.larus.camera.api.vlm.VLMIntent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class d {
    public final VLMIntent a;
    public final e b;
    public final g c;

    public static final class a extends d {
        public final e d;
        public final g e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.d.hashCode() * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "Common(status=" + this.d + ", preProcessInfo=" + this.e + ')';
        }

        @Override // ix8.d
        public final g a() {
            return this.e;
        }

        @Override // ix8.d
        public final e b() {
            return this.d;
        }

        public /* synthetic */ a(e r3) {
            this(r3, new g(0));
        }

        public a(e r2, g r3) {
            Intrinsics.checkNotNullParameter(r2, "status");
            Intrinsics.checkNotNullParameter(r3, "preProcessInfo");
            super(VLMIntent.COMMON, r2, r3);
            this.d = r2;
            this.e = r3;
        }
    }

    public static final class b extends d {
        public final e d;
        public final int e;
        public final int f;
        public final String g;
        public final f h;
        public final String i;
        public final String j;
        public final g k;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (this.e == r6.e) goto L15;
            return false;
        L15:
            if (this.f == r6.f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.d.hashCode() * 31) + this.e) * 31) + this.f) * 31;
            String r1 = this.g;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            f r5 = this.h;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.i;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.j;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return ((r10 + r2) * 31) + this.k.hashCode();
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Edu(status=" + this.d + ", requestImageWidth=" + this.e + ", requestImageHeight=" + this.f + ", data=" + this.g + ", enableChoice=" + this.h + ", requestId=" + this.i + ", eduExtraParam=" + this.j + ", preProcessInfo=" + this.k + ')';
        }

        @Override // ix8.d
        public final g a() {
            return this.k;
        }

        @Override // ix8.d
        public final e b() {
            return this.d;
        }

        public b(e.d r2, int r3, int r4, String r5, f r6, String r7, String r8, g r9) {
            Intrinsics.checkNotNullParameter(r2, "status");
            Intrinsics.checkNotNullParameter(r9, "preProcessInfo");
            super(VLMIntent.EDU, r2, r9);
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r6;
            this.i = r7;
            this.j = r8;
            this.k = r9;
        }
    }

    public g a() {
        return this.c;
    }

    public e b() {
        return this.b;
    }

    public d(VLMIntent r1, e r2, g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
