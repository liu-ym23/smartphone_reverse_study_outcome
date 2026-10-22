package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import com.bytedance.supervisor.token.Token;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.quality.BlankScreenConfig;
import com.ss.android.lark.officewebview.quality.PixelCopyCropRectConfig;
import com.ss.android.lark.officewebview.quality.WebViewOptimizeConfig;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.utils.ScreenUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public float a;
    public long b;
    public long c;
    public final boolean d;
    public final int e;
    public a f;

    public c() {
        this.a = 0.0f;
        this.b = 0;
        this.c = 0;
        this.d = false;
        this.e = 10;
        WebViewOptimizeConfig r1 = ixb.a.a;
        if (r1 == null) goto L5;
        BlankScreenConfig r2 = r1.getBlankScreen();
    L6:
        if (r2 == null) goto L9;
        this.d = r2.getEnableNearBlankPixelNormalize();
        this.e = Math.max(0, Math.min(ScreenUtils.MAX_SYSTEM_BRIGHTNESS, r2.getNearBlankPixelColorThreshold()));
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static Bitmap c(View r4) {
        if (r4.getWidth() != 0) goto L5;
        return null;
    L5:
        if (r4.getHeight() == 0) goto L16;
        int r0 = r4.getWidth();
        int r1 = r4.getHeight() - 0;
        if (r0 <= 0) goto L15;
        if (r1 <= 0) goto L17;
        Bitmap r2 = Bitmap.createBitmap(Math.max(1, r0 / 6), Math.max(1, r1 / 6), Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        r3.scale(0.16666667f, 0.16666667f);
        r3.translate(0.0f, 0);
        r4.draw(r3);
        return r2;
    L17:
        return null;
    L15:
        return null;
    L16:
        return null;
    }

    public final void d(Bitmap r18) {
        int r1 = r18.getWidth() * r18.getHeight();
        int[] r10 = new int[r1];
        r18.getPixels(r10, 0, r18.getWidth(), 0, 0, r18.getWidth(), r18.getHeight());
        int r2 = r18.getWidth();
        int r3 = r18.getHeight();
        if (r18.isRecycled() == true) goto L5;
        r18.recycle();
    L5:
        j.e("CML_TAG_BlankScreenManager", "isBlankV1 pixels length " + r1 + " , width = " + r2 + " , height = " + r3);
        SparseArray r4 = new SparseArray();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L7:
        if (r6 >= r2) goto L19;
        int r12 = 0;
    L9:
        if (r12 >= r3) goto L17;
        int r13 = r10[(r12 * r2) + r6];
        r7 = r7 + 1;
        int r14 = ((Integer) r4.get(r13, -1)).intValue();
        if (r14 >= 0) goto L13;
        int r15 = 1;
    L14:
        if (r15 <= r8) goto L16;
        r9 = r13;
        r8 = r15;
    L16:
        r4.put(r13, Integer.valueOf(r15));
        r12 = r12 + 1;
        goto L9
    L13:
        r15 = r14 + 1;
        goto L14
    L17:
        r6 = r6 + 1;
        goto L7
    L19:
        if (this.d == false) goto L38;
        if (r7 <= 0) goto L38;
        int r11 = 0;
        int r16 = 0;
    L22:
        if (r11 >= r2) goto L37;
        int r17 = 0;
    L24:
        if (r17 >= r3) goto L36;
        int r19 = r10[(r17 * r2) + r11];
        if (Math.abs(Color.red(r19) - Color.red(r9)) <= this.e) goto L28;
    L32:
        boolean r5 = false;
    L33:
        if (r5 == false) goto L35;
        r16 = r16 + 1;
    L35:
        r17 = r17 + 1;
        goto L24
    L28:
        if (Math.abs(Color.green(r19) - Color.green(r9)) > this.e) goto L32;
        if (Math.abs(Color.blue(r19) - Color.blue(r9)) > this.e) goto L32;
        r5 = true;
        goto L33
    L36:
        r11 = r11 + 1;
        goto L22
    L37:
        r8 = Math.max(r8, r16);
    L38:
        if (r7 != 0) goto L40;
        float r20 = 1.0f;
    L41:
        this.a = r20;
        StringBuilder r21 = new StringBuilder("blank pixels percent = ");
        r21.append(r20);
        r21.append(", enableNearBlankPixelNormalize = ");
        r21.append(this.d);
        r21.append(", nearBlankPixelColorThreshold = ");
        r21.append(this.e);
        r21.append(", bucketSize = ");
        r21.append(r4.size());
        r21.append(", dominantBucketCount = ");
        r21.append(r8);
        r21.append(", dominantPixelRgb = ");
        r21.append("(" + Color.red(r9) + "," + Color.green(r9) + "," + Color.blue(r9) + ")");
        j.e("CML_TAG_BlankScreenManager", r21.toString());
        return;
    L40:
        r20 = r8 / r7;
        goto L41
    }

    public final void f(String r3) {
        j.b("CML_TAG_BlankScreenManager", "blank check error: " + r3);
        a r0 = this.f;
        if (r0 == null) goto L6;
        r0.b(r3);
        return;
    }

    public static Rect b(View r9, Window r10) {
        int[] r0 = new int[2];
        r9.getLocationInWindow(r0);
        int r3 = r0[0];
        Rect r1 = new Rect(r3, r0[1], r9.getWidth() + r3, r0[1] + r9.getHeight());
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L7:
        Rect r5 = new Rect();
        if (r11 == null) goto L11;
        r11.getWindowVisibleDisplayFrame(r5);
    L11:
        if (r5.width() > 0) goto L13;
    L17:
        j.e("CML_TAG_BlankScreenManager", "pixel copy src rect by webview bounds, rect=" + r1 + ", webViewSize=" + r9.getWidth() + "x" + r9.getHeight() + ", locationInWindow=[" + r0[0] + "," + r0[1] + "], windowVisibleRect=" + r5);
        return r1;
    L13:
        if (r5.height() <= 0) goto L17;
        if (r1.intersect(r5) == true) goto L17;
        r1.setEmpty();
        goto L17
    }

    public static void a(View r7, Rect r8, PixelCopyCropRectConfig r9, String r10) {
        if (r9 != null) goto L6;
        j.e("CML_TAG_BlankScreenManager", "pixel copy crop rect empty, bizName=" + r10 + ", rect=" + r8.width() + "x" + r8.height());
        return;
    L6:
        Resources r11 = r7.getResources();
        float r12 = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density;
        int r2 = Math.round(r9.getLeftDp() * r12);
        int r3 = Math.round(r9.getTopDp() * r12);
        int r4 = Math.round(r9.getRightDp() * r12);
        int r13 = Math.round(r9.getBottomDp() * r12);
        r8.left += r2;
        r8.top += r3;
        r8.right -= r4;
        r8.bottom -= r13;
        j.e("CML_TAG_BlankScreenManager", "pixel copy crop rect, bizName=" + r10 + ", cropDp=[" + r9.getLeftDp() + "," + r9.getTopDp() + "," + r9.getRightDp() + "," + r9.getBottomDp() + "], cropPx=[" + r2 + "," + r3 + "," + r4 + "," + r13 + "], rect=" + r8.width() + "x" + r8.height());
    }

    public final void e(View r9, Window r10, PixelCopyCropRectConfig r11, String r12) {
        final long r3 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 26) goto L38;
        f("pixel copy unsupported api");
        return;
    L38:
    L35:
        th = move-exception;
        j.b("CML_TAG_BlankScreenManager", "checkBlankScreenByPixelCopy error. " + th.getMessage());
        f(th.getMessage());
        return;
    L7:
        if (r9.isAttachedToWindow() == true) goto L9;
    L33:
        f("invalid webview for pixel copy");     // Catch: Throwable -> L35
        return;
    L9:
        if (r9.isShown() == false) goto L33;
        if (r9.getWidth() <= 0) goto L33;
        if (r9.getHeight() <= 0) goto L33;
        if (r10 != null) goto L18;
        f("window is null for pixel copy");     // Catch: Throwable -> L35
        return;
    L18:
        final Rect r6 = b(r9, r10);     // Catch: Throwable -> L35
        if (r6.width() > 0) goto L21;
    L31:
        f("src rect is invalid for pixel copy");     // Catch: Throwable -> L35
        return;
    L21:
        if (r6.height() <= 0) goto L31;
        a(r9, r6, r11, r12);     // Catch: Throwable -> L35
        if (r6.width() > 0) goto L26;
    L29:
        f("pixel copy crop rect is invalid");     // Catch: Throwable -> L35
        return;
    L26:
        if (r6.height() <= 0) goto L29;
        final Bitmap r13 = Bitmap.createBitmap(Math.max(1, r6.width() / 6), Math.max(1, r6.height() / 6), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L35
        wf7.b.a.e(r10, r6, r13, new b(this, r13, r3, r6), new Handler(Looper.getMainLooper()), new Token("LARK-PSDA-chameleon-blank-check"));     // Catch: Throwable -> L35
    }
}
