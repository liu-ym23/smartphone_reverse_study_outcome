package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import android.view.View;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.gift.platform.core.GiftServiceKt;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends zr2.k implements o {
    public final yz0.k b;

    public static final class a {
    }

    static {
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final void onStart() {
        IRoomAuthStatus r0 = this.b.getRoom().getRoomAuthStatus();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.enableInteractionGift() != true) goto L9;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).tg(this.b.getDataCenter()).e(RevToolbarButton.InteractGift, this);
        return;
    }

    public final void onStop() {
        IRoomAuthStatus r0 = this.b.getRoom().getRoomAuthStatus();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.enableInteractionGift() != true) goto L9;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).tg(this.b.getDataCenter()).c(RevToolbarButton.InteractGift, this);
        return;
    }

    public final boolean showRedDot() {
        if (((Boolean) yo0.a.getValue()).booleanValue() == false) goto L7;
        return false;
    L7:
        return ay1.b.q();
    }

    public l(yz0.k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.b = r2;
    }

    public final void d(zr2.h r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        Intrinsics.checkNotNullParameter(r2, "button");
        Intrinsics.checkNotNullParameter(r2, "button");
    }

    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        ((GiftServiceKt) com.bytedance.android.live.revenue.core.util.f.a(GiftServiceKt.class)).openInteractGiftDialog(null, 2, null, "anchor_panel", null, null);
        com.bytedance.android.livesdk.gift.platform.core.preview.a r9 = com.bytedance.android.livesdk.gift.platform.core.preview.a.a;
        IRoom r0 = this.b.getRoom();
        boolean r1 = ay1.b.q();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "room");
        LinkedHashMap r10 = new LinkedHashMap();
        String r2 = r0.getAnchorId();
        if (r2 != null) goto L5;
        r2 = BuildConfig.FLAVOR;
    L5:
        r10.put("anchor_id", r2);
        r10.put("room_id", String.valueOf(r0.getRoomId()));
        r10.put("event_page", "live");
        if (r1 == false) goto L8;
        String r3 = "1";
    L9:
        r10.put("is_notice", r3);
        com.bytedance.android.livesdk.gift.platform.core.preview.a.c("livesdk_interactive_gift_anchor_set_panel_click", r10);
        ay1.b.q0.setValue(null, ay1.b.a[82], Boolean.FALSE);
        return;
    L8:
        r3 = "0";
        goto L9
    }

    public final void p4(View r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        com.bytedance.android.livesdk.gift.platform.core.preview.a r6 = com.bytedance.android.livesdk.gift.platform.core.preview.a.a;
        IRoom r7 = this.b.getRoom();
        boolean r0 = ay1.b.q();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "room");
        LinkedHashMap r8 = new LinkedHashMap();
        String r1 = r7.getAnchorId();
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        r8.put("anchor_id", r1);
        r8.put("room_id", String.valueOf(r7.getRoomId()));
        r8.put("event_page", "live");
        if (r0 == false) goto L8;
        String r9 = "1";
    L9:
        r8.put("is_notice", r9);
        com.bytedance.android.livesdk.gift.platform.core.preview.a.c("livesdk_interactive_gift_anchor_set_panel_show", r8);
        return;
    L8:
        r9 = "0";
        goto L9
    }
}
