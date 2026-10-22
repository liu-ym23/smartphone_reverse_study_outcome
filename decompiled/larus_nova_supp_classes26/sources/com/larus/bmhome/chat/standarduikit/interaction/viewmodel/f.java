package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import com.larus.bmhome.interactionpanel.w;
import com.larus.im.bean.message.block.QuickReplyBlock;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Map<String, String> f;
    public final long g;
    public final QuickReplyBlock h;
    public final w i;

    public f() {
        this(null, null, null, null, null, 0, null, null, 511);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
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
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        long r19 = this.g;
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        QuickReplyBlock r21 = this.h;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        w r24 = this.i;
        if (r24 == null) goto L35;
        r1 = r24.hashCode();
    L35:
        return r23 + r1;
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionQuickReplyVMData(messageId=" + this.a + ", blockId=" + this.b + ", conversationId=" + this.c + ", botId=" + this.d + ", currentPage=" + this.e + ", messageExt=" + this.f + ", previousBlockCompleteTimeMs=" + this.g + ", quickReplyBlock=" + this.h + ", trackContext=" + this.i + ')';
    }

    public f(String r3, String r4, String r5, String r6, Map r7, long r8, QuickReplyBlock r10, w r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r12 & 32) == 0) goto L18;
        r7 = null;
    L18:
        if ((r12 & 64) == 0) goto L21;
        r8 = 0;
    L21:
        if ((r12 & 128) == 0) goto L24;
        r10 = null;
    L24:
        if ((r12 & 256) == 0) goto L26;
        r11 = null;
    L26:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = null;
        this.f = r7;
        this.g = r8;
        this.h = r10;
        this.i = r11;
    }
}
