package com.ss.android.lark.replyinthread.pages;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d extends f {
    public final String c;
    public final MessageInfo d;
    public final String e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.c.hashCode() * 31) + this.d.hashCode()) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewVisitorThreadPageInfo(threadId=" + this.c + ", previewMessage=" + this.d + ", previewId=" + this.e + ", msgLinkToken=" + this.f + ')';
    }

    @Override // com.ss.android.lark.replyinthread.pages.f
    public final String a() {
        return this.c;
    }

    public d(String r2, MessageInfo r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "threadId");
        Intrinsics.checkNotNullParameter(r3, "previewMessage");
        super(3, r2);
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
