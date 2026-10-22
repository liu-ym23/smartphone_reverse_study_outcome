package com.obric.oui.calendar;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f6347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f6348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedList<a> f6349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6350e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f6351a;
    }

    e() {
        this.f6347b = null;
        this.f6348c = null;
        this.f6349d = new LinkedList();
        this.f6350e = false;
        this.f6346a = false;
    }

    void a(e r10) {
        Drawable r11 = this.f6348c;
        if (r11 == null) goto L5;
        r10.i(r11);
    L5:
        Drawable r12 = this.f6347b;
        if (r12 == null) goto L8;
        r10.h(r12);
    L8:
        r10.f6349d.addAll(this.f6349d);
        r10.f6346a |= this.f6346a;
        r10.f6350e = this.f6350e;
    }

    public boolean b() {
        return this.f6350e;
    }

    Drawable c() {
        return this.f6347b;
    }

    Drawable d() {
        return this.f6348c;
    }

    List<a> e() {
        return Collections.unmodifiableList(this.f6349d);
    }

    boolean f() {
        return this.f6346a;
    }

    void g() {
        this.f6347b = null;
        this.f6348c = null;
        this.f6349d.clear();
        this.f6346a = false;
        this.f6350e = false;
    }

    public void h(@NonNull Drawable r10) {
        if (r10 == null) goto L6;
        this.f6347b = r10;
        this.f6346a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }

    public void i(@NonNull Drawable r10) {
        if (r10 == null) goto L6;
        this.f6348c = r10;
        this.f6346a = true;
        return;
    L6:
        throw new IllegalArgumentException("Cannot be null");
    }
}
