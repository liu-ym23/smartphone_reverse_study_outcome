package oo1;

import android.media.MediaCodec;
import android.media.MediaMuxer;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends PthreadThreadV2 {
    public final d.a A;
    public MediaCodec v;
    public final MediaCodec.BufferInfo w;
    public MediaMuxer x;
    public volatile boolean y;
    public long z;

    public final void l() {
        super.run();
        this.y = false;
        this.v.start();     // Catch: Exception -> L55
    L5:
        if (this.y == false) goto L20;
        ALogger.d("AudioCodecThread", "准备停止mediaMuxer");
        MediaCodec r2 = this.v;
        if (r2 != null) goto L9;
    L11:
        this.v = null;
        e.d.set(true);
        if (e.e.get() == false) goto L20;
        MediaMuxer r3 = this.x;
        if (r3 != null) goto L59;
    L19:
        this.x = null;
        this.A.d(2);
    L22:
        this.A.c("AudioCodecThread", "", 0);
        return;
    L59:
        r3.stop();     // Catch: Exception -> L17
        this.x.release();     // Catch: Exception -> L17
        ALogger.d("AudioCodecThread", "停止mediaMuxer");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ALogger.e("AudioCodecThread", e.getMessage());
        goto L19
    L9:
        if ((this.w.flags & 4) == 0) goto L11;
        r2.stop();
        this.v.release();
    L20:
        MediaCodec r4 = this.v;
        if (r4 == null) goto L22;
        int r5 = r4.dequeueOutputBuffer(this.w, 0);     // Catch: Exception -> L54
        ALogger.d("AudioCodecThread", "outputBufferIndex : " + r5);
        if (r5 != (-2)) goto L32;
        MediaMuxer r6 = this.x;
        if (r6 == null) goto L32;
        e.a.c(r6.addTrack(this.v.getOutputFormat()));
        if (e.b.b() < 0) goto L5;
        ALogger.d("AudioCodecThread", "start MediaMuxer");
        this.x.start();
        e.c.set(true);
        this.A.d(1);
    L32:
        if (r5 < 0) goto L5;
        if (this.y == true) goto L5;
        if (e.c.get() == false) goto L37;
        ALogger.d("AudioCodecThread", "尝试写入数据");
        ByteBuffer r7 = this.v.getOutputBuffers()[r5];
        r7.position(this.w.offset);
        MediaCodec.BufferInfo r8 = this.w;
        r7.limit(r8.offset + r8.size);
        if (this.z != 0) goto L41;
        this.z = this.w.presentationTimeUs;
    L41:
        MediaCodec.BufferInfo r9 = this.w;
        long r10 = r9.presentationTimeUs - this.z;
        r9.presentationTimeUs = r10;
        e.g.set(r10);
    L46:
        e = move-exception;
        ALogger.e("AudioCodecThread", e.getMessage());
    L48:
        this.v.releaseOutputBuffer(r5, false);
        ALogger.d("AudioCodecThread", "releaseOutputBuffer");
        r5 = this.v.dequeueOutputBuffer(this.w, 0);     // Catch: Exception -> L51
        ALogger.d("AudioCodecThread", "outputBufferIndex : " + r5);
    L51:
        e = move-exception;
        throw new RuntimeException(e);
    L43:
        if (this.y == true) goto L48;
        this.x.writeSampleData(e.a.b(), r7, this.w);     // Catch: Exception -> L46
        goto L48
    L37:
        ALogger.d("AudioCodecThread", "run: 线程延迟");
        SystemClock.sleep(10);
    L55:
        this.A.c("AudioCodecThread", "audioCodec start Fail", -1);
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

    public a(MediaCodec r2, MediaCodec.BufferInfo r3, MediaMuxer r4, f.a r5) {
        super("AudioCodecThread");
        this.v = r2;
        this.w = r3;
        this.x = r4;
        this.A = r5;
        this.z = 0;
        e.g.set(0);
        e.a.c(-1);
    }
}
