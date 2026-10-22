package com.obric.assistant.settings.memory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.nova.NovaApplication;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.d1;
import com.obric.cae.libs.useraware.ApWakeEvent;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0019J*\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0019J\u001e\u0010\u001d\u001a\u00020\u00062\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002J,\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020\u00172\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002JH\u0010$\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\"0%2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00172\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J.\u0010*\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00172\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002J,\u0010,\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0019H\u0002J@\u0010,\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0019H\u0002J$\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010/\u001a\u00020\u00172\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u001fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricReferenceMemorySettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "personalContextSettingsDelegate", "Lcom/obric/assistant/settings/ObricPersonalContextSettingApiDelegate;", "getPersonalContextSettingsDelegate", "()Lcom/obric/assistant/settings/ObricPersonalContextSettingApiDelegate;", "personalContextSettingsDelegate$delegate", "Lkotlin/Lazy;", "setSwitchJob", "Lkotlinx/coroutines/Job;", "refresh", "", "setMainSwitchEnabled", "enabled", "", "onResult", "Lkotlin/Function1;", "setChildSwitchEnabled", "storageKey", "", "buildState", "overrideValues", "", "buildChildRows", "", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryRow;", "mainSwitchEnabled", "addMemoryRow", "", "id", "title", "subtitle", "isMainSwitchEnabled", "getSwitchEnabled", "defVal", "setSwitchEnabled", "buildChildSwitchTargetValues", "buildMainSwitchTargetValues", "hasEnabledChildSwitch", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricReferenceMemorySettingViewModel extends ViewModel {
    private final z0<f0> _uiState;
    private final Lazy personalContextSettingsDelegate$delegate;
    private Job setSwitchJob;
    private final i1<f0> uiState;

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$refresh$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$refresh$1", f = "ObricReferenceMemorySettingViewModel.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$refresh$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$refresh$1$1", f = "ObricReferenceMemorySettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
            int label;
            final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

            public C00211(ObricReferenceMemorySettingViewModel r1, Continuation<? super C00211> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00211(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super f0> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                return ObricReferenceMemorySettingViewModel.buildState$default(this.this$0, null, 1, null);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ObricReferenceMemorySettingViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            z0 r2 = (z0) this.L$0;
            ResultKt.throwOnFailure(r7);
        L12:
            r2.setValue(r7);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            z0 r8 = ObricReferenceMemorySettingViewModel.access$get_uiState$p(this.this$0);
            CoroutineDispatcher r3 = Dispatchers.getIO();
            C00211 r4 = new C00211(this.this$0, null);
            this.L$0 = r8;
            this.label = 1;
            Object r5 = BuildersKt.withContext(r3, r4, this);
            if (r5 != r0) goto L11;
            return r0;
        L11:
            r2 = r8;
            r7 = r5;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1", f = "ObricReferenceMemorySettingViewModel.kt", i = {2}, l = {ApWakeEvent.OTHER_END, 144, 147}, m = "invokeSuspend", n = {WindowEvent.WindowOpenPerfResult.SUCCESS}, s = {"Z$0"})
    public static final class C00841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        final /* synthetic */ Map<String, Boolean> $overrideValues;
        final /* synthetic */ String $storageKey;
        Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$1", f = "ObricReferenceMemorySettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
            final /* synthetic */ Map<String, Boolean> $overrideValues;
            int label;
            final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

            public C00221(ObricReferenceMemorySettingViewModel r1, Map<String, Boolean> r2, Continuation<? super C00221> r3) {
                this.this$0 = r1;
                this.$overrideValues = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00221(this.this$0, this.$overrideValues, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super f0> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return ObricReferenceMemorySettingViewModel.access$buildState(this.this$0, this.$overrideValues);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/memory/ObricReferenceMemoryUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$2", f = "ObricReferenceMemorySettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
            int label;
            final /* synthetic */ ObricReferenceMemorySettingViewModel this$0;

            public AnonymousClass2(ObricReferenceMemorySettingViewModel r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super f0> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                return ObricReferenceMemorySettingViewModel.buildState$default(this.this$0, null, 1, null);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C00841(ObricReferenceMemorySettingViewModel r1, Function1<? super Boolean, Unit> r2, Map<String, Boolean> r3, String r4, boolean r5, Continuation<? super C00841> r6) {
            this.this$0 = r1;
            this.$onResult = r2;
            this.$overrideValues = r3;
            this.$storageKey = r4;
            this.$enabled = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C00841(this.this$0, this.$onResult, this.$overrideValues, this.$storageKey, this.$enabled, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            boolean r2 = this.Z$0;
            z0 r3 = (z0) this.L$0;
            ResultKt.throwOnFailure(r10);
        L22:
            r3.setValue(r10);
            this.$onResult.invoke(Boxing.boxBoolean(r2));
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r10);
        L18:
            boolean r11 = ((Boolean) r10).booleanValue();
            r3 = ObricReferenceMemorySettingViewModel.access$get_uiState$p(this.this$0);
            CoroutineDispatcher r4 = Dispatchers.getIO();
            AnonymousClass2 r5 = new AnonymousClass2(this.this$0, null);
            this.L$0 = r3;
            this.Z$0 = r11;
            this.label = 3;
            Object r6 = BuildersKt.withContext(r4, r5, this);
            if (r6 != r0) goto L21;
            return r0;
        L21:
            r2 = r11;
            r10 = r6;
            goto L22
        L11:
            z0 r7 = (z0) this.L$0;
            ResultKt.throwOnFailure(r10);
        L15:
            r7.setValue(r10);
            CoroutineDispatcher r12 = Dispatchers.getIO();
            ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$success$1 r8 = new ObricReferenceMemorySettingViewModel$setSwitchEnabled$1$success$1(this.this$0, this.$storageKey, this.$enabled, null);
            this.L$0 = null;
            this.label = 2;
            r10 = BuildersKt.withContext(r12, r8, this);
            if (r10 != r0) goto L18;
            return r0;
        L12:
            ResultKt.throwOnFailure(r10);
            r7 = ObricReferenceMemorySettingViewModel.access$get_uiState$p(this.this$0);
            CoroutineDispatcher r13 = Dispatchers.getIO();
            C00221 r9 = new C00221(this.this$0, this.$overrideValues, null);
            this.L$0 = r7;
            this.label = 1;
            r10 = BuildersKt.withContext(r13, r9, this);
            if (r10 != r0) goto L15;
            return r0;
        }
    }

    public static /* synthetic */ ObricPersonalContextSettingApiDelegate yo() {
        return personalContextSettingsDelegate_delegate$lambda$0();
    }

    private final ObricPersonalContextSettingApiDelegate getPersonalContextSettingsDelegate() {
        return (ObricPersonalContextSettingApiDelegate) this.personalContextSettingsDelegate$delegate.getValue();
    }

    private final boolean isMainSwitchEnabled() {
        return getSwitchEnabled$default(this, "reference_memory", false, null, 4, null);
    }

    public ObricReferenceMemorySettingViewModel() {
        StateFlowImpl r0 = j1.a(new f0(0));
        this._uiState = r0;
        this.uiState = r0;
        this.personalContextSettingsDelegate$delegate = LazyKt.lazy(new e0());
    }

    public final void refresh() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
    }

    private static final ObricPersonalContextSettingApiDelegate personalContextSettingsDelegate_delegate$lambda$0() {
        return ObricPersonalContextSettingApiDelegate.b;
    }

    public final i1<f0> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ ObricPersonalContextSettingApiDelegate access$getPersonalContextSettingsDelegate(ObricReferenceMemorySettingViewModel r0) {
        return r0.getPersonalContextSettingsDelegate();
    }

    public static final /* synthetic */ z0 access$get_uiState$p(ObricReferenceMemorySettingViewModel r0) {
        return r0._uiState;
    }

    private final Map<String, Boolean> buildMainSwitchTargetValues(boolean r9) {
        boolean r2 = isMainSwitchEnabled();
        if (r9 == false) goto L7;
        Boolean r3 = Boolean.TRUE;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("reference_memory", r3), TuplesKt.to("reference_memory_personal_info", r3)});
    L7:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("reference_memory", Boolean.FALSE), TuplesKt.to("reference_memory_personal_info", Boolean.valueOf(getSwitchEnabled$default(this, "reference_memory_personal_info", r2, null, 4, null)))});
    }

    private final f0 buildState(Map<String, Boolean> r12) {
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        NovaApplication r1 = r0.getApplication();
        boolean r2 = getSwitchEnabled("reference_memory", false, r12);
        List r3 = CollectionsKt.createListBuilder();
        r3.add(new y("reference_memory", r1.getString(2131912558), r1.getString(2131912561), r2, true, ObricReferenceMemorySwitchGroup.MAIN));
        r3.addAll(buildChildRows(r2, r12));
        return new f0(CollectionsKt.build(r3));
    }

    private final boolean hasEnabledChildSwitch(Map<String, Boolean> r3) {
        return getSwitchEnabled("reference_memory_personal_info", getSwitchEnabled("reference_memory", false, r3), r3);
    }

    public static final /* synthetic */ f0 access$buildState(ObricReferenceMemorySettingViewModel r0, Map r1) {
        return r0.buildState(r1);
    }

    private final List<y> buildChildRows(boolean r10, Map<String, Boolean> r11) {
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        NovaApplication r1 = r0.getApplication();
        List<y> r8 = CollectionsKt.createListBuilder();
        addMemoryRow(r8, "reference_memory_personal_info", r1.getString(2131912563), r1.getString(2131912562), r10, r11);
        return CollectionsKt.build(r8);
    }

    private final Map<String, Boolean> buildChildSwitchTargetValues(String r3, boolean r4) {
        Map<String, Boolean> r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r3, Boolean.valueOf(r4))});
        if (r4 == false) goto L5;
    L7:
        return r5;
    L5:
        if (hasEnabledChildSwitch(r5) == true) goto L7;
        r5.put("reference_memory", Boolean.FALSE);
        goto L7
    }

    public final void setMainSwitchEnabled(boolean r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onResult");
        setSwitchEnabled("reference_memory", r3, buildMainSwitchTargetValues(r3), r4);
    }

    private final boolean getSwitchEnabled(String r2, boolean r3, Map<String, Boolean> r4) {
        Boolean r5 = r4.get(r2);
        if (r5 != null) goto L5;
        d1 r6 = getPersonalContextSettingsDelegate().f();
        if (Intrinsics.areEqual(r2, "reference_memory") == false) goto L11;
        if (r6 != null) goto L16;
        return r3;
    L16:
        return r6.a;
    L11:
        if (Intrinsics.areEqual(r2, "reference_memory_personal_info") == false) goto L17;
        if (r6 != null) goto L14;
        return r3;
    L14:
        return r6.b;
    L17:
        return r3;
    L5:
        return r5.booleanValue();
    }

    private final void setSwitchEnabled(String r2, boolean r3, Function1<? super Boolean, Unit> r4) {
        setSwitchEnabled(r2, r3, MapsKt.mapOf(TuplesKt.to(r2, Boolean.valueOf(r3))), r4);
    }

    public final void setChildSwitchEnabled(String r2, boolean r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "storageKey");
        Intrinsics.checkNotNullParameter(r4, "onResult");
        if (isMainSwitchEnabled() == true) goto L6;
        refresh();
        r4.invoke(Boolean.FALSE);
        return;
    L6:
        setSwitchEnabled(r2, r3, buildChildSwitchTargetValues(r2, r3), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ f0 buildState$default(ObricReferenceMemorySettingViewModel r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = MapsKt.emptyMap();
    L6:
        return r0.buildState(r1);
    }

    private final void setSwitchEnabled(String r15, boolean r16, Map<String, Boolean> r17, Function1<? super Boolean, Unit> r18) {
        Job r0 = this.setSwitchJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.setSwitchJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C00841(this, r18, r17, r15, r16, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List buildChildRows$default(ObricReferenceMemorySettingViewModel r0, boolean r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = MapsKt.emptyMap();
    L6:
        return r0.buildChildRows(r1, r2);
    }

    private final void addMemoryRow(List<y> r9, String r10, String r11, String r12, boolean r13, Map<String, Boolean> r14) {
        r9.add(new y(r10, r11, r12, getSwitchEnabled(r10, r13, r14), r13, ObricReferenceMemorySwitchGroup.CHILD));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean getSwitchEnabled$default(ObricReferenceMemorySettingViewModel r0, String r1, boolean r2, Map r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = MapsKt.emptyMap();
    L6:
        return r0.getSwitchEnabled(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addMemoryRow$default(ObricReferenceMemorySettingViewModel r7, List r8, String r9, String r10, String r11, boolean r12, Map r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r13 = MapsKt.emptyMap();
    L5:
        r7.addMemoryRow(r8, r9, r10, r11, r12, r13);
    }
}
