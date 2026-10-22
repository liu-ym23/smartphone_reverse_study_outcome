package com.obric.cae.utils;

import ae.d;
import android.content.Context;
import android.os.Bundle;
import android.util.EventsUtils;
import be.a;
import ce.e;
import ce.h;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.cae.libs.softap.i;
import com.obric.cae.log.CommSenseLog;
import com.qualcomm.qti.qesdk.QesdkUtils;
import defpackage.c;
import ge.l;
import ge.p;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import pe.z;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class AIKernelJavaBridge {
    public static final AIKernelJavaBridge INSTANCE = null;
    private static final String TAG = "AIKernelJavaBridge";
    private static final ExecutorService aiKernelExecutor = null;

    /* JADX INFO: renamed from: com.obric.cae.utils.AIKernelJavaBridge$initAndLoadModel$1, reason: invalid class name */
    @e(c = "com.obric.cae.utils.AIKernelJavaBridge$initAndLoadModel$1", f = "AIKernelJavaBridge.kt", l = {45}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends h implements l<d<? super j>, Object> {
        final /* synthetic */ p<PackageResource, Boolean, Object> $callback;
        final /* synthetic */ String $modelName;
        final /* synthetic */ int $preloadSeconds;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(String r8, p<? super PackageResource, ? super Boolean, ? extends Object> r10, int r11, d<? super AnonymousClass1> r12) {
            this.$modelName = r8;
            this.$callback = r10;
            this.$preloadSeconds = r11;
            super(1, r12);
        }

        @Override // ce.a
        public final d<j> create(d<?> r8) {
            return new AnonymousClass1(this.$modelName, this.$callback, this.$preloadSeconds, r8);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super j> r8) {
            return ((AnonymousClass1) create(r8)).invokeSuspend(j.f13877a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ce.a
        public final Object invokeSuspend(Object r14) {
            a r8 = a.f3165a;
            int r10 = this.label;
            Bundle r11 = null;
            Object[] r12 = 0;
            Object[] r13 = 0;
            if (r10 == 0) goto L11;
            if (r10 != 1) goto L10;
            c.m0(r14);     // Catch: Exception -> L7
        L18:
            xd.d r15 = (xd.d) r14;     // Catch: Exception -> L7
            if (r15 == null) goto L35;
            IBaseModel r16 = (IBaseModel) r15.f13868b;     // Catch: Exception -> L7
            A r17 = r15.f13867a;
            if (r16 == null) goto L30;
            CommSenseLog.d(AIKernelJavaBridge.TAG, "model load success: " + this.$modelName);     // Catch: Exception -> L7
            PackageResource r18 = (PackageResource) r17;     // Catch: Exception -> L7
            if (r18 == null) goto L43;
            p<PackageResource, Boolean, Object> r19 = this.$callback;     // Catch: Exception -> L7
            if (r19 == null) goto L43;
            Boolean r20 = Boolean.TRUE;     // Catch: Exception -> L7
        L29:
            r19.invoke(r18, r20);     // Catch: Exception -> L7
        L43:
            return j.f13877a;
        L30:
            CommSenseLog.e(AIKernelJavaBridge.TAG, "model load failed: " + this.$modelName);     // Catch: Exception -> L7
            r18 = (PackageResource) r17;     // Catch: Exception -> L7
            if (r18 == null) goto L43;
            r19 = this.$callback;     // Catch: Exception -> L7
            if (r19 == null) goto L43;
            r20 = Boolean.FALSE;     // Catch: Exception -> L7
            goto L29
        L35:
            CommSenseLog.e(AIKernelJavaBridge.TAG, "model load failed: " + this.$modelName);     // Catch: Exception -> L7
            p<PackageResource, Boolean, Object> r110 = this.$callback;     // Catch: Exception -> L7
            if (r110 == null) goto L43;
            r110.invoke(null, Boolean.FALSE);     // Catch: Exception -> L7
            goto L43
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            c.m0(r14);
            RequestParams r21 = new RequestParams(r11, r13 == true ? 1 : 0, 3, r12 == true ? 1 : 0);     // Catch: Exception -> L7
            int r111 = this.$preloadSeconds;     // Catch: Exception -> L7
            if (r111 <= 0) goto L15;
            r21.getBackend().putBoolean("needPreload", true);     // Catch: Exception -> L7
            r21.getBackend().putInt("preloadSeconds", r111);     // Catch: Exception -> L7
        L15:
            AIKernelUtils r22 = AIKernelUtils.INSTANCE;     // Catch: Exception -> L7
            String r23 = this.$modelName;     // Catch: Exception -> L7
            this.label = 1;     // Catch: Exception -> L7
            r14 = AIKernelUtils.loadAndCacheModel$default(r22, r23, false, r21, this, 2, null);     // Catch: Exception -> L7
            if (r14 != r8) goto L18;
            return r8;
        L7:
            e = move-exception;
            CommSenseLog.e(AIKernelJavaBridge.TAG, "model load exception: " + e.getMessage());
            p<PackageResource, Boolean, Object> r112 = this.$callback;
            if (r112 == null) goto L43;
            r112.invoke(null, Boolean.FALSE);
            goto L43
        }

        @Override // ge.l
        public /* bridge */ /* synthetic */ Object invoke(d<? super j> r8) {
            return invoke2(r8);
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.utils.AIKernelJavaBridge$runModelInferenceAsync$1, reason: invalid class name and case insensitive filesystem */
    @e(c = "com.obric.cae.utils.AIKernelJavaBridge$runModelInferenceAsync$1", f = "AIKernelJavaBridge.kt", l = {75}, m = "invokeSuspend")
    public static final class C02091 extends h implements l<d<? super j>, Object> {
        final /* synthetic */ l<Float, j> $callback;
        final /* synthetic */ String $featureKey;
        final /* synthetic */ float[] $features;
        final /* synthetic */ String $modelName;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C02091(String r8, String r10, float[] r11, l<? super Float, j> r12, d<? super C02091> r13) {
            this.$modelName = r8;
            this.$featureKey = r10;
            this.$features = r11;
            this.$callback = r12;
            super(1, r13);
        }

        @Override // ce.a
        public final d<j> create(d<?> r8) {
            return new C02091(this.$modelName, this.$featureKey, this.$features, this.$callback, r8);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super j> r8) {
            return ((C02091) create(r8)).invokeSuspend(j.f13877a);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            a r10 = a.f3165a;
            int r11 = this.label;
            if (r11 == 0) goto L11;
            if (r11 != 1) goto L10;
            c.m0(r8);     // Catch: Exception -> L7
        L15:
            this.$callback.invoke((Float) r8);     // Catch: Exception -> L7
        L19:
            return j.f13877a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            c.m0(r8);
            AIKernelUtils r12 = AIKernelUtils.INSTANCE;     // Catch: Exception -> L7
            String r13 = this.$modelName;     // Catch: Exception -> L7
            String r14 = this.$featureKey;     // Catch: Exception -> L7
            float[] r15 = this.$features;     // Catch: Exception -> L7
            this.label = 1;     // Catch: Exception -> L7
            r8 = r12.runModelInference(r13, r14, r15, false, this);     // Catch: Exception -> L7
            if (r8 != r10) goto L15;
            return r10;
        L7:
            e = move-exception;
            CommSenseLog.e(AIKernelJavaBridge.TAG, "model inference exception: " + e.getMessage());
            this.$callback.invoke(null);
            goto L19
        }

        @Override // ge.l
        public /* bridge */ /* synthetic */ Object invoke(d<? super j> r8) {
            return invoke2(r8);
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.utils.AIKernelJavaBridge$runModelInferenceSync$1, reason: invalid class name and case insensitive filesystem */
    @e(c = "com.obric.cae.utils.AIKernelJavaBridge$runModelInferenceSync$1", f = "AIKernelJavaBridge.kt", l = {EventsUtils.FEAT_TYPE_PROC_FREQUENT_RESTART}, m = "invokeSuspend")
    public static final class C02101 extends h implements p<z, d<? super Float>, Object> {
        final /* synthetic */ String $featureKey;
        final /* synthetic */ float[] $features;
        final /* synthetic */ String $modelName;
        int label;

        public C02101(String r8, String r10, float[] r11, d<? super C02101> r12) {
            this.$modelName = r8;
            this.$featureKey = r10;
            this.$features = r11;
            super(2, r12);
        }

        @Override // ce.a
        public final d<j> create(Object r8, d<?> r10) {
            return new C02101(this.$modelName, this.$featureKey, this.$features, r10);
        }

        @Override // ge.p
        public /* bridge */ /* synthetic */ Object invoke(z r8, d<? super Float> r10) {
            return invoke2(r8, r10);
        }

        @Override // ce.a
        public final Object invokeSuspend(Object r8) {
            a r10 = a.f3165a;
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            c.m0(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            c.m0(r8);
            AIKernelUtils r12 = AIKernelUtils.INSTANCE;
            String r13 = this.$modelName;
            String r14 = this.$featureKey;
            float[] r15 = this.$features;
            this.label = 1;
            r8 = r12.runModelInference(r13, r14, r15, true, this);
            if (r8 != r10) goto L11;
            return r10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(z r8, d<? super Float> r10) {
            return ((C02101) create(r8, r10)).invokeSuspend(j.f13877a);
        }
    }

    static {
        INSTANCE = new AIKernelJavaBridge();
        aiKernelExecutor = Executors.newFixedThreadPool(2, new i(2));
    }

    private AIKernelJavaBridge() {
    }

    public static /* synthetic */ void a(l r8) {
        m12executeBackground$lambda1(r8);
    }

    /* JADX INFO: renamed from: aiKernelExecutor$lambda-0, reason: not valid java name */
    private static final Thread m11aiKernelExecutor$lambda0(Runnable r8) {
        return new Thread(r8, TAG);
    }

    public static /* synthetic */ Thread b(Runnable r8) {
        return m11aiKernelExecutor$lambda0(r8);
    }

    private final void executeBackground(l<? super d<? super j>, ? extends Object> r8) {
        aiKernelExecutor.execute(new androidx.activity.d(r8, 29));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        CommSenseLog.e(TAG, "execute background task failed: " + e.getMessage());
    }

    /* JADX INFO: renamed from: executeBackground$lambda-1, reason: not valid java name */
    private static final void m12executeBackground$lambda1(l r8) {
        he.i.f(r8, "$block");
        l6.a.J0(new AIKernelJavaBridge$executeBackground$1$1(r8, null));
    }

    public static final void initAndLoadModel(long r10, Context r11, String r12) {
        he.i.f(r11, "context");
        he.i.f(r12, "modelName");
        initAndLoadModel$default(r10, r11, r12, null, 0, 24, null);
    }

    public static /* synthetic */ void initAndLoadModel$default(long r8, Context r10, String r11, p r12, int r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r12 = null;
    L5:
        p r16 = r12;
        if ((r14 & 16) == 0) goto L8;
        r13 = 0;
    L8:
        initAndLoadModel(r8, r10, r11, r16, r13);
    }

    public static final boolean isModelLoadSuccess(String r8) {
        he.i.f(r8, "modelName");
        return AIKernelUtils.INSTANCE.isContainsModel(r8);
    }

    public static final void releaseModel(String r8) {
        he.i.f(r8, "modelName");
        AIKernelUtils.INSTANCE.releaseModel(r8);
    }

    public static final void runModelInferenceAsync(String r8, String r10, float[] r11, l<? super Float, j> r12) {
        he.i.f(r8, "modelName");
        he.i.f(r10, "featureKey");
        he.i.f(r11, "features");
        he.i.f(r12, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
        INSTANCE.executeBackground(new C02091(r8, r10, r11, r12, null));
    }

    public static final Float runModelInferenceSync(String r8, String r10, float[] r11) {
        he.i.f(r8, "modelName");
        he.i.f(r10, "featureKey");
        he.i.f(r11, "features");
        return (Float) l6.a.J0(new C02101(r8, r10, r11, null));
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "model inference exception: " + e.getMessage());
        return null;
    }

    public static final void initAndLoadModel(long r10, Context r11, String r12, p<? super PackageResource, ? super Boolean, ? extends Object> r13) {
        he.i.f(r11, "context");
        he.i.f(r12, "modelName");
        initAndLoadModel$default(r10, r11, r12, r13, 0, 16, null);
    }

    public static final void initAndLoadModel(long r8, Context r10, String r11, p<? super PackageResource, ? super Boolean, ? extends Object> r12, int r13) {
        he.i.f(r10, "context");
        he.i.f(r11, "modelName");
        AIKernelUtils.INSTANCE.initSDK(r10, r8);
        INSTANCE.executeBackground(new AnonymousClass1(r11, r12, r13, null));
    }
}
