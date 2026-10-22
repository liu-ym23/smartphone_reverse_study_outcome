package com.obric.memorydata.memory.ui.address.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.databinding.ActivityAddressSettingBinding;
import com.obric.memorydata.memory.permission.c;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.memory.ui.address.edit.AddressEditActivity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.memorydata.ui.g;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/setting/AddressSettingActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityAddressSettingBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/address/setting/AddressSettingViewModel;", "locationPermissionRequestHelper", "Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionRequestHelper;", "getLocationPermissionRequestHelper", "()Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionRequestHelper;", "locationPermissionRequestHelper$delegate", "Lkotlin/Lazy;", "autoLearnSwitchListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeChecked", "initView", "observeData", "renderState", "state", "Lcom/obric/memorydata/memory/ui/address/setting/AddressSettingUiState;", "renderAddressItem", "item", "Lcom/obric/memorydata/ui/custom/DeviceAdaptiveCardListItem;", "Lcom/obric/memorydata/memory/ui/address/setting/AddressItemUiState;", "autoLearnEnabled", "", "setAutoLearnSwitchChecked", "checked", "handleHomeAddressClick", "handleCompanyAddressClick", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AddressSettingActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private static final String TAG = "AddressSettingActivity";
    private final CompoundButton.OnCheckedChangeListener autoLearnSwitchListener;
    private ActivityAddressSettingBinding binding;
    private final Lazy locationPermissionRequestHelper$delegate;
    private AddressSettingViewModel viewModel;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/setting/AddressSettingActivity$Companion;", "", "<init>", "()V", "TAG", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            ZeusTransformUtils.startActivity(r2, new Intent(r2, AddressSettingActivity.class), "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.setting.AddressSettingActivity$initView$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object r8) {
            super(0, r8, AddressSettingActivity.class, "onBackPressed", "onBackPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((AddressSettingActivity) ZeusTransformUtils.preCheckCast(this.receiver, AddressSettingActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.setting.AddressSettingActivity$observeData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.setting.AddressSettingActivity$observeData$1", f = "AddressSettingActivity.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    static final class C11171 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddressSettingActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.setting.AddressSettingActivity$observeData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/memorydata/memory/ui/address/setting/AddressSettingUiState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.setting.AddressSettingActivity$observeData$1$1", f = "AddressSettingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05231 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AddressSettingActivity this$0;

            C05231(AddressSettingActivity r3, Continuation<? super C05231> r4) {
                AddressSettingActivity r5 = (AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressSettingActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C05231 r0 = new C05231(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(b r3, Continuation<? super Unit> r4) {
                return ((C05231) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05231.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(b r3, Continuation<? super Unit> r4) {
                return invoke2((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                b r5 = (b) ZeusTransformUtils.preCheckCast(this.L$0, b.class, "com.obric.memorydata.plugin");
                RunLog.INSTANCE.debug(AddressSettingActivity.TAG, "autoLearnEnabled change to " + r5.b());
                AddressSettingActivity.access$renderState(this.this$0, r5);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11171(AddressSettingActivity r3, Continuation<? super C11171> r4) {
            AddressSettingActivity r5 = (AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressSettingActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11171(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11171) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11171.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            AddressSettingViewModel r8 = AddressSettingActivity.access$getViewModel$p(this.this$0);
            if (r8 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r8 = null;
        L11:
            i r9 = (i) ZeusTransformUtils.preCheckCast(r8.getUiState(), i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05231(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (k.a(r9, r2, r3) != r0) goto L15;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AddressSettingActivity() {
        this.locationPermissionRequestHelper$delegate = LazyKt.lazy(new $$Lambda$AddressSettingActivity$WzUgz43SwN_epcFn1Ci_ZISZjk(this));
        this.autoLearnSwitchListener = new $$Lambda$AddressSettingActivity$UPzM44bHOoWLMYH8C2XC30g9q6k(this);
    }

    public static final /* synthetic */ AddressSettingViewModel access$getViewModel$p(AddressSettingActivity r2) {
        return ((AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressSettingActivity.class, "com.obric.memorydata.plugin")).viewModel;
    }

    public static final /* synthetic */ void access$renderState(AddressSettingActivity r2, b r3) {
        ((AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressSettingActivity.class, "com.obric.memorydata.plugin")).renderState(r3);
    }

    private static final void autoLearnSwitchListener$lambda$3(AddressSettingActivity r2, CompoundButton r3, boolean r4) {
        AddressSettingActivity r5 = (AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressSettingActivity.class, "com.obric.memorydata.plugin");
        AddressSettingViewModel r6 = null;
        if (r4 == true) goto L11;
        AddressSettingViewModel r7 = r5.viewModel;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r6.updateAutoLearnState(false);
        return;
    L7:
        r6 = r7;
        goto L8
    L11:
        if (com.obric.memorydata.memory.permission.b.f10340a.a() == false) goto L17;
        AddressSettingViewModel r8 = r5.viewModel;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        r6.updateAutoLearnState(true);
        return;
    L15:
        r6 = r8;
        goto L16
    L17:
        r5.setAutoLearnSwitchChecked(false);
        r5.getLocationPermissionRequestHelper().b();
    }

    private final c getLocationPermissionRequestHelper() {
        return (c) ZeusTransformUtils.preCheckCast(this.locationPermissionRequestHelper$delegate.getValue(), c.class, "com.obric.memorydata.plugin");
    }

    private final void handleCompanyAddressClick() {
        AddressSettingViewModel r0 = this.viewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.getUiState().c(), b.class, "com.obric.memorydata.plugin");
        if (r1.a() == true) goto L8;
        return;
    L8:
        if (r1.d().b() == false) goto L13;
        AddressEditActivity.Companion.startActivity((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "公司");
        return;
    }

    private final void handleHomeAddressClick() {
        AddressSettingViewModel r0 = this.viewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.getUiState().c(), b.class, "com.obric.memorydata.plugin");
        if (r1.a() == true) goto L8;
        return;
    L8:
        if (r1.c().b() == false) goto L13;
        AddressEditActivity.Companion.startActivity((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), "家");
        return;
    }

    private final void initView() {
        Integer r0 = com.obric.memorydata.ui.custom.a.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarMemorySettingsBottomGap, "attr", "OFloatingTitleBarMemorySettingsBottomGap"));
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        ActivityAddressSettingBinding r2 = this.binding;
        ActivityAddressSettingBinding r3 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L9:
        OFloatingTitleBar r4 = r2.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r4, "viewTitle");
        ActivityAddressSettingBinding r6 = this.binding;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L12:
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.addressSettingsContainer, View.class, "com.obric.memorydata.plugin");
        ActivityAddressSettingBinding r8 = this.binding;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L15:
        setupTitleBarBackAction(r4, r7, r1, r8.cutOff);
        ActivityAddressSettingBinding r5 = this.binding;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L18:
        OFloatingTitleBar r9 = r5.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r9, "viewTitle");
        com.obric.memorydata.ui.custom.a.a(r9, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function0.class, "com.obric.memorydata.plugin"));
        ActivityAddressSettingBinding r10 = this.binding;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L21:
        OFloatingTitleBar r11 = r10.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r11, "viewTitle");
        registerFloatingTitleBar(r11);
        ActivityAddressSettingBinding r12 = this.binding;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L24:
        OSwitch r13 = r12.autoLearnSwitch.getEndSwitch();
        if (r13 == null) goto L27;
        r13.setEnabled(false);
        r13.setOnCheckedChangeListener(this.autoLearnSwitchListener);
    L27:
        ActivityAddressSettingBinding r14 = this.binding;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L30:
        r14.homeAddressItem.setOnContentClickListener(new $$Lambda$AddressSettingActivity$atKk7zLdZ42bXyU7zRYSpgejQT4(this));
        ActivityAddressSettingBinding r15 = this.binding;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L34:
        r3.companyAddressItem.setOnContentClickListener(new $$Lambda$AddressSettingActivity$KDJ_8jD_1lcXhQtYEWyteW6cY(this));
        return;
    L33:
        r3 = r15;
        goto L34
    L5:
        r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        goto L6
    }

    private static final void initView$lambda$5(AddressSettingActivity r1, View r2) {
        ((AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r1, AddressSettingActivity.class, "com.obric.memorydata.plugin")).handleHomeAddressClick();
    }

    private static final void initView$lambda$6(AddressSettingActivity r1, View r2) {
        ((AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r1, AddressSettingActivity.class, "com.obric.memorydata.plugin")).handleCompanyAddressClick();
    }

    /* JADX INFO: renamed from: lambda$EIU601p3bFy00Z8lv-XmJwOfe8A, reason: not valid java name */
    public static /* synthetic */ Unit m775lambda$EIU601p3bFy00Z8lvXmJwOfe8A(AddressSettingActivity r0) {
        return locationPermissionRequestHelper_delegate$lambda$2$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$KDJ_8-jD_1lc-XhQtYEWyteW6cY, reason: not valid java name */
    public static /* synthetic */ void m776lambda$KDJ_8jD_1lcXhQtYEWyteW6cY(AddressSettingActivity r0, View r1) {
        initView$lambda$6(r0, r1);
    }

    public static /* synthetic */ void lambda$UPzM44bHOoWLMYH8C2XC30g9q6k(AddressSettingActivity r0, CompoundButton r1, boolean r2) {
        autoLearnSwitchListener$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$V0ciduJJ5Y2_Eq_UHSifDO8J1HY(AddressSettingActivity r0) {
        return locationPermissionRequestHelper_delegate$lambda$2$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$WzUg-z43SwN_epcFn1Ci_ZISZjk, reason: not valid java name */
    public static /* synthetic */ c m777lambda$WzUgz43SwN_epcFn1Ci_ZISZjk(AddressSettingActivity r0) {
        return locationPermissionRequestHelper_delegate$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$atKk7zLdZ42bXyU7zRYSpgejQT4(AddressSettingActivity r0, View r1) {
        initView$lambda$5(r0, r1);
    }

    private static final c locationPermissionRequestHelper_delegate$lambda$2(AddressSettingActivity r4) {
        final AddressSettingActivity r5 = (AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r4, AddressSettingActivity.class, "com.obric.memorydata.plugin");
        return new c((FragmentActivity) ZeusTransformUtils.preCheckCast(r5, FragmentActivity.class, "com.obric.memorydata.plugin"), new $$Lambda$AddressSettingActivity$EIU601p3bFy00Z8lvXmJwOfe8A(r5), new $$Lambda$AddressSettingActivity$V0ciduJJ5Y2_Eq_UHSifDO8J1HY(r5));
    }

    private static final Unit locationPermissionRequestHelper_delegate$lambda$2$lambda$0(AddressSettingActivity r2) {
        AddressSettingViewModel r3 = ((AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressSettingActivity.class, "com.obric.memorydata.plugin")).viewModel;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        r3.updateAutoLearnState(true);
        return Unit.INSTANCE;
    }

    private static final Unit locationPermissionRequestHelper_delegate$lambda$2$lambda$1(AddressSettingActivity r2) {
        ((AddressSettingActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressSettingActivity.class, "com.obric.memorydata.plugin")).setAutoLearnSwitchChecked(false);
        return Unit.INSTANCE;
    }

    private final void observeData() {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11171(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void renderAddressItem(DeviceAdaptiveCardListItem r8, com.obric.memorydata.memory.ui.address.setting.a r9, boolean r10) {
        OCardListItem r0 = (OCardListItem) ZeusTransformUtils.preCheckCast(r8, OCardListItem.class, "com.obric.memorydata.plugin");
        String r2 = r9.a();
        if (r2 != null) goto L5;
        r2 = getString(ZeusTransformUtils.mapRes(R.string.address_not_set_text, TypedValues.Custom.S_STRING, "address_not_set_text"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
    L5:
        OCardListItem.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r10 == false) goto L8;
        String r7 = getString(ZeusTransformUtils.mapRes(R.string.auto_learn_address_text, TypedValues.Custom.S_STRING, "auto_learn_address_text"));
    L9:
        r8.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"));
        r8.d(r10);
        r8.f(r9.b());
        return;
    L8:
        r7 = "";
        goto L9
    }

    private final void renderState(b r6) {
        if (r6.a() == true) goto L5;
        return;
    L5:
        ActivityAddressSettingBinding r0 = this.binding;
        ActivityAddressSettingBinding r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        OSwitch r2 = r0.autoLearnSwitch.getEndSwitch();
        if (r2 == null) goto L11;
        r2.setEnabled(true);
    L11:
        setAutoLearnSwitchChecked(r6.b());
        ActivityAddressSettingBinding r3 = this.binding;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L14:
        DeviceAdaptiveCardListItem r4 = r3.homeAddressItem;
        Intrinsics.checkNotNullExpressionValue(r4, "homeAddressItem");
        renderAddressItem(r4, r6.c(), r6.b());
        ActivityAddressSettingBinding r5 = this.binding;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        DeviceAdaptiveCardListItem r7 = r1.companyAddressItem;
        Intrinsics.checkNotNullExpressionValue(r7, "companyAddressItem");
        renderAddressItem(r7, r6.d(), r6.b());
        return;
    L17:
        r1 = r5;
        goto L18
    }

    private final void setAutoLearnSwitchChecked(boolean r3) {
        ActivityAddressSettingBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OSwitch r1 = r0.autoLearnSwitch.getEndSwitch();
        if (r1 == null) goto L9;
        r1.setOnCheckedChangeListener(null);
        r1.setChecked(r3);
        r1.setOnCheckedChangeListener(this.autoLearnSwitchListener);
        return;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r5) {
        prepareSystemBar();
        ActivityAddressSettingBinding r6 = ActivityAddressSettingBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityAddressSettingBinding r7 = this.binding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        ONestedScrollView r8 = r7.addressSettingsContainer;
        Intrinsics.checkNotNullExpressionValue(r8, "addressSettingsContainer");
        g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        this.viewModel = (AddressSettingViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(this, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(AddressSettingViewModel.class), AddressSettingViewModel.class, "com.obric.memorydata.plugin");
        initView();
        observeData();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        getLocationPermissionRequestHelper().a();
        com.obric.memorydata.memory.permission.b.f10340a.b();
        AddressSettingViewModel r1 = this.viewModel;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        r1.refreshState();
    }
}
