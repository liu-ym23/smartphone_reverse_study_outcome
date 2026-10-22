package com.larus.voicecall.impl.degrade;

import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.reach.api.ReachClickTarget;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachPresentationCapability;
import com.larus.reach.api.ReachPresentationCapabilityProvider;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.utils.o0;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ns9.t;
import uz8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0006*\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/voicecall/impl/degrade/RealtimeCallQuotaReachSceneHandler;", "Lcom/larus/reach/api/ReachSceneLifecycleListener;", "Lcom/larus/reach/api/ReachPresentationCapabilityProvider;", "<init>", "()V", "pushScene", NameKeys.UnloadStrategy_No_Strategy, "getPushScene", "()Ljava/lang/String;", "requiredCapabilities", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/reach/api/ReachPresentationCapability;", "request", "Lcom/larus/reach/api/ReachRequest;", "onShow", NameKeys.UnloadStrategy_No_Strategy, "onClick", LynxTouchEvent.EVENT_CLICK, "Lcom/larus/reach/api/ReachClickEvent;", "actionUrl", "mobShowSubsGuidance", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallQuotaReachSceneHandler implements ReachSceneLifecycleListener, ReachPresentationCapabilityProvider {
    public final String a;

    public RealtimeCallQuotaReachSceneHandler() {
        this.a = "realtime_call_quota";
    }

    public final String a() {
        return this.a;
    }

    public final void b(t r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
    }

    public final Set<ReachPresentationCapability> e(t r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        if (ObricFeatureServiceDelegate.b.c() == false) goto L6;
        return SetsKt.setOf(ReachPresentationCapability.APPLICATION_OVERLAY);
    L6:
        return SetsKt.emptySet();
    }

    public final void g(t r17) {
        Intrinsics.checkNotNullParameter(r17, "request");
        String r0 = (String) r17.e.a.get("action_url");
        String r1 = null;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        if (r0 == null) goto L40;
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r2 = ICommerceMembershipService.a.a();
        if (r2 == null) goto L13;
        c r3 = r2.z(r0);
    L14:
        ICommerceMembershipService r4 = ICommerceMembershipService.a.a();
        if (r4 == null) goto L39;
        if (r3 == null) goto L18;
        String r5 = r3.a;
    L20:
        if (o0.d(r5) == false) goto L24;
        if (r3 == null) goto L23;
        String r6 = r3.a;
    L26:
        if (r3 == null) goto L28;
        String r7 = r3.b;
    L29:
        if (r3 == null) goto L31;
        String r8 = r3.c;
    L32:
        if (r3 == null) goto L34;
        String r9 = r3.d;
    L35:
        if (r3 == null) goto L37;
        r1 = r3.f;
    L37:
        ICommerceMembershipService.b.b(r4, r6, "chat", r7, r8, r9, r1, null, null, null, null, null, null, 4032);
        return;
    L34:
        r9 = null;
        goto L35
    L31:
        r8 = null;
        goto L32
    L28:
        r7 = null;
        goto L29
    L23:
        r6 = null;
        goto L26
    L24:
        r6 = "in_app_push";
        goto L26
    L18:
        r5 = null;
        goto L20
    L39:
        return;
    L13:
        r3 = null;
        goto L14
    L40:
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        goto L7
    }

    public final void d(t r2, ReachCloseReason r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "reason");
    }

    public final void f(t r2, ReachRejectReason r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "reason");
    }

    public final void h(t r3, ns9.e r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, LynxTouchEvent.EVENT_CLICK);
        if (r4.a == ReachClickTarget.CARD) goto L5;
        return;
    L5:
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r5 = ICommerceMembershipService.a.a();
        if (r5 == null) goto L17;
        String r6 = (String) r3.e.a.get("action_url");
        if (r6 != null) goto L10;
    L12:
        r6 = null;
    L13:
        if (r6 != null) goto L15;
        return;
    L15:
        r5.w(r6, null);
        return;
    L10:
        if ((!StringsKt.isBlank(r6)) == false) goto L12;
    }

    public final void c(t r1, ns9.e r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "request");
        Intrinsics.checkNotNullParameter(r2, LynxTouchEvent.EVENT_CLICK);
    }
}
