package com.larus.dora.impl.feedback;

import android.net.Network;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.transfer.DoraDeviceLinkType;
import com.bytedance.dora.transfer.DoraTransferDirection;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.log.DoraLogManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l {
    public final DoraGFeedbackViewModel a;
    public final StateFlowImpl b;
    public final b1 c;
    public String d;
    public String e;
    public boolean f;
    public x39.b g;
    public Job h;

    public l(DoraGFeedbackViewModel r4) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.a = r4;
        StateFlowImpl r0 = j1.a(LogState.IDLE);
        this.b = r0;
        this.c = kotlinx.coroutines.flow.e.b(r0);
        this.e = "";
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0, new DoraFeedbackLog$setupStateLogging$1(null)), ViewModelKt.getViewModelScope(r4));
    }

    public static final Object a(l r11, Continuation r12) {
        r11.getClass();
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r12), 1);
        r0.C();
        String r1 = vk4.e.d.a.c();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        j r7 = new j(r0, r11);
        OkHttpClient r13 = qk4.n.a;
        String r8 = "http://" + r1 + "/log";
        Request r14 = new Request.Builder().url(r8).build();
        long r3 = System.currentTimeMillis();
        StringBuilder r2 = new StringBuilder();
        r2.append(qk4.n.a());
        r2.append(File.separator);
        String r4 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        DoraDevice r5 = kj4.a.g().c();
        if (r5 == null) goto L8;
        String r6 = "G_" + r4 + "_" + r5.sn + "_" + r5.softVersion + ".zip";
    L9:
        r2.append(r6);
        String r9 = r2.toString();
        pk4.j.a("DoraVisionUtils", "takeVisionLogs: " + r8 + " -> " + r9);
        Network r10 = vk4.a.a;
        if (r10 != null) goto L12;
        pk4.j.d("DoraVisionUtils", "takeVisionLogs: cacheNetwork is null");
        OkHttpClient r15 = qk4.n.b;
        DoraDeviceLinkType r16 = DoraDeviceLinkType.WIFI_P2P;
    L13:
        ok4.e r17 = ok4.b.a.a;
        r15.newCall(r14).enqueue(new qk4.o(r3, r17, r17.c(r16, ok4.a.e, DoraTransferDirection.UPLINK), r7, r8, r9));
        Object r18 = r0.B();
        if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L16:
        return r18;
    L12:
        pk4.j.d("DoraVisionUtils", "takeVisionLogs: cacheNetwork is ok");
        r15 = qk4.n.b.newBuilder().socketFactory(r10.getSocketFactory()).dns(new qk4.m(r10)).build();
        r16 = DoraDeviceLinkType.WIFI_SOFT_AP;
        goto L13
    L8:
        r6 = "G_" + r4 + ".zip";
        goto L9
    }

    public static final Object b(l r9, String r10, Continuation r11) {
        r9.getClass();
        kotlinx.coroutines.j r12 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r11), 1);
        r12.C();
        PolarisFileWrapper r0 = new PolarisFileWrapper(r10);
        if (r0.exists() == false) goto L5;
        int r1 = (int) r0.length();
    L6:
        if (r1 == 0) goto L8;
    L11:
        System.currentTimeMillis();
        xs3.a r2 = new xs3.a();
        String r3 = com.larus.platform.service.o.a.getDeviceId();
        pk4.j.d("DoraGFeedbackViewModel", "upload log filePath " + r10);
        r2.c(String.valueOf(AppHost.a.getAppId()), r3, "dora_g_log", CollectionsKt.listOf(r10), "feedback", null, new k(r12));
        Object r13 = r12.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L15:
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r13;
    L18:
        return Unit.INSTANCE;
    L8:
        if (r0.exists() == false) goto L10;
        r0.delete();
    L10:
        DoraLogManager.a.u(false, "fileSize is 0");
        Result.Companion r4 = Result.Companion;
        r12.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IOException("fileSize is 0"))));
        goto L11
    L5:
        r1 = 0;
        goto L6
    }
}
