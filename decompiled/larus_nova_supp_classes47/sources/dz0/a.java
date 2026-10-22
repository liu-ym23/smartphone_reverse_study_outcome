package dz0;

import android.net.Uri;
import bz0.k;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.platform.aio.settings.GiftPanelOptSettingsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k57.c;
import k57.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import qy0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final Uri a;
    public final k b;
    public final Map<String, Object> c;

    public final Uri a() {
        x0 r0 = new x0(this.a);
        int r1 = qy0.a.a;
        Uri r2 = this.a;
        Map<String, Object> r3 = this.c;
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "lynxCreateParams");
        Intrinsics.checkNotNullParameter(r2, "uri");
        String r5 = UriProtector.getQueryParameter(r2, "aio_params");
        if (r5 != null) goto L5;
        r5 = "{}";
    L5:
        k57.a r6 = (k57.a) GsonProtectorUtils.fromJson(l97.a.a, r5, TypesJVMKt.getJavaType(Reflection.typeOf(k57.a.class)));
        String r4 = r2.toString();
        Intrinsics.checkNotNullParameter(r4, "templateUrl");
        Intrinsics.checkNotNullParameter(r3, "lynxCreateParams");
        Intrinsics.checkNotNullParameter(r3, "lynxCreateParams");
        b r7 = new b(r4, r3);
        Intrinsics.checkNotNullParameter(r6, "initialModel");
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = r6.o7().entrySet().iterator();
    L6:
        Boolean r10 = null;
        if (r9.hasNext() == false) goto L14;
        Map.Entry r12 = (Map.Entry) r9.next();
        String r13 = (String) r12.getKey();
        d r14 = (d) r12.getValue();
        Intrinsics.checkNotNullParameter(r14, "propertyInfo");     // Catch: Throwable -> L11
        Object r15 = r3.get(r14.P6());     // Catch: Throwable -> L11
        GiftPanelOptSettingsKt.a();     // Catch: Throwable -> L11
        k57.b r16 = new k57.b(r15, null);     // Catch: Throwable -> L11
    L13:
        r8.put(r13, r16);
    L11:
        th = move-exception;
        r16 = new k57.b(null, th);
        goto L13
    L14:
        Iterator r17 = r6.V0().entrySet().iterator();
    L16:
        if (r17.hasNext() == false) goto L23;
        Map.Entry r18 = (Map.Entry) r17.next();
        String r19 = (String) r18.getKey();
        Object r20 = r7.a((c) r18.getValue(), r8);     // Catch: Throwable -> L20
        GiftPanelOptSettingsKt.a();     // Catch: Throwable -> L20
        k57.b r22 = new k57.b(r20, null);     // Catch: Throwable -> L20
    L22:
        r8.put(r19, r22);
    L20:
        th = move-exception;
        r22 = new k57.b(null, th);
        goto L22
    L23:
        k r23 = this.b;
        Intrinsics.checkNotNullParameter("aio_params", "key");
        r0.a.remove("aio_params");
        b(r0, r23.a, "width");
        b(r0, r23.b, "height");
        b(r0, r23.c, "gravity");
        b(r0, r23.d, "radius_top_left");
        b(r0, r23.e, "radius_top_right");
        b(r0, r23.f, "radius_bottom_right");
        b(r0, r23.g, "radius_bottom_left");
        b(r0, r23.h, "pull_down_close");
        b(r0, r23.i, "pull_down_height");
        b(r0, r23.j, "pull_down_indicator_not_show");
        b(r0, r23.k, "pull_down_indicator_color");
        b(r0, r23.l, "show_back");
        b(r0, r23.m, "show_close");
        Boolean r24 = r23.n;
        if (r24 == null) goto L26;
        r10 = Boolean.valueOf(!r24.booleanValue());
    L26:
        b(r0, r10, "mask_click_disable");
        b(r0, r23.o, "enable_share");
        b(r0, r23.p, "height_percent");
        b(r0, r23.q, "width_percent");
        b(r0, r23.r, "rate_height");
        return r0.c();
    }

    public a(Uri r2, k r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "initialUri");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "initialParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static void b(x0 r1, Object r2, String r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof Boolean) == true) goto L7;
        String r4 = r2.toString();
    L11:
        r1.b(r3, r4);
        return;
    L7:
        if (((Boolean) r2).booleanValue() == false) goto L9;
        r4 = DataType.TRUE;
        goto L11
    L9:
        r4 = DataType.FALSE;
        goto L11
    }
}
