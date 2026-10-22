package com.obric.memorydata.memory.ui.automemory.settings;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.android.material.card.MaterialCardView;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.databinding.AutoMemoryProActivityMemoryCustomRuleEditBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.utils.bb;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryCustomRuleEditActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "binding", "Lcom/obric/memorydata/memory/databinding/AutoMemoryProActivityMemoryCustomRuleEditBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryCustomRuleEditViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryCustomRuleEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "bindState", "state", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryCustomRuleEditUiState;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryCustomRuleEditActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    public static final String EXTRA_SESSION_ID = "session_id";
    private AutoMemoryProActivityMemoryCustomRuleEditBinding binding;
    private final NavigationBarScheme navigationBarScheme;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryCustomRuleEditActivity$Companion;", "", "<init>", "()V", "EXTRA_SESSION_ID", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", ObricMemoryConstants.KEY_SESSION_ID, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryCustomRuleEditActivity f10720a;

        public b(MemoryCustomRuleEditActivity r3) {
            this.f10720a = (MemoryCustomRuleEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryCustomRuleEditActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r2) {
            Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
            MemoryCustomRuleEditViewModel r0 = MemoryCustomRuleEditActivity.access$getViewModel(this.f10720a);
            if (r5 == null) goto L5;
            String r6 = r5.toString();
        L6:
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            r0.onTextChanged(r6);
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryCustomRuleEditActivity$onCreateChecked$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryCustomRuleEditActivity$onCreateChecked$5", f = "MemoryCustomRuleEditActivity.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryCustomRuleEditActivity this$0;

        AnonymousClass5(MemoryCustomRuleEditActivity r3, Continuation<? super AnonymousClass5> r4) {
            MemoryCustomRuleEditActivity r5 = (MemoryCustomRuleEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryCustomRuleEditActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass5) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<d> r7 = MemoryCustomRuleEditActivity.access$getViewModel(this.this$0).getState();
            final MemoryCustomRuleEditActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super d> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryCustomRuleEditActivity() {
        this.navigationBarScheme = NavigationBarScheme.B3;
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new MemoryCustomRuleEditActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(MemoryCustomRuleEditViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new MemoryCustomRuleEditActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new MemoryCustomRuleEditActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$bindState(MemoryCustomRuleEditActivity r2, d r3) {
        ((MemoryCustomRuleEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryCustomRuleEditActivity.class, "com.obric.memorydata.plugin")).bindState(r3);
    }

    public static final /* synthetic */ MemoryCustomRuleEditViewModel access$getViewModel(MemoryCustomRuleEditActivity r2) {
        return ((MemoryCustomRuleEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryCustomRuleEditActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    private final void bindState(d r7) {
        AutoMemoryProActivityMemoryCustomRuleEditBinding r0 = this.binding;
        AutoMemoryProActivityMemoryCustomRuleEditBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        Editable r1 = r0.descInput.getVInput().getText();
        if (r1 == null) goto L8;
        String r3 = r1.toString();
    L9:
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        if (Intrinsics.areEqual(r3, r7.a()) == true) goto L22;
        AutoMemoryProActivityMemoryCustomRuleEditBinding r4 = this.binding;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L16:
        r4.descInput.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryCustomRuleEditBinding r6 = this.binding;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L20:
        r2.descInput.getVInput().setSelection(r7.a().length());
        return;
    L19:
        r2 = r6;
        goto L20
    L22:
        return;
    L8:
        r3 = null;
        goto L9
    }

    private final MemoryCustomRuleEditViewModel getViewModel() {
        return (MemoryCustomRuleEditViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), MemoryCustomRuleEditViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$SPhLi21P45JSBvhveJuHhyvmO0A(MemoryCustomRuleEditActivity r0, View r1) {
        onCreateChecked$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$X2x8KAOETqM9c1e8z6m6GsgvPeM(MemoryCustomRuleEditActivity r0, View r1, WindowInsetsCompat r2) {
        return onCreateChecked$lambda$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$f2Knh9w5FoRX-bMGHJ_meGBDzgU, reason: not valid java name */
    public static /* synthetic */ boolean m819lambda$f2Knh9w5FoRXbMGHJ_meGBDzgU(OEditText r0, View r1, MotionEvent r2) {
        return onCreateChecked$lambda$6$lambda$4(r0, r1, r2);
    }

    private static final void onCreateChecked$lambda$1$lambda$0(MemoryCustomRuleEditActivity r1, View r2) {
        ((MemoryCustomRuleEditActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryCustomRuleEditActivity.class, "com.obric.memorydata.plugin")).finish();
    }

    private static final WindowInsetsCompat onCreateChecked$lambda$2(MemoryCustomRuleEditActivity r3, View r4, WindowInsetsCompat r5) {
        MemoryCustomRuleEditActivity r6 = (MemoryCustomRuleEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryCustomRuleEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "insets");
        Insets r7 = r5.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(r7, "getInsets(...)");
        int r0 = r5.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        AutoMemoryProActivityMemoryCustomRuleEditBinding r8 = r6.binding;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L5:
        LinearLayout r9 = r8.contentContainer;
        Intrinsics.checkNotNullExpressionValue(r9, "contentContainer");
        bb.c((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), Math.max(r7.bottom, r0) + MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
        return r5;
    }

    private static final boolean onCreateChecked$lambda$6$lambda$4(OEditText r3, View r4, MotionEvent r5) {
        if (r4.canScrollVertically(-1) == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        int r7 = r5.getActionMasked();
        if (r7 == 0) goto L20;
        if (r7 != 1) goto L13;
    L17:
        ViewParent r8 = r3.getParent();
        if (r8 == null) goto L23;
        r8.requestDisallowInterceptTouchEvent(false);
    L23:
        return false;
    L13:
        if (r7 == 2) goto L20;
        if (r7 == 3) goto L17;
    L20:
        ViewParent r9 = r3.getParent();
        if (r9 == null) goto L23;
        r9.requestDisallowInterceptTouchEvent(r6);
        goto L23
    L5:
        if (r4.canScrollVertically(1) == true) goto L8;
        r6 = false;
        goto L9
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r11) {
        setupInset();
        prepareSystemBar();
        AutoMemoryProActivityMemoryCustomRuleEditBinding r12 = AutoMemoryProActivityMemoryCustomRuleEditBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r12, "inflate(...)");
        this.binding = r12;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r12.getRoot(), View.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryCustomRuleEditBinding r13 = this.binding;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L8:
        View r14 = (View) ZeusTransformUtils.preCheckCast(r13.viewTitle, View.class, "com.obric.memorydata.plugin");
        AutoMemoryProActivityMemoryCustomRuleEditBinding r2 = this.binding;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L11:
        setupCutOffArea(r14, r2.cutOff);
        AutoMemoryProActivityMemoryCustomRuleEditBinding r15 = this.binding;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L14:
        OFloatingTitleBar.a(r15.viewTitle, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$MemoryCustomRuleEditActivity$SPhLi21P45JSBvhveJuHhyvmO0A(this), 2, null);
        AutoMemoryProActivityMemoryCustomRuleEditBinding r16 = this.binding;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L17:
        OFloatingTitleBar r17 = r16.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r17, "viewTitle");
        registerFloatingTitleBar(r17);
        AutoMemoryProActivityMemoryCustomRuleEditBinding r18 = this.binding;
        if (r18 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L20:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r18.getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryCustomRuleEditActivity$X2x8KAOETqM9c1e8z6m6GsgvPeM(this));
        AutoMemoryProActivityMemoryCustomRuleEditBinding r19 = this.binding;
        if (r19 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L23:
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(r19.getRoot(), View.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryCustomRuleEditBinding r110 = this.binding;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L26:
        OInputLayout r111 = r110.descInput;
        boolean r3 = true;
        r111.setType(1);
        r111.a(true);
        r111.c(false);
        r111.e(false);
        r111.g(true);
        r111.setLimitCount(2000);
        r111.setAutoChangeWithLimit(true);
        AutoMemoryProActivityMemoryCustomRuleEditBinding r112 = this.binding;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L29:
        final OEditText r113 = r112.descInput.getVInput();
        r113.setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        r113.setHorizontallyScrolling(false);
        r113.setTextAlignment(5);
        r113.setOnTouchListener(new $$Lambda$MemoryCustomRuleEditActivity$f2Knh9w5FoRXbMGHJ_meGBDzgU(r113));
        TextView r114 = (TextView) ZeusTransformUtils.preCheckCast(r113, TextView.class, "com.obric.memorydata.plugin");
        b r0 = new b(this);
        r114.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin"));
        TextWatcher r115 = (TextWatcher) ZeusTransformUtils.preCheckCast(r0, TextWatcher.class, "com.obric.memorydata.plugin");
        String r116 = getIntent().getStringExtra("session_id");
        if (r116 != null) goto L33;
        r116 = "";
    L33:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L36;
        r3 = false;
    L36:
        if (r3 == false) goto L39;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryCustomRuleEdit", "no sessionId, finish", null, 4, null);
        finish();
        return;
    L39:
        getViewModel().bind(r116);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
