package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.n2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ PKListUserViewHolder a;

    public j(PKListUserViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        PKListUserViewHolder r10 = this.a;
        int r0 = PKListUserViewHolder.Q;
        r10.getClass();
        b51.b r1 = b51.b.c0;
        r1.getClass();
        x0 r2 = new x0((String) b51.b.V.getValue(r1, b51.b.a[46]));
        x0 r3 = r2.d("url");
        JSONObject r4 = new JSONObject();
        com.bytedance.android.livesdk.revenue.service.room.c r5 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r5 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r6 = r5.getRoomContext();
        if (r6 == null) goto L11;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L11;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L11;
        long r12 = r8.getRoomId();
    L12:
        r4.put("room_id", String.valueOf(r12));
        IRoom r13 = r10.C;
        String r14 = "";
        if (r13 == null) goto L16;
        String r15 = String.valueOf(r13.getRoomId());
        if (r15 == null) goto L16;
    L17:
        r4.put("to_room_id", r15);
        y31.k r16 = r10.L;
        if (r16 == null) goto L24;
        IRoom r17 = r16.b;
        if (r17 == null) goto L24;
        IBaseUser r18 = r17.getOwner();
        if (r18 == null) goto L24;
        String r19 = r18.getUserId();
    L25:
        r4.put("to_user_id", r19);
        r4.put("client_attached_info", "");
        y31.k r20 = r10.L;
        if (r20 == null) goto L30;
        m2 r22 = r20.a;
        if (r22 == null) goto L30;
        String r23 = r22.getBattleAttachedInfo();
    L31:
        r4.put("battle_attached_info", r23);
        y31.k r24 = r10.L;
        if (r24 == null) goto L38;
        IRoom r25 = r24.b;
        if (r25 == null) goto L38;
        IBaseUser r26 = r25.getOwner();
        if (r26 == null) goto L38;
        String r27 = r26.getUserId();
    L39:
        r4.put("to_open_id", r27);
        r3.b("user_info", r4.toString());
        JSONObject r28 = new JSONObject();
        y31.k r29 = r10.L;
        if (r29 == null) goto L45;
        String r30 = r29.i;
        if (r30 == null) goto L45;
        r14 = r30;
    L45:
        r28.put("request_id", r14);
        y31.k r32 = r10.L;
        if (r32 == null) goto L50;
        m2 r33 = r32.a;
        if (r33 == null) goto L50;
        n2 r34 = r33.getInviteButton();
    L52:
        if (r34 == null) goto L62;
        y31.k r35 = r10.L;
        if (r35 == null) goto L60;
        m2 r36 = r35.a;
        if (r36 == null) goto L60;
        n2 r37 = r36.getInviteButton();
        if (r37 == null) goto L60;
        Long r38 = Long.valueOf(r37.getType());
    L61:
        r28.put("right_user_status", String.valueOf(r38));
    L63:
        r3.b("log", r28.toString());
        View r39 = ((RecyclerView.ViewHolder) r10).itemView;
        if (r39 == null) goto L68;
        Context r40 = r39.getContext();
        if (r40 == null) goto L68;
        ((vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(r40, r2.c(), null);
    L68:
        this.a.U3("livesdk_pk_invite_entrance_click");
        return;
    L60:
        r38 = null;
        goto L61
    L62:
        r28.put("right_user_status", "2");
    L50:
        r34 = null;
    L38:
        r27 = null;
    L30:
        r23 = null;
    L24:
        r19 = null;
    L16:
        r15 = "";
    L11:
        r12 = 0;
        goto L12
    }
}
