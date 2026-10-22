package com.larus.asr.session.component;

import android.app.Application;
import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.asr.ChatBottomSpeakerComponent;
import com.larus.asr.KmpAsrSessionAdapter;
import com.larus.asr.a5;
import com.larus.asr.x5;
import com.larus.bmhome.chat.ext.AudioTextExtra;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaResourceManager;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y0 implements o0 {
    public final com.larus.asr.session.p a;
    public final f0 b;
    public final boolean c;
    public final Function1<Long, Long> d;
    public final Lazy e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AsrEngineRoute.values().length];
            r0[AsrEngineRoute.KMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AsrEngineRoute.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AsrEngineRoute.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Override // com.larus.asr.session.component.o0
    public final void a(byte[] r1) {
    }

    public final com.larus.asr.session.n n() {
        return (com.larus.asr.session.n) this.e.getValue();
    }

    @Override // com.larus.asr.session.component.o0
    public final void onClear() {
        if (this.b.o != AsrEngineRoute.KMP) goto L9;
        KmpAsrSessionAdapter r0 = (KmpAsrSessionAdapter) this.b.p.getValue();
        r0.c();
        lw5.e r1 = r0.b;
        if (r1 == null) goto L7;
        r1.V2(false, false);
    L7:
        r0.b = null;
        return;
    }

    @Override // com.larus.asr.session.component.o0
    public final void onStop() {
        if (this.b.o != AsrEngineRoute.KMP) goto L6;
        ((KmpAsrSessionAdapter) this.b.p.getValue()).c();
        return;
    }

    @Override // com.larus.asr.session.component.o0
    public final void c(com.larus.asr.session.component.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.o0
    public final void d(com.larus.asr.session.component.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        boolean r0 = this.a.Sa();
        Object r1 = this.a.F9();
        this.a.setKeepScreenOn(false);
        e2a.e.a();
        if (r0 == false) goto L7;
        Message r2 = r5.b;
        if (r2 == null) goto L7;
        n().cancelAudioText(r2);
    L7:
        if (r1 == null) goto L12;
        Message r3 = r5.b;
        if (r3 == null) goto L11;
        n().deleteOnNoAudioContent(r3);
    L11:
        this.a.ca(null);
    L12:
        String r6 = r5.a;
        AsrEngineRoute r4 = this.b.o;
        int r7 = b.a[r4.ordinal()];
        if (r7 != 1) goto L15;
        ((KmpAsrSessionAdapter) this.b.p.getValue()).a(r6);
        return;
    L15:
        if (r7 != 2) goto L17;
        x5.a().d(r6);
        return;
    L17:
        if (r7 != 3) goto L20;
        return;
    L20:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.asr.session.component.o0
    public final void e(j0 r19) {
        Intrinsics.checkNotNullParameter(r19, "event");
        if (r19.g == false) goto L5;
    L79:
        this.a.ca(null);
        this.a.m8();
        return;
    L5:
        if (r19.f == false) goto L7;
    L69:
        Message r1 = r19.b;
        FLogger.a.w("AudioMessageLifecyclePost", "submit skipped because recording is too short");
        if (r1 == null) goto L72;
        n().deleteOnNoAudioContent(r1);
    L72:
        if (r1 == null) goto L74;
        String r2 = r1.getLocalMessageId();
    L76:
        if (com.larus.media.o.a() == false) goto L79;
        MediaResourceManager.a r3 = new MediaResourceManager.a();
        r3.a = 3;
        r3.b = r2;
        r3.c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        Lazy r4 = MediaResourceManager.a;
        MediaResourceManager.d(r3);
        goto L79
    L74:
        r2 = null;
        goto L76
    L7:
        if (r19.e <= 500) goto L69;
        final Message r5 = r19.b;
        ChatBottomSpeakerComponent r6 = this.a;
        if ((r6 instanceof ChatBottomSpeakerComponent) == false) goto L11;
        ChatBottomSpeakerComponent r7 = r6;
    L12:
        boolean r8 = false;
        if (r7 == null) goto L20;
        if (r5 == null) goto L16;
        String r9 = r5.getLocalMessageId();
    L18:
        if (r7.X3(r9) != true) goto L20;
        boolean r10 = true;
    L21:
        String r11 = "";
        if (this.c == false) goto L31;
        IAIChatControlTraceService.Companion r12 = IAIChatControlTraceService.a;
        if (r5 == null) goto L26;
        String r13 = r5.getLocalMessageId();
    L27:
        if (r13 != null) goto L29;
        String r14 = "";
    L30:
        boolean r15 = r19.c;
        long r16 = r19.d;
        r12.ub(r14, r15, r16, Math.min(r16, this.a.Ea()), this.a.Qa());
    L38:
        if (r5 == null) goto L79;
        if ((!this.a.ya()) == true) goto L43;
        r5 = null;
    L43:
        if (r5 == null) goto L79;
        if (this.c == true) goto L47;
    L53:
        if (r8 == true) goto L79;
        if (this.a.Ra() == false) goto L57;
        HashMap<String, Function0<Unit>> r17 = a5.a;
        a5.a(r5.getLocalMessageId(), new x0(this, r5));
    L59:
        if (z2.a.getSendMessageNetworkToastConfig().a() != 1) goto L79;
        int r20 = com.larus.utils.f0.a;
        AppHost.Companion r21 = AppHost.a;
        if (com.larus.utils.f0.a(r21.getApplication()) == true) goto L79;
        t19.s r22 = t19.s.a;
        Application r23 = r21.getApplication();
        r22.getClass();
        t19.s.s(r23, 2131908080);
        Function2<? super String, ? super Boolean, Boolean> r24 = r19.h;
        String r25 = r5.getContent();
        if (r25 == null) goto L67;
        r11 = r25;
    L67:
        if (((Boolean) r24.invoke(r11, Boolean.valueOf(r10))).booleanValue() == false) goto L79;
        n().deleteOnNoAudioContent(r5);
        goto L79
    L57:
        n().submitAudioText(r5);
        goto L59
    L47:
        if (this.a.ob() == false) goto L53;
        if (this.a.Cb() == false) goto L51;
    L52:
        r8 = true;
        goto L53
    L51:
        if (Intrinsics.areEqual(z2.a.voiceInputHandsfreeConfig().getHandsfreeAsrEndBehavior(), "backfill") == false) goto L53;
    L29:
        r14 = r13;
        goto L30
    L26:
        r13 = null;
        goto L27
    L31:
        IAIChatControlTraceService.Companion r26 = IAIChatControlTraceService.a;
        if (r5 == null) goto L34;
        String r27 = r5.getLocalMessageId();
    L35:
        if (r27 != null) goto L37;
        r27 = "";
    L37:
        IAIChatControlTraceService.a.f(r26, r27, r19.c, r19.d);
        goto L38
    L34:
        r27 = null;
        goto L35
    L16:
        r9 = null;
    L20:
        r10 = false;
        goto L21
    L11:
        r7 = null;
        goto L12
    }

    @Override // com.larus.asr.session.component.o0
    public final void i(j0 r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        boolean r1 = false;
        this.a.setKeepScreenOn(false);
        e2a.e.c();
        int r0 = AsrSessionComponentUtils.a;
        Object r5 = null;
        AsrSessionComponentUtils.b(this.a, r7.a, null, "onSubmit2:" + r7.a, 12);
        String r2 = r7.a;
        Message r3 = r7.b;
        int r4 = b.a[this.b.o.ordinal()];
        if (r4 != 1) goto L5;
        r1 = ((KmpAsrSessionAdapter) this.b.p.getValue()).f(r2);
    L17:
        r7.f = r1;
        Message r6 = r7.b;
        if (r6 == null) goto L38;
        Map r8 = r6.getBusinessExt();
        if (r8 == null) goto L22;
        String r9 = (String) r8.get("tag_audio_text_info");
    L23:
        if (r9 == null) goto L33;
        int r10 = ve8.e.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L27
        Object r12 = Result.constructor-impl(new Gson().fromJson(r9, AudioTextExtra.class));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r12) == true) goto L33;
        r5 = r12;
    L27:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L33:
        AudioTextExtra r14 = (AudioTextExtra) r5;
        if (r14 == null) goto L38;
        Long r15 = r14.getRecordTime();
        if (r15 == null) goto L38;
        long r16 = r15.longValue();
    L39:
        long r17 = SystemClock.elapsedRealtime() - r16;
        r7.d = r17;
        r7.e = ((Number) this.d.invoke(Long.valueOf(r17))).longValue();
        return;
    L22:
        r9 = null;
    L38:
        r16 = 0;
        goto L39
    L5:
        if (r4 != 2) goto L7;
        com.larus.audio.k0 r19 = x5.a();
        if (r3 == null) goto L14;
        String r20 = r3.getLocalMessageId();
    L15:
        r1 = r19.g(r2, r20, this.a.I9());
        goto L17
    L14:
        r20 = null;
        goto L15
    L7:
        if (r4 == 3) goto L17;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.asr.session.component.o0
    public final void j(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public /* synthetic */ y0(com.larus.asr.session.p r3, f0 r4) {
        this(r3, r4, false, new w0());
    }

    @Override // com.larus.asr.session.component.o0
    public final void h(a0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    @Override // com.larus.asr.session.component.o0
    public final void l(a0 r2, com.larus.audio.b r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y0(com.larus.asr.session.p r2, f0 r3, boolean r4, Function1<? super Long, Long> r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "asrContext");
        Intrinsics.checkNotNullParameter(r5, "durationForShortCheck");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = LazyKt.lazy(new v0(this));
    }

    @Override // com.larus.asr.session.component.o0
    public final void f(a0 r1, String r2, String r3, long r4, int r6) {
        Intrinsics.checkNotNullParameter(r1, "scope");
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "path");
    }
}
