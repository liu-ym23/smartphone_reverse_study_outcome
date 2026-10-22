package com.larus.dora.impl.device.settings.camera;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraPageCameraSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
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
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010&\u001a\u00020\u001fH\u0002J\u001a\u0010'\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001f2\b\b\u0002\u0010&\u001a\u00020\u001fH\u0002J*\u0010(\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/dora/impl/device/settings/camera/CameraSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageCameraSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/camera/CameraSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/camera/CameraSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "TAG", "", "mTakeImageSwitchCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mBurstTakeImageSwitchCheckedChangeListener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDoraConnectStateChanged", "isConnected", "", "getCurrentPageName", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "resetTakeImageSwitchState", "originState", "isError", "resetBurstTakeImageSwitchState", "resetSwitchState", "switchView", "Lcom/larus/bmhome/view/item/ItemTextToggle;", "listener", "setBurstTakeImageGroupVisible", "visible", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int k = 0;
    public LarusDoraPageCameraSettingsBinding f;
    public final Lazy g;
    public final String h;
    public final b i;
    public final c j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.camera.CameraSettingsFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.camera.CameraSettingsFragment$onViewCreated$1", f = "CameraSettingsFragment.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CameraSettingsFragment this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.camera.CameraSettingsFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.camera.CameraSettingsFragment$onViewCreated$1$1", f = "CameraSettingsFragment.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ CameraSettingsFragment this$0;

            /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.camera.CameraSettingsFragment$onViewCreated$1$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ CameraSettingsFragment a;

                public a(CameraSettingsFragment r1) {
                    this.a = r1;
                }

                public final Object emit(Object r7, Continuation r8) {
                    f r9 = (f) r7;
                    if (Intrinsics.areEqual(r9, f.a.a) == true) goto L16;
                    if ((r9 instanceof f.b) == false) goto L16;
                    CameraSettingsFragment r10 = this.a;
                    LarusDoraPageCameraSettingsBinding r0 = r10.f;
                    if (r0 == null) goto L16;
                    ItemTextToggle r1 = r0.f;
                    f.b r11 = (f.b) r9;
                    if (r1.getToggleView().isChecked() == r11.a) goto L11;
                    r1.getToggleView().setOnCheckedChangeListener(null);
                    r1.getToggleView().setChecked(r11.a);
                L11:
                    g49.d.d(r10.h, "doraTakeImageSwitch: " + r11.a);
                    r1.getToggleView().setOnCheckedChangeListener(r10.i);
                    ItemTextToggle r2 = r0.d;
                    if (r2.getToggleView().isChecked() == r11.b) goto L14;
                    r2.getToggleView().setOnCheckedChangeListener(null);
                    r2.getToggleView().setChecked(r11.b);
                L14:
                    g49.d.d(r10.h, "doraBurstTakeImageSwitch: " + r11.b);
                    r2.getToggleView().setOnCheckedChangeListener(r10.j);
                    r10.Y90(r0.f.getToggleView().isChecked());
                L16:
                    return Unit.INSTANCE;
                }
            }

            public C00391(CameraSettingsFragment r1, Continuation<? super C00391> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00391(this.this$0, r3);
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
                CameraSettingsFragment r6 = this.this$0;
                int r2 = CameraSettingsFragment.k;
                i1<f> r7 = r6.W90().getCameraSettingsStateFlow();
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r3, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(CameraSettingsFragment r1, Continuation<? super AnonymousClass1> r2) {
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
            CameraSettingsFragment r7 = this.this$0;
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            C00391 r3 = new C00391(r7, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(r7, r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final String k() {
        return "photo_settings";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageCameraSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final CameraSettingsViewModel W90() {
        return (CameraSettingsViewModel) this.g.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.device.settings.camera.b] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.dora.impl.device.settings.camera.c] */
    public CameraSettingsFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CameraSettingsViewModel.class), new CameraSettingsFragment$special$$inlined$activityViewModels$default$1(this), new CameraSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.h = "CameraSettingsFragment";
        this.i = new b(this);
        this.j = new c(this);
    }

    public final void onResume() {
        super.onResume();
        W90().loadCameraSettings();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        if (r1 == false) goto L6;
        W90().loadCameraSettings();
        return;
    }

    public final void Y90(boolean r6) {
        LarusDoraPageCameraSettingsBinding r0 = this.f;
        if (r0 == null) goto L14;
        ItemGroup r1 = r0.c;
        int r2 = 0;
        if (r6 == false) goto L7;
        int r4 = 0;
    L8:
        r1.setVisibility(r4);
        AppCompatTextView r3 = r0.b;
        if (r6 == true) goto L12;
        r2 = 8;
    L12:
        r3.setVisibility(r2);
        return;
    L7:
        r4 = 8;
        goto L8
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        LarusDoraPageCameraSettingsBinding r16 = this.f;
        if (r16 == null) goto L5;
        NovaTitleBarEx r0 = r16.g;
        NovaTitleBarEx.Y5(r0, getString(2131902378), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new com.larus.dora.impl.device.settings.camera.a(this), 14);
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131562257, r10, false);
        int r13 = 2131369431;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r12, 2131369431);
        if (r2 == null) goto L31;
        r13 = 2131369432;
        ItemGroup r3 = ViewBindings.findChildViewById(r12, 2131369432);
        if (r3 == null) goto L31;
        r13 = 2131369433;
        ItemTextToggle r4 = ViewBindings.findChildViewById(r12, 2131369433);
        if (r4 == null) goto L31;
        r13 = 2131369962;
        View r5 = ViewBindings.findChildViewById(r12, 2131369962);
        if (r5 == null) goto L31;
        r13 = 2131370024;
        ItemTextToggle r6 = ViewBindings.findChildViewById(r12, 2131370024);
        if (r6 == null) goto L31;
        r13 = 2131370025;
        if (ViewBindings.findChildViewById(r12, 2131370025) == null) goto L31;
        r13 = 2131370026;
        if (ViewBindings.findChildViewById(r12, 2131370026) == null) goto L31;
        r13 = 2131370027;
        if (ViewBindings.findChildViewById(r12, 2131370027) == null) goto L31;
        r13 = 2131370028;
        if (ViewBindings.findChildViewById(r12, 2131370028) == null) goto L31;
        r13 = 2131370029;
        if (ViewBindings.findChildViewById(r12, 2131370029) == null) goto L31;
        r13 = 2131370030;
        if (ViewBindings.findChildViewById(r12, 2131370030) == null) goto L31;
        r13 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r12, 2131385238)) == null) goto L31;
        r13 = 2131388772;
        NovaTitleBarEx r7 = ViewBindings.findChildViewById(r12, 2131388772);
        if (r7 == null) goto L31;
        ConstraintLayout r14 = r12;
        this.f = new LarusDoraPageCameraSettingsBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }

    public static void X90(boolean r2, ItemTextToggle r3, CompoundButton.OnCheckedChangeListener r4, boolean r5) {
        if (r3.getToggleView().isChecked() != r2) goto L5;
        return;
    L5:
        r3.getToggleView().setOnCheckedChangeListener(null);
        r3.getToggleView().setChecked(r2);
        r3.getToggleView().setOnCheckedChangeListener(r4);
        if (r5 == false) goto L9;
        s r6 = s.a;
        Application r7 = AppHost.a.getApplication();
        r6.getClass();
        s.b(r7, 2131902382, false);
        return;
    }
}
