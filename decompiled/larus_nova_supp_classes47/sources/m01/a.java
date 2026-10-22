package m01;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.scope.o;
import ds2.e;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l01.b;
import l01.c;
import l01.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o, d, c {
    public final com.bytedance.android.livesdk.revenue.service.user.a a;

    /* JADX INFO: renamed from: m01.a$a, reason: collision with other inner class name */
    public static final class C0271a<T, R> implements Function {
        public final /* synthetic */ a a;

        public C0271a(a r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((IBaseUser) r2, "it");
            l01.a r3 = new l01.a();
            r3.b(this.a.getCurrentUserId());
            String r0 = com.bytedance.android.live.base.model.user.o.a(this.a.b());
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r3.a(r0);
            return r3;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // l01.d
    public final IBaseUser b() {
        IBaseUser r0 = this.a.b();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // l01.d
    public final String getCurrentUserId() {
        return this.a.getCurrentUserId();
    }

    @Override // l01.c
    public final Single<b> getCurrentUserSingle() {
        b r0 = new b();
        r0.a(b());
        return Single.just(r0);
    }

    @Override // l01.d
    public final boolean isLogin() {
        return this.a.isLogin();
    }

    @Override // l01.c
    public final Observable<l01.a> observeCurrentUserInfo() {
        l01.a r0 = new l01.a();
        r0.b(getCurrentUserId());
        String r1 = com.bytedance.android.live.base.model.user.o.a(b());
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.a(r1);
        return Observable.merge(Observable.just(r0), this.a.p().map(new C0271a(this)));
    }

    public a(com.bytedance.android.livesdk.revenue.service.user.a r2) {
        Intrinsics.checkNotNullParameter(r2, "revUserService");
        this.a = r2;
    }

    @Override // l01.d
    public final Single<IBaseUser> t3(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        com.bytedance.android.livesdk.revenue.service.user.a r0 = this.a;
        return r0.g2(r3, r0.Je()).take(1).singleOrError();
    }

    @Override // l01.d
    public final Single<IBaseUser> z4(Context r3, Function1<? super ds2.b, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "builderContext");
        com.bytedance.android.livesdk.revenue.service.user.a r0 = this.a;
        e r1 = r0.Je();
        r4.invoke(r1);
        return r0.g2(r3, r1).take(1).singleOrError();
    }
}
