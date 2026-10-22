package com.bytedance.android.live.revenue.platform.container.impl;

import android.view.View;
import com.bytedance.platform.aio.channel.AbstractChannelClient;
import com.bytedance.platform.aio.channel.RpcException;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0<T> implements Consumer {
    public final /* synthetic */ h0 a;
    public final /* synthetic */ BytesContentType b;
    public final /* synthetic */ com.bytedance.platform.aio.channel.b c;
    public final /* synthetic */ com.bytedance.platform.aio.a d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ CompositeDisposable g;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ j0 a;

        public a(j0 r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            j0 r0 = this.a;
            h0 r1 = r0.a;
            BytesContentType r2 = r0.b;
            return r1.c.a(r3, r2);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ j0 a;

        public b(j0 r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.c.close();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ j0 a;

        public c(j0 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            h0.a r5 = (h0.a) r4;
            this.a.c.a(r5.a, r5.b);
            this.a.c.flush();
            jy0.b.d("RevenueJsMethodServer", "write " + r5.b.name() + " success " + this.a.e + ", methodId: " + this.a.f);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ j0 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ String c;

        public d(j0 r1, View r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            RpcException r5 = (Throwable) r7;
            jy0.b.c("RevenueJsMethodServer", "write err " + this.a.e + ", methodId: " + this.a.f + "  " + r5, null, 4);
            if ((r5 instanceof RpcException) == false) goto L5;
            RpcException r6 = r5;
            this.a.c.d(r6.getRpcCategory(), r6.getRpcMessage(), r6.getRpcExtra(), this.a.b);
        L6:
            this.a.c.close();
            return;
        L5:
            this.a.c.d("internal_error", "unknown error, message: " + r5.getMessage(), this.a.a.c.b(r5), this.a.b);
            int r8 = com.bytedance.android.live.revenue.platform.container.impl.d.a;
            View r0 = this.b;
            String r1 = this.c;
            String r2 = this.a.c.getChannelId();
            j0 r9 = this.a;
            com.bytedance.android.live.revenue.platform.container.impl.d.d(r0, r1, r2, r9.e, r9.f, r5);
            goto L6
        }
    }

    public j0(h0 r1, BytesContentType r2, AbstractChannelClient.a r3, com.bytedance.platform.aio.a r4, String r5, String r6, CompositeDisposable r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final void accept(Object r9) {
        if (r9 == null) goto L10;
        JsonObject r1 = (JsonObject) r9;
        h0 r10 = this.a;
        if (r10.d == null) goto L8;
        Pair r12 = (Pair) r10.e.invoke();
        View r6 = (View) r12.component1();
        String r13 = (String) r12.component2();
        i57.g r0 = this.a.d;
        r0.getClass();
        i57.g r5 = new i57.g(MapsKt.toMutableMap(r0.b));
        i57.e r2 = i57.e.f;
        r2.getClass();
        r5.b((i57.a.a) i57.e.d.getValue(r2, i57.e.a[2]), this.b);
        v r7 = new v(r1, r6, r13, this.c.getChannelId(), r5);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.d.c(this.e, this.f, r7).a.map(new a(this)).doOnComplete(new b(this)).subscribe(new c(this), new d(this, r6, r13)), this.g);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.platform.aio.context.MutableAioCallContext");
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JsonObject /* = com.google.gson.JsonObject */");
    }
}
