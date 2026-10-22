package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.livesdk.message.model.ek;
import com.bytedance.android.livesdk.message.model.vc;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l0 implements com.bytedance.android.live.broadcastgame.c0<com.bytedance.android.live.broadcastgame.v>, vlc.l {
    public Disposable a;
    public final vlc.d b;
    public final long c;
    public final boolean d;
    public final DataCenter e;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.b.removeMessageListener(this);
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "queue");
        this.b.addMessageListener(MessageType.INTERACT_OPEN_APP_STATE_MESSAGE.getIntType(), this);
    }

    public final void onMessage(tlc.d r4) {
        if ((r4 instanceof vc) == false) goto L40;
        int r0 = i20.c.a;
        if (tb1.c.g == false) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L41;
        boolean r2 = this.d;
        vc r5 = (vc) r4;
        if (r5.getGameStatus() != 1) goto L42;
        Disposable r3 = null;
        if (r2 == true) goto L27;
        final ek r6 = b(r2, r5);
        if (r6 == null) goto L43;
        Disposable r7 = this.a;
        if (r7 == null) goto L21;
        r7.dispose();
    L21:
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r8 = AudienceGameContext.a.a();
        if (r8 == null) goto L26;
        com.bytedance.live.datacontext.n<Boolean> r9 = r8.getHasOpenGameLaunch();
        if (r9 == null) goto L26;
        r3 = i80.a.b(r9, new OpenPlatformPublicMessageReceiver$showStartInteractOpenAppMessage$$inlined$let$lambda$1(r6, this));
    L26:
        this.a = r3;
        return;
    L43:
        return;
    L27:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r11 = AnchorGameContext.a.a();
        if (r11 == null) goto L35;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.i0> r12 = r11.getCurrentOpenPlatformAppInfo();
        if (r12 == null) goto L35;
        com.bytedance.android.live.broadcastgame.api.model.i0 r13 = (com.bytedance.android.live.broadcastgame.api.model.i0) r12.getValue();
        if (r13 == null) goto L35;
        r3 = r13.d;
    L35:
        if (r3 == InteractID.OpenMicroApp) goto L45;
        ek r14 = b(r2, r5);
        if (r14 == null) goto L46;
        this.e.put("data_push_2_public_screen_message", r14);
        return;
    L46:
        return;
    L45:
        return;
    L42:
        return;
    L41:
        return;
    L7:
        if (tb1.c.b == true) goto L10;
        r1 = false;
        goto L11
    }

    public final ek b(boolean r3, vc r4) {
        if (r3 == true) goto L4;
    L7:
        if (r3 == true) goto L12;
        String r5 = r4.getDisplayText();
        Intrinsics.checkNotNull(r5);
        if ((!StringsKt.isBlank(r5)) == true) goto L11;
        return null;
    L11:
        return ag1.c.c(this.c, r4.getDisplayText());
    L12:
        return null;
    L4:
        if ((!StringsKt.isBlank(r4.E())) == false) goto L7;
        return ag1.c.c(this.c, r4.E());
    }

    public l0(vlc.d r2, long r3, boolean r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
    }
}
