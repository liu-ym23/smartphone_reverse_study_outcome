package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

    public h(GuestLinkMainPageDialogForAudience r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        Integer r10 = (Integer) r9;
        if (this.a.O == hd0.c.f().h()) goto L21;
        int r0 = vi0.b.a;
        String r11 = String.valueOf(r10);
        Intrinsics.checkNotNullParameter(r11, "state");
        JSONObject r6 = new JSONObject();
        r6.put("state", r11);
        int r12 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerMedia, "guest_link_player_load_state_change", 0, null, r6, 88);
        this.a.O = hd0.c.f().h();
        ALogger.i("GuestLinkMainPageDialogForAudience", "update mIsCurrentOnline: " + this.a.O + ", leaveChannel");
        com.bytedance.android.live.base.model.message.guestlink.a r13 = this.a.T90();
        if (r13 == null) goto L18;
        lb6.g r1 = this.a.D;
        if (r1 == null) goto L18;
        r1.g(je0.d.a0(), r13.getChannelId(), "LinkPlayerStateChange", true);
    L18:
        this.a.dismiss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r14 = DialogFragmentLancet.sLastShowStack;
        if (r14 == null) goto L20;
        com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    }
}
