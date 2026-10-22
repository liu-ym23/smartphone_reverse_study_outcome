package com.bytedance.android.live.messagewindow.business.card;

import android.view.ViewGroup;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardConstant;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.livesdk.message.model.i3;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;
import yt1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements m {
    public final /* synthetic */ n a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ e c;

    public final void onFetchSuccess() {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L7;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d("TopRightCommonCard");
        r1.c("template onFetchSuccess");
        r1.a("isFromCache", Boolean.FALSE);
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
        return;
    }

    public g(n r1, ViewGroup r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(com.bytedance.android.livesdk.dslservice.a r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "loadFrom");
        Intrinsics.checkNotNullParameter(r7, "loadFrom");
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.d("TopRightCommonCard");
        r1.c("template onLoadSuccess");
        r1.a("isSyncLoad", Boolean.valueOf(r6));
        r1.a("loadFrom", r7);
        Unit r8 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        i r9 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r9 == null) goto L15;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r10 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_load_time_cost");
        r10.b("position", Integer.valueOf(CommonCardConstant.Position.TOP_RIGHT.getValue()));
        i3 r11 = this.c.B;
        if (r11 == null) goto L12;
        Integer r12 = r11.type;
    L13:
        r10.b("type", r12);
        r10.b("cost_time", Long.valueOf(System.currentTimeMillis() - this.c.r));
        Unit r13 = Unit.INSTANCE;
        r9.b(r10.a());
        return;
    L12:
        r12 = null;
        goto L13
    }

    public final void b(String r5, String r6, Throwable r7) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "reason");
        m.a.a(r5, r6);
        i r1 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r1 == null) goto L6;
        CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
        r2.d("TopRightCommonCard");
        r2.c("template onFailed, card dismiss");
        r2.a("type", r5);
        r2.a("reason", r6);
        Unit r8 = Unit.INSTANCE;
        r1.d(r2.b());
    L6:
        this.c.dismiss();
    }
}
