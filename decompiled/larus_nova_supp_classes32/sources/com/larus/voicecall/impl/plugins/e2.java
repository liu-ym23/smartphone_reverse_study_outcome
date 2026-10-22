package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.platform.api.d3;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.larus.voicecall.impl.museum.MuseumExtensionDispatcher;
import com.larus.voicecall.impl.plugins.r;
import hq9.e4;
import hq9.n3;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e2<C extends r> extends com.larus.audio.call.arch.a<C> implements z2a.d, f2 {
    public final String f;
    public boolean g;

    public final void b3() {
        VoiceCallServiceDelegate.a.L(this);
        G0("call_release");
        com.larus.voicecall.impl.degrade.h.a.getClass();
        com.larus.voicecall.impl.degrade.h.d = false;
        FLogger.a.i("RealtimeCallQuota", "setCurrentCallAllowVoiceToVideoWithoutSingleQuota allow=false");
    }

    public final void e3() {
        super.e3();
        if (com.larus.voicecall.impl.museum.f.a() == true) goto L6;
        FLogger.a.i("MuseumExtensionDebug", "[plugin][start][ignore] reason=setting_disabled");
        return;
    L6:
        boolean r0 = Intrinsics.areEqual(com.larus.audio.call.util.m.b(getContext().params().q, "app_scene"), "museum");
        com.larus.voicecall.impl.degrade.h.a.getClass();
        com.larus.voicecall.impl.degrade.h.d = r0;
        FLogger r3 = FLogger.a;
        r3.i("RealtimeCallQuota", "setCurrentCallAllowVoiceToVideoWithoutSingleQuota allow=" + r0);
        r3.i("MuseumExtensionDebug", "[quota][voice_to_video] allowWithoutSingleQuota=" + r0 + ", appScene=" + com.larus.audio.call.util.m.b(getContext().params().q, "app_scene"));
        VoiceCallServiceDelegate.a.j(this);
    }

    public final String T2() {
        return this.f;
    }

    public e2(C r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "rcMuseumExtensionPlugin";
    }

    @Override // com.larus.voicecall.impl.plugins.f2
    public final void G0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        if (this.g == true) goto L6;
        FLogger.a.i("MuseumExtensionDebug", "[banner][dismiss][skip] reason=" + r5 + ", shown=false");
        return;
    L6:
        this.g = false;
        CopyOnWriteArrayList<z2a.d> r1 = MuseumExtensionDispatcher.a;
        Intrinsics.checkNotNullParameter(r5, "reason");
        FLogger.a.i("MuseumExtensionDebug", "[banner][dismiss] reason=".concat(r5));
        d3.a.d();
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [com.larus.voicecall.impl.plugins.a2, kotlin.jvm.functions.Function0] */
    @Override // z2a.d
    public final void J1(z2a.c r35) {
        Intrinsics.checkNotNullParameter(r35, "notification");
        if (com.larus.voicecall.impl.museum.f.a() == true) goto L6;
        FLogger.a.i("MuseumExtensionDebug", "[cmd][plugin][ignore] reason=setting_disabled");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r35, "<this>");
        final com.larus.voicecall.impl.museum.a r2 = new com.larus.voicecall.impl.museum.a(r35.a, r35.b, r35.c, r35.d, r35.e, r35.f, r35.g, r35.h, r35.i, r35.j);
        FLogger r1 = FLogger.a;
        r1.i("MuseumExtensionDebug", "[cmd][plugin][parsed] stage=" + r2.e + ", museum=" + r2.d + ", callId=" + getContext().params().e + ", roomId=" + getContext().params().d);
        if (Intrinsics.areEqual(r2.e, "hangup") == false) goto L10;
        r1.i("MuseumExtensionDebug", "[cmd][plugin][ignore] hangup stage should not show in call");
        return;
    L10:
        CopyOnWriteArrayList<z2a.d> r4 = MuseumExtensionDispatcher.a;
        final boolean r11 = Intrinsics.areEqual(r2.e, "no_quota");
        final ?? r12 = new a2(this);
        final Function1 r8 = new b2(this);
        final Function2 r9 = new c2(this);
        Function0 r15 = new d2(this, r2);
        Intrinsics.checkNotNullParameter(r2, "banner");
        Intrinsics.checkNotNullParameter("cmd", "showReason");
        if (com.larus.voicecall.impl.museum.f.a() == true) goto L13;
        r1.i("MuseumExtensionDebug", "[banner][show][ignore] stage=" + r2.e + ", reason=setting_disabled");
        boolean r5 = false;
        String r7 = ", shown=";
    L25:
        this.g = r5;
        r1.i("MuseumExtensionDebug", "[banner][shown_state] stage=" + r2.e + r7 + this.g + ", reason=cmd");
        return;
    L13:
        String r13 = "museum_extension_" + r2.e;
        String r10 = r2.c;
        String r6 = r2.a;
        String r14 = r2.b;
        if (Intrinsics.areEqual(r2.e, "no_quota") == false) goto L16;
        long r19 = 2147483647L;
    L18:
        if (Intrinsics.areEqual(r2.e, "start_session_auto") == false) goto L20;
        e4 r16 = new e4(true, null, r2.f, new com.larus.voicecall.impl.museum.c(r2), 2);
    L21:
        r7 = ", shown=";
        n3 r17 = new n3(r13, r10, r6, r14, null, r19, "realtime_call", null, null, r16, null, null, null, null, false, new com.larus.voicecall.impl.museum.b(), false, r15, 391968);
        r5 = d3.a.c(r17);
        if (r5 == false) goto L24;
        int r18 = com.larus.voicecall.impl.museum.g.a;
        com.larus.voicecall.impl.museum.g.a((RealtimeCallParam) r12.invoke(), r2);
    L24:
        r1.i("MuseumExtensionDebug", "[banner][show] stage=" + r2.e + ", museum=" + r2.d + ", sendLongLinkAfterSuccess=" + r11 + r7 + r5 + ", identity=" + r13 + ", reason=cmd, isInCallNotification=true, business=" + r17.h + ", skipDisplayNameCheck=" + r17.q + ", enableSystemWindowFallback=" + r17.s + ", icon=" + r2.c + ", displayDurationMs=" + r17.g);
        StringBuilder r20 = new StringBuilder("showNotification stage=");
        r20.append(r2.e);
        r20.append(r7);
        r20.append(r5);
        r1.i("MuseumExtensionDispatcher", r20.toString());
        goto L25
    L20:
        r16 = new e4(true, null, r2.f, new com.larus.voicecall.impl.museum.d(r2, r11, r12, r8, r9), 2);
        goto L21
    L16:
        r19 = RangesKt.coerceAtLeast(r2.h, 1) * 1000;
        goto L18
    }
}
