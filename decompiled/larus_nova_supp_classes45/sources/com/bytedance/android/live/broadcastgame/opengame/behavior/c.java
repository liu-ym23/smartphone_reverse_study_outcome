package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.view.View;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements c0.b {
    public View a;
    public DataCenter b;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
    }

    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r2) {
        Intrinsics.checkNotNullParameter(r2, "command");
        if ((r2 instanceof com.bytedance.android.live.broadcastgame.opengame.behavior.a) == false) goto L10;
        ((com.bytedance.android.live.broadcastgame.opengame.behavior.a) r2).getClass();
        ALogger.d("AudienceOpenGameBehavior", "command: 0 null null");
        y3.m(this.b).c(ToolbarButton.OPEN_PLATFORM_GAME.extended());
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r3 = AudienceGameContext.a.a();
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.getOpenInteractGameIconShouldShow();
        if (r4 == null) goto L12;
        r4.setValue(Boolean.TRUE);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onClick(View r3) {
        int r4 = f.a;
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.openplatform.f(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        if (r2 == null) goto L5;
        r2.setOnClickListener(this);
    L5:
        View r4 = this.a;
        if (r4 == null) goto L8;
        HSImageView r5 = (HSImageView) r4.findViewById(2131376280);
    L8:
        z.b(r3);
        this.b = r3;
        y3.m(r3).i(ToolbarButton.OPEN_PLATFORM_GAME.extended());
    }
}
