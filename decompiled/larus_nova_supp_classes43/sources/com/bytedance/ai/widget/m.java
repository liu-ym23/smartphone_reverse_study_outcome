package com.bytedance.ai.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof m) == true) goto L8;
        return false;
    L8:
        m r11 = (m) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return ((((r0 + r10) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "WidgetMonitorInfo(messageId=" + this.a + ", cardId=" + this.b + ", replyId=" + this.c + ", appletId=" + this.d + ", widgetId=" + this.e + ')';
    }

    public m(String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "messageId");
        Intrinsics.checkNotNullParameter(r11, "cardId");
        Intrinsics.checkNotNullParameter(r13, "appletId");
        Intrinsics.checkNotNullParameter(r14, "widgetId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
