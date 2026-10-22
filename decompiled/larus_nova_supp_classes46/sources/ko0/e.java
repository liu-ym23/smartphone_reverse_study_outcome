package ko0;

import com.bytedance.android.livesdk.config.o90;
import com.bytedance.android.livesdk.config.yc1;
import com.bytedance.android.livesdk.utils.z0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final a e = null;
    public final int a;
    public final String b;
    public final Function0<Unit> c;
    public final Function0<Unit> d;

    public static final class a {
        public a() {
        }

        public static boolean b() {
            float r1 = z0.b(false);
            if (a() != 0) goto L5;
            return false;
        L5:
            if (r1 <= ((yc1) o90.a.getValue()).d()) goto L9;
            return true;
        L9:
            return false;
        }

        public static int a() {
            return ((yc1) o90.a.getValue()).e();
        }
    }

    public e() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L14;
        e r4 = (e) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Function0<Unit> r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Function0<Unit> r8 = this.d;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppToolbarAnimConfig(animType=" + this.a + ", animUrl=" + this.b + ", onAnimStart=" + this.c + ", onAnimEnd=" + this.d + ")";
    }

    static {
        e = new a();
    }

    public e(int r1, String r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = r3;
    }
}
