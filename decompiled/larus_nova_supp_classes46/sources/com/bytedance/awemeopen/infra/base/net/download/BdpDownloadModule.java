package com.bytedance.awemeopen.infra.base.net.download;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.net.AoRequestHelper;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class BdpDownloadModule {
    public static final ConcurrentHashMap<Integer, BdpDownloadTask> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static int a(Context r2, AoDownloadRequest r3, AoDownloadCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        final int r0 = AoRequestHelper.INSTANCE.generateRequestId();
        final BdpDownloadTask r1 = new BdpDownloadTask(r0, r2, r3, r4);
        Integer r5 = Integer.valueOf(r0);
        a.put(r5, r1);
        AoPool.a(new BdpDownloadModule$queue$1(r1, r0));
        return r0;
    }
}
