package com.larus.bmhome.clarification;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.InteractionAskQuestion;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d2 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final Message f;
    public final Block g;
    public final List<InteractionAskQuestion> h;
    public final v1 i;
    public final int j;
    public final ze8.b k;
    public final List<z1> l;
    public final long m;
    public final com.larus.bmhome.interactionpanel.w n;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d2) == true) goto L8;
        return false;
    L8:
        d2 r9 = (d2) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j) * 31;
        ze8.b r1 = this.k;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.l.hashCode()) * 31;
        long r5 = this.m;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        com.larus.bmhome.interactionpanel.w r7 = this.n;
        if (r7 == null) goto L11;
        r2 = r7.hashCode();
    L11:
        return r6 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClarificationSession(conversationId=" + this.a + ", messageId=" + this.b + ", blockId=" + this.c + ", clarifyId=" + this.d + ", status=" + this.e + ", triggerMessage=" + this.f + ", triggerBlock=" + this.g + ", questions=" + this.h + ", inputSnapshot=" + this.i + ", currentIndex=" + this.j + ", panelSession=" + this.k + ", pageStates=" + this.l + ", createdAt=" + this.m + ", trackContext=" + this.n + ')';
    }

    public static d2 a(d2 r20, Message r21, int r22, ze8.b r23, List r24, com.larus.bmhome.interactionpanel.w r25, int r26) {
        v1 r3 = null;
        if ((r26 & 1) == 0) goto L5;
        String r5 = r20.a;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r6 = r20.b;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r7 = r20.c;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r8 = r20.d;
    L19:
        if ((r26 & 16) == 0) goto L21;
        int r9 = r20.e;
    L23:
        if ((r26 & 32) == 0) goto L25;
        Message r10 = r20.f;
    L27:
        if ((r26 & 64) == 0) goto L29;
        Block r11 = r20.g;
    L31:
        if ((r26 & 128) == 0) goto L33;
        List<InteractionAskQuestion> r12 = r20.h;
    L35:
        if ((r26 & 256) == 0) goto L37;
        r3 = r20.i;
    L37:
        v1 r13 = r3;
        if ((r26 & 512) == 0) goto L40;
        int r14 = r20.j;
    L42:
        if ((r26 & 1024) == 0) goto L44;
        ze8.b r15 = r20.k;
    L46:
        if ((r26 & 2048) == 0) goto L48;
        List r2 = r20.l;
    L50:
        if ((r26 & 4096) == 0) goto L52;
        long r4 = r20.m;
    L53:
        long r17 = r4;
        if ((r26 & 8192) == 0) goto L56;
        com.larus.bmhome.interactionpanel.w r19 = r20.n;
    L57:
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Intrinsics.checkNotNullParameter(r7, "blockId");
        Intrinsics.checkNotNullParameter(r8, "clarifyId");
        Intrinsics.checkNotNullParameter(r10, "triggerMessage");
        Intrinsics.checkNotNullParameter(r11, "triggerBlock");
        Intrinsics.checkNotNullParameter(r12, "questions");
        Intrinsics.checkNotNullParameter(r13, "inputSnapshot");
        Intrinsics.checkNotNullParameter(r2, "pageStates");
        return new d2(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r17, r19);
    L56:
        r19 = r25;
        goto L57
    L52:
        r4 = 0;
        goto L53
    L48:
        r2 = r24;
        goto L50
    L44:
        r15 = r23;
        goto L46
    L40:
        r14 = r22;
        goto L42
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = r21;
        goto L27
    L21:
        r9 = 0;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public d2(String r12, String r13, String r14, String r15, int r16, Message r17, Block r18, List<InteractionAskQuestion> r19, v1 r20, int r21, ze8.b r22, List<z1> r23, long r24, com.larus.bmhome.interactionpanel.w r26) {
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r13, "messageId");
        Intrinsics.checkNotNullParameter(r14, "blockId");
        Intrinsics.checkNotNullParameter(r15, "clarifyId");
        Intrinsics.checkNotNullParameter(r17, "triggerMessage");
        Intrinsics.checkNotNullParameter(r18, "triggerBlock");
        Intrinsics.checkNotNullParameter(r19, "questions");
        Intrinsics.checkNotNullParameter(r20, "inputSnapshot");
        Intrinsics.checkNotNullParameter(r23, "pageStates");
        this.a = r12;
        this.b = r13;
        this.c = r14;
        this.d = r15;
        this.e = r16;
        this.f = r17;
        this.g = r18;
        this.h = r19;
        this.i = r20;
        this.j = r21;
        this.k = r22;
        this.l = r23;
        this.m = r24;
        this.n = r26;
    }
}
