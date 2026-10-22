package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 5, 1})
final class KmpAssetsUtils$checkDiskSizeOpt$2 extends Lambda implements Function0<Boolean> {
    public static final KmpAssetsUtils$checkDiskSizeOpt$2 INSTANCE = null;

    static {
        INSTANCE = new KmpAssetsUtils$checkDiskSizeOpt$2();
    }

    public KmpAssetsUtils$checkDiskSizeOpt$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m201invoke() {
        return ((Boolean) a0.m.getValue(null, a0.a[11])).booleanValue();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m201invoke());
    }
}
