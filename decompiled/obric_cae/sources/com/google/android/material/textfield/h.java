package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class h extends aa.f {
    public static final /* synthetic */ int J = 0;
    public a I;

    public static final class a extends aa.f.b {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final RectF f5031v;

        public a(aa.j r8, RectF r10) {
            super(r8);
            this.f5031v = r10;
        }

        @Override // aa.f.b, android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            b r8 = new b(this);
            r8.invalidateSelf();
            return r8;
        }

        public a(a r8) {
            super(r8);
            this.f5031v = r8.f5031v;
        }
    }

    @TargetApi(18)
    public static class b extends h {
        @Override // aa.f
        public final void g(Canvas r8) {
            if (this.I.f5031v.isEmpty() == false) goto L5;
            super.g(r8);
            return;
        L5:
            r8.save();
            r8.clipOutRect(this.I.f5031v);
            super.g(r8);
            r8.restore();
        }
    }

    public h(a r8) {
        super(r8);
        this.I = r8;
    }

    @Override // aa.f, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.I = new a(this.I);
        return this;
    }

    public final void o(float r8, float r10, float r11, float r12) {
        RectF r13 = this.I.f5031v;
        if (r8 == r13.left) goto L5;
    L10:
        r13.set(r8, r10, r11, r12);
        invalidateSelf();
        return;
    L5:
        if (r10 != r13.top) goto L10;
        if (r11 != r13.right) goto L10;
        if (r12 != r13.bottom) goto L10;
    }
}
