package com.obric.aee;

import android.os.Bundle;
import com.bytedance.crash.event.EnsureReportData;
import com.obric.aee.impl.EngineBridge;
import com.obric.aee.impl.EngineConfig;
import com.obric.aee.impl.HostExtension;
import com.obric.aee.impl.InvokeUtils;
import com.obric.pap.base.PythonHost;
import com.obric.pap.base.PythonRes;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import y6.b;

/* JADX INFO: loaded from: classes2.dex */
public final class ExecutionEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutionEngine f4305a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile EngineConfig f4306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f4307c;

    static {
        f4305a = new ExecutionEngine();
        f4307c = "ExecutionEngine";
    }

    private ExecutionEngine() {
    }

    public static final /* synthetic */ String a() {
        return f4307c;
    }

    public final String b() {
        return HostExtension.INSTANCE.tracebackPython(true);
    }

    public final void c(boolean r10) {
        if (PythonHost.f7778a.isInitialized() == false) goto L7;
        InvokeUtils.INSTANCE.enableVerifySo(r10);
        return;
    L7:
        throw new IllegalStateException("enableCheckSo must be called after PythonHost is initialized.");
    }

    public final Object d(final a r18, Continuation<? super Unit> r19) {
        ExecutionEngine r10 = this;
        if ((r19 instanceof ExecutionEngine$init$1) == false) goto L7;
        ExecutionEngine$init$1 r11 = (ExecutionEngine$init$1) r19;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 != 1) goto L17;
        File r16 = (File) r11.L$2;
        EngineConfig r17 = (EngineConfig) r11.L$1;
        ExecutionEngine r20 = (ExecutionEngine) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
    L40:
        return Unit.INSTANCE;
    L14:
        th = th;
        final File r110 = r16;
        r10 = r20;
    L43:
        monitor-enter(r10);
    L51:
        th = move-exception;
        throw th;
    L45:
        if (f4306b != r17) goto L47;
        f4306b = null;     // Catch: Throwable -> L51
    L47:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L51
        monitor-exit(r10);
        z6.a.f13800a.b(r17, r110, th);
        throw new KotlinNothingValueException();
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        monitor-enter(this);
    L56:
        th = move-exception;
        throw th;
    L21:
        if (f4306b != null) goto L55;
        f4306b = new EngineConfig(r18, new ExecutionEngine$init$2$1(EngineBridge.INSTANCE));     // Catch: Throwable -> L56
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L56
        monitor-exit(this);
        final long r23 = System.currentTimeMillis();
        final EngineConfig r24 = f4306b;
        if (r24 != null) goto L27;
        return r22;
    L27:
        final Map<String, String> r111 = r24.getGlobalConfig();
        if (r111.get("tracing_memory") == null) goto L30;
        boolean r25 = true;
    L31:
        r110 = new File(r18.c(), "APHOME");
        HostExtension r112 = HostExtension.INSTANCE;     // Catch: Throwable -> L41
        if (r25 == false) goto L35;
        boolean r26 = true;
    L36:
        final boolean r113 = r26;
        Function0<Unit> r114 = new ExecutionEngine$init$3(r24, r23, r110, r113, r18, r111);     // Catch: Throwable -> L41
        r11.L$0 = r10;     // Catch: Throwable -> L41
        r11.L$1 = r24;     // Catch: Throwable -> L41
        r11.L$2 = r110;     // Catch: Throwable -> L41
        r11.label = 1;     // Catch: Throwable -> L41
        if (r112.d(r114, r11) != r14) goto L40;
        return r14;
    L35:
        r26 = false;
    L41:
        th = th;
        r17 = r24;
        goto L43
    L30:
        r25 = false;
        goto L31
    L55:
        throw new IllegalStateException("Engine has been initialized.");     // Catch: Throwable -> L56
    L7:
        r11 = new ExecutionEngine$init$1(r10, r19);
        goto L8
    }

    public final void e(a r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        File r11 = new File(r10.c(), "APHOME");
        EngineConfig r12 = new EngineConfig(r10, ExecutionEngine$initRes$cfg$1.INSTANCE);
        r12.logI(f4307c, "Engine=> init Res in single step.");
        int r13 = 0;
    L4:
        if (r13 >= 2) goto L17;
        z6.a.f13800a.a(r12, r11);     // Catch: Throwable -> L9
        PythonRes.f7779a.a(r12.getContext(), r11, r12.getAdditionalAssetsHash(), r12);     // Catch: Throwable -> L9
        if (r13 <= 0) goto L8;
        r12.logI(f4307c, "Engine=> init Res retry succeeded on attempt " + (r13 + 1) + '.');     // Catch: Throwable -> L9
        return;
    L8:
        return;
    L9:
        th = move-exception;
        if (r13 != 0) goto L15;
        PythonRes.f7779a.b(r11, r12);
        String r14 = f4307c;
        StringBuilder r15 = new StringBuilder();
        r15.append("Engine=> init Res failed on attempt 1, retry once: ");
        String r16 = th.getMessage();
        if (r16 != null) goto L14;
        r16 = th.getClass().getSimpleName();
    L14:
        r15.append(r16);
        r12.logW(r14, r15.toString());
        r13 = r13 + 1;
        goto L4
    L15:
        z6.a.f13800a.b(r12, r11, th);
        throw new KotlinNothingValueException();
    }

    public final void f(Object r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "inst");
        Intrinsics.checkNotNullParameter(r13, "prefix");
        Method[] r11 = r12.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(r11, "inst::class.java.declaredMethods");
        int r10 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L37;
        Method r15 = r11[r14];
        Annotation[] r16 = r15.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(r16, "method.annotations");
        ArrayList r17 = new ArrayList();
        int r18 = r16.length;
        int r19 = 0;
    L5:
        if (r19 >= r18) goto L10;
        Annotation r20 = r16[r19];
        if ((r20 instanceof com.obric.aee.utils.a) == false) goto L9;
        r17.add(r20);
    L9:
        r19 = r19 + 1;
        goto L5
    L10:
        com.obric.aee.utils.a r21 = (com.obric.aee.utils.a) CollectionsKt.firstOrNull(r17);
        if (r21 == null) goto L36;
        boolean r22 = true;
        r15.setAccessible(true);
        String r23 = r21.name();
        if (r23.length() != 0) goto L15;
        boolean r24 = true;
    L16:
        if (r24 == false) goto L19;
        r23 = r15.getName();
    L19:
        if (r13.length() <= 0) goto L21;
        boolean r25 = true;
    L22:
        if (r25 == false) goto L24;
        r23 = r13 + '.' + r23;
    L24:
        Parameter[] r26 = r15.getParameters();
        Intrinsics.checkNotNullExpressionValue(r26, "method.parameters");
        if (r26.length == 0) goto L29;
        r22 = false;
    L29:
        if (r22 == true) goto L34;
        Parameter[] r27 = r15.getParameters();
        Intrinsics.checkNotNullExpressionValue(r27, "method.parameters");
        if (Intrinsics.areEqual(((Parameter) ArraysKt.last(r27)).getType(), Continuation.class) == false) goto L34;
        InvokeUtils r28 = InvokeUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r23, "key");
        Intrinsics.checkNotNullExpressionValue(r15, EnsureReportData.METHOD);
        CoroutineDispatcher r29 = r21.runIn().asDispatcher();
    L35:
        r28.l(r23, r15, r12, r29, r21.timeout(), true);
    L34:
        r28 = InvokeUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r23, "key");
        Intrinsics.checkNotNullExpressionValue(r15, EnsureReportData.METHOD);
        r29 = null;
        goto L35
    L21:
        r25 = false;
        goto L22
    L15:
        r24 = false;
    L36:
        r14 = r14 + 1;
        goto L3
    }

    public final Object g(b r10, Bundle r11, String r12, Bundle r13, Continuation<? super Bundle> r14) {
        if (StringsKt.startsWith$default(r12, '_', false, 2, null) == true) goto L7;
        return EngineBridge.INSTANCE.runPackage(r10, r11, r12, r13, r14);
    L7:
        throw new IllegalArgumentException("event start with _ is reserved.");
    }

    public final Object h(b r10, Bundle r11, Function2<? super Bundle, ? super Boolean, Unit> r12, String r13, Bundle r14, Continuation<? super Unit> r15) {
        if (StringsKt.startsWith$default(r13, '_', false, 2, null) == true) goto L10;
        Object r16 = EngineBridge.INSTANCE.runPackageSteaming(r10, r11, r13, r14, r12, r15);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r16;
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalArgumentException("event start with _ is reserved.");
    }

    public final Object i(b r10, Continuation<? super Unit> r11) {
        Object r12 = EngineBridge.INSTANCE.stopService(r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }
}
