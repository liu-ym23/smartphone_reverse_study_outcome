package com.ss.android.lark.diskmanage.storage;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.l;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Deprecated(message = "direct native path is not allowed, plz use LarkFileStorage instead", replaceWith = @ReplaceWith(expression = "LarkFileStorage", imports = {}))
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.b(r1) + "/avatar/";
        FileUtils.t(r2);
        return r2;
    }

    public static String b(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.a(r1) + "/download/";
        FileUtils.t(r2);
        return r2;
    }

    public static String c(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r7 = r6.getFilesDir().getPath();
        Intrinsics.checkNotNull(r7);
        return r7.substring(0, StringsKt.lastIndexOf$default(r7, "/", 0, false, 6, null)) + "/databases/";
    }

    public static String d(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.b(r1) + "/drive/";
        FileUtils.t(r2);
        return r2;
    }

    public static String e(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.b(r1) + "/picture/";
        FileUtils.t(r2);
        return r2;
    }

    public static String f(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.a(r1) + "/glide_cache/";
        FileUtils.t(r2);
        return r2;
    }

    public static String g(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.a(r1) + "/image_cache/";
        FileUtils.t(r2);
        return r2;
    }

    public static String h(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.a(r1) + "/image_compressed/";
        FileUtils.t(r2);
        return r2;
    }

    public static String i(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        File r2 = r1.getCacheDir();
        if (r2 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r2.getPath();
    }

    public static String j(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        File r2 = r1.getFilesDir();
        if (r2 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r2.getPath();
    }

    public static String k(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
        if (DevEnvUtil.isDevelopPackage(r1) == false) goto L6;
        return o(r1);
    L6:
        return n(r1);
    }

    public static String l(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r3 = l.d(r2) + "/Lark/";
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L5;
        r0.mkdir();
    L5:
        return r3;
    }

    public static String m(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        File r2 = r1.getExternalCacheDir();
        if (r2 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r2.getPath();
    }

    public static String n(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return l.c(r1) + "/Journal/";
    }

    public static String o(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return l.b(r1) + "/Journal/";
    }

    public static String p(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = c(r1) + "sdk_storage/";
        FileUtils.t(r2);
        return r2;
    }

    public static String q(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.a(r1) + "/share_temp/";
        FileUtils.t(r2);
        return r2;
    }

    public static String r(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.a(r1) + "/update/";
        FileUtils.t(r2);
        return r2;
    }

    public static String s(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = l.a(r1) + "/video_cache/";
        FileUtils.t(r2);
        return r2;
    }
}
