package p4a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import com.lynx.animax.util.AnimaXLog;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final c a;
    public final MediaCodec b;
    public boolean c;
    public int d;
    public int e;
    public final MediaCodec.BufferInfo f;

    public final ByteBuffer a() {
        MediaCodec r0 = this.b;
        ByteBuffer r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = r0.dequeueOutputBuffer(this.f, 1000);
        if (r2 < 0) goto L9;
        r1 = this.b.getOutputBuffer(r2);
        this.e = r2;
    L16:
        if ((this.f.flags & 4) == 0) goto L18;
        this.c = true;
    L18:
        return r1;
    L9:
        if (r2 != (-2)) goto L16;
        if (Build.VERSION.SDK_INT < 24) goto L16;
        MediaFormat r3 = this.b.getOutputFormat();
        AnimaXLog.b("AudioAssetDecoder", "decoded audio format: " + r3);
        if (r3.containsKey("pcm-encoding") == false) goto L16;
        this.a.e = r3.getInteger("pcm-encoding");
        goto L16
    }

    public a(c r4) {
        this.c = false;
        this.d = -1;
        this.e = -1;
        this.f = new MediaCodec.BufferInfo();
        this.a = r4;
        MediaFormat r5 = r4.a;
        if (r5 != null) goto L5;
        return;
    L5:
        String r1 = r5.getString("mime");
        if (r1 != null) goto L13;
        return;
    L13:
        MediaCodec r2 = MediaCodec.createDecoderByType(r1);     // Catch: Exception -> L10
        this.b = r2;     // Catch: Exception -> L10
        r2.configure(r5, null, null, 0);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        AnimaXLog.a("AudioAssetDecoder", "Failed to init audio asset decoder: " + e.getMessage());
    }
}
