package com.ss.android.socialbase.downloader.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class g extends com.ss.android.socialbase.downloader.b.a {
    private static Object g;
    private static Set h;

    static {
        g = new Object();
        h = new HashSet();
    }

    public g() {
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public com.ss.android.socialbase.downloader.b.e a(i r3) {
        if (r3.d.b("fix_task_repetition") > 0) goto L5;
        return null;
    L5:
        return super.a(r3);
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r4) {
        com.ss.android.socialbase.downloader.b.f r5 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r4, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        int r3 = this.c.getId();
        Object r0 = g;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (h.contains(Integer.valueOf(r3)) == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.b("DownloadCheckTaskRepetitionModule", r3, "proceed", "Repetitive task");     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L9:
        h.add(Integer.valueOf(r3));     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        r5.a();     // Catch: Throwable -> L20
        Object r6 = g;
        monitor-enter(r6);
        h.remove(Integer.valueOf(r3));     // Catch: Throwable -> L17
        monitor-exit(r6);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        th = move-exception;
        monitor-enter(g);
        h.remove(Integer.valueOf(r3));     // Catch: Throwable -> L26
        throw th;
    L26:
        th = move-exception;
        throw th;
    }
}
