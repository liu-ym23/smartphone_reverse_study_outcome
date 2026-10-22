package com.bytedance;

import android.media.AudioTrack;
import com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends AudioTrack {
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
    public final int write(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "audioData");
        boolean r0 = this.a;
        if (r0 == false) goto L20;
        Object r1 = this.c;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.a == false) goto L9;
        boolean r13 = this.b;     // Catch: Throwable -> L17
    L10:
        if (r13 == false) goto L14;
        lp7.a.b("SafeAudioTrack", "write() called after release()");     // Catch: Throwable -> L17
        monitor-exit(r1);
        return 0;
    L14:
        int r14 = super.write(r10, r11, r12);     // Catch: Throwable -> L17
        monitor-exit(r1);
        return r14;
    L9:
        r13 = false;
        goto L10
    L20:
        if (r0 == false) goto L22;
        boolean r15 = this.b;
    L23:
        if (r15 == false) goto L27;
        lp7.a.b("SafeAudioTrack", "write() called after release()");
        return 0;
    L27:
        return super.write(r10, r11, r12);
    L22:
        r15 = false;
        goto L23
    }

    public b(int r10, int r11, int r12, int r13) {
        super(3, r10, r11, r12, r13, 1);
        IKMPAppInfoProvider r14 = xw5.a.a;
        if (r14 == null) goto L7;
        boolean r15 = true;
        if (r14.useSafeAudioTrackEnable() != true) goto L7;
    L8:
        this.a = r15;
        this.c = new Object();
        return;
    L7:
        r15 = false;
        goto L8
    }
}
