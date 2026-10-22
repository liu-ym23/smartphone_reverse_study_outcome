package com.obric.cae.utils;

import android.content.Context;
import be.a;
import ce.c;
import ce.e;
import ce.h;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.cae.log.CommSenseLog;
import ge.p;
import ge.q;
import he.i;
import he.j;
import he.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import pe.x1;
import pe.z;
import xd.d;

/* JADX INFO: loaded from: classes2.dex */
public final class AIKernelUtils {
    public static final AIKernelUtils INSTANCE = null;
    private static final String TAG = "AIKernelUtils";
    private static final long TIMEOUT_GET_PACKAGE = 5000;
    private static final long TIMEOUT_INFER = 3000;
    private static final long TIMEOUT_LOAD_PACKAGE = 3000;
    private static final long TIMEOUT_UPDATE_PACKAGE = 5000;
    private static boolean hasInit;
    private static final ConcurrentHashMap<String, d<PackageResource, IBaseModel>> mModelCache = null;

    /* JADX INFO: renamed from: com.obric.cae.utils.AIKernelUtils$loadAndCacheModel$1, reason: invalid class name */
    @e(c = "com.obric.cae.utils.AIKernelUtils", f = "AIKernelUtils.kt", l = {54, 61, 73}, m = "loadAndCacheModel")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelUtils this$0;

