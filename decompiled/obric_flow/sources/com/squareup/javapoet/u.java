package com.squareup.javapoet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f15018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f15019c;
    public final x d;
    public final i e;

    public u(jk.a r5) {
        String r10 = (String) r5.f18350b;
        com.bytedance.android.anniex.base.service.f.s(r10, "name == null", new Object[0]);
        this.f15017a = r10;
        this.f15018b = com.bytedance.android.anniex.base.service.f.x((ArrayList) r5.d);
        this.f15019c = com.bytedance.android.anniex.base.service.f.y((ArrayList) r5.e);
        x r11 = (x) r5.f18349a;
        com.bytedance.android.anniex.base.service.f.s(r11, "type == null", new Object[0]);
        this.d = r11;
        g r12 = (g) r5.f18351c;
        r12.getClass();
        this.e = new i(r12);
    }

    public static jk.a a(x r5, String r10, Modifier... r11) {
        com.bytedance.android.anniex.base.service.f.s(r5, "type == null", new Object[0]);
        com.bytedance.android.anniex.base.service.f.r(d(r10), "not a valid name: %s", new Object[]{r10});
        jk.a r12 = new jk.a(r10, r5);
        Collections.addAll((ArrayList) r12.e, r11);
        return r12;
    }

    public static jk.a b(Modifier... r5) {
        return a(x.e(String.class), "_value", r5);
    }

    public static boolean d(String r5) {
        if (r5.endsWith(".this") == false) goto L7;
        return SourceVersion.isIdentifier(androidx.constraintlayout.motion.widget.a.n(r5, 5, 0));
    L7:
        if (r5.equals("this") == false) goto L9;
    L10:
        return true;
    L9:
        if (SourceVersion.isName(r5) == true) goto L10;
        return false;
    }

    public final void c(k r5, boolean r10) {
        r5.f(this.f15018b, true);
        Set r11 = Collections.emptySet();
        r5.h(this.f15019c, r11);
        x r12 = this.d;
        if (r10 == false) goto L5;
        x.a(r12).n(r5, true);
    L6:
        r5.b(" $L", new Object[]{this.f15017a});
        return;
    L5:
        r12.c(r5);
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (u.class == r5.getClass()) goto L12;
        return false;
    L12:
        return toString().equals(r5.toString());
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        c(new k(r5), false);     // Catch: IOException -> L5
        return r5.toString();
    L6:
        throw new AssertionError();
    }
}
