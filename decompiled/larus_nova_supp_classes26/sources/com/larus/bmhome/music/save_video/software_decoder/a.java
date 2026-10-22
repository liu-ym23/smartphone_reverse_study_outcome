package com.larus.bmhome.music.save_video.software_decoder;

import android.media.MediaExtractor;
import android.media.MediaMuxer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static int a;
    public static int b;

    static {
    }

    public a() {
    }

    public static final void a(MediaExtractor r0, MediaExtractor r1, MediaMuxer r2) {
        if (r2 != null) goto L11;
    L4:
        if (r2 == null) goto L6;
        r2.release();     // Catch: Exception -> L10
    L6:
        r0.release();     // Catch: Exception -> L10
        if (r1 == null) goto L13;
        r1.release();     // Catch: Exception -> L10
        return;
    L14:
        return;
    L13:
        return;
    L11:
        r2.stop();     // Catch: Exception -> L10
        goto L4
    }
}
