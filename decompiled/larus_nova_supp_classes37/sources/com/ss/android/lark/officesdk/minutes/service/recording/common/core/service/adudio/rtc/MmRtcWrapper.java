package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRtcWrapper {
    public static final /* synthetic */ int n = 0;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.f b;
    public final Function0<Boolean> c;
    public final String d;
    public final Lazy e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final String i;
    public final h j;
    public long k;
    public final Lazy l;
    public final Lazy m;

    public static final class a {
    }

    static {
    }

    public MmRtcWrapper() {
        throw null;
    }

    public final void d() {
        c(this, new MmRtcWrapper$destroyRtc$1(this));
    }

    public final boolean e() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    public final void h() {
        c(this, new MmRtcWrapper$leaveChannel$1(this));
    }

    public final void j() {
        c(this, new MmRtcWrapper$release$1(this));
    }

    public final void p() {
        c(this, new MmRtcWrapper$stopAudioCapture$1(this));
    }

    public final void g(final com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r3) {
        final boolean r1 = true;
        c(this, new MmRtcWrapper$joinRoom$1(r1, r3, this));
    }

    public final void i(final sub.a r2) {
        Intrinsics.checkNotNullParameter(r2, "frame");
        c(this, new MmRtcWrapper$pushExternalEncodedAudioFrame$1(r2, this));
    }

    public final void k(final boolean r2) {
        c(this, new MmRtcWrapper$setEncodedExternalAudioDevice$1(r2));
    }

    public final void l(final boolean r2) {
        c(this, new MmRtcWrapper$setExternalAudioDevice$1(r2));
    }

    public final void m(final boolean r2) {
        c(this, new MmRtcWrapper$setPlaybackDigitalMute$1(r2));
    }

    public final void n(final int r2) {
        c(this, new MmRtcWrapper$setPlaybackVolume$1(r2));
    }

    public final void o(final Function1<? super Throwable, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onFailure");
        b(r2, new MmRtcWrapper$startAudioCapture$2(this, r2));
    }

    public MmRtcWrapper(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r3, com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.f r4) {
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "userComponentContext");
        Intrinsics.checkNotNullParameter(r4, "audioFormat");
        Intrinsics.checkNotNullParameter(r0, "isLarkAppProvider");
        this.a = r3;
        this.b = r4;
        this.c = r0;
        this.d = UUID.randomUUID().toString();
        this.e = LazyKt.lazy(new MmRtcWrapper$rtcScope$2(this));
        this.f = true;
        this.g = 2;
        this.h = true;
        MmChannelProfileType.VC.getValue();
        if (((Boolean) r0.invoke()).booleanValue() == false) goto L5;
        String r5 = "vc";
    L6:
        this.i = r5;
        this.j = new h(0);
        this.l = LazyKt.lazy(new MmRtcWrapper$audioSettingsConfig$2(this));
        this.m = LazyKt.lazy(new MmRtcWrapper$enableMMAudioMode$2(this));
        return;
    L5:
        r5 = "doubao_vc";
        goto L6
    }

    public static final String a(MmRtcWrapper r1, String r2) {
        if (r2 == null) goto L9;
        r1.getClass();
        if ((!StringsKt.isBlank(r2)) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L9;
        return r2;
    L9:
        if (r1.e() == false) goto L11;
        return "byteview_minutes_meeting";
    L11:
        return "";
    }

    public static /* synthetic */ void c(MmRtcWrapper r1, Function1 r2) {
        r1.b(MmRtcWrapper$checkAndRunInScop$1.INSTANCE, r2);
    }

    public final void b(Function1<? super Throwable, Unit> r9, Function1<? super nub.b, Unit> r10) {
        nub.b r0 = (nub.b) this.a.u(nub.b.class);
        if (r0 != null) goto L6;
        lvb.a.b("MmRtcWrapper", "[checkRtcService] rtcService is null");
        return;
    L6:
        BuildersKt.launch$default((CoroutineScope) this.e.getValue(), null, null, new MmRtcWrapper$checkAndRunInScop$2(r10, r0, r9, null), 3, null);
    }

    public final Object f(final MmRecordingAudioService.c r9, final MmRtcInitInfo r10, final String r11, Continuation r12) {
        final j r6 = new j(IntrinsicsKt.intercepted(r12), 1);
        r6.C();
        c(this, new MmRtcWrapper$initRtc$2$1(this, r9, r10, r11, r6));
        Object r13 = r6.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L5:
        return r13;
    }
}
