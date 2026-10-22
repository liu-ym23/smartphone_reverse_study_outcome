package com.larus.avlink;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class l0 {
    public static final ExecutorService a = null;

    static {
        a = PThreadExecutorsUtils.newSingleThreadExecutor(new k0());
    }
}
