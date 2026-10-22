package com.bytedance.android.live.effect.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.core.view.GestureDetectorCompat;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.b;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Logger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class EffectGestureDetectorV2 implements b, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener {
    public final LiveEffectContextFactoryDelegate$Type a;
    public final GestureDetectorCompat b;
    public final ScaleGestureDetector c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public Type j;

    public static final enum Type extends Enum<Type> {
        public static final Type BEF_GESTURE_TYPE_LONG_PRESS = null;
        public static final Type BEF_GESTURE_TYPE_PAN = null;
        public static final Type BEF_GESTURE_TYPE_ROTATE = null;
        public static final Type BEF_GESTURE_TYPE_SCALE = null;
        public static final Type BEF_GESTURE_TYPE_TAP = null;
        public static final Type BEF_GESTURE_TYPE_UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r0 = new Type("BEF_GESTURE_TYPE_UNKNOWN", 0);
            BEF_GESTURE_TYPE_UNKNOWN = r0;
            Type r1 = new Type("BEF_GESTURE_TYPE_TAP", 1);
            BEF_GESTURE_TYPE_TAP = r1;
            Type r3 = new Type("BEF_GESTURE_TYPE_PAN", 2);
            BEF_GESTURE_TYPE_PAN = r3;
            Type r5 = new Type("BEF_GESTURE_TYPE_ROTATE", 3);
            BEF_GESTURE_TYPE_ROTATE = r5;
            Type r7 = new Type("BEF_GESTURE_TYPE_SCALE", 4);
            BEF_GESTURE_TYPE_SCALE = r7;
            Type r9 = new Type("BEF_GESTURE_TYPE_LONG_PRESS", 5);
            BEF_GESTURE_TYPE_LONG_PRESS = r9;
            a = new Type[]{r0, r1, r3, r5, r7, r9};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r1) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r1) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r1) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r1) {
        return true;
    }

    public final boolean d() {
        LiveEffectContextFactoryDelegate$Type r0 = this.a;
        List<String> r1 = LiveEffectContext.h;
        ILiveEffectComposerManager r2 = LiveEffectContext.a.a(r0).a();
        if (r2 == null) goto L8;
        boolean r3 = c(r2.o(d0.c));
        if (r3 == false) goto L7;
        return r3;
    L7:
        return c(r2.o("livegame"));
    L8:
        return false;
    }

    public static boolean c(List r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.size() <= 0) goto L22;
        Iterator r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L23;
        List r0 = ((Sticker) r3.next()).getTypes();
        if (r0 == null) goto L7;
        if (r0.size() <= 0) goto L7;
        return r0.contains("TouchGes");
    L23:
        return false;
    L22:
        return false;
    }

    public final boolean f(MotionEvent r8) {
        if (d() == true) goto L6;
        return false;
    L6:
        if ((r8.getAction() & 255) != 2) goto L11;
        int r0 = 0;
    L9:
        if (r0 >= r8.getPointerCount()) goto L12;
        xs2.b.a().post(new a(207, a(r8, r8.getPointerId(r0))));
        r0 = r0 + 1;
    L12:
        Logger.e("AmazingEngineTouch", "notifyTouchEvent: ACTION_AMAZING_TOUCH");
        int r1 = r8.getAction() & 255;
        this.c.onTouchEvent(r8);
        if (r1 != 0) goto L16;
        this.d = false;
    L16:
        if (r8.getPointerCount() <= 1) goto L19;
        this.d = true;
    L19:
        if (this.d == true) goto L21;
        this.b.onTouchEvent(r8);
    L21:
        if (r1 != 1) goto L24;
        e(202, b(r8, true));
    L24:
        return true;
    L11:
        xs2.b.a().post(new a(207, a(r8, r8.getPointerId(r8.getActionIndex()))));
        goto L12
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r3) {
        e(208, b(r3, false));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r2) {
        e(201, b(r2, true));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r2) {
        this.j = Type.BEF_GESTURE_TYPE_LONG_PRESS;
        e(204, b(r2, false));
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r3) {
        this.j = Type.BEF_GESTURE_TYPE_SCALE;
        float r0 = r3.getScaleFactor() / this.i;
        a.C0187a r1 = new a.C0187a();
        r1.c = r0;
        e(205, r1);
        this.i = r3.getScaleFactor();
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r1) {
        this.i = 1.0f;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r3) {
        this.j = Type.BEF_GESTURE_TYPE_TAP;
        e(206, b(r3, false));
        return false;
    }

    public EffectGestureDetectorV2(Context r3, LiveEffectContextFactoryDelegate$Type r4) {
        this.d = false;
        this.i = 1.0f;
        this.j = Type.BEF_GESTURE_TYPE_PAN;
        this.a = r4;
        Resources r5 = r3.getApplicationContext().getResources();
        this.e = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).widthPixels;
        Resources r6 = r3.getApplicationContext().getResources();
        this.f = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).heightPixels;
        GestureDetectorCompat r7 = new GestureDetectorCompat(r3, this);
        this.b = r7;
        r7.setIsLongpressEnabled(false);
        r7.setOnDoubleTapListener(this);
        this.c = new ScaleGestureDetector(r3, this);
    }

    public static void e(int r2, a.C0187a r3) {
        Logger.e("EffectGestureDetector", "notifyTouchEvent:" + r2 + " type:" + r3.a);
        xs2.b.a().post(new a(r2, r3));
    }

    public final a.C0187a a(MotionEvent r7, long r8) {
        a.C0187a r0 = new a.C0187a();
        r0.d = r8;
        if (this.h <= 10) goto L5;
        float r1 = r7.getX(r7.findPointerIndex((int) r8)) - this.h;
    L6:
        r0.b = r1 / this.e;
        if (this.g <= 10) goto L9;
        float r2 = r7.getY(r7.findPointerIndex((int) r8)) - this.g;
    L10:
        float r3 = r2 / this.f;
        float r4 = r0.b;
        if (r4 > 0.0f) goto L13;
        r4 = 0.0f;
    L17:
        r0.b = r4;
        int r5 = (r3 > 0.0f ? 1 : (r3 == 0.0f ? 0 : -1));
        r7.getPressure(r7.findPointerIndex((int) r8));
        int r9 = r7.getActionMasked();
        if (r9 != 0) goto L20;
    L27:
        r7.getPointerCount();
        return r0;
    L20:
        if (r9 == 1) goto L27;
        if (r9 == 2) goto L27;
        if (r9 == 3) goto L27;
        if (r9 == 5) goto L27;
        goto L27
    L13:
        if (r4 < 1.0f) goto L17;
        r4 = 1.0f;
        goto L17
    L9:
        r2 = r7.getY(r7.findPointerIndex((int) r8));
        goto L10
    L5:
        r1 = r7.getX(r7.findPointerIndex((int) r8));
        goto L6
    }

    public final a.C0187a b(MotionEvent r4, boolean r5) {
        a.C0187a r0 = new a.C0187a();
        r0.b = r4.getX() / this.e;
        r4.getY();
        if (r5 == false) goto L7;
        Type r6 = this.j;
        if (r6 == null) goto L7;
        r0.a = r6.ordinal();
    L7:
        return r0;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        this.j = Type.BEF_GESTURE_TYPE_PAN;
        a.C0187a r5 = b(r2, false);
        r5.getClass();
        r5.getClass();
        r5.getClass();
        e(203, r5);
        return true;
    }
}
