package oo1;

import android.media.MediaCodec;
import android.media.MediaMuxer;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends PthreadThreadV2 {
    public MediaCodec v;
    public final MediaCodec.BufferInfo w;
    public MediaMuxer x;
    public volatile boolean y;
    public final d.a z;

    public final void l() {
        super.run();
        this.y = false;
        this.v.start();     // Catch: Exception -> L54
    L5:
        if (this.y == false) goto L20;
        MediaCodec r2 = this.v;
        if (r2 != null) goto L9;
    L11:
        this.v = null;
        e.e.set(true);
        if (e.d.get() == false) goto L20;
        MediaMuxer r3 = this.x;
        if (r3 != null) goto L64;
    L19:
        this.x = null;
        this.z.d(2);
    L22:
        this.z.c("VideoCodecThread", "", 0);
        return;
    L64:
        r3.stop();     // Catch: Exception -> L17
        this.x.release();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ALogger.e("VideoCodecThread", e.getMessage());
        goto L19
    L9:
        if ((this.w.flags & 4) == 0) goto L11;
        r2.stop();
        this.v.release();
    L20:
        MediaCodec r4 = this.v;
        if (r4 == null) goto L22;
        int r5 = r4.dequeueOutputBuffer(this.w, 0);     // Catch: Exception -> L53
        ALogger.d("VideoCodecThread", "outputBufferIndex : " + r5);
        if (r5 != (-2)) goto L32;
        MediaMuxer r6 = this.x;
        if (r6 == null) goto L32;
        e.b.c(r6.addTrack(this.v.getOutputFormat()));
        if (e.a.b() < 0) goto L5;
        ALogger.d("VideoCodecThread", "start MediaMuxer");
        this.x.start();
        e.c.set(true);
        this.z.d(1);
    L32:
        if (r5 < 0) goto L5;
        if (this.y == true) goto L5;
        if (e.c.get() == false) goto L37;
        ByteBuffer r7 = this.v.getOutputBuffers()[r5];
        r7.position(this.w.offset);
        MediaCodec.BufferInfo r8 = this.w;
        r7.limit(r8.offset + r8.size);
        this.w.presentationTimeUs = e.g.get();
    L45:
        e = move-exception;
        ALogger.e("VideoCodecThread", e.getMessage());
    L47:
        this.z.b((int) (this.w.presentationTimeUs / 1000000));
        this.v.releaseOutputBuffer(r5, false);
        ALogger.d("VideoCodecThread", "releaseOutputBuffer");
        r5 = this.v.dequeueOutputBuffer(this.w, 0);     // Catch: Exception -> L50
    L50:
        e = move-exception;
        throw new RuntimeException(e);
    L40:
        if (this.y == true) goto L47;
        MediaMuxer r9 = this.x;     // Catch: Exception -> L45
        if (r9 == null) goto L47;
        r9.writeSampleData(e.b.b(), r7, this.w);     // Catch: Exception -> L45
        goto L47
    L37:
        SystemClock.sleep(10);
    L54:
        this.z.c("VideoCodecThread", "videoCodec start failed", -1);
    }

    public final void run() {
        l();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(MediaCodec r2, MediaCodec.BufferInfo r3, MediaMuxer r4, f.a r5) {
        super("VideoCodecThread");
        this.v = r2;
        this.w = r3;
        this.x = r4;
        this.z = r5;
        e.b.c(-1);
    }
}
