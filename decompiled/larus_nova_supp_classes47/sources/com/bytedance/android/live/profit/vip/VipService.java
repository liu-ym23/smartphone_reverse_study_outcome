package com.bytedance.android.live.profit.vip;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.model.v0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VipService implements com.bytedance.android.scope.o, e {
    public VipContext a;
    public Disposable b;
    public final com.bytedance.android.live.revenue.core.a c;
    public final kv0.a d;
    public final p e;
    public final VipDataService f;
    public final yz0.g g;

    @Override // com.bytedance.android.live.profit.vip.e
    public final com.bytedance.live.datacontext.i<Boolean> getCanShowVipSingleBadge() {
        VipContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getCanShowVipSingleBadge();
    }

    @Override // com.bytedance.android.live.profit.vip.e
    public final com.bytedance.live.datacontext.m<Boolean> getHasNewSubscribeEmoji() {
        VipContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getHasNewSubscribeEmoji();
    }

    @Override // com.bytedance.android.live.profit.vip.e
    public final com.bytedance.live.datacontext.m<? extends h> getSubscribeInfo() {
        VipContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.getSubscribeInfo();
    }

    @Override // com.bytedance.android.live.profit.vip.e
    public final com.bytedance.live.datacontext.i<Boolean> isAnchor() {
        VipContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.isAnchor();
    }

    @Override // com.bytedance.android.live.profit.vip.e
    public final com.bytedance.live.datacontext.m<Boolean> isEmojiPanelShow() {
        VipContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.isEmojiPanelShow();
    }

    @Override // com.bytedance.android.live.profit.vip.e
    public final com.bytedance.live.datacontext.m<Boolean> isFirstTimeOpenEmoji() {
        VipContext r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("ctx");
    L6:
        return r0.isFirstTimeOpenEmoji();
    }

    public final void onStart() {
        Pair r0 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        VipContext r1 = (VipContext) r0.component1();
        Disposable r2 = (Disposable) r0.component2();
        this.a = r1;
        this.b = r2;
        r1.isAnchor().d(Boolean.valueOf(this.g.isAnchor()));
        com.bytedance.live.datacontext.i<Boolean> r3 = r1.getCanShowVipSingleBadge();
        Map r4 = IRoomKt_androidKt.getAnchorABMap(this.g.mo444getRoom());
        if (r4 != null) goto L6;
        r4 = new LinkedHashMap();
    L6:
        if (r4.containsKey("live_vip_badge_separate") == false) goto L8;
        boolean r5 = Intrinsics.areEqual((String) r4.get("live_vip_badge_separate"), DataType.TRUE);
    L9:
        r3.d(Boolean.valueOf(r5));
        yu0.e.a(this.e.f, r1.getSubscribeInfo());
        yu0.e.a(this.e.h, r1.getHasNewSubscribeEmoji());
        this.c.d(Reflection.getOrCreateKotlinClass(e.class), this.d);
        return;
    L8:
        r5 = true;
        goto L9
    }

    public final void onStop() {
        this.b.dispose();
    }

    @Override // com.bytedance.android.live.profit.vip.e
    public final b u1() {
        return this.e.c();
    }

    @Override // com.bytedance.android.live.profit.vip.e
    public final void bn(String r3) {
        Intrinsics.checkNotNullParameter("emoji", "source");
        VipDataService r1 = this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter("emoji", "source");
        r1.e.d("emoji");
    }

    @Override // com.bytedance.android.live.profit.vip.e
    public final void td(b r2) {
        Intrinsics.checkNotNullParameter(r2, "cache");
        this.e.f(r2);
    }

    @Override // com.bytedance.android.live.profit.vip.e
    public final Single<v0> Ti(long r13, int r15) {
        p r0 = this.f.e;
        int r14 = 1;
        Map r16 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", String.valueOf(r0.b)), TuplesKt.to("emoji_id", String.valueOf(r13)), TuplesKt.to("type", String.valueOf(r15))});
        if (r0.k.isVsRoom() == false) goto L8;
        com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
        long r2 = System.currentTimeMillis();
        Pair r3 = r0.j.getRoomContext().getSeiTimePair();
        long r4 = ((Number) r3.component1()).longValue() + (r2 - ((Number) r3.component2()).longValue());
        long r5 = r0.k.getEpisodeId();
        if (r0.k.q3() == false) goto L7;
        r14 = 2;
    L7:
        JSONObject r17 = new JSONObject();
        r17.put("episode_id", r5);
        r17.put("stage", r14);
        r16.put("flow_time", String.valueOf(r4));
        r16.put("episode_info_str", r17.toString());
    L8:
        int r18 = iv0.a.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        tz0.b r19 = tz0.b.a;
        uz0.e r110 = new uz0.e();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r110, "$this$beforeConfigureRequest");
        Iterator r111 = r16.entrySet().iterator();
    L10:
        if (r111.hasNext() == false) goto L12;
        Map.Entry r112 = (Map.Entry) r111.next();
        String r6 = (String) r112.getKey();
        String r113 = (String) r112.getValue();
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r113, "value");
        r110.e.put(r6, r113);
        goto L10
    L12:
        Intrinsics.checkNotNullParameter(r110, "$this$afterConfigureRequest");
        Single r114 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/room/chat/", TypesJVMKt.getJavaType(Reflection.typeOf(v0.class)), Extra.class, r110.d, r110.a, r110.b, r110.c, r110.e, r110.f, r110.g).singleOrError().map(s.a);
        int r115 = com.bytedance.revenue.platform.api.core.rx.p.a;
        return r114.observeOn(AndroidSchedulers.mainThread());
    }

    public VipService(com.bytedance.android.live.revenue.core.a r2, kv0.a r3, p r4, VipDataService r5, yz0.g r6) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        Intrinsics.checkNotNullParameter(r3, "myScope");
        Intrinsics.checkNotNullParameter(r4, "repository");
        Intrinsics.checkNotNullParameter(r5, "dataService");
        Intrinsics.checkNotNullParameter(r6, "roomDataService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.b = new CompositeDisposable();
    }
}
