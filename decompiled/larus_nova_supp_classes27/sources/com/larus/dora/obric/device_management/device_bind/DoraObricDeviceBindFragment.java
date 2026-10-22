package com.larus.dora.obric.device_management.device_bind;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.t0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0017\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\u000eH\u0002J \u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\t2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\tH\u0002J\b\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/dora/obric/device_management/device_bind/DoraObricDeviceBindFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "isChecking", "", "onboardingDialogFragment", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "prePage", "", "gpsDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "pendingCheckAction", "Lkotlin/Function0;", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "productID", "", "Ljava/lang/Integer;", "buryPointSource", "pageRenderer", "Lcom/larus/dora/obric/device_management/device_bind/DoraObricBindPageRenderer;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDestroyView", "getCurrentPageName", "buildContentView", "buildNativePageContent", "Lcom/larus/dora/obric/device_management/device_bind/DoraObricBindPageRenderer$Content;", "buildBuyUrl", "productId", "isGlassesProduct", "(Ljava/lang/Integer;)Z", "openBuyPage", "url", "startBind", "checkReady", "from", "doNext", "handlePermissionDenied", "reason", "launchOnboarding", "resolveProductId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceBindFragment extends DoraBaseFragment {
    public static final int[] o = null;
    public boolean f;
    public BottomSheetDialogFragment g;
    public String h;
    public CommonDialog i;
    public Function0<Unit> j;
    public ActivityResultLauncher<Intent> k;
    public Integer l;
    public String m;
    public f n;

    public static final class a {
    }

    public final String k() {
        return "DoraObricDeviceBindFragment";
    }

    static {
        o = new int[]{ProductNameType.DORA_G.id, ProductNameType.DORA_G2.id, ProductNameType.DORA_G_AIR.id, ProductNameType.DORA_G_PIN.id};
    }

    public final void onDestroyView() {
        f r0 = this.n;
        if (r0 == null) goto L5;
        r0.e = null;
        r0.f = null;
        r0.g = null;
        r0.h = null;
        r0.i = null;
        r0.j = null;
        r0.k = null;
    L5:
        this.n = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricDeviceBindFragment() {
        this.j = new g();
        this.m = "";
    }

    public final int Z90() {
        Integer r0 = t0.a(getArguments(), "product_id");
        if (r0 != null) goto L7;
        int r1 = ProductNameType.DORA_LITE.id;
        g49.d.e("DoraObricDeviceBindFragment", "resolveProductId missing or invalid, use Dora Lite");
        return r1;
    L7:
        return r0.intValue();
    }

    public static boolean Y90(Integer r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (ArraysKt.contains(o, r1.intValue()) == false) goto L6;
        return true;
    }

    public final void X90(String r2) {
        g49.d.d("DoraObricDeviceBindFragment", "handlePermissionDenied: ".concat(r2));
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new i(this));
    }

    public final void W90(String r8, Function0<Unit> r9) {
        g49.d.d("DoraObricDeviceBindFragment", "checkReady: " + r8 + " start");
        if (Intrinsics.areEqual(r8, "check_from_MAIN") == true) goto L5;
    L8:
        this.f = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricDeviceBindFragment$checkReady$1(r8, r9, this, null), 3, null);
        return;
    L5:
        if (this.f == false) goto L8;
        g49.d.d("DoraObricDeviceBindFragment", "checkReady: " + r8 + " isChecking");
    }

    public final void onViewCreated(View r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r21, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r21, r22);
        f r1 = this.n;
        boolean r2 = false;
        if (r1 == null) goto L30;
        Integer r5 = this.l;
        if (r5 == null) goto L7;
        int r6 = r5.intValue();
    L8:
        boolean r7 = Y90(Integer.valueOf(r6));
        if (r7 == false) goto L11;
        int r8 = 2131903444;
    L12:
        if (r7 == false) goto L14;
        int r9 = 2131903443;
    L15:
        String r10 = getString(r8);
        String r11 = getString(r9);
        if (r7 == false) goto L18;
        int r12 = 0;
    L19:
        if (r7 == false) goto L21;
        String r13 = "larus_dora_obric_device_bind_img_glasses";
    L22:
        String r14 = getString(2131902189);
        if (r7 == false) goto L25;
        String r16 = null;
    L26:
        if (r7 == false) goto L28;
        String r17 = null;
    L29:
        r1.d(new f.b(r10, r11, r12, r13, r14, true, r16, r17, !r7, 256));
        goto L30
    L28:
        r17 = UriProtector.parse("sslocal://flow/webview").buildUpon().appendQueryParameter("product_id", String.valueOf(r6)).appendQueryParameter("link_url", "https://www.olafriend.cn/product?allows_inline_media_playback=1").build().toString();
        goto L29
    L25:
        r16 = getString(2131903346);
        goto L26
    L21:
        r13 = null;
        goto L22
    L18:
        r12 = 2131240542;
        goto L19
    L14:
        r9 = 2131903433;
        goto L15
    L11:
        r8 = 2131903434;
        goto L12
    L7:
        r6 = ProductNameType.DORA_LITE.id;
    L30:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        Bundle r3 = getArguments();
        if (r3 != null) goto L33;
    L35:
        if (r2 == false) goto L38;
        W90("check_from_MAIN", new j(this));
        return;
    L38:
        return;
    L33:
        if (r3.getBoolean("key_dora_onboarding_auto_connect") != true) goto L35;
        r2 = true;
        goto L35
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Bundle r6 = getArguments();
        String r7 = "";
        if (r6 == null) goto L6;
        String r8 = r6.getString("device_manage", "");
        if (r8 == null) goto L6;
    L7:
        this.h = r8;
        this.l = Integer.valueOf(Z90());
        Bundle r9 = getArguments();
        if (r9 == null) goto L10;
        String r10 = r9.getString("bury_point_source");
    L11:
        if (r10 == null) goto L14;
        r7 = r10;
    L14:
        this.m = r7;
        f r11 = new f(requireContext(), new h(this), new DoraObricDeviceBindFragment$buildContentView$2(this), new DoraObricDeviceBindFragment$buildContentView$3(this));
        this.n = r11;
        return r11.b();
    L10:
        r10 = null;
    L6:
        r8 = "";
        goto L7
    }
}
