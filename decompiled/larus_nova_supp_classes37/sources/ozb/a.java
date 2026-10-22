package ozb;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutReason;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final LogoutReason a;
    public final List<? extends User> b;
    public final List<? extends User> c;

    public final String toString() {
        return "LogoutEndContext{isSuccess=trueisLogoutAll=false, reason=" + this.a + ", logoutUserList=" + this.b + ", allUserList=" + this.c + '}';
    }

    public a(LogoutReason r1, List r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
