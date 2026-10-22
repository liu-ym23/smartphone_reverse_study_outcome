package com.ss.android.socialbase.downloader.thread;

import androidx.room.writer.DaoWriter;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f16112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16113c;

    public DefaultThreadFactory(String r5) {
        this.f16112b = new AtomicInteger();
        this.f16111a = r5;
        this.f16113c = true;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        Thread r10 = new Thread(r5, this.f16111a + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + this.f16112b.incrementAndGet());
        if (this.f16113c == false) goto L5;
    L10:
        return r10;
    L5:
        if (r10.isDaemon() == false) goto L8;
        r10.setDaemon(false);
    L8:
        if (r10.getPriority() == 5) goto L10;
        r10.setPriority(5);
        goto L10
    }
}
