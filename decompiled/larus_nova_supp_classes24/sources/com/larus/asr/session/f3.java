package com.larus.asr.session;

import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.asr.ChatBottomSpeakerComponent;
import com.larus.asr.VoiceInputType;
import com.larus.asr.a5;
import com.larus.asr.c5;
import com.larus.bmhome.chat.ext.AudioTextExtra;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class f3 implements Function1 {
    public final /* synthetic */ SendMessageAsrSession a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ com.larus.audio.asr.c0 c;
    public final /* synthetic */ VoiceInputType d;

    public /* synthetic */ f3(SendMessageAsrSession r1, Message r2, com.larus.audio.asr.c0 r3, VoiceInputType r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r20) {
        SendMessageAsrSession r10 = this.a;
        Message r3 = this.b;
        com.larus.audio.asr.c0 r0 = this.c;
        VoiceInputType r8 = this.d;
        com.larus.audio.b r11 = (com.larus.audio.b) r20;
        ChatBottomSpeakerComponent r2 = r10.a;
        String r12 = null;
        if ((r2 instanceof ChatBottomSpeakerComponent) == false) goto L5;
        ChatBottomSpeakerComponent r4 = r2;
    L6:
        if (r4 == null) goto L11;
        if (r3 == null) goto L9;
        String r5 = r3.getLocalMessageId();
    L10:
        boolean r6 = r4.X3(r5);
    L12:
        String r7 = r11.a;
        String r13 = r11.b;
        long r9 = r11.c;
        f2a.c r14 = r10.g.b("asrGlobalSuccess invoke");
        LinkedHashMap r15 = new LinkedHashMap();
        f2a.f r16 = new f2a.f("is_empty_asr_result");
        if (r13.length() != 0) goto L15;
        boolean r17 = true;
    L16:
        r15.put(r16, String.valueOf(r17));
        r15.put(new f2a.f("audio_duration"), String.valueOf(r9));
        r15.put(new f2a.f("is_cancel"), String.valueOf(r10.f));
        f2a.f r19 = f2a.f.d;
        String r21 = g2a.d.b(r13);
        if (r21 != null) goto L19;
        r21 = "";
    L19:
        r15.put(r19, r21);
        r15.put(f2a.f.c, r7);
        r14.d(r15);
        r14.c.d = "asrGlobalSuccess";
        List r22 = CollectionsKt.listOf(r0.a);
        f2a.g r23 = r14.c;
        r23.b = r22;
        r23.e = r0.b;
        f2a.c.c(r14, null, 15);
        r10.e = false;
        HashMap<String, Function0<Unit>> r24 = a5.a;
        a5.c(r3.getLocalMessageId());
        HashSet<String> r25 = c5.a;
        if (c5.b(r3.getLocalMessageId()) == true) goto L22;
        FLogger.a.i("SendMessageAsrSession", "asrGlobalSuccess asrResult:" + g2a.d.b(r13));
        if (r13.length() <= 0) goto L31;
        boolean r26 = true;
    L32:
        if (r26 == false) goto L47;
        boolean r1 = r10.c(r3, r13);
        if (r1 == true) goto L43;
        com.larus.audio.c r27 = r11.g;
        if (r27 == null) goto L38;
        String r29 = r27.b;
    L39:
        if (r27 == null) goto L41;
        String r30 = r27.c;
    L42:
        r10.h(r3, r7, r13, r29, r30, r8, r11);
        goto L43
    L41:
        r30 = null;
        goto L42
    L38:
        r29 = null;
    L43:
        com.larus.audio.c r31 = r11.g;
        if (r31 == null) goto L46;
        r12 = r31.d;
    L46:
        r10.oa(new com.larus.bmhome.chat.component.bottom.core.speaker.g.e(r13, r12, r1));
    L74:
        return Unit.INSTANCE;
    L47:
        boolean r32 = ((Boolean) r10.i.invoke(r13)).booleanValue();
        boolean r33 = ((Boolean) r10.m.invoke(com.larus.audio.b.a(r11, r6))).booleanValue();
        if (r10.f == true) goto L72;
        Map r34 = r3.getBusinessExt();
        if (r34 == null) goto L52;
        String r35 = (String) r34.get("tag_audio_text_info");
    L53:
        if (r35 == null) goto L61;
        int r36 = ve8.e.a;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L57
        Object r38 = Result.constructor-impl(new Gson().fromJson(r35, AudioTextExtra.class));     // Catch: Throwable -> L57
    L60:
        if (Result.isFailure-impl(r38) == true) goto L61;
    L62:
        AudioTextExtra r39 = (AudioTextExtra) r38;
        if (r39 == null) goto L67;
        Long r40 = r39.getRecordTime();
        if (r40 == null) goto L67;
        long r41 = r40.longValue();
    L69:
        if ((SystemClock.elapsedRealtime() - r41) <= 500) goto L71;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SendMessageAsrSession$asrGlobalSuccess$1$2(r6, r32, r33, null), 3, null);
    L71:
        r10.oa(com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a);
    L67:
        r41 = 0;
    L57:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r38 = Result.constructor-impl(ResultKt.createFailure(th));
    L61:
        r38 = null;
        goto L62
    L52:
        r35 = null;
    L72:
        r10.e().deleteOnNoAudioContent(r3);
        r10.b(r3.getLocalMessageId());
        goto L74
    L31:
        r26 = false;
        goto L32
    L22:
        if (r10.g() == false) goto L27;
        p r43 = r10.a;
        com.larus.audio.c r44 = r11.g;
        if (r44 == null) goto L26;
        r12 = r44.d;
    L26:
        r43.R9(r12);
    L27:
        FLogger.a.i("SendMessageAsrSession", "has send stream result, return taskId = " + r7);
        return Unit.INSTANCE;
    L15:
        r17 = false;
        goto L16
    L9:
        r5 = null;
        goto L10
    L11:
        r6 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }
}
