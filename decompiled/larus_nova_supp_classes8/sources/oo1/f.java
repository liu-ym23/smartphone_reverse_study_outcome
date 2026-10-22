package oo1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.io.FileUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f {
    public static d a;
    public static Context b;
    public static String c;
    public static d.a d;

    public static final class a implements d.a {
        public a() {
        }

        @Override // oo1.d.a
        public final void b(int r3) {
            ALogger.i("QuickInsideRecordManager", "onMediaInfoListener time:" + r3);
            d r0 = f.a;
            d.a r1 = f.d;
            if (r1 == null) goto L6;
            r1.b(r3);
            return;
        }

        @Override // oo1.d.a
        public final void d(int r3) {
            ALogger.i("QuickInsideRecordManager", "onMediaMuxerChangeListener type:" + r3);
            d r0 = f.a;
            d.a r1 = f.d;
            if (r1 == null) goto L6;
            r1.d(r3);
            return;
        }

        @Override // oo1.d.a
        public final void c(String r2, String r3, int r4) {
            d.a r0 = f.d;
            if (r0 == null) goto L5;
            r0.c(r2, r3, r4);
        L5:
            d r5 = f.a;
            if (r5 == null) goto L9;
            r5.a();
            return;
        }
    }

    static {
        c = "";
    }

    public static void a(Bitmap r7) {
        ALogger.i("QuickInsideRecordManager", "pushVideoFrame");
        if (r7 == null) goto L26;
        d r0 = a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.e != null) goto L9;
        return;
    L9:
        if (e.d.get() == false) goto L11;
        return;
    L11:
        if (e.e.get() == false) goto L13;
        return;
    L13:
        if (r0.a == null) goto L31;
        ALogger.d("MediaEncodeManager", "setBitmapSource");
        int r1 = r7.getWidth();
        int r3 = r7.getHeight();
        Canvas r4 = r0.a.lockCanvas(null);     // Catch: Exception -> L21
        if (r4 == null) goto L19;
        Rect r5 = new Rect(0, 0, r1, r3);     // Catch: Exception -> L21
        r4.drawBitmap(r7, r5, r5, r0.g);     // Catch: Exception -> L21
        r0.a.unlockCanvasAndPost(r4);     // Catch: Exception -> L21
    L19:
        r7.recycle();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        ALogger.e("MediaEncodeManager", "setBitmapSource error:" + e.getMessage());
        return;
    L31:
        return;
    }

    public static void b(int r11, int r12, int r13, int r14, int r15) {
        ALogger.i("QuickInsideRecordManager", "startRecord width: " + r11 + "  height:" + r12 + ' ');
        a = new d();
        String r0 = FileUtils.getCacheDirPath(b) + ("/VID_" + System.currentTimeMillis() + ".mp4");
        c = r0;
        d r1 = a;
        if (r1 == null) goto L30;
        a r6 = new a();
        r1.b = new MediaMuxer(r0, 0);     // Catch: IOException -> L7
    L40:
    L24:
        e = move-exception;
        ALogger.e("MediaEncodeManager", "initVideoCodec: 视频类型无效 videoType:video/avc width:" + r11 + " height:" + r12 + "msg:" + e.getMessage());
    L44:
        r1.c = MediaCodec.createEncoderByType("audio/mp4a-latm");     // Catch: IOException -> L28
        MediaFormat r16 = MediaFormat.createAudioFormat("audio/mp4a-latm", r13, r14);     // Catch: IOException -> L28
        r16.setInteger("bitrate", 76000);     // Catch: IOException -> L28
        r16.setInteger("aac-profile", 2);     // Catch: IOException -> L28
        r16.setInteger("max-input-size", 10240);     // Catch: IOException -> L28
        r1.c.configure(r16, null, null, 1);     // Catch: IOException -> L28
        r1.d = new MediaCodec.BufferInfo();     // Catch: IOException -> L28
    L29:
        r1.h = r13;
        r1.i = r14;
        r1.j = r15;
        r1.m = new h(r1.e, r1.f, r1.b, r6);
        r1.l = new oo1.a(r1.c, r1.d, r1.b, r6);
    L28:
        ALogger.e("MediaEncodeManager", "initAudioCodec: 音频类型无效");
        goto L29
    L10:
        if ((r11 % 2) != 1) goto L13;
        r11 = r11 + 1;     // Catch: Exception -> L24
    L13:
        if ((r12 % 2) != 1) goto L15;
        r12 = r12 + 1;     // Catch: Exception -> L24
    L15:
        if (r11 > 0) goto L17;
        r11 = 1920;
    L17:
        if (r12 > 0) goto L19;
        r12 = 1080;
    L19:
        r1.e = MediaCodec.createEncoderByType("video/avc");     // Catch: Exception -> L24
        MediaFormat r5 = MediaFormat.createVideoFormat("video/avc", r11, r12);     // Catch: Exception -> L24
        r5.setInteger("color-format", 2130708361);     // Catch: Exception -> L24
        r5.setInteger("frame-rate", 24);     // Catch: Exception -> L24
        r5.setInteger("bitrate", r11 * r12);     // Catch: Exception -> L24
        r5.setInteger("i-frame-interval", 1);     // Catch: Exception -> L24
        if (Build.VERSION.SDK_INT < 24) goto L22;
        r5.setInteger("profile", 8);     // Catch: Exception -> L24
        r5.setInteger("level", 512);     // Catch: Exception -> L24
    L22:
        r1.e.configure(r5, null, null, 1);     // Catch: Exception -> L24
        r1.f = new MediaCodec.BufferInfo();     // Catch: Exception -> L24
        r1.a = r1.e.createInputSurface();     // Catch: Exception -> L24
    L7:
        ALogger.e("MediaEncodeManager", "initMediaMuxer: 文件打开失败,path=" + r0);
    L30:
        d r17 = a;
        if (r17 != null) goto L33;
        return;
    L33:
        if (r17.a == null) goto L49;
        e.c.set(false);
        e.d.set(false);
        e.e.set(false);
        ThreadMethodProxy.start(r17.m);     // Catch: Exception -> L38
        ThreadMethodProxy.start(r17.l);     // Catch: Exception -> L38
        return;
    L38:
        h r18 = r17.m;
        r18.getClass();
        e.e.set(true);
        r18.y = true;
        oo1.a r19 = r17.l;
        r19.getClass();
        e.d.set(true);
        r19.y = true;
        return;
    }
}
