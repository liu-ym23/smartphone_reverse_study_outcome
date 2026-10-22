package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q {
    public final String a;
    public final boolean b;
    public final m c;
    public final String d;
    public final UplinkFileEntity e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        if (this.f == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        String r5 = this.g;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        String r9 = this.h;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.i;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.j;
        if (r15 == null) goto L27;
        r6 = r15.hashCode();
    L27:
        return r14 + r6;
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r5.hashCode();
        goto L14
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "TryFileUploadParam(conversationId=" + this.a + ", isMultiFile=" + this.b + ", listener=" + this.c + ", fromScene=" + this.d + ", entity=" + this.e + ", skippedAttachment=" + this.f + ", localSendMsgId=" + this.g + ", botId=" + this.h + ", sectionId=" + this.i + ", uploadTaskShareTag=" + this.j + ')';
    }

    public q(String r2, boolean r3, m r4, String r5, UplinkFileEntity r6, boolean r7, String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r5, "fromScene");
        Intrinsics.checkNotNullParameter(r6, "entity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }

    public /* synthetic */ q(String r14, boolean r15, m r16, String r17, UplinkFileEntity r18, boolean r19, String r20, String r21, String r22, String r23, int r24) {
        if ((r24 & 32) == 0) goto L5;
        boolean r8 = false;
    L7:
        if ((r24 & 64) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r24 & 128) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r24 & 256) == 0) goto L17;
        String r11 = null;
    L19:
        if ((r24 & 512) == 0) goto L21;
        String r12 = null;
    L22:
        this(r14, r15, r16, r17, r18, r8, r9, r10, r11, r12);
        return;
    L21:
        r12 = r23;
        goto L22
    L17:
        r11 = r22;
        goto L19
    L13:
        r10 = r21;
        goto L15
    L9:
        r9 = r20;
        goto L11
    L5:
        r8 = r19;
        goto L7
    }
}
