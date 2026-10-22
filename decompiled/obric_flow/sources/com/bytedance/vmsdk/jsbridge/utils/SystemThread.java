package com.bytedance.vmsdk.jsbridge.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import bm.a;
import com.lynx.tasm.ui.image.h;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class SystemThread {
    private Thread mAndroidThread;
    private long mNativeThread;

    private SystemThread(long r5, String r10, int r11) {
        this.mNativeThread = r5;
        createAndroidThread(r10, r11);
    }

    public static /* synthetic */ long access$000(SystemThread r5) {
        return r5.mNativeThread;
    }

    public static /* synthetic */ void access$100(long r5) {
        nativeRun(r5);
    }

    @CalledByNative
    public static void attachMainThread(long r5) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        nativeRun(r5);
        return;
    L6:
        new Handler(Looper.getMainLooper()).post(new a(4, r5));
    }

    @CalledByNative
    public static SystemThread create(long r5, String r10, int r11) {
        return new SystemThread(r5, r10, r11);
    }

    private void createAndroidThread(String r5, int r10) {
        Thread r11 = new Thread(new h(this, 17), r5);
        this.mAndroidThread = r11;
        r11.setPriority(r10);
        this.mAndroidThread.start();
    }

    private static native void nativeRun(long r5);

    @CalledByNative
    public void join() {
        this.mAndroidThread.join();     // Catch: InterruptedException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @CalledByNative
    public void stop() {
        Looper r5 = Looper.myLooper();
        if (Thread.currentThread() != this.mAndroidThread) goto L7;
        if (r5 == null) goto L8;
        r5.quit();
        return;
    L8:
        return;
    }
}
