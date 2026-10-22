package com.bytedance.badger.collect.impl.model;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class ExecutorOptions {
    public ExecutorService ioExecutor;
    public Looper looper;
    public ExecutorService networkExecutor;

    public ExecutorOptions() {
    }
}
