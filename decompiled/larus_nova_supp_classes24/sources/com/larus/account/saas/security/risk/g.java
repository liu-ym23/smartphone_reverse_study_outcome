package com.larus.account.saas.security.risk;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g {
    public final i a;
    public final h b;
    public final ExecutorService c;
    public final Handler d;
    public final AtomicBoolean e;

    public static final class a {
    }

    static {
    }

    public g(i r4, h r5) {
        ExecutorService r0 = PThreadExecutorsUtils.newSingleThreadExecutor(new b());
        Handler r1 = com.larus.account.saas.runtime.internal.util.b.a;
        Intrinsics.checkNotNullParameter(r4, "repository");
        Intrinsics.checkNotNullParameter(r5, "reporter");
        Intrinsics.checkNotNullParameter(r0, "executor");
        Intrinsics.checkNotNullParameter(r1, "mainHandler");
        this.a = r4;
        this.b = r5;
        this.c = r0;
        this.d = r1;
        this.e = new AtomicBoolean(false);
    }
}
