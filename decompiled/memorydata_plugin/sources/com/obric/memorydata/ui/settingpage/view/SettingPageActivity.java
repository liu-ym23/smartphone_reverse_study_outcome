package com.obric.memorydata.ui.settingpage.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.databinding.ActivitySettingPageBinding;
import com.obric.memorydata.ui.settingpage.viewmodel.SettingPageViewModel;
import com.obric.memorydata.ui.settingpage.viewmodel.a;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/ui/settingpage/view/SettingPageActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/databinding/ActivitySettingPageBinding;", "viewModel", "Lcom/obric/memorydata/ui/settingpage/viewmodel/SettingPageViewModel;", "textViewDisableColor", "", "textViewEnableColor", "backgroundColor", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "changeOSwitchState", "oSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", EventBody.KEY_VALUE, "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SettingPageActivity extends FragmentActivity {
    private final int backgroundColor;
    private ActivitySettingPageBinding binding;
    private final int textViewDisableColor;
    private final int textViewEnableColor;
    private SettingPageViewModel viewModel;

    /* JADX INFO: renamed from: com.obric.memorydata.ui.settingpage.view.SettingPageActivity$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.ui.settingpage.view.SettingPageActivity$onCreate$1", f = "SettingPageActivity.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SettingPageActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.ui.settingpage.view.SettingPageActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.ui.settingpage.view.SettingPageActivity$onCreate$1$1", f = "SettingPageActivity.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
        static final class C07121 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SettingPageActivity this$0;

            C07121(SettingPageActivity r3, Continuation<? super C07121> r4) {
                SettingPageActivity r5 = (SettingPageActivity) ZeusTransformUtils.wrapperContextForParams(r3, SettingPageActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C07121(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C07121) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C07121.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r6);
            L15:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                SettingPageViewModel r7 = SettingPageActivity.access$getViewModel$p(this.this$0);
                if (r7 != null) goto L11;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                r7 = null;
            L11:
                ar<a> r8 = r7.getUiState();
                final SettingPageActivity r3 = this.this$0;
                j<? super a> r2 = (j) ZeusTransformUtils.preCheckCast(new C07131(r3), j.class, "com.obric.memorydata.plugin");
                Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                if (r8.collect(r2, r4) != r0) goto L15;
                return r0;
            }
        }

        AnonymousClass1(SettingPageActivity r3, Continuation<? super AnonymousClass1> r4) {
            SettingPageActivity r5 = (SettingPageActivity) ZeusTransformUtils.wrapperContextForParams(r3, SettingPageActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            LifecycleOwner r9 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(this.this$0, LifecycleOwner.class, "com.obric.memorydata.plugin");
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new C07121(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r9, r2, r4, r3) != r0) goto L12;
            return r0;
        }
    }

    public SettingPageActivity() {
        this.textViewDisableColor = Color.rgb(115, 115, 115);
        this.textViewEnableColor = Color.rgb(0, 0, 0);
        this.backgroundColor = Color.rgb(242, 240, 244);
    }

    public static final /* synthetic */ void access$changeOSwitchState(SettingPageActivity r2, OSwitch r3, AppCompatTextView r4, boolean r5) {
        ((SettingPageActivity) ZeusTransformUtils.wrapperContextForParams(r2, SettingPageActivity.class, "com.obric.memorydata.plugin")).changeOSwitchState(r3, r4, r5);
    }

    public static final /* synthetic */ ActivitySettingPageBinding access$getBinding$p(SettingPageActivity r2) {
        return ((SettingPageActivity) ZeusTransformUtils.wrapperContextForParams(r2, SettingPageActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ SettingPageViewModel access$getViewModel$p(SettingPageActivity r2) {
        return ((SettingPageActivity) ZeusTransformUtils.wrapperContextForParams(r2, SettingPageActivity.class, "com.obric.memorydata.plugin")).viewModel;
    }

    private final void changeOSwitchState(OSwitch r2, AppCompatTextView r3, boolean r4) {
        if (r2.isChecked() == r4) goto L5;
        r2.setChecked(r4);
    L5:
        if (r4 == false) goto L9;
        int r5 = r3.getCurrentTextColor();
        int r0 = this.textViewEnableColor;
        if (r5 == r0) goto L9;
        r3.setTextColor(r0);
        return;
    L9:
        if (r4 == true) goto L15;
        int r6 = r3.getCurrentTextColor();
        int r1 = this.textViewDisableColor;
        if (r6 == r1) goto L16;
        r3.setTextColor(r1);
        return;
    L16:
        return;
    }

    public static /* synthetic */ void lambda$4wVOJ4tW8A__U_qfwo_VF7mAgjA(SettingPageActivity r0, CompoundButton r1, boolean r2) {
        onCreate$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$Qe1qgDQlFPtldvsJiuIzLJW1lZc(SettingPageActivity r0, CompoundButton r1, boolean r2) {
        onCreate$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$uPJvvLTSKNSw5olCgNBWydv9UT8(SettingPageActivity r0, View r1) {
        onCreate$lambda$0(r0, r1);
    }

    private static final void onCreate$lambda$0(SettingPageActivity r1, View r2) {
        ((SettingPageActivity) ZeusTransformUtils.wrapperContextForParams(r1, SettingPageActivity.class, "com.obric.memorydata.plugin")).getOnBackPressedDispatcher().onBackPressed();
    }

    private static final void onCreate$lambda$1(SettingPageActivity r1, CompoundButton r2, boolean r3) {
        SettingPageViewModel r4 = ((SettingPageActivity) ZeusTransformUtils.wrapperContextForParams(r1, SettingPageActivity.class, "com.obric.memorydata.plugin")).viewModel;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L5:
        r4.notifyInstantEntityIndexCheckedChange(r3);
    }

    private static final void onCreate$lambda$2(SettingPageActivity r1, CompoundButton r2, boolean r3) {
        SettingPageViewModel r4 = ((SettingPageActivity) ZeusTransformUtils.wrapperContextForParams(r1, SettingPageActivity.class, "com.obric.memorydata.plugin")).viewModel;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L5:
        r4.notifyIsOnAvoidDataImportSwitchOn(r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r11) {
        super.onCreate(r11);
        ActivitySettingPageBinding r12 = ActivitySettingPageBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r12, "inflate(...)");
        this.binding = r12;
        ActivitySettingPageBinding r1 = null;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r12.getRoot(), View.class, "com.obric.memorydata.plugin"));
        this.viewModel = (SettingPageViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(this, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(SettingPageViewModel.class), SettingPageViewModel.class, "com.obric.memorydata.plugin");
        i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        ActivitySettingPageBinding r13 = this.binding;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L8:
        r13.arrowBackImageHotArea.setOnClickListener(new $$Lambda$SettingPageActivity$uPJvvLTSKNSw5olCgNBWydv9UT8(this));
        ActivitySettingPageBinding r14 = this.binding;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L11:
        r14.switchInstantEntityIndex.setOnCheckedChangeListener(new $$Lambda$SettingPageActivity$4wVOJ4tW8A__U_qfwo_VF7mAgjA(this));
        ActivitySettingPageBinding r15 = this.binding;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L14:
        r15.switchOnAvoidDataImport.setOnCheckedChangeListener(new $$Lambda$SettingPageActivity$Qe1qgDQlFPtldvsJiuIzLJW1lZc(this));
        ActivitySettingPageBinding r16 = this.binding;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        r1.getRoot().setBackgroundColor(this.backgroundColor);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(this.backgroundColor);
        getWindow().setNavigationBarContrastEnforced(true);
        return;
    L17:
        r1 = r16;
        goto L18
    }
}
