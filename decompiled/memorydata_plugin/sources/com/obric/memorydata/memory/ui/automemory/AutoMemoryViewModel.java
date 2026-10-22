package com.obric.memorydata.memory.ui.automemory;

import android.os.SystemClock;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.api.settings.AutoMemoryRecommendItem;
import com.obric.memorydata.middleware.api.settings.AutoMemoryRecommendMemoryInfo;
import com.obric.memorydata.middleware.api.settings.AutoMemoryRecommendSection;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0016H\u0002J\u0006\u0010$\u001a\u00020\u0016J\b\u0010%\u001a\u00020\u0016H\u0002J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(J\u0016\u0010)\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001cJ\u000e\u0010+\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0006H\u0002J\u0006\u0010.\u001a\u00020\u0016J\b\u0010/\u001a\u00020\u001eH\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0002J\u0014\u00103\u001a\u000204*\u0002052\u0006\u00106\u001a\u00020\u001eH\u0002J\u0016\u00107\u001a\u000208*\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u001eH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryUiEvent;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "checkUpdatingJob", "Lkotlinx/coroutines/Job;", "ruleUpdatingPollingJob", "selectTab", "", "tab", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "checkUpdatingOnceAndShowLoading", "showLoadingAndEnqueueRuleGenerator", "enqueueRuleUpdatingTask", "", "taskName", "", "startRuleUpdatingPolling", "queryRuleUpdating", "defaultValue", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishRuleUpdating", "cancelRuleUpdatingLoading", "dismissLoading", "deleteMyCollection", "cardId", "", "updateMyCollectionPausedState", "isPaused", "hasReachedManualCollectionLimit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildInitialState", "refreshMyCollections", "getMyCollectionExcludeSource", "parseRecommendData", "", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardItem;", "toPresetMemoryInfo", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", "Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendItem;", "fallbackTitle", "toMemoryInfoSection", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo$Section;", "Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendSection;", "defaultTitle", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String DEFAULT_INFO_TITLE = "具体记忆的内容";
    private static final int MAX_MANUAL_COLLECTION_COUNT = 10;
    private static final int RULE_UPDATING_FAST_POLL_COUNT = 3;
    private static final long RULE_UPDATING_FAST_POLL_INTERVAL_MS = 300;
    private static final long RULE_UPDATING_LOG_INTERVAL_MS = 20000;
    private static final long RULE_UPDATING_SLOW_POLL_INTERVAL_MS = 1000;
    public static final String SOURCE_AI_PROACTIVE = "ai_proactive";
    private static final String TAG = "AutoMemoryViewModel";
    private final ad<t> _events;
    private final ae<u> _state;
    private bx checkUpdatingJob;
    private final ai<t> events;
    private bx ruleUpdatingPollingJob;
    private final ar<u> state;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryViewModel$Companion;", "", "<init>", "()V", "TAG", "", "SOURCE_AI_PROACTIVE", "DEFAULT_INFO_TITLE", "RULE_UPDATING_FAST_POLL_INTERVAL_MS", "", "RULE_UPDATING_SLOW_POLL_INTERVAL_MS", "RULE_UPDATING_FAST_POLL_COUNT", "", "RULE_UPDATING_LOG_INTERVAL_MS", "MAX_MANUAL_COLLECTION_COUNT", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$checkUpdatingOnceAndShowLoading$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$checkUpdatingOnceAndShowLoading$1", f = "AutoMemoryViewModel.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AutoMemoryViewModel this$0;

        AnonymousClass1(AutoMemoryViewModel r3, Continuation<? super AnonymousClass1> r4) {
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
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            AutoMemoryViewModel r5 = this.this$0;
            if (r7 == false) goto L14;
            AutoMemoryViewModel.access$showLoadingAndEnqueueRuleGenerator(r5);
        L16:
            return Unit.INSTANCE;
        L14:
            AutoMemoryViewModel.access$dismissLoading(r5);
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            AutoMemoryViewModel r8 = this.this$0;
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r6 = AutoMemoryViewModel.access$queryRuleUpdating(r8, false, r4);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$deleteMyCollection$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$deleteMyCollection$2", f = "AutoMemoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $cardId;
        int label;

        AnonymousClass2(long r3, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$cardId = r3;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$cardId, r6), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().deleteById(this.$cardId);
            com.obric.memorydata.memory.ui.automemory.requirement.b.f10717a.b(this.$cardId);
            com.obric.memorydata.memory.b.b.f10079a.a(this.$cardId);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$hasReachedManualCollectionLimit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel", f = "AutoMemoryViewModel.kt", i = {}, l = {225}, m = "hasReachedManualCollectionLimit", n = {}, s = {})
    static final class C11231 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoMemoryViewModel this$0;

        C11231(AutoMemoryViewModel r3, Continuation<? super C11231> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.hasReachedManualCollectionLimit((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$queryRuleUpdating$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$queryRuleUpdating$2", f = "AutoMemoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11242 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
        final /* synthetic */ boolean $defaultValue;
        private /* synthetic */ Object L$0;
        int label;

        C11242(boolean r3, Continuation<? super C11242> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$defaultValue = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            C11242 r0 = new C11242(this.$defaultValue, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
            return ((C11242) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11242.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r5);
            al r6 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L7
            Object r8 = Result.m1421constructorimpl(Boxing.boxBoolean(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().isUpdating()));     // Catch: Throwable -> L7
        L9:
            Throwable r0 = Result.m1424exceptionOrNullimpl(r8);
            if (r0 == null) goto L12;
            RunLog.INSTANCE.warn(AutoMemoryViewModel.TAG, "check rule updating state failed", r0);
        L12:
            Boolean r4 = Boxing.boxBoolean(this.$defaultValue);
            if (Result.m1427isFailureimpl(r8) == true) goto L15;
            return r8;
        L15:
            return r4;
        L7:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L9
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$refreshMyCollections$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$refreshMyCollections$1", f = "AutoMemoryViewModel.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    static final class C11251 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AutoMemoryViewModel this$0;

        C11251(AutoMemoryViewModel r3, Continuation<? super C11251> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11251(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11251) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11251.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
            ae r11 = AutoMemoryViewModel.access$get_state$p(this.this$0);
        L12:
            Object r2 = r11.c();
            if (r11.a(r2, u.a((u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.memorydata.plugin"), null, false, r13, null, 11, null)) == false) goto L12;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            CoroutineContext r14 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryViewModel$refreshMyCollections$1$dbItems$1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r12 = kotlinx.coroutines.i.a(r14, r3, r4);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$startRuleUpdatingPolling$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$startRuleUpdatingPolling$1", f = "AutoMemoryViewModel.kt", i = {0, 0, 1, 1}, l = {133, 135}, m = "invokeSuspend", n = {"pollCount", "lastLogTime", "pollCount", "lastLogTime"}, s = {"I$0", "J$0", "I$0", "J$0"})
    static final class C11261 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int I$0;
        long J$0;
        int label;
        final /* synthetic */ AutoMemoryViewModel this$0;

        C11261(AutoMemoryViewModel r3, Continuation<? super C11261> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11261(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11261) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11261.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007d -> B:23:0x0080). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            long r7 = this.J$0;
            int r3 = this.I$0;
            ResultKt.throwOnFailure(r19);
            Object r9 = r19;
        L23:
            boolean r10 = ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            long r11 = SystemClock.elapsedRealtime();
            if ((r11 - r7) < 20000) goto L26;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AutoMemoryViewModel.TAG, "rule updating polling check isUpdating=" + r10 + " pollCount=" + r3, false, 4, null);
            r7 = r11;
        L26:
            if (r10 == true) goto L12;
            AutoMemoryViewModel.access$setRuleUpdatingPollingJob$p(this.this$0, null);
            AutoMemoryViewModel.access$finishRuleUpdating(this.this$0);
        L29:
            return Unit.INSTANCE;
        L12:
            if (((u) ZeusTransformUtils.preCheckCast(AutoMemoryViewModel.access$get_state$p(this.this$0).c(), u.class, "com.obric.memorydata.plugin")).b() == true) goto L14;
            AutoMemoryViewModel.access$setRuleUpdatingPollingJob$p(this.this$0, null);
            goto L29
        L14:
            if (r3 >= 3) goto L16;
            long r12 = 300;
        L17:
            Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.I$0 = r3;
            this.J$0 = r7;
            this.label = 1;
            if (au.a(r12, r13) != r1) goto L20;
            return r1;
        L20:
            r3 = r3 + 1;
            AutoMemoryViewModel r14 = this.this$0;
            Continuation r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.I$0 = r3;
            this.J$0 = r7;
            this.label = 2;
            r9 = AutoMemoryViewModel.access$queryRuleUpdating(r14, true, r15);
            if (r9 != r1) goto L23;
            return r1;
        L16:
            r12 = 1000;
            goto L17
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r7 = this.J$0;
            r3 = this.I$0;
            ResultKt.throwOnFailure(r19);
            goto L20
        L10:
            ResultKt.throwOnFailure(r19);
            r3 = 0;
            r7 = 0;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$updateMyCollectionPausedState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel$updateMyCollectionPausedState$2", f = "AutoMemoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C11272 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $cardId;
        final /* synthetic */ boolean $isPaused;
        int label;

        C11272(long r3, boolean r5, Continuation<? super C11272> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$cardId = r3;
            this.$isPaused = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11272(this.$cardId, this.$isPaused, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11272) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11272.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().updatePausedState(this.$cardId, this.$isPaused) <= 0) goto L8;
            com.obric.memorydata.memory.b.a.f10078a.a();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoMemoryViewModel() {
        ae<u> r0 = at.a(buildInitialState());
        this._state = r0;
        this.state = kotlinx.coroutines.flow.k.a(r0);
        ad<t> r1 = ak.a(0, 1, BufferOverflow.DROP_OLDEST);
        this._events = r1;
        this.events = (ai) ZeusTransformUtils.preCheckCast(r1, ai.class, "com.obric.memorydata.plugin");
        refreshMyCollections();
    }

    public static final /* synthetic */ void access$dismissLoading(AutoMemoryViewModel r0) {
        r0.dismissLoading();
    }

    public static final /* synthetic */ void access$finishRuleUpdating(AutoMemoryViewModel r0) {
        r0.finishRuleUpdating();
    }

    public static final /* synthetic */ String access$getMyCollectionExcludeSource(AutoMemoryViewModel r0) {
        return r0.getMyCollectionExcludeSource();
    }

    public static final /* synthetic */ ae access$get_state$p(AutoMemoryViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ Object access$queryRuleUpdating(AutoMemoryViewModel r2, boolean r3, Continuation r4) {
        return r2.queryRuleUpdating(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setRuleUpdatingPollingJob$p(AutoMemoryViewModel r2, bx r3) {
        r2.ruleUpdatingPollingJob = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$showLoadingAndEnqueueRuleGenerator(AutoMemoryViewModel r0) {
        r0.showLoadingAndEnqueueRuleGenerator();
    }

    private final u buildInitialState() {
        List<d> r4 = parseRecommendData();
        return new u(AutoMemoryTab.AUTO, false, CollectionsKt.emptyList(), r4, 2, null);
    }

    private final void dismissLoading() {
        ae<u> r9 = this._state;
    L3:
        u r0 = r9.c();
        if (r9.a(r0, u.a((u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.memorydata.plugin"), null, false, null, null, 13, null)) == false) goto L3;
    }

    private final boolean enqueueRuleUpdatingTask(String r10) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        AutoMemoryViewModel r9 = (AutoMemoryViewModel) ZeusTransformUtils.preCheckCast(this, AutoMemoryViewModel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r10).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();     // Catch: Throwable -> L5
        Object r11 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L8:
        if (Result.m1428isSuccessimpl(r11) == false) goto L10;
        ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "auto memory rule updating task enqueued name=" + r10, false, 4, null);
    L10:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r11);
        if (r3 == null) goto L14;
        RunLog.INSTANCE.warn(TAG, "auto memory rule updating task enqueue failed name=" + r10, r3);
    L14:
        if (Result.m1427isFailureimpl(r11) == false) goto L17;
        r11 = false;
    L17:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void finishRuleUpdating() {
        if (((u) ZeusTransformUtils.preCheckCast(this._state.c(), u.class, "com.obric.memorydata.plugin")).b() == true) goto L5;
        return;
    L5:
        dismissLoading();
        refreshMyCollections();
    }

    private final String getMyCollectionExcludeSource() {
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        return "NO_EXCLUDE";
    L5:
        return SOURCE_AI_PROACTIVE;
    }

    public static /* synthetic */ d lambda$4gPjBISpMRPPMM5v0jbV6wrpEG0(AutoMemoryViewModel r0, AutoMemoryRecommendItem r1) {
        return parseRecommendData$lambda$14(r0, r1);
    }

    private final List<d> parseRecommendData() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        AutoMemoryViewModel r2 = (AutoMemoryViewModel) ZeusTransformUtils.preCheckCast(this, AutoMemoryViewModel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(AppSettingsManager.INSTANCE.getRecommendSettings().getAutoMemoryPresetRules());     // Catch: Throwable -> L5
    L7:
        List r4 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r3) == false) goto L11;
        r3 = r4;
    L11:
        return SequencesKt.toList(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$AutoMemoryViewModel$4gPjBISpMRPPMM5v0jbV6wrpEG0(this)));
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final d parseRecommendData$lambda$14(AutoMemoryViewModel r38, AutoMemoryRecommendItem r39) {
        Intrinsics.checkNotNullParameter(r39, "item");
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r39.getTitle(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r39.getContent(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r35 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r2 = true;
    L6:
        Integer r37 = null;
        if (r2 == false) goto L9;
    L57:
        return null;
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L57;
        String r4 = r39.getIcon();
        if (r4 != null) goto L17;
        String r28 = "";
    L18:
        String r5 = r39.getIconColorKey();
        if (r5 != null) goto L21;
        String r29 = "";
    L22:
        String r6 = r39.getSubtitle();
        if (r6 == null) goto L25;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L26:
        if (r7 != null) goto L28;
        String r18 = "";
    L29:
        MemoryRuleEntity r9 = new MemoryRuleEntity(0, r1, r8, "", null, null, null, null, false, 0, null, r18, null, null, false, false, false, false, 0, 0, 0, r28, r29, null, 0, 27260401, null);
        String r10 = r38.toPresetMemoryInfo(r39, r1).h().toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        r9.setMemoryInfoJson(r10);
        Integer r11 = r39.getActiveStartMinute();
        int r12 = -1;
        if (r11 == null) goto L42;
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r13 < 0) goto L35;
        if (r13 >= 1440) goto L35;
        boolean r14 = true;
    L37:
        if (Boolean.valueOf(r14).booleanValue() == true) goto L40;
        r11 = null;
    L40:
        if (r11 == null) goto L42;
        int r15 = r11.intValue();
    L43:
        r9.setActiveStartMinute(r15);
        Integer r0 = r39.getActiveEndMinute();
        if (r0 == null) goto L55;
        int r16 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r16 < 0) goto L49;
        if (r16 >= 1440) goto L49;
    L51:
        if (Boolean.valueOf(r35).booleanValue() == false) goto L53;
        r37 = r0;
    L53:
        if (r37 == null) goto L55;
        r12 = r37.intValue();
    L49:
        r35 = false;
    L55:
        r9.setActiveEndMinute(r12);
        return new d(r9, 0, 2, null);
    L35:
        r14 = false;
    L42:
        r15 = -1;
        goto L43
    L28:
        r18 = r7;
        goto L29
    L25:
        r7 = null;
        goto L26
    L21:
        r29 = r5;
        goto L22
    L17:
        r28 = r4;
        goto L18
    L11:
        r3 = false;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    private final Object queryRuleUpdating(boolean r4, Continuation<? super Boolean> r5) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new C11242(r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    private final void showLoadingAndEnqueueRuleGenerator() {
        ae<u> r0 = this._state;
    L3:
        u r1 = r0.c();
        if (r0.a(r1, u.a((u) ZeusTransformUtils.preCheckCast(r1, u.class, "com.obric.memorydata.plugin"), null, true, null, null, 13, null)) == false) goto L3;
        enqueueRuleUpdatingTask("auto_memory_pro_rule_generator");
        enqueueRuleUpdatingTask("auto_memory_pro_memory_info_generator");
        startRuleUpdatingPolling();
    }

    private final void startRuleUpdatingPolling() {
        bx r0 = this.ruleUpdatingPollingJob;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        this.ruleUpdatingPollingJob = kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11261(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (r0.a() != true) goto L7;
        goto L7
    }

    private final com.obric.memorydata.memory.ui.automemory.settings.e.b toMemoryInfoSection(AutoMemoryRecommendSection r5, String r6) {
        if (r5 == null) goto L5;
        String r0 = r5.getTitle();
        if (r0 == null) goto L9;
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L10:
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r7 = r6;
        if (StringsKt.isBlank(r2) == true) goto L16;
        r7 = r2;
    L16:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r5.getItems(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L26;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L23;
        r4 = null;
    L23:
        if (r4 == null) goto L18;
        r3.add(r4);
        goto L18
    L26:
        return new com.obric.memorydata.memory.ui.automemory.settings.e.b(r8, (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
    L9:
        r1 = null;
        goto L10
    L5:
        return new com.obric.memorydata.memory.ui.automemory.settings.e.b(r6, null, 2, null);
    }

    private final com.obric.memorydata.memory.ui.automemory.settings.e toPresetMemoryInfo(AutoMemoryRecommendItem r15, String r16) {
        AutoMemoryRecommendMemoryInfo r0 = r15.getMemoryInfo();
        String r1 = null;
        if (r0 == null) goto L7;
        String r3 = r0.getTitle();
        if (r3 == null) goto L7;
        String r4 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L8:
        String r5 = "";
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r6) == false) goto L14;
        r6 = r16;
    L14:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L18;
        String r8 = r0.getScene();
        if (r8 == null) goto L18;
    L19:
        if (r8 == null) goto L21;
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L22:
        if (r9 != null) goto L24;
        String r10 = "";
    L25:
        if (r0 == null) goto L28;
        AutoMemoryRecommendSection r11 = r0.getInfo();
        if (r11 == null) goto L28;
    L29:
        com.obric.memorydata.memory.ui.automemory.settings.e.b r12 = toMemoryInfoSection(r11, DEFAULT_INFO_TITLE);
        if (r0 == null) goto L34;
        String r13 = r0.getCustomRule();
        if (r13 == null) goto L34;
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L35:
        if (r14 != null) goto L37;
        r14 = "";
    L37:
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r17) == false) goto L45;
        String r18 = r15.getCustomRule();
        if (r18 == null) goto L42;
        r17 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L43:
        if (r17 != null) goto L45;
        r17 = "";
        goto L45
    L42:
        r17 = null;
    L45:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L50;
        String r20 = r0.getUpdateRule();
        if (r20 == null) goto L50;
        String r21 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L51:
        if (r21 != null) goto L53;
        r21 = "";
    L53:
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r22) == false) goto L61;
        String r23 = r15.getUpdateRule();
        if (r23 == null) goto L58;
        r22 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L59:
        if (r22 != null) goto L61;
        r22 = "";
        goto L61
    L58:
        r22 = null;
    L61:
        String r110 = (String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L66;
        String r24 = r0.getTitleFormat();
        if (r24 == null) goto L66;
        String r25 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L67:
        if (r25 != null) goto L69;
        r25 = "";
    L69:
        CharSequence r26 = (CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r26) == false) goto L77;
        String r27 = r15.getTitleFormat();
        if (r27 == null) goto L74;
        r26 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r27, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L75:
        if (r26 != null) goto L77;
        r26 = "";
        goto L77
    L74:
        r26 = null;
    L77:
        String r111 = (String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L82;
        String r28 = r0.getSubtitleFormat();
        if (r28 == null) goto L82;
        String r29 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L83:
        if (r29 != null) goto L85;
        r29 = "";
    L85:
        CharSequence r30 = (CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r30) == false) goto L93;
        String r31 = r15.getSubtitleFormat();
        if (r31 == null) goto L90;
        r30 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L91:
        if (r30 != null) goto L93;
        r30 = "";
        goto L93
    L90:
        r30 = null;
    L93:
        String r112 = (String) ZeusTransformUtils.preCheckCast(r30, String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L98;
        String r2 = r0.getContentFormat();
        if (r2 == null) goto L98;
        String r32 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L99:
        if (r32 != null) goto L101;
        r32 = "";
    L101:
        CharSequence r33 = (CharSequence) ZeusTransformUtils.preCheckCast(r32, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r33) == false) goto L111;
        String r34 = r15.getContentFormat();
        if (r34 == null) goto L106;
        r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r34, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L106:
        if (r1 == null) goto L109;
        r5 = r1;
    L109:
        r33 = r5;
    L111:
        return new com.obric.memorydata.memory.ui.automemory.settings.e(r7, r10, r12, r19, r110, r111, r112, (String) ZeusTransformUtils.preCheckCast(r33, String.class, "com.obric.memorydata.plugin"));
    L98:
        r32 = null;
    L82:
        r29 = null;
    L66:
        r25 = null;
    L50:
        r21 = null;
    L34:
        r14 = null;
    L28:
        r11 = r15.getInfo();
        goto L29
    L24:
        r10 = r9;
        goto L25
    L21:
        r9 = null;
    L18:
        r8 = r15.getScene();
    L7:
        r4 = null;
        goto L8
    }

    public final void cancelRuleUpdatingLoading() {
        bx r0 = this.ruleUpdatingPollingJob;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.ruleUpdatingPollingJob = null;
        dismissLoading();
    }

    public final void checkUpdatingOnceAndShowLoading() {
        if (((u) ZeusTransformUtils.preCheckCast(this._state.c(), u.class, "com.obric.memorydata.plugin")).b() == true) goto L14;
        bx r0 = this.checkUpdatingJob;
        boolean r1 = true;
        if (r0 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == true) goto L15;
        this.checkUpdatingJob = kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L15:
        return;
    L7:
        if (r0.a() != true) goto L9;
    }

    public final void deleteMyCollection(long r14) {
        ae<u> r0 = this._state;
        String r1 = "";
    L3:
        u r2 = r0.c();
        u r5 = (u) ZeusTransformUtils.preCheckCast(r2, u.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r5.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L4:
        boolean r12 = true;
        if (r4.hasNext() == false) goto L12;
        Object r7 = r4.next();
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
        if (r8.a().getId() != r14) goto L9;
        r1 = r8.a().getTitle();
        r12 = false;
    L9:
        if (r12 == false) goto L4;
        r6.add(r7);
        goto L4
    L12:
        if (r0.a(r2, u.a(r5, null, false, (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), null, 11, null)) == false) goto L3;
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r14, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L24;
        this._events.a(new t.a(r1));
        return;
    }

    public final ai<t> getEvents() {
        return this.events;
    }

    public final ar<u> getState() {
        return this.state;
    }

    public final Object hasReachedManualCollectionLimit(Continuation<? super Boolean> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C11231.class) == false) goto L7;
        C11231 r0 = (C11231) ZeusTransformUtils.preCheckCast(r8, C11231.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L18:
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue() >= 10) goto L22;
        r4 = false;
    L22:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r6 = (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryViewModel$hasReachedManualCollectionLimit$count$1(this, null), Function2.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r9 = kotlinx.coroutines.i.a(r10, r6, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new C11231(this, r8);
        goto L8
    }

    public final void refreshMyCollections() {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11251(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void selectTab(AutoMemoryTab r10) {
        Intrinsics.checkNotNullParameter(r10, "tab");
        ae<u> r9 = this._state;
    L3:
        u r0 = r9.c();
        if (r9.a(r0, u.a((u) ZeusTransformUtils.preCheckCast(r0, u.class, "com.obric.memorydata.plugin"), r10, false, null, null, 14, null)) == false) goto L3;
    }

    public final void updateMyCollectionPausedState(long r45, boolean r47) {
        ae<u> r3 = this._state;
    L3:
        u r4 = r3.c();
        u r7 = (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r7.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L11;
        d r12 = (d) ZeusTransformUtils.preCheckCast(r6.next(), d.class, "com.obric.memorydata.plugin");
        if (r12.a().getId() != r45) goto L9;
        r12 = d.a(r12, MemoryRuleEntity.copy$default(r12.a(), 0, null, null, null, null, null, null, null, false, 0, null, null, null, null, r47, false, false, false, 0, 0, 0, null, null, null, 0, 33538047, null), 0, 2, null);
    L9:
        r10.add(r12);
        goto L5
    L11:
        if (r3.a(r4, u.a(r7, null, false, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), null, 11, null)) == false) goto L3;
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11272(r45, r47, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }
}
