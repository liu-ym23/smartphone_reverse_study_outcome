package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.k9;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AnchorZoomFeatureWidget a;

    public b(AnchorZoomFeatureWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        com.bytedance.android.livesdk.e.b().getClass();
        if (com.bytedance.android.livesdk.e.c() == true) goto L14;
        IBroadcastService r4 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r4 != null) goto L7;
    L9:
        ALogger.i(this.a.g, "show zoom guid");
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.b.l0;
        Boolean r0 = Boolean.TRUE;
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
        k9 r6 = new k9(((Widget) this.a).context);
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return;
    L7:
        if (r4.isPlayingGame() != true) goto L9;
    L14:
        ALogger.i(this.a.g, "cant show zoomguid,other dialog show");
    }
}
