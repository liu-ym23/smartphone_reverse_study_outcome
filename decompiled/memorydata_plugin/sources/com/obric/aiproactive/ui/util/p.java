package com.obric.aiproactive.ui.util;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015Bc\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0012:\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bR&\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0007\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/util/StartupLaunchReportGate;", "", "schedule", "Lkotlin/Function2;", "", "Lkotlin/Function0;", "", "report", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "rawEnterFrom", "startupInspirationId", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "isPending", "", "latestRawEnterFrom", "latestStartupInspirationId", "onForegroundResumed", "onNewIntent", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6896a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<Long, Function0<Unit>, Unit> f6897b;
    private final Function2<String, String, Unit> c;
    private boolean d;
    private String e;
    private String f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/util/StartupLaunchReportGate$Companion;", "", "<init>", "()V", "INTENT_SETTLE_DELAY_MS", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6896a = new a(null);
    }

    public p(Function2<? super Long, ? super Function0<Unit>, Unit> r3, Function2<? super String, ? super String, Unit> r4) {
        Function2<Long, Function0<Unit>, Unit> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Function2<String, String, Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "schedule");
        Intrinsics.checkNotNullParameter(r6, "report");
        this.f6897b = r5;
        this.c = r6;
    }

    private static final Unit a(p r2) {
        if (r2.d == false) goto L5;
        r2.d = false;
        r2.c.invoke(r2.e, r2.f);
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$lpvLGpRakDpn2ENyaOL49SQbXTQ(p r0) {
        return a(r0);
    }

    public final void a(String r3, String r4) {
        this.e = r3;
        this.f = r4;
        if (this.d == false) goto L5;
        return;
    L5:
        this.d = true;
        this.f6897b.invoke(1000L, new $$Lambda$p$lpvLGpRakDpn2ENyaOL49SQbXTQ(this));
    }

    public final void b(String r2, String r3) {
        if (this.d == true) goto L5;
        return;
    L5:
        this.e = r2;
        this.f = r3;
    }
}
