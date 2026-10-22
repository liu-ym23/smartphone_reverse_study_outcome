package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.profit.fansclub.widget.entrance.EntranceUtilsKt;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ FollowMVIViewModel a;
    public final /* synthetic */ com.bytedance.android.live.profit.fansclub.widget.entrance.data.i b;

    public b(FollowMVIViewModel r1, com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        IFollowPair r12 = (IFollowPair) r10;
        boolean r1 = true;
        ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).getCurrentRechargeCacheDataObject().setFollowed(true);
        Context r0 = this.b.getContext();
        if ((r0 instanceof FragmentActivity) == true) goto L5;
        r0 = null;
    L5:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).W((FragmentActivity) r0, this.b.f());
        if (r12.getFollowStatus() == 0) goto L23;
        FollowMVIViewModel r2 = this.a;
        DataCenter r3 = this.b.a;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L10:
        String r4 = this.b.f();
        long r5 = this.b.k();
        r2.getClass();
        if (c1.b(r3) == false) goto L13;
    L14:
        JSONObject r7 = new JSONObject();
        r7.put("follow_status", r12.getFollowStatus());     // Catch: JSONException -> L17
        r7.put("anchor_id", r4);     // Catch: JSONException -> L17
        r7.put("room_id", String.valueOf(r5));     // Catch: JSONException -> L17
    L18:
        r2.u1(r7);
        ILiveDouPlusService r13 = jc1.k.n(ILiveDouPlusService.class);
        if (c1.b(r3) == false) goto L21;
        Map r6 = c1.e(r3);
    L22:
        r13.logEvent(true, "live_ad", "follow_success", FollowMVIViewModel.h1(r7, r6));
        goto L23
    L21:
        r6 = c1.f(r3);
        goto L22
    L13:
        if (c1.c(r3) == true) goto L14;
    L23:
        FollowMVIViewModel.e1(this.a, "关注成功");
        FollowMVIViewModel r14 = this.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r8 = fu0.b.a(r14.getDataCenter());
        if (r8 == null) goto L67;
        ReadOnlyProperty r9 = com.bytedance.android.live.profit.fansclub.i.n;
        KProperty[] r15 = com.bytedance.android.live.profit.fansclub.i.a;
        if (((Number) r9.getValue(null, r15[11])).intValue() != 2) goto L32;
        if (r8.j().a == FansClubUserStatus.Active) goto L32;
        EntranceUtilsKt.b(r14.y, r14.getDataCenter());
        return;
    L32:
        if (((Number) r9.getValue(null, r15[11])).intValue() == 1) goto L34;
        return;
    L34:
        if (r8.A() == false) goto L37;
    L48:
        r1 = false;
    L49:
        if (r1 == false) goto L64;
        o r16 = yt0.d.a(r14.y).a();
        if (r16 == null) goto L65;
        m<com.bytedance.android.live.profit.fansclub.e> r17 = r16.getParticipateIncentive();
        if (r17 != null) goto L56;
        return;
    L56:
        if (((com.bytedance.android.live.profit.fansclub.e) r17.getValue()).a == 0) goto L58;
        r14.K0(EntranceUtilsKt.a());
        return;
    L58:
        RxUtilKt.c(RxUtilKt.h(r17.a()).first(r17.getValue()).timeout(3, TimeUnit.SECONDS).subscribe(new d(r14, r17), new e(r17)), r14.v);
        return;
    L65:
        return;
    L64:
        return;
    L37:
        if (fm3.c.c == false) goto L48;
        if (r8.j().a != FansClubUserStatus.Active) goto L43;
        ALogger.i("EntranceDataSource", "canShowFansClubTipGuide=false, reason=joined");
        goto L48
    L43:
        if (r8.F() == false) goto L46;
        ALogger.i("EntranceDataSource", "canShowFansClubTipGuide=false, reason=is ecom fans club mode");
        goto L48
    L46:
        if (r8.c() == true) goto L49;
        ALogger.i("EntranceDataSource", "canShowFansClubTipGuide=false, reason=fans club disallowed");
        goto L48
    }
}
