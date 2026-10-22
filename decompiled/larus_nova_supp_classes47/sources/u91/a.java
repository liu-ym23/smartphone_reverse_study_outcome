package u91;

import com.bytedance.android.livesdk.message.model.t;
import com.bytedance.android.livesdk.model.b1;
import kotlin.jvm.internal.Intrinsics;
import o91.b;
import tlc.d;
import w91.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements e {
    public int a;
    public boolean b;
    public int c;
    public b1 d;
    public d e;
    public final b f;

    /* JADX INFO: renamed from: u91.a$a, reason: collision with other inner class name */
    public static final class C0329a {
    }

    static {
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final String toString() {
        return "UserInfoTabModel(tabType=" + this.f + ", renderType=" + this.a + ", isAnchor=" + this.b + ", tabLine=" + this.c + ')';
    }

    @Override // w91.e
    public final b getTabType() {
        return this.f;
    }

    public a(b.n r2) {
        Intrinsics.checkNotNullParameter(r2, "tabType");
        this.f = r2;
        this.c = 1;
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Long r2 = null;
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r3)) == false) goto L12;
        return false;
    L12:
        if (r7 == null) goto L34;
        a r8 = (a) r7;
        if ((!Intrinsics.areEqual(this.f, r8.f)) == false) goto L16;
        return false;
    L16:
        d r1 = this.e;
        if ((r1 instanceof t) == true) goto L19;
        r1 = null;
    L19:
        t r4 = (t) r1;
        if (r4 == null) goto L22;
        Long r5 = Long.valueOf(r4.bizType);
    L23:
        d r9 = r8.e;
        if ((r9 instanceof t) == true) goto L26;
        r9 = null;
    L26:
        t r10 = (t) r9;
        if (r10 == null) goto L30;
        r2 = Long.valueOf(r10.bizType);
    L30:
        if ((!Intrinsics.areEqual(r5, r2)) == false) goto L32;
        return false;
    L32:
        return true;
    L22:
        r5 = null;
        goto L23
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.navi.userinfo_p.flipper.business.model.UserInfoTabModel");
    L8:
        r3 = null;
        goto L10
    }
}
