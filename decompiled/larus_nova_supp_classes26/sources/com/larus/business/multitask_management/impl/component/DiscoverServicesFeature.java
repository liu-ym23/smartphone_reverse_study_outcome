package com.larus.business.multitask_management.impl.component;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0000\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/business/multitask_management/impl/component/DiscoverServicesFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/business/multitask_management/impl/component/IDiscoverServicesAbility;", "<init>", "()V", "cursor", "", "hasMore", "", "firstLoaded", "firstPageHasMore", "discoverServices", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/business/multitask_management/impl/component/QuickAccessListData;", "discoverServicesBeforeFilter", "", "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "firstPageSize", "", "loadMorePageSize", "isLoading", "job", "Lkotlinx/coroutines/Job;", "getDiscoverServices", "Lkotlinx/coroutines/flow/StateFlow;", "onAttach", "", "onCreate", "loadMore", "refresh", "clearData", "requestDiscoverServices", "pageSize", "enablePrefetch", "scheduleDiscoverPrefetchIfNeeded", "increaseFoldThreshold", "current", "delta", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiscoverServicesFeature extends ComponentFeature implements com.larus.business.multitask_management.impl.component.a {
    public static final j r = null;
    public String h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final StateFlowImpl l;
    public List<t> m;
    public final int n;
    public final int o;
    public boolean p;
    public Job q;

    public static final class a {
    }

    static {
        int r1 = j0.a;
        r = new j(j0.d(2131899753), true, 2, SectionCardStyle.SMALL, 0, 112);
    }

    @Override // com.larus.business.multitask_management.impl.component.a
    public final void a() {
        FLogger.a.i("multitask-DiscoverServicesFeature", "loadMore, firstLoaded = " + this.j + ", hasMore = " + this.i);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DiscoverServicesFeature$loadMore$1(this, null), 3, null);
    }

    public final void onCreate() {
        L2(this.n, true);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.business.multitask_management.impl.component.a.class);
    }

    public DiscoverServicesFeature() {
        il9.b r0 = (il9.b) ServiceManager.get().getService(il9.b.class);
        if (r0 == null) goto L5;
        v r1 = r0.M2();
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
        StateFlowImpl r5 = j1.a(new i(r3, 50, r4));
        this.l = r5;
        this.m = CollectionsKt.toList(((i) r5.getValue()).a);
        this.n = 50;
        this.o = z2.a.getMultiTaskManagementConfig().a();
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

    @Override // com.larus.business.multitask_management.impl.component.a
    public final StateFlowImpl Ng() {
        return this.l;
    }

    public static final void F2(DiscoverServicesFeature r6) {
        if (r6.j == true) goto L5;
        return;
    L5:
        if (r6.p == false) goto L8;
        return;
    L8:
        if (r6.i == true) goto L10;
    L12:
        int r0 = RangesKt.coerceAtLeast(((i) r6.l.getValue()).a.size() - ((i) r6.l.getValue()).b, 0);
        if (r6.i == true) goto L15;
        return;
    L15:
        if (r0 >= 50) goto L21;
        FLogger.a.i("multitask-DiscoverServicesFeature", "prefetch recent list, remainingBuffer = " + r0 + ", cursor = " + r6.h);
        r6.L2(r6.o, false);
        return;
    L21:
        return;
    L10:
        if (r6.h != null) goto L12;
        FLogger.a.e("multitask-DiscoverServicesFeature", "skip prefetch: hasMore=true but cursor is null");
    }

    @Override // com.larus.business.multitask_management.impl.component.a
    public final void J(boolean r2) {
        this.h = null;
        this.i = false;
        this.j = false;
        L2(this.n, true);
    }

    public final void L2(int r10, boolean r11) {
        if (this.p == false) goto L6;
        FLogger.a.i("multitask-DiscoverServicesFeature", "requestDiscoverServices isLoading, skip");
        return;
    L6:
        Job r0 = this.q;
        if (r0 == null) goto L9;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L9:
        this.q = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DiscoverServicesFeature$requestDiscoverServices$1(this, r11, r10, null), 3, null);
    }
}
