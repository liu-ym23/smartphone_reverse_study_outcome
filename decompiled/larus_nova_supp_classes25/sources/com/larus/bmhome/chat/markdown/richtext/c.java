package com.larus.bmhome.chat.markdown.richtext;

import android.content.res.Resources;
import com.larus.business.markdown.api.model.BgListItemConfig;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.ListStyle;
import com.larus.business.markdown.api.model.PhoneNumberConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.larus.platform.service.z2;
import io.noties.markwon.core.spans.ListMarginInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tsc.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final lw8.d a(lw8.d r41, Resources r42) {
        Intrinsics.checkNotNullParameter(r41, "<this>");
        Intrinsics.checkNotNullParameter(r42, "resources");
        if (z2.a.enableMessageMention() == true) goto L5;
        return r41;
    L5:
        List r2 = r41.c;
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        List r3 = r41.z;
        if (r3 != null) goto L11;
        r3 = CollectionsKt.emptyList();
    L11:
        List r4 = r2;
        boolean r5 = false;
        if ((r4 instanceof Collection) == true) goto L14;
    L16:
        Iterator r6 = r4.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        if ((((a0) r6.next()) instanceof e) == false) goto L18;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L37;
        List r8 = r3;
        if ((r8 instanceof Collection) == true) goto L27;
    L29:
        Iterator r9 = r8.iterator();
    L31:
        if (r9.hasNext() == false) goto L35;
        if ((((lsc.a) r9.next()) instanceof b) == false) goto L31;
        r5 = true;
    L35:
        if (r5 == false) goto L37;
        return r41;
    L27:
        if (r8.isEmpty() == false) goto L29;
    L37:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r4.iterator();
    L39:
        if (r11.hasNext() == false) goto L43;
        Object r12 = r11.next();
        if ((((a0) r12) instanceof e) == true) goto L39;
        r10.add(r12);
        goto L39
    L43:
        List r13 = CollectionsKt.plus(r10, new e(r42));
        ArrayList r1 = new ArrayList();
        Iterator r14 = r3.iterator();
    L45:
        if (r14.hasNext() == false) goto L49;
        Object r15 = r14.next();
        if ((((lsc.a) r15) instanceof b) == true) goto L45;
        r1.add(r15);
        goto L45
    L49:
        List r31 = CollectionsKt.plus(r1, new b());
        int r16 = r41.a;
        Integer r17 = r41.b;
        String r18 = r41.d;
        boolean r19 = r41.e;
        boolean r110 = r41.f;
        Integer r111 = r41.g;
        int r112 = r41.h;
        int r113 = r41.i;
        Float r114 = r41.j;
        float r20 = r41.k;
        Float r21 = r41.l;
        int r22 = r41.m;
        int r23 = r41.n;
        BgListItemConfig r24 = r41.o;
        Integer r25 = r41.p;
        Integer r26 = r41.q;
        Function1 r27 = r41.r;
        Function1 r28 = r41.s;
        lw8.a r29 = r41.t;
        ThematicBreakConfig r30 = r41.u;
        CodeBlockConfig r32 = r41.v;
        TableConfig r33 = r41.w;
        PhoneNumberConfig r34 = r41.x;
        ListMarginInfo r35 = r41.y;
        Integer r36 = r41.A;
        ListStyle r37 = r41.B;
        Boolean r38 = r41.C;
        Boolean r39 = r41.D;
        Boolean r40 = r41.E;
        mw8.b r43 = r41.F;
        boolean r44 = r41.G;
        Map r45 = r41.H;
        boolean r0 = r41.I;
        Intrinsics.checkNotNullParameter(r13, "htmlTagHandlerList");
        Intrinsics.checkNotNullParameter(r18, "codeCopyTitle");
        Intrinsics.checkNotNullParameter(r43, "latexSingleConfig");
        return new lw8.d(r16, r17, r13, r18, r19, r110, r111, r112, r113, r114, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35, r31, r36, r37, r38, r39, r40, r43, r44, r45, r0);
    L22:
        r7 = false;
        goto L23
    L14:
        if (r4.isEmpty() == false) goto L16;
        goto L16
    }
}
