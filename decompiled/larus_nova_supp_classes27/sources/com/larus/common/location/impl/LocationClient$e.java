package com.larus.common.location.impl;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.api.CoordinateType;
import com.larus.platform.model.LocationResult;
import com.larus.utils.logger.FLogger;
import f06.b;
import f06.d;
import hq9.z2;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LocationClient$e implements BDLocationCallback {
    public final /* synthetic */ String a;
    public final /* synthetic */ CoordinateType b;
    public final /* synthetic */ z2 c;
    public final /* synthetic */ LocationClient d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CoordinateType.values().length];
            r0[CoordinateType.GCJ_O2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CoordinateType.WGS_84.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final void onError(BDLocationException r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("continuousLocate error with code:");
        if (r4 == null) goto L5;
        String r2 = r4.getCode();
    L6:
        r1.append(r2);
        r1.append(", identifier: ");
        r1.append(this.a);
        r0.e("LocationClient", r1.toString());
        z2 r3 = this.c;
        if (r3 == null) goto L14;
        if (r4 == null) goto L11;
        String r5 = r4.getCode();
        if (r5 == null) goto L11;
    L12:
        r3.onError(r5, LocationResult.SDK_INTERNAL_ERROR.toString());
        return;
    L11:
        r5 = "-1";
        goto L12
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onLocationChanged(BDLocation r21) {
        ArrayList r9 = new ArrayList();
        Object[] r11 = {r21};
        b r13 = new b();
        g06.a r0 = (g06.a) ApiHookConfig.b.get(101330);
        if (r0 == null) goto L5;
        f06.a[] r1 = r0.i;
    L6:
        f06.a[] r7 = r1;
        int r6 = r7.length;
        int r5 = 0;
    L8:
        if (r5 >= r6) goto L15;
        f06.a r3 = r7[r5];
        int r17 = r5;
        int r18 = r6;
        f06.a[] r110 = r7;
        d r2 = r3.preInvoke(101330, "com/larus/common/location/impl/LocationClient$continuousLocate$2", "onLocationChanged", this, r11, "void", r13);     // Catch: Exception -> L47
        if (r2.a == true) goto L12;
        r9.add(r3);     // Catch: Exception -> L47
        goto L14
    L12:
        Double r4 = null;
    L17:
        if (r2.a == false) goto L19;
        return;
    L19:
        if (r21 != null) goto L21;
        return;
    L21:
        FLogger.a.i("LocationClient", "continuousLocate success, identifier: " + this.a);
        int r8 = a.a[this.b.ordinal()];
        if (r8 != 1) goto L24;
        BDPoint r10 = r21.getGCJ02();
        if (r10 == null) goto L31;
        Double r12 = Double.valueOf(r10.getLongitude());
    L32:
        BDPoint r14 = r21.getGCJ02();
        if (r14 == null) goto L35;
        Double r15 = Double.valueOf(r14.getLatitude());
    L36:
        Double r16 = r15;
        Double r20 = r12;
    L37:
        if (r20 == null) goto L43;
        if (r16 == null) goto L43;
        z2 r22 = this.c;
        if (r22 == null) goto L53;
        LocationResult r23 = LocationResult.SUCCESS;
        LocationClient r24 = this.d;
        double r25 = r20.doubleValue();
        double r26 = r16.doubleValue();
        int r27 = LocationClient.o;
        r22.a(r23, r24.B(r21, r25, r26, null));
        return;
    L53:
        return;
    L43:
        z2 r28 = this.c;
        if (r28 == null) goto L55;
        r28.onError(LocationResult.NO_DATA.getMessage(), "");
        return;
    L55:
        return;
    L35:
        r15 = r4;
        goto L36
    L31:
        r12 = r4;
        goto L32
    L24:
        if (r8 != 2) goto L27;
        r20 = Double.valueOf(r21.getLongitude());
        r16 = Double.valueOf(r21.getLatitude());
        goto L37
    L27:
        throw new NoWhenBranchMatchedException();
    L14:
        r5 = r17 + 1;
        r6 = r18;
        r7 = r110;
        goto L8
    L15:
        r4 = null;
        r2 = new d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }

    public LocationClient$e(String r1, CoordinateType r2, z2 r3, LocationClient r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
