package com.facebook.imageformat;

import com.facebook.common.logging.FLog;
import com.facebook.imageutils.HeifFormatUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DefaultImageFormats {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageFormat f7962a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImageFormat f7963b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ImageFormat f7964c = null;
    public static final ImageFormat d = null;
    public static final ImageFormat e = null;
    public static final ImageFormat f = null;
    public static final ImageFormat g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ImageFormat f7965h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ImageFormat f7966i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ImageFormat f7967j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ImageFormat f7968k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ImageFormat f7969l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ImageFormat f7970m = null;

    static {
        f7962a = new ImageFormat("JPEG", "jpeg");
        f7963b = new ImageFormat("PNG", "png");
        f7964c = new ImageFormat("GIF", "gif");
        d = new ImageFormat("BMP", "bmp");
        e = new ImageFormat("ICO", "ico");
        f = new ImageFormat("WEBP_SIMPLE", "webp");
        g = new ImageFormat("WEBP_LOSSLESS", "webp");
        f7965h = new ImageFormat("WEBP_EXTENDED", "webp");
        f7966i = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", "webp");
        f7967j = new ImageFormat("WEBP_ANIMATED", "webp");
        f7968k = new ImageFormat("HEIF", "heif");
        f7969l = new ImageFormat("HEIF_FORMAT", "heic");
        f7970m = new ImageFormat("DNG", "dng");
    }

    public static boolean a(ImageFormat r5) {
        ImageFormat r10 = HeifFormatUtil.f8455c;
        if (r10 != null) goto L21;
        Class r11 = HeifFormatUtil.f8454b;
        if (r11 != null) goto L26;
        r10 = null;
        goto L21
    L26:
        HeifFormatUtil.f8455c = (ImageFormat) r11.getDeclaredField("HEIF_FORMAT").get(null);     // Catch: Exception -> L10 IllegalAccessException -> L12 NoSuchFieldException -> L14
    L19:
        r10 = HeifFormatUtil.f8455c;
        goto L21
    L12:
        e = move-exception;
        FLog.a("HeifFormatUtil", "HeifFormat init ", e);
    L14:
        e = move-exception;
        FLog.a("HeifFormatUtil", "HeifFormat init ", e);
    L10:
        e = move-exception;
        e.printStackTrace();
    L21:
        if (r10 != null) goto L23;
        return false;
    L23:
        if (r5 != r10) goto L28;
        return true;
    L28:
        return false;
    }

    public static boolean b(ImageFormat r5) {
        if (r5 != f) goto L5;
        return true;
    L5:
        if (r5 != g) goto L7;
        return true;
    L7:
        if (r5 != f7965h) goto L9;
        return true;
    L9:
        if (r5 == f7966i) goto L17;
        return false;
    L17:
        return true;
    }
}
