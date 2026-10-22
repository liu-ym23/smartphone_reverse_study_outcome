package com.ss.android.lark.picker.base.widget.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.a0;
import h18.e;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class FakePickerAvatarCreator {
    public static final int BLACK = -16777216;
    public static final int BLUE = -16776961;
    public static final int CYAN = -16711681;
    public static final int DKGRAY = -12303292;
    public static final int GRAY = -7829368;
    public static final int GREEN = -16711936;
    public static final int LTGRAY = -3355444;
    public static final int MAGENTA = -65281;
    public static final int RED = -65536;
    public static final int YELLOW = -256;
    private static Integer[] colorSet;

    public FakePickerAvatarCreator() {
    }

    static {
        colorSet = new Integer[]{Integer.valueOf(BLACK), Integer.valueOf(DKGRAY), Integer.valueOf(GRAY), Integer.valueOf(LTGRAY), Integer.valueOf(RED), Integer.valueOf(GREEN), Integer.valueOf(BLUE), Integer.valueOf(YELLOW), Integer.valueOf(CYAN), Integer.valueOf(MAGENTA)};
    }

    private static int getRandomColor() {
        return colorSet[new Random().nextInt(10)].intValue();
    }

    public static Bitmap createFakeAvatar(Context r0, String r1, String r2) {
        if (TextUtils.isEmpty(a0.a(r0, r1)) == false) goto L5;
        int r3 = UIUtils.dp2px(r0, 100.0f);
        return createNameAvatarBitmap(r3, r3, r2);
    L5:
        return null;
    }

    public static Bitmap createFakeAvatarForGroupChat(Context r0, String r1, String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L7;
        return null;
    L7:
        return createFakeAvatar(r0, r1, UIUtils.getString(r0, 2131891798));
    }

    public static Bitmap createNameAvatarBitmap(int r1, int r2, String r3) {
        return createNameAvatarBitmap(r1, r2, r3, getRandomColor());
    }

    public static Bitmap createNameAvatarBitmap(int r7, int r8, String r9, int r10) {
        Bitmap r0 = Bitmap.createBitmap(r7, r7, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        RectF r2 = new RectF(0.0f, 0.0f, r1.getWidth(), r1.getHeight());
        Paint r3 = new Paint(257);
        r3.setColor(-1);
        r1.drawOval(r2, r3);
        r3.setColor(r10);
        float r11 = r8;
        r1.drawRect(new RectF(r11, r11, r2.width() - r11, r2.height() - r11), r3);
        r3.setColor(-1);
        r3.setStrokeWidth(3.0f);
        r3.setTextSize(r7 * 0.5f);
        r3.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt r12 = r3.getFontMetricsInt();
        r1.drawText(r9, r2.centerX(), (((r2.bottom + r2.top) - r12.bottom) - r12.top) / 2.0f, r3);
        return r0;
    }

    public static Bitmap createNameAvatarBitmap(int r6, float r7, String r8, int r9, Context r10) {
        Bitmap r0 = Bitmap.createBitmap(r6, r6, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        RectF r2 = new RectF(0.0f, 0.0f, r1.getWidth(), r1.getHeight());
        Paint r3 = new Paint(257);
        r3.setTypeface(e.a(r10));
        r3.setColor(-1);
        r1.drawOval(r2, r3);
        r3.setColor(r9);
        float r11 = r6;
        r1.drawRect(new RectF(r11, r11, r2.width() - r11, r2.height() - r11), r3);
        r3.setColor(-1);
        r3.setStrokeWidth(3.0f);
        r3.setTextSize(r7);
        r3.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt r12 = r3.getFontMetricsInt();
        r1.drawText(r8, r2.centerX(), (((r2.bottom + r2.top) - r12.bottom) - r12.top) / 2.0f, r3);
        return r0;
    }

    public static Bitmap createFakeAvatarForChatter(Context r1, String r2, String r3, boolean r4, String r5, int r6) {
        if (TextUtils.isEmpty(r5) == true) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(a0.a(r1, r2 + ".jpg")) == false) goto L15;
        if (r4 == false) goto L13;
        int r7 = UIUtils.dp2px(r1, 0.0f);
        if (TextUtils.isEmpty(r3) == true) goto L16;
        r3 = r3.substring(r3.length() - 1);
    L16:
        return createNameAvatarBitmap(UIUtils.dp2px(r1, r6), r7, r3);
    L13:
        int r8 = UIUtils.dp2px(r1, 100.0f);
        return createNameAvatarBitmap(r8, r8, r3);
    L15:
        return null;
    }
}
