package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.platform.aio.channel.AbstractChannelClient;
import com.bytedance.platform.aio.channel.RpcException;
import com.bytedance.platform.aio.channel.RpcExceptionMonitorLevel;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevenueJsDriver$invokeMethod$2<R> implements ObservableOnSubscribe<R> {
    public final /* synthetic */ RevenueJsDriver a;
    public final /* synthetic */ View b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.bytedance.platform.aio.channel.b d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Ref.BooleanRef h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RevenueJsDriver$invokeMethod$2 a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ ObservableEmitter c;

        public a(RevenueJsDriver$invokeMethod$2 r1, Ref.BooleanRef r2, ObservableEmitter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            Ref.BooleanRef r0 = this.b;
            if (r0.element == false) goto L5;
            r0.element = false;
            int r1 = d.a;
            RevenueJsDriver$invokeMethod$2 r2 = this.a;
            View r3 = r2.b;
            String r4 = r2.c;
            String r5 = r2.d.getChannelId();
            RevenueJsDriver$invokeMethod$2 r6 = this.a;
            d.b(r3, r4, r5, r6.e, r6.f, 1);
        L5:
            ObservableEmitter r7 = this.c;
            if (r8 == null) goto L10;
            r7.onNext(r8);
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type R");
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RevenueJsDriver$invokeMethod$2 a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ ObservableEmitter c;
        public final /* synthetic */ CompositeDisposable d;
        public final /* synthetic */ Disposable e;
        public final /* synthetic */ Disposable f;

        public b(RevenueJsDriver$invokeMethod$2 r1, Ref.BooleanRef r2, ObservableEmitter r3, CompositeDisposable r4, Disposable r5, Disposable r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r26) {
            RpcException r7 = (Throwable) r26;
            Ref.BooleanRef r1 = this.b;
            if (r1.element == false) goto L5;
            r1.element = false;
            int r2 = d.a;
            RevenueJsDriver$invokeMethod$2 r3 = this.a;
            View r8 = r3.b;
            String r9 = r3.c;
            String r10 = r3.d.getChannelId();
            RevenueJsDriver$invokeMethod$2 r4 = this.a;
            d.b(r8, r9, r10, r4.e, r4.f, 0);
        L5:
            this.a.h.element = true;
            this.c.onError(r7);
            if ((r7 instanceof RpcException) == false) goto L31;
            RpcException r12 = r7;
            String r5 = r12.getRpcCategory();
            int r6 = r5.hashCode();
            k r13 = k.a;
            String r14 = "unknown message";
            if (r6 == (-964900773)) goto L20;
            if (r6 == 1181466235) goto L13;
        L26:
            int r15 = d.a;
            RevenueJsDriver$invokeMethod$2 r16 = this.a;
            View r17 = r16.b;
            String r18 = r16.c;
            String r19 = r16.d.getChannelId();
            RevenueJsDriver$invokeMethod$2 r20 = this.a;
            d.d(r17, r18, r19, r20.e, r20.f, r7);
        L27:
            RevenueJsDriver$invokeMethod$2 r22 = this.a;
            View r23 = r22.b;
            String r24 = r22.c;
            String r25 = r22.d.getChannelId();
            RevenueJsDriver$invokeMethod$2 r27 = this.a;
            String r28 = r27.e;
            String r29 = r27.f;
            String r30 = r12.getRpcCategory();
            String r32 = r7.getMessage();
            if (r32 != null) goto L30;
            r32 = "";
        L30:
            RpcException r33 = r7;
            Map r110 = r33.getRpcExtra();
            RpcExceptionMonitorLevel r34 = r33.getRpcErrorLevel();
            Intrinsics.checkNotNullParameter(r25, "channelId");
            Intrinsics.checkNotNullParameter(r28, "interfaceId");
            Intrinsics.checkNotNullParameter(r29, "methodId");
            Intrinsics.checkNotNullParameter(r30, "reason");
            Intrinsics.checkNotNullParameter(r32, "message");
            Intrinsics.checkNotNullParameter("", "releaseVersion");
            Intrinsics.checkNotNullParameter(r110, "extra");
            Intrinsics.checkNotNullParameter(r34, "monitorLevel");
            Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new g(r23, "ttlive_aio_foundation_call_" + r34.getPostFix(), r24, r28, r29, r25, r30, r32, r110), r13);
        L32:
            this.d.delete(this.e);
            this.d.remove(this.f);
            return;
        L13:
            if (r5.equals("no_such_service") == false) goto L26;
            int r35 = d.a;
            RevenueJsDriver$invokeMethod$2 r36 = this.a;
            View r37 = r36.b;
            String r38 = r36.c;
            String r39 = r36.d.getChannelId();
            RevenueJsDriver$invokeMethod$2 r40 = this.a;
            String r42 = r40.e;
            String r43 = r40.f;
            String r111 = r7.getMessage();
            if (r111 == null) goto L18;
            r14 = r111;
        L18:
            Intrinsics.checkNotNullParameter(r39, "channelId");
            Intrinsics.checkNotNullParameter(r42, "interfaceId");
            Intrinsics.checkNotNullParameter(r43, "methodId");
            Intrinsics.checkNotNullParameter(r14, "message");
            Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new j(r37, r38, r42, r43, r39, r14), r13);
            goto L27
        L20:
            if (r5.equals("no_such_method") == false) goto L26;
            int r44 = d.a;
            RevenueJsDriver$invokeMethod$2 r45 = this.a;
            View r46 = r45.b;
            String r47 = r45.c;
            String r48 = r45.d.getChannelId();
            RevenueJsDriver$invokeMethod$2 r49 = this.a;
            String r50 = r49.e;
            String r52 = r49.f;
            String r53 = r7.getMessage();
            if (r53 == null) goto L25;
            r14 = r53;
        L25:
            Intrinsics.checkNotNullParameter(r48, "channelId");
            Intrinsics.checkNotNullParameter(r50, "interfaceId");
            Intrinsics.checkNotNullParameter(r52, "methodId");
            Intrinsics.checkNotNullParameter(r14, "message");
            Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new i(r46, r47, r50, r52, r48, r14), r13);
            goto L27
        L31:
            int r54 = d.a;
            RevenueJsDriver$invokeMethod$2 r55 = this.a;
            View r56 = r55.b;
            String r57 = r55.c;
            String r58 = r55.d.getChannelId();
            RevenueJsDriver$invokeMethod$2 r59 = this.a;
            d.d(r56, r57, r58, r59.e, r59.f, r7);
            goto L32
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ ObservableEmitter a;
        public final /* synthetic */ CompositeDisposable b;
        public final /* synthetic */ Disposable c;
        public final /* synthetic */ Disposable d;

        public c(ObservableEmitter r1, CompositeDisposable r2, Disposable r3, Disposable r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void run() {
            this.a.onComplete();
            this.b.delete(this.c);
            this.b.delete(this.d);
        }
    }

    public final void subscribe(ObservableEmitter<R> r17) {
        Intrinsics.checkNotNullParameter(r17, "emitter");
        h57.a r9 = new h57.a();
        CompositeDisposable r10 = new CompositeDisposable();
        int r0 = com.bytedance.revenue.platform.api.core.rx.h.a;
        Disposable r12 = com.bytedance.revenue.platform.api.core.rx.h.a(new RevenueJsDriver$invokeMethod$2$subscribe$reportInterruption$1(this));
        Disposable r13 = com.bytedance.revenue.platform.api.core.rx.h.a(new RevenueJsDriver$invokeMethod$2$subscribe$closeRead$1(this));
        Ref.BooleanRef r2 = new Ref.BooleanRef();
        r2.element = true;
        r10.addAll(new Disposable[]{r12, r13, r9.b.subscribe(new a(this, r2, r17), new b(this, r2, r17, r10, r12, r13), new c(r17, r10, r12, r13))});
        r17.setDisposable(r10);
        this.d.c(r9);
        h0.a<Object> r1 = this.a.c.a(((z) this.g).a, BytesContentType.PROTOBUF);
        this.d.a(r1.a, r1.b);
        this.d.b();
    }

    public RevenueJsDriver$invokeMethod$2(RevenueJsDriver r1, View r2, String r3, AbstractChannelClient.a r4, String r5, String r6, Object r7, Ref.BooleanRef r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
