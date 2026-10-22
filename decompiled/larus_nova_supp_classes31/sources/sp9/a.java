package sp9;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tp9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final Matrix a(Rect r6, int r7, int r8, Rect r9, pp9.b r10) {
        Intrinsics.checkNotNullParameter(r6, "fromRect");
        Intrinsics.checkNotNullParameter(r10, "listItemScaleType");
        boolean r0 = false;
        if (r9 == null) goto L5;
        int r1 = r9.width();
    L6:
        if (r9 == null) goto L8;
        int r11 = r9.height();
    L9:
        boolean r2 = true;
        if (r7 == 0) goto L14;
        if (r8 == 0) goto L14;
        boolean r3 = false;
    L15:
        if (r1 == 0) goto L19;
        if (r11 == 0) goto L19;
        boolean r4 = false;
    L20:
        if (r3 == true) goto L27;
        if (r4 == true) goto L27;
        if ((r11 / r1) < (r8 / r7)) goto L26;
        r0 = true;
    L26:
        r2 = r0;
    L27:
        if (r2 == false) goto L29;
        float r5 = r8;
        float r12 = r11;
    L30:
        float r13 = r5 / r12;
        RectF r14 = new RectF(0.0f, 0.0f, r1, r11);
        Matrix r15 = new Matrix();
        r15.setScale(r13, r13, r1 / 2, r11 / 2);
        r15.postTranslate((r7 - r1) / 2, (r8 - r11) / 2);
        r15.mapRect(r14, r14);
        return r10.a(r14, r6);
    L29:
        r5 = r7;
        r12 = r1;
    L19:
        r4 = true;
    L14:
        r3 = true;
        goto L15
    L8:
        r11 = 0;
        goto L9
    L5:
        r1 = 0;
        goto L6
    }

    public static final AnimatorSet b(Matrix r8, Matrix r9, Rect r10, qp9.a r11, Function1<? super Matrix, Unit> r12) {
        Intrinsics.checkNotNullParameter(r8, "startMatrix");
        Intrinsics.checkNotNullParameter(r9, "endMatrix");
        Intrinsics.checkNotNullParameter(r11, "animationConfiguration");
        Intrinsics.checkNotNullParameter(r12, "callback");
        float[] r1 = new float[9];
        r8.getValues(r1);
        float[] r2 = new float[9];
        r9.getValues(r2);
        tp9.c r3 = new tp9.c(r10, r1, r12);
        ObjectAnimator r13 = ObjectAnimator.ofPropertyValuesHolder(r3, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(tp9.b.a, new tp9.a(new float[9]), new float[][]{r1, r2})});
        r13.setDuration(r11.f);
        r13.setInterpolator(r11.b);
        qp9.a.C0070a r4 = r11.i;
        if (r10 == null) goto L5;
        RectF r7 = new RectF(r10);
    L6:
        RectF r5 = new RectF(r7);
        RectF r14 = new RectF();
        RectF r15 = new RectF();
        r8.mapRect(r14, r5);
        r9.mapRect(r15, r5);
        float r16 = r14.centerX();
        float r17 = r14.centerY();
        float r18 = r15.centerX();
        float r6 = r15.centerY();
        r4.getClass();
        Path r19 = new Path();
        r19.moveTo(r16, r17);
        r19.lineTo(r18, r6);
        int r20 = d.a;
        ObjectAnimator r21 = ObjectAnimator.ofPropertyValuesHolder(r3, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(tp9.b.b, null, r19)});
        r21.setDuration(r11.e);
        r21.setInterpolator(r11.a);
        AnimatorSet r22 = new AnimatorSet();
        r22.playTogether(new Animator[]{r13, r21});
        return r22;
    L5:
        r7 = null;
        goto L6
    }
}
