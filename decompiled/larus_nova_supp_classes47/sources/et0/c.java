package et0;

import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final a g = null;
    public final int a;
    public final boolean b;
    public final ProfileFansClub c;
    public final String d;
    public final k e;
    public final boolean f;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L18;
        c r4 = (c) r3;
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
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = this.a * 31;
        boolean r1 = this.b;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        ProfileFansClub r5 = this.c;
        int r6 = 0;
        if (r5 == null) goto L8;
        int r7 = r5.hashCode();
    L9:
        int r8 = (r4 + r7) * 31;
        String r9 = this.d;
        if (r9 == null) goto L12;
        int r10 = r9.hashCode();
    L13:
        int r12 = (r8 + r10) * 31;
        k r13 = this.e;
        if (r13 == null) goto L16;
        r6 = r13.hashCode();
    L16:
        int r14 = (r12 + r6) * 31;
        boolean r15 = this.f;
        if (r15 == true) goto L21;
        r2 = r15;
    L21:
        return r14 + r2;
    L12:
        r10 = 0;
        goto L13
    L8:
        r7 = 0;
        goto L9
    }

    public final String toString() {
        return "FansClubData(type=" + this.a + ", showFansCount=" + this.b + ", fansClubInfo=" + this.c + ", clubName=" + this.d + ", fansClubIcon=" + this.e + ", isSubscriber=" + this.f + ")";
    }

    static {
        g = new a();
    }

    public c() {
        this(HonorWallElement.TYPE_UNKNOWN, false, null, null, null, false);
    }

    public final int getType() {
        return this.a;
    }

    public c(int r1, boolean r2, ProfileFansClub r3, String r4, k r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
