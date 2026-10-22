package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.ITicketData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q extends mx.j {
    public static final /* synthetic */ int m = 0;

    public static final class a {
        @JvmStatic
        public static q a(DataCenter r10, ListDialogAbility r11) {
            Intrinsics.checkNotNullParameter(r10, "dataCenter");
            Intrinsics.checkNotNullParameter(r11, "ability");
            Room r0 = z.o(r10);
            if (z.c(r10) != LiveMode.MEDIA) goto L5;
            boolean r2 = true;
        L6:
            boolean r5 = r0.isPaidRoom();
            PaidLiveData r1 = r0.getPaidLiveData();
            if (r1 == null) goto L11;
            ITicketData r3 = r1.getTicketSession();
            if (r3 == null) goto L11;
            long r4 = r3.getTicketId();
        L12:
            long r6 = r4;
            PaidLiveData r7 = r0.getPaidLiveData();
            if (r7 == null) goto L18;
            ITicketData r8 = r7.getTicketSession();
            if (r8 == null) goto L18;
            String r9 = r8.getTitle();
            if (r9 == null) goto L18;
        L20:
            return new q(r2, r10, r11, r5, r6, r9);
        L18:
            r9 = "";
        L11:
            r4 = 0;
            goto L12
        L5:
            r2 = false;
            goto L6
        }
    }

    static {
    }

    public q(boolean r14, DataCenter r15, ListDialogAbility r16, boolean r17, long r18, String r20) {
        Intrinsics.checkNotNullParameter(r16, "ability");
        Intrinsics.checkNotNullParameter(r20, "ticketName");
        Room r10 = null;
        super(s1.B(2131919670), null, false, 14);
        ((mx.j) this).l = new p(this, r14, r15, r16, r17, r18, r20);
        if (com.bytedance.android.livesdk.interactivity.api.asr.utils.a.a() == false) goto L36;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        r10 = (Room) r1.getValue();
    L9:
        com.bytedance.android.livesdk.log.g r2 = com.bytedance.android.livesdk.log.u.l();
        HashMap r3 = new HashMap();
        r3.put("enter_from_merge", "direct_shoot");
        if (r10 != null) goto L12;
    L14:
        String r4 = "0";
    L15:
        r3.put("is_paidlive", r4);
        String r5 = "";
        if (r10 == null) goto L23;
        PaidLiveData r6 = r10.getPaidLiveData();
        if (r6 == null) goto L23;
        ITicketData r7 = r6.getTicketSession();
        if (r7 == null) goto L23;
        String r8 = String.valueOf(r7.getTicketId());
        if (r8 == null) goto L23;
    L24:
        r3.put("ticket_id", r8);
        if (r10 == null) goto L34;
        PaidLiveData r9 = r10.getPaidLiveData();
        if (r9 == null) goto L34;
        ITicketData r11 = r9.getTicketSession();
        if (r11 == null) goto L34;
        String r12 = r11.getTitle();
        if (r12 == null) goto L34;
        r5 = r12;
    L34:
        r3.put("ticket_name", r5);
        Unit r13 = Unit.INSTANCE;
        r2.sendLog("livesdk_anchor_interact_right_show", r3, new Object[]{Room.class, am2.x.class});
        return;
    L23:
        r8 = "";
        goto L24
    L12:
        if (r10.isPaidRoom() != true) goto L14;
        r4 = "1";
        goto L15
    }
}
