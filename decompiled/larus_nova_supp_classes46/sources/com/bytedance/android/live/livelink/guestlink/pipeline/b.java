package com.bytedance.android.live.livelink.guestlink.pipeline;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import lb6.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ob6.a.a {
    public final /* synthetic */ GuestLinkPipeLineManager a;

    public final void c() {
    }

    public final void s() {
    }

    public final void t() {
    }

    public b(GuestLinkPipeLineManager r1) {
        this.a = r1;
    }

    public final void A(String r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L14;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L22;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L23;
        nb6.b r5 = (nb6.b) r2.next();
        if (r5 == null) goto L8;
        f r6 = r5.a;
        if (r6 == null) goto L8;
        r6.A(r3, r4);
        goto L8
    L23:
        return;
    L22:
        return;
    }

    public final void J(String[] r3, boolean[] r4, int[] r5) {
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L14;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L22;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L23;
        nb6.b r6 = (nb6.b) r2.next();
        if (r6 == null) goto L8;
        f r7 = r6.a;
        if (r7 == null) goto L8;
        r7.J(r3, r4, r5);
        goto L8
    L23:
        return;
    L22:
        return;
    }
}
