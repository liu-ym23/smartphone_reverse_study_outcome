package com.bytedance.android.livesdk.gift.blindbox;

import android.content.Context;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import py.k;
import zz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.bytedance.android.livesdk.gift.platform.business.dialog.topview.b {
    public Long k;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.b, com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void d() {
        e0 r0 = this.d;
        if (r0 == null) goto L5;
        String r1 = r0.uri;
    L18:
    L15:
        th = move-exception;
        jy0.b.b("GiftBannerView", "failed to open uri " + r1, th);
        return;
    L7:
        if (Intrinsics.areEqual((Boolean) this.f.get("data_is_portrait", Boolean.TRUE), Boolean.FALSE) == false) goto L9;
        ToastUtil.a(2131915307, 0);     // Catch: Throwable -> L15
        return;
    L9:
        c.b(r1, this.k);     // Catch: Throwable -> L15
        Context r2 = this.a.getContext();     // Catch: Throwable -> L15
        if (r1 != null) goto L12;
        String r3 = BuildConfig.FLAVOR;
    L13:
        h.a(r2, UriProtector.parse(r3));     // Catch: Throwable -> L15
        return;
    L12:
        r3 = r1;
        goto L13
    L5:
        r1 = null;
        goto L18
    }

    public a(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.b
    public final void i(k r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "imageModel");
        Intrinsics.checkNotNullParameter(r3, "imageModel");
        JSONObject r0 = new JSONObject();
        c.f(r0, "uri", String.valueOf(r3.getUri()));
        c.e("ttlive_blind_box_banner_res_status_all", r4, r0);
        jy0.b.a("ttlive_blind_box", "ttlive_blind_box_banner_res_status_all " + r0);
    }
}
