package w4b;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class a0 implements c.o {
    public final com.ss.android.lark.passportc.api.m a;

    @Override // w4b.c.o
    public final String Fc() {
        return this.a.getUser().getSession();
    }

    @Override // w4b.c.o
    public final String fe() {
        return this.a.getUser().getTenantId();
    }

    @Override // w4b.c.o
    public final String userId() {
        return this.a.getUser().userId;
    }

    @Inject
    public a0(com.ss.android.lark.passportc.api.m r2) {
        Intrinsics.checkNotNullParameter(r2, "userService");
        this.a = r2;
    }
}
