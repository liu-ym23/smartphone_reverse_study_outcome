package com.obric.cae.utils;

import android.content.Context;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJL\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J6\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u000e0\u0014H\u0007J)\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\u001c"}, d2 = {"Lcom/obric/cae/utils/AIKernelJavaBridge;", "", "", "appId", "Landroid/content/Context;", "context", "", "modelName", "Lkotlin/Function2;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "", "callback", "", Params.PRELOAD_SECONDS, "", "initAndLoadModel", "isModelLoadSuccess", "featureKey", "", "features", "Lkotlin/Function1;", "", "runModelInferenceAsync", "runModelInferenceSync", "(Ljava/lang/String;Ljava/lang/String;[F)Ljava/lang/Float;", "releaseModel", "<init>", "()V", "CommSenseAAR_release"}, k = 1, mv = {1, 8, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f7359b = null;

    static {
        f7358a = new b();
        f7359b = Executors.newFixedThreadPool(2, $$Lambda$BETQr8QzChLbH6cjMCW3c5NAh5o.INSTANCE);
    }

    public b() {
    }

    @JvmStatic
    public static final Float a(String r2, String r3, float[] r4) {
        Intrinsics.checkNotNullParameter(r2, "modelName");
        Intrinsics.checkNotNullParameter(r3, "featureKey");
        Intrinsics.checkNotNullParameter(r4, "features");
        return (Float) ZeusTransformUtils.preCheckCast(i.a(null, new AIKernelJavaBridge$d(r2, r3, r4, null), 1, null), Float.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        com.obric.cae.log.a.i("AIKernelJavaBridge", "model inference exception: " + e.getMessage());
        return null;
    }

    public static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "AIKernelJavaBridge");
    }

    @JvmStatic
    public static final void a(long r8, Context r10, String r11) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r11, "modelName");
        a(r8, r2, r11, null, 0, 24, null);
    }

    @JvmStatic
    public static final void a(long r2, Context r4, String r5, Function2<? super PackageResource, ? super Boolean, ? extends Object> r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r5, "modelName");
        c.f7367a.a(r8, r2);
        b r3 = f7358a;
        AIKernelJavaBridge$b r10 = new AIKernelJavaBridge$b(r5, r9, r7, null);
        r3.getClass();
        b(r10);
    }

    public static /* synthetic */ void a(long r7, Context r9, String r10, Function2 r11, int r12, int r13, Object r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Function2 r15 = (Function2) ZeusTransformUtils.wrapperContextForParams(r11, Function2.class, "com.obric.memorydata.plugin");
        if ((r13 & 8) == 0) goto L5;
        r15 = null;
    L5:
        Function2 r5 = r15;
        if ((r13 & 16) == 0) goto L8;
        r12 = 0;
    L8:
        a(r7, r3, r10, r5, r12);
    }

    public static final void a(Function1 r2) {
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$block");
        i.a(null, new AIKernelJavaBridge$a(r3, null), 1, null);
    }

    @JvmStatic
    public static final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "modelName");
        return c.f7367a.a(r1);
    }

    public static void b(Function1 r2) {
        final Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        f7359b.execute(new $$Lambda$t4DH7lR53eRB3vV8hSICVbYrm6o(r3));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        com.obric.cae.log.a.i("AIKernelJavaBridge", "execute background task failed: " + e.getMessage());
    }
}
