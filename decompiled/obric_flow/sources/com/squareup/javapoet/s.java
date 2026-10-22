package com.squareup.javapoet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f15004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x f15005c;
    public final LinkedHashSet d;
    public final g e;
    public boolean f;
    public i g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f15006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f15007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f15008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f15009k;

    public s(String r5) {
        int r10 = i.f14970c;
        this.f15004b = new g();
        this.d = new LinkedHashSet();
        this.e = new g();
        this.f15006h = new ArrayList();
        this.f15007i = new ArrayList();
        this.f15008j = new ArrayList();
        this.f15009k = new ArrayList();
        w(r5);
    }

    public static /* synthetic */ g a(s r5) {
        return r5.e;
    }

    public static /* synthetic */ String b(s r5) {
        return r5.f15003a;
    }

    public static /* synthetic */ boolean c(s r5) {
        return r5.f;
    }

    public static /* synthetic */ g d(s r5) {
        return r5.f15004b;
    }

    public static /* synthetic */ x e(s r5) {
        return r5.f15005c;
    }

    public static /* synthetic */ LinkedHashSet f(s r5) {
        return r5.d;
    }

    public static /* synthetic */ i g(s r5) {
        return r5.g;
    }

    public final void h() {
        i(e.n(Override.class));
    }

    public final void i(e r5) {
        this.f15007i.add(b.a(r5).b());
    }

    public final void j(i r5) {
        this.e.a(r5);
    }

    public final void k(x r5) {
        this.d.add(r5);
    }

    public final void l(Modifier... r5) {
        Collections.addAll(this.f15008j, r5);
    }

    public final void m(u r5) {
        this.f15009k.add(r5);
    }

    public final void n(x r5, String r10, Modifier... r11) {
        m(new u(u.a(r5, r10, r11)));
    }

    public final void o(String r5, Object... r10) {
        this.e.c(r5, r10);
    }

    public final void p(List r5) {
        if (r5 == null) goto L5;
        boolean r10 = true;
    L6:
        com.bytedance.android.anniex.base.service.f.r(r10, "typeVariables == null", new Object[0]);
        Iterator r11 = r5.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        this.f15006h.add((a0) r11.next());
        goto L8
    L10:
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void q(String r5, Object... r10) {
        this.e.e(r5, r10);
    }

    public final t r() {
        return new t(this);
    }

    public final void s() {
        this.e.g();
    }

    public final void t(String r5, Object... r10) {
        this.e.h(r5, r10);
    }

    public final void u() {
        v(x.e(String.class));
    }

    public final void v(x r5) {
        com.bytedance.android.anniex.base.service.f.t(!this.f15003a.equals("<init>"), "constructor cannot have return type.", new Object[0]);
        this.f15005c = r5;
    }

    public final void w(String r5) {
        boolean r10 = false;
        com.bytedance.android.anniex.base.service.f.s(r5, "name == null", new Object[0]);
        if (r5.equals("<init>") == false) goto L5;
    L6:
        r10 = true;
    L7:
        com.bytedance.android.anniex.base.service.f.r(r10, "not a valid name: %s", new Object[]{r5});
        this.f15003a = r5;
        if (r5.equals("<init>") == false) goto L10;
        x r11 = null;
    L11:
        this.f15005c = r11;
        return;
    L10:
        r11 = x.d;
        goto L11
    L5:
        if (SourceVersion.isName(r5) == false) goto L7;
        goto L6
    }

    public final void x(boolean r5) {
        this.f = r5;
    }
}
