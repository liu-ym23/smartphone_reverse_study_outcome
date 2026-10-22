package rp0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends vq0.b {
    public i(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    @Override // vq0.b
    public final Bundle onEvent(Bundle r7) {
        ILiveMiniAppService r0 = k.f(ILiveMiniAppService.class);
        if (r0 == null) goto L5;
        r0.setMiniAppActivityStatue(true);
    L5:
        Room r1 = this.a.getRoom();
        if (r1 == null) goto L8;
        LiveMode r2 = r1.getStreamType();
    L10:
        if (r2 == LiveMode.SCREEN_RECORD) goto L18;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r3 == null) goto L18;
        com.bytedance.live.datacontext.j r4 = r3.getLiveStream();
        if (r4 == null) goto L18;
        com.bytedance.android.live.pushstream.d r5 = (com.bytedance.android.live.pushstream.d) r4.getValue();
        if (r5 == null) goto L18;
        r5.q1("mini app event", new uv0.a(LiveRequestSourceRole.Business, "OnMiniAppResumeEventListener.onEvent", null));
    L18:
        AnchorCastContextService r6 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        if (r6.g().a() == false) goto L27;
        MiniAppInstance r8 = this.a.getMiniAppInstance();
        if (r8 == null) goto L23;
        String r9 = r8.getAppId();
    L24:
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        LinkScreenCastType r10 = LinkScreenCastType.CAST_TYPE_MINI_APP;
        Intrinsics.checkNotNullParameter(r9, "appId");
        Intrinsics.checkNotNullParameter(r10, "castType");
        dp0.a r11 = r6.g();
        int r12 = qo0.a.a;
        qo0.a.c("AnchorCastContextService", "resumeLiveCast by Strategy:" + r11);
        r11.f(r9, r10);
        goto L27
    L23:
        r9 = null;
    L27:
        super.onEvent(r7);
        return null;
    L8:
        r2 = null;
        goto L10
    }
}
