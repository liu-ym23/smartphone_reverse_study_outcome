package com.obric.memorydata.memory.ui.list;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.room.InvalidationTracker;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0006*\u0002\u0086\u0001\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008a\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0015\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020!H\u0000¢\u0006\u0002\b*J\u0006\u0010+\u001a\u00020\u000bJ\u0006\u0010,\u001a\u00020\u000bJ \u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020K2\u0006\u0010X\u001a\u00020M2\b\u0010Y\u001a\u0004\u0018\u00010LJ\u0006\u0010Z\u001a\u00020!J\u0006\u0010[\u001a\u00020\u000bJ\u0006\u0010\\\u001a\u00020\u000bJ!\u0010]\u001a\u00020\u000b2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0000¢\u0006\u0002\bbJ\u0017\u0010c\u001a\u00020\u000b2\b\u0010^\u001a\u0004\u0018\u00010_H\u0000¢\u0006\u0002\bdJ\u0015\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bhJ\r\u0010i\u001a\u00020aH\u0000¢\u0006\u0002\bjJ\u0012\u0010k\u001a\u00020\u00062\n\b\u0002\u0010l\u001a\u0004\u0018\u00010KJ\u000e\u0010p\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u0006J\u000e\u0010q\u001a\u00020\u000b2\u0006\u0010r\u001a\u00020!J\u001c\u0010s\u001a\u00020\u000b2\u0006\u0010t\u001a\u0002012\f\u0010u\u001a\b\u0012\u0004\u0012\u00020v0\u001aJ\u0007\u0010\u0088\u0001\u001a\u00020\u000bJ\u0007\u0010\u0089\u0001\u001a\u00020\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001d¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u001e\u0010%\u001a\u00020!2\u0006\u0010$\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010-\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001e\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u0010\u0014R\u001c\u0010:\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0012\"\u0004\b<\u0010\u0014R\u001e\u0010=\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b>\u00103\"\u0004\b?\u00105R\u001a\u0010@\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010'\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0012\"\u0004\bF\u0010\u0014R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020!0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020!0\u001d¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u001fR0\u0010I\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020K\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010L\u0012\u0004\u0012\u00020M0J\u0018\u00010J0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R3\u0010O\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020K\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010L\u0012\u0004\u0012\u00020M0J\u0018\u00010J0\u001d¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u001fR\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010T0\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u001fR\u0014\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u001fR\u0014\u0010w\u001a\b\u0012\u0004\u0012\u00020!0xX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010y\u001a\b\u0012\u0004\u0012\u00020!0z¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0017\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000b0x¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0019\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0z¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010|R\u0015\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020!0xX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020!0z¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010|R\u0013\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0087\u0001¨\u0006\u008b\u0001"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "selectBottomTab", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getSelectBottomTab", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "previousBottomTabBeforeAutoMemory", "updateSelectedBottomTab", "", "tab", "Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;", "getPreviousBottomTabBeforeAutoMemory", "updateAutoMemoryFallbackTab", "selectedTag", "getSelectedTag", "()Ljava/lang/String;", "setSelectedTag", "(Ljava/lang/String;)V", "selectionManager", "Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "getSelectionManager", "()Lcom/obric/memorydata/memory/ui/list/SelectionStateManager;", "_memorySourceFilters", "", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "memorySourceFilters", "Lkotlinx/coroutines/flow/StateFlow;", "getMemorySourceFilters", "()Lkotlinx/coroutines/flow/StateFlow;", "_glassesLandingPending", "", "glassesLandingPending", "getGlassesLandingPending", EventBody.KEY_VALUE, "keepGlassesForVisit", "getKeepGlassesForVisit$memory_obricRelease", "()Z", "restoreGlassesVisibility", "visible", "restoreGlassesVisibility$memory_obricRelease", "requestGlassesLanding", "consumeGlassesLanding", "selectedCollectSourcePackage", "getSelectedCollectSourcePackage", "setSelectedCollectSourcePackage", "selectedCollectSourceProductType", "", "getSelectedCollectSourceProductType", "()Ljava/lang/Integer;", "setSelectedCollectSourceProductType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "selectedCollectSourceName", "getSelectedCollectSourceName", "setSelectedCollectSourceName", "targetCollectSourcePackage", "getTargetCollectSourcePackage", "setTargetCollectSourcePackage", "targetCollectSourceProductType", "getTargetCollectSourceProductType", "setTargetCollectSourceProductType", "forceCollectAllForTarget", "getForceCollectAllForTarget", "setForceCollectAllForTarget", "(Z)V", "targetPersonalTag", "getTargetPersonalTag", "setTargetPersonalTag", "_isLayoutBottomTabState", "isLayoutBottomTabState", "_targetEntityFlow", "Lkotlin/Pair;", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "Ljava/time/LocalDate;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isConsumedTargetEntity", "targetEntityFlow", "getTargetEntityFlow", "contextAwarenessLaunchTargetStateMachine", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetStateMachine;", "contextAwarenessTargetRequest", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTargetRequest;", "getContextAwarenessTargetRequest$memory_obricRelease", "setTargetEntity", "memoryTab", "appEntity", "date", "isTargetEntityConsumed", "consumeTargetEntity", "resetTargetEntityConsumeStatus", "initializeContextAwarenessTarget", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "restoredSnapshot", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessLaunchTargetSnapshot;", "initializeContextAwarenessTarget$memory_obricRelease", "replaceContextAwarenessTargetFromNewIntent", "replaceContextAwarenessTargetFromNewIntent$memory_obricRelease", "completeContextAwarenessTarget", "requestId", "", "completeContextAwarenessTarget$memory_obricRelease", "contextAwarenessLaunchTargetSnapshot", "contextAwarenessLaunchTargetSnapshot$memory_obricRelease", "getMixTab", "targetMemoryTab", "_enterFrom", "enterFrom", "getEnterFrom", "setEnterFrom", "setIsLayoutBottomTabState", "isShow", "updateMemorySourceStats", "totalCount", "stats", "Lcom/obric/memorydata/database/entity/CollectMemorySourceStat;", "_memoryCorrelationChangeFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "memoryCorrelationChangeFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getMemoryCorrelationChangeFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_memoryDeleteFlow", "get_memoryDeleteFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "memoryDeleteFlow", "getMemoryDeleteFlow", "_screenObservationChangeFlow", "screenObservationChangeFlow", "getScreenObservationChangeFlow", "memoryDataChangedObserver", "com/obric/memorydata/memory/ui/list/MemoryListShareViewModel$memoryDataChangedObserver$1", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel$memoryDataChangedObserver$1;", "registerGlobalMemoryObserver", "unregisterGlobalMemoryObserver", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryListShareViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "MemoryListShareViewModel";
    private final kotlinx.coroutines.flow.ae<String> _enterFrom;
    private final kotlinx.coroutines.flow.ae<Boolean> _glassesLandingPending;
    private final kotlinx.coroutines.flow.ae<Boolean> _isLayoutBottomTabState;
    private final kotlinx.coroutines.flow.ad<Boolean> _memoryCorrelationChangeFlow;
    private final kotlinx.coroutines.flow.ad<Unit> _memoryDeleteFlow;
    private final kotlinx.coroutines.flow.ae<List<MemorySourceFilter>> _memorySourceFilters;
    private final kotlinx.coroutines.flow.ad<Boolean> _screenObservationChangeFlow;
    private final kotlinx.coroutines.flow.ae<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> _targetEntityFlow;
    private final com.obric.memorydata.memory.ui.list.contextawareness.f contextAwarenessLaunchTargetStateMachine;
    private final kotlinx.coroutines.flow.ar<com.obric.memorydata.memory.ui.list.contextawareness.l> contextAwarenessTargetRequest;
    private final kotlinx.coroutines.flow.ar<String> enterFrom;
    private volatile boolean forceCollectAllForTarget;
    private final kotlinx.coroutines.flow.ar<Boolean> glassesLandingPending;
    private boolean isConsumedTargetEntity;
    private final kotlinx.coroutines.flow.ar<Boolean> isLayoutBottomTabState;
    private volatile boolean keepGlassesForVisit;
    private final kotlinx.coroutines.flow.ai<Boolean> memoryCorrelationChangeFlow;
    private final MemoryListShareViewModel$memoryDataChangedObserver$1 memoryDataChangedObserver;
    private final kotlinx.coroutines.flow.ai<Unit> memoryDeleteFlow;
    private final kotlinx.coroutines.flow.ar<List<MemorySourceFilter>> memorySourceFilters;
    private volatile String previousBottomTabBeforeAutoMemory;
    private final kotlinx.coroutines.flow.ai<Boolean> screenObservationChangeFlow;
    private final kotlinx.coroutines.flow.ae<String> selectBottomTab;
    private volatile String selectedCollectSourceName;
    private volatile String selectedCollectSourcePackage;
    private volatile Integer selectedCollectSourceProductType;
    private volatile String selectedTag;
    private final SelectionStateManager selectionManager;
    private volatile String targetCollectSourcePackage;
    private volatile Integer targetCollectSourceProductType;
    private final kotlinx.coroutines.flow.ar<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> targetEntityFlow;
    private volatile String targetPersonalTag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListShareViewModel$registerGlobalMemoryObserver$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListShareViewModel$registerGlobalMemoryObserver$1", f = "MemoryListShareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListShareViewModel this$0;

        AnonymousClass1(MemoryListShareViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            MemoryDbEngine.INSTANCE.getPersonalDbEngine().getInvalidationTracker().addObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(MemoryListShareViewModel.access$getMemoryDataChangedObserver$p(this.this$0), InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListShareViewModel$unregisterGlobalMemoryObserver$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListShareViewModel$unregisterGlobalMemoryObserver$1", f = "MemoryListShareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11641 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryListShareViewModel this$0;

        C11641(MemoryListShareViewModel r3, Continuation<? super C11641> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11641(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11641) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11641.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            MemoryDbEngine.INSTANCE.getPersonalDbEngine().getInvalidationTracker().removeObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(MemoryListShareViewModel.access$getMemoryDataChangedObserver$p(this.this$0), InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [com.obric.memorydata.memory.ui.list.MemoryListShareViewModel$memoryDataChangedObserver$1] */
    public MemoryListShareViewModel() {
        RunLog.INSTANCE.debug(TAG, "MemoryListShareViewModel: init, this: " + this);
        this.selectBottomTab = kotlinx.coroutines.flow.at.a(MemoryContainerTab.GLOBAL_MEMORY.getText());
        this.selectedTag = PersonalTag.f11118a.a();
        this.selectionManager = new SelectionStateManager();
        kotlinx.coroutines.flow.ae<List<MemorySourceFilter>> r0 = kotlinx.coroutines.flow.at.a(CollectionsKt.emptyList());
        this._memorySourceFilters = r0;
        this.memorySourceFilters = kotlinx.coroutines.flow.k.a(r0);
        kotlinx.coroutines.flow.ae<Boolean> r1 = kotlinx.coroutines.flow.at.a(false);
        this._glassesLandingPending = r1;
        this.glassesLandingPending = kotlinx.coroutines.flow.k.a(r1);
        kotlinx.coroutines.flow.ae<Boolean> r2 = kotlinx.coroutines.flow.at.a(true);
        this._isLayoutBottomTabState = r2;
        this.isLayoutBottomTabState = kotlinx.coroutines.flow.k.a(r2);
        kotlinx.coroutines.flow.ae<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> r3 = kotlinx.coroutines.flow.at.a(null);
        this._targetEntityFlow = r3;
        this.targetEntityFlow = (kotlinx.coroutines.flow.ar) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.ar.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.list.contextawareness.f r4 = new com.obric.memorydata.memory.ui.list.contextawareness.f(null, 1, null);
        this.contextAwarenessLaunchTargetStateMachine = r4;
        this.contextAwarenessTargetRequest = r4.a();
        kotlinx.coroutines.flow.ae<String> r5 = kotlinx.coroutines.flow.at.a("");
        this._enterFrom = r5;
        this.enterFrom = kotlinx.coroutines.flow.k.a(r5);
        kotlinx.coroutines.flow.ad<Boolean> r6 = kotlinx.coroutines.flow.ak.a(0, 0, null, 7, null);
        this._memoryCorrelationChangeFlow = r6;
        this.memoryCorrelationChangeFlow = kotlinx.coroutines.flow.k.a(r6);
        kotlinx.coroutines.flow.ad<Unit> r7 = kotlinx.coroutines.flow.ak.a(0, 0, null, 7, null);
        this._memoryDeleteFlow = r7;
        this.memoryDeleteFlow = kotlinx.coroutines.flow.k.a(r7);
        kotlinx.coroutines.flow.ad<Boolean> r8 = kotlinx.coroutines.flow.ak.a(0, 0, null, 7, null);
        this._screenObservationChangeFlow = r8;
        this.screenObservationChangeFlow = kotlinx.coroutines.flow.k.a(r8);
        final String[] r9 = {"RawMemoryEntityCorrelation", "ShortMemory"};
        this.memoryDataChangedObserver = new MemoryListShareViewModel$memoryDataChangedObserver$1(this, r9);
    }

    public static final /* synthetic */ MemoryListShareViewModel$memoryDataChangedObserver$1 access$getMemoryDataChangedObserver$p(MemoryListShareViewModel r0) {
        return r0.memoryDataChangedObserver;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ad access$get_memoryCorrelationChangeFlow$p(MemoryListShareViewModel r0) {
        return r0._memoryCorrelationChangeFlow;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ad access$get_screenObservationChangeFlow$p(MemoryListShareViewModel r0) {
        return r0._screenObservationChangeFlow;
    }

    public static /* synthetic */ String getMixTab$default(MemoryListShareViewModel r0, MemoryTab r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.getMixTab(r1);
    }

    public final void completeContextAwarenessTarget$memory_obricRelease(long r1) {
        this.contextAwarenessLaunchTargetStateMachine.a(r1);
    }

    public final void consumeGlassesLanding() {
        this._glassesLandingPending.b(false);
    }

    public final void consumeTargetEntity() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "consumeTargetEntity", false, 4, null);
        this.isConsumedTargetEntity = true;
    }

    public final com.obric.memorydata.memory.ui.list.contextawareness.e contextAwarenessLaunchTargetSnapshot$memory_obricRelease() {
        return this.contextAwarenessLaunchTargetStateMachine.b();
    }

    public final kotlinx.coroutines.flow.ar<com.obric.memorydata.memory.ui.list.contextawareness.l> getContextAwarenessTargetRequest$memory_obricRelease() {
        return this.contextAwarenessTargetRequest;
    }

    public final kotlinx.coroutines.flow.ar<String> getEnterFrom() {
        return this.enterFrom;
    }

    public final boolean getForceCollectAllForTarget() {
        return this.forceCollectAllForTarget;
    }

    public final kotlinx.coroutines.flow.ar<Boolean> getGlassesLandingPending() {
        return this.glassesLandingPending;
    }

    public final boolean getKeepGlassesForVisit$memory_obricRelease() {
        return this.keepGlassesForVisit;
    }

    public final kotlinx.coroutines.flow.ai<Boolean> getMemoryCorrelationChangeFlow() {
        return this.memoryCorrelationChangeFlow;
    }

    public final kotlinx.coroutines.flow.ai<Unit> getMemoryDeleteFlow() {
        return this.memoryDeleteFlow;
    }

    public final kotlinx.coroutines.flow.ar<List<MemorySourceFilter>> getMemorySourceFilters() {
        return this.memorySourceFilters;
    }

    public final String getMixTab(MemoryTab r7) {
        MemoryContainerTab[] r0 = MemoryContainerTab.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        MemoryContainerTab r3 = r0[r2];
        if (Intrinsics.areEqual(r3.getText(), this.selectBottomTab.c()) == true) goto L9;
        r2 = r2 + 1;
    L9:
        if (r3 != null) goto L12;
        r3 = MemoryContainerTab.GLOBAL_MEMORY;
    L12:
        return y.f11339a.a(r3, r7).getText();
    L8:
        r3 = null;
        goto L9
    }

    public final MemoryContainerTab getPreviousBottomTabBeforeAutoMemory() {
        String r7 = this.previousBottomTabBeforeAutoMemory;
        if (r7 != null) goto L5;
        return null;
    L5:
        MemoryContainerTab[] r1 = MemoryContainerTab.values();
        int r2 = r1.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L19;
        MemoryContainerTab r5 = r1[r4];
        if (r5 != MemoryContainerTab.AUTO_MEMORY_TASK) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == true) goto L16;
        r4 = r4 + 1;
        goto L6
    L16:
        return r5;
    L10:
        if (Intrinsics.areEqual(r5.getText(), r7) == false) goto L12;
        r6 = true;
        goto L13
    L19:
        return null;
    }

    public final kotlinx.coroutines.flow.ai<Boolean> getScreenObservationChangeFlow() {
        return this.screenObservationChangeFlow;
    }

    public final kotlinx.coroutines.flow.ae<String> getSelectBottomTab() {
        return this.selectBottomTab;
    }

    public final String getSelectedCollectSourceName() {
        return this.selectedCollectSourceName;
    }

    public final String getSelectedCollectSourcePackage() {
        return this.selectedCollectSourcePackage;
    }

    public final Integer getSelectedCollectSourceProductType() {
        return this.selectedCollectSourceProductType;
    }

    public final String getSelectedTag() {
        return this.selectedTag;
    }

    public final SelectionStateManager getSelectionManager() {
        return this.selectionManager;
    }

    public final String getTargetCollectSourcePackage() {
        return this.targetCollectSourcePackage;
    }

    public final Integer getTargetCollectSourceProductType() {
        return this.targetCollectSourceProductType;
    }

    public final kotlinx.coroutines.flow.ar<Pair<MemoryTab, Pair<LocalDate, AppEntity>>> getTargetEntityFlow() {
        return this.targetEntityFlow;
    }

    public final String getTargetPersonalTag() {
        return this.targetPersonalTag;
    }

    public final kotlinx.coroutines.flow.ad<Unit> get_memoryDeleteFlow() {
        return this._memoryDeleteFlow;
    }

    public final void initializeContextAwarenessTarget$memory_obricRelease(com.obric.memorydata.memory.ui.list.contextawareness.v r1, com.obric.memorydata.memory.ui.list.contextawareness.e r2) {
        this.contextAwarenessLaunchTargetStateMachine.a(r1, r2);
    }

    public final kotlinx.coroutines.flow.ar<Boolean> isLayoutBottomTabState() {
        return this.isLayoutBottomTabState;
    }

    public final boolean isTargetEntityConsumed() {
        return this.isConsumedTargetEntity;
    }

    public final void registerGlobalMemoryObserver() {
        RunLog.INSTANCE.debug(TAG, "registerGlobalMemoryObserver");
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public final void replaceContextAwarenessTargetFromNewIntent$memory_obricRelease(com.obric.memorydata.memory.ui.list.contextawareness.v r1) {
        this.contextAwarenessLaunchTargetStateMachine.a(r1);
    }

    public final synchronized void requestGlassesLanding() {
        monitor-enter(this);
        this.keepGlassesForVisit = true;     // Catch: Throwable -> L7
        this._glassesLandingPending.b(true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void resetTargetEntityConsumeStatus() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "resetTargetEntityConsumeStatus", false, 4, null);
        this.isConsumedTargetEntity = false;
    }

    public final synchronized void restoreGlassesVisibility$memory_obricRelease(boolean r2) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.keepGlassesForVisit == true) goto L8;
        if (r2 == true) goto L8;
        boolean r3 = false;
    L9:
        this.keepGlassesForVisit = r3;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L8:
        r3 = true;
        goto L9
    }

    public final void setEnterFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        this._enterFrom.b(r2);
    }

    public final void setForceCollectAllForTarget(boolean r1) {
        this.forceCollectAllForTarget = r1;
    }

    public final void setIsLayoutBottomTabState(boolean r1) {
        this._isLayoutBottomTabState.b(Boolean.valueOf(r1));
    }

    public final void setSelectedCollectSourceName(String r1) {
        this.selectedCollectSourceName = r1;
    }

    public final void setSelectedCollectSourcePackage(String r1) {
        this.selectedCollectSourcePackage = r1;
    }

    public final void setSelectedCollectSourceProductType(Integer r1) {
        this.selectedCollectSourceProductType = r1;
    }

    public final void setSelectedTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectedTag = r2;
    }

    public final void setTargetCollectSourcePackage(String r1) {
        this.targetCollectSourcePackage = r1;
    }

    public final void setTargetCollectSourceProductType(Integer r1) {
        this.targetCollectSourceProductType = r1;
    }

    public final void setTargetEntity(MemoryTab r3, AppEntity r4, LocalDate r5) {
        Intrinsics.checkNotNullParameter(r3, "memoryTab");
        Intrinsics.checkNotNullParameter(r4, "appEntity");
        this._targetEntityFlow.b(new Pair(r3, new Pair(r5, r4)));
    }

    public final void setTargetPersonalTag(String r1) {
        this.targetPersonalTag = r1;
    }

    public final void unregisterGlobalMemoryObserver() {
        RunLog.INSTANCE.debug(TAG, "unregisterGlobalMemoryObserver");
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11641(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public final void updateAutoMemoryFallbackTab(MemoryContainerTab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        if (r2 == MemoryContainerTab.AUTO_MEMORY_TASK) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.previousBottomTabBeforeAutoMemory = r2.getText();
        return;
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final synchronized void updateMemorySourceStats(int r7, List<com.obric.memorydata.database.entity.al> r8) {
        monitor-enter(this);
        List<com.obric.memorydata.database.entity.al> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        Intrinsics.checkNotNullParameter(r9, "stats");     // Catch: Throwable -> L39
        boolean r1 = true;
        if (this.keepGlassesForVisit == true) goto L25;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L8;
    L10:
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L39
    L12:
        if (r2.hasNext() == false) goto L21;
        com.obric.memorydata.database.entity.al r3 = (com.obric.memorydata.database.entity.al) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.memorydata.database.entity.al.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        if (r3.c() == 20) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L12;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L25;
        boolean r6 = false;
    L26:
        this.keepGlassesForVisit = r6;     // Catch: Throwable -> L39
        MemorySourceFilter.a r10 = MemorySourceFilter.Companion;     // Catch: Throwable -> L39
        if (this.keepGlassesForVisit == false) goto L29;
    L32:
        List<com.obric.memorydata.database.entity.al> r11 = r10.a(r9, r1);     // Catch: Throwable -> L39
        List r12 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L39
        r12.add(MemorySourceFilter.Companion.a(RangesKt.coerceAtLeast(r7, 0)));     // Catch: Throwable -> L39
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        MemorySourceFilter.a r14 = MemorySourceFilter.Companion;     // Catch: Throwable -> L39
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        Iterator r16 = r13.iterator();     // Catch: Throwable -> L39
    L34:
        if (r16.hasNext() == false) goto L36;
        r15.add(r14.a((com.obric.memorydata.database.entity.al) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.memorydata.database.entity.al.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L39
        goto L34
    L36:
        r12.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L39
        this._memorySourceFilters.b(MemorySourceFilter.Companion.a((List) ZeusTransformUtils.preCheckCast(this._memorySourceFilters.c(), List.class, "com.obric.memorydata.plugin"), CollectionsKt.build(r12)));     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L29:
        if (h.f11312a.c() == true) goto L32;
        r1 = false;
        goto L32
    L16:
        if (r3.d() <= 0) goto L18;
        r4 = true;
    L21:
        r5 = false;
        goto L22
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
    L25:
        r6 = true;
    L39:
        th = move-exception;
        throw th;
    }

    public final void updateSelectedBottomTab(MemoryContainerTab r4) {
        Intrinsics.checkNotNullParameter(r4, "tab");
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.selectBottomTab.c(), String.class, "com.obric.memorydata.plugin");
        if (r4 == MemoryContainerTab.AUTO_MEMORY_TASK) goto L5;
        r0 = r4.getText();
    L8:
        this.previousBottomTabBeforeAutoMemory = r0;
    L9:
        this.selectBottomTab.b(r4.getText());
        return;
    L5:
        if (Intrinsics.areEqual(r0, MemoryContainerTab.AUTO_MEMORY_TASK.getText()) == true) goto L9;
        goto L9
    }
}
