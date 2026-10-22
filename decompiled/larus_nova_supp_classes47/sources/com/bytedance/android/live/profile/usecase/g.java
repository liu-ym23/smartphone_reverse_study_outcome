package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ f a;

    public g(f r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        IFollowPair r9 = (IFollowPair) r8;
        if (r9 == null) goto L30;
        int r1 = r9.getFollowStatus();
        this.a.a(r1);
        boolean r2 = com.bytedance.android.live.revenue.core.util.h.a;
        RechargeCurrentCacheData r3 = ((com.bytedance.android.live.recharge.k) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.recharge.k.class)).getCurrentRechargeCacheDataObject();
        if (r3 == null) goto L7;
        r3.setFollowed(true);
    L7:
        f2.b(2131919118, 0);
        DataCenter r4 = this.a.d.getRoomDataCenter();
        if (r4 == null) goto L30;
        if (r1 == 0) goto L30;
        ps0.b r5 = this.a.d.getRoom();
        String r6 = this.a.d.getTargetUser().baseProfileInfo.getIdStr();
        this.a.d.getLogUseCase().getClass();
        Intrinsics.checkNotNullParameter(r4, "mDataCenter");
        Intrinsics.checkNotNullParameter(r5, "room");
        Intrinsics.checkNotNullParameter(r6, "userId");
        if ((!Intrinsics.areEqual(r6, r5.getOwnerUserIdStr())) == true) goto L30;
        if (c1.b(r4) == false) goto L16;
    L17:
        JSONObject r7 = new JSONObject();
        r7.put("follow_status", Integer.valueOf(r9.getFollowStatus()));     // Catch: JSONException -> L20
        r7.put("anchor_id", r5.getOwnerUserIdStr().toString());     // Catch: JSONException -> L20
        r7.put("room_id", r5.getId());     // Catch: JSONException -> L20
    L22:
        os0.b.c().getLiveRoomEventParamUtils().handleLiveAdExtraData(r7);
        ILiveDouPlusService r10 = jc1.k.n(ILiveDouPlusService.class);
        os0.c r12 = new os0.c();
        r12.a(r7);
        if (c1.b(r4) == false) goto L26;
        Map r13 = c1.e(r4);
    L29:
        r12.b(r13);
        r10.logEvent(true, "live_ad", "follow_success", r12.a);
        goto L30
    L26:
        if (c1.c(r4) == false) goto L28;
        r13 = c1.f(r4);
        goto L29
    L28:
        r13 = null;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L16:
        if (c1.c(r4) == true) goto L17;
    L30:
        this.a.a = false;
    }
}
