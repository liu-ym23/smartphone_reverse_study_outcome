package com.larus.dora.impl.device;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.wlan.direct.WifiDirectOwnerProxy;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.databinding.LarusDoraDeviceBatteryLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceDisconnectedLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraDeviceScanLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraPageDeviceBinding;
import com.larus.dora.impl.databinding.LarusDoraSodaVipBannerBinding;
import com.larus.dora.impl.device.battery.DoraDeviceBoxBattery;
import com.larus.dora.impl.device.scan.ScanDeviceDialog;
import com.larus.dora.impl.device.settings.DoraUnbindBaseFragment;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.onboarding.dialog.DoraOnboardingAudioSettingDialog;
import com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingConnectDialogFragment;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Deprecated(message = "This fragment is deprecated. See DoraDynamicFragment.")
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004*\u0002),\b\u0007\u0018\u0000 b2\u00020\u00012\u00020\u0002:\u0001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020\u0019H\u0002J\u001a\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u000eH\u0002J\b\u0010>\u001a\u00020\u0019H\u0016J\b\u0010?\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0019H\u0016J\b\u0010B\u001a\u00020\u0019H\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u000eH\u0016J\b\u0010G\u001a\u00020\u0019H\u0002J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020MH\u0002J\u001a\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u000e2\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\b\u0010R\u001a\u00020\u0019H\u0002J\b\u0010S\u001a\u00020\u0019H\u0002J \u0010T\u001a\u00020\u00192\b\b\u0002\u0010U\u001a\u00020D2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\b\u0010W\u001a\u00020\u0019H\u0002J\u0010\u0010X\u001a\u00020\u00192\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010Y\u001a\u00020\u0019H\u0002J\u001a\u0010Z\u001a\u00020\u00192\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010[\u001a\u00020\u000eH\u0002J\b\u0010\\\u001a\u00020\u0019H\u0002J \u0010]\u001a\u00020\u00192\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020_H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-¨\u0006c"}, d2 = {"Lcom/larus/dora/impl/device/DoraDeviceFragment;", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "Lcom/bytedance/dora/wlan/direct/IWifiDirect$IWifiDirectStateCallback;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageDeviceBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/DoraDeviceViewModel;", "getModel", "()Lcom/larus/dora/impl/device/DoraDeviceViewModel;", "model$delegate", "Lkotlin/Lazy;", "isDarkMode", "", "keepAliveBalloon", "Lcom/skydoves/balloon/Balloon;", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "gpsDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "isChecking", "pendingCheckAction", "Lkotlin/Function0;", "", "unbindDialog", "connectFailedDialog", "Lcom/larus/dora/impl/device/DoraDeviceConnectFailedDialog;", "isFirst", "onboardingDialogFragment", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment;", "lastOnboardingDialogFragment", "Landroidx/fragment/app/Fragment;", "pendingShowAudioSettingDialog", "hasOnboarding", "isFragmentStarted", "isProactivePermissionChecked", "mainHandler", "Landroid/os/Handler;", "fragmentLifecycleCallbacks", "com/larus/dora/impl/device/DoraDeviceFragment$fragmentLifecycleCallbacks$1", "Lcom/larus/dora/impl/device/DoraDeviceFragment$fragmentLifecycleCallbacks$1;", "broadcastReceiver", "com/larus/dora/impl/device/DoraDeviceFragment$broadcastReceiver$1", "Lcom/larus/dora/impl/device/DoraDeviceFragment$broadcastReceiver$1;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "openHotspotSettings", "onViewCreated", "view", "updateKeepAliveBalloonVisibility", "shouldShow", "onStart", "onResume", "onStop", "onDestroyView", "onDetach", "getCurrentPageName", "", "onDoraConnectStateChanged", "isConnected", "showScanUi", "showDeviceInfoUi", "device", "Lcom/bytedance/dora/device/DoraDevice;", "checkProactivePermission", "settings", "Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "showDisconnectedUi", "isRetrying", "lastConnectedDevice", "Lcom/larus/dora/impl/DoraSimpleDevice;", "showConnectFailedDialog", "dismissConnectFailedDialog", "checkReady", "from", "doNext", "handleScanForALongTime", "showUnbindDialog", "dismissUnbindDialog", "launchOnboarding", "autoConnect", "updateWlanUI", "onStateChanged", "p0", "", "p1", "reason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceFragment extends DoraUnbindBaseFragment implements com.bytedance.dora.wlan.direct.a.a {
    public static final /* synthetic */ int z = 0;
    public LarusDoraPageDeviceBinding g;
    public final Lazy h;
    public boolean i;
    public Balloon j;
    public ActivityResultLauncher<Intent> k;
    public CommonDialog l;
    public boolean m;
    public Function0<Unit> n;
    public CommonDialog o;
    public DoraDeviceConnectFailedDialog p;
    public DoraLiteOnboardingConnectDialogFragment q;
    public Fragment r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public final Handler w;
    public final DoraDeviceFragment$fragmentLifecycleCallbacks$1 x;
    public final DoraDeviceFragment$broadcastReceiver$1 y;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraDeviceFragment a;

        public b(DoraDeviceFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            com.larus.dora.impl.device.c r9 = (com.larus.dora.impl.device.c) r7;
            DoraLiteOnboardingConnectDialogFragment r10 = this.a.q;
            if (r10 == null) goto L7;
            boolean r0 = true;
            if (r10.isVisible() != true) goto L7;
        L9:
            if (r0 == false) goto L11;
        L39:
            g49.d.d("DoraDeviceFragment", "deviceStateFlow collect ignore ## in onboarding ##");
            return Unit.INSTANCE;
        L11:
            if (com.larus.dora.impl.onboarding.d.a() == true) goto L39;
            if (Intrinsics.areEqual(r9, com.larus.dora.impl.device.c.C0034c.a) == true) goto L41;
            int r1 = -1;
            if (Intrinsics.areEqual(r9, com.larus.dora.impl.device.c.d.a) == false) goto L21;
            DoraDeviceFragment r11 = this.a;
            r11.getClass();
            g49.d.d("DoraDeviceFragment", "showScanUi");
            r11.da0();
            r11.ca0();
            LarusDoraPageDeviceBinding r12 = r11.g;
            if (r12 == null) goto L41;
            DoraNovaTitleBarEx r2 = r12.e;
            DoraNovaTitleBarEx.S5(r2, r11.getString(2131902437));
            r2.getBinding().d.setVisibility(8);
            LarusDoraDeviceInfoLayoutBinding r13 = r12.c;
            Lazy r3 = DoraDeviceLayoutInfoKt.a;
            Intrinsics.checkNotNullParameter(r13, "<this>");
            e1.o(r13.a);
            DoraDeviceBoxBattery.c = -1;
            DoraDeviceBoxBattery.c();
            DoraDeviceBoxBattery.e = null;
            final LarusDoraDeviceScanLayoutBinding r14 = r12.d;
            Intrinsics.checkNotNullParameter(r14, "<this>");
            e1.x(r14.a);
            int r4 = com.larus.utils.i.c(r14.a.getContext());
            DoraMovieView r5 = r14.e;
            ViewGroup.LayoutParams r6 = r5.getLayoutParams();
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r6;
            float r16 = r4;
            int r17 = (int) (0.43f * r16);
            ((ViewGroup.MarginLayoutParams) r15).width = r17;
            ((ViewGroup.MarginLayoutParams) r15).height = r17;
            ((ViewGroup.MarginLayoutParams) r15).topMargin = (int) (0.1f * r16);
            r5.setLayoutParams(r15);
            AppCompatImageView r18 = r14.d;
            ViewGroup.LayoutParams r20 = r18.getLayoutParams();
            Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
            ((ViewGroup.MarginLayoutParams) r21).topMargin = (int) (r16 * 0.09f);
            r18.setLayoutParams(r21);
            e1.d(r14.b, new r0(r14));
            LarusDoraDeviceDisconnectedLayoutBinding r22 = r12.b;
            Intrinsics.checkNotNullParameter(r22, "<this>");
            e1.o(r22.a);
            goto L41
        L21:
            if ((r9 instanceof com.larus.dora.impl.device.c.a) == false) goto L34;
            DoraDeviceFragment.Y90(this.a, ((com.larus.dora.impl.device.c.a) r9).b);
            wj4.a r23 = wj4.a.a.a;
            DoraDevice r24 = ak4.a.d().current();
            if (r24 == null) goto L26;
            r1 = r24.type;
        L26:
            if (r1 != 16) goto L30;
            DoraDeviceFragment r25 = this.a;
            LarusDoraPageDeviceBinding r26 = r25.g;
            if (r26 == null) goto L41;
            e1.x(r26.c.x);
            r25.fa0();
            goto L41
        L30:
            LarusDoraPageDeviceBinding r27 = this.a.g;
            if (r27 == null) goto L41;
            e1.o(r27.c.x);
            goto L41
        L34:
            if ((r9 instanceof com.larus.dora.impl.device.c.b) == false) goto L37;
            com.larus.dora.impl.device.c.b r28 = (com.larus.dora.impl.device.c.b) r9;
            DoraDeviceFragment.Z90(this.a, r28.a, r28.b);
            goto L41
        L37:
            throw new NoWhenBranchMatchedException();
        L41:
            return Unit.INSTANCE;
        L7:
            r0 = false;
            goto L9
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraDeviceFragment a;

        public c(DoraDeviceFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            com.larus.dora.impl.device.a r9 = (com.larus.dora.impl.device.a) r7;
            boolean r0 = false;
            if (Intrinsics.areEqual(r9, com.larus.dora.impl.device.a.c.a) == false) goto L14;
            LarusDoraPageDeviceBinding r10 = this.a.g;
            if (r10 == null) goto L46;
            LarusDoraDeviceScanLayoutBinding r11 = r10.d;
            if (r11 == null) goto L46;
            Intrinsics.checkNotNullParameter(r11, "<this>");
            if (r11.a.getVisibility() != 0) goto L11;
            r0 = true;
        L11:
            if (r0 == false) goto L46;
            e1.x(r11.c);
        L46:
            return Unit.INSTANCE;
        L14:
            if ((r9 instanceof com.larus.dora.impl.device.a.b) == false) goto L21;
            DoraDeviceFragment r12 = this.a;
            DoraDevice r13 = ((com.larus.dora.impl.device.a.b) r9).a;
            int r1 = DoraDeviceFragment.z;
            r12.da0();
            CommonDialog.a r2 = new CommonDialog.a();
            r2.i(r12.getString(2131902447));
            r2.g(r12.getString(2131902446));
            CommonDialog.a.f(r2, new w(r12, r13), r12.getString(2131902418), false, 12);
            CommonDialog.a.e(r2, new x(r12), r12.getString(2131902465), 4);
            r2.z = false;
            Function0<Boolean> r14 = new s();
            Intrinsics.checkNotNullParameter(r14, "callback");
            r2.B = r14;
            CommonDialog r15 = r2.a();
            r12.o = r15;
            FragmentManager r16 = r12.getChildFragmentManager();
            LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, null, r3);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r15, r3) == true) goto L46;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L49
        L19:
            r15.show(r16, null);
            goto L46
        L21:
            if ((r9 instanceof com.larus.dora.impl.device.a.C0031a) == false) goto L38;
            DoraDeviceFragment r17 = this.a;
            com.larus.dora.impl.device.a.C0031a r18 = (com.larus.dora.impl.device.a.C0031a) r9;
            DoraDevice r4 = r18.a;
            boolean r20 = r18.b;
            int r5 = DoraDeviceFragment.z;
            r17.ca0();
            g49.d.d("DoraDeviceFragment", "launchOnboarding: " + o59.a.h(r4));
            DoraLiteOnboardingConnectDialogFragment r6 = r17.q;
            if (r6 == null) goto L31;
            r17.r = r6;
            r6.dismissAllowingStateLoss();     // Catch: Exception -> L27
        L27:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r21 = DialogFragmentLancet.sLastShowStack;
            if (r21 == null) goto L31;
            com.bytedance.crash.d.d(r21, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        L31:
            DoraLiteOnboardingConnectDialogFragment r22 = new DoraLiteOnboardingConnectDialogFragment();
            r22.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_onboarding_device", com.larus.dora.impl.onboarding.x.c(r4)), TuplesKt.to("key_dora_onboarding_auto_connect", Boolean.valueOf(r20))}));
            FragmentManager r23 = r17.getParentFragmentManager();
            LandscapeRestrictionOperation r24 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r22, "DoraOnboardingDeviceFoundDialogFragment", r24);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r23, r22, r24) == false) goto L56;
        L36:
            r17.q = r22;
            goto L46
        L56:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
        L35:
            r22.show(r23, "DoraOnboardingDeviceFoundDialogFragment");
            goto L36
        L38:
            if (Intrinsics.areEqual(r9, com.larus.dora.impl.device.a.d.a) == false) goto L48;
            DoraDeviceFragment r25 = this.a;
            int r26 = DoraDeviceFragment.z;
            r25.ca0();
            DoraDeviceConnectFailedDialog r27 = new DoraDeviceConnectFailedDialog();
            FragmentManager r28 = r25.getChildFragmentManager();
            LandscapeRestrictionOperation r30 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r27, "ConnectFailedDialog", r30);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r28, r27, r30) == false) goto L52;
        L44:
            r25.p = r27;
            goto L46
        L52:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L51
        L43:
            r27.show(r28, "ConnectFailedDialog");
            goto L44
        L48:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraDeviceFragment a;

        public d(DoraDeviceFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            boolean r4 = ((Boolean) r2).booleanValue();
            DoraLiteOnboardingConnectDialogFragment r5 = this.a.q;
            if (r5 == null) goto L7;
            boolean r0 = true;
            if (r5.isVisible() != true) goto L7;
        L8:
            if (r0 == false) goto L10;
        L15:
            g49.d.d("DoraDeviceFragment", "DoraKeepAliveBalloon collect " + r4 + " ignore ## in onboarding ## sStartOnboarding=" + com.larus.dora.impl.onboarding.d.a() + ",hasOnboarding=" + this.a.t);
            return Unit.INSTANCE;
        L10:
            if (com.larus.dora.impl.onboarding.d.a() == true) goto L15;
            DoraDeviceFragment r6 = this.a;
            if (r6.t == true) goto L15;
            DoraDeviceFragment.aa0(r6, r4);
            return Unit.INSTANCE;
        L7:
            r0 = false;
            goto L8
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ DoraDeviceFragment a;

        public e(DoraDeviceFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            com.larus.dora.impl.network.a r5 = (com.larus.dora.impl.network.a) r3;
            String r6 = ILoginService.a.getAccountInfo().c;
            g49.d.d("DoraDeviceFragment", "sodaBannerSharedFlow ishow " + r5.a());
            if (r5.a() == false) goto L11;
            com.larus.dora.impl.util.b0.a.getClass();
            com.larus.dora.impl.util.b0.J(true, r6);
            LarusDoraPageDeviceBinding r7 = this.a.g;
            if (r7 == null) goto L19;
            LarusDoraDeviceInfoLayoutBinding r8 = r7.c;
            if (r8 == null) goto L19;
            LarusDoraSodaVipBannerBinding r9 = r8.w;
            if (r9 == null) goto L19;
            DoraDeviceLayoutInfoKt.a(r9, r5.getType());
        L19:
            return Unit.INSTANCE;
        L11:
            com.larus.dora.impl.util.b0.a.getClass();
            com.larus.dora.impl.util.b0.J(false, r6);
            LarusDoraPageDeviceBinding r10 = this.a.g;
            if (r10 == null) goto L19;
            LarusDoraDeviceInfoLayoutBinding r11 = r10.c;
            if (r11 == null) goto L19;
            LarusDoraSodaVipBannerBinding r12 = r11.w;
            if (r12 == null) goto L19;
            Lazy r13 = DoraDeviceLayoutInfoKt.a;
            Intrinsics.checkNotNullParameter(r12, "<this>");
            r12.a.setVisibility(8);
            goto L19
        }
    }

    public static final class f<T> implements FlowCollector {
        public final /* synthetic */ DoraDeviceFragment a;

        public f(DoraDeviceFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            com.larus.dora.impl.device.b r7 = (com.larus.dora.impl.device.b) r5;
            if ((r7 instanceof com.larus.dora.impl.device.b.C0033b) == false) goto L39;
            com.larus.dora.impl.device.b.C0033b r8 = (com.larus.dora.impl.device.b.C0033b) r7;
            DoraPushSummaryConfig r0 = r8.b;
            DoraUserSettingsManager r1 = DoraUserSettingsManager.a;
            IObricDoraService r2 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
            boolean r3 = true;
            if (r2 != null) goto L7;
        L9:
            boolean r4 = false;
        L10:
            if (r4 == false) goto L13;
        L19:
            r3 = false;
        L20:
            g49.d.d("DoraDeviceFragment", "deviceFeatureStateFlow#collect, feature=" + r7 + ", isProactivePermissionChecked=" + this.a.v);
            if (r3 == false) goto L28;
            LarusDoraPageDeviceBinding r9 = this.a.g;
            if (r9 == null) goto L27;
            LarusDoraDeviceInfoLayoutBinding r10 = r9.c;
            if (r10 == null) goto L27;
            Lazy r11 = DoraDeviceLayoutInfoKt.a;
            Intrinsics.checkNotNullParameter(r10, "<this>");
            e1.x(r10.s);
        L27:
            DoraDeviceFragment r12 = this.a;
            r12.w.postDelayed(new v(r12, r0), 300);
        L33:
            LarusDoraPageDeviceBinding r13 = this.a.g;
            if (r13 == null) goto L39;
            LarusDoraDeviceInfoLayoutBinding r14 = r13.c;
            if (r14 == null) goto L39;
            DoraDeviceLayoutInfoKt.d(r14);
            goto L39
        L28:
            LarusDoraPageDeviceBinding r15 = this.a.g;
            if (r15 == null) goto L33;
            LarusDoraDeviceInfoLayoutBinding r16 = r15.c;
            if (r16 == null) goto L33;
            Lazy r17 = DoraDeviceLayoutInfoKt.a;
            Intrinsics.checkNotNullParameter(r16, "<this>");
            e1.o(r16.s);
            goto L33
        L13:
            if (r8.a.b("startVUI") == false) goto L19;
            if (r0.getNotificationSummary() == true) goto L20;
            if (r0.getProactiveMessage() == false) goto L19;
        L7:
            if (r2.n() != true) goto L9;
            r4 = true;
        L39:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
    }

    public final String k() {
        return "device_manage";
    }

    public final void Xb() {
        com.larus.utils.y.c(new t(this));
    }

    public final void ca0() {
        DoraDeviceConnectFailedDialog r0 = this.p;
        if (r0 != null) goto L12;
    L10:
        this.p = null;
        return;
    L12:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final void da0() {
        CommonDialog r0 = this.o;
        if (r0 == null) goto L14;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L10:
        this.o = null;
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final DoraDeviceViewModel ea0() {
        return (DoraDeviceViewModel) this.h.getValue();
    }

    public final void fa0() {
        int r0 = wk4.a.a;
        int r1 = WifiDirectOwnerProxy.k;
        int r2 = WifiDirectOwnerProxy.a.a.t();
        g49.d.d("DoraDeviceFragment", "updateWlanUI: state=" + r2);
        LarusDoraPageDeviceBinding r3 = this.g;
        if (r3 == null) goto L14;
        LarusDoraDeviceInfoLayoutBinding r4 = r3.c;
        if (r4 == null) goto L15;
        ItemTextArrow r5 = r4.y;
        if (r5 != null) goto L9;
        return;
    L9:
        if (r2 != 1) goto L11;
        int r6 = 2131902454;
    L12:
        String r7 = getString(r6);
        int r8 = ItemTextArrow.k;
        r5.Z5(r7, null);
        r5.setVisible(true);
        return;
    L11:
        r6 = 2131902421;
        goto L12
    L15:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.dora.impl.device.DoraDeviceFragment$fragmentLifecycleCallbacks$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.dora.impl.device.DoraDeviceFragment$broadcastReceiver$1] */
    public DoraDeviceFragment() {
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraDeviceViewModel.class), new DoraDeviceFragment$special$$inlined$activityViewModels$default$1(this), new DoraDeviceFragment$special$$inlined$activityViewModels$default$2(this));
        boolean r0 = v19.h.a;
        this.i = v19.h.a(null);
        this.n = new n();
        this.w = new Handler(Looper.getMainLooper());
        this.x = new DoraDeviceFragment$fragmentLifecycleCallbacks$1(this);
        this.y = new DoraDeviceFragment$broadcastReceiver$1(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        LarusDoraPageDeviceBinding r0 = this.g;
        if (r0 == null) goto L7;
        LarusDoraDeviceScanLayoutBinding r1 = r0.d;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.e.f();
    L7:
        LarusDoraPageDeviceBinding r2 = this.g;
        if (r2 == null) goto L12;
        LarusDoraDeviceInfoLayoutBinding r3 = r2.c;
        if (r3 == null) goto L12;
        Lazy r4 = DoraDeviceLayoutInfoKt.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        DoraDeviceBoxBattery.c = -1;
        DoraDeviceBoxBattery.c();
        DoraDeviceBoxBattery.e = null;
    L12:
        this.t = false;
        Context r5 = getContext();
        if (r5 == null) goto L15;
        LocalBroadcastManager.getInstance(r5).unregisterReceiver(this.y);
    L15:
        Balloon r6 = this.j;
        if (r6 == null) goto L18;
        r6.h();
    L18:
        this.j = null;
        CommonDialog r7 = this.l;
        if (r7 != null) goto L29;
    L27:
        da0();
        getParentFragmentManager().unregisterFragmentLifecycleCallbacks(this.x);
        int r8 = wk4.a.a;
        int r9 = WifiDirectOwnerProxy.k;
        WifiDirectOwnerProxy.a.a.getClass();
        ((CopyOnWriteArraySet) com.bytedance.dora.wlan.direct.a.q1).remove(this);
        return;
    L29:
        r7.dismissAllowingStateLoss();     // Catch: Exception -> L22
    L26:
        this.l = null;
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L26;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L26
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        ActivityResultLauncher<Intent> r0 = this.k;
        if (r0 == null) goto L6;
        r0.unregister();
        return;
    }

    public final void onResume() {
        super.onResume();
        com.larus.utils.y.c(new p(this));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        g49.d.d("DoraDeviceFragment", "onStart");
        this.u = true;
        if (this.s == true) goto L5;
    L7:
        ba0("check_from_MAIN", new m(this));
        return;
    L5:
        if ((ea0().getDeviceStateFlow().getValue() instanceof com.larus.dora.impl.device.c.a) == false) goto L7;
        this.s = false;
        X90(new DoraOnboardingAudioSettingDialog(), getChildFragmentManager());
        goto L7
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        super.onStop();
        g49.d.d("DoraDeviceFragment", "onStop");
        this.u = false;
        ea0().stopConnectAndScan("onStop");
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new o(this));
    }

    public static void W90(ScanDeviceDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "find_device", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "find_device");
    }

    public static void X90(DoraOnboardingAudioSettingDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "OnboardingAudioSetting", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "OnboardingAudioSetting");
    }

    public static final void Y90(final DoraDeviceFragment r110, final DoraDevice r20) {
        r110.getClass();
        g49.d.d("DoraDeviceFragment", "showDeviceInfoUi: device=" + r20);
        r110.ca0();
        LarusDoraPageDeviceBinding r2 = r110.g;
        if (r2 == null) goto L186;
        DoraNovaTitleBarEx r3 = r2.e;
        DoraNovaTitleBarEx.S5(r3, r110.getString(2131902437));
        DoraNovaTitleBarEx.U5(r3, new q(r110));
        LarusDoraDeviceScanLayoutBinding r4 = r2.d;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        e1.o(r4.c);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4.e.f();
        e1.o(r4.a);
        final LarusDoraDeviceInfoLayoutBinding r5 = r2.c;
        LifecycleCoroutineScope r6 = LifecycleOwnerKt.getLifecycleScope(r110);
        boolean r7 = r110.i;
        final View r8 = r2.f;
        Lazy r9 = DoraDeviceLayoutInfoKt.a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r8, "titleBackgroundView");
        e1.x(r5.a);
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = new int[]{-1, -1, -1};
        int[] r11 = {0, 0, 0};
        String r14 = "";
        if (r20 == null) goto L20;
        String r12 = o59.a.d(r20);
        r10.element = o59.a.a(r20);
        int[] r15 = o59.a.b(r20);
        int[] r13 = (int[]) r10.element;
        int r16 = r13[0];
        if (r16 < 0) goto L10;
        if (r16 >= 101) goto L10;
        boolean r17 = true;
    L11:
        int r18 = r13[1];
        if (r18 < 0) goto L15;
        if (r18 >= 101) goto L15;
        boolean r111 = true;
    L16:
        int r112 = r13[2];
        if (r112 < 0) goto L21;
        if (r112 >= 101) goto L21;
        boolean r113 = true;
    L22:
        if (r7 == false) goto L31;
        e1.x(r5.i);
        if (r5.o.getScrollY() <= 0) goto L26;
        boolean r114 = true;
    L27:
        if (r114 == false) goto L29;
        e1.x(r8);
    L30:
        r5.o.setOnScrollChangeListener(new f0(r8));
    L32:
        ItemTextArrow r0 = r5.p;
        int r21 = ItemTextArrow.k;
        r0.Z5(r12, null);
        r5.p.setVisible(true);
        if (r20 != null) goto L35;
        String r1 = "";
    L37:
        if (r1.length() != 0) goto L39;
        boolean r22 = true;
    L40:
        if (r22 == false) goto L42;
        r5.j.U5();
    L44:
        if (r20 != null) goto L46;
    L48:
        boolean r23 = false;
    L50:
        if (r23 == false) goto L52;
        int r24 = ((int[]) r10.element)[0];
    L59:
        if (r17 == false) goto L65;
        LarusDoraDeviceBatteryLayoutBinding r25 = r5.e;
        if (r15[0] != 1) goto L63;
        boolean r26 = true;
    L64:
        DoraDeviceLayoutInfoKt.b(r25, r7, r26, r24);
    L66:
        if (r20 != null) goto L68;
    L70:
        boolean r27 = false;
    L71:
        if (r27 == false) goto L73;
        int r28 = ((int[]) r10.element)[1];
    L81:
        if (r111 == false) goto L87;
        LarusDoraDeviceBatteryLayoutBinding r30 = r5.f;
        if (r15[1] != 1) goto L85;
        boolean r31 = true;
    L86:
        DoraDeviceLayoutInfoKt.b(r30, r7, r31, r28);
    L88:
        if (r20 == null) goto L113;
        if (r113 == true) goto L113;
        String r32 = r20.mac;
        if (r32 != null) goto L94;
        r32 = r20.sn;
    L94:
        if (r32 != null) goto L96;
    L99:
        boolean r33 = true;
    L101:
        if (r33 == false) goto L103;
        int r34 = -1;
    L104:
        if (r34 >= 0) goto L106;
    L108:
        boolean r35 = false;
    L109:
        if (r35 == false) goto L111;
        e1.x(r5.d.a);
        DoraDeviceLayoutInfoKt.b(r5.d, r7, false, r34);
    L112:
        Integer r115 = null;
        boolean r116 = false;
    L149:
        DoraSKU.a r36 = DoraSKU.Companion;
        if (r20 == null) goto L152;
        Integer r37 = Integer.valueOf(r20.sku);
    L153:
        DoraSKU r38 = DoraSKU.a.b(r36, r37);
        StringBuilder r40 = new StringBuilder("DoraPageDeviceInfoBinding sku=");
        if (r20 == null) goto L156;
        Integer r41 = Integer.valueOf(r20.sku);
    L157:
        r40.append(r41);
        r40.append(", doraSku=");
        r40.append(r38);
        g49.d.d("DoraDeviceLayoutInfo", r40.toString());
        ImageView r42 = r5.m;
        DoraResourceUtil r43 = DoraResourceUtil.a;
        r42.setImageBitmap(DoraResourceUtil.c(DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_LEFT.fileName(r38, r7)));
        r5.n.setImageBitmap(DoraResourceUtil.c(DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_RIGHT.fileName(r38, r7)));
        r5.l.setImageBitmap(DoraResourceUtil.c(DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_BOX.fileName(r38, r7)));
        String r44 = ILoginService.a.getAccountInfo().c;
        com.larus.dora.impl.util.b0.a.getClass();
        if (com.larus.dora.impl.util.b0.f(r44) == false) goto L160;
        boolean r45 = true;
        DoraDeviceLayoutInfoKt.a(r5.w, 1);
    L162:
        if (((Boolean) DoraDeviceLayoutInfoKt.a.getValue()).booleanValue() == false) goto L170;
        if (r20 != null) goto L165;
    L167:
        boolean r117 = false;
    L168:
        if (r117 == false) goto L170;
        e1.x(r5.q);
        r5.k.setBackgroundResource(2131239218);
    L171:
        if (r20 != null) goto L173;
    L175:
        if (r116 == true) goto L183;
        if (r20 == null) goto L178;
        Integer r46 = Integer.valueOf(r20.productId);
    L180:
        if (o59.a.o(r46) == true) goto L183;
        e1.o(r5.h);
        r5.j.setBackgroundResource(2131239215);
    L184:
        r110.fa0();
        LarusDoraDeviceDisconnectedLayoutBinding r47 = r2.b;
        Intrinsics.checkNotNullParameter(r47, "<this>");
        e1.o(r47.a);
        return;
    L178:
        r46 = r115;
    L183:
        e1.x(r5.h);
        r5.j.setBackgroundResource(2131239218);
        goto L184
    L173:
        if (r20.productId != ProductNameType.DORA_E.id) goto L175;
        r116 = true;
        goto L175
    L165:
        if (o59.a.w(r20) != r45) goto L167;
        r117 = true;
    L170:
        e1.o(r5.q);
        r5.k.setBackgroundResource(2131239212);
        goto L171
    L160:
        r45 = true;
        goto L162
    L156:
        r41 = r115;
        goto L157
    L152:
        r37 = r115;
        goto L153
    L111:
        DoraDeviceBoxBattery.c = -1;
        DoraDeviceBoxBattery.c();
        DoraDeviceBoxBattery.e = null;
        e1.o(r5.d.a);
        goto L112
    L106:
        if (r34 >= 101) goto L108;
        r35 = true;
        goto L109
    L103:
        Lazy r48 = com.larus.dora.impl.device.battery.k.a;
        r34 = com.larus.dora.impl.device.battery.k.g(r32);
        goto L104
    L96:
        if (r32.length() == 0) goto L99;
        r33 = false;
    L113:
        e1.x(r5.d.a);
        if (r113 == false) goto L148;
        LarusDoraDeviceBatteryLayoutBinding r50 = r5.d;
        if (r15[2] != 1) goto L118;
        boolean r51 = true;
    L119:
        r50.a.setAlpha(1.0f);
        LottieAdapterView r52 = r50.c;
        Intrinsics.checkNotNull(r52);
        e1.x(r52);
        if (r7 == false) goto L124;
        if (r51 == false) goto L123;
        String r118 = "charging_dark";
    L128:
        if (r52.getComposition() == null) goto L138;
        String r119 = r52.getImageAssetsFolder();
        r115 = null;
        if (r119 == null) goto L134;
        r116 = false;
        if (StringsKt.contains$default(r119, r118, false, 2, null) == true) goto L135;
        boolean r120 = true;
    L136:
        if (r120 == true) goto L139;
    L143:
        e1.o(r50.d);
        Job r53 = DoraDeviceBoxBattery.a;
        int r54 = ((int[]) r10.element)[2];
        if (r15[2] != 1) goto L146;
        boolean r55 = true;
    L147:
        DoraDeviceBoxBattery.b(r6, r54, r55, new g0(r20, r10, r5));
        goto L149
    L146:
        r55 = false;
    L139:
        if (r51 == false) goto L141;
        String r56 = "charging";
    L142:
        r52.setContentDescription(r56);
        r52.setAnimation(r118.concat("/data.json"));
        r52.setImageAssetsFolder(r118.concat("/images/"));
        goto L143
    L141:
        r56 = "not charging";
    L135:
        r120 = false;
        goto L136
    L134:
        r116 = false;
        goto L135
    L138:
        r115 = null;
        r116 = false;
        goto L139
    L123:
        r118 = "default_dark";
        goto L128
    L124:
        if (r51 == false) goto L126;
        r118 = "charging_light";
        goto L128
    L126:
        r118 = "default_light";
        goto L128
    L118:
        r51 = false;
        goto L119
    L148:
        r115 = null;
        r116 = false;
        DoraDeviceLayoutInfoKt.c(r5.d);
        goto L149
    L85:
        r31 = false;
        goto L86
    L87:
        DoraDeviceLayoutInfoKt.c(r5.f);
        goto L88
    L73:
        Lazy r57 = com.larus.dora.impl.device.battery.k.a;
        if (r20 == null) goto L76;
        String r58 = r20.sn;
    L77:
        if (r58 == null) goto L80;
        r14 = r58;
    L80:
        r28 = com.larus.dora.impl.device.battery.k.f(r14, (int[]) r10.element, r15, "UI");
        goto L81
    L76:
        r58 = null;
        goto L77
    L68:
        if (r20.vendorId != 4096) goto L70;
        r27 = true;
        goto L71
    L63:
        r26 = false;
        goto L64
    L65:
        DoraDeviceLayoutInfoKt.c(r5.e);
        goto L66
    L52:
        Lazy r60 = com.larus.dora.impl.device.battery.k.a;
        if (r20 == null) goto L55;
        String r61 = r20.sn;
    L56:
        if (r61 != null) goto L58;
        r61 = "";
    L58:
        r24 = com.larus.dora.impl.device.battery.k.d(r61, (int[]) r10.element, r15, "UI");
        goto L59
    L55:
        r61 = null;
        goto L56
    L46:
        if (r20.vendorId != 4096) goto L48;
        r23 = true;
        goto L50
    L42:
        r5.j.i6("");
        goto L44
    L39:
        r22 = false;
        goto L40
    L35:
        com.larus.dora.impl.ota.b r62 = com.larus.dora.impl.ota.b.a;
        r1 = com.larus.dora.impl.ota.b.a(r20);
        goto L37
    L29:
        e1.o(r8);
        goto L30
    L26:
        r114 = false;
        goto L27
    L31:
        e1.x(r8);
        e1.o(r5.i);
    L21:
        r113 = false;
    L15:
        r111 = false;
    L10:
        r17 = false;
        goto L11
    L20:
        r15 = r11;
        r12 = "";
        r111 = false;
        r17 = false;
        goto L21
    }

    public static final void aa0(final DoraDeviceFragment r2, final boolean r3) {
        r2.getClass();
        g49.d.d("DoraDeviceFragment", "updateKeepAliveBalloonVisibility: " + r3);
        LarusDoraPageDeviceBinding r0 = r2.g;
        if (r0 == null) goto L8;
        ConstraintLayout r1 = r0.e;
        if (r1 == null) goto L9;
        r1.post(new j(r3, r2));
        return;
    L9:
        return;
    }

    public final void ba0(String r8, Function0<Unit> r9) {
        g49.d.d("DoraDeviceFragment", "checkReady: " + r8 + " start");
        if (Intrinsics.areEqual(r8, "check_from_MAIN") == true) goto L5;
    L8:
        this.m = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraDeviceFragment$checkReady$1(r8, r9, this, null), 3, null);
        return;
    L5:
        if (this.m == false) goto L8;
        g49.d.d("DoraDeviceFragment", "checkReady: " + r8 + " isChecking");
    }

    @Override // com.larus.dora.impl.device.settings.DoraUnbindBaseFragment
    public final void onViewCreated(View r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r21, "view");
        super.onViewCreated(r21, r22);
        g49.d.d("DoraDeviceFragment", "onViewCreated, savedInstanceState=" + r22);
        LarusDoraPageDeviceBinding r1 = this.g;
        if (r1 == null) goto L19;
        DoraNovaTitleBarEx.T5(r1.e, new u(this));
        final LarusDoraDeviceInfoLayoutBinding r4 = r1.c;
        final DoraDeviceViewModel r5 = ea0();
        Lazy r6 = DoraDeviceLayoutInfoKt.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(r5, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        final Context r7 = r4.a.getContext();
        if (r7 == null) goto L11;
        e1.d(r4.p, new j0(r5, r7, this));
        e1.d(r4.k, new k0(r7, this));
        e1.d(r4.q, new l0(r7, this));
        e1.d(r4.j, new m0(r7, this));
        e1.d(r4.h, new n0(r7, this));
        e1.d(r4.u, new o0(r4, r7, this));
        DoraDeviceLayoutInfoKt.d(r4);
        e1.d(r4.b, new p0(r7, this));
        e1.d(r4.t, new b0(r7, this));
        Spinner r8 = r4.z;
        ArrayAdapter r9 = new ArrayAdapter(AppHost.a.getApplication(), R.layout.simple_spinner_item, CollectionsKt.toList(r5.getBots().values()));
        r9.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        r8.setAdapter(r9);
        r8.setSelection(CollectionsKt.toList(r5.getBots().keySet()).indexOf(DoraConfig.g()));
        r8.setOnItemSelectedListener(new q0(r5, r4));
        ItemTextArrow r10 = r4.g;
        String r11 = r5.getBots().get(DoraConfig.g());
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        int r12 = ItemTextArrow.k;
        r10.Z5(r11, null);
        r4.g.setVisible(true);
        e1.d(r4.g, new c0(r4));
        r4.a.setMotionEventSplittingEnabled(false);
        r4.g.setVisible(false);
        r4.z.setVisibility(8);
        e1.d(r4.r, new d0(r7, this));
    L11:
        LarusDoraPageDeviceBinding r13 = this.g;
        if (r13 == null) goto L18;
        LarusDoraDeviceInfoLayoutBinding r14 = r13.c;
        if (r14 == null) goto L18;
        ItemTextArrow r15 = r14.y;
        if (r15 == null) goto L18;
        int r16 = ItemTextArrow.k;
        r15.Z5("未连接", null);
    L18:
        int r17 = wk4.a.a;
        int r18 = WifiDirectOwnerProxy.k;
        WifiDirectOwnerProxy.a.a.getClass();
        ((CopyOnWriteArraySet) com.bytedance.dora.wlan.direct.a.q1).add(this);
        r1.c.x.setOnClickListener(new h(this));
    L19:
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r2, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r2, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r2, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r2, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r2, null, this), 3, null);
        getChildFragmentManager().setFragmentResultListener("showBluetoothDialog", this, new i(this));
        getParentFragmentManager().registerFragmentLifecycleCallbacks(this.x, false);
        ea0().load();
        ea0().syncUserSettings();
    }

    public static final void Z90(final DoraDeviceFragment r5, boolean r6, DoraSimpleDevice r7) {
        r5.getClass();
        StringBuilder r0 = new StringBuilder("showDisconnectedUi: name=");
        if (r7 == null) goto L5;
        String r2 = r7.getName();
    L6:
        r0.append(r2);
        r0.append(", sn=");
        if (r7 == null) goto L9;
        String r3 = r7.getSn();
    L10:
        r0.append(r3);
        g49.d.d("DoraDeviceFragment", r0.toString());
        r5.da0();
        LarusDoraPageDeviceBinding r1 = r5.g;
        if (r1 == null) goto L34;
        DoraNovaTitleBarEx r4 = r1.e;
        DoraNovaTitleBarEx.S5(r4, "");
        DoraNovaTitleBarEx.U5(r4, new g(r5));
        LarusDoraDeviceScanLayoutBinding r8 = r1.d;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        e1.o(r8.c);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r8.e.f();
        e1.o(r8.a);
        LarusDoraDeviceInfoLayoutBinding r9 = r1.c;
        Lazy r10 = DoraDeviceLayoutInfoKt.a;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        e1.o(r9.a);
        DoraDeviceBoxBattery.c = -1;
        DoraDeviceBoxBattery.c();
        DoraDeviceBoxBattery.e = null;
        LarusDoraDeviceDisconnectedLayoutBinding r11 = r1.b;
        final DoraDeviceViewModel r12 = r5.ea0();
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        e1.x(r11.a);
        DoraResourceUtil r13 = DoraResourceUtil.a;
        DoraImageType r14 = DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_WELCOME;
        DoraSKU.a r15 = DoraSKU.Companion;
        if (r7 == null) goto L15;
        Integer r16 = Integer.valueOf(r7.getSku());
    L16:
        String r17 = DoraResourceUtil.d(r14.fileName(DoraSKU.a.b(r15, r16)));
        g49.d.d("DoraDevicePageDisconnected", "img path=" + r17);
        if (r17.length() <= 0) goto L19;
        boolean r18 = true;
    L20:
        if (r18 == false) goto L22;
        ImageLoaderKt.s(r11.d, UriProtector.parse("file://".concat(r17)), null);
    L23:
        AppCompatTextView r20 = r11.f;
        if (r7 == null) goto L28;
        CharSequence r21 = r7.getName();
        if (r21 == null) goto L28;
    L29:
        r20.setText(r21);
        if (r6 == false) goto L32;
        e1.x(r11.e);
        r11.c.setText(2131902420);
        e1.d(r11.b, new y());
        return;
    L32:
        e1.o(r11.e);
        r11.c.setText(2131902419);
        e1.d(r11.b, new z(r12));
        return;
    L28:
        r21 = "Ola Friend";
        goto L29
    L22:
        ImageLoaderKt.u(r11.d, "res://" + AppHost.a.getApplication().getPackageName() + "/2131242904", null);
        goto L23
    L19:
        r18 = false;
        goto L20
    L15:
        r16 = null;
        goto L16
    L34:
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r45, ViewGroup r46, Bundle r47) {
        Intrinsics.checkNotNullParameter(r45, "inflater");
        boolean r2 = v19.h.a;
        this.i = v19.h.a(null);
        ConstraintLayout r1 = r45.inflate(2131562259, r46, false);
        int r3 = 2131369471;
        ConstraintLayout r4 = ViewBindings.findChildViewById(r1, 2131369471);
        if (r4 == null) goto L125;
        int r5 = 2131369518;
        ConstraintLayout r9 = ViewBindings.findChildViewById(r4, 2131369518);
        if (r9 == null) goto L123;
        r5 = 2131369519;
        DoraTextView r10 = (DoraTextView) ViewBindings.findChildViewById(r4, 2131369519);
        if (r10 == null) goto L123;
        r5 = 2131369520;
        SimpleDraweeView r11 = ViewBindings.findChildViewById(r4, 2131369520);
        if (r11 == null) goto L123;
        r5 = 2131369521;
        ProgressBar r12 = (ProgressBar) ViewBindings.findChildViewById(r4, 2131369521);
        if (r12 == null) goto L123;
        r5 = 2131369522;
        if (ViewBindings.findChildViewById(r4, 2131369522) == null) goto L123;
        r5 = 2131369523;
        DoraTextView r13 = (DoraTextView) ViewBindings.findChildViewById(r4, 2131369523);
        if (r13 == null) goto L123;
        LarusDoraDeviceDisconnectedLayoutBinding r16 = new LarusDoraDeviceDisconnectedLayoutBinding(r4, r9, r10, r11, r12, r13);
        r3 = 2131369489;
        NestedScrollView r6 = ViewBindings.findChildViewById(r1, 2131369489);
        if (r6 == null) goto L125;
        int r7 = 2131369450;
        ItemTextArrow r110 = ViewBindings.findChildViewById(r6, 2131369450);
        if (r110 == null) goto L121;
        r7 = 2131369451;
        if (ViewBindings.findChildViewById(r6, 2131369451) == null) goto L121;
        r7 = 2131369452;
        if (ViewBindings.findChildViewById(r6, 2131369452) == null) goto L121;
        r7 = 2131369453;
        View r20 = ViewBindings.findChildViewById(r6, 2131369453);
        if (r20 == null) goto L121;
        r7 = 2131369454;
        View r8 = ViewBindings.findChildViewById(r6, 2131369454);
        if (r8 == null) goto L121;
        LarusDoraDeviceBatteryLayoutBinding r21 = LarusDoraDeviceBatteryLayoutBinding.a(r8);
        r7 = 2131369455;
        View r14 = ViewBindings.findChildViewById(r6, 2131369455);
        if (r14 == null) goto L121;
        LarusDoraDeviceBatteryLayoutBinding r22 = LarusDoraDeviceBatteryLayoutBinding.a(r14);
        r7 = 2131369456;
        View r15 = ViewBindings.findChildViewById(r6, 2131369456);
        if (r15 == null) goto L121;
        LarusDoraDeviceBatteryLayoutBinding r23 = LarusDoraDeviceBatteryLayoutBinding.a(r15);
        r7 = 2131369457;
        if (ViewBindings.findChildViewById(r6, 2131369457) == null) goto L121;
        r7 = 2131369458;
        ItemTextArrow r24 = ViewBindings.findChildViewById(r6, 2131369458);
        if (r24 == null) goto L121;
        r7 = 2131369461;
        ItemTextArrow r25 = ViewBindings.findChildViewById(r6, 2131369461);
        if (r25 == null) goto L121;
        r7 = 2131369466;
        ImageView r26 = (ImageView) ViewBindings.findChildViewById(r6, 2131369466);
        if (r26 == null) goto L121;
        r7 = 2131369472;
        ItemTextArrow r27 = ViewBindings.findChildViewById(r6, 2131369472);
        if (r27 == null) goto L121;
        r7 = 2131369473;
        ItemTextArrow r28 = ViewBindings.findChildViewById(r6, 2131369473);
        if (r28 == null) goto L121;
        r7 = 2131369476;
        if (ViewBindings.findChildViewById(r6, 2131369476) == null) goto L121;
        r7 = 2131369480;
        ImageView r210 = (ImageView) ViewBindings.findChildViewById(r6, 2131369480);
        if (r210 == null) goto L121;
        r7 = 2131369483;
        ImageView r30 = (ImageView) ViewBindings.findChildViewById(r6, 2131369483);
        if (r30 == null) goto L121;
        r7 = 2131369484;
        ImageView r31 = (ImageView) ViewBindings.findChildViewById(r6, 2131369484);
        if (r31 == null) goto L121;
        NestedScrollView r32 = r6;
        r7 = 2131369494;
        ItemTextArrow r33 = ViewBindings.findChildViewById(r6, 2131369494);
        if (r33 == null) goto L121;
        r7 = 2131369497;
        if (ViewBindings.findChildViewById(r6, 2131369497) == null) goto L121;
        r7 = 2131369504;
        if (ViewBindings.findChildViewById(r6, 2131369504) == null) goto L121;
        r7 = 2131369507;
        ItemTextArrow r34 = ViewBindings.findChildViewById(r6, 2131369507);
        if (r34 == null) goto L121;
        r7 = 2131369510;
        if (ViewBindings.findChildViewById(r6, 2131369510) == null) goto L121;
        r7 = 2131369636;
        ItemTextArrow r35 = ViewBindings.findChildViewById(r6, 2131369636);
        if (r35 == null) goto L121;
        r7 = 2131369655;
        if (ViewBindings.findChildViewById(r6, 2131369655) == null) goto L121;
        r7 = 2131369656;
        if (ViewBindings.findChildViewById(r6, 2131369656) == null) goto L121;
        r7 = 2131369972;
        ItemGroup r36 = ViewBindings.findChildViewById(r6, 2131369972);
        if (r36 == null) goto L121;
        r7 = 2131369979;
        ItemTextArrow r37 = ViewBindings.findChildViewById(r6, 2131369979);
        if (r37 == null) goto L121;
        r7 = 2131370005;
        ItemTextArrow r38 = ViewBindings.findChildViewById(r6, 2131370005);
        if (r38 == null) goto L121;
        r7 = 2131370006;
        ItemGroup r310 = ViewBindings.findChildViewById(r6, 2131370006);
        if (r310 == null) goto L121;
        r7 = 2131370007;
        ItemGroup r17 = ViewBindings.findChildViewById(r6, 2131370007);
        if (r17 == null) goto L121;
        int r18 = 2131369635;
        LinearLayoutCompat r40 = ViewBindings.findChildViewById(r17, 2131369635);
        if (r40 == null) goto L119;
        r18 = 2131370008;
        ImageView r41 = (ImageView) ViewBindings.findChildViewById(r17, 2131370008);
        if (r41 == null) goto L119;
        r18 = 2131370010;
        if (((DoraTextView) ViewBindings.findChildViewById(r17, 2131370010)) == null) goto L119;
        LarusDoraSodaVipBannerBinding r42 = new LarusDoraSodaVipBannerBinding(r17, r40, r41);
        ItemGroup r43 = ViewBindings.findChildViewById(r6, 2131370072);
        if (r43 == null) goto L117;
        ItemTextArrow r44 = ViewBindings.findChildViewById(r6, 2131370073);
        if (r44 == null) goto L116;
        Spinner r48 = (Spinner) ViewBindings.findChildViewById(r6, 2131392982);
        if (r48 == null) goto L115;
        LarusDoraDeviceInfoLayoutBinding r50 = new LarusDoraDeviceInfoLayoutBinding(r32, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28, r210, r30, r31, r32, r33, r34, r35, r36, r37, r38, r310, r42, r43, r44, r48);
        r3 = 2131369503;
        ConstraintLayout r51 = ViewBindings.findChildViewById(r1, 2131369503);
        if (r51 == null) goto L125;
        int r52 = 2131369699;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r51, 2131369699);
        if (r111 == null) goto L114;
        r52 = 2131369998;
        LinearLayoutCompat r112 = ViewBindings.findChildViewById(r51, 2131369998);
        if (r112 == null) goto L114;
        r52 = 2131369999;
        AppCompatImageView r113 = ViewBindings.findChildViewById(r51, 2131369999);
        if (r113 == null) goto L114;
        r52 = 2131370000;
        DoraMovieView r114 = (DoraMovieView) ViewBindings.findChildViewById(r51, 2131370000);
        if (r114 == null) goto L114;
        r52 = 2131370001;
        if (ViewBindings.findChildViewById(r51, 2131370001) == null) goto L114;
        LarusDoraDeviceScanLayoutBinding r115 = new LarusDoraDeviceScanLayoutBinding(r51, r111, r112, r113, r114);
        ConstraintLayout r116 = r1;
        r3 = 2131388772;
        DoraNovaTitleBarEx r117 = (DoraNovaTitleBarEx) ViewBindings.findChildViewById(r1, 2131388772);
        if (r117 == null) goto L125;
        r3 = 2131388806;
        View r211 = ViewBindings.findChildViewById(r1, 2131388806);
        if (r211 == null) goto L125;
        this.g = new LarusDoraPageDeviceBinding(r116, r16, r50, r115, r117, r211);
        Context r53 = getContext();
        if (r53 == null) goto L109;
        IntentFilter r54 = new IntentFilter("action.ONBOARDING_ACTIVITY_DESTROY");
        r54.addAction("action.ONBOARDING_ACTIVITY_CREATE");
        LocalBroadcastManager.getInstance(r53).registerReceiver(this.y, r54);
    L109:
        LarusDoraPageDeviceBinding r55 = this.g;
        if (r55 != null) goto L112;
        return null;
    L112:
        return r55.a;
    L114:
        throw new NullPointerException("Missing required view with ID: ".concat(r51.getResources().getResourceName(r52)));
    L115:
        r7 = 2131392982;
        goto L121
    L116:
        r7 = 2131370073;
        goto L121
    L117:
        r7 = 2131370072;
    L119:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r18)));
    L121:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    L123:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r5)));
    L125:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r3)));
    }
}
