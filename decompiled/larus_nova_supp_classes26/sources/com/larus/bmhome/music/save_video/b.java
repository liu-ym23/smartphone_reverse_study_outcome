package com.larus.bmhome.music.save_video;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface b {
    void a(ByteBuffer r1, MediaCodec.BufferInfo r2);

    void b(ByteBuffer r1, MediaCodec.BufferInfo r2);

    void c(MediaFormat r1, MediaExtractor r2);

    long d();

    boolean isStarted();

    void release();
}
