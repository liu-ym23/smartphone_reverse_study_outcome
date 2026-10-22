package ch0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final /* synthetic */ int e = 0;
    public final IBaseUser a;
    public final int b;
    public final int c;
    public final g d;

    public static final class a {
        public static d a() {
            IBaseUser r0 = jc1.k.n(IMiddlewareUserService.class).user().b().cloneFrom();
            Intrinsics.checkNotNull(r0);
            return new d(r0, 0, 0, new g("", 0, 0, 0, 0));
        }
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L14;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
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
        IBaseUser r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + this.b) * 31) + this.c) * 31;
        g r4 = this.d;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkCurrentUserMergeData(user=" + this.a + ", linkStatus=" + this.b + ", silenceStatus=" + this.c + ", rtcLocalUserInfo=" + this.d + ")";
    }

    public d(IBaseUser r2, int r3, int r4, g r5) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r5, "rtcLocalUserInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public static d a(d r2, int r3, int r4, g r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        IBaseUser r0 = r2.a;
    L7:
        if ((r6 & 2) == 0) goto L10;
        r3 = r2.b;
    L10:
        if ((r6 & 4) == 0) goto L13;
        r4 = r2.c;
    L13:
        if ((r6 & 8) == 0) goto L15;
        r5 = r2.d;
    L15:
        Intrinsics.checkNotNullParameter(r0, "user");
        Intrinsics.checkNotNullParameter(r5, "rtcLocalUserInfo");
        return new d(r0, r3, r4, r5);
    L5:
        r0 = null;
        goto L7
    }
}
