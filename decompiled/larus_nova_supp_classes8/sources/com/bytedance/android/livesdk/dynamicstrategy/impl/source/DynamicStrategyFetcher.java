package com.bytedance.android.livesdk.dynamicstrategy.impl.source;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.a0;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.p;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.x;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.z;
import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J,\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0017\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J&\u0010\u001b\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00100\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u0019H\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0018\u0010\u001d\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J \u0010\u001e\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010 R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010 R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/source/DynamicStrategyFetcher;", "", "", "requestScene", "", "forceFetchFull", "Lkotlin/Function0;", "", "callback", "fetchStrategy", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/z;", "data", "", "globalVersion", "updateStrategy", "", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a0;", "originList", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/p;", "incrementStrategies", "mergeStrategy", "leftList", "rightList", "checkEqualStrategy", "", "Lkotlin/Function1;", "filter", "safeRemoveIf", "updateStrategyWhenLaunch", "updateStrategyWhenMessageNotify", "updateStrategyWhenUserChanged", "UPDATE_TYPE_FULL", "I", "UPDATE_TYPE_INCREMENT", "UPDATE_TYPE_INCREMENT_WITH_CHECK", "REQUEST_SCENE_LAUNCH", "REQUEST_SCENE_MESSAGE", "REQUEST_SCENE_ENTER", "REQUEST_SCENE_USER_CHANGE", "Lio/reactivex/disposables/Disposable;", "fetchDisposable", "Lio/reactivex/disposables/Disposable;", "<init>", "()V", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicStrategyFetcher {
    public static final DynamicStrategyFetcher INSTANCE = null;
    private static final int REQUEST_SCENE_ENTER = 3;
    private static final int REQUEST_SCENE_LAUNCH = 1;
    private static final int REQUEST_SCENE_MESSAGE = 2;
    private static final int REQUEST_SCENE_USER_CHANGE = 4;
    private static final int UPDATE_TYPE_FULL = 1;
    private static final int UPDATE_TYPE_INCREMENT = 2;
    private static final int UPDATE_TYPE_INCREMENT_WITH_CHECK = 3;
    private static Disposable fetchDisposable;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public a(int r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            BaseResponse r11 = (BaseResponse) r10;
            z r0 = (z) r11.data;
            x r1 = (x) r11.extra;
            if (r1 == null) goto L5;
            String r2 = r1.a();
        L6:
            z r12 = (z) r11.data;
            if (r12 == null) goto L9;
            Integer r13 = Integer.valueOf(r12.responseType);
        L10:
            if (r0 == null) goto L28;
            if (r2 == null) goto L28;
            if (r13 != null) goto L17;
        L18:
            if (r13 != null) goto L21;
        L22:
            if (r13 != null) goto L25;
        L26:
            int r3 = k.a;
            k.i(this.a, this.b, "unknown update type " + r13, null);
            int r4 = DynamicStrategyMonitor.a;
            DynamicStrategyMonitor.e(this.a, this.b, 998, "unknown update type " + r13);
            return;
        L25:
            if (r13.intValue() != 3) goto L26;
        L27:
            int r14 = k.a;
            int r15 = this.a;
            String r5 = this.b;
            Intrinsics.checkNotNullParameter(r5, "version");
            k.g("DynamicStrategy_fetch", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action", "success"), TuplesKt.to("result_type", Integer.valueOf(r15)), TuplesKt.to("version", r5)}));
            int r16 = DynamicStrategyMonitor.a;
            int r17 = this.a;
            String r6 = this.b;
            Intrinsics.checkNotNullParameter(r6, "version");
            JSONObject r7 = new JSONObject();
            r7.put("requestScene", r17);
            r7.put("is_success", true);
            LiveMonitor.a r8 = DynamicStrategyMonitor.a(DynamicStrategyMonitor.Event.StrategyFetchAll);
            r8.b(r7);
            r8.i("requestScene", Integer.valueOf(r17));
            r8.i("version", r6);
            r8.a().report();
            DynamicStrategyFetcher.access$updateStrategy(DynamicStrategyFetcher.INSTANCE, this.a, r0, r2);
            return;
        L21:
            if (r13.intValue() == 2) goto L27;
        L17:
            if (r13.intValue() == 1) goto L27;
        L28:
            int r18 = k.a;
            k.i(this.a, this.b, "data or version is null", null);
            int r19 = DynamicStrategyMonitor.a;
            DynamicStrategyMonitor.e(this.a, this.b, 997, "data or version is null");
            return;
        L9:
            r13 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public b(int r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            ApiServerException r6 = (Throwable) r5;
            int r0 = k.a;
            int r1 = this.a;
            String r2 = this.b;
            String r3 = r6.getMessage();
            String r4 = "api error";
            if (r3 != null) goto L5;
            r3 = "api error";
        L5:
            k.i(r1, r2, r3, r6);
            int r7 = DynamicStrategyMonitor.a;
            int r8 = this.a;
            String r9 = this.b;
            if ((r6 instanceof ApiServerException) == true) goto L8;
            ApiServerException r10 = null;
        L9:
            ApiServerException r11 = r10;
            if (r11 == null) goto L12;
            int r12 = r11.getErrorCode();
        L13:
            String r13 = r6.getMessage();
            if (r13 == null) goto L17;
            r4 = r13;
        L17:
            DynamicStrategyMonitor.e(r8, r9, r12, r4);
            return;
        L12:
            r12 = 999;
            goto L13
        L8:
            r10 = r6;
            goto L9
        }
    }

    public static final class c extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public c() {
        }
    }

    private DynamicStrategyFetcher() {
    }

    static {
        INSTANCE = new DynamicStrategyFetcher();
    }

    public final void updateStrategyWhenLaunch(Function0<Unit> r3) {
        ku1.c r0 = ku1.c.a;
        if (((ku1.b) r0.getValue()).b() == true) goto L5;
        return;
    L5:
        fetchStrategy(1, ((ku1.b) r0.getValue()).c(), r3);
    }

    public final void updateStrategyWhenMessageNotify(Function0<Unit> r3) {
        if (((ku1.b) ku1.c.a.getValue()).b() == true) goto L5;
        return;
    L5:
        fetchStrategy(2, false, r3);
    }

    private final boolean checkEqualStrategy(List<? extends a0> r5, List<? extends a0> r6) {
        List<? extends a0> r7 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L3:
        String r3 = "";
        if (r8.hasNext() == false) goto L10;
        String r2 = ((a0) r8.next()).strategyName;
        if (r2 == null) goto L9;
        r3 = r2;
    L9:
        r0.add(r3);
        goto L3
    L10:
        List r9 = CollectionsKt.toMutableList(r0);
        List<? extends a0> r10 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L17;
        String r4 = ((a0) r11.next()).strategyName;
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r1.add(r4);
        goto L12
    L17:
        List r12 = CollectionsKt.toList(r1);
        if (r9.size() == r12.size()) goto L20;
        return false;
    L20:
        r9.removeAll(r12);
        if (r9.size() == 0) goto L23;
        return false;
    L23:
        return true;
    }

    private final List<a0> mergeStrategy(List<? extends a0> r5, p r6) {
        ArrayList r0 = new ArrayList();
        r0.addAll(r5);
        List<a0> r7 = r6.incrementStrategies;
        if (r7 == null) goto L8;
        Iterator<T> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        final a0 r1 = (a0) r8.next();
        INSTANCE.safeRemoveIf(r0, new DynamicStrategyFetcher$mergeStrategy$1$1(r1));
        r0.add(r1);
    L8:
        List<a0> r9 = r6.deleteStrategies;
        if (r9 == null) goto L14;
        Iterator<T> r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        final a0 r11 = (a0) r10.next();
        INSTANCE.safeRemoveIf(r0, new DynamicStrategyFetcher$mergeStrategy$2$1(r11));
    L14:
        return r0;
    }

    private final boolean safeRemoveIf(Collection<a0> r3, Function1<? super a0, Boolean> r4) {
        Iterator<a0> r5 = r3.iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L8;
        if (((Boolean) r4.invoke(r5.next())).booleanValue() == false) goto L4;
        r5.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public final void updateStrategyWhenUserChanged(Function0<Unit> r2, boolean r3) {
        if (((ku1.b) ku1.c.a.getValue()).b() == true) goto L5;
        return;
    L5:
        fetchStrategy(4, r3, r2);
    }

    private final void fetchStrategy(int r6, boolean r7, Function0<Unit> r8) {
        Disposable r9 = fetchDisposable;
        if (r9 == null) goto L5;
        r9.dispose();
    L5:
        String r10 = "";
        if (r7 == false) goto L8;
        String r11 = "";
    L9:
        DynamicStrategyApi r0 = (DynamicStrategyApi) com.bytedance.android.live.network.c.b().e(DynamicStrategyApi.class);
        if (r0 != null) goto L12;
        return;
    L12:
        String r1 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new c()).second;
        if (r1 == null) goto L16;
        r10 = r1;
    L16:
        int r2 = k.a;
        Intrinsics.checkNotNullParameter(r11, "version");
        k.g("DynamicStrategy_fetch", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("action", "start"), TuplesKt.to("request_scene", Integer.valueOf(r6)), TuplesKt.to("version", r11)}));
        fetchDisposable = r0.fetchStrategy(r6, r11, r10).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6, r11), new b(r6, r11));
        return;
    L8:
        boolean r12 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a;
        r11 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_strategy_info").j("strategy_version", "");
        goto L9
    }

    private final void updateStrategy(int r7, z r8, String r9) {
        int r0 = r8.responseType;
        boolean r1 = true;
        if (r0 != 1) goto L5;
        List<a0> r10 = r8.fullStrategies;
        com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.c.update(r9, r10);
        return;
    L5:
        if (r0 != 2) goto L7;
        p r11 = r8.incrementStrategies;
        List<a0> r2 = r11.incrementStrategies;
        if (r2 != null) goto L33;
    L34:
        List<a0> r12 = r11.deleteStrategies;
        if (r12 != null) goto L37;
    L41:
        if (Boolean.valueOf(r1).booleanValue() == true) goto L56;
        com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.c.update(r9, mergeStrategy(com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a(), r8.incrementStrategies));
        return;
    L56:
        return;
    L37:
        if (r12.size() == 0) goto L41;
    L39:
        r1 = false;
        goto L41
    L33:
        if (r2.size() != 0) goto L39;
    L7:
        if (r0 != 3) goto L58;
        boolean r3 = com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a;
        List<a0> r4 = mergeStrategy(com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.a(), r8.incrementStrategies);
        List<a0> r5 = r8.fullStrategies;
        if (checkEqualStrategy(r4, r5) == true) goto L29;
        int r6 = DynamicStrategyMonitor.a;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r4.iterator();
    L13:
        if (r14.hasNext() == false) goto L17;
        String r15 = ((a0) r14.next()).strategyName;
        if (r15 == null) goto L13;
        r13.add(r15);
        goto L13
    L17:
        List r16 = CollectionsKt.toList(r13);
        List<a0> r17 = r8.fullStrategies;
        if (r17 == null) goto L27;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L21:
        if (r19.hasNext() == false) goto L25;
        String r20 = ((a0) r19.next()).strategyName;
        if (r20 == null) goto L21;
        r18.add(r20);
        goto L21
    L25:
        List r21 = CollectionsKt.toList(r18);
        if (r21 == null) goto L27;
    L28:
        Intrinsics.checkNotNullParameter(r9, "version");
        Intrinsics.checkNotNullParameter(r16, "merge");
        Intrinsics.checkNotNullParameter(r21, "full");
        JSONObject r22 = new JSONObject();
        r22.put("requestScene", r7);
        LiveMonitor.a r23 = DynamicStrategyMonitor.a(DynamicStrategyMonitor.Event.StrategyCheckError);
        r23.b(r22);
        r23.i("requestScene", Integer.valueOf(r7));
        r23.i("version", r9);
        r23.i("mergeList", r16);
        r23.i("fullList", r21);
        r23.a().report();
    L27:
        r21 = CollectionsKt.emptyList();
    L29:
        com.bytedance.android.livesdk.dynamicstrategy.impl.source.a.c.update(r9, r5);
        return;
    }

    public static final /* synthetic */ void access$updateStrategy(DynamicStrategyFetcher r0, int r1, z r2, String r3) {
        r0.updateStrategy(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateStrategyWhenLaunch$default(DynamicStrategyFetcher r0, Function0 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.updateStrategyWhenLaunch(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateStrategyWhenMessageNotify$default(DynamicStrategyFetcher r0, Function0 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.updateStrategyWhenMessageNotify(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateStrategyWhenUserChanged$default(DynamicStrategyFetcher r0, Function0 r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.updateStrategyWhenUserChanged(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchStrategy$default(DynamicStrategyFetcher r0, int r1, boolean r2, Function0 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.fetchStrategy(r1, r2, r3);
    }
}
