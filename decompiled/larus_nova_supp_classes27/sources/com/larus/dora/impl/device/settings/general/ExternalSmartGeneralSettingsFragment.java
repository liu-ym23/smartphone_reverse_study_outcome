package com.larus.dora.impl.device.settings.general;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextDescView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraPageExternalSmartGeneralSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u000f\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u001bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/dora/impl/device/settings/general/ExternalSmartGeneralSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageExternalSmartGeneralSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "TAG", "", "hasUplpad", "", "device", "Lcom/bytedance/dora/device/DoraDevice;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDoraConnectStateChanged", "isConnected", "getCurrentPageName", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setPrefer", "()Lkotlin/Unit;", "showUnbindConfirmDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExternalSmartGeneralSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageExternalSmartGeneralSettingsBinding f;
    public final Lazy g;
    public boolean h;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ ExternalSmartGeneralSettingsFragment a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[IntentState.values().length];
                r0[IntentState.ACTION_SERVER_UNBIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[IntentState.ACTION_NO_DEVICE_CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[IntentState.ACTION_SERVER_UNBIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[IntentState.ACTION_SPP_DISCONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[IntentState.ACTION_UNBIND_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public b(ExternalSmartGeneralSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            IntentState r4 = (IntentState) ((Pair) r2).getFirst();
            int r5 = a.a[r4.ordinal()];
            if (r5 != 1) goto L5;
            t19.s r6 = t19.s.a;
            Application r7 = AppHost.a.getApplication();
            r6.getClass();
            t19.s.b(r7, 2131908080, false);
        L20:
            return Unit.INSTANCE;
        L5:
            if (r5 != 2) goto L7;
        L17:
            t19.s r8 = t19.s.a;
            Application r9 = AppHost.a.getApplication();
            r8.getClass();
            t19.s.b(r9, 2131904036, false);
            goto L20
        L7:
            if (r5 == 3) goto L17;
            if (r5 == 4) goto L17;
            if (r5 != 5) goto L16;
            FragmentActivity r10 = this.a.getActivity();
            if (r10 == null) goto L20;
            Intent r11 = new Intent("action.DEVICE_UNBIND");
            r11.setPackage(r10.getPackageName());
            LocalBroadcastManager.getInstance(r10).sendBroadcast(r11);
            r10.finish();
            goto L20
        L16:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.ExternalSmartGeneralSettingsFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.ExternalSmartGeneralSettingsFragment$onViewCreated$1", f = "ExternalSmartGeneralSettingsFragment.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ExternalSmartGeneralSettingsFragment this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.ExternalSmartGeneralSettingsFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.ExternalSmartGeneralSettingsFragment$onViewCreated$1$1", f = "ExternalSmartGeneralSettingsFragment.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ExternalSmartGeneralSettingsFragment this$0;

            /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.ExternalSmartGeneralSettingsFragment$onViewCreated$1$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ ExternalSmartGeneralSettingsFragment a;

                public a(ExternalSmartGeneralSettingsFragment r1) {
                    this.a = r1;
                }

                public final Object emit(Object r4, Continuation r5) {
                    w r6 = (w) r4;
                    if (Intrinsics.areEqual(r6, w.a.a) == true) goto L19;
                    if ((r6 instanceof w.b) == false) goto L17;
                    LarusDoraPageExternalSmartGeneralSettingsBinding r7 = this.a.f;
                    if (r7 == null) goto L19;
                    w.b r8 = (w.b) r6;
                    DoraDevice r0 = r8.b;
                    Intrinsics.checkNotNullParameter(r0, "<this>");
                    String r1 = r0.softVersion;
                    String r2 = "";
                    if (r1 != null) goto L11;
                    r1 = "";
                L11:
                    String r3 = "v".concat(r1);
                    r7.c.setDescText(r3);
                    ItemTextDescView r9 = r7.d;
                    String r10 = r8.b.sn;
                    if (r10 == null) goto L15;
                    r2 = r10;
                L15:
                    r9.setDescText(r2);
                    r7.b.setDescText(o59.a.d(r8.b));
                    goto L19
                L17:
                    throw new NoWhenBranchMatchedException();
                L19:
                    return Unit.INSTANCE;
                }
            }

            public C00401(ExternalSmartGeneralSettingsFragment r1, Continuation<? super C00401> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00401(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                ExternalSmartGeneralSettingsFragment r6 = this.this$0;
                int r2 = ExternalSmartGeneralSettingsFragment.i;
                i1<w> r7 = r6.W90().getGeneralSettingsStateFlow();
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r3, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(ExternalSmartGeneralSettingsFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            ExternalSmartGeneralSettingsFragment r7 = this.this$0;
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            C00401 r3 = new C00401(r7, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(r7, r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final String k() {
        return "general_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageExternalSmartGeneralSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    public final GeneralSettingsViewModel W90() {
        return (GeneralSettingsViewModel) this.g.getValue();
    }

    public ExternalSmartGeneralSettingsFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GeneralSettingsViewModel.class), new ExternalSmartGeneralSettingsFragment$special$$inlined$activityViewModels$default$1(this), new ExternalSmartGeneralSettingsFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onResume() {
        super.onResume();
        W90().loadGeneralSettings();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        if (r1 == false) goto L6;
        W90().loadGeneralSettings();
        return;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        LarusDoraPageExternalSmartGeneralSettingsBinding r11 = this.f;
        if (r11 == null) goto L5;
        NovaTitleBarEx r0 = r11.g;
        NovaTitleBarEx.Y5(r0, getString(2131902422), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new com.larus.dora.impl.device.settings.general.b(this), 14);
    L5:
        final LarusDoraPageExternalSmartGeneralSettingsBinding r12 = this.f;
        if (r12 == null) goto L8;
        e1.d(r12.d, new c(r12, this));
        e1.d(r12.e, new d(this));
        Unit r13 = Unit.INSTANCE;
    L8:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ExternalSmartGeneralSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r1, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131562264, r10, false);
        int r13 = 2131369485;
        if (ViewBindings.findChildViewById(r12, 2131369485) == null) goto L23;
        r13 = 2131369494;
        ItemTextDescView r2 = ViewBindings.findChildViewById(r12, 2131369494);
        if (r2 == null) goto L23;
        r13 = 2131369498;
        if (ViewBindings.findChildViewById(r12, 2131369498) == null) goto L23;
        r13 = 2131369500;
        ItemTextDescView r3 = ViewBindings.findChildViewById(r12, 2131369500);
        if (r3 == null) goto L23;
        r13 = 2131369506;
        ItemTextDescView r4 = ViewBindings.findChildViewById(r12, 2131369506);
        if (r4 == null) goto L23;
        r13 = 2131369508;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r12, 2131369508);
        if (r5 == null) goto L23;
        r13 = 2131369962;
        View r6 = ViewBindings.findChildViewById(r12, 2131369962);
        if (r6 == null) goto L23;
        r13 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r12, 2131385238)) == null) goto L23;
        r13 = 2131388772;
        NovaTitleBarEx r7 = ViewBindings.findChildViewById(r12, 2131388772);
        if (r7 == null) goto L23;
        ConstraintLayout r14 = r12;
        this.f = new LarusDoraPageExternalSmartGeneralSettingsBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
