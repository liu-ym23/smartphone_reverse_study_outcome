package wyb;

import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.mfa.g;
import com.ss.android.lark.passport.flow.mfa.m;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements syb.a<m> {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // syb.a
    public final String getName() {
        return "GetAuthUrlAction";
    }

    @Override // syb.a
    public final void a(String r4, m r5) {
        Intrinsics.checkNotNullParameter(r4, "nextStep");
        Intrinsics.checkNotNullParameter(r5, "context");
        PassportLog.d("GetAuthUrlAction", "enter get auth url action");
        Set<String> r6 = a.b;
        a r7 = a.C0203a.a(r5.c.getStepInfo());
        if (r7.a() == true) goto L5;
        PassportLog.b("GetAuthUrlAction", "unsupported idp channel: " + r7.a);
        r5.b.i(g.d());
        return;
    L5:
        r5.b.z(r5.c, r5.getActivity());
    }

    @Override // syb.a
    public final boolean b(String r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "nextStep");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (Intrinsics.areEqual(r2, "get_auth_url") == false) goto L7;
        Set<String> r4 = a.b;
        if (a.C0203a.a(r3.c.getStepInfo()).a() == false) goto L7;
        return true;
    L7:
        return false;
    }
}
