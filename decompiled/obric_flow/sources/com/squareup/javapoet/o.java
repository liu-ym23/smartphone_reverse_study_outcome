package com.squareup.javapoet;

import ai.j0;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.JavaFileObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final n g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f14994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f14996c;
    public final Set d;
    public final Set e;
    public final String f;

    static {
        g = new n();
    }

    public o(z4.a r5) {
        g r10 = (g) r5.f23391c;
        r10.getClass();
        this.f14994a = new i(r10);
        this.f14995b = (String) r5.f23389a;
        z r11 = (z) r5.f23390b;
        this.f14996c = r11;
        this.d = com.bytedance.android.anniex.base.service.f.y((TreeSet) r5.e);
        this.f = (String) r5.d;
        LinkedHashSet r12 = new LinkedHashSet();
        b(r11, r12);
        this.e = com.bytedance.android.anniex.base.service.f.y(r12);
    }

    public static void b(z r5, LinkedHashSet r10) {
        r10.addAll(r5.f15066r);
        Iterator r11 = r5.f15063o.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        b((z) r11.next(), r10);
        goto L4
    }

    public final void a(k r10) {
        String r5 = r10.f;
        boolean r11 = true;
        if (r5 != k.f14975q) goto L5;
        boolean r12 = true;
    L6:
        com.bytedance.android.anniex.base.service.f.t(r12, "package already set: %s", new Object[]{r5});
        String r13 = this.f14995b;
        com.bytedance.android.anniex.base.service.f.s(r13, "packageName == null", new Object[0]);
        r10.f = r13;
        i r14 = this.f14994a;
        if (r14.f14971a.isEmpty() == true) goto L15;
        r10.f14986o = true;
        r10.e = true;
        r10.c(r14, false);     // Catch: Throwable -> L11
        r10.e("\n");     // Catch: Throwable -> L11
        r10.e = false;
    L11:
        th = move-exception;
        r10.e = false;
        throw th;
    L15:
        if (r13.isEmpty() == true) goto L17;
        r10.b("package $L;\n", new Object[]{r13});
        r10.e("\n");
    L17:
        Set r15 = this.d;
        if (r15.isEmpty() == true) goto L24;
        Iterator r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L23;
        r10.b("import static $L;\n", new Object[]{(String) r16.next()});
        goto L21
    L23:
        r10.e("\n");
    L24:
        Iterator r17 = new TreeSet(r10.f14982k.values()).iterator();
        int r18 = 0;
    L26:
        if (r17.hasNext() == false) goto L28;
        r10.b("import $L;\n", new Object[]{((e) r17.next()).t()});
        r18 = r18 + 1;
        goto L26
    L28:
        if (r18 <= 0) goto L30;
        r10.e("\n");
    L30:
        this.f14996c.b(r10, null, Collections.emptySet());
        String r19 = r10.f;
        String r20 = k.f14975q;
        if (r19 != r20) goto L34;
        r11 = false;
    L34:
        com.bytedance.android.anniex.base.service.f.t(r11, "package not set", new Object[0]);
        r10.f = r20;
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final void c(Appendable r12) {
        n r5 = g;
        Set r10 = this.e;
        k r11 = new k(r5, this.f, this.d, r10);
        a(r11);
        LinkedHashMap r13 = new LinkedHashMap(r11.f14983l);
        r13.keySet().removeAll(r11.f14984m);
        Set r14 = this.e;
        a(new k(r12, this.f, r13, this.d, r14));
    }

    public final void d(Filer r5) {
        String r10 = this.f14995b;
        boolean r11 = r10.isEmpty();
        z r12 = this.f14996c;
        if (r11 == false) goto L5;
        String r13 = r12.f15054b;
    L6:
        List r14 = r12.f15065q;
        JavaFileObject r15 = r5.createSourceFile(r13, (Element[]) r14.toArray(new Element[r14.size()]));
        Writer r16 = r15.openWriter();     // Catch: Exception -> L21
        c(r16);     // Catch: Throwable -> L12
        if (r16 == null) goto L34;
        r16.close();     // Catch: Exception -> L21
        return;
    L34:
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r16 != null) goto L27;
    L20:
        throw th;     // Catch: Exception -> L21
    L27:
        r16.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        r15.delete();     // Catch: Exception -> L24
    L23:
        throw e;
    L5:
        StringBuilder r17 = j0.w(r10, ".");
        r17.append(r12.f15054b);
        r13 = r17.toString();
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (o.class == r5.getClass()) goto L12;
        return false;
    L12:
        return toString().equals(r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();     // Catch: IOException -> L4
        c(r5);     // Catch: IOException -> L4
        return r5.toString();
    L5:
        throw new AssertionError();
    }
}
