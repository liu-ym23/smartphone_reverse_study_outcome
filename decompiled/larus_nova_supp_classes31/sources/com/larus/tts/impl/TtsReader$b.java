package com.larus.tts.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class TtsReader$b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final p68.i f;
    public final boolean g;
    public final String h;
    public final String i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TtsReader$b) == true) goto L8;
        return false;
    L8:
        TtsReader$b r6 = (TtsReader$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
        int r5 = 1231;
        if (this.e == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        p68.i r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        if (this.g == true) goto L18;
        r5 = 1237;
    L18:
        int r11 = (r10 + r5) * 31;
        String r12 = this.h;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.i;
        if (r15 == null) goto L27;
        r2 = r15.hashCode();
    L27:
        return r14 + r2;
    L21:
        r13 = r12.hashCode();
        goto L22
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "readerQueueTask(taskId=" + this.a + ", questionId=" + this.b + ", conversationId=" + this.c + ", msgId=" + this.d + ", skipTtsChecked=" + this.e + ", voiceStyleInfo=" + this.f + ", isFromManual=" + this.g + ", replyUniqueKey=" + this.h + ", chatNext=" + this.i + ')';
    }

    public TtsReader$b(String r2, String r3, String r4, String r5, boolean r6, p68.i r7, boolean r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "questionId");
        Intrinsics.checkNotNullParameter(r5, "msgId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
