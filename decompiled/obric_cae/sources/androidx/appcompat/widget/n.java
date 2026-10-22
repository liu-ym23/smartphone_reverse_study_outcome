package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f1219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t0 f1220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1221c;

    public n(ImageView r8) {
        this.f1221c = 0;
        this.f1219a = r8;
    }

    public final void a() {
        ImageView r8 = this.f1219a;
        Drawable r10 = r8.getDrawable();
        if (r10 == null) goto L5;
        Rect r11 = d0.f1115a;
    L5:
        if (r10 == null) goto L10;
        t0 r12 = this.f1220b;
        if (r12 == null) goto L11;
        j.e(r10, r12, r8.getDrawableState());
        return;
    L11:
        return;
    }

    public final void b(AttributeSet r10, int r11) {
        ImageView r8 = this.f1219a;
        Context r12 = r8.getContext();
        int[] r13 = c.a.f3220f;
        v0 r14 = v0.m(r12, r10, r13, r11);
        Context r15 = r8.getContext();
        TypedArray r16 = r14.f1275b;
        WeakHashMap<View, j0.h0> r17 = j0.w.f8437a;
        j0.w.m.c(r8, r15, r13, r10, r16, r11, 0);
        Drawable r18 = r8.getDrawable();     // Catch: Throwable -> L20
        if (r18 != null) goto L10;
        int r19 = r14.i(1, -1);     // Catch: Throwable -> L20
        if (r19 == (-1)) goto L10;
        r18 = d.a.a(r8.getContext(), r19);     // Catch: Throwable -> L20
        if (r18 == null) goto L10;
        r8.setImageDrawable(r18);     // Catch: Throwable -> L20
    L10:
        if (r18 == null) goto L13;
        Rect r20 = d0.f1115a;     // Catch: Throwable -> L20
    L13:
        if (r14.l(2) == false) goto L16;
        androidx.core.widget.f.c(r8, r14.b(2));     // Catch: Throwable -> L20
    L16:
        if (r14.l(3) == false) goto L18;
        androidx.core.widget.f.d(r8, d0.b(r14.h(3, -1), null));     // Catch: Throwable -> L20
    L18:
        r14.n();
        return;
    L20:
        th = move-exception;
        r14.n();
        throw th;
    }
}
