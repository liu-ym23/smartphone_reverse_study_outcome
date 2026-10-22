package com.ss.android.lark.forseti.util.dragging;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import androidx.window.layout.WindowMetricsCalculator;
import cib.f;
import cib.g;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiColumnsDraggingHelper {
    public float A;
    public final Paint B;
    public final Paint C;
    public final Paint D;
    public final Paint E;
    public final Paint F;
    public final Paint G;
    public final Context a;
    public final Lazy b;
    public final Lazy c;
    public boolean d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public float y;
    public float z;

    public static final class a {
    }

    public static final class b {
        public final float a;
        public final float b;
        public final float c;
        public final float d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Float.compare(this.a, r6.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
        }

        public final String toString() {
            return "Region(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ')';
        }

        public b(float r1, float r2, float r3, float r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ForsetiWidth.values().length];
            r0[ForsetiWidth.FULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[ForsetiWidth.AVERAGE_LEVEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_LEFT_SIDE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_LEFT_SIDE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    static {
    }

    public static boolean h(float r1) {
        if (r1 > 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final ForsetiWidth d() {
        int r0 = f.a(this.a, 750.0f);
        Rect r1 = WindowMetricsCalculator.Companion.getOrCreate().computeCurrentWindowMetrics(ContextsKt.requireActivity(this.a)).getBounds();
        float r2 = r1.width();
        if (r1.width() <= r0) goto L12;
        if (r2 > this.e) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L14;
        return ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE;
    L14:
        return ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE;
    L7:
        r3 = false;
        goto L8
    L12:
        return ForsetiWidth.AVERAGE_LEVEL;
    }

    public final boolean e() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    public final Context getContext() {
        return this.a;
    }

    public ForsetiColumnsDraggingHelper(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        this.a = r7;
        this.b = LazyKt.lazy(ForsetiColumnsDraggingHelper$optimizeDraggingViewDisabled$2.INSTANCE);
        this.c = LazyKt.lazy(ForsetiColumnsDraggingHelper$optimizeDraggingViewUnderKeyboardDisabled$2.INSTANCE);
        this.e = f.a(r7, 1194.0f);
        this.f = f.a(r7, 318.0f);
        this.g = f.a(r7, 376.0f);
        this.h = f.a(r7, 100.0f);
        this.i = f.a(r7, 24.0f);
        this.j = f.a(r7, 32.0f);
        int r1 = f.a(r7, 0.5f);
        this.k = r1;
        this.l = f.a(r7, 48.0f);
        this.m = f.a(r7, 12.0f);
        this.n = f.a(r7, 8.0f);
        this.o = f.a(r7, 16.0f);
        this.p = f.a(r7, 28.0f);
        this.q = f.a(r7, 2.0f);
        this.r = f.a(r7, 2.0f);
        this.s = f.a(r7, 32.0f);
        this.t = f.a(r7, 12.0f);
        this.u = f.a(r7, 48.0f);
        this.v = f.a(r7, 502.0f);
        this.w = 2131108718;
        this.x = 2131108721;
        Paint r2 = new Paint();
        r2.setColor(f.b(r7, 2131108718));
        float r3 = r1;
        r2.setStrokeWidth(r3);
        this.B = r2;
        Paint r4 = new Paint();
        r4.setStyle(Paint.Style.FILL);
        r4.setColor(f.b(r7, 2131108718));
        r4.setAntiAlias(true);
        this.C = r4;
        Paint r5 = new Paint();
        r5.setColor(f.b(r7, 2131108718));
        r5.setStrokeWidth(r3);
        this.D = r5;
        Paint r0 = new Paint();
        r0.setColor(f.b(r7, 2131106627));
        this.E = r0;
        Paint r6 = new Paint();
        r6.setStyle(Paint.Style.FILL);
        r6.setColor(f.b(r7, 2131105444));
        r6.setAntiAlias(true);
        this.F = r6;
        Paint r8 = new Paint();
        r8.setColor(f.b(r7, 2131102487));
        this.G = r8;
    }

    public static ForsetiWidth c(ForsetiWidth r2) {
        if (r2 != null) goto L5;
        int r3 = -1;
    L6:
        if (r3 == (-1)) goto L18;
        if (r3 == 4) goto L18;
        switch(r3) {
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            default: goto L10;
        };
    L10:
        d.a.getClass();
        ForsetiWidth r4 = d.c;
        if (r4 == null) goto L20;
        return r4;
    L20:
        return ForsetiWidth.AVERAGE_LEVEL;
    L21:
        return ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE;
    L22:
        return ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE;
    L23:
        return ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE;
    L24:
        return ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE;
    L18:
        return ForsetiWidth.AVERAGE_LEVEL;
    L5:
        r3 = c.a[r2.ordinal()];
        goto L6
    }

    public final ForsetiWidth a(ForsetiWidth r3) {
        if (r3 != null) goto L5;
        int r4 = -1;
    L6:
        if (r4 == (-1)) goto L26;
        if (r4 == 2) goto L33;
        if (r4 == 3) goto L32;
        if (r4 == 4) goto L31;
        if (r4 == 5) goto L30;
        if (r4 == 6) goto L29;
        d.a.getClass();
        ForsetiWidth r5 = d.b;
        if (r5 == null) goto L28;
        return r5;
    L28:
        return d();
    L29:
        return ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_LEFT_SIDE;
    L30:
        return ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_LEFT_SIDE;
    L31:
        return ForsetiWidth.AVERAGE_LEVEL;
    L32:
        return ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_LEFT_SIDE;
    L33:
        return ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_LEFT_SIDE;
    L26:
        return d();
    L5:
        r4 = c.a[r3.ordinal()];
        goto L6
    }

    public final ForsetiWidth b(float r8) {
        if (r8 > this.e) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        int r1 = this.f;
    L9:
        float r2 = r1;
        float r3 = r2 / 2.0f;
        float r4 = this.A;
        float r5 = r4 / 2.0f;
        float r6 = ((r5 - r2) / 2.0f) + r2;
        float r7 = (((r4 - r2) - r5) / 2.0f) + r5;
        if (r8 >= r3) goto L13;
        return ForsetiWidth.FULL;
    L13:
        if (r8 >= r6) goto L18;
        if (r0 == false) goto L26;
        return ForsetiWidth.FIXED_LEVEL1_IN_NARROW_SCREEN_RIGHT_SIDE;
    L26:
        return ForsetiWidth.FIXED_LEVEL1_IN_WIDE_SCREEN_RIGHT_SIDE;
    L18:
        if (r8 < r7) goto L27;
        if (r0 == false) goto L23;
        return ForsetiWidth.FIXED_LEVEL2_IN_NARROW_SCREEN_RIGHT_SIDE;
    L23:
        return ForsetiWidth.FIXED_LEVEL2_IN_WIDE_SCREEN_RIGHT_SIDE;
    L27:
        return ForsetiWidth.AVERAGE_LEVEL;
    L8:
        r1 = this.g;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final float j(ForsetiWidth r2) {
        if (r2 != null) goto L4;
        int r3 = -1;
    L6:
        switch(r3) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L17;
        };
    L8:
        float r4 = this.A;
        int r0 = this.g;
    L18:
        return r4 - r0;
    L9:
        r4 = this.A;
        r0 = this.f;
        goto L18
    L11:
        float r5 = this.A;
    L19:
        return r5 / 2.0f;
    L13:
        int r6 = this.g;
    L20:
        return r6;
    L14:
        r6 = this.f;
        goto L20
    L16:
        return 0.0f;
    L17:
        r5 = this.A;
        goto L19
    L4:
        r3 = c.a[r2.ordinal()];
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(View r8, boolean r9) {
        if (r8 != null) goto L6;
        Log.w("ForsetiColumnsDraggingHelper", "renderView is null, cannot apply blur effect.");
        return;
    L6:
        int r1 = Build.VERSION.SDK_INT;
        RenderScript r3 = 0;
        RenderEffect r4 = null;
        Bitmap r5 = null;
        r5 = null;
        if (r1 < 31) goto L13;
        Log.d("ForsetiColumnsDraggingHelper", "Applying blur effect using RenderEffect.");
        if (r9 == false) goto L11;
        r4 = RenderEffect.createBlurEffect(50.0f, 50.0f, Shader.TileMode.CLAMP);
    L11:
        r8.setRenderEffect(r4);
        return;
    L13:
        if (r1 < 23) goto L57;
        Log.d("ForsetiColumnsDraggingHelper", "Applying blur effect using RenderScript for pre Android 12 devices.");
        int r0 = g.a;
        Intrinsics.checkNotNullParameter(r8, "renderView");
        if (r9 == true) goto L52;
        Log.d("ViewBlurUtil", "Removing RenderScript blur effect.");
        r8.setForeground(null);
        return;
    L52:
        Bitmap r10 = Bitmap.createBitmap(r8.getWidth(), r8.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L19
        r8.draw(new Canvas(r10));     // Catch: Exception -> L19
    L21:
        if (r10 != null) goto L23;
        Log.w("ViewBlurUtil", "Failed to convert view to bitmap for RenderScript blur.");
        return;
    L23:
        Context r2 = r8.getContext();
        RenderScript r6 = RenderScript.create(r2);     // Catch: Throwable -> L37 Exception -> L39
        Allocation r7 = Allocation.createFromBitmap(r6, r10);     // Catch: Throwable -> L33 Exception -> L35
        Allocation r11 = Allocation.createTyped(r6, r7.getType());     // Catch: Throwable -> L33 Exception -> L35
        ScriptIntrinsicBlur r12 = ScriptIntrinsicBlur.create(r6, Element.U8_4(r6));     // Catch: Throwable -> L33 Exception -> L35
        r12.setRadius(25.0f);     // Catch: Throwable -> L33 Exception -> L35
        r12.setInput(r7);     // Catch: Throwable -> L33 Exception -> L35
        r12.forEach(r11);     // Catch: Throwable -> L33 Exception -> L35
        Bitmap.Config r13 = r10.getConfig();     // Catch: Throwable -> L33 Exception -> L35
        if (r13 == null) goto L28;
        Bitmap r14 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), r13);     // Catch: Throwable -> L33 Exception -> L35
    L29:
        r11.copyTo(r14);     // Catch: Throwable -> L33 Exception -> L35
        if (r6 == null) goto L32;
        r6.destroy();
    L32:
        r5 = r14;
    L44:
        if (r5 == null) goto L46;
        r8.setForeground(new BitmapDrawable(r8.getResources(), r5));
        Log.d("ViewBlurUtil", "RenderScript blur effect applied successfully.");
        return;
    L46:
        Log.e("ViewBlurUtil", "Failed to apply RenderScript blur effect.");
        return;
    L28:
        r14 = null;
    L35:
        e = e;
    L41:
        Log.e("ViewBlurUtil", "Error during RenderScript blur: " + e.getMessage());     // Catch: Throwable -> L33
        if (r6 == null) goto L44;
        r6.destroy();
        goto L44
    L33:
        th = th;
        r3 = r2;
    L47:
        if (r3 == 0) goto L49;
        r3.destroy();
    L49:
        throw th;
    L39:
        e = e;
        r6 = null;
    L37:
        th = th;
    L19:
        e = move-exception;
        Log.e("ViewBlurUtil", "Error capturing bitmap from view: " + e.getMessage());
        r10 = null;
        goto L21
    }

    public final int g(int r2, ForsetiWidth r3) {
        if (r3 != null) goto L4;
        int r4 = -1;
    L5:
        switch(r4) {
            case 1: goto L13;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L14;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L14;
        };
    L9:
        int r5 = this.g;
    L17:
        return r2 - r5;
    L10:
        r5 = this.f;
        goto L17
    L14:
        return (int) (r2 * 0.5f);
    L15:
        return this.g;
    L16:
        return this.f;
    L13:
        return r2 * 1;
    L4:
        r4 = c.a[r3.ordinal()];
        goto L5
    }
}
