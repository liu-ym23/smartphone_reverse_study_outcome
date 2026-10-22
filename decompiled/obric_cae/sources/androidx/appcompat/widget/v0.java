package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypedArray f1275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f1276c;

    public v0(Context r8, TypedArray r10) {
        this.f1274a = r8;
        this.f1275b = r10;
    }

    public static v0 m(Context r8, AttributeSet r10, int[] r11, int r12) {
        return new v0(r8, r8.obtainStyledAttributes(r10, r11, r12, 0));
    }

    public final boolean a(int r8, boolean r10) {
        return this.f1275b.getBoolean(r8, r10);
    }

    public final ColorStateList b(int r8) {
        TypedArray r10 = this.f1275b;
        if (r10.hasValue(r8) == false) goto L10;
        int r11 = r10.getResourceId(r8, 0);
        if (r11 == 0) goto L10;
        ColorStateList r12 = androidx.core.content.a.b(this.f1274a, r11);
        if (r12 == null) goto L10;
        return r12;
    L10:
        return r10.getColorStateList(r8);
    }

    public final int c(int r8, int r10) {
        return this.f1275b.getDimensionPixelOffset(r8, r10);
    }

    public final int d(int r8, int r10) {
        return this.f1275b.getDimensionPixelSize(r8, r10);
    }

    public final Drawable e(int r8) {
        TypedArray r10 = this.f1275b;
        if (r10.hasValue(r8) == false) goto L9;
        int r11 = r10.getResourceId(r8, 0);
        if (r11 == 0) goto L9;
        return d.a.a(this.f1274a, r11);
    L9:
        return r10.getDrawable(r8);
    }

    public final Drawable f(int r8) {
        if (this.f1275b.hasValue(r8) == false) goto L14;
        int r10 = this.f1275b.getResourceId(r8, 0);
        if (r10 == 0) goto L18;
        j r11 = j.a();
        Context r12 = this.f1274a;
        monitor-enter(r11);
        Drawable r13 = r11.f1193a.f(r12, true, r10);     // Catch: Throwable -> L11
        monitor-exit(r11);
        return r13;
    L11:
        th = move-exception;
        throw th;
    L18:
        return null;
    L14:
        return null;
    }

    public final Typeface g(int r10, int r11, w.a r12) {
        int r8 = this.f1275b.getResourceId(r10, 0);
        if (r8 != 0) goto L6;
        return null;
    L6:
        if (this.f1276c != null) goto L8;
        this.f1276c = new TypedValue();
    L8:
        TypedValue r13 = this.f1276c;
        ThreadLocal<TypedValue> r14 = z.f.f14146a;
        Context r15 = this.f1274a;
        if (r15.isRestricted() == false) goto L12;
        return null;
    L12:
        return z.f.b(r15, r8, r13, r11, r12, true, false);
    }

    public final int h(int r8, int r10) {
        return this.f1275b.getInt(r8, r10);
    }

    public final int i(int r8, int r10) {
        return this.f1275b.getResourceId(r8, r10);
    }

    public final String j(int r8) {
        return this.f1275b.getString(r8);
    }

    public final CharSequence k(int r8) {
        return this.f1275b.getText(r8);
    }

    public final boolean l(int r8) {
        return this.f1275b.hasValue(r8);
    }

    public final void n() {
        this.f1275b.recycle();
    }
}
