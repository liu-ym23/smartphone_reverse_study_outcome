package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementBasicVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.qm;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/holder/TicketHolder;", "Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/holder/CommonTabHolder;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TicketHolder extends CommonTabHolder implements Observer<KVData>, vlc.l {
    public static final /* synthetic */ int j = 0;
    public long h;
    public u91.a i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        this.e.observe("data_current_room_ticket_count", this);
        vlc.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.UPDATE_FAN_TICKET_MESSAGE.getIntType(), this);
    L5:
        IRoom r1 = this.d;
        if (r1 == null) goto L8;
        IRoomStats r2 = r1.getStats();
    L9:
        String r6 = "";
        if (r2 == null) goto L27;
        DataCenter r3 = this.e;
        if (r3 == null) goto L27;
        long r7 = 0;
    L20:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r4 = Spm.a.a("a100.c100.d100").anchorId(r1.getOwnerUserIdString()).roomId(r1.getIdStr()).aliasAppend("render_ticket_failed");
        String r5 = e.getMessage();
        if (r5 == null) goto L25;
        r6 = r5;
    L25:
        sw2.a.b(r4.reason(r6).i(), "TicketHolder");
    L26:
        s(r7);
    L40:
        q("live_wave");
        return;
    L15:
        if (r3.get("data_current_room_ticket_count") == null) goto L17;
        Long r8 = (Long) this.e.get("data_current_room_ticket_count", 0L);     // Catch: Exception -> L20
    L18:
        r7 = r8.longValue();     // Catch: Exception -> L20
        goto L26
    L17:
        IRoomStats r9 = r1.getStats();     // Catch: Exception -> L20
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L20
        r8 = Long.valueOf(r9.getTicket());     // Catch: Exception -> L20
    L27:
        Spm.Companion.getClass();
        Spm r10 = Spm.a.a("a100.c100.d100");
        if (r1 == null) goto L32;
        String r12 = r1.getOwnerUserIdString();
        if (r12 == null) goto L32;
    L33:
        Spm r13 = r10.anchorId(r12);
        if (r1 == null) goto L39;
        String r14 = r1.getIdStr();
        if (r14 == null) goto L39;
        r6 = r14;
    L39:
        sw2.a.b(r13.roomId(r6).aliasAppend("render_ticket_failed").reason("room or datacenter is null").i(), "TicketHolder");
    L32:
        r12 = "";
        goto L33
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        this.h = 0;
        this.i = null;
        this.e.removeObserver(this);
        vlc.d r0 = this.b;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.i = r3;
        s(this.h);
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L17;
        String r0 = r5.getKey();
        if (r0.hashCode() == 1247726949) goto L9;
        return;
    L9:
        if (r0.equals("data_current_room_ticket_count") == false) goto L16;
        Long r6 = (Long) r5.getData();
        if (r6 == null) goto L13;
        long r1 = r6.longValue();
    L14:
        s(r1);
        return;
    L13:
        r1 = 0;
        goto L14
    L16:
        return;
    }

    public final void onMessage(tlc.d r6) {
        if ((r6 instanceof o0) == true) goto L5;
        tlc.d r0 = null;
    L6:
        o0 r1 = (o0) r0;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.getMessageType() != MessageType.UPDATE_FAN_TICKET_MESSAGE) goto L28;
        if (r6 == null) goto L27;
        qm r7 = (qm) r6;
        long r2 = 0;
        if (r7.E() == false) goto L22;
        Long r3 = r7.getCount();
        if (r3 == null) goto L17;
        long r4 = r3.longValue();
    L18:
        this.h = r4;
        Long r8 = r7.getCount();
        if (r8 == null) goto L21;
        r2 = r8.longValue();
    L21:
        r(r2);
        return;
    L17:
        r4 = 0;
        goto L18
    L22:
        Long r9 = r7.getCount();
        if (r9 == null) goto L25;
        r2 = r9.longValue();
    L25:
        s(r2);
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.UpdateFanTicketMessage");
    L28:
        return;
    L5:
        r0 = r6;
        goto L6
    }

    public final void r(long r7) {
        if (this.i != null) goto L5;
        return;
    L5:
        IRoom r0 = this.d;
        if (r0 == null) goto L10;
        IRoomStats r1 = r0.getStats();
        if (r1 == null) goto L10;
        r1.setTicket(r7);
    L10:
        u91.a r2 = this.i;
        if (r2 != null) goto L13;
    L26:
        String r8 = s1.C(2131911610, new Object[]{x.a(r7)});
        UserInfoVM.Companion.getClass();
        aa1.a r9 = UserInfoVM.b.b();
        if (r9 == null) goto L31;
        ElementBasicVM r10 = r9.getBasicVm();
        if (r10 == null) goto L31;
        ElementBasicVM.updateAccessibilityDesc$default(r10, null, r8, 1, null);
    L31:
        com.bytedance.android.live.room.navi.userinfo_p.flipper.core.e.e(this, r8);
        return;
    L13:
        if (r2.b != true) goto L26;
        if (r2.c != 1) goto L21;
        r8 = x.a(r7);
        UserInfoVM.Companion.getClass();
        aa1.a r12 = UserInfoVM.b.b();
        if (r12 == null) goto L31;
        ElementBasicVM r13 = r12.getBasicVm();
        if (r13 == null) goto L31;
        ElementBasicVM.updateAccessibilityDesc$default(r13, r8, null, 2, null);
        goto L31
    L21:
        r8 = s1.C(2131911610, new Object[]{""});
        UserInfoVM.Companion.getClass();
        aa1.a r14 = UserInfoVM.b.b();
        if (r14 == null) goto L31;
        ElementBasicVM r15 = r14.getBasicVm();
        if (r15 == null) goto L31;
        ElementBasicVM.updateAccessibilityDesc$default(r15, null, r8, 1, null);
        goto L31
    }

    public final void s(long r4) {
        if (this.h <= r4) goto L5;
        return;
    L5:
        this.h = r4;
        r(r4);
    }

    public TicketHolder(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}
