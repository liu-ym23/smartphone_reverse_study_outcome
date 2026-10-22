package c0c;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import f0c.h;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class c implements r {
    public final m a;

    @Deprecated(message = "this callback doesn't provide enough information. Passing UserStatePayload instead.", replaceWith = @ReplaceWith(expression = "Use UserScopeRepository.destroy(UserStatePayload)", imports = {}))
    public void c() {
    }

    public void d(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Deprecated(message = "this callback doesn't provide enough information. Passing UserStatePayload instead.", replaceWith = @ReplaceWith(expression = "Use UserScopeRepository.onPrepared(UserStatePayload)", imports = {}))
    public void e() {
    }

    public void i(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Deprecated(message = "this callback doesn't provide enough information. Passing UserStatePayload instead.", replaceWith = @ReplaceWith(expression = "Use UserScopeRepository.preparing(UserStatePayload)", imports = {}))
    public void k() {
    }

    public void l(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.r
    public m getPassport() {
        return this.a;
    }

    public c(m r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        this.a = r2;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        c();
        d(r2);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        e();
        i(r2);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        k();
        l(r2);
    }
}
