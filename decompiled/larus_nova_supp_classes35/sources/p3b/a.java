package p3b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends v4b.a {
    public static final /* synthetic */ int W = 0;

    public static int b(boolean r0) {
        if (r0 == false) goto L5;
        return v4b.a.a;
    L5:
        return v4b.a.z;
    }

    public static Drawable c(Context r3, boolean r4) {
        if (r4 == false) goto L4;
        int r0 = 2131247394;
    L5:
        GradientDrawable r5 = (GradientDrawable) UIUtils.getDrawable(r3, r0);
        int[] r1 = new int[2];
        if (r4 == false) goto L8;
        int r2 = v4b.a.c;
    L9:
        r1[0] = r2;
        if (r4 == false) goto L12;
        int r6 = v4b.a.b;
    L13:
        r1[1] = r6;
        r5.setColors(r1);
        return r5;
    L12:
        r6 = v4b.a.A;
        goto L13
    L8:
        r2 = v4b.a.B;
        goto L9
    L4:
        r0 = 2131247395;
        goto L5
    }
}
