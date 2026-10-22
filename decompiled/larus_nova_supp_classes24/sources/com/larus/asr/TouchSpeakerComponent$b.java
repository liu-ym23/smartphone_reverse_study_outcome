package com.larus.asr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.asr.direct.IAsrDirectFillAbility;
import com.larus.audio.asr.c0;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.trace.l0;
import com.larus.trace.SendingTextEditTriggeredScene;
import com.larus.utils.logger.FLogger;
import f58.a;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class TouchSpeakerComponent$b extends Handler {
    public final /* synthetic */ TouchSpeakerComponent a;

    @Override // android.os.Handler
    public final void handleMessage(Message r20) {
        Intrinsics.checkNotNullParameter(r20, "msg");
        com.larus.platform.service.z2 r2 = com.larus.platform.service.z2.a;
        boolean r4 = true;
        if (r2.m3() == false) goto L8;
        boolean r3 = com.larus.bmhome.utils.e.a;
        if (r2.disableVoiceInput() == true) goto L8;
        boolean r5 = false;
    L9:
        if (r5 == false) goto L11;
        return;
    L11:
        maa.e r6 = (maa.e) this.a.s.getValue();
        if (r6 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L19;
        return;
    L19:
        x5.b().c();
        int r8 = r20.what;
        boolean r9 = r20.getData().getBoolean("from_text_area", false);
        String r10 = r20.getData().getString("asr_input_trace_id");
        String r11 = "";
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        String r1 = r20.getData().getString("asr_input_enter_from");
        if (r1 == null) goto L26;
        r11 = r1;
    L26:
        f2a.c r12 = this.a.w.b("handleMessage");
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put(new f2a.f("message"), String.valueOf(r8));
        r13.put(new f2a.f("from_text_area"), String.valueOf(r9));
        r12.d(r13);
        List r14 = CollectionsKt.listOf(r10);
        f2a.g r15 = r12.c;
        r15.b = r14;
        r15.d = "handler.handleMessage";
        r15.e = r11;
        f2a.c.c(r12, null, 15);
        FLogger.a.i("TouchSpeakerComponent", "actionSpeak handleMessage what: " + r8);
        if (r8 == 10001) goto L29;
        return;
    L29:
        if (this.a.z3().speakerTouchEnable() == true) goto L32;
        this.a.C3(2131907356, false);
        return;
    L32:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r16 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.a.m.getValue();
        if (r16 != null) goto L35;
    L37:
        r4 = false;
    L38:
        if (r4 == false) goto L42;
        s r17 = s.a;
        Context r19 = this.a.getContext();
        r17.getClass();
        s.s(r19, 2131910343);
        f2a.c r21 = this.a.w.a("handleMessage, but enableSpeakerHandleTouch is false");
        LinkedHashMap r22 = new LinkedHashMap();
        r22.put(new f2a.f("message"), String.valueOf(r8));
        r22.put(new f2a.f("from_text_area"), String.valueOf(r9));
        r21.d(r22);
        List r23 = CollectionsKt.listOf(r10);
        f2a.g r24 = r21.c;
        r24.b = r23;
        r24.d = "handler.handleMessage";
        r24.e = r11;
        f2a.c.c(r21, null, 15);
        return;
    L42:
        if (TouchSpeakerComponent.F2(this.a) == false) goto L44;
        return;
    L44:
        c0 r110 = new c0(r10, r11, 0, 252);
        if (this.a.B3() == false) goto L49;
        IAsrDirectFillAbility r25 = this.a.m3();
        if (r25 == null) goto L52;
        r25.il(r9, r110);
    L52:
        u7 r26 = (u7) this.a.l.getValue();
        if (r26 == null) goto L57;
        l0 r27 = r26.ON();
        if (r27 == null) goto L57;
        r27.w(SendingTextEditTriggeredScene.ASR);
    L57:
        a.a("long_press");
        return;
    L49:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r29 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.a.m.getValue();
        if (r29 == null) goto L52;
        com.larus.bmhome.chat.component.bottom.core.speaker.l.a.a(r29, r9, this.a.X2(), VoiceInputType.TouchSpeaker, true, r110, null, null, null, null, null, 992);
        goto L52
    L35:
        if (r16.N70() == true) goto L37;
    L14:
        if (r6.Ds() != true) goto L16;
        r7 = true;
    L8:
        r5 = true;
        goto L9
    }

    public TouchSpeakerComponent$b(TouchSpeakerComponent r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
