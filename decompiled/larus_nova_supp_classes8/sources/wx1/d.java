package wx1;

import androidx.fragment.app.FragmentActivity;
import bw.p;
import com.bytedance.android.gamecp.host_api.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.p0;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.user.l;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements p {
    public g a;

    public d() {
    }

    public final void getUidContactPermissionState() {
    }

    public final void q(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
    }

    public final User b() {
        return a.a(k.n(IUserService.class).user());
    }

    public final String getCurUserId() {
        String r0 = k.n(IUserService.class).user().b().getUserId();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final boolean isLogin() {
        return k.n(IUserService.class).user().isLogin();
    }

    public final hw.b user() {
        if (this.a != null) goto L5;
        this.a = new g(this);
    L5:
        g r0 = this.a;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final boolean userNameIsProtected() {
        kz.a r0 = kz.b.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a() != true) goto L7;
        return true;
    }

    public final String getProtectedName(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "nickName");
        Intrinsics.checkNotNullParameter(r4, "userId");
        com.bytedance.android.live.base.model.user.User r0 = new com.bytedance.android.live.base.model.user.User();
        o0.a.getClass();
        r0.assignUserId(new p0(r4, r4));
        r0.setNickName(r3);
        kz.a r5 = kz.b.a;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.b(r0);
    }

    public final void v1(FragmentActivity r3, hw.a r4, String r5, int r6, String r7) {
        com.bytedance.android.livesdk.user.f r0 = k.n(IUserService.class).user();
        l.a r1 = new l.a();
        r1.a = r5;
        r1.d = r7;
        r1.g = "";
        r1.c = r6;
        r1.e = "";
        r1.b = "";
        r0.login(r3, new l(r1)).subscribe(new b(r4), new c(r4));
    }
}
