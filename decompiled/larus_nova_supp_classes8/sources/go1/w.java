package go1;

import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.livesdk.interactivity.api.medialink.BaseMediaLinkControlWidget;
import com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements BaseMediaLinkControlWidget.a {
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.a a;
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.ui.framework.c b;

    public final void a(LiveWidget r2) {
        this.a.Uj(r2);
    }

    public final Widget b(x32.b r5) {
        IMediaLinkOutService r0 = jc1.k.f(IMediaLinkOutService.class);
        if (r0 == null) goto L5;
        Widget r6 = r0.createMediaMultiAudienceWidget(r5);
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.a.C0015a.a(this.a, 2131379804, r6, false, 12);
        return r6;
    L5:
        r6 = null;
        goto L6
    }

    public w(com.bytedance.android.livesdk.chatroom.ui.framework.a r1, com.bytedance.android.livesdk.chatroom.ui.framework.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
