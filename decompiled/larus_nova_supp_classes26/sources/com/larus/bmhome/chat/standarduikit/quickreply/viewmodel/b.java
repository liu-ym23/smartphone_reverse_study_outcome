package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import java.util.Map;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final Map<String, String> f;
    public final Function6<String, QuickReplyBlock, String, QuickReplyItem, Integer, Integer, Boolean> g;
    public final Integer h;
    public final QuickReplyBlock i;
    public final ChatPageContext j;
    public final String k;
    public final Message l;

    public b() {
        this(null, null, null, null, 0, null, null, null, 4095);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
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
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L44;
        return false;
    L44:
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
        long r13 = this.e;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        Map<String, String> r15 = this.f;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        Function6<String, QuickReplyBlock, String, QuickReplyItem, Integer, Integer, Boolean> r18 = this.g;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        Integer r21 = this.h;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        QuickReplyBlock r24 = this.i;
        if (r24 != null) goto L33;
        int r25 = 0;
    L34:
        int r26 = (r23 + r25) * 31;
        ChatPageContext r27 = this.j;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        String r30 = this.k;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        Message r33 = this.l;
        if (r33 == null) goto L47;
        r1 = r33.hashCode();
    L47:
        return r32 + r1;
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r28 = r27.hashCode();
        goto L38
    L33:
        r25 = r24.hashCode();
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
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
        return "QuickReplyVMData(conversationId=" + this.a + ", referenceMessageId=" + this.b + ", botId=" + this.c + ", currentPage=" + this.d + ", previousBlockCompleteTimeMs=" + this.e + ", messageExt=" + this.f + ", customClickListener=" + this.g + ", itemBackgroundRes=" + this.h + ", quickReplyBlock=" + this.i + ", chatPageContext=" + this.j + ", blockId=" + this.k + ", message=" + this.l + ')';
    }

    public /* synthetic */ b(String r18, String r19, String r20, String r21, long r22, Map r24, QuickReplyBlock r25, String r26, int r27) {
        if ((r27 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r27 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r27 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r27 & 16) == 0) goto L21;
        long r8 = 0;
    L23:
        if ((r27 & 32) == 0) goto L25;
        Map r10 = null;
    L27:
        if ((r27 & 256) == 0) goto L29;
        QuickReplyBlock r13 = null;
    L31:
        if ((r27 & 1024) == 0) goto L33;
        String r15 = null;
    L34:
        this(r4, r5, r6, r7, r8, r10, null, null, r13, null, r15, null);
        return;
    L33:
        r15 = r26;
        goto L34
    L29:
        r13 = r25;
        goto L31
    L25:
        r10 = r24;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r1, String r2, String r3, String r4, long r5, Map<String, String> r7, Function6<? super String, ? super QuickReplyBlock, ? super String, ? super QuickReplyItem, ? super Integer, ? super Integer, Boolean> r8, Integer r9, QuickReplyBlock r10, ChatPageContext r11, String r12, Message r13) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
