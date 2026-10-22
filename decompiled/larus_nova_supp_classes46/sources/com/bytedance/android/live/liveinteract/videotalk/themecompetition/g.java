package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import com.bytedance.android.livesdk.chatroom.model.interact.SelectionType;
import com.bytedance.android.livesdk.chatroom.model.interact.a2;
import com.bytedance.android.livesdk.chatroom.model.interact.b2;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ ThemedCompetitionWidget a;

    public g(ThemedCompetitionWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        k1 r6 = (k1) ((com.bytedance.android.live.network.response.e) r5).data;
        if (r6 == null) goto L23;
        p2 r7 = r6.getLinkmicPlayModeInfo();
        if (r7 == null) goto L24;
        a2 r8 = r7.getThemedCompetitionInfo();
        if (r8 == null) goto L25;
        ThemedCompetitionContext.a r0 = ThemedCompetitionContext.Companion;
        r0.f(r8);
        a r1 = b.a;
        b2 r9 = r8.getSetting();
        if (r9 == null) goto L11;
        r9.getSelectionType();
    L12:
        r1.getClass();
        if (r0.g() == false) goto L21;
        ThemedCompetitionViewManager r10 = this.a.d;
        if (r10 == null) goto L18;
        r10.b();
    L18:
        if (this.a.isAnchor() == true) goto L20;
        b.e();
    L20:
        r1.a = System.currentTimeMillis();
    L21:
        ThemedCompetitionWidget r11 = this.a;
        int r2 = ThemedCompetitionWidget.f;
        r11.wq();
        return;
    L11:
        SelectionType.UNKNOWN.getValue();
        goto L12
    L25:
        return;
    L24:
        return;
    }
}
