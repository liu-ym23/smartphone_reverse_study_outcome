package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.wb;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b3 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public final Context a;

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

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        if (((Boolean) yo0.a.getValue()).booleanValue() == false) goto L6;
        return false;
    L6:
        return !SharedPrefHelper.b(this.a).f("live.pref.PREF_LIVE_ANCHOR_TOOLBAR_FLOW_FEEDBACK_DOT_SHOW", false);
    }

    public final Context getContext() {
        return this.a;
    }

    public b3(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        SharedPrefHelper r6 = SharedPrefHelper.b(this.a);
        r6.l("live.pref.PREF_LIVE_ANCHOR_TOOLBAR_FLOW_FEEDBACK_DOT_SHOW", Boolean.TRUE);
        r6.a();
        LiveMode r0 = null;
        int r3 = 3;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L8;
        com.bytedance.live.datacontext.i r8 = r7.getLiveMode();
        if (r8 == null) goto L8;
        r0 = (LiveMode) r8.getValue();
    L8:
        if (r0 != null) goto L11;
    L18:
        r3 = 999;
    L19:
        jc1.k.n(ILiveActionHandler.class).handle(this.a, UriProtector.parse(wb.a.getValue()).buildUpon().appendQueryParameter("live_type", String.valueOf(r3)).build());
        com.bytedance.android.livesdk.log.u.l().d("livesdk_anchor_flow_control_click", new Object[]{Room.class});
        return;
    L11:
        switch(a3.a[r0.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L19;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L18;
        };
    L13:
        r3 = 5;
        goto L19
    L14:
        r3 = 4;
        goto L19
    L15:
        r3 = 2;
        goto L19
    L16:
        r3 = 1;
        goto L19
    L17:
        r3 = 0;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        com.bytedance.android.livesdk.log.u.l().d("livesdk_anchor_flow_control_show", new Object[]{Room.class});
    }
}
