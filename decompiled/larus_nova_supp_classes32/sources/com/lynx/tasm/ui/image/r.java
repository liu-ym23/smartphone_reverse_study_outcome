package com.lynx.tasm.ui.image;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r extends BaseDataSubscriber<Object> {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ q c;

    public final void onFailureImpl(DataSource<Object> r5) {
        this.c.j(this.a, r5, r5.getFailureCause(), true);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    public final void onNewResultImpl(DataSource<Object> r11) {
        boolean r0 = r11.isFinished();
        float r1 = r11.getProgress();
        ?? r2 = r11.getResult();
        if (r2 == 0) goto L41;
        q r3 = this.c;
        String r4 = this.a;
        boolean r5 = this.b;
        if (r3.i(r4, r11) == true) goto L8;
        r3.m(r2);
        r11.close();
        return;
    L8:
        if (r3.b(r11, r2) == false) goto L53;
        Drawable r12 = r3.c(r2);     // Catch: Exception -> L39
        T r6 = r3.h;
        Drawable r7 = r3.i;
        r3.h = r2;
        r3.i = r12;
        if (r0 == false) goto L21;
        Animatable r8 = null;
        r3.g = null;     // Catch: Throwable -> L31
        SettableDraweeHierarchy r9 = r3.l;     // Catch: Throwable -> L31
        if (r9 == null) goto L17;
        r9.setImage(r12, 1.0f, r5);     // Catch: Throwable -> L31
    L17:
        ControllerListener r10 = r3.d();     // Catch: Throwable -> L31
        Object r13 = r3.g(r2);     // Catch: Throwable -> L31
        Object r14 = r3.i;     // Catch: Throwable -> L31
        if ((r14 instanceof Animatable) == false) goto L20;
        r8 = (Animatable) r14;     // Catch: Throwable -> L31
    L20:
        r10.onFinalImageSet(r4, r13, r8);     // Catch: Throwable -> L31
    L25:
        if (r7 == null) goto L28;
        if (r7 == r12) goto L28;
        r3.k(r7);
    L28:
        if (r6 == 0) goto L48;
        if (r6 == r2) goto L49;
        r3.m(r6);
        return;
    L49:
        return;
    L48:
        return;
    L21:
        SettableDraweeHierarchy r15 = r3.l;     // Catch: Throwable -> L31
        if (r15 == null) goto L24;
        r15.setImage(r12, r1, r5);     // Catch: Throwable -> L31
    L24:
        r3.d().onIntermediateImageSet(r4, r3.g(r2));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if (r7 == null) goto L35;
        if (r7 == r12) goto L35;
        r3.k(r7);
    L35:
        if (r6 == 0) goto L38;
        if (r6 == r2) goto L38;
        r3.m(r6);
    L38:
        throw th;
    L39:
        e = move-exception;
        r3.m(r2);
        r3.j(r4, r11, e, r0);
        return;
    L53:
        return;
    L41:
        if (r0 == false) goto L52;
        this.c.j(this.a, r11, new NullPointerException(), true);
        return;
    }

    public final void onProgressUpdate(DataSource<Object> r5) {
        boolean r0 = r5.isFinished();
        float r1 = r5.getProgress();
        q r2 = this.c;
        if (r2.i(this.a, r5) == true) goto L5;
        r5.close();
        return;
    L5:
        if (r0 == true) goto L11;
        SettableDraweeHierarchy r6 = r2.l;
        if (r6 == null) goto L12;
        r6.setProgress(r1, false);
        return;
    L12:
        return;
    }

    public r(q r1, String r2, boolean r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
