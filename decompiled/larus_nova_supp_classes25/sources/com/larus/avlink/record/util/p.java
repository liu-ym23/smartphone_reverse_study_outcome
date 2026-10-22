package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.network.NetworkQualityType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements com.larus.network.k {
    public boolean a;
    public final /* synthetic */ NetworkAwareRetrier b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkQualityType.values().length];
            r0[NetworkQualityType.NO_NET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[NetworkQualityType.WEAK_NETWORK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[NetworkQualityType.NORMAL_NETWORK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public p(NetworkAwareRetrier r2) {
        this.b = r2;
        if (NetConnectionTypeProvider.a(NetConnectionTypeProvider.a) != NetworkQualityType.NO_NET) goto L5;
        boolean r3 = true;
    L6:
        this.a = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void a(NetworkQualityType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        this.a = true;
        return;
    L5:
        if (r3 == 2) goto L12;
        if (r3 == 3) goto L12;
        throw new NoWhenBranchMatchedException();
    L12:
        if (this.a == false) goto L16;
        this.a = false;
        n1.d(this.b.b, "wake up on network recovered");
        this.b.l.trySend-JP2dKIU(Unit.INSTANCE);
        return;
    }
}
