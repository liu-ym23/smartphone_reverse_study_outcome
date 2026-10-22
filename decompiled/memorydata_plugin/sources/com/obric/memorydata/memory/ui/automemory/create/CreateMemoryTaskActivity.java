package com.obric.memorydata.memory.ui.automemory.create;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/CreateMemoryTaskActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "viewModel", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getCurrentFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "handleExitRequest", "showExitConfirmDialog", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CreateMemoryTaskActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private final NavigationBarScheme navigationBarScheme;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/CreateMemoryTaskActivity$Companion;", "", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            ZeusTransformUtils.startActivity(r2, new Intent(r2, CreateMemoryTaskActivity.class), "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements i<AutoMemoryCreateCollectionStep> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f10657a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.CreateMemoryTaskActivity$b$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f10658a;

            public AnonymousClass1(j r3) {
                this.f10658a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, CreateMemoryTaskActivity$onCreateChecked$$inlined$map$1$2$1.class) == false) goto L7;
                CreateMemoryTaskActivity$onCreateChecked$$inlined$map$1$2$1 r0 = (CreateMemoryTaskActivity$onCreateChecked$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r8, CreateMemoryTaskActivity$onCreateChecked$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                j r5 = this.f10658a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                AutoMemoryCreateCollectionStep r11 = ((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).g();
                r0.label = 1;
                if (r5.emit(r11, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new CreateMemoryTaskActivity$onCreateChecked$$inlined$map$1$2$1(this, r8);
                goto L8
            }
        }

        public b(i r3) {
            this.f10657a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super AutoMemoryCreateCollectionStep> r3, Continuation r4) {
            j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10657a.collect((j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.CreateMemoryTaskActivity$onCreateChecked$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "step", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionStep;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.CreateMemoryTaskActivity$onCreateChecked$3", f = "CreateMemoryTaskActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<AutoMemoryCreateCollectionStep, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreateMemoryTaskActivity this$0;

        AnonymousClass3(CreateMemoryTaskActivity r3, Continuation<? super AnonymousClass3> r4) {
            CreateMemoryTaskActivity r5 = (CreateMemoryTaskActivity) ZeusTransformUtils.wrapperContextForParams(r3, CreateMemoryTaskActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(AutoMemoryCreateCollectionStep r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(AutoMemoryCreateCollectionStep r3, Continuation<? super Unit> r4) {
            return invoke2((AutoMemoryCreateCollectionStep) ZeusTransformUtils.preCheckCast(r3, AutoMemoryCreateCollectionStep.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            if (((AutoMemoryCreateCollectionStep) ZeusTransformUtils.preCheckCast(this.L$0, AutoMemoryCreateCollectionStep.class, "com.obric.memorydata.plugin")) != AutoMemoryCreateCollectionStep.CLOSE) goto L8;
            this.this$0.finish();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.CreateMemoryTaskActivity$onCreateChecked$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.CreateMemoryTaskActivity$onCreateChecked$4", f = "CreateMemoryTaskActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreateMemoryTaskActivity this$0;

        AnonymousClass4(CreateMemoryTaskActivity r3, Continuation<? super AnonymousClass4> r4) {
            CreateMemoryTaskActivity r5 = (CreateMemoryTaskActivity) ZeusTransformUtils.wrapperContextForParams(r3, CreateMemoryTaskActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Unit r3, Continuation<? super Unit> r4) {
            return invoke2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Unit r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CreateMemoryTaskActivity.access$handleExitRequest(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public CreateMemoryTaskActivity() {
        this.navigationBarScheme = NavigationBarScheme.A;
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new CreateMemoryTaskActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(AutoMemoryCreateCollectionViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new CreateMemoryTaskActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new CreateMemoryTaskActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ AutoMemoryCreateCollectionViewModel access$getViewModel(CreateMemoryTaskActivity r2) {
        return ((CreateMemoryTaskActivity) ZeusTransformUtils.wrapperContextForParams(r2, CreateMemoryTaskActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$handleExitRequest(CreateMemoryTaskActivity r2) {
        ((CreateMemoryTaskActivity) ZeusTransformUtils.wrapperContextForParams(r2, CreateMemoryTaskActivity.class, "com.obric.memorydata.plugin")).handleExitRequest();
    }

    private final AutoMemoryCreateCollectionViewModel getViewModel() {
        return (AutoMemoryCreateCollectionViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), AutoMemoryCreateCollectionViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void handleExitRequest() {
        if (getViewModel().hasUnsavedContent() == true) goto L6;
        getViewModel().closePage();
        return;
    L6:
        showExitConfirmDialog();
    }

    /* JADX INFO: renamed from: lambda$OCJ85r0hZQEQuqQzfECGF-7L-bs, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m798lambda$OCJ85r0hZQEQuqQzfECGF7Lbs(CreateMemoryTaskActivity r0, View r1, WindowInsetsCompat r2) {
        return onCreateChecked$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$aSLCF_ws9XtsPW3VfwkdMjPn4t8(CreateMemoryTaskActivity r0, DialogInterface r1, int r2) {
        showExitConfirmDialog$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$jPpqineInEKg9g20cfHghFf8BMM(DialogInterface r0, int r1) {
        showExitConfirmDialog$lambda$2(r0, r1);
    }

    private static final WindowInsetsCompat onCreateChecked$lambda$0(CreateMemoryTaskActivity r4, View r5, WindowInsetsCompat r6) {
        CreateMemoryTaskActivity r7 = (CreateMemoryTaskActivity) ZeusTransformUtils.wrapperContextForParams(r4, CreateMemoryTaskActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r6, "insets");
        Insets r0 = r6.getInsets(WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(r0, "getInsets(...)");
        Insets r2 = r6.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(r2, "getInsets(...)");
        r5.setPadding(0, r2.top, 0, Math.max(r2.bottom, r0.bottom));
        r7.getViewModel().updateImeBottom(r0.bottom);
        return r6;
    }

    private final void showExitConfirmDialog() {
        Drawable r7 = null;
        com.obric.oui.dialog.alert.c r8 = com.obric.oui.dialog.alert.c.a(new com.obric.oui.dialog.alert.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_create_memory_task_exit_title, TypedValues.Custom.S_STRING, "memory_create_memory_task_exit_title")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_create_memory_task_exit_message, TypedValues.Custom.S_STRING, "memory_create_memory_task_exit_message")), CharSequence.class, "com.obric.memorydata.plugin")).a(true);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.memory_create_memory_task_exit_cancel, TypedValues.Custom.S_STRING, "memory_create_memory_task_exit_cancel"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        com.obric.oui.dialog.alert.c r14 = com.obric.oui.dialog.alert.c.b(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$CreateMemoryTaskActivity$jPpqineInEKg9g20cfHghFf8BMM.INSTANCE, null, 4, null);
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.memory_create_memory_task_exit_confirm, TypedValues.Custom.S_STRING, "memory_create_memory_task_exit_confirm"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        com.obric.oui.dialog.alert.b r3 = com.obric.oui.dialog.alert.c.a(r14, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$CreateMemoryTaskActivity$aSLCF_ws9XtsPW3VfwkdMjPn4t8(this), null, 4, null).g();
        com.obric.oui.dialog.alert.b r4 = (com.obric.oui.dialog.alert.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.dialog.alert.b.class, "com.obric.memorydata.plugin");
        r4.setCanceledOnTouchOutside(true);
        r4.setCancelable(true);
        OButton r5 = r4.g();
        OButton r6 = r4.f();
        if (ZeusTransformUtils.instanceOf(r6, TextView.class) == false) goto L5;
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
    L6:
        if (r9 == null) goto L17;
        r9.setTextColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6")));
        if (r5 == null) goto L17;
        Drawable r0 = r5.getBackground();
        if (r0 == null) goto L16;
        Drawable.ConstantState r10 = r0.getConstantState();
        if (r10 == null) goto L16;
        Drawable r11 = r10.newDrawable();
        if (r11 == null) goto L16;
        r7 = r11.mutate();
    L16:
        r9.setBackground(r7);
        r9.setBackgroundTintList(r5.getBackgroundTintList());
    L17:
        ((com.obric.oui.dialog.alert.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.dialog.alert.b.class, "com.obric.memorydata.plugin")).show();
        return;
    L5:
        r9 = null;
        goto L6
    }

    private static final void showExitConfirmDialog$lambda$2(DialogInterface r1, int r2) {
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin")).dismiss();
    }

    private static final void showExitConfirmDialog$lambda$3(CreateMemoryTaskActivity r1, DialogInterface r2, int r3) {
        CreateMemoryTaskActivity r4 = (CreateMemoryTaskActivity) ZeusTransformUtils.wrapperContextForParams(r1, CreateMemoryTaskActivity.class, "com.obric.memorydata.plugin");
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin")).dismiss();
        r4.getViewModel().closePage();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, com.obric.memorydata.ui.b
    public OFloatingTitleBar getCurrentFloatingTitleBar() {
        return (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title_bar, OaidModel.KEY_ID, "title_bar")), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r11) {
        setContentView(ZeusTransformUtils.mapRes(R.layout.auto_memory_pro_activity_create_memory_task, "layout", "auto_memory_pro_activity_create_memory_task"));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), new $$Lambda$CreateMemoryTaskActivity$OCJ85r0hZQEQuqQzfECGF7Lbs(this));
        if (r11 != null) goto L6;
        getViewModel().resetState();
        AutoMemoryCreateCollectionViewModel.initState$default(getViewModel(), 0, "", "", false, null, null, 48, null);
    L6:
        if (getSupportFragmentManager().findFragmentById(ZeusTransformUtils.mapRes(R.id.sheet_root_container, OaidModel.KEY_ID, "sheet_root_container")) != null) goto L8;
        getSupportFragmentManager().beginTransaction().add(ZeusTransformUtils.mapRes(R.id.sheet_root_container, OaidModel.KEY_ID, "sheet_root_container"), (Fragment) ZeusTransformUtils.preCheckCast(new AutoMemoryCreateCollectionSheetHostFragment(), Fragment.class, "com.obric.memorydata.plugin")).commitNowAllowingStateLoss();
    L8:
        k.b(k.f(k.b((i) ZeusTransformUtils.preCheckCast(new b((i) ZeusTransformUtils.preCheckCast(getViewModel().getState(), i.class, "com.obric.memorydata.plugin")), i.class, "com.obric.memorydata.plugin")), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin")), (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"));
        k.b(k.f((i) ZeusTransformUtils.preCheckCast(getViewModel().getExitRequest(), i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin")), (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"));
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin"), (OnBackPressedCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this), OnBackPressedCallback.class, "com.obric.memorydata.plugin"));
    }
}