        public AnonymousClass1(AIKernelUtils r8, ae.d<? super AnonymousClass1> r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.loadAndCacheModel(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.utils.AIKernelUtils$runModelInference$1, reason: invalid class name and case insensitive filesystem */
    @e(c = "com.obric.cae.utils.AIKernelUtils", f = "AIKernelUtils.kt", l = {92, 100}, m = "runModelInference")
    public static final class C02111 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelUtils this$0;

        public C02111(AIKernelUtils r8, ae.d<? super C02111> r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runModelInference(null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.utils.AIKernelUtils$runModelInference$2, reason: invalid class name */
    @e(c = "com.obric.cae.utils.AIKernelUtils$runModelInference$2", f = "AIKernelUtils.kt", l = {102}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends h implements p<z, ae.d<? super Float>, Object> {
        final /* synthetic */ String $biz;
        final /* synthetic */ IBaseModel $model;
        final /* synthetic */ RequestParams $params;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.obric.cae.utils.AIKernelUtils$runModelInference$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends j implements q<Boolean, Object, JSONObject, xd.j> {
            final /* synthetic */ String $biz;
            final /* synthetic */ o<Float> $value;

            public AnonymousClass1(o<Float> r8, String r10) {
                this.$value = r8;
                this.$biz = r10;
                super(3);
            }

            @Override // ge.q
            public /* bridge */ /* synthetic */ xd.j invoke(Boolean r8, Object r10, JSONObject r11) {
                invoke(r8.booleanValue(), r10, r11);
                return xd.j.f13877a;
            }

            /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Float] */
            public final void invoke(boolean r8, Object r10, JSONObject r11) {
                i.f(r11, "<anonymous parameter 2>");
                o<Float> r12 = this.$value;     // Catch: Exception -> L5
                i.d(r10, "null cannot be cast to non-null type kotlin.Number");     // Catch: Exception -> L5
                r12.f8064a = Float.valueOf(((Number) r10).floatValue());     // Catch: Exception -> L5
                CommSenseLog.d(AIKernelUtils.TAG, "Model{" + this.$biz + "} inference succeeded, result=" + this.$value.f8064a);     // Catch: Exception -> L5
                return;
            L5:
                e = move-exception;
                CommSenseLog.e(AIKernelUtils.TAG, "Failed to parse inference result: " + e.getMessage(), e);
            }
        }

        /* JADX INFO: renamed from: com.obric.cae.utils.AIKernelUtils$runModelInference$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C00552 extends j implements q<Integer, String, JSONObject, xd.j> {
            public static final C00552 INSTANCE = null;

            static {
                INSTANCE = new C00552();
            }

            public C00552() {
                super(3);
            }

            @Override // ge.q
            public /* bridge */ /* synthetic */ xd.j invoke(Integer r8, String r10, JSONObject r11) {
                invoke(r8.intValue(), r10, r11);
                return xd.j.f13877a;
            }

            public final void invoke(int r8, String r10, JSONObject r11) {
                i.f(r10, "errInfo");
                i.f(r11, "<anonymous parameter 2>");
                CommSenseLog.e(AIKernelUtils.TAG, "Model inference failed: " + r8 + ", " + r10);
            }
        }

        public AnonymousClass2(IBaseModel r8, RequestParams r10, String r11, ae.d<? super AnonymousClass2> r12) {
            this.$model = r8;
            this.$params = r10;
            this.$biz = r11;
            super(2, r12);
        }

        @Override // ce.a
        public final ae.d<xd.j> create(Object r8, ae.d<?> r10) {
            return new AnonymousClass2(this.$model, this.$params, this.$biz, r10);
        }

        @Override // ge.p
        public /* bridge */ /* synthetic */ Object invoke(z r8, ae.d<? super Float> r10) {
            return invoke2(r8, r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            a r10 = a.f3165a;
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            o r12 = (o) this.L$0;
            defpackage.c.m0(r8);
        L12:
            xa.a r13 = (xa.a) r8;
            if (r13 != null) goto L16;
            CommSenseLog.e(AIKernelUtils.TAG, "Failed to run model inference, infer() returned null, biz=" + this.$biz);
            return null;
        L16:
            l6.a.r0(r13, new AnonymousClass1(r12, this.$biz));
            l6.a.J(r13, C00552.INSTANCE);
            return r12.f8064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            defpackage.c.m0(r8);
            o r14 = new o();
            IBaseModel r15 = this.$model;
            RequestParams r16 = this.$params;
            this.L$0 = r14;
            this.label = 1;
            Object r17 = r15.infer(r16, this);
            if (r17 != r10) goto L11;
            return r10;
        L11:
            r12 = r14;
            r8 = r17;
            goto L12
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(z r8, ae.d<? super Float> r10) {
            return ((AnonymousClass2) create(r8, r10)).invokeSuspend(xd.j.f13877a);
        }
    }

    static {
        INSTANCE = new AIKernelUtils();
        mModelCache = new ConcurrentHashMap();
    }

    private AIKernelUtils() {
    }

    private final RequestParams buildModelRequestParams(String r8, float[] r10) {
        RequestParams r11 = new RequestParams(null, null, 3, null);
        new AIKernelUtils$buildModelRequestParams$1$1(r8, r10).invoke(r11.getBackend());
        return r11;
    }

    public static /* synthetic */ Object loadAndCacheModel$default(AIKernelUtils r8, String r10, boolean r11, RequestParams r12, ae.d r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = new RequestParams(null, null, 3, null);
    L9:
        return r8.loadAndCacheModel(r10, r11, r12, r13);
    }

    public final IBaseModel getCachedModel(String r8) {
        i.f(r8, "biz");
        d<PackageResource, IBaseModel> r10 = mModelCache.get(r8);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f13868b;
    }

    public final synchronized void initSDK(Context r8, long r10) {
        monitor-enter(this);
        i.f(r8, "context");     // Catch: Throwable -> L11
        if (hasInit == false) goto L8;
        CommSenseLog.d(TAG, "SDK already initialized, no need to init again");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        AIKernelConfig r11 = new AIKernelConfig.Builder(r8).appId(r10).build();     // Catch: Throwable -> L11
        AIKernelManager.INSTANCE.init(r11);     // Catch: Throwable -> L11
        hasInit = true;     // Catch: Throwable -> L11
        CommSenseLog.d(TAG, "SDK initialized successfully");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean isContainsModel(String r8) {
        monitor-enter(this);
        i.f(r8, "biz");     // Catch: Throwable -> L6
        boolean r10 = mModelCache.containsKey(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final Object loadAndCacheModel(String r12, boolean r13, RequestParams r14, ae.d<? super d<PackageResource, ? extends IBaseModel>> r15) {
        if ((r15 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r8 = (AnonymousClass1) r15;
        int r10 = r8.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r8.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r16 = r8.result;
        a r11 = a.f3165a;
        int r17 = r8.label;
        IBaseModel r18 = null;
        if (r17 == 0) goto L18;
        if (r17 == 1) goto L17;
        if (r17 == 2) goto L16;
        if (r17 != 3) goto L15;
        PackageResource r19 = (PackageResource) r8.L$2;
        PackageResource r110 = (PackageResource) r8.L$1;
        String r111 = (String) r8.L$0;
        defpackage.c.m0(r16);
    L53:
        IBaseModel r112 = (IBaseModel) r16;
        if (r112 == null) goto L57;
        mModelCache.put(r111, new d(r19, r112));
        r18 = r112;
    L57:
        return new d(r110, r18);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r113 = r8.Z$0;
        r110 = (PackageResource) r8.L$3;
        RequestParams r114 = (RequestParams) r8.L$2;
        String r115 = (String) r8.L$1;
        AIKernelUtils r20 = (AIKernelUtils) r8.L$0;
        defpackage.c.m0(r16);
        r14 = r114;
        r111 = r115;
    L37:
        xd.e r116 = (xd.e) r16;
        if (r116 == null) goto L58;
        Object r117 = r116.f13869a;
        if ((r117 instanceof xd.e.a) == false) goto L42;
        r117 = null;
    L42:
        PackageResource r118 = (PackageResource) r117;
        if (r118 == null) goto L58;
        CommSenseLog.d(TAG, "update package status: " + r118);
        if (r118.isAvailable() == true) goto L49;
        CommSenseLog.e(TAG, "package is not available after update, biz=" + r111);
        return new d(r118, null);
    L49:
        AIKernelUtils$loadAndCacheModel$model$1 r21 = new AIKernelUtils$loadAndCacheModel$model$1(r111, r113, r14, null);
        r8.L$0 = r111;
        r8.L$1 = r110;
        r8.L$2 = r118;
        r8.L$3 = null;
        r8.label = 3;
        Object r119 = x1.b(3000, r21, r8);
        if (r119 != r11) goto L52;
        return r11;
    L52:
        r16 = r119;
        r19 = r118;
    L58:
        CommSenseLog.e(TAG, "Failed to update package, biz=" + r111);
        return new d(r110, null);
    L17:
        r13 = r8.Z$0;
        r14 = (RequestParams) r8.L$2;
        r12 = (String) r8.L$1;
        AIKernelUtils this = (AIKernelUtils) r8.L$0;
        defpackage.c.m0(r16);
    L25:
        xd.e r120 = (xd.e) r16;
        if (r120 == null) goto L60;
        Object r121 = r120.f13869a;
        if ((r121 instanceof xd.e.a) == false) goto L30;
        r121 = null;
    L30:
        PackageResource r122 = (PackageResource) r121;
        if (r122 == null) goto L60;
        CommSenseLog.d(TAG, "get package status: " + r122);
        AIKernelUtils$loadAndCacheModel$updateResult$1 r22 = new AIKernelUtils$loadAndCacheModel$updateResult$1(r122, r14, null);
        r8.L$0 = this;
        r8.L$1 = r12;
        r8.L$2 = r14;
        r8.L$3 = r122;
        r8.Z$0 = r13;
        r8.label = 2;
        Object r123 = x1.b(5000, r22, r8);
        if (r123 != r11) goto L36;
        return r11;
    L36:
        r16 = r123;
        r113 = r13;
        r111 = r12;
        r110 = r122;
    L60:
        CommSenseLog.e(TAG, "Failed to get package status, biz=" + r12);
        return null;
    L18:
        defpackage.c.m0(r16);
        ConcurrentHashMap<String, d<PackageResource, IBaseModel>> r124 = mModelCache;
        if (r124.containsKey(r12) == true) goto L21;
        AIKernelUtils$loadAndCacheModel$pkgResult$1 r125 = new AIKernelUtils$loadAndCacheModel$pkgResult$1(r12, r14, null);
        r8.L$0 = this;
        r8.L$1 = r12;
        r8.L$2 = r14;
        r8.Z$0 = r13;
        r8.label = 1;
        r16 = x1.b(5000, r125, r8);
        if (r16 != r11) goto L25;
        return r11;
    L21:
        return r124.get(r12);
    L7:
        r8 = new AnonymousClass1(this, r15);
        goto L8
    }

    public final synchronized void releaseAllModels() {
        monitor-enter(this);
        Collection<d<PackageResource, IBaseModel>> r8 = mModelCache.values();     // Catch: Throwable -> L10
        i.e(r8, "mModelCache.values");     // Catch: Throwable -> L10
        Iterator<T> r10 = r8.iterator();     // Catch: Throwable -> L10
    L5:
        if (r10.hasNext() == false) goto L7;
        ((IBaseModel) ((d) r10.next()).f13868b).close();     // Catch: Throwable -> L10
        goto L5
    L7:
        mModelCache.clear();     // Catch: Throwable -> L10
        CommSenseLog.d(TAG, "All model resources released");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void releaseModel(String r8) {
        monitor-enter(this);
        i.f(r8, "biz");     // Catch: Throwable -> L12
        d<PackageResource, IBaseModel> r10 = mModelCache.remove(r8);     // Catch: Throwable -> L12
        if (r10 == null) goto L9;
        IBaseModel r11 = r10.f13868b;     // Catch: Throwable -> L12
        if (r11 == null) goto L9;
        r11.close();     // Catch: Throwable -> L12
    L9:
        CommSenseLog.d(TAG, "Model resources released, biz=".concat(r8));     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final Object runModelInference(String r16, String r17, float[] r18, boolean r19, ae.d<? super Float> r20) {
        if ((r20 instanceof C02111) == false) goto L7;
        C02111 r8 = (C02111) r20;
        int r10 = r8.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r8.label = r10 - Integer.MIN_VALUE;
    L8:
        C02111 r11 = r8;
        Object r12 = r11.result;
        a r13 = a.f3165a;
        int r14 = r11.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        defpackage.c.m0(r12);
    L36:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float[] r15 = (float[]) r11.L$3;
        String r21 = (String) r11.L$2;
        String r22 = (String) r11.L$1;
        AIKernelUtils r23 = (AIKernelUtils) r11.L$0;
        defpackage.c.m0(r12);
        float[] r110 = r15;
        String r111 = r21;
    L27:
        d r24 = (d) r12;
        if (r24 != null) goto L29;
    L22:
        IBaseModel r25 = null;
    L30:
        if (r25 != null) goto L33;
        CommSenseLog.e(TAG, "Failed to load model, biz=" + r22);
        return null;
    L33:
        AnonymousClass2 r26 = new AnonymousClass2(r25, r23.buildModelRequestParams(r111, r110), r22, null);
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.label = 2;
        r12 = x1.b(3000, r26, r11);
        if (r12 != r13) goto L36;
        return r13;
    L29:
        r25 = (IBaseModel) r24.f13868b;
        goto L30
    L16:
        defpackage.c.m0(r12);
        if (r19 == false) goto L23;
        d<PackageResource, IBaseModel> r27 = mModelCache.get(r16);
        if (r27 == null) goto L21;
        r25 = r27.f13868b;
        r111 = r17;
        r110 = r18;
        r23 = this;
        r22 = r16;
        goto L30
    L21:
        r111 = r17;
        r110 = r18;
        r23 = this;
        r22 = r16;
        goto L22
    L23:
        r11.L$0 = this;
        r11.L$1 = r16;
        r111 = r17;
        r11.L$2 = r111;
        r110 = r18;
        r11.L$3 = r110;
        r11.label = 1;
        r12 = loadAndCacheModel$default(this, r16, false, null, r11, 6, null);
        if (r12 != r13) goto L26;
        return r13;
    L26:
        r23 = this;
        r22 = r16;
    L7:
        r8 = new C02111(this, r20);
        goto L8
    }
}
