package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q extends IHostAppMonitorListener.Stub {
    public final /* synthetic */ GuestLinkMainPageDialogForLinker a;

    public q(GuestLinkMainPageDialogForLinker r1) {
        this.a = r1;
    }

    public final void appEnterBackground(boolean r21, boolean r22) {
        super.appEnterBackground(r21, r22);
        com.bytedance.android.live.base.model.message.guestlink.a r2 = this.a.T90();
        ArrayList r3 = null;
        if (r2 == null) goto L17;
        List r4 = r2.getLinkedUsers();
        if (r4 == null) goto L17;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L16;
        Object r7 = r6.next();
        IBaseUser r8 = ((com.bytedance.android.live.base.model.message.guestlink.k) r7).getUser();
        if (r8 == null) goto L12;
        String r9 = r8.getIdString();
    L14:
        if (Intrinsics.areEqual(r9, je0.d.b0()) == false) goto L8;
        r5.add(r7);
        goto L8
    L12:
        r9 = null;
        goto L14
    L16:
        r3 = r5;
    L17:
        ALogger.i("GuestLinkMainPageDialogForLinker", "appEnterBackground, background: " + r21 + ", selfLinkerInfo: " + r3);
        if (r3 != null) goto L20;
        return;
    L20:
        long r10 = 0;
        if (r21 == false) goto L39;
        lb6.g r1 = this.a.D;
        if (r1 == null) goto L33;
        ob6.a r11 = r1.j();
        if (r11 == null) goto L33;
        ei6.a r12 = r11.A();
        if (r12 == null) goto L33;
        xi6.c r13 = r12.t();
        if (r13 == null) goto L33;
        com.bytedance.live.livelink.kmp.impl.core.video.b r14 = r13.f();
        if (r14 == null) goto L33;
        r14.e(true);
    L33:
        int r15 = vi0.b.a;
        JSONObject r16 = new JSONObject();
        r16.put("open", false);
        int r17 = rd0.a.a;
        MultiTraceData$TraceBusiness r18 = MultiTraceData$TraceBusiness.GuestLink;
        MultiTraceData$TraceEvent r19 = MultiTraceData$TraceEvent.GuestLinkerMedia;
        rd0.a.b(r18, r19, "guest_link_audio_capture_change", 0, null, r16, 88);
        com.bytedance.android.live.base.model.message.guestlink.a r20 = this.a.T90();
        if (r20 == null) goto L38;
        this.a.getClass();
        if (BaseGuestLinkMainPageDialog.W90(GuestLinkMainPageDialogForLinker.ga0(r20)) == false) goto L38;
        JSONObject r23 = new JSONObject();
        r23.put("open", false);
        rd0.a.b(r18, r19, "guest_link_video_capture_change", 0, null, r23, 88);
    L38:
        long r110 = 1;
    L56:
        lb6.g r24 = this.a.D;
        if (r24 == null) goto L70;
        mb6.b r25 = r24.f();
        if (r25 == null) goto L71;
        long r26 = je0.d.a0();
        com.bytedance.android.live.base.model.message.guestlink.a r27 = this.a.T90();
        if (r27 == null) goto L63;
        r10 = r27.getChannelId();
    L63:
        r25.D(r26, r10, r110);
        return;
    L71:
        return;
    L70:
        return;
    L39:
        lb6.g r28 = this.a.D;
        if (r28 == null) goto L50;
        ob6.a r29 = r28.j();
        if (r29 == null) goto L50;
        ei6.a r30 = r29.A();
        if (r30 == null) goto L50;
        xi6.c r31 = r30.t();
        if (r31 == null) goto L50;
        com.bytedance.live.livelink.kmp.impl.core.video.b r32 = r31.f();
        if (r32 == null) goto L50;
        r32.e(false);
    L50:
        int r33 = vi0.b.a;
        JSONObject r111 = new JSONObject();
        r111.put("open", true);
        int r34 = rd0.a.a;
        MultiTraceData$TraceBusiness r35 = MultiTraceData$TraceBusiness.GuestLink;
        MultiTraceData$TraceEvent r112 = MultiTraceData$TraceEvent.GuestLinkerMedia;
        rd0.a.b(r35, r112, "guest_link_audio_capture_change", 0, null, r111, 88);
        com.bytedance.android.live.base.model.message.guestlink.a r36 = this.a.T90();
        if (r36 == null) goto L55;
        this.a.getClass();
        if (BaseGuestLinkMainPageDialog.W90(GuestLinkMainPageDialogForLinker.ga0(r36)) == false) goto L55;
        JSONObject r37 = new JSONObject();
        r37.put("open", true);
        rd0.a.b(r35, r112, "guest_link_video_capture_change", 0, null, r37, 88);
    L55:
        r110 = 0;
        goto L56
    }
}
