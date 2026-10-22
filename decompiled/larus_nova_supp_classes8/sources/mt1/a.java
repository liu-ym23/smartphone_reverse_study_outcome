package mt1;

import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public f a;
    public final int b;
    public final Room c;
    public final String d;
    public final pt1.a e;
    public final boolean f;

    /* JADX INFO: renamed from: mt1.a$a, reason: collision with other inner class name */
    public static final class C0401a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L16;
        a r4 = (a) r3;
        if (this.b == r4.b) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L14;
        return false;
    L14:
        if (this.f == r4.f) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r0 = this.b * 31;
        Room r1 = this.c;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        pt1.a r8 = this.e;
        if (r8 == null) goto L13;
        r2 = r8.hashCode();
    L13:
        int r9 = (r7 + r2) * 31;
        boolean r10 = this.f;
        ?? r11 = r10;
        if (r10 == false) goto L17;
        r11 = 1;
    L17:
        return r9 + r11;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "DislikeMenuEvent(type=" + this.b + ", room=" + this.c + ", enterFrom=" + this.d + ", shareFansHelper=" + this.e + ", fromLongPress=" + this.f + ")";
    }

    public final int getType() {
        return this.b;
    }

    public a(int r2, Room r3, String r4, pt1.a r5, boolean r6, int r7) {
        if ((r7 & 8) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 16) == 0) goto L8;
        r6 = false;
    L8:
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
