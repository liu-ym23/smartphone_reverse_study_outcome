package com.larus.audioplayer.impl.stream;

import android.media.AudioTrack;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u extends AudioTrack {
    public final boolean a;
    public volatile boolean b;
    public final Object c;

    public static final class a {
    }

    static {
    }

    @Override // android.media.AudioTrack
    public final void release() {
        if (this.a == false) goto L12;
        Object r0 = this.c;
        monitor-enter(r0);
        this.b = true;     // Catch: Throwable -> L9
        super.release();     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        this.b = true;
        super.release();
    }

    @Override // android.media.AudioTrack
    public final int write(byte[] r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "audioData");
        boolean r0 = this.a;
        if (r0 == false) goto L20;
        Object r1 = this.c;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.a == false) goto L9;
        boolean r2 = this.b;     // Catch: Throwable -> L17
    L10:
        if (r2 == false) goto L14;
        FLogger.a.e("SafeAudioTrack", "write() called after release()");     // Catch: Throwable -> L17
        monitor-exit(r1);
        return 0;
    L14:
        int r7 = super.write(r4, r5, r6);     // Catch: Throwable -> L17
        monitor-exit(r1);
        return r7;
    L9:
        r2 = false;
        goto L10
    L20:
        if (r0 == false) goto L22;
        boolean r3 = this.b;
    L23:
        if (r3 == false) goto L27;
        FLogger.a.e("SafeAudioTrack", "write() called after release()");
        return 0;
    L27:
        return super.write(r4, r5, r6);
    L22:
        r3 = false;
        goto L23
    }

    public u(int r8, int r9, int r10, int r11) {
        super(3, r8, r9, r10, r11, 1);
        this.a = z2.a.s1();
        this.c = new Object();
    }
}
