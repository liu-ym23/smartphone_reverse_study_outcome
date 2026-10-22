package com.obric.assistant.upload.internal;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, Exception r4) {
        Intrinsics.checkNotNullParameter("ObricUploadImageCompress", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "e");
        FLogger.a.e("ObricUpload_ObricUploadImageCompress", "thread[name: " + ThreadMethodProxy.currentThread().getName() + "] -- " + r3, r4);
    }

    public static void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.e("ObricUpload_".concat(r3), "thread[name: " + ThreadMethodProxy.currentThread().getName() + "] -- " + r4);
    }

    public static void c(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.i("ObricUpload_".concat(r3), "thread[name: " + ThreadMethodProxy.currentThread().getName() + "] -- " + r4);
    }
}
