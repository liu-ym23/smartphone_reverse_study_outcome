package com.obric.cae.cldReport;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r8, Throwable r10) {
        CldCommon.b(r8, r10);
    }
}
