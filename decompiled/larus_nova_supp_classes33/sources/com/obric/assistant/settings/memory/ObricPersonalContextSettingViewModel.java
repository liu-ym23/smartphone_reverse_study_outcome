package com.obric.assistant.settings.memory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.permission.IObricPermissionService$Companion;
import com.obric.assistant.settings.AILabSettingItem;
import com.obric.assistant.settings.IAILabService;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.ToggleName;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u001d\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fH\u0082@¢\u0006\u0002\u0010 J\u001a\u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010\"\u001a\u00020#H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006-"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricPersonalContextSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/settings/memory/ObricPersonalContextUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "personalContextSettingsDelegate", "Lcom/obric/assistant/settings/ObricPersonalContextSettingApiDelegate;", "getPersonalContextSettingsDelegate", "()Lcom/obric/assistant/settings/ObricPersonalContextSettingApiDelegate;", "personalContextSettingsDelegate$delegate", "Lkotlin/Lazy;", "aiLabService", "Lcom/obric/assistant/settings/IAILabService;", "getAiLabService", "()Lcom/obric/assistant/settings/IAILabService;", "aiLabService$delegate", "refresh", "", "buildState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildDataSourceRows", "", "Lcom/obric/assistant/settings/memory/ObricPersonalContextRow;", "addMemoryRows", "rows", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memoryRow", "toggleName", "Lcom/obric/assistant/settings/ToggleName;", "title", "", "dataSourceRow", "Lcom/obric/assistant/settings/memory/ObricPersonalContextRow$DataSourceItem;", "getAlbumEndText", "getEndText", "enabled", "", "followOldMemorySwitch", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPersonalContextSettingViewModel extends ViewModel {
    private final z0<x> _uiState;
    private final Lazy aiLabService$delegate;
    private final Lazy personalContextSettingsDelegate$delegate;
    private final i1<x> uiState;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ToggleName.values().length];
            r0[ToggleName.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[ToggleName.EVENT_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L37:
            r0[ToggleName.COLLECTION_MEMORY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[ToggleName.PERSONAL_INFO_MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L31:
            r0[ToggleName.SCREEN_MEMORY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L23:
            r0[ToggleName.HEARING_MEMORY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[IObricPermissionService$Companion.ObricPermissionStatus.values().length];
            r1[IObricPermissionService$Companion.ObricPermissionStatus.GRANTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L33:
            r1[IObricPermissionService$Companion.ObricPermissionStatus.LIMITED_GRANTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L13:
            b = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel$addMemoryRows$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel", f = "ObricPersonalContextSettingViewModel.kt", i = {0, 1}, l = {95, ErrorCode.UNREGISTER_ERROR}, m = "addMemoryRows", n = {"rows", "rows"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricPersonalContextSettingViewModel this$0;

        public AnonymousClass1(ObricPersonalContextSettingViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ObricPersonalContextSettingViewModel.access$addMemoryRows(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel$buildDataSourceRows$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel", f = "ObricPersonalContextSettingViewModel.kt", i = {0}, l = {76}, m = "buildDataSourceRows", n = {"rows"}, s = {"L$0"})
    public static final class C00811 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricPersonalContextSettingViewModel this$0;

        public C00811(ObricPersonalContextSettingViewModel r1, Continuation<? super C00811> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ObricPersonalContextSettingViewModel.access$buildDataSourceRows(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel$buildState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel", f = "ObricPersonalContextSettingViewModel.kt", i = {}, l = {58}, m = "buildState", n = {}, s = {})
    public static final class C00821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricPersonalContextSettingViewModel this$0;

        public C00821(ObricPersonalContextSettingViewModel r1, Continuation<? super C00821> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ObricPersonalContextSettingViewModel.access$buildState(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel$refresh$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel$refresh$1", f = "ObricPersonalContextSettingViewModel.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ObricPersonalContextSettingViewModel this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel$refresh$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/memory/ObricPersonalContextUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.memory.ObricPersonalContextSettingViewModel$refresh$1$1", f = "ObricPersonalContextSettingViewModel.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super x>, Object> {
            int label;
            final /* synthetic */ ObricPersonalContextSettingViewModel this$0;

            public C00201(ObricPersonalContextSettingViewModel r1, Continuation<? super C00201> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00201(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super x> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L11:
                return r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                ObricPersonalContextSettingViewModel r5 = this.this$0;
                this.label = 1;
                r4 = ObricPersonalContextSettingViewModel.access$buildState(r5, this);
                if (r4 != r0) goto L11;
                return r0;
            }
        }

        public C00831(ObricPersonalContextSettingViewModel r1, Continuation<? super C00831> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00831(this.this$0, r3);
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
            z0 r8 = ObricPersonalContextSettingViewModel.access$get_uiState$p(this.this$0);
            CoroutineDispatcher r3 = Dispatchers.getIO();
            C00201 r4 = new C00201(this.this$0, null);
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

    public static /* synthetic */ ObricPersonalContextSettingApiDelegate Mo() {
        return personalContextSettingsDelegate_delegate$lambda$0();
    }

    public static /* synthetic */ IAILabService yo() {
        return aiLabService_delegate$lambda$1();
    }

    private static final IAILabService aiLabService_delegate$lambda$1() {
        return (IAILabService) ServiceManager.get().getService(IAILabService.class);
    }

    private final IAILabService getAiLabService() {
        return (IAILabService) this.aiLabService$delegate.getValue();
    }

    private final String getAlbumEndText() {
        IObricPermissionService r0 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r0 == null) goto L5;
        IObricPermissionService$Companion.ObricPermissionStatus r1 = r0.h();
    L6:
        if (r1 != null) goto L8;
        int r2 = -1;
    L10:
        if (r2 != 1) goto L12;
        String r3 = AppHost.a.getApplication().getString(2131911961);
        Intrinsics.checkNotNull(r3);
        return r3;
    L12:
        if (r2 != 2) goto L17;
        String r4 = AppHost.a.getApplication().getString(2131912201);
        Intrinsics.checkNotNull(r4);
        return r4;
    L17:
        return AppHost.a.getApplication().getString(2131912176);
    L8:
        r2 = a.b[r1.ordinal()];
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final ObricPersonalContextSettingApiDelegate getPersonalContextSettingsDelegate() {
        return (ObricPersonalContextSettingApiDelegate) this.personalContextSettingsDelegate$delegate.getValue();
    }

    public ObricPersonalContextSettingViewModel() {
        StateFlowImpl r0 = j1.a(new x(0));
        this._uiState = r0;
        this.uiState = r0;
        this.personalContextSettingsDelegate$delegate = LazyKt.lazy(new v());
        this.aiLabService$delegate = LazyKt.lazy(new w());
        refresh();
    }

    public final void refresh() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C00831(this, null), 2, null);
    }

    private static final ObricPersonalContextSettingApiDelegate personalContextSettingsDelegate_delegate$lambda$0() {
        return ObricPersonalContextSettingApiDelegate.b;
    }

    public final i1<x> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ z0 access$get_uiState$p(ObricPersonalContextSettingViewModel r0) {
        return r0._uiState;
    }

    private final Object buildDataSourceRows(Continuation<? super List<? extends com.obric.assistant.settings.memory.a>> r8) {
        if ((r8 instanceof C00811) == false) goto L7;
        Continuation<? super Unit> r0 = (C00811) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        List r4 = (List) r0.L$0;
        ResultKt.throwOnFailure(r9);
        return r4;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ArrayList r10 = new ArrayList();
        ToggleName r5 = ToggleName.CONTACTS;
        AppHost.Companion r6 = AppHost.a;
        r10.add(dataSourceRow(r5, r6.getApplication().getString(2131912154)));
        r10.add(dataSourceRow(ToggleName.CALL_LOGS, r6.getApplication().getString(2131912150)));
        r10.add(dataSourceRow(ToggleName.MESSAGE, r6.getApplication().getString(2131912165)));
        r10.add(dataSourceRow(ToggleName.ALBUM, r6.getApplication().getString(2131912147)));
        r10.add(dataSourceRow(ToggleName.NOTES, tga.b.a()));
        r10.add(dataSourceRow(ToggleName.CLOCK, r6.getApplication().getString(2131912152)));
        r10.add(dataSourceRow(ToggleName.FILE_MANAGEMENT, r6.getApplication().getString(2131912156)));
        r10.add(dataSourceRow(ToggleName.RECORD, r6.getApplication().getString(2131912170)));
        r10.add(dataSourceRow(ToggleName.CALENDAR, r6.getApplication().getString(2131912149)));
        r0.L$0 = r10;
        r0.label = 1;
        if (addMemoryRows(r10, r0) != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new C00811(this, r8);
        goto L8
    }

    private final Object buildState(Continuation<? super x> r9) {
        if ((r9 instanceof C00821) == false) goto L7;
        C00821 r0 = (C00821) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        List r4 = (List) r0.L$1;
        List r5 = (List) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L24:
        r4.addAll((Collection) r10);
        List r6 = r5;
    L26:
        return new x(CollectionsKt.build(r6));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (getPersonalContextSettingsDelegate().q() != true) goto L17;
        boolean r11 = true;
    L18:
        r6 = CollectionsKt.createListBuilder();
        r6.add(com.obric.assistant.settings.memory.a.C0023a.a);
        AppHost.Companion r7 = AppHost.a;
        r6.add(new com.obric.assistant.settings.memory.a.c(r7.getApplication().getString(2131912172), r11));
        if (r11 == false) goto L26;
        r6.add(new com.obric.assistant.settings.memory.a.d(r7.getApplication().getString(2131912171)));
        r0.L$0 = r6;
        r0.L$1 = r6;
        r0.label = 1;
        r10 = buildDataSourceRows(r0);
        if (r10 != r2) goto L23;
        return r2;
    L23:
        r5 = r6;
        r4 = r5;
        goto L24
    L17:
        r11 = false;
    L7:
        r0 = new C00821(this, r9);
        goto L8
    }

    private final boolean followOldMemorySwitch(ToggleName r2) {
        int r3 = a.a[r2.ordinal()];
        if (r3 != 2) goto L5;
    L13:
        return true;
    L5:
        if (r3 == 3) goto L13;
        if (r3 == 4) goto L13;
        if (r3 == 5) goto L13;
        if (r3 == 6) goto L13;
        return false;
    }

    private final String getEndText(boolean r2) {
        if (r2 == false) goto L4;
        String r3 = AppHost.a.getApplication().getString(2131911961);
        Intrinsics.checkNotNull(r3);
        return r3;
    L4:
        String r4 = AppHost.a.getApplication().getString(2131912176);
        Intrinsics.checkNotNull(r4);
        return r4;
    }

    public static final /* synthetic */ Object access$buildDataSourceRows(ObricPersonalContextSettingViewModel r0, Continuation r1) {
        return r0.buildDataSourceRows(r1);
    }

    public static final /* synthetic */ Object access$buildState(ObricPersonalContextSettingViewModel r0, Continuation r1) {
        return r0.buildState(r1);
    }

    private final Object addMemoryRows(List<com.obric.assistant.settings.memory.a> r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r9 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L49:
        if (((Boolean) r11).booleanValue() != true) goto L51;
        r4 = true;
    L51:
        if (r4 == false) goto L55;
        com.obric.assistant.settings.memory.a r12 = memoryRow(ToggleName.HEARING_MEMORY, AppHost.a.getApplication().getString(2131912162));
        if (r12 == null) goto L55;
        Boxing.boxBoolean(r9.add(r12));
    L55:
        com.obric.assistant.settings.memory.a r13 = memoryRow(ToggleName.GLOBAL_MEMORY, AppHost.a.getApplication().getString(2131912160));
        if (r13 == null) goto L59;
        Boxing.boxBoolean(r9.add(r13));
    L59:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L33:
        if (((Boolean) r11).booleanValue() != true) goto L35;
        boolean r14 = true;
    L36:
        if (r14 == false) goto L43;
        ToggleName r15 = ToggleName.SCREEN_MEMORY;
        AppHost.Companion r5 = AppHost.a;
        com.obric.assistant.settings.memory.a r16 = memoryRow(r15, r5.getApplication().getString(2131912164));
        if (r16 == null) goto L40;
        Boxing.boxBoolean(r9.add(r16));
    L40:
        com.obric.assistant.settings.memory.a r17 = memoryRow(ToggleName.AI_DIARY, r5.getApplication().getString(2131912146));
        if (r17 == null) goto L43;
        Boxing.boxBoolean(r9.add(r17));
    L43:
        IAILabService r18 = getAiLabService();
        if (r18 == null) goto L51;
        AILabSettingItem r6 = AILabSettingItem.VoiceMemory;
        r0.L$0 = r9;
        r0.label = 2;
        r11 = r18.b(r6, r0);
        if (r11 != r2) goto L49;
        return r2;
    L35:
        r14 = false;
        goto L36
    L16:
        ResultKt.throwOnFailure(r11);
        ToggleName r19 = ToggleName.COLLECTION_MEMORY;
        AppHost.Companion r7 = AppHost.a;
        com.obric.assistant.settings.memory.a r110 = memoryRow(r19, r7.getApplication().getString(2131912158));
        if (r110 == null) goto L19;
        Boxing.boxBoolean(r9.add(r110));
    L19:
        com.obric.assistant.settings.memory.a r111 = memoryRow(ToggleName.PERSONAL_INFO_MEMORY, r7.getApplication().getString(2131912163));
        if (r111 == null) goto L23;
        Boxing.boxBoolean(r9.add(r111));
    L23:
        if (getPersonalContextSettingsDelegate().t() == true) goto L27;
        com.obric.assistant.settings.memory.a r112 = memoryRow(ToggleName.EVENT_MEMORY, r7.getApplication().getString(2131912159));
        if (r112 == null) goto L27;
        Boxing.boxBoolean(r9.add(r112));
    L27:
        IAILabService r113 = getAiLabService();
        if (r113 == null) goto L35;
        AILabSettingItem r8 = AILabSettingItem.ScreenMemory;
        r0.L$0 = r9;
        r0.label = 1;
        r11 = r113.b(r8, r0);
        if (r11 != r2) goto L33;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    private final com.obric.assistant.settings.memory.a.b dataSourceRow(ToggleName r4, String r5) {
        if (a.a[r4.ordinal()] != 1) goto L5;
        String r1 = getAlbumEndText();
    L7:
        return new com.obric.assistant.settings.memory.a.b(r4, r5, r1);
    L5:
        r1 = getEndText(getPersonalContextSettingsDelegate().o(r4));
        goto L7
    }

    private final com.obric.assistant.settings.memory.a memoryRow(ToggleName r3, String r4) {
        if (ObricPersonalContextSettingApiDelegate.b.l(r3) == false) goto L6;
        return null;
    L6:
        boolean r0 = getPersonalContextSettingsDelegate().o(ToggleName.MEMORY);
        if (followOldMemorySwitch(r3) == false) goto L9;
        boolean r1 = getPersonalContextSettingsDelegate().j(r3, r0);
    L11:
        return new com.obric.assistant.settings.memory.a.b(r3, r4, getEndText(r1));
    L9:
        r1 = getPersonalContextSettingsDelegate().j(r3, false);
        goto L11
    }

    public static final /* synthetic */ Object access$addMemoryRows(ObricPersonalContextSettingViewModel r0, List r1, Continuation r2) {
        return r0.addMemoryRows(r1, r2);
    }
}
