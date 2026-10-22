package r60;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static boolean c(View r4) {
        if (r4.getAlpha() >= 1.0f) goto L5;
        return true;
    L5:
        Drawable r5 = r4.getBackground();
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.getOpacity() != (-2)) goto L11;
        return true;
    L11:
        if (r5.getOpacity() != (-3)) goto L13;
        return true;
    L13:
        if (r5.getAlpha() < 255) goto L19;
        return false;
    L19:
        return true;
    }

    public static boolean a(View r6, Rect r7) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        int[] r2 = new int[2];     // Catch: Throwable -> L14
        r6.getLocationOnScreen(r2);     // Catch: Throwable -> L14
        int r3 = r2[0];     // Catch: Throwable -> L14
        int r4 = r2[1];     // Catch: Throwable -> L14
        int r5 = r6.getWidth() + r3;     // Catch: Throwable -> L14
        int r8 = r6.getHeight() + r4;     // Catch: Throwable -> L14
        if (r3 <= r7.left) goto L6;
    L12:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        return false;
    L6:
        if (r5 < r7.right) goto L12;
        if (r4 > r7.top) goto L12;
        if (r8 < r7.bottom) goto L12;
        return true;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static boolean d(View r6, Rect r7) {
        if ((r6 instanceof ViewGroup) == false) goto L33;
        LinkedList r0 = new LinkedList();
        r0.add(r6);
    L6:
        if (r0.isEmpty() == true) goto L33;
        ViewGroup r8 = (ViewGroup) r0.removeFirst();
        if (r8.getChildCount() == 0) goto L9;
        int r2 = r8.getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L17;
        View r4 = r8.getChildAt(r3);
        if ((r4 instanceof ViewGroup) == false) goto L15;
        r0.add(r4);
    L15:
        r3 = r3 + 1;
        goto L11
    L17:
        if (a(r8, r7) == false) goto L6;
        if (r8.getAlpha() >= 1.0f) goto L21;
    L30:
        boolean r9 = true;
    L31:
        if (r9 == true) goto L6;
        return true;
    L21:
        if (r8.getBackground() == null) goto L30;
        if (r8.getBackground().getOpacity() == (-2)) goto L30;
        if (r8.getBackground().getOpacity() == (-3)) goto L30;
        if (r8.getBackground().getAlpha() < 255) goto L30;
        r9 = false;
        goto L31
    L9:
        return false;
    L33:
        return false;
    }

    public static boolean b(View r2, View r3, View r4) {
        if (r2 != null) goto L28;
    L27:
        return false;
    L28:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L25
        Rect r5 = new Rect();     // Catch: Throwable -> L25
        r2.getWindowVisibleDisplayFrame(r5);     // Catch: Throwable -> L25
        if (r5.isEmpty() == false) goto L8;
        return false;
    L8:
        if (a(r3, r5) == false) goto L13;
        if (c(r3) == true) goto L13;
    L31:
        return true;
    L13:
        if (a(r3, r5) == true) goto L16;
        return false;
    L16:
        if (a(r4, r5) == false) goto L21;
        if (c(r4) == false) goto L31;
    L21:
        if (a(r4, r5) == false) goto L32;
        return d(r4, r5);
    L32:
        return false;
    L25:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
