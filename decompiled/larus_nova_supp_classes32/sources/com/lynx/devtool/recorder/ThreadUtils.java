package com.lynx.devtool.recorder;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ThreadUtils {
    private static final ExecutorService sThreadPool = null;

    public ThreadUtils() {
    }

    static {
        sThreadPool = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("r/ThreadUtils"));
    }

    public static ExecutorService getThreadPool() {
        return sThreadPool;
    }
}
