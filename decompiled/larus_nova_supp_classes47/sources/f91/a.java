package f91;

import com.bytedance.android.live.room.navi.userinfo_p.presenter.h;
import e91.d;
import e91.f;
import e91.i;
import kotlin.jvm.internal.Intrinsics;
import m91.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {

    /* JADX INFO: renamed from: f91.a$a, reason: collision with other inner class name */
    public static final class C0238a {
    }

    static {
    }

    public a() {
    }

    public final e91.a a(c r2, Object r3, h r4) {
        int r5 = ((Number) r3).intValue();
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L19;
        if (r5 == 3) goto L18;
        if (r5 == 4) goto L17;
        return null;
    L17:
        return new d(r2, r4);
    L18:
        return new f(r4);
    L19:
        return new i(r4);
    L15:
        return new e91.h(r4);
    }
}
