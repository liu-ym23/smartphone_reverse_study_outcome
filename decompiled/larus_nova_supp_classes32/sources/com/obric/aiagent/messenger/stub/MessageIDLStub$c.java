package com.obric.aiagent.messenger.stub;

import com.lynx.tasm.event.LynxTouchEvent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$c {
    public final String a;
    public final String b;
    public final String c;
    public final Map<String, String> d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final long h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MessageIDLStub$c) == true) goto L8;
        return false;
    L8:
        MessageIDLStub$c r9 = (MessageIDLStub$c) r8;
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
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        int r3 = 1231;
        if (this.f == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        if (this.g == true) goto L10;
        r3 = 1237;
    L10:
        long r6 = this.h;
        return ((r5 + r3) * 31) + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "PendingWidgetUpdate(localMessageId=" + this.a + ", messageId=" + this.b + ", conversationId=" + this.c + ", renderDataByBlockId=" + this.d + ", revision=" + this.e + ", retryOnForeground=" + this.f + ", protectAfterRemoteSuccess=" + this.g + ", backgroundGeneration=" + this.h + ')';
    }

    public static MessageIDLStub$c a(MessageIDLStub$c r15, String r16, String r17, boolean r18, long r19, int r21) {
        Map<String, String> r3 = null;
        if ((r21 & 1) == 0) goto L5;
        String r5 = r15.a;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r6 = r15.b;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r7 = r15.c;
    L15:
        if ((r21 & 8) == 0) goto L17;
        r3 = r15.d;
    L17:
        Map<String, String> r8 = r3;
        if ((r21 & 16) == 0) goto L20;
        long r2 = r15.e;
    L21:
        long r9 = r2;
        if ((r21 & 32) == 0) goto L24;
        boolean r11 = r15.f;
    L26:
        if ((r21 & 64) == 0) goto L28;
        boolean r12 = r15.g;
    L30:
        if ((r21 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L32;
        long r13 = r15.h;
    L33:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r5, "localMessageId");
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        Intrinsics.checkNotNullParameter(r8, "renderDataByBlockId");
        return new MessageIDLStub$c(r5, r6, r7, r8, r9, r11, r12, r13);
    L32:
        r13 = r19;
        goto L33
    L28:
        r12 = false;
        goto L30
    L24:
        r11 = r18;
        goto L26
    L20:
        r2 = 0;
        goto L21
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public MessageIDLStub$c(String r2, String r3, String r4, Map<String, String> r5, long r6, boolean r8, boolean r9, long r10) {
        Intrinsics.checkNotNullParameter(r2, "localMessageId");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "renderDataByBlockId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
