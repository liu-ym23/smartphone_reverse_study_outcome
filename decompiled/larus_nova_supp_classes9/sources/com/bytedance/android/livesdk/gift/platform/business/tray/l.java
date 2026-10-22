package com.bytedance.android.livesdk.gift.platform.business.tray;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends NormalGiftMessage {
    public int R;
    public py.k S;
    public String T;
    public py.k U;
    public String V;
    public String W;
    public long X;
    public int Y;
    public py.k Z;
    public Long k0;

    public static final class a {
    }

    static {
    }

    public final boolean A() {
        if ((this.R & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage
    public final long getTotalMoney() {
        Long r0 = this.k0;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.longValue();
    }

    public final String y() {
        if (A() == false) goto L6;
        return "6";
    L6:
        boolean r2 = true;
        if ((this.R & 2) != 2) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        return "0";
    L12:
        if (this.U != null) goto L15;
        r2 = false;
    L15:
        if (r2 == false) goto L17;
        return "8";
    L17:
        return "7";
    L9:
        r0 = false;
        goto L10
    }

    public l(long r3) {
        super(0, r3);
        this.T = BuildConfig.FLAVOR;
        this.V = BuildConfig.FLAVOR;
        this.W = BuildConfig.FLAVOR;
        this.X = 2000;
        this.Y = 1;
        this.k0 = 0L;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(NormalGiftMessage r1) {
        return h(r1);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage
    public final int h(NormalGiftMessage r7) {
        if (r7 != null) goto L6;
        return 0;
    L6:
        if (getTotalMoney() == r7.getTotalMoney()) goto L10;
        return super.h(r7);
    L10:
        if ((r7 instanceof l) == true) goto L13;
        return 1;
    L13:
        if (A() == false) goto L18;
        if (((l) r7).A() == true) goto L18;
        return 1;
    L18:
        if (A() == false) goto L20;
    L23:
        return 0;
    L20:
        if (((l) r7).A() == false) goto L23;
        return -1;
    }
}
