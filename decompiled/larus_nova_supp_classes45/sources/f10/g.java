package f10;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(View r6, int r7) {
        if (r6 != null) goto L5;
        return false;
    L5:
        if (r6.getVisibility() == 0) goto L7;
        return false;
    L7:
        if (r6.isShown() == true) goto L9;
        return false;
    L9:
        if (r6.getGlobalVisibleRect(new Rect()) == false) goto L36;
        Rect r1 = new Rect();
        boolean r2 = r6.getGlobalVisibleRect(r1);
        if (r7 == 1) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r7 == 0) goto L19;
    L21:
        boolean r8 = false;
    L22:
        if (r4 == true) goto L26;
        if (r8 == true) goto L26;
        boolean r9 = false;
    L27:
        if (r2 == false) goto L34;
        if (r9 == false) goto L35;
        return true;
    L35:
        return false;
    L34:
        return false;
    L26:
        r9 = true;
        goto L27
    L19:
        if (r1.width() <= (r6.getMeasuredWidth() / 2)) goto L21;
        r8 = true;
        goto L22
    L14:
        if (r1.height() <= (r6.getMeasuredHeight() / 2)) goto L16;
        r4 = true;
        goto L17
    L36:
        return false;
    }
}
