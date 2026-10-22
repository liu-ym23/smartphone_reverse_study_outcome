package com.bytedance.android.live.liveinteract.revenue.guestlink;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.GuestLinkMainPageDialogForLinker;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements vi0.c.a {
    public final /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.g a;
    public final /* synthetic */ GuestLinkWidget b;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.multianchor.model.g c;

    @Override // vi0.c.a
    public final void a() {
        ALogger.i("GuestLinkWidget", "leaveMultiLinkRoom success");
        int r2 = vi0.b.a;
        String r3 = String.valueOf(this.a.getChannelId());
        Intrinsics.checkNotNullParameter(r3, "channelId");
        Intrinsics.checkNotNullParameter("", "errorMsg");
        JSONObject r11 = new JSONObject();
        r11.put("channel_id", r3);
        r11.put("error", "");
        int r4 = rd0.a.a;
        MultiTraceData$TraceBusiness r5 = MultiTraceData$TraceBusiness.GuestLink;
        MultiTraceData$TraceEvent r13 = MultiTraceData$TraceEvent.GuestLinkerLink;
        rd0.a.b(r5, r13, "guest_link_linkmic_leave_call", 0, null, r11, 88);
        GuestLinkWidget r6 = this.b;
        com.bytedance.android.live.base.model.message.guestlink.g r7 = this.a;
        int r8 = GuestLinkWidget.j;
        r6.getClass();
        ALogger.i("GuestLinkWidget", "showMainPageForLinker");
        if (vm2.i.e().getDisableVideo() == false) goto L5;
        int r19 = 2;
    L6:
        r6.g = r7.getRtcExtInfo();
        String r0 = String.valueOf(r7.getChannelId());
        String r9 = r6.g;
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r0, "channelId");
        Intrinsics.checkNotNullParameter(r9, "rtcExtInfo");
        JSONObject r10 = new JSONObject();
        r10.put("channel_id", r0);
        r10.put("rtc_extra_info", r9);
        rd0.a.b(r5, r13, "guest_link_join_rtc_room", 0, null, r10, 88);
        lb6.g r14 = r6.wq();
        if (r14 == null) goto L16;
        long r15 = je0.d.a0();
        long r17 = r7.getChannelId();
        int r1 = r6.f;
        String r12 = r6.g;
        if (r12 != null) goto L14;
        String r21 = "";
    L15:
        r14.l(r15, r17, r19, r1, r21, r7.getLiveCoreInfo(), r7.getCallDuration(), true);
        goto L16
    L14:
        r21 = r12;
    L16:
        GuestLinkMainPageDialogForLinker r16 = r6.b;
        if (r16 != null) goto L37;
    L24:
        int r18 = GuestLinkMainPageDialogForLinker.P;
        DataCenter r20 = ((Widget) r6).dataCenter;
        lb6.g r22 = r6.wq();
        r7.getChannelId();
        r7.getScore();
        long r23 = r7.getCallDuration();
        IVoiceLiveTheme r24 = r7.getChannelBackground();
        Intrinsics.checkNotNullParameter(r6, "outerScopeProvider");
        GuestLinkMainPageDialogForLinker r25 = new GuestLinkMainPageDialogForLinker(r6, r20);
        r25.D = r22;
        r25.L = r23;
        r25.M = r24;
        r6.b = r25;
        FragmentActivity r26 = ((Widget) r6).context;
        if (r26 == null) goto L33;
        FragmentManager r27 = r26.getSupportFragmentManager();
        LandscapeRestrictionOperation r28 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r25, "GuestLinkMainPageDialogForLinker", r28);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r27, r25, r28) == true) goto L39;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L34
    L30:
        r25.show(r27, "GuestLinkMainPageDialogForLinker");
        return;
    L39:
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L37:
        r16.dismiss();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r29 = DialogFragmentLancet.sLastShowStack;
        if (r29 == null) goto L24;
        com.bytedance.crash.d.d(r29, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L24
    L5:
        r19 = r6.e;
        goto L6
    }

    public f(com.bytedance.android.live.base.model.message.guestlink.g r1, GuestLinkWidget r2, com.bytedance.android.live.liveinteract.multianchor.model.g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
