package com.bytedance.android.live.revenue.platform.stream.impl;

import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import java.io.File;
import java.io.FileFilter;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements CompletableOnSubscribe {
    public final /* synthetic */ StreamCaptureServiceImpl a;

    public static final class a implements FileFilter {
        public final /* synthetic */ File a;

        public a(PolarisFileWrapper r1) {
            this.a = r1;
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r2) {
            if (r2.isDirectory() == true) goto L5;
        L7:
            return false;
        L5:
            if ((!Intrinsics.areEqual(r2, this.a)) == false) goto L7;
            return true;
        }
    }

    public e(StreamCaptureServiceImpl r1) {
        this.a = r1;
    }

    public final void subscribe(CompletableEmitter r8) {
        Intrinsics.checkNotNullParameter(r8, "emitter");
        StreamCaptureServiceImpl r0 = this.a;     // Catch: Throwable -> L10
        r0.getClass();     // Catch: Throwable -> L10
        File[] r1 = this.a.c().listFiles(new a(new PolarisFileWrapper(r0.c(), String.valueOf(Process.myPid()))));     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        int r2 = r1.length;     // Catch: Throwable -> L10
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        File r4 = r1[r3];     // Catch: Throwable -> L10
        jy0.b.a("StreamCaptureService", "cleanStaleBitmapCache: " + r4.getAbsolutePath());     // Catch: Throwable -> L10
        FilesKt.deleteRecursively(r4);     // Catch: Throwable -> L10
        r3 = r3 + 1;     // Catch: Throwable -> L10
    L8:
        r8.onComplete();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        r8.onError(th);
    }
}
