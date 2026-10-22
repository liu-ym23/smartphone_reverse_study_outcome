package com.bytedance.android.ec.core.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "狗屎，不要用")
public final class n0 {
    public final List<i> a;
    public final String b;
    public final boolean c;

    public final String c() {
        if (((ArrayList) this.a).isEmpty() == true) goto L5;
        Iterator r0 = ((ArrayList) this.a).iterator();
    L7:
        boolean r10 = false;
        if (r0.hasNext() == false) goto L14;
        if (StringsKt.contains$default(this.b, ((i) r0.next()).a, false, 2, null) == false) goto L7;
        if (this.c == true) goto L7;
        r0.remove();
        goto L7
    L14:
        String r1 = e2.b(this.a, "UTF-8");
        if (this.b.length() != 0) goto L17;
        r10 = true;
    L17:
        if (r10 == false) goto L20;
        return r1;
    L20:
        if (StringsKt.indexOf$default(this.b, '?', 0, false, 6, null) < 0) goto L23;
        return this.b + '&' + r1;
    L23:
        return this.b + '?' + r1;
    L5:
        return this.b;
    }

    public final String toString() {
        return c();
    }

    public n0(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "mUrl");
        this.b = r10;
        this.c = r11;
        this.a = new ArrayList();
    }

    public final void a(String r10, long r11) {
        List<i> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new i(r10, String.valueOf(r11)));
    }

    public final void b(String r10, String r11) {
        List<i> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new i(r10, r11));
    }
}
