package com.bytedance.android.live.revlink.impl.behavior;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0<T> implements ObservableOnSubscribe {
    public final /* synthetic */ ToolbarPkIdleHolder a;
    public final /* synthetic */ PkPanelType b;

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

    public e0(ToolbarPkIdleHolder r1, PkPanelType r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L11;
        NextLiveData r1 = r0.uf();
        if (r1 == null) goto L11;
        if (this.b != PkPanelType.PK) goto L9;
        int r2 = 2;
    L10:
        r1.setValue(r2);
        goto L11
    L9:
        r2 = 1;
    L11:
        com.bytedance.android.livesdk.revenue.datacenter.e r3 = wq2.e.a();
        k r4 = this.a.a;
        PkPanelType r5 = this.b;
        r4.getClass();
        r3.f(k.e(r5));
        ld.a r7 = ld.d.a();
        if (r7 == null) goto L16;
        NextLiveData r8 = r7.A4();
        if (r8 == null) goto L16;
        k r9 = this.a.a;
        PkPanelType r10 = this.b;
        r9.getClass();
        r8.setValue(k.f(r10));
    L16:
        this.a.d(this.b, IvPkId.MAIN, false);
        Observable r12 = Observable.just(1);
        ToolbarPkIdleHolder.a r13 = ToolbarPkIdleHolder.h;
        r13.getClass();
        this.a.e.add(r12.delay(((Number) ToolbarPkIdleHolder.g.getValue(r13, ToolbarPkIdleHolder.a.a[0])).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r6)));
    }
}
