package com.larus.asr.session;

import android.app.Application;
import com.larus.asr.ChatBottomSpeakerComponent;
import com.larus.asr.handsfree.AsrInputMode;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d3 implements Function4 {
    public final /* synthetic */ SendMessageAsrSession a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ com.larus.audio.asr.c0 c;

    public /* synthetic */ d3(SendMessageAsrSession r1, Message r2, com.larus.audio.asr.c0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r24, Object r25, Object r26, Object r27) {
        SendMessageAsrSession r14 = this.a;
        Message r15 = this.b;
        com.larus.audio.asr.c0 r0 = this.c;
        String r12 = (String) r24;
        String r4 = (String) r25;
        long r10 = ((Long) r26).longValue();
        int r13 = ((Integer) r27).intValue();
        Intrinsics.checkNotNullParameter(r12, "taskId");
        Intrinsics.checkNotNullParameter(r4, "path");
        r14.C = true;
        r14.A.removeCallbacks(r14.B);
        ChatBottomSpeakerComponent r2 = r14.a;
        if ((r2 instanceof ChatBottomSpeakerComponent) == false) goto L5;
        ChatBottomSpeakerComponent r3 = r2;
    L7:
        if (r3 == null) goto L12;
        if (r15 == null) goto L10;
        String r5 = r15.getLocalMessageId();
    L11:
        boolean r16 = r3.X3(r5);
    L13:
        f2a.c r6 = r14.g.b("asrGlobalFail invoke");
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put(new f2a.f("error_code"), String.valueOf(r13));
        r7.put(new f2a.f("duration"), String.valueOf(r10));
        r7.put(f2a.f.c, r12);
        r6.d(r7);
        r6.c.d = "asrGlobalFail";
        List r8 = CollectionsKt.listOf(r0.a);
        f2a.g r9 = r6.c;
        r9.b = r8;
        r9.e = r0.b;
        f2a.c.c(r6, null, 15);
        r14.e = false;
        AppHost.Companion r1 = AppHost.a;
        Application r11 = r1.getApplication();
        if (r13 != AsrEventEnum.ASR_RECORDER_SILENCED.getCode()) goto L16;
    L19:
        boolean r17 = true;
    L21:
        if (r14.a.ob() == false) goto L24;
        if (r17 == false) goto L24;
        boolean r19 = true;
    L25:
        if (r19 == false) goto L63;
        r14.a.ha("recorder_interrupt");
    L63:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L29
        Object r21 = Result.constructor-impl(Boolean.valueOf(r1.a().isAppBackground()));     // Catch: Throwable -> L29
    L31:
        Boolean r22 = Boolean.FALSE;
        if (Result.isFailure-impl(r21) == false) goto L34;
        r21 = r22;
    L34:
        boolean r23 = ((Boolean) r21).booleanValue();
        if (r14.a.B5() != AsrInputMode.HANDSFREE) goto L37;
        boolean r29 = true;
    L38:
        FLogger r30 = FLogger.a;
        StringBuilder r31 = new StringBuilder("[HF] asrGlobalFail diagnostic: taskId=");
        r31.append(r12);
        r31.append(" errorCode=");
        r31.append(r13);
        r31.append(" isHandsfreeLatched=");
        r31.append(r14.a.ob());
        r31.append(" isHandsfreeActive=");
        r31.append(r29);
        r31.append(" isHandsfreeRecorderInterrupted=");
        r31.append(r19);
        r31.append(" appBackground=");
        r31.append(r23);
        r31.append(" speakerVisible=");
        r31.append(r14.a.Sa());
        r31.append(" pathEmpty=");
        if (r4.length() != 0) goto L41;
        boolean r32 = true;
    L42:
        r31.append(r32);
        r31.append(" duration=");
        r31.append(r10);
        r30.i("SendMessageAsrSession", r31.toString());
        boolean r110 = r19;
        r14.d = new e3(r12, r4, r14, r11, r15, r16, r110, r13, r17, r10);
        AsrEventEnum r33 = AsrEventEnum.ASR_RECORDER_SILENCED;
        if (r13 != r33.getCode()) goto L45;
    L48:
        if (r110 == true) goto L51;
        t19.s.a.getClass();
        t19.s.b(r11, 2131899941, false);
    L51:
        if (r13 != r33.getCode()) goto L53;
        String r34 = "asr_recorder_silenced";
    L54:
        e3 r35 = null;
        SendMessageAsrSession.k(r14, r12, null, r34, 20);
        r14.f = true;
    L56:
        if (r14.a.Sa() == true) goto L61;
        e3 r36 = r14.d;
        if (r36 == null) goto L60;
        r36.invoke();
    L60:
        r14.d = r35;
    L61:
        r14.oa(com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a);
        r14.b(r15.getLocalMessageId());
        return Unit.INSTANCE;
    L53:
        r34 = "asr_request_media_failed";
        goto L54
    L45:
        if (r13 == AsrEventEnum.ASR_REQUEST_MEDIA_FAILED.getCode()) goto L48;
        r35 = null;
        goto L56
    L41:
        r32 = false;
        goto L42
    L37:
        r29 = false;
    L29:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        r19 = false;
        goto L25
    L16:
        if (r13 == AsrEventEnum.ASR_REQUEST_MEDIA_FAILED.getCode()) goto L19;
        r17 = false;
        goto L21
    L10:
        r5 = null;
        goto L11
    L12:
        r16 = false;
        goto L13
    L5:
        r3 = null;
        goto L7
    }
}
