package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import oc6.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends BaseMVIDataStore<h> implements com.bytedance.android.scope.o {
    public boolean e;
    public int f;
    public final CompositeDisposable g;
    public final BehaviorSubject<Integer> h;
    public final ny0.a i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            final e0 r5 = (e0) r4;
            GiftPanelBizBoostUtils.E.getClass();
            if (GiftPanelBizBoostUtils.A.l0() == true) goto L5;
        L7:
            this.a.g("observeCurrentTopViewMode_" + r5.a(), new GiftOperationDataStore$onStart$1$1(this, r5));
            return;
        L5:
            if (this.a.f != r5.a()) goto L7;
        }
    }

    static {
    }

    public final boolean f() {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.e.getClass();
        return com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x.a();
    }

    public final int k() {
        Integer r0 = (Integer) this.h.getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    public final void onStart() {
        RxUtilKt.c(((oc6.q) ny0.a.a.a(this.i, Reflection.getOrCreateKotlinClass(oc6.q.class))).observeCurrentTopViewMode().subscribe(new b(this)), this.g);
    }

    public final void onStop() {
        this.g.clear();
    }

    public h(ny0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "rpcService");
        this.i = r2;
        this.f = -1;
        this.g = new CompositeDisposable();
        this.h = BehaviorSubject.createDefault(-1);
    }
}
