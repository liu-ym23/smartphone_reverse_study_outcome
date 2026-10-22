package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Handler f15451a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Looper f15452a = null;

        static {
            HandlerThread r0 = new HandlerThread("DownloadWatchDog");
            r0.start();
            f15452a = r0.getLooper();
        }

        static /* synthetic */ Looper a() {
            return f15452a;
        }
    }

    public interface b {
        long a();
    }

    public c() {
        this.f15451a = new Handler(a.a(), this);
    }

    public static Looper a() {
        return a.a();
    }

    public void a(b r3, long r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Handler r2 = this.f15451a;
        if (r2 != null) goto L5;
        return;
    L5:
        Message r0 = Message.obtain();
        r0.what = 0;
        r0.obj = r5;
        r2.sendMessageDelayed(r0, r4);
    }

    public void b() {
        Handler r0 = this.f15451a;
        if (r0 != null) goto L5;
        return;
    L5:
        this.f15451a = null;
        r0.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r5) {
        if (r5.what != 0) goto L16;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5.obj, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        long r0 = r6.a();     // Catch: Throwable -> L9
        if (r0 <= 0) goto L15;
        a(r6, r0);     // Catch: Throwable -> L9
        return true;
    L15:
        return true;
    L9:
        th = move-exception;
        th.printStackTrace();
        return true;
    L16:
        return true;
    }
}
