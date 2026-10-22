package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a implements w91.a {
    public final List<w91.a.InterfaceC0339a> a;

    @Override // w91.a
    public final void d() {
    }

    @Override // w91.a
    public final int a() {
        return ((ArrayList) this.a).size();
    }

    public final void f() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        w91.a.InterfaceC0339a r1 = (w91.a.InterfaceC0339a) r0.next();
        r0.remove();
        if (r1 == null) goto L4;
        r1.a();
        goto L4
    }

    public a() {
        this.a = new ArrayList();
    }

    @Override // w91.a
    public final boolean b(w91.a.InterfaceC0339a r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        List<w91.a.InterfaceC0339a> r0 = this.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        Iterator r2 = ((ArrayList) r0).iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (Intrinsics.areEqual((w91.a.InterfaceC0339a) r2.next(), r5) == false) goto L7;
        r1 = true;
    L11:
        if (r1 == true) goto L14;
        ((ArrayList) this.a).add(r5);
    L14:
        return !r1;
    }

    @Override // w91.a
    public final boolean c(w91.a.InterfaceC0339a r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        Iterator r0 = ((ArrayList) this.a).iterator();
        if (r0.hasNext() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual((w91.a.InterfaceC0339a) r0.next(), r3) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // w91.a
    public final boolean e(w91.a.InterfaceC0339a r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        List<w91.a.InterfaceC0339a> r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L18;
        Iterator r1 = ((ArrayList) this.a).iterator();
    L9:
        if (r1.hasNext() == false) goto L19;
        if (Intrinsics.areEqual((w91.a.InterfaceC0339a) r1.next(), r4) == false) goto L9;
        r1.remove();
        return true;
    L19:
        return false;
    L18:
        return false;
    }
}
