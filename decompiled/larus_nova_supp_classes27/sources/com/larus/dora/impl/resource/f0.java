package com.larus.dora.impl.resource;

import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraEnableScope.values().length];
            r0[DoraEnableScope.G1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DoraEnableScope.G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DoraEnableScope.G_SERIES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final String a(DoraEnableScope r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return DoraObricDeviceHomeViewModel.PRODUCT_CODE_G1;
    L5:
        if (r2 != 2) goto L7;
        return DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2;
    L7:
        if (r2 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    L11:
        throw new IllegalStateException("G_SERIES is not a device grant".toString());
    }
}
