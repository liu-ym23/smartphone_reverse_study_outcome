package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements ObservableOnSubscribe<Object> {
    public final /* synthetic */ m a;
    public final /* synthetic */ CompositeDisposable b;
    public final /* synthetic */ Set c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Object f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ p a;
        public final /* synthetic */ ObservableEmitter b;

        public a(p r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.platform.aio.a r5 = (com.bytedance.platform.aio.a) r4;
            p r0 = this.a;
            if (((ArrayList) r0.a.d).contains(r0.d) == true) goto L8;
            p r1 = this.a;
            m r2 = r1.a;
            Set r3 = r1.c;
            r2.getClass();
            com.bytedance.android.live.revenue.platform.container.impl.core.g.a r6 = com.bytedance.android.live.revenue.platform.container.impl.core.g.D0;
            CenterServiceType r7 = CenterServiceType.PRE_CENTER_SERVICE;
            r6.getClass();
            if (Intrinsics.areEqual(r3, com.bytedance.android.live.revenue.platform.container.impl.core.g.a.a(r7)) == true) goto L8;
            this.b.onError(com.bytedance.platform.aio.d.f(this.a.d));
            return;
        L8:
            jy0.b.d("[AioLink]", "invokeMethod, interfaceId: " + this.a.d + ", methodId: " + this.a.e);
            p r8 = this.a;
            com.bytedance.revenue.platform.api.core.rx.f.a(r5.c(r8.d, r8.e, r8.f).a.subscribe(new n(this), new o(this)), this.a.b);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ObservableEmitter a;

        public b(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ObservableEmitter r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    public final void subscribe(ObservableEmitter<Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        r5.setDisposable(this.b);
        m r0 = this.a;
        Set r1 = this.c;
        String r2 = this.d;
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.a.filter(new q(r1)).firstOrError().map(new r(r2)).subscribe(new a(this, r5), new b(r5)), this.b);
    }

    public p(m r1, CompositeDisposable r2, Set r3, String r4, String r5, z r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
