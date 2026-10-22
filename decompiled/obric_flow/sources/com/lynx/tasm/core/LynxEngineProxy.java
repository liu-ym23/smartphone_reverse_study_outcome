package com.lynx.tasm.core;

import com.lynx.tasm.base.CalledByNative;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class LynxEngineProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10828a;

    public LynxEngineProxy(long r5) {
        this.f10828a = nativeCreate(r5);
    }

    public static /* synthetic */ void a(LynxEngineProxy r5, long r10) {
        r5.nativeDestroy(r10);
    }

    public static /* synthetic */ void b(LynxEngineProxy r5, long r10, int r11, int r12, int r13) {
        r5.nativeOnPseudoStatusChanged(r10, r11, r12, r13);
    }

    public static /* synthetic */ void c(LynxEngineProxy r5, long r10, int r11, String r12, ByteBuffer r13) {
        r5.nativeInvokeLepusApiCallback(r10, r11, r12, r13);
    }

    public static /* synthetic */ void d(LynxEngineProxy r5, long r10, long r11) {
        r5.nativeStartEventCapture(r10, r11);
    }

    public static /* synthetic */ void e(LynxEngineProxy r5, long r10, Runnable r11) {
        r5.nativeDispatchTaskToLynxEngine(r10, r11);
    }

    @CalledByNative
    private static void executeRunnable(Runnable r5) {
        r5.run();
    }

    public static /* synthetic */ void f(LynxEngineProxy r5, long r10, String r11, int r12, float r13, float r14, float r15, float r16, float r17, float r18, long r19) {
        r5.nativeSendTouchEvent(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ void g(LynxEngineProxy r5, long r10, String r11, int r12, int r13, ByteBuffer r14, int r15) {
        r5.nativeSendGestureEvent(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void h(LynxEngineProxy r5, long r10, String r11, int r12, ByteBuffer r13, int r14, String r15) {
        r5.nativeSendCustomEvent(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void i(LynxEngineProxy r5, long r10, String r11, ByteBuffer r12, int r13, long r14) {
        r5.nativeSendMultiTouchEvent(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void j(LynxEngineProxy r5, long r10, ByteBuffer r11, int r12) {
        r5.nativeStartEventGenerate(r10, r11, r12);
    }

    public static /* synthetic */ void k(LynxEngineProxy r5, long r10, boolean r11, long r12) {
        r5.nativeStartEventFire(r10, r11, r12);
    }

    public static /* synthetic */ void l(LynxEngineProxy r5, long r10, long r11) {
        r5.nativeStartEventBubble(r10, r11);
    }

    private native long nativeCreate(long r5);

    private native void nativeDestroy(long r5);

    private native void nativeDispatchTaskToLynxEngine(long r5, Runnable r10);

    private native void nativeInvokeLepusApiCallback(long r5, int r10, String r11, Object r12);

    private native void nativeOnPseudoStatusChanged(long r5, int r10, int r11, int r12);

    private native void nativeSendCustomEvent(long r5, String r10, int r11, ByteBuffer r12, int r13, String r14);

    private native void nativeSendGestureEvent(long r5, String r10, int r11, int r12, ByteBuffer r13, int r14);

    private native void nativeSendMultiTouchEvent(long r5, String r10, ByteBuffer r11, int r12, long r13);

    private native void nativeSendTouchEvent(long r5, String r10, int r11, float r12, float r13, float r14, float r15, float r16, float r17, long r18);

    private native void nativeStartEventBubble(long r5, long r10);

    private native void nativeStartEventCapture(long r5, long r10);

    private native void nativeStartEventFire(long r5, boolean r10, long r11);

    private native void nativeStartEventGenerate(long r5, ByteBuffer r10, int r11);
}
