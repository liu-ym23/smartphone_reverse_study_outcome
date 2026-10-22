package com.bytedance.android.live.revenue.platform.router.impl;

import android.content.Context;
import com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.q;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zz0.i;
import zz0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b implements zz0.d, d {
    public final Map<String, c> a;
    public int b;
    public final vy0.b c;

    public b(vy0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridService");
        this.c = r2;
        this.a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.revenue.platform.router.impl.d
    public final zy0.a Y0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        c r3 = (c) ((LinkedHashMap) this.a).get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.b;
    }

    @Override // zz0.d, zz0.b
    public final Single<Unit> closeSelfAsync(i57.a r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r1 = q.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        i57.e r0 = i57.e.f;
        r0.getClass();
        xy0.a r6 = (xy0.a) r5.a((i57.a.a) i57.e.b.getValue(r0, i57.e.a[0]));
        if (r6 == null) goto L6;
        r6.dispose();
    L6:
        return Single.just(Unit.INSTANCE);
    }

    @Override // zz0.d, zz0.b
    public final Observable<UIHandleStatus> observeUIHandleStatus(j r2) {
        Intrinsics.checkNotNullParameter(r2, "uiHandle");
        Map<String, c> r0 = this.a;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        c r3 = (c) r1.get(r2.getId());
        if (r3 != null) goto L7;
        l r4 = l.a;
        return Observable.just(E(UIHandleStatus.HybridStatus.HybridStatusType.RELEASED, null));
    L7:
        return r3.a;
    }

    public static UIHandleStatus E(UIHandleStatus.HybridStatus.HybridStatusType r6, String r7) {
        Class r0 = UIHandleStatus.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r3 = r1.putIfAbsent(r0, r2);
        if (r3 == null) goto L12;
        r2 = r3;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L48;
        UIHandleStatus r5 = (UIHandleStatus) r4;
        Class r8 = UIHandleStatus.HybridStatus.class.getAnnotation(JsonAdapter.class).value();
        Object r9 = r1.get(r8);
        if (r9 != null) goto L24;
        r9 = r8.getConstructor(new Class[0]);
        if (r9 == null) goto L23;
        Object r10 = r1.putIfAbsent(r8, r9);
        if (r10 == null) goto L24;
        r9 = r10;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r12 = ((SerializableObjectJsonAdapterBase) ((Constructor) r9).newInstance(new Object[0])).createInstance();
        if (r12 == null) goto L46;
        UIHandleStatus.HybridStatus r13 = (UIHandleStatus.HybridStatus) r12;
        r13.setType(r6.getTag());
        if (r7 == null) goto L43;
        Class r14 = UIHandleStatus.HybridStatus.b.class.getAnnotation(JsonAdapter.class).value();
        Object r15 = r1.get(r14);
        if (r15 != null) goto L38;
        r15 = r14.getConstructor(new Class[0]);
        if (r15 == null) goto L37;
        Object r16 = r1.putIfAbsent(r14, r15);
        if (r16 == null) goto L38;
        r15 = r16;
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L38:
        Object r17 = ((SerializableObjectJsonAdapterBase) ((Constructor) r15).newInstance(new Object[0])).createInstance();
        if (r17 == null) goto L42;
        UIHandleStatus.HybridStatus.b r18 = (UIHandleStatus.HybridStatus.b) r17;
        r18.setMessage(r7);
        Unit r19 = Unit.INSTANCE;
        r13.D8(r18);
        goto L43
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus.HybridStatus.FailedInfo");
    L43:
        Unit r20 = Unit.INSTANCE;
        r5.R2(r13);
        return r5;
    L46:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus.HybridStatus");
    L48:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus");
    }

    public static /* synthetic */ UIHandleStatus I(b r0, UIHandleStatus.HybridStatus.HybridStatusType r1) {
        r0.getClass();
        return E(r1, null);
    }

    @Override // zz0.d, zz0.b
    public final Single<i> handleSchemeAsync(i57.a r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "aioCallContext");
        Intrinsics.checkNotNullParameter(r6, "uriString");
        int r0 = q.a;
        Class r1 = i.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r2 = vh7.b.a;
        Object r3 = r2.get(r1);
        if (r3 != null) goto L12;
        r3 = r1.getConstructor(new Class[0]);
        if (r3 == null) goto L11;
        Object r4 = r2.putIfAbsent(r1, r3);
        if (r4 == null) goto L12;
        r3 = r4;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r3).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L17;
        i r8 = (i) r7;
        Object r9 = r5.a(i57.e.f.a());
        Intrinsics.checkNotNull(r9);
        a01.b r10 = (a01.b) this;
        r8.setSuccess(r10.S2((Context) r9, r6));
        return Single.just(r8);
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.schema.api.OpenSchemaResponse");
    }

    @Override // zz0.d, zz0.b
    public final Single<j> openHybridDialogAsync(i57.a r9, String r10, zz0.a r12) {
        Intrinsics.checkNotNullParameter(r9, "aioCallContext");
        Intrinsics.checkNotNullParameter(r10, "schema");
        Intrinsics.checkNotNullParameter(r9, "aioCallContext");
        Intrinsics.checkNotNullParameter(r10, "schema");
        Class r0 = j.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r3 = r1.putIfAbsent(r0, r2);
        if (r3 == null) goto L12;
        r2 = r3;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L17;
        j r6 = (j) r4;
        i97.a r5 = i97.a.a;
        int r7 = (int) (System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN));
        int r8 = this.b + 1;
        this.b = r8;
        r6.setId(String.valueOf(r7 + r8));
        int r13 = com.bytedance.revenue.platform.api.core.rx.c.a;
        BehaviorSubject r14 = BehaviorSubject.createDefault(E(UIHandleStatus.HybridStatus.HybridStatusType.LOADING, null));
        int r15 = q.a;
        return Single.create(new a(this, r10, r9, r14, r6, r12));
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.schema.api.UIHandle");
    }
}
