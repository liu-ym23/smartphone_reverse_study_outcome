package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCheckTaskRepetitionModule extends AbsDownloadModule {
    public static final Object g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashSet f15307h = null;

    static {
        g = new Object();
        f15307h = new HashSet();
    }

    public DownloadCheckTaskRepetitionModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        if (r5.d.a("fix_task_repetition", 0) > 0) goto L5;
        return null;
    L5:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        int r10 = this.f15290c.l();
        Object r11 = g;
        monitor-enter(r11);
        HashSet r12 = f15307h;     // Catch: Throwable -> L9
        if (r12.contains(Integer.valueOf(r10)) == false) goto L11;
        Logger.a("DownloadCheckTaskRepetitionModule", r10, "proceed", "Repetitive task");     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L11:
        r12.add(Integer.valueOf(r10));     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        r5.c();     // Catch: Throwable -> L21
        monitor-enter(r11);
        r12.remove(Integer.valueOf(r10));     // Catch: Throwable -> L18
        monitor-exit(r11);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        monitor-enter(g);
        f15307h.remove(Integer.valueOf(r10));     // Catch: Throwable -> L27
        throw th;
    L27:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    }
}
