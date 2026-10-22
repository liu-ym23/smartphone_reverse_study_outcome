package com.bytedance.android.live.livepkaudience.dialog;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ PkWithAudienceFeedbackDialog a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public z(PkWithAudienceFeedbackDialog r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.a r8 = (com.bytedance.android.live.network.response.a) r7;
        PkWithAudienceFeedbackDialog r9 = this.a;
        String r0 = this.b;
        String r1 = this.c;
        int r2 = PkWithAudienceFeedbackDialog.m;
        r9.getClass();
        LinkedHashMap r3 = new LinkedHashMap();
        if (r9.g == false) goto L5;
        String r4 = "anchor";
    L6:
        r3.put("user_type", r4);
        int r5 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        el0.j.l(r3, r5);
        el0.j.j(r3, Integer.valueOf(r5));
        el0.j.o(r3);
        r3.put("is_ksong", "0");
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        r3.put("first_feedback", r0);
        r3.put("second_feedback", r1);
        boolean r10 = r9.g;
        if (r10 == false) goto L23;
        if (r10 == false) goto L18;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r11 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r11 == null) goto L18;
        com.bytedance.android.live.livepkaudience.base.i r12 = r11.getLinkUserCenter();
        if (r12 == null) goto L18;
        int r13 = r12.b();
    L19:
        if (r13 <= 0) goto L21;
        String r14 = "end_ahead";
    L22:
        r3.put("request_page", r14);
        goto L23
    L21:
        r14 = "normal";
    L18:
        r13 = 0;
    L23:
        el0.j.n(r3, Integer.valueOf(r5));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_chat_feedback_success", r3, new Object[]{am2.x.class, Room.class});
        PkWithAudienceFeedbackDialog r15 = this.a;
        int r6 = 2131922743;
        if (r15.l == false) goto L27;
        f2.b(2131922743, 0);
        return;
    L27:
        if (r15.g == true) goto L30;
        r6 = 2131922742;
    L30:
        f2.b(r6, 0);
        return;
    L5:
        r4 = "guest";
        goto L6
    }
}
