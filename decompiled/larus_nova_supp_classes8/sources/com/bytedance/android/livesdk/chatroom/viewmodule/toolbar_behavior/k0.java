package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.yi0;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.guardbox.api.GuardBoxApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;
    public View b;
    public final Context c;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ k0 a;

        public b(k0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.livesdk.guardbox.api.b r3 = ((com.bytedance.android.livesdk.guardbox.api.a) r2).a();
            if (r3 == null) goto L7;
            Map r4 = r3.a();
            if (r4 == null) goto L7;
            Boolean r5 = (Boolean) r4.get("popular_box");
        L9:
            if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L13;
            View r6 = this.a.b;
            if (r6 == null) goto L16;
            r6.setVisibility(0);
        L16:
            this.a.b("popular_chest_icon_show");
            return;
        L13:
            View r7 = this.a.b;
            if (r7 == null) goto L16;
            r7.setVisibility(8);
        L7:
            r5 = null;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ k0 a;

        public c(k0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            View r4 = this.a.b;
            if (r4 == null) goto L5;
            r4.setVisibility(8);
        L5:
            this.a.b("popular_chest_icon_show");
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final boolean a() {
        Room r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        r4 = (Room) r1.getValue();
    L7:
        boolean r2 = false;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.a).n(ToolbarButton.GROUP_PURCHASE) == false) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L18;
        if (r4 == null) goto L20;
        if (r4.isHasCommerceGoods() == true) goto L18;
    L20:
        return !r2;
    L18:
        r2 = true;
        goto L20
    L10:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.a).n(ToolbarButton.GROUP_PURCHASE_MORE) == true) goto L13;
        r3 = false;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        if (a() == true) goto L5;
    L15:
        return false;
    L5:
        if (((Boolean) yo0.a.getValue()).booleanValue() == true) goto L15;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.A.getValue()).booleanValue() == true) goto L14;
        View r0 = this.b;
        if (r0 == null) goto L12;
        r0.setVisibility(0);
    L12:
        b("popular_chest_icon_show");
        return true;
    L14:
        ((GuardBoxApi) com.bytedance.android.live.network.c.b().e(GuardBoxApi.class)).getGuardBoxRedDotState("popular_box").compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this));
        goto L15
    }

    public k0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
    }

    public final void b(String r6) {
        String r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        LinkedHashMap r3 = new LinkedHashMap();
        if (r2 == null) goto L11;
        r4 = r2.getAnchorId();
    L11:
        r3.put("anchor_id", String.valueOf(r4));
        if (r2 == null) goto L15;
        String r5 = String.valueOf(r2.getRoomId());
        if (r5 == null) goto L15;
    L16:
        r3.put("room_id", r5);
        View r7 = this.b;
        if (r7 != null) goto L19;
    L21:
        String r8 = "0";
    L22:
        r3.put("whether_mark", r8);
        com.bytedance.android.livesdk.log.u.l().sendLog(r6, r3, new Object[]{Room.class});
        return;
    L19:
        if (r7.getVisibility() != 0) goto L21;
        r8 = "1";
    L15:
        r5 = "";
    L7:
        r2 = null;
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (a() == true) goto L6;
        com.bytedance.android.live.core.utils.f2.c("暂未开放", 0);
        return;
    L6:
        b("popular_chest_icon_click");
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.A;
        if (((Boolean) r4.getValue()).booleanValue() == true) goto L9;
        com.bytedance.android.livesdk.sharedpref.f.d(r4, Boolean.TRUE);
    L9:
        int r5 = com.bytedance.android.livesdk.utils.o.a;
        String r6 = yi0.a.getValue();
        if (StringUtils.isEmpty(r6) == true) goto L13;
        com.bytedance.android.livesdk.service.l.d().a().handle(this.c, r6);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = r2.findViewById(2131384095);
        this.a = r3;
    }
}
