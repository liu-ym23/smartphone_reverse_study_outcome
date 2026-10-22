package com.bytedance.ies.bullet.web.pia;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements fh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6227b;

    public /* synthetic */ e(String r5, int r10) {
        this.f6226a = r10;
        this.f6227b = r5;
    }

    @Override // fh.b
    public final Object a(Object r5) {
        switch(this.f6226a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        k r10 = null;
        if ((r5 instanceof c) == false) goto L7;
        c r11 = (c) r5;
    L8:
        if (r11 == null) goto L11;
        r10 = (k) r11.a(k.class);
    L11:
        return new q(this.f6227b, r10);
    L7:
        r11 = null;
        goto L8
    L13:
        return b(r5);
    }

    public LinkedHashMap b(Object r5) {
        if ((r5 instanceof c) == false) goto L5;
        c r10 = (c) r5;
    L6:
        if (r10 == null) goto L8;
        k r11 = (k) r10.a(k.class);
    L8:
        tc.c r12 = tc.c.f22119c;
        if (tc.c.f22119c.a(b.class, this.f6227b) != null) goto L16;
        ConcurrentHashMap r13 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r14 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r14 == null) goto L14;
        xc.d r15 = (xc.d) r14.a(xc.d.class);
    L14:
        return new LinkedHashMap();
    L16:
        throw new ClassCastException();
    L5:
        r10 = null;
        goto L6
    }

    @Override // fh.b
    public final Object create() {
        switch(this.f6226a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new q(this.f6227b, null);
    L7:
        return b(null);
    }
}
