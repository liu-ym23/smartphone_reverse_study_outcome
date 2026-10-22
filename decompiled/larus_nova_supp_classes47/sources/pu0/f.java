package pu0;

import com.bytedance.android.live.profit.livepet.LivePetMessageDispatcher;
import com.bytedance.android.livesdk.message.model.cb;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.l;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements o, d {
    public final LivePetMessageDispatcher a;
    public final com.bytedance.android.live.profit.livepet.instance.b b;
    public final g c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // pu0.d
    public final Observable<c> observeLinkRegion() {
        Observable<c> r0 = this.c.observeLinkRegion();
        if (r0 != null) goto L6;
        l r1 = l.a;
        return Observable.empty();
    L6:
        return r0;
    }

    @Override // pu0.d
    public final Observable<cb> observePetEffectInfo() {
        return this.a.b.a(true);
    }

    @Override // pu0.d
    public final Observable<i> observePetRegion() {
        Observable<i> r0 = this.c.observePetRegion();
        if (r0 != null) goto L6;
        l r1 = l.a;
        i r2 = new i();
        h r3 = new h();
        r3.b(0.0f);
        r3.d(0.0f);
        r3.c(1.0f);
        r3.a(1.0f);
        Unit r4 = Unit.INSTANCE;
        r2.a(r3);
        return Observable.just(r2);
    L6:
        return r0;
    }

    @Override // pu0.d
    public final void unloadPet() {
        this.b.c();
    }

    @Override // pu0.d
    public final Observable<a> observeGiftEffectEvent(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "giftIds");
        Observable<a> r3 = this.c.observeGiftEffectEvent(r2);
        if (r3 != null) goto L6;
        l r4 = l.a;
        return Observable.empty();
    L6:
        return r3;
    }

    @Override // pu0.d
    public final Observable<b> observeGiftTrayEvent(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "giftIds");
        Observable<b> r3 = this.c.observeGiftTrayEvent(r2);
        if (r3 != null) goto L6;
        l r4 = l.a;
        return Observable.empty();
    L6:
        return r3;
    }

    public f(LivePetMessageDispatcher r2, com.bytedance.android.live.profit.livepet.instance.b r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "messageDispatcher");
        Intrinsics.checkNotNullParameter(r3, "instanceManager");
        Intrinsics.checkNotNullParameter(r4, "platformImpl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
