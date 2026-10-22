package com.larus.dora.obric.device_management.device_home;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a2 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraObricDeviceModeEntryProduct.values().length];
            r0[DoraObricDeviceModeEntryProduct.G1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DoraObricDeviceModeEntryProduct.G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DoraObricDeviceModeEntryProduct.G_AIR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DoraObricDeviceModeEntryProduct.G_PIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DoraObricDeviceModeEntryProduct.UNSUPPORTED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final boolean a(DoraObricDeviceModeEntryProduct r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        return true;
    L5:
        if (r3 != 2) goto L7;
        return true;
    L7:
        if (r3 != 3) goto L9;
        return true;
    L9:
        if (r3 != 4) goto L11;
        return true;
    L11:
        if (r3 != 5) goto L14;
        return false;
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
