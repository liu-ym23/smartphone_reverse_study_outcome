package com.bytedance.android.live.platformplayer.layout;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.service.IUhdLoginService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public x0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        String r8 = (String) r7;
        this.a.Er("player widget @" + this.a.hashCode() + " onPlayMediaError()");
        NextLiveData r9 = this.a.U2.e().getStartPull();
        Boolean r0 = Boolean.FALSE;
        r9.setValue(r0);
        LivePlayerWidget r10 = this.a;
        ds0.d r1 = r10.U2;
        if (r1.n == false) goto L31;
        r1.n = false;
        if (r10.v == false) goto L31;
        IRoomContextService r11 = jc1.k.f(IRoomContextService.class);
        String r2 = null;
        if (r11 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.o r12 = IRoomContextService.a.a(r11, null, 0, 3);
        if (r12 == null) goto L11;
        Boolean r13 = r12.isVSRoom();
    L12:
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r13, r3) == false) goto L27;
        DataCenter r14 = ((Widget) this.a).dataCenter;
        if (r14 == null) goto L17;
        r14.put("action_switch_live_resolution", r0);
    L17:
        DataCenter r15 = ((Widget) this.a).dataCenter;
        if (r15 == null) goto L20;
        Boolean r16 = (Boolean) r15.get("action_switch_live_resolution", r0);
    L22:
        if (Intrinsics.areEqual(r16, r3) == false) goto L31;
        Context r17 = ((Widget) this.a).context;
        if (r17 == null) goto L26;
        r2 = r17.getString(2131920002);
    L26:
        f2.c(r2, 0);
        goto L31
    L20:
        r16 = null;
        goto L22
    L27:
        Context r18 = ((Widget) this.a).context;
        if (r18 == null) goto L30;
        r2 = r18.getString(2131920002);
    L30:
        f2.c(r2, 0);
    L11:
        r13 = null;
    L31:
        this.a.getClass();
        IUhdLoginService r19 = LivePlayerWidget.Sq();
        if (r19 == null) goto L35;
        r19.releaseTimer(this.a.hashCode());
        return;
    }
}
