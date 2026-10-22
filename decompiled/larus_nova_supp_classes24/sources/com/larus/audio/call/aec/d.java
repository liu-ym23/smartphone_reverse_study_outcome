package com.larus.audio.call.aec;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.structures.SAMICoreAudioBin;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ f a;

    public /* synthetic */ d(f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r0 = this.a;
        if (r0.c == false) goto L5;
        return;
    L5:
        if (r0.h == true) goto L11;
        com.larus.audio.call.util.e r1 = com.larus.audio.call.util.e.a;
        String r4 = r0.b;
        StringBuilder r5 = new StringBuilder("[startProcess] running, queue is null: ");
        if (r0.d != null) goto L9;
        boolean r6 = true;
    L10:
        r5.append(r6);
        r1.i(r4, r5.toString());
        r0.h = true;
        goto L11
    L9:
        r6 = false;
    L11:
        ConcurrentLinkedQueue r2 = r0.d;
        if (r2 == null) goto L14;
    L16:
        if (r2 != null) goto L18;
    L20:
        ConcurrentLinkedQueue r3 = r0.d;
        if (r3 == null) goto L46;
        SAMICoreVoiceAssistantAudioData r7 = (SAMICoreVoiceAssistantAudioData) r3.poll();
        if (r7 == null) goto L52;
        SAMICoreBlock r8 = new SAMICoreBlock();
        r8.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
        r8.audioData = new SAMICoreVoiceAssistantAudioData[]{r7};
        r8.numberAudioData = 1;
        SAMICoreBlock r9 = new SAMICoreBlock();
        if (r0.c == false) goto L30;
        com.larus.audio.call.util.e.a.i(r0.b, "[startProcess] destroy");
        Function1 r10 = r0.e;
        if (r10 == null) goto L47;
        r10.invoke(null);
        return;
    L47:
        return;
    L30:
        int r11 = r0.a.SAMICoreProcess(r8, r9);
        if (r11 == 0) goto L38;
        if (r11 == 150009) goto L38;
        com.larus.audio.call.util.e.a.i(r0.b, "[startProcess] fail");
        Function1 r12 = r0.e;
        if (r12 == null) goto L38;
        r12.invoke(null);
    L38:
        if (r9.dataType != SAMICoreDataType.SAMICoreDataType_AudioBin) goto L49;
        Object[] r13 = r9.audioData;
        if (r13 == null) goto L50;
        Object r14 = r13[0];
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.mammon.audiosdk.structures.SAMICoreAudioBin");
        SAMICoreAudioBin r15 = (SAMICoreAudioBin) r14;
        Function1 r16 = r0.e;
        if (r16 == null) goto L51;
        r16.invoke(r15.audioData);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L52:
        return;
    L46:
        return;
    L18:
        if (r0.g == true) goto L20;
        com.larus.audio.call.util.e.a.e(r0.b, "[startProcess] queue valid");
        r0.g = true;
        goto L20
    L14:
        if (r0.g == false) goto L16;
        com.larus.audio.call.util.e.a.e(r0.b, "[startProcess] queue error");
        r0.g = false;
        goto L20
    }
}
