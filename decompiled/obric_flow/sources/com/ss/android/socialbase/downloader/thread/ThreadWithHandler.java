package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadWithHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f16119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InnerThread f16120c;
    public Handler d;

    public class InnerThread extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadWithHandler f16121a;

        public InnerThread(ThreadWithHandler r5) {
            this.f16121a = r5;
            super("DownloaderNotifyThread");
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            Looper r5 = getLooper();
            Object r10 = this.f16121a.f16118a;
            monitor-enter(r10);
            ThreadWithHandler r11 = this.f16121a;     // Catch: Throwable -> L12
            r11.d = new Handler(r5);     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
        L7:
            if (this.f16121a.f16119b.isEmpty() == true) goto L11;
            MessageEntity r12 = (MessageEntity) this.f16121a.f16119b.poll();
            if (r12 == null) goto L7;
            this.f16121a.d.postDelayed(r12.f16122a, r12.f16123b);
            goto L7
        L11:
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public class MessageEntity {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f16122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f16123b;

        public MessageEntity(Runnable r5, long r10) {
            this.f16122a = r5;
            this.f16123b = r10;
        }
    }

    public ThreadWithHandler() {
        this.f16118a = new Object();
        this.f16119b = new ConcurrentLinkedQueue();
        this.f16120c = new InnerThread(this);
    }

    public final void a(Runnable r5, long r10) {
        if (this.d != null) goto L17;
        Object r11 = this.f16118a;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.d != null) goto L13;
        this.f16119b.add(new MessageEntity(r5, r10));     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L11
    L17:
        this.d.postDelayed(r5, r10);
    }

    public final void a() {
        this.f16120c.quit();
    }
}
