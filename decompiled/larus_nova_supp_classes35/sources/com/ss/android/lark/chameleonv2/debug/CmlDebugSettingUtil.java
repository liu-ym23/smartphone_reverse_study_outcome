package com.ss.android.lark.chameleonv2.debug;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CmlDebugSettingUtil {
    public static final com.ss.android.lark.storage.a a = null;
    public static final Lazy b = null;

    static {
        a = new com.ss.android.lark.storage.a("chameleon");
        b = LazyKt.lazy(CmlDebugSettingUtil$kvRepo$2.INSTANCE);
    }

    public static String a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "defaultValue");
        String r3 = ((KVRepo) b.getValue()).getString(r1, r2);
        if (r3 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r3;
    }

    public static void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        ((KVRepo) b.getValue()).putString(r1, r2);
    }
}
