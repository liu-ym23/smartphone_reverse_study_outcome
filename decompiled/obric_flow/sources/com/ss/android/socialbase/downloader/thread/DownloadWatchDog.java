package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadWatchDog implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Handler f16116a;

    public static class Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Looper f16117a = null;

        static {
            HandlerThread r5 = new HandlerThread("DownloadWatchDog");
            r5.start();
            f16117a = r5.getLooper();
        }
    }

    public interface IWatcher {
        long a();
    }

    public DownloadWatchDog() {
        this.f16116a = new Handler(Holder.f16117a, this);
    }

    public static Looper a() {
        return Holder.f16117a;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r5) {
        if (r5.what != 0) goto L20;
        IWatcher r10 = (IWatcher) r5.obj;     // Catch: Throwable -> L12
        long r11 = r10.a();     // Catch: Throwable -> L12
        if (r11 <= 0) goto L18;
        Handler r12 = this.f16116a;     // Catch: Throwable -> L12
        if (r12 == null) goto L19;
        Message r13 = Message.obtain();     // Catch: Throwable -> L12
        r13.what = 0;     // Catch: Throwable -> L12
        r13.obj = r10;     // Catch: Throwable -> L12
        r12.sendMessageDelayed(r13, r11);     // Catch: Throwable -> L12
        return true;
    L19:
        return true;
    L18:
        return true;
    L12:
        th = move-exception;
        th.printStackTrace();
        return true;
    L20:
        return true;
    }
}
