package jd2;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public final int a;
    public final long b;
    public final String c;
    public final b d;
    public final String e;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final int b;
        public final String c;
        public final String d;
        public final int e;

        public b() {
            this(0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L16;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = ((r1 * 31) + this.b) * 31;
            String r3 = this.c;
            int r4 = 0;
            if (r3 == null) goto L8;
            int r5 = r3.hashCode();
        L9:
            int r6 = (r2 + r5) * 31;
            String r7 = this.d;
            if (r7 == null) goto L13;
            r4 = r7.hashCode();
        L13:
            return ((r6 + r4) * 31) + this.e;
        L8:
            r5 = 0;
            goto L9
        }

        public final String toString() {
            return "ExtraData(isSinger=" + this.a + ", uiLayout=" + this.b + ", idStr='" + this.c + "', lyricUrl='" + this.d + "', lyricType=" + this.e + ')';
        }

        public /* synthetic */ b(int r7) {
            this(false, 0, BuildConfig.FLAVOR, BuildConfig.FLAVOR, 3);
        }

        public b(boolean r2, int r3, String r4, String r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "idStr");
            Intrinsics.checkNotNullParameter(r5, "lyricUrl");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
    }

    public c() {
        this(0, 0, BuildConfig.FLAVOR, new b(0), BuildConfig.FLAVOR);
    }

    public static c a(int r8, long r9, String r11, b r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "musicId");
        Intrinsics.checkNotNullParameter(r13, "extraData");
        Intrinsics.checkNotNullParameter(r14, "roomId");
        return new c(r8, r9, r11, r13, r14);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L16;
        c r7 = (c) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L5;
        int r5 = r3.hashCode();
    L6:
        int r6 = (r2 + r5) * 31;
        b r7 = this.d;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.e;
        if (r10 == null) goto L14;
        r4 = r10.hashCode();
    L14:
        return r9 + r4;
    L9:
        r8 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvSingStateData(singState=" + this.a + ", singPlayProgress=" + this.b + ", musicId='" + this.c + "', extraData=" + this.d + ", roomId='" + this.e + "')";
    }

    public c(int r2, long r3, String r5, b r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "musicId");
        Intrinsics.checkNotNullParameter(r6, "extraData");
        Intrinsics.checkNotNullParameter(r7, "roomId");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
