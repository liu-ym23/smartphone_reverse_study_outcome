package com.obric.memorydata.memory.ui.settings;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.appcontext.IAppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.ui.IdentityController;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0012H\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "processIntent", MemorySourceLinkType.INTENT, "Lcom/obric/memorydata/memory/ui/settings/MemorySettingsIntent;", "updateJoinInUXPState", "", "updateNeedIdentifyAuthState", "refresh", "initializeMemorySettingsState", "isLifelogInstalled", "initPermissionLogic", "shouldShowUxpSwitch", "permissionState", "Lcom/obric/memorydata/memory/lab/AILabPermissionState;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemorySettingsViewModel extends ViewModel implements DefaultLifecycleObserver {
    public static final a Companion = null;
    private static final String TAG = "MemorySettingsViewModel";
    private final ae<k> _state;
    private final ar<k> state;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/MemorySettingsViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsViewModel$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsViewModel$init$1", f = "MemorySettingsViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsViewModel this$0;

        AnonymousClass1(MemorySettingsViewModel r3, Continuation<? super AnonymousClass1> r4) {
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<Boolean> r7 = RecommendApi.INSTANCE.screenObservationEnabled();
            final MemorySettingsViewModel r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C06161(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsViewModel$init$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsViewModel$init$2", f = "MemorySettingsViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsViewModel this$0;

        AnonymousClass2(MemorySettingsViewModel r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
            ar<Boolean> r7 = l.f11479a.a().d();
            final MemorySettingsViewModel r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Boolean> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.MemorySettingsViewModel$init$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.MemorySettingsViewModel$init$3", f = "MemorySettingsViewModel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemorySettingsViewModel this$0;

        AnonymousClass3(MemorySettingsViewModel r3, Continuation<? super AnonymousClass3> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            ar<com.obric.memorydata.memory.lab.d> r7 = AILabPermissionRepository.f10236a.a();
            final MemorySettingsViewModel r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super com.obric.memorydata.memory.lab.d> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemorySettingsViewModel() {
        ae<k> r0 = at.a(initializeMemorySettingsState());
        this._state = r0;
        this.state = kotlinx.coroutines.flow.k.a(r0);
    }

    public static final /* synthetic */ ae access$get_state$p(MemorySettingsViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ boolean access$shouldShowUxpSwitch(MemorySettingsViewModel r0, com.obric.memorydata.memory.lab.d r1) {
        return r0.shouldShowUxpSwitch(r1);
    }

    private final void initPermissionLogic() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "开始初始化AI Lab权限检查", false, 4, null);     // Catch: Exception -> L5
        com.obric.memorydata.memory.lab.a.a(com.obric.memorydata.memory.lab.a.f10241a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, 2, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "初始化权限逻辑失败:" + e.getMessage(), null, 4, null);
    }

    private final k initializeMemorySettingsState() {
        return new k(IdentityController.f12979a.c(), ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().j().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().n().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), false, ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().c().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), isLifelogInstalled(), ((com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin")).c(), shouldShowUxpSwitch((com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin")), 16, null);
    }

    private final boolean isLifelogInstalled() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo("com.obric.lifelog", 0) != null) goto L6;
        return false;
    L6:
        return true;
    L11:
        return false;
    }

    private final boolean shouldShowUxpSwitch(com.obric.memorydata.memory.lab.d r12) {
        boolean r11 = AppContext.INSTANCE.isDebug();
        String r0 = AppContext.INSTANCE.getServerDeviceId();
        boolean r4 = true;
        String r1 = IAppContext.a.a((IAppContext) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE, IAppContext.class, "com.obric.memorydata.plugin"), null, 1, null);
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        IRecommendSettings r2 = AppSettingsManager.INSTANCE.getRecommendSettings();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
    L13:
        boolean r3 = false;
    L15:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L20;
    L22:
        boolean r7 = false;
    L23:
        boolean r13 = AILabPermissionRepository.f10236a.e(r12);
        if (r11 == true) goto L30;
        if (r3 == true) goto L30;
        if (r7 == true) goto L30;
        if (r13 == true) goto L30;
        r4 = false;
    L30:
        List r8 = CollectionsKt.createListBuilder();
        if (r11 == false) goto L33;
        r8.add("debug");
    L33:
        if (r3 == false) goto L35;
        r8.add("did");
    L35:
        if (r7 == false) goto L37;
        r8.add("osDeviceId");
    L37:
        if (r13 == false) goto L39;
        r8.add("labPermission");
    L39:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "shouldShowUxpSwitch: show=" + r4 + ", reasons=" + CollectionsKt.build(r8), false, 4, null);
        return r4;
    L20:
        if (r2.getUxpEnableDid().contains(r1) == false) goto L22;
        r7 = true;
        goto L23
    L17:
        r6 = false;
        goto L18
    L11:
        if (r2.getUxpEnableDid().contains(r0) == false) goto L13;
        r3 = true;
        goto L15
    L8:
        r5 = false;
        goto L9
    }

    private final void updateJoinInUXPState(boolean r17) {
        l.f11479a.a().c(r17);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "updateJoinInUXPState state = " + r17, false, 4, null);
        ae<k> r14 = this._state;
    L3:
        k r15 = r14.c();
        if (r14.a(r15, k.a((k) ZeusTransformUtils.preCheckCast(r15, k.class, "com.obric.memorydata.plugin"), false, r17, false, false, false, false, false, false, false, 509, null)) == false) goto L3;
    }

    private final void updateNeedIdentifyAuthState(boolean r15) {
        IdentityController.f12979a.a(r15);
        ae<k> r14 = this._state;
    L3:
        k r0 = r14.c();
        if (r14.a(r0, k.a((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.memorydata.plugin"), r15, false, false, false, false, false, false, false, false, TypedValues.PositionType.TYPE_POSITION_TYPE, null)) == false) goto L3;
    }

    public final ar<k> getState() {
        return this.state;
    }

    public final void init() {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        initPermissionLogic();
    }

    public final void processIntent(j r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        if (ZeusTransformUtils.instanceOf(r3, j.a.class) == false) goto L6;
        updateJoinInUXPState(((j.a) ZeusTransformUtils.preCheckCast(r3, j.a.class, "com.obric.memorydata.plugin")).a());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, j.b.class) == false) goto L10;
        updateNeedIdentifyAuthState(((j.b) ZeusTransformUtils.preCheckCast(r3, j.b.class, "com.obric.memorydata.plugin")).a());
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void refresh() {
        l.f11479a.a().z();
        ae<k> r1 = this._state;
    L3:
        k r2 = r1.c();
        if (r1.a(r2, k.a((k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.memorydata.plugin"), false, false, ((Boolean) ZeusTransformUtils.preCheckCast(RecommendApi.INSTANCE.screenObservationEnabled().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), l.f11479a.a().x(), ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().d().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().c().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), isLifelogInstalled(), false, false, 387, null)) == false) goto L3;
    }
}
