package com.bytedance.android.livesdk.gift.util;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import cy0.j;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import mz0.i;
import mz0.n;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class GiftPanelIconLoadListener implements p0 {
    public static final ReadOnlyProperty e = null;
    public static final Lazy f = null;
    public static final a g = null;
    public long a;
    public k b;
    public String c;
    public final GiftContext d;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "GIFT_ICON_LOAD_MONITOR_THRESHOLD", "getGIFT_ICON_LOAD_MONITOR_THRESHOLD()I", 0))};
        }

        public a() {
        }
    }

    public final void d(ImageInfo r1) {
    }

    public abstract Map<String, String> g();

    static {
        g = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_icon_load_monitor_threshold", 800, Integer.TYPE, false);
        KProperty r10 = a.a[0];
        e = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
        f = LazyKt.lazy(GiftPanelIconLoadListener$Companion$giftPanelIconMonitorThreshold$2.INSTANCE);
    }

    public GiftPanelIconLoadListener(GiftContext r1) {
        this.d = r1;
    }

    public final void e(k r3) {
        this.a = System.currentTimeMillis();
        this.b = r3;
    }

    public final void f(Map<String, String> r6) {
        GiftContext r0 = this.d;
        if (r0 == null) goto L6;
        r6.put("panel_open_times", String.valueOf(r0.getPanelOpenTimes()));
        r6.put("stay_room_duration", String.valueOf((System.currentTimeMillis() - r0.getEnterRoomTime()) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        r6.put("panel_open_duration", String.valueOf(System.currentTimeMillis() - ((Number) r0.getGiftPanelFirstRenderTs().getValue()).longValue()));
        return;
    }

    public final void a(ImageInfo r5, Animatable r6) {
        long r0 = System.currentTimeMillis() - this.a;
        g.getClass();
        if (r0 > ((Number) f.getValue()).intValue()) goto L5;
        return;
    L5:
        Map<String, String> r7 = g();
        r7.put("duration", String.valueOf(r0));
        r7.put("status", "0");
        String r1 = this.c;
        if (r1 != null) goto L8;
        r1 = BuildConfig.FLAVOR;
    L8:
        r7.put("image_size", r1);
        if ((r5 instanceof CloseableBitmap) == true) goto L11;
        r5 = null;
    L11:
        CloseableBitmap r8 = (CloseableBitmap) r5;
        if (r8 != null) goto L14;
    L24:
        f(r7);
        n r9 = new n();
        Map r2 = r9.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r2.putAll(r7);
        cy0.e.a.getClass();
        j r3 = cy0.e.a.a;
        m.e.getClass();
        Object r4 = m.b(r3).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r4);
        ((f80.a) r4).w3("livesdk_gift_icon_load", r9.a, r9.b);
        jy0.b.c("ttlive_gift_icon", "load gift icon success,  " + r7, null, 4);
        return;
    L14:
        if (r8.isHitMemoryCache() == false) goto L17;
        String r10 = String.valueOf(1);
    L23:
        r7.put("image_source", r10);
        goto L24
    L17:
        if (r8.isHitDiskCache() == false) goto L20;
        r10 = String.valueOf(2);
        goto L23
    L20:
        if (r8.isRequestInternet() == false) goto L22;
        r10 = String.valueOf(3);
        goto L23
    L22:
        r10 = String.valueOf(0);
        goto L23
    }

    public void b(k r10, Exception r11) {
        Map<String, String> r0 = g();
        r0.put("duration", String.valueOf(System.currentTimeMillis() - this.a));
        r0.put("error_msg", String.valueOf(r11.getMessage()));
        f(r0);
        if (com.bytedance.android.livesdk.gift.platform.business.i.h().w0() == false) goto L5;
        r0.put("domain_opt", "1");
    L7:
        if (w12.b.a() == false) goto L9;
        r0.put("domain_check", "1");
    L11:
        if (r10 == null) goto L13;
        List r1 = r10.getUrls();
    L15:
        if (r1 != null) goto L17;
        r0.put(sz1.a.KEY_LOCAL_ICON_BITMAP, "-1");
    L23:
        boolean r2 = true;
        if (r10 == null) goto L31;
        List r4 = r10.getUrls();
        if (r4 == null) goto L31;
        Iterator r5 = r4.iterator();
        int r6 = 0;
    L29:
        if (r5.hasNext() == false) goto L31;
        r0.put("url" + r6, (String) r5.next());
        r6 = r6 + 1;
    L31:
        r0.put("status", "1");
        n r3 = new n();
        Map r7 = r3.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        cy0.e.a.getClass();
        j r8 = cy0.e.a.a;
        m.e.getClass();
        Object r9 = m.b(r8).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_gift_icon_load", r3.a, r3.b);
        int r13 = com.bytedance.android.livesdk.gift.platform.business.i.h().M3();
        if (r13 > 0) goto L34;
    L71:
        jy0.b.c("ttlive_gift_icon", "load gift icon failed, " + r0, null, 4);
        return;
    L34:
        if (com.bytedance.android.livesdk.gift.platform.business.i.h().w0() == false) goto L71;
        GiftDataStorageService r14 = s.b();
        if (r14 == null) goto L71;
        if (r14.j.size() <= r13) goto L40;
        GiftListRepo r15 = GiftListRepo.k;
        int r16 = r14.j.size();
        r15.getClass();
        GiftListRepo.e(r16, "image");
    L40:
        if (r10 == null) goto L42;
        String r17 = r10.getUri();
    L43:
        if (r17 != null) goto L45;
    L48:
        boolean r18 = true;
    L49:
        String r19 = BuildConfig.FLAVOR;
        if (r18 == true) goto L58;
        LinkedHashSet<String> r20 = r14.j;
        if (r10 == null) goto L57;
        String r110 = r10.getUri();
        if (r110 == null) goto L57;
        r19 = r110;
    L57:
        r20.add(r19);
        goto L71
    L58:
        String r21 = r0.get("gift_id");
        if (r21 != null) goto L61;
    L70:
        r14.j.add(String.valueOf(System.currentTimeMillis()));
        goto L71
    L61:
        if (r21.length() == 0) goto L64;
        r2 = false;
    L64:
        if (r2 == true) goto L70;
        LinkedHashSet<String> r23 = r14.j;
        String r111 = r0.get("gift_id");
        if (r111 == null) goto L69;
        r19 = r111;
    L69:
        r23.add(r19);
        goto L71
    L45:
        if (r17.length() == 0) goto L48;
        r18 = false;
        goto L49
    L42:
        r17 = null;
        goto L43
    L17:
        if (r10 == null) goto L21;
        List r24 = r10.getUrls();
        if (r24 == null) goto L21;
        Integer r25 = Integer.valueOf(r24.size());
    L22:
        r0.put(sz1.a.KEY_LOCAL_ICON_BITMAP, String.valueOf(r25.intValue()));
    L21:
        r25 = null;
        goto L22
    L13:
        r1 = null;
        goto L15
    L9:
        r0.put("domain_check", "0");
        goto L11
    L5:
        r0.put("domain_opt", "0");
        goto L7
    }

    public void c(k r1, int r2, int r3, boolean r4) {
        StringBuilder r5 = new StringBuilder();
        r5.append(r2);
        r5.append('-');
        r5.append(r3);
        this.c = r5.toString();
    }
}
