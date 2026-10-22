package t08;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends GradientDrawable {
    public static final /* synthetic */ int e = 0;
    public ColorStateList a;
    public ColorStateList b;
    public int c;
    public boolean d;

    /* JADX INFO: renamed from: t08.a$a, reason: collision with other inner class name */
    public static final class C0127a {
        public static a a(ColorStateList r1, int r2, ColorStateList r3, int r4, int r5, int r6, int r7, boolean r8, int r9) {
            a r0 = new a();
            r0.a = r1;
            r0.setColor(r1);
            r0.c = r2;
            r0.b = r3;
            r0.setStroke(r2, r3);
            if (r4 > 0) goto L11;
            if (r5 > 0) goto L11;
            if (r6 > 0) goto L11;
            if (r7 > 0) goto L11;
            r0.setCornerRadius(r9);
            if (r9 > 0) goto L12;
        L13:
            r0.d = r8;
            return r0;
        L12:
            r8 = false;
        L11:
            float r10 = r4;
            float r11 = r5;
            float r12 = r7;
            float r13 = r6;
            r0.setCornerRadii(new float[]{r10, r10, r11, r11, r12, r12, r13, r13});
            goto L12
        }
    }

    static {
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList r0 = this.a;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        if (r0.isStateful() == false) goto L6;
    L12:
        return true;
    L6:
        ColorStateList r1 = this.b;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNull(r1);
        if (r1.isStateful() == true) goto L12;
    L11:
        if (super.isStateful() == true) goto L12;
        return false;
    }

    public a() {
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "r");
        super.onBoundsChange(r2);
        if (this.d == false) goto L6;
        setCornerRadius(Math.min(r2.width(), r2.height()) / 2);
        return;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "stateSet");
        boolean r0 = super.onStateChange(r5);
        ColorStateList r1 = this.a;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        setColor(r1.getColorForState(r5, 0));
        r0 = true;
    L5:
        ColorStateList r2 = this.b;
        if (r2 == null) goto L9;
        Intrinsics.checkNotNull(r2);
        int r6 = r2.getColorForState(r5, 0);
        setStroke(this.c, r6);
        return true;
    L9:
        return r0;
    }
}
