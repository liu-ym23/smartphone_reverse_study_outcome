package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.background.BackgroundRepeat;
import com.lynx.tasm.behavior.ui.utils.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class f<T extends d<?>> {
    public final LynxContext a;
    public T b;
    public Drawable.Callback c;
    public float d;

    public abstract T a();

    public final T b() {
        if (this.b != null) goto L6;
        T r0 = (T) a();
        this.b = r0;
        r0.setCallback(this.c);
    L6:
        return this.b;
    }

    public final void c() {
        T r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator r1 = ((ArrayList) r0.e.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((a7a.d) r1.next()).d();
        goto L7
    }

    public final void d() {
        T r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator r1 = ((ArrayList) r0.e.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((a7a.d) r1.next()).e();
        goto L7
    }

    public final void e() {
        T r0 = this.b;
        if (r0 == null) goto L8;
        Iterator r1 = ((ArrayList) r0.e.a).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((a7a.d) r1.next()).f();
        goto L6
    L10:
        return;
    }

    public f(LynxContext r2) {
        this.c = null;
        this.a = r2;
    }

    public final void f(Bitmap.Config r4) {
        T r0 = b().e;
        if (r0 == 0) goto L14;
        r0.i = r4;
        List<a7a.d> r5 = r0.a;
        if (r5 == null) goto L20;
        Iterator r6 = ((ArrayList) r5).iterator();
    L10:
        if (r6.hasNext() == false) goto L21;
        a7a.d r1 = (a7a.d) r6.next();
        if (r1 == null) goto L10;
        r1.h(r0.i);
        goto L10
    L21:
        return;
    L20:
        return;
    }

    public final void g(ReadableArray r6) {
        T r0 = b().e;
        ((ArrayList) r0.d).clear();
        if (r6 == null) goto L15;
        int r1 = r6.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L19;
        int r3 = r6.getInt(r2);
        if (r3 >= 0) goto L10;
    L13:
        ((ArrayList) r0.d).add(1);
    L14:
        r2 = r2 + 1;
        goto L6
    L10:
        if (r3 > 4) goto L13;
        List<Integer> r4 = r0.d;
        ArrayList r5 = (ArrayList) r4;
        r5.add(Integer.valueOf(r3));
        goto L14
    L19:
        return;
    }

    public final void h(ReadableArray r6) {
        T r0 = b().e;
        ((ArrayList) r0.c).clear();
        if (r6 == null) goto L13;
        int r1 = r6.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L17;
        int r3 = r6.getInt(r2);
        if (r3 >= 0) goto L10;
    L11:
        r3 = 1;
    L12:
        List<Integer> r4 = r0.c;
        ArrayList r5 = (ArrayList) r4;
        r5.add(Integer.valueOf(r3));
        r2 = r2 + 1;
        goto L6
    L10:
        if (r3 <= 2) goto L12;
    L17:
        return;
    }

    public final void i(ReadableArray r7) {
        T r0 = b().e;
        ((ArrayList) r0.b).clear();
        if (r7 != null) goto L5;
        return;
    L5:
        if ((r7.size() % 2) != 0) goto L13;
        int r1 = 0;
    L9:
        if (r1 >= r7.size()) goto L14;
        int r2 = r7.getInt(r1 + 1);
        List<a7a.h> r3 = r0.b;
        ArrayList r4 = (ArrayList) r3;
        r4.add(new a7a.h(r7.getDynamic(r1), r2));
        r1 = r1 + 2;
        goto L9
    L14:
        return;
    }

    public final void j(ReadableArray r6) {
        T r0 = b().e;
        ((ArrayList) r0.e).clear();
        if (r6 == null) goto L8;
        int r1 = r6.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L10;
        List<BackgroundRepeat> r3 = r0.e;
        ArrayList r4 = (ArrayList) r3;
        r4.add(BackgroundRepeat.valueOf(r6.getInt(r2)));
        r2 = r2 + 1;
        goto L6
    L10:
        return;
    }

    public final void k(ReadableArray r8) {
        T r0 = b().e;
        ((ArrayList) r0.f).clear();
        if (r8 != null) goto L5;
        return;
    L5:
        if ((r8.size() % 2) != 0) goto L12;
        int r1 = r8.size();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        List<a7a.j> r3 = r0.f;
        ArrayList r4 = (ArrayList) r3;
        r4.add(new a7a.j(r8.getDynamic(r2), r8.getInt(r2 + 1)));
        r2 = r2 + 2;
        goto L8
    L13:
        return;
    }
}
