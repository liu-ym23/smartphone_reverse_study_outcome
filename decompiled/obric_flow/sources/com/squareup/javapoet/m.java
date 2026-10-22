package com.squareup.javapoet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f14991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f14993c;
    public final List d;
    public final Set e;
    public final i f;

    public m(l r5) {
        x r10 = r5.f14988a;
        com.bytedance.android.anniex.base.service.f.s(r10, "type == null", new Object[0]);
        this.f14991a = r10;
        String r11 = r5.f14989b;
        com.bytedance.android.anniex.base.service.f.s(r11, "name == null", new Object[0]);
        this.f14992b = r11;
        g r12 = r5.f14990c;
        r12.getClass();
        this.f14993c = new i(r12);
        this.d = com.bytedance.android.anniex.base.service.f.x(r5.e);
        this.e = com.bytedance.android.anniex.base.service.f.y(r5.f);
        i r13 = r5.d;
        if (r13 != null) goto L5;
        r13 = new i(new g());
    L5:
        this.f = r13;
    }

    public static l a(x r5, String r10, Modifier... r11) {
        com.bytedance.android.anniex.base.service.f.s(r5, "type == null", new Object[0]);
        com.bytedance.android.anniex.base.service.f.r(SourceVersion.isName(r10), "not a valid name: %s", new Object[]{r10});
        l r12 = new l(r10, r5);
        r12.b(r11);
        return r12;
    }

    public final void b(k r5, Set r10) {
        r5.g(this.f14993c);
        r5.f(this.d, false);
        r5.h(this.e, r10);
        r5.b("$T $L", new Object[]{this.f14991a, this.f14992b});
        i r11 = this.f;
        if (r11.f14971a.isEmpty() == true) goto L5;
        r5.e(" = ");
        r5.c(r11, false);
    L5:
        r5.e(";\n");
    }

    public final boolean c(Modifier r5) {
        return this.e.contains(r5);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (m.class == r5.getClass()) goto L12;
        return false;
    L12:
        return toString().equals(r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        b(new k(r5), Collections.emptySet());     // Catch: IOException -> L5
        return r5.toString();
    L6:
        throw new AssertionError();
    }
}
