package com.lynx.tasm.behavior.ui.utils;

import ai.j0;
import android.graphics.Bitmap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.background.BackgroundRepeat;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f10749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f10750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.h f10751c;
    public float d;

    public h(LynxContext r5) {
        this.f10751c = null;
        this.f10749a = r5;
    }

    public abstract f a();

    public final void b(Bitmap.Config r5) {
        an.j r10 = d().e;
        if (r10 == null) goto L14;
        r10.f348i = r5;
        ArrayList r11 = r10.f344a;
        if (r11 == null) goto L20;
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L21;
        an.c r13 = (an.c) r12.next();
        if (r13 == null) goto L10;
        r13.b(r10.f348i);
        goto L10
    L21:
        return;
    L20:
        return;
    }

    public final void c(ReadableArray r10) {
        an.j r5 = d().e;
        r5.d.clear();
        if (r10 == null) goto L15;
        int r11 = r10.size();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L19;
        int r13 = r10.getInt(r12);
        ArrayList r14 = r5.d;
        if (r13 >= 0) goto L10;
    L13:
        r14.add(1);
    L14:
        r12 = r12 + 1;
        goto L6
    L10:
        if (r13 > 2) goto L13;
        r14.add(Integer.valueOf(r13));
        goto L14
    L19:
        return;
    }

    public final f d() {
        if (this.f10750b != null) goto L6;
        f r5 = a();
        this.f10750b = r5;
        r5.setCallback(this.f10751c);
    L6:
        return this.f10750b;
    }

    public final void e(ReadableArray r10) {
        an.j r5 = d().e;
        r5.f346c.clear();
        if (r10 == null) goto L13;
        int r11 = r10.size();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L17;
        int r13 = r10.getInt(r12);
        if (r13 >= 0) goto L10;
    L11:
        r13 = 1;
    L12:
        r12 = j0.d(r13, r5.f346c, r12, 1);
        goto L6
    L10:
        if (r13 <= 2) goto L12;
    L17:
        return;
    }

    public final void f() {
        f r5 = this.f10750b;
        if (r5 == null) goto L9;
        Iterator r10 = r5.e.f344a.iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        ((an.c) r10.next()).i();
        goto L7
    L11:
        return;
    }

    public final void g(ReadableArray r10) {
        an.j r5 = d().e;
        r5.f345b.clear();
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10.size() % 2) != 0) goto L13;
        int r11 = 0;
    L9:
        if (r11 >= r10.size()) goto L14;
        int r12 = r10.getInt(r11 + 1);
        r5.f345b.add(new an.g(r10.getDynamic(r11), r12));
        r11 = r11 + 2;
        goto L9
    L14:
        return;
    }

    public final void h(ReadableArray r10) {
        an.j r5 = d().e;
        r5.e.clear();
        if (r10 == null) goto L27;
        int r11 = r10.size();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L36;
        ArrayList r13 = r5.e;
        int r14 = r10.getInt(r12);
        if (r14 != 0) goto L10;
        BackgroundRepeat r15 = BackgroundRepeat.f10424a;
    L26:
        r13.add(r15);
        r12 = r12 + 1;
        goto L6
    L10:
        if (r14 != 1) goto L12;
        r15 = BackgroundRepeat.f10425b;
        goto L26
    L12:
        if (r14 != 2) goto L14;
        r15 = BackgroundRepeat.f10426c;
        goto L26
    L14:
        if (r14 != 3) goto L16;
        r15 = BackgroundRepeat.d;
        goto L26
    L16:
        if (r14 != 4) goto L18;
        r15 = BackgroundRepeat.e;
        goto L26
    L18:
        if (r14 == 5) goto L20;
        r15 = BackgroundRepeat.f10424a;
        goto L26
    L20:
        r15 = BackgroundRepeat.f;
        goto L26
    L36:
        return;
    }

    public final void i(ReadableArray r10) {
        an.j r11 = d().e;
        r11.f.clear();
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10.size() % 2) != 0) goto L12;
        int r5 = r10.size();
        int r12 = 0;
    L8:
        if (r12 >= r5) goto L13;
        r11.f.add(new an.i(r10.getDynamic(r12), r10.getInt(r12 + 1)));
        r12 = r12 + 2;
        goto L8
    L13:
        return;
    }
}
