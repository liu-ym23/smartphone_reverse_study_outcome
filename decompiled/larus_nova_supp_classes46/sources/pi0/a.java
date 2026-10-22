package pi0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.fk1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import ne0.g;
import rj0.k;
import rj0.l;
import sh0.h0;
import sh0.i0;
import sh0.j0;
import ti6.f;
import uf2.m1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(DataCenter r21, f r22, int r23) {
        Intrinsics.checkNotNullParameter(r22, "region");
        i0 r2 = j0.a(r21);
        if (r2 == null) goto L11;
        g r3 = r2.b;
        if (r3 == null) goto L7;
        int r5 = h0.a;
        Boolean r4 = (Boolean) r3.a("is_xplay_mixing");
    L9:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) != true) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L14;
        return;
    L14:
        if (r23 == 7) goto L16;
        if (r23 == 1) goto L16;
        return;
    L16:
        ALogger.d("MixerAdapterStreamUtils", "checkFitRtcMixRegion, region: width=" + r22.f + ", height=" + r22.g + ", x=" + r22.d + ", y=" + r22.e + ", renderMode=" + r22.s + ',');
        ReadOnlyProperty r7 = vm2.d.z4;
        KProperty[] r10 = vm2.d.a;
        fk1 r1 = (fk1) ((Map) r7.getValue(null, r10[283(0x11b, float:3.97E-43)])).get(Integer.valueOf(r23));
        if (r1 == null) goto L19;
        float r8 = r1.a();
    L20:
        double r11 = r22.f;
        double r13 = r8;
        double r9 = r11 * r13;
        double r12 = r22.g;
        double r14 = r13 * r12;
        double r15 = r22.d + (r11 - r9);
        double r16 = r22.e + ((r12 - r14) / ((double) 2));
        r22.f = r9;
        r22.g = r14;
        r22.d = r15;
        r22.e = r16;
        r22.s = 2;
        if (((Boolean) vm2.d.i3.getValue(null, r10[214(0xd6, float:3.0E-43)])).booleanValue() == false) goto L29;
        com.bytedance.android.live.liveinteract.plantform.base.a.g0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a() == null) goto L29;
        com.bytedance.android.live.liveinteract.plantform.base.a r17 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        Intrinsics.checkNotNull(r17);
        if (r17.R1() == null) goto L29;
        k.m2.getClass();
        k r18 = k.a.a();
        Intrinsics.checkNotNull(r18);
        if (r18.G7() == true) goto L29;
        k r19 = k.a.a();
        Intrinsics.checkNotNull(r19);
        r19.Yg();
        com.bytedance.android.live.liveinteract.plantform.base.a r20 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        Intrinsics.checkNotNull(r20);
        hg6.g r24 = r20.R1();
        Intrinsics.checkNotNull(r24);
        r24.f();
    L29:
        ALogger.d("MixerAdapterStreamUtils", "checkFitRtcMixRegion, sizeRation: " + r8 + ", newRegion: width=" + r22.f + ", height=" + r22.g + ", x=" + r22.d + ", y=" + r22.e + ", renderMode=" + r22.s + ',');
        return;
    L19:
        r8 = 1.0f;
        goto L20
    L7:
        r4 = null;
    L11:
        r6 = false;
        goto L12
    }

    public static void b(DataCenter r1, m1.b r2, boolean r3, int r4) {
        i0 r5 = j0.a(r1);
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L19;
        if (r3 == false) goto L20;
        l.n2.getClass();
        if (l.a.a() != null) goto L13;
        return;
    L13:
        if (r4 == 7) goto L15;
        if (r4 == 1) goto L15;
        return;
    L15:
        ALogger.d("MixerAdapterStreamUtils", "setLayerFitOnMixing");
        if (r2 == null) goto L23;
        r2.g();
        return;
    L23:
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r5.g() != true) goto L7;
        r6 = true;
        goto L8
    }
}
