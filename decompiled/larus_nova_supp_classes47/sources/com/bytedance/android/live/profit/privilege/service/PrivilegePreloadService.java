package com.bytedance.android.live.profit.privilege.service;

import android.content.Context;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.misc.m;
import com.bytedance.android.live.revenue.core.util.AsyncService;
import com.bytedance.android.livesdk.message.model.fb;
import com.bytedance.android.livesdk.revenue.message.i;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PrivilegePreloadService extends AsyncService {
    public final CompositeDisposable d;
    public final k e;
    public final com.bytedance.android.livesdk.revenue.service.message.d f;

    public static final class a implements l {
        public final /* synthetic */ PublishSubject a;

        public a(PublishSubject r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r2) {
            if ((r2 instanceof fb) == false) goto L6;
            this.a.onNext(r2);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PrivilegePreloadService a;

        public b(PrivilegePreloadService r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            fb r5 = (fb) r4;
            PrivilegePreloadService.w0(this.a, r5.getScene(), r5.getParam());
        }
    }

    private final Context getContext() {
        return this.e.getContext();
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final void onStop() {
        super.onStop();
        this.d.dispose();
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final Object o0(Continuation<? super Unit> r7) {
        if ((r7 instanceof PrivilegePreloadService$onStartAsync$1) == false) goto L7;
        PrivilegePreloadService$onStartAsync$1 r0 = (PrivilegePreloadService$onStartAsync$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        PrivilegePreloadService r4 = (PrivilegePreloadService) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L18:
        com.bytedance.android.livesdk.revenue.service.message.d r9 = r4.f;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        String r5 = com.bytedance.android.live.revenue.common.message.b.I.a;
        PublishSubject r6 = PublishSubject.create();
        a r10 = new a(r6);
        i r12 = r9.getMessageManager();
        if (r12 != null) goto L21;
        Observable r13 = null;
    L22:
        if (r13 == null) goto L26;
        Disposable r14 = r13.subscribe(new b(r4));
        if (r14 == null) goto L26;
        RxUtilKt.c(r14, r4.d);
    L28:
        return Unit.INSTANCE;
    L26:
        ALogger.e("PrivilegePreloadService", "failed to listen message");
        Unit r15 = Unit.INSTANCE;
        goto L28
    L21:
        r13 = r6.doOnSubscribe(new com.bytedance.android.live.misc.l(r12, r5, r10)).doOnDispose(new m(r12, r5, r10));
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ALogger.w("PrivilegePreloadService", "service starting");
        com.bytedance.android.livesdk.revenue.service.message.d r16 = this.f;
        r0.L$0 = this;
        r0.label = 1;
        if (r16.g(r0) != r2) goto L17;
        return r2;
    L17:
        r4 = this;
    L7:
        r0 = new PrivilegePreloadService$onStartAsync$1(this, r7);
        goto L8
    }

    public PrivilegePreloadService(k r2, com.bytedance.android.livesdk.revenue.service.message.d r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "messageManagerService");
        this.e = r2;
        this.f = r3;
        this.d = new CompositeDisposable();
    }

    public static final void w0(PrivilegePreloadService r6, long r7, String r9) {
        r6.getClass();
        ALogger.w("PrivilegePreloadService", "creating preload card");
        com.bytedance.android.annie.ng.c r0 = Annie.with(r6.getContext(), UriProtector.parse((String) com.bytedance.android.live.profit.privilege.d.b.getValue(null, com.bytedance.android.live.profit.privilege.d.a[0])), "webcast");
        e r2 = new e();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "commonLifecycle");
        r0.d = r2;
        HybridCard r1 = r0.a();
        if (r1 == null) goto L5;
        r1.registerMethod("close", new f(r1));
        a7.a.a(r1, null, MapsKt.mapOf(TuplesKt.to("preloadData", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", Long.valueOf(r7)), TuplesKt.to("param", r9)}))), 1);
        RxUtilKt.c(Disposables.fromAction(new g(new WeakReference(r1))), r6.d);
        return;
    L5:
        ALogger.e("PrivilegePreloadService", "create card failed");
    }
}
