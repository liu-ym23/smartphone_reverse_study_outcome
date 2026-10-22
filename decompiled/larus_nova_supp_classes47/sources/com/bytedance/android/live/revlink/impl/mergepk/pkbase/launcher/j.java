package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.IPropInfoNotifyResponse;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.m;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public final CompositeDisposable a;
    public Disposable b;
    public final com.bytedance.android.live.revlink.impl.global.c c;
    public final Function0<Integer> d;
    public final IRoom e;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e f;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            com.bytedance.android.live.revenue.common.k.c((Throwable) r1);
        }
    }

    public final void a(int r10) {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r2 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r2);
        if (((com.bytedance.live.kmp.core.c) r2).hasPKPropCard() == true) goto L8;
        return;
    L8:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.c;
        LinkCrossRoomDataHolder r4 = null;
        if (r3 == null) goto L11;
        r31.a r5 = r3.getLinkNetwork();
    L12:
        if (r5 == null) goto L34;
        com.bytedance.android.live.revlink.impl.global.c r6 = this.c;
        if (r6 == null) goto L16;
        r4 = r6.getLinkCrossRoomDataHolder();
    L16:
        if (r4 == null) goto L18;
        long r7 = r4.c();
    L19:
        long r8 = r7;
        long r9 = this.f.getPkId();
        IRoom r12 = this.e;
        if (r12 == null) goto L23;
        String r13 = IRoomKt_androidKt.getAnchorId(r12);
        if (r13 == null) goto L23;
    L24:
        Observable<ExtraResponse<IPropInfoNotifyResponse, Extra>> r14 = r5.A(r10, r8, r9, r13);
        if (r14 == null) goto L35;
        int r15 = p.a;
        Observable r16 = r14.subscribeOn(Schedulers.io());
        if (r16 == null) goto L36;
        Observable r17 = r16.observeOn(AndroidSchedulers.mainThread());
        if (r17 == null) goto L37;
        Disposable r18 = r17.subscribe(a.a, b.a);
        if (r18 == null) goto L38;
        this.a.add(r18);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L23:
        r13 = "";
        goto L24
    L18:
        r7 = 0;
        goto L19
    L34:
        return;
    L11:
        r5 = null;
        goto L12
    }

    public j(com.bytedance.android.live.revlink.impl.global.c r2, Function0<Integer> r3, IRoom r4, com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r5) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r5, "pkBaseService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.a = new CompositeDisposable();
    }
}
