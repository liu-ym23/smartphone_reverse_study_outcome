package com.obric.memorydata.memory.ui.settings.contextawareness;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.databinding.ActivityContextAwarenessSettingsBinding;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.settingsharness.q;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0014J\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\u001cH\u0002J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0082@¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u00020)H\u0082@¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\tH\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00100\u001a\u00020#2\u0006\u0010$\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020)H\u0002J\b\u00104\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019¨\u00066"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityContextAwarenessSettingsBinding;", "settingsHarness", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageHarness;", "enhancedTimelinessDialog", "Landroid/app/Dialog;", "stateOwner", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsStateOwner;", "getStateOwner", "()Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsStateOwner;", "stateOwner$delegate", "Lkotlin/Lazy;", "harnessState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageState;", "getHarnessState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "harnessState$delegate", "locationPermissionRequestHelper", "Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionRequestHelper;", "getLocationPermissionRequestHelper", "()Lcom/obric/memorydata/memory/permission/MemoryLocationPermissionRequestHelper;", "locationPermissionRequestHelper$delegate", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeChecked", "onDestroy", "finishForAILabHidden", "handleAction", "Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult;", "action", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction;", "(Lcom/obric/memorydata/ui/settingsharness/SettingsAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEnhancedTimelinessSwitch", "targetChecked", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEnhancedTimelinessEnable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showEnhancedTimelinessDialog", "dialog", "handleLocationSwitch", "handleNavigation", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction$NavigationRequested;", "mutationResult", "success", "publishAuthoritativeState", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextAwarenessSettingsActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private ActivityContextAwarenessSettingsBinding binding;
    private Dialog enhancedTimelinessDialog;
    private final Lazy harnessState$delegate;
    private final Lazy locationPermissionRequestHelper$delegate;
    private final com.obric.memorydata.ui.settingsharness.h settingsHarness;
    private final Lazy stateOwner$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsActivity$Companion;", "", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r4 = new Intent(r2, ContextAwarenessSettingsActivity.class);
            if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L5;
            r4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r2, r4, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class b implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ContextAwarenessSettingsActivity f11432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.dialog.v2.alert.a f11433b;
        final /* synthetic */ AtomicBoolean c;
        final /* synthetic */ kotlinx.coroutines.n<Boolean> d;

        b(ContextAwarenessSettingsActivity r3, com.obric.oui.dialog.v2.alert.a r4, AtomicBoolean r5, kotlinx.coroutines.n<? super Boolean> r6) {
            ContextAwarenessSettingsActivity r7 = (ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.n<Boolean> r8 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
            this.f11432a = r7;
            this.f11433b = r4;
            this.c = r5;
            this.d = r8;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r3) {
            DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
            if (ContextAwarenessSettingsActivity.access$getEnhancedTimelinessDialog$p(this.f11432a) != this.f11433b) goto L5;
            ContextAwarenessSettingsActivity.access$setEnhancedTimelinessDialog$p(this.f11432a, null);
        L5:
            ContextAwarenessSettingsActivity.access$confirmEnhancedTimelinessEnable$lambda$5$complete(this.c, this.d, false);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class c implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ContextAwarenessSettingsActivity f11434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.dialog.v2.alert.a f11435b;

        c(ContextAwarenessSettingsActivity r3, com.obric.oui.dialog.v2.alert.a r4) {
            this.f11434a = (ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
            this.f11435b = r4;
        }

        public final void a(Throwable r3) {
            ContextAwarenessSettingsActivity r4 = this.f11434a;
            final com.obric.oui.dialog.v2.alert.a r2 = this.f11435b;
            r4.runOnUiThread((Runnable) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2), Runnable.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class d implements Function2<DialogInterface, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f11437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n<Boolean> f11438b;

        d(AtomicBoolean r3, kotlinx.coroutines.n<? super Boolean> r4) {
            kotlinx.coroutines.n<Boolean> r5 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
            this.f11437a = r3;
            this.f11438b = r5;
        }

        public final void a(DialogInterface r2, int r3) {
            DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "currentDialog");
            ContextAwarenessSettingsActivity.access$confirmEnhancedTimelinessEnable$lambda$5$complete(this.f11437a, this.f11438b, false);
            r4.dismiss();
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Unit invoke(DialogInterface r3, Integer r4) {
            a((DialogInterface) ZeusTransformUtils.preCheckCast(r3, DialogInterface.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class e implements Function2<DialogInterface, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f11439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n<Boolean> f11440b;

        e(AtomicBoolean r3, kotlinx.coroutines.n<? super Boolean> r4) {
            kotlinx.coroutines.n<Boolean> r5 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
            this.f11439a = r3;
            this.f11440b = r5;
        }

        public final void a(DialogInterface r2, int r3) {
            DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "currentDialog");
            ContextAwarenessSettingsActivity.access$confirmEnhancedTimelinessEnable$lambda$5$complete(this.f11439a, this.f11440b, true);
            r4.dismiss();
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Unit invoke(DialogInterface r3, Integer r4) {
            a((DialogInterface) ZeusTransformUtils.preCheckCast(r3, DialogInterface.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue());
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class f implements com.obric.memorydata.ui.settingsharness.d, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ContextAwarenessSettingsActivity f11441a;

        f(ContextAwarenessSettingsActivity r3) {
            this.f11441a = (ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.ui.settingsharness.d
        public final Object a(com.obric.memorydata.ui.settingsharness.b r3, Continuation<? super com.obric.memorydata.ui.settingsharness.f> r4) {
            com.obric.memorydata.ui.settingsharness.b r5 = (com.obric.memorydata.ui.settingsharness.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ui.settingsharness.b.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return ContextAwarenessSettingsActivity.access$handleAction(this.f11441a, r5, r6);
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.ui.settingsharness.d.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, FunctionAdapter.class) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(((FunctionAdapter) ZeusTransformUtils.preCheckCast(this, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate(), ((FunctionAdapter) ZeusTransformUtils.preCheckCast(r3, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return (Function) ZeusTransformUtils.preCheckCast(new FunctionReferenceImpl(2, this.f11441a, ContextAwarenessSettingsActivity.class, "handleAction", "handleAction(Lcom/obric/memorydata/ui/settingsharness/SettingsAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0), Function.class, "com.obric.memorydata.plugin");
        }

        public final int hashCode() {
            return ((FunctionAdapter) ZeusTransformUtils.preCheckCast(this, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity$handleEnhancedTimelinessSwitch$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity", f = "ContextAwarenessSettingsActivity.kt", i = {0, 0}, l = {179}, m = "handleEnhancedTimelinessSwitch", n = {"this", "targetChecked"}, s = {"L$0", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ContextAwarenessSettingsActivity this$0;

        AnonymousClass1(ContextAwarenessSettingsActivity r3, Continuation<? super AnonymousClass1> r4) {
            ContextAwarenessSettingsActivity r5 = (ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ContextAwarenessSettingsActivity.access$handleEnhancedTimelinessSwitch(this.this$0, false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity$onCreateChecked$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C12121 extends FunctionReferenceImpl implements Function0<Unit> {
        C12121(Object r8) {
            super(0, r8, ContextAwarenessSettingsActivity.class, "onBackPressed", "onBackPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((ContextAwarenessSettingsActivity) ZeusTransformUtils.preCheckCast(this.receiver, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity$onCreateChecked$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity$onCreateChecked$3", f = "ContextAwarenessSettingsActivity.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessSettingsActivity this$0;

        AnonymousClass3(ContextAwarenessSettingsActivity r3, Continuation<? super AnonymousClass3> r4) {
            ContextAwarenessSettingsActivity r5 = (ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            kotlinx.coroutines.flow.i<Unit> r7 = ContextAwarenessSettingsActivity.access$getStateOwner(this.this$0).b();
            final ContextAwarenessSettingsActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Unit> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity$onCreateChecked$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsActivity$onCreateChecked$4", f = "ContextAwarenessSettingsActivity.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ContextAwarenessSettingsActivity this$0;

        AnonymousClass4(ContextAwarenessSettingsActivity r3, Continuation<? super AnonymousClass4> r4) {
            ContextAwarenessSettingsActivity r5 = (ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
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
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            ar<com.obric.memorydata.memory.lab.d> r7 = AILabPermissionRepository.f10236a.a();
            final ContextAwarenessSettingsActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super com.obric.memorydata.memory.lab.d> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContextAwarenessSettingsActivity() {
        this.settingsHarness = new com.obric.memorydata.ui.settingsharness.h(null, 1, 0 == true ? 1 : 0);
        this.stateOwner$delegate = LazyKt.lazy($$Lambda$ContextAwarenessSettingsActivity$3SHnTgQEiVYY8jfjtWwNYrEpdk.INSTANCE);
        this.harnessState$delegate = LazyKt.lazy(new $$Lambda$ContextAwarenessSettingsActivity$JFb2ufuCyj3XDzCQCZg_GkHIT3k(this));
        this.locationPermissionRequestHelper$delegate = LazyKt.lazy(new $$Lambda$ContextAwarenessSettingsActivity$4FeJOkWMZTm327qcqWVS_PGN2o(this));
    }

    public static final /* synthetic */ Object access$confirmEnhancedTimelinessEnable(ContextAwarenessSettingsActivity r2, Continuation r3) {
        return ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).confirmEnhancedTimelinessEnable((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$confirmEnhancedTimelinessEnable$lambda$5$complete(AtomicBoolean r2, kotlinx.coroutines.n r3, boolean r4) {
        confirmEnhancedTimelinessEnable$lambda$5$complete(r2, (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"), r4);
    }

    public static final /* synthetic */ void access$finishForAILabHidden(ContextAwarenessSettingsActivity r2) {
        ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).finishForAILabHidden();
    }

    public static final /* synthetic */ ActivityContextAwarenessSettingsBinding access$getBinding$p(ContextAwarenessSettingsActivity r2) {
        return ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ Dialog access$getEnhancedTimelinessDialog$p(ContextAwarenessSettingsActivity r2) {
        return ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).enhancedTimelinessDialog;
    }

    public static final /* synthetic */ j access$getStateOwner(ContextAwarenessSettingsActivity r2) {
        return ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).getStateOwner();
    }

    public static final /* synthetic */ Object access$handleAction(ContextAwarenessSettingsActivity r2, com.obric.memorydata.ui.settingsharness.b r3, Continuation r4) {
        return ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).handleAction((com.obric.memorydata.ui.settingsharness.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ui.settingsharness.b.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$handleEnhancedTimelinessSwitch(ContextAwarenessSettingsActivity r2, boolean r3, Continuation r4) {
        return ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).handleEnhancedTimelinessSwitch(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$publishAuthoritativeState(ContextAwarenessSettingsActivity r2) {
        ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).publishAuthoritativeState();
    }

    public static final /* synthetic */ void access$setEnhancedTimelinessDialog$p(ContextAwarenessSettingsActivity r2, Dialog r3) {
        ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).enhancedTimelinessDialog = r3;
    }

    public static final /* synthetic */ boolean access$showEnhancedTimelinessDialog(ContextAwarenessSettingsActivity r2, Dialog r3) {
        return ((ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin")).showEnhancedTimelinessDialog(r3);
    }

    private final Object confirmEnhancedTimelinessEnable(Continuation<? super Boolean> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r13), 1);
        r0.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        AtomicBoolean r4 = new AtomicBoolean(false);
        com.obric.oui.dialog.v2.alert.a r6 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.context_awareness_enhanced_timeliness_title, TypedValues.Custom.S_STRING, "context_awareness_enhanced_timeliness_title")), CharSequence.class, "com.obric.memorydata.plugin"), false).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.context_awareness_enhanced_timeliness_dialog_message, TypedValues.Custom.S_STRING, "context_awareness_enhanced_timeliness_dialog_message")), CharSequence.class, "com.obric.memorydata.plugin")), false, 1, null).b(ZeusTransformUtils.mapRes(R.string.context_awareness_enhanced_timeliness_cancel, TypedValues.Custom.S_STRING, "context_awareness_enhanced_timeliness_cancel"), (Function2) ZeusTransformUtils.preCheckCast(new d(r4, r2), Function2.class, "com.obric.memorydata.plugin")).a(ZeusTransformUtils.mapRes(R.string.context_awareness_enhanced_timeliness_enable, TypedValues.Custom.S_STRING, "context_awareness_enhanced_timeliness_enable"), (Function2) ZeusTransformUtils.preCheckCast(new e(r4, r2), Function2.class, "com.obric.memorydata.plugin")).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        access$setEnhancedTimelinessDialog$p(this, (Dialog) ZeusTransformUtils.preCheckCast(r6, Dialog.class, "com.obric.memorydata.plugin"));
        r6.setOnDismissListener((DialogInterface.OnDismissListener) ZeusTransformUtils.preCheckCast(new b(this, r6, r4, r2), DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin"));
        r6.setCanceledOnTouchOutside(true);
        r6.setCancelable(true);
        r2.a((Function1) ZeusTransformUtils.preCheckCast(new c(this, r6), Function1.class, "com.obric.memorydata.plugin"));
        if (r2.a() == true) goto L5;
    L6:
        access$confirmEnhancedTimelinessEnable$lambda$5$complete(r4, r2, false);
    L7:
        Object r11 = r0.h();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L10:
        return r11;
    L5:
        if (access$showEnhancedTimelinessDialog(this, (Dialog) ZeusTransformUtils.preCheckCast(r6, Dialog.class, "com.obric.memorydata.plugin")) == true) goto L7;
        goto L6
    }

    private static final void confirmEnhancedTimelinessEnable$lambda$5$complete(AtomicBoolean r3, kotlinx.coroutines.n<? super Boolean> r4, boolean r5) {
        kotlinx.coroutines.n r6 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        if (r3.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (r6.a() == false) goto L9;
        Boolean r7 = Boolean.valueOf(r5);
        Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r9 = Result.Companion;
        r8.resumeWith(Result.m1421constructorimpl(r7));
        return;
    }

    private final void finishForAILabHidden() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        ((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin")).a("context_awareness_settings_lab_hidden", "Context awareness settings closed because AI Lab is hidden", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        finish();
    }

    private final ae<com.obric.memorydata.ui.settingsharness.i> getHarnessState() {
        return (ae) ZeusTransformUtils.preCheckCast(this.harnessState$delegate.getValue(), ae.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.memory.permission.c getLocationPermissionRequestHelper() {
        return (com.obric.memorydata.memory.permission.c) ZeusTransformUtils.preCheckCast(this.locationPermissionRequestHelper$delegate.getValue(), com.obric.memorydata.memory.permission.c.class, "com.obric.memorydata.plugin");
    }

    private final j getStateOwner() {
        return (j) ZeusTransformUtils.preCheckCast(this.stateOwner$delegate.getValue(), j.class, "com.obric.memorydata.plugin");
    }

    private final Object handleAction(com.obric.memorydata.ui.settingsharness.b r4, Continuation<? super com.obric.memorydata.ui.settingsharness.f> r5) {
        com.obric.memorydata.ui.settingsharness.b r6 = (com.obric.memorydata.ui.settingsharness.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.ui.settingsharness.b.class, "com.obric.memorydata.plugin");
        Continuation<? super com.obric.memorydata.ui.settingsharness.f> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.ui.settingsharness.b.c.class) == false) goto L27;
        String r0 = ((com.obric.memorydata.ui.settingsharness.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.c.class, "com.obric.memorydata.plugin")).a();
        switch(r0.hashCode()) {
            case -2105216310: goto L20;
            case -1794828793: goto L16;
            case -1245927818: goto L12;
            case 1901043637: goto L8;
            default: goto L24;
        };
    L24:
        boolean r8 = getStateOwner().a(com.obric.memorydata.memory.ui.settings.contextawareness.d.f11450a.a(((com.obric.memorydata.ui.settingsharness.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.c.class, "com.obric.memorydata.plugin")).a()), ((com.obric.memorydata.ui.settingsharness.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.c.class, "com.obric.memorydata.plugin")).b());
    L37:
        return mutationResult(r8);
    L8:
        if (r0.equals("location") == false) goto L24;
        return handleLocationSwitch(((com.obric.memorydata.ui.settingsharness.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.c.class, "com.obric.memorydata.plugin")).b());
    L12:
        if (r0.equals("cellular_upload") == false) goto L24;
        r8 = getStateOwner().a(((com.obric.memorydata.ui.settingsharness.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.c.class, "com.obric.memorydata.plugin")).b());
        goto L37
    L16:
        if (r0.equals("recorder_ambient_voice_collection_debug") == false) goto L24;
        r8 = getStateOwner().c(((com.obric.memorydata.ui.settingsharness.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.c.class, "com.obric.memorydata.plugin")).b());
        goto L37
    L20:
        if (r0.equals("enhanced_timeliness") == false) goto L24;
        return handleEnhancedTimelinessSwitch(((com.obric.memorydata.ui.settingsharness.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.c.class, "com.obric.memorydata.plugin")).b(), r7);
    L27:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.ui.settingsharness.b.a.class) == false) goto L31;
        return handleNavigation((com.obric.memorydata.ui.settingsharness.b.a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.a.class, "com.obric.memorydata.plugin"));
    L31:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.ui.settingsharness.b.C0715b.class) == false) goto L35;
        throw new IllegalStateException(("Context Awareness main page has no selector row: " + ((com.obric.memorydata.ui.settingsharness.b.C0715b) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.C0715b.class, "com.obric.memorydata.plugin")).a()).toString());
    L35:
        throw new NoWhenBranchMatchedException();
    }

    private final Object handleEnhancedTimelinessSwitch(boolean r6, Continuation<? super com.obric.memorydata.ui.settingsharness.f> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r8, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = r0.Z$0;
        ContextAwarenessSettingsActivity this = (ContextAwarenessSettingsActivity) ZeusTransformUtils.preCheckCast(r0.L$0, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L25;
        this.publishAuthoritativeState();
        return com.obric.memorydata.ui.settingsharness.f.a.f13037a;
    L25:
        return this.mutationResult(this.getStateOwner().b(r6));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (r6 == false) goto L25;
        r0.L$0 = this;
        r0.Z$0 = r6;
        r0.label = 1;
        r9 = confirmEnhancedTimelinessEnable(r0);
        if (r9 != r2) goto L20;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    private final com.obric.memorydata.ui.settingsharness.f handleLocationSwitch(boolean r3) {
        if (r3 == false) goto L9;
        if (com.obric.memorydata.memory.permission.b.f10340a.a() == true) goto L9;
        publishAuthoritativeState();
        getLocationPermissionRequestHelper().b();
        return (com.obric.memorydata.ui.settingsharness.f) ZeusTransformUtils.preCheckCast(com.obric.memorydata.ui.settingsharness.f.a.f13037a, com.obric.memorydata.ui.settingsharness.f.class, "com.obric.memorydata.plugin");
    L9:
        return mutationResult(getStateOwner().a(ContextAwarenessGlobalSource.LOCATION, r3));
    }

    private final com.obric.memorydata.ui.settingsharness.f handleNavigation(com.obric.memorydata.ui.settingsharness.b.a r6) {
        String r0 = r6.b();
        switch(r0.hashCode()) {
            case -1936977002: goto L26;
            case -619415472: goto L21;
            case -14869957: goto L18;
            case 580699939: goto L15;
            case 1385936767: goto L6;
            default: goto L34;
        };
    L6:
        if (r0.equals("open_smart_glasses") == false) goto L34;
        if (((i) ZeusTransformUtils.preCheckCast(getStateOwner().a().c(), i.class, "com.obric.memorydata.plugin")).q() == true) goto L11;
        Object r7 = new com.obric.memorydata.ui.settingsharness.f.b((q) ZeusTransformUtils.preCheckCast(new q.b(ZeusTransformUtils.mapRes(R.string.context_awareness_glasses_not_connected, TypedValues.Custom.S_STRING, "context_awareness_glasses_not_connected")), q.class, "com.obric.memorydata.plugin"));
    L24:
        com.obric.memorydata.ui.settingsharness.f r8 = (com.obric.memorydata.ui.settingsharness.f) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ui.settingsharness.f.class, "com.obric.memorydata.plugin");
        publishAuthoritativeState();
        return r8;
    L11:
        if (getStateOwner().c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")) == true) goto L23;
        r7 = new com.obric.memorydata.ui.settingsharness.f.b((q) ZeusTransformUtils.preCheckCast(new q.b(ZeusTransformUtils.mapRes(R.string.context_awareness_glasses_unavailable, TypedValues.Custom.S_STRING, "context_awareness_glasses_unavailable")), q.class, "com.obric.memorydata.plugin"));
    L23:
        r7 = com.obric.memorydata.ui.settingsharness.f.a.f13037a;
        goto L24
    L15:
        if (r0.equals("open_system_app_data") == false) goto L34;
        SystemAppDataSettingsActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        goto L23
    L18:
        if (r0.equals("open_screen_content") == false) goto L34;
        getStateOwner().a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        goto L23
    L21:
        if (r0.equals("open_block_rules") == false) goto L34;
        getStateOwner().d((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        goto L23
    L26:
        if (r0.equals("open_ambient_voice") == false) goto L34;
        if (getStateOwner().b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")) == true) goto L23;
        r7 = new com.obric.memorydata.ui.settingsharness.f.b((q) ZeusTransformUtils.preCheckCast(new q.b(ZeusTransformUtils.mapRes(R.string.context_awareness_recorder_settings_unavailable, TypedValues.Custom.S_STRING, "context_awareness_recorder_settings_unavailable")), q.class, "com.obric.memorydata.plugin"));
    L34:
        throw new IllegalStateException(("Unsupported Context Awareness navigation: " + r6.b()).toString());
    }

    private static final ae harnessState_delegate$lambda$1(ContextAwarenessSettingsActivity r3) {
        ContextAwarenessSettingsActivity r4 = (ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
        return at.a(com.obric.memorydata.memory.ui.settings.contextawareness.d.f11450a.a((i) ZeusTransformUtils.preCheckCast(r4.getStateOwner().a().c(), i.class, "com.obric.memorydata.plugin")));
    }

    public static /* synthetic */ Unit lambda$2XnAy_RZPulev2BZ7fPC3KlpwkI(ContextAwarenessSettingsActivity r0) {
        return locationPermissionRequestHelper_delegate$lambda$3$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$3SHnTgQEiVY-Y8jfjtWwNYrEpdk, reason: not valid java name */
    public static /* synthetic */ j m984lambda$3SHnTgQEiVYY8jfjtWwNYrEpdk() {
        return stateOwner_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$4F-eJOkWMZTm327qcqWVS_PGN2o, reason: not valid java name */
    public static /* synthetic */ com.obric.memorydata.memory.permission.c m985lambda$4FeJOkWMZTm327qcqWVS_PGN2o(ContextAwarenessSettingsActivity r0) {
        return locationPermissionRequestHelper_delegate$lambda$3(r0);
    }

    public static /* synthetic */ ae lambda$JFb2ufuCyj3XDzCQCZg_GkHIT3k(ContextAwarenessSettingsActivity r0) {
        return harnessState_delegate$lambda$1(r0);
    }

    private static final com.obric.memorydata.memory.permission.c locationPermissionRequestHelper_delegate$lambda$3(ContextAwarenessSettingsActivity r5) {
        final ContextAwarenessSettingsActivity r6 = (ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r5, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
        return new com.obric.memorydata.memory.permission.c((FragmentActivity) ZeusTransformUtils.preCheckCast(r6, FragmentActivity.class, "com.obric.memorydata.plugin"), new $$Lambda$ContextAwarenessSettingsActivity$2XnAy_RZPulev2BZ7fPC3KlpwkI(r6), (Function0) ZeusTransformUtils.preCheckCast(new ContextAwarenessSettingsActivity$locationPermissionRequestHelper$2$2(r6), Function0.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit locationPermissionRequestHelper_delegate$lambda$3$lambda$2(ContextAwarenessSettingsActivity r3) {
        ContextAwarenessSettingsActivity r4 = (ContextAwarenessSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, ContextAwarenessSettingsActivity.class, "com.obric.memorydata.plugin");
        r4.getStateOwner().a(ContextAwarenessGlobalSource.LOCATION, true);
        r4.publishAuthoritativeState();
        return Unit.INSTANCE;
    }

    private final com.obric.memorydata.ui.settingsharness.f mutationResult(boolean r5) {
        publishAuthoritativeState();
        if (r5 == false) goto L5;
        Object r6 = com.obric.memorydata.ui.settingsharness.f.a.f13037a;
    L7:
        return (com.obric.memorydata.ui.settingsharness.f) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.f.class, "com.obric.memorydata.plugin");
    L5:
        r6 = new com.obric.memorydata.ui.settingsharness.f.b((q) ZeusTransformUtils.preCheckCast(new q.b(ZeusTransformUtils.mapRes(R.string.context_awareness_save_failed, TypedValues.Custom.S_STRING, "context_awareness_save_failed")), q.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    private final void publishAuthoritativeState() {
        getStateOwner().c();
        getHarnessState().b(com.obric.memorydata.memory.ui.settings.contextawareness.d.f11450a.a((i) ZeusTransformUtils.preCheckCast(getStateOwner().a().c(), i.class, "com.obric.memorydata.plugin")));
    }

    private final boolean showEnhancedTimelinessDialog(Dialog r9) {
        if (isFinishing() == false) goto L5;
    L13:
        this.enhancedTimelinessDialog = null;
        return false;
    L5:
        if (isDestroyed() == true) goto L13;
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L13;
        r9.show();     // Catch: WindowManager.BadTokenException -> L11
        return true;
    L11:
        this.enhancedTimelinessDialog = null;
        ((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin")).a("enhanced_timeliness_dialog_bad_token", "提升感知及时性确认弹窗因窗口状态失效未展示", new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final j stateOwner_delegate$lambda$0() {
        return new j(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r12) {
        AILabPermissionRepository r13 = AILabPermissionRepository.f10236a;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "getApplicationContext(...)");
        r13.a(r0);
        com.obric.memorydata.memory.lab.d r14 = (com.obric.memorydata.memory.lab.d) ZeusTransformUtils.preCheckCast(AILabPermissionRepository.f10236a.a().c(), com.obric.memorydata.memory.lab.d.class, "com.obric.memorydata.plugin");
        if (r14.b() != null) goto L5;
    L8:
        prepareSystemBar();
        ActivityContextAwarenessSettingsBinding r1 = ActivityContextAwarenessSettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r1, "inflate(...)");
        this.binding = r1;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L11:
        FrameLayout r2 = r1.getRoot();
        if (r14.c() == false) goto L14;
        int r15 = 0;
    L15:
        r2.setVisibility(r15);
        ActivityContextAwarenessSettingsBinding r16 = this.binding;
        if (r16 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L18:
        setContentView((View) ZeusTransformUtils.preCheckCast(r16.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityContextAwarenessSettingsBinding r17 = this.binding;
        if (r17 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L21:
        OFloatingTitleBar r18 = r17.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r18, "viewTitle");
        ActivityContextAwarenessSettingsBinding r5 = this.binding;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L24:
        View r6 = (View) ZeusTransformUtils.preCheckCast(r5.contextAwarenessContainer, View.class, "com.obric.memorydata.plugin");
        int r7 = com.obric.oui.common.util.h.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), 16);
        ActivityContextAwarenessSettingsBinding r8 = this.binding;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L27:
        setupTitleBarBackAction(r18, r6, r7, r8.cutOff);
        ActivityContextAwarenessSettingsBinding r19 = this.binding;
        if (r19 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L30:
        OFloatingTitleBar r110 = r19.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r110, "viewTitle");
        com.obric.memorydata.ui.custom.a.a(r110, (Function0) ZeusTransformUtils.preCheckCast(new C12121(this), Function0.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.ui.settingsharness.h r9 = this.settingsHarness;
        ActivityContextAwarenessSettingsBinding r111 = this.binding;
        if (r111 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L33:
        FrameLayout r112 = r111.getRoot();
        Intrinsics.checkNotNullExpressionValue(r112, "getRoot(...)");
        r9.a((View) ZeusTransformUtils.preCheckCast(r112, View.class, "com.obric.memorydata.plugin"), com.obric.memorydata.memory.ui.settings.contextawareness.d.f11450a.a(), (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (ar) ZeusTransformUtils.preCheckCast(getHarnessState(), ar.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.ui.settingsharness.d) ZeusTransformUtils.preCheckCast(new f(this), com.obric.memorydata.ui.settingsharness.d.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        com.obric.memorydata.memory.lab.a r113 = com.obric.memorydata.memory.lab.a.f10241a;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r11, "getApplicationContext(...)");
        r113.b(r11, "ContextAwarenessSettingsActivity.onCreateChecked");
        return;
    L14:
        r15 = 4;
        goto L15
    L5:
        if (r14.c() == true) goto L8;
        finishForAILabHidden();
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        this.settingsHarness.a();
        Dialog r0 = this.enhancedTimelinessDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.enhancedTimelinessDialog = null;
        super.onDestroy();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        getLocationPermissionRequestHelper().a();
        publishAuthoritativeState();
    }
}
