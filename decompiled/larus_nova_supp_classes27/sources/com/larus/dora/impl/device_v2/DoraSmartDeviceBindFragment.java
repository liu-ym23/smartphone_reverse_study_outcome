package com.larus.dora.impl.device_v2;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraExternalSmartDeviceBindPageBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel;
import com.larus.dora.impl.onboarding.DoraOnboardingPromptDialogFragment;
import com.larus.dora.impl.onboarding.TOAST_TYPE;
import com.larus.dora.impl.onboarding.o0;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalDeviceOnboardingDialogFragment;
import com.larus.dora.impl.onboarding.p0;
import com.larus.dora.impl.onboarding.q0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e*\u000225\u0018\u0000 _2\u00020\u0001:\u0002_`B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u000209H\u0016J&\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020;2\b\u0010@\u001a\u0004\u0018\u00010AH\u0017J\u0010\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020FH\u0002J\u0012\u0010G\u001a\u0004\u0018\u00010,2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020\u001bH\u0016J\u0010\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020SH\u0002J\u0010\u0010T\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020PH\u0002J\b\u0010U\u001a\u00020\u001bH\u0016J\b\u0010V\u001a\u00020\u001bH\u0002J \u0010W\u001a\u00020\u001b2\b\b\u0002\u0010X\u001a\u00020\u00162\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u0010Z\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020\u0016H\u0002J\b\u0010\\\u001a\u00020\u001bH\u0002J\b\u0010]\u001a\u00020\u001bH\u0016J\b\u0010^\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106¨\u0006a"}, d2 = {"Lcom/larus/dora/impl/device_v2/DoraSmartDeviceBindFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "isChecking", "", "isFirst", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraExternalSmartDeviceBindPageBinding;", "scanModel", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "getScanModel", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "scanModel$delegate", "Lkotlin/Lazy;", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader;", "onboardingDialogFragment", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogBaseFragment;", "lastOnboardingDialogFragment", "Landroidx/fragment/app/Fragment;", "prePage", "", "gpsDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "pendingCheckAction", "Lkotlin/Function0;", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pageKey", "productID", "", "Ljava/lang/Integer;", "productModel", "connectFailedDialog", "Lcom/larus/dora/impl/device/DoraDeviceConnectFailedDialog;", "mac", "sku", "vendorID", "autoFound", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ivMainImageLock", "", "connectFailedDialogFragment", "Lcom/larus/dora/impl/onboarding/DoraOnboardingPromptDialogFragment;", "needUnbindDialog", "buryPointSource", "fragmentLifecycleCallbacks", "com/larus/dora/impl/device_v2/DoraSmartDeviceBindFragment$fragmentLifecycleCallbacks$1", "Lcom/larus/dora/impl/device_v2/DoraSmartDeviceBindFragment$fragmentLifecycleCallbacks$1;", "receiver", "com/larus/dora/impl/device_v2/DoraSmartDeviceBindFragment$receiver$1", "Lcom/larus/dora/impl/device_v2/DoraSmartDeviceBindFragment$receiver$1;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupPage", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslSimplePage;", "handleUiState", "state", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "onResume", "showConnectFailedDialog", "uiState", "Lcom/larus/dora/impl/onboarding/OnboardingUiState$DeviceConnectFailed;", "gotoOnboardingPage", "device", "Lcom/bytedance/dora/device/DoraDevice;", "handleAction", "action", "Lcom/larus/dora/impl/onboarding/OnboardingAction;", "showNeedUnbindDialog", "onStop", "startBind", "checkReady", "from", "doNext", "handlePermissionDenied", "reason", "launchOnboarding", "onDestroyView", "getCurrentPageName", "Companion", "DslHBindDevicePage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraSmartDeviceBindFragment extends DoraBaseFragment {
    public static final /* synthetic */ int B = 0;
    public final DoraSmartDeviceBindFragment$receiver$1 A;
    public boolean f;
    public LarusDoraExternalSmartDeviceBindPageBinding g;
    public final Lazy h;
    public final com.larus.dora.impl.dynamic.loader.d i;
    public DoraExternalDeviceOnboardingDialogFragment j;
    public String k;
    public CommonDialog l;
    public Function0<Unit> m;
    public ActivityResultLauncher<Intent> n;
    public String o;
    public Integer p;
    public String q;
    public String r;
    public String s;
    public int t;
    public final AtomicBoolean u;
    public final Object v;
    public DoraOnboardingPromptDialogFragment w;
    public CommonDialog x;
    public String y;
    public final DoraSmartDeviceBindFragment$fragmentLifecycleCallbacks$1 z;

    public static final class a {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/impl/device_v2/DoraSmartDeviceBindFragment$DslHBindDevicePage;", "", "title", "Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "desc", "imageLink", "Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "bindButtonInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslButton;", "<init>", "(Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;Lcom/larus/dora/impl/dynamic/dsl/DslButton;)V", "getTitle", "()Lcom/larus/dora/impl/dynamic/dsl/DslIdentifier;", "getDesc", "getImageLink", "()Lcom/larus/dora/impl/dynamic/dsl/DslImageLink;", "getBindButtonInfo", "()Lcom/larus/dora/impl/dynamic/dsl/DslButton;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("bind_button_info")
        private final c59.h bindButtonInfo;

        @SerializedName("desc")
        private final c59.t desc;

        @SerializedName("image_link")
        private final c59.u imageLink;

        @SerializedName("title")
        private final c59.t title;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.imageLink, r6.imageLink) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.bindButtonInfo, r6.bindButtonInfo) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            c59.t r0 = this.title;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            c59.t r4 = this.desc;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            c59.u r7 = this.imageLink;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            c59.h r10 = this.bindButtonInfo;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DslHBindDevicePage(title=" + this.title + ", desc=" + this.desc + ", imageLink=" + this.imageLink + ", bindButtonInfo=" + this.bindButtonInfo + ')';
        }

        public b() {
            this.title = null;
            this.desc = null;
            this.imageLink = null;
            this.bindButtonInfo = null;
        }

        public final c59.h a() {
            return this.bindButtonInfo;
        }

        public final c59.t b() {
            return this.desc;
        }

        public final c59.u c() {
            return this.imageLink;
        }

        public final c59.t d() {
            return this.title;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraSmartDeviceBindFragment a;

        public c(DoraSmartDeviceBindFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            q0 r11 = (q0) r9;
            DoraSmartDeviceBindFragment r12 = this.a;
            if (r12.g == null) goto L56;
            g49.d.d("DoraDeviceBindFragment", "handleUiState: " + r11);
            if (Intrinsics.areEqual(r11, q0.e.a) == false) goto L8;
            Unit r13 = Unit.INSTANCE;
            goto L56
        L8:
            if (Intrinsics.areEqual(r11, q0.f.a) == false) goto L13;
            LarusDoraExternalSmartDeviceBindPageBinding r14 = r12.g;
            if (r14 == null) goto L56;
            DoraOnboardingPromptDialogFragment r0 = new DoraOnboardingPromptDialogFragment(new d0(r12), "scan_long_time");
            r0.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_onboarding_origin_from", r12.k)}));
            DoraSmartDeviceBindFragment.W90(r0, r12.getParentFragmentManager());
            r12.Y90().stopScan();
            e1.x(r14.d);
            e1.o(r14.c);
            Unit r15 = Unit.INSTANCE;
            goto L56
        L13:
            if ((r11 instanceof q0.d) == false) goto L28;
            LarusDoraExternalSmartDeviceBindPageBinding r1 = r12.g;
            if (r1 == null) goto L56;
            e1.x(r1.d);
            e1.o(r1.c);
            e1.x(r1.h);
            r1.h.setText(r12.getString(2131903845, new Object[]{o59.a.d(((q0.d) r11).a)}));
            r1.d.setText(r12.getString(2131902385));
            if (r12.u.compareAndSet(false, true) == false) goto L26;
            SimpleDraweeView r2 = r1.f;
            Object r16 = r12.v;
            monitor-enter(r16);
            int r3 = l59.a.a;     // Catch: Throwable -> L23
            ImageLoaderKt.u(r2, l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/h/scanning_h_resize/${product}/image_${sku}.png", ((q0.d) r11).a, "light"), "dora_dynamic_biz_tag");     // Catch: Throwable -> L23
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L23
            monitor-exit(r16);
        L23:
            th = move-exception;
            throw th;
        L26:
            Unit r18 = Unit.INSTANCE;
            goto L56
        L28:
            if ((r11 instanceof q0.c) == false) goto L43;
            LarusDoraExternalSmartDeviceBindPageBinding r4 = r12.g;
            if (r4 == null) goto L56;
            e1.x(r4.d);
            e1.x(r4.c);
            e1.x(r4.h);
            r4.h.setText(r12.getString(2131903845, new Object[]{o59.a.d(((q0.c) r11).a)}));
            r4.d.setText(r12.getString(2131903844));
            if (r12.u.compareAndSet(false, true) == false) goto L41;
            SimpleDraweeView r5 = r4.f;
            Object r110 = r12.v;
            monitor-enter(r110);
            int r6 = l59.a.a;     // Catch: Throwable -> L38
            ImageLoaderKt.u(r5, l59.a.a("https://p3-starweave-source.byteimg.com/tos-cn-i-99ixvlomm4/h/scanning_h_resize/${product}/image_${sku}.png", ((q0.c) r11).a, "light"), "dora_dynamic_biz_tag");     // Catch: Throwable -> L38
            Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L38
            monitor-exit(r110);
        L38:
            th = move-exception;
            throw th;
        L41:
            Unit r21 = Unit.INSTANCE;
            goto L56
        L43:
            if ((r11 instanceof q0.b) == false) goto L46;
            o5.a(r12, "fragment_request_key_onboarding_start", com.larus.utils.f.c(new Pair[0]));
            new Handler(Looper.getMainLooper()).postDelayed(new e0(r12, r11), 200);
            goto L56
        L46:
            if ((r11 instanceof q0.a) == false) goto L54;
            LarusDoraExternalSmartDeviceBindPageBinding r7 = r12.g;
            if (r7 == null) goto L56;
            if (r12.isResumed() == false) goto L52;
            r12.aa0((q0.a) r11);
        L52:
            r12.Y90().stopScan();
            e1.x(r7.d);
            e1.o(r7.c);
            r7.d.setText(r12.getString(2131902385));
            Unit r22 = Unit.INSTANCE;
            goto L56
        L54:
            throw new NoWhenBranchMatchedException();
        L56:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraSmartDeviceBindFragment a;

        public d(DoraSmartDeviceBindFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            o0 r8 = (o0) r6;
            final DoraSmartDeviceBindFragment r9 = this.a;
            int r0 = DoraSmartDeviceBindFragment.B;
            r9.getClass();
            g49.d.d("DoraDeviceBindFragment", "handleAction: " + r8);
            if ((r8 instanceof o0.c) == false) goto L21;
            final DoraDevice r10 = ((o0.c) r8).a;
            boolean r1 = false;
            if (r9.x != null) goto L7;
            CommonDialog.a r2 = new CommonDialog.a();
            r2.i(r9.getString(2131902447));
            r2.g(r9.getString(2131902446));
            CommonDialog.a.f(r2, new i0(r9, r10), r9.getString(2131902418), false, 12);
            CommonDialog.a.e(r2, new j0(r9, r10), r9.getString(2131902465), 4);
            r2.z = false;
            Function0<Boolean> r3 = new z(r9, r10);
            Intrinsics.checkNotNullParameter(r3, "callback");
            r2.B = r3;
            r9.x = r2.a();
        L7:
            CommonDialog r11 = r9.x;
            if (r11 != null) goto L10;
        L12:
            if (r1 == true) goto L34;
            CommonDialog r12 = r9.x;
            if (r12 == null) goto L34;
            FragmentManager r13 = r9.getChildFragmentManager();
            LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, null, r4);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r12, r4) == true) goto L34;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
        L19:
            r12.show(r13, null);
        L34:
            return Unit.INSTANCE;
        L10:
            if (r11.isVisible() != true) goto L12;
            r1 = true;
            goto L12
        L21:
            if ((r8 instanceof o0.d) == false) goto L27;
            o0.d r14 = (o0.d) r8;
            if (r14.getType() != TOAST_TYPE.TOAST_TYPE_WARNING) goto L25;
            t19.s r15 = t19.s.a;
            Application r5 = AppHost.a.getApplication();
            String r16 = r14.a;
            r15.getClass();
            t19.s.t(r5, r16);
            goto L34
        L25:
            t19.s r17 = t19.s.a;
            Application r18 = AppHost.a.getApplication();
            String r20 = r14.a;
            r17.getClass();
            t19.s.c(r18, r20);
            goto L34
        L27:
            if (Intrinsics.areEqual(r8, o0.a.a) == true) goto L34;
            if ((r8 instanceof o0.b) == true) goto L34;
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e implements p0 {
        public final /* synthetic */ DoraSmartDeviceBindFragment a;
        public final /* synthetic */ q0.a b;

        @Override // com.larus.dora.impl.onboarding.p0
        public final void onCloseButtonClick() {
        }

        @Override // com.larus.dora.impl.onboarding.p0
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "promptType");
            DoraSmartDeviceBindFragment r3 = this.a;
            if (r3.g == null) goto L11;
            q0.a r0 = this.b;
            if (r0 == null) goto L7;
            DoraDevice r1 = r0.a;
        L8:
            if (r1 == null) goto L12;
            r3.Y90().bindAndConnect(r1);
            return;
        L12:
            return;
        L7:
            r1 = null;
            goto L8
        }

        public e(DoraSmartDeviceBindFragment r1, q0.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device_v2.DoraSmartDeviceBindFragment$onViewCreated$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device_v2.DoraSmartDeviceBindFragment$onViewCreated$5", f = "DoraSmartDeviceBindFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraSmartDeviceBindFragment this$0;

        public AnonymousClass5(DoraSmartDeviceBindFragment r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass5(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            if (com.larus.utils.o0.d(this.this$0.r) == false) goto L8;
            final DoraSmartDeviceBindFragment r4 = this.this$0;
            r4.X90("check_from_MAIN", new g0(r4));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final String k() {
        return "DoraDeviceBindFragment";
    }

    public final DoraOnboardingDialogViewModel Y90() {
        return (DoraOnboardingDialogViewModel) this.h.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.dora.impl.device_v2.DoraSmartDeviceBindFragment$fragmentLifecycleCallbacks$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.dora.impl.device_v2.DoraSmartDeviceBindFragment$receiver$1] */
    public DoraSmartDeviceBindFragment() {
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOnboardingDialogViewModel.class), new DoraSmartDeviceBindFragment$special$$inlined$activityViewModels$default$1(this), new DoraSmartDeviceBindFragment$special$$inlined$activityViewModels$default$2(this));
        this.i = new com.larus.dora.impl.dynamic.loader.d();
        this.m = new a0();
        this.s = "";
        this.t = -1;
        this.u = new AtomicBoolean(false);
        this.v = new Object();
        this.y = "";
        this.z = new DoraSmartDeviceBindFragment$fragmentLifecycleCallbacks$1();
        this.A = new DoraSmartDeviceBindFragment$receiver$1();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).unregisterReceiver(this.A);
    }

    public final void onResume() {
        super.onResume();
        if (this.g == null) goto L19;
        DoraOnboardingDialogViewModel r0 = Y90();
        q0 r1 = null;
        if (r0 == null) goto L9;
        i1<q0> r2 = r0.getUiStateFlow();
        if (r2 == null) goto L9;
        q0 r3 = (q0) r2.getValue();
    L11:
        if ((r3 instanceof q0.a) == false) goto L20;
        DoraOnboardingDialogViewModel r4 = Y90();
        if (r4 == null) goto L17;
        i1<q0> r5 = r4.getUiStateFlow();
        if (r5 == null) goto L17;
        r1 = (q0) r5.getValue();
    L17:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larus.dora.impl.onboarding.OnboardingUiState.DeviceConnectFailed");
        aa0((q0.a) r1);
        return;
    L20:
        return;
    L9:
        r3 = null;
        goto L11
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        super.onStop();
        if (this.g == null) goto L6;
        Y90().stopScan();
        return;
    }

    public final void Z90(String r2) {
        g49.d.d("DoraDeviceBindFragment", "handlePermissionDenied: ".concat(r2));
    }

    public final void aa0(q0.a r4) {
        DoraOnboardingPromptDialogFragment r0 = this.w;
        if (r0 != null) goto L12;
    L10:
        DoraOnboardingPromptDialogFragment r1 = new DoraOnboardingPromptDialogFragment(new e(this, r4), "connect_failed");
        r1.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_onboarding_origin_from", this.k)}));
        W90(r1, getParentFragmentManager());
        this.w = r1;
        return;
    L12:
        r0.dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L10;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.n = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b0(this));
    }

    public static void W90(DoraOnboardingPromptDialogFragment r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "DoraDeviceBindFragment", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "DoraDeviceBindFragment");
    }

    public final void X90(String r8, Function0<Unit> r9) {
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + r8 + " start");
        if (Intrinsics.areEqual(r8, "check_from_MAIN") == true) goto L5;
    L8:
        this.f = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraSmartDeviceBindFragment$checkReady$1(r8, r9, this, null), 3, null);
        return;
    L5:
        if (this.f == false) goto L8;
        g49.d.d("DoraDeviceBindFragment", "checkReady: " + r8 + " isChecking");
    }

    public final void onViewCreated(View r20, Bundle r21) {
        String r2 = "";
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        Bundle r0 = getArguments();     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        String r1 = r0.getString("product_id");     // Catch: Throwable -> L11
    L7:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        this.p = Integer.valueOf(CastIntegerProtector.parseInt(r1));     // Catch: Throwable -> L11
    L13:
        Bundle r3 = getArguments();
        if (r3 == null) goto L16;
        String r4 = r3.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L17:
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        this.q = r4;
        Bundle r5 = getArguments();
        if (r5 == null) goto L22;
        String r6 = r5.getString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY);
    L23:
        if (r6 != null) goto L25;
        r6 = "";
    L25:
        this.o = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L28;
        String r8 = r7.getString("extra_mac");
    L29:
        if (r8 != null) goto L31;
        r8 = "";
    L31:
        this.r = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L34;
        String r10 = r9.getString("extra_sku");
    L35:
        if (r10 != null) goto L37;
        r10 = "";
    L37:
        this.s = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L40;
        int r12 = r11.getInt("extra_vendor_id");
    L41:
        this.t = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L44;
        String r14 = r13.getString("bury_point_source");
    L45:
        if (r14 == null) goto L48;
        r2 = r14;
    L48:
        this.y = r2;
        LarusDoraExternalSmartDeviceBindPageBinding r15 = this.g;
        if (r15 == null) goto L51;
        e1.x(r15.e);
        ViewGroup.LayoutParams r16 = r15.e.getLayoutParams();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r17 = (RelativeLayout.LayoutParams) r16;
        com.larus.utils.i0.a.getClass();
        r17.topMargin = com.larus.utils.i0.g();
        r15.e.setLayoutParams(r17);
        r15.e.setLeftClickListener(new y(this));
        com.larus.dora.impl.dynamic.loader.d.b(this.i, LifecycleOwnerKt.getLifecycleScope(this), 4096, -1, this.q, this.o, new DoraSmartDeviceBindFragment$onViewCreated$1$2(this));
    L51:
        getParentFragmentManager().registerFragmentLifecycleCallbacks(this.z, false);
        Lifecycle.State r18 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraSmartDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r18, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraSmartDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r18, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraSmartDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r18, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass5(this, null), 2, null);
        return;
    L44:
        r14 = null;
        goto L45
    L40:
        r12 = -1;
        goto L41
    L34:
        r10 = null;
        goto L35
    L28:
        r8 = null;
        goto L29
    L22:
        r6 = null;
        goto L23
    L16:
        r4 = null;
        goto L17
    L6:
        r1 = null;
    L11:
        th = move-exception;
        this.p = -1;
        g49.d.b("DoraDeviceBindFragment", "onViewCreated, error is " + th.getMessage());
        goto L13
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r14 = r11.inflate(2131562175, r12, false);
        int r15 = 2131364657;
        LinearLayoutCompat r2 = ViewBindings.findChildViewById(r14, 2131364657);
        if (r2 == null) goto L32;
        r15 = 2131364658;
        ProgressBar r3 = (ProgressBar) ViewBindings.findChildViewById(r14, 2131364658);
        if (r3 == null) goto L32;
        r15 = 2131364659;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r14, 2131364659);
        if (r4 == null) goto L32;
        r15 = 2131368926;
        HistoryDeviceNavigationBar r5 = (HistoryDeviceNavigationBar) ViewBindings.findChildViewById(r14, 2131368926);
        if (r5 == null) goto L32;
        r15 = 2131376390;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r14, 2131376390);
        if (r6 == null) goto L32;
        r15 = 2131378745;
        if (((LinearLayout) ViewBindings.findChildViewById(r14, 2131378745)) == null) goto L32;
        r15 = 2131390487;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, 2131390487);
        if (r7 == null) goto L32;
        r15 = 2131390493;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, 2131390493);
        if (r8 == null) goto L32;
        r15 = 2131391606;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r14, 2131391606);
        if (r9 == null) goto L32;
        this.g = new LarusDoraExternalSmartDeviceBindPageBinding((RelativeLayout) r14, r2, r3, r4, r5, r6, r7, r8, r9);
        IntentFilter r16 = new IntentFilter("action.DEVICE_TO_GUIDE");
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).registerReceiver(this.A, r16);
        Bundle r17 = getArguments();
        String r18 = "";
        if (r17 == null) goto L26;
        String r110 = r17.getString("device_manage", "");
        if (r110 == null) goto L26;
        r18 = r110;
    L26:
        this.k = r18;
        LarusDoraExternalSmartDeviceBindPageBinding r111 = this.g;
        if (r111 != null) goto L33;
        return null;
    L33:
        return r111.a;
    L32:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
