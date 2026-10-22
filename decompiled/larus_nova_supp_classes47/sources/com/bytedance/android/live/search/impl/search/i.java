package com.bytedance.android.live.search.impl.search;

import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ h a;

    public i(h r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        ra1.e r8 = (ra1.e) r7;
        h r0 = this.a;
        r0.a = false;
        r0.d = r8.d();
        this.a.b = r8.c();
        this.a.d = r8.d();
        this.a.c = r8.e();
        h r1 = this.a;
        r1.g = r8.k(r1.g);
        List<ra1.f> r2 = r8.f();
        if (r2 != null) goto L5;
        return;
    L5:
        if ((!r2.isEmpty()) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L29;
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L21;
        ra1.f r4 = (ra1.f) r3.next();
        ra1.a r5 = r4.a();
        if (r5 == null) goto L15;
        String r6 = r8.e();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.a = r6;
    L15:
        ra1.a r9 = r4.a();
        if (r9 == null) goto L11;
        JsonObject r10 = r8.g();
        if (r10 != null) goto L20;
        r10 = new JsonObject();
    L20:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.b = r10;
        goto L11
    L21:
        h r12 = this.a;
        r12.j.C6(r2, r12.d);
        return;
    }
}
