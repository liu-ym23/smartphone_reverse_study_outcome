package com.bytedance.ai.widget;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3088c;
    public final String d;

    public p(String r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r10, "cardId");
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "widgetId");
        this.f3086a = r5;
        this.f3087b = r10;
        this.f3088c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r10 = (p) r5;
        String r11 = r10.f3086a;
        if (Intrinsics.areEqual(this.f3086a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3087b, r10.f3087b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f3088c, r10.f3088c) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f3086a.hashCode() * 31;
        int r10 = kk.a.b(this.f3087b, r5, 31) * 31;
        int r11 = kk.a.b(this.f3088c, r10, 31);
        return this.d.hashCode() + r11;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("WidgetMonitorInfo(messageId=");
        r5.append(this.f3086a);
        r5.append(", cardId=");
        r5.append(this.f3087b);
        r5.append(", replyId=null, appletId=");
        r5.append(this.f3088c);
        r5.append(", widgetId=");
        return j0.p(r5, this.d, ')');
    }
}
