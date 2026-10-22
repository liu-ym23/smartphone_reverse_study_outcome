package com.obric.assistant.component.clicktalk;

import com.larus.asr.VoiceInputType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ ChatClickTalkComponent a;
    public final /* synthetic */ ChatClickTalkComponent$a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Integer e;
    public final /* synthetic */ VoiceInputType f;
    public final /* synthetic */ String g;

    public /* synthetic */ h(ChatClickTalkComponent r1, ChatClickTalkComponent$a r2, String r3, String r4, Integer r5, VoiceInputType r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r9) {
        ChatClickTalkComponent r0 = this.a;
        ChatClickTalkComponent$a r6 = this.b;
        String r1 = this.c;
        String r2 = this.d;
        Integer r3 = this.e;
        VoiceInputType r4 = this.f;
        String r5 = this.g;
        boolean r10 = ((Boolean) r9).booleanValue();
        int r7 = ChatClickTalkComponent.L0;
        if (r0.p3(r6) == true) goto L13;
        if (r10 == false) goto L8;
        r0.c4(r1, r2, r3, r4, r5, r6);
    L12:
        return Unit.INSTANCE;
    L8:
        if (r0.p3(r6) == true) goto L12;
        r0.h4(r6);
        r0.j4(false, "record_audio_denied");
        r0.C3("blocked", "record_audio_denied", r5);
        goto L12
    L13:
        return Unit.INSTANCE;
    }
}
