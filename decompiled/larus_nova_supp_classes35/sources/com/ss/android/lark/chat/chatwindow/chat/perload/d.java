package com.ss.android.lark.chat.chatwindow.chat.perload;

import kotlin.jvm.internal.Intrinsics;
import u3b.a;
import u3b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d<Task extends u3b.a, DATA> {
    public final Class<Task> a;
    public final com.ss.android.lark.chat.chatwindow.chat.perload.loader.c<Task, e<DATA>> b;
    public final t3b.e<Task> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        t3b.e<Task> r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DataPreLoaderHolder(taskClass=" + this.a + ", loader=" + this.b + ", keyProvider=" + this.c + ')';
    }

    public d(Class r2, f6b.c r3, f6b.a r4) {
        Intrinsics.checkNotNullParameter(r2, "taskClass");
        Intrinsics.checkNotNullParameter(r3, "loader");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
