package com.bytedance.bdinstall.dtrait.executor;

import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class ExecutorOptions {
    public ExecutorService ioExecutor;
    public Executor networkExecutor;
    public ExecutorService sDtraitExecutor;
    public ExecutorService sDtraitLoaderExecutor;
    public Looper workLooper;

    public ExecutorOptions() {
    }
}
