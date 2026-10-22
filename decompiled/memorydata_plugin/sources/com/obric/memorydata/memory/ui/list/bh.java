package com.obric.memorydata.memory.ui.list;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.memoryentity.search.MemorySearchResultCategory;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bJ\u0014\u0010\u001e\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018J\u0014\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020\u000bJ\u0014\u0010%\u001a\u00020\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J\u0006\u0010)\u001a\u00020\u001cJ\u0016\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-J&\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00162\b\b\u0002\u0010#\u001a\u00020\u000bJ\u0006\u00101\u001a\u00020\u0016J\u000e\u00101\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000bJ \u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u00162\b\b\u0002\u0010#\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u00104J\u0006\u00105\u001a\u000206J\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020-\u0018\u000108J\b\u00109\u001a\u00020\u001cH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00180\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00180\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006;"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchResultCache;", "", "<init>", "()V", "allResults", "", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;", "pagingSource", "Lcom/obric/memorydata/memory/ui/list/SearchPagingSource;", "materializedCategories", "", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "serverCategories", "selectedCategory", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_dataSize", "", "_availableCategories", "", "availableCategories", "getAvailableCategories", "setPagingSource", "", AILabCheckPermissionTask.KEY_SOURCE, "addResults", "results", "setAvailableCategories", "categories", "selectCategory", EventBody.KEY_CATEGORY, "getSelectedCategory", "removeResults", "identifiers", "", "Lcom/obric/memorydata/memory/ui/list/EntityIdentifier;", "markComplete", "markError", "errorCode", DTraitConstant.ERROR, "", "getResults", CommonConsts.APM_INNER_EVENT_COST_START, "size", "getCurrentSize", "waitForDataAvailable", "requiredSize", "(ILcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSearchComplete", "", "getError", "Lkotlin/Pair;", "updateAvailableCategories", "SearchState", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.obric.memorydata.memory.memoryentity.search.c> f11236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SearchPagingSource f11237b;
    private final Set<MemorySearchResultCategory> c;
    private Set<MemorySearchResultCategory> d;
    private volatile MemorySearchResultCategory e;
    private final kotlinx.coroutines.flow.ae<a> f;
    private final kotlinx.coroutines.flow.ar<a> g;
    private final kotlinx.coroutines.flow.ae<Integer> h;
    private final kotlinx.coroutines.flow.ae<List<MemorySearchResultCategory>> i;
    private final kotlinx.coroutines.flow.ar<List<MemorySearchResultCategory>> j;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState;", "", "<init>", "()V", "Loading", "Error", "Complete", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState$Complete;", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState$Error;", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState$Loading;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class a {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.bh$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState$Complete;", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0594a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0594a f11238a = null;

            static {
                f11238a = new C0594a();
            }

            private C0594a() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState$Error;", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f11239a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f11240b;

            public b(int r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, "message");
                super(null);
                this.f11239a = r2;
                this.f11240b = r3;
            }

            public final int a() {
                return this.f11239a;
            }

            public final String b() {
                return this.f11240b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
                if (this.f11239a == r6.f11239a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f11240b, r6.f11240b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (Integer.hashCode(this.f11239a) * 31) + this.f11240b.hashCode();
            }

            public String toString() {
                return "Error(code=" + this.f11239a + ", message=" + this.f11240b + ')';
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState$Loading;", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache$SearchState;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f11241a = null;

            static {
                f11241a = new c();
            }

            private c() {
                super(null);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    public bh() {
        this.f11236a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.c = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.e = MemorySearchResultCategory.ALL;
        kotlinx.coroutines.flow.ae<a> r0 = kotlinx.coroutines.flow.at.a(a.c.f11241a);
        this.f = r0;
        this.g = kotlinx.coroutines.flow.k.a(r0);
        this.h = kotlinx.coroutines.flow.at.a(0);
        kotlinx.coroutines.flow.ae<List<MemorySearchResultCategory>> r1 = kotlinx.coroutines.flow.at.a(CollectionsKt.emptyList());
        this.i = r1;
        this.j = kotlinx.coroutines.flow.k.a(r1);
    }

    private static final boolean a(Set r3, com.obric.memorydata.memory.memoryentity.search.c r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "result");
        g r6 = g.f11310a.a(r4.a());     // Catch: Exception -> L8
        if (r6 == null) goto L13;
        if (r5.contains(r6) == true) goto L15;
        return false;
    L15:
        return true;
    L13:
        return false;
    L8:
        e = move-exception;
        RunLog.INSTANCE.error("SearchResultCache", "Error removing result", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final void g() {
        Set<MemorySearchResultCategory> r0 = this.d;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(MemorySearchResultCategory.Companion.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L34;
        Object r4 = r3.next();
        MemorySearchResultCategory r5 = (MemorySearchResultCategory) ZeusTransformUtils.preCheckCast(r4, MemorySearchResultCategory.class, "com.obric.memorydata.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin");
        boolean r8 = true;
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L8;
    L10:
        Iterator r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L9;
        if (r5.acceptsCategory((MemorySearchResultCategory) ZeusTransformUtils.preCheckCast(r7.next(), MemorySearchResultCategory.class, "com.obric.memorydata.plugin")) == false) goto L12;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L31;
        if (r0 == null) goto L32;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L21;
    L23:
        Iterator r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L22;
        if (r5.acceptsCategory((MemorySearchResultCategory) ZeusTransformUtils.preCheckCast(r11.next(), MemorySearchResultCategory.class, "com.obric.memorydata.plugin")) == false) goto L25;
        boolean r12 = true;
    L29:
        if (r12 == false) goto L31;
    L22:
        r12 = false;
        goto L29
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L23;
    L32:
        if (r8 == false) goto L4;
        r2.add(r4);
    L31:
        r8 = false;
    L9:
        r9 = false;
        goto L16
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
    L34:
        this.i.b((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ boolean lambda$sgEVnoof9d3f91bcooD2plTeCUU(Set r0, com.obric.memorydata.memory.memoryentity.search.c r1) {
        return a(r0, r1);
    }

    public final Object a(int r6, MemorySearchResultCategory r7, Continuation<? super Unit> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        Object r5 = kotlinx.coroutines.flow.k.c(kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.h, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.f, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new SearchResultCache$waitForDataAvailable$2(this, r7, r6, null), Function3.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new SearchResultCache$waitForDataAvailable$3(null), Function2.class, "com.obric.memorydata.plugin"), r9);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public final List<com.obric.memorydata.memory.memoryentity.search.c> a(int r6, int r7, MemorySearchResultCategory r8) {
        Intrinsics.checkNotNullParameter(r8, EventBody.KEY_CATEGORY);
        List<com.obric.memorydata.memory.memoryentity.search.c> r0 = this.f11236a;
        monitor-enter(r0);
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f11236a, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Iterator r9 = r5.iterator();     // Catch: Throwable -> L16
    L6:
        if (r9.hasNext() == false) goto L10;
        Object r2 = r9.next();     // Catch: Throwable -> L16
        if (r8.accepts((com.obric.memorydata.memory.memoryentity.search.c) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.memoryentity.search.c.class, "com.obric.memorydata.plugin")) == false) goto L6;
        r1.add(r2);     // Catch: Throwable -> L16
        goto L6
    L10:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        int r11 = Math.min(r7 + r6, r10.size());     // Catch: Throwable -> L16
        if (r6 < r10.size()) goto L13;
        List<com.obric.memorydata.memory.memoryentity.search.c> r12 = CollectionsKt.emptyList();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);
        return r12;
    L13:
        r12 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r10.subList(r6, r11), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final kotlinx.coroutines.flow.ar<List<MemorySearchResultCategory>> a() {
        return this.j;
    }

    public final void a(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, DTraitConstant.ERROR);
        this.f.b(new a.b(r2, r3));
    }

    public final void a(MemorySearchResultCategory r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_CATEGORY);
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        SearchPagingSource r1 = this.f11237b;
        if (r1 == null) goto L9;
        r1.invalidate();
        return;
    }

    public final void a(SearchPagingSource r2) {
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        this.f11237b = r2;
    }

    public final void a(List<com.obric.memorydata.memory.memoryentity.search.c> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "results");
        List<com.obric.memorydata.memory.memoryentity.search.c> r0 = this.f11236a;
        monitor-enter(r0);
        this.f11236a.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L11
    L6:
        if (r7.hasNext() == false) goto L8;
        com.obric.memorydata.memory.memoryentity.search.c r1 = (com.obric.memorydata.memory.memoryentity.search.c) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.memorydata.memory.memoryentity.search.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        this.c.add(r1.b());     // Catch: Throwable -> L11
        goto L6
    L8:
        g();     // Catch: Throwable -> L11
        this.h.b(Integer.valueOf(this.f11236a.size()));     // Catch: Throwable -> L11
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void a(Set<g> r5) {
        final Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "identifiers");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        List<com.obric.memorydata.memory.memoryentity.search.c> r0 = this.f11236a;
        monitor-enter(r0);
        CollectionsKt.removeAll(this.f11236a, new $$Lambda$bh$sgEVnoof9d3f91bcooD2plTeCUU(r6));     // Catch: Throwable -> L14
        this.h.b(Integer.valueOf(this.f11236a.size()));     // Catch: Throwable -> L14
        this.c.clear();     // Catch: Throwable -> L14
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f11236a, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L14
    L9:
        if (r7.hasNext() == false) goto L11;
        com.obric.memorydata.memory.memoryentity.search.c r1 = (com.obric.memorydata.memory.memoryentity.search.c) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.memorydata.memory.memoryentity.search.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        this.c.add(r1.b());     // Catch: Throwable -> L14
        goto L9
    L11:
        g();     // Catch: Throwable -> L14
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final int b(MemorySearchResultCategory r6) {
        Intrinsics.checkNotNullParameter(r6, EventBody.KEY_CATEGORY);
        List<com.obric.memorydata.memory.memoryentity.search.c> r0 = this.f11236a;
        monitor-enter(r0);
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.f11236a, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L7;
    L9:
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L20
    L10:
        if (r7.hasNext() == false) goto L18;
        if (r6.accepts((com.obric.memorydata.memory.memoryentity.search.c) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.memorydata.memory.memoryentity.search.c.class, "com.obric.memorydata.plugin")) == false) goto L10;
        r2 = r2 + 1;     // Catch: Throwable -> L20
        if (r2 >= 0) goto L10;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);
        return r2;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L20:
        th = move-exception;
        throw th;
    }

    public final MemorySearchResultCategory b() {
        return this.e;
    }

    public final void b(List<? extends MemorySearchResultCategory> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "categories");
        List<com.obric.memorydata.memory.memoryentity.search.c> r0 = this.f11236a;
        monitor-enter(r0);
        Set<MemorySearchResultCategory> r1 = this.d;     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L8:
        this.d = r1;     // Catch: Throwable -> L11
        g();     // Catch: Throwable -> L11
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L7:
        r1 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final void c() {
        this.f.b(a.C0594a.f11238a);
    }

    public final int d() {
        List<com.obric.memorydata.memory.memoryentity.search.c> r0 = this.f11236a;
        monitor-enter(r0);
        int r1 = this.f11236a.size();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean e() {
        return ZeusTransformUtils.instanceOf(this.f.c(), a.C0594a.class);
    }

    public final Pair<Integer, String> f() {
        a r3 = this.f.c();
        if (ZeusTransformUtils.instanceOf(r3, a.b.class) == false) goto L5;
        a.b r4 = (a.b) ZeusTransformUtils.preCheckCast(r3, a.b.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return TuplesKt.to(Integer.valueOf(r4.a()), r4.b());
    L5:
        r4 = null;
        goto L6
    }
}
