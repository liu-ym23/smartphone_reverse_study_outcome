package com.obric.memorydata.memory.ui.list;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import androidx.paging.PagingSource;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.ig;
import com.obric.memorydata.memory.memoryentity.search.MemorySearchResultCategory;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ss.bduploader.UploadKeys;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u000fJ\u0006\u0010,\u001a\u00020\u001fJ\u001a\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u0010'\u001a\u00020(H\u0002J\u001c\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000200020!2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u00103\u001a\u00020\u001fJ\u0014\u00104\u001a\u00020\u001f2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u00106\u001a\u00020\u001f2\f\u00107\u001a\b\u0012\u0004\u0012\u00020.0\u0011J\u0014\u00108\u001a\u00020\u001f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0011J\u000e\u00108\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020:R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00110\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00180\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010%¨\u0006>"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "currentCache", "Lcom/obric/memorydata/memory/ui/list/SearchResultCache;", "availableCategoriesJob", "Lkotlinx/coroutines/Job;", "_searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/list/SearchViewModel$SearchRequest;", "_deletedIdentifiers", "", "Lcom/obric/memorydata/memory/ui/list/EntityIdentifier;", "_selectedCategory", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "_availableCategories", "", "availableCategories", "Lkotlinx/coroutines/flow/StateFlow;", "getAvailableCategories", "()Lkotlinx/coroutines/flow/StateFlow;", "_loadingFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Pair;", "", "loadingFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getLoadingFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_refreshTrigger", "", "searchResults", "Lkotlinx/coroutines/flow/Flow;", "Lcom/obric/memorydata/memory/ui/list/SearchResultWithVersion;", "getSearchResults$annotations", "getSearchResults", "()Lkotlinx/coroutines/flow/Flow;", "updateQuery", ChatMessage.TYPE_QUERY, "", "version", "selectCategory", EventBody.KEY_CATEGORY, "triggerRefreshStart", "convertToMemoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "result", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;", "searchInternal", "Landroidx/paging/PagingData;", "clearSearch", "removeFromCache", "identifiers", "removeMemoryItems", "items", "removeByMetaInfo", "metaInfoList", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "metaInfo", "Companion", "SearchRequest", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "SearchViewModel";
    private final kotlinx.coroutines.flow.ae<List<MemorySearchResultCategory>> _availableCategories;
    private final kotlinx.coroutines.flow.ae<Set<g>> _deletedIdentifiers;
    private final kotlinx.coroutines.flow.ad<Pair<Long, Long>> _loadingFlow;
    private final kotlinx.coroutines.flow.ad<Unit> _refreshTrigger;
    private final kotlinx.coroutines.flow.ae<b> _searchQuery;
    private final kotlinx.coroutines.flow.ae<MemorySearchResultCategory> _selectedCategory;
    private final kotlinx.coroutines.flow.ar<List<MemorySearchResultCategory>> availableCategories;
    private bx availableCategoriesJob;
    private bh currentCache;
    private final kotlinx.coroutines.flow.ai<Pair<Long, Long>> loadingFlow;
    private final kotlinx.coroutines.flow.i<bj> searchResults;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchViewModel$SearchRequest;", "", ChatMessage.TYPE_QUERY, "", "version", "", "<init>", "(Ljava/lang/String;J)V", "getQuery", "()Ljava/lang/String;", "getVersion", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11160b;

        public b(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
            this.f11159a = r2;
            this.f11160b = r3;
        }

        public final String a() {
            return this.f11159a;
        }

        public final long b() {
            return this.f11160b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, b.class) == true) goto L8;
            return false;
        L8:
            b r8 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11159a, r8.f11159a) == true) goto L12;
            return false;
        L12:
            if (this.f11160b == r8.f11160b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11159a.hashCode() * 31) + Long.hashCode(this.f11160b);
        }

        public String toString() {
            return "SearchRequest(query=" + this.f11159a + ", version=" + this.f11160b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<bj> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f11161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f11162b;
        final /* synthetic */ SearchViewModel c;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.SearchViewModel$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f11163a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f11164b;
            final /* synthetic */ SearchViewModel c;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, b r4, SearchViewModel r5) {
                this.f11163a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f11164b = r4;
                this.c = r5;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r10, Continuation r11) {
                Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r12, SearchViewModel$searchResults$lambda$2$$inlined$map$1$2$1.class) == false) goto L7;
                SearchViewModel$searchResults$lambda$2$$inlined$map$1$2$1 r0 = (SearchViewModel$searchResults$lambda$2$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r12, SearchViewModel$searchResults$lambda$2$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r13 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r13);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r13);
                kotlinx.coroutines.flow.j r14 = this.f11163a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Pair r15 = (Pair) ZeusTransformUtils.preCheckCast(r10, Pair.class, "com.obric.memorydata.plugin");
                bj r1 = new bj(this.f11164b.b(), (MemorySearchResultCategory) ZeusTransformUtils.preCheckCast(r15.component1(), MemorySearchResultCategory.class, "com.obric.memorydata.plugin"), PagingDataTransforms.flatMap((PagingData) ZeusTransformUtils.preCheckCast(r15.component2(), PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new SearchViewModel$searchResults$4$4$convertedData$1(this.c, this.f11164b, null), Function2.class, "com.obric.memorydata.plugin")));
                r0.label = 1;
                if (r14.emit(r1, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new SearchViewModel$searchResults$lambda$2$$inlined$map$1$2$1(this, r12);
                goto L8
            }
        }

        public c(kotlinx.coroutines.flow.i r3, b r4, SearchViewModel r5) {
            this.f11161a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f11162b = r4;
            this.c = r5;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super bj> r5, Continuation r6) {
            kotlinx.coroutines.flow.j r7 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            Object r4 = this.f11161a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, this.f11162b, this.c), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r8);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements kotlinx.coroutines.flow.i<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f11165a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.SearchViewModel$d$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f11166a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f11166a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, SearchViewModel$special$$inlined$filter$1$2$1.class) == false) goto L7;
                SearchViewModel$special$$inlined$filter$1$2$1 r0 = (SearchViewModel$special$$inlined$filter$1$2$1) ZeusTransformUtils.preCheckCast(r8, SearchViewModel$special$$inlined$filter$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L23:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f11166a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                if (((CharSequence) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
                boolean r11 = true;
            L18:
                if (r11 == false) goto L23;
                r0.label = 1;
                if (r5.emit(r6, r0) != r2) goto L23;
                return r2;
            L17:
                r11 = false;
            L7:
                r0 = new SearchViewModel$special$$inlined$filter$1$2$1(this, r8);
                goto L8
            }
        }

        public d(kotlinx.coroutines.flow.i r3) {
            this.f11165a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super b> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f11165a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.SearchViewModel$searchInternal$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchViewModel$searchInternal$1", f = "MemorySearchResultCache.kt", i = {}, l = {UploadKeys.KeyIsSkipMeta}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ bh $cache;
        int label;
        final /* synthetic */ SearchViewModel this$0;

        AnonymousClass1(bh r3, SearchViewModel r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$cache = r3;
            this.this$0 = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$cache, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<List<MemorySearchResultCategory>> r7 = this.$cache.a();
            final SearchViewModel r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super List<MemorySearchResultCategory>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05931(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.SearchViewModel$triggerRefreshStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.SearchViewModel$triggerRefreshStart$1", f = "MemorySearchResultCache.kt", i = {}, l = {383}, m = "invokeSuspend", n = {}, s = {})
    static final class C11921 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SearchViewModel this$0;

        C11921(SearchViewModel r3, Continuation<? super C11921> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11921(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11921) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11921.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            b r12 = (b) ZeusTransformUtils.preCheckCast(SearchViewModel.access$get_searchQuery$p(this.this$0).c(), b.class, "com.obric.memorydata.plugin");
            if (r12 == null) goto L14;
            SearchViewModel r2 = this.this$0;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), SearchViewModel.TAG, "triggerRefreshStart for version=" + r12.b(), false, 4, null);
            kotlinx.coroutines.flow.ad r13 = SearchViewModel.access$get_refreshTrigger$p(r2);
            Unit r3 = Unit.INSTANCE;
            this.label = 1;
            if (r13.emit(r3, this) != r0) goto L14;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public SearchViewModel() {
        kotlinx.coroutines.flow.ae<b> r1 = kotlinx.coroutines.flow.at.a(null);
        this._searchQuery = r1;
        this._deletedIdentifiers = kotlinx.coroutines.flow.at.a(SetsKt.emptySet());
        this._selectedCategory = kotlinx.coroutines.flow.at.a(MemorySearchResultCategory.ALL);
        kotlinx.coroutines.flow.ae<List<MemorySearchResultCategory>> r2 = kotlinx.coroutines.flow.at.a(CollectionsKt.emptyList());
        this._availableCategories = r2;
        this.availableCategories = kotlinx.coroutines.flow.k.a(r2);
        kotlinx.coroutines.flow.ad<Pair<Long, Long>> r3 = kotlinx.coroutines.flow.ak.a(0, 1, null, 4, null);
        this._loadingFlow = r3;
        this.loadingFlow = kotlinx.coroutines.flow.k.a(r3);
        kotlinx.coroutines.flow.ad<Unit> r4 = kotlinx.coroutines.flow.ak.a(0, 0, null, 6, null);
        this._refreshTrigger = r4;
        this.searchResults = kotlinx.coroutines.flow.k.c(kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new d(kotlinx.coroutines.flow.k.a(kotlinx.coroutines.flow.k.c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), 300)), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new SearchViewModel$searchResults$2(null), Function2.class, "com.obric.memorydata.plugin")), (Function3) ZeusTransformUtils.preCheckCast(new SearchViewModel$searchResults$3(null), Function3.class, "com.obric.memorydata.plugin")), (Function3) ZeusTransformUtils.preCheckCast(new SearchViewModel$special$$inlined$flatMapLatest$1(null, this), Function3.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.data.a access$convertToMemoryItem(SearchViewModel r0, com.obric.memorydata.memory.memoryentity.search.c r1, String r2) {
        return r0.convertToMemoryItem(r1, r2);
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_availableCategories$p(SearchViewModel r0) {
        return r0._availableCategories;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_deletedIdentifiers$p(SearchViewModel r0) {
        return r0._deletedIdentifiers;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ad access$get_loadingFlow$p(SearchViewModel r0) {
        return r0._loadingFlow;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ad access$get_refreshTrigger$p(SearchViewModel r0) {
        return r0._refreshTrigger;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_searchQuery$p(SearchViewModel r0) {
        return r0._searchQuery;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_selectedCategory$p(SearchViewModel r0) {
        return r0._selectedCategory;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.i access$searchInternal(SearchViewModel r0, String r1) {
        return r0.searchInternal(r1);
    }

    private final com.obric.memorydata.memory.ui.data.a convertToMemoryItem(com.obric.memorydata.memory.memoryentity.search.c r10, String r11) {
        List r4 = CollectionsKt.listOf(r11);
        com.obric.memorydata.database.entity.d r9 = r10.a();
        com.obric.memorydata.memory.ui.data.a.h r12 = null;
        if (ZeusTransformUtils.instanceOf(r9, RawMemoryEntity.class) == false) goto L9;
        MemoryEntity r1 = com.obric.memorydata.database.entity.memoryindex.m.a().toMemoryEntity((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L7;
        r12 = new com.obric.memorydata.memory.ui.data.a.h(r1, false, false, r4, null, 16, null);
    L7:
        Object r13 = ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
    L26:
        return (com.obric.memorydata.memory.ui.data.a) r13;
    L9:
        if (ZeusTransformUtils.instanceOf(r9, ig.class) == false) goto L16;
        RawMemoryEntity r14 = new ig(((ig) ZeusTransformUtils.preCheckCast(r9, ig.class, "com.obric.memorydata.plugin")).a(), ((ig) ZeusTransformUtils.preCheckCast(r9, ig.class, "com.obric.memorydata.plugin")).b()).c();
        if (r14 == null) goto L7;
        MemoryEntity r2 = com.obric.memorydata.database.entity.memoryindex.m.a().toMemoryEntity(r14);
        if (r2 == null) goto L7;
        r12 = new com.obric.memorydata.memory.ui.data.a.h(r2, false, false, r4, null, 16, null);
        goto L7
    L16:
        if (ZeusTransformUtils.instanceOf(r9, EpisodicMemoryEntity.class) == false) goto L21;
        Object r15 = new com.obric.memorydata.memory.ui.data.a.i((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r9, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"), r4);
    L18:
        r13 = ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        goto L26
    L21:
        if (ZeusTransformUtils.instanceOf(r9, fj.class) == false) goto L24;
        r15 = new com.obric.memorydata.memory.ui.data.a.C0539a((fj) ZeusTransformUtils.preCheckCast(r9, fj.class, "com.obric.memorydata.plugin"), false, r4);
        goto L18
    L24:
        if (ZeusTransformUtils.instanceOf(r9, AutoMemoryProEntity.class) == false) goto L27;
        r15 = new com.obric.memorydata.memory.ui.data.a.b((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r9, AutoMemoryProEntity.class, "com.obric.memorydata.plugin"), r4);
        goto L18
    L27:
        return null;
    }

    public static /* synthetic */ void getSearchResults$annotations() {
    }

    public static /* synthetic */ PagingSource lambda$xbBTb6prGAOLmiPi8_MmT3QLU6U(bh r0) {
        return searchInternal$lambda$6(r0);
    }

    private final kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.memoryentity.search.c>> searchInternal(String r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "searchInternal: query is " + com.obric.memorydata.utils.q.f13259a.b(r11), false, 4, null);
        final bh r0 = new bh();
        this.currentCache = r0;
        bx r1 = this.availableCategoriesJob;
        if (r1 == null) goto L5;
        bx.a.a(r1, null, 1, null);
    L5:
        this.availableCategoriesJob = kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r0, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        com.obric.memorydata.memory.memoryentity.search.b.f10326a.a(r11, (com.obric.memorydata.memory.memoryentity.search.a) ZeusTransformUtils.preCheckCast(new bg(r0), com.obric.memorydata.memory.memoryentity.search.a.class, "com.obric.memorydata.plugin"));
        return new Pager(new PagingConfig(20, 20, false, 20, 0, 0, 52, null), null, new $$Lambda$SearchViewModel$xbBTb6prGAOLmiPi8_MmT3QLU6U(r0), 2, null).getFlow();
    }

    private static final PagingSource searchInternal$lambda$6(bh r2) {
        return (PagingSource) ZeusTransformUtils.preCheckCast(new SearchPagingSource(r2), PagingSource.class, "com.obric.memorydata.plugin");
    }

    public final void clearSearch() {
        this._searchQuery.b(null);
        this._deletedIdentifiers.b(SetsKt.emptySet());
    }

    public final kotlinx.coroutines.flow.ar<List<MemorySearchResultCategory>> getAvailableCategories() {
        return this.availableCategories;
    }

    public final kotlinx.coroutines.flow.ai<Pair<Long, Long>> getLoadingFlow() {
        return this.loadingFlow;
    }

    public final kotlinx.coroutines.flow.i<bj> getSearchResults() {
        return this.searchResults;
    }

    public final void removeByMetaInfo(cu r2) {
        Intrinsics.checkNotNullParameter(r2, "metaInfo");
        removeFromCache(SetsKt.setOf(g.f11310a.a(r2)));
    }

    public final void removeByMetaInfo(List<cu> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "metaInfoList");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        cu r2 = (cu) ZeusTransformUtils.preCheckCast(r8.next(), cu.class, "com.obric.memorydata.plugin");
        r0.add(g.f11310a.a(r2));
        goto L4
    L6:
        removeFromCache(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
    }

    public final void removeFromCache(Set<g> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "identifiers");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r10.next(), g.class, "com.obric.memorydata.plugin");
        if (r2.getType() != (-401)) goto L8;
        r2 = g.a(r2, NetError.ERR_INVALID_REDIRECT, null, 2, null);
    L8:
        r0.add(r2);
        goto L4
    L9:
        Set<g> r11 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.flow.ae<Set<g>> r1 = this._deletedIdentifiers;
        r1.b(SetsKt.plus((Set) ZeusTransformUtils.preCheckCast(r1.c(), Set.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")));
        bh r6 = this.currentCache;
        if (r6 == null) goto L16;
        r6.a(r11);
        return;
    }

    public final void removeMemoryItems(List<? extends com.obric.memorydata.memory.ui.data.a> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "items");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L21;
        com.obric.memorydata.memory.ui.data.a r2 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L10;
        g.a r3 = g.f11310a;
        Object r4 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b();
    L8:
        g r5 = r3.a(r4);
    L19:
        if (r5 == null) goto L4;
        r0.add(r5);
        goto L4
    L10:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L13;
        r3 = g.f11310a;
        r4 = ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b();
        goto L8
    L13:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L16;
        r3 = g.f11310a;
        r4 = ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b();
        goto L8
    L16:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L18;
        r3 = g.f11310a;
        r4 = ((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b();
        goto L8
    L18:
        r5 = null;
        goto L19
    L21:
        removeFromCache(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
    }

    public final void selectCategory(MemorySearchResultCategory r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_CATEGORY);
        bh r0 = this.currentCache;
        if (r0 == null) goto L5;
        r0.a(r2);
    L5:
        this._selectedCategory.b(r2);
    }

    public final void triggerRefreshStart() {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11921(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void updateQuery(String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, ChatMessage.TYPE_QUERY);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "updateQuery: query=" + com.obric.memorydata.utils.q.f13259a.b(r8) + ", version=" + r9, false, 4, null);
        this._searchQuery.b(new b(r8, r9));
    }
}
