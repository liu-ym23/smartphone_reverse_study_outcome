package com.bytedance.android.live.revlink.impl.behavior;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0<T> implements ObservableOnSubscribe {
    public final /* synthetic */ ToolbarPkIdleHolder a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Integer r2 = (Integer) r1;
            this.a.onComplete();
        }
    }

    public i0(ToolbarPkIdleHolder r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L7;
        NextLiveData r1 = r0.uf();
        if (r1 == null) goto L7;
        r1.setValue(1);
    L7:
        com.bytedance.android.livesdk.revenue.datacenter.e r2 = wq2.e.a();
        k r3 = this.a.a;
        PkPanelType r4 = PkPanelType.Anchor;
        r3.getClass();
        r2.f(k.e(r4));
        ld.a r5 = ld.d.a();
        if (r5 == null) goto L12;
        NextLiveData r7 = r5.A4();
        if (r7 == null) goto L12;
        this.a.a.getClass();
        r7.setValue(k.f(r4));
    L12:
        ToolbarPkIdleHolder r8 = this.a;
        IvPkId r9 = IvPkId.MAIN;
        r8.getClass();
        r8.d(r4, r9, false);
        Observable r10 = Observable.just(1);
        ToolbarPkIdleHolder.a r12 = ToolbarPkIdleHolder.h;
        r12.getClass();
        Disposable r13 = r10.delay(((Number) ToolbarPkIdleHolder.g.getValue(r12, ToolbarPkIdleHolder.a.a[0])).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r6));
        this.a.e.add(r13);
    }
}
