package com.lynx.animax.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.google.common.reflect.w;
import com.lynx.animax.util.AnimaXLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaCodec f9645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9647c;
    public boolean d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f9652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public i f9653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public VideoAsset f9654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Surface f9655o;

    public final void a() {
        VideoAsset r5 = this.f9654n;
        if (r5 == null) goto L78;
        d r10 = r5.f9642b;
        if (r10 != null) goto L8;
        MediaFormat r11 = null;
    L9:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "CodecManager", "initDecoder, format: " + r11);
        String r12 = r11.getString("mime");
        if (r12 == null) goto L101;
        int r13 = MediaCodecList.getCodecCount();
    L13:
        int r14 = this.f9651k;
        if (r14 >= r13) goto L81;
        this.f9651k = r14 + 1;
        MediaCodecInfo r15 = MediaCodecList.getCodecInfoAt(r14);
        if (r15.isEncoder() == true) goto L13;
        String[] r16 = r15.getSupportedTypes();
        if (r16 != null) goto L20;
        int r17 = 0;
    L21:
        int r18 = 0;
    L22:
        if (r18 >= r17) goto L13;
        if (r12.equals(r16[r18]) == true) goto L25;
        r18 = r18 + 1;
        goto L22
    L25:
        String r19 = r15.getName();
        if (r19 == null) goto L13;
        String r20 = "try decoder: ".concat(r19);
        AnimaXLog.LogLevel r21 = AnimaXLog.LogLevel.f9713a;
        AnimaXLog.a(r21, "CodecManager", r20);
        if (this.f9654n != null) goto L85;
        am.e r22 = new am.e("tryInitDecoder error: mAsset is null");
    L75:
        if (r22.f324a == true) goto L77;
        StringBuilder r23 = com.lynx.tasm.utils.e.b("[", r19, "]: ");
        r23.append(r22.f325b);
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "CodecManager", r23.toString());
    L77:
        if (c() == true) goto L77;
        return;
    L85:
        this.f9645a = MediaCodec.createByCodecName(r19);     // Catch: Throwable -> L33 MediaCodec.CodecException -> L35
        String r24 = null;
    L39:
        am.e r25 = new am.e(r24);
        if (r25.f324a == true) goto L42;
        r22 = r25;
        goto L75
    L42:
        d r26 = this.f9654n.f9642b;
        if (r26 != null) goto L45;
        MediaFormat r27 = null;
    L87:
        this.f9645a.configure(r27, this.f9655o, null, 0);     // Catch: Throwable -> L49 MediaCodec.CryptoException -> L51 MediaCodec.CodecException -> L53
        String r28 = null;
    L58:
        am.e r29 = new am.e(r28);
        if (r29.f324a == true) goto L83;
        this.f9645a.release();
        this.f9645a = null;
    L61:
        r22 = r29;
        goto L75
    L83:
        this.f9645a.start();     // Catch: Throwable -> L64 MediaCodec.CodecException -> L66
        String r30 = null;
    L70:
        r29 = new am.e(r30);
        if (r29.f324a == true) goto L73;
        this.f9645a.release();
        this.f9645a = null;
        goto L61
    L73:
        this.f9646b = r19;
        this.f9647c = true;
        AnimaXLog.a(r21, "CodecManager", "chosen decoder: ".concat(r19));
        r22 = new am.e();
        goto L75
    L66:
        e = move-exception;
        r30 = "startDecoder CodecException: " + e.getMessage();
    L64:
        e = move-exception;
        r30 = "startDecoder Exception: " + e.getMessage();
        goto L70
    L53:
        e = move-exception;
        r28 = "configureCodec CodecException: " + e.getMessage();
    L51:
        e = move-exception;
        r28 = "configureCodec CryptoException: " + e.getMessage();
    L49:
        e = move-exception;
        r28 = "configureCodec Exception: " + e.getMessage();
        goto L58
    L45:
        r27 = r26.f9662a;
        goto L87
    L35:
        e = move-exception;
        r24 = "createByCodecName CodecException: " + e.getMessage();
    L33:
        e = move-exception;
        r24 = androidx.room.jarjarred.org.antlr.runtime.a.o(e, new StringBuilder("createByCodecName Exception: "));
        goto L39
    L20:
        r17 = r16.length;
        goto L21
    L81:
        b("initDecoder error");
        return;
    L101:
        return;
    L8:
        r11 = r10.f9662a;
        goto L9
    }

    public final void b(String r5) {
        i r10 = this.f9653m;
        if (r10 == null) goto L14;
        ab.b r11 = new ab.b(20, r10, false, r5);
        Handler r12 = r10.f9682n;
        if (r12 != null) goto L7;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoPlayerImpl", "Attempted to post to GL thread after it was released or not alive.");
        return;
    L7:
        if (Looper.myLooper() != r12.getLooper()) goto L10;
        r11.run();
        return;
    L10:
        r12.post(r11);
        return;
    }

    public final boolean c() {
        boolean r5 = false;
        if (this.f9647c == false) goto L79;
        VideoAsset r10 = this.f9654n;
        if (r10 == null) goto L79;
        if (this.f9648h < this.f9649i) goto L10;
        return false;
    L10:
        int r11 = this.f;
        w r12 = r10.d;
        String r13 = null;
        if (r12 == null) goto L19;
        ArrayList r14 = (ArrayList) r12.d;
        if (r11 < 0) goto L19;
        if (r11 >= r14.size()) goto L19;
        c r15 = (c) r14.get(r11);
    L20:
        VideoAsset r16 = this.f9654n;
        if (r15 == null) goto L29;
        w r17 = r16.d;
        if (r17 == null) goto L30;
        ByteBuffer r18 = (ByteBuffer) r17.f9377c;
        if (r18 == null) goto L30;
        r18.position(0);
        r18.limit(r15.f9660b);
        r18.position(r15.f9659a);
        ByteBuffer r19 = r18;
    L31:
        if (r19 != null) goto L80;
        return false;
    L80:
        int r20 = this.f9645a.dequeueInputBuffer(this.f9652l);     // Catch: IllegalStateException -> L36 MediaCodec.CodecException -> L38
    L43:
        if (r20 >= 0) goto L82;
    L44:
        int r110 = -1;
    L57:
        if (r110 >= 0) goto L84;
        return false;
    L84:
        this.f9645a.queueInputBuffer(r110, 0, r15.f9660b - r15.f9659a, r15.f9661c, 0);     // Catch: IllegalStateException -> L62 MediaCodec.CodecException -> L64 MediaCodec.CryptoException -> L66
    L71:
        if (r13 == null) goto L73;
        b(r13);
    L74:
        if (r5 == false) goto L79;
        this.f9648h++;
        if ((-1) != this.g) goto L78;
        this.g = this.f;
    L78:
        this.f = (this.f + 1) % this.f9654n.getFrameCount();
        goto L79
    L73:
        r5 = true;
        goto L74
    L64:
        e = move-exception;
        r13 = "[" + this.f9646b + "]: queueInputBuffer CodecException: " + e.getMessage();
    L66:
        e = move-exception;
        r13 = "[" + this.f9646b + "]: queueInputBuffer CryptoException: " + e.getMessage();
    L62:
        e = move-exception;
        r13 = "[" + this.f9646b + "]: queueInputBuffer IllegalStateException: " + e.getMessage();
        goto L71
    L82:
        ByteBuffer r21 = this.f9645a.getInputBuffer(r20);     // Catch: IllegalStateException -> L47 MediaCodec.CodecException -> L49
    L54:
        if (r21 == null) goto L44;
        r21.put(r19);
        r110 = r20;
        goto L57
    L49:
        e = move-exception;
        b("[" + this.f9646b + "]: getInputBuffer CodecException: " + e.getMessage());
    L53:
        r21 = null;
    L47:
        e = move-exception;
        b("[" + this.f9646b + "]: getInputBuffer IllegalStateException: " + e.getMessage());
        goto L53
    L38:
        e = move-exception;
        b("[" + this.f9646b + "]: dequeueInputBuffer CodecException: " + e.getMessage());
    L42:
        r20 = -1;
    L36:
        e = move-exception;
        b("[" + this.f9646b + "]: dequeueInputBuffer IllegalStateException: " + e.getMessage());
        this.f9647c = false;
        this.d = true;
    L30:
        r19 = null;
        goto L31
    L29:
        r16.getClass();
    L19:
        r15 = null;
    L79:
        return r5;
    }

    public final void d() {
        if (this.f9645a == null) goto L14;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "CodecManager", "releaseDecoder");
        this.f9645a.stop();     // Catch: Throwable -> L8
    L10:
        this.f9647c = false;
        this.f9645a.release();
        this.f9645a = null;
        this.f9650j = 0;
        this.f9649i = Math.min(20, 3);
        this.e = -1;
        this.f9648h = 0;
        this.f = 0;
        this.g = -1;
        return;
    L8:
        e = move-exception;
        e.getMessage();
        goto L10
    }
}
