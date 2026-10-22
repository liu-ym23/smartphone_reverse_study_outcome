package com.bytedance.android.live.revenue.platform.container.impl;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.platform.aio.ServiceHub;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RpcMethodImpl<T> {
    public final String a;
    public final List<b> b;
    public final Lazy c;
    public String d;
    public final String e;
    public final Method f;
    public final ServiceHub g;
    public final Type h;
    public final Class<T> i;
    public final com.bytedance.android.live.revenue.platform.container.impl.core.g j;
    public final CenterServiceType k;

    public static final class a {
        public final List<Object> a;
        public final long b;

        public a(List<? extends Object> r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "args");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final String a;
        public final Type b;

        public b(String r2, Type r3) {
            Intrinsics.checkNotNullParameter(r2, "paramKey");
            Intrinsics.checkNotNullParameter(r3, "paramType");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final String a;
        public final int b;

        public final int getType() {
            return this.b;
        }

        public c(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "fallbackUrl");
            this.a = r2;
            this.b = r3;
        }
    }

    public final /* synthetic */ class d implements Action {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void run() {
            this.a.invoke();
        }
    }

    public final /* synthetic */ class e implements Consumer {
        public final /* synthetic */ Function1 a;

        public e(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static z c(a r7, List r8) {
        ArrayList r9 = (ArrayList) r8;
        if (r9.isEmpty() == false) goto L8;
        Object r0 = CollectionsKt.firstOrNull(r7.a);
        if (r0 != null) goto L22;
        r0 = new JsonObject();
    L22:
        return new z(r0, r7.b);
    L8:
        JsonObject r1 = new JsonObject();
        if (r7.a == null) goto L18;
        Iterator<T> r10 = r9.iterator();
        int r2 = 0;
    L12:
        if (r10.hasNext() == false) goto L18;
        T r3 = r10.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        b r5 = (b) r3;
        r1.add(r5.a, GsonProtectorUtils.toJsonTree(GsonHelper.get(), ListProtector.get(r7.a, r2), r5.b));
        r2 = r4;
    L18:
        return new z(r1, r7.b);
    }

    public final Observable<JsonObject> b(a r9, boolean r10) {
        jy0.b.d("[AioLink]", "start invokeServiceCenter, interfaceId: " + this.e + ", methodId: " + this.a);
        com.bytedance.android.live.revenue.platform.container.impl.core.g r2 = this.j;
        com.bytedance.android.live.revenue.platform.container.impl.core.g.a r0 = com.bytedance.android.live.revenue.platform.container.impl.core.g.D0;
        CenterServiceType r1 = this.k;
        r0.getClass();
        Observable<JsonObject> r12 = r2.K(com.bytedance.android.live.revenue.platform.container.impl.core.g.a.a(r1), this.e, this.a, c(r9, this.b), r10);
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Scheduler r14 = Schedulers.computation();
        if (((Boolean) u0.b.getValue(null, u0.a[0])).booleanValue() == true) goto L5;
        return r12;
    L5:
        return r12.subscribeOn(r14);
    }

    public final void a(a r8, CompositeDisposable r9, final Function1<Object, Unit> r10, Function1<? super Throwable, Unit> r12, Function0<Unit> r13, Context r14) {
        Function1<JsonObject, Unit> r3 = new RpcMethodImpl$invokeService$convertResultCallback$1(this, r10);
        if (m.e.contains(this.e) == false) goto L6;
        RxUtilKt.c(this.g.d(this.e).subscribe(new p0(this, r8, r3, r12, r13, r9)), r9);
        return;
    L6:
        if (((c) this.c.getValue()) == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L22;
        if (r14 != null) goto L12;
        Observable r15 = Observable.error(com.bytedance.platform.aio.d.b("please provide context when call routerService", null));
    L13:
        if (r10 == null) goto L15;
        r10 = new e(r10);
    L15:
        Consumer r16 = (Consumer) r10;
        if (r12 == null) goto L18;
        r12 = new e(r12);
    L18:
        Consumer r17 = (Consumer) r12;
        if (r13 == null) goto L21;
        r13 = new d(r13);
    L21:
        RxUtilKt.c(r15.subscribe(r16, r17, (Action) r13), r9);
        return;
    L12:
        r15 = b(r8, true).map(new q0(this)).onErrorResumeNext(new s0(this, r14, r8));
        goto L13
    L22:
        Observable<JsonObject> r18 = b(r8, false);
        e r19 = new e(r3);
        if (r12 == null) goto L25;
        r12 = new e(r12);
    L25:
        Consumer r110 = (Consumer) r12;
        if (r13 == null) goto L28;
        r13 = new d(r13);
    L28:
        RxUtilKt.c(r18.subscribe(r19, r110, (Action) r13), r9);
        return;
    L8:
        r0 = false;
        goto L9
    }

    public RpcMethodImpl(String r6, Method r7, ServiceHub r8, Type r9, Class r10, com.bytedance.android.live.revenue.platform.container.impl.b r12, CenterServiceType r13) {
        Intrinsics.checkNotNullParameter(r6, "interfaceId");
        Intrinsics.checkNotNullParameter(r7, "method");
        Intrinsics.checkNotNullParameter(r8, "serviceHub");
        Intrinsics.checkNotNullParameter(r9, "returnType");
        Intrinsics.checkNotNullParameter(r10, "returnRawType");
        Intrinsics.checkNotNullParameter(r12, "centerService");
        Intrinsics.checkNotNullParameter(r13, "serviceType");
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        this.k = r13;
        BindsRpc r14 = r7.getAnnotation(BindsRpc.class);
        Intrinsics.checkNotNull(r14);
        this.a = r14.rpcName();
        ArrayList r15 = new ArrayList();
        RpcParam[][] r16 = r7.getParameterAnnotations();
        int r17 = r16.length;
        int r18 = 0;
        int r19 = 0;
    L3:
        if (r18 >= r17) goto L16;
        int r0 = r19 + 1;
        RpcParam[] r110 = (Annotation[]) r16[r18];
        Type r111 = this.f.getGenericParameterTypes()[r19];
        if (r110 == null) goto L15;
        int r1 = r110.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        RpcParam r3 = r110[r2];
        if ((r3 instanceof RpcParam) == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r3 == null) goto L15;
        r15.add(new b(r3.paramName(), r111));
        goto L15
    L12:
        r3 = null;
    L15:
        r18 = r18 + 1;
        r19 = r0;
        goto L3
    L16:
        this.b = r15;
        this.c = LazyKt.lazy(new RpcMethodImpl$routerServiceInfo$2(this));
    }
}
