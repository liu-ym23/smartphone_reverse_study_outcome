package nzb;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final boolean a;
    public final boolean b;
    public final List<? extends User> c;
    public final List<? extends User> d;
    public final User e;

    public final String toString() {
        return "LoginEndContext{isSuccess=" + this.a + ", isFastLogin=" + this.b + ", loginUserList=" + this.c + ", allUserList=" + this.d + ", activeUser=" + this.e + '}';
    }

    public a(boolean r1, boolean r2, List r3, List r4, User r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
