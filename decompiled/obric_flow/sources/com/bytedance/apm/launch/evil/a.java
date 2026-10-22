package com.bytedance.apm.launch.evil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f3895a = null;

    static {
        f3895a = Executors.newSingleThreadExecutor(new com.bumptech.glide.load.engine.a(1));
    }
}
