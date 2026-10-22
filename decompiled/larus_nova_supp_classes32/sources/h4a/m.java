package h4a;

import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m implements hx7.h {
    public m() {
    }

    public final void getBoundPhone() {
    }

    public final String getAvatarURL() {
        return AccountService.a.s();
    }

    public final String getNickname() {
        return AccountService.a.getNickname();
    }

    public final String getSecUid() {
        return AccountService.a.getSecUserId();
    }

    public final String getUniqueID() {
        return o.a.getUserUniqueID();
    }

    public final String getUserId() {
        return o.a.getUserID();
    }

    public final boolean hasLogin() {
        return AccountService.a.isLogin().booleanValue();
    }

    public final void a(tx7.i.a r3) {
        Intrinsics.checkNotNullParameter(r3, "logoutStatusCallback");
        AccountService.a.z("logout_by_jsb_x_logout_method", new l(r3));
    }
}
