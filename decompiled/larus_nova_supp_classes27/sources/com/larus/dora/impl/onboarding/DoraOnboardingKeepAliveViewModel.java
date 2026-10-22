package com.larus.dora.impl.onboarding;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelKt;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.alive.DoraKeepAliveViewModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
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
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020 J,\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010+\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0016J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020&0-J\u000e\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0011R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R$\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00062"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingKeepAliveViewModel;", "Lcom/larus/dora/impl/alive/DoraKeepAliveViewModel;", "<init>", "()V", "flowCompanionDeviceManager", "Lcom/larus/cdm/IFlowCompanionDeviceManager;", "getFlowCompanionDeviceManager", "()Lcom/larus/cdm/IFlowCompanionDeviceManager;", "flowCompanionDeviceManager$delegate", "Lkotlin/Lazy;", "flowCompanionDeviceAssociator", "Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", "getFlowCompanionDeviceAssociator", "()Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", "setFlowCompanionDeviceAssociator", "(Lcom/larus/cdm/IFlowCompanionDeviceAssociator;)V", "isCdmSwitchExposed", "", "()Z", "value", "isCdmSwitchOn", "setCdmSwitchOn", "(Z)V", "isNotificationSwitchOn", "setNotificationSwitchOn", "_authButtonStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingKeepAliveViewModel$AuthButtonState;", "authButtonStateFlow", "getAuthButtonStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "updateAuthButtonState", "", "createCompanionDeviceAssociator", "fragment", "Landroidx/fragment/app/Fragment;", "setCdm", "macAddress", "", "sn", "setOngoingNotification", "loadCdmState", "manager", "associator", "getExposureList", "", "reportOnboardingKeepAliveSetting", "isCdmOn", "Companion", "AuthButtonState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOnboardingKeepAliveViewModel extends DoraKeepAliveViewModel {
    public static final a Companion = null;
    public static final String TAG = "DoraOnboardingKeepAliveViewModel";
    private final z0<AuthButtonState> _authButtonStateFlow;
    private final z0<AuthButtonState> authButtonStateFlow;
    private oy8.e flowCompanionDeviceAssociator;
    private final Lazy flowCompanionDeviceManager$delegate;
    private boolean isCdmSwitchOn;
    private boolean isNotificationSwitchOn;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingKeepAliveViewModel$AuthButtonState;", "", "clickable", "", "resId", "", "<init>", "(Ljava/lang/String;IZI)V", "getClickable", "()Z", "getResId", "()I", "AllEnabled", "Enabled", "Disabled", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AuthButtonState extends Enum<AuthButtonState> {
        public static final AuthButtonState AllEnabled = null;
        public static final AuthButtonState Disabled = null;
        public static final AuthButtonState Enabled = null;
        public static final /* synthetic */ AuthButtonState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final boolean clickable;
        private final int resId;

        public static EnumEntries<AuthButtonState> getEntries() {
            return b;
        }

        static {
            AuthButtonState r0 = new AuthButtonState("AllEnabled", 0, true, 2131903755);
            AllEnabled = r0;
            AuthButtonState r1 = new AuthButtonState("Enabled", 1, true, 2131903756);
            Enabled = r1;
            AuthButtonState r2 = new AuthButtonState("Disabled", 2, false, 2131903756);
            Disabled = r2;
            AuthButtonState[] r5 = {r0, r1, r2};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static AuthButtonState[] values() {
            return (AuthButtonState[]) a.clone();
        }

        public final boolean getClickable() {
            return this.clickable;
        }

        public final int getResId() {
            return this.resId;
        }

        public static AuthButtonState valueOf(String r1) {
            return (AuthButtonState) r27.a.a(AuthButtonState.class, r1);
        }

        public AuthButtonState(String r1, int r2, boolean r3, int r4) {
            super(r1, r2);
            this.clickable = r3;
            this.resId = r4;
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.DoraOnboardingKeepAliveViewModel$loadCdmState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingKeepAliveViewModel$loadCdmState$1", f = "DoraOnboardingKeepAliveViewModel.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $macAddress;
        final /* synthetic */ IFlowCompanionDeviceManager $manager;
        final /* synthetic */ String $sn;
        int label;
        final /* synthetic */ DoraOnboardingKeepAliveViewModel this$0;

        public AnonymousClass1(DoraOnboardingKeepAliveViewModel r1, IFlowCompanionDeviceManager r2, String r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$manager = r2;
            this.$macAddress = r3;
            this.$sn = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$manager, this.$macAddress, this.$sn, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            boolean r7 = this.this$0.isCdmKeepAliveEnabled(this.$manager, this.$macAddress, this.$sn);
            g49.d.d(DoraOnboardingKeepAliveViewModel.TAG, "loadCdmState: state=" + r7);
            MutableSharedFlow r2 = DoraOnboardingKeepAliveViewModel.access$get_keepAliveCdmToggleStateFlow(this.this$0);
            Boolean r8 = Boxing.boxBoolean(r7);
            this.label = 1;
            if (r2.emit(r8, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ IFlowCompanionDeviceManager yo() {
        return flowCompanionDeviceManager_delegate$lambda$0();
    }

    private static final IFlowCompanionDeviceManager flowCompanionDeviceManager_delegate$lambda$0() {
        return (IFlowCompanionDeviceManager) ServiceManager.get().getService(IFlowCompanionDeviceManager.class);
    }

    private final void updateAuthButtonState() {
        boolean r0 = this.isCdmSwitchOn;
        if (r0 == true) goto L5;
    L7:
        if (r0 == false) goto L9;
    L12:
        this._authButtonStateFlow.setValue(AuthButtonState.Enabled);
    L13:
        g49.d.d(TAG, "updateAuthButtonState: isCdmSwitchOn=" + this.isCdmSwitchOn + ", isNotificationSwitchOn=" + this.isNotificationSwitchOn + ", authButtonState=" + this._authButtonStateFlow.getValue());
        return;
    L9:
        if (this.isNotificationSwitchOn == true) goto L12;
        this._authButtonStateFlow.setValue(AuthButtonState.Disabled);
        goto L13
    L5:
        if (this.isNotificationSwitchOn == false) goto L7;
        this._authButtonStateFlow.setValue(AuthButtonState.AllEnabled);
        goto L13
    }

    public final List<String> getExposureList() {
        ArrayList r0 = new ArrayList();
        if (isCdmSwitchExposed() == false) goto L5;
        r0.add("cdm");
    L5:
        r0.add("notification");
        return r0;
    }

    public final IFlowCompanionDeviceManager getFlowCompanionDeviceManager() {
        return (IFlowCompanionDeviceManager) this.flowCompanionDeviceManager$delegate.getValue();
    }

    public final void setOngoingNotification() {
        g49.d.d(TAG, "setOngoingNotification: isNotificationSwitchOn=" + this.isNotificationSwitchOn);
        boolean r0 = this.isNotificationSwitchOn;
        super.enableOngoingNotification(r0);
        if (r0 == false) goto L5;
        com.larus.dora.impl.core.i0.a.a.getClass();
        com.larus.dora.impl.core.i0.k(4);
    L6:
        j49.b.h(r0);
        return;
    L5:
        com.larus.dora.impl.core.i0.a.a.getClass();
        com.larus.dora.impl.core.i0.l();
        goto L6
    }

    public DoraOnboardingKeepAliveViewModel() {
        this.flowCompanionDeviceManager$delegate = LazyKt.lazy(new j0());
        this.isCdmSwitchOn = true;
        this.isNotificationSwitchOn = true;
        StateFlowImpl r0 = j1.a(AuthButtonState.AllEnabled);
        this._authButtonStateFlow = r0;
        this.authButtonStateFlow = r0;
    }

    public final boolean isCdmSwitchExposed() {
        IFlowCompanionDeviceManager r0 = getFlowCompanionDeviceManager();
        if (r0 != null) goto L7;
        return false;
    L7:
        return com.larus.dora.impl.alive.a.a(r0);
    }

    public final z0<AuthButtonState> getAuthButtonStateFlow() {
        return this.authButtonStateFlow;
    }

    public final oy8.e getFlowCompanionDeviceAssociator() {
        return this.flowCompanionDeviceAssociator;
    }

    public final boolean isCdmSwitchOn() {
        return this.isCdmSwitchOn;
    }

    public final boolean isNotificationSwitchOn() {
        return this.isNotificationSwitchOn;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_keepAliveCdmToggleStateFlow(DoraOnboardingKeepAliveViewModel r0) {
        return r0.get_keepAliveCdmToggleStateFlow();
    }

    public final void createCompanionDeviceAssociator(Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        g49.d.d(TAG, "createCompanionDeviceAssociator");
        IFlowCompanionDeviceManager r1 = getFlowCompanionDeviceManager();     // Catch: Exception -> L9
        if (r1 == null) goto L6;
        FlowCompanionDeviceAssociatorImpl r5 = r1.j(r4);     // Catch: Exception -> L9
    L7:
        this.flowCompanionDeviceAssociator = r5;     // Catch: Exception -> L9
        return;
    L6:
        r5 = null;
    L9:
        e = move-exception;
        g49.d.c(TAG, "createCompanionDeviceAssociator failed, " + e.getMessage(), e);
    }

    public final void reportOnboardingKeepAliveSetting(boolean r21) {
        ArrayList r1 = new ArrayList();
        if (r21 == false) goto L6;
        r1.add("cdm");
    L6:
        if (isOngoingNotificationEnabled() == false) goto L8;
        r1.add("notification");
    L8:
        List<String> r2 = getExposureList();
        g49.d.d(TAG, "reportOnboardingKeepAliveSetting: isCdmOn=" + r21 + ", exposureList=" + r2 + ", settingOnList=" + r1);
        int r0 = m0.a;
        Intrinsics.checkNotNullParameter(r2, "exposureList");
        Intrinsics.checkNotNullParameter(r1, "settingOnList");
        g49.d.d("DoraOnboardingTracker", "reportOnboardingKeepAliveSetting: " + r2 + ", " + r1);
        DoraBuryPointManager.a.L("dora_onboarding_keep_alive_setting", MapsKt.mapOf(new Pair[]{TuplesKt.to("exposure_setting_list", CollectionsKt.joinToString$default(r2, ",", null, null, 0, null, null, 62, null)), TuplesKt.to("setting_on_list", CollectionsKt.joinToString$default(r1, ",", null, null, 0, null, null, 62, null))}));
    }

    public final void setCdmSwitchOn(boolean r1) {
        this.isCdmSwitchOn = r1;
        updateAuthButtonState();
    }

    public final void setFlowCompanionDeviceAssociator(oy8.e r1) {
        this.flowCompanionDeviceAssociator = r1;
    }

    public final void setNotificationSwitchOn(boolean r1) {
        this.isNotificationSwitchOn = r1;
        updateAuthButtonState();
    }

    public final void setCdm(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "macAddress");
        Intrinsics.checkNotNullParameter(r10, "sn");
        g49.d.d(TAG, "setCdm, isCdmSwitchOn=" + this.isCdmSwitchOn);
        super.enableCdm(this.isCdmSwitchOn, getFlowCompanionDeviceManager(), this.flowCompanionDeviceAssociator, r9, r10);
    }

    @Override // com.larus.dora.impl.alive.DoraKeepAliveViewModel
    public void loadCdmState(IFlowCompanionDeviceManager r10, oy8.e r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "macAddress");
        Intrinsics.checkNotNullParameter(r13, "sn");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r10, r12, r13, null), 2, null);
    }
}
