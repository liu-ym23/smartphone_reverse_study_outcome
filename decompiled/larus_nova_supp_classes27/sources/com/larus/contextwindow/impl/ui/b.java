package com.larus.contextwindow.impl.ui;

import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaRowKind;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a a(ContextWindowSnapshot r9, com.larus.contextwindow.impl.membership.h r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "contextSnapshot");
        Intrinsics.checkNotNullParameter(r10, "repositoryState");
        MembershipQuotaSummaryDto r0 = r10.a;
        Long r1 = null;
        if (r0 == null) goto L22;
        z29.c r2 = com.larus.contextwindow.impl.membership.c.a(r0);
        if ((!r2.a.isEmpty()) == false) goto L22;
        List<z29.b> r5 = r2.a;
        boolean r12 = r10.b;
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Iterator<T> r3 = r2.a.iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        Object r6 = r3.next();
        if (((z29.b) r6).a != MembershipQuotaRowKind.H5) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
    L16:
        z29.b r8 = (z29.b) r6;
        if (r8 == null) goto L20;
        r1 = r8.l;
    L20:
        return new a(r9, r11, new j(r5, r12, r1));
    L12:
        r7 = false;
        goto L13
    L15:
        r6 = null;
    L22:
        return new a(r9, r11, null);
    }
}
