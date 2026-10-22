package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.asr.a5;
import com.larus.asr.c5;
import com.larus.im.bean.message.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class i3 implements Function1 {
    public final /* synthetic */ SendMessageAsrSession a;
    public final /* synthetic */ com.larus.audio.asr.c0 b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ String d;
    public final /* synthetic */ VoiceInputType e;

    public /* synthetic */ i3(SendMessageAsrSession r1, com.larus.audio.asr.c0 r2, Message r3, String r4, VoiceInputType r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r54) {
        final SendMessageAsrSession r7 = this.a;
        com.larus.audio.asr.c0 r1 = this.b;
        final Message r3 = this.c;
        final String r5 = this.d;
        final VoiceInputType r6 = this.e;
        final String r4 = (String) r54;
        r7.o = r4;
        f2a.c r2 = r7.g.b("asrGlobalStream invoke");
        LinkedHashMap r8 = new LinkedHashMap();
        f2a.f r9 = new f2a.f("is_empty_asr_result");
        if (r4.length() != 0) goto L5;
        boolean r10 = true;
    L6:
        r8.put(r9, String.valueOf(r10));
        r8.put(new f2a.f("is_cancel"), String.valueOf(r7.f));
        f2a.f r11 = f2a.f.d;
        String r12 = g2a.d.b(r4);
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        r8.put(r11, r12);
        r8.put(f2a.f.c, r5);
        r2.d(r8);
        List r13 = CollectionsKt.listOf(r1.a);
        f2a.g r14 = r2.c;
        r14.b = r13;
        r14.d = "asrGlobalStream";
        r14.e = r1.b;
        f2a.c.c(r2, null, 15);
        HashMap<String, Function0<Unit>> r15 = a5.a;
        a5.c(r3.getLocalMessageId());
        if (r7.g() == true) goto L12;
        r7.e().streamAudioText(Message.copy$default(r3, null, null, null, 0, 0, null, 0, false, null, r4, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -513, 31, null));
    L12:
        HashSet<String> r16 = c5.a;
        c5.a(r3.getLocalMessageId(), new j3(r7, r3, r4, r5, r6));
        r7.oa(new com.larus.bmhome.chat.component.bottom.core.speaker.g.d(r4));
        return Unit.INSTANCE;
    L5:
        r10 = false;
        goto L6
    }
}
