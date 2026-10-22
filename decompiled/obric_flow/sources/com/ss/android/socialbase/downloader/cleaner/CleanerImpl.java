package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes3.dex */
public class CleanerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Semaphore f15237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f15238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f15239c;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.cleaner.CleanerImpl$1, reason: invalid class name */
    class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CleanerImpl f15240a;

        public AnonymousClass1(CleanerImpl r5) {
            this.f15240a = r5;
        }
    }

    public interface CleanerHandler {
        void start();
    }

    public CleanerImpl(CleanerConfig r5) {
        this.f15237a = new Semaphore(0);
        this.f15238b = false;
        CopyOnWriteArrayList r10 = new CopyOnWriteArrayList();
        this.f15239c = r10;
        HashSet r11 = r5.g;
        monitor-enter(r11);
        boolean r12 = r5.g.isEmpty();     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
        if (r12 == true) goto L11;
        if (r5.f15227c.isEmpty() == true) goto L11;
        r10.add(new CacheKeyCleaner(this, r5));
    L11:
        if (DirectoryCleaner.e == false) goto L19;
        r10.add(new DirectoryCleaner(this, r5));
        return;
    L19:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void a() {
        if (Logger.b() == false) goto L6;
        Logger.b("CleanerImpl", "startSync", "Run");
    L6:
        if (this.f15239c.isEmpty() == true) goto L39;
        long r5 = System.currentTimeMillis();
        final Detecter r10 = new Detecter(new AnonymousClass1(this));
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (r10.f15242b != Detecter.DetecterState.f15249a) goto L17;
        r10.f15242b = Detecter.DetecterState.f15251c;     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        r10.e.execute(new Detecter.AnonymousClass1(r10));
    L19:
        if (this.f15238b == true) goto L28;
        Iterator r11 = this.f15239c.iterator();
    L23:
        if (r11.hasNext() == false) goto L27;
        ((CleanerHandler) r11.next()).start();
        if (this.f15238b == false) goto L23;
        this.f15238b = false;
        goto L28
    L27:
        this.f15237a.release();
    L28:
        this.f15237a.acquire();
        r10.f = true;
        r10.f15241a = null;
        r10.d.release();
        if (Logger.b() == false) goto L38;
        Logger.b("CleanerImpl", "startSync", "clear all cache end---cost time=" + (System.currentTimeMillis() - r5));
        return;
    L38:
        return;
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L15
        goto L19
    }
}
