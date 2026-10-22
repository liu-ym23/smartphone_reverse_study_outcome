package ep;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.util.Log;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RotateDrawable f16851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f16852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f16853c;
    public int d;

    public a(RotateDrawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        this.f16851a = r5;
        this.f16852b = new int[2];
        this.f16853c = new int[2];
    }

    public final boolean a() {
        RotateDrawable r5 = this.f16851a;
        Drawable.Callback r10 = r5.getCallback();
        if (r10 != null) goto L6;
    L4:
        r10 = null;
    L7:
        View r11 = (View) r10;
        if (r11 != null) goto L10;
    L39:
        Log.w("DynamicDrawableRefreshLogic", "needRefresh: callbackView is null or not attached to window");
        return false;
    L10:
        if (r11.isAttachedToWindow() == false) goto L39;
        int[] r12 = this.f16852b;
        r11.getLocationInWindow(r12);
        int r13 = r12[0];
        int r14 = r12[1];
        int[] r15 = this.f16853c;
        if (r13 == r15[0]) goto L15;
    L37:
        r15[0] = r13;
        r15[1] = r14;
        this.d = 0;
        Log.d("DynamicDrawableRefreshLogic", "needRefresh: location changed");
        return true;
    L15:
        if (r14 != r15[1]) goto L37;
        Drawable.Callback r16 = r5.getCallback();
        if ((r16 instanceof View) == false) goto L33;
        View r17 = (View) r16;
        if (r17.isAttachedToWindow() == false) goto L33;
        int r18 = r17.getResources().getDisplayMetrics().widthPixels;
        int r19 = r17.getResources().getDisplayMetrics().heightPixels;
        int r20 = r12[0];
        int r21 = r12[1];
        if (r20 < 0) goto L27;
        if (r20 > r18) goto L27;
        if (r21 < 0) goto L27;
        if (r21 > r19) goto L27;
        boolean r22 = true;
    L28:
        boolean r23 = r17.hasWindowFocus();
        if (r22 == false) goto L33;
        if (r23 == false) goto L33;
        this.d = 0;
        return true;
    L27:
        r22 = false;
    L33:
        int r24 = this.d + 1;
        this.d = r24;
        if (r24 < 3) goto L36;
        return false;
    L36:
        return true;
    L6:
        if ((r10 instanceof View) == false) goto L4;
        goto L4
    }
}
