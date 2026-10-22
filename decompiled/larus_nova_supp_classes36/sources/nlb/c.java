package nlb;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.LogSafetyTools;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static Bitmap.Config a(g r3) {
        ImageUtils.ImageType r0 = r3.g;
        if (r0 != null) goto L5;
    L10:
        Bitmap.Config r1 = Bitmap.Config.ARGB_8888;
    L11:
        Log.i("LargeImageHelper", "getBitmapConfig, path=" + LogSafetyTools.a(r3.a.getRealPath()) + ", bitmapConfig=" + r1);
        return r1;
    L5:
        if (r0 == ImageUtils.ImageType.TYPE_UNKNOWN) goto L10;
        if (ImageUtils.f(r0) == true) goto L10;
        r1 = null;
        goto L11
    }

    public static int f(View r4) {
        if (ImageWidgetFG.a() == false) goto L17;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        int r1 = DeviceUtils.getScreenHeight(LarkContext.getApplication());
        if (r0 == null) goto L9;
        int r2 = r0.height;
        if (r2 <= 0) goto L9;
        return r2;
    L9:
        int r5 = r4.getMeasuredHeight();
        if (r5 <= 0) goto L14;
        if (r5 <= r1) goto L13;
        Log.w("LargeImageHelper", "View measured height: " + r5 + ", larger than screen height: " + r1);
    L13:
        return r5;
    L14:
        Log.w("LargeImageHelper", "getViewHeight / Use screen height: " + r1);
        return r1;
    L17:
        return DeviceUtils.getScreenHeight(LarkContext.getApplication());
    }

    public static int g(View r4) {
        if (ImageWidgetFG.a() == false) goto L17;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        int r1 = DeviceUtils.getScreenWidth(LarkContext.getApplication());
        if (r0 == null) goto L9;
        int r2 = r0.width;
        if (r2 <= 0) goto L9;
        return r2;
    L9:
        int r5 = r4.getMeasuredWidth();
        if (r5 <= 0) goto L14;
        if (r5 <= r1) goto L13;
        Log.w("LargeImageHelper", "View measured width: " + r5 + ", larger than screen width: " + r1);
    L13:
        return r5;
    L14:
        Log.w("LargeImageHelper", "getViewWidth / Use screen width: " + r1);
        return r1;
    L17:
        return DeviceUtils.getScreenWidth(LarkContext.getApplication());
    }

    public static int[] e(SubsamplingScaleImageView r10, g r11) {
        if (ImageUtils.f(r11.g) == false) goto L20;
        int[] r0 = new int[2];
        int r4 = r11.e;
        int r12 = r11.f;
        if (h(r10, r4, r12) == false) goto L18;
        Pair r5 = new Pair(Integer.valueOf(r4), Integer.valueOf(r12));
        float r13 = Math.max(((Integer) r5.first).intValue(), ((Integer) r5.second).intValue());
        float r6 = Math.min(((Integer) r5.first).intValue(), ((Integer) r5.second).intValue());
        int r7 = g(r10) * 2;
        int r14 = f(r10) * 2;
        float r1 = Math.max(r7, r14);
        float r8 = Math.min(r7, r14);
        if ((r13 * r6) <= (r1 * r8)) goto L14;
        if (r1 <= 0.0f) goto L14;
        if (r8 <= 0.0f) goto L14;
        float r2 = Math.max(Math.max(r13 / r1, r6 / r8), 1.0f);
        r13 = r13 / r2;
        r6 = r6 / r2;
    L14:
        if (((Integer) r5.first).intValue() <= ((Integer) r5.second).intValue()) goto L16;
        Pair r3 = new Pair(Integer.valueOf((int) r13), Integer.valueOf((int) r6));
    L17:
        Log.i("LargeImageHelper", "scaleResolution, from " + r5 + ", to " + r3 + ", max " + new Pair(Integer.valueOf(r7), Integer.valueOf(r14)));
        r0[0] = ((Integer) r3.first).intValue();
        r0[1] = ((Integer) r3.second).intValue();
    L19:
        return r0;
    L16:
        r3 = new Pair(Integer.valueOf((int) r6), Integer.valueOf((int) r13));
        goto L17
    L18:
        r0[0] = r4;
        r0[1] = r12;
        goto L19
    L20:
        int[] r9 = new int[2];
        int r15 = r11.e;
        int r16 = r11.f;
        int r17 = g(r10);
        int r18 = f(r10);
        if (r16 >= r18) goto L24;
        if (r15 >= r17) goto L24;
        r9[0] = r15;
        r9[1] = r16;
    L28:
        int r19 = r9[0];
        if (r19 <= (r17 / 2)) goto L34;
        int r20 = r9[1];
        if (r20 <= (r18 / 4)) goto L34;
        r9[0] = r19 / 2;
        r9[1] = r20 / 2;
    L34:
        if (r9[0] > 0) goto L37;
        r9[0] = r17;
    L37:
        if (r9[1] > 0) goto L39;
        r9[1] = r18;
    L39:
        return r9;
    L24:
        float r21 = r15 / r16;
        float r110 = r18 * r21;
        float r22 = r17;
        if (r110 <= r22) goto L27;
        r9[0] = r17;
        r9[1] = (int) (r22 / r21);
        goto L28
    L27:
        r9[1] = r18;
        r9[0] = (int) r110;
        goto L28
    }

    public static boolean h(View r6, int r7, int r8) {
        if ((((long) r7) * ((long) r8)) <= ((((long) g(r6)) * 4) * ((long) f(r6)))) goto L5;
    L8:
        boolean r9 = true;
    L9:
        Log.i("LargeImageHelper", "isTooLargeImage:" + r9);
        return r9;
    L5:
        if (Math.max(r7, r8) >= 4096) goto L8;
        r9 = false;
        goto L9
    }

    public static void i(SubsamplingScaleImageView r4, g r5, Bitmap r6) {
        Uri r0 = Uri.fromFile(r5.a.toFile());
        if (r0 == null) goto L20;
        qlb.a r1 = new qlb.a(r0);
        int r2 = r5.e;
        int r3 = r5.f;
        r1.e = r2;
        r1.f = r3;
        Rect r7 = r1.g;
        if (r7 == null) goto L7;
        r1.d = true;
        r1.e = r7.width();
        r1.f = r1.g.height();
    L7:
        r1.d = h(r4, r5.e, r5.f);
        com.ss.android.lark.imagewidget.largeimage.transform.b r8 = r5.d;
        if (r8 == null) goto L12;
        Rect r9 = r8.a;
        if (r9 == null) goto L12;
        r1.g = r9;
        r1.d = true;
        r1.e = r9.width();
        r1.f = r1.g.height();
    L12:
        if (r6 == null) goto L17;
        qlb.a r10 = qlb.a.a(r6);
        if (ImageUtils.f(r5.g) == false) goto L16;
        Log.i("LargeImageHelper", "heif only show preview source");
        r4.setImage(r10);
        return;
    L16:
        r4.K(r1, r10);
        return;
    L17:
        r4.setImage(r1);
        return;
    L20:
        throw new NullPointerException("Uri must not be null");
    }

    public static float b(int r1, int r2, int r3, int r4) {
        float r0 = d(r1, r2, r3, r4);
        if (r3 < r1) goto L7;
        if (r4 < r2) goto L7;
        float r5 = 1.0f;
    L9:
        return r0 * Math.max(r5, 2.5f);
    L7:
        r5 = Math.max(r1 / r3, r2 / r4);
        goto L9
    }

    public static float c(int r3, int r4, int r5, int r6) {
        if (r3 == 0) goto L13;
        if (r4 == 0) goto L13;
        if (r5 < r3) goto L12;
        if (r6 < r4) goto L12;
        return Math.max(Math.max(r5 / r3, r6 / r4), b(r3, r4, r5, r6) * 2.0f);
    L12:
        return b(r3, r4, r5, r6) + 2.0f;
    L13:
        return 2.0f;
    }

    public static float d(int r2, int r3, int r4, int r5) {
        Log.i("LargeImageHelper", "getMinScale, newW:" + r2 + ",newH:" + r3 + ",bitmapW:" + r4 + ",bitmapH:" + r5);
        if (r2 <= 0) goto L13;
        if (r3 <= 0) goto L13;
        if (r4 <= 0) goto L13;
        if (r5 <= 0) goto L13;
        float r6 = (r2 * 1.0f) / r4;
        float r7 = (r3 * 1.0f) / r5;
        if ((r5 / r4) <= 3) goto L12;
        return Math.max(r6, r7);
    L12:
        return Math.min(r6, r7);
    L13:
        return 1.0f;
    }
}
