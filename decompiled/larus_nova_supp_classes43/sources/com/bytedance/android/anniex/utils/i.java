package com.bytedance.android.anniex.utils;

import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.n;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.strategy.StrategyCalculateHandler;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static final boolean a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Lazy r0 = ArgusGlobalDelegate.c;
        ArgusGlobalDelegate r1 = ArgusGlobalDelegate.a.a();
        if (r1 != null) goto L6;
        return true;
    L6:
        com.bytedance.ies.argus.api.params.a r11 = new com.bytedance.ies.argus.api.params.a(r10);
        Intrinsics.checkNotNullParameter(r11, "params");
        BaseEventCenter.b r12 = new BaseEventCenter.b(r1.b, ArgusGlobalAspect.ABOUT_TO_REQUEST_LYNX_SSR_URL, r11);
        Lazy r13 = ArgusConfigManager.j;
        if (ArgusConfigManager.a.a().a(r12.a, r12.getContext().b()) == false) goto L10;
        int r14 = com.bytedance.ies.argus.base.d.a;
        com.bytedance.ies.argus.base.d.c("BaseEventCenter", "argusBizId " + r12.getContext().b() + ", aspect: " + r12.a.getStringValue() + " is disabled by recovery.");
        com.bytedance.ies.argus.bean.k r15 = new com.bytedance.ies.argus.bean.k();
        com.bytedance.ies.argus.bean.i.i(r15, ArgusCommonVerifyReason.ASPECT_DISABLE_BY_RECOVERY, null, 6);
    L29:
        return r15.d();
    L10:
        if (r12.getContext().d() != null) goto L13;
        r15 = r12.b();
        com.bytedance.ies.argus.bean.i.i(r15, ArgusCommonVerifyReason.ASPECT_CONFIG_IS_NULL, null, 6);
        goto L29
    L13:
        if (r12.getContext().e().b == true) goto L15;
        r15 = r12.b();
        com.bytedance.ies.argus.bean.i.i(r15, ArgusCommonVerifyReason.ASPECT_IS_OFF, null, 6);
        goto L29
    L15:
        long r16 = System.currentTimeMillis();
        r12.getContext().e = false;
        AspectContext r17 = r12.getContext();
        AspectContext.Companion.TraceType r18 = AspectContext.Companion.TraceType.ASPECT_VERIFY;
        r17.h(r18, AspectContext.Companion.TraceStage.START, null);
        AspectContext r19 = r12.getContext();
        r12.b();
        StrategyCalculateHandler r20 = r1.a;
        int r21 = StrategyCalculateHandler.c;
        r20.a(r19, null);
        if (r12.d == false) goto L24;
        ConcurrentHashMap r22 = r12.e.f;
        n r23 = r12.a;
        Object r24 = r22.get(r23);
        if (r24 != null) goto L23;
        r24 = new CopyOnWriteArrayList();
        Object r25 = r22.putIfAbsent(r23, r24);
        if (r25 == null) goto L23;
        r24 = r25;
    L23:
        ((CopyOnWriteArrayList) r24).add(r12.getContext());
    L24:
        r12.getContext().h(r18, AspectContext.Companion.TraceStage.END, null);
        BaseEventCenter.b.a(r12, null);
        com.bytedance.ies.argus.bean.k r26 = r12.b();
        r12.getContext().f().a("trigger_time", Long.valueOf(r16));
        Function1 r27 = r12.e.g;
        if (r27 == null) goto L27;
        r27.invoke(r12.getContext());
    L27:
        r15 = r26;
        goto L29
    }
}
