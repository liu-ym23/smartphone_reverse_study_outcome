package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ NewPkRecordViewHolder a;
    public final /* synthetic */ String b;

    public g(NewPkRecordViewHolder r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        x0 r6 = new x0(this.b);
        y31.d.a r0 = this.a.b;
        if (r0 == null) goto L7;
        Function1<? super Boolean, Unit> r1 = r0.k;
        if (r1 == null) goto L7;
        Unit r2 = (Unit) r1.invoke(Boolean.TRUE);
    L7:
        ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(((RecyclerView.ViewHolder) this.a).itemView.getContext(), r6.c(), this.a.x);
        LinkedHashMap r7 = new LinkedHashMap();
        com.bytedance.android.livesdk.revenue.room.a r3 = this.a.e;
        String r4 = "";
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.m r8 = r3.getRoom();
        if (r8 == null) goto L15;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L15;
        String r10 = String.valueOf(r9.getRoomId());
        if (r10 == null) goto L15;
    L16:
        r7.put("room_id", r10);
        com.bytedance.android.livesdk.revenue.room.a r12 = this.a.e;
        if (r12 == null) goto L24;
        IRoomBase r13 = r12.getCommonRoom();
        if (r13 == null) goto L24;
        IBaseUser r14 = r13.getOwnerKt();
        if (r14 == null) goto L24;
        String r15 = r14.getIdString();
        if (r15 == null) goto L24;
    L25:
        r7.put("anchor_id", r15);
        y31.d.a r16 = this.a.b;
        if (r16 == null) goto L31;
        f2 r17 = r16.b;
        if (r17 == null) goto L31;
        String r18 = String.valueOf(r17.getChannelId());
        if (r18 == null) goto L31;
    L32:
        r7.put("channel_id", r18);
        y31.d.a r19 = this.a.b;
        if (r19 == null) goto L38;
        f2 r20 = r19.b;
        if (r20 == null) goto L38;
        String r22 = r20.getBattleId();
        if (r22 == null) goto L38;
    L39:
        r7.put("pk_id", r22);
        r7.put("btn_type", "level");
        y31.d.a r23 = this.a.b;
        if (r23 == null) goto L51;
        f2 r24 = r23.b;
        if (r24 == null) goto L51;
        IBattleUserInfo r25 = r24.getBattleUserInfo();
        if (r25 == null) goto L51;
        k0 r26 = r25.getUserInfo();
        if (r26 == null) goto L51;
        String r27 = r26.getUserId();
        if (r27 == null) goto L51;
        r4 = r27;
    L51:
        r7.put("click_user_id", r4);
        mz0.n r28 = new mz0.n();
        Map<String, String> r29 = r28.a;
        Intrinsics.checkNotNullParameter(r29, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r29.putAll(r7);
        mz0.m r30 = new mz0.m();
        r30.b(LogCommon.ROOM);
        List<Object> r32 = r28.b;
        ArrayList r33 = (ArrayList) r32;
        r33.addAll(r30.a);
        cy0.e.a.getClass();
        cy0.j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((mz0.i) ((f80.a) r35)).w3("livesdk_all_pk_records_choice_panel_detail_click", r28.a, r28.b);
        return;
    L38:
        r22 = "";
    L31:
        r18 = "";
    L24:
        r15 = "";
    L15:
        r10 = "";
        goto L16
    }
}
