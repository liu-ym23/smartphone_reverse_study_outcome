package com.lynx.animax.audio;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.lynx.animax.util.AnimaXLog;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import p4a.a;
import p4a.b;
import p4a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AudioAsset {
    public String a;
    public c b;
    public ByteBuffer c;

    public AudioAsset() {
    }

    public static AudioAsset create() {
        return new AudioAsset();
    }

    public final boolean a() {
        c r0 = this.b;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.b <= 0) goto L11;
        if (r0.c <= 0) goto L11;
        if (r0.d <= 0) goto L11;
        return true;
    }

    public boolean loadLocal(String r21) {
        if (r21 != null) goto L5;
    L143:
        AnimaXLog.a("AudioAsset", "audio file path is empty");
        return false;
    L5:
        if (r21.isEmpty() == true) goto L143;
        ByteBuffer r6 = null;
        if (r21.isEmpty() == true) goto L33;
        c r7 = new c();
        MediaExtractor r8 = new MediaExtractor();
        if (b.a(r8, r21) == true) goto L13;
        AnimaXLog.a("AudioAssetExtractor", "load fail, MediaExtractor setDataSource error");
        r8.release();
        goto L33
    L13:
        int r9 = r8.getTrackCount();
        int r10 = 0;
    L14:
        if (r10 >= r9) goto L31;
        MediaFormat r11 = r8.getTrackFormat(r10);
        String r0 = r11.getString("mime");     // Catch: ClassCastException -> L18
    L20:
        if (r0 == null) goto L29;
        if (r0.startsWith("audio/") == false) goto L29;
        r7.f = r10;
        r7.a = r11;
        r7.b = r11.getInteger("channel-count");     // Catch: ClassCastException -> L26
        r7.c = r11.getInteger("sample-rate");     // Catch: ClassCastException -> L26
        r7.d = r11.getLong("durationUs");     // Catch: ClassCastException -> L26
    L28:
        AnimaXLog.b("AudioAssetExtractor", "audio track format: " + r11);
    L26:
        e = move-exception;
        AnimaXLog.a("AudioAssetExtractor", "Failed to get meta info from format: " + e.getMessage());
    L29:
        r10 = r10 + 1;
    L18:
        e = move-exception;
        AnimaXLog.a("AudioAssetExtractor", "format doesn't has mime property: " + e.getMessage());
        r0 = null;
    L31:
        if (r7.f >= 0) goto L34;
        AnimaXLog.a("AudioAssetExtractor", "load fail, there is no audio track");
        r8.release();
        goto L33
    L34:
        r8.release();
    L35:
        this.b = r7;
        if (a() == true) goto L39;
        this.b = null;
        return false;
    L39:
        this.a = r21;
        if (a() == true) goto L43;
        return false;
    L43:
        if (this.c != null) goto L140;
        c r1 = this.b;
        String r12 = this.a;
        int r13 = r1.f;
        if (r12 != null) goto L47;
    L138:
        this.c = r6;
        goto L140
    L47:
        if (r12.isEmpty() == true) goto L138;
        if (r13 < 0) goto L138;
        MediaExtractor r14 = new MediaExtractor();
        if (b.a(r14, r12) == true) goto L53;
        AnimaXLog.a("AudioAssetExtractor", "load fail, MediaExtractor setDataSource error");
        r14.release();
        goto L138
    L53:
        r14.selectTrack(r13);
        a r4 = new a(r1);
        if (r4.b == null) goto L56;
        boolean r2 = true;
    L57:
        if (r2 == true) goto L59;
        AnimaXLog.a("AudioAssetExtractor", "Failed to init decoder.");
        r14.release();
        goto L138
    L59:
        ByteArrayOutputStream r15 = new ByteArrayOutputStream();
        MediaCodec r3 = r4.b;     // Catch: Throwable -> L115 Exception -> L117
        if (r3 == null) goto L64;
        r4.c = false;     // Catch: Throwable -> L115 Exception -> L117
        r3.start();     // Catch: Throwable -> L115 Exception -> L117
    L64:
        ByteBuffer r5 = ByteBuffer.allocate(8192);     // Catch: Throwable -> L115 Exception -> L117
        boolean r16 = true;
        int r17 = 0;
    L66:
        if (r4.c == true) goto L112;
        if (r16 == false) goto L95;
        MediaCodec r18 = r4.b;     // Catch: Throwable -> L115 Exception -> L117
        if (r18 == null) goto L73;
        int r19 = r18.dequeueInputBuffer(1000);     // Catch: Throwable -> L115 Exception -> L117
        r4.d = r19;     // Catch: Throwable -> L115 Exception -> L117
        if (r19 < 0) goto L73;
        ByteBuffer r110 = r4.b.getInputBuffer(r19);     // Catch: Throwable -> L115 Exception -> L117
    L75:
        if (r110 == null) goto L95;
        int r111 = 1;
    L78:
        if (r111 > 20) goto L86;
        r14.readSampleData(r5, 0);     // Catch: Throwable -> L115 Exception -> L117
        if ((r110.position() + r5.limit()) > r110.capacity()) goto L86;
        r110.put(r5);     // Catch: Throwable -> L115 Exception -> L117
        if (r14.advance() == false) goto L84;
        r111 = r111 + 1;     // Catch: Throwable -> L115 Exception -> L117
        goto L78
    L84:
        r16 = false;
    L86:
        r110.flip();     // Catch: Throwable -> L115 Exception -> L117
        if (r16 == false) goto L89;
        int r112 = 0;
    L90:
        int r113 = r110.limit();     // Catch: Throwable -> L115 Exception -> L117
        MediaCodec r114 = r4.b;     // Catch: Throwable -> L115 Exception -> L117
        if (r114 == null) goto L94;
        r114.queueInputBuffer(r4.d, 0, r113, 0, r112);     // Catch: Throwable -> L115 Exception -> L117
    L94:
        boolean r115 = true;
    L96:
        ByteBuffer r116 = r4.a();     // Catch: Throwable -> L115 Exception -> L117
        if (r116 == null) goto L98;
        if (r116.hasArray() == false) goto L106;
        byte[] r117 = r116.array();     // Catch: Throwable -> L115 Exception -> L117
        int r118 = r116.arrayOffset();     // Catch: Throwable -> L115 Exception -> L117
        MediaCodec.BufferInfo r119 = r4.f;     // Catch: Throwable -> L115 Exception -> L117
        r15.write(r117, r118 + r119.offset, r119.size);     // Catch: Throwable -> L115 Exception -> L117
    L107:
        MediaCodec r120 = r4.b;     // Catch: Throwable -> L115 Exception -> L117
        if (r120 == null) goto L66;
        r120.releaseOutputBuffer(r4.e, false);     // Catch: Throwable -> L115 Exception -> L117
        goto L66
    L106:
        byte[] r121 = new byte[r4.f.size];     // Catch: Throwable -> L115 Exception -> L117
        r116.get(r121);     // Catch: Throwable -> L115 Exception -> L117
        r15.write(r121);     // Catch: Throwable -> L115 Exception -> L117
        goto L107
    L98:
        if (r115 == true) goto L101;
        r17 = r17 + 1;     // Catch: Throwable -> L115 Exception -> L117
    L101:
        if (r17 <= 100) goto L66;
    L89:
        r112 = 4;
    L73:
        r110 = null;
    L95:
        r115 = false;
    L112:
        if (r4.c == true) goto L119;
        AnimaXLog.a("AudioAssetExtractor", "Failed to decode audio asset: the decoder is in infinite loop.");     // Catch: Throwable -> L115 Exception -> L117
    L119:
        MediaCodec r20 = r4.b;
        if (r20 == null) goto L123;
        r20.stop();
    L123:
        MediaCodec r22 = r4.b;
        if (r22 == null) goto L127;
        r22.release();
    L127:
        r14.release();
        r6 = ByteBuffer.wrap(r15.toByteArray());
    L115:
        th = move-exception;
        MediaCodec r23 = r4.b;
        if (r23 == null) goto L132;
        r23.stop();
    L132:
        MediaCodec r24 = r4.b;
        if (r24 == null) goto L136;
        r24.release();
    L136:
        r14.release();
        throw th;
    L117:
        e = move-exception;
        AnimaXLog.a("AudioAssetExtractor", "Failed to decode audio asset: " + e.getMessage());     // Catch: Throwable -> L115
        goto L119
    L56:
        r2 = false;
    L140:
        if (this.c == null) goto L168;
        return true;
    L168:
        return false;
    L33:
        r7 = null;
        goto L35
    }
}
