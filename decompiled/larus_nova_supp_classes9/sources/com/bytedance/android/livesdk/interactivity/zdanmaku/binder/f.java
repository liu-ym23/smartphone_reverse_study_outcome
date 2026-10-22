package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends tk6.e<BusinessConfigure, View> {
    public final cq1.b e;
    public final h80.d<p22.c> f;

    public f(cq1.b r5, h80.d<p22.c> r6) {
        Intrinsics.checkNotNullParameter(r5, "itemView");
        Intrinsics.checkNotNullParameter(r6, "businessDanmakuSettingConfigSupplier");
        super(r5.getView(), DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.e = r5;
        this.f = r6;
    }

    public final void b(Object r9, RenderEntity r10) {
        BusinessConfigure r11 = (BusinessConfigure) r9;
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r10, "entity");
        p22.c r0 = (p22.c) this.f.get();
        cq1.b r1 = this.e;
        p22.c.a r2 = r0.d;
        r1.a(r2.a, r2.b, r2.c, r2.d, r2.f, r2.e);
        BusinessResourceConfigure r3 = r11.resourceConfig;
        if (r3 != null) goto L5;
    L7:
        String r4 = String.valueOf(r11.businessId);
        BusinessResourceConfigure r5 = r11.resourceConfig;
        String r6 = BuildConfig.FLAVOR;
        if (r5 == null) goto L11;
        String r7 = String.valueOf(r5.resourceId);
        if (r7 == null) goto L11;
    L12:
        dq1.c r8 = pm1.f.k();
        if (r8 == null) goto L18;
        String r13 = r8.i(Long.valueOf(r11.businessType));
        if (r13 == null) goto L18;
        r6 = r13;
    L18:
        tc2.a r14 = new tc2.a(r4, r7, r6);
        r10.getClass();
        r10.a(tc2.a.class, r14);
        return;
    L11:
        r7 = BuildConfig.FLAVOR;
        goto L12
    L5:
        if (r3.barrageConfig == null) goto L7;
        this.e.b(r11, "business_info_landscape");
        goto L7
    }
}
