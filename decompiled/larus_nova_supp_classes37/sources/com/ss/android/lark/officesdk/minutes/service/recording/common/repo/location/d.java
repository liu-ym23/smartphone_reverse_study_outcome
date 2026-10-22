package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final LarkLocation a;
    public final String b;
    public final POIInfo c;
    public final boolean d;
    public final boolean e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        LarkLocation r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        POIInfo r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        int r9 = 1231;
        if (this.d == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r8 + r10) * 31;
        if (this.e == true) goto L23;
        r9 = 1237;
    L23:
        return r11 + r9;
    L17:
        r10 = 1237;
        goto L18
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingLocationEntity(mmLocation=" + this.a + ", mmPOIAddress=" + this.b + ", poiInfo=" + this.c + ", hasMapSnapshotSuccess=" + this.d + ", hasLocationUploaded=" + this.e + ')';
    }

    public /* synthetic */ d(int r7) {
        this(null, null, null, false, false);
    }

    public d(LarkLocation r1, String r2, POIInfo r3, boolean r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public static d a(d r6, LarkLocation r7, String r8, POIInfo r9, boolean r10, boolean r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        LarkLocation r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.b;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.c;
    L11:
        POIInfo r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.d;
    L14:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L17;
        r11 = r6.e;
    L17:
        r6.getClass();
        return new d(r1, r2, r3, r4, r11);
    }
}
