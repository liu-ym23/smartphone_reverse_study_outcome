package com.larus.dora.impl.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.s0;
import com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingWakeupFragment;
import com.larus.dora.impl.onboarding.othersmart.DoraHOnboardingNotificationGuideFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020(H\u0016J\b\u0010-\u001a\u00020(H\u0016J\b\u0010.\u001a\u00020(H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\b\u00100\u001a\u00020\u0006H\u0016J\b\u00101\u001a\u00020\u0006H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u00104\u001a\u00020(H\u0016J\u0010\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u0006H\u0004J\u0010\u00109\u001a\u00020(2\u0006\u0010:\u001a\u00020\u0001H\u0016J\u0010\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u0010H\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001c\u0010$\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001a¨\u0006>"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/trace/tracknode/IFlowPageTrackNode;", "<init>", "()V", "enterPageTraced", "", "enterPageTimeInMillis", "", "settingGroup", "Lcom/larus/bmhome/view/item/ItemGroup;", "getSettingGroup", "()Lcom/larus/bmhome/view/item/ItemGroup;", "setSettingGroup", "(Lcom/larus/bmhome/view/item/ItemGroup;)V", "buryPointSource", "", "getBuryPointSource", "()Ljava/lang/String;", "setBuryPointSource", "(Ljava/lang/String;)V", "continueBtn", "Landroid/widget/TextView;", "getContinueBtn", "()Landroid/widget/TextView;", "setContinueBtn", "(Landroid/widget/TextView;)V", "continueBtnPb", "Landroid/view/View;", "getContinueBtnPb", "()Landroid/view/View;", "setContinueBtnPb", "(Landroid/view/View;)V", "skpBtn", "getSkpBtn", "setSkpBtn", "laterBtn", "getLaterBtn", "setLaterBtn", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "onSkipButtonClicked", "shouldShowSkipButton", "autoLogShipButton", "autoLogEnterPage", "autoLogExitPage", "getCurrentCardName", "logEnterPage", "logExitPage", "enterTime", "isUsingObricLogic", "isDoraKeepAliveEnableForObric", "next", "fragment", "gotoDeviceManagePage", "mac", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraOnboardingBaseFragment extends Fragment implements com.larus.trace.tracknode.a {
    public static final /* synthetic */ int l = 0;
    public boolean d;
    public long e;
    public ItemGroup f;
    public String g;
    public TextView h;
    public View i;
    public TextView j;
    public TextView k;

    public static final class a {
    }

    static {
    }

    public boolean S90() {
        return !(this instanceof DoraLiteOnboardingWakeupFragment);
    }

    public boolean T90() {
        return !(this instanceof DoraLiteOnboardingWakeupFragment);
    }

    public boolean U90() {
        return true;
    }

    public String V90() {
        return null;
    }

    public void aa0() {
    }

    public boolean ba0() {
        return !(this instanceof DoraHOnboardingNotificationGuideFragment);
    }

    public final boolean et() {
        return false;
    }

    public final by7.e parentTrackNode() {
        return null;
    }

    public final void te() {
    }

    public static boolean X90() {
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.q() != true) goto L7;
        return true;
    }

    public static boolean Y90() {
        IObricDoraService r0 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.t() != true) goto L7;
        return true;
    }

    public DoraOnboardingBaseFragment() {
        this.g = "";
    }

    public final void onDestroy() {
        super.onDestroy();
        if (T90() == false) goto L6;
        long r0 = this.e;
        long r2 = SystemClock.elapsedRealtime() - r0;
        int r1 = m0.a;
        m0.h(k(), r2, false);
        return;
    }

    public void onResume() {
        super.onResume();
        if (S90() == true) goto L5;
        return;
    L5:
        if (this.d == true) goto L9;
        int r0 = m0.a;
        m0.g(k(), this.g, V90());
        this.d = true;
        this.e = SystemClock.elapsedRealtime();
        return;
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public final void W90(String r6) {
        Intrinsics.checkNotNullParameter(r6, "mac");
        FragmentActivity r0 = getActivity();
        Integer r1 = null;
        if (r0 == null) goto L7;
        Intent r2 = r0.getIntent();
        if (r2 == null) goto L7;
        DoraOnboardingDevice r3 = (DoraOnboardingDevice) r2.getParcelableExtra("key_dora_onboarding_device");
    L8:
        s0 r4 = s0.a;
        Context r5 = requireContext();
        r4.getClass();
        if (s0.e(r5, r3) == false) goto L11;
        return;
    L11:
        Iterator r7 = DoraAdapterExtKt.k(kj4.a.g()).iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((DoraDevice) r8).mac, r6) == false) goto L13;
    L18:
        DoraDevice r9 = (DoraDevice) r8;
        s0 r10 = s0.a;
        if (r9 == null) goto L21;
        Integer r11 = Integer.valueOf(r9.productId);
    L22:
        if (r9 == null) goto L24;
        Integer r12 = Integer.valueOf(r9.type);
    L25:
        r10.getClass();
        boolean r13 = s0.a(r11, r12);
        int r14 = com.larus.dora.impl.util.s.a;
        if (r9 == null) goto L29;
        r1 = Integer.valueOf(r9.productId);
    L29:
        if (com.larus.dora.impl.util.s.c(r1) == false) goto L32;
        if (r13 == false) goto L32;
        String r15 = "//dora_g_device_management";
    L33:
        com.bytedance.router.i r16 = SmartRouter.buildRoute(AppHost.a.getApplication(), r15);
        r16.d = 0;
        r16.e = 2130772373;
        r16.c.addFlags(603979776);
        r16.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r6);
        if (r9 == null) goto L36;
        int r17 = r9.productId;
    L37:
        r16.c.putExtra("product_id", r17);
        r16.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_manage_v3");
        r16.d();
        return;
    L36:
        r17 = -1;
    L32:
        r15 = "//dora_dynamic_list";
        goto L33
    L24:
        r12 = null;
        goto L25
    L21:
        r11 = null;
        goto L22
    L17:
        r8 = null;
    L7:
        r3 = null;
        goto L8
    }

    public void Z90(Fragment r8) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        if (isAdded() == true) goto L5;
    L9:
        g49.d.e("DoraOnboardingBaseFragment", "current fragment is not added or statedSaved, cannot navigate to next fragment");
        return;
    L5:
        if (isStateSaved() == true) goto L9;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new DoraOnboardingBaseFragment$next$1(this, r8, null), 2, null);
    }

    public final void fillTrackParams(TrackParams r1) {
        com.larus.trace.tracknode.a.a.a(this, r1);
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Bundle r4 = getArguments();
        TextView r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.getString("bury_point_source");
    L6:
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        this.g = r6;
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L11;
        TextView r8 = (TextView) r7.findViewById(2131369877);
    L12:
        this.h = r8;
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L15;
        View r10 = r9.findViewById(2131369878);
    L16:
        this.i = r10;
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L21;
        TextView r12 = (TextView) r11.findViewById(2131369901);
        if (r12 == null) goto L21;
        e1.o(r12);
    L22:
        this.k = r12;
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L25;
        ItemGroup r14 = (ItemGroup) r13.findViewById(2131369938);
    L26:
        this.f = r14;
        FragmentActivity r15 = getActivity();
        if (r15 == null) goto L35;
        TextView r16 = (TextView) r15.findViewById(2131369939);
        if (r16 == null) goto L35;
        if (ba0() == false) goto L33;
        e1.x(r16);
        e1.d(r16, new e(this));
    L34:
        r5 = r16;
        goto L35
    L33:
        e1.o(r16);
    L35:
        this.j = r5;
        return;
    L25:
        r14 = null;
    L21:
        r12 = null;
        goto L22
    L15:
        r10 = null;
        goto L16
    L11:
        r8 = null;
        goto L12
    L5:
        r6 = null;
        goto L6
    }
}
