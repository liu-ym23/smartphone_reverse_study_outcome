package com.bytedance.android.live.liveinteract.revenue.paid.widget;

import cj0.k;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceVideoWindowManager;
import com.bytedance.android.live.liveinteract.plantform.base.d;
import com.bytedance.android.live.liveinteract.plantform.base.e;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/widget/PaidLinkMicInteractWidget;", "Lcom/bytedance/android/live/liveinteract/revenue/paid/widget/BasePaidLinkMicWidget;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLinkMicInteractWidget extends BasePaidLinkMicWidget {

    public static final class a {
    }

    static {
    }

    public static InteractAudienceVideoWindowManager yq() {
        e.l0.getClass();
        e r0 = e.a.a();
        if (r0 == null) goto L6;
        InteractAudienceVideoWindowManager r1 = r0.windowManager();
        if (r1 == null) goto L6;
        return r1;
    L6:
        d.j0.getClass();
        d r2 = d.a.a();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.windowManager();
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.widget.BasePaidLinkMicWidget, com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L12;
        return;
    L12:
        if (fj0.e.i() == false) goto L18;
        InteractAudienceVideoWindowManager r1 = yq();
        if (r1 == null) goto L19;
        r1.h = true;
        r1.i(true);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (this.d == false) goto L7;
    L8:
        r0 = true;
        goto L10
    L7:
        if (vm2.d.o0() == false) goto L9;
        goto L8
    }

    public PaidLinkMicInteractWidget() {
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.paid.widget.BasePaidLinkMicWidget
    public final void wq(k r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        super.wq(r5);
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        boolean r2 = false;
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L31;
        LinkMicRoomDataSyncModel r1 = LinkWRDSHelper.b();
        if (r1 == null) goto L20;
        dc2.c r3 = r1.getTalkRoomListUserInfoPb();
        if (r3 == null) goto L20;
        IRoomLinkMicSyncData r4 = (IRoomLinkMicSyncData) r3.c();
        if (r4 == null) goto L20;
        List r6 = r4.getMLinkUsers();
        if (r6 == null) goto L20;
        int r7 = r6.size();
    L22:
        if (r7 >= 2) goto L24;
        r2 = true;
    L24:
        if (r2 == false) goto L26;
    L27:
        InteractAudienceVideoWindowManager r8 = yq();
        if (r8 == null) goto L33;
        r8.h = r5.a;
        r8.i(true);
        return;
    L33:
        return;
    L26:
        if (r5.a == false) goto L27;
        return;
    L20:
        r7 = 0;
        goto L22
    L31:
        return;
    L5:
        if (this.d == false) goto L7;
    L8:
        r0 = true;
        goto L10
    L7:
        if (vm2.d.o0() == false) goto L9;
        goto L8
    }
}
