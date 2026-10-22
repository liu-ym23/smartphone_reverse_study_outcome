package com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightPKProgressLayout;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightProgressBar;
import com.bytedance.ies.sdk.widgets.KVData;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ DynamicTeamFightViewManager a;

    public a(DynamicTeamFightViewManager r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        if (Intrinsics.areEqual(r10.getKey(), "data_multi_fight_profit_egg") == false) goto L21;
        JsonObject r11 = (JsonObject) r10.getData();
        if (r11 == null) goto L9;
        JsonElement r12 = r11.get("status");
        if (r12 == null) goto L9;
        int r13 = r12.getAsInt();
    L10:
        TeamFightPKProgressLayout r1 = this.a.e;
        if (r13 != 6) goto L17;
        if (r1.h == true) goto L23;
        r1.h = true;
        int r14 = TeamFightProgressBar.s;
        int r0 = (int) (((double) r14) * 2.5d);
        r1.b = r0;
        a1.p(r1.B, r0);
        a1.k(r1.B, r14);
        a1.k(r1.y, r14);
        r1.y.setEnlarge(true);
        r1.g(r1.d, r1.e, true);
        r1.a(r1.y.getProgress());
        return;
    L23:
        return;
    L17:
        if (r1.h == false) goto L24;
        r1.h = false;
        r1.i = false;
        UtilityKotlinExtentionsKt.t(r1.z);
        UtilityKotlinExtentionsKt.t(r1.n);
        UtilityKotlinExtentionsKt.t(r1.q);
        int r15 = s1.j(2131169158);
        r1.b = r15;
        a1.p(r1.B, r15);
        HSImageView r16 = r1.B;
        int r2 = TeamFightProgressBar.r;
        a1.k(r16, r2);
        a1.k(r1.y, r2);
        r1.y.setEnlarge(false);
        r1.g(r1.d, r1.e, true);
        r1.y.b(0);
        r1.y.c(0);
        r1.a(r1.y.getProgress());
        return;
    L24:
        return;
    L9:
        r13 = 0;
        goto L10
    }
}
