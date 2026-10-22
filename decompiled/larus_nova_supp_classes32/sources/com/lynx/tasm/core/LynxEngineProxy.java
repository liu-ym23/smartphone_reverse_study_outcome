package com.lynx.tasm.core;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxEngineProxy {
    public long a;

    private native long nativeCreate(long r1);

    private native void nativeDestroy(long r1);

    private native void nativeDispatchTaskToLynxEngine(long r1, Runnable r3);

    private native void nativeInvokeLepusApiCallback(long r1, int r3, String r4, Object r5);

    private native void nativeOnPseudoStatusChanged(long r1, int r3, int r4, int r5);

    private native void nativeSendCustomEvent(long r1, String r3, int r4, ByteBuffer r5, int r6, String r7);

    private native void nativeSendGestureEvent(long r1, String r3, int r4, int r5, ByteBuffer r6, int r7);

    private native void nativeSendMultiTouchEvent(long r1, String r3, ByteBuffer r4, int r5, long r6);

    private native void nativeSendTouchEvent(long r1, String r3, int r4, float r5, float r6, float r7, float r8, float r9, float r10, long r11);

    private native void nativeStartEventBubble(long r1, long r3);

    private native void nativeStartEventCapture(long r1, long r3);

    private native void nativeStartEventFire(long r1, boolean r3, long r4);

    private native void nativeStartEventGenerate(long r1, ByteBuffer r3, int r4);

    public LynxEngineProxy(long r1) {
        this.a = nativeCreate(r1);
    }

    private static void executeRunnable(Runnable r0) {
        r0.run();
    }

    public static /* synthetic */ void a(LynxEngineProxy r0, long r1) {
        r0.nativeDestroy(r1);
    }

    public static /* synthetic */ void b(LynxEngineProxy r0, long r1, long r3) {
        r0.nativeStartEventCapture(r1, r3);
    }

    public static /* synthetic */ void c(LynxEngineProxy r0, long r1, long r3) {
        r0.nativeStartEventBubble(r1, r3);
    }

    public static /* synthetic */ void e(LynxEngineProxy r0, long r1, Runnable r3) {
        r0.nativeDispatchTaskToLynxEngine(r1, r3);
    }

    public static /* synthetic */ void d(LynxEngineProxy r0, long r1, boolean r3, long r4) {
        r0.nativeStartEventFire(r1, r3, r4);
    }

    public static /* synthetic */ void l(LynxEngineProxy r0, long r1, ByteBuffer r3, int r4) {
        r0.nativeStartEventGenerate(r1, r3, r4);
    }

    public static /* synthetic */ void j(LynxEngineProxy r0, long r1, int r3, int r4, int r5) {
        r0.nativeOnPseudoStatusChanged(r1, r3, r4, r5);
    }

    public static /* synthetic */ void k(LynxEngineProxy r0, long r1, int r3, String r4, Object r5) {
        r0.nativeInvokeLepusApiCallback(r1, r3, r4, r5);
    }

    public static /* synthetic */ void g(LynxEngineProxy r0, long r1, String r3, ByteBuffer r4, int r5, long r6) {
        r0.nativeSendMultiTouchEvent(r1, r3, r4, r5, r6);
    }

    public static /* synthetic */ void h(LynxEngineProxy r0, long r1, String r3, int r4, ByteBuffer r5, int r6, String r7) {
        r0.nativeSendCustomEvent(r1, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void i(LynxEngineProxy r0, long r1, String r3, int r4, int r5, ByteBuffer r6, int r7) {
        r0.nativeSendGestureEvent(r1, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void f(LynxEngineProxy r0, long r1, String r3, int r4, float r5, float r6, float r7, float r8, float r9, float r10, long r11) {
        r0.nativeSendTouchEvent(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }
}
