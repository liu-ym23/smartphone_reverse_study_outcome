package ufb;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.floating.widget.appfloat.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements wfb.b {
    public c() {
    }

    public static int c(View r3, h r4) {
        int r0 = xfb.d.a;
        Rect r1 = xfb.d.c(r3.getContext());
        int r5 = ((WindowManager.LayoutParams) r4.a).x;
        if (r5 >= (r1.right - (r3.getRight() + r5))) goto L6;
        return -r3.getRight();
    L6:
        return r1.right;
    }

    @Override // wfb.b
    public final ValueAnimator b(View r5, h r6, WindowManager r7) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "windowManager");
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{((WindowManager.LayoutParams) r6.a).x, c(r5, r6)});
        r0.addUpdateListener(new b(r6, r7, r5));
        return r0;
    }

    @Override // wfb.b
    public final ValueAnimator a(View r4, h r5, WindowManager r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "windowManager");
        int r0 = c(r4, r5);
        int r1 = ((WindowManager.LayoutParams) r5.a).x;
        if (r1 <= 0) goto L5;
        int r2 = r1 + r7;
    L6:
        ValueAnimator r8 = ValueAnimator.ofInt(new int[]{r0, r2});
        r8.setDuration(500);
        r8.addUpdateListener(new a(r5, r6, r4));
        return r8;
    L5:
        r2 = r1 - r7;
        goto L6
    }
}
