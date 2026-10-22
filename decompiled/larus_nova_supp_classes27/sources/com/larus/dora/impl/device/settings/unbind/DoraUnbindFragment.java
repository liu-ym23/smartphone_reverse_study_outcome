package com.larus.dora.impl.device.settings.unbind;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraUnbindBinding;
import com.larus.dora.impl.device.settings.DoraUnbindBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindFragment;", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraUnbindBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindViewModel;", "model$delegate", "Lkotlin/Lazy;", "getCurrentPageName", "", "getPageMaskView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showUnbindConfirmDialog", "showLowPowerConfirmDialog", "context", "Landroid/content/Context;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraUnbindFragment extends DoraUnbindBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraUnbindBinding g;
    public final Lazy h;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraUnbindFragment a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[DoraUnbindState.values().length];
                r0[DoraUnbindState.SERVER_UNBIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[DoraUnbindState.NO_DEVICE_CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[DoraUnbindState.SERVER_UNBIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[DoraUnbindState.SPP_DISCONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[DoraUnbindState.UNBIND_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public b(DoraUnbindFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v8, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.util.ArrayList] */
        public final Object emit(Object r9, Continuation r10) {
            Pair r11 = (Pair) r9;
            int r12 = a.a[((DoraUnbindState) r11.getFirst()).ordinal()];
            boolean r0 = true;
            if (r12 != 1) goto L5;
            s r13 = s.a;
            Context r14 = this.a.getContext();
            String r1 = this.a.getString(2131902938);
            r13.getClass();
            s.c(r14, r1);
        L78:
            return Unit.INSTANCE;
        L5:
            if (r12 != 2) goto L7;
        L75:
            s r15 = s.a;
            Context r16 = this.a.getContext();
            String r2 = this.a.getString(2131902949);
            r15.getClass();
            s.c(r16, r2);
            goto L78
        L7:
            if (r12 == 3) goto L75;
            if (r12 == 4) goto L75;
            if (r12 != 5) goto L74;
            FragmentActivity r17 = this.a.getActivity();
            if (r17 == null) goto L78;
            DoraUnbindFragment r3 = this.a;
            Intent r4 = new Intent("action.DEVICE_UNBIND");
            r4.setPackage(r17.getPackageName());
            DoraDevice r5 = (DoraDevice) r11.getSecond();
            String r6 = null;
            if (r5 == null) goto L17;
            String r7 = r5.mac;
        L19:
            if (TextUtils.isEmpty(r7) == true) goto L26;
            DoraDevice r8 = (DoraDevice) r11.getSecond();
            if (r8 == null) goto L24;
            String r18 = r8.mac;
            if (r18 == null) goto L24;
        L25:
            r4.putExtra("mac", r18);
        L24:
            r18 = "";
        L26:
            LocalBroadcastManager.getInstance(r17).sendBroadcast(r4);
            DoraDevice r110 = (DoraDevice) r11.getSecond();
            List r20 = kj4.a.g().getDoraBindList();
            if (r20 == null) goto L38;
            ?? r21 = new ArrayList();
            Iterator<T> r22 = r20.iterator();
        L30:
            if (r22.hasNext() == false) goto L39;
            T r23 = r22.next();
            String r24 = ((DoraDevice) r23).mac;
            if (r110 == null) goto L34;
            String r25 = r110.mac;
        L36:
            if ((!Intrinsics.areEqual(r24, r25)) == false) goto L30;
            r21.add(r23);
            goto L30
        L34:
            r25 = null;
        L39:
            Iterable r111 = (Iterable) r21;
            if ((r111 instanceof Collection) == true) goto L42;
        L44:
            Iterator<T> r112 = r111.iterator();
        L46:
            if (r112.hasNext() == false) goto L53;
            if (((DoraDevice) r112.next()).productId != ProductNameType.DORA_G.id) goto L50;
            boolean r26 = true;
        L51:
            if (r26 == false) goto L46;
        L55:
            if (com.larus.dora.impl.util.s.a() == false) goto L61;
            if (r0 == false) goto L61;
            i r27 = SmartRouter.buildRoute(r3.getContext(), "//dora_g_device_management");
            r27.c.addFlags(335544320);
            r27.d();
            FragmentActivity r28 = r3.getActivity();
            if (r28 == null) goto L78;
            r28.finish();
        L61:
            if (r21.isEmpty() == false) goto L70;
            i r113 = SmartRouter.buildRoute(r3.getContext(), "//flow/dora/bind_device");
            r113.c.addFlags(268435456);
            DoraDevice r30 = (DoraDevice) r11.getSecond();
            if (r30 == null) goto L65;
            Integer r31 = Boxing.boxInt(r30.productId);
        L66:
            r113.c.putExtra("product_id", String.valueOf(r31));
            DoraDevice r32 = (DoraDevice) r11.getSecond();
            if (r32 == null) goto L69;
            r6 = r32.model;
        L69:
            r113.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r6);
            r113.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "bind_device_v2");
            r113.d = 2130772401;
            r113.e = 2130772399;
            r113.d();
            goto L78
        L65:
            r31 = null;
            goto L66
        L70:
            FragmentActivity r33 = r3.getActivity();
            if (r33 == null) goto L78;
            r33.finish();
            goto L78
        L50:
            r26 = false;
        L53:
            r0 = false;
            goto L55
        L42:
            if (((Collection) r111).isEmpty() == false) goto L44;
        L38:
            r21 = CollectionsKt.emptyList();
            goto L39
        L17:
            r7 = null;
            goto L19
        L74:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public final String k() {
        return "dora_unbind";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraUnbindBinding r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public DoraUnbindFragment() {
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraUnbindViewModel.class), new DoraUnbindFragment$special$$inlined$activityViewModels$default$1(this), new DoraUnbindFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public static void W90(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    @Override // com.larus.dora.impl.device.settings.DoraUnbindBaseFragment
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LarusDoraUnbindBinding r10 = this.g;
        if (r10 == null) goto L7;
        NovaTitleBarEx r0 = r10.d;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, getString(2131902947), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new com.larus.dora.impl.device.settings.unbind.a(this), 14);
    L7:
        LarusDoraUnbindBinding r11 = this.g;
        if (r11 == null) goto L10;
        AppCompatTextView r12 = r11.c;
    L11:
        e1.d(r12, new com.larus.dora.impl.device.settings.unbind.b(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraUnbindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        return;
    L10:
        r12 = null;
        goto L11
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562307, r4, false);
        int r7 = 2131369962;
        View r8 = ViewBindings.findChildViewById(r6, 2131369962);
        if (r8 == null) goto L11;
        r7 = 2131377268;
        DoraTextView r0 = (DoraTextView) ViewBindings.findChildViewById(r6, 2131377268);
        if (r0 == null) goto L11;
        r7 = 2131388772;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r1 == null) goto L11;
        ConstraintLayout r9 = r6;
        this.g = new LarusDoraUnbindBinding(r9, r8, r0, r1);
        return r9;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
