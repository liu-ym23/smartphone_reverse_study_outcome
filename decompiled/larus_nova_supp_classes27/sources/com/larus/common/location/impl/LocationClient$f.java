package com.larus.common.location.impl;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.api.CoordinateType;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.larus.utils.logger.FLogger;
import f06.b;
import f06.d;
import hq9.a3;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LocationClient$f implements BDLocationCallback {
    public final /* synthetic */ long a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ LocateScene c;
    public final /* synthetic */ CoordinateType d;
    public final /* synthetic */ a3 e;
    public final /* synthetic */ LocationClient f;
    public final /* synthetic */ ScheduledFuture<?> g;

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

    public final void onError(BDLocationException r5) {
        if (this.b.element == false) goto L5;
        return;
    L5:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[");
        r1.append(this.c.name());
        r1.append("] singleLocate error with code:");
        if (r5 == null) goto L8;
        String r3 = r5.getCode();
    L9:
        r1.append(r3);
        r0.e("LocationClient", r1.toString(), r5);
        a3 r2 = this.e;
        LocationResult r4 = LocationResult.SDK_INTERNAL_ERROR;
        if (r5 == null) goto L14;
        String r6 = r5.getCode();
        if (r6 == null) goto L14;
        Integer r7 = StringsKt.toIntOrNull(r6);
    L15:
        a3.a.a(r2, r4, r7, null, 4);
        this.g.cancel(true);
        return;
    L14:
        r7 = null;
        goto L15
    L8:
        r3 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        d r2 = r3.preInvoke(101330, "com/larus/common/location/impl/LocationClient$doSingleLocate$2", "onLocationChanged", this, r11, "void", r13);     // Catch: Exception -> L47
        if (r2.a == true) goto L12;
        r9.add(r3);     // Catch: Exception -> L47
        goto L14
    L12:
        Integer r8 = null;
    L17:
        if (r2.a == false) goto L19;
        return;
    L19:
        long r4 = System.currentTimeMillis() - this.a;
        if (this.b.element == false) goto L22;
        return;
    L22:
        FLogger r10 = FLogger.a;
        r10.i("LocationClient", "[" + this.c.name() + "] singleLocate success, duration: " + r4 + "ms");
        if (r21 != null) goto L25;
        return;
    L25:
        int r12 = a.a[this.d.ordinal()];
        if (r12 == 1) goto L31;
        if (r12 != 2) goto L30;
        Double r14 = Double.valueOf(r21.getLongitude());
        Double r15 = Double.valueOf(r21.getLatitude());
    L40:
        if (r14 == 0) goto L44;
        if (r15 == 0) goto L44;
        a3 r16 = this.e;
        LocationResult r111 = LocationResult.SUCCESS;
        LocationClient r20 = this.f;
        double r22 = r14.doubleValue();
        double r112 = r15.doubleValue();
        int r23 = LocationClient.o;
        a3.a.a(r16, r111, r8, r20.B(r21, r22, r112, Float.valueOf(r21.getBearing())), 2);
    L45:
        this.g.cancel(true);
        return;
    L44:
        r10.i("LocationClient", "lng | lat is null");
        a3.a.a(this.e, LocationResult.NO_DATA, r8, r8, 6);
        goto L45
    L30:
        throw new NoWhenBranchMatchedException();
    L31:
        BDPoint r24 = r21.getGCJ02();
        if (r24 == null) goto L34;
        Object r25 = Double.valueOf(r24.getLongitude());
    L35:
        BDPoint r26 = r21.getGCJ02();
        if (r26 == null) goto L38;
        Object r27 = Double.valueOf(r26.getLatitude());
    L39:
        r15 = r27;
        r14 = r25;
        goto L40
    L38:
        r27 = r8;
        goto L39
    L34:
        r25 = r8;
    L14:
        r5 = r17 + 1;
        r6 = r18;
        r7 = r110;
        goto L8
    L15:
        r8 = null;
        r2 = new d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }

    public LocationClient$f(long r1, Ref.BooleanRef r3, LocateScene r4, CoordinateType r5, n r6, LocationClient r7, ScheduledFuture r8) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
