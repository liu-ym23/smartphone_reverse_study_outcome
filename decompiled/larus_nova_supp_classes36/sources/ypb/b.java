package ypb;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vpb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(int r1) {
        if (r1 < 0) goto L6;
        if (r1 > 55295) goto L6;
    L9:
        return true;
    L6:
        if (r1 >= 57344) goto L8;
    L10:
        return false;
    L8:
        if (r1 > 1114111) goto L10;
        goto L9
    }

    public static Bitmap a(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
    L9:
        e = move-exception;
        Log.e("IconUtil", e);
        Bitmap r2 = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        Intrinsics.checkNotNull(r2);
        return r2;
    L4:
        if ((r5 instanceof BitmapDrawable) == true) goto L6;
        Application r0 = LarkContext.getApplication();     // Catch: Exception -> L9
        int r1 = d.h;     // Catch: Exception -> L9
        int r3 = UIUtils.dp2px(r0, 44.0f);     // Catch: Exception -> L9
        int r4 = UIUtils.dp2px(LarkContext.getApplication(), 44.0f);     // Catch: Exception -> L9
        Bitmap r6 = Bitmap.createBitmap(r3, r4, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L9
        Canvas r7 = new Canvas(r6);     // Catch: Exception -> L9
        r5.setBounds(0, 0, r3, r4);     // Catch: Exception -> L9
        r5.draw(r7);     // Catch: Exception -> L9
        return r6;
    L6:
        return ((BitmapDrawable) r5).getBitmap();
    }

    @JvmStatic
    public static final Bitmap c(Bitmap r7, int r8, int r9) {
        if (r7 != null) goto L5;
        return null;
    L5:
        int r3 = r7.getWidth();
        int r4 = r7.getHeight();
        Matrix r5 = new Matrix();
        r5.postScale(r8 / r3, r9 / r4);
        return Bitmap.createBitmap(r7, 0, 0, r3, r4, r5, false);
    }
}
