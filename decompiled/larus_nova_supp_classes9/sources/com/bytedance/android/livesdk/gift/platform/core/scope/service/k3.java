package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.revenue.service.effect.RevStickerPanel;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k3 implements com.bytedance.android.livesdk.revenue.service.effect.d {
    public final /* synthetic */ com.bytedance.android.livesdk.revenue.service.effect.c a;
    public final /* synthetic */ m3 b;

    public static final class a<T> implements SingleOnSubscribe {
        public final /* synthetic */ k3 a;
        public final /* synthetic */ List b;

        public a(k3 r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(SingleEmitter<List<yp2.b>> r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            r3.onSuccess(this.a.a.lk(this.b));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ k3 a;

        public b(k3 r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Iterator r7 = ((List) r6).iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            yp2.b r0 = (yp2.b) r7.next();
            com.bytedance.android.livesdk.revenue.service.effect.c.a.a(this.a.a, RevStickerPanel.EFFECT_ATMOSPHERE, r0, null, 12);
            goto L4
        }
    }

    public final void onFail() {
    }

    public final void onSuccess(List<? extends com.bytedance.android.livesdk.revenue.service.effect.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        Disposable r0 = this.b.b;
        if (r0 == null) goto L7;
        if (r0.isDisposed() == true) goto L7;
        return;
    L7:
        if ((!r4.isEmpty()) == false) goto L11;
        this.b.b = Single.create(new a(this, r4)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), l3.a);
        return;
    }

    public k3(com.bytedance.android.livesdk.revenue.service.effect.c r1, m3 r2) {
        this.a = r1;
        this.b = r2;
    }
}
