package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r implements ne0.a {
    public final /* synthetic */ o a;

    public r(o r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        if (r3 == null) goto L12;
        if (((Boolean) r3).booleanValue() == true) goto L7;
        ((LinkedHashMap) this.a.a.a).clear();
        return;
    L7:
        if (((Boolean) vm2.d.W6.getValue(null, vm2.d.a[410(0x19a, float:5.75E-43)])).booleanValue() == false) goto L13;
        ((LinkedHashMap) this.a.a.a).clear();
        return;
    L13:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }
}
