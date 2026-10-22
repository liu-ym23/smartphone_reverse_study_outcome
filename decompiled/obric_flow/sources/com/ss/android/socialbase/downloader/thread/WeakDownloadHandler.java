package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class WeakDownloadHandler extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f16124a;

    public interface IHandler {
        void a(Message r5);
    }

    public WeakDownloadHandler(Looper r5, IHandler r10) {
        super(r5);
        this.f16124a = new WeakReference(r10);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r5) {
        IHandler r10 = (IHandler) this.f16124a.get();
        if (r10 == null) goto L7;
        if (r5 == null) goto L8;
        r10.a(r5);
        return;
    L8:
        return;
    }
}
