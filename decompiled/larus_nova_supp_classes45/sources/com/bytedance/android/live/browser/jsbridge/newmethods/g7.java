package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.LiveSwitchVSMultiTabResultModel;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g7 extends w20.m3<w20.hb, LiveSwitchVSMultiTabResultModel> {
    public final Activity a;
    public final DataCenter b;

    public final Activity getActivity() {
        return this.a;
    }

    public g7(Activity r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.hb r7 = (w20.hb) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r7.d() == null) goto L18;
        nm1.r r8 = pm1.f.o();
        if (r8 == null) goto L18;
        r8.a();
        MultiTabManagerImpl r9 = MultiTabManagerImpl.e;
        if (r9.h(this.b) != true) goto L18;
        nm1.r r1 = pm1.f.o();
        if (r1 == null) goto L18;
        r1.a();
        DataCenter r2 = this.b;
        Integer r3 = r7.d();
        if (r3 == null) goto L13;
        long r4 = r3.intValue();
    L15:
        if (r9.k(r2, r4) != true) goto L18;
        xs2.b r11 = xs2.b.a();
        Integer r12 = r7.d();
        Intrinsics.checkNotNull(r12);
        r11.post(new mu2.a(Long.valueOf(r12.intValue())));
        finishWithSuccess();
        return;
    L13:
        r4 = -1;
    L18:
        if (TextUtils.isEmpty(r7.c()) == true) goto L40;
        UrlBuilder r13 = new UrlBuilder(r7.c());
        Integer r14 = r7.b();
        if (r14 == null) goto L22;
        int r15 = r14.intValue();
    L24:
        if (r15 > 0) goto L26;
    L28:
        r13.addParam("height_percent", 70);
    L30:
        if (Intrinsics.areEqual(r7.a(), Boolean.TRUE) == false) goto L32;
        r13.addParam("use_player_bottom_height", 1);
    L32:
        r13.addParam("type", "popup");
        DataCenter r16 = this.b;
        if (r16 == null) goto L39;
        Room r17 = com.bytedance.android.live.core.utils.z.o(r16);
        if (r17 == null) goto L39;
        String r18 = r17.getIdStr();
        if (r18 == null) goto L39;
        r13.addParam("room_id", r18);
    L39:
        com.bytedance.android.livesdk.service.l.d().a().handle(this.a, UriProtector.parse(r13.build()));
        finishWithSuccess();
        return;
    L26:
        if (r15 > 100) goto L28;
        r13.addParam("height_percent", r15);
        goto L30
    L22:
        r15 = 0;
        goto L24
    L40:
        finishWithFailure();
    }
}
