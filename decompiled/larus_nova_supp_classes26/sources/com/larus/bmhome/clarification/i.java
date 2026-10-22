package com.larus.bmhome.clarification;

import com.larus.im.bean.message.UplinkFileEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final List<String> a;
    public final String b;
    public final String c;
    public final List<UplinkFileEntity> d;
    public final long e;

    public i() {
        String r0 = null;
        this(r0, r0, 31);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r9 = (i) r8;
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
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.d.hashCode()) * 31;
        long r4 = this.e;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClarificationAnswerDraft(selectedOptionIds=" + this.a + ", inputText=" + this.b + ", attachmentLocalMsgId=" + this.c + ", attachments=" + this.d + ", updatedAt=" + this.e + ')';
    }

    public /* synthetic */ i(String r10, String r11, int r12) {
        List r1 = null;
        if ((r12 & 1) == 0) goto L5;
        List r3 = CollectionsKt.emptyList();
    L7:
        if ((r12 & 2) == 0) goto L9;
        r10 = "";
    L9:
        String r4 = r10;
        if ((r12 & 4) == 0) goto L12;
        String r5 = null;
    L14:
        if ((r12 & 8) == 0) goto L16;
        r1 = CollectionsKt.emptyList();
    L16:
        List r6 = r1;
        if ((r12 & 16) == 0) goto L19;
        long r13 = System.currentTimeMillis();
    L20:
        this(r3, r4, r5, r6, r13);
        return;
    L19:
        r13 = 0;
        goto L20
    L12:
        r5 = r11;
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    public i(List<String> r2, String r3, String r4, List<UplinkFileEntity> r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r3, "inputText");
        Intrinsics.checkNotNullParameter(r5, "attachments");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public static i a(i r7, List r8, String r9, String r10, List r11, long r12, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.a;
    L5:
        List r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.b;
    L8:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.c;
    L11:
        String r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.d;
    L14:
        List r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r12 = r7.e;
    L17:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r2, "inputText");
        Intrinsics.checkNotNullParameter(r4, "attachments");
        return new i(r1, r2, r3, r4, r12);
    }
}
