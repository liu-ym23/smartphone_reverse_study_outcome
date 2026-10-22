package com.larus.browsertakeover.transport;

import com.larus.im.service.audio.x0;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r11) {
        if (r11 != null) goto L5;
        return "null";
    L5:
        String r1 = StringsKt.take(r11, 256);
        ArrayList r2 = new ArrayList(r1.length());
        int r3 = 0;
    L7:
        if (r3 >= r1.length()) goto L16;
        char r4 = r1.charAt(r3);
        if (Character.isISOControl(r4) == false) goto L11;
    L14:
        r4 = ' ';
    L15:
        r2.add(Character.valueOf(r4));
        r3 = r3 + 1;
        goto L7
    L11:
        if (r4 == 8232) goto L14;
        if (r4 != 8233) goto L15;
    L16:
        String r5 = CollectionsKt.joinToString$default(r2, "", null, null, 0, null, null, 62, null);
        if (r11.length() > 256) goto L19;
        return r5;
    L19:
        return r5 + 8230;
    }

    public static String b(x0 r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        StringBuilder r0 = new StringBuilder("MediaSessionConfig(bizId=");
        r0.append(a(r5.a));
        r0.append(", sessionType=");
        r0.append(r5.b);
        r0.append(", enablePseudo=");
        r0.append(r5.l);
        r0.append(", userIDPresent=");
        boolean r2 = false;
        if (r5.c == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(", deviceIdPresent=");
        if (r5.d == null) goto L9;
        boolean r3 = true;
    L10:
        r0.append(r3);
        r0.append(", conversationIdPresent=");
        if (r5.i == null) goto L13;
        boolean r4 = true;
    L14:
        r0.append(r4);
        r0.append(", botIdPresent=");
        if (r5.j == null) goto L17;
        boolean r6 = true;
    L18:
        r0.append(r6);
        r0.append(", localCallIdPresent=");
        if (r5.h == null) goto L21;
        boolean r7 = true;
    L22:
        r0.append(r7);
        r0.append(", appVersion=");
        r0.append(a(r5.e));
        r0.append(", updateVersionCode=");
        r0.append(r5.f);
        r0.append(", packageType=");
        r0.append(a(r5.g));
        r0.append(", extraCount=");
        r0.append(r5.m.size());
        r0.append(", mmtConfigPresent=");
        if (r5.n == null) goto L25;
        boolean r8 = true;
    L26:
        r0.append(r8);
        r0.append(", rtcConfigPresent=");
        if (r5.o == null) goto L29;
        boolean r9 = true;
    L30:
        r0.append(r9);
        r0.append(", audioKit=");
        com.larus.im.service.audio.c r10 = r5.k;
        StringBuilder r11 = new StringBuilder("AvAudioKitConfig(audioKitMode=");
        r11.append(r10.f);
        r11.append(", playAudioChannel=");
        r11.append(r10.a);
        r11.append(", playAudioSampleRate=");
        r11.append(r10.b);
        r11.append(", recordAudioChannel=");
        r11.append(r10.c);
        r11.append(", recordAudioSampleRate=");
        r11.append(r10.d);
        r11.append(", recorderFormatFrameMs=");
        r11.append(r10.e);
        r11.append(", enableSpeechAec=");
        r11.append(r10.g);
        r11.append(", useRemoteModel=");
        r11.append(r10.j);
        r11.append(", speechAecOutputType=");
        r11.append(r10.k);
        r11.append(", speechAecModelPathPresent=");
        if (r10.h.length() <= 0) goto L33;
        boolean r12 = true;
    L34:
        r11.append(r12);
        r11.append(", audioxModelPathPresent=");
        if (r10.i.length() <= 0) goto L37;
        boolean r13 = true;
    L38:
        r11.append(r13);
        r11.append(", speechAecDumpPathPresent=");
        if (r10.l.length() <= 0) goto L41;
        r2 = true;
    L41:
        r11.append(r2);
        r11.append(')');
        r0.append(r11.toString());
        r0.append(')');
        return r0.toString();
    L37:
        r13 = false;
        goto L38
    L33:
        r12 = false;
        goto L34
    L29:
        r9 = false;
        goto L30
    L25:
        r8 = false;
        goto L26
    L21:
        r7 = false;
        goto L22
    L17:
        r6 = false;
        goto L18
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }
}
