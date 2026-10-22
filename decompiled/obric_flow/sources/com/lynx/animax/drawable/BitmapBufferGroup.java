package com.lynx.animax.drawable;

import android.view.View;
import androidx.annotation.Nullable;
import com.lynx.animax.base.CalledByNative;
import im.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapBufferGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f9604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f9605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9606c;
    public final WeakReference d;
    public final boolean e;

    public BitmapBufferGroup(d r5) {
        this.f9604a = new AtomicReference();
        this.d = new WeakReference(r5);
        this.e = true;
        this.f9605b = new ConcurrentLinkedQueue();
        this.f9606c = 3;
    }

    @Nullable
    @CalledByNative
    public BitmapBuffer getBitmapBufferForOffscreenRendering() {
        return (BitmapBuffer) this.f9605b.peek();
    }

    @CalledByNative
    public void onBufferUpdate() {
        ConcurrentLinkedQueue r5 = this.f9605b;
        BitmapBuffer r10 = (BitmapBuffer) r5.peek();
        if (r10 == null) goto L22;
        AtomicReference r11 = r10.f9600c;
        BitmapBuffer.BufferState r12 = (BitmapBuffer.BufferState) r11.get();
        BitmapBuffer.BufferState r13 = BitmapBuffer.BufferState.f9602b;
        if (r12 != r13) goto L25;
        AtomicReference r14 = this.f9604a;
        BitmapBuffer r15 = (BitmapBuffer) r14.getAndSet(r10);
        if (r15 == null) goto L11;
        BitmapBuffer.BufferState r16 = BitmapBuffer.BufferState.f9601a;
        r15.f9600c.set(r16);
        r5.offer(r15);
    L11:
        if (((BitmapBuffer.BufferState) r11.get()) == r13) goto L18;
        if (r15 == null) goto L14;
        r5.remove(r15);
        r15.b();
    L14:
        BitmapBuffer r17 = (BitmapBuffer) r14.getAndSet(null);
        if (r17 == null) goto L23;
        r17.b();
        return;
    L23:
        return;
    L18:
        r5.remove(r10);
        View r18 = (View) this.d.get();
        if (r18 == null) goto L24;
        r18.postInvalidate();
        return;
    L24:
        return;
    L25:
        return;
    }
}
