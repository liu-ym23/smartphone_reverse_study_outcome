package com.obric.assistant.component.clicktalk;

import com.larus.asr.VoiceInputType;
import com.larus.utils.logger.FLogger;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d0 implements Function0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ChatClickTalkComponent e;
    public final /* synthetic */ Integer f;
    public final /* synthetic */ String g;
    public final /* synthetic */ ChatClickTalkComponent$a h;

    public /* synthetic */ d0(boolean r1, boolean r2, boolean r3, int r4, ChatClickTalkComponent r5, Integer r6, String r7, ChatClickTalkComponent$a r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final Object invoke() {
        boolean r0 = this.a;
        boolean r1 = this.b;
        boolean r2 = this.c;
        int r3 = this.d;
        final ChatClickTalkComponent r5 = this.e;
        final Integer r9 = this.f;
        final String r8 = this.g;
        final ChatClickTalkComponent$a r6 = this.h;
        int r4 = ChatClickTalkComponent.L0;
        StateFlowImpl r7 = m0.a;
        final String r10 = UUID.randomUUID().toString();
        boolean r11 = true;
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        if (r2 == false) goto L7;
        VoiceInputType r12 = VoiceInputType.DoraVoiceSpeaker;
    L10:
        final VoiceInputType r13 = r12;
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("voiceInputType ");
        r15.append(r13);
        r15.append(", isDoraWakeUp ");
        if (r0 == false) goto L14;
        if (r1 == false) goto L14;
    L15:
        r15.append(r11);
        r15.append(", isDoraVuiWakeup=");
        r15.append(r2);
        r14.i("ChatClickTalkComponent", r15.toString());
        r5.getClass();
        com.larus.utils.l0.b(new t(r5, r6, r10, r8, r9, r13));
        return Unit.INSTANCE;
    L14:
        r11 = false;
    L7:
        if (r3 != 1) goto L9;
        r12 = VoiceInputType.ThirdPartySpeaker;
        goto L10
    L9:
        r12 = VoiceInputType.ClickSpeaker;
        goto L10
    }
}
