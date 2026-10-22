package com.ss.android.lark.image.uploader.config;

import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ConfigManager {
    public static final Lazy a = null;
    public static final ImageUploadConfig b = null;

    static {
        a = LazyKt.lazy(ConfigManager$config$2.INSTANCE);
        b = new ImageUploadConfig();
    }

    public static ImageUploadConfig a() {
        return (ImageUploadConfig) a.getValue();
    }

    public static long b() {
        c r0 = a().getFileSizeConfig();
        if (r0 != null) goto L10;
        c r1 = b.getFileSizeConfig();
        if (r1 != null) goto L11;
        return 52428800;
    L11:
        return r1.b();
    L10:
        return r0.b();
    }

    public static h f() {
        h r0 = a().getUploadAvatarConfig();
        if (r0 != null) goto L8;
        h r1 = b.getUploadAvatarConfig();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new h();
    L8:
        return r0;
    }

    public static long c(com.ss.android.lark.image.uploader.entity.b r2) {
        Intrinsics.checkNotNullParameter(r2, "uploadImage");
        c r0 = a().getFileSizeConfig();
        String r1 = null;
        if (r0 == null) goto L8;
        ImageInfo r3 = r2.k;
        if (r3 == null) goto L16;
        r1 = r3.e;
    L16:
        return r0.a(r1).a();
    L8:
        c r4 = b.getFileSizeConfig();
        if (r4 == null) goto L14;
        ImageInfo r5 = r2.k;
        if (r5 == null) goto L17;
        r1 = r5.e;
    L17:
        return r4.a(r1).a();
    L14:
        return 26214400;
    }

    public static int d(com.ss.android.lark.image.uploader.entity.b r3) {
        Intrinsics.checkNotNullParameter(r3, "uploadImage");
        c r0 = a().getFileSizeConfig();
        String r1 = null;
        if (r0 == null) goto L11;
        ImageInfo r2 = r3.k;
        if (r2 == null) goto L7;
        String r4 = r2.e;
    L8:
        f r5 = r0.a(r4).b();
        if (r5 == null) goto L11;
        return r5.a();
    L7:
        r4 = null;
    L11:
        c r6 = b.getFileSizeConfig();
        if (r6 == null) goto L19;
        ImageInfo r7 = r3.k;
        if (r7 == null) goto L16;
        r1 = r7.e;
    L16:
        f r8 = r6.a(r1).b();
        if (r8 == null) goto L19;
        return r8.a();
    L19:
        return 12000;
    }

    public static int e(com.ss.android.lark.image.uploader.entity.b r3) {
        Intrinsics.checkNotNullParameter(r3, "uploadImage");
        c r0 = a().getFileSizeConfig();
        String r1 = null;
        if (r0 == null) goto L11;
        ImageInfo r2 = r3.k;
        if (r2 == null) goto L7;
        String r4 = r2.e;
    L8:
        f r5 = r0.a(r4).b();
        if (r5 == null) goto L11;
        return r5.b();
    L7:
        r4 = null;
    L11:
        c r6 = b.getFileSizeConfig();
        if (r6 == null) goto L19;
        ImageInfo r7 = r3.k;
        if (r7 == null) goto L16;
        r1 = r7.e;
    L16:
        f r8 = r6.a(r1).b();
        if (r8 == null) goto L19;
        return r8.b();
    L19:
        return 12000;
    }
}
