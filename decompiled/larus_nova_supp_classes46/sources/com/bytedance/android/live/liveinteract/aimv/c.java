package com.bytedance.android.live.liveinteract.aimv;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSourceType;
import fd2.h0;
import hg6.g;
import kotlin.Unit;
import ui6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ LiveLinkmicAIMVManager a;

    public c(LiveLinkmicAIMVManager r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.a.m.booleanValue() == false) goto L22;
        j1 r4 = this.a.t;
        if (r4 == null) goto L7;
        cg6.a r5 = (cg6.a) r4.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    L8:
        if (r5 == null) goto L18;
        g r6 = r5.getRtcManager();
        if (r6 == null) goto L18;
        ei6.a r7 = r6.V0();
        if (r7 == null) goto L18;
        d r8 = r7.l();
        if (r8 == null) goto L18;
        mi6.a r9 = r8.b();
        if (r9 == null) goto L18;
        r9.o(LiveWrappedAudioSourceType.AUDIO_SOURCE_TYPE_INTERNAL);
    L18:
        com.example.myapplication.a r10 = this.a.l;
        if (r10 == null) goto L21;
        r10.b();
    L21:
        this.a.n = false;
        return;
    L7:
        r5 = null;
        goto L8
    L22:
        xs2.b r11 = xs2.b.a();
        h0 r1 = new h0();
        r1.a = false;
        Unit r0 = Unit.INSTANCE;
        r11.post(r1);
    }
}
