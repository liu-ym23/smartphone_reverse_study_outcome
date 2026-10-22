package com.bytedance.android.live.revenue.platform.stream.impl;

import android.graphics.Bitmap;
import android.os.Process;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Completable;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.UUID;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements SingleOnSubscribe {
    public final /* synthetic */ StreamCaptureServiceImpl a;
    public final /* synthetic */ StreamCaptureServiceImpl.b b;
    public final /* synthetic */ Bitmap c;

    public g(StreamCaptureServiceImpl r1, StreamCaptureServiceImpl.b r2, Bitmap r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<File> r8) {
        Intrinsics.checkNotNullParameter(r8, "emitter");
        StreamCaptureServiceImpl r0 = this.a;     // Catch: Throwable -> L24
        r0.getClass();     // Catch: Throwable -> L24
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0.c(), String.valueOf(Process.myPid()));     // Catch: Throwable -> L24
        r1.mkdirs();     // Catch: Throwable -> L24
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L24
        r2.append(UUID.randomUUID());     // Catch: Throwable -> L24
        StreamCaptureServiceImpl r3 = this.a;     // Catch: Throwable -> L24
        Bitmap.CompressFormat r4 = this.b.a;     // Catch: Throwable -> L24
        r3.getClass();     // Catch: Throwable -> L24
        int r5 = c.a[r4.ordinal()];     // Catch: Throwable -> L24
        if (r5 != 1) goto L6;
        String r6 = ".jpg";
    L11:
        r2.append(r6);     // Catch: Throwable -> L24
        PolarisFileWrapper r7 = new PolarisFileWrapper(r1, r2.toString());     // Catch: Throwable -> L24
        PolarisFileOutputStreamWrapper r9 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L24
        Bitmap r10 = this.c;     // Catch: Throwable -> L19
        StreamCaptureServiceImpl.b r12 = this.b;     // Catch: Throwable -> L19
        r10.compress(r12.a, r12.b, r9);     // Catch: Throwable -> L19
        r9.flush();     // Catch: Throwable -> L19
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L14:
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L24
        StreamCaptureServiceImpl r14 = this.a;     // Catch: Throwable -> L24
        if (r14.a == true) goto L17;
        r14.a = true;     // Catch: Throwable -> L24
        RxUtilKt.s(Completable.create(new e(r14)).subscribeOn(Schedulers.io()));     // Catch: Throwable -> L24
    L17:
        r8.onSuccess(r7);     // Catch: Throwable -> L24
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L6:
        if (r5 != 2) goto L9;
        r6 = ".png";
        goto L11
    L9:
        throw new IllegalArgumentException("Unsupported compress format: " + r4);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r8.onError(th);
    }
}
