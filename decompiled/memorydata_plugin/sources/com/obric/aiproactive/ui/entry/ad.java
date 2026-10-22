package com.obric.aiproactive.ui.entry;

import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000\u001a&\u0010\f\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000\u001a \u0010\r\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000\"\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"updatePendingStartupInspiration", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;", "currentState", "inspirationId", "", "resolveStartupInspirationFromNow", "Lcom/obric/aiproactive/ui/entry/StartupInspirationTransition;", "batchId", "", "recommendations", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "resolveStartupInspirationFromAllToday", "isInspirationInList", "", "STARTUP_FLOW_TAG", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ad {
    public static final ac a(ac r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "currentState");
        String r0 = null;
        if (r14 == null) goto L5;
        String r15 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if ((!r3) == false) goto L16;
        r0 = r15;
    L16:
        if (r0 != null) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[StartupFlow] clearPendingStartupInspiration requestId=" + r13.a() + " stage=" + r13.c(), false, 4, null);
        return ac.a(r13, 0, null, StartupInspirationStage.IDLE, 1, null);
    L19:
        long r4 = r13.a() + 1;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[StartupFlow] updatePendingStartupInspiration requestId=" + r4 + " inspirationId=" + r0 + " oldStage=" + r13.c(), false, 4, null);
        return new ac(r4, r0, StartupInspirationStage.WAITING_NOW);
    L9:
        if (StringsKt.isBlank(r2) == true) goto L12;
        r3 = false;
        goto L14
    L5:
        r15 = null;
        goto L6
    }

    public static final af a(ac r11, long r12, List<ProactiveRecommendationDto> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "currentState");
        Intrinsics.checkNotNullParameter(r15, "recommendations");
        if (r11.c() == StartupInspirationStage.WAITING_NOW) goto L7;
        RunLog.INSTANCE.debug("ProactiveUI", "[StartupFlow] ignoreNowResolution requestId=" + r11.a() + " stage=" + r11.c() + " batchId=" + r12);
        return new af(r11, (ae) ZeusTransformUtils.preCheckCast(ae.a.f6604a, ae.class, "com.obric.memorydata.plugin"));
    L7:
        if (r12 > 0) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[StartupFlow] waitNowValidBatch requestId=" + r11.a() + " inspirationId=" + r11.b() + " batchId=" + r12, false, 4, null);
        return new af(r11, (ae) ZeusTransformUtils.preCheckCast(ae.a.f6604a, ae.class, "com.obric.memorydata.plugin"));
    L10:
        String r0 = r11.b();
        if (a(r0, r15) == false) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[StartupFlow] resolveNowMatched requestId=" + r11.a() + " inspirationId=" + r0 + " batchId=" + r12, false, 4, null);
        ac r13 = ac.a(r11, 0, null, StartupInspirationStage.COMPLETED, 1, null);
        if (r0 != null) goto L16;
        r0 = "";
    L16:
        return new af(r13, (ae) ZeusTransformUtils.preCheckCast(new ae.b(r0), ae.class, "com.obric.memorydata.plugin"));
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[StartupFlow] resolveNowFallbackToAll requestId=" + r11.a() + " inspirationId=" + r0 + " batchId=" + r12 + " candidateSize=" + r15.size(), false, 4, null);
        return new af(ac.a(r11, 0, null, StartupInspirationStage.WAITING_ALL, 3, null), (ae) ZeusTransformUtils.preCheckCast(ae.c.f6606a, ae.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean a(String r3, List<ProactiveRecommendationDto> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "recommendations");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if (Intrinsics.areEqual(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r0, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getInspirationId(), r3) == false) goto L4;
    L9:
        if (r0 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r0 = null;
        goto L9
    }

    public static final af b(ac r11, long r12, List<ProactiveRecommendationDto> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "currentState");
        Intrinsics.checkNotNullParameter(r15, "recommendations");
        if (r11.c() == StartupInspirationStage.WAITING_ALL) goto L7;
        RunLog.INSTANCE.debug("ProactiveUI", "[StartupFlow] ignoreAllResolution requestId=" + r11.a() + " stage=" + r11.c() + " batchId=" + r12);
        return new af(r11, (ae) ZeusTransformUtils.preCheckCast(ae.a.f6604a, ae.class, "com.obric.memorydata.plugin"));
    L7:
        if (r12 > 0) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[StartupFlow] waitAllValidBatch requestId=" + r11.a() + " inspirationId=" + r11.b() + " batchId=" + r12, false, 4, null);
        return new af(r11, (ae) ZeusTransformUtils.preCheckCast(ae.a.f6604a, ae.class, "com.obric.memorydata.plugin"));
    L10:
        String r0 = r11.b();
        if (a(r0, r15) == false) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[StartupFlow] resolveAllMatched requestId=" + r11.a() + " inspirationId=" + r0 + " batchId=" + r12, false, 4, null);
        ac r13 = ac.a(r11, 0, null, StartupInspirationStage.COMPLETED, 1, null);
        if (r0 != null) goto L18;
        r0 = "";
    L18:
        return new af(r13, (ae) ZeusTransformUtils.preCheckCast(new ae.b(r0), ae.class, "com.obric.memorydata.plugin"));
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[StartupFlow] resolveAllMissed requestId=" + r11.a() + " inspirationId=" + r0 + " batchId=" + r12 + " candidateSize=" + r15.size(), false, 4, null);
        return new af(ac.a(r11, 0, null, StartupInspirationStage.COMPLETED, 1, null), (ae) ZeusTransformUtils.preCheckCast(ae.a.f6604a, ae.class, "com.obric.memorydata.plugin"));
    }
}
