package com.bytedance.android.live.core.utils;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v0 {
    public static final v0 e = null;
    public final ExecutorService a;
    public final List<String> b;
    public final Object c;
    public Boolean d;

    static {
        e = new v0();
    }

    public v0() {
        this.c = new Object();
        this.d = null;
        this.a = PThreadExecutorsUtils.newFixedThreadPool(1, new DefaultThreadFactory("ImageMonitorHelper"));
        this.b = new LinkedList();
    }
}
