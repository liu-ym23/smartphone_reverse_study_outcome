package com.obric.assistant.omnidetailpage.blockview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l implements com.larus.platform.api.n0 {
    public final /* synthetic */ j a;
    public final /* synthetic */ ifa.c.b b;

    public final void b(Integer r1, Integer r2) {
    }

    public final void c(int r1) {
    }

    public final void d(int r1) {
    }

    public final void onCompletion() {
    }

    public final void onPrepare() {
    }

    public final void onPrepared() {
    }

    public final void onVideoStatusException(int r1) {
    }

    public final void onRenderStart() {
        ifa.c.b r0 = this.a.k;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L7:
        if (Intrinsics.areEqual(r2, this.b.a) == false) goto L16;
        ifa.c.b r3 = this.a.k;
        if (r3 == null) goto L12;
        r1 = r3.c;
    L12:
        if (Intrinsics.areEqual(r1, this.b.c) == false) goto L17;
        j r4 = this.a;
        r4.p = true;
        r4.n = true;
        r4.g.setVisibility(8);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public l(j r1, ifa.c.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(Integer r2, Integer r3) {
        ifa.c.b r4 = this.a.k;
        String r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.a;
    L7:
        if (Intrinsics.areEqual(r6, this.b.a) == false) goto L18;
        ifa.c.b r7 = this.a.k;
        if (r7 == null) goto L12;
        r5 = r7.c;
    L12:
        if (Intrinsics.areEqual(r5, this.b.c) == false) goto L20;
        j r8 = this.a;
        r8.n = false;
        if (r8.k == null) goto L19;
        r8.g.setVisibility(0);
        return;
    L19:
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
