package com.bytedance.android.livesdk.gift.platform.business.config;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DiamondConfig {
    public static final Lazy c = null;
    public static final a d = null;
    public final py.k a;
    public final String b;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static DiamondConfig a() {
            GiftPanelBizBoostUtils.E.getClass();
            if (((Boolean) GiftPanelBizBoostUtils.r.getValue()).booleanValue() == false) goto L7;
            return (DiamondConfig) DiamondConfig.c.getValue();
        L7:
            return new DiamondConfig(r3.a(), r3.c(), r3.b(), BuildConfig.FLAVOR);
        }
    }

    public DiamondConfig() {
        py.k r0 = null;
        this(r0, r0, r0, 15);
    }

    static {
        d = new a();
        c = LazyKt.lazy(DiamondConfig$Companion$defaultInst$2.INSTANCE);
    }

    public /* synthetic */ DiamondConfig(py.k r4, String r5, String r6, int r7) {
        String r1 = null;
        if ((r7 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = BuildConfig.FLAVOR;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r6 = BuildConfig.FLAVOR;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r1 = BuildConfig.FLAVOR;
    L14:
        this(r4, r5, r6, r1);
    }

    public DiamondConfig(py.k r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "diamondSuffix");
        Intrinsics.checkNotNullParameter(r4, "diamondSuffixShort");
        Intrinsics.checkNotNullParameter(r5, "lowerDiamondSuffix");
        this.a = r2;
        this.b = r4;
    }
}
