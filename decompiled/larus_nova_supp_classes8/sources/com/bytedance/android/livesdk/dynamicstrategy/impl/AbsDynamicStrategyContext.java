package com.bytedance.android.livesdk.dynamicstrategy.impl;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.e;
import com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g;
import com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.h;
import com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.i;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ju1.n;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import lu1.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001=B\u0017\u0012\u0006\u00103\u001a\u00020\u0005\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000e\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0006\u0010\u0010\u001a\u00020\u0000J\b\u0010\u0011\u001a\u00020\u0003H\u0014J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001e\u0010\u0017\u001a\u00020\u00032\u0014\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\u0015H\u0016J\u0016\u0010\u0019\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016J\u0012\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\u0015H\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0016\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\u0015H&J\u0012\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u0005H&R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R&\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00106\u001a\u0002058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/AbsDynamicStrategyContext;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext;", "", "onInit", "", LiveEndPageData.TAG_NAME, "Liu1/b;", "strategy", "insertAndExecuteStrategy", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "dynamicFactor", "source", "checkAndProcessNFA", "tryStartTestStrategy", "init", "onCleared", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lju1/n;", "getStrategy", "", "factors", "upsertFactors", "strategies", "upsertStrategy", "", "getTestFeatureValue", "getTestFeatureList", "getTestStrategyList", "featureName", "featureValue", "mockFeatureValue", "onLoadFeatureList", "strategyName", "onLoadStrategy", "Luu1/b;", "stateManager", "Luu1/b;", "Lcom/bytedance/android/livesdk/dynamicstrategy/impl/nfa/h;", "nfaManager", "Lcom/bytedance/android/livesdk/dynamicstrategy/impl/nfa/h;", "", "strategyResultMap", "Ljava/util/Map;", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "", "hasInit", "Z", "roomId", "Ljava/lang/String;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext$Scope;", "scope", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext$Scope;", "getScope", "()Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext$Scope;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext$Scope;)V", "Companion", "a", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsDynamicStrategyContext extends ViewModel implements IDynamicStrategyContext {
    public static final a Companion = null;
    private static volatile h globalNfaManager;
    private final CompositeDisposable disposable;
    private volatile boolean hasInit;
    private final h nfaManager;
    private final String roomId;
    private final IDynamicStrategyContext.Scope scope;
    private final uu1.b stateManager;
    private final Map<String, PropertyOwner<n>> strategyResultMap;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ g a;
        public final /* synthetic */ g.a b;

        public b(g r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            this.a.c(this.b);
        }
    }

    public static final class c implements g.a {
        public final /* synthetic */ DynamicFactor a;

        public c(DynamicFactor r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g.a
        public final void a(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
            ((l) this.a).update(Boolean.valueOf(r3));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;

        public d(String r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            f2.c("策略[" + this.a + "]:" + ((n) r3).c(), 0);
        }
    }

    static {
        Companion = new a();
    }

    public final synchronized AbsDynamicStrategyContext init() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.hasInit == true) goto L6;
        onInit();     // Catch: Throwable -> L8
        this.hasInit = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return this;
    }

    public abstract List<DynamicFactor<? extends Object>> onLoadFeatureList();

    public abstract iu1.b onLoadStrategy(String r1);

    public List<DynamicFactor<?>> getTestFeatureList() {
        return this.stateManager.f();
    }

    public Map<String, Object> getTestFeatureValue() {
        return this.stateManager.q();
    }

    public List<iu1.b> getTestStrategyList() {
        return this.stateManager.o();
    }

    private final void onInit() {
        Iterator<T> r0 = onLoadFeatureList().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DynamicFactor<? extends Object> r1 = (DynamicFactor) r0.next();
        checkAndProcessNFA(r1, "context init");
        this.stateManager.a(r1);
        goto L4
    L6:
        int r2 = k.a;
        String r3 = this.roomId;
        String r4 = String.valueOf(hashCode());
        List<ju1.c<Object>> r5 = this.stateManager.m();
        List<ju1.l> r6 = this.stateManager.getSceneList();
        List<ju1.h> r7 = this.stateManager.j();
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "contextTag");
        Intrinsics.checkNotNullParameter(r5, "factor");
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter(r7, "strategy");
        Pair[] r8 = new Pair[6];
        r8[0] = TuplesKt.to("action", "create");
        r8[1] = TuplesKt.to("room_id", r3);
        r8[2] = TuplesKt.to("context_tag", r4);
        List<ju1.c<Object>> r9 = r5;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        ju1.c r12 = (ju1.c) r11.next();
        r10.add(r12.a + '|' + r12.b);
        goto L8
    L10:
        r8[3] = TuplesKt.to("factor", CollectionsKt.toList(r10));
        List<ju1.l> r13 = r6;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r15 = r13.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        r14.add(((ju1.l) r15.next()).b());
        goto L12
    L14:
        r8[4] = TuplesKt.to("scene", CollectionsKt.toList(r14));
        List<ju1.h> r16 = r7;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L16:
        if (r18.hasNext() == false) goto L18;
        ju1.h r19 = (ju1.h) r18.next();
        r17.add(r19.b() + '|' + r19.d());
        goto L16
    L18:
        r8[5] = TuplesKt.to("strategy", CollectionsKt.toList(r17));
        k.g("DynamicStrategy_room_context", MapsKt.mutableMapOf(r8));
        this.stateManager.prepare();
        this.nfaManager.prepare();
        Iterator<Map.Entry<String, n>> r20 = this.stateManager.g().entrySet().iterator();
    L20:
        if (r20.hasNext() == false) goto L22;
        Map.Entry<String, n> r21 = r20.next();
        this.strategyResultMap.put(r21.getKey(), new PropertyOwner(r21.getValue()));
        goto L20
    L22:
        this.stateManager.k(new AnonymousClass3(this));
        tryStartTestStrategy();
    }

    private final void tryStartTestStrategy() {
        if (v.a() == false) goto L14;
        String r0 = ((ku1.b) ku1.c.a.getValue()).f();
        if (r0 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L16;
        PropertyOwner<n> r1 = getStrategy(r0);
        if (r1 == null) goto L17;
        Disposable r2 = r1.subscribe(new d(r0));
        if (r2 == null) goto L18;
        RxUtilKt.c(r2, this.disposable);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public void onCleared() {
        super.onCleared();
        this.disposable.clear();
        int r0 = k.a;
        String r1 = this.roomId;
        String r2 = String.valueOf(hashCode());
        Intrinsics.checkNotNullParameter(r1, "roomId");
        Intrinsics.checkNotNullParameter(r2, "contextTag");
        k.g("DynamicStrategy_room_context", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action", "destroy"), TuplesKt.to("room_id", r1), TuplesKt.to("context_tag", r2)}));
        long r10 = this.stateManager.i();
        if (r10 <= 0) goto L5;
        String r3 = this.roomId;
        String r5 = String.valueOf(hashCode());
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r5, "contextTag");
        k.g("DynamicStrategy_cost", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "strategy execute"), TuplesKt.to("room_id", r3), TuplesKt.to("context_tag", r5), TuplesKt.to("cost", String.valueOf(r10))}));
        int r4 = DynamicStrategyMonitor.a;
        LiveMonitor.a r6 = DynamicStrategyMonitor.a(DynamicStrategyMonitor.Event.StrategyExecuteCost);
        r6.h(r10);
        r6.a().report();
    L5:
        this.stateManager.destroy();
        this.nfaManager.release();
    }

    public static final /* synthetic */ h access$getGlobalNfaManager$cp() {
        return globalNfaManager;
    }

    public IDynamicStrategyContext.Scope getScope() {
        return this.scope;
    }

    public static final /* synthetic */ Map access$getStrategyResultMap$p(AbsDynamicStrategyContext r0) {
        return r0.strategyResultMap;
    }

    public static final /* synthetic */ void access$setGlobalNfaManager$cp(h r0) {
        globalNfaManager = r0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext
    public PropertyOwner<n> getStrategy(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
        PropertyOwner<n> r0 = this.strategyResultMap.get(r3);
        if (r0 != null) goto L8;
        iu1.b r1 = onLoadStrategy(r3);
        if (r1 == null) goto L9;
        insertAndExecuteStrategy(r3, r1);
        return this.strategyResultMap.get(r3);
    L9:
        return r0;
    L8:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext
    public void upsertFactors(List<? extends DynamicFactor<? extends Object>> r5) {
        Intrinsics.checkNotNullParameter(r5, "factors");
        List<? extends DynamicFactor<? extends Object>> r0 = r5;
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        checkAndProcessNFA((DynamicFactor) r1.next(), "upsert factor");
        goto L4
    L7:
        if ((!r5.isEmpty()) == false) goto L9;
        this.stateManager.b(r5);
    L9:
        int r6 = k.a;
        StringBuilder r7 = new StringBuilder("upsert factors: ");
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r3 = r0.iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        r2.add(((DynamicFactor) r3.next()).c());
        goto L11
    L13:
        r7.append(TextUtils.join(",", r2));
        k.a(r7.toString());
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext
    public void upsertStrategy(List<? extends iu1.b> r4) {
        Intrinsics.checkNotNullParameter(r4, "strategies");
        List<? extends iu1.b> r5 = r4;
        Iterator<T> r0 = r5.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        iu1.b r1 = (iu1.b) r0.next();
        insertAndExecuteStrategy(r1.getStrategy().b(), r1);
        goto L4
    L6:
        int r2 = k.a;
        StringBuilder r3 = new StringBuilder("upsert strategies: ");
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r6.add(((iu1.b) r7.next()).getStrategy().b());
        goto L8
    L10:
        r3.append(TextUtils.join(",", r6));
        k.a(r3.toString());
    }

    public AbsDynamicStrategyContext(String r2, IDynamicStrategyContext.Scope r3) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.roomId = r2;
        this.scope = r3;
        this.stateManager = new uu1.a();
        this.nfaManager = new i(r2);
        this.strategyResultMap = new LinkedHashMap();
        this.disposable = new CompositeDisposable();
    }

    private final void checkAndProcessNFA(DynamicFactor<? extends Object> r7, String r8) {
        if ((r7 instanceof l) == false) goto L32;
        String r0 = r7.c();
        l r1 = (l) r7;
        s r2 = r1.d;
        if (r2.c() != 2) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L23;
        Companion.getClass();
        if (access$getGlobalNfaManager$cp() == null) goto L12;
    L22:
        h r4 = access$getGlobalNfaManager$cp();
    L24:
        if (r4 == null) goto L26;
        g r9 = r4.c(new e(r0, r2, this.roomId), r8);
    L27:
        if (r9 == null) goto L33;
        r1.b = r9.b();
        c r5 = new c(r7);
        r9.f(r5);
        this.disposable.add(Disposables.fromAction(new b(r9, r5)));
        return;
    L33:
        return;
    L26:
        r9 = null;
        goto L27
    L12:
        monitor-enter(h.class);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (access$getGlobalNfaManager$cp() != null) goto L16;
        i r6 = new i("");     // Catch: Throwable -> L19
        r6.prepare();     // Catch: Throwable -> L19
        access$setGlobalNfaManager$cp(r6);     // Catch: Throwable -> L19
    L16:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(h.class);
        goto L22
    L23:
        r4 = this.nfaManager;
        goto L24
    L7:
        r3 = false;
        goto L8
    }

    private final void insertAndExecuteStrategy(String r3, iu1.b r4) {
        this.stateManager.c(r4);
        this.stateManager.h(r3);
        n r5 = this.stateManager.e(r3);
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.strategyResultMap.get(r3) != null) goto L7;
        this.strategyResultMap.put(r3, new PropertyOwner(r5));
        return;
    L7:
        PropertyOwner<n> r6 = this.strategyResultMap.get(r3);
        if (r6 == null) goto L13;
        r6.a(r5);
        return;
    }

    public void mockFeatureValue(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        Intrinsics.checkNotNullParameter(r3, "featureValue");
        this.stateManager.p(r2, r3);
    }
}
