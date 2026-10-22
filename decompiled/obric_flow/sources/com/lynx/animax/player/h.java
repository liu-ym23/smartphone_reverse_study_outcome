package com.lynx.animax.player;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import com.lynx.animax.util.AnimaXLog;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f9672b;

    public h(i r5, int r10) {
        this.f9672b = r5;
        this.f9671a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r5 = this.f9672b.f9681m;
        if (r5.d == false) goto L6;
        r5.d = false;
        r5.d();
        r5.a();
    L6:
        if (r5.f9647c == false) goto L144;
        int r10 = r5.e;
        int r14 = this.f9671a;
        if (r14 == r10) goto L145;
        VideoAsset r11 = r5.f9654n;
        if (r11 == null) goto L43;
        ArrayList r12 = (ArrayList) r11.d.f9376b;
        int r13 = Collections.binarySearch(r12, Integer.valueOf(r14));
        if (r13 >= 0) goto L17;
        r13 = (-r13) - 2;
    L17:
        int r15 = ((Integer) r12.get(r13)).intValue();
        if ((-1) != r5.g) goto L20;
        r5.f9648h = 0;
        r5.f = r15;
        goto L43
    L20:
        int r16 = (r14 - r15) + 1;
        int r17 = r5.e;
        if (r17 > r14) goto L23;
        int r18 = r14 - r17;
    L24:
        int r19 = r5.f9648h;
        if (r18 > r19) goto L27;
        int r20 = 0;
    L28:
        if (r20 <= r16) goto L43;
        if (r19 > 0) goto L126;
    L41:
        r5.f = r15;
        r5.g = -1;
        goto L43
    L126:
        r5.f9645a.flush();     // Catch: IllegalStateException -> L32 MediaCodec.CodecException -> L34
        String r21 = null;
    L38:
        if (r21 == null) goto L40;
        r5.b(r21);
        r5.f9647c = false;
    L40:
        r5.f9648h = 0;
        goto L41
    L34:
        e = move-exception;
        r21 = "[" + r5.f9646b + "]: flush CodecException: " + e.getMessage();
    L32:
        e = move-exception;
        r21 = "[" + r5.f9646b + "]: flush IllegalStateException: " + e.getMessage();
        goto L38
    L27:
        r20 = r18 - r19;
        goto L28
    L23:
        r18 = (r5.f9654n.getFrameCount() + r14) - r5.e;
    L43:
        if (r5.f9647c == false) goto L146;
        MediaCodec.BufferInfo r22 = new MediaCodec.BufferInfo();
        int r23 = 3;
    L47:
        if (r5.e == r14) goto L113;
    L49:
        if (r5.c() == true) goto L49;
        if (r5.f9648h == 0) goto L147;
        if (r5.g != r14) goto L56;
        boolean r24 = true;
    L58:
        if (r5.f9654n != null) goto L128;
        CodecManager$ProcessFrameStatus r25 = CodecManager$ProcessFrameStatus.d;
    L104:
        if (CodecManager$ProcessFrameStatus.f9638a == r25) goto L47;
        if (CodecManager$ProcessFrameStatus.f9640c == r25) goto L47;
        if (CodecManager$ProcessFrameStatus.f9639b != r25) goto L148;
        if (r23 <= 0) goto L149;
        r23 = r23 - 1;
        goto L47
    L149:
        return;
    L148:
        return;
    L128:
        int r110 = r5.f9645a.dequeueOutputBuffer(r22, r5.f9652l);     // Catch: IllegalStateException -> L97 MediaCodec.CodecException -> L99
    L62:
        if ((-3) != r110) goto L65;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "CodecManager", "output buffers changed");
        r25 = CodecManager$ProcessFrameStatus.f9640c;
        goto L104
    L65:
        if ((-2) != r110) goto L75;
        StringBuilder r26 = new StringBuilder("output format changed: ");
        MediaCodec r111 = r5.f9645a;
        if (r111 != null) goto L124;
    L73:
        MediaFormat r112 = null;
    L74:
        r26.append(r112);
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "CodecManager", r26.toString());
        r25 = CodecManager$ProcessFrameStatus.f9640c;
        goto L104
    L124:
        r112 = r111.getOutputFormat();     // Catch: IllegalStateException -> L71
    L71:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "CodecManager", "getOutputFormat failed: " + e.getMessage());
        goto L73
    L75:
        if ((-1) != r110) goto L84;
        int r27 = r5.f9650j + 1;
        r5.f9650j = r27;
        if (r27 >= 0) goto L79;
        r5.f9650j = 0;
    L79:
        int r28 = r5.f9650j;
        if (r28 <= 1) goto L82;
        r5.f9649i = Math.min(20, r28 + 5);
    L83:
        r25 = CodecManager$ProcessFrameStatus.f9639b;
        goto L104
    L82:
        r5.f9649i = Math.min(20, (r28 * 3) + 3);
        goto L83
    L84:
        if (r110 >= 0) goto L130;
        r5.b("[" + r5.f9646b + "]: outputBufferIndex: " + r110);
        r25 = CodecManager$ProcessFrameStatus.d;
        goto L104
    L130:
        r5.f9645a.releaseOutputBuffer(r110, r24);     // Catch: IllegalStateException -> L88 MediaCodec.CodecException -> L90
        String r29 = null;
    L94:
        if (r29 == null) goto L96;
        r5.b(r29);
    L96:
        r5.f9648h--;
        int r30 = r5.g;
        r5.e = r30;
        r5.g = (r30 + 1) % r5.f9654n.getFrameCount();
        r25 = CodecManager$ProcessFrameStatus.f9638a;
        goto L104
    L90:
        e = move-exception;
        r29 = "[" + r5.f9646b + "]: releaseOutputBuffer CodecException: " + e.getMessage();
    L88:
        e = move-exception;
        r29 = "[" + r5.f9646b + "]: releaseOutputBuffer IllegalStateException: " + e.getMessage();
    L99:
        e = move-exception;
        r5.b("[" + r5.f9646b + "]: dequeueOutputBuffer CodecException: " + e.getMessage());
        r25 = CodecManager$ProcessFrameStatus.d;
    L97:
        e = move-exception;
        r5.b("[" + r5.f9646b + "]: dequeueOutputBuffer IllegalStateException: " + e.getMessage());
        r5.f9647c = false;
        r5.d = true;
        r25 = CodecManager$ProcessFrameStatus.d;
        goto L104
    L56:
        r24 = false;
        goto L58
    L147:
        return;
    L113:
        i r113 = r5.f9653m;
        if (r113 == null) goto L122;
        g r31 = new g(r113, 2);
        Handler r114 = r113.f9682n;
        if (r114 != null) goto L118;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoPlayerImpl", "Attempted to post to GL thread after it was released or not alive.");
        goto L122
    L118:
        if (Looper.myLooper() != r114.getLooper()) goto L120;
        r31.run();
        goto L122
    L120:
        r114.post(r31);
    L122:
        r5.c();
        return;
    L146:
        return;
    L145:
        return;
    }
}
