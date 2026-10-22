package com.bytedance.android.live.revenue.platform.network.impl;

import android.os.SystemClock;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.h;
import com.bytedance.android.live.base.model.i;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.UnifiedResponsesKt;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends com.bytedance.android.live.revenue.platform.network.impl.b implements o {
    public final Set<Long> b;
    public final com.bytedance.android.livesdk.revenue.service.network.a c;
    public final com.bytedance.android.live.revenue.platform.network.impl.f d;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ c a;
        public final /* synthetic */ Type b;
        public final /* synthetic */ Type c;
        public final /* synthetic */ MiddlewareConverter d;

        public a(c r1, Type r2, Type r3, MiddlewareConverter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object apply(Object r5) {
            ExtraResponse r6 = (ExtraResponse) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            return c.I(this.a, r6, this.b, (Class) this.c, this.d);
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ c a;
        public final /* synthetic */ Type b;
        public final /* synthetic */ MiddlewareConverter c;

        public b(c r1, Type r2, MiddlewareConverter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            c.E(this.a, r5, (Class) this.b, this.c);
            return Observable.error(r5);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.network.impl.c$c, reason: collision with other inner class name */
    public static final class C0100c<T, R> implements Function {
        public final /* synthetic */ c a;
        public final /* synthetic */ Type b;
        public final /* synthetic */ Type c;
        public final /* synthetic */ MiddlewareConverter d;

        public C0100c(c r1, Type r2, Type r3, MiddlewareConverter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object apply(Object r5) {
            ExtraResponse r6 = (ExtraResponse) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            return c.I(this.a, r6, this.b, (Class) this.c, this.d);
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ c a;
        public final /* synthetic */ Type b;
        public final /* synthetic */ MiddlewareConverter c;

        public d(c r1, Type r2, MiddlewareConverter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            c.E(this.a, r5, (Class) this.b, this.c);
            return Observable.error(r5);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ long b;

        public e(c r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Disposable r4 = (Disposable) r3;
            this.a.b.add(Long.valueOf(this.b));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ long b;

        public f(c r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(T r3) {
            this.a.b.remove(Long.valueOf(this.b));
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ long b;

        public g(c r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.b.remove(Long.valueOf(this.b));
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public static Observable b0() {
        ApiServerException r0 = new ApiServerException(10001);
        r0.setErrorMsg(s1.B(2131922467));
        r0.setPrompt(s1.B(2131922467));
        r0.setBlockNotice(false);
        return Observable.error(r0);
    }

    public final boolean K() {
        ReadOnlyProperty r0 = com.bytedance.android.live.revenue.platform.network.impl.d.b;
        KProperty[] r1 = com.bytedance.android.live.revenue.platform.network.impl.d.a;
        if (((com.bytedance.android.live.revenue.platform.network.impl.a) r0.getValue(null, r1[0])).a() == true) goto L5;
        return false;
    L5:
        if (this.b.size() <= ((com.bytedance.android.live.revenue.platform.network.impl.a) r0.getValue(null, r1[0])).b()) goto L9;
        return true;
    L9:
        return false;
    }

    public final <T> Observable<T> w0(Observable<T> r4) {
        long r0 = SystemClock.elapsedRealtime();
        return r4.doOnSubscribe(new e(this, r0)).doOnNext(new f(this, r0)).doOnError(new g(this, r0));
    }

    public c(com.bytedance.android.livesdk.revenue.service.network.a r2, com.bytedance.android.live.revenue.platform.network.impl.f r3) {
        Intrinsics.checkNotNullParameter(r2, "networkService");
        Intrinsics.checkNotNullParameter(r3, "decoder");
        this.c = r2;
        this.d = r3;
        this.b = new LinkedHashSet();
    }

    public static final void E(c r10, Throwable r12, Class r13, MiddlewareConverter r14) {
        r10.getClass();
        String r1 = null;
        if ((r12 instanceof CustomApiServerException) == true) goto L5;
        Throwable r0 = null;
    L7:
        if (((CustomApiServerException) r0) == null) goto L52;
        CustomApiServerException r2 = (CustomApiServerException) r12;
        Extra r3 = (i) GsonProtectorUtils.fromJson(GsonHelper.get(), r2.getExtra(), i.class);
        if (r3 != null) goto L12;
        return;
    L12:
        if (((i) r3).b == null) goto L15;
        Extra r15 = com.bytedance.android.live.revenue.platform.network.impl.e.a(r3, r13);
    L20:
        int r16 = r2.getErrorCode();
        CustomApiServerException r17 = (ApiServerException) r12;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r17, "exception");
        Intrinsics.checkNotNullParameter(r15, "extra");
        String r4 = r17.getErrorMsg();
        String r5 = r17.getPrompt();
        String r6 = r17.getAlert();
        boolean r7 = r17.isBlockNotice();
        boolean r8 = r17 instanceof CustomApiServerException;
        if (r8 == true) goto L23;
        CustomApiServerException r9 = null;
    L24:
        CustomApiServerException r18 = r9;
        if (r18 == null) goto L27;
        String r19 = r18.getUrl();
    L28:
        if (r8 == true) goto L30;
        CustomApiServerException r20 = null;
    L31:
        CustomApiServerException r22 = r20;
        if (r22 == null) goto L34;
        String r23 = r22.getXTtLogId();
    L35:
        if (r8 == true) goto L37;
        CustomApiServerException r24 = null;
    L38:
        CustomApiServerException r25 = r24;
        if (r25 == null) goto L41;
        r1 = r25.getTraceId();
    L41:
        com.bytedance.android.livesdk.revenue.network.e r26 = new com.bytedance.android.livesdk.revenue.network.e(r4, r5, r6, r7, r19, r23, r1);
        Unit r27 = Unit.INSTANCE;
        List<com.bytedance.android.livesdk.revenue.network.a> r28 = r14.c;
        Iterator<T> r29 = r14.d.iterator();
        com.bytedance.android.livesdk.revenue.network.e r30 = r26;
    L43:
        if (r29.hasNext() == false) goto L45;
        com.bytedance.android.livesdk.revenue.network.a r32 = (com.bytedance.android.livesdk.revenue.network.a) r29.next();
        MiddlewareConverter.MiddlewarePriority r33 = MiddlewareConverter.MiddlewarePriority.Self;
        com.bytedance.android.livesdk.revenue.network.d r34 = r14.b;
        r30 = r32.A(r34.a, r34, r16, r30, r15);
        Unit r35 = Unit.INSTANCE;
        goto L43
    L45:
        Iterator<T> r36 = r28.iterator();
    L47:
        if (r36.hasNext() == false) goto L49;
        com.bytedance.android.livesdk.revenue.network.a r37 = (com.bytedance.android.livesdk.revenue.network.a) r36.next();
        MiddlewareConverter.MiddlewarePriority r38 = MiddlewareConverter.MiddlewarePriority.Self;
        com.bytedance.android.livesdk.revenue.network.d r39 = r14.b;
        r30 = r37.A(r39.a, r39, r16, r30, r15);
        Unit r40 = Unit.INSTANCE;
        goto L47
    L49:
        r17.setErrorMsg(r30.a);
        r17.setPrompt(r30.b);
        r17.setAlert(r30.c);
        r17.setBlockNotice(r30.d);
        r17.setExtra(GsonProtectorUtils.toJson(GsonHelper.get(), r15));
        return;
    L37:
        r24 = r17;
        goto L38
    L34:
        r23 = null;
        goto L35
    L30:
        r20 = r17;
        goto L31
    L27:
        r19 = null;
        goto L28
    L23:
        r9 = r17;
        goto L24
    L15:
        if (((i) r3).a == null) goto L17;
        r15 = r10.d.c(r3, r13);
        goto L20
    L17:
        Object r110 = r13.newInstance();
        if (r110 == null) goto L51;
        r15 = (Extra) r110;
        goto L20
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.Extra");
    L52:
        return;
    L5:
        r0 = r12;
        goto L7
    }

    public static final com.bytedance.android.live.network.response.d.b I(c r9, ExtraResponse r10, Type r12, Class r13, MiddlewareConverter r14) {
        r9.getClass();
        h r0 = (h) CollectionsKt.firstOrNull((List) r10.data);
        JsonElement r1 = null;
        if (r0 == null) goto L5;
        JsonElement r2 = r0.b;
    L7:
        if (r2 == null) goto L12;
        Gson r15 = com.bytedance.android.live.revenue.platform.network.impl.e.a;
        h r16 = (h) CollectionsKt.firstOrNull((List) r10.data);
        if (r16 == null) goto L11;
        r1 = r16.b;
    L11:
        Intrinsics.checkNotNull(r1);
        Extra r17 = r10.extra;
        Intrinsics.checkNotNullParameter(r1, "dataJson");
        Intrinsics.checkNotNullParameter(r17, "originExtra");
        Intrinsics.checkNotNullParameter(r12, "dataType");
        Intrinsics.checkNotNullParameter(r13, "extraType");
        Pair r18 = TuplesKt.to(GsonProtectorUtils.fromJson(com.bytedance.android.live.revenue.platform.network.impl.e.a, r1, r12), com.bytedance.android.live.revenue.platform.network.impl.e.a(r17, r13));
    L78:
        com.bytedance.android.live.network.response.d.b r19 = new com.bytedance.android.live.network.response.d.b(r18.component1(), (Extra) r18.component2());
        ((Field) UnifiedResponsesKt.a.getValue()).set(r19, r10.logId);
        ((ExtraResponse) r19).b = r10.b;
        ((ExtraResponse) r19).a = r10.a;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r19, "body");
        Unit r20 = Unit.INSTANCE;
        List<com.bytedance.android.livesdk.revenue.network.a> r22 = r14.c;
        Iterator<T> r110 = r14.d.iterator();
    L80:
        if (r110.hasNext() == false) goto L82;
        com.bytedance.android.livesdk.revenue.network.a r111 = (com.bytedance.android.livesdk.revenue.network.a) r110.next();
        MiddlewareConverter.MiddlewarePriority r3 = MiddlewareConverter.MiddlewarePriority.Self;
        com.bytedance.android.livesdk.revenue.network.d r4 = r14.b;
        r111.E(r4.a, r4, r19);
        Unit r112 = Unit.INSTANCE;
        goto L80
    L82:
        Iterator<T> r23 = r22.iterator();
    L84:
        if (r23.hasNext() == false) goto L86;
        com.bytedance.android.livesdk.revenue.network.a r113 = (com.bytedance.android.livesdk.revenue.network.a) r23.next();
        MiddlewareConverter.MiddlewarePriority r114 = MiddlewareConverter.MiddlewarePriority.Self;
        com.bytedance.android.livesdk.revenue.network.d r115 = r14.b;
        r113.E(r115.a, r115, r19);
        Unit r116 = Unit.INSTANCE;
        goto L84
    L86:
        return r19;
    L12:
        com.bytedance.android.live.revenue.platform.network.impl.f r5 = r9.d;
        Iterable r6 = (Iterable) r10.data;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r7.add(((h) r8.next()).a);
        goto L14
    L16:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r7, "byteArrayList");
        Intrinsics.checkNotNullParameter(r12, "dataType");
        if (Intrinsics.areEqual(r12, Unit.class) == false) goto L19;
        Object r117 = Unit.INSTANCE;
    L77:
        r18 = TuplesKt.to(r117, r9.d.c(r10.extra, r13));
        goto L78
    L19:
        ArrayList r24 = new ArrayList();
        Iterator r25 = r7.iterator();
    L21:
        if (r25.hasNext() == false) goto L23;
        byte[] r26 = (byte[]) r25.next();
        am3.g r27 = new am3.g();
        r27.k(new am3.b(r26));
        r24.add(r27);
        goto L21
    L23:
        ResponsePBDataDecoder$getDataCollectionConstructorAndType$1 r28 = ResponsePBDataDecoder$getDataCollectionConstructorAndType$1.INSTANCE;
        boolean r29 = r12 instanceof Class;
        if (r29 == false) goto L27;
        Class r30 = (Class) r12;
    L32:
        if (Intrinsics.areEqual(r30, List.class) == false) goto L39;
        if ((r12 instanceof ParameterizedType) == false) goto L37;
        Pair r32 = new Pair(ResponsePBDataDecoder$getDataCollectionConstructorAndType$3.INSTANCE, r28.invoke((ParameterizedType) r12));
    L55:
        Function0 r118 = (Function0) r32.component1();
        Class r33 = (Class) r32.component2();
        if (r118 == null) goto L58;
        r1 = (Collection) r118.invoke();
    L58:
        if (r1 == null) goto L65;
        Iterator r119 = r24.iterator();
    L61:
        if (r119.hasNext() == false) goto L63;
        r1.add(r5.a((am3.g) r119.next(), r33));
        goto L61
    L63:
        r117 = r1;
        goto L77
    L65:
        if (r24.isEmpty() == false) goto L74;
        if (r33 == null) goto L73;
        r117 = vh7.f.c(r33);
        if (r117 != null) goto L77;
        throw new NullPointerException("null cannot be cast to non-null type T");
    L73:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<com.bytedance.tools.kcp.modelx.runtime.FlexModel<*>>");
    L74:
        am3.g r120 = (am3.g) CollectionsKt.single(r24);
        if (r33 == null) goto L88;
        r117 = r5.a(r120, r33);
        goto L77
    L88:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<T>");
    L37:
        throw new IllegalStateException(("Type [" + r12 + "] must have one type argument.").toString());
    L39:
        if (Intrinsics.areEqual(r30, Set.class) == false) goto L46;
        if ((r12 instanceof ParameterizedType) == false) goto L44;
        r32 = new Pair(ResponsePBDataDecoder$getDataCollectionConstructorAndType$5.INSTANCE, r28.invoke((ParameterizedType) r12));
        goto L55
    L44:
        throw new IllegalStateException(("Type [" + r12 + "] must have one type argument.").toString());
    L46:
        if (r30.isInterface() == false) goto L50;
        if (vh7.c.class.isAssignableFrom(r30) == true) goto L50;
    L90:
        throw new IllegalStateException(("Unsupported data type: " + r12).toString());
    L50:
        if (Collection.class.isAssignableFrom(r30) == true) goto L90;
        if (Map.class.isAssignableFrom(r30) == true) goto L90;
        if (r29 == false) goto L90;
        r32 = new Pair(null, r12);
        goto L55
    L27:
        if ((r12 instanceof ParameterizedType) == false) goto L94;
        Type r34 = ((ParameterizedType) r12).getRawType();
        if (r34 == null) goto L92;
        r30 = (Class) r34;
        goto L32
    L92:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L94:
        throw new IllegalStateException(("Unable to get classType for " + r12.getClass()).toString());
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revenue.platform.network.api.INetworkService
    public final <DATA, EXTRA extends Extra> Observable<ExtraResponse<DATA, EXTRA>> x0(INetworkService.Biz r16, String r17, Type r18, Type r19, List<? extends com.bytedance.android.livesdk.revenue.network.a> r20, Map<String, String> r22, Map<String, String> r23, Map<String, ? extends List<String>> r24) {
        Intrinsics.checkNotNullParameter(r16, "biz");
        Intrinsics.checkNotNullParameter(r17, "path");
        Intrinsics.checkNotNullParameter(r18, "dataType");
        Intrinsics.checkNotNullParameter(r19, "extraType");
        Intrinsics.checkNotNullParameter(r20, "middlewareList");
        Intrinsics.checkNotNullParameter(r22, "headerMap");
        Intrinsics.checkNotNullParameter(r23, "queryMap");
        Intrinsics.checkNotNullParameter(r24, "queryListMap");
        Class r6 = (Class) r19;
        if (K() == true) goto L5;
        Intrinsics.checkNotNullParameter(r16, "biz");
        List<com.bytedance.android.livesdk.revenue.network.a> r1 = this.a.get(r16);
        if (r1 != null) goto L9;
        r1 = CollectionsKt.emptyList();
    L9:
        MiddlewareConverter r7 = new MiddlewareConverter(r20, r1, new com.bytedance.android.livesdk.revenue.network.d(r17, r22, r23, MapsKt.emptyMap(), r24, MapsKt.emptyMap(), null));
        com.bytedance.android.livesdk.revenue.network.d r2 = r7.b;
        return w0(this.c.t9(r2.a, r2.b, r2.c, r2.e).map(new a(this, r18, r19, r7)).onErrorResumeNext(new b(this, r19, r7)));
    L5:
        return b0();
    }

    @Override // com.bytedance.android.live.revenue.platform.network.api.INetworkService
    public final <DATA, EXTRA extends Extra> Observable<ExtraResponse<DATA, EXTRA>> L4(INetworkService.Biz r16, String r17, Type r18, Type r19, List<? extends com.bytedance.android.livesdk.revenue.network.a> r20, Map<String, String> r22, Map<String, String> r23, Map<String, ? extends List<String>> r24, Map<String, String> r25, Map<String, ? extends List<String>> r26, JsonObject r27) {
        Intrinsics.checkNotNullParameter(r16, "biz");
        Intrinsics.checkNotNullParameter(r17, "path");
        Intrinsics.checkNotNullParameter(r18, "dataType");
        Intrinsics.checkNotNullParameter(r19, "extraType");
        Intrinsics.checkNotNullParameter(r20, "middlewareList");
        Intrinsics.checkNotNullParameter(r22, "headerMap");
        Intrinsics.checkNotNullParameter(r23, "queryMap");
        Intrinsics.checkNotNullParameter(r24, "queryListMap");
        Intrinsics.checkNotNullParameter(r25, "fieldMap");
        Intrinsics.checkNotNullParameter(r26, "fieldListMap");
        Class r6 = (Class) r19;
        if (K() == true) goto L5;
        Intrinsics.checkNotNullParameter(r16, "biz");
        List<com.bytedance.android.livesdk.revenue.network.a> r1 = this.a.get(r16);
        if (r1 != null) goto L9;
        r1 = CollectionsKt.emptyList();
    L9:
        MiddlewareConverter r7 = new MiddlewareConverter(r20, r1, new com.bytedance.android.livesdk.revenue.network.d(r17, r22, r23, r25, r24, r26, r27));
        com.bytedance.android.livesdk.revenue.network.d r2 = r7.b;
        JsonObject r4 = r2.g;
        if (r4 == null) goto L12;
        com.bytedance.android.livesdk.revenue.service.network.a r5 = this.c;
        String r8 = r2.a;
        Map r9 = r2.b;
        Map r3 = r2.c;
        Intrinsics.checkNotNull(r4);
        Observable r10 = r5.Z7(r8, r9, r3, r4);
    L14:
        return w0(r10.map(new C0100c(this, r18, r19, r7)).onErrorResumeNext(new d(this, r19, r7)));
    L12:
        r10 = this.c.ik(r2.a, r2.b, r2.c, r2.e, r2.d, r2.f);
        goto L14
    L5:
        return b0();
    }
}
