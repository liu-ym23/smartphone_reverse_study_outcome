package com.larus.dispatcher.askhuman.handler;

import androidx.fragment.app.FragmentActivity;
import com.larus.im.bean.message.block.ActionType;
import com.larus.im.bean.message.block.QuickReplyItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o {
    public final QuickReplyItem a;
    public final bs8.h b;
    public final FragmentActivity c;
    public final t d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;
    public final Integer j;
    public final Function1<com.larus.bmhome.taskskill.service.k, Unit> k;
    public final boolean l;
    public final String m;
    public final String n;
    public final String o;
    public final BrowserTakeoverEntryMonitor p;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        FragmentActivity r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.d.hashCode()) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.g.hashCode()) * 31;
        String r11 = this.h;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + this.i) * 31;
        Integer r14 = this.j;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r17 = this.k;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r20 = (r16 + r18) * 31;
        if (this.l == false) goto L29;
        int r21 = 1231;
    L30:
        int r22 = (r20 + r21) * 31;
        String r23 = this.m;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.n;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r30 = this.o;
        if (r30 == null) goto L43;
        r2 = r30.hashCode();
    L43:
        return r28 + r2;
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = 1237;
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "QuickReplyHandleContext(item=" + this.a + ", conversationState=" + this.b + ", fragmentActivity=" + this.c + ", schemaPayload=" + this.d + ", pcDeviceId=" + this.e + ", sourceDeviceId=" + this.f + ", messageId=" + this.g + ", blockId=" + this.h + ", itemIndex=" + this.i + ", interactionType=" + this.j + ", onEvent=" + this.k + ", updateMessageLoading=" + this.l + ", pcGuideRequestKey=" + this.m + ", displayType=" + this.n + ", agentType=" + this.o + ')';
    }

    public o(QuickReplyItem r7, bs8.h r8, FragmentActivity r9, t r10, String r11, String r12, String r13, String r14, int r15, Integer r16, Function1<? super com.larus.bmhome.taskskill.service.k, Unit> r17, boolean r18, String r110, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r7, "item");
        Intrinsics.checkNotNullParameter(r8, "conversationState");
        Intrinsics.checkNotNullParameter(r10, "schemaPayload");
        Intrinsics.checkNotNullParameter(r13, "messageId");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r110;
        this.n = r20;
        this.o = r21;
        int r4 = BrowserTakeoverEntryMonitor.e;
        Intrinsics.checkNotNullParameter(this, "context");
        Integer r1 = r7.getActionType();
        int r5 = ActionType.CUA_REQUEST_ACTION_BROWSER_OPERATION.getValue();
        BrowserTakeoverEntryMonitor r6 = null;
        String r22 = null;
        r6 = null;
        if (r1 != null) goto L6;
    L20:
        this.p = r6;
        return;
    L6:
        if (r1.intValue() != r5) goto L20;
        f r2 = r10.f;
        if (r2 == null) goto L13;
        boolean r3 = true;
        if (r2.a != true) goto L13;
    L14:
        if (r3 == false) goto L17;
        r22 = "cloud";
    L19:
        r6 = new BrowserTakeoverEntryMonitor(r22);
        goto L20
    L17:
        if (r8.a() == false) goto L19;
        r22 = "local_pc";
    L13:
        r3 = false;
        goto L14
    }

    public /* synthetic */ o(QuickReplyItem r20, bs8.h r21, FragmentActivity r22, t r23, String r24, String r25, String r26, String r27, Integer r28, Function1 r210, boolean r30, String r31, String r32, String r33, int r34) {
        if ((r34 & 128) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r34 & 1024) == 0) goto L9;
        Function1 r14 = null;
    L11:
        if ((r34 & 2048) == 0) goto L13;
        boolean r15 = true;
    L15:
        if ((r34 & 4096) == 0) goto L17;
        String r16 = null;
    L19:
        if ((r34 & 8192) == 0) goto L21;
        String r17 = null;
    L23:
        if ((r34 & 16384) == 0) goto L25;
        String r18 = null;
    L26:
        this(r20, r21, r22, r23, r24, r25, r26, r11, 0, r28, r14, r15, r16, r17, r18);
        return;
    L25:
        r18 = r33;
        goto L26
    L21:
        r17 = r32;
        goto L23
    L17:
        r16 = r31;
        goto L19
    L13:
        r15 = r30;
        goto L15
    L9:
        r14 = r210;
        goto L11
    L5:
        r11 = r27;
        goto L7
    }
}
