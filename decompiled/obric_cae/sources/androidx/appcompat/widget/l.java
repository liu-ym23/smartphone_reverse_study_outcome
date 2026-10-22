package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f1206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0.f f1207b;

    public l(TextView r8) {
        this.f1206a = r8;
        this.f1207b = new q0.f(r8);
    }

    public final void a(AttributeSet r8, int r10) {
        TypedArray r11 = this.f1206a.getContext().obtainStyledAttributes(r8, c.a.f3223i, r10, 0);
        boolean r12 = true;
        if (r11.hasValue(14) == false) goto L6;
        r12 = r11.getBoolean(14, true);     // Catch: Throwable -> L8
    L6:
        r11.recycle();
        c(r12);
        return;
    L8:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public final void b(boolean r8) {
        this.f1207b.f10113a.b(r8);
    }

    public final void c(boolean r8) {
        this.f1207b.f10113a.c(r8);
    }
}
