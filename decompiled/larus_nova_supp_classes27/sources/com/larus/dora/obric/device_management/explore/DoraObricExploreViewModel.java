package com.larus.dora.obric.device_management.explore;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.n1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u001c0\u001a0\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0002J0\u0010#\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0017H\u0002J \u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0017*\b\u0012\u0004\u0012\u00020(0\u00172\u0006\u0010$\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricExploreViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "pendingCount", "", "loadedSections", "", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreSection;", "completedRequests", "", "load", "", "buildDeviceRequests", "", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreDeviceRequest;", "toDeviceRequests", "Lkotlin/Pair;", "Lcom/bytedance/dora/annotation/ProductNameType;", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "fetchDeviceSection", "request", "parseFeatureSet", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreFunctionSet;", "pageNode", "Lcom/larus/dora/impl/dynamic/dsl/DslNode;", "completeRequest", "simpleDevice", "configuredTitle", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "items", "Lcom/larus/dora/obric/device_management/explore/DoraObricExploreItem;", "filterByDevice", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricExploreViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DoraObricExploreViewModel";
    private final kotlinx.coroutines.flow.z0<p> _state;
    private final Set<Integer> completedRequests;
    private final com.larus.dora.impl.dynamic.loader.d dataLoader;
    private final Map<Integer, o> loadedSections;
    private int pendingCount;
    private final i1<p> state;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.larus.dora.impl.dynamic.loader.d.b {
        public final /* synthetic */ DoraObricExploreViewModel a;
        public final /* synthetic */ g b;
        public final /* synthetic */ z49.b c;

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void a() {
            g49.d.d(DoraObricExploreViewModel.TAG, "onInvalid productType=" + this.b.b + ", pageKey=obric_explore");
            DoraObricExploreViewModel.access$completeRequest(this.a, this.b, this.c, null, CollectionsKt.emptyList());
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void b(c59.z r7) {
            Intrinsics.checkNotNullParameter(r7, "pageNode");
            m r8 = DoraObricExploreViewModel.access$parseFeatureSet(this.a, r7);
            DoraObricExploreViewModel r0 = this.a;
            g r1 = this.b;
            z49.b r2 = this.c;
            List<n> r3 = null;
            if (r8 == null) goto L5;
            c59.t r4 = r8.b();
        L6:
            DoraObricExploreViewModel r5 = this.a;
            if (r8 == null) goto L9;
            r3 = r8.a();
        L9:
            if (r3 != null) goto L11;
            r3 = CollectionsKt.emptyList();
        L11:
            DoraObricExploreViewModel.access$completeRequest(r0, r1, r2, r4, DoraObricExploreViewModel.access$filterByDevice(r5, CollectionsKt.filterNotNull(r3), this.c));
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void onFail(String r5) {
            g49.d.b(DoraObricExploreViewModel.TAG, "onFail productType=" + this.b.b + ", pageKey=obric_explore, error=" + r5);
            DoraObricExploreViewModel.access$completeRequest(this.a, this.b, this.c, null, CollectionsKt.emptyList());
        }

        public b(DoraObricExploreViewModel r1, g r2, z49.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.explore.DoraObricExploreViewModel$completeRequest$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricExploreViewModel$completeRequest$1", f = "DoraObricExploreViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ c59.t $configuredTitle;
        final /* synthetic */ List<n> $items;
        final /* synthetic */ g $request;
        final /* synthetic */ z49.b $simpleDevice;
        int label;
        final /* synthetic */ DoraObricExploreViewModel this$0;

        public AnonymousClass1(DoraObricExploreViewModel r1, g r2, List<n> r3, c59.t r4, z49.b r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$request = r2;
            this.$items = r3;
            this.$configuredTitle = r4;
            this.$simpleDevice = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$request, this.$items, this.$configuredTitle, this.$simpleDevice, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r10);
            boolean r11 = DoraObricExploreViewModel.access$getCompletedRequests$p(this.this$0).add(Boxing.boxInt(this.$request.a));
            if ((!this.$items.isEmpty()) == false) goto L15;
            Map r0 = DoraObricExploreViewModel.access$getLoadedSections$p(this.this$0);
            Integer r1 = Boxing.boxInt(this.$request.a);
            ProductNameType r4 = this.$request.b;
            c59.t r5 = this.$configuredTitle;
            int r2 = com.larus.dora.impl.util.o.a;
            String r3 = com.larus.dora.impl.util.o.b(this.$simpleDevice.c(), this.$simpleDevice.e());
            g r6 = this.$request;
            if (StringsKt.isBlank(r3) == false) goto L14;
            ProductNameType r7 = r6.b;
            if (r7 == null) goto L11;
            r3 = r7.name;
        L12:
            if (r3 != null) goto L14;
            r3 = "";
            goto L14
        L11:
            r3 = null;
        L14:
            r0.put(r1, new o(r4, r5, r3, this.$simpleDevice, this.$items));
        L15:
            if (r11 == false) goto L18;
            DoraObricExploreViewModel r12 = this.this$0;
            DoraObricExploreViewModel.access$setPendingCount$p(r12, DoraObricExploreViewModel.access$getPendingCount$p(r12) - 1);
        L18:
            if (DoraObricExploreViewModel.access$getPendingCount$p(this.this$0) > 0) goto L21;
            DoraObricExploreViewModel.access$get_state$p(this.this$0).setValue(new p(false, CollectionsKt.toList(MapsKt.toSortedMap(DoraObricExploreViewModel.access$getLoadedSections$p(this.this$0)).values())));
        L21:
            return Unit.INSTANCE;
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public final void load() {
        this.loadedSections.clear();
        this.completedRequests.clear();
        this._state.setValue(new p(true, 2));
        List<g> r0 = buildDeviceRequests();
        if (r0.isEmpty() == false) goto L6;
        this._state.setValue(new p(false, 2));
        return;
    L6:
        this.pendingCount = r0.size();
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        fetchDeviceSection((g) r1.next());
        goto L8
    }

    public DoraObricExploreViewModel() {
        this.dataLoader = new com.larus.dora.impl.dynamic.loader.d();
        StateFlowImpl r0 = j1.a(new p(false, 3));
        this._state = r0;
        this.state = r0;
        this.loadedSections = new LinkedHashMap();
        this.completedRequests = new LinkedHashSet();
    }

    private final List<g> buildDeviceRequests() {
        List r0 = DoraAdapterExtKt.k(kj4.a.g());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        DoraDevice r3 = (DoraDevice) r2.next();
        r1.add(TuplesKt.to(ProductNameType.getProduct(r3.productId), n1.b(r3)));
        goto L4
    L7:
        return toDeviceRequests(r1);
    }

    public final i1<p> getState() {
        return this.state;
    }

    public static final /* synthetic */ Set access$getCompletedRequests$p(DoraObricExploreViewModel r0) {
        return r0.completedRequests;
    }

    public static final /* synthetic */ Map access$getLoadedSections$p(DoraObricExploreViewModel r0) {
        return r0.loadedSections;
    }

    public static final /* synthetic */ int access$getPendingCount$p(DoraObricExploreViewModel r0) {
        return r0.pendingCount;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.z0 access$get_state$p(DoraObricExploreViewModel r0) {
        return r0._state;
    }

    private final void fetchDeviceSection(g r13) {
        z49.b r0 = r13.c;
        DoraDevice r1 = r0.a;
        if (r1 == null) goto L5;
        int r2 = r1.vendorId;
    L6:
        int r3 = n1.d(r0);
        g49.d.d(TAG, "fetchDeviceSection productType=" + r13.b + ", vendorId=" + r2 + ", productId=" + r3 + ", model=" + r0.d() + ", mac=" + r0.c());
        com.larus.dora.impl.dynamic.loader.d.b(this.dataLoader, ViewModelKt.getViewModelScope(this), Integer.valueOf(r2), Integer.valueOf(r3), r0.d(), "obric_explore", new b(this, r13, r0));
        return;
    L5:
        r2 = -1;
        goto L6
    }

    private final m parseFeatureSet(c59.z r2) {
        c59.c0 r3 = c59.a0.d(r2);
        Lazy r0 = c59.s.a;
        c59.i r4 = r3.a;
        if (r4 == null) goto L5;
        Map<String, Object> r5 = r4.b;
    L7:
        return (m) c59.s.c(r5, m.class);
    L5:
        r5 = null;
        goto L7
    }

    private final List<g> toDeviceRequests(List<? extends Pair<? extends ProductNameType, z49.b>> r7) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r2 = r8.next();
        if (o59.a.o(((z49.b) ((Pair) r2).component2()).f()) == true) goto L7;
        r1.add(r2);
        goto L4
    L7:
        r0.add(r2);
        goto L4
    L9:
        Pair r9 = new Pair(r0, r1);
        List r3 = (List) r9.component1();
        List r10 = CollectionsKt.plus(r3, (List) r9.component2());
        HashSet r4 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L15;
        Object r6 = r11.next();
        if (r4.add(((z49.b) ((Pair) r6).component2()).f()) == false) goto L11;
        r5.add(r6);
        goto L11
    L15:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r13 = r5.iterator();
        int r14 = 0;
    L17:
        if (r13.hasNext() == false) goto L22;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        Pair r17 = (Pair) r15;
        r12.add(new g(r14, (ProductNameType) r17.component1(), (z49.b) r17.component2()));
        r14 = r16;
        goto L17
    L22:
        return r12;
    }

    public static final /* synthetic */ m access$parseFeatureSet(DoraObricExploreViewModel r0, c59.z r1) {
        return r0.parseFeatureSet(r1);
    }

    public static final /* synthetic */ void access$setPendingCount$p(DoraObricExploreViewModel r0, int r1) {
        r0.pendingCount = r1;
    }

    private final List<n> filterByDevice(List<n> r8, z49.b r9) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r1 = r10.next();
        if (c59.p.c(((n) r1).b(), r9.h(), r9.f(), r9.c(), r9.b()) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public static final /* synthetic */ List access$filterByDevice(DoraObricExploreViewModel r0, List r1, z49.b r2) {
        return r0.filterByDevice(r1, r2);
    }

    private final void completeRequest(g r12, z49.b r13, c59.t r14, List<n> r15) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r12, r15, r14, r13, null), 3, null);
    }

    public static final /* synthetic */ void access$completeRequest(DoraObricExploreViewModel r0, g r1, z49.b r2, c59.t r3, List r4) {
        r0.completeRequest(r1, r2, r3, r4);
    }
}
