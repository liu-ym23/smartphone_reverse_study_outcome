package com.ss.android.lark.commonmark.html;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.b0;
import v7b.k;
import v7b.s;
import w7b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements e {
    public static final Pattern b = null;
    public static final Pattern c = null;
    public static final Pattern d = null;
    public final com.ss.android.lark.commonmark.html.a a;

    public static final class a {
    }

    static {
        b = PatternProtector.compile("^<([a-zA-Z0-9\\-]+)([^>]*?)\\s*(\\/)?>$");
        c = PatternProtector.compile("^</([a-zA-Z\\d\\-]+)>$");
        d = PatternProtector.compile("\\s+([a-zA-Z0-9\\-_]+)(?:\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]+)))?");
    }

    public b(com.ss.android.lark.commonmark.html.a r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        this.a = r2;
    }

    @Override // w7b.e
    public final s a(s r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        b(r1);
        return r1;
    }

    public final void b(s r13) {
        s r0 = r13.e;
    L3:
        if (r0 == null) goto L5;
        b(r0);
        r0 = r0.h;
        goto L3
    L5:
        s r14 = r13.e;
    L6:
        if (r14 == null) goto L85;
        boolean r1 = r14 instanceof k;
        String r3 = BuildConfig.FLAVOR;
        s r4 = null;
        if (r1 == false) goto L12;
        Matcher r2 = b.matcher(((k) r14).j);
        if (r2.find() == false) goto L12;
        String r5 = r2.group(1);
        if (r5 == null) goto L16;
        String r6 = r5.toLowerCase(Locale.getDefault());
    L17:
        if (r6 != null) goto L19;
        r6 = BuildConfig.FLAVOR;
    L19:
        String r7 = r2.group(2);
        if (r7 != null) goto L22;
    L25:
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
        Map r9 = MapsKt.emptyMap();
    L41:
        String r10 = r2.group(3);
        if (r10 != null) goto L44;
    L49:
        boolean r11 = false;
    L50:
        Triple r12 = new Triple(r6, r9, Boolean.valueOf(r11));
    L51:
        if (r12 == null) goto L84;
        String r15 = (String) r12.component1();
        Map r16 = (Map) r12.component2();
        if (((Boolean) r12.component3()).booleanValue() == true) goto L54;
        ArrayList r17 = new ArrayList(8);
        s r18 = r14.h;
    L58:
        if (r18 == null) goto L76;
        if ((r18 instanceof k) == false) goto L67;
        Matcher r19 = c.matcher(((k) r18).j);
        if (r19.find() == false) goto L67;
        String r20 = r19.group(1);
        if (r20 == null) goto L67;
        String r21 = r20.toLowerCase(Locale.getDefault());
    L68:
        if (r21 != null) goto L70;
    L72:
        r17.add(r18);
        if ((r18 instanceof b0) == false) goto L75;
        r3 = r3 + ((b0) r18).j;
    L75:
        r18 = r18.h;
        goto L58
    L70:
        if (Intrinsics.areEqual(r21, r15) == false) goto L72;
        r4 = r18;
    L67:
        r21 = null;
    L76:
        if (r4 == null) goto L84;
        s r22 = this.a.a(r15, r16);
        if (r22 == null) goto L84;
        r14.l(r22);
        List r110 = CollectionsKt.mutableListOf(new s[]{r14});
        r110.addAll(r17);
        r110.add(r4);
        Iterator r111 = r110.iterator();
    L81:
        if (r111.hasNext() == false) goto L83;
        ((s) r111.next()).p();
        goto L81
    L83:
        r14 = r22.h;
        goto L6
    L54:
        s r23 = this.a.a(r15, r16);
        if (r23 == null) goto L84;
        r14.l(r23);
        r14.p();
        r14 = r23.h;
    L84:
        r14 = r14.h;
        goto L6
    L44:
        if (r10.length() <= 0) goto L46;
        boolean r24 = true;
    L47:
        if (r24 != true) goto L49;
        r11 = true;
        goto L50
    L46:
        r24 = false;
        goto L47
    L29:
        LinkedHashMap r25 = new LinkedHashMap();
        Matcher r26 = d.matcher(r7);
    L31:
        if (r26.find() == false) goto L40;
        String r112 = r26.group(1);
        String r113 = r26.group(2);
        if (r113 != null) goto L39;
        r113 = r26.group(3);
        if (r113 != null) goto L39;
        r113 = r26.group(4);
        if (r113 != null) goto L39;
        r113 = BuildConfig.FLAVOR;
    L39:
        r25.put(r112, r113);
        goto L31
    L40:
        r9 = r25;
        goto L41
    L22:
        if (StringsKt.isBlank(r7) == true) goto L25;
        r8 = false;
        goto L27
    L16:
        r6 = null;
    L12:
        r12 = null;
        goto L51
    }
}
