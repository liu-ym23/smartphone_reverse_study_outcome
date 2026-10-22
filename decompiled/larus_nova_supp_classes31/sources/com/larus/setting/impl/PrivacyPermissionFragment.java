package com.larus.setting.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.AccessibilityCommonDialog;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.minor.api.IMinorService;
import com.larus.permission.api.IPermissionX;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowSettingThemeConfigProvider;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.setting.impl.databinding.LarusPagePrivacyPermissionBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallConfigServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.security.privacypermission.ObricPrivacyAndPermissionUiDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000f\u0010!\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u000f\u0010$\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u000f\u0010%\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u000f\u0010&\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u000f\u0010'\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u000f\u0010(\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u000f\u0010)\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u000f\u0010*\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u000f\u0010+\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J0\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0002J8\u00102\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\r2\u0006\u00103\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0002J\u000f\u00104\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J/\u00105\u001a\u00020\"*\u00020\u001a2!\u00106\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\"07H\u0002J\n\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u001a\u0010<\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010=\u001a\u00020\"H\u0002J\b\u0010>\u001a\u00020\"H\u0002J\b\u0010?\u001a\u00020\"H\u0016J\b\u0010@\u001a\u00020\u0015H\u0016J\b\u0010A\u001a\u00020\rH\u0016J\b\u0010B\u001a\u00020\u0015H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006D"}, d2 = {"Lcom/larus/setting/impl/PrivacyPermissionFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "model", "Lcom/larus/setting/impl/SettingModel;", "getModel", "()Lcom/larus/setting/impl/SettingModel;", "model$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/setting/impl/databinding/LarusPagePrivacyPermissionBinding;", "statusOn", "", "getStatusOn", "()Ljava/lang/String;", "statusOn$delegate", "statusOff", "getStatusOff", "statusOff$delegate", "isInMinorMode", "", "isOversea", "isMainlandMinorMode", "()Z", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initAllowTrainingItem", "", "()Lkotlin/Unit;", "initAdvancedAudioItem", "initRealtimeDenoiseItem", "initFaceMemoryItem", "initContactPermissionItem", "initPersonalRecommendItem", "initPictureLocationItem", "initAuthorizationManagementItem", "handleSystemPermissionItemClick", "showGoSettingsDialogWithDefaultCancel", "view", "permissionType", "title", "message", "confirmText", "showGoSettingsDialog", "cancelText", "handleBlockSettingClick", "clickWithDebounceAndResumed", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "onViewCreated", "initViewModel", "adaptItemsVisibilityAtTargetAppMode", "onDestroyView", "autoLogEnterPage", "getCurrentPageName", "isTrainingBySpecificTypeEnabled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PrivacyPermissionFragment extends TraceFragment {
    public static final /* synthetic */ int k = 0;
    public final Lazy e;
    public LarusPagePrivacyPermissionBinding f;
    public final Lazy g;
    public final Lazy h;
    public final boolean i;
    public final boolean j;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class c implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ PrivacyPermissionFragment a;
        public final /* synthetic */ String b;

        public final void confirm() {
            FragmentActivity r0 = this.a.getActivity();
            if (r0 == null) goto L5;
            IPermissionX.a.j(r0, null);
        L5:
            tx9.c0.F(this.b, "setting");
        }

        public c(PrivacyPermissionFragment r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ String a;

        public final void cancel() {
            tx9.c0.F(this.a, "cancel");
        }

        public d(String r1) {
            this.a = r1;
        }
    }

    public static final class e implements com.larus.common_ui.dialog.l1 {
        public e() {
        }

        public final void a() {
        }
    }

    public static final class f implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ PrivacyPermissionFragment a;
        public final /* synthetic */ String b;

        public final void confirm() {
            FragmentActivity r0 = this.a.getActivity();
            if (r0 == null) goto L5;
            IPermissionX.a.j(r0, null);
        L5:
            tx9.c0.F(this.b, "setting");
        }

        public f(PrivacyPermissionFragment r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ String a;

        public final void cancel() {
            tx9.c0.F(this.a, "cancel");
        }

        public g(String r1) {
            this.a = r1;
        }
    }

    public static final class h implements com.larus.common_ui.dialog.l1 {
        public h() {
        }

        public final void a() {
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "privacy_permission_page";
    }

    public static boolean aa0() {
        if (com.larus.platform.service.z2.a.getEnableModelTrainingBySpecificType() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final SettingModel W90() {
        return (SettingModel) this.e.getValue();
    }

    public final String X90() {
        return (String) this.h.getValue();
    }

    public final String Y90() {
        return (String) this.g.getValue();
    }

    public final boolean Z90() {
        if (this.i == true) goto L5;
    L7:
        return false;
    L5:
        if (this.j == true) goto L7;
        return true;
    }

    public PrivacyPermissionFragment() {
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingModel.class), new PrivacyPermissionFragment$special$$inlined$activityViewModels$default$1(this), new PrivacyPermissionFragment$special$$inlined$activityViewModels$default$2(this));
        this.g = LazyKt.lazy(new i2(this));
        this.h = LazyKt.lazy(new h1(this));
        this.i = IMinorService.a.a();
        this.j = AppHost.a.isOversea();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        ObricPrivacyAndPermissionUiDelegate.b.e();
        this.f = null;
    }

    public static void U90(DataPermissionBottomSheet r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "DataPermissionBottomSheet", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "DataPermissionBottomSheet");
    }

    public final void V90(final ItemTextArrow r2, final Function1 r3) {
        com.larus.utils.e1.d(r2, new a2(this, r3, r2));
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        SettingModel.updateUserConfigs$default(W90(), null, 0, null, 7, null);
        LarusPagePrivacyPermissionBinding r10 = this.f;
        LinearLayout r11 = null;
        if (r10 != null) goto L5;
    L28:
        final LarusPagePrivacyPermissionBinding r12 = this.f;
        if (r12 == null) goto L31;
        W90().getAuthorizationCountLiveData().observe(getViewLifecycleOwner(), new b(new q1(r12)));
        W90().getRealtimeDenoiseLiveData().observe(getViewLifecycleOwner(), new b(new s1(r12, this)));
        W90().getAllowTraining().observe(getViewLifecycleOwner(), new b(new t1(this, r12)));
        W90().getOptOutVoice().observe(getViewLifecycleOwner(), new b(new u1(r12, this)));
        W90().getPersonalizedRecommend().observe(getViewLifecycleOwner(), new b(new v1(r12, this)));
        W90().getPictureLocation().observe(getViewLifecycleOwner(), new b(new w1(r12, this)));
        W90().getFaceMemoryEnableLiveData().observe(getViewLifecycleOwner(), new b(new x1(r12, this)));
    L31:
        IFlowSettingThemeConfigProvider r13 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r13 == null) goto L38;
        LarusPagePrivacyPermissionBinding r0 = this.f;
        if (r0 == null) goto L36;
        r11 = r0.k;
    L36:
        r13.b(r11, AdaptThemeFeatureKey.SETTING_ITEM_DATA_PERMISSION);
    L38:
        if (Z90() == false) goto L43;
        LarusPagePrivacyPermissionBinding r14 = this.f;
        if (r14 == null) goto L44;
        com.larus.utils.e1.o(r14.k);
        ViewGroup.LayoutParams r15 = r14.x.getLayoutParams();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        int r16 = i5.r0();
        ((ViewGroup.MarginLayoutParams) r15).topMargin = r16;
        return;
    L44:
        return;
    L43:
        return;
    L5:
        if (aa0() == true) goto L11;
        ItemTextArrow r1 = r10.c;
        if (W90().isAllowTraining() == false) goto L9;
        String r2 = Y90();
    L10:
        int r3 = ItemTextArrow.k;
        r1.Z5(r2, null);
        goto L11
    L9:
        r2 = X90();
    L11:
        ItemTextArrow r4 = r10.y;
        if (W90().isOptOutVoiceEnabled() == false) goto L14;
        String r5 = Y90();
    L15:
        int r6 = ItemTextArrow.k;
        r4.Z5(r5, null);
        ItemTextArrow r7 = r10.t;
        if (W90().isPersonalizedRecommendEnabled() == false) goto L18;
        String r17 = Y90();
    L19:
        r7.Z5(r17, null);
        ItemTextArrow r18 = r10.v;
        if (W90().isPictureLocationEnabled() == false) goto L22;
        String r19 = Y90();
    L23:
        r18.Z5(r19, null);
        ItemTextArrow r20 = r10.l;
        if (W90().getFaceMemoryEnabled() == false) goto L26;
        String r21 = Y90();
    L27:
        r20.Z5(r21, null);
        goto L28
    L26:
        r21 = X90();
        goto L27
    L22:
        r19 = X90();
        goto L23
    L18:
        r17 = X90();
        goto L19
    L14:
        r5 = X90();
        goto L15
    }

    public final View onCreateView(LayoutInflater r35, ViewGroup r36, Bundle r37) {
        Intrinsics.checkNotNullParameter(r35, "inflater");
        View r1 = r35.inflate(2131563057, r36, false);
        int r2 = 2131362252;
        ItemTextArrow r6 = ViewBindings.findChildViewById(r1, 2131362252);
        if (r6 == null) goto L218;
        r2 = 2131362537;
        ItemTextArrow r7 = ViewBindings.findChildViewById(r1, 2131362537);
        if (r7 == null) goto L218;
        r2 = 2131363583;
        if (ViewBindings.findChildViewById(r1, 2131363583) == null) goto L218;
        r2 = 2131363584;
        ItemTextArrow r8 = ViewBindings.findChildViewById(r1, 2131363584);
        if (r8 == null) goto L218;
        r2 = 2131363585;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131363585);
        if (r9 == null) goto L218;
        r2 = 2131363586;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131363586)) == null) goto L218;
        r2 = 2131364281;
        ItemTextArrow r10 = ViewBindings.findChildViewById(r1, 2131364281);
        if (r10 == null) goto L218;
        r2 = 2131365101;
        ItemTextArrow r11 = ViewBindings.findChildViewById(r1, 2131365101);
        if (r11 == null) goto L218;
        r2 = 2131367721;
        if (ViewBindings.findChildViewById(r1, 2131367721) == null) goto L218;
        r2 = 2131367722;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131367722);
        if (r12 == null) goto L218;
        r2 = 2131367723;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131367723)) == null) goto L218;
        r2 = 2131367771;
        if (((LinearLayout) ViewBindings.findChildViewById(r1, 2131367771)) == null) goto L218;
        r2 = 2131368492;
        ItemTextArrow r13 = ViewBindings.findChildViewById(r1, 2131368492);
        if (r13 == null) goto L218;
        r2 = 2131368535;
        ItemGroup r14 = ViewBindings.findChildViewById(r1, 2131368535);
        if (r14 == null) goto L218;
        r2 = 2131368536;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131368536);
        if (r15 == null) goto L218;
        r2 = 2131368537;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131368537)) == null) goto L218;
        r2 = 2131372048;
        ItemTextArrow r16 = ViewBindings.findChildViewById(r1, 2131372048);
        if (r16 == null) goto L218;
        r2 = 2131372536;
        ItemTextArrow r17 = ViewBindings.findChildViewById(r1, 2131372536);
        if (r17 == null) goto L218;
        LinearLayout r5 = (LinearLayout) r1;
        r2 = 2131379152;
        ItemTextArrow r18 = ViewBindings.findChildViewById(r1, 2131379152);
        if (r18 == null) goto L218;
        r2 = 2131380082;
        ItemTextArrow r19 = ViewBindings.findChildViewById(r1, 2131380082);
        if (r19 == null) goto L218;
        r2 = 2131380322;
        ItemTextArrow r20 = ViewBindings.findChildViewById(r1, 2131380322);
        if (r20 == null) goto L218;
        r2 = 2131380966;
        ItemTextArrow r21 = ViewBindings.findChildViewById(r1, 2131380966);
        if (r21 == null) goto L218;
        r2 = 2131381262;
        ViewStub r22 = (ViewStub) ViewBindings.findChildViewById(r1, 2131381262);
        if (r22 == null) goto L218;
        r2 = 2131381735;
        if (ViewBindings.findChildViewById(r1, 2131381735) == null) goto L218;
        r2 = 2131381736;
        LinearLayout r23 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131381736);
        if (r23 == null) goto L218;
        r2 = 2131381737;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131381737)) == null) goto L218;
        r2 = 2131382193;
        ItemTextArrow r24 = ViewBindings.findChildViewById(r1, 2131382193);
        if (r24 == null) goto L218;
        r2 = 2131382221;
        ItemTextArrow r25 = ViewBindings.findChildViewById(r1, 2131382221);
        if (r25 == null) goto L218;
        r2 = 2131382297;
        ItemTextArrow r26 = ViewBindings.findChildViewById(r1, 2131382297);
        if (r26 == null) goto L218;
        r2 = 2131383047;
        NovaTitleBarEx r3 = ViewBindings.findChildViewById(r1, 2131383047);
        if (r3 == null) goto L218;
        r2 = 2131383471;
        ItemTextArrow r28 = ViewBindings.findChildViewById(r1, 2131383471);
        if (r28 == null) goto L218;
        r2 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r1, 2131385238)) == null) goto L218;
        r2 = 2131387979;
        if (ViewBindings.findChildViewById(r1, 2131387979) == null) goto L218;
        r2 = 2131387980;
        LinearLayout r29 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131387980);
        if (r29 == null) goto L218;
        r2 = 2131387981;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131387981)) == null) goto L218;
        r2 = 2131392726;
        ItemTextArrow r30 = ViewBindings.findChildViewById(r1, 2131392726);
        if (r30 == null) goto L218;
        this.f = new LarusPagePrivacyPermissionBinding(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r3, r28, r29, r30);
        NovaTitleBarEx.Y5(r3, getString(2131909294), null, null, 6);
        NovaTitleBarEx.b6(r3, 2131241477, false, null, null, new i1(this), 14);
        LarusPagePrivacyPermissionBinding r4 = this.f;
        if (r4 != null) goto L77;
    L81:
        LarusPagePrivacyPermissionBinding r27 = this.f;
        if (r27 == null) goto L110;
        FLogger.a.d("PrimacyPermissionFragment", "initAllowTrainingItem,specific training is :" + aa0());
        if (Z90() == false) goto L86;
        com.larus.utils.e1.o(r27.c);
    L109:
        Unit r31 = Unit.INSTANCE;
        goto L110
    L86:
        String r32 = "";
        if (aa0() == false) goto L96;
        ItemTextArrow r33 = r27.c;
        int r34 = lt9.a.a;
        Context r38 = getContext();
        if (r38 == null) goto L94;
        String r39 = r38.getString(2131908517);
        if (r39 == null) goto L94;
        r32 = r39;
    L94:
        r33.setText(r32);
        com.larus.utils.e1.d(r27.c, new e2(this));
        goto L109
    L96:
        if (com.larus.platform.service.z2.a.getAllowTrainingConfig().b() == false) goto L108;
        ItemTextArrow r40 = r27.c;
        int r41 = lt9.a.a;
        Context r42 = getContext();
        if (r42 == null) goto L103;
        String r43 = r42.getString(2131900706);
        if (r43 == null) goto L103;
        r32 = r43;
    L103:
        r40.setText(r32);
        ItemTextArrow r44 = r27.c;
        if (W90().isAllowTraining() == false) goto L106;
        String r45 = Y90();
    L107:
        int r46 = ItemTextArrow.k;
        r44.Z5(r45, null);
        V90(r27.c, new f2(this));
        goto L109
    L106:
        r45 = X90();
        goto L107
    L108:
        com.larus.utils.e1.o(r27.c);
    L110:
        LarusPagePrivacyPermissionBinding r47 = this.f;
        if (r47 != null) goto L113;
    L128:
        LarusPagePrivacyPermissionBinding r48 = this.f;
        if (r48 != null) goto L131;
    L142:
        LarusPagePrivacyPermissionBinding r49 = this.f;
        if (r49 != null) goto L145;
    L152:
        LarusPagePrivacyPermissionBinding r50 = this.f;
        if (r50 != null) goto L155;
    L166:
        LarusPagePrivacyPermissionBinding r51 = this.f;
        if (r51 != null) goto L169;
    L177:
        LarusPagePrivacyPermissionBinding r52 = this.f;
        if (r52 != null) goto L180;
    L191:
        LarusPagePrivacyPermissionBinding r53 = this.f;
        if (r53 == null) goto L194;
        V90(r53.o, new j1(this));
        V90(r53.g, new k1(this));
        V90(r53.u, new l1(this));
        V90(r53.n, new m1(this));
        V90(r53.w, new n1(this));
        V90(r53.i, new o1(this));
        V90(r53.p, new p1(this));
        Unit r54 = Unit.INSTANCE;
    L194:
        LarusPagePrivacyPermissionBinding r55 = this.f;
        if (r55 != null) goto L197;
    L203:
        LarusPagePrivacyPermissionBinding r56 = this.f;
        if (r56 == null) goto L208;
        ViewStub r57 = r56.r;
        if (r57 == null) goto L208;
        ObricPrivacyAndPermissionUiDelegate.b.b(this, r57, new PrivacyPermissionFragment$onCreateView$1$1(this));
    L208:
        LarusPagePrivacyPermissionBinding r58 = this.f;
        if (r58 == null) goto L213;
        ItemGroup r59 = r58.j;
        if (r59 == null) goto L213;
        r59.c();
    L213:
        LarusPagePrivacyPermissionBinding r60 = this.f;
        if (r60 != null) goto L216;
        return null;
    L216:
        return r60.a;
    L197:
        if (com.larus.platform.service.z2.a.getAppsFrameworkConfig().b == true) goto L199;
    L201:
        com.larus.utils.e1.o(r55.e);
    L202:
        Unit r61 = Unit.INSTANCE;
        goto L203
    L199:
        if (AccountService.a.a() == true) goto L201;
        com.larus.utils.e1.x(r55.e);
        W90().fetchAuthorizationCount();
        V90(r55.d, new b2(this));
        goto L202
    L180:
        if (Z90() == false) goto L183;
        com.larus.utils.e1.o(r52.v);
    L190:
        Unit r62 = Unit.INSTANCE;
        goto L191
    L183:
        if (com.larus.platform.service.z2.a.m2() == false) goto L189;
        ItemTextArrow r63 = r52.v;
        if (W90().isPictureLocationEnabled() == false) goto L187;
        String r64 = Y90();
    L188:
        int r65 = ItemTextArrow.k;
        r63.Z5(r64, null);
        V90(r52.v, new z1(this));
        goto L190
    L187:
        r64 = X90();
        goto L188
    L189:
        com.larus.utils.e1.o(r52.v);
        goto L190
    L169:
        if (Z90() == false) goto L171;
        com.larus.utils.e1.o(r51.t);
    L176:
        Unit r66 = Unit.INSTANCE;
        goto L177
    L171:
        ItemTextArrow r67 = r51.t;
        if (W90().isPersonalizedRecommendEnabled() == false) goto L174;
        String r68 = Y90();
    L175:
        int r69 = ItemTextArrow.k;
        r67.Z5(r68, null);
        V90(r51.t, new g2(this));
        goto L176
    L174:
        r68 = X90();
        goto L175
    L155:
        if (Z90() == false) goto L158;
        com.larus.utils.e1.o(r50.l);
    L165:
        Unit r70 = Unit.INSTANCE;
        goto L166
    L158:
        if (com.larus.platform.service.z2.a.hasFaceMemoryFunc() == false) goto L164;
        ItemTextArrow r71 = r50.l;
        if (W90().getFaceMemoryEnabled() == false) goto L162;
        String r72 = Y90();
    L163:
        int r73 = ItemTextArrow.k;
        r71.Z5(r72, null);
        V90(r50.l, new r1(this));
        goto L165
    L162:
        r72 = X90();
        goto L163
    L164:
        com.larus.utils.e1.o(r50.l);
        goto L165
    L145:
        if (Z90() == false) goto L147;
        com.larus.utils.e1.o(r49.h);
    L151:
        Unit r74 = Unit.INSTANCE;
        goto L152
    L147:
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.f() == true) goto L150;
        com.larus.utils.e1.o(r49.h);
        goto L151
    L150:
        com.larus.utils.e1.d(r49.m, new c2(this));
        com.larus.utils.e1.d(r49.b, new d2(this));
        goto L151
    L131:
        if (Z90() == false) goto L134;
        com.larus.utils.e1.o(r48.q);
    L141:
        Unit r75 = Unit.INSTANCE;
        goto L142
    L134:
        if (VoiceCallConfigServiceDelegate.b.b() == false) goto L140;
        com.larus.utils.e1.x(r48.q);
        ItemTextArrow r76 = r48.q;
        if (W90().isRealtimeVoiceFeatureTrainAuthorize() == false) goto L138;
        String r77 = Y90();
    L139:
        r76.Z5(r77, null);
        V90(r48.q, new y1(this));
        goto L141
    L138:
        r77 = X90();
        goto L139
    L140:
        com.larus.utils.e1.o(r48.q);
        goto L141
    L113:
        if (Z90() == false) goto L115;
        com.larus.utils.e1.o(r47.y);
    L127:
        Unit r78 = Unit.INSTANCE;
        goto L128
    L115:
        com.larus.platform.service.z2 r79 = com.larus.platform.service.z2.a;
        if (r79.m3() == true) goto L118;
    L126:
        com.larus.utils.e1.o(r47.y);
        goto L127
    L118:
        if (r79.getAllowTrainingConfig().b() == true) goto L126;
        if (aa0() == true) goto L126;
        ItemTextArrow r80 = r47.y;
        if (W90().isOptOutVoiceEnabled() == false) goto L124;
        String r81 = Y90();
    L125:
        int r82 = ItemTextArrow.k;
        r80.Z5(r81, null);
        V90(r47.y, new h2(this));
        goto L127
    L124:
        r81 = X90();
        goto L125
    L77:
        if (this.i == true) goto L79;
        com.larus.utils.e1.d(r4.f, new g1(this));
    L80:
        Unit r83 = Unit.INSTANCE;
        goto L81
    L79:
        com.larus.utils.e1.o(r4.s);
    L218:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public final void ba0(View r9, String r10, String r11, String r12, String r13, String r14) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L7;
        r0.S();
        if (com.larus.home.impl.sdk.c1.a.a() != true) goto L7;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L16;
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, "message");
        c r2 = new c(this, r10);
        Intrinsics.checkNotNullParameter(r2, "listener");
        d r3 = new d(r10);
        Intrinsics.checkNotNullParameter(r3, "listener");
        e r15 = new e();
        Intrinsics.checkNotNullParameter(r15, "listener");
        int r16 = ContextCompat.getColor(r9.getContext(), v19.c.b(2130972079, r9.getContext(), 2131103136));
        AccessibilityCommonDialog r4 = new AccessibilityCommonDialog();
        r4.e = r11;
        r4.g = r12;
        r4.h = null;
        r4.i = r14;
        r4.m = r2;
        r4.n = null;
        r4.k = false;
        r4.l = true;
        r4.o = r13;
        r4.p = r3;
        r4.q = r15;
        r4.s = false;
        r4.r = null;
        r4.t = true;
        r4.u = null;
        r4.v = null;
        r4.w = null;
        r4.x = null;
        r4.y = true;
        r4.z = null;
        r4.A = null;
        r4.B = null;
        r4.C = false;
        r4.f = true;
        r4.j = r16;
        FragmentManager r17 = getChildFragmentManager();
        LandscapeRestrictionOperation r18 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, null, r18);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r4, r18) == true) goto L28;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L14:
        r4.show(r17, null);
        return;
    L28:
        return;
    L16:
        CommonDialog.a r5 = new CommonDialog.a();
        Intrinsics.checkNotNullParameter(r11, "title");
        r5.a = r11;
        Intrinsics.checkNotNullParameter(r12, "message");
        r5.i = r12;
        CommonDialog.a.f(r5, new f(this, r10), r14, false, 12);
        CommonDialog.a.e(r5, new g(r10), r13, 4);
        h r19 = new h();
        Intrinsics.checkNotNullParameter(r19, "listener");
        r5.v = r19;
        r5.t = true;
        CommonDialog r20 = r5.b(ContextCompat.getColor(r9.getContext(), 2131103136));
        FragmentManager r110 = getChildFragmentManager();
        LandscapeRestrictionOperation r111 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r20, null, r111);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r20, r111) == true) goto L29;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L20:
        r20.show(r110, null);
        return;
    L29:
        return;
    L7:
        r1 = false;
        goto L9
    }
}
