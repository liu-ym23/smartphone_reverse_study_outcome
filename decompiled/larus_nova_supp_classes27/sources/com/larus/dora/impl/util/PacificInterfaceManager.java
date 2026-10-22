package com.larus.dora.impl.util;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.enroll.audio.enroll.IVoiceEnrollService;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraPreWakeUpTask;
import com.larus.utils.y;
import com.obric.assistant.spi.dora.ObricDoraDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class PacificInterfaceManager {
    public static Function1<? super Boolean, Unit> a;
    public static boolean b;
    public static Job c;

    static {
    }

    public static void a(String r6) {
        ILoginService r1 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r1 == null) goto L8;
        q38.a r2 = r1.getAccountInfo();
        if (r2 == null) goto L8;
        String r3 = r2.c;
        if (r3 == null) goto L8;
    L9:
        PolarisFileWrapper r4 = new PolarisFileWrapper(AppHost.a.getApplication().getFilesDir(), "wakeup_sid");
        if (r4.exists() == true) goto L12;
        return;
    L12:
        final String r7 = "sid_feature_" + r3 + '_' + r6 + '_';
        File[] r8 = r4.listFiles(new m0(r7));
        if (r8 == null) goto L22;
        int r5 = r8.length;
        int r9 = 0;
    L15:
        if (r9 >= r5) goto L28;
        r8[r9].delete();     // Catch: Exception -> L19
        g49.d.d("PacificInterfaceManager", "clearFeatureFile success");     // Catch: Exception -> L19
    L21:
        r9 = r9 + 1;
    L19:
        e = move-exception;
        g49.d.b("PacificInterfaceManager", "clearFeatureFile failed: " + e.getMessage());
        goto L21
    L28:
        return;
    L22:
        return;
    L8:
        r3 = "unknown";
        goto L9
    }

    public static void d(final boolean r2) {
        g49.d.d("PacificInterfaceManager", "setModelReady: " + r2);
        b = r2;
        y.c(new o0(r2));
    }

    public static void e(com.larus.dora.impl.settings.voiceprint.e r2) {
        StringBuilder r0 = new StringBuilder("setModelReadyListener: ");
        if (r2 == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        g49.d.d("PacificInterfaceManager", r0.toString());
        a = r2;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static String f(String r1) {
        if (r1 == null) goto L4;
        byte[] r2 = r1.getBytes(StandardCharsets.UTF_8);
    L6:
        return g(r2);
    L4:
        r2 = null;
        goto L6
    }

    public static String g(byte[] r10) {
        if (r10 != null) goto L4;
    L13:
        return null;
    L4:
        if (r10.length != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L13;
        byte[] r1 = MessageDigest.getInstance("SHA-256").digest(r10);     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L11
        return ArraysKt.joinToString$default(r1, "", null, null, 0, null, new n0(), 30, null);
    L11:
        e = move-exception;
        g49.d.c("PacificInterfaceManager", "sha256 error", e);
        goto L13
    L6:
        r0 = false;
        goto L7
    }

    public static boolean c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "mac");
        Intrinsics.checkNotNullParameter(r2, "deviceName");
        String r3 = f(r1);
        if (r3 == null) goto L6;
        r1 = r3;
    L6:
        IVoiceEnrollService r4 = (IVoiceEnrollService) ServiceManager.get().getService(IVoiceEnrollService.class);
        if (r4 == null) goto L9;
        boolean r5 = r4.a(r1);
    L10:
        g49.d.d("PacificInterfaceManager", "getDeviceEnrollStatusLocalCache local:" + r5);
        if (r5 == false) goto L13;
        int r6 = DoraPreWakeUpTask.d;
        DoraPreWakeUpTask.Companion.m();
    L13:
        return r5;
    L9:
        r5 = false;
        goto L10
    }

    public static Object b(String r3, String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PacificInterfaceManager$getDeviceEnrollStatus$2(r3, r4, null), r5);
    }

    public static void h(String r9, String r10, String r11) {
        g49.d.d("PacificInterfaceManager", "updateWakeupFingerPrintModelPath: firstKwsModelPath=" + r9 + ", sidEnrollModelPath=" + r10 + ", silentFilePath=" + r11);
        Job r0 = c;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        c = null;
        boolean r1 = false;
        if (r9 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L29;
        if (r10 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L29;
        if (r11 != null) goto L22;
    L25:
        boolean r6 = true;
    L26:
        if (r6 == false) goto L29;
        d(false);
        return;
    L22:
        if (r11.length() == 0) goto L25;
        r6 = false;
        goto L26
    L15:
        if (r10.length() == 0) goto L18;
        r5 = false;
    L29:
        if (r11 != null) goto L31;
    L32:
        r1 = true;
    L33:
        if (r1 == true) goto L38;
        IVoiceEnrollService.a.getClass();
        IVoiceEnrollService r2 = IVoiceEnrollService.a.a();
        if (r2 == null) goto L37;
        r2.b(r9, r10, r11);
    L37:
        ObricDoraDelegate.b.b(r9, r10, r11);
        d(true);
        return;
    L38:
        g49.d.d("PacificInterfaceManager", "silentFilePath is empty, start retry check");
        c = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PacificInterfaceManager$updateWakeupFingerPrintModelPath$1(r9, r10, null), 3, null);
        return;
    L31:
        if (r11.length() != 0) goto L33;
    L8:
        if (r9.length() == 0) goto L11;
        r4 = false;
        goto L12
    }
}
