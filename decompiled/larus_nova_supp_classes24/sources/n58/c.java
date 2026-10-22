package n58;

import android.media.AudioRecord;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import com.larus.audio.call.dora.CommandStatus;
import java.io.BufferedInputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements h68.c {
    public final String a;
    public final String b;
    public BufferedInputStream c;
    public long d;
    public long e;
    public long f;
    public AsrDataSourceState g;

    public static final class a {
    }

    static {
    }

    @Override // h68.c
    public final h68.a release() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        BufferedInputStream r2 = this.c;     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        r2.close();     // Catch: Throwable -> L8
    L6:
        this.c = null;     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        this.g = AsrDataSourceState.UNINITIALIZED;
        return new h68.a.b(null);
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // h68.c
    public final int b() {
        return AudioRecord.getMinBufferSize(16000, 16, 2);
    }

    @Override // h68.c
    public final h68.a prepare() {
        int r0 = c68.b.a;
        c68.b.d("HookAsrDataSource", "[ASR][onPrepare]: fileDirPath=" + this.a + ", fileName=" + this.b);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        PolarisFileWrapper r3 = new PolarisFileWrapper(this.a, this.b);     // Catch: Throwable -> L9
        if (r3.exists() == true) goto L7;
        c68.b.b("HookAsrDataSource", "[ASR][onPrepare]: file not found");     // Catch: Throwable -> L9
        return new h68.a.C0110a(-1001, "file not found", null);
    L7:
        this.c = new BufferedInputStream(new PolarisFileInputStreamWrapper(r3));     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L15;
        c68.b.c("HookAsrDataSource", "[ASR][onPrepare]: file open failed", r5);
        return new h68.a.C0110a(-1002, r5.getMessage(), null);
    L15:
        this.g = AsrDataSourceState.INITIALIZED;
        return new h68.a.b(null);
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // h68.c
    public final h68.a stop() {
        this.g = AsrDataSourceState.STOPPED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a start() {
        this.d = System.currentTimeMillis();
        this.g = AsrDataSourceState.STARTED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final AsrDataSourceState a() {
        return this.g;
    }

    @Override // h68.c
    public final h68.a read(byte[] r11) {
        Intrinsics.checkNotNullParameter(r11, "buffer");
        int r1 = c68.b.a;
        c68.b.d("HookAsrDataSource", "[ASR][read]: read(fileDirPath=" + this.a + ", fileName=" + this.b + ")...");
        BufferedInputStream r2 = this.c;
        if (r2 == null) goto L5;
        int r12 = r2.read(r11);     // Catch: Throwable -> L18
        if (r12 == (-1)) goto L9;
    L11:
        if (r12 <= 0) goto L13;
        this.f += (long) r12;     // Catch: Throwable -> L18
    L13:
        long r0 = ((((long) CommandStatus.DORA_TRACE) * this.f) / ((long) 32000)) - (System.currentTimeMillis() - this.d);     // Catch: Throwable -> L18
        if (r0 <= 0) goto L16;
        Thread.sleep(r0);     // Catch: Throwable -> L18
    L16:
        return new h68.a.b(Integer.valueOf(r12));
    L9:
        if (this.e != 0) goto L11;
        this.e = System.currentTimeMillis();     // Catch: Throwable -> L18
        c68.b.d("StartHookOnceService", "readDuration: " + (this.e - this.d) + "ms");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        return new h68.a.C0110a(-1004, th.getMessage(), null);
    L5:
        return new h68.a.C0110a(-1003, "input stream not found", null);
    }

    public c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileDirPath");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        this.a = r2;
        this.b = r3;
        this.g = AsrDataSourceState.UNINITIALIZED;
    }
}
