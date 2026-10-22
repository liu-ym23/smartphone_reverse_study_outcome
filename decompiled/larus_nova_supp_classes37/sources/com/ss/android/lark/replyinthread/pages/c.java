package com.ss.android.lark.replyinthread.pages;

import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c extends f {
    public final String c;
    public final String d;
    public final String e;
    public final MergeForwardContent f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
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
        return (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "MergeForwardVisitorThreadPageInfo(threadId=" + this.c + ", rootMessageId=" + this.d + ", originMergeForwardMessageId=" + this.e + ", parentMessageContent=" + this.f + ')';
    }

    @Override // com.ss.android.lark.replyinthread.pages.f
    public final String a() {
        return this.c;
    }

    public c(String r2, String r3, String r4, MergeForwardContent r5) {
        Intrinsics.checkNotNullParameter(r2, "threadId");
        Intrinsics.checkNotNullParameter(r3, "rootMessageId");
        Intrinsics.checkNotNullParameter(r4, "originMergeForwardMessageId");
        Intrinsics.checkNotNullParameter(r5, "parentMessageContent");
        super(2, r2);
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
