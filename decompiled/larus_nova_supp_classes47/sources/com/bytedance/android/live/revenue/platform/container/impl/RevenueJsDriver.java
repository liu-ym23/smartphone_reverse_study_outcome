package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.platform.aio.ServiceHub;
import com.bytedance.platform.aio.Severity;
import com.bytedance.platform.aio.channel.AbstractChannelClient;
import com.bytedance.platform.aio.channel.js.JsBridgeChannelClient;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevenueJsDriver implements com.bytedance.platform.aio.a {
    public final Lazy a;
    public h0<Object, Object> b;
    public final g0 c;
    public final com.bytedance.platform.aio.channel.js.c d;
    public final com.bytedance.platform.aio.channel.js.c e;
    public final com.bytedance.platform.aio.channel.js.a f;
    public final i57.a g;
    public final Function0<Pair<View, String>> h;

    public static final class a implements com.bytedance.platform.aio.channel.b.a {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ View b;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.bytedance.platform.aio.channel.b d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Object g;

        public final void a() {
        }

        public final void b(boolean r12) {
            if (r12 == false) goto L4;
            return;
        L4:
            if (this.a.element == true) goto L8;
            int r13 = d.a;
            View r1 = this.b;
            String r2 = this.c;
            String r5 = this.d.getChannelId();
            String r3 = this.e;
            String r4 = this.f;
            i97.a r14 = i97.a.a;
            long r6 = System.currentTimeMillis() - ((z) this.g).b;
            Intrinsics.checkNotNullParameter(r5, "channelId");
            Intrinsics.checkNotNullParameter(r3, "interfaceId");
            Intrinsics.checkNotNullParameter(r4, "methodId");
            Single.just(1).subscribeOn(Schedulers.computation()).subscribe(new h(r1, r2, r3, r4, r5, r6), k.a);
            return;
        }

        public a(Ref.BooleanRef r1, View r2, String r3, AbstractChannelClient.a r4, String r5, String r6, Object r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public final JsBridgeChannelClient a() {
        return (JsBridgeChannelClient) this.a.getValue();
    }

    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interfaceId");
        return false;
    }

    public final void g(ServiceHub r6) {
        Intrinsics.checkNotNullParameter(r6, "serviceHub");
        jy0.b.d("RevenueJsDriver", "onLoad" + r6 + ", current url is: " + ((String) ((Pair) this.h.invoke()).getSecond()));
        JsBridgeChannelClient r0 = a();
        r0.getClass();
        Intrinsics.checkNotNullParameter("RevenueNativeJsDriver", "tag");
        com.bytedance.platform.aio.channel.f r3 = ((AbstractChannelClient) r0).f;
        r3.getClass();
        Intrinsics.checkNotNullParameter("RevenueNativeJsDriver", "tag");
        r3.a.add("RevenueNativeJsDriver");
        h0<Object, Object> r1 = new h0(r6, this.c, this.g, this.h);
        this.b = r1;
        Unit r2 = Unit.INSTANCE;
        ((AbstractChannelClient) r0).d = r1;
        ((AbstractChannelClient) r0).e = new f0(this, r6);
    }

    public final void i(com.bytedance.platform.aio.c r4) {
        Intrinsics.checkNotNullParameter(r4, "serviceHub");
        jy0.b.d("RevenueJsDriver", "onUnload" + r4 + ", current url is: " + ((String) ((Pair) this.h.invoke()).getSecond()));
        h0<Object, Object> r5 = this.b;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("handler");
    L5:
        r5.a.clear();
        JsBridgeChannelClient r6 = a();
        r6.k.a("rpcChannelMessage", r6.g);
        r6.k.a("rpcChannelMessageV2", r6.h);
    }

    public RevenueJsDriver(com.bytedance.platform.aio.channel.js.a r2, i57.g r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "jsBridge");
        Intrinsics.checkNotNullParameter(r3, "aioCallContext");
        Intrinsics.checkNotNullParameter(r4, "getMonitorParams");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = LazyKt.lazy(new RevenueJsDriver$client$2(this));
        this.c = new g0();
        this.d = a().g;
        this.e = a().h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T, R> j57.a<R> c(String r18, String r19, T r20) {
        Intrinsics.checkNotNullParameter(r18, "interfaceId");
        Intrinsics.checkNotNullParameter(r19, "methodId");
        Intrinsics.checkNotNullParameter(r20, "arguments");
        i97.a r3 = i97.a.a;
        System.currentTimeMillis();
        long r2 = ((z) r20).b;
        JsBridgeChannelClient r4 = a();
        BytesContentType r5 = BytesContentType.PROTOBUF;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r18, "interfaceId");
        Intrinsics.checkNotNullParameter(r19, "methodId");
        Intrinsics.checkNotNullParameter(r5, "contentType");
        StringBuilder r6 = new StringBuilder();
        r6.append(Integer.toString(r4.hashCode(), CharsKt.checkRadix(16)));
        r6.append('.');
        int r7 = ((AbstractChannelClient) r4).c;
        ((AbstractChannelClient) r4).c = r7 + 1;
        r6.append(r7);
        String r8 = r6.toString();
        AbstractChannelClient.a r12 = r4.b(r8);
        ((AbstractChannelClient) r4).b.put(r8, r12);
        String r9 = ((AbstractChannelClient) r4).a;
        com.bytedance.platform.aio.b.a.getClass();
        com.bytedance.platform.aio.b r13 = com.bytedance.platform.aio.b.a.a;
        Severity r14 = Severity.DEBUG;
        if (r13.b(r14, r9) == false) goto L5;
        r13.a(r14, r9, "connect: interfaceId = " + r18 + ", methodId = " + r19 + ", channel = " + r12);
    L5:
        r4.e(r18, r19, r8);
        Intrinsics.checkNotNullParameter(r18, "interfaceId");
        Intrinsics.checkNotNullParameter(r19, "methodId");
        Intrinsics.checkNotNullParameter(r5, "contentType");
        if (r12.c == true) goto L9;
        ((ArrayList) r12.g).add(new com.bytedance.platform.aio.channel.e.b(r12.h, r18, r19, r5));
    L9:
        String r0 = r18 + '.' + r19;
        Intrinsics.checkNotNullParameter(r0, "tag");
        com.bytedance.platform.aio.channel.f r10 = r12.j;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "tag");
        r10.a.add(r0);
        Ref.BooleanRef r15 = new Ref.BooleanRef();
        r15.element = false;
        Pair r1 = (Pair) this.h.invoke();
        View r16 = (View) r1.component1();
        String r17 = (String) r1.component2();
        r12.f = new a(r15, r16, r17, r12, r18, r19, r20);
        com.bytedance.revenue.platform.api.core.rx.l r22 = com.bytedance.revenue.platform.api.core.rx.l.a;
        return new j57.a(Observable.create(new RevenueJsDriver$invokeMethod$2(this, r16, r17, r12, r18, r19, r20, r15)), null, 4);
    }
}
