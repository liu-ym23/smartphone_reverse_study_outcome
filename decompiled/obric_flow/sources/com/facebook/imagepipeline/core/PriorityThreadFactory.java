package com.facebook.imagepipeline.core;

import androidx.room.writer.DaoWriter;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class PriorityThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8118c;
    public final AtomicInteger d;

    public PriorityThreadFactory(String r5) {
        this.d = new AtomicInteger(1);
        this.f8116a = 10;
        this.f8117b = r5;
        this.f8118c = true;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable r5) {
        Runnable r10 = new AnonymousClass1(this, r5);
        if (this.f8118c == false) goto L5;
        String r11 = this.f8117b + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + this.d.getAndIncrement();
    L7:
        return new Thread(r10, r11);
    L5:
        r11 = this.f8117b;
        goto L7
    }
}
