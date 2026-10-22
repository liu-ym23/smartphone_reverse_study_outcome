package com.facebook.imagepipeline.systrace;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FrescoSystrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile DefaultFrescoSystrace f8445a;

    public interface Systrace {
    }

    public static Systrace a() {
        if (f8445a != null) goto L16;
        monitor-enter(FrescoSystrace.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f8445a != null) goto L11;
        f8445a = new DefaultFrescoSystrace();     // Catch: Throwable -> L9
    L11:
        monitor-exit(FrescoSystrace.class);     // Catch: Throwable -> L9
    L16:
        return f8445a;
    }
}
