package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<Matrix> f3433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<RectF> f3434b = null;

    static {
        f3433a = new ThreadLocal();
        f3434b = new ThreadLocal();
    }

    public static void a(@NonNull ViewGroup r10, @NonNull View r11, @NonNull Rect r12) {
        r12.set(0, 0, r11.getWidth(), r11.getHeight());
        c(r10, r11, r12);
    }

    private static void b(ViewParent r10, @NonNull View r11, @NonNull Matrix r12) {
        Object r13 = r11.getParent();
        if ((r13 instanceof View) == false) goto L6;
        if (r13 == r10) goto L6;
        View r14 = (View) r13;
        b(r10, r14, r12);
        r12.preTranslate(-r14.getScrollX(), -r14.getScrollY());
    L6:
        r12.preTranslate(r11.getLeft(), r11.getTop());
        if (r11.getMatrix().isIdentity() == true) goto L10;
        r12.preConcat(r11.getMatrix());
        return;
    }

    public static void c(@NonNull ViewGroup r10, @NonNull View r11, @NonNull Rect r12) {
        ThreadLocal<Matrix> r13 = f3433a;
        Matrix r14 = r13.get();
        if (r14 != null) goto L5;
        r14 = new Matrix();
        r13.set(r14);
    L6:
        b(r10, r11, r14);
        ThreadLocal<RectF> r15 = f3434b;
        RectF r16 = r15.get();
        if (r16 != null) goto L9;
        r16 = new RectF();
        r15.set(r16);
    L9:
        r16.set(r12);
        r14.mapRect(r16);
        r12.set((int) (r16.left + 0.5f), (int) (r16.top + 0.5f), (int) (r16.right + 0.5f), (int) (r16.bottom + 0.5f));
        return;
    L5:
        r14.reset();
        goto L6
    }
}
