package c0c;

import com.ss.android.lark.passportc.api.g;
import com.ss.android.lark.passportc.api.j;
import f0c.e;
import f0c.f;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b implements g {
    public final j a;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r1, f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
    }

    public void lf(f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toState");
    }

    @Deprecated(message = "UserPayload doesn't provide enough information. Use GlobalState instead.", replaceWith = @ReplaceWith(expression = "Use GlobalScopeRepository.destroy(GlobalState)", imports = {}))
    public void mf(f0c.g r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    public void nf(f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toState");
    }

    @Deprecated(message = "UserPayload doesn't provide enough information. Use GlobalState instead.", replaceWith = @ReplaceWith(expression = "Use GlobalScopeRepository.onPrepared(GlobalState)", imports = {}))
    public void of(f0c.g r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(e r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public void pf(f0c.g r1, f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toState");
    }

    @Deprecated(message = "UserPayload doesn't provide enough information. Use GlobalState instead.", replaceWith = @ReplaceWith(expression = "Use GlobalScopeRepository.preparing(UserPayload?, GlobalState)", imports = {}))
    public void qf(f0c.g r1, f0c.g r2) {
    }

    @Override // com.ss.android.lark.passportc.api.g
    public final j getPassport() {
        return this.a;
    }

    public b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        this.a = r2;
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(e r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        lf(r2);
        mf(r2.c);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        nf(r2);
        of(r2.c);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r2, f0c.b r3) {
        Intrinsics.checkNotNullParameter(r3, "currentState");
        pf(r2, r3);
        qf(r2, r3.a());
    }
}
