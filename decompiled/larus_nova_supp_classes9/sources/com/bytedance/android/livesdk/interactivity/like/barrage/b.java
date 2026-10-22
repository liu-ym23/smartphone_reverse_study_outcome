package com.bytedance.android.livesdk.interactivity.like.barrage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.os.Message;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.live.IBarrageLauncher;
import com.bytedance.common.utility.Logger;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import com.ss.ugc.live.barrage.view.BarrageLayout;
import java.util.Arrays;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements IBarrageLauncher, WeakHandler.IHandler {
    public final TypedArray a;
    public final Bitmap[] b;
    public final Random c;
    public DiggController d;
    public final WeakHandler e;
    public final Context f;
    public final ViewGroup g;

    public static final class a {
    }

    static {
    }

    public final void start() {
        int r0 = this.c.nextInt(6) + 5;
        long[] r1 = new long[r0];
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L6;
        long r3 = this.c.nextInt((int) 3000);
        r1[r2] = r3;
        this.e.sendEmptyMessageDelayed(13, r3);
        r2 = r2 + 1;
        goto L4
    L6:
        this.e.sendEmptyMessageDelayed(12, 3000);
        Logger.d("BarrageLauncher", "Barrage count: " + r0 + ", at times: " + Arrays.toString(r1));
    }

    public final void stop() {
        this.e.removeMessages(12);
        this.e.removeMessages(13);
    }

    public final void release() {
        stop();
        Bitmap[] r0 = this.b;
        if (r0 == null) goto L12;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L12;
        Bitmap r3 = r0[r2];
        if (r3 == null) goto L11;
        if (r3.isRecycled() == true) goto L11;
        r3.recycle();
    L11:
        r2 = r2 + 1;
    L12:
        DiggController r4 = this.d;
        if (r4 == null) goto L15;
        r4.m();
    L15:
        TypedArray r5 = this.a;
        if (r5 == null) goto L23;
        r5.recycle();
        return;
    }

    public final void handleMsg(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        int r8 = r7.what;
        if (r8 != 12) goto L5;
        start();
        return;
    L5:
        if (r8 == 13) goto L49;
        return;
    L49:
        TypedArray r1 = this.a;     // Catch: Throwable -> L12
        if (r1 == null) goto L11;
        r1.length();     // Catch: Throwable -> L12
    L11:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L19;
        TypedArray r3 = this.a;
        if (r3 == null) goto L17;
        int r4 = r3.length();
    L18:
        if (r4 > 0) goto L19;
        return;
    L17:
        r4 = 0;
    L19:
        DiggController r5 = this.d;
        if (r5 == null) goto L22;
        int r6 = r5.r();
    L23:
        if (r6 >= 24) goto L58;
        Bitmap[] r9 = this.b;
        if (r9 == null) goto L52;
        int r10 = this.c.nextInt(r9.length);
        Bitmap r11 = r9[r10];
        Bitmap r13 = null;
        if (r11 != null) goto L30;
    L31:
        TypedArray r14 = this.a;
        if (r14 == null) goto L38;
        Context r15 = this.f;
        if (r15 == null) goto L36;
        Resources r16 = r15.getResources();
    L37:
        r9[r10] = BitmapFactory.decodeResource(r16, r14.getResourceId(r10, 0));
        goto L38
    L36:
        r16 = null;
    L38:
        Bitmap r17 = r9[r10];
        if (r17 != null) goto L41;
        return;
    L41:
        if ((true ^ r17.isRecycled()) == false) goto L43;
        r13 = r17;
    L43:
        if (r13 == null) goto L54;
        DiggController r18 = this.d;
        if (r18 == null) goto L55;
        this.c.nextDouble();
        r18.a(new com.bytedance.android.livesdk.interactivity.like.barrage.a(r13), false);
        return;
    L55:
        return;
    L54:
        return;
    L30:
        if (r11.isRecycled() == false) goto L38;
    L52:
        return;
    L58:
        return;
    L22:
        r6 = 24;
    L12:
        r2 = true;
        goto L13
    }

    public b(Context r6, ViewGroup r7) {
        this.f = r6;
        this.g = r7;
        this.c = new Random();
        this.e = new WeakHandler(this);
        Resources r0 = s1.getResources();
        if (r0 == null) goto L5;
        TypedArray r1 = r0.obtainTypedArray(2130903116);
    L6:
        this.a = r1;
        if (r1 == null) goto L9;
        this.b = new Bitmap[r1.length()];
    L9:
        if (r6 == null) goto L22;
        if (r7 == null) goto L26;
        int r3 = 0;
        BarrageLayout r2 = new BarrageLayout(r6, null, 6, 0);
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r7.addView(r2);
        DiggController r8 = new DiggController(r2, 1400);
        this.d = r8;
        r2.a(r8);
    L14:
        if (r3 >= 10) goto L27;
        Path r9 = new Path();
        float r4 = 220;
        r9.moveTo(s1.f(50), s1.f(r4));
        float r10 = ((r3 - 5) * 6) + 50;
        r9.quadTo(s1.f(r10), s1.f(r4), s1.f(r10), s1.f(40));
        DiggController r11 = this.d;
        if (r11 == null) goto L21;
        Intrinsics.checkNotNullParameter(r9, "path");
        d r5 = new d(r11.t, r9, r11.n);
        if (r11.s.booleanValue() == false) goto L20;
        ((AbsBarrageController) r5).h = true;
    L20:
        ((AbsBarrageController) r5).g = ((Boolean) h21.d.getValue()).booleanValue();
        r11.o.add(r5);
        r11.t.a(r5);
    L21:
        r3 = r3 + 1;
        goto L14
    L27:
        return;
    L26:
        return;
    L22:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
