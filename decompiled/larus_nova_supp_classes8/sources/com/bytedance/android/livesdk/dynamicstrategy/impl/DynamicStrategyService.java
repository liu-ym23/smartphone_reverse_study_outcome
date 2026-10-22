package com.bytedance.android.livesdk.dynamicstrategy.impl;

import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.m;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.x;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.y;
import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import com.bytedance.android.livesdk.dynamicstrategy.impl.source.DynamicStrategyApi;
import com.bytedance.android.livesdk.dynamicstrategy.impl.source.DynamicStrategyFetcher;
import com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.f;
import com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.g;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import ju1.h;
import ju1.l;
import ju1.n;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import nu1.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0004H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0006H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\rH\u0016J$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0006H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0006H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%0\u0006H\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/DynamicStrategyService;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyService;", "", "init", "", "eventKey", "", "eventParams", "sendNfaEvent", "", "forceFetchFull", "updateDynamicStrategyInfo", "strategyName", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a0;", "getDynamicStrategyRule", "express", "", "context", "executeExpress", "strategy", "Lju1/h;", "parseStrategy", "strategyRule", "parseStrategyRule", "Lju1/n;", "executeStrategy", "scene", "Lju1/l;", "parseScene", "executeScene", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext;", "createLiveRoomStrategyContext", "getGlobalStrategyContext", "Lis2/b;", "getFeatureBackendHandler", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/m;", "feature", "mockFeature", "getMockFeature", "<init>", "()V", "Companion", "a", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DynamicStrategyService implements IDynamicStrategyService {
    public static final a Companion = null;
    private static boolean isFirstTimeCreateContext;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        isFirstTimeCreateContext = true;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public is2.b getFeatureBackendHandler() {
        return new g();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public IDynamicStrategyContext getGlobalStrategyContext() {
        return GlobalDynamicStrategyContext.INSTANCE.init();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public Map<String, m> getMockFeature() {
        boolean r0 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.a;
        return com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.e;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public void init() {
        new com.bytedance.android.livesdk.dynamicstrategy.impl.source.b().run();
    }

    public DynamicStrategyService() {
        k.l(IDynamicStrategyService.class, this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public IDynamicStrategyContext createLiveRoomStrategyContext(DataCenter r8) {
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        long r0 = System.currentTimeMillis();
        AbsDynamicStrategyContext r2 = new LiveRoomDynamicStrategyContext(r8).init();
        long r3 = System.currentTimeMillis() - r0;
        int r1 = lu1.k.a;
        String r9 = String.valueOf(a0.n(r8).getRoomId());
        String r4 = String.valueOf(hashCode());
        Intrinsics.checkNotNullParameter(r9, "roomId");
        Intrinsics.checkNotNullParameter(r4, "contextTag");
        lu1.k.g("DynamicStrategy_cost", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "context init"), TuplesKt.to("room_id", r9), TuplesKt.to("context_tag", r4), TuplesKt.to("cost", String.valueOf(r3))}));
        int r10 = DynamicStrategyMonitor.a;
        boolean r11 = isFirstTimeCreateContext;
        JSONObject r5 = new JSONObject();
        r5.put("isFirst", r11);
        LiveMonitor.a r12 = DynamicStrategyMonitor.a(DynamicStrategyMonitor.Event.StrategyContextInitContext);
        r12.b(r5);
        r12.h(r3);
        r12.a().report();
        isFirstTimeCreateContext = false;
        return r2;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0 getDynamicStrategyRule(String r4) {
        Intrinsics.checkNotNullParameter(r4, "strategyName");
        boolean r0 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a;
        Iterator r1 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (TextUtils.equals(((com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0) r2).strategyName, r4) == false) goto L4;
    L10:
        return (com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0) r2;
    L8:
        r2 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public void mockFeature(m r3) {
        Intrinsics.checkNotNullParameter(r3, "feature");
        boolean r1 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.a;
        Intrinsics.checkNotNullParameter(r3, "feature");
        String r0 = r3.name;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.e.put(r0, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public l parseScene(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Map<String, l> r0 = mu1.a.a;
        Intrinsics.checkNotNullParameter(r3, "sceneStr");
        l r1 = (l) ((LinkedHashMap) mu1.a.a).get(r3);
        if (r1 != null) goto L17;
        Iterator r2 = ((ArrayList) mu1.a.b).iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        l r4 = ((e) r2.next()).parse();
        if (r4 == null) goto L7;
        mu1.a.a.put(r3, r4);
        return r4;
    L11:
        return null;
    L17:
        return r1;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public h parseStrategy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        return mu1.b.d(r2);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public h parseStrategyRule(com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "strategyRule");
        return mu1.b.c(r2);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public void updateDynamicStrategyInfo(boolean r8) {
        DynamicStrategyFetcher.INSTANCE.updateStrategyWhenUserChanged(null, r8);
        boolean r9 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.a;
        if (com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.a == true) goto L5;
        com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.d();
    L5:
        Boolean r10 = (Boolean) ku1.e.a.getValue();
        lu1.k.a("CloudFactorStore onLoginChanged");
        DynamicStrategyApi r1 = (DynamicStrategyApi) com.bytedance.android.live.network.c.b().e(DynamicStrategyApi.class);
        if (r1 == null) goto L16;
        String r3 = com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a.c;
        String r0 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.b()).second;
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        Observable<BaseResponse<y, x>> r2 = r1.getFeature(4, r3, "", r0, r10.booleanValue());
        if (r2 == null) goto L17;
        Observable r4 = r2.subscribeOn(Schedulers.io());
        if (r4 == null) goto L18;
        r4.subscribe(new com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.e(r10), f.a);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public Object executeExpress(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "express");
        Intrinsics.checkNotNullParameter(r4, "context");
        return qu1.b.a(r3, r4);
    L5:
        e = move-exception;
        int r0 = lu1.k.a;
        lu1.k.f("external_call ", r3, e);
        int r1 = DynamicStrategyMonitor.a;
        String r5 = e.getMessage();
        if (r5 != null) goto L9;
        r5 = "express error";
    L9:
        DynamicStrategyMonitor.d("external_call", "unknown", r3, r5);
        return null;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public boolean executeScene(l r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "context");
        return mu1.a.a(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public n executeStrategy(h r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r3, "context");
        return mu1.b.b(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyService
    public void sendNfaEvent(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventKey");
        Intrinsics.checkNotNullParameter(r3, "eventParams");
        com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.f.b.getClass();
        com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.f.a(r2, r3);
    }
}
