package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t {
    public static final Set<Integer> a = null;
    public static final Set<Integer> b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraObricDeviceHomeQuickActionType.values().length];
            r0[DoraObricDeviceHomeQuickActionType.DOUBAO_ASSISTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DoraObricDeviceHomeQuickActionType.RECORD_MINUTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DoraObricDeviceHomeQuickActionType.QUICK_NOTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DoraObricDeviceHomeQuickActionType.SIMULTANEOUS_INTERPRET.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DoraObricDeviceHomeQuickActionType.NOTIFICATION_BROADCAST.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
        ProductNameType r2 = ProductNameType.DORA_LITE;
        ProductNameType r3 = ProductNameType.H_FREE_CLIP_2;
        ProductNameType r5 = ProductNameType.H_FREE_CLIP_2_HE;
        ProductNameType r7 = ProductNameType.H_FREE_BUDS_PRO_5;
        a = SetsKt.setOf(new Integer[]{Integer.valueOf(r2.id), Integer.valueOf(r3.id), Integer.valueOf(r5.id), Integer.valueOf(r7.id)});
        b = SetsKt.setOf(new Integer[]{Integer.valueOf(r2.deviceType), Integer.valueOf(r3.deviceType), Integer.valueOf(r5.deviceType), Integer.valueOf(r7.deviceType)});
    }

    public static final boolean a(DoraDevice r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (o59.a.p(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (o59.a.o(Integer.valueOf(r1.productId)) == true) goto L8;
        return false;
    }

    public static final boolean b(DoraDevice r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (a.contains(Integer.valueOf(r2.productId)) == false) goto L5;
    L8:
        return true;
    L5:
        if (b.contains(Integer.valueOf(r2.type)) == true) goto L8;
        return false;
    }
}
