package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f1248a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1249b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1250c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1251d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f1252e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f1253f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f1254g = null;

    static {
        f1248a = new ThreadLocal();
        f1249b = new int[]{-16842910};
        f1250c = new int[]{R.attr.state_focused};
        f1251d = new int[]{R.attr.state_pressed};
        f1252e = new int[]{R.attr.state_checked};
        f1253f = new int[0];
        f1254g = new int[1];
    }

    public static void a(View r8, Context r10) {
        TypedArray r11 = r10.obtainStyledAttributes(c.a.f3224j);
    L8:
        th = move-exception;
        r11.recycle();
        throw th;
    L4:
        if (r11.hasValue(117) == true) goto L6;
        Log.e("ThemeUtils", "View " + r8.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");     // Catch: Throwable -> L8
    L6:
        r11.recycle();
    }

    public static int b(Context r8, int r10) {
        ColorStateList r11 = d(r8, r10);
        if (r11 != null) goto L5;
    L8:
        ThreadLocal<TypedValue> r12 = f1248a;
        TypedValue r13 = r12.get();
        if (r13 != null) goto L11;
        r13 = new TypedValue();
        r12.set(r13);
    L11:
        r8.getTheme().resolveAttribute(R.attr.disabledAlpha, r13, true);
        float r14 = r13.getFloat();
        int r15 = c(r8, r10);
        return a0.a.d(r15, Math.round(Color.alpha(r15) * r14));
    L5:
        if (r11.isStateful() == false) goto L8;
        return r11.getColorForState(f1249b, r11.getDefaultColor());
    }

    public static int c(Context r8, int r10) {
        int[] r11 = f1254g;
        r11[0] = r10;
        TypedArray r12 = r8.obtainStyledAttributes(null, r11);
        v0 r13 = new v0(r8, r12);
        int r14 = r12.getColor(0, 0);     // Catch: Throwable -> L6
        r13.n();
        return r14;
    L6:
        th = move-exception;
        r13.n();
        throw th;
    }

    public static ColorStateList d(Context r8, int r10) {
        int[] r11 = f1254g;
        r11[0] = r10;
        v0 r12 = new v0(r8, r8.obtainStyledAttributes(null, r11));
        ColorStateList r13 = r12.b(0);     // Catch: Throwable -> L6
        r12.n();
        return r13;
    L6:
        th = move-exception;
        r12.n();
        throw th;
    }
}
