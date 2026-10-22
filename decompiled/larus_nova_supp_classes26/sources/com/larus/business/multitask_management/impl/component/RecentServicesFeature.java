package com.larus.business.multitask_management.impl.component;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import ll9.t;
import ll9.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0)H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/business/multitask_management/impl/component/RecentServicesFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/business/multitask_management/impl/component/IRecentServicesAbility;", "<init>", "()V", "cursor", "", "hasMore", "", "recentServices", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/business/multitask_management/impl/component/QuickAccessListData;", "firstLoaded", "firstPageHasMore", "firstPageLastItemUpdateTime", "", "firstPageSize", "", "loadMorePageSize", "isLoading", "job", "Lkotlinx/coroutines/Job;", "getRecentServices", "Lkotlinx/coroutines/flow/StateFlow;", "onAttach", "", "onCreate", "loadMore", "refresh", "clearData", "requestRecentServices", "pageSize", "enablePrefetch", "scheduleRecentPrefetchIfNeeded", "increaseFoldThreshold", "current", "delta", "removeRecentAccess", "node", "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "filterFirstPageNodes", "", "nodes", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecentServicesFeature extends ComponentFeature implements d {
    public static final j r = null;
    public String h;
    public boolean i;
    public final StateFlowImpl j;
    public boolean k;
    public boolean l;
    public long m;
    public final int n;
    public final int o;
    public boolean p;
    public Job q;

    public static final class a {
    }

    static {
        int r1 = j0.a;
        r = new j(j0.d(2131899755), true, 1, SectionCardStyle.LARGE, 0, 112);
    }

    @Override // com.larus.business.multitask_management.impl.component.d
    public final void a() {
        FLogger.a.i("multitask-RecentServicesFeature", "loadMore, firstLoaded = " + this.k + ", hasMore = " + this.i);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new RecentServicesFeature$loadMore$1(this, null), 3, null);
    }

    public final void onCreate() {
        N2(this.n, true);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, d.class);
    }

    public RecentServicesFeature() {
        il9.b r0 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r0 == null) goto L5;
        v r1 = r0.U();
    L7:
        if (r1 == null) goto L12;
        List r2 = r1.a;
        if (r2 == null) goto L12;
        List r3 = CollectionsKt.filterNotNull(r2);
        if (r3 == null) goto L12;
    L13:
        if (r1 == null) goto L15;
        boolean r4 = Intrinsics.areEqual(r1.b, Boolean.TRUE);
    L16:
        this.j = j1.a(new i(r3, 8, r4));
        this.n = 8;
        this.o = z2.a.getMultiTaskManagementConfig().f();
        return;
    L15:
        r4 = false;
    L12:
        r3 = CollectionsKt.emptyList();
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.business.multitask_management.impl.component.d
    public final StateFlowImpl vl() {
        return this.j;
    }

    public static final void L2(RecentServicesFeature r6) {
        if (r6.k == true) goto L5;
        return;
    L5:
        if (r6.p == false) goto L8;
        return;
    L8:
        if (r6.i == true) goto L10;
    L12:
        int r0 = RangesKt.coerceAtLeast(((i) r6.j.getValue()).a.size() - ((i) r6.j.getValue()).b, 0);
        if (r6.i == true) goto L15;
        return;
    L15:
        if (r0 >= 20) goto L21;
        FLogger.a.i("multitask-RecentServicesFeature", "prefetch recent list, remainingBuffer = " + r0 + ", cursor = " + r6.h);
        r6.N2(r6.o, false);
        return;
    L21:
        return;
    L10:
        if (r6.h != null) goto L12;
        FLogger.a.e("multitask-RecentServicesFeature", "skip prefetch: hasMore=true but cursor is null");
    }

    @Override // com.larus.business.multitask_management.impl.component.d
    public final void J(boolean r2) {
        this.h = null;
        this.i = false;
        this.k = false;
        N2(this.n, true);
    }

    @Override // com.larus.business.multitask_management.impl.component.d
    public final void xF(t r8) {
        Intrinsics.checkNotNullParameter(r8, "node");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new RecentServicesFeature$removeRecentAccess$1(this, r8, null), 3, null);
    }

    public static final List F2(RecentServicesFeature r7, List r8) {
        r7.getClass();
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L14;
        t r1 = (t) r9.next();
        Long r2 = r1.j;
        if (r2 == null) goto L8;
        long r3 = r2.longValue();
    L10:
        if (r3 < r7.m) goto L13;
        r0.add(r1);
    L13:
        if (r0.size() < (r7.n * 2)) goto L4;
    L8:
        r3 = 0;
    L14:
        return r0;
    }

    public final void N2(int r10, boolean r11) {
        Job r0 = this.q;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.q = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new RecentServicesFeature$requestRecentServices$1(this, r11, r10, null), 3, null);
    }
}
