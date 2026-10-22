package com.lynx.animax.drawable;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.os.Build;
import android.view.View;
import com.lynx.animax.util.AnimaXLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BitmapBufferGroup {
    public final AtomicReference<BitmapBuffer> a;
    public final ConcurrentLinkedQueue<BitmapBuffer> b;
    public final int c;
    public final WeakReference<View> d;
    public final boolean e;

    public final void a() {
    L2:
        BitmapBuffer r0 = this.b.poll();
        if (r0 == null) goto L5;
        r0.a();
        goto L2
    L5:
        BitmapBuffer r1 = this.a.getAndSet(null);
        if (r1 == null) goto L10;
        r1.a();
        return;
    }

    public BitmapBuffer getBitmapBufferForOffscreenRendering() {
        return this.b.peek();
    }

    public void onBufferUpdate() {
        BitmapBuffer r0 = this.b.peek();
        if (r0 == null) goto L23;
        BitmapBuffer.BufferState r1 = r0.c.get();
        BitmapBuffer.BufferState r2 = BitmapBuffer.BufferState.Ready;
        if (r1 != r2) goto L25;
        BitmapBuffer r3 = this.a.getAndSet(r0);
        if (r3 == null) goto L11;
        BitmapBuffer.BufferState r4 = BitmapBuffer.BufferState.NotReady;
        r3.c.set(r4);
        this.b.offer(r3);
    L11:
        if (r0.c.get() == r2) goto L18;
        if (r3 == null) goto L14;
        this.b.remove(r3);
        r3.a();
    L14:
        BitmapBuffer r5 = this.a.getAndSet(null);
        if (r5 == null) goto L22;
        r5.a();
        return;
    L22:
        return;
    L18:
        this.b.remove(r0);
        View r6 = this.d.get();
        if (r6 == null) goto L24;
        r6.postInvalidate();
        return;
    L24:
        return;
    L25:
        return;
    }

    public BitmapBufferGroup(View r2) {
        this.a = new AtomicReference();
        this.d = new WeakReference(r2);
        this.e = true;
        this.b = new ConcurrentLinkedQueue();
        this.c = 3;
    }

    public final BitmapBuffer c(BitmapBuffer r3) {
        BitmapBuffer r0 = this.a.get();
        if (r0 != null) goto L5;
        return r3;
    L5:
        if (r0.c.get() != BitmapBuffer.BufferState.Ready) goto L12;
        if (r3 == null) goto L10;
        BitmapBuffer.BufferState r1 = BitmapBuffer.BufferState.NotReady;
        r3.c.set(r1);
        this.b.offer(r3);
    L10:
        return this.a.getAndSet(null);
    L12:
        return r3;
    }

    public final void b(int r18, int r19) {
        if (r18 <= 0) goto L55;
        if (r19 <= 0) goto L64;
        a();
        if (r18 <= 0) goto L63;
        if (r19 <= 0) goto L65;
        int r11 = 0;
    L12:
        if (r11 >= this.c) goto L66;
        ConcurrentLinkedQueue<BitmapBuffer> r12 = this.b;
        boolean r0 = this.e;
        int r2 = Build.VERSION.SDK_INT;
        boolean r14 = true;
        if (r2 < 26) goto L21;
        if (r0 == false) goto L20;
        if (r2 < 29) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L21;
    L18:
        r3 = false;
    L20:
        boolean r4 = true;
    L22:
        Bitmap r16 = null;
        if (r4 == false) goto L41;
        if (r18 <= 0) goto L41;
        if (r19 <= 0) goto L41;
        if (r0 == false) goto L30;
        long r5 = 304;
    L56:
        HardwareBuffer r6 = HardwareBuffer.create(r18, r19, 1, 1, r5);     // Catch: Exception -> L39
    L43:
        if (Build.VERSION.SDK_INT >= 29) goto L46;
        r14 = false;
    L46:
        if (r14 == false) goto L52;
        if (r6 == null) goto L52;
        r16 = Bitmap.wrapHardwareBuffer(r6, ColorSpace.get(ColorSpace.Named.SRGB));     // Catch: Exception -> L50
    L50:
        e = move-exception;
        AnimaXLog.a("BitmapBuffer", "Failed to wrap HardwareBuffer: " + e.getMessage());
        r6.close();
        r6 = null;
    L52:
        if (r16 != null) goto L54;
        r16 = Bitmap.createBitmap(r18, r19, Bitmap.Config.ARGB_8888);
    L54:
        r12.offer(new BitmapBuffer(r16, r6));
        r11 = r11 + 1;
    L39:
        e = move-exception;
        AnimaXLog.a("BitmapBuffer", "Failed to create HardwareBuffer: " + e.getMessage());
        goto L41
    L30:
        if (r2 < 29) goto L32;
        boolean r1 = true;
    L33:
        if (r1 == false) goto L35;
        r5 = 768;
        goto L56
    L35:
        r5 = 515;
        goto L56
    L32:
        r1 = false;
    L41:
        r6 = null;
    L21:
        r4 = false;
        goto L22
    L66:
        return;
    L65:
        return;
    L63:
        return;
    L64:
        return;
    }
}
