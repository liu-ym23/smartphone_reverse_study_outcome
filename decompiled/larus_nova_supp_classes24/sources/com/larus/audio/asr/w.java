package com.larus.audio.asr;

import com.larus.audio.audiov3.asr.AsrCallBackType;
import com.larus.business.debug.base.audio.module.ASRModule;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import n58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w implements b {
    public final /* synthetic */ b a;
    public final /* synthetic */ c0 b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    @Override // n58.b
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "convId");
        b r0 = this.a;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    public w(b r1, c0 r2, Message r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // n58.b
    public final void a(String r27, AsrCallBackType r29, String r210, String r30, long r31, String r33, int r34, String r35, String r36, String r37) {
        Intrinsics.checkNotNullParameter(r33, "vid");
        f2a.d r2 = com.larus.audio.utils.c.a;
        f2a.c r3 = r2.b("receive ASR result");
        LinkedHashMap r4 = new LinkedHashMap();
        Message r5 = this.c;
        String r6 = this.d;
        String r7 = this.e;
        f2a.f r8 = f2a.f.d;
        String r9 = g2a.d.b(r210);
        String r15 = "";
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        r4.put(r8, r9);
        f2a.f r10 = new f2a.f("is_empty_asr_result");
        boolean r16 = false;
        if (r210 != null) goto L8;
    L11:
        boolean r17 = true;
    L12:
        r4.put(r10, String.valueOf(r17));
        r4.put(new f2a.f("error_code"), String.valueOf(r34));
        f2a.f r11 = new f2a.f("path");
        String r19 = "";
        if (r30 == null) goto L16;
        r15 = r30;
    L16:
        r4.put(r11, r15);
        r4.put(new f2a.f("audio_duration"), String.valueOf(r31));
        f2a.f r1 = new f2a.f("local_message_id");
        if (r5 == null) goto L20;
        String r12 = r5.getLocalMessageId();
        if (r12 == null) goto L20;
    L21:
        r4.put(r1, r12);
        f2a.f r13 = f2a.f.c;
        if (r27 != null) goto L24;
        String r14 = r19;
    L25:
        r4.put(r13, r14);
        f2a.f r20 = new f2a.f("type");
        if (r29 == null) goto L28;
        String r110 = r29.name();
    L29:
        if (r110 != null) goto L31;
        String r111 = r19;
    L32:
        r4.put(r20, r111);
        r4.put(f2a.f.h, r6);
        f2a.f r21 = f2a.f.e;
        if (r7 != null) goto L35;
        r7 = r19;
    L35:
        r4.put(r21, r7);
        r3.d(r4);
        List r22 = CollectionsKt.listOf(this.b.a);
        f2a.g r23 = r3.c;
        r23.b = r22;
        r23.d = "AsrGlobals.start.onResultState";
        r23.e = this.b.b;
        f2a.c.c(r3, null, 15);
        if (r27 != null) goto L40;
        FLogger.a.w("AsrGlobals", "onResultState no taskId");
        return;
    L40:
        if (r29 != AsrCallBackType.AS_SUCCESS) goto L89;
        AsrGlobals r24 = AsrGlobals.a;
        Message r25 = this.c;
        c0 r26 = this.b;
        if (r35 != null) goto L44;
        String r32 = r19;
    L45:
        if (r36 != null) goto L47;
        String r112 = r19;
    L48:
        if (r37 != null) goto L50;
        String r38 = r19;
    L51:
        com.larus.audio.c r39 = new com.larus.audio.c(r30, r32, r112, r38);
        ConcurrentHashMap<String, z> r113 = AsrGlobals.k;
        z r40 = r113.get(r27);
        if (r40 == null) goto L73;
        f2a.c r41 = r2.b("trigger callback [onSuccess] is not null");
        LinkedHashMap r42 = new LinkedHashMap();
        f2a.f r0 = new f2a.f("path");
        if (r30 != null) goto L56;
        String r43 = r19;
    L57:
        r42.put(r0, r43);
        r42.put(new f2a.f("audio_duration"), String.valueOf(r31));
        f2a.f r44 = new f2a.f("local_message_id");
        if (r25 == null) goto L61;
        String r45 = r25.getLocalMessageId();
        if (r45 == null) goto L61;
    L62:
        r42.put(r44, r45);
        f2a.f r46 = new f2a.f("asr_result_size");
        if (r210 == null) goto L65;
        Integer r47 = Integer.valueOf(r210.length());
    L66:
        r42.put(r46, String.valueOf(r47));
        r42.put(new f2a.f("callback_map_size"), String.valueOf(r113.size()));
        r42.put(r13, r27);
        r41.d(r42);
        List r48 = CollectionsKt.listOf(r26.a);
        f2a.g r49 = r41.c;
        r49.b = r48;
        r49.e = r26.b;
        r49.d = "AsrGlobals.triggerFail";
        f2a.c.c(r41, null, 15);
        if (r210 != null) goto L69;
        String r50 = r19;
    L70:
        Intrinsics.checkNotNullParameter(r27, "taskId");
        Intrinsics.checkNotNullParameter(r50, "asrResult");
        Intrinsics.checkNotNullParameter(r33, "vid");
        Intrinsics.checkNotNullParameter(r39, "extra");
        Function1<com.larus.audio.b, Unit> r114 = r40.a;
        if (r114 == null) goto L80;
        r114.invoke(new com.larus.audio.b(r27, r50, r31, r33, r30, r39, 16));
    L80:
        r113.remove(r27);
        if (r210 != null) goto L83;
    L84:
        r16 = true;
    L85:
        if (r16 == false) goto L87;
        AsrGlobals.i(r27, "asr_recog_empty", 3);
    L87:
        w r51 = this;
    L122:
        b r52 = r51.a;
        if (r52 == null) goto L126;
        b.a.a(r52, r27, r29, r210, r30, r31, r33, r37, 448);
        return;
    L126:
        return;
    L83:
        if (r210.length() != 0) goto L85;
    L69:
        r50 = r210;
        goto L70
    L65:
        r47 = null;
    L61:
        r45 = r19;
        goto L62
    L56:
        r43 = r30;
        goto L57
    L73:
        if (r30 != null) goto L75;
        String r53 = r19;
    L76:
        if (r210 == null) goto L79;
        r19 = r210;
    L79:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AsrGlobals$triggerSuccessCallbackWhenIsNull$1(r27, r25, r26, r19, r53, r31, null), 3, null);
        goto L80
    L75:
        r53 = r30;
        goto L76
    L50:
        r38 = r37;
        goto L51
    L47:
        r112 = r36;
        goto L48
    L44:
        r32 = r35;
        goto L45
    L89:
        if (r29 != AsrCallBackType.ASR_FAILED_TOKEN) goto L95;
        c68.b.a("AsrGlobals", "called: ASR_FAILED_TOKEN");
        AsrGlobals r54 = AsrGlobals.a;
        ((w78.f) AsrGlobals.h.getValue()).a.a(true);
        AsrGlobals.i(r27, "asr_recog_failed_token", 3);
        r51 = this;
        Message r55 = r51.c;
        if (r30 != null) goto L93;
        String r56 = r19;
    L94:
        AsrGlobals.j(r55, r27, r56, r31, r34, r51.b);
        goto L122
    L93:
        r56 = r30;
        goto L94
    L95:
        r51 = this;
        if (r29 != AsrCallBackType.ASR_CANCEL) goto L103;
        c68.b.a("AsrGlobals", "called: ASR_ASR_CANCEL");
        AsrGlobals r57 = AsrGlobals.a;
        AsrGlobals.i(r27, "asr_recog_cancel", 3);
        Message r59 = r51.c;
        if (r30 != null) goto L100;
        String r60 = r19;
    L101:
        AsrGlobals.j(r59, r27, r60, r31, r34, r51.b);
        goto L122
    L100:
        r60 = r30;
        goto L101
    L103:
        if (r29 != AsrCallBackType.ASR_STREAM) goto L117;
        m58.q r61 = m58.h.d;
        if (r61 == null) goto L111;
        ASRModule r62 = r61.c();
        if (r62 == null) goto L111;
        if (r62.o() != true) goto L111;
        r16 = true;
    L111:
        if (r16 == false) goto L113;
        String r115 = "[stream]";
    L114:
        Function1<? super String, Unit> r63 = AsrGlobals.c;
        if (r63 == null) goto L122;
        r63.invoke(r115 + r210);
        goto L122
    L113:
        r115 = r19;
        goto L114
    L117:
        c68.b.a("AsrGlobals", "called: ASR_Failed");
        AsrGlobals r64 = AsrGlobals.a;
        AsrGlobals.i(r27, "asr_recog_err", 1);
        Message r65 = r51.c;
        if (r30 != null) goto L120;
        String r66 = r19;
    L121:
        AsrGlobals.j(r65, r27, r66, r31, r34, r51.b);
        goto L122
    L120:
        r66 = r30;
        goto L121
    L31:
        r111 = r110;
        goto L32
    L28:
        r110 = null;
        goto L29
    L24:
        r14 = r27;
    L20:
        r12 = r19;
        goto L21
    L8:
        if (r210.length() == 0) goto L11;
        r17 = false;
        goto L12
    }
}
