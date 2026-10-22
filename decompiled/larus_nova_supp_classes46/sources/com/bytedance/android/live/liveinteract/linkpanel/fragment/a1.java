package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a1 implements View.OnClickListener {
    public final /* synthetic */ VideoTalkSettingFragment a;

    public a1(VideoTalkSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.p(this.a.n) == false) goto L9;
        u6 r0 = new u6(vm2.d.Q().b());
        r0.b("request_page", "link_setting_panel");
        if (this.a.getRoom().isLiveTypeAudio() == false) goto L7;
        String r10 = "1";
    L8:
        r0.b("show_room_item", r10);
        String r11 = UriProtector.parse(vm2.d.Q().a()).buildUpon().appendQueryParameter("url", r0.toString()).build().toString();
        jc1.k.n(IBaseLiveActionHandler.class).handle(this.a.getContext(), r11);
        this.a.d.dismiss();
        return;
    L7:
        r10 = "0";
        goto L8
    L9:
        VideoTalkSettingFragment r12 = this.a;
        DataCenter r2 = r12.n;
        if (r2 == null) goto L14;
        yf0.g r7 = r12.d;
        int r1 = MultiLinkIntegrationPlayMethodFragment.q;
        r7.Rh(MultiLinkIntegrationPlayMethodFragment.a.a(r7, r12.getRoom(), r2, this.a.s, null, 1, true));
        return;
    }
}
