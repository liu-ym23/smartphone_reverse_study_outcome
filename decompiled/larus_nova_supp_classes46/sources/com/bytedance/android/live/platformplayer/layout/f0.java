package com.bytedance.android.live.platformplayer.layout;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.InteractPlayViewManager;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public f0(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        Boolean r8 = (Boolean) r7;
        MutableLiveData r9 = this.a.U2.e().getHideLoading();
        Boolean r0 = Boolean.TRUE;
        r9.setValue(r0);
        this.a.A70();
        LivePlayerWidget r10 = this.a;
        ds0.d r1 = r10.U2;
        if (r1.n == false) goto L46;
        r1.n = false;
        DataCenter r11 = ((Widget) r10).dataCenter;
        if (r11 == null) goto L7;
        r11.put("cmd_switch_resolution_success", 0);
    L7:
        String r2 = null;
        if (this.a.v == false) goto L36;
        IRoomContextService r12 = jc1.k.f(IRoomContextService.class);
        if (r12 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.o r13 = IRoomContextService.a.a(r12, null, 0, 3);
        if (r13 == null) goto L14;
        Boolean r14 = r13.isVSRoom();
    L16:
        if ((!Intrinsics.areEqual(r14, r0)) == false) goto L36;
        ILivePlayerClient r15 = this.a.dr();
        if (r15 == null) goto L29;
        IRoomEventHub r16 = r15.getEventHub();
        if (r16 == null) goto L29;
        if (r16.getResolutionRemoved() != true) goto L29;
        ILivePlayerClient r17 = this.a.dr();
        if (r17 == null) goto L34;
        IRoomEventHub r18 = r17.getEventHub();
        if (r18 == null) goto L34;
        r18.setResolutionRemoved(false);
    L34:
        IResolutionService r19 = jc1.k.f(IResolutionService.class);
        Intrinsics.checkNotNull(r19);
        r19.reportResolutionChangeEvent("hand_change", this.a.U2.w());
    L29:
        Context r20 = ((Widget) this.a).context;
        if (r20 == null) goto L32;
        String r21 = r20.getString(2131920005);
    L33:
        f2.c(r21, 0);
        goto L34
    L32:
        r21 = null;
    L14:
        r14 = null;
    L36:
        if (this.a.dr() == null) goto L46;
        if (this.a.er().getOptUpdateLiveRequestQuality() == false) goto L46;
        ILivePlayerClient r22 = this.a.dr();
        Intrinsics.checkNotNull(r22);
        LiveRequest r23 = r22.getLiveRequest();
        if (r23 == null) goto L42;
        r2 = r23.getResolution();
    L42:
        if (r2 == null) goto L46;
        ILivePlayerClient r24 = this.a.dr();
        Intrinsics.checkNotNull(r24);
        LiveRequest r25 = r24.getLiveRequest();
        if (r25 == null) goto L46;
        ILivePlayerClient r3 = this.a.dr();
        Intrinsics.checkNotNull(r3);
        r25.setResolution(r3.getCurrentResolution());
    L46:
        InteractPlayViewManager r26 = this.a.t;
        if (r26 == null) goto L50;
        r26.h();
        return;
    }
}
