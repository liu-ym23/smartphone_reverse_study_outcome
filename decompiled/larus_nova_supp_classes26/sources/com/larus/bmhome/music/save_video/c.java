package com.larus.bmhome.music.save_video;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements b {
    public final long a;
    public final MediaMuxer b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public long g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final void release() {
        this.b.stop();
        this.b.release();
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final long d() {
        return this.g;
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final boolean isStarted() {
        return this.c;
    }

    public c(String r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, MusicAppletPage.KEY_PATH);
        this.a = (long) (TimeUnit.SECONDS.toMicros(1) / r5);
        this.b = new MediaMuxer(r4, 0);
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final void a(ByteBuffer r3, MediaCodec.BufferInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "encodedData");
        Intrinsics.checkNotNullParameter(r4, "audioBufferInfo");
        this.b.writeSampleData(this.e, r3, r4);
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final void b(ByteBuffer r5, MediaCodec.BufferInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "encodedData");
        Intrinsics.checkNotNullParameter(r6, "bufferInfo");
        long r0 = this.a;
        int r2 = this.f;
        this.f = r2 + 1;
        long r1 = r0 * ((long) r2);
        this.g = r1;
        r6.presentationTimeUs = r1;
        this.b.writeSampleData(this.d, r5, r6);
    }

    @Override // com.larus.bmhome.music.save_video.b
    public final void c(MediaFormat r2, MediaExtractor r3) {
        Intrinsics.checkNotNullParameter(r2, "videoFormat");
        if (r3 == null) goto L5;
        r3.selectTrack(0);
    L5:
        if (r3 == null) goto L7;
        MediaFormat r4 = r3.getTrackFormat(0);
    L8:
        this.d = this.b.addTrack(r2);
        if (r4 == null) goto L11;
        this.e = this.b.addTrack(r4);
        r4.toString();
    L11:
        r2.toString();
        this.b.start();
        this.c = true;
        return;
    L7:
        r4 = null;
        goto L8
    }
}
