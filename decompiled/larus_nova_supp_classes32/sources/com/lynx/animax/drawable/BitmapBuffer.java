package com.lynx.animax.drawable;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Build;
import java.util.concurrent.atomic.AtomicReference;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BitmapBuffer {
    public final Bitmap a;
    public final HardwareBuffer b;
    public final AtomicReference<BufferState> c;

    public static final enum BufferState extends Enum<BufferState> {
        public static final BufferState Destroyed = null;
        public static final BufferState NotReady = null;
        public static final BufferState Prepare = null;
        public static final BufferState Ready = null;
        public static final /* synthetic */ BufferState[] a = null;

        static {
            BufferState r0 = new BufferState("NotReady", 0);
            NotReady = r0;
            BufferState r1 = new BufferState("Prepare", 1);
            Prepare = r1;
            BufferState r3 = new BufferState("Ready", 2);
            Ready = r3;
            BufferState r5 = new BufferState("Destroyed", 3);
            Destroyed = r5;
            a = new BufferState[]{r0, r1, r3, r5};
        }

        public static BufferState[] values() {
            return (BufferState[]) a.clone();
        }

        public static BufferState valueOf(String r1) {
            return (BufferState) a.a(BufferState.class, r1);
        }

        public BufferState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final void a() {
        AtomicReference<BufferState> r0 = this.c;
        BufferState r1 = BufferState.Destroyed;
        BufferState r2 = r0.getAndSet(r1);
        if (r2 != r1) goto L5;
        return;
    L5:
        if (r2 != BufferState.Prepare) goto L8;
        return;
    L8:
        if (this.a.isRecycled() == true) goto L10;
        this.a.recycle();
    L10:
        HardwareBuffer r3 = this.b;
        if (r3 != null) goto L13;
        return;
    L13:
        if (Build.VERSION.SDK_INT < 26) goto L18;
        r3.close();
        return;
    }

    public Bitmap getBitmap() {
        if (this.c.get() != BufferState.Destroyed) goto L7;
        return null;
    L7:
        return this.a;
    }

    public HardwareBuffer getHardwareBuffer() {
        if (this.c.get() != BufferState.Destroyed) goto L7;
        return null;
    L7:
        return this.b;
    }

    public void setState(int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (r3 < BufferState.values().length) goto L7;
        return;
    L7:
        if (this.c.getAndSet(BufferState.values()[r3]) != BufferState.Destroyed) goto L11;
        a();
        return;
    }

    public BitmapBuffer(Bitmap r3, HardwareBuffer r4) {
        this.c = new AtomicReference(BufferState.NotReady);
        this.a = r3;
        this.b = r4;
    }
}
