package com.larus.asr.task;

import com.larus.audio.audiov3.task.asr.AsrDataSourceState;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements h68.c {
    public volatile AsrDataSourceState a;

    /* JADX INFO: renamed from: com.larus.asr.task.a$a, reason: collision with other inner class name */
    public static final class C0069a {
    }

    static {
    }

    @Override // h68.c
    public final int b() {
        return 3200;
    }

    @Override // h68.c
    public final h68.a prepare() {
        this.a = AsrDataSourceState.INITIALIZED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a release() {
        this.a = AsrDataSourceState.UNINITIALIZED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a start() {
        this.a = AsrDataSourceState.STARTED;
        return new h68.a.b(null);
    }

    @Override // h68.c
    public final h68.a stop() {
        this.a = AsrDataSourceState.STOPPED;
        return new h68.a.b(null);
    }

    public a() {
        this.a = AsrDataSourceState.UNINITIALIZED;
    }

    @Override // h68.c
    public final AsrDataSourceState a() {
        return this.a;
    }

    @Override // h68.c
    public final h68.a read(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "buffer");
        if (this.a != AsrDataSourceState.STARTED) goto L9;
        Thread.sleep(50);     // Catch: InterruptedException -> L7
    L7:
        ThreadMethodProxy.currentThread().interrupt();
    L9:
        return new h68.a.b(0);
    }
}
