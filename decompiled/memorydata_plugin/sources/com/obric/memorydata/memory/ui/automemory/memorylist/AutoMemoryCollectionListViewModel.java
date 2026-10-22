package com.obric.memorydata.memory.ui.automemory.memorylist;

import android.content.Context;
import android.util.EventsUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.entity.y;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.ck;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010\u001d\u001a\u00020\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001fJ\u0017\u0010 \u001a\u00020\u00162\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0016J\u0017\u0010$\u001a\u00020\u00162\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\"J\u001e\u0010&\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0(2\b\b\u0002\u0010)\u001a\u00020\u001cJ,\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0(2\u0006\u0010.\u001a\u00020\u001cH\u0002J\u0006\u0010/\u001a\u00020\u0016J\u0006\u00100\u001a\u00020\u0016J\u0006\u00101\u001a\u00020\u001cJ\u000e\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u000eJ\u0006\u00104\u001a\u00020\u0016J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010\u0017\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u00106J\u0016\u00107\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u00106J\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002090+2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u0018\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006A"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "ruleId", "", "getRuleId", "()J", "setRuleId", "(J)V", "exportingAutoMemoryId", "Ljava/lang/Long;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "collectionId", "title", "refresh", "updateCollectionPausedState", "isPaused", "", "deleteCollection", "onDeleted", "Lkotlin/Function0;", "enterSelectionMode", "initialSelectedId", "(Ljava/lang/Long;)V", "exitSelectionMode", "toggleSelection", "selectedId", "deleteItems", "idSet", "", "deleteAll", "deleteItemsFromDb", "", "Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "currentRuleId", "isDeleteAll", "selectAll", "selectNone", "isBuildPackageExporting", "markBuildPackageExportStarted", "autoMemoryId", "markBuildPackageExportFinished", "queryAutoMemoryByCollectionId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markCollectionRead", "buildUiItems", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListGroup;", "items", "formatDateTitle", "date", "Ljava/time/LocalDate;", "zoneId", "Ljava/time/ZoneId;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryCollectionListViewModel extends ViewModel {
    private static final a Companion = null;
    private static final DateTimeFormatter DAY_HEADER_DATE_FORMAT = null;
    private final String TAG;
    private final ae<d> _state;
    private volatile Long exportingAutoMemoryId;
    private long ruleId;
    private final ar<d> state;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionListViewModel$Companion;", "", "<init>", "()V", "DAY_HEADER_DATE_FORMAT", "Ljava/time/format/DateTimeFormatter;", "getDAY_HEADER_DATE_FORMAT", "()Ljava/time/format/DateTimeFormatter;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast((LocalDate) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), LocalDate.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast((LocalDate) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), LocalDate.class, "com.obric.memorydata.plugin"), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((y) ZeusTransformUtils.preCheckCast(r5, y.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((y) ZeusTransformUtils.preCheckCast(r4, y.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$deleteCollection$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$deleteCollection$1", f = "AutoMemoryCollectionListViewModel.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $currentRuleId;
        final /* synthetic */ Function0<Unit> $onDeleted;
        int label;
        final /* synthetic */ AutoMemoryCollectionListViewModel this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$deleteCollection$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$deleteCollection$1$1", f = "AutoMemoryCollectionListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05341 extends SuspendLambda implements Function2<al, Continuation<? super Integer>, Object> {
            final /* synthetic */ long $currentRuleId;
            int label;

            C05341(long r3, Continuation<? super C05341> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.$currentRuleId = r3;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C05341(this.$currentRuleId, r6), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Integer> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Integer> r4) {
                return ((C05341) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05341.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().deleteById(this.$currentRuleId);
                com.obric.memorydata.memory.ui.automemory.requirement.b.f10717a.b(this.$currentRuleId);
                return Boxing.boxInt(com.obric.memorydata.memory.b.b.f10079a.a(this.$currentRuleId));
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(AutoMemoryCollectionListViewModel r3, Function0<Unit> r4, long r5, Continuation<? super AnonymousClass1> r7) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$onDeleted = r6;
            this.$currentRuleId = r5;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$onDeleted, this.$currentRuleId, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L11:
            ae r14 = AutoMemoryCollectionListViewModel.access$get_state$p(this.this$0);
        L12:
            Object r2 = r14.c();
            if (r14.a(r2, d.a((d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin"), null, null, CollectionsKt.emptyList(), false, SetsKt.emptySet(), 1, null)) == false) goto L12;
            this.$onDeleted.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            CoroutineContext r15 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new C05341(this.$currentRuleId, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.i.a(r15, r3, r4) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$deleteItems$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$deleteItems$1", f = "AutoMemoryCollectionListViewModel.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
    static final class C11291 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $currentRuleId;
        final /* synthetic */ Set<Long> $idSet;
        final /* synthetic */ boolean $isDeleteAll;
        int label;
        final /* synthetic */ AutoMemoryCollectionListViewModel this$0;

        C11291(AutoMemoryCollectionListViewModel r3, long r4, Set<Long> r6, boolean r7, Continuation<? super C11291> r8) {
            Set<Long> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$currentRuleId = r4;
            this.$idSet = r9;
            this.$isDeleteAll = r7;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11291(this.this$0, this.$currentRuleId, this.$idSet, this.$isDeleteAll, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11291) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11291.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            List r15 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
            ae r2 = AutoMemoryCollectionListViewModel.access$get_state$p(this.this$0);
            AutoMemoryCollectionListViewModel r3 = this.this$0;
            Set<Long> r13 = this.$idSet;
        L12:
            Object r4 = r2.c();
            d r5 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin");
            if (r2.a(r4, d.a(r5, null, null, AutoMemoryCollectionListViewModel.access$buildUiItems(r3, r15), false, SetsKt.minus(r5.e(), (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")), 11, null)) == false) goto L12;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            CoroutineContext r16 = ck.f17296b.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
            Function2 r6 = (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionListViewModel$deleteItems$1$refreshedItems$1(this.this$0, this.$currentRuleId, this.$idSet, this.$isDeleteAll, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r14 = kotlinx.coroutines.i.a(r16, r6, r7);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$markCollectionRead$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$markCollectionRead$2", f = "AutoMemoryCollectionListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $collectionId;
        int label;

        AnonymousClass2(long r3, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$collectionId = r3;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$collectionId, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            Long r6 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryMaxIdByRuleId(this.$collectionId);
            if (r6 == null) goto L9;
            long r0 = r6.longValue();
            MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().updateLastExposedAutoMemoryId(this.$collectionId, r0);
            return Unit.INSTANCE;
        L9:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$queryAutoMemoryByCollectionId$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$queryAutoMemoryByCollectionId$2", f = "AutoMemoryCollectionListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11302 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends y>>, Object> {
        final /* synthetic */ long $collectionId;
        private /* synthetic */ Object L$0;
        int label;

        C11302(long r3, Continuation<? super C11302> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$collectionId = r3;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            C11302 r0 = new C11302(this.$collectionId, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends y>> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super List<y>> r4) {
            return ((C11302) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11302.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r3);
            al r4 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            long r2 = this.$collectionId;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
            Object r5 = Result.m1421constructorimpl(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryListItemsByRuleId(r2));     // Catch: Throwable -> L7
        L9:
            List r6 = CollectionsKt.emptyList();
            if (Result.m1427isFailureimpl(r5) == false) goto L13;
            r5 = r6;
        L13:
            return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        L7:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$refresh$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$refresh$2", f = "AutoMemoryCollectionListViewModel.kt", i = {1, 2, 2}, l = {57, EventsUtils.FEAT_TYPE_ACTIVITY_PAUSED_TIMEOUT, 61}, m = "invokeSuspend", n = {"rule", "rule", "items"}, s = {"L$0", "L$0", "L$1"})
    static final class C11312 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $currentRuleId;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AutoMemoryCollectionListViewModel this$0;

        C11312(AutoMemoryCollectionListViewModel r3, long r4, Continuation<? super C11312> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$currentRuleId = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11312(this.this$0, this.$currentRuleId, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11312) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11312.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r16) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            List r3 = (List) ZeusTransformUtils.preCheckCast(this.L$1, List.class, "com.obric.memorydata.plugin");
            MemoryRuleEntity r4 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(this.L$0, MemoryRuleEntity.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r16);
        L22:
            ae r5 = AutoMemoryCollectionListViewModel.access$get_state$p(this.this$0);
            AutoMemoryCollectionListViewModel r0 = this.this$0;
        L23:
            Object r6 = r5.c();
            d r7 = (d) ZeusTransformUtils.preCheckCast(r6, d.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L32;
            String r8 = r4.getTitle();
            if (r8 == null) goto L32;
            CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
            if (StringsKt.isBlank(r9) == false) goto L30;
            r9 = r7.a();
        L30:
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L32;
        L33:
            MemoryRuleEntity r11 = r4;
            if (r5.a(r6, d.a(r7, r10, r11, AutoMemoryCollectionListViewModel.access$buildUiItems(r0, r3), false, null, 24, null)) == false) goto L23;
            return Unit.INSTANCE;
        L32:
            r10 = r7.a();
            goto L33
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r4 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(this.L$0, MemoryRuleEntity.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r16);
            Object r12 = r16;
        L18:
            List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
            AutoMemoryCollectionListViewModel r14 = this.this$0;
            long r15 = this.$currentRuleId;
            Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r4;
            this.L$1 = r13;
            this.label = 3;
            if (AutoMemoryCollectionListViewModel.access$markCollectionRead(r14, r15, r17) != r1) goto L21;
            return r1;
        L21:
            r3 = r13;
            goto L22
        L11:
            ResultKt.throwOnFailure(r16);
            Object r18 = r16;
        L15:
            r4 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r18, MemoryRuleEntity.class, "com.obric.memorydata.plugin");
            AutoMemoryCollectionListViewModel r19 = this.this$0;
            long r20 = this.$currentRuleId;
            Continuation r21 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r4;
            this.label = 2;
            r12 = AutoMemoryCollectionListViewModel.access$queryAutoMemoryByCollectionId(r19, r20, r21);
            if (r12 != r1) goto L18;
            return r1;
        L12:
            ResultKt.throwOnFailure(r16);
            CoroutineContext r22 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r23 = (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionListViewModel$refresh$2$rule$1(this.$currentRuleId, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r24 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r18 = kotlinx.coroutines.i.a(r22, r23, r24);
            if (r18 != r1) goto L15;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$updateCollectionPausedState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.memorylist.AutoMemoryCollectionListViewModel$updateCollectionPausedState$2", f = "AutoMemoryCollectionListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11322 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $currentRuleId;
        final /* synthetic */ boolean $isPaused;
        int label;

        C11322(long r3, boolean r5, Continuation<? super C11322> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$currentRuleId = r3;
            this.$isPaused = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11322(this.$currentRuleId, this.$isPaused, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11322) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11322.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().updatePausedState(this.$currentRuleId, this.$isPaused) <= 0) goto L8;
            com.obric.memorydata.memory.b.a.f10078a.a();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
        DateTimeFormatter r0 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA);
        Intrinsics.checkNotNullExpressionValue(r0, "ofPattern(...)");
        DAY_HEADER_DATE_FORMAT = r0;
    }

    public AutoMemoryCollectionListViewModel() {
        this.TAG = "AutoMemoryCollectionListViewModel";
        ae<d> r0 = at.a(new d(null, null, null, false, null, 31, null));
        this._state = r0;
        this.state = k.a(r0);
    }

    public static final /* synthetic */ List access$buildUiItems(AutoMemoryCollectionListViewModel r2, List r3) {
        return r2.buildUiItems((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ List access$deleteItemsFromDb(AutoMemoryCollectionListViewModel r2, long r3, Set r5, boolean r6) {
        return r2.deleteItemsFromDb(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"), r6);
    }

    public static final /* synthetic */ DateTimeFormatter access$getDAY_HEADER_DATE_FORMAT$cp() {
        return DAY_HEADER_DATE_FORMAT;
    }

    public static final /* synthetic */ ae access$get_state$p(AutoMemoryCollectionListViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ Object access$markCollectionRead(AutoMemoryCollectionListViewModel r2, long r3, Continuation r5) {
        return r2.markCollectionRead(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$queryAutoMemoryByCollectionId(AutoMemoryCollectionListViewModel r2, long r3, Continuation r5) {
        return r2.queryAutoMemoryByCollectionId(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final List<com.obric.memorydata.memory.ui.automemory.memorylist.b> buildUiItems(List<y> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r10.isEmpty() == true) goto L5;
        ZoneId r0 = ZoneId.systemDefault();
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L13;
        Object r3 = r12.next();
        LocalDate r4 = Instant.ofEpochMilli(((y) ZeusTransformUtils.preCheckCast(r3, y.class, "com.obric.memorydata.plugin")).b()).atZone(r0).toLocalDate();
        Object r5 = r2.get(r4);
        if (r5 != null) goto L12;
        r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r2.put(r4, r5);
    L12:
        ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).add(r3);
        goto L8
    L13:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r2.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L15:
        if (r14.hasNext() == false) goto L18;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        LocalDate r8 = (LocalDate) ZeusTransformUtils.preCheckCast(r7.getKey(), LocalDate.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.preCheckCast(r7.getValue(), List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r0);
        r6.add(new com.obric.memorydata.memory.ui.automemory.memorylist.b(formatDateTitle(r8, r0), CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin"))));
        goto L15
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    public static /* synthetic */ void deleteItems$default(AutoMemoryCollectionListViewModel r1, Set r2, boolean r3, int r4, Object r5) {
        Set<Long> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        r1.deleteItems(r6, r3);
    }

    private static final Sequence deleteItems$lambda$8(com.obric.memorydata.memory.ui.automemory.memorylist.b r2) {
        Intrinsics.checkNotNullParameter(r2, "group");
        return CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r2.b(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final long deleteItems$lambda$9(y r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.a();
    }

    private final List<y> deleteItemsFromDb(long r8, Set<Long> r10, boolean r11) {
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        AutoMemoryCollectionListViewModel r1 = (AutoMemoryCollectionListViewModel) ZeusTransformUtils.preCheckCast(this, AutoMemoryCollectionListViewModel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r11 == false) goto L6;
        int r13 = com.obric.memorydata.memory.b.b.f10079a.a(r8);     // Catch: Throwable -> L15
    L7:
        RunLog.INSTANCE.debug(r1.TAG, "deleteItems resolved, ruleId=" + r8 + ", dbCount=" + r13);     // Catch: Throwable -> L15
        if (r8 <= 0) goto L10;
        RunLog.INSTANCE.debug(r1.TAG, "deleteItems finish, ruleId=" + r8);     // Catch: Throwable -> L15
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().updateMemoryRuleCountById(r8);     // Catch: Throwable -> L15
    L10:
        if (r8 <= 0) goto L12;
        List<y> r14 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryListItemsByRuleId(r8);     // Catch: Throwable -> L15
    L13:
        Object r15 = Result.m1421constructorimpl(r14);     // Catch: Throwable -> L15
    L17:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L26;
        RunLog.INSTANCE.error(this.TAG, "deleteItems failed, ruleId=" + r8, r16);
        if (r8 <= 0) goto L23;
        List<y> r7 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryListItemsByRuleId(r8);
    L24:
        r15 = r7;
        goto L26
    L23:
        r7 = CollectionsKt.emptyList();
    L26:
        return (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
    L12:
        r14 = CollectionsKt.emptyList();     // Catch: Throwable -> L15
        goto L13
    L6:
        r13 = com.obric.memorydata.memory.b.b.f10079a.a((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public static /* synthetic */ void enterSelectionMode$default(AutoMemoryCollectionListViewModel r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.enterSelectionMode(r1);
    }

    private final String formatDateTitle(LocalDate r6, ZoneId r7) {
        LocalDate r5 = LocalDate.now(r7);
        if (Intrinsics.areEqual(r6, r5) == false) goto L7;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r9 = R.string.memory_date_today;
        String r10 = "memory_date_today";
    L5:
        String r11 = r8.getString(ZeusTransformUtils.mapRes(r9, TypedValues.Custom.S_STRING, r10));
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");
        return r11;
    L7:
        if (Intrinsics.areEqual(r6, r5.minusDays(1)) == false) goto L9;
        r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        r9 = R.string.memory_date_yesterday;
        r10 = "memory_date_yesterday";
        goto L5
    L9:
        String r12 = DAY_HEADER_DATE_FORMAT.format((TemporalAccessor) ZeusTransformUtils.preCheckCast(r6, TemporalAccessor.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r12, "format(...)");
        return r12;
    }

    public static /* synthetic */ long lambda$4aHtD340pnADQimslzVHu8qXsJw(y r2) {
        return selectAll$lambda$17$lambda$16(r2);
    }

    /* JADX INFO: renamed from: lambda$kkQ3f7-fe76J8zctSPqRl0JrvvM, reason: not valid java name */
    public static /* synthetic */ long m806lambda$kkQ3f7fe76J8zctSPqRl0JrvvM(y r2) {
        return deleteItems$lambda$9(r2);
    }

    public static /* synthetic */ Sequence lambda$kn31W05CeQjuim2JIC7lhou5YKg(com.obric.memorydata.memory.ui.automemory.memorylist.b r0) {
        return selectAll$lambda$17$lambda$15(r0);
    }

    public static /* synthetic */ Sequence lambda$oi6P3YxZUSTxkSTV_WyQHZXrSps(com.obric.memorydata.memory.ui.automemory.memorylist.b r0) {
        return deleteItems$lambda$8(r0);
    }

    private final Object markCollectionRead(long r4, Continuation<? super Unit> r6) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        Object r5 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    private final Object queryAutoMemoryByCollectionId(long r4, Continuation<? super List<y>> r6) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C11302(r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final Sequence selectAll$lambda$17$lambda$15(com.obric.memorydata.memory.ui.automemory.memorylist.b r2) {
        Intrinsics.checkNotNullParameter(r2, "group");
        return CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r2.b(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final long selectAll$lambda$17$lambda$16(y r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.a();
    }

    public static /* synthetic */ void toggleSelection$default(AutoMemoryCollectionListViewModel r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.toggleSelection(r1);
    }

    public final void deleteCollection(Function0<Unit> r14) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onDeleted");
        long r5 = this.ruleId;
        if (r5 > 0) goto L6;
        r4.invoke();
        return;
    L6:
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r4, r5, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void deleteItems(Set<Long> r21, boolean r22) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r21, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "idSet");
        if (r9.isEmpty() == false) goto L6;
        RunLog.INSTANCE.debug(this.TAG, "deleteItems skip empty idSet");
        return;
    L6:
        long r2 = this.ruleId;
        Set r0 = SequencesKt.toSet(SequencesKt.map(SequencesKt.flatMap(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(((d) ZeusTransformUtils.preCheckCast(this._state.c(), d.class, "com.obric.memorydata.plugin")).c(), Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$AutoMemoryCollectionListViewModel$oi6P3YxZUSTxkSTV_WyQHZXrSps.INSTANCE), $$Lambda$AutoMemoryCollectionListViewModel$kkQ3f7fe76J8zctSPqRl0JrvvM.INSTANCE));
        if (r22 == true) goto L9;
    L11:
        boolean r11 = false;
    L12:
        RunLog.INSTANCE.debug(this.TAG, "deleteItems start, ruleId=" + r2 + ", selectedCount=" + r9.size() + ", visibleCount=" + r0.size() + ", isDeleteAll=" + r11);
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11291(this, r2, r9, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        ae<d> r1 = this._state;
    L13:
        d r3 = r1.c();
        d r12 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L17;
        List r4 = CollectionsKt.emptyList();
    L16:
        List r15 = r4;
        if (r11 == false) goto L36;
        Set r5 = SetsKt.emptySet();
    L38:
        if (r1.a(r3, d.a(r12, null, null, r15, false, r5, 11, null)) == false) goto L13;
        return;
    L36:
        r5 = SetsKt.minus(r12.e(), (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"));
        goto L38
    L17:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r12.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L19:
        if (r8.hasNext() == false) goto L32;
        com.obric.memorydata.memory.ui.automemory.memorylist.b r10 = (com.obric.memorydata.memory.ui.automemory.memorylist.b) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.memory.ui.automemory.memorylist.b.class, "com.obric.memorydata.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10.b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r13.iterator();
    L22:
        if (r16.hasNext() == false) goto L26;
        Object r17 = r16.next();
        if ((!r9.contains(Long.valueOf(((y) ZeusTransformUtils.preCheckCast(r17, y.class, "com.obric.memorydata.plugin")).a()))) == false) goto L22;
        r14.add(r17);
        goto L22
    L26:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.automemory.memorylist.b r19 = null;
        if (r18.isEmpty() == true) goto L30;
        r19 = com.obric.memorydata.memory.ui.automemory.memorylist.b.a(r10, null, r18, 1, null);
    L30:
        if (r19 == null) goto L19;
        r7.add(r19);
        goto L19
    L32:
        r4 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        goto L16
    L9:
        if (r2 <= 0) goto L11;
        r11 = true;
        goto L12
    }

    public final void enterSelectionMode(Long r13) {
        ae<d> r12 = this._state;
    L3:
        d r0 = r12.c();
        d r3 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        Long r1 = null;
        if (r13 != null) goto L6;
    L11:
        if (r1 == null) goto L13;
        Set r2 = SetsKt.setOf(r13);
    L15:
        if (r12.a(r0, d.a(r3, null, null, null, true, r2, 7, null)) == false) goto L3;
        return;
    L13:
        r2 = SetsKt.emptySet();
        goto L15
    L6:
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r1 = r13;
        goto L11
    L8:
        r4 = false;
        goto L9
    }

    public final void exitSelectionMode() {
        ae<d> r10 = this._state;
    L3:
        d r0 = r10.c();
        if (r10.a(r0, d.a((d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin"), null, null, null, false, SetsKt.emptySet(), 7, null)) == false) goto L3;
    }

    public final long getRuleId() {
        return this.ruleId;
    }

    public final ar<d> getState() {
        return this.state;
    }

    public final void init(long r11, String r13) {
        Intrinsics.checkNotNullParameter(r13, "title");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r14) == false) goto L5;
        r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_auto_memory_list, TypedValues.Custom.S_STRING, "memory_auto_memory_list"));
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
    L5:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
        ae<d> r15 = this._state;
        r15.b(d.a((d) ZeusTransformUtils.preCheckCast(r15.c(), d.class, "com.obric.memorydata.plugin"), r3, null, null, false, null, 30, null));
        if (r11 > 0) goto L11;
        ae<d> r16 = this._state;
    L8:
        d r10 = r16.c();
        if (r16.a(r10, d.a((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.memorydata.plugin"), null, null, CollectionsKt.emptyList(), false, null, 27, null)) == false) goto L8;
        return;
    L11:
        this.ruleId = r11;
        refresh();
    }

    public final boolean isBuildPackageExporting() {
        if (this.exportingAutoMemoryId == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void markBuildPackageExportFinished() {
        this.exportingAutoMemoryId = null;
    }

    public final void markBuildPackageExportStarted(long r1) {
        this.exportingAutoMemoryId = Long.valueOf(r1);
    }

    public final void refresh() {
        long r0 = this.ruleId;
        if (r0 > 0) goto L8;
        ae<d> r2 = this._state;
    L5:
        d r12 = r2.c();
        if (r2.a(r12, d.a((d) ZeusTransformUtils.preCheckCast(r12, d.class, "com.obric.memorydata.plugin"), null, null, CollectionsKt.emptyList(), false, null, 27, null)) == false) goto L5;
        return;
    L8:
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11312(this, r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void selectAll() {
        ae<d> r11 = this._state;
    L3:
        d r0 = r11.c();
        d r3 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        if (r11.a(r0, d.a(r3, null, null, null, false, SequencesKt.toSet(SequencesKt.map(SequencesKt.flatMap(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r3.c(), Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$AutoMemoryCollectionListViewModel$kn31W05CeQjuim2JIC7lhou5YKg.INSTANCE), $$Lambda$AutoMemoryCollectionListViewModel$4aHtD340pnADQimslzVHu8qXsJw.INSTANCE)), 15, null)) == false) goto L3;
    }

    public final void selectNone() {
        ae<d> r10 = this._state;
    L3:
        d r0 = r10.c();
        if (r10.a(r0, d.a((d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin"), null, null, null, false, SetsKt.emptySet(), 15, null)) == false) goto L3;
    }

    public final void setRuleId(long r1) {
        this.ruleId = r1;
    }

    public final void toggleSelection(Long r12) {
        if (((d) ZeusTransformUtils.preCheckCast(this._state.c(), d.class, "com.obric.memorydata.plugin")).d() == false) goto L15;
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.longValue() <= 0) goto L19;
        ae<d> r11 = this._state;
    L9:
        d r0 = r11.c();
        d r3 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");
        if (r3.e().contains(r12) == false) goto L12;
        Set r1 = SetsKt.minus(r3.e(), r12);
    L14:
        if (r11.a(r0, d.a(r3, null, null, null, false, r1, 15, null)) == false) goto L9;
        return;
    L12:
        r1 = SetsKt.plus(r3.e(), r12);
        goto L14
    L19:
        return;
    }

    public final void updateCollectionPausedState(boolean r41) {
        long r1 = this.ruleId;
        if (r1 > 0) goto L5;
        return;
    L5:
        ae<d> r3 = this._state;
    L6:
        d r4 = r3.c();
        d r7 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin");
        MemoryRuleEntity r9 = r7.b();
        if (r9 == null) goto L9;
        MemoryRuleEntity r10 = MemoryRuleEntity.copy$default(r9, 0, null, null, null, null, null, null, null, false, 0, null, null, null, null, r41, false, false, false, 0, 0, 0, null, null, null, 0, 33538047, null);
    L11:
        if (r3.a(r4, d.a(r7, null, r10, null, false, null, 29, null)) == false) goto L6;
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11322(r1, r41, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    L9:
        r10 = null;
        goto L11
    }
}
