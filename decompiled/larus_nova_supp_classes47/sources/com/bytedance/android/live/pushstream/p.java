package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<V> implements Callable {
    public final /* synthetic */ File a;

    public p(PolarisFileWrapper r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        if (this.a.exists() == true) goto L25;
        this.a.createNewFile();
        InputStream r0 = jc1.a.b().getApplicationContext().getAssets().open("audio_metrics_v1.3.model");
        PolarisFileOutputStreamWrapper r2 = new PolarisFileOutputStreamWrapper(this.a);     // Catch: Throwable -> L20
        byte[] r1 = new byte[1024];     // Catch: Throwable -> L15
        int r3 = r0.read(r1);     // Catch: Throwable -> L15
    L9:
        if (r3 == (-1)) goto L11;
        r2.write(r1, 0, r3);     // Catch: Throwable -> L15
        r3 = r0.read(r1);     // Catch: Throwable -> L15
        goto L9
    L11:
        r2.flush();     // Catch: Throwable -> L15
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r0, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    L25:
        ALogger.d("AudioSamiDiagnosisImpl", "createLiveStream: file.exists(): " + this.a.exists() + "file size: " + this.a.length());
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
