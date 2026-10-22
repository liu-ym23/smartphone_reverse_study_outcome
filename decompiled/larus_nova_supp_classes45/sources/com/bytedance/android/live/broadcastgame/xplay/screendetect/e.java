package com.bytedance.android.live.broadcastgame.xplay.screendetect;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final boolean a = false;
    public static final Bitmap.Config b = null;
    public static Bitmap c;
    public static Pair<int[], Triple<int[], int[], int[]>> d;
    public static Function1<? super String, Unit> e;
    public static final e f = null;

    public static final class a extends Handler {
        public a(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message r1, long r2) {
            Intrinsics.checkNotNullParameter(r1, "msg");
            r1.getCallback().run();
            return true;
        }
    }

    public e() {
    }

    static {
        f = new e();
        if (Build.VERSION.SDK_INT < 24) goto L5;
        boolean r0 = true;
    L6:
        a = r0;
        b = Bitmap.Config.RGB_565;
        new a(Looper.getMainLooper());
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void b(Triple r3) {
        int r1 = 0;
    L4:
        if (r1 >= 256) goto L6;
        ((int[]) r3.getFirst())[r1] = 0;
        ((int[]) r3.getSecond())[r1] = 0;
        ((int[]) r3.getThird())[r1] = 0;
        r1 = r1 + 1;
        goto L4
    }

    public static boolean d(SurfaceView r1) {
        if (r1 == null) goto L4;
        SurfaceHolder r0 = r1.getHolder();
    L5:
        if (r0 != null) goto L7;
    L15:
        return false;
    L7:
        if (r1.getHolder().getSurface() == null) goto L15;
        if (r1.getHolder().getSurface().isValid() == false) goto L15;
        if (r1.getWidth() <= 0) goto L15;
        if (r1.getHeight() <= 0) goto L15;
        return true;
    L4:
        r0 = null;
        goto L5
    }

    public static Pair a(Triple r8, int r9) {
        int[] r0 = (int[]) r8.component1();
        int[] r1 = (int[]) r8.component2();
        int[] r11 = (int[]) r8.component3();
        int r4 = 0;
        Triple r2 = new Triple(new b(0), new b(0), new b(0));
        b r3 = (b) r2.component1();
        b r5 = (b) r2.component2();
        b r6 = (b) r2.component3();
    L4:
        if (r4 >= 256) goto L15;
        int r7 = r3.b;
        int r12 = r0[r4];
        if (r7 >= r12) goto L8;
        r3.b = r12;
        r3.a = r4;
    L8:
        int r13 = r5.b;
        int r14 = r1[r4];
        if (r13 >= r14) goto L11;
        r5.b = r14;
        r5.a = r4;
    L11:
        int r15 = r6.b;
        int r16 = r11[r4];
        if (r15 >= r16) goto L14;
        r6.b = r16;
        r6.a = r4;
    L14:
        r4 = r4 + 1;
        goto L4
    L15:
        float r17 = r9;
        return new Pair(Float.valueOf((((r3.b / r17) + (r5.b / r17)) + (r6.b / r17)) / 3), Integer.toHexString(Color.rgb(r3.a, r5.a, r6.a)));
    }

    public static void c(Triple r3, int r4) {
        int[] r0 = (int[]) r3.getFirst();
        int r1 = Color.red(r4);
        r0[r1] = r0[r1] + 1;
        int[] r2 = (int[]) r3.getSecond();
        int r5 = Color.green(r4);
        r2[r5] = r2[r5] + 1;
        int[] r6 = (int[]) r3.getThird();
        int r7 = Color.blue(r4);
        r6[r7] = r6[r7] + 1;
    }
}
