package com.bytedance.android.ec.core.cps;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static final Context m() {
        return ECAppInfoService.e.getApplicationContext();
    }

    public static final String n() {
        Class r1 = a();     // Catch: Throwable -> L9
        Object r10 = r1.getMethod("get", new Class[]{String.class, String.class}).invoke(r1, new Object[]{"wifi.interface", "wlan0"});     // Catch: Throwable -> L9
        if (r10 == null) goto L8;
        return (String) r10;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L9
    L9:
        return "wlan0";
    }

    public static final Object b(Continuation r10) {
        if ((r10 instanceof CyberProtectionCollectorKt$firstInstallTime$1) == false) goto L7;
        CyberProtectionCollectorKt$firstInstallTime$1 r0 = (CyberProtectionCollectorKt$firstInstallTime$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L20
    L19:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$firstInstallTime$2 r15 = new CyberProtectionCollectorKt$firstInstallTime$2(null);     // Catch: Throwable -> L20
        r0.label = 1;     // Catch: Throwable -> L20
        r11 = BuildersKt.withContext(r14, r15, r0);     // Catch: Throwable -> L20
        if (r11 != r12) goto L19;
        return r12;
    L21:
        return null;
    L7:
        r0 = new CyberProtectionCollectorKt$firstInstallTime$1(r10);
        goto L8
    }

    public static final Object c(Continuation r10) {
        if ((r10 instanceof CyberProtectionCollectorKt$getAvailableStorageTotal$1) == false) goto L7;
        CyberProtectionCollectorKt$getAvailableStorageTotal$1 r0 = (CyberProtectionCollectorKt$getAvailableStorageTotal$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L20
    L19:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getAvailableStorageTotal$2 r15 = new CyberProtectionCollectorKt$getAvailableStorageTotal$2(null);     // Catch: Throwable -> L20
        r0.label = 1;     // Catch: Throwable -> L20
        r11 = BuildersKt.withContext(r14, r15, r0);     // Catch: Throwable -> L20
        if (r11 != r12) goto L19;
        return r12;
    L21:
        return null;
    L7:
        r0 = new CyberProtectionCollectorKt$getAvailableStorageTotal$1(r10);
        goto L8
    }

    public static final Object d(Continuation r10) {
        if ((r10 instanceof CyberProtectionCollectorKt$getBatteryCapacity$1) == false) goto L7;
        CyberProtectionCollectorKt$getBatteryCapacity$1 r0 = (CyberProtectionCollectorKt$getBatteryCapacity$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L20
    L19:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getBatteryCapacity$2 r15 = new CyberProtectionCollectorKt$getBatteryCapacity$2(null);     // Catch: Throwable -> L20
        r0.label = 1;     // Catch: Throwable -> L20
        r11 = BuildersKt.withContext(r14, r15, r0);     // Catch: Throwable -> L20
        if (r11 != r12) goto L19;
        return r12;
    L21:
        return null;
    L7:
        r0 = new CyberProtectionCollectorKt$getBatteryCapacity$1(r10);
        goto L8
    }

    public static final Object e(Continuation r10) {
        if ((r10 instanceof CyberProtectionCollectorKt$getBatteryRemaining$1) == false) goto L7;
        CyberProtectionCollectorKt$getBatteryRemaining$1 r0 = (CyberProtectionCollectorKt$getBatteryRemaining$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L20
    L19:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getBatteryRemaining$2 r15 = new CyberProtectionCollectorKt$getBatteryRemaining$2(null);     // Catch: Throwable -> L20
        r0.label = 1;     // Catch: Throwable -> L20
        r11 = BuildersKt.withContext(r14, r15, r0);     // Catch: Throwable -> L20
        if (r11 != r12) goto L19;
        return r12;
    L21:
        return null;
    L7:
        r0 = new CyberProtectionCollectorKt$getBatteryRemaining$1(r10);
        goto L8
    }

    public static final Object f(Continuation r10) {
        if ((r10 instanceof CyberProtectionCollectorKt$getBootId$1) == false) goto L7;
        CyberProtectionCollectorKt$getBootId$1 r0 = (CyberProtectionCollectorKt$getBootId$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L16;
        if (r13 != 1) goto L15;
        Ref.ObjectRef r14 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L23
    L22:
        return (String) r14.element;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r11);
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = null;
        CoroutineDispatcher r16 = Dispatchers.getIO();     // Catch: Throwable -> L24
        CyberProtectionCollectorKt$getBootId$2 r17 = new CyberProtectionCollectorKt$getBootId$2("/proc/sys/kernel/random/boot_id", r15, null);     // Catch: Throwable -> L24
        r0.L$0 = r15;     // Catch: Throwable -> L24
        r0.label = 1;     // Catch: Throwable -> L24
        if (BuildersKt.withContext(r16, r17, r0) != r12) goto L20;
        return r12;
    L20:
        r14 = r15;
    L7:
        r0 = new CyberProtectionCollectorKt$getBootId$1(r10);
        goto L8
    }

    public static final Object g(Continuation r10) {
        if ((r10 instanceof CyberProtectionCollectorKt$getLibCSoHash$1) == false) goto L7;
        CyberProtectionCollectorKt$getLibCSoHash$1 r0 = (CyberProtectionCollectorKt$getLibCSoHash$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L20
    L19:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getLibCSoHash$2 r15 = new CyberProtectionCollectorKt$getLibCSoHash$2(null);     // Catch: Throwable -> L20
        r0.label = 1;     // Catch: Throwable -> L20
        r11 = BuildersKt.withContext(r14, r15, r0);     // Catch: Throwable -> L20
        if (r11 != r12) goto L19;
        return r12;
    L21:
        return null;
    L7:
        r0 = new CyberProtectionCollectorKt$getLibCSoHash$1(r10);
        goto L8
    }

    public static final Object h(Continuation r10) {
        if ((r10 instanceof CyberProtectionCollectorKt$getMac$1) == false) goto L7;
        CyberProtectionCollectorKt$getMac$1 r0 = (CyberProtectionCollectorKt$getMac$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        boolean r14 = true;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        Ref.ObjectRef r15 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L33:
        r15.element = (String) r11;
        Ref.ObjectRef r16 = r15;
    L35:
        return (String) r16.element;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r17 = (Ref.ObjectRef) r0.L$1;
        Ref.ObjectRef r18 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r11);
        Ref.ObjectRef r19 = r17;
        r16 = r18;
    L20:
        r19.element = (String) r11;
        String r20 = (String) r16.element;
        if (r20 != null) goto L23;
    L26:
        if (r14 == false) goto L28;
    L29:
        CoroutineDispatcher r21 = Dispatchers.getIO();
        CyberProtectionCollectorKt$getMac$2 r22 = new CyberProtectionCollectorKt$getMac$2(null);
        r0.L$0 = r16;
        r0.L$1 = null;
        r0.label = 2;
        r11 = BuildersKt.withContext(r21, r22, r0);
        if (r11 == r12) goto L37;
        r15 = r16;
        goto L33
    L37:
        return r12;
    L28:
        if (Intrinsics.areEqual((String) r16.element, "02:00:00:00:00:00") == false) goto L35;
    L23:
        if (StringsKt.isBlank(r20) == true) goto L26;
        r14 = false;
        goto L26
    L16:
        ResultKt.throwOnFailure(r11);
        r16 = new Ref.ObjectRef();
        CoroutineDispatcher r23 = Dispatchers.getIO();
        CyberProtectionCollectorKt$getMac$macAddress$1 r24 = new CyberProtectionCollectorKt$getMac$macAddress$1(null);
        r0.L$0 = r16;
        r0.L$1 = r16;
        r0.label = 1;
        r11 = BuildersKt.withContext(r23, r24, r0);
        if (r11 == r12) goto L36;
        r19 = r16;
        goto L20
    L36:
        return r12;
    L7:
        r0 = new CyberProtectionCollectorKt$getMac$1(r10);
        goto L8
    }

    public static final Object i(Continuation r10) {
        if ((r10 instanceof CyberProtectionCollectorKt$getSignHash$1) == false) goto L7;
        CyberProtectionCollectorKt$getSignHash$1 r0 = (CyberProtectionCollectorKt$getSignHash$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L20
    L19:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getSignHash$2 r15 = new CyberProtectionCollectorKt$getSignHash$2(null);     // Catch: Throwable -> L20
        r0.label = 1;     // Catch: Throwable -> L20
        r11 = BuildersKt.withContext(r14, r15, r0);     // Catch: Throwable -> L20
        if (r11 != r12) goto L19;
        return r12;
    L21:
        return null;
    L7:
        r0 = new CyberProtectionCollectorKt$getSignHash$1(r10);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0197 -> B:74:0x019b). Please report as a decompilation issue!!! */
    public static final Object j(Continuation r27) {
        if ((r27 instanceof CyberProtectionCollectorKt$getStatData$1) == false) goto L7;
        CyberProtectionCollectorKt$getStatData$1 r1 = (CyberProtectionCollectorKt$getStatData$1) r27;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        int r13 = 4;
        if (r12 == 0) goto L24;
        if (r12 == 1) goto L21;
        if (r12 == 2) goto L18;
        if (r12 != 3) goto L17;
        int r14 = r1.I$2;
        int r15 = r1.I$1;
        int r16 = r1.I$0;
        String[] r17 = (String[]) r1.L$4;
        String[] r18 = (String[]) r1.L$3;
        ArrayList r19 = (ArrayList) r1.L$2;
        String[] r20 = (String[]) r1.L$1;
        ArrayList r21 = (ArrayList) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L60
        String[] r110 = r18;
        int r22 = r15;
        String[] r23 = r17;
        Object r111 = null;
        String[] r112 = r20;
        ArrayList r24 = r19;
    L74:
        String r25 = (String) r0;     // Catch: Throwable -> L67
        if (r25 != null) goto L59;
        r25 = "none";
    L59:
        r23[r14] = r25;     // Catch: Throwable -> L67
        r24.add(ArraysKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L67
        int r26 = r16 + 1;     // Catch: Throwable -> L67
        r13 = 4;
    L26:
        if (r26 >= r22) goto L63;
        String r28 = r112[r26];     // Catch: Throwable -> L60
        String[] r29 = new String[3];     // Catch: Throwable -> L60
        String[] r30 = new String[r13];     // Catch: Throwable -> L60
        r30[0] = "stat";     // Catch: Throwable -> L60
        r30[1] = "-c";     // Catch: Throwable -> L60
        r30[2] = "%X";     // Catch: Throwable -> L60
        r30[3] = r28;     // Catch: Throwable -> L60
        r1.L$0 = r21;     // Catch: Throwable -> L60
        r1.L$1 = r28;     // Catch: Throwable -> L60
        r1.L$2 = r112;     // Catch: Throwable -> L60
        r1.L$3 = r21;     // Catch: Throwable -> L60
        r1.L$4 = r29;     // Catch: Throwable -> L60
        r1.L$5 = r29;     // Catch: Throwable -> L60
        r1.I$0 = r26;     // Catch: Throwable -> L60
        r1.I$1 = r22;     // Catch: Throwable -> L60
        r1.I$2 = 0;     // Catch: Throwable -> L60
        r1.label = 1;     // Catch: Throwable -> L60
        Object r31 = BuildersKt.withContext(Dispatchers.getIO(), new CyberProtectionCollectorKt$runShell$2(r30, null), r1);     // Catch: Throwable -> L60
        if (r31 == r11) goto L76;
        String r113 = r28;
        ArrayList r32 = r21;
        r24 = r32;
        int r114 = 0;
        int r33 = r26;
        r0 = r31;
        String[] r34 = r29;
    L34:
        String r35 = (String) r0;     // Catch: Throwable -> L60
        if (r35 != null) goto L37;
        r35 = "none";
    L37:
        r34[r114] = r35;     // Catch: Throwable -> L60
        String[] r36 = new String[r13];     // Catch: Throwable -> L60
        r36[0] = "stat";     // Catch: Throwable -> L60
        r36[1] = "-c";     // Catch: Throwable -> L60
        r36[2] = "%Y";     // Catch: Throwable -> L60
        r36[3] = r113;     // Catch: Throwable -> L60
        r1.L$0 = r32;     // Catch: Throwable -> L60
        r1.L$1 = r113;     // Catch: Throwable -> L60
        r1.L$2 = r112;     // Catch: Throwable -> L60
        r1.L$3 = r24;     // Catch: Throwable -> L60
        r1.L$4 = r29;     // Catch: Throwable -> L60
        r1.L$5 = r29;     // Catch: Throwable -> L60
        r1.I$0 = r33;     // Catch: Throwable -> L60
        r1.I$1 = r22;     // Catch: Throwable -> L60
        r1.I$2 = 1;     // Catch: Throwable -> L60
        r1.label = 2;     // Catch: Throwable -> L60
        r0 = BuildersKt.withContext(Dispatchers.getIO(), new CyberProtectionCollectorKt$runShell$2(r36, null), r1);     // Catch: Throwable -> L60
        if (r0 == r11) goto L76;
        r16 = r33;
        int r37 = 1;
        r21 = r32;
        String[] r38 = r29;
    L44:
        String r39 = (String) r0;     // Catch: Throwable -> L60
        if (r39 != null) goto L47;
        r39 = "none";
    L47:
        r29[r37] = r39;     // Catch: Throwable -> L60
        String[] r40 = {"stat", "-c", "%i", r113};     // Catch: Throwable -> L60
        r1.L$0 = r21;     // Catch: Throwable -> L60
        r1.L$1 = r112;     // Catch: Throwable -> L60
        r1.L$2 = r24;     // Catch: Throwable -> L60
        r1.L$3 = r38;     // Catch: Throwable -> L60
        r1.L$4 = r38;     // Catch: Throwable -> L60
        r1.L$5 = null;     // Catch: Throwable -> L61
        r1.I$0 = r16;     // Catch: Throwable -> L60
        r1.I$1 = r22;     // Catch: Throwable -> L60
        r1.I$2 = 2;     // Catch: Throwable -> L60
        r1.label = 3;     // Catch: Throwable -> L60
        r111 = null;
        r0 = BuildersKt.withContext(Dispatchers.getIO(), new CyberProtectionCollectorKt$runShell$2(r40, null), r1);     // Catch: Throwable -> L67
        if (r0 == r11) goto L76;
        r23 = r38;
        r110 = r23;
        r14 = 2;
    L61:
        r111 = null;
    L62:
        r111 = null;
    L76:
        return r11;
    L63:
        r111 = null;
        return CollectionsKt.joinToString$default(r21, ";", null, null, 0, null, null, 62, null);
    L66:
        return r111;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r41 = r1.I$2;
        r22 = r1.I$1;
        int r42 = r1.I$0;
        r29 = (String[]) r1.L$5;
        String[] r43 = (String[]) r1.L$4;
        ArrayList r115 = (ArrayList) r1.L$3;
        String[] r116 = (String[]) r1.L$2;
        r113 = (String) r1.L$1;
        ArrayList r44 = (ArrayList) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L60
        r37 = r41;
        r38 = r43;
        r24 = r115;
        r112 = r116;
        r16 = r42;
        r21 = r44;
        goto L44
    L21:
        int r45 = r1.I$2;
        r22 = r1.I$1;
        r33 = r1.I$0;
        r34 = (String[]) r1.L$5;
        r29 = (String[]) r1.L$4;
        r24 = (ArrayList) r1.L$3;
        r112 = (String[]) r1.L$2;
        String r117 = (String) r1.L$1;
        ArrayList r118 = (ArrayList) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L60
        r114 = r45;
        r32 = r118;
        r113 = r117;
        goto L34
    L24:
        ResultKt.throwOnFailure(r0);
        r112 = new String[]{"/data/local/tmp", "/sdcard/Download", "/sdcard/Android", "/sdcard/DCIM"};
        r21 = new ArrayList(4);     // Catch: Throwable -> L60
        r26 = 0;
        r22 = 4;
    L60:
        r111 = null;
    L7:
        r1 = new CyberProtectionCollectorKt$getStatData$1(r27);
        goto L8
    }

    public static final Object k(Continuation r10) {
        if ((r10 instanceof CyberProtectionCollectorKt$getStorageTotal$1) == false) goto L7;
        CyberProtectionCollectorKt$getStorageTotal$1 r0 = (CyberProtectionCollectorKt$getStorageTotal$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L15;
        if (r13 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L20
    L19:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getStorageTotal$2 r15 = new CyberProtectionCollectorKt$getStorageTotal$2(null);     // Catch: Throwable -> L20
        r0.label = 1;     // Catch: Throwable -> L20
        r11 = BuildersKt.withContext(r14, r15, r0);     // Catch: Throwable -> L20
        if (r11 != r12) goto L19;
        return r12;
    L21:
        return null;
    L7:
        r0 = new CyberProtectionCollectorKt$getStorageTotal$1(r10);
        goto L8
    }

    public static byte[] l(NetworkInterface r13) {
        f06.c r10 = new f06.c();
        Object[] r11 = new Object[0];
        f06.b r12 = new f06.b();
        f06.d r14 = r10.b(101701, "java/net/NetworkInterface", "getHardwareAddress", r13, r11, "byte[]", r12);
        if (r14.a == false) goto L6;
        r10.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r13, r11, null, r12, false);
        return (byte[]) r14.b;
    L6:
        byte[] r15 = r13.getHardwareAddress();
        r10.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r13, r11, r15, r12, true);
        return r15;
    }
}
