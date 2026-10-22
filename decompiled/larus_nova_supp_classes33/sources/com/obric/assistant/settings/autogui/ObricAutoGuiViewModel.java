package com.obric.assistant.settings.autogui;

import android.app.Application;
import android.os.Build;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.obric.assistant.special_input.OSkillExtensionSettingRepository;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\u0012\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019*\u00020\u0012H\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u0014H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002R\u001b\u0010\u0006\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "createAutoGuiSwitchUIModel", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "loadingHintUIModel", "getLoadingHintUIModel", "()Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "loadingHintUIModel$delegate", "Lkotlin/Lazy;", "availTitleUIModel", "getAvailTitleUIModel", "availTitleUIModel$delegate", "inAvailTitleUIModel", "getInAvailTitleUIModel", "inAvailTitleUIModel$delegate", "lastDataSource", "Lcom/obric/assistant/settings/AutoActionAppDataSource;", "skillExtensionEntryVisibleForSession", "", "lastObservedSkillExtensionEnabled", "Ljava/lang/Boolean;", "_autoGuiUIModelListFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "autoGuiUIModelListFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getAutoGuiUIModelListFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "fetchAutoGuiUIModelList", "", "refreshListBySwitchChanged", "maybeUpdateSkillExtensionEntryVisible", "state", "", "isOmniSkillAvailableState", "maybeInitSkillExtensionActionBarNewState", "transToAutoGuiUIModelList", "isDisplayAppVisible", "appInfo", "Lcom/obric/assistant/settings/AppInfo;", "hasAutoExecuteAuthorizationPageConfig", "resolveAutoExecuteAuthorizationPageConfig", "Lcom/google/gson/JsonObject;", "configJson", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoGuiViewModel extends ViewModel {
    private static final String ANDROID_DOCUMENTS_UI_PACKAGE_NAME = "com.android.documentsui";
    private static final String ANDROID_LAUNCHER_PACKAGE_NAME = "com.android.launcher3";
    private static final String AUTO_EXECUTE_AUTHORIZATION_CLOUD_CONFIG_KEY = "auto_gui_automatic_execution_authorization";
    public static final a Companion = null;
    private static final Set<String> HIDDEN_DISPLAY_APP_PACKAGES = null;
    private static final long SKILL_EXTENSION_ACTION_BAR_NEW_DURATION_MS = 604800000;
    private final kotlinx.coroutines.flow.z0<List<b0>> _autoGuiUIModelListFlow;
    private final i1<List<b0>> autoGuiUIModelListFlow;
    private final Lazy availTitleUIModel$delegate;
    private final Lazy inAvailTitleUIModel$delegate;
    private com.obric.assistant.settings.c lastDataSource;
    private Boolean lastObservedSkillExtensionEnabled;
    private final Lazy loadingHintUIModel$delegate;
    private boolean skillExtensionEntryVisibleForSession;

    /* JADX INFO: renamed from: com.obric.assistant.settings.autogui.ObricAutoGuiViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiViewModel$1", f = "ObricAutoGuiViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricAutoGuiViewModel this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.autogui.ObricAutoGuiViewModel$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricAutoGuiViewModel a;

            public a(ObricAutoGuiViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r5, Continuation r6) {
                Triple r7 = (Triple) r5;
                boolean r8 = ((Boolean) r7.component1()).booleanValue();
                boolean r0 = ((Boolean) r7.component2()).booleanValue();
                int r9 = ((Number) r7.component3()).intValue();
                boolean r1 = !Intrinsics.areEqual(ObricAutoGuiViewModel.access$getLastObservedSkillExtensionEnabled$p(this.a), Boxing.boxBoolean(r8));
                ObricAutoGuiViewModel.access$setLastObservedSkillExtensionEnabled$p(this.a, Boxing.boxBoolean(r8));
                boolean r2 = ObricAutoGuiViewModel.access$maybeUpdateSkillExtensionEntryVisible(this.a, r9);
                if (r0 == false) goto L8;
                if (r8 == false) goto L8;
                if (ObricAutoGuiViewModel.access$isOmniSkillAvailableState(this.a, r9) == false) goto L8;
                ObricAutoGuiViewModel.access$maybeInitSkillExtensionActionBarNewState(this.a);
            L8:
                if (r1 == true) goto L10;
                if (r2 == true) goto L10;
            L12:
                return Unit.INSTANCE;
            L10:
                this.a.refreshListBySwitchChanged();
                goto L12
            }
        }

        public AnonymousClass1(ObricAutoGuiViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            final kotlinx.coroutines.flow.b1 r6 = com.obric.assistant.special_input.j.a;
            Flow r7 = kotlinx.coroutines.flow.e.n(new ObricAutoGuiViewModel$1$invokeSuspend$$inlined$map$1(r6));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.autogui.ObricAutoGuiViewModel$fetchAutoGuiUIModelList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiViewModel$fetchAutoGuiUIModelList$1", f = "ObricAutoGuiViewModel.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b0 $autoGuiSwitchUIModel;
        Object L$0;
        int label;
        final /* synthetic */ ObricAutoGuiViewModel this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.autogui.ObricAutoGuiViewModel$fetchAutoGuiUIModelList$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemUIModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiViewModel$fetchAutoGuiUIModelList$1$1", f = "ObricAutoGuiViewModel.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends b0>>, Object> {
            final /* synthetic */ b0 $autoGuiSwitchUIModel;
            Object L$0;
            int label;
            final /* synthetic */ ObricAutoGuiViewModel this$0;

            public C00171(ObricAutoGuiViewModel r1, b0 r2, Continuation<? super C00171> r3) {
                this.this$0 = r1;
                this.$autoGuiSwitchUIModel = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00171(this.this$0, this.$autoGuiSwitchUIModel, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super List<b0>> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ObricAutoGuiViewModel r2 = (ObricAutoGuiViewModel) this.L$0;
                ResultKt.throwOnFailure(r6);
            L14:
                ObricAutoGuiViewModel r4 = r2;
                com.obric.assistant.settings.c r3 = (com.obric.assistant.settings.c) r6;
                ObricAutoGuiViewModel r7 = r4;
            L16:
                ObricAutoGuiViewModel.access$setLastDataSource$p(r7, r3);
                com.obric.assistant.settings.c r8 = ObricAutoGuiViewModel.access$getLastDataSource$p(this.this$0);
                if (r8 == null) goto L22;
                List r9 = ObricAutoGuiViewModel.access$transToAutoGuiUIModelList(this.this$0, r8);
                if (r9 == null) goto L22;
                return r9;
            L22:
                return CollectionsKt.listOf(new b0[]{this.$autoGuiSwitchUIModel, ObricAutoGuiViewModel.access$getAvailTitleUIModel(this.this$0)});
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                r7 = this.this$0;
                IObricAutoGuiSettingsApi r5 = (IObricAutoGuiSettingsApi) ServiceManager.get().getService(IObricAutoGuiSettingsApi.class);
                if (r5 == null) goto L15;
                this.L$0 = r7;
                this.label = 1;
                Object r10 = r5.i(this);
                if (r10 != r0) goto L13;
                return r0;
            L13:
                r2 = r7;
                r6 = r10;
                goto L14
            L15:
                r3 = null;
                goto L16
            }
        }

        public C00801(ObricAutoGuiViewModel r1, b0 r2, Continuation<? super C00801> r3) {
            this.this$0 = r1;
            this.$autoGuiSwitchUIModel = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C00801(this.this$0, this.$autoGuiSwitchUIModel, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            kotlinx.coroutines.flow.z0 r2 = (kotlinx.coroutines.flow.z0) this.L$0;
            ResultKt.throwOnFailure(r8);
        L12:
            r2.setValue(r8);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            kotlinx.coroutines.flow.z0 r9 = ObricAutoGuiViewModel.access$get_autoGuiUIModelListFlow$p(this.this$0);
            CoroutineDispatcher r3 = Dispatchers.getIO();
            C00171 r4 = new C00171(this.this$0, this.$autoGuiSwitchUIModel, null);
            this.L$0 = r9;
            this.label = 1;
            Object r5 = BuildersKt.withContext(r3, r4, this);
            if (r5 != r0) goto L11;
            return r0;
        L11:
            r2 = r9;
            r8 = r5;
            goto L12
        }
    }

    public static /* synthetic */ b0 Mo() {
        return availTitleUIModel_delegate$lambda$1();
    }

    public static /* synthetic */ b0 No() {
        return loadingHintUIModel_delegate$lambda$0();
    }

    private final boolean isOmniSkillAvailableState(int r1) {
        if (r1 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    public static /* synthetic */ b0 yo() {
        return inAvailTitleUIModel_delegate$lambda$2();
    }

    static {
        Companion = new a();
        HIDDEN_DISPLAY_APP_PACKAGES = SetsKt.setOf(new String[]{ANDROID_DOCUMENTS_UI_PACKAGE_NAME, ANDROID_LAUNCHER_PACKAGE_NAME});
    }

    private static final b0 availTitleUIModel_delegate$lambda$1() {
        return new b0(ObricAutoGuiItemViewType.TITLE_HINT, null, AppHost.a.getApplication().getString(2131912454), false, null, false, false, null, null, false, false, false, false, 8186);
    }

    private final b0 createAutoGuiSwitchUIModel() {
        t1 r0 = t1.a;
        if (r0.getAutoGuiEnabledScene() != 2) goto L5;
        boolean r10 = true;
    L6:
        ObricAutoGuiItemViewType r5 = ObricAutoGuiItemViewType.AUTO_GUI_SWITCH;
        String r7 = FlowRuntime.a().getApplication().getString(2131912430);
        boolean r11 = hasAutoExecuteAuthorizationPageConfig();
        String r2 = r0.O();
        Intrinsics.checkNotNullParameter(r2, "value");
        Application r4 = FlowRuntime.a().getApplication();
        switch(r2.hashCode()) {
            case 48: goto L21;
            case 49: goto L17;
            case 50: goto L14;
            case 51: goto L10;
            default: goto L25;
        };
    L25:
        String r3 = r4.getString(2131912461);
    L24:
        String r12 = r3;
        String r13 = m0.a(r0.getAutoGuiFastModeUseSettings());
        boolean r14 = r0.v1();
        boolean r15 = this.skillExtensionEntryVisibleForSession;
        kotlinx.coroutines.flow.b1 r6 = com.obric.assistant.special_input.j.a;
        OSkillExtensionSettingRepository.a.getClass();
        if (OSkillExtensionSettingRepository.c() == true) goto L29;
        OSkillExtensionSettingRepository.e();
        boolean r16 = false;
    L31:
        return new b0(r5, null, r7, true, null, r10, r11, r12, r13, r14, r15, r16, false, 4114);
    L29:
        OSkillExtensionSettingRepository.a();
        OSkillExtensionSettingRepository.b("lazy_read");
        r16 = ((com.obric.assistant.special_input.t0) OSkillExtensionSettingRepository.i.getValue()).a;
        goto L31
    L10:
        if (r2.equals("3") == false) goto L25;
        r3 = r4.getString(2131912456);
        goto L24
    L14:
        if (r2.equals("2") == false) goto L25;
    L23:
        r3 = r4.getString(2131912461);
        goto L24
    L17:
        if (r2.equals("1") == false) goto L25;
        r3 = r4.getString(2131912459);
        goto L24
    L21:
        if (r2.equals("0") == true) goto L23;
    L5:
        r10 = false;
        goto L6
    }

    private final b0 getAvailTitleUIModel() {
        return (b0) this.availTitleUIModel$delegate.getValue();
    }

    private final b0 getInAvailTitleUIModel() {
        return (b0) this.inAvailTitleUIModel$delegate.getValue();
    }

    private final b0 getLoadingHintUIModel() {
        return (b0) this.loadingHintUIModel$delegate.getValue();
    }

    private final boolean hasAutoExecuteAuthorizationPageConfig() {
        if (resolveAutoExecuteAuthorizationPageConfig(t1.a.getObricCloudConfig(AUTO_EXECUTE_AUTHORIZATION_CLOUD_CONFIG_KEY)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static final b0 inAvailTitleUIModel_delegate$lambda$2() {
        ObricAutoGuiItemViewType r1 = ObricAutoGuiItemViewType.TITLE_HINT;
        String r0 = t1.a.getObricAutoGuiBlacklistConfig().getObricAutoGuiBlacklistHint();
        if (r0 != null) goto L6;
        r0 = AppHost.a.getApplication().getString(2131912431);
    L6:
        return new b0(r1, null, r0, false, null, false, false, null, null, false, false, false, false, 8186);
    }

    private static final b0 loadingHintUIModel_delegate$lambda$0() {
        return new b0(ObricAutoGuiItemViewType.LOADING_HINT, null, null, false, null, false, false, null, null, false, false, false, false, 8190);
    }

    private final void maybeInitSkillExtensionActionBarNewState() {
        t1 r0 = t1.a;
        if (r0.c0() == false) goto L5;
        return;
    L5:
        long r1 = System.currentTimeMillis() + SKILL_EXTENSION_ACTION_BAR_NEW_DURATION_MS;
        r0.E0();
        r0.L1(r1);
        r0.c1(false);
    }

    public final void refreshListBySwitchChanged() {
        kotlinx.coroutines.flow.z0<List<b0>> r0 = this._autoGuiUIModelListFlow;
        com.obric.assistant.settings.c r1 = this.lastDataSource;
        if (r1 == null) goto L6;
        List<b0> r2 = transToAutoGuiUIModelList(r1);
        if (r2 == null) goto L6;
    L7:
        r0.setValue(r2);
        return;
    L6:
        r2 = CollectionsKt.listOf(createAutoGuiSwitchUIModel());
        goto L7
    }

    public ObricAutoGuiViewModel() {
        this.loadingHintUIModel$delegate = LazyKt.lazy(new j0());
        this.availTitleUIModel$delegate = LazyKt.lazy(new k0());
        this.inAvailTitleUIModel$delegate = LazyKt.lazy(new l0());
        kotlinx.coroutines.flow.b1 r0 = com.obric.assistant.special_input.j.a;
        OSkillExtensionSettingRepository r1 = OSkillExtensionSettingRepository.a;
        r1.getClass();
        boolean r2 = false;
        if (OSkillExtensionSettingRepository.c() == true) goto L5;
        OSkillExtensionSettingRepository.e();
    L8:
        this.skillExtensionEntryVisibleForSession = r2;
        StateFlowImpl r3 = j1.a(CollectionsKt.listOf(createAutoGuiSwitchUIModel()));
        this._autoGuiUIModelListFlow = r3;
        this.autoGuiUIModelListFlow = r3;
        Intrinsics.checkNotNullParameter("auto_gui_view_model_init", WindowEvent.Params.REASON);
        r1.getClass();
        OSkillExtensionSettingRepository.b("auto_gui_view_model_init");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L5:
        OSkillExtensionSettingRepository.a();
        OSkillExtensionSettingRepository.b("lazy_read");
        if (((com.obric.assistant.special_input.t0) OSkillExtensionSettingRepository.i.getValue()).e != 1) goto L8;
        r2 = true;
        goto L8
    }

    public final void fetchAutoGuiUIModelList() {
        b0 r0 = createAutoGuiSwitchUIModel();
        if (t1.a.getAutoGuiEnabledScene() != 2) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        this._autoGuiUIModelListFlow.setValue(CollectionsKt.listOf(r0));
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C00801(this, r0, null), 2, null);
        return;
    L9:
        if (this.lastDataSource != null) goto L11;
        this._autoGuiUIModelListFlow.setValue(CollectionsKt.listOf(new b0[]{r0, getAvailTitleUIModel(), getLoadingHintUIModel()}));
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    public final i1<List<b0>> getAutoGuiUIModelListFlow() {
        return this.autoGuiUIModelListFlow;
    }

    public static final /* synthetic */ b0 access$getAvailTitleUIModel(ObricAutoGuiViewModel r0) {
        return r0.getAvailTitleUIModel();
    }

    public static final /* synthetic */ com.obric.assistant.settings.c access$getLastDataSource$p(ObricAutoGuiViewModel r0) {
        return r0.lastDataSource;
    }

    public static final /* synthetic */ Boolean access$getLastObservedSkillExtensionEnabled$p(ObricAutoGuiViewModel r0) {
        return r0.lastObservedSkillExtensionEnabled;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.z0 access$get_autoGuiUIModelListFlow$p(ObricAutoGuiViewModel r0) {
        return r0._autoGuiUIModelListFlow;
    }

    public static final /* synthetic */ void access$maybeInitSkillExtensionActionBarNewState(ObricAutoGuiViewModel r0) {
        r0.maybeInitSkillExtensionActionBarNewState();
    }

    private final boolean isDisplayAppVisible(com.obric.assistant.settings.b r2) {
        return !HIDDEN_DISPLAY_APP_PACKAGES.contains(r2.a);
    }

    private final boolean maybeUpdateSkillExtensionEntryVisible(int r2) {
        if (r2 == 1) goto L5;
        return false;
    L5:
        if (this.skillExtensionEntryVisibleForSession == true) goto L11;
        this.skillExtensionEntryVisibleForSession = true;
        return true;
    L11:
        return false;
    }

    private final JsonObject resolveAutoExecuteAuthorizationPageConfig(JsonObject r4) {
        JsonElement r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        JsonElement r1 = r4.get(AUTO_EXECUTE_AUTHORIZATION_CLOUD_CONFIG_KEY);
        if (r1 != null) goto L8;
        return r4;
    L8:
        if (r1.isJsonObject() == false) goto L10;
        r0 = r1;
    L10:
        if (r0 == null) goto L16;
        JsonObject r2 = r0.getAsJsonObject();
        if (r2 != null) goto L14;
        return r4;
    L14:
        return r2;
    L16:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
    private final List<b0> transToAutoGuiUIModelList(com.obric.assistant.settings.c r26) {
        b0 r2 = createAutoGuiSwitchUIModel();
        if (t1.a.getAutoGuiEnabledScene() != 2) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        ArrayList r4 = new ArrayList();
        r4.add(r2);
        Lazy r5 = o0.a;
        if (Build.VERSION.SDK_INT < 37) goto L12;
        boolean r6 = true;
    L13:
        List<com.obric.assistant.settings.b> r7 = r26.a;
        ?? r22 = 0;
        if (r7 == null) goto L21;
        ?? r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L17:
        if (r9.hasNext() == false) goto L22;
        Object r10 = r9.next();
        if (isDisplayAppVisible((com.obric.assistant.settings.b) r10) == false) goto L17;
        r8.add(r10);
    L22:
        if (r8 != 0) goto L24;
        r8 = CollectionsKt.emptyList();
    L24:
        boolean r11 = !((Collection) r8).isEmpty();
        ?? r12 = r8;
        if (r11 == true) goto L28;
        r12 = 0;
    L28:
        if (r12 == 0) goto L46;
        int r13 = r12.size();
        r4.add(getAvailTitleUIModel());
        Iterator r23 = ((Iterable) r12).iterator();
        int r14 = 0;
    L31:
        if (r23.hasNext() == false) goto L46;
        Object r15 = r23.next();
        int r24 = r14 + 1;
        if (r14 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        com.obric.assistant.settings.b r16 = (com.obric.assistant.settings.b) r15;
        if (r13 != 1) goto L39;
        ObricAutoGuiItemBgType r17 = ObricAutoGuiItemBgType.CORNERS;
    L45:
        r4.add(new b0(ObricAutoGuiItemViewType.APP_AVAILABLE, r17, null, false, r16, false, false, null, null, false, false, false, r6, 4076));
        r14 = r24;
        goto L31
    L39:
        if (r14 != 0) goto L42;
        r17 = ObricAutoGuiItemBgType.TOP_CORNERS;
        goto L45
    L42:
        if (r14 != (r13 - 1)) goto L44;
        r17 = ObricAutoGuiItemBgType.BOTTOM_CORNERS;
        goto L45
    L44:
        r17 = ObricAutoGuiItemBgType.NORMAL;
    L46:
        List<com.obric.assistant.settings.b> r1 = r26.c;
        if (r1 == null) goto L54;
        ?? r18 = new ArrayList();
        Iterator r19 = r1.iterator();
    L50:
        if (r19.hasNext() == false) goto L55;
        Object r20 = r19.next();
        if (isDisplayAppVisible((com.obric.assistant.settings.b) r20) == false) goto L50;
        r18.add(r20);
    L55:
        if (r18 != 0) goto L58;
        r18 = CollectionsKt.emptyList();
    L58:
        if ((!((Collection) r18).isEmpty()) == false) goto L60;
        r22 = r18;
    L60:
        if (r22 == 0) goto L78;
        int r21 = r22.size();
        r4.add(getInAvailTitleUIModel());
        Iterator r25 = ((Iterable) r22).iterator();
        int r27 = 0;
    L63:
        if (r25.hasNext() == false) goto L78;
        Object r28 = r25.next();
        int r29 = r27 + 1;
        if (r27 >= 0) goto L67;
        CollectionsKt.throwIndexOverflow();
    L67:
        com.obric.assistant.settings.b r110 = (com.obric.assistant.settings.b) r28;
        if (r21 != 1) goto L71;
        ObricAutoGuiItemBgType r30 = ObricAutoGuiItemBgType.CORNERS;
    L77:
        r4.add(new b0(ObricAutoGuiItemViewType.APP_INAVAILABLE, r30, null, false, r110, false, false, null, null, false, false, false, false, 8172));
        r27 = r29;
        goto L63
    L71:
        if (r27 != 0) goto L74;
        r30 = ObricAutoGuiItemBgType.TOP_CORNERS;
        goto L77
    L74:
        if (r27 != (r21 - 1)) goto L76;
        r30 = ObricAutoGuiItemBgType.BOTTOM_CORNERS;
        goto L77
    L76:
        r30 = ObricAutoGuiItemBgType.NORMAL;
    L78:
        return r4;
    L54:
        r18 = 0;
        goto L55
    L21:
        r8 = 0;
        goto L22
    L12:
        r6 = false;
        goto L13
    L8:
        return CollectionsKt.listOf(r2);
    L5:
        r3 = false;
        goto L6
    }

    public static final /* synthetic */ boolean access$isOmniSkillAvailableState(ObricAutoGuiViewModel r0, int r1) {
        return r0.isOmniSkillAvailableState(r1);
    }

    public static final /* synthetic */ boolean access$maybeUpdateSkillExtensionEntryVisible(ObricAutoGuiViewModel r0, int r1) {
        return r0.maybeUpdateSkillExtensionEntryVisible(r1);
    }

    public static final /* synthetic */ void access$setLastDataSource$p(ObricAutoGuiViewModel r0, com.obric.assistant.settings.c r1) {
        r0.lastDataSource = r1;
    }

    public static final /* synthetic */ void access$setLastObservedSkillExtensionEnabled$p(ObricAutoGuiViewModel r0, Boolean r1) {
        r0.lastObservedSkillExtensionEnabled = r1;
    }

    public static final /* synthetic */ List access$transToAutoGuiUIModelList(ObricAutoGuiViewModel r0, com.obric.assistant.settings.c r1) {
        return r0.transToAutoGuiUIModelList(r1);
    }
}
