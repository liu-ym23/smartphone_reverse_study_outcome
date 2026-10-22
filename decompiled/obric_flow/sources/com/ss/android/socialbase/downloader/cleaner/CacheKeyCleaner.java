package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CacheKeyCleaner implements CleanerImpl.CleanerHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CleanerImpl f15210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CleanerConfig f15211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f15212c;

    public CacheKeyCleaner(CleanerImpl r5, CleanerConfig r10) {
        this.f15210a = r5;
        this.f15211b = r10;
        this.f15212c = r10.f15227c;
    }

    public final void a() {
        Iterator r5 = this.f15212c.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L41;
        Map.Entry r10 = (Map.Entry) r5.next();
        int r11 = ((Integer) r10.getKey()).intValue();
        Iterator r12 = ((List) r10.getValue()).iterator();
    L7:
        if (r12.hasNext() == false) goto L31;
        if (this.f15210a.f15238b == true) goto L11;
        Integer r13 = (Integer) r12.next();
        int r14 = r13.intValue();
        if (this.f15211b.a(r14) == false) goto L17;
        String r15 = (String) this.f15211b.f15228h.get(r13);
        String r16 = (String) this.f15211b.f15229i.get(r13);
        String r17 = (String) this.f15211b.f15230j.get(r13);
        char[] r18 = DownloadUtils.f16142a;
        String r19 = r16 + ".tp";
        DownloadUtils.b(r15, r16);
        if (r17 == null) goto L24;
        r15 = r17;
    L24:
        DownloadUtils.b(r15, r19);
        if (this.f15211b.f15231k.contains(r13) == true) goto L28;
        ((DefaultDownloadCache) DownloadComponentManager.h()).d(r14);
    L28:
        if (Logger.b() == false) goto L30;
        Logger.b("CacheKeyCleaner", "startImpl", "clean cache downloadId=" + r14);
    L30:
        r12.remove();
        this.f15211b.b(r14);
        goto L7
    L17:
        if (Logger.b() == false) goto L19;
        Logger.b("CacheKeyCleaner", "startImpl", "dwg888Find in visit history,can't do clean,downloadId=" + r14);
    L19:
        r12.remove();
        goto L7
    L11:
        if (Logger.b() == false) goto L32;
        Logger.b("CacheKeyCleaner", "startImpl", "stop cleaning");
        return;
    L32:
        return;
    L31:
        r5.remove();
        this.f15211b.c(r11);
        goto L4
    }

    @Override // com.ss.android.socialbase.downloader.cleaner.CleanerImpl.CleanerHandler
    public final void start() {
        if (Logger.b() == false) goto L21;
        Logger.b("CacheKeyCleaner", "start", "Run");
    L21:
        a();     // Catch: Throwable -> L10
        if (Logger.b() == false) goto L25;
        Logger.b("CacheKeyCleaner", "start", "Run End");
        return;
    L25:
        return;
    L10:
        th = move-exception;
        Logger.c("CacheKeyCleaner", "start", "Error:" + th);     // Catch: Throwable -> L16
        if (Logger.b() == false) goto L26;
        Logger.b("CacheKeyCleaner", "start", "Run End");
        return;
    L26:
        return;
    L16:
        th = move-exception;
        if (Logger.b() == false) goto L20;
        Logger.b("CacheKeyCleaner", "start", "Run End");
    L20:
        throw th;
    }
}
