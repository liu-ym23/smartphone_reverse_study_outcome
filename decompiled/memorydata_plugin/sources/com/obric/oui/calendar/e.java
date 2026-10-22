package com.obric.oui.calendar;

import android.graphics.drawable.Drawable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f13440b;
    private Drawable c;
    private final LinkedList<a> d;
    private boolean e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f13441a;
    }

    e() {
        this.f13440b = null;
        this.c = null;
        this.d = new LinkedList();
        this.e = false;
        this.f13439a = false;
    }

    void a() {
        this.f13440b = null;
        this.c = null;
        this.d.clear();
        this.f13439a = false;
        this.e = false;
    }

    public void a(Drawable r1) {
        if (r1 == null) goto L6;
        this.f13440b = r1;
        this.f13439a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    void a(e r3) {
        Drawable r0 = this.c;
        if (r0 == null) goto L5;
        r3.b(r0);
    L5:
        Drawable r1 = this.f13440b;
        if (r1 == null) goto L8;
        r3.a(r1);
    L8:
        r3.d.addAll(this.d);
        r3.f13439a |= this.f13439a;
        r3.e = this.e;
    }

    public void b(Drawable r1) {
        if (r1 == null) goto L6;
        this.c = r1;
        this.f13439a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    boolean b() {
        return this.f13439a;
    }

    Drawable c() {
        return this.c;
    }

    Drawable d() {
        return this.f13440b;
    }

    List<a> e() {
        return Collections.unmodifiableList(this.d);
    }

    public boolean f() {
        return this.e;
    }
}
