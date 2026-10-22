package com.obric.assistant.chat.component.interaction;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class TouchSpeakerEventComponent$b {
    public final String a;
    public final int b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public String f;
    public String g;
    public Job h;
    public boolean i;
    public boolean j;
    public boolean k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TouchSpeakerEventComponent$b) == true) goto L8;
        return false;
    L8:
        TouchSpeakerEventComponent$b r6 = (TouchSpeakerEventComponent$b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        String r6 = this.f;
        int r7 = 0;
        if (r6 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r5 + r8) * 31;
        String r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Job r13 = this.h;
        if (r13 == null) goto L22;
        r7 = r13.hashCode();
    L22:
        int r14 = (r12 + r7) * 31;
        if (this.i == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        if (this.j == false) goto L29;
        int r17 = 1231;
    L30:
        int r18 = (r16 + r17) * 31;
        if (this.k == true) goto L35;
        r2 = 1237;
    L35:
        return r18 + r2;
    L29:
        r17 = 1237;
        goto L30
    L25:
        r15 = 1237;
        goto L26
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "TouchSpeakAttempt(captureSessionId=" + this.a + ", sourceType=" + this.b + ", conversationId=" + this.c + ", hasAttachment=" + this.d + ", isRadio=" + this.e + ", resolvedBotId=" + this.f + ", modeSessionId=" + this.g + ", resolveBotJob=" + this.h + ", captureStarted=" + this.i + ", asrStarted=" + this.j + ", asrStartDispatched=" + this.k + ')';
    }

    public TouchSpeakerEventComponent$b(String r2, int r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "captureSessionId");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = false;
        this.k = false;
    }
}
