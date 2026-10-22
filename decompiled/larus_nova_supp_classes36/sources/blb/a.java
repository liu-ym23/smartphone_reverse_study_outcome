package blb;

import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    static {
    }

    public static int[] a(ImageInfo r9, flb.b r10) {
        Intrinsics.checkNotNullParameter(r9, "imageInfo");
        long r2 = r9.c;
        int r0 = Math.min(r9.a, r9.b);
        int r5 = Math.max(r9.a, r9.b);
        int r6 = r9.d;
        if (r10 == null) goto L5;
        int r7 = r10.a;
    L6:
        if (r10 == null) goto L8;
        int r8 = r10.b;
    L9:
        int[] r1 = ykb.b.a.f(r2, r0, r5, r6, r7, r8);
        if (r1.length != 0) goto L12;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
    L17:
        com.ss.android.lark.image.uploader.config.b r4 = ConfigManager.a().getCompressConfig();
        if (r4 == null) goto L20;
        int r11 = r4.b();
    L21:
        com.ss.android.lark.image.uploader.config.b r12 = ConfigManager.a().getCompressConfig();
        if (r12 == null) goto L24;
        int r13 = r12.a();
    L25:
        r1 = new int[]{r11, r13};
    L26:
        int r14 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("CompressParamsProvider", "ImageInfo:" + r9 + ", fileCompressConfig:" + r10 + ", target short side:" + r1[0] + ", target quality:" + r1[1]);
        if (r1[0] > 0) goto L29;
        r1[0] = r0;
    L29:
        int r15 = r1[1];
        if (r15 <= 0) goto L32;
        if (r15 > 100) goto L32;
    L33:
        return r1;
    L32:
        r1[1] = 100;
        goto L33
    L24:
        r13 = 70;
        goto L25
    L20:
        r11 = 1080;
        goto L21
    L16:
        if (r1.length >= 2) goto L26;
    L12:
        r3 = false;
        goto L14
    L8:
        r8 = -1;
        goto L9
    L5:
        r7 = -1;
        goto L6
    }
}
