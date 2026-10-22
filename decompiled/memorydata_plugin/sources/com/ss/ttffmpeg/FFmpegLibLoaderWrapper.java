package com.ss.ttffmpeg;

/* JADX INFO: loaded from: classes6.dex */
public final class FFmpegLibLoaderWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f15776a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f15777b = null;
    private static volatile b c = null;
    private static boolean d = false;

    static {
    }

    public FFmpegLibLoaderWrapper() {
    }

    public static synchronized String getFFmpegVersion() {
        monitor-enter(FFmpegLibLoaderWrapper.class);
        monitor-exit(FFmpegLibLoaderWrapper.class);
        return BuildConfig.VERSION_NAME;
    }
}
