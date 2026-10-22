package com.lynx.animax.composition;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.util.AnimaXLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXComposition {
    public final long a;

    public static class a implements Runnable {
        public long a;

        @Override // java.lang.Runnable
        public final void run() {
            AnimaXLog.b("AnimaXComposition", "nativeDestroy AnimaXComposition on CleanupReference.");     // Catch: Throwable -> L6
            long r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == 0) goto L9;
            AnimaXComposition.a(r0);     // Catch: Throwable -> L6
            this.a = 0;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(long r1) {
            this.a = r1;
        }
    }

    private static native void nativeDestroy(long r0);

    private native long nativeGetEndFrame(long r1);

    private native long nativeGetStartFrame(long r1);

    public AnimaXComposition(long r3) {
        this.a = r3;
        new q4a.a(this, new a(r3));
    }

    public static /* synthetic */ void a(long r0) {
        nativeDestroy(r0);
    }

    public static AnimaXComposition create(long r1) {
        return new AnimaXComposition(r1);
    }
}
