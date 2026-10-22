package alb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.image.uploader.config.OriginalModeFormat;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(com.ss.android.lark.image.uploader.entity.b r10) {
        Intrinsics.checkNotNullParameter(r10, "uploadImage");
        String r1 = r10.a;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r1);
        OriginalModeFormat r5 = null;
        if (r2.exists() == true) goto L6;
        int r0 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.b("FileSizeChecker", "checkValidFailed, file not exist:" + r10, null, false);
        return -10002;
    L6:
        String[] r3 = FileUtils.a;
        long r4 = r2.length();
        ImageInfo r7 = r10.k;
        if (r7 != null) goto L9;
        r7 = com.ss.android.lark.image.uploader.utils.b.d(r1, true, false);
        r10.k = r7;
    L9:
        long r8 = ConfigManager.c(r10);
        if (r4 <= r8) goto L13;
        int r11 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.b("FileSizeChecker", "checkValidFailed, file size over limit, file size:" + r4 + ", fileSizeLimit:" + r8, null, false);
        return -10001;
    L13:
        if (r7 == null) goto L18;
        int r6 = r7.a * r7.b;
        Intrinsics.checkNotNullParameter(r10, "uploadImage");
        int r9 = ConfigManager.e(r10) * ConfigManager.d(r10);
        if (r6 <= r9) goto L19;
        int r12 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.b("FileSizeChecker", "checkValidFailed, file resolution over limit, file resolution:" + r6 + ", fileResolutionLimit:" + r9, null, false);
        return -10003;
    L19:
        if (r7 != null) goto L21;
    L29:
        return 0;
    L21:
        if (r10.b == false) goto L29;
        com.ss.android.lark.image.uploader.config.c r13 = ConfigManager.a().getFileSizeConfig();
        if (r13 == null) goto L26;
        r5 = r13.a(r7.e).c();
    L26:
        if (r5 != OriginalModeFormat.FILE) goto L29;
        return -10006;
    L18:
        int r14 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.b("FileSizeChecker", "checkValidFailed, failed to get bitmapInfo. UploadImage:" + r10, null, false);
        goto L19
    }

    public static a b(ImageUploadTask r13) {
        Intrinsics.checkNotNullParameter(r13, "task");
        flb.a r0 = r13.d;
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r14 = r13.b;
        com.ss.android.lark.image.uploader.config.c r1 = ConfigManager.a().getFileSizeConfig();
        if (r1 != null) goto L7;
        r1 = ConfigManager.b.getFileSizeConfig();
        if (r1 != null) goto L7;
        boolean r2 = true;
    L10:
        if (r0 == null) goto L12;
        boolean r3 = r0.b;
    L14:
        if (r2 == false) goto L33;
        if (r3 == true) goto L33;
        Iterator<com.ss.android.lark.image.uploader.entity.b> r15 = r14.iterator();
    L19:
        if (r15.hasNext() == false) goto L32;
        com.ss.android.lark.image.uploader.entity.b r8 = r15.next();
        int r7 = a(r8);
        int r4 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("FileSizeChecker", "checkValid, image:" + r8 + ", ret:" + r7);
        if (r7 == 0) goto L19;
        if (r7 != (-10003)) goto L25;
        Lazy r16 = ConfigManager.a;
        Intrinsics.checkNotNullParameter(r8, "uploadImage");
        long r5 = ConfigManager.e(r8) * ConfigManager.d(r8);
    L30:
        return new a(r7, r8, r5, ConfigManager.e(r8), ConfigManager.d(r8));
    L25:
        if (r7 == (-10001)) goto L27;
        r5 = 0;
        goto L30
    L27:
        r5 = ConfigManager.c(r8) / ((long) 1048576);
        goto L30
    L32:
        return new a(0, null, 30);
    L33:
        int r17 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("FileSizeChecker", "FileSizeCheckConfig close, config:" + r2 + ", setting:" + r3 + ",  skip");
        return new a(0, null, 30);
    L12:
        r3 = false;
    L7:
        r2 = r1.c();
        goto L10
    }
}
