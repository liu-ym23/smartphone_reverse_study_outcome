package alb;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.image.uploader.config.d;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static a b(ImageUploadTask r9) {
        Intrinsics.checkNotNullParameter(r9, "task");
        flb.a r0 = r9.d;
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r10 = r9.b;
        d r1 = ConfigManager.a().getFileTypeConfig();
        if (r1 != null) goto L7;
        r1 = ConfigManager.b.getFileTypeConfig();
        if (r1 != null) goto L7;
        boolean r2 = true;
    L10:
        if (r0 == null) goto L12;
        boolean r3 = r0.b;
    L14:
        if (r2 == false) goto L26;
        if (r3 == true) goto L26;
        Iterator<com.ss.android.lark.image.uploader.entity.b> r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L25;
        com.ss.android.lark.image.uploader.entity.b r4 = r11.next();
        int r5 = a(r4, r0);
        int r7 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("FileTypeChecker", "checkValid, image:" + r4 + ", ret:" + r5);
        if (r5 == 0) goto L19;
        return new a(r5, r4, 28);
    L25:
        return new a(0, null, 30);
    L26:
        int r12 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("FileTypeChecker", "FileTypeCheckConfig close, config:" + r2 + ", setting:" + r3 + ",  skip");
        return new a(0, null, 30);
    L12:
        r3 = false;
    L7:
        r2 = r1.a();
        goto L10
    }

    public static int a(com.ss.android.lark.image.uploader.entity.b r12, flb.a r13) {
        Intrinsics.checkNotNullParameter(r12, "uploadImage");
        PolarisFileWrapper r1 = new PolarisFileWrapper(r12.a);
        if (r1.exists() == true) goto L6;
        int r14 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.b("FileTypeChecker", "checkValidFailed, file not exist:" + r12, null, false);
        return -10002;
    L6:
        ImageInfo r0 = r12.k;
        if (r0 == null) goto L10;
        String r2 = r0.e;
        if (r2 == null) goto L10;
    L11:
        int r3 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("FileTypeChecker", "checkValid, mimeType:" + r2 + ", image:" + r12);
        ImageInfo r4 = r12.k;
        if (r4 != null) goto L14;
        r4 = com.ss.android.lark.image.uploader.utils.b.d(r12.a, true, false);
        r12.k = r4;
    L14:
        if (r4 != null) goto L16;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == true) goto L24;
        com.ss.android.lark.image.uploader.utils.c.b("FileTypeChecker", "can't decode, image:" + r12, null, false);
        return -10004;
    L24:
        if (r13 == null) goto L26;
        boolean r15 = r13.a;
    L27:
        Lazy r16 = ConfigManager.a;
        if (r15 == false) goto L32;
        d r17 = ConfigManager.a().getFileTypeConfig();
        if (r17 == null) goto L35;
        ArrayList<String> r18 = r17.b();
    L36:
        if (r18 == null) goto L38;
        List r19 = CollectionsKt.filterNotNull(r18);
    L39:
        if (r19 != null) goto L41;
        r19 = CollectionsKt.emptyList();
    L41:
        Intrinsics.checkNotNull(r2);
        if (TextUtils.isEmpty(r2) == false) goto L45;
        boolean r110 = false;
    L48:
        if (r110 == false) goto L50;
        return 0;
    L50:
        if (TextUtils.equals(r2, "*/*") == true) goto L55;
        return -10005;
    L55:
        return 0;
    L45:
        if (StringsKt.contains$default(r2, "/", false, 2, null) == true) goto L47;
        r110 = r19.contains(r2.toLowerCase());
        goto L48
    L47:
        String r111 = r2.substring(Math.min(r2.length() - 1, StringsKt.lastIndexOf$default(r2, '/', 0, false, 6, null) + 1));
        com.ss.android.lark.image.uploader.utils.c.c("FileTypeChecker", "image subType:" + r111);
        r110 = r19.contains(r111.toLowerCase());
        goto L48
    L38:
        r19 = null;
    L35:
        r18 = null;
        goto L36
    L32:
        d r112 = ConfigManager.a().getFileTypeConfig();
        if (r112 == null) goto L35;
        r18 = r112.c();
        goto L36
    L26:
        r15 = false;
        goto L27
    L16:
        if (r4.a <= 0) goto L20;
        if (r4.b <= 0) goto L20;
        r5 = true;
    L10:
        String[] r6 = FileUtils.a;
        r2 = FileUtils.p(r1.getPath());
        goto L11
    }
}
