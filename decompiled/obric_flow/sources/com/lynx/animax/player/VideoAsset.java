package com.lynx.animax.player;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.google.common.reflect.w;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.p;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class VideoAsset {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f9642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9643c;
    public w d;

    @CalledByNative
    public static VideoAsset create() {
        return new VideoAsset();
    }

    public final boolean a() {
        if (this.d != null) goto L50;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "VideoAsset", "prepareFrameBuffer");
        d r5 = this.f9642b;
        if (r5 == null) goto L50;
        String r10 = this.f9641a;
        int r11 = r5.f;
        w r12 = null;
        if (r10 != null) goto L10;
    L41:
        this.d = r12;
        if (r12 == null) goto L50;
        ArrayList r13 = (ArrayList) r12.f9376b;
        if (r13.isEmpty() == true) goto L50;
        if (((Integer) r13.get(0)).intValue() != 0) goto L50;
        ArrayList r14 = (ArrayList) this.d.d;
        if (this.f9642b.e == r14.size()) goto L50;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAsset", "prepareFrameBuffer: frameCount change from " + this.f9642b.e + " to " + r14.size());
        this.f9642b.e = r14.size();
        goto L50
    L10:
        if (r10.isEmpty() == true) goto L41;
        if (r11 < 0) goto L41;
        w r15 = new w(15);
        MediaExtractor r16 = new MediaExtractor();
        r16.setDataSource(r10);     // Catch: IOException -> L36
        r16.selectTrack(r11);
        int r17 = (int) new File(r10).length();
        if (r17 > 0) goto L18;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", com.lynx.jsbridge.a.d(r17, "doExtractVideoRawData fail, videoSize = "));
    L35:
        boolean r18 = true;
    L38:
        r16.release();
        if (r18 == false) goto L41;
        r12 = r15;
        goto L41
    L18:
        ByteBuffer r19 = ByteBuffer.allocate(r17);
        ArrayList r20 = (ArrayList) r15.f9376b;
        ArrayList r21 = (ArrayList) r15.d;
        int r110 = 0;
    L59:
        int r111 = r16.readSampleData(r19, r110);     // Catch: IllegalArgumentException -> L21
    L26:
        if (r111 <= 0) goto L32;
        if ((r16.getSampleFlags() & 1) <= 0) goto L30;
        r20.add(Integer.valueOf(r21.size()));
    L30:
        int r112 = r111 + r110;
        r21.add(new c(r110, r16.getSampleTime(), r112));
        r16.advance();
        r110 = r112;
        goto L59
    L32:
        if (r111 != (-1)) goto L34;
        StringBuilder r113 = p.d(r110, "video size: ", " bytes, frame count: ");
        r113.append(r21.size());
        r113.append(", key frame count: ");
        r113.append(r20.size());
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "VideoAssetExtractor", r113.toString());
        r15.f9377c = r19;
        goto L35
    L34:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "doExtractVideoRawData fail");
        r20.clear();
        r21.clear();
    L21:
        e = move-exception;
        String r114 = e.getMessage();
        if (r114 != null) goto L25;
        r114 = "current buffer may not have enough space to read";
    L25:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "readSampleData IllegalArgumentException: ".concat(r114));
        r111 = 0;
    L36:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "setDataSource IOException: " + e.getMessage());
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "load fail, MediaExtractor setDataSource error");
        r18 = false;
    L50:
        w r115 = this.d;
        if (r115 != null) goto L53;
        return false;
    L53:
        ArrayList r116 = (ArrayList) r115.f9376b;
        if (r116.isEmpty() == false) goto L56;
    L58:
        return false;
    L56:
        if (((Integer) r116.get(0)).intValue() != 0) goto L58;
        return true;
    }

    @CalledByNative
    public int getFrameCount() {
        d r5 = this.f9642b;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.e;
    }

    @CalledByNative
    public float getFrameRate() {
        d r5 = this.f9642b;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return r5.d;
    }

    @CalledByNative
    public int getHeight() {
        d r5 = this.f9642b;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.f9664c;
    }

    @CalledByNative
    public int getWidth() {
        d r5 = this.f9642b;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.f9663b;
    }

    @CalledByNative
    public boolean loadLocal(String r15) {
        boolean r5 = false;
        if (r15 != null) goto L5;
    L76:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAsset", "video file path is empty");
        this.f9643c = false;
        return false;
    L5:
        if (r15.isEmpty() == true) goto L76;
        if (r15.isEmpty() == false) goto L10;
    L9:
        d r10 = null;
    L59:
        this.f9642b = r10;
        if (r10 != null) goto L62;
    L70:
        this.f9643c = r5;
        if (r5 == false) goto L73;
        this.f9641a = r15;
        a();
    L75:
        return this.f9643c;
    L73:
        this.f9642b = null;
        goto L75
    L62:
        if (r10.f9663b <= 0) goto L70;
        if (r10.f9664c <= 0) goto L70;
        if (r10.e <= 0) goto L70;
        if (r10.d <= 0.0f) goto L70;
        r5 = true;
        goto L70
    L10:
        r10 = new d();
        r10.f = -1;
        MediaExtractor r11 = new MediaExtractor();
        r11.setDataSource(r15);     // Catch: IOException -> L54
        int r12 = r11.getTrackCount();
        int r13 = 0;
    L13:
        if (r13 >= r12) goto L25;
        MediaFormat r14 = r11.getTrackFormat(r13);
        String r16 = r14.getString("mime");     // Catch: ClassCastException -> L17
    L19:
        if (r16 == null) goto L23;
        if (r16.startsWith("video/") == false) goto L23;
        r10.f = r13;
        r10.f9662a = r14;
    L23:
        r13 = r13 + 1;
    L17:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "format doesn't has mine property: " + e.getMessage());
        r16 = null;
    L25:
        if (r10.f >= 0) goto L82;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "load fail, there is no video track");
    L56:
        boolean r17 = false;
    L57:
        r11.release();
        if (r17 == false) goto L9;
    L82:
        r10.f9663b = r10.f9662a.getInteger("width");     // Catch: Throwable -> L30
    L90:
        r10.f9664c = r10.f9662a.getInteger("height");     // Catch: Throwable -> L35
    L37:
        MediaFormat r18 = r10.f9662a;
        r10.d = r18.getInteger("frame-rate");     // Catch: Throwable -> L40
    L43:
        if (0.0f == r10.d) goto L80;
    L78:
        long r19 = r10.f9662a.getLong("durationUs");     // Catch: Throwable -> L51
    L53:
        r10.e = Math.round((r10.d * r19) / 1000000.0f);
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "VideoAssetExtractor", "frame count: " + r10.e);
        r17 = true;
    L51:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "format doesn't has long durationUs property: " + e.getMessage());
        r19 = 0;
        goto L53
    L80:
        r10.d = r18.getFloat("frame-rate");     // Catch: Throwable -> L47
    L47:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "format doesn't has float frame-rate property: " + e.getMessage());
    L40:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "format doesn't has int frame-rate property: " + e.getMessage());
        r10.d = 0.0f;
    L35:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "format doesn't has height property: " + e.getMessage());
        r10.f9664c = 0;
    L30:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "format doesn't has width property: " + e.getMessage());
        r10.f9663b = 0;
    L54:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "setDataSource IOException: " + e.getMessage());
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "VideoAssetExtractor", "load fail, MediaExtractor setDataSource error");
        goto L56
    }
}
