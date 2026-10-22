package com.bytedance.android.livesdk.downloader;

import com.bytedance.android.livesdk.gift.configmodel.z;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.GiftResourceManager;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class GiftResourceManagerFactory {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(GiftResourceManagerFactory$downloaderManagerTypeOpt$2.INSTANCE);
    }

    public static e a() {
        if (((z) a.getValue()).getEnable() == true) goto L5;
        GiftResourceManager r0 = GiftResourceManager.h;
        if (r0 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        return r0;
    L11:
        throw new IllegalStateException("GiftResourceManager is not initialized");
    L5:
        return NewGiftResourceManager.m;
    }
}
