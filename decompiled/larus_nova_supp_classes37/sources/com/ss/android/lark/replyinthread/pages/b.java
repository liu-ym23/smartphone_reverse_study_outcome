package com.ss.android.lark.replyinthread.pages;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends f {
    public final String c;
    public final Bundle d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.c.hashCode() * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "InChatThreadPageInfo(threadId=" + this.c + ", bundle=" + this.d + ')';
    }

    @Override // com.ss.android.lark.replyinthread.pages.f
    public final String a() {
        return this.c;
    }

    public b(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "threadId");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        super(0, r2);
        this.c = r2;
        this.d = r3;
    }
}
