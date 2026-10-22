package com.lynx.clay.embedding.android;

import android.graphics.Matrix;
import android.view.InputDevice;
import android.view.MotionEvent;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final Matrix f = null;
    public final FlutterRenderer a;
    public final i b;
    public final boolean c;
    public MotionEvent d;
    public boolean e;

    public static int b(int r3) {
        if (r3 != 0) goto L6;
        return 4;
    L6:
        if (r3 != 1) goto L9;
        return 6;
    L9:
        if (r3 != 5) goto L11;
        return 4;
    L11:
        if (r3 != 6) goto L14;
        return 6;
    L14:
        if (r3 != 2) goto L17;
        return 5;
    L17:
        if (r3 != 7) goto L19;
        return 3;
    L19:
        if (r3 != 3) goto L23;
        return 0;
    L23:
        if (r3 != 8) goto L25;
        return 3;
    L25:
        return -1;
    }

    static {
        f = new Matrix();
    }

    public b(FlutterRenderer r2, boolean r3) {
        this.d = null;
        this.e = false;
        this.a = r2;
        if (i.c != null) goto L5;
        i.c = new i();
    L5:
        this.b = i.c;
        this.c = r3;
    }

    public final ByteBuffer c(MotionEvent r13, Matrix r14) {
        int r0 = r13.getPointerCount();
        ByteBuffer r1 = ByteBuffer.allocateDirect((r0 * 37) * 8);
        r1.order(ByteOrder.LITTLE_ENDIAN);
        int r2 = r13.getActionMasked();
        int r9 = b(r13.getActionMasked());
        if (r2 != 0) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L14;
        if (r2 != 1) goto L12;
    L13:
        boolean r3 = true;
    L15:
        if (r4 == false) goto L17;
        a(r13, r13.getActionIndex(), r9, 0, r14, r1);
    L31:
        if ((r1.position() % 296) != 0) goto L34;
        return r1;
    L34:
        throw new AssertionError("Packet position is not on field boundary");
    L17:
        if (r3 == false) goto L27;
        int r11 = 0;
    L19:
        if (r11 >= r0) goto L26;
        if (r11 == r13.getActionIndex()) goto L25;
        if (r13.getToolType(r11) != 1) goto L25;
        a(r13, r11, 5, 1, r14, r1);
    L25:
        r11 = r11 + 1;
        goto L19
    L26:
        a(r13, r13.getActionIndex(), r9, 0, r14, r1);
        goto L31
    L27:
        int r10 = 0;
    L28:
        if (r10 >= r0) goto L31;
        a(r13, r10, r9, 0, r14, r1);
        r10 = r10 + 1;
        goto L28
    L12:
        if (r2 == 6) goto L13;
    L14:
        r3 = false;
        goto L15
    L5:
        if (r2 == 5) goto L8;
        r4 = false;
        goto L9
    }

    public final boolean d(MotionEvent r4, Matrix r5) {
        if (r4.getActionMasked() != 0) goto L5;
    L6:
        this.d = r4;
        this.e = false;
    L8:
        if (this.e == false) goto L10;
        return false;
    L10:
        ByteBuffer r6 = c(r4, r5);
        FlutterRenderer r0 = this.a;
        int r2 = r6.position();
        boolean r7 = r0.a.dispatchPointerDataPacket(r6, r2);
        if (r7 == true) goto L20;
        this.e = true;
        MotionEvent r1 = this.d;
        if (r1 == null) goto L20;
        MotionEvent r3 = MotionEvent.obtain(r1);
        r3.setAction(3);
        ByteBuffer r8 = c(r3, r5);     // Catch: Throwable -> L17
        FlutterRenderer r9 = this.a;     // Catch: Throwable -> L17
        int r10 = r8.position();     // Catch: Throwable -> L17
        r9.a.dispatchPointerDataPacket(r8, r10);     // Catch: Throwable -> L17
        r3.recycle();
    L17:
        th = move-exception;
        r3.recycle();
        throw th;
    L20:
        return r7;
    L5:
        if (r4.getActionMasked() != 3) goto L8;
        goto L6
    }

    public final void a(MotionEvent r21, int r22, int r23, int r24, Matrix r25, ByteBuffer r26) {
        if (r23 != (-1)) goto L6;
        return;
    L6:
        if (this.c == false) goto L8;
        i r5 = this.b;
        r5.getClass();
        long r8 = i.a.a.incrementAndGet();
        r5.a.put(r8, MotionEvent.obtain(r21));
        r5.b.add(Long.valueOf(r8));
    L9:
        int r6 = r21.getToolType(r22);
        if (r6 == 1) goto L18;
        if (r6 == 2) goto L17;
        int r15 = 3;
        if (r6 == 3) goto L16;
        if (r6 == 4) goto L20;
        r15 = 5;
    L20:
        if (r21.getActionMasked() != 8) goto L22;
        int r7 = 1;
    L23:
        long r13 = r21.getEventTime() * 1000;
        r26.putLong(r8);
        r26.putLong(r13);
        r26.putLong(r23);
        r26.putLong(r15);
        r26.putLong(r7);
        r26.putLong(r21.getPointerId(r22));
        r26.putLong(0);
        float[] r9 = {r21.getX(r22), r21.getY(r22)};
        r25.mapPoints(r9);
        r26.putDouble(r9[0]);
        r26.putDouble(r9[1]);
        r26.putDouble(0.0d);
        r26.putDouble(0.0d);
        if (r15 != 1) goto L36;
        long r12 = r21.getButtonState() & 31;
        if (r12 == 0) goto L28;
    L34:
        long r10 = r12;
    L39:
        r26.putLong(r10);
        r26.putLong(0);
        r26.putLong(0);
        r26.putDouble(r21.getPressure(r22));
        if (r21.getDevice() == null) goto L44;
        InputDevice.MotionRange r3 = r21.getDevice().getMotionRange(2);
        if (r3 == null) goto L44;
        double r11 = r3.getMin();
        double r14 = r3.getMax();
    L45:
        r26.putDouble(r11);
        r26.putDouble(r14);
        if (r15 != 2) goto L48;
        r26.putDouble(r21.getAxisValue(24, r22));
        r26.putDouble(0.0d);
    L49:
        r26.putDouble(r21.getSize(r22));
        r26.putDouble(r21.getToolMajor(r22));
        r26.putDouble(r21.getToolMinor(r22));
        r26.putDouble(0.0d);
        r26.putDouble(0.0d);
        r26.putDouble(r21.getAxisValue(8, r22));
        if (r15 != 2) goto L52;
        r26.putDouble(r21.getAxisValue(25, r22));
    L53:
        r26.putLong(r24);
        if (r7 != 1) goto L56;
        r26.putDouble(-r21.getAxisValue(10));
        r26.putDouble(-r21.getAxisValue(9));
    L57:
        r26.putDouble(0.0d);
        r26.putDouble(0.0d);
        r26.putDouble(0.0d);
        r26.putDouble(0.0d);
        r26.putDouble(1.0d);
        r26.putDouble(0.0d);
        r26.putLong(r21.getSource());
        r26.putLong(1);
        return;
    L56:
        r26.putDouble(0.0d);
        r26.putDouble(0.0d);
        goto L57
    L52:
        r26.putDouble(0.0d);
        goto L53
    L48:
        r26.putDouble(0.0d);
        r26.putDouble(0.0d);
    L44:
        r14 = 1.0d;
        r11 = 0.0d;
        goto L45
    L28:
        if (r21.getSource() != 8194) goto L34;
        if (r23 != 4) goto L32;
    L33:
        r10 = 1;
        goto L39
    L32:
        if (r23 != 5) goto L34;
    L36:
        if (r15 != 2) goto L38;
        r10 = (r21.getButtonState() >> 4) & 15;
        goto L39
    L38:
        r10 = 0;
        goto L39
    L22:
        r7 = 0;
        goto L23
    L16:
        r15 = 1;
        goto L20
    L17:
        r15 = 2;
        goto L20
    L18:
        r15 = 0;
        goto L20
    L8:
        r8 = 0;
        goto L9
    }
}
