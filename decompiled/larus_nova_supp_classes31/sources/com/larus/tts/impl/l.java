package com.larus.tts.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class l implements Function2 {
    public final /* synthetic */ ChatTitleTtsComponent a;

    public /* synthetic */ l(ChatTitleTtsComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r8, Object r9) {
        ChatTitleTtsComponent r0 = this.a;
        e r10 = (e) r8;
        e r11 = (e) r9;
        int r1 = ChatTitleTtsComponent.v;
        String r2 = null;
        if (r10 == null) goto L5;
        String r3 = r10.a;
    L6:
        if (r11 == null) goto L8;
        String r4 = r11.a;
    L9:
        boolean r5 = Intrinsics.areEqual(r3, r4);
        boolean r6 = false;
        if (r5 == false) goto L71;
        if (r10 == null) goto L13;
        Integer r7 = r10.j;
    L14:
        if (r11 == null) goto L16;
        Integer r12 = r11.j;
    L18:
        if (Intrinsics.areEqual(r7, r12) == false) goto L71;
        if (r10 == null) goto L21;
        String r13 = r10.r;
    L22:
        if (r11 == null) goto L24;
        r2 = r11.r;
    L24:
        r0.getClass();
        if (r13 != null) goto L28;
        if (r2 != null) goto L28;
        boolean r14 = true;
    L68:
        if (r14 == false) goto L71;
        r6 = true;
    L28:
        if (r13 == null) goto L67;
        if (r2 == null) goto L67;
        int r15 = r13.length() - 1;     // Catch: Exception -> L66
        int r16 = 0;
        boolean r17 = false;
    L33:
        if (r16 > r15) goto L48;
        if (r17 == true) goto L36;
        int r18 = r16;
    L38:
        if (Intrinsics.compare(r13.charAt(r18), 32) > 0) goto L40;
        boolean r19 = true;
    L41:
        if (r17 == false) goto L42;
        if (r19 == false) goto L48;
        r15 = r15 - 1;     // Catch: Exception -> L66
        goto L33
    L42:
        if (r19 == false) goto L43;
        r16 = r16 + 1;     // Catch: Exception -> L66
        goto L33
    L43:
        r17 = true;
        goto L33
    L40:
        r19 = false;
        goto L41
    L36:
        r18 = r15;
    L48:
        String r20 = r13.subSequence(r16, r15 + 1).toString();     // Catch: Exception -> L66
        int r21 = r2.length() - 1;     // Catch: Exception -> L66
        int r22 = 0;
        boolean r23 = false;
    L49:
        if (r22 > r21) goto L64;
        if (r23 == true) goto L52;
        int r24 = r22;
    L54:
        if (Intrinsics.compare(r2.charAt(r24), 32) > 0) goto L56;
        boolean r25 = true;
    L57:
        if (r23 == false) goto L58;
        if (r25 == false) goto L64;
        r21 = r21 - 1;     // Catch: Exception -> L66
        goto L49
    L58:
        if (r25 == false) goto L59;
        r22 = r22 + 1;     // Catch: Exception -> L66
        goto L49
    L59:
        r23 = true;
        goto L49
    L56:
        r25 = false;
        goto L57
    L52:
        r24 = r21;
    L64:
        String r26 = r2.subSequence(r22, r21 + 1).toString();     // Catch: Exception -> L66
        JsonParser r27 = new JsonParser();     // Catch: Exception -> L66
        JsonElement r28 = r27.parse(r20);     // Catch: Exception -> L66
        JsonElement r29 = r27.parse(r26);     // Catch: Exception -> L66
        FLogger.a.i("ChatTitleTtsComponent", "compareJsonStrings, isEqual: " + r28.equals(r29));     // Catch: Exception -> L66
        r14 = r28.equals(r29);     // Catch: Exception -> L66
    L67:
        r14 = false;
        goto L68
    L21:
        r13 = null;
        goto L22
    L16:
        r12 = null;
        goto L18
    L13:
        r7 = null;
    L71:
        return Boolean.valueOf(r6);
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }
}
