package com.larus.dora.impl.onboarding.lite;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraOnboardingDeviceFoundBinding;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Deprecated(message = "This fragment is only used in DoraDeviceFragment, and DoraDeviceFragment is deprecated.")
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0011\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0012\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\u0016\u0010*\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006/"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraOnboardingDeviceFoundBinding;", "interruptDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "needUnbindDialog", "state", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment$UiState;", "enterPageTraced", "", "newMultiDevice", "doraOnboardingDevice", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "doraLinkCallback", "com/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1", "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onResume", "onDestroyView", "connect", "device", "Lcom/bytedance/dora/device/DoraDevice;", "updateUi", "uiState", "gotoDeviceGuide", "showInterruptDialog", "showNeedUnbindDialog", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceAndConnect", "UiState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraLiteOnboardingConnectDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int l = 0;
    public LarusDoraOnboardingDeviceFoundBinding d;
    public CommonDialog e;
    public CommonDialog f;
    public UiState g;
    public boolean h;
    public boolean i;
    public DoraOnboardingDevice j;
    public final DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1 k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingConnectDialogFragment$UiState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CONNECTING", "CONNECTED", "DISCONNECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UiState extends Enum<UiState> {
        public static final UiState CONNECTED = null;
        public static final UiState CONNECTING = null;
        public static final UiState DISCONNECTED = null;
        public static final UiState IDLE = null;
        public static final /* synthetic */ UiState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<UiState> getEntries() {
            return b;
        }

        static {
            UiState r0 = new UiState("IDLE", 0);
            IDLE = r0;
            UiState r1 = new UiState("CONNECTING", 1);
            CONNECTING = r1;
            UiState r3 = new UiState("CONNECTED", 2);
            CONNECTED = r3;
            UiState r5 = new UiState("DISCONNECTED", 3);
            DISCONNECTED = r5;
            UiState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static UiState[] values() {
            return (UiState[]) a.clone();
        }

        public static UiState valueOf(String r1) {
            return (UiState) r27.a.a(UiState.class, r1);
        }

        public UiState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UiState.values().length];
            r0[UiState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[UiState.CONNECTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[UiState.CONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[UiState.DISCONNECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DoraLiteOnboardingConnectDialogFragment a;

        public c(DoraLiteOnboardingConnectDialogFragment r1) {
            this.a = r1;
        }

        public final void a() {
            DoraLiteOnboardingConnectDialogFragment r0 = this.a;
            int r1 = DoraLiteOnboardingConnectDialogFragment.l;
            r0.getClass();
            Bundle r3 = r0.getArguments();     // Catch: Throwable -> L26
            String r5 = null;
            if (r3 == null) goto L7;
            DoraOnboardingDevice r4 = (DoraOnboardingDevice) r3.getParcelable("key_dora_onboarding_device");     // Catch: Throwable -> L26
        L8:
            Bundle r6 = r0.getArguments();     // Catch: Throwable -> L26
            if (r6 == null) goto L11;
            String r7 = r6.getString("key_dora_onboarding_origin_from");     // Catch: Throwable -> L26
        L12:
            Context r8 = r0.getContext();     // Catch: Throwable -> L26
            if (r8 != null) goto L16;
            return;
        L16:
            if (r0.i == false) goto L24;
            Intent r9 = new Intent("action.DEVICE_UPDATE_DYNAMIC");     // Catch: Throwable -> L26
            if (r4 == null) goto L20;
            r5 = r4.b;     // Catch: Throwable -> L26
        L20:
            r9.putExtra("mac", r5);     // Catch: Throwable -> L26
            LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r9);     // Catch: Throwable -> L26
            if (Intrinsics.areEqual(r7, "device_manage") == false) goto L23;
            g49.d.d("DoraOnboardingConnectDialogFragment", "from page : " + r7);     // Catch: Throwable -> L26
            goto L24
        L23:
            n1.i();     // Catch: Throwable -> L26
        L24:
            com.bytedance.router.i r2 = SmartRouter.buildRoute(r8, "//dora_onboarding_v2");     // Catch: Throwable -> L26
            r2.d = 2130772372;     // Catch: Throwable -> L26
            r2.e = 2130772399;     // Catch: Throwable -> L26
            r2.c.putExtra("key_dora_onboarding_device", r4);     // Catch: Throwable -> L26
            r2.d();     // Catch: Throwable -> L26
            DoraLiteOnboardingConnectDialogFragment.S90(r0);     // Catch: Throwable -> L26
            return;
        L11:
            r7 = null;
            goto L12
        L7:
            r4 = null;
        L26:
            th = move-exception;
            g49.d.c("DoraOnboardingConnectDialogFragment", "gotoDeviceGuide: exception", th);
            DoraLiteOnboardingConnectDialogFragment.S90(r0);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951935;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1] */
    public DoraLiteOnboardingConnectDialogFragment() {
        this.g = UiState.IDLE;
        this.k = new DoraLiteOnboardingConnectDialogFragment$doraLinkCallback$1(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        kj4.a.g().unregisterDoraLinkCallback(this.k);
        LarusDoraOnboardingDeviceFoundBinding r0 = this.d;
        if (r0 == null) goto L8;
        DoraMovieView r1 = r0.e;
        if (r1 == null) goto L9;
        r1.g();
        r1.f();
        return;
    L9:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.h == true) goto L6;
        j49.a.g("", "earphone_connection");
        this.h = true;
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        BottomSheetBehavior.from(r0.findViewById(2131368870)).setHideable(false);
        return;
    }

    public static void S90(DoraLiteOnboardingConnectDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(UiState r4) {
        this.g = r4;
        int r5 = b.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        LarusDoraOnboardingDeviceFoundBinding r6 = this.d;
        if (r6 == null) goto L46;
        LinearLayoutCompat r7 = r6.d;
        if (r7 == null) goto L46;
        e1.o(r7);
    L46:
        LarusDoraOnboardingDeviceFoundBinding r8 = this.d;
        if (r8 == null) goto L61;
        AppCompatTextView r9 = r8.c;
        if (r9 == null) goto L62;
        e1.x(r9);
        return;
    L62:
        return;
    L61:
        return;
    L5:
        if (r5 != 2) goto L7;
        LarusDoraOnboardingDeviceFoundBinding r10 = this.d;
        if (r10 == null) goto L36;
        LinearLayoutCompat r11 = r10.d;
        if (r11 == null) goto L36;
        e1.x(r11);
    L36:
        LarusDoraOnboardingDeviceFoundBinding r12 = this.d;
        if (r12 == null) goto L58;
        AppCompatTextView r13 = r12.c;
        if (r13 == null) goto L59;
        e1.o(r13);
        return;
    L59:
        return;
    L58:
        return;
    L7:
        if (r5 != 3) goto L9;
        boolean r14 = com.larus.dora.impl.onboarding.d.a;
        com.larus.dora.impl.onboarding.d.d = SystemClock.elapsedRealtime();
        CommonDialog r15 = this.e;
        if (r15 != null) goto L52;
    L30:
        new Handler(Looper.getMainLooper()).postDelayed(new c(this), 200);
        return;
    L52:
        r15.dismissAllowingStateLoss();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L30;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L30
    L9:
        if (r5 != 4) goto L21;
        LarusDoraOnboardingDeviceFoundBinding r17 = this.d;
        if (r17 == null) goto L15;
        LinearLayoutCompat r18 = r17.d;
        if (r18 == null) goto L15;
        e1.o(r18);
    L15:
        LarusDoraOnboardingDeviceFoundBinding r20 = this.d;
        if (r20 == null) goto L54;
        AppCompatTextView r21 = r20.c;
        if (r21 == null) goto L55;
        e1.x(r21);
        return;
    L55:
        return;
    L54:
        return;
    L21:
        throw new NoWhenBranchMatchedException();
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        BottomSheetDialog r11 = getDialog();
        if ((r11 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r12 = r11;
    L6:
        if (r12 == null) goto L8;
        View r13 = r12.findViewById(2131368870);
    L9:
        int r14 = com.larus.utils.m0.a;
        int r15 = com.larus.utils.m0.a(getContext());
        com.larus.utils.i0.a.getClass();
        int r16 = ((r15 - com.larus.utils.i0.g()) - com.larus.utils.i0.e()) - i5.c0();
        if (r13 == null) goto L12;
        ViewGroup.LayoutParams r1 = r13.getLayoutParams();
        r1.height = r16;
        r13.setLayoutParams(r1);
        BottomSheetBehavior r2 = BottomSheetBehavior.from(r13);
        r13.setBackgroundResource(R.color.transparent);
        r2.setState(3);
        r2.setPeekHeight(r16);
    L12:
        Bundle r17 = getArguments();
        if (r17 == null) goto L15;
        final DoraOnboardingDevice r18 = (DoraOnboardingDevice) r17.getParcelable("key_dora_onboarding_device");
    L16:
        Bundle r110 = getArguments();
        boolean r3 = false;
        if (r110 == null) goto L19;
        boolean r111 = r110.getBoolean("key_dora_onboarding_auto_connect", false);
    L20:
        this.j = r18;
        Bundle r4 = getArguments();
        if (r4 == null) goto L23;
        r3 = r4.getBoolean("key_dora_is_new_multi_device", false);
    L23:
        this.i = r3;
        final LarusDoraOnboardingDeviceFoundBinding r5 = this.d;
        if (r5 == null) goto L26;
        e1.d(r5.b, new com.larus.dora.impl.onboarding.lite.a(this));
        e1.d(r5.c, new com.larus.dora.impl.onboarding.lite.b(r18, this));
        r5.e.post(new com.larus.dora.impl.onboarding.lite.c(r18, r5));
    L26:
        kj4.a.g().registerDoraLinkCallback(this.k);
        if (r111 == false) goto L36;
        if (r18 == null) goto L30;
        DoraDevice r20 = com.larus.dora.impl.onboarding.x.b(r18);
    L31:
        StringBuilder r112 = new StringBuilder("auto connect ");
        if (r20 == null) goto L34;
        String r6 = o59.a.h(r20);
    L35:
        r112.append(r6);
        g49.d.d("DoraOnboardingConnectDialogFragment", r112.toString());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraLiteOnboardingConnectDialogFragment$connect$1(this, r20, null), 3, null);
        return;
    L34:
        r6 = null;
        goto L35
    L30:
        r20 = null;
        goto L31
    L36:
        T90(UiState.IDLE);
        return;
    L19:
        r111 = false;
        goto L20
    L15:
        r18 = null;
        goto L16
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562238, r9, false);
        int r12 = 2131369870;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r11, 2131369870);
        if (r2 == null) goto L17;
        r12 = 2131369874;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r11, 2131369874);
        if (r3 == null) goto L17;
        r12 = 2131369875;
        LinearLayoutCompat r4 = ViewBindings.findChildViewById(r11, 2131369875);
        if (r4 == null) goto L17;
        r12 = 2131369879;
        DoraMovieView r5 = (DoraMovieView) ViewBindings.findChildViewById(r11, 2131369879);
        if (r5 == null) goto L17;
        r12 = 2131369880;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131369880);
        if (r6 == null) goto L17;
        r12 = 2131369940;
        if (ViewBindings.findChildViewById(r11, 2131369940) == null) goto L17;
        FrameLayout r13 = (FrameLayout) r11;
        this.d = new LarusDoraOnboardingDeviceFoundBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
