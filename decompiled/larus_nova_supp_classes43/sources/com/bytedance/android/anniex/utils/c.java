package com.bytedance.android.anniex.utils;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final List<String> a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static final List<String> d = null;
    public static final boolean e = false;

    static {
        s26.d r0 = s26.d.c;
        m0 r1 = s26.d.c.c(m0.class);
        if (r1 == null) goto L5;
        com.bytedance.ies.bullet.service.base.d r10 = r1.a0();
    L6:
        Map r11 = x26.a.a;
        w26.g r12 = (w26.g) x26.a.a(w26.g.class);
        if (r12 == null) goto L13;
        w26.e r13 = (w26.e) r12.n0(w26.e.class);
        if (r13 == null) goto L13;
        Collection r14 = r13.m();
        if (r14 == null) goto L13;
    L14:
        a = CollectionsKt.plus(r14, CollectionsKt.emptyList());
        w26.g r15 = (w26.g) x26.a.a(w26.g.class);
        if (r15 == null) goto L21;
        w26.e r16 = (w26.e) r15.n0(w26.e.class);
        if (r16 == null) goto L21;
        Collection r17 = r16.i();
        if (r17 == null) goto L21;
    L22:
        b = CollectionsKt.plus(r17, CollectionsKt.emptyList());
        w26.g r18 = (w26.g) x26.a.a(w26.g.class);
        if (r18 == null) goto L29;
        w26.e r19 = (w26.e) r18.n0(w26.e.class);
        if (r19 == null) goto L29;
        Collection r20 = r19.g();
        if (r20 == null) goto L29;
    L30:
        c = CollectionsKt.plus(r20, CollectionsKt.emptyList());
        w26.g r21 = (w26.g) x26.a.a(w26.g.class);
        if (r21 == null) goto L37;
        w26.e r22 = (w26.e) r21.n0(w26.e.class);
        if (r22 == null) goto L37;
        Collection r23 = r22.c();
        if (r23 == null) goto L37;
    L38:
        d = CollectionsKt.plus(r23, CollectionsKt.emptyList());
        boolean r24 = false;
        if (r10 != null) goto L41;
    L43:
        boolean r25 = false;
    L44:
        if (r25 == false) goto L55;
        w26.g r26 = (w26.g) x26.a.a(w26.g.class);
        if (r26 == null) goto L52;
        w26.e r27 = (w26.e) r26.n0(w26.e.class);
        if (r27 == null) goto L52;
        Boolean r28 = r27.W();
        if (r28 == null) goto L52;
        boolean r29 = r28.booleanValue();
    L53:
        if (r29 == false) goto L55;
        r24 = true;
    L52:
        r29 = true;
    L55:
        e = r24;
        return;
    L41:
        if (r10.B0 != true) goto L43;
        r25 = true;
    L37:
        r23 = new ArrayList();
    L29:
        r20 = new ArrayList();
    L21:
        r17 = new ArrayList();
    L13:
        r14 = new ArrayList();
        goto L14
    L5:
        r10 = null;
        goto L6
    }

    public static final boolean a(String r10) {
        if (Intrinsics.areEqual(r10, "flow") == false) goto L14;
        Map r11 = x26.a.a;
        w26.g r12 = (w26.g) x26.a.a(w26.g.class);
        if (r12 == null) goto L11;
        w26.e r13 = (w26.e) r12.n0(w26.e.class);
        if (r13 == null) goto L11;
        Boolean r14 = r13.S();
        if (r14 == null) goto L11;
        boolean r15 = r14.booleanValue();
    L12:
        if (r15 == false) goto L14;
        return true;
    L11:
        r15 = true;
    L14:
        return false;
    }

    public static final String getType(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        String r0 = r10.getScheme();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r11 = r10.getAuthority();
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        String r12 = r10.getPath();
        if (r12 == null) goto L13;
        r1 = r12;
    L13:
        if (Intrinsics.areEqual(r0, "http") == false) goto L15;
        return "_unknown";
    L15:
        if (Intrinsics.areEqual(r0, "https") == false) goto L18;
        return "_unknown";
    L18:
        if (StringsKt.endsWith$default(r11, "_popup", false, 2, null) == false) goto L21;
    L39:
        return "_popup";
    L21:
        if (StringsKt.endsWith$default(r11, "_page", false, 2, null) == true) goto L37;
        if (Intrinsics.areEqual(r11, "lynxview") == true) goto L37;
        if (Intrinsics.areEqual(r11, "webview") == true) goto L37;
        if (StringsKt.endsWith$default(r1, "_popup", false, 2, null) == true) goto L39;
        if (StringsKt.endsWith$default(r1, "_page", false, 2, null) == true) goto L37;
        if (Intrinsics.areEqual(r1, "lynxview") == true) goto L37;
        if (Intrinsics.areEqual(r1, "webview") == true) goto L37;
        return "_unknown";
    L37:
        return "_page";
    }

    public static final boolean b(h r10, Uri r11, boolean r12, List<String> r13, List<String> r14, String r15) {
        if (r12 == true) goto L5;
        return false;
    L5:
        String r16 = a36.b.a(r11, "default_bid");
        if (r16 != null) goto L8;
        r16 = r11.toString();
    L8:
        Iterator<T> r17 = r13.iterator();
    L10:
        if (r17.hasNext() == false) goto L15;
        if (StringsKt.contains$default(r16, (String) r17.next(), false, 2, null) == false) goto L10;
        return false;
    L15:
        if (Intrinsics.areEqual(r10.a, r15) == false) goto L17;
        return true;
    L17:
        Iterator<T> r18 = r14.iterator();
    L19:
        if (r18.hasNext() == false) goto L24;
        if (StringsKt.contains$default(r16, (String) r18.next(), false, 2, null) == false) goto L19;
        r10.a = r15;
        return true;
    L24:
        return false;
    }
}
