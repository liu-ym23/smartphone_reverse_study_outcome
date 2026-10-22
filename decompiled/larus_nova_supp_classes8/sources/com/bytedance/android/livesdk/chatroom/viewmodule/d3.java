package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d3 implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.android.livesdk.gift.model.b1 a;
    public final /* synthetic */ TopRightBannerWidget b;

    public d3(com.bytedance.android.livesdk.gift.model.b1 r1, TopRightBannerWidget r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Context r5 = ((Widget) this.b).context;
        com.bytedance.android.livesdk.gift.model.b1 r0 = this.a;
        int r1 = r0.getActionType();
        if (r1 != 2) goto L5;
        UrlBuilder r6 = new UrlBuilder(r0.getSchemaUrl());
        int r2 = com.bytedance.android.livesdk.utils.r0.a;
        r6.addParam("is_first_consume", String.valueOf(com.bytedance.android.livesdk.utils.r0.a(com.bytedance.android.livesdk.c.a().b())));
        xs2.b.a().post(new zg1.i2(r6.build()));
    L11:
        TopRightBannerWidget r7 = this.b;
        String r3 = String.valueOf(this.a.getId());
        int r8 = TopRightBannerWidget.q;
        r7.Cq(r3, "live_banner_click");
        return;
    L5:
        if (r1 == 3) goto L9;
        UrlBuilder r9 = new UrlBuilder(r0.getSchemaUrl());
        r9.addParam(LiveEndPageData.TAG_TITLE, r0.getTitle());
        Uri r10 = UriProtector.parse(r9.build());
        if (r10 == null) goto L11;
        String r11 = r10.toString();
        Bundle r12 = new Bundle();
        int r13 = com.bytedance.android.livesdk.c.a;
        jc1.k.n(IMiddlewareHostAction.class).handleSchema(r5, r11, r12);
        goto L11
    L9:
        jc1.k.f(IBaseBrowserService.class).buildFullScreenWebPage(r5, r0.getSchemaUrl()).setTitle(r0.getTitle()).b();
        goto L11
    }
}
