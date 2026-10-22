package oo1;

import android.graphics.Paint;
import android.media.MediaCodec;
import android.media.MediaMuxer;
import android.view.Surface;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public Surface a;
    public MediaMuxer b;
    public MediaCodec c;
    public MediaCodec.BufferInfo d;
    public MediaCodec e;
    public MediaCodec.BufferInfo f;
    public final Paint g;
    public int h;
    public int i;
    public int j;
    public long k;
    public oo1.a l;
    public h m;

    public interface a {
        void b(int r1);

        void c(String r1, String r2, int r3);

        void d(int r1);
    }

    public final void a() {
        AtomicBoolean r0 = e.e;
        r0.set(true);
        AtomicBoolean r2 = e.d;
        r2.set(true);
        oo1.a r3 = this.l;
        if (r3 == null) goto L5;
        r2.set(true);
        r3.y = true;
    L5:
        h r4 = this.m;
        if (r4 == null) goto L8;
        r0.set(true);
        r4.y = true;
    L8:
        this.l = null;
        this.m = null;
    }

    public d() {
        this.g = new Paint();
    }
}
