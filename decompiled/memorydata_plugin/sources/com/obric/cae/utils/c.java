package com.obric.cae.utils;

import android.content.Context;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004JA\u0010\u0011\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\bJ5\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/obric/cae/utils/AIKernelUtils;", "", "Landroid/content/Context;", "context", "", "appId", "", "initSDK", "", "biz", "", "useCloud", "Lcom/obric/aikernel/sdk/config/RequestParams;", TrackerImpl.PARAMS, "Lkotlin/Pair;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "loadAndCacheModel", "(Ljava/lang/String;ZLcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedModel", "featureKey", "", "features", "isBlock", "", "runModelInference", "(Ljava/lang/String;Ljava/lang/String;[FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "releaseModel", "releaseAllModels", "isContainsModel", "<init>", "()V", "CommSenseAAR_release"}, k = 1, mv = {1, 8, 0})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7367a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7368b;
    public static final ConcurrentHashMap<String, Pair<PackageResource, IBaseModel>> c = null;

    static {
        f7367a = new c();
        c = new ConcurrentHashMap();
    }

    public c() {
    }

    public static /* synthetic */ Object a(c r1, String r2, boolean r3, RequestParams r4, Continuation r5, int r6, Object r7) {
        Continuation<? super Pair<PackageResource, ? extends IBaseModel>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = new RequestParams(null, null, 3, null);
    L9:
        return r1.a(r2, r3, r4, r8);
    }

    public final Object a(String r17, String r18, float[] r19, boolean r20, Continuation<? super Float> r21) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, AIKernelUtils$e.class) == false) goto L7;
        AIKernelUtils$e r1 = (AIKernelUtils$e) ZeusTransformUtils.preCheckCast(r0, AIKernelUtils$e.class, "com.obric.memorydata.plugin");
        int r2 = r1.g;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.g = r2 - Integer.MIN_VALUE;
    L8:
        AIKernelUtils$e r10 = r1;
        Object r3 = r10.e;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r10.g;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r3);
    L35:
        return r3;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float[] r5 = r10.d;
        String r6 = r10.c;
        String r7 = r10.f7350b;
        c r8 = r10.f7349a;
        ResultKt.throwOnFailure(r3);
        float[] r15 = r5;
        String r14 = r6;
    L25:
        Pair r9 = (Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L28;
    L27:
        IBaseModel r12 = (IBaseModel) ZeusTransformUtils.preCheckCast(r9.getSecond(), IBaseModel.class, "com.obric.memorydata.plugin");
    L29:
        if (r12 != null) goto L32;
        com.obric.cae.log.a.i("AIKernelUtils", "Failed to load model, biz=" + r7);
        return null;
    L32:
        r8.getClass();
        RequestParams r13 = new RequestParams(null, null, 3, null);
        ParamsKt.setCustomArgs(r13, new a(r14, r15));
        AIKernelUtils$f r16 = new AIKernelUtils$f(r12, r13, r7, null);
        r10.f7349a = null;
        r10.f7350b = null;
        r10.c = null;
        r10.d = (float[]) ZeusTransformUtils.preCheckCast(null, float[].class, "com.obric.memorydata.plugin");
        r10.g = 2;
        r3 = da.b(3000, r16, r10);
        if (r3 != r11) goto L35;
        return r11;
    L28:
        r12 = null;
        goto L29
    L16:
        ResultKt.throwOnFailure(r3);
        if (r20 == false) goto L21;
        r9 = (Pair) ZeusTransformUtils.preCheckCast(c.get(r17), Pair.class, "com.obric.memorydata.plugin");
        r14 = r18;
        r15 = r19;
        r8 = this;
        r7 = r17;
        if (r9 == null) goto L28;
    L21:
        r10.f7349a = this;
        r10.f7350b = r17;
        r14 = r18;
        r10.c = r14;
        r15 = r19;
        r10.d = r15;
        r10.g = 1;
        r3 = a(this, r17, false, null, r10, 6, null);
        if (r3 != r11) goto L24;
        return r11;
    L24:
        r8 = this;
        r7 = r17;
    L7:
        r1 = new AIKernelUtils$e(this, r0);
        goto L8
    }

    public final Object a(String r19, boolean r20, RequestParams r21, Continuation<? super Pair<PackageResource, ? extends IBaseModel>> r22) {
        c r0 = this;
        String r1 = r19;
        RequestParams r2 = r21;
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AIKernelUtils$a.class) == false) goto L7;
        AIKernelUtils$a r6 = (AIKernelUtils$a) ZeusTransformUtils.preCheckCast(r4, AIKernelUtils$a.class, "com.obric.memorydata.plugin");
        int r7 = r6.h;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.h = r7 - Integer.MIN_VALUE;
    L8:
        Object r5 = r6.f;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.h;
        IBaseModel r15 = null;
        if (r9 == 0) goto L18;
        if (r9 == 1) goto L17;
        if (r9 == 2) goto L16;
        if (r9 != 3) goto L15;
        PackageResource r3 = (PackageResource) ZeusTransformUtils.preCheckCast(r6.c, PackageResource.class, "com.obric.memorydata.plugin");
        PackageResource r10 = (PackageResource) ZeusTransformUtils.preCheckCast(r6.f7342b, PackageResource.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.f7341a, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L53:
        IBaseModel r12 = (IBaseModel) ZeusTransformUtils.preCheckCast(r5, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L57;
        c.put(r11, new Pair(r3, r12));
        r15 = r12;
    L57:
        return new Pair(r10, r15);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r13 = r6.e;
        r10 = r6.d;
        RequestParams r14 = (RequestParams) ZeusTransformUtils.preCheckCast(r6.c, RequestParams.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r6.f7342b, String.class, "com.obric.memorydata.plugin");
        c r17 = (c) ZeusTransformUtils.preCheckCast(r6.f7341a, c.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        RequestParams r18 = r14;
        r11 = r16;
    L37:
        Result r23 = (Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L58;
        Object r24 = r23.m1430unboximpl();
        if (Result.m1427isFailureimpl(r24) == false) goto L42;
        r24 = null;
    L42:
        PackageResource r25 = (PackageResource) ZeusTransformUtils.preCheckCast(r24, PackageResource.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L58;
        com.obric.cae.log.a.c("AIKernelUtils", "update package status: " + r25);
        if (r25.isAvailable() == true) goto L49;
        com.obric.cae.log.a.i("AIKernelUtils", "package is not available after update, biz=" + r11);
        return new Pair(r25, null);
    L49:
        AIKernelUtils$b r26 = new AIKernelUtils$b(r11, r13, r18, null);
        r6.f7341a = r11;
        r6.f7342b = r10;
        r6.c = r25;
        r6.d = null;
        r6.h = 3;
        Object r27 = da.b(3000, r26, r6);
        if (r27 != r8) goto L52;
        return r8;
    L52:
        r5 = r27;
        r3 = r25;
    L58:
        com.obric.cae.log.a.i("AIKernelUtils", "Failed to update package, biz=" + r11);
        return new Pair(r10, null);
    L17:
        boolean r28 = r6.e;
        RequestParams r29 = (RequestParams) ZeusTransformUtils.preCheckCast(r6.c, RequestParams.class, "com.obric.memorydata.plugin");
        String r30 = (String) ZeusTransformUtils.preCheckCast(r6.f7342b, String.class, "com.obric.memorydata.plugin");
        c r31 = (c) ZeusTransformUtils.preCheckCast(r6.f7341a, c.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        boolean r32 = r28;
        r0 = r31;
        Object r33 = r5;
        r2 = r29;
        r1 = r30;
    L25:
        Result r34 = (Result) ZeusTransformUtils.preCheckCast(r33, Result.class, "com.obric.memorydata.plugin");
        if (r34 == null) goto L60;
        Object r35 = r34.m1430unboximpl();
        if (Result.m1427isFailureimpl(r35) == false) goto L30;
        r35 = null;
    L30:
        PackageResource r36 = (PackageResource) ZeusTransformUtils.preCheckCast(r35, PackageResource.class, "com.obric.memorydata.plugin");
        if (r36 == null) goto L60;
        com.obric.cae.log.a.c("AIKernelUtils", "get package status: " + r36);
        AIKernelUtils$d r37 = new AIKernelUtils$d(r36, r2, null);
        r6.f7341a = r0;
        r6.f7342b = r1;
        r6.c = r2;
        r6.d = r36;
        r6.e = r32;
        r6.h = 2;
        Object r38 = da.b(5000, r37, r6);
        if (r38 != r8) goto L36;
        return r8;
    L36:
        boolean r110 = r32;
        r5 = r38;
        r13 = r110;
        RequestParams r111 = r2;
        r11 = r1;
        r10 = r36;
        r18 = r111;
    L60:
        com.obric.cae.log.a.i("AIKernelUtils", "Failed to get package status, biz=" + r1);
        return null;
    L18:
        ResultKt.throwOnFailure(r5);
        ConcurrentHashMap<String, Pair<PackageResource, IBaseModel>> r39 = c;
        if (r39.containsKey(r1) == true) goto L21;
        AIKernelUtils$c r40 = new AIKernelUtils$c(r1, r2, null);
        r6.f7341a = r0;
        r6.f7342b = r1;
        r6.c = r2;
        r32 = r20;
        r6.e = r32;
        r6.h = 1;
        r33 = da.b(5000, r40, r6);
        if (r33 != r8) goto L25;
        return r8;
    L21:
        return r39.get(r1);
    L7:
        r6 = new AIKernelUtils$a(r0, r4);
        goto L8
    }

    public final synchronized void a(Context r3, long r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r5, "context");     // Catch: Throwable -> L11
        if (f7368b == false) goto L8;
        com.obric.cae.log.a.c("AIKernelUtils", "SDK already initialized, no need to init again");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        AIKernelConfig r6 = new AIKernelConfig.Builder(r5).appId(r4).build();     // Catch: Throwable -> L11
        AIKernelManager.INSTANCE.init(r6);     // Catch: Throwable -> L11
        f7368b = true;     // Catch: Throwable -> L11
        com.obric.cae.log.a.c("AIKernelUtils", "SDK initialized successfully");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "biz");     // Catch: Throwable -> L6
        boolean r3 = c.containsKey(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }
}
