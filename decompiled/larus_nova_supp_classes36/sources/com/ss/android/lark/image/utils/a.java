package com.ss.android.lark.image.utils;

import android.os.StatFs;
import android.text.TextUtils;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.LarkContext;
import com.ss.lark.android.encryption.CipherManager;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static float a;
    public static boolean b;
    public static boolean c;
    public static boolean d;

    static {
        a = e();
        b = d();
        c = c();
    }

    @JvmStatic
    public static final boolean b() {
        Log.i("ImageCacheUtils", "diskNotSupportCache / isDiskSpaceLow: " + b + ", isDiskCacheException: " + d);
        if (b == false) goto L5;
    L8:
        return true;
    L5:
        if (d == true) goto L8;
        return false;
    }

    public static float e() {
        int r0 = com.ss.android.lark.diskmanage.storage.d.a;
        String r1 = com.ss.android.lark.diskmanage.storage.d.m(LarkContext.getApplication());
        boolean r2 = b.a;
        Intrinsics.checkNotNullParameter(r1, "dir");
        if (TextUtils.isEmpty(r1) == false) goto L11;
    L7:
        long r3 = 0;
    L8:
        a = (r3 / 1024.0f) / 1024.0f;
        Log.i("ImageCacheUtils", "getImageCacheFreeSize:" + a);
        return a;
    L11:
        FileUtils.t(r1);     // Catch: Throwable -> L10
        StatFs r4 = new StatFs(r1);     // Catch: Throwable -> L10
        r3 = r4.getBlockSizeLong() * r4.getAvailableBlocksLong();
        goto L8
    }

    @JvmStatic
    public static final boolean f() {
        Log.i("ImageCacheUtils", "isNoGlideCacheImage(), isDiskSpaceLow:" + b + ",isCipherEncrypt:" + c + ",isDiskCacheException:" + d);
        if (b == false) goto L5;
    L10:
        return true;
    L5:
        if (c == true) goto L10;
        if (d == true) goto L10;
        return false;
    }

    public static boolean c() {
        boolean r1 = true;
        if (ChatImageSettings.getGlideImageCache().getNoCacheEncrypt() == 1) goto L5;
    L7:
        r1 = false;
    L8:
        Log.i("ImageCacheUtils", "getCipherStatus, " + r1);
        return r1;
    L5:
        if (CipherManager.d() != 1) goto L7;
        goto L7
    }

    public static boolean d() {
        boolean r1 = true;
        if (ChatImageSettings.getGlideImageCache().getNoCacheOnLowDiskSpace() == 1) goto L5;
    L7:
        r1 = false;
    L8:
        Log.i("ImageCacheUtils", "getDiskSpaceStatus, " + r1);
        return r1;
    L5:
        if (e() >= ChatImageSettings.getGlideImageCache().getMinDiskSpace()) goto L7;
        goto L7
    }

    @JvmStatic
    public static final void a(String r1, int r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r1, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "extraCategory");
        switch(r2) {
            case 701007: goto L6;
            case 701008: goto L6;
            case 701009: goto L20;
            case 701010: goto L6;
            default: goto L20;
        };
    L20:
        r3.put("cache_free_size", Float.valueOf(a));
        r3.put("is_disk_space_low", Integer.valueOf(b ? 1 : 0));
        r3.put("is_cipher_encrypt", Integer.valueOf(c ? 1 : 0));
        r3.put("is_disk_cache_exception", Integer.valueOf(d ? 1 : 0));
        return;
    L6:
        if (b == true) goto L9;
        b = d();
    L9:
        if (c == true) goto L12;
        c = c();
    L12:
        if (d == true) goto L20;
        boolean r0 = true;
        if (ChatImageSettings.getGlideImageCache().getNoCacheOnDiskCacheException() == 1) goto L16;
    L18:
        r0 = false;
    L19:
        Log.i("ImageCacheUtils", "getDiskCacheStatus, " + r0);
        d = r0;
        goto L20
    L16:
        if (ImageLoader.getDependency().hasImageCache(r1) == false) goto L18;
        goto L18
    }
}
