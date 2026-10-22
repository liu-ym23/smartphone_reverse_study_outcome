package rp0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends vq0.c {
    public a(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    @Override // vq0.c
    public final Bundle onEvent(Bundle r8) {
        ILiveMiniAppService r0 = k.f(ILiveMiniAppService.class);
        if (r0 == null) goto L5;
        r0.setMiniAppActivityStatue(false);
    L5:
        RoomContext.a r1 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r1, null, 0, 3);
        if (r5 == null) goto L18;
        m r6 = r5.isAppBackground();
        if (r6 == null) goto L18;
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L18;
        RoomContext r2 = RoomContext.a.c(r1, null, 0, 3);
        if (r2 == null) goto L18;
        com.bytedance.live.datacontext.j r3 = r2.getLiveStream();
        if (r3 == null) goto L18;
        com.bytedance.android.live.pushstream.d r4 = (com.bytedance.android.live.pushstream.d) r3.getValue();
        if (r4 == null) goto L18;
        r4.J0("mini app event", new uv0.a(LiveRequestSourceRole.Business, "LiveAnchorOnMiniAppStopEventListener.onEvent", null));
    L18:
        if (r8 == null) goto L24;
        String r7 = r8.getString("exit_reason");
        if ((!Intrinsics.areEqual(r7, "api-navigateToMiniProgram")) == true) goto L22;
    L25:
        AnchorCastContextService r9 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        if (r9.g().a() == false) goto L34;
        MiniAppInstance r10 = this.a.getMiniAppInstance();
        if (r10 == null) goto L30;
        String r11 = r10.getAppId();
    L31:
        if (r11 != null) goto L33;
        r11 = "";
    L33:
        LinkScreenCastType r12 = LinkScreenCastType.CAST_TYPE_MINI_APP;
        Intrinsics.checkNotNullParameter(r11, "appId");
        Intrinsics.checkNotNullParameter(r12, "castType");
        dp0.a r13 = r9.g();
        int r14 = qo0.a.a;
        qo0.a.c("AnchorCastContextService", "pauseLiveCast by Strategy:" + r13 + " reason:" + r7);
        r13.e(r11, r12, r7);
        goto L34
    L30:
        r11 = null;
    L34:
        super.onEvent(r8);
        return null;
    L22:
        if ((!Intrinsics.areEqual(r7, "api-openSchema")) == false) goto L25;
        ((IInteractService) k.n(IInteractService.class)).onProgramHide();
        goto L25
    L24:
        r7 = null;
        goto L25
    }
}
