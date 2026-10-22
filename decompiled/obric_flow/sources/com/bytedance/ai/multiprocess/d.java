package com.bytedance.ai.multiprocess;

import android.app.Application;
import android.content.Intent;
import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f2406a;

    public static Object a(Application r10, Continuation r11) {
        a r5 = f2406a;
        if (r5 == null) goto L26;
        if (r5.f2400a != null) goto L8;
        Object r12 = Unit.INSTANCE;
    L21:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        return r12;
    L24:
        return Unit.INSTANCE;
    L8:
        if (r5.f2402c == false) goto L10;
        r12 = Unit.INSTANCE;
        goto L21
    L10:
        final l r13 = new l(1, IntrinsicsKt.intercepted(r11));
        r13.w();
        String r14 = r10.getPackageName() + ".AISDK_INIT_ACTION";
        Intent r15 = new Intent(r14);
        String r16 = com.lynx.tasm.behavior.utils.d.c("sendOrderedBroadcast===", r14, "AIManager");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L13;
        r17.d("AIManager", r16);
    L13:
        r10.sendOrderedBroadcast(r15, "com.bytedance.ai.process.INIT_BROADCAST_ACCESS", new AISDKMultiProcessServiceImpl$restoreUseCountIfNeeded$2$1(r13), null, 0, null, null);
        r12 = r13.v();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L17:
        if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        r12 = Unit.INSTANCE;
        goto L21
    L26:
        return Unit.INSTANCE;
    }

    public static Object b(String r10, String r11, AIPackage.AIPackageType r12, Continuation r13) {
        a r5 = f2406a;
        if (r5 != null) goto L5;
        return null;
    L5:
        return BuildersKt.withContext(Dispatchers.getIO(), new AISDKMultiProcessServiceImpl$loadFallbackAIPackage$2(r5, r10, r11, r12, null), r13);
    }
}
