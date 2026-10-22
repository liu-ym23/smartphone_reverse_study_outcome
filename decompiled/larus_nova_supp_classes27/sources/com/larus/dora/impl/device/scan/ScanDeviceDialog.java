package com.larus.dora.impl.device.scan;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.dora.impl.core.BindAndConnectResult;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraDialogScanDeviceBinding;
import com.larus.dora.impl.device.DoraDeviceViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Deprecated(message = "This dialog is only used in DoraDeviceFragment, and DoraDeviceFragment is deprecated")
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001a\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u001dH\u0016J\b\u00100\u001a\u00020\u001dH\u0016J\u0016\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u0010\u00106\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00068"}, d2 = {"Lcom/larus/dora/impl/device/scan/ScanDeviceDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/DoraDeviceViewModel;", "getModel", "()Lcom/larus/dora/impl/device/DoraDeviceViewModel;", "model$delegate", "Lkotlin/Lazy;", "scanDialogModel", "Lcom/larus/dora/impl/device/scan/ScanDeviceDialogViewModel;", "getScanDialogModel", "()Lcom/larus/dora/impl/device/scan/ScanDeviceDialogViewModel;", "scanDialogModel$delegate", "lastLinkState", "", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDialogScanDeviceBinding;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "scanListAdapter", "Lcom/larus/dora/impl/device/scan/ScanDeviceListAdapter;", "isConnectingOrReplacing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "doraLinkCallback", "com/larus/dora/impl/device/scan/ScanDeviceDialog$doraLinkCallback$1", "Lcom/larus/dora/impl/device/scan/ScanDeviceDialog$doraLinkCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupStatusBar", "window", "Landroid/view/Window;", "onViewCreated", "view", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "onStop", "onDestroyView", "connect", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showNeedUnbindDialog", "replaceAndConnect", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanDeviceDialog extends DialogFragment {
    public static final /* synthetic */ int l = 0;
    public final Lazy d;
    public final Lazy e;
    public int f;
    public LarusDoraDialogScanDeviceBinding g;
    public final CoroutineScope h;
    public ScanDeviceListAdapter i;
    public final AtomicBoolean j;
    public final ScanDeviceDialog$doraLinkCallback$1 k;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ ScanDeviceDialog a;

        public b(ScanDeviceDialog r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            j r7 = (j) r5;
            ScanDeviceListAdapter r8 = this.a.i;
            if (r8 == null) goto L19;
            Intrinsics.checkNotNullParameter(r7, "deviceModel");
            List<j> r0 = r8.a;
            if ((r0 instanceof Collection) == true) goto L7;
        L9:
            Iterator r1 = ((ArrayList) r0).iterator();
        L11:
            if (r1.hasNext() == false) goto L15;
            if (Intrinsics.areEqual(((j) r1.next()).a, r7.a) == false) goto L11;
            boolean r2 = false;
        L16:
            if (r2 == false) goto L19;
            ((ArrayList) r8.a).add(r7);
            r8.notifyItemInserted(((ArrayList) r8.a).size() - 1);
        L15:
            r2 = true;
            goto L16
        L7:
            if (((ArrayList) r0).isEmpty() == false) goto L9;
        L19:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.dora.impl.device.scan.ScanDeviceDialog$doraLinkCallback$1] */
    public ScanDeviceDialog() {
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraDeviceViewModel.class), new ScanDeviceDialog$special$$inlined$activityViewModels$default$1(this), new ScanDeviceDialog$special$$inlined$activityViewModels$default$2(this));
        final Function0<Fragment> r0 = new ScanDeviceDialog$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ScanDeviceDialogViewModel.class), new ScanDeviceDialog$special$$inlined$viewModels$default$2(r0), new ScanDeviceDialog$special$$inlined$viewModels$default$3(r0, this));
        this.h = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.j = new AtomicBoolean(false);
        this.k = new ScanDeviceDialog$doraLinkCallback$1(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.g = null;
        kj4.a.g().unregisterDoraLinkCallback(this.k);
        if (this.f != 2) goto L5;
        boolean r0 = true;
    L6:
        g49.d.d("ScanDeviceDialog", "showBluetoothDialog is " + r0);
        o5.a(this, "showBluetoothDialog", com.larus.utils.f.c(new Pair[]{TuplesKt.to("showBluetoothDialog", Boolean.valueOf(r0))}));
        o5.a(this, "find_device", com.larus.utils.f.c(new Pair[0]));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        ((ScanDeviceDialogViewModel) this.e.getValue()).startScan();
    }

    public final void onStop() {
        super.onStop();
        ((ScanDeviceDialogViewModel) this.e.getValue()).stopScan();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(2, 2131953746);
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        if ((((DoraDeviceViewModel) this.d.getValue()).getDeviceStateFlow().getValue() instanceof com.larus.dora.impl.device.c.b) == false) goto L5;
        g49.d.d("ScanDeviceDialog", "dialog dismissed and deviceState=DeviceState.Disconnected");     // Catch: Throwable -> L7
        ((DoraDeviceViewModel) this.d.getValue()).startConnectOrScan("ScanDeviceDialog#onDismiss");     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        LarusDoraDialogScanDeviceBinding r9 = this.g;
        if (r9 == null) goto L7;
        FrameLayout r10 = r9.a;
        if (r10 == null) goto L7;
        r10.setOnClickListener(new com.larus.dora.impl.device.scan.a(this));
    L7:
        final ScanDeviceListAdapter r11 = new ScanDeviceListAdapter();
        Function1<? super j, Unit> r12 = new com.larus.dora.impl.device.scan.b(this, r11);
        Intrinsics.checkNotNullParameter(r12, "clickAction");
        r11.b = r12;
        this.i = r11;
        LarusDoraDialogScanDeviceBinding r13 = this.g;
        if (r13 == null) goto L12;
        RecyclerView r14 = r13.b;
        if (r14 == null) goto L12;
        r14.setLayoutManager(new LinearLayoutManager(r14.getContext()));
        r14.setAdapter(this.i);
    L12:
        this.j.set(false);
        kj4.a.g().registerDoraLinkCallback(this.k);
        Lifecycle.State r15 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ScanDeviceDialog$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r15, null, this), 3, null);
    }

    public static final Object S90(ScanDeviceDialog r6, DoraDevice r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof ScanDeviceDialog$connect$1) == false) goto L7;
        ScanDeviceDialog$connect$1 r0 = (ScanDeviceDialog$connect$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L24:
        Unit r10 = (Unit) r9;
    L26:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L19:
        BindAndConnectResult r11 = (BindAndConnectResult) r9;
        r6.j.set(false);
        if (r6.getActivity() == null) goto L26;
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        ScanDeviceDialog$connect$2$1 r5 = new ScanDeviceDialog$connect$2$1(r11, r6, r7, null);
        r0.L$0 = null;
        r0.label = 2;
        r9 = BuildersKt.withContext(r4, r5, r0);
        if (r9 != r2) goto L24;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        r6.j.set(true);
        kj4.a r12 = kj4.a.g();
        r0.L$0 = r7;
        r0.label = 1;
        r9 = DoraAdapterExtKt.a(r12, r7, r0);
        if (r9 != r2) goto L19;
        return r2;
    L7:
        r0 = new ScanDeviceDialog$connect$1(r6, r8);
        goto L8
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562168, r9, false);
        int r12 = 2131367771;
        RoundLinearLayout r13 = (RoundLinearLayout) ViewBindings.findChildViewById(r11, 2131367771);
        if (r13 == null) goto L28;
        r12 = 2131368922;
        RecyclerView r1 = ViewBindings.findChildViewById(r11, 2131368922);
        if (r1 == null) goto L28;
        r12 = 2131372535;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131372535)) == null) goto L28;
        FrameLayout r14 = (FrameLayout) r11;
        LarusDoraDialogScanDeviceBinding r15 = new LarusDoraDialogScanDeviceBinding(r14, r13, r1);
        Dialog r2 = getDialog();
        if (r2 == null) goto L11;
        r2.setCanceledOnTouchOutside(true);
    L11:
        Dialog r3 = getDialog();
        if (r3 == null) goto L25;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L25;
        r4.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)));
        r4.setFlags(512, 512);
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L18;
        boolean r5 = true;
    L19:
        WindowCompat.setDecorFitsSystemWindows(r4, false);
        r4.setStatusBarColor(Color.argb(1, 255, 255, 255));
        View r0 = r4.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L24;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r6 = ThreadMethodProxy.currentThread();
        if (r6 == com.larus.home.impl.utils.c.a) goto L24;
        com.larus.home.impl.utils.c.a(r6, "getDecorView");
    L24:
        WindowCompat.getInsetsController(r4, r0).setAppearanceLightStatusBars(!r5);
        goto L25
    L18:
        r5 = false;
    L25:
        i0.a.getClass();
        int r7 = i0.g();
        int r16 = r13.getPaddingStart();
        int r17 = r13.getPaddingEnd();
        int r18 = r13.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r13.getClass().getSimpleName() + ",source:,start:" + r16 + ",top:" + r7 + ",end:" + r17 + ",bottom:" + r18);
        r13.setPaddingRelative(r16, r7, r17, r18);
        this.g = r15;
        return r14;
    L28:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
