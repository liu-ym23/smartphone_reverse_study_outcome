package com.obric.memorydata.memory.ui.list;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.core.app.FrameMetricsAggregator;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.obric.memorydata.memory.tracker.PendingPersonalInfoTracker;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.union.build.storage.SemanticConfirmationResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#J%\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\u0017H\u0000¢\u0006\u0002\b(J\u001d\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020\u0017H\u0002J$\u0010,\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020\u00172\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020!J\u0006\u00101\u001a\u00020!J\u0006\u00102\u001a\u00020!J\u000e\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u001aJ\b\u00105\u001a\u00020!H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001f0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "repository", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoRepository;", "mutableUiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "errorEvents", "Lkotlinx/coroutines/channels/Channel;", "", "errors", "Lkotlinx/coroutines/flow/Flow;", "getErrors", "()Lkotlinx/coroutines/flow/Flow;", "operatingIds", "", "sheetRequested", "", "ownerId", "seenLatestPendingTime", "", "seenLatestPendingTimeLoaded", "latestPendingTime", "displayRevision", "displaySnapshot", "", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM, "", "item", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "ignore", "onCardClicked", "surface", "Lcom/obric/memorydata/memory/tracker/PendingPersonalInfoTracker$Surface;", "onCardClicked$memory_obricRelease", "onCardShown", "onCardShown$memory_obricRelease", "canTrackCurrentUser", "review", "render", "state", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoRepositoryState;", "openSheet", "closeSheet", "refresh", "markSeen", "renderedRevision", "onCleared", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PendingPersonalInfoViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String SEEN_LATEST_PENDING_TIME_KEY = "personal_info_confidence_seen_latest_pending_time";
    private long displayRevision;
    private List<? extends List<String>> displaySnapshot;
    private final kotlinx.coroutines.channels.i<String> errorEvents;
    private final kotlinx.coroutines.flow.i<String> errors;
    private long latestPendingTime;
    private final kotlinx.coroutines.flow.ae<az> mutableUiState;
    private final Set<String> operatingIds;
    private final String ownerId;
    private final aw repository;
    private long seenLatestPendingTime;
    private boolean seenLatestPendingTimeLoaded;
    private boolean sheetRequested;
    private final kotlinx.coroutines.flow.ar<az> uiState;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PendingPersonalInfoViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PendingPersonalInfoViewModel$1", f = "PendingPersonalInfoViewModel.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PendingPersonalInfoViewModel this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PendingPersonalInfoViewModel$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* synthetic */ class C05761 implements FunctionAdapter, kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ PendingPersonalInfoViewModel f11071a;

            C05761(PendingPersonalInfoViewModel r1) {
                this.f11071a = r1;
            }

            public final Object a(ay r3, Continuation<? super Unit> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                Object r2 = AnonymousClass1.access$invokeSuspend$render(this.f11071a, r3, r5);
                if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r2;
            L6:
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a((ay) ZeusTransformUtils.preCheckCast(r3, ay.class, "com.obric.memorydata.plugin"), r5);
            }

            public final boolean equals(Object r3) {
                if (ZeusTransformUtils.instanceOf(r3, kotlinx.coroutines.flow.j.class) == true) goto L5;
                return false;
            L5:
                if (ZeusTransformUtils.instanceOf(r3, FunctionAdapter.class) == true) goto L7;
                return false;
            L7:
                return Intrinsics.areEqual(((FunctionAdapter) ZeusTransformUtils.preCheckCast(this, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate(), ((FunctionAdapter) ZeusTransformUtils.preCheckCast(r3, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate());
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function<?> getFunctionDelegate() {
                return (Function) ZeusTransformUtils.preCheckCast(new AdaptedFunctionReference(2, this.f11071a, PendingPersonalInfoViewModel.class, "render", "render(Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoRepositoryState;)V", 4), Function.class, "com.obric.memorydata.plugin");
            }

            public final int hashCode() {
                return ((FunctionAdapter) ZeusTransformUtils.preCheckCast(this, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate().hashCode();
            }
        }

        AnonymousClass1(PendingPersonalInfoViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        public static final /* synthetic */ Object access$invokeSuspend$render(PendingPersonalInfoViewModel r2, ay r3, Continuation r4) {
            return invokeSuspend$render(r2, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private static final /* synthetic */ Object invokeSuspend$render(PendingPersonalInfoViewModel r2, ay r3, Continuation r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            PendingPersonalInfoViewModel.access$render(r2, r3);
            return Unit.INSTANCE;
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
            kotlinx.coroutines.flow.ar<ay> r7 = PendingPersonalInfoViewModel.access$getRepository$p(this.this$0).a();
            kotlinx.coroutines.flow.j<? super ay> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05761(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoViewModel$Companion;", "", "<init>", "()V", "SEEN_LATEST_PENDING_TIME_KEY", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((ar) ZeusTransformUtils.preCheckCast(r2, ar.class, "com.obric.memorydata.plugin")).a(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((ar) ZeusTransformUtils.preCheckCast(r3, ar.class, "com.obric.memorydata.plugin")).a(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PendingPersonalInfoViewModel$refresh$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PendingPersonalInfoViewModel$refresh$1", f = "PendingPersonalInfoViewModel.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    static final class C11681 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PendingPersonalInfoViewModel this$0;

        C11681(PendingPersonalInfoViewModel r3, Continuation<? super C11681> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11681(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11681) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11681.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            aw r6 = PendingPersonalInfoViewModel.access$getRepository$p(this.this$0);
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.PendingPersonalInfoViewModel$review$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.PendingPersonalInfoViewModel$review$1", f = "PendingPersonalInfoViewModel.kt", i = {}, l = {81, 82}, m = "invokeSuspend", n = {}, s = {})
    static final class C11691 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $confirm;
        final /* synthetic */ ar $item;
        int label;
        final /* synthetic */ PendingPersonalInfoViewModel this$0;

        C11691(PendingPersonalInfoViewModel r3, ar r4, boolean r5, Continuation<? super C11691> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$item = r4;
            this.$confirm = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11691(this.this$0, this.$item, this.$confirm, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((C11691) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11691.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L12
        L23:
            PendingPersonalInfoViewModel.access$getOperatingIds$p(this.this$0).remove(this.$item.a());
            PendingPersonalInfoViewModel r7 = this.this$0;
            PendingPersonalInfoViewModel.access$render(r7, (ay) ZeusTransformUtils.preCheckCast(PendingPersonalInfoViewModel.access$getRepository$p(r7).a().c(), ay.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L12
        L18:
            SemanticConfirmationResult r9 = (SemanticConfirmationResult) ZeusTransformUtils.preCheckCast(r8, SemanticConfirmationResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            if (r9.getSuccess() == true) goto L23;
            kotlinx.coroutines.channels.i r2 = PendingPersonalInfoViewModel.access$getErrorEvents$p(this.this$0);     // Catch: Throwable -> L12
            String r10 = r9.getCode();     // Catch: Throwable -> L12
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            this.label = 2;     // Catch: Throwable -> L12
            if (r2.send(r10, r3) != r0) goto L23;
            return r0;
        L14:
            ResultKt.throwOnFailure(r8);
            aw r11 = PendingPersonalInfoViewModel.access$getRepository$p(this.this$0);     // Catch: Throwable -> L12
            ar r4 = this.$item;     // Catch: Throwable -> L12
            boolean r5 = this.$confirm;     // Catch: Throwable -> L12
            Continuation<? super SemanticConfirmationResult> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            this.label = 1;     // Catch: Throwable -> L12
            r8 = r11.a(r4, r5, r6);     // Catch: Throwable -> L12
            if (r8 != r0) goto L18;
            return r0;
        L12:
            th = move-exception;
            PendingPersonalInfoViewModel.access$getOperatingIds$p(this.this$0).remove(this.$item.a());
            PendingPersonalInfoViewModel r12 = this.this$0;
            PendingPersonalInfoViewModel.access$render(r12, (ay) ZeusTransformUtils.preCheckCast(PendingPersonalInfoViewModel.access$getRepository$p(r12).a().c(), ay.class, "com.obric.memorydata.plugin"));
            throw th;
        }
    }

    static {
        Companion = new a(null);
    }

    public PendingPersonalInfoViewModel() {
        this.repository = ax.f11215a.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")));
        kotlinx.coroutines.flow.ae<az> r0 = kotlinx.coroutines.flow.at.a(new az(null, false, 0, 0, null, false, false, 127, null));
        this.mutableUiState = r0;
        this.uiState = kotlinx.coroutines.flow.k.a(r0);
        kotlinx.coroutines.channels.i<String> r1 = kotlinx.coroutines.channels.l.a(-2, null, null, 6, null);
        this.errorEvents = r1;
        this.errors = kotlinx.coroutines.flow.k.a((kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin"));
        this.operatingIds = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        this.ownerId = UserSettings.INSTANCE.getUserId();
        this.displaySnapshot = CollectionsKt.emptyList();
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ kotlinx.coroutines.channels.i access$getErrorEvents$p(PendingPersonalInfoViewModel r0) {
        return r0.errorEvents;
    }

    public static final /* synthetic */ Set access$getOperatingIds$p(PendingPersonalInfoViewModel r0) {
        return r0.operatingIds;
    }

    public static final /* synthetic */ aw access$getRepository$p(PendingPersonalInfoViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ void access$render(PendingPersonalInfoViewModel r0, ay r1) {
        r0.render(r1);
    }

    private final boolean canTrackCurrentUser() {
        if (((az) ZeusTransformUtils.preCheckCast(this.mutableUiState.c(), az.class, "com.obric.memorydata.plugin")).b() == true) goto L5;
    L9:
        return false;
    L5:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L9;
        if (Intrinsics.areEqual(this.ownerId, UserSettings.INSTANCE.getUserId()) == false) goto L9;
        return true;
    }

    private final void render(ay r31) {
        if (r31.e() == null) goto L8;
        if (Intrinsics.areEqual(r31.e(), ((az) ZeusTransformUtils.preCheckCast(this.mutableUiState.c(), az.class, "com.obric.memorydata.plugin")).e()) == true) goto L8;
        this.errorEvents.mo54trySendJP2dKIU(r31.e());
    L8:
        if (r31.c() == true) goto L10;
    L16:
        boolean r1 = false;
    L17:
        List r5 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r31.a(), Iterable.class, "com.obric.memorydata.plugin"), 20);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r6.hasNext() == true) goto L20;
        Comparable r7 = null;
    L27:
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(r7, Long.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L30;
        long r9 = r8.longValue();
    L31:
        long r10 = RangesKt.coerceAtLeast(r9, 0);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L33:
        if (r13.hasNext() == false) goto L35;
        ar r14 = (ar) ZeusTransformUtils.preCheckCast(r13.next(), ar.class, "com.obric.memorydata.plugin");
        r12.add(CollectionsKt.listOf(new String[]{r14.a(), r14.c(), r14.d()}));
        goto L33
    L35:
        List<? extends List<String>> r15 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        if (r1 == true) goto L38;
    L44:
        if (r1 == true) goto L46;
    L50:
        kotlinx.coroutines.flow.ae<az> r16 = this.mutableUiState;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r31.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L52:
        if (r19.hasNext() == false) goto L54;
        ar r110 = (ar) ZeusTransformUtils.preCheckCast(r19.next(), ar.class, "com.obric.memorydata.plugin");
        r18.add(ar.a(r110, null, null, null, null, null, 0, 0, 0, null, this.operatingIds.contains(r110.a()), FrameMetricsAggregator.EVERY_DURATION, null));
        goto L52
    L54:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        int r21 = r31.b();
        String r111 = r31.e();
        long r22 = this.displayRevision;
        if (r1 == true) goto L57;
    L63:
        boolean r112 = false;
    L64:
        if (r1 == true) goto L66;
    L72:
        boolean r113 = false;
    L73:
        r16.b(new az(r20, r1, r21, r22, r111, r112, r113));
        if (r1 == false) goto L84;
        this.sheetRequested = false;
        return;
    L84:
        return;
    L66:
        if (this.seenLatestPendingTimeLoaded == false) goto L72;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r31.a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L72;
        if (this.latestPendingTime <= this.seenLatestPendingTime) goto L72;
        r113 = true;
        goto L73
    L57:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r31.a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L63;
        if (this.sheetRequested == false) goto L61;
    L62:
        r112 = true;
        goto L64
    L61:
        if (((az) ZeusTransformUtils.preCheckCast(this.mutableUiState.c(), az.class, "com.obric.memorydata.plugin")).f() == false) goto L63;
    L46:
        if (this.seenLatestPendingTimeLoaded == true) goto L50;
        IStore r23 = StoreManager.INSTANCE.getPersonalStore();
        if (r23 == null) goto L50;
        this.seenLatestPendingTime = r23.getLong(SEEN_LATEST_PENDING_TIME_KEY, 0);
        this.seenLatestPendingTimeLoaded = true;
        goto L50
    L38:
        if (this.displayRevision != 0) goto L40;
    L43:
        this.displaySnapshot = r15;
        this.latestPendingTime = r10;
        this.displayRevision++;
        goto L44
    L40:
        if (Intrinsics.areEqual(r15, this.displaySnapshot) == false) goto L43;
        if (r10 == this.latestPendingTime) goto L44;
    L30:
        r9 = 0;
        goto L31
    L20:
        Comparable r24 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ar) ZeusTransformUtils.preCheckCast(r6.next(), ar.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin");
    L22:
        if (r6.hasNext() == false) goto L26;
        Comparable r25 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ar) ZeusTransformUtils.preCheckCast(r6.next(), ar.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin");
        if (r24.compareTo(r25) >= 0) goto L22;
        r24 = r25;
        goto L22
    L26:
        r7 = r24;
        goto L27
    L10:
        if (r31.d() == false) goto L16;
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L16;
        if (Intrinsics.areEqual(this.ownerId, UserSettings.INSTANCE.getUserId()) == false) goto L16;
        r1 = true;
        goto L17
    }

    private final void review(ar r9, boolean r10, PendingPersonalInfoTracker.Surface r11) {
        if (this.operatingIds.add(r9.a()) == true) goto L5;
        return;
    L5:
        if (r11 != null) goto L7;
    L9:
        render((ay) ZeusTransformUtils.preCheckCast(this.repository.a().c(), ay.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11691(this, r9, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L7:
        if (canTrackCurrentUser() == false) goto L9;
        PendingPersonalInfoTracker.f10529a.a(r9.b(), r11, r10);
        goto L9
    }

    static /* synthetic */ void review$default(PendingPersonalInfoViewModel r0, ar r1, boolean r2, PendingPersonalInfoTracker.Surface r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.review(r1, r2, r3);
    }

    public final void closeSheet() {
        this.sheetRequested = false;
        kotlinx.coroutines.flow.ae<az> r12 = this.mutableUiState;
        r12.b(az.a((az) ZeusTransformUtils.preCheckCast(r12.c(), az.class, "com.obric.memorydata.plugin"), null, false, 0, 0, null, false, false, 95, null));
    }

    public final void confirm(ar r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        review$default(this, r8, true, null, 4, null);
    }

    public final kotlinx.coroutines.flow.i<String> getErrors() {
        return this.errors;
    }

    public final kotlinx.coroutines.flow.ar<az> getUiState() {
        return this.uiState;
    }

    public final void ignore(ar r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        review$default(this, r8, false, null, 4, null);
    }

    public final void markSeen(long r4) {
        if (((az) ZeusTransformUtils.preCheckCast(this.mutableUiState.c(), az.class, "com.obric.memorydata.plugin")).b() == true) goto L5;
        return;
    L5:
        if (r4 == this.displayRevision) goto L7;
        return;
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(this.ownerId, UserSettings.INSTANCE.getUserId()) == true) goto L12;
        return;
    L12:
        if (this.seenLatestPendingTime != this.latestPendingTime) goto L14;
        return;
    L14:
        IStore r5 = StoreManager.INSTANCE.getPersonalStore();
        if (r5 != null) goto L18;
        return;
    L18:
        if (r5.syncSave(SEEN_LATEST_PENDING_TIME_KEY, this.latestPendingTime) == true) goto L20;
        return;
    L20:
        this.seenLatestPendingTime = this.latestPendingTime;
        render((ay) ZeusTransformUtils.preCheckCast(this.repository.a().c(), ay.class, "com.obric.memorydata.plugin"));
    }

    public final void onCardClicked$memory_obricRelease(ar r2, PendingPersonalInfoTracker.Surface r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "surface");
        review(r2, r4, r3);
    }

    public final void onCardShown$memory_obricRelease(ar r7, PendingPersonalInfoTracker.Surface r8) {
        Intrinsics.checkNotNullParameter(r7, "item");
        Intrinsics.checkNotNullParameter(r8, "surface");
        az r0 = (az) ZeusTransformUtils.preCheckCast(this.mutableUiState.c(), az.class, "com.obric.memorydata.plugin");
        if (canTrackCurrentUser() == false) goto L27;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r0.a(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L7;
    L9:
        Iterator r9 = r6.iterator();
    L11:
        if (r9.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(((ar) ZeusTransformUtils.preCheckCast(r9.next(), ar.class, "com.obric.memorydata.plugin")).a(), r7.a()) == false) goto L11;
        boolean r10 = false;
    L15:
        if (r10 == false) goto L17;
        return;
    L17:
        if (r8 != PendingPersonalInfoTracker.Surface.CONSUME_DIALOG) goto L20;
        r3 = true;
    L20:
        if (r3 != r0.f()) goto L29;
        PendingPersonalInfoTracker.f10529a.a(r7.b(), r8, r0.c());
        return;
    L29:
        return;
    L8:
        r10 = true;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.repository.b();
        super.onCleared();
    }

    public final void openSheet() {
        this.sheetRequested = true;
        render((ay) ZeusTransformUtils.preCheckCast(this.repository.a().c(), ay.class, "com.obric.memorydata.plugin"));
    }

    public final void refresh() {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11681(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
