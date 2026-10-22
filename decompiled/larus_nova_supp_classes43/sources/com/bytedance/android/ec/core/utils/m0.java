package com.bytedance.android.ec.core.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m0 {
    public final List<i> a;
    public String b;

    public static final class a {
    }

    static {
    }

    public final String c() {
        if (((ArrayList) this.a).isEmpty() == true) goto L5;
        Iterator r0 = ((ArrayList) this.a).iterator();
    L7:
        boolean r10 = false;
        if (r0.hasNext() == false) goto L17;
        i r1 = (i) r0.next();
        if (StringsKt.contains$default(this.b, r1.a, false, 2, null) == false) goto L7;
        String r11 = this.b;
        String r12 = r1.a;
        String r13 = r1.b;
        if (TextUtils.isEmpty(r11) == false) goto L14;
    L16:
        this.b = r11;
        r0.remove();
        goto L7
    L14:
        if (TextUtils.isEmpty(r12) == true) goto L16;
        r11 = new Regex("(" + r12 + "=[^&]*)").replace(r11, r12 + '=' + r13);
        goto L16
    L17:
        String r14 = e2.b(this.a, "UTF-8");
        if (this.b.length() != 0) goto L20;
        r10 = true;
    L20:
        if (r10 == false) goto L23;
        return r14;
    L23:
        if (StringsKt.indexOf$default(this.b, '?', 0, false, 6, null) < 0) goto L26;
        return this.b + '&' + r14;
    L26:
        return this.b + '?' + r14;
    L5:
        return this.b;
    }

    public final String toString() {
        return c();
    }

    public m0(String r10) {
        Intrinsics.checkNotNullParameter(r10, "mUrl");
        this.b = r10;
        this.a = new ArrayList();
    }

    public final void a(String r10, String r11) {
        if (cg4.a.a(r11) == false) goto L6;
        List<i> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new i(r10, r11));
        return;
    }

    public final void b(String r10, String r11) {
        List<i> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new i(r10, r11));
    }
}
