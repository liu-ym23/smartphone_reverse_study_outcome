package com.bytedance.ai.applet.grantingV2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v {
    public static final boolean b(String r10, u2.f r11) {
        if (g.b(r11, r10) == false) goto L5;
        return true;
    L5:
        String r12 = r11.c();
        if (r12 != null) goto L8;
    L32:
        com.bytedance.ai.utils.g.a.w("McpGrantingManagerV2", "Unknown permission status: " + r11.c() + ", treating as needs processing");
        return true;
    L8:
        switch(r12.hashCode()) {
            case -682587753: goto L31;
            case 280295099: goto L28;
            case 664583344: goto L25;
            case 854280074: goto L21;
            case 1085547216: goto L17;
            case 1100137118: goto L14;
            case 2084348283: goto L11;
            default: goto L32;
        };
    L11:
        if (r12.equals("refused_by_history") == false) goto L32;
        return true;
    L14:
        if (r12.equals("revoked") == false) goto L32;
        return true;
    L17:
        if (r12.equals("refused") == false) goto L32;
        return r11.f();
    L21:
        if (r12.equals("granted_without_system") == false) goto L32;
        return r11.f();
    L25:
        if (r12.equals("granted_by_history") == false) goto L32;
        return true;
    L28:
        if (r12.equals("granted") == false) goto L32;
        return false;
    L31:
        if (r12.equals("pending") == false) goto L32;
        return true;
    }

    public static final u2.e c(u2.e r10, u2.f r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "newItem");
        List<u2.f> r0 = r10.h();
        if (r0 != null) goto L5;
        return r10;
    L5:
        Iterator<u2.f> r1 = r0.iterator();
        int r12 = 0;
    L7:
        if (r1.hasNext() == false) goto L17;
        u2.f r13 = r1.next();
        if (r13.d() == r11.d()) goto L11;
    L13:
        boolean r14 = false;
    L14:
        if (r14 == true) goto L18;
        r12 = r12 + 1;
    L18:
        if (r12 == (-1)) goto L23;
        List r15 = CollectionsKt.toMutableList(r0);
        ListProtector.set(r15, r12, r11);
        return u2.e.a(r10, null, CollectionsKt.toList(r15), 127);
    L23:
        return r10;
    L11:
        if (Intrinsics.areEqual(r13.b(), r11.b()) == false) goto L13;
        r14 = true;
        goto L14
    L17:
        r12 = -1;
        goto L18
    }

    public static final u2.f a(List<u2.f> r10, Integer r11, String r12) {
        Object r0 = null;
        if (r11 != null) goto L11;
        Iterator<T> r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L32;
        Object r14 = r13.next();
        if (b(r12, (u2.f) r14) == false) goto L6;
        r0 = r14;
    L32:
        return (u2.f) r0;
    L11:
        Iterator<T> r15 = r10.iterator();
    L13:
        if (r15.hasNext() == false) goto L23;
        Object r1 = r15.next();
        u2.f r16 = (u2.f) r1;
        if (r16.d() > r11.intValue()) goto L17;
    L19:
        boolean r17 = false;
    L20:
        if (r17 == false) goto L13;
        r0 = r1;
        goto L23
    L17:
        if (b(r12, r16) == false) goto L19;
        r17 = true;
    L23:
        return (u2.f) r0;
    }
}
