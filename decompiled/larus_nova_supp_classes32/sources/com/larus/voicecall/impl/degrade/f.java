package com.larus.voicecall.impl.degrade;

import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.platform.api.d3;
import com.larus.platform.model.NotificationType;
import com.larus.reach.api.ReachService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.voicecall.impl.degrade.bean.QuotaCtaResult;
import com.larus.voicecall.impl.degrade.bean.QuotaInfo;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.n3;
import kotlin.Result;
import kotlin.ResultKt;
import ns9.u;
import uz8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ QuotaInfo a;

    public /* synthetic */ f(QuotaInfo r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QuotaInfo r0 = this.a;
        ReachService r2 = (ReachService) ServiceManager.get().getService(ReachService.class);
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.h("realtime_call_quota") != true) goto L7;
    L8:
        u r4 = null;
        if (r3 == false) goto L25;
        h.a.getClass();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L16
        ReachService r6 = (ReachService) ServiceManager.get().getService(ReachService.class);     // Catch: Throwable -> L16
        if (r6 == null) goto L14;
        r4 = r6.a(h.a(r0));     // Catch: Throwable -> L16
    L14:
        Object r1 = Result.constructor-impl(Boolean.valueOf(r4 instanceof u.a));     // Catch: Throwable -> L16
    L18:
        Throwable r7 = Result.exceptionOrNull-impl(r1);
        if (r7 == null) goto L21;
        FLogger.a.e("RealtimeCallQuota", "submitReachQuotaBanner failed", r7);
    L21:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L24;
        r1 = r8;
    L24:
        ((Boolean) r1).booleanValue();
        return;
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L25:
        h.a.getClass();
        NotificationType r10 = NotificationType.QUOTA_LIMIT;
        if (r0 == null) goto L33;
        QuotaCtaResult r11 = r0.getCtaResult();
        if (r11 == null) goto L33;
        String r12 = r11.getCtaGuideTitle();
        if (r12 == null) goto L33;
        String r13 = r12;
    L34:
        if (r0 == null) goto L41;
        QuotaCtaResult r14 = r0.getCtaResult();
        if (r14 == null) goto L41;
        String r15 = r14.getGuideContent();
        if (r15 == null) goto L41;
        String r16 = r15;
    L42:
        if (r0 == null) goto L49;
        QuotaCtaResult r17 = r0.getCtaResult();
        if (r17 == null) goto L49;
        String r18 = r17.getImageUrl();
        if (r18 == null) goto L49;
        String r19 = r18;
    L50:
        if (r0 == null) goto L54;
        QuotaCtaResult r20 = r0.getCtaResult();
        if (r20 == null) goto L54;
        long r21 = r20.getDisplayDurationMSec();
    L55:
        d3.a.c(new n3(null, r19, r13, r16, r10, r21, "realtime_call", null, new g(r0), null, null, null, null, null, false, null, ObricFeatureServiceDelegate.b.c(), null, 785665));
        if (r0 == null) goto L60;
        QuotaCtaResult r22 = r0.getCtaResult();
        if (r22 == null) goto L60;
        String r23 = r22.getActionUrl();
    L61:
        if (r23 == null) goto L96;
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r24 = ICommerceMembershipService.a.a();
        if (r24 == null) goto L66;
        c r25 = r24.z(r23);
    L67:
        ICommerceMembershipService r26 = ICommerceMembershipService.a.a();
        if (r26 == null) goto L95;
        if (r25 == null) goto L71;
        String r27 = r25.a;
    L73:
        if (o0.d(r27) == false) goto L77;
        if (r25 == null) goto L76;
        String r28 = r25.a;
    L79:
        if (r25 == null) goto L81;
        String r29 = r25.b;
    L82:
        if (r25 == null) goto L84;
        String r30 = r25.c;
    L85:
        if (r25 == null) goto L87;
        String r31 = r25.d;
    L88:
        if (r25 == null) goto L90;
        r4 = r25.f;
    L90:
        ICommerceMembershipService.b.b(r26, r28, "chat", r29, r30, r31, r4, null, null, null, null, null, null, 4032);
        return;
    L87:
        r31 = null;
        goto L88
    L84:
        r30 = null;
        goto L85
    L81:
        r29 = null;
        goto L82
    L76:
        r28 = null;
        goto L79
    L77:
        r28 = "in_app_push";
        goto L79
    L71:
        r27 = null;
        goto L73
    L95:
        return;
    L66:
        r25 = null;
        goto L67
    L96:
        return;
    L60:
        r23 = null;
    L54:
        r21 = 3000;
    L49:
        r19 = NameKeys.UnloadStrategy_No_Strategy;
    L41:
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L33:
        r13 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        r3 = false;
        goto L8
    }
}
