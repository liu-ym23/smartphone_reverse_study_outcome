package com.lynx.animax.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.view.Surface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class CodecManager {
    public MediaCodec a;
    public String b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public long l;
    public a m;
    public VideoAsset n;
    public Surface o;

    public static final enum ProcessFrameStatus extends Enum<ProcessFrameStatus> {
        public static final ProcessFrameStatus FATAL = null;
        public static final ProcessFrameStatus SUCCESS = null;
        public static final ProcessFrameStatus TRY_AGAIN = null;
        public static final ProcessFrameStatus TRY_AGAIN_IF_NECESSARY = null;
        public static final /* synthetic */ ProcessFrameStatus[] a = null;

        static {
            ProcessFrameStatus r0 = new ProcessFrameStatus("SUCCESS", 0);
            SUCCESS = r0;
            ProcessFrameStatus r1 = new ProcessFrameStatus("TRY_AGAIN_IF_NECESSARY", 1);
            TRY_AGAIN_IF_NECESSARY = r1;
            ProcessFrameStatus r3 = new ProcessFrameStatus("TRY_AGAIN", 2);
            TRY_AGAIN = r3;
            ProcessFrameStatus r5 = new ProcessFrameStatus("FATAL", 3);
            FATAL = r5;
            a = new ProcessFrameStatus[]{r0, r1, r3, r5};
        }

        public static ProcessFrameStatus[] values() {
            return (ProcessFrameStatus[]) a.clone();
        }

        public static ProcessFrameStatus valueOf(String r1) {
            return (ProcessFrameStatus) r27.a.a(ProcessFrameStatus.class, r1);
        }

        public ProcessFrameStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
    }

    public final void b() {
        VideoAsset r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        f r1 = r0.b;
        if (r1 != null) goto L8;
        MediaFormat r2 = null;
    L9:
        AnimaXLog.b("CodecManager", "initDecoder, format: " + r2);
        String r3 = r2.getString("mime");
        if (r3 != null) goto L51;
        return;
    L51:
        int r4 = MediaCodecList.getCodecCount();     // Catch: Exception -> L36
    L13:
        int r5 = this.k;     // Catch: Exception -> L36
        boolean r6 = false;
        if (r5 >= r4) goto L45;
        this.k = r5 + 1;     // Catch: Exception -> L36
        MediaCodecInfo r7 = MediaCodecList.getCodecInfoAt(r5);     // Catch: Exception -> L36
        if (r7.isEncoder() == true) goto L13;
        String[] r8 = r7.getSupportedTypes();     // Catch: Exception -> L36
        if (r8 != null) goto L20;
        int r9 = 0;
    L21:
        int r10 = 0;
    L23:
        if (r10 >= r9) goto L28;
        if (r3.equals(r8[r10]) == true) goto L26;
        r10 = r10 + 1;     // Catch: Exception -> L36
        goto L23
    L26:
        r6 = true;
    L28:
        if (r6 == false) goto L13;
        String r11 = r7.getName();     // Catch: Exception -> L36
        if (r11 == null) goto L13;
        if (f(r11).a == false) goto L13;
        r6 = true;
        goto L45
    L20:
        r9 = r8.length;     // Catch: Exception -> L36
    L45:
        if (r6 == true) goto L49;
        e("initDecoder error");
        return;
    L49:
        if (c() == true) goto L49;
        return;
    L36:
        e = move-exception;
        AnimaXLog.a("CodecManager", "enumerate codec list failed, fallback to decoder by type: " + e.getMessage());
        AnimaXLog.b("CodecManager", "try decoder by type: ".concat(r3));
        if (this.n != null) goto L53;
        q4a.d r12 = new q4a.d("tryInitDecoderByType error: mAsset is null");
    L44:
        r6 = r12.a;
        goto L45
    L53:
        MediaCodec r13 = MediaCodec.createDecoderByType(r3);     // Catch: Exception -> L42
        this.a = r13;     // Catch: Exception -> L42
        r12 = a(r13.getName());
    L42:
        e = move-exception;
        r12 = new q4a.d("createDecoderByType Exception: " + e.getMessage());
        goto L44
    L8:
        r2 = r1.a;
        goto L9
    }

    public final boolean c() {
        boolean r3 = false;
        if (this.c == false) goto L61;
        VideoAsset r0 = this.n;
        if (r0 == null) goto L61;
        if (this.h < this.i) goto L10;
        return false;
    L10:
        int r4 = this.f;
        l r1 = r0.d;
        String r5 = null;
        if (r1 != null) goto L13;
    L12:
        d r6 = null;
    L19:
        ByteBuffer r7 = this.n.a(r6);
        if (r7 != null) goto L62;
        return false;
    L62:
        int r9 = this.a.dequeueInputBuffer(this.l);     // Catch: IllegalStateException -> L25 MediaCodec.CodecException -> L27
    L30:
        if (r9 >= 0) goto L64;
    L40:
        int r11 = -1;
    L42:
        if (r11 >= 0) goto L66;
        return false;
    L66:
        this.a.queueInputBuffer(r11, 0, r6.b - r6.a, r6.c, 0);     // Catch: IllegalStateException -> L47 MediaCodec.CodecException -> L49 MediaCodec.CryptoException -> L51
    L53:
        if (r5 == null) goto L55;
        e(r5);
    L56:
        if (r3 == false) goto L61;
        this.h++;
        if ((-1) != this.g) goto L60;
        this.g = this.f;
    L60:
        this.f = (this.f + 1) % this.n.getFrameCount();
        goto L61
    L55:
        r3 = true;
        goto L56
    L49:
        e = move-exception;
        r5 = "[" + this.b + "]: queueInputBuffer CodecException: " + e.getMessage();
    L51:
        e = move-exception;
        r5 = "[" + this.b + "]: queueInputBuffer CryptoException: " + e.getMessage();
    L47:
        e = move-exception;
        r5 = "[" + this.b + "]: queueInputBuffer IllegalStateException: " + e.getMessage();
        goto L53
    L64:
        ByteBuffer r2 = this.a.getInputBuffer(r9);     // Catch: IllegalStateException -> L34 MediaCodec.CodecException -> L36
    L39:
        if (r2 == null) goto L40;
        r2.put(r7);
        r11 = r9;
        goto L42
    L36:
        e = move-exception;
        e("[" + this.b + "]: getInputBuffer CodecException: " + e.getMessage());
    L38:
        r2 = null;
    L34:
        e = move-exception;
        e("[" + this.b + "]: getInputBuffer IllegalStateException: " + e.getMessage());
        goto L38
    L27:
        e = move-exception;
        e("[" + this.b + "]: dequeueInputBuffer CodecException: " + e.getMessage());
    L29:
        r9 = -1;
    L25:
        e = move-exception;
        e("[" + this.b + "]: dequeueInputBuffer IllegalStateException: " + e.getMessage());
        this.c = false;
        this.d = true;
        goto L29
    L13:
        ArrayList<d> r8 = r1.c;
        if (r4 < 0) goto L12;
        if (r4 >= r8.size()) goto L12;
        r6 = (d) ListProtector.get(r8, r4);
    L61:
        return r3;
    }

    public final void d() {
        if (this.a != null) goto L5;
        return;
    L5:
        AnimaXLog.b("CodecManager", "releaseDecoder");
        this.a.stop();     // Catch: IllegalStateException -> L8 Throwable -> L10
    L12:
        this.c = false;
        this.a.release();
        this.a = null;
        this.j = 0;
        g();
        this.e = -1;
        this.h = 0;
        this.f = 0;
        this.g = -1;
        return;
    L10:
        e = move-exception;
        e.getMessage();
        goto L12
    }

    public final void g() {
        if (this.j >= 0) goto L5;
        this.j = 0;
    L5:
        int r0 = this.j;
        if (r0 <= 1) goto L8;
        this.i = Math.min(20, r0 + 5);
        return;
    L8:
        this.i = Math.min(20, (r0 * 3) + 3);
    }

    public CodecManager(h r2) {
        this.d = false;
        this.k = 0;
        this.m = r2;
    }

    public final q4a.d a(String r6) {
        f r0 = this.n.b;
        if (r0 != null) goto L5;
        MediaFormat r1 = null;
    L37:
        this.a.configure(r1, this.o, null, 0);     // Catch: IllegalStateException -> L9 IllegalArgumentException -> L11 MediaCodec.CryptoException -> L13 MediaCodec.CodecException -> L15
        String r2 = null;
    L17:
        q4a.d r3 = new q4a.d(r2);
        if (r3.a == true) goto L35;
        this.a.release();
        this.a = null;
        return r3;
    L35:
        this.a.start();     // Catch: IllegalStateException -> L23 IllegalArgumentException -> L25 MediaCodec.CodecException -> L27
        String r4 = null;
    L29:
        q4a.d r5 = new q4a.d(r4);
        if (r5.a == true) goto L33;
        this.a.release();
        this.a = null;
        return r5;
    L33:
        this.b = r6;
        this.c = true;
        AnimaXLog.b("CodecManager", "chosen decoder: " + r6);
        return new q4a.d();
    L27:
        e = move-exception;
        r4 = "startDecoder CodecException: " + e.getMessage();
    L25:
        e = e;
    L26:
        r4 = "startDecoder Exception: " + e.getMessage();
    L23:
        e = e;
        goto L26
    L15:
        e = move-exception;
        r2 = "configureCodec CodecException: " + e.getMessage();
    L13:
        e = move-exception;
        r2 = "configureCodec CryptoException: " + e.getMessage();
    L11:
        e = e;
    L12:
        r2 = "configureCodec Exception: " + e.getMessage();
    L9:
        e = e;
        goto L12
    L5:
        r1 = r0.a;
        goto L37
    }

    public final void e(String r3) {
        a r0 = this.m;
        if (r0 == null) goto L6;
        h r1 = (h) r0;
        r1.getClass();
        r1.d(new i(r1, r3));
        return;
    }

    public final q4a.d f(String r4) {
        AnimaXLog.b("CodecManager", "try decoder: " + r4);
        if (this.n == null) goto L5;
        this.a = MediaCodec.createByCodecName(r4);     // Catch: IllegalArgumentException -> L8 IOException -> L10 MediaCodec.CodecException -> L12
        String r0 = null;
    L14:
        q4a.d r1 = new q4a.d(r0);
        if (r1.a == true) goto L18;
        return r1;
    L18:
        return a(r4);
    L12:
        e = move-exception;
        r0 = "createByCodecName CodecException: " + e.getMessage();
    L10:
        e = e;
    L11:
        r0 = "createByCodecName Exception: " + e.getMessage();
    L8:
        e = e;
        goto L11
    L5:
        return new q4a.d("tryInitDecoder error: mAsset is null");
    }
}
