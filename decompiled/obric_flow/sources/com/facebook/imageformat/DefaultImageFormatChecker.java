package com.facebook.imageformat;

import com.facebook.common.webp.WebpSupportStatus;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultImageFormatChecker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f7951b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7952c = 0;
    public static final byte[] d = null;
    public static final int e = 0;
    public static final byte[] f = null;
    public static final byte[] g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f7953h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7954i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f7955j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7956k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f7957l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[][] f7958m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f7959n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f7960o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7961a;

    static {
        f7951b = new byte[]{-1, -40, -1};
        f7952c = 3;
        d = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        e = 8;
        f = ImageFormatCheckerUtils.a("GIF87a");
        g = ImageFormatCheckerUtils.a("GIF89a");
        byte[] r5 = ImageFormatCheckerUtils.a("BM");
        f7953h = r5;
        f7954i = r5.length;
        f7955j = new byte[]{0, 0, 1, 0};
        f7956k = 4;
        f7957l = ImageFormatCheckerUtils.a("ftyp");
        f7958m = new byte[][]{ImageFormatCheckerUtils.a("heic"), ImageFormatCheckerUtils.a("heix"), ImageFormatCheckerUtils.a("hevc"), ImageFormatCheckerUtils.a("hevx"), ImageFormatCheckerUtils.a("mif1"), ImageFormatCheckerUtils.a("msf1")};
        f7959n = new byte[]{73, 73, 42, 0};
        f7960o = new byte[]{77, 77, 0, 42};
    }

    public DefaultImageFormatChecker() {
        int[] r5 = {21, 20, f7952c, e, 6, f7954i, f7956k, 12};
        int r10 = r5[0];
        int r11 = 1;
    L4:
        if (r11 >= 8) goto L9;
        int r12 = r5[r11];
        if (r12 <= r10) goto L8;
        r10 = r12;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        this.f7961a = r10;
    }

    public final ImageFormat a(byte[] r10, int r11) {
        boolean r5 = true;
        if (r11 < 20) goto L47;
        byte[] r12 = WebpSupportStatus.f7701b;
        if (WebpSupportStatus.a(r10, 0, r12) == false) goto L48;
        byte[] r13 = WebpSupportStatus.f7702c;
        if (WebpSupportStatus.a(r10, 8, r13) == false) goto L48;
        if (r11 < 20) goto L46;
        if (WebpSupportStatus.a(r10, 0, r12) == false) goto L46;
        if (WebpSupportStatus.a(r10, 8, r13) == false) goto L46;
        if (WebpSupportStatus.a(r10, 12, WebpSupportStatus.d) == false) goto L18;
        return DefaultImageFormats.f;
    L18:
        if (WebpSupportStatus.a(r10, 12, WebpSupportStatus.e) == false) goto L22;
        return DefaultImageFormats.g;
    L22:
        if (r11 < 21) goto L44;
        byte[] r14 = WebpSupportStatus.f;
        if (WebpSupportStatus.a(r10, 12, r14) == false) goto L44;
        boolean r15 = WebpSupportStatus.a(r10, 12, r14);
        if ((r10[20] & 2) != 2) goto L28;
        boolean r16 = true;
    L29:
        if (r15 == false) goto L33;
        if (r16 == false) goto L33;
        return DefaultImageFormats.f7967j;
    L33:
        boolean r17 = WebpSupportStatus.a(r10, 12, r14);
        if ((r10[20] & 16) == 16) goto L37;
        r5 = false;
    L37:
        if (r17 == false) goto L42;
        if (r5 == false) goto L42;
        return DefaultImageFormats.f7966i;
    L42:
        return DefaultImageFormats.f7965h;
    L28:
        r16 = false;
    L44:
        return ImageFormat.f7971c;
    L46:
        throw new IllegalArgumentException();
    L48:
        byte[] r18 = f7951b;
        if (r11 >= 3) goto L51;
    L54:
        byte[] r19 = d;
        if (r11 < 8) goto L61;
        if (ImageFormatCheckerUtils.a(r10, r19, 0) == false) goto L61;
        return DefaultImageFormats.f7963b;
    L61:
        if (r11 >= 6) goto L64;
    L68:
        byte[] r20 = f7953h;
        if (r11 >= r20.length) goto L71;
        boolean r21 = false;
    L72:
        if (r21 == true) goto L74;
        byte[] r22 = f7955j;
        if (r11 >= r22.length) goto L78;
        boolean r23 = false;
    L79:
        if (r23 == true) goto L81;
        if (r11 >= 12) goto L85;
    L96:
        boolean r24 = false;
    L97:
        if (r24 == true) goto L99;
        byte[] r25 = f7959n;
        if (r11 >= r25.length) goto L106;
        if (r11 >= f7960o.length) goto L106;
    L110:
        r5 = false;
    L111:
        if (r5 == false) goto L115;
        return DefaultImageFormats.f7970m;
    L115:
        return ImageFormat.f7971c;
    L106:
        if (ImageFormatCheckerUtils.a(r10, r25, 0) == true) goto L111;
        if (ImageFormatCheckerUtils.a(r10, f7960o, 0) == false) goto L110;
    L99:
        return DefaultImageFormats.f7968k;
    L85:
        if (r10[3] < 8) goto L96;
        if (ImageFormatCheckerUtils.a(r10, f7957l, 4) == false) goto L96;
        byte[][] r26 = f7958m;
        int r27 = r26.length;
        int r28 = 0;
    L91:
        if (r28 >= r27) goto L96;
        if (ImageFormatCheckerUtils.a(r10, r26[r28], 8) == true) goto L94;
        r28 = r28 + 1;
        goto L91
    L94:
        r24 = true;
        goto L97
    L81:
        return DefaultImageFormats.e;
    L78:
        r23 = ImageFormatCheckerUtils.a(r10, r22, 0);
        goto L79
    L74:
        return DefaultImageFormats.d;
    L71:
        r21 = ImageFormatCheckerUtils.a(r10, r20, 0);
        goto L72
    L64:
        if (ImageFormatCheckerUtils.a(r10, f, 0) == true) goto L117;
        if (ImageFormatCheckerUtils.a(r10, g, 0) == false) goto L68;
    L117:
        return DefaultImageFormats.f7964c;
    L51:
        if (ImageFormatCheckerUtils.a(r10, r18, 0) == false) goto L54;
        return DefaultImageFormats.f7962a;
    L47:
        boolean r29 = WebpSupportStatus.f7700a;
        goto L48
    }
}
