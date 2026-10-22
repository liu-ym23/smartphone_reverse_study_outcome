package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadModuleChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f15291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadCommonParams f15293c;
    public volatile boolean d;

    public DownloadModuleChain(DownloadCommonParams r5) {
        this.f15291a = new CopyOnWriteArrayList();
        this.d = false;
        this.f15293c = r5;
    }

    public final void a() {
        Iterator r5 = this.f15291a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((IDownloadModule) r5.next()).cancel();
        goto L4
    }

    public final void b() {
        Iterator r5 = this.f15291a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((IDownloadModule) r5.next()).a();
        goto L4
    }

    public final void c() {
        if (this.f15292b != this.f15291a.size()) goto L5;
        return;
    L5:
        IDownloadModule r5 = (IDownloadModule) this.f15291a.get(this.f15292b);
        this.f15292b++;
        r5.a(this);
    }

    public final void a(long r5, int r10) {
        Iterator r11 = this.f15291a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((IDownloadModule) r11.next()).a(r5, r10);
        goto L4
    }
}
