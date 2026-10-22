package com.larus.common.account.phone;

import com.larus.account.base.model.PhoneLoginAccountDiscoverySource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class PhoneLogin$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PhoneLoginAccountDiscoverySource.values().length];
        r0[PhoneLoginAccountDiscoverySource.VERIFICATION_CODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r0[PhoneLoginAccountDiscoverySource.CARRIER_ONE_KEY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        a = r0;
    }
}
