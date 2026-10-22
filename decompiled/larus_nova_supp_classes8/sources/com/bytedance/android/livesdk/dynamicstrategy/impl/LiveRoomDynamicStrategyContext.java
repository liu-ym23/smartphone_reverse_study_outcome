package com.bytedance.android.livesdk.dynamicstrategy.impl;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveDanmakuCountLevel;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveDanmakuHotRate;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveHasFirstFrame;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveLotteryTermInterestFactor;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveOrientationChanged;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LivePkAndLinkState;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LivePublicScreenHotState;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LivePublicScreenMessageFansRate;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LivePublicScreenMessageHotRate;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LivePublicScreenMessageLongRate;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LivePublicScreenMessageMeanLength;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveRedpackTermInterestFactor;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveRoomAudienceNumber;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveRoomTypeFactor;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveScreenOrientation;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.LiveShowMentionMessage;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.b0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.c0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.d0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.e0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.f0;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.i;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.m;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.n;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.o;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.p;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.q;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.r;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.t;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.u;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.v;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.w;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.x;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.y;
import com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.z;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/LiveRoomDynamicStrategyContext;", "Lcom/bytedance/android/livesdk/dynamicstrategy/impl/AbsDynamicStrategyContext;", "", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "onLoadFeatureList", "", "strategyName", "Liu1/b;", "onLoadStrategy", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomDynamicStrategyContext extends AbsDynamicStrategyContext {
    private final DataCenter dataCenter;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.AbsDynamicStrategyContext
    public List<DynamicFactor<? extends Object>> onLoadFeatureList() {
        ArrayList r0 = new ArrayList();
        r0.addAll(a.a());
        DataCenter r1 = this.dataCenter;
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        ArrayList r2 = new ArrayList();
        List r3 = CollectionsKt.listOf(new DynamicFactor[]{new v(r1), new r(r1), new n(a0.d(r1, false)), new x(), new b0(), new f0(), new com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.a0(r1), new y(), new LiveShowMentionMessage(r1), new com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor.a(), new i(), new LivePkAndLinkState(r1), new t(r1), new LivePublicScreenHotState(r1), new LiveDanmakuCountLevel(r1), new LivePublicScreenMessageLongRate(r1), new LivePublicScreenMessageHotRate(r1), new LiveDanmakuHotRate(r1), new LivePublicScreenMessageFansRate(r1), new LiveRoomTypeFactor(r1), new LivePublicScreenMessageMeanLength(r1), new LiveRoomAudienceNumber(r1), new p(r1), new LiveScreenOrientation(r1), new LiveHasFirstFrame(r1), new q(r1), new LiveOrientationChanged(r1), new o(r1), new m(), new w(), new z(), new c0(), new LiveLotteryTermInterestFactor(r1), new LiveRedpackTermInterestFactor(r1), new u(), new e0(r1), new d0(r1)});
        if (r3 == null) goto L5;
        r2.addAll(r3);
    L5:
        boolean r4 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.a;
        List r5 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.c();
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L21;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.m r10 = (com.bytedance.android.livesdk.dynamicstrategy.api.entity.m) r7.next();
        Intrinsics.checkNotNullParameter(r10, "$this$isNFALiveRoom");
        if (r10.featureType != 6) goto L15;
        s r11 = r10.nfaInfo;
        if (r11 == null) goto L15;
        if (r11.c() != 3) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L18;
        lu1.n r13 = j.a(r10);
    L19:
        if (r13 == null) goto L7;
        r6.add(r13);
        goto L7
    L18:
        r13 = null;
    L15:
        r12 = false;
        goto L16
    L21:
        List r8 = CollectionsKt.toList(r6);
        if (r8 == null) goto L24;
        r2.addAll(r8);
    L24:
        List<a.d<?, ?>> r9 = a.a;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r15 = r9.iterator();
    L26:
        if (r15.hasNext() == false) goto L32;
        a.d r16 = (a.d) r15.next();
        if (r16 == null) goto L31;
        r14.add(new a.e(r16));
        goto L26
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dynamicstrategy.impl.DynamicFeatureFactory.MixFeature<kotlin.Any, kotlin.Any>");
    L32:
        List r17 = CollectionsKt.toList(r14);
        if (r17 == null) goto L35;
        r2.addAll(r17);
    L35:
        List<a.f<?>> r18 = a.b;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L37:
        if (r20.hasNext() == false) goto L43;
        a.f r21 = (a.f) r20.next();
        if (r21 == null) goto L42;
        r19.add(new a.g(r21, r1, r21.a));
        goto L37
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dynamicstrategy.impl.DynamicFeatureFactory.MixJSBFeature<kotlin.Any>");
    L43:
        List r22 = CollectionsKt.toList(r19);
        if (r22 == null) goto L46;
        r2.addAll(r22);
    L46:
        r0.addAll(r2);
        return r0;
    }

    public LiveRoomDynamicStrategyContext(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(String.valueOf(a0.n(r3).getRoomId()), IDynamicStrategyContext.Scope.LIVE_ROOM);
        this.dataCenter = r3;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.AbsDynamicStrategyContext
    public iu1.b onLoadStrategy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "strategyName");
        List<String> r0 = c.a;
        return c.a(r2, this.dataCenter);
    }
}
