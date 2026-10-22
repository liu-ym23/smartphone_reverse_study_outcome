package com.obric.aiagent.messenger.stub;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MessageIDLStub$d {
    public final String a;
    public final String b;
    public final Map<String, String> c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageIDLStub$d) == true) goto L8;
        return false;
    L8:
        MessageIDLStub$d r6 = (MessageIDLStub$d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "WidgetRenderProtection(localMessageId=" + this.a + ", messageId=" + this.b + ", renderDataByBlockId=" + this.c + ", source=" + this.d + ')';
    }

    public MessageIDLStub$d(String r2, String r3, Map<String, String> r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "localMessageId");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "renderDataByBlockId");
        Intrinsics.checkNotNullParameter(r5, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
