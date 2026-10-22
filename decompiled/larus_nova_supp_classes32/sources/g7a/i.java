package g7a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.core.LynxThreadPool;
import i8a.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static List<Integer> a(int r3, int r4) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        r0.add(0);
        if (r3 <= 0) goto L10;
        if (r4 <= 0) goto L10;
    L6:
        if (r1 >= r3) goto L10;
        r1 = Math.min(r1 + r4, r3);
        if (((Integer) ListProtector.get(r0, r0.size() - 1)).intValue() == r1) goto L6;
        r0.add(Integer.valueOf(r1));
    L10:
        return r0;
    }

    public static int[] c(int r16, int r17, float r18, Bitmap.Config r19, Callback r20) {
        double r4 = r18;
        long r2 = Math.max(1, Math.round(((double) r16) * r4));
        long r5 = Math.max(1, Math.round(((double) r17) * r4));
        if (r2 <= 2147483647L) goto L5;
    L25:
        r20.invoke(new Object[]{8, "screenshot size exceeds limit"});
        return null;
    L5:
        if (r5 > 2147483647L) goto L25;
        if (r2 <= (Long.MAX_VALUE / r5)) goto L11;
        r20.invoke(new Object[]{8, "screenshot memory size overflow"});
        return null;
    L11:
        long r12 = r2 * r5;
        if (r19 != Bitmap.Config.RGB_565) goto L14;
        int r0 = 2;
    L15:
        long r7 = r0;
        if (r12 <= (Long.MAX_VALUE / r7)) goto L20;
        r20.invoke(new Object[]{8, "screenshot memory size overflow"});
        return null;
    L20:
        if ((r12 * r7) <= 268435456) goto L24;
        r20.invoke(new Object[]{8, "screenshot memory exceeds limit"});
        return null;
    L24:
        return new int[]{(int) r2, (int) r5};
    L14:
        r0 = 4;
        goto L15
    }

    public static void d(View r24, int r25, int r26, LynxContext r27, ReadableMap r28, Callback r29, g r30) {
        if (r24 != null) goto L5;
    L60:
        r29.invoke(new Object[]{6, new JavaOnlyMap()});
        return;
    L5:
        if (r24.getWidth() <= 0) goto L60;
        if (r24.getHeight() <= 0) goto L60;
        String r6 = "jpeg";
        if (r28 == null) goto L14;
        r6 = r28.getString("format", "jpeg");
    L14:
        if ("png".equals(r6) == false) goto L16;
        Bitmap.Config r7 = Bitmap.Config.ARGB_8888;
        Bitmap.CompressFormat r8 = Bitmap.CompressFormat.PNG;
        String r9 = "data:image/png;base64,";
    L17:
        Bitmap.Config r14 = r7;
        Bitmap.CompressFormat r15 = r8;
        String r13 = r9;
        if (r28 != null) goto L20;
        float r10 = 1.0f;
    L22:
        if (Float.isNaN(r10) == false) goto L24;
    L58:
        r29.invoke(new Object[]{4, "scale must be greater than 0"});
        return;
    L24:
        if (Float.isInfinite(r10) == true) goto L58;
        if (r10 <= 0.0f) goto L58;
        int r12 = r24.getWidth();
        int r11 = r24.getHeight();
        int r16 = Math.max(r12, r25);
        int r17 = Math.max(r11, r26);
        int[] r18 = c(r16, r17, r10, r14, r29);
        if (r18 != null) goto L31;
        return;
    L31:
        int r19 = r18[0];
        int r20 = r18[1];
        int r4 = r30.getScrollX();
        int r3 = r30.getScrollY();
        String r110 = r13;
        if (r28 != null) goto L34;
    L36:
        boolean r0 = false;
    L37:
        i8a.h r5 = (i8a.h) n.c().a(i8a.h.class);
        Bitmap r111 = Bitmap.createBitmap(r19, r20, r14);     // Catch: Throwable -> L53
        Canvas r112 = new Canvas(r111);     // Catch: Throwable -> L51
        r112.scale(r10, r10);     // Catch: Throwable -> L51
        Iterator r113 = ((ArrayList) a(r17 - r11, r11)).iterator();     // Catch: Throwable -> L51
    L41:
        if (r113.hasNext() == false) goto L49;
        int r21 = ((Integer) r113.next()).intValue();     // Catch: Throwable -> L51
        Iterator r114 = ((ArrayList) a(r16 - r12, r12)).iterator();     // Catch: Throwable -> L51
    L44:
        if (r114.hasNext() == false) goto L41;
        int r22 = ((Integer) r114.next()).intValue();     // Catch: Throwable -> L51
        r30.scrollTo(r22, r21);     // Catch: Throwable -> L51
        Canvas r23 = r112;
        int r210 = r21;
        Canvas r211 = r112;
        boolean r115 = r0;
        int r212 = r16;
        i8a.h r116 = r5;
        int r213 = r12;
        boolean r214 = r0;
        i8a.h r215 = r5;
        Bitmap r1 = r111;
        String r31 = r110;
        b(r24, r23, r14, r27, r115, r116, r22, r210);     // Catch: Throwable -> L62
        r111 = r1;
        r110 = r31;
        r21 = r210;
        r112 = r211;
        r16 = r212;
        r12 = r213;
        r0 = r214;
        r5 = r215;
    L52:
        Bitmap r117 = r1;
    L54:
        if (r117 == null) goto L56;
        r117.recycle();
    L56:
        r30.scrollTo(r4, r3);
        r29.invoke(new Object[]{1, new JavaOnlyMap()});
        return;
    L49:
        r30.scrollTo(r4, r3);
        LynxThreadPool.b().execute(new h(r111, r15, r110, r29));
        return;
    L51:
        r1 = r111;
    L53:
        r117 = null;
        goto L54
    L34:
        if (r28.getBoolean("androidEnablePixelCopy", false) == false) goto L36;
        r0 = true;
        goto L37
    L20:
        r10 = (float) r28.getDouble("scale", 1.0d);
        goto L22
    L16:
        r7 = Bitmap.Config.RGB_565;
        r8 = Bitmap.CompressFormat.JPEG;
        r9 = "data:image/jpeg;base64,";
        goto L17
    }

    public static void b(View r1, Canvas r2, Bitmap.Config r3, LynxContext r4, boolean r5, i8a.h r6, int r7, int r8) {
        if (r6 == null) goto L8;
        Bitmap r9 = r6.c(r1, r3);
        if (r9 == null) goto L8;
        r2.drawBitmap(r9, r7, r8, null);
        r9.recycle();
        return;
    L8:
        if (r5 == false) goto L14;
        if (r4 == null) goto L14;
        if (r4.getUIBodyView() == null) goto L14;
        Bitmap r10 = Bitmap.createBitmap(r1.getWidth(), r1.getHeight(), r3);
        ((LynxUIRenderer) r4.getUIBodyView().getLynxUIRendererInternal()).d(r1, new Canvas(r10));
        r2.drawBitmap(r10, r7, r8, null);
        r10.recycle();
        return;
    L14:
        int r11 = r2.save();
        r2.translate(r7, r8);
        boolean r12 = r1.isDirty();
        r1.draw(r2);
        if (r12 == false) goto L17;
        r1.postInvalidate();
    L17:
        r2.restoreToCount(r11);
    }
}
