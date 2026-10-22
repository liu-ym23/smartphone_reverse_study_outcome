package f0c;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b {
    public final g a;
    public final h b;

    public static final class a {
        public static b a(g r1, UserState r2, h r3, lzb.a r4) {
            Intrinsics.checkNotNullParameter(r2, "initAbsentState");
            Intrinsics.checkNotNullParameter(r3, "statePayload");
            Intrinsics.checkNotNullParameter(r4, "context");
            if (r3.a != UserState.OFFLINE) goto L6;
            return new e(r1, r3.b, r4);
        L6:
            return new f(r1, r3.b, r4);
        }
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("{state:");
        r0.append(this.b.a);
        r0.append(", userid:");
        g r1 = a();
        String r2 = null;
        if (r1 == null) goto L7;
        User r3 = r1.a;
        if (r3 == null) goto L7;
        String r4 = r3.userId;
    L8:
        r0.append(r4);
        r0.append(", session:");
        g r5 = a();
        if (r5 == null) goto L13;
        UserSession r6 = r5.b;
        if (r6 == null) goto L13;
        r2 = r6.a;
    L13:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L7:
        r4 = null;
        goto L8
    }

    public g a() {
        return this.a;
    }

    public b(g r1, h r2) {
        this.a = r1;
        this.b = r2;
    }
}
