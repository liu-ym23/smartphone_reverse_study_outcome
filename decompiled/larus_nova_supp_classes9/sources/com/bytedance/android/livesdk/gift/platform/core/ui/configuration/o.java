package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.livesdk.gift.model.x3;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements com.bytedance.android.scope.o {
    public final p12.c a;
    public final CompositeDisposable b;
    public final yz0.g c;
    public final jy0.a d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            x3 r2 = (x3) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ o a;

        public c(o r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            jy0.a r0 = this.a.d;
            r0.M3("GiftEffectConfigurationService", "updateGameEffectSwitch error", (Throwable) r4);
        }
    }

    static {
    }

    public final void onStart() {
        if (this.c.isAnchor() == true) goto L5;
        return;
    L5:
        if (ay1.d.a() == false) goto L7;
        ((Boolean) m12.b.s.getValue(null, m12.b.a[17])).booleanValue();
        return;
    L7:
        p12.c r0 = this.a;
        String r1 = this.c.getRoom().getIdStr();
        r0.getClass();
        Observable r2 = p12.c.a(r1, true);
        int r3 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r2.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(b.a, new c(this)), this.b);
    }

    public final void onStop() {
        this.b.clear();
    }

    public o(yz0.g r2, jy0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "aLogService");
        this.c = r2;
        this.d = r3;
        this.a = new p12.c();
        this.b = new CompositeDisposable();
    }
}
