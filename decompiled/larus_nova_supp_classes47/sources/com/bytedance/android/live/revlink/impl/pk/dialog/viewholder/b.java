package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.h4;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ NewPkRecordViewHolder a;

    public b(NewPkRecordViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        NewPkRecordViewHolder r7 = this.a;
        int r0 = NewPkRecordViewHolder.z;
        r7.getClass();
        b51.b r1 = b51.b.c0;
        r1.getClass();
        x0 r2 = new x0((String) b51.b.T.getValue(r1, b51.b.a[44]));
        x0 r3 = r2.d("url");
        y31.d.a r4 = r7.b;
        if (r4 == null) goto L7;
        Function1<? super Boolean, Unit> r5 = r4.k;
        if (r5 == null) goto L7;
        Unit r8 = (Unit) r5.invoke(Boolean.TRUE);
    L7:
        y31.d.a r9 = r7.b;
        String r10 = null;
        if (r9 == null) goto L10;
        h4 r12 = r9.h;
    L11:
        r3.b("feed_back_info", GsonProtectorUtils.toJson(l97.a.a, r12));
        y31.d.a r13 = r7.b;
        if (r13 == null) goto L16;
        JSONObject r14 = r13.j;
        if (r14 == null) goto L16;
        r10 = r14.toString();
    L16:
        r3.b("user_info", r10);
        ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(((RecyclerView.ViewHolder) r7).itemView.getContext(), r2.c(), r7.x);
        LinkedHashMap r15 = new LinkedHashMap();
        com.bytedance.android.livesdk.revenue.room.a r16 = r7.e;
        String r17 = "";
        if (r16 == null) goto L24;
        com.bytedance.live.datacontext.m r18 = r16.getRoom();
        if (r18 == null) goto L24;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L24;
        String r20 = String.valueOf(r19.getRoomId());
        if (r20 == null) goto L24;
    L25:
        r15.put("room_id", r20);
        com.bytedance.android.livesdk.revenue.room.a r22 = r7.e;
        if (r22 == null) goto L33;
        IRoomBase r23 = r22.getCommonRoom();
        if (r23 == null) goto L33;
        IBaseUser r24 = r23.getOwnerKt();
        if (r24 == null) goto L33;
        String r25 = r24.getIdString();
        if (r25 == null) goto L33;
    L34:
        r15.put("anchor_id", r25);
        y31.d.a r26 = r7.b;
        if (r26 == null) goto L40;
        f2 r27 = r26.b;
        if (r27 == null) goto L40;
        String r28 = String.valueOf(r27.getChannelId());
        if (r28 == null) goto L40;
    L41:
        r15.put("channel_id", r28);
        y31.d.a r29 = r7.b;
        if (r29 == null) goto L47;
        f2 r30 = r29.b;
        if (r30 == null) goto L47;
        String r32 = r30.getBattleId();
        if (r32 == null) goto L47;
    L48:
        r15.put("pk_id", r32);
        y31.d.a r33 = r7.b;
        if (r33 == null) goto L59;
        f2 r34 = r33.b;
        if (r34 == null) goto L59;
        IBattleUserInfo r35 = r34.getBattleUserInfo();
        if (r35 == null) goto L59;
        k0 r36 = r35.getUserInfo();
        if (r36 == null) goto L59;
        String r37 = r36.getUserId();
        if (r37 == null) goto L59;
        r17 = r37;
    L59:
        r15.put("feedback_anchor_id", r17);
        y31.d.a r38 = r7.b;
        if (r38 == null) goto L66;
        f2 r39 = r38.b;
        if (r39 == null) goto L66;
        if (r39.getBattleResultType() != 1) goto L66;
        String r40 = "win";
    L74:
        r15.put("pk_result", r40);
        r15.put("request_page", "pk_record");
        mz0.n r42 = new mz0.n();
        Map<String, String> r43 = r42.a;
        Intrinsics.checkNotNullParameter(r43, "map");
        Intrinsics.checkNotNullParameter(r15, "map");
        r43.putAll(r15);
        mz0.m r44 = new mz0.m();
        r44.b(LogCommon.ROOM);
        ((ArrayList) r42.b).addAll(r44.a);
        cy0.e.a.getClass();
        cy0.j r45 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r46 = com.bytedance.android.scope.m.b(r45).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r46);
        ((mz0.i) ((f80.a) r46)).w3("livesdk_pk_record_nps_click", r42.a, r42.b);
        return;
    L66:
        y31.d.a r47 = r7.b;
        if (r47 == null) goto L73;
        f2 r48 = r47.b;
        if (r48 == null) goto L73;
        if (r48.getBattleResultType() != 2) goto L73;
        r40 = "loss";
    L73:
        r40 = "draw";
    L47:
        r32 = "";
    L40:
        r28 = "";
    L33:
        r25 = "";
    L24:
        r20 = "";
        goto L25
    L10:
        r12 = null;
        goto L11
    }
}
