package com.obric.memorydata.memory.ui.settings.contextawareness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.databinding.ActivitySystemAppDataSettingsBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.settingsharness.q;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/SystemAppDataSettingsActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivitySystemAppDataSettingsBinding;", "settingsHarness", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageHarness;", "stateOwner", "Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsStateOwner;", "getStateOwner", "()Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSettingsStateOwner;", "stateOwner$delegate", "Lkotlin/Lazy;", "harnessState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/ui/settingsharness/SettingsPageState;", "getHarnessState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "harnessState$delegate", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeChecked", "onDestroy", "handleAction", "Lcom/obric/memorydata/ui/settingsharness/SettingsMutationResult;", "action", "Lcom/obric/memorydata/ui/settingsharness/SettingsAction;", "(Lcom/obric/memorydata/ui/settingsharness/SettingsAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "publishAuthoritativeState", "systemAppPageState", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SystemAppDataSettingsActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private ActivitySystemAppDataSettingsBinding binding;
    private final Lazy harnessState$delegate;
    private final com.obric.memorydata.ui.settingsharness.h settingsHarness;
    private final Lazy stateOwner$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/SystemAppDataSettingsActivity$Companion;", "", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r4 = new Intent(r2, SystemAppDataSettingsActivity.class);
            if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L5;
            r4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r2, r4, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class b implements com.obric.memorydata.ui.settingsharness.d, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SystemAppDataSettingsActivity f11444a;

        b(SystemAppDataSettingsActivity r3) {
            this.f11444a = (SystemAppDataSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SystemAppDataSettingsActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.ui.settingsharness.d
        public final Object a(com.obric.memorydata.ui.settingsharness.b r3, Continuation<? super com.obric.memorydata.ui.settingsharness.f> r4) {
            com.obric.memorydata.ui.settingsharness.b r5 = (com.obric.memorydata.ui.settingsharness.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ui.settingsharness.b.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return SystemAppDataSettingsActivity.access$handleAction(this.f11444a, r5, r6);
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
            return (Function) ZeusTransformUtils.preCheckCast(new FunctionReferenceImpl(2, this.f11444a, SystemAppDataSettingsActivity.class, "handleAction", "handleAction(Lcom/obric/memorydata/ui/settingsharness/SettingsAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0), Function.class, "com.obric.memorydata.plugin");
        }

        public final int hashCode() {
            return ((FunctionAdapter) ZeusTransformUtils.preCheckCast(this, FunctionAdapter.class, "com.obric.memorydata.plugin")).getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.contextawareness.SystemAppDataSettingsActivity$onCreateChecked$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object r8) {
            super(0, r8, SystemAppDataSettingsActivity.class, "onBackPressed", "onBackPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SystemAppDataSettingsActivity) ZeusTransformUtils.preCheckCast(this.receiver, SystemAppDataSettingsActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemAppDataSettingsActivity() {
        this.settingsHarness = new com.obric.memorydata.ui.settingsharness.h(null, 1, 0 == true ? 1 : 0);
        this.stateOwner$delegate = LazyKt.lazy($$Lambda$SystemAppDataSettingsActivity$8RjCFIYk3pDZKv3re10f_vBQzn0.INSTANCE);
        this.harnessState$delegate = LazyKt.lazy(new $$Lambda$SystemAppDataSettingsActivity$MnocHnWVDabUSrV1lro8HE5Q6GM(this));
    }

    public static final /* synthetic */ Object access$handleAction(SystemAppDataSettingsActivity r2, com.obric.memorydata.ui.settingsharness.b r3, Continuation r4) {
        return ((SystemAppDataSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SystemAppDataSettingsActivity.class, "com.obric.memorydata.plugin")).handleAction((com.obric.memorydata.ui.settingsharness.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ui.settingsharness.b.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final ae<com.obric.memorydata.ui.settingsharness.i> getHarnessState() {
        return (ae) ZeusTransformUtils.preCheckCast(this.harnessState$delegate.getValue(), ae.class, "com.obric.memorydata.plugin");
    }

    private final j getStateOwner() {
        return (j) ZeusTransformUtils.preCheckCast(this.stateOwner$delegate.getValue(), j.class, "com.obric.memorydata.plugin");
    }

    private final Object handleAction(com.obric.memorydata.ui.settingsharness.b r4, Continuation<? super com.obric.memorydata.ui.settingsharness.f> r5) {
        com.obric.memorydata.ui.settingsharness.b r6 = (com.obric.memorydata.ui.settingsharness.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.ui.settingsharness.b.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.ui.settingsharness.b.c.class) == false) goto L11;
        ContextAwarenessSystemApp r8 = o.f11464a.a(((com.obric.memorydata.ui.settingsharness.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.c.class, "com.obric.memorydata.plugin")).a());
        boolean r9 = getStateOwner().a(r8, ((com.obric.memorydata.ui.settingsharness.b.c) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.ui.settingsharness.b.c.class, "com.obric.memorydata.plugin")).b());
        publishAuthoritativeState();
        if (r9 == false) goto L7;
        Object r3 = com.obric.memorydata.ui.settingsharness.f.a.f13037a;
    L9:
        return (com.obric.memorydata.ui.settingsharness.f) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ui.settingsharness.f.class, "com.obric.memorydata.plugin");
    L7:
        r3 = new com.obric.memorydata.ui.settingsharness.f.b((q) ZeusTransformUtils.preCheckCast(new q.b(ZeusTransformUtils.mapRes(R.string.context_awareness_save_failed, TypedValues.Custom.S_STRING, "context_awareness_save_failed")), q.class, "com.obric.memorydata.plugin"));
        goto L9
    L11:
        throw new IllegalArgumentException("System App Data page only accepts switch actions".toString());
    }

    private static final ae harnessState_delegate$lambda$1(SystemAppDataSettingsActivity r2) {
        return at.a(((SystemAppDataSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SystemAppDataSettingsActivity.class, "com.obric.memorydata.plugin")).systemAppPageState());
    }

    public static /* synthetic */ j lambda$8RjCFIYk3pDZKv3re10f_vBQzn0() {
        return stateOwner_delegate$lambda$0();
    }

    public static /* synthetic */ ae lambda$MnocHnWVDabUSrV1lro8HE5Q6GM(SystemAppDataSettingsActivity r0) {
        return harnessState_delegate$lambda$1(r0);
    }

    private final void publishAuthoritativeState() {
        getStateOwner().c();
        getHarnessState().b(systemAppPageState());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final j stateOwner_delegate$lambda$0() {
        return new j(null, 1, 0 == true ? 1 : 0);
    }

    private final com.obric.memorydata.ui.settingsharness.i systemAppPageState() {
        i r2 = (i) ZeusTransformUtils.preCheckCast(getStateOwner().a().c(), i.class, "com.obric.memorydata.plugin");
        return o.f11464a.a(r2.f());
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r11) {
        prepareSystemBar();
        ActivitySystemAppDataSettingsBinding r12 = ActivitySystemAppDataSettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r12, "inflate(...)");
        this.binding = r12;
        ActivitySystemAppDataSettingsBinding r0 = null;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r12.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivitySystemAppDataSettingsBinding r13 = this.binding;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L8:
        OFloatingTitleBar r14 = r13.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r14, "viewTitle");
        ActivitySystemAppDataSettingsBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4.systemAppDataContainer, View.class, "com.obric.memorydata.plugin");
        int r6 = com.obric.oui.common.util.h.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), 16);
        ActivitySystemAppDataSettingsBinding r7 = this.binding;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L14:
        setupTitleBarBackAction(r14, r5, r6, r7.cutOff);
        ActivitySystemAppDataSettingsBinding r15 = this.binding;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L17:
        OFloatingTitleBar r16 = r15.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r16, "viewTitle");
        com.obric.memorydata.ui.custom.a.a(r16, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function0.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.ui.settingsharness.h r8 = this.settingsHarness;
        ActivitySystemAppDataSettingsBinding r17 = this.binding;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        FrameLayout r18 = r0.getRoot();
        Intrinsics.checkNotNullExpressionValue(r18, "getRoot(...)");
        r8.a((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"), o.f11464a.a(), (al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (ar) ZeusTransformUtils.preCheckCast(getHarnessState(), ar.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.ui.settingsharness.d) ZeusTransformUtils.preCheckCast(new b(this), com.obric.memorydata.ui.settingsharness.d.class, "com.obric.memorydata.plugin"));
        return;
    L20:
        r0 = r17;
        goto L21
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        this.settingsHarness.a();
        super.onDestroy();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        publishAuthoritativeState();
    }
}
