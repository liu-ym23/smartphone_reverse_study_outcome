package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.view.View;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y;
import com.bytedance.android.livesdk.config.s4;
import com.bytedance.android.livesdk.config.vu;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements y {
    public View a;
    public final c0 b;

    public static final class a {
    }

    static {
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

    public final void onShow() {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final boolean b80() {
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r0 = AudienceGameContext.a.a();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Boolean> r1 = r0.getHasOpenGameLaunch();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L9:
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    L7:
        r2 = null;
        goto L9
    }

    public final void yl() {
        f2.c(((s4) vu.a.getValue()).c(), 0);
    }

    public b(g3 r2) {
        Intrinsics.checkNotNullParameter(r2, "toolbarManager");
        this.b = r2;
    }

    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r3) {
        Intrinsics.checkNotNullParameter(r3, "command");
        if ((r3 instanceof com.bytedance.android.live.broadcastgame.opengame.behavior.a) == true) goto L5;
        return;
    L5:
        ((com.bytedance.android.live.broadcastgame.opengame.behavior.a) r3).getClass();
        ALogger.d("AudienceGameToolbarEntranceBehavior", "command: 0 null null");
        int r4 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        Intrinsics.checkNotNullParameter(null, "name");
        ALogger.d("OpenPlatformLog", "显示观众端入口: null");
        throw null;
    }

    public final void onClick(View r3) {
        int r4 = f.a;
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.openplatform.f("from_temp_area"));
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
    }
}
