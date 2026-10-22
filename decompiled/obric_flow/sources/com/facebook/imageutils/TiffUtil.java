package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
abstract class TiffUtil {

    public static class TiffHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8458b;

        public TiffHeader() {
        }
    }

    public static int a(InputStream r10, int r11) {
        TiffHeader r5 = new TiffHeader();
        if (r11 > 8) goto L5;
    L4:
        int r12 = 0;
    L18:
        int r13 = r5.f8458b - 8;
        if (r12 == 0) goto L46;
        if (r13 > r12) goto L46;
        r10.skip(r13);
        int r14 = r12 - r13;
        boolean r15 = r5.f8457a;
        if (r14 < 14) goto L34;
        int r16 = StreamProcessor.a(r10, 2, r15);
        int r17 = r14 - 2;
    L26:
        int r18 = r16 - 1;
        if (r16 <= 0) goto L34;
        if (r17 < 12) goto L34;
        int r19 = r17 - 2;
        if (StreamProcessor.a(r10, 2, r15) == 274) goto L35;
        r10.skip(10);
        r17 = r17 - 12;
        r16 = r18;
    L35:
        boolean r110 = r5.f8457a;
        if (r19 >= 10) goto L39;
        return 0;
    L39:
        if (StreamProcessor.a(r10, 2, r110) == 3) goto L42;
        return 0;
    L42:
        if (StreamProcessor.a(r10, 4, r110) == 1) goto L45;
        return 0;
    L45:
        return StreamProcessor.a(r10, 2, r110);
    L34:
        r19 = 0;
    L46:
        return 0;
    L5:
        int r20 = StreamProcessor.a(r10, 4, false);
        if (r20 != 1229531648) goto L8;
    L10:
        if (r20 != 1229531648) goto L12;
        boolean r21 = true;
    L13:
        r5.f8457a = r21;
        int r22 = StreamProcessor.a(r10, 4, r21);
        r5.f8458b = r22;
        r12 = r11 - 8;
        if (r22 >= 8) goto L16;
    L17:
        FLog.a(TiffUtil.class, "Invalid offset");
        goto L4
    L16:
        if ((r22 - 8) <= r12) goto L18;
    L12:
        r21 = false;
        goto L13
    L8:
        if (r20 == 1296891946) goto L10;
        FLog.a(TiffUtil.class, "Invalid TIFF header");
        goto L4
    }
}
