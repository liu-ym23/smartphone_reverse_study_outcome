package com.bytedance.android.livesdk.gift.platform.core.interceptor;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.r;
import com.bytedance.android.livesdk.revenue.network.d;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.bytedance.android.livesdk.revenue.network.a {
    public a() {
    }

    public final void E(String r4, d r5, com.bytedance.android.live.network.response.d.b r6) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "response");
        Object r7 = ((ExtraResponse) r6).data;
        if ((r7 instanceof p2) == false) goto L23;
        p2 r8 = (p2) r7;
        r r9 = r8.getDsAlertInfo();
        if (r9 == null) goto L7;
        String r10 = r9.getSchemaUrl();
    L9:
        if (r10 != null) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == true) goto L24;
        r r13 = r8.getDsAlertInfo();
        if (r13 != null) goto L19;
        return;
    L19:
        if (r13.getSchemaUrl() == null) goto L26;
        h.b(s1.getContext(), u.a(r13.getSchemaUrl(), MapsKt.mapOf(new Pair[]{TuplesKt.to("icon", r13.getIcon()), TuplesKt.to("slogan", r13.getSlogan()), TuplesKt.to("background", r13.getBackground()), TuplesKt.to("title", r13.getTitle()), TuplesKt.to("left_button_text", r13.getLeftButtonText()), TuplesKt.to("right_button_text", r13.getRightButtonText()), TuplesKt.to("limit_scene", r13.getLimitScene()), TuplesKt.to("text", r13.getText())})));
        ApiServerException r14 = new ApiServerException(r13.getErrorCode());
        r14.setBlockNotice(true);
        throw r14;
    L26:
        return;
    L24:
        return;
    L11:
        if (r10.length() == 0) goto L14;
        r11 = false;
        goto L15
    L7:
        r10 = null;
        goto L9
    }
}
