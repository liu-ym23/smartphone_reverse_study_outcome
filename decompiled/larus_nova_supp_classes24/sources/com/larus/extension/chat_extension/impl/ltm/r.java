package com.larus.extension.chat_extension.impl.ltm;

import com.larus.extension.chat_extension.impl.ltm.view.ChatLtmBaseHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r {
    public final String a;
    public final String b;
    public final ChatLtmStatus c;
    public final String d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public boolean h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31;
        int r2 = 1231;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.h == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatLtmItemData(id=" + this.a + ", content=" + this.b + ", status=" + this.c + ", date=" + this.d + ", viewType=" + this.e + ", isLast=" + this.f + ", isFirst=" + this.g + ", needHighLight=" + this.h + ')';
    }

    public r(String r2, String r3, ChatLtmStatus r4, String r5, int r6, boolean r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "status");
        Intrinsics.checkNotNullParameter(r5, "date");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public /* synthetic */ r(String r12, String r13, ChatLtmStatus r14, String r15, int r16, boolean r17, boolean r19, boolean r110, int r20) {
        if ((r20 & 8) == 0) goto L5;
        String r6 = "";
    L7:
        if ((r20 & 16) == 0) goto L9;
        int r7 = ChatLtmBaseHolder.Companion.ChatItemViewType.NORMAL.getValue();
    L11:
        if ((r20 & 32) == 0) goto L13;
        boolean r8 = false;
    L15:
        if ((r20 & 64) == 0) goto L17;
        boolean r9 = false;
    L19:
        if ((r20 & 128) == 0) goto L21;
        boolean r10 = false;
    L22:
        this(r12, r13, r14, r6, r7, r8, r9, r10);
        return;
    L21:
        r10 = r110;
        goto L22
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }
}
