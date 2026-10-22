package com.larus.asr.session.component;

import android.app.Application;
import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.asr.ChatBottomSpeakerComponent;
import com.larus.asr.VoiceInputType;
import com.larus.asr.a5;
import com.larus.asr.c5;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.bmhome.chat.ext.AudioTextExtra;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.MessageMenu;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.media.MediaResourceManager;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.platform.spi.IAIChatService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class AsrMessageResultPostComponent implements q0 {
    public final com.larus.asr.session.p a;
    public final String b;
    public final f0 c;
    public final VoiceInputType d;
    public final Function0<Long> e;
    public final Lazy f;
    public Function1<? super String, Boolean> g;
    public Function2<? super String, ? super String, Boolean> h;
    public Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> i;
    public Function1<? super com.larus.audio.b, Boolean> j;
    public Function1<? super com.larus.audio.a, Boolean> k;
    public Function2<? super String, ? super byte[], Unit> l;
    public Function2<? super String, ? super Boolean, Unit> m;
    public s n;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.component.o0
    public final void onClear() {
        this.n = null;
        c5.c();
        a5.b();
    }

    @Override // com.larus.asr.session.component.o0
    public final void onStop() {
    }

    public final com.larus.asr.session.n n() {
        return (com.larus.asr.session.n) this.f.getValue();
    }

    public boolean s() {
        return this.a.ob();
    }

    public final boolean r() {
        if (s() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.a.Cb() == false) goto L7;
    L8:
        return true;
    L7:
        if (Intrinsics.areEqual(z2.a.voiceInputHandsfreeConfig().getHandsfreeAsrEndBehavior(), "backfill") == false) goto L9;
        goto L8
    }

    @Override // com.larus.asr.session.component.o0
    public final void a(byte[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.a.Ma(this.b, r5);
        Function2<? super String, ? super byte[], Unit> r0 = this.l;
        ChatBottomSpeakerComponent r1 = this.a;
        String r3 = null;
        if ((r1 instanceof ChatBottomSpeakerComponent) == false) goto L7;
        ChatBottomSpeakerComponent r2 = r1;
    L8:
        if (r2 == null) goto L10;
        r3 = r2.G1;
    L10:
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        r0.invoke(r3, r5);
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.larus.asr.session.component.q0
    public final void b(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.i = r2;
    }

    @Override // com.larus.asr.session.component.o0
    public final void c(com.larus.asr.session.component.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.o0
    public final void d(com.larus.asr.session.component.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.n = null;
    }

    @Override // com.larus.asr.session.component.o0
    public final void e(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.q0
    public final void g(Function2<? super String, ? super Boolean, Unit> r1) {
        this.m = r1;
    }

    @Override // com.larus.asr.session.component.o0
    public final void i(j0 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        s r0 = this.n;
        if (r0 != null) goto L5;
        boolean r1 = false;
    L6:
        r3.g = r1;
        AsrMessageResultPostComponent$onSubmit$1 r2 = new AsrMessageResultPostComponent$onSubmit$1(this);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r3.h = r2;
        return;
    L5:
        this.n = null;
        r0.invoke();
        r1 = true;
        goto L6
    }

    @Override // com.larus.asr.session.component.o0
    public final void j(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.larus.asr.session.component.q0
    public final void k(Function2<? super String, ? super String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.h = r2;
    }

    public void t(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        n().deleteOnNoAudioContentWithoutContent(r2);
    }

    @Override // com.larus.asr.session.component.o0
    public final void h(final a0 r49, final String r50) {
        Intrinsics.checkNotNullParameter(r49, "scope");
        Intrinsics.checkNotNullParameter(r50, "streamResult");
        final f0 r0 = r49.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        Message r14 = r0.d;
        if (r14 == null) goto L14;
        r0.i = r50;
        HashMap<String, Function0<Unit>> r1 = a5.a;
        a5.c(r14.getLocalMessageId());
        if (r() == true) goto L10;
        Message r46 = r14;
        n().streamAudioText(Message.copy$default(r46, null, null, null, 0, 0, null, 0, false, null, r50, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -513, 31, null));
    L11:
        HashSet<String> r2 = c5.a;
        final Message r5 = r46;
        c5.a(r46.getLocalMessageId(), new t(r0, this, r49, r50, r5));
        com.larus.bmhome.chat.component.bottom.core.speaker.g r3 = new com.larus.bmhome.chat.component.bottom.core.speaker.g.d(r50);
        this.c.e(r3);
        return;
    L10:
        r46 = r14;
        goto L11
    L14:
        throw new IllegalStateException("ASR stream requires a prepared message".toString());
    }

    @Override // com.larus.asr.session.component.o0
    public final void l(a0 r17, com.larus.audio.b r19) {
        Intrinsics.checkNotNullParameter(r17, "scope");
        Intrinsics.checkNotNullParameter(r19, "result");
        f0 r3 = r17.getContext();
        if (r3 != null) goto L5;
        return;
    L5:
        Message r8 = r3.d;
        if (r8 == null) goto L73;
        String r10 = r19.b;
        ChatBottomSpeakerComponent r1 = this.a;
        Object r11 = null;
        String r12 = null;
        String r13 = null;
        r11 = null;
        if ((r1 instanceof ChatBottomSpeakerComponent) == false) goto L10;
        ChatBottomSpeakerComponent r2 = r1;
    L11:
        boolean r4 = false;
        if (r2 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        this.c.d();
        HashMap<String, Function0<Unit>> r5 = a5.a;
        a5.c(r8.getLocalMessageId());
        HashSet<String> r7 = c5.a;
        if (c5.b(r8.getLocalMessageId()) == false) goto L27;
        if (r() == false) goto L76;
        com.larus.asr.session.p r9 = this.a;
        com.larus.audio.c r0 = r19.g;
        if (r0 == null) goto L24;
        r12 = r0.d;
    L24:
        r9.R9(r12);
        return;
    L76:
        return;
    L27:
        if (r10.length() <= 0) goto L29;
        r4 = true;
    L29:
        if (r4 == false) goto L41;
        String r14 = r19.a;
        com.larus.audio.c r15 = r19.g;
        if (r15 == null) goto L33;
        String r16 = r15.b;
    L34:
        if (r15 == null) goto L36;
        String r20 = r15.c;
    L37:
        u(r17, r3, r10, r14, r19, r16, r20);
        com.larus.audio.c r21 = r19.g;
        if (r21 == null) goto L40;
        r13 = r21.d;
    L40:
        this.c.e(new com.larus.bmhome.chat.component.bottom.core.speaker.g.e(r10, r13, 4));
        return;
    L36:
        r20 = null;
        goto L37
    L33:
        r16 = null;
        goto L34
    L41:
        boolean r22 = ((Boolean) this.g.invoke(r10)).booleanValue();
        boolean r23 = ((Boolean) this.j.invoke(com.larus.audio.b.a(r19, r6))).booleanValue();
        if (r3.c() == true) goto L67;
        Map r24 = r8.getBusinessExt();
        if (r24 == null) goto L46;
        String r25 = (String) r24.get("tag_audio_text_info");
    L47:
        if (r25 == null) goto L57;
        int r26 = ve8.e.a;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L51
        Object r29 = Result.constructor-impl(new Gson().fromJson(r25, AudioTextExtra.class));     // Catch: Throwable -> L51
    L54:
        if (Result.isFailure-impl(r29) == true) goto L57;
        r11 = r29;
    L51:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
    L57:
        AudioTextExtra r110 = (AudioTextExtra) r11;
        if (r110 == null) goto L62;
        Long r31 = r110.getRecordTime();
        if (r31 == null) goto L62;
        long r32 = r31.longValue();
    L64:
        if ((SystemClock.elapsedRealtime() - r32) <= 500) goto L66;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AsrMessageResultPostComponent$onSuccess$1(r3, this, r6, r22, r23, null), 3, null);
    L66:
        this.c.e(com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a);
    L62:
        r32 = 0;
        goto L64
    L46:
        r25 = null;
    L67:
        n().deleteOnNoAudioContent(r8);
        String r33 = r8.getLocalMessageId();
        if (com.larus.media.o.a() == false) goto L78;
        MediaResourceManager.a r34 = new MediaResourceManager.a();
        r34.a = 3;
        r34.b = r33;
        r34.c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        MediaResourceManager.d(r34);
        return;
    L78:
        return;
    L14:
        if (r2.X3(r8.getLocalMessageId()) != true) goto L16;
        r6 = true;
        goto L17
    L10:
        r2 = null;
        goto L11
    L73:
        throw new IllegalStateException("ASR success requires a prepared message".toString());
    }

    public void o(a0 r35, j r36) {
        Intrinsics.checkNotNullParameter(r35, "scope");
        Intrinsics.checkNotNullParameter(r36, "result");
        String r3 = this.a.ub(r36.b);
        ChatBottomSpeakerComponent r4 = this.a;
        String r11 = null;
        if ((r4 instanceof ChatBottomSpeakerComponent) == false) goto L5;
        ChatBottomSpeakerComponent r5 = r4;
    L6:
        boolean r12 = true;
        if (r5 != null) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L16;
        n().deleteOnNoAudioContent(r36.a);
        return;
    L16:
        if (this.a.ya() == false) goto L20;
        this.a.ib(r36.b, r36.d, this.d);
        return;
    L20:
        if (this.a.Ua(r36.b) == true) goto L23;
        n().deleteOnNoAudioContent(r36.a);
        return;
    L23:
        wc9.e r7 = this.a.h();
        if (r7 == null) goto L26;
        String r8 = r7.a;
    L27:
        if (r8 != null) goto L29;
        r8 = "";
    L29:
        IAIChatService.a.c(r8, r36.c);
        WeakReference r9 = MessageMenu.x;
        MessageMenu.a.a();
        AttachmentInfo r10 = this.a.X9();
        if ((r10 instanceof AttachmentInfo) == false) goto L32;
        AttachmentInfo r17 = r10;
    L33:
        if (r17 != null) goto L35;
        ReferenceInfo r14 = this.a.G9();
    L36:
        Map r13 = this.a.eb(r3, r36.a, r14, r17, r36.d);
        com.larus.audio.b r15 = r36.e;
        if (r15 == null) goto L41;
        com.larus.audio.c r16 = r15.g;
        if (r16 == null) goto L41;
        String r19 = r16.d;
    L42:
        if (r17 == null) goto L44;
        r13.put("is_audio", "true");
    L66:
        if (r19 != null) goto L68;
    L75:
        if (r17 == null) goto L91;
        ArrayList r1 = new ArrayList();
        String r110 = r17.getFilePath();
        String r20 = r17.getTosKey();
        Integer r21 = r17.getHeight();
        if (r21 == null) goto L79;
        int r22 = r21.intValue();
    L80:
        Integer r23 = Integer.valueOf(r22);
        Integer r24 = r17.getWidth();
        if (r24 == null) goto L83;
        int r25 = r24.intValue();
    L84:
        r1.add(new ai8.e(r110, r20, r23, Integer.valueOf(r25), null, null, null, null, null, null, false, this.a.M1(), null, null, 28656));
        if (r3.length() > 0) goto L88;
        r12 = false;
    L88:
        if (r12 == false) goto L90;
        r1.add(new ai8.h(r3, null, null, null, r13, null, false, false, this.a.M1(), null, 750));
    L90:
        n().sendFileAndTxt(this.a.h(), "speak", r1, r17.getFromScene(), null);
        n().deleteOnNoAudioContent(r36.a);
    L101:
        this.a.Gb(r36.c);
        IAIChatRenderTraceService.a.j(r36.c);
        return;
    L83:
        r25 = 0;
        goto L84
    L79:
        r22 = 0;
        goto L80
    L91:
        if (r14 != null) goto L93;
        r3 = this.a.Jb(r3);
    L93:
        String r111 = r3;
        String r26 = r36.a.getLocalMessageId();
        if (r14 != null) goto L96;
        ReferenceInfo r27 = com.larus.bmhome.chat.bean.d.b1(r36.a);
    L97:
        ai8.b r29 = new ai8.b(r111, r26, r27, r13, r36.a.getBusinessExt(), false, this.a.M1(), (Long) this.e.invoke(), 32);
        if (r14 != null) goto L100;
        r35.b.invoke(r36.a);
    L100:
        n().sendAudioText(r8, r29, r36.a, this.d);
        goto L101
    L96:
        r27 = r14;
        goto L97
    L68:
        if (r19.length() <= 0) goto L70;
        boolean r30 = true;
    L71:
        if (r30 == false) goto L73;
        r11 = r19;
    L73:
        if (r11 == null) goto L75;
        r13.put("asr_log_id", r11);
        goto L75
    L70:
        r30 = false;
        goto L71
    L44:
        String r31 = r36.f;
        if (r31 != null) goto L47;
    L55:
        String r32 = r36.g;
        if (r32 == null) goto L66;
        if (r32.length() <= 0) goto L60;
        boolean r33 = true;
    L61:
        if (r33 == true) goto L64;
        r32 = null;
    L64:
        if (r32 == null) goto L66;
        r13.put("audio_event_resp", r32);
        goto L66
    L60:
        r33 = false;
        goto L61
    L47:
        if (r31.length() <= 0) goto L49;
        boolean r34 = true;
    L50:
        if (r34 == true) goto L53;
        r31 = null;
    L53:
        if (r31 == null) goto L55;
        r13.put("audio_data_tos_uri", r31);
        goto L55
    L49:
        r34 = false;
    L41:
        r19 = null;
        goto L42
    L35:
        r14 = null;
        goto L36
    L32:
        r17 = null;
        goto L33
    L26:
        r8 = null;
        goto L27
    L9:
        if (r5.c4(r3) != true) goto L11;
        r6 = true;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    public void v(boolean r1, boolean r2) {
        if (r1 == false) goto L4;
        if (r2 == false) goto L4;
        return;
    L4:
        t19.s r3 = t19.s.a;
        Application r4 = AppHost.a.getApplication();
        r3.getClass();
        t19.s.s(r4, 2131899943);
    }

    @Override // com.larus.asr.session.component.q0
    public final void m(Function1<? super com.larus.audio.b, Boolean> r2, Function1<? super com.larus.audio.a, Boolean> r3, Function2<? super String, ? super byte[], Unit> r4, final Function1<? super String, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "success");
        Intrinsics.checkNotNullParameter(r3, "fail");
        Intrinsics.checkNotNullParameter(r4, "audioData");
        Intrinsics.checkNotNullParameter(r5, "rawResult");
        this.g = r5;
        this.h = new k(r5);
        this.j = r2;
        this.k = r3;
        this.l = r4;
    }

    public final void q(Message r4, String r5, long r6, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "path");
        if (((Boolean) this.k.invoke(new com.larus.audio.a(r4.getContent(), r8))).booleanValue() == false) goto L5;
        n().deleteOnNoAudioContent(r4);
        return;
    L5:
        n().failAudioText(r4, r5, r6);
    }

    public AsrMessageResultPostComponent(com.larus.asr.session.p r2, String r3, f0 r4, VoiceInputType r5, Function0<Long> r6) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "sessionTaskId");
        Intrinsics.checkNotNullParameter(r4, "asrContext");
        Intrinsics.checkNotNullParameter(r5, "voiceInputType");
        Intrinsics.checkNotNullParameter(r6, "sendTriggerTimestampProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LazyKt.lazy(new l(this));
        this.g = new m();
        this.h = new n(this);
        this.i = new o();
        this.j = new p();
        this.k = new q();
        this.l = new r();
    }

    @Override // com.larus.asr.session.component.o0
    public final void f(a0 r20, String r21, String r22, long r23, int r25) {
        Intrinsics.checkNotNullParameter(r20, "scope");
        Intrinsics.checkNotNullParameter(r21, "taskId");
        Intrinsics.checkNotNullParameter(r22, "path");
        f0 r1 = r20.getContext();
        if (r1 != null) goto L5;
        return;
    L5:
        Message r13 = r1.d;
        if (r13 == null) goto L53;
        this.c.d();
        ChatBottomSpeakerComponent r0 = this.a;
        if ((r0 instanceof ChatBottomSpeakerComponent) == false) goto L10;
        ChatBottomSpeakerComponent r2 = r0;
    L12:
        if (r2 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        AsrEventEnum r16 = AsrEventEnum.ASR_RECORDER_SILENCED;
        if (r25 != r16.getCode()) goto L20;
    L23:
        boolean r17 = true;
    L25:
        if (s() == false) goto L28;
        if (r17 == false) goto L28;
        boolean r19 = true;
    L29:
        if (r19 == false) goto L31;
        this.a.ha("recorder_interrupt");
    L31:
        this.n = new s(r1, this, r13, r4, r19, r22, r23, r17);
        if (r17 == false) goto L40;
        if (r19 == true) goto L35;
        t19.s r3 = t19.s.a;
        Application r5 = AppHost.a.getApplication();
        r3.getClass();
        t19.s.b(r5, 2131899941, false);
    L35:
        int r6 = AsrSessionComponentUtils.a;
        com.larus.asr.session.p r7 = this.a;
        if (r25 != r16.getCode()) goto L38;
        String r8 = "asr_recorder_silenced";
    L39:
        s r9 = null;
        AsrSessionComponentUtils.b(r7, r21, null, r8, 12);
    L42:
        if (this.a.Sa() == true) goto L47;
        s r10 = this.n;
        if (r10 == null) goto L47;
        this.n = r9;
        r10.invoke();
    L47:
        com.larus.bmhome.chat.component.bottom.core.speaker.g r11 = com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a;
        this.c.e(r11);
        String r12 = r13.getLocalMessageId();
        if (com.larus.media.o.a() == false) goto L54;
        MediaResourceManager.a r14 = new MediaResourceManager.a();
        r14.a = 3;
        r14.b = r12;
        r14.c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        MediaResourceManager.d(r14);
        return;
    L54:
        return;
    L38:
        r8 = "asr_request_media_failed";
        goto L39
    L40:
        r9 = null;
    L28:
        r19 = false;
        goto L29
    L20:
        if (r25 == AsrEventEnum.ASR_REQUEST_MEDIA_FAILED.getCode()) goto L23;
        r17 = false;
        goto L25
    L14:
        if (r2.X3(r13.getLocalMessageId()) != true) goto L16;
        r4 = true;
        goto L17
    L10:
        r2 = null;
        goto L12
    L53:
        throw new IllegalStateException("ASR failure requires a prepared message".toString());
    }

    public void p(Message r7, String r8, long r9, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r7, "message");
        Intrinsics.checkNotNullParameter(r8, "path");
        if (r11 == false) goto L5;
        n().deleteOnNoAudioContent(r7);
        return;
    L5:
        q(r7, r8, r9, r12);
    }

    public final void u(a0 r11, f0 r12, String r13, String r14, com.larus.audio.b r15, String r16, String r17) {
        Message r2 = r12.d;
        if (r2 == null) goto L39;
        ChatBottomSpeakerComponent r4 = null;
        if (r15 == null) goto L9;
        com.larus.audio.c r5 = r15.g;
        if (r5 == null) goto L9;
        String r6 = r5.d;
    L11:
        if (((Boolean) this.h.invoke(r13, r6)).booleanValue() == false) goto L17;
        if (s() == false) goto L40;
        n().deleteOnNoAudioContent(r2);
        return;
    L40:
        return;
    L17:
        if (r12.c() == false) goto L19;
        return;
    L19:
        if (r15 == null) goto L32;
        com.larus.asr.session.p r1 = this.a;
        if ((r1 instanceof ChatBottomSpeakerComponent) == false) goto L23;
        r4 = (ChatBottomSpeakerComponent) r1;
    L23:
        if (r4 == null) goto L27;
        boolean r3 = r4.X3(r2.getLocalMessageId());
        boolean r7 = true;
        if (r3 != true) goto L27;
    L29:
        if (((Boolean) this.j.invoke(com.larus.audio.b.a(r15, r7))).booleanValue() == false) goto L32;
        n().deleteOnNoAudioContentWithoutContent(r2);
        return;
    L27:
        r7 = false;
    L32:
        com.larus.bmhome.chat.component.bottom.core.speaker.a r8 = (com.larus.bmhome.chat.component.bottom.core.speaker.a) this.i.invoke(r13);
        if (r8.a == false) goto L36;
        t(r2);
        return;
    L36:
        o(r11, new j(r2, r13, r14, r8.b, r15, r16, r17));
        return;
    L9:
        r6 = null;
        goto L11
    L39:
        throw new IllegalStateException("ASR result requires a prepared message".toString());
    }
}
