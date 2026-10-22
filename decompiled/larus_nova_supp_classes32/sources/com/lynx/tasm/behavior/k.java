package com.lynx.tasm.behavior;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public static int n;
    public static final int o = 0;
    public int a;
    public final a b;
    public final c c;
    public b d;
    public boolean e;
    public boolean f;
    public boolean g;
    public MotionEvent h;
    public MotionEvent i;
    public float j;
    public float k;
    public boolean l;
    public boolean m;

    public class a extends Handler {
        public final /* synthetic */ k a;

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            int r0 = r5.what;
            if (r0 != 1) goto L5;
            this.a.c.getClass();
            return;
        L5:
            if (r0 == 2) goto L14;
            if (r0 != 3) goto L13;
            k r6 = this.a;
            b r1 = r6.d;
            if (r1 != null) goto L10;
            return;
        L10:
            if (r6.e == true) goto L18;
            r1.a();
            return;
        L18:
            return;
        L13:
            throw new RuntimeException("Unknown message " + r5);
        L14:
            k r7 = this.a;
            r7.b.removeMessages(3);
            r7.f = true;
            c r2 = r7.c;
            ((b1.c) r2).a.o(r7.h);
        }

        public a(k r1, Handler r2) {
            this.a = r1;
            super(r2.getLooper());
        }
    }

    public interface b {
        void a();
    }

    public interface c {
    }

    public static class d implements c, b {
        public d() {
        }

        @Override // com.lynx.tasm.behavior.k.b
        public final void a() {
        }
    }

    public final void a() {
        this.b.removeMessages(1);
        this.b.removeMessages(2);
        this.b.removeMessages(3);
        this.e = false;
        this.g = false;
        if (this.f == false) goto L6;
        this.f = false;
        return;
    }

    static {
        n = ViewConfiguration.getLongPressTimeout();
        o = ViewConfiguration.getTapTimeout();
    }

    public final void b(MotionEvent r9) {
        int r0 = r9.getAction();
        float r1 = r9.getY();
        float r2 = r9.getX();
        int r3 = r0 & 255;
        int r4 = 0;
        if (r3 != 0) goto L5;
        this.k = r2;
        this.j = r1;
        MotionEvent r5 = this.h;
        if (r5 == null) goto L55;
        r5.recycle();
    L55:
        this.h = MotionEvent.obtain(r9);
        this.g = true;
        this.e = true;
        this.f = false;
        if (this.l == false) goto L58;
        this.b.removeMessages(2);
        this.b.sendEmptyMessageAtTime(2, (this.h.getDownTime() + ((long) o)) + ((long) n));
    L58:
        this.b.sendEmptyMessageAtTime(1, this.h.getDownTime() + ((long) o));
        this.c.getClass();
        return;
    L5:
        if (r3 == 1) goto L42;
        if (r3 == 2) goto L26;
        if (r3 != 3) goto L9;
        a();
        return;
    L9:
        if (r3 == 5) goto L22;
        if (r3 == 6) goto L14;
        return;
    L14:
        if (this.m == true) goto L16;
        return;
    L16:
        if (r9.getPointerCount() == 2) goto L18;
        return;
    L18:
        if (((r0 & 65280) >> 8) != 0) goto L20;
        r4 = 1;
    L20:
        this.k = r9.getX(r4);
        this.j = r9.getY(r4);
        return;
    L22:
        if (this.m == false) goto L63;
        a();
        return;
    L63:
        return;
    L26:
        if (this.f == false) goto L28;
        return;
    L28:
        if (this.m == true) goto L30;
    L32:
        float r10 = this.k - r2;
        float r6 = this.j - r1;
        if (this.g == false) goto L38;
        int r11 = (int) (r2 - this.h.getX());
        int r7 = (int) (r1 - this.h.getY());
        if (((r11 * r11) + (r7 * r7)) <= this.a) goto L67;
        this.c.getClass();
        this.k = r2;
        this.j = r1;
        this.g = false;
        this.b.removeMessages(3);
        this.b.removeMessages(1);
        this.b.removeMessages(2);
        return;
    L67:
        return;
    L38:
        if (Math.abs(r10) < 1.0f) goto L40;
    L41:
        this.c.getClass();
        this.k = r2;
        this.j = r1;
        return;
    L40:
        if (Math.abs(r6) >= 1.0f) goto L41;
        return;
    L30:
        if (r9.getPointerCount() <= 1) goto L32;
        return;
    L42:
        this.e = false;
        MotionEvent r12 = MotionEvent.obtain(r9);
        if (this.f == false) goto L46;
        this.b.removeMessages(3);
        this.f = false;
    L48:
        MotionEvent r8 = this.i;
        if (r8 == null) goto L51;
        r8.recycle();
    L51:
        this.i = r12;
        this.b.removeMessages(1);
        this.b.removeMessages(2);
        return;
    L46:
        if (this.g == false) goto L48;
        this.c.getClass();
        goto L48
    }

    public k(LynxContext r4, b1.c r5, Handler r6) {
        if (r4 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.b = new a(this, r6);
        this.c = r5;
        this.d = r5;
        this.l = true;
        this.m = r1;
        if (r4 != null) goto L11;
        int r7 = ViewConfiguration.getTouchSlop();
    L12:
        this.a = r7 * r7;
        return;
    L11:
        r7 = ViewConfiguration.get(r4).getScaledTouchSlop();
        goto L12
    L5:
        if (r4.getApplicationInfo().targetSdkVersion < 8) goto L7;
        r1 = true;
        goto L8
    }
}
