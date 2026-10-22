package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import bytedance.io.BdFileSystem;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AssetsUtils {
    public static long a;
    public static boolean b;
    public static final Lazy c = null;

    static {
        a = -1;
        c = LazyKt.lazy(AssetsUtils$cancelWriteSp$2.INSTANCE);
    }

    public static void a() {
        if (((Boolean) c.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = ay1.d.c;
        KProperty[] r1 = ay1.d.a;
        if (((Boolean) r0.getValue(null, r1[3])).booleanValue() == false) goto L9;
        jy0.b.c("AssetsUtils", "has init local resource", null, 4);
        return;
    L9:
        HashMap r2 = (HashMap) ay1.d.b.getValue(null, r1[2]);
        if (r2 != null) goto L12;
        r2 = new HashMap();
    L12:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e r3 = GiftResourceManagerFactory.a();
        if (r3 == null) goto L17;
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r4 = r3.a();
        if (r4 == null) goto L17;
        String r5 = r4.a();
    L18:
        if (r5 != null) goto L20;
        return;
    L20:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r5);
        if (r7.exists() == true) goto L23;
        jy0.b.c("AssetsUtils", "init local resource failed: not found root path: ".concat(r5), null, 4);
        return;
    L23:
        File[] r6 = r7.listFiles();
        HashSet r8 = new HashSet();
        int r9 = r6.length;
        int r10 = 0;
    L24:
        if (r10 >= r9) goto L33;
        File r11 = r6[r10];
        if (r11.exists() == false) goto L32;
        r8.add(r11.getPath());
        if (r2.get(r11.getPath()) != null) goto L32;
        r2.put(r11.getPath(), String.valueOf(System.currentTimeMillis()));
    L32:
        r10 = r10 + 1;
        goto L24
    L33:
        Intrinsics.checkNotNullParameter(r2, "filePathCache");
        KProperty[] r13 = ay1.d.a;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        com.bytedance.tools.kcp.spongepreference.runtime.a r14 = ay1.d.b;
        KProperty[] r15 = ay1.d.a;
        r14.setValue(null, r15[2], r2);
        ay1.d.c.setValue(null, r15[3], Boolean.TRUE);
        return;
    L17:
        r5 = null;
        goto L18
    }

    public static boolean b(boolean r8) {
        Boolean r2 = null;
        if (b == false) goto L13;
        if (a != (-1)) goto L8;
        a = BdFileSystem.getAvailableStorageSize(s1.getContext());
    L8:
        if (a >= ((Number) com.bytedance.android.livesdk.gift.platform.business.effect.b.f.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.b.a[4])).intValue()) goto L17;
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L17;
        return true;
    L17:
        wh6.a r1 = vh6.c.b(wh6.a.class);
        if (r1 == null) goto L21;
        r2 = Boolean.valueOf(r1.isDeepCleanDowngrade());
    L21:
        if (r2.booleanValue() == false) goto L24;
        if (r8 == true) goto L26;
        return true;
    L26:
        return false;
    L24:
        return false;
    L13:
        if (BdFileSystem.getAvailableStorageSize(s1.getContext()) >= ((Number) com.bytedance.android.livesdk.gift.platform.business.effect.b.f.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.b.a[4])).intValue()) goto L17;
        KmpEnv r3 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L17;
        return true;
    }

    public static void c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "filePath");
        if (((Boolean) c.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r10, "filePath");
        if (StringsKt.endsWith$default(r10, '/', false, 2, null) == false) goto L8;
        r10 = r10.substring(0, r10.length() - 1);
    L8:
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = ay1.d.b;
        KProperty[] r1 = ay1.d.a;
        HashMap r4 = (HashMap) r0.getValue(null, r1[2]);
        if (r4 != null) goto L11;
        r4 = new HashMap();
    L11:
        String r5 = (String) r4.get(r10);
        if (r5 != null) goto L15;
        r5 = "sp not record";
    L15:
        r4.put(r10, String.valueOf(System.currentTimeMillis()));
        jy0.b.a("AssetsUtils", "file " + r10 + " update at time " + ((String) r4.get(r10)) + " (last time : " + r5 + ')');
        Intrinsics.checkNotNullParameter(r4, "filePathCache");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.setValue(null, r1[2], r4);
        int r2 = StringsKt.lastIndexOf$default(r10, "/", 0, false, 6, null) + 1;
        if (r2 >= r10.length()) goto L23;
        String r11 = r10.substring(r2);
        if (r11 != null) goto L20;
        return;
    L20:
        if (r11.length() != 32) goto L25;
        int r3 = com.bytedance.android.livesdk.gift.platform.core.b.a;
        Intrinsics.checkNotNullParameter(r11, "assetMd5");
        return;
    L25:
        return;
    }
}
