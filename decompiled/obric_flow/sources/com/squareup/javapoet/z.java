package com.squareup.javapoet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeSpec$Kind f15053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f15055c;
    public final i d;
    public final List e;
    public final Set f;
    public final List g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f15056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f15057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f15058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f15059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f15060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i f15061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f15062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f15063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set f15064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f15065q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Set f15066r;

    public z(y r5) {
        this.f15053a = r5.f15040a;
        this.f15054b = r5.f15041b;
        this.f15055c = r5.f15042c;
        g r10 = r5.d;
        r10.getClass();
        this.d = new i(r10);
        this.e = com.bytedance.android.anniex.base.service.f.x(r5.f15044i);
        this.f = com.bytedance.android.anniex.base.service.f.y(r5.f15045j);
        this.g = com.bytedance.android.anniex.base.service.f.x(r5.f15046k);
        this.f15056h = r5.e;
        this.f15057i = com.bytedance.android.anniex.base.service.f.x(r5.f15047l);
        this.f15058j = Collections.unmodifiableMap(new LinkedHashMap(r5.f15043h));
        this.f15059k = com.bytedance.android.anniex.base.service.f.x(r5.f15048m);
        g r11 = r5.f;
        r11.getClass();
        this.f15060l = new i(r11);
        g r12 = r5.g;
        r12.getClass();
        this.f15061m = new i(r12);
        this.f15062n = com.bytedance.android.anniex.base.service.f.x(r5.f15049n);
        ArrayList r13 = r5.f15050o;
        this.f15063o = com.bytedance.android.anniex.base.service.f.x(r13);
        this.f15066r = com.bytedance.android.anniex.base.service.f.y(r5.f15052q);
        this.f15064p = new HashSet(r13.size());
        ArrayList r14 = new ArrayList();
        r14.addAll(r5.f15051p);
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        z r16 = (z) r15.next();
        this.f15064p.add(r16.f15054b);
        r14.addAll(r16.f15065q);
        goto L4
    L6:
        this.f15065q = com.bytedance.android.anniex.base.service.f.x(r14);
    }

    public static y a(String r5, Object... r10) {
        i r11 = i.d(r5, r10);
        return new y(TypeSpec$Kind.CLASS, null, r11);
    }

    public final void b(k r10, String r11, Set r12) {
        int r5 = r10.f14987p;
        r10.f14987p = -1;
        boolean r13 = true;
        if (r11 == null) goto L19;
        r10.g(this.d);     // Catch: Throwable -> L7
        r10.f(this.e, false);     // Catch: Throwable -> L7
        r10.b("$L", new Object[]{r11});     // Catch: Throwable -> L7
        if (this.f15055c.f14971a.isEmpty() == true) goto L10;
        r10.d("(");     // Catch: Throwable -> L7
        r10.a(this.f15055c);     // Catch: Throwable -> L7
        r10.d(")");     // Catch: Throwable -> L7
    L10:
        if (this.f15059k.isEmpty() == true) goto L12;
    L17:
        r10.d(" {\n");     // Catch: Throwable -> L7
    L58:
        r10.p(this);     // Catch: Throwable -> L7
        r10.l();     // Catch: Throwable -> L7
        Iterator r14 = this.f15058j.entrySet().iterator();     // Catch: Throwable -> L7
    L61:
        if (r14.hasNext() == false) goto L78;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L7
        if (r13 == true) goto L65;
        r10.d("\n");     // Catch: Throwable -> L7
    L65:
        ((z) r15.getValue()).b(r10, (String) r15.getKey(), Collections.emptySet());     // Catch: Throwable -> L7
        if (r14.hasNext() == false) goto L69;
        r10.d(",\n");     // Catch: Throwable -> L7
    L77:
        r13 = false;
        goto L61
    L69:
        if (this.f15059k.isEmpty() == true) goto L71;
    L76:
        r10.d(";\n");     // Catch: Throwable -> L7
        goto L77
    L71:
        if (this.f15062n.isEmpty() == false) goto L76;
        if (this.f15063o.isEmpty() == false) goto L76;
        r10.d("\n");     // Catch: Throwable -> L7
        goto L77
    L78:
        Iterator r16 = this.f15059k.iterator();     // Catch: Throwable -> L7
    L80:
        if (r16.hasNext() == false) goto L88;
        m r17 = (m) r16.next();     // Catch: Throwable -> L7
        if (r17.c(Modifier.STATIC) == false) goto L80;
        if (r13 == true) goto L86;
        r10.d("\n");     // Catch: Throwable -> L7
    L86:
        r17.b(r10, TypeSpec$Kind.access$900(this.f15053a));     // Catch: Throwable -> L7
        r13 = false;
        goto L80
    L88:
        if (this.f15060l.b() == true) goto L92;
        if (r13 == true) goto L91;
        r10.d("\n");     // Catch: Throwable -> L7
    L91:
        r10.a(this.f15060l);     // Catch: Throwable -> L7
        r13 = false;
    L92:
        Iterator r18 = this.f15059k.iterator();     // Catch: Throwable -> L7
    L94:
        if (r18.hasNext() == false) goto L102;
        m r19 = (m) r18.next();     // Catch: Throwable -> L7
        if (r19.c(Modifier.STATIC) == true) goto L94;
        if (r13 == true) goto L100;
        r10.d("\n");     // Catch: Throwable -> L7
    L100:
        r19.b(r10, TypeSpec$Kind.access$900(this.f15053a));     // Catch: Throwable -> L7
        r13 = false;
        goto L94
    L102:
        if (this.f15061m.b() == true) goto L106;
        if (r13 == true) goto L105;
        r10.d("\n");     // Catch: Throwable -> L7
    L105:
        r10.a(this.f15061m);     // Catch: Throwable -> L7
        r13 = false;
    L106:
        Iterator r110 = this.f15062n.iterator();     // Catch: Throwable -> L7
    L108:
        if (r110.hasNext() == false) goto L115;
        t r20 = (t) r110.next();     // Catch: Throwable -> L7
        if (r20.d() == false) goto L108;
        if (r13 == true) goto L114;
        r10.d("\n");     // Catch: Throwable -> L7
    L114:
        r20.b(r10, this.f15054b, TypeSpec$Kind.access$1000(this.f15053a));     // Catch: Throwable -> L7
        r13 = false;
        goto L108
    L115:
        Iterator r111 = this.f15062n.iterator();     // Catch: Throwable -> L7
    L117:
        if (r111.hasNext() == false) goto L124;
        t r21 = (t) r111.next();     // Catch: Throwable -> L7
        if (r21.d() == true) goto L117;
        if (r13 == true) goto L123;
        r10.d("\n");     // Catch: Throwable -> L7
    L123:
        r21.b(r10, this.f15054b, TypeSpec$Kind.access$1000(this.f15053a));     // Catch: Throwable -> L7
        r13 = false;
        goto L117
    L124:
        Iterator r112 = this.f15063o.iterator();     // Catch: Throwable -> L7
    L126:
        if (r112.hasNext() == false) goto L131;
        z r22 = (z) r112.next();     // Catch: Throwable -> L7
        if (r13 == true) goto L130;
        r10.d("\n");     // Catch: Throwable -> L7
    L130:
        r22.b(r10, null, TypeSpec$Kind.access$1100(this.f15053a));     // Catch: Throwable -> L7
        r13 = false;
        goto L126
    L131:
        r10.q();     // Catch: Throwable -> L7
        r10.n();     // Catch: Throwable -> L7
        r10.o(this.g);     // Catch: Throwable -> L7
        r10.d("}");     // Catch: Throwable -> L7
        if (r11 == null) goto L134;
    L136:
        r10.f14987p = r5;
        return;
    L134:
        if (this.f15055c != null) goto L136;
        r10.d("\n");     // Catch: Throwable -> L7
        goto L136
    L12:
        if (this.f15062n.isEmpty() == false) goto L17;
        if (this.f15063o.isEmpty() == false) goto L17;
        r10.f14987p = r5;
        return;
    L19:
        if (this.f15055c != null) goto L21;
        r10.p(new z(this));     // Catch: Throwable -> L7
        r10.g(this.d);     // Catch: Throwable -> L7
        r10.f(this.e, false);     // Catch: Throwable -> L7
        r10.h(this.f, com.bytedance.android.anniex.base.service.f.E(r12, TypeSpec$Kind.access$800(this.f15053a)));     // Catch: Throwable -> L7
        TypeSpec$Kind r113 = this.f15053a;     // Catch: Throwable -> L7
        if (r113 != TypeSpec$Kind.ANNOTATION) goto L29;
        r10.b("$L $L", new Object[]{"@interface", this.f15054b});     // Catch: Throwable -> L7
    L30:
        r10.i(this.g);     // Catch: Throwable -> L7
        if (this.f15053a != TypeSpec$Kind.INTERFACE) goto L34;
        List r114 = this.f15057i;     // Catch: Throwable -> L7
        List r23 = Collections.emptyList();     // Catch: Throwable -> L7
    L40:
        if (r114.isEmpty() == true) goto L49;
        r10.d(" extends");     // Catch: Throwable -> L7
        Iterator r115 = r114.iterator();     // Catch: Throwable -> L7
        boolean r24 = true;
    L43:
        if (r115.hasNext() == false) goto L49;
        x r25 = (x) r115.next();     // Catch: Throwable -> L7
        if (r24 == true) goto L47;
        r10.d(",");     // Catch: Throwable -> L7
    L47:
        r10.b(" $T", new Object[]{r25});     // Catch: Throwable -> L7
        r24 = false;
    L49:
        if (r23.isEmpty() == true) goto L57;
        r10.d(" implements");     // Catch: Throwable -> L7
        Iterator r116 = r23.iterator();     // Catch: Throwable -> L7
        boolean r26 = true;
    L52:
        if (r116.hasNext() == false) goto L57;
        x r27 = (x) r116.next();     // Catch: Throwable -> L7
        if (r26 == true) goto L56;
        r10.d(",");     // Catch: Throwable -> L7
    L56:
        r10.b(" $T", new Object[]{r27});     // Catch: Throwable -> L7
        r26 = false;
    L57:
        r10.n();     // Catch: Throwable -> L7
        r10.d(" {\n");     // Catch: Throwable -> L7
        goto L58
    L34:
        if (this.f15056h.equals(e.B) == false) goto L36;
        r114 = Collections.emptyList();     // Catch: Throwable -> L7
    L37:
        r23 = this.f15057i;     // Catch: Throwable -> L7
        goto L40
    L36:
        r114 = Collections.singletonList(this.f15056h);     // Catch: Throwable -> L7
        goto L37
    L29:
        r10.b("$L $L", new Object[]{r113.name().toLowerCase(Locale.US), this.f15054b});     // Catch: Throwable -> L7
        goto L30
    L21:
        if (this.f15057i.isEmpty() == true) goto L23;
        x r117 = (x) this.f15057i.get(0);     // Catch: Throwable -> L7
    L24:
        r10.b("new $T(", new Object[]{r117});     // Catch: Throwable -> L7
        r10.a(this.f15055c);     // Catch: Throwable -> L7
        r10.d(") {\n");     // Catch: Throwable -> L7
        goto L58
    L23:
        r117 = this.f15056h;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r10.f14987p = r5;
        throw th;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (z.class == r5.getClass()) goto L12;
        return false;
    L12:
        return toString().equals(r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        b(new k(r5), null, Collections.emptySet());     // Catch: IOException -> L5
        return r5.toString();
    L6:
        throw new AssertionError();
    }

    public z(z r5) {
        this.f15053a = r5.f15053a;
        this.f15054b = r5.f15054b;
        this.f15055c = null;
        this.d = r5.d;
        this.e = Collections.emptyList();
        this.f = Collections.emptySet();
        this.g = Collections.emptyList();
        this.f15056h = null;
        this.f15057i = Collections.emptyList();
        this.f15058j = Collections.emptyMap();
        this.f15059k = Collections.emptyList();
        this.f15060l = r5.f15060l;
        this.f15061m = r5.f15061m;
        this.f15062n = Collections.emptyList();
        this.f15063o = Collections.emptyList();
        this.f15065q = Collections.emptyList();
        this.f15064p = Collections.emptySet();
        this.f15066r = Collections.emptySet();
    }
}
