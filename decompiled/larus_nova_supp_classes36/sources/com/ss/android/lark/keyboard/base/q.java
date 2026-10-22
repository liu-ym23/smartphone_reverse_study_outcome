package com.ss.android.lark.keyboard.base;

import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.entity.message.content.AtAIKnowledgeSourceClient;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q {
    public final String a;
    public String b;
    public RichText c;
    public final PartialReplyInfo d;
    public final boolean e;
    public final boolean f;
    public final s5c.d g;
    public final List<k> h;
    public final AtAIKnowledgeSourceClient i;
    public r j;

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
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        PartialReplyInfo r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.e == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.f == true) goto L14;
        r5 = 1237;
    L14:
        int r8 = (r7 + r5) * 31;
        s5c.d r9 = this.g;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        List<k> r12 = this.h;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        AtAIKnowledgeSourceClient r15 = this.i;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        r r18 = this.j;
        if (r18 == null) goto L31;
        r2 = r18.hashCode();
    L31:
        return r17 + r2;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "SendInfo(title=" + this.a + ", content=" + this.b + ", richText=" + this.c + ", partialReplyInfo=" + this.d + ", hasSmartReply=" + this.e + ", isAIQuery=" + this.f + ", extras=" + this.g + ", hitPointHandlers=" + this.h + ", source=" + this.i + ", sendInfoExtraParam=" + this.j + ')';
    }

    public static q a(q r15, String r16, RichText r17, int r18) {
        r r3 = null;
        if ((r18 & 1) == 0) goto L5;
        String r5 = r15.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r6 = r15.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        RichText r7 = r15.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        PartialReplyInfo r8 = r15.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r9 = r15.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r10 = r15.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        s5c.d r11 = r15.g;
    L31:
        if ((r18 & 128) == 0) goto L33;
        List<k> r12 = r15.h;
    L35:
        if ((r18 & 256) == 0) goto L37;
        AtAIKnowledgeSourceClient r13 = r15.i;
    L39:
        if ((r18 & 512) == 0) goto L41;
        r3 = r15.j;
    L41:
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, "content");
        Intrinsics.checkNotNullParameter(r7, "richText");
        return new q(r5, r6, r7, r8, r9, r10, r11, r12, r13, r3);
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = false;
        goto L27
    L21:
        r9 = false;
        goto L23
    L17:
        r8 = null;
        goto L19
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

    public /* synthetic */ q(String r12, String r13, RichText r14, PartialReplyInfo r15, boolean r16, s5c.d r17, List r18) {
        this(r12, r13, r14, r15, false, r16, r17, r18, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(String r2, String r3, RichText r4, PartialReplyInfo r5, boolean r6, boolean r7, s5c.d r8, List<? extends k> r9, AtAIKnowledgeSourceClient r10, r r11) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "richText");
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
}
