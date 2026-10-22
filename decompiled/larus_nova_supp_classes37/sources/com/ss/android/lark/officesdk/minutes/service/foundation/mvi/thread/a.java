package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread;

import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final CoreThreadPool a = null;
    public static ExecutorService b;

    static {
        a = CoreThreadPool.getDefault();
    }
}
