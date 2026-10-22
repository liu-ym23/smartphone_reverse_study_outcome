package com.ss.android.lark.chameleonv2.container.webcontainer.util;

import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChameleonDebugUtils {
    public static final com.ss.android.lark.storage.a a = null;
    public static final Lazy b = null;

    static {
        a = new com.ss.android.lark.storage.a("chameleon");
        b = LazyKt.lazy(ChameleonDebugUtils$kvRepo$2.INSTANCE);
    }

    public static KVRepo b() {
        return (KVRepo) b.getValue();
    }

    public static String a() {
        return b().getString("chameleon_ip_proxy_bizname", null);
    }

    public static String c(String r7) {
        if (b.a() == false) goto L36;
        boolean r0 = true;
        if (r7 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L36;
        if (b().getBoolean("chameleon_disable_ip_proxy", false) == false) goto L16;
        return BuildConfig.FLAVOR;
    L16:
        String r4 = a();
        if (r4 != null) goto L19;
        r4 = BuildConfig.FLAVOR;
    L19:
        String r5 = b().getString("chameleon_ip_proxy_url", null);
        if (r5 != null) goto L23;
        r5 = BuildConfig.FLAVOR;
    L23:
        if (r4.length() <= 0) goto L25;
        boolean r6 = true;
    L26:
        if (r6 == false) goto L36;
        if (r5.length() > 0) goto L31;
        r0 = false;
    L31:
        if (r0 == false) goto L36;
        if (Intrinsics.areEqual(r7, r4) == false) goto L36;
        j.e("CML_TAG_ChameleonDebugUtils", "Using proxy URL for biz: " + r7 + ", proxy: " + r5);
        return r5;
    L25:
        r6 = false;
        goto L26
    L7:
        if (r7.length() == 0) goto L10;
        r3 = false;
    L36:
        return BuildConfig.FLAVOR;
    }
}
