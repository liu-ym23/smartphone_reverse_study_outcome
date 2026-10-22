package com.bytedance.ai.applet.grantingV2;

import android.content.Context;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public u2.e a;
    public final List<u2.f> b;
    public final u2.c c;
    public final l d;
    public final j e;
    public WeakReference<Context> f;
    public i g;
    public u2.a h;
    public AppletAuthTaskMonitor.Session i;
    public final AtomicBoolean j;
    public final AtomicLong k;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
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
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        j r1 = this.e;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        WeakReference<Context> r13 = this.f;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        i r16 = this.g;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        u2.a r19 = this.h;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        AppletAuthTaskMonitor.Session r22 = this.i;
        if (r22 == null) goto L23;
        r10 = r22.hashCode();
    L23:
        return r21 + r10;
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "GrantingContext(grantingData=" + this.a + ", sortedGrantingList=" + this.b + ", appletMetaData=" + this.c + ", callback=" + this.d + ", isLastMessage=" + this.e + ", uiContextWk=" + this.f + ", currentStrategy=" + this.g + ", currentCardModel=" + this.h + ", authTaskSession=" + this.i + ')';
    }

    public f(u2.e r10, List r11, u2.c r12, com.bytedance.applet.impl.i r13, com.bytedance.applet.impl.j r14) {
        Intrinsics.checkNotNullParameter(r10, "grantingData");
        Intrinsics.checkNotNullParameter(r11, "sortedGrantingList");
        Intrinsics.checkNotNullParameter(r12, "appletMetaData");
        Intrinsics.checkNotNullParameter(r13, "callback");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = new AtomicBoolean(false);
        this.k = new AtomicLong(0);
    }
}
