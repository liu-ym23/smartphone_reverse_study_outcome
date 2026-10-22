package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ParticipateHourRankSettingItem extends mx.j implements View.OnClickListener {
    public final Lazy m;
    public final Function0<Unit> n;
    public final Context o;

    public ParticipateHourRankSettingItem(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(s1.B(2131919974), null, false, 6);
        this.o = r7;
        Lazy r8 = InfraKotlinExtsKt.mainThreadLazy(ParticipateHourRankSettingItem$room$2.INSTANCE);
        this.m = r8;
        ((mx.j) this).l = this;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L6;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_hourly_rank_setting_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("room_id", String.valueOf(r9.id)), TuplesKt.to("anchor_id", r9.getOwnerUserIdString())}), new Object[0]);
    L6:
        this.n = UtilityKotlinExtentionsKt.y(new ParticipateHourRankSettingItem$openDialog$1(this));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.n.invoke();
    }
}
