package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.NetworkUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.CloseReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapReadHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapUtilKt;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e;
import com.ss.android.lark.officesdk.minutes.ui.databinding.OfficeSdkMmViewEndWindowLoadingBinding;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper;
import com.ss.android.lark.officesdk.minutes.ui.service.MmRecordingUiProviders;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.f;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Ý\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001u\b\u0007\u0018\u0000 \u0082\u00012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006:\u0002\u0082\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J$\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010M\u001a\u00020DH\u0016J\b\u0010N\u001a\u00020DH\u0016J\b\u0010O\u001a\u00020DH\u0016J\b\u0010P\u001a\u00020DH\u0016J\u001a\u0010Q\u001a\u00020D2\u0006\u0010R\u001a\u00020H2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010S\u001a\u00020DH\u0002J1\u0010T\u001a\u00020D2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010YH\u0002¢\u0006\u0002\u0010ZJ\b\u0010[\u001a\u00020DH\u0002J\b\u0010\\\u001a\u00020DH\u0002J\u0010\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020\nH\u0002J\u0010\u0010_\u001a\u00020D2\u0006\u0010`\u001a\u00020\nH\u0002J\b\u0010a\u001a\u00020<H\u0002J\b\u0010b\u001a\u00020<H\u0002J(\u0010c\u001a\u00020D2\u0006\u0010d\u001a\u00020V2\u0006\u0010e\u001a\u00020V2\u0006\u0010f\u001a\u00020V2\u0006\u0010g\u001a\u00020VH\u0014J\u0010\u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020D2\u0006\u0010l\u001a\u00020<H\u0014J\b\u0010m\u001a\u00020DH\u0002J\b\u0010n\u001a\u00020DH\u0002J\u001a\u0010o\u001a\u00020D2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020sH\u0002J\r\u0010t\u001a\u00020uH\u0002¢\u0006\u0002\u0010vJ\b\u0010w\u001a\u00020DH\u0002J\b\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020D2\u0006\u0010{\u001a\u00020|H\u0002J\b\u0010}\u001a\u00020DH\u0002J\b\u0010~\u001a\u00020DH\u0002J\u0012\u0010\u007f\u001a\u00020D2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000e\u001a\u0004\b!\u0010\"R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u000e\u001a\u0004\b2\u00103R\u0010\u00105\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020\u00058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000e\u001a\u0004\b@\u0010A¨\u0006\u0083\u0001"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MviBaseFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowUIEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowViewModel;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "getMmUccApi", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "setMmUccApi", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)V", "navRectProvider", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmNavRectProvider;", "getNavRectProvider", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmNavRectProvider;", "navRectProvider$delegate", "appletNavigator", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmAppletNavigator;", "getAppletNavigator", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmAppletNavigator;", "appletNavigator$delegate", "hostBridge", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/IMmRecordingHostBridge;", "getHostBridge", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/IMmRecordingHostBridge;", "hostBridge$delegate", "_endWindowView", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/endwindow/MmEndWindowFragmentView;", "endWindowView", "getEndWindowView", "()Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/endwindow/MmEndWindowFragmentView;", "webHelper", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowWebHelper;", "statTracker", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/MmEndWindowStatTracker;", "getStatTracker", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/MmEndWindowStatTracker;", "statTracker$delegate", "uiProviders", "Lcom/ss/android/lark/officesdk/minutes/ui/service/MmRecordingUiProviders;", "getUiProviders", "()Lcom/ss/android/lark/officesdk/minutes/ui/service/MmRecordingUiProviders;", "uiProviders$delegate", "dataKey", "sessionId", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "loadTimeoutJob", "Lkotlinx/coroutines/Job;", "hasReceivedLoadComplete", "", "hasTrackedEndWindowShowFail", "isInvalidRestore", "viewModel", "getViewModel", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowViewModel;", "viewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onPause", "onDestroyView", "onDestroy", "onViewCreated", "view", "startEndWindowLoadTimeout", "trackEndWindowShowFailOnce", "errorCode", "", "errorMsg", "latencyMs", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "setupBackPressCallback", "initView", "openWebPageFromHost", "url", "openProfileFromHost", "userId", "supportHostBridge", "supportHostNavRect", "onWindowInsetsChanged", "left", "top", "right", "bottom", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDarkModeChanged", "isDarkMode", "updateUiWhenThemeChanged", "applyTopCloseButtonStyle", "handleChangeSpeaker", "origin", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmEndWindowChangeSpeakerOrigin;", "callback", "Lcom/ss/android/lark/officewebview/bridge/JsCallBack;", "createWebHelperListener", "com/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowFragment$createWebHelperListener$1", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/MmEndWindowFragment$createWebHelperListener$1;", "observeState", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "closePage", "reason", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/CloseReason;", "clearCachedEntityIfNeeded", "markEndWindowClosedIfNeeded", "sendOpenPage", "entity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmRecordingEndWindowEntity;", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEndWindowFragment extends Hilt_MmEndWindowFragment<d, Object, c, MmEndWindowViewModel> implements d0c.c {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public boolean B;
    public final Lazy C;
    public final Lazy m;

    @Inject
    public com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public lwb.a r;
    public MmEndWindowWebHelper s;
    public final Lazy t;
    public final Lazy u;
    public String v;
    public String w;
    public MmRecordingUILaunchMode x;
    public Job y;
    public boolean z;

    public static final class a {
        public static MmEndWindowFragment a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "dataKey");
            MmEndWindowFragment r0 = new MmEndWindowFragment();
            Bundle r1 = new Bundle();
            r1.putString("mm_end_window_data_key", r5);
            Application r2 = LarkContext.getApplication();
            if (r2 == null) goto L5;
            PassportcConvention.f(r1, r2);
        L6:
            r0.setArguments(r1);
            return r0;
        L5:
            int r3 = bwb.b.a;
            bwb.b.d(MmUiLogScene.END_WINDOW, "newInstance", "newInstance: Application not initialized, dataKey=" + r5, null);
            goto L6
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // d0c.c
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final String U90() {
        return (String) this.m.getValue();
    }

    public final lwb.a fa0() {
        lwb.a r0 = this.r;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("End window view is not created".toString());
    }

    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a ga0() {
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mmUccApi");
        return null;
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c ha0() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c) this.t.getValue();
    }

    public final MmEndWindowViewModel ia0() {
        return (MmEndWindowViewModel) this.C.getValue();
    }

    public final void onDestroy() {
        if (this.B == false) goto L6;
        super.onDestroy();
        return;
    L6:
        FragmentActivity r0 = getActivity();
        boolean r1 = false;
        if (r0 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L15;
    L23:
        FragmentActivity r2 = getActivity();
        if (r2 != null) goto L26;
    L28:
        boolean r4 = false;
    L29:
        if (r4 == false) goto L32;
    L41:
        super.onDestroy();
        return;
    L32:
        if (isRemoving() == true) goto L38;
        if (r2 != null) goto L35;
    L37:
        if (r1 == false) goto L41;
    L35:
        if (r2.isFinishing() != true) goto L37;
        r1 = true;
    L38:
        String r5 = this.v;
        if (r5 == null) goto L41;
        ConcurrentHashMap<String, Object> r6 = uub.c.a;
        Intrinsics.checkNotNullParameter(r5, "dataKey");
        uub.c.a.remove(r5);
        goto L41
    L26:
        if (r2.isChangingConfigurations() != true) goto L28;
        r4 = true;
        goto L29
    L15:
        if (isRemoving() == true) goto L22;
        if (r0 != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == false) goto L23;
    L18:
        if (r0.isFinishing() != true) goto L20;
        r7 = true;
    L22:
        ga0().N().e(this.w);
        goto L23
    L9:
        if (r0.isChangingConfigurations() != true) goto L11;
        r3 = true;
        goto L12
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onDestroyView() {
        if (this.B == false) goto L6;
        super.onDestroyView();
        return;
    L6:
        ((MmRecordingUiProviders) this.u.getValue()).a(getContext(), getChildFragmentManager());
        super.onDestroyView();
        Job r0 = this.y;
        if (r0 == null) goto L9;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c r1 = ha0();
        if (r1.e == true) goto L13;
        lvb.a.b(r1.b, "[endTracking] hasTrackedView is false");
    L16:
        T90();
        MmEndWindowWebHelper r2 = this.s;
        if (r2 == null) goto L21;
        int r3 = bwb.b.a;
        bwb.b.g(MmUiLogScene.WEB, "destroy", null, r2.f(), 4);
        r2.e();
        if (r2.m == false) goto L21;
        MmRecordingMapReadHelper r4 = (MmRecordingMapReadHelper) r2.l.getValue();
        r4.b = null;
        r4.c = null;
        MmRecordingMapUtilKt.b(LarkContext.getApplication(), r4.a, "MmRecordingMapReadHelper.destroy");
    L21:
        this.r = null;
        return;
    L13:
        if (r1.a.d(r1.c) == true) goto L15;
        lvb.a.b(r1.b, "[endTracking] commonParam invalid, sessionId=" + r1.c);
        goto L16
    L15:
        long r5 = (System.currentTimeMillis() - r1.d) / ((long) 1000);
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r6 = r1.a;
        String r7 = r1.c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r8 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r8.c("duration", r5);
        r8.e("source", "native");
        r6.g(r7, "vc_record_tail_window_duration_status", r8.a());
        r1.c = "";
        r1.d = 0;
        r1.e = false;
        goto L16
    }

    public MmEndWindowFragment() {
        this.m = LazyKt.lazy(new MmEndWindowFragment$logDetail$2(this));
        this.o = LazyKt.lazy(new MmEndWindowFragment$navRectProvider$2(this));
        this.p = LazyKt.lazy(new MmEndWindowFragment$appletNavigator$2(this));
        this.q = LazyKt.lazy(new MmEndWindowFragment$hostBridge$2(this));
        this.t = LazyKt.lazy(new MmEndWindowFragment$statTracker$2(this));
        this.u = LazyKt.lazy(new MmEndWindowFragment$uiProviders$2(this));
        this.w = "";
        this.x = MmRecordingUILaunchMode.UNKNOWN;
        this.C = LazyKt.lazy(new MmEndWindowFragment$viewModel$2(this));
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment
    public final /* bridge */ /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a Z90() {
        return ia0();
    }

    public final void da0() {
        AppCompatImageView r0 = fa0().e;
        Context r1 = r0.getContext();
        Intrinsics.checkNotNull(r1);
        r0.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r1).w(r1));
        r0.clearColorFilter();
        ImageViewCompat.setImageTintList(r0, UDColorUtils.getColorStateList(r1, com.ss.android.lark.officesdk.minutes.ui.style.a.a(r1).k()));
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onPause() {
        super.onPause();
        if (this.B == false) goto L5;
        return;
    L5:
        MmEndWindowWebHelper r0 = this.s;
        if (r0 == null) goto L9;
        e r1 = r0.n;
        lvb.a.e(r1.b, "[onPause]");
        r1.e = true;
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onResume() {
        super.onResume();
        if (this.B == false) goto L5;
        return;
    L5:
        MmEndWindowWebHelper r0 = this.s;
        if (r0 == null) goto L9;
        r0.n.a();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m399provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void X90(boolean r6) {
        if (this.B == false) goto L5;
        return;
    L5:
        T90();
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.END_WINDOW, "updateUiWhenThemeChanged", null, U90(), 4);
        da0();
        MmEndWindowWebHelper r1 = this.s;
        if (r1 == null) goto L9;
        r1.l(r6);
        return;
    }

    public final void ea0(CloseReason r3) {
        wvb.a.a((uub.a) this.p.getValue(), getActivity(), r3);
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        if (this.B == false) goto L5;
        return;
    L5:
        V90(true);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (LarkContext.getApplication() != null) goto L6;
        int r9 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "onCreate", "Application not initialized, finish activity", U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L6:
        Bundle r10 = getArguments();
        String r2 = null;
        if (r10 == null) goto L9;
        String r11 = r10.getString("mm_end_window_data_key");
    L10:
        if (r11 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L19;
        int r12 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "onCreate", "dataKey is null or blank, finish activity", U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L19:
        ConcurrentHashMap<String, Object> r4 = uub.c.a;
        Intrinsics.checkNotNullParameter(r11, "dataKey");
        Object r5 = uub.c.a.get(r11);
        if (r5 != null) goto L22;
        r5 = null;
    L22:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c) r5;
        if (r6 != null) goto L27;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "onCreate", "Entity is null, finish activity, dataKey=".concat(r11), U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L27:
        if (r6.c.shouldHandleUI() == true) goto L30;
        int r13 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "onCreate", "uiLaunchMode is invalid, ui=" + r6.c, U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L30:
        com.ss.android.lark.officesdk.minutes.ui.style.e r14 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r15 = r6.c;
        r14.getClass();
        if (com.ss.android.lark.officesdk.minutes.ui.style.e.c(r15) != null) goto L34;
        int r16 = bwb.b.a;
        bwb.b.d(MmUiLogScene.END_WINDOW, "onCreate", "ui provider is missing, ui=" + r6.c, U90());
        this.B = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L34:
        this.v = r11;
        this.w = r6.a;
        this.x = r6.c;
        int r17 = bwb.b.a;
        bwb.b.f(MmUiLogScene.ENTRY, "onCreate", "page=end, ui=" + this.x + ", session=" + this.w, U90());
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.c r18 = ha0();
        String r0 = r6.a;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        r18.c = r0;
        r18.d = System.currentTimeMillis();
        r18.e = true;
        if (r18.a.d(r18.c) == true) goto L37;
        lvb.a.b(r18.b, "[trackView] commonParam invalid, sessionId=" + r18.c);
    L38:
        this.h = Boolean.valueOf(W90());
        ia0().dispatchEvent(new c.a(r6));
        tvb.a r19 = (tvb.a) ga0().N().g.getValue();
        String r1 = r6.a;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        MmRecordingCommonParam r20 = r19.a.b(r1);
        if (r20 == null) goto L41;
        r2 = r20.getRecordId();
    L41:
        if (r2 != null) goto L43;
        r2 = "";
    L43:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r21 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r21.e("current_page", "feishu_recording_end_window_page");
        r21.e("feishu_record_id", r2);
        r21.e("enter_method", "recording_end_auto_open");
        r19.a(r1, "enter_page", r21.a());
        return;
    L37:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r22 = r18.a;
        String r23 = r18.c;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r24 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r24.e("source", "native");
        r22.g(r23, "vc_record_tail_window_view", r24.a());
        goto L38
    L12:
        if (StringsKt.isBlank(r11) == true) goto L15;
        r3 = false;
        goto L16
    L9:
        r11 = null;
        goto L10
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        if (this.B == false) goto L5;
        return;
    L5:
        int r11 = uvb.b.a;
        uvb.a.b(r9, uvb.c.d0);
        uvb.b.a(r9, 2131389095, uvb.c.e0);
        OnBackPressedCallback r12 = new MmEndWindowFragment$setupBackPressCallback$callback$1(this);
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L10;
        OnBackPressedDispatcher r14 = r13.getOnBackPressedDispatcher();
        if (r14 == null) goto L10;
        r14.addCallback(getViewLifecycleOwner(), r12);
    L10:
        Job r15 = this.y;
        if (r15 == null) goto L13;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L13:
        this.z = false;
        this.A = false;
        this.y = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MmEndWindowFragment$startEndWindowLoadTimeout$1(this, null), 3, null);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r0 = ia0().getLatestEntity();
        da0();
        com.ss.android.lark.officesdk.minutes.ui.style.e r1 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r2 = this.x;
        r1.getClass();
        if (com.ss.android.lark.officesdk.minutes.ui.style.e.b(r2).getCapability().e() == true) goto L16;
    L18:
        fa0().e.setVisibility(0);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(fa0().e, new MmEndWindowFragment$initView$1(this));
    L19:
        this.s = new MmEndWindowWebHelper(ga0(), r0.d.getMeetingId(), LifecycleOwnerKt.getLifecycleScope(this), fa0().c, new MmEndWindowFragment$createWebHelperListener$1(this));
        aa0(MmEndWindowFragment$observeState$1.INSTANCE, new MmEndWindowFragment$observeState$2(this, null));
        aa0(MmEndWindowFragment$observeState$3.INSTANCE, new MmEndWindowFragment$observeState$4(this, null));
        return;
    L16:
        if (((uub.b) this.o.getValue()) == null) goto L18;
        fa0().e.setVisibility(8);
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [android.view.View, android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmEndWindowLoadingLayout] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        super.onCreateView(r13, r14, r15);
        if (this.B == true) goto L5;
        LayoutInflater r16 = LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r13.getContext(), this.x));
        com.ss.android.lark.officesdk.minutes.ui.style.e r17 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r0 = this.x;
        r17.getClass();
        f r18 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r0).getLayout();
        Intrinsics.checkNotNull(r16);
        lwb.a r19 = r18.i(r16, r14);
        this.r = r19;
        ?? r110 = r19.d;
        MmRecordingUILaunchMode r111 = this.x;
        if (r110.b != null) goto L9;
    L11:
        r110.R5();
        r110.removeAllViews();
        com.ss.android.lark.officesdk.minutes.ui.style.e.b(r111).getLayout().D(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r110.getContext(), r111)), r110);
        int r1 = 2131392452;
        View r2 = ViewBindings.findChildViewById(r110, 2131392452);
        if (r2 == null) goto L61;
        r1 = 2131392453;
        View r3 = ViewBindings.findChildViewById(r110, 2131392453);
        if (r3 == null) goto L61;
        r1 = 2131392454;
        View r4 = ViewBindings.findChildViewById(r110, 2131392454);
        if (r4 == null) goto L61;
        r1 = 2131392455;
        View r5 = ViewBindings.findChildViewById(r110, 2131392455);
        if (r5 == null) goto L61;
        r1 = 2131392456;
        View r6 = ViewBindings.findChildViewById(r110, 2131392456);
        if (r6 == null) goto L61;
        r1 = 2131392457;
        View r7 = ViewBindings.findChildViewById(r110, 2131392457);
        if (r7 == null) goto L61;
        r1 = 2131392458;
        View r8 = ViewBindings.findChildViewById(r110, 2131392458);
        if (r8 == null) goto L61;
        r1 = 2131392459;
        View r9 = ViewBindings.findChildViewById(r110, 2131392459);
        if (r9 == null) goto L61;
        r1 = 2131392460;
        View r10 = ViewBindings.findChildViewById(r110, 2131392460);
        if (r10 == null) goto L61;
        r110.b = new OfficeSdkMmViewEndWindowLoadingBinding(r110, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r110.c = r111;
        r110.setBackgroundColor(UIUtils.getColor(r110.getContext(), 2131100548));
        OfficeSdkMmViewEndWindowLoadingBinding r112 = r110.b;
        OfficeSdkMmViewEndWindowLoadingBinding r11 = null;
        if (r112 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L32:
        r110.S5(r112.b, 2131564105);
        OfficeSdkMmViewEndWindowLoadingBinding r113 = r110.b;
        if (r113 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L35:
        r110.S5(r113.c, 2131564102);
        OfficeSdkMmViewEndWindowLoadingBinding r114 = r110.b;
        if (r114 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L38:
        r110.S5(r114.d, 2131564105);
        OfficeSdkMmViewEndWindowLoadingBinding r115 = r110.b;
        if (r115 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L41:
        r110.S5(r115.e, 2131564103);
        OfficeSdkMmViewEndWindowLoadingBinding r116 = r110.b;
        if (r116 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L44:
        r110.S5(r116.f, 2131564104);
        OfficeSdkMmViewEndWindowLoadingBinding r117 = r110.b;
        if (r117 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L47:
        r110.S5(r117.g, 2131564102);
        OfficeSdkMmViewEndWindowLoadingBinding r118 = r110.b;
        if (r118 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L50:
        r110.S5(r118.h, 2131564103);
        OfficeSdkMmViewEndWindowLoadingBinding r119 = r110.b;
        if (r119 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L53:
        r110.S5(r119.i, 2131564104);
        OfficeSdkMmViewEndWindowLoadingBinding r120 = r110.b;
        if (r120 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L57:
        r110.S5(r11.j, 2131564102);
    L59:
        return r19.a;
    L56:
        r11 = r120;
    L61:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r1)));
    L9:
        if (r110.c != r111) goto L11;
    L5:
        return new View(r13.getContext());
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void Y90(int r4, int r5, int r6, int r7) {
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.END_WINDOW;
        StringBuilder r2 = new StringBuilder("onWindowInsetsChanged: insets=[");
        r2.append(r4);
        r2.append(',');
        r2.append(r5);
        r2.append(',');
        r2.append(r6);
        r2.append(',');
        r2.append(r7);
        r2.append("], hasNavRectProvider=");
        if (((uub.b) this.o.getValue()) == null) goto L5;
        boolean r8 = true;
    L6:
        r2.append(r8);
        bwb.b.f(r1, "onWindowInsetsChanged", r2.toString(), U90());
        com.ss.android.lark.officesdk.minutes.ui.style.e r9 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r3 = this.x;
        r9.getClass();
        if (com.ss.android.lark.officesdk.minutes.ui.style.e.b(r3).getCapability().e() == true) goto L9;
    L11:
        ViewGroup.LayoutParams r10 = fa0().e.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        r11.topMargin = r5 + UIUtils.dp2px(fa0().e.getContext(), 2.0f);
        fa0().e.setLayoutParams(r11);
        fa0().b.setPadding(0, 0, 0, r7);
        return;
    L9:
        if (((uub.b) this.o.getValue()) == null) goto L11;
        return;
    L5:
        r8 = false;
        goto L6
    }

    public static void ja0(MmEndWindowFragment r18, Integer r19, String r20, Long r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Integer r6 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Long r16 = null;
    L15:
        if (r18.A == true) goto L23;
        r18.A = true;
        qvb.a r3 = qvb.a.a;
        if (r1 != null) goto L20;
        String r7 = "";
    L21:
        qvb.a.c(r3, "endwindow", "error", r6, r7, null, null, null, null, null, null, null, Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())), r16, 2032);
        return;
    L20:
        r7 = r1;
        goto L21
    L23:
        return;
    L13:
        r16 = r21;
        goto L15
    L9:
        r1 = r20;
        goto L11
    L5:
        r6 = r19;
        goto L7
    }
}
