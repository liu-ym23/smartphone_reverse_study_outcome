package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j0 {
    public static final String d(com.larus.bmhome.actionbar.model.w r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r0 = r3.t;
        if (r0 != null) goto L5;
    L11:
        String r4 = r3.b;
        if (r4 != null) goto L14;
        return null;
    L14:
        if ((!StringsKt.isBlank(r4)) == true) goto L16;
        return null;
    L16:
        return r4;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0;
    }

    public static final boolean e(com.larus.bmhome.actionbar.model.c2 r2) {
        Integer r0 = r2.getType();
        if (r0 != null) goto L6;
    L7:
        Integer r3 = r2.getType();
        if (r3 != null) goto L11;
    L13:
        return false;
    L11:
        if (r3.intValue() != 4) goto L13;
    L14:
        return true;
    L6:
        if (r0.intValue() == 5) goto L14;
        goto L7
    }

    public static final boolean g(com.larus.bmhome.actionbar.model.w r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        com.larus.bmhome.actionbar.model.z1 r3 = r2.w;
        if (r3 == null) goto L10;
        String r4 = r3.a;
        if (r4 != null) goto L7;
        return false;
    L7:
        if ((!StringsKt.isBlank(r4)) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static final m0 b(com.larus.bmhome.actionbar.model.j r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Integer r0 = null;
        if (r8 == null) goto L91;
        int r9 = r8.intValue();
        Integer r1 = r7.m;
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        if (r9 >= r2) goto L10;
        return null;
    L10:
        List r10 = r7.n;
        if (r10 != null) goto L13;
        r10 = CollectionsKt.emptyList();
    L13:
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        Object r3 = r11.next();
        if (e((com.larus.bmhome.actionbar.model.c2) r3) == false) goto L15;
    L20:
        com.larus.bmhome.actionbar.model.c2 r4 = (com.larus.bmhome.actionbar.model.c2) r3;
        if (r4 != null) goto L28;
        r4 = r7.l;
        if (r4 != null) goto L25;
    L27:
        r4 = null;
        goto L28
    L25:
        if (e(r4) == false) goto L27;
    L28:
        if (r4 == null) goto L92;
        boolean r12 = v19.h.a;
        boolean r13 = false;
        if (v19.h.a(null) == false) goto L46;
        com.larus.bmhome.actionbar.model.g1 r14 = r4.d;
        if (r14 == null) goto L45;
        String r5 = r14.b;
        if (r5 != null) goto L36;
    L39:
        boolean r6 = true;
    L41:
        if ((!r6) == true) goto L44;
        r14 = null;
    L44:
        if (r14 == null) goto L45;
    L47:
        if (r14 == null) goto L93;
        String r15 = r14.b;
        if (r15 != null) goto L51;
        return null;
    L51:
        if ((!StringsKt.isBlank(r15)) == true) goto L54;
        r15 = null;
    L54:
        if (r15 == null) goto L95;
        Integer r16 = r14.c;
        int r17 = 12;
        if (r16 != null) goto L59;
    L67:
        int r18 = 12;
    L68:
        Integer r19 = r14.d;
        if (r19 != null) goto L71;
    L79:
        Integer r20 = r14.e;
        if (r20 == null) goto L87;
        if (r20.intValue() < 0) goto L84;
        r13 = true;
    L84:
        if (r13 == false) goto L87;
        r0 = r20;
    L87:
        return new m0(r15, r18, r17, r0);
    L71:
        if (r19.intValue() <= 0) goto L73;
        boolean r21 = true;
    L74:
        if (r21 == true) goto L77;
        r19 = null;
    L77:
        if (r19 == null) goto L79;
        r17 = r19.intValue();
        goto L79
    L73:
        r21 = false;
        goto L74
    L59:
        if (r16.intValue() <= 0) goto L61;
        boolean r22 = true;
    L62:
        if (r22 == true) goto L65;
        r16 = null;
    L65:
        if (r16 == null) goto L67;
        r18 = r16.intValue();
        goto L68
    L61:
        r22 = false;
        goto L62
    L95:
        return null;
    L93:
        return null;
    L36:
        if (StringsKt.isBlank(r5) == true) goto L39;
        r6 = false;
    L45:
        r14 = r4.c;
        goto L47
    L46:
        r14 = r4.c;
        goto L47
    L92:
        return null;
    L19:
        r3 = null;
        goto L20
    L7:
        r2 = Integer.MAX_VALUE;
        goto L8
    L91:
        return null;
    }

    public static final String c(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r0 = null;
        if (r3 != null) goto L5;
    L25:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(r2.getString(2131899467));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == false) goto L16;
        r5 = null;
    L16:
        String r6 = (String) r5;
        if (r6 != null) goto L19;
    L21:
        if (r0 != null) goto L24;
        return r2.getString(2131899466);
    L24:
        return r0;
    L19:
        if ((!StringsKt.isBlank(r6)) == false) goto L21;
        r0 = r6;
    L11:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L25;
        return r3;
    }

    public static final boolean f(com.larus.bmhome.actionbar.model.j r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 == null) goto L20;
        int r5 = r4.intValue();
        com.larus.bmhome.actionbar.model.z1 r1 = r3.o;
        if (r1 == null) goto L11;
        String r2 = r1.a;
        if (r2 == null) goto L11;
        if ((!StringsKt.isBlank(r2)) != true) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L21;
        Integer r7 = r3.m;
        if (r7 == null) goto L16;
        int r8 = r7.intValue();
    L17:
        if (r5 < r8) goto L22;
        return true;
    L22:
        return false;
    L16:
        r8 = Integer.MAX_VALUE;
        goto L17
    L21:
        return false;
    L11:
        r6 = false;
        goto L12
    L20:
        return false;
    }

    public static final k0 a(com.larus.bmhome.actionbar.model.w r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r10, "enterMethod");
        String r2 = null;
        if (g(r8) == true) goto L5;
        return null;
    L5:
        com.larus.bmhome.actionbar.model.z1 r1 = r8.w;
        if (r1 == null) goto L8;
        Map r3 = r1.d;
    L9:
        int r4 = uz8.b.C0138b.c;
        if (r3 == null) goto L12;
        String r5 = (String) r3.get("feature_detail_key");
    L13:
        if (r3 == null) goto L15;
        String r6 = (String) r3.get("feature_detail_value");
    L16:
        List r7 = CollectionsKt.listOfNotNull(uz8.b.C0138b.a.a(r5, r6, null));
        List r11 = CollectionsKt.listOf(new l0(r9, r8.a, null, 4));
        com.larus.bmhome.actionbar.model.z1 r12 = r8.w;
        int r13 = uz8.b.e;
        if (r3 == null) goto L19;
        String r14 = (String) r3.get("trigger_scene");
    L20:
        if (r3 == null) goto L22;
        r2 = (String) r3.get("feature_key");
    L22:
        Intrinsics.checkNotNullParameter(r10, "enterMethod");
        Intrinsics.checkNotNullParameter(r7, "featureDetails");
        return new k0(r11, r12, new uz8.b(r10, r14, r2, uz8.b.a.a(r7)), r7);
    L19:
        r14 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L12:
        r5 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    }
}
