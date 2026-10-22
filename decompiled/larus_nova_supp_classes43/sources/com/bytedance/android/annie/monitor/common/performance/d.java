package com.bytedance.android.annie.monitor.common.performance;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final String a;
    public final WeakReference<View> b;
    public final AtomicInteger c;

    public d() {
        throw null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "PageInfo(url=" + this.a + ", viewRef=" + this.b + ", reportTimes=" + this.c + ')';
    }

    public d(String r10, WeakReference r11) {
        AtomicInteger r0 = new AtomicInteger();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "viewRef");
        Intrinsics.checkNotNullParameter(r0, "reportTimes");
        this.a = r10;
        this.b = r11;
        this.c = r0;
    }
}
