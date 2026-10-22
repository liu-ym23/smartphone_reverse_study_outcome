package com.larus.agents.impl.experience;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r {
    public static final t a(u r15) {
        Intrinsics.checkNotNullParameter(r15, "<this>");
        String r0 = r15.c();
        if (r0 != null) goto L5;
    L38:
        return null;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        String r4 = r0;
    L8:
        if (r4 == null) goto L38;
        String r5 = r15.e();
        if (r5 != null) goto L13;
        return null;
    L13:
        String r6 = r15.b();
        if (r6 != null) goto L16;
        return null;
    L16:
        q r1 = r15.d();
        if (r1 != null) goto L19;
        return null;
    L19:
        String r7 = r1.getType();
        if (r7 != null) goto L22;
        return null;
    L22:
        Integer r2 = r1.b();
        if (r2 == null) goto L38;
        int r3 = r2.intValue();
        Long r8 = r1.a();
        if (r8 == null) goto L38;
        long r9 = r8.longValue();
        List<String> r10 = r1.c();
        if (r10 != null) goto L29;
        return null;
    L29:
        List r11 = CollectionsKt.filterNotNull(r10);
        if (r11.size() == r10.size()) goto L32;
        return null;
    L32:
        Boolean r12 = r15.a();
        if (r12 == null) goto L38;
        boolean r13 = r12.booleanValue();
        Long r16 = r15.f();
        if (r16 == null) goto L38;
        long r14 = r16.longValue();
        WorkExperienceSource.a r17 = WorkExperienceSource.Companion;
        Integer r19 = Integer.valueOf(r3);
        r17.getClass();
        return new t(r4, r5, r6, r7, WorkExperienceSource.a.a(r19), r9, r11, r13, r14);
    L7:
        r4 = null;
        goto L8
    }
}
