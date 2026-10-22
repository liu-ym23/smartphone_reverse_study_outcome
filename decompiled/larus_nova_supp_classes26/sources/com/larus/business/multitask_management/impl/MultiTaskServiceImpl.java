package com.larus.business.multitask_management.impl;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.a0;
import com.larus.bmhome.b0;
import com.larus.business.multitask_management.api.IMultiTaskInitEvent;
import com.larus.business.multitask_management.api.IMultiTaskService;
import com.larus.business.multitask_management.impl.floatwindow.TaskManagementFloatWindowView;
import com.larus.business.multitask_management.impl.fullscreen.MultiTaskManagementFullscreenFragment;
import com.larus.business.multitask_management.impl.pad.MultiTaskManagementPadDialogFragment;
import com.larus.business.multitask_management.impl.sheet.MultiTaskManagementDialogFragment;
import com.larus.business.multitask_management.impl.view.QuickAccessNodeDefaultIcons;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.floatwindow.view.SingleFloatWindowState;
import com.larus.platform.api.m4;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.e2;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e19.t;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kl9.u;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\f\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\u0019\u0010(\u001a\u0004\u0018\u00010\t2\b\u0010)\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u0004\u0018\u00010\u001a*\u00020,H\u0002J\"\u0010-\u001a\u0004\u0018\u00010\u001a*\u00020,2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001c0/H\u0002J\u0016\u00100\u001a\u0004\u0018\u00010\u001a*\u00020,2\u0006\u00101\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u00063"}, d2 = {"Lcom/larus/business/multitask_management/impl/MultiTaskServiceImpl;", "Lcom/larus/business/multitask_management/api/IMultiTaskService;", "<init>", "()V", "currentRequest", "Lcom/larus/business/multitask_management/impl/floatwindow/TaskManagementFloatRequest;", "inited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastScreenWidth", "", "Ljava/lang/Integer;", "screenSizeCallbacks", "com/larus/business/multitask_management/impl/MultiTaskServiceImpl$screenSizeCallbacks$1", "Lcom/larus/business/multitask_management/impl/MultiTaskServiceImpl$screenSizeCallbacks$1;", "init", "", "handleScreenSizeChanged", "newConfig", "Landroid/content/res/Configuration;", "updateMultiTaskFloatWindowWidth", "getScreenWidth", "getMultiTaskManagementFragment", "Landroidx/fragment/app/DialogFragment;", "enterFrom", "", "getMultiTaskManagementFullscreenFragment", "Landroidx/fragment/app/Fragment;", "isMultiTaskManagementAccountEligible", "", "isMultiTaskManagementEntranceEnabled", "isMultiTaskManagementFloatWindowEnabled", "isMultiTaskManagementEnabled", "showMultiTaskFloatWindow", "hideMultiTaskFloatWindow", "expandMultiTaskFloatWindow", "animate", "collapseMultiTaskFloatWindow", "isMultiTaskFloatWindowExpanded", "presentingTaskListType", "closeMultiTaskPage", "resolveLocalIconResource", "uri", "(Ljava/lang/String;)Ljava/lang/Integer;", "findMultiTaskManagementFragment", "Landroidx/fragment/app/FragmentManager;", "findFragmentDeep", "predicate", "Lkotlin/Function1;", "findFragmentByTagDeep", "tag", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskServiceImpl implements IMultiTaskService {
    public static final /* synthetic */ int e = 0;
    public com.larus.business.multitask_management.impl.floatwindow.a a;
    public final AtomicBoolean b;
    public Integer c;
    public final d d;

    public static final class a {
    }

    public static final class b implements m4 {
        public final /* synthetic */ MultiTaskServiceImpl a;

        public final void S1() {
            this.a.c();
        }

        public final void b1() {
            il9.a r0 = (il9.a) ServiceManager.get().getService(il9.a.class);
            if (r0 == null) goto L11;
            StateFlowImpl r1 = r0.I0();
            if (r1 == null) goto L11;
            List r2 = (List) r1.getValue();
            if (r2 == null) goto L11;
            boolean r3 = true;
            if ((!r2.isEmpty()) != true) goto L11;
        L12:
            if (r3 == false) goto L15;
            this.a.e();
            return;
        L15:
            return;
        L11:
            r3 = false;
            goto L12
        }

        public b(MultiTaskServiceImpl r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.platform.api.b {
        public final /* synthetic */ MultiTaskServiceImpl a;

        public c(MultiTaskServiceImpl r1) {
            this.a = r1;
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            il9.a r3 = (il9.a) ServiceManager.get().getService(il9.a.class);
            if (r3 == null) goto L11;
            StateFlowImpl r4 = r3.I0();
            if (r4 == null) goto L11;
            List r5 = (List) r4.getValue();
            if (r5 == null) goto L11;
            boolean r0 = true;
            if ((!r5.isEmpty()) != true) goto L11;
        L12:
            if (r0 == false) goto L15;
            this.a.e();
            return;
        L15:
            return;
        L11:
            r0 = false;
            goto L12
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a.c();
        }
    }

    public static final class d implements ComponentCallbacks {
        public final /* synthetic */ MultiTaskServiceImpl a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public d(MultiTaskServiceImpl r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r4) {
            Intrinsics.checkNotNullParameter(r4, "newConfig");
            MultiTaskServiceImpl r0 = this.a;
            int r1 = MultiTaskServiceImpl.e;
            r0.getClass();
            int r5 = r4.screenWidthDp;
            Integer r2 = r0.c;
            r0.c = Integer.valueOf(r5);
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.intValue() != r5) goto L8;
            return;
        L8:
            if (r0.a != null) goto L11;
            return;
        L11:
            if (r0.d() == false) goto L45;
            il9.a r6 = (il9.a) ServiceManager.get().getService(il9.a.class);
            boolean r3 = false;
            if (r6 == null) goto L22;
            StateFlowImpl r7 = r6.I0();
            if (r7 == null) goto L22;
            List r8 = (List) r7.getValue();
            if (r8 == null) goto L22;
            if (r8.isEmpty() == true) goto L22;
            boolean r9 = true;
        L23:
            if (r9 == false) goto L46;
            com.larus.business.multitask_management.impl.floatwindow.a r10 = r0.a;
            if (r10 == null) goto L41;
            t r11 = t.j;
            t r12 = t.a.a();
            if (r12 != null) goto L30;
        L32:
            if (r3 == false) goto L36;
            t r13 = t.a.a();
            if (r13 == null) goto L36;
            r13.n(r10);
        L36:
            TaskManagementFloatWindowView r14 = r10.b;
            if (r14 == null) goto L42;
            r14.l();
            return;
        L42:
            return;
        L30:
            if (r12.j(r10) != true) goto L32;
            r3 = true;
            goto L32
        L41:
            return;
        L46:
            return;
        L22:
            r9 = false;
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.MultiTaskServiceImpl$init$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.MultiTaskServiceImpl$init$2", f = "MultiTaskServiceImpl.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ il9.a $multiTaskManager;
        int label;
        final /* synthetic */ MultiTaskServiceImpl this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.MultiTaskServiceImpl$init$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {
            public final /* synthetic */ MultiTaskServiceImpl a;

            public AnonymousClass1(MultiTaskServiceImpl r1) {
                this.a = r1;
            }

            public final Object a(List<u> r6, Continuation<? super Unit> r7) {
                if ((r7 instanceof MultiTaskServiceImpl$init$2$1$emit$1) == false) goto L7;
                MultiTaskServiceImpl$init$2$1$emit$1 r0 = (MultiTaskServiceImpl$init$2$1$emit$1) r7;
                int r1 = r0.label;
                if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
                r0.label = r1 - Integer.MIN_VALUE;
            L8:
                Object r8 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                boolean r4 = true;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r8);
            L24:
                il9.a r9 = (il9.a) ServiceManager.get().getService(il9.a.class);
                if (r9 == null) goto L33;
                StateFlowImpl r10 = r9.I0();
                if (r10 == null) goto L33;
                List r11 = (List) r10.getValue();
                if (r11 == null) goto L33;
                if (r11.isEmpty() != true) goto L33;
            L34:
                if (r4 == false) goto L37;
                this.a.c();
            L37:
                return Unit.INSTANCE;
            L33:
                r4 = false;
                goto L34
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r8);
                FLogger.a.i("multitask-MultiTaskServiceImpl", "getTaskRecordList " + r6.size());
                if (this.a.d() == true) goto L19;
                this.a.c();
                return Unit.INSTANCE;
            L19:
                if ((!r6.isEmpty()) == false) goto L21;
                this.a.e();
                goto L37
            L21:
                r0.label = 1;
                if (DelayKt.delay(250, r0) != r2) goto L24;
                return r2;
            L7:
                r0 = new MultiTaskServiceImpl$init$2$1$emit$1(this, r7);
                goto L8
            }

            public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return a((List) r1, r2);
            }
        }

        public AnonymousClass2(il9.a r1, MultiTaskServiceImpl r2, Continuation<? super AnonymousClass2> r3) {
            this.$multiTaskManager = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$multiTaskManager, this.this$0, r4);
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
            StateFlowImpl r6 = this.$multiTaskManager.I0();
            AnonymousClass1 r2 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final void c() {
        com.larus.business.multitask_management.impl.floatwindow.a r0 = this.a;
        if (r0 == null) goto L7;
        t r1 = t.j;
        t r2 = t.a.a();
        if (r2 == null) goto L7;
        r2.m(r0);
    L7:
        this.a = null;
    }

    public final boolean d() {
        if (z2.a.getAppsFrameworkConfig().c == true) goto L5;
    L7:
        return false;
    L5:
        if (q() == false) goto L7;
        return true;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final String i() {
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        Fragment r2 = null;
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 == null) goto L8;
        FragmentManager r3 = r1.getSupportFragmentManager();
    L9:
        if (r3 == null) goto L14;
        Fragment r4 = a(r3);
        if (r4 == null) goto L13;
        r2 = r4;
        goto L14
    L13:
        r2 = b(r3, new com.larus.business.multitask_management.impl.a());
    L14:
        boolean r5 = false;
        if (r2 != null) goto L17;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == false) goto L24;
        return "multi_task_manage";
    L24:
        if (this.a == null) goto L33;
        t r7 = t.j;
        t r8 = t.a.a();
        if (r8 != null) goto L28;
    L30:
        if (r5 == false) goto L35;
        return "task_float_window";
    L35:
        return "";
    L28:
        if (r8.j(this.a) != true) goto L30;
        r5 = true;
        goto L30
    L33:
        return "";
    L17:
        if (r2.isAdded() != true) goto L19;
        r6 = true;
        goto L20
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final void init() {
        if (this.b.get() == false) goto L5;
        return;
    L5:
        il9.a r0 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r0 != null) goto L10;
        FLogger.a.i("multitask-MultiTaskServiceImpl", "init skipped: IMultiTaskManager is not ready");
        return;
    L10:
        if (this.b.compareAndSet(false, true) == false) goto L18;
        this.c = Integer.valueOf(AppHost.a.getApplication().getResources().getConfiguration().screenWidthDp);
        r0.init();
        Iterator r1 = ServiceManager.get().getServices(IMultiTaskInitEvent.class).iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        ((IMultiTaskInitEvent) r1.next()).onInit();
        goto L13
    L15:
        AppHost.Companion r2 = AppHost.a;
        r2.getApplication().registerComponentCallbacks(this.d);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass2(r0, this, null), 3, null);
        AccountService r3 = AccountService.a;
        r3.H(new b(this));
        r3.E(new c(this));
        r2.a().j(new AnonymousClass5(this));
        return;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final String m() {
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        ww8.a r2 = null;
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 == null) goto L8;
        FragmentManager r3 = r1.getSupportFragmentManager();
    L9:
        if (r3 == null) goto L14;
        Fragment r4 = a(r3);
        if (r4 != null) goto L15;
        r4 = b(r3, new com.larus.business.multitask_management.impl.a());
    L15:
        boolean r5 = true;
        if (r4 != null) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L24;
        String r7 = "multi_task_manage";
    L35:
        if ((r4 instanceof DialogFragment) == false) goto L44;
        ((DialogFragment) r4).dismissAllowingStateLoss();     // Catch: Exception -> L39
    L50:
        p(false);
        return r7;
    L39:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L50;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L50
    L44:
        if ((r4 instanceof MultiTaskManagementFullscreenFragment) == false) goto L50;
        a0 r9 = b0.a(r4);
        if ((r9 instanceof ww8.a) == false) goto L48;
        r2 = (ww8.a) r9;
    L48:
        if (r2 == null) goto L50;
        r2.Gx();
        goto L50
    L24:
        if (this.a == null) goto L33;
        t r10 = t.j;
        t r11 = t.a.a();
        if (r11 != null) goto L28;
    L30:
        r5 = false;
    L31:
        if (r5 == false) goto L33;
        r7 = "task_float_window";
        goto L35
    L28:
        if (r11.j(this.a) != true) goto L30;
    L33:
        r7 = "";
        goto L35
    L18:
        if (r4.isAdded() != true) goto L20;
        r6 = true;
        goto L21
    L14:
        r4 = null;
        goto L15
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final boolean n() {
        com.larus.business.multitask_management.impl.floatwindow.a r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        t r2 = t.j;
        t r3 = t.a.a();
        if (r3 != null) goto L8;
    L14:
        SingleFloatWindowState r1 = null;
    L16:
        if (r1 != SingleFloatWindowState.MAXIMIZE) goto L19;
        return true;
    L19:
        return false;
    L8:
        if (Intrinsics.areEqual(r3.b.a, r0) == false) goto L14;
        if (r3.d == false) goto L14;
        r1 = r3.c.c.d();
        goto L16
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final void o() {
        if (this.a == null) goto L15;
        t r0 = t.j;
        t r1 = t.a.a();
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L16;
        t r3 = t.a.a();
        if (r3 == null) goto L17;
        r3.c(SingleFloatWindowState.MAXIMIZE, true);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (r1.j(this.a) != true) goto L9;
        r2 = true;
        goto L10
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final boolean q() {
        AccountService r0 = AccountService.a;
        if (r0.a() == false) goto L5;
    L9:
        return false;
    L5:
        if (i3.a.f() == true) goto L9;
        if (r0.isLogin().booleanValue() == false) goto L9;
        return true;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final boolean u() {
        if (z2.a.getAppsFrameworkConfig().d == true) goto L5;
    L7:
        return false;
    L5:
        if (q() == false) goto L7;
        return true;
    }

    public MultiTaskServiceImpl() {
        this.b = new AtomicBoolean(false);
        this.d = new d(this);
    }

    public final void e() {
        if (d() == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L10;
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 == null) goto L10;
        this.a = new com.larus.business.multitask_management.impl.floatwindow.a(r0);
    L10:
        com.larus.business.multitask_management.impl.floatwindow.a r1 = this.a;
        if (r1 == null) goto L23;
        t r2 = t.j;
        t r3 = t.a.a();
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L24;
        t r5 = t.a.a();
        if (r5 == null) goto L25;
        r5.e(r1);
        return;
    L25:
        return;
    L24:
        return;
    L15:
        if (r3.j(this.a) == true) goto L17;
        r4 = true;
        goto L18
    }

    public static Fragment a(FragmentManager r3) {
        Fragment r0 = r3.findFragmentByTag("multi_task_management");
        if (r0 == null) goto L5;
        return r0;
    L5:
        Iterator r4 = r3.getFragments().iterator();
    L6:
        Fragment r1 = null;
        Object r2 = null;
        if (r4.hasNext() == false) goto L22;
        Fragment r5 = (Fragment) r4.next();
        if (r5.isAdded() == false) goto L6;
        if (r5.isDetached() == true) goto L6;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L14
        Object r7 = Result.constructor-impl(a(r5.getChildFragmentManager()));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r7) == true) goto L20;
        r2 = r7;
    L20:
        r1 = (Fragment) r2;
        if (r1 == null) goto L6;
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        return r1;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final void p(boolean r3) {
        if (this.a == null) goto L15;
        t r0 = t.j;
        t r1 = t.a.a();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.j(this.a) != true) goto L9;
    L10:
        if (r2 == false) goto L16;
        t r4 = t.a.a();
        if (r4 == null) goto L17;
        r4.c(SingleFloatWindowState.MINIMIZE, r3);
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final Integer r(String r5) {
        Iterator r0 = QuickAccessNodeDefaultIcons.getEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((QuickAccessNodeDefaultIcons) r1).getUri(), r5) == false) goto L4;
    L9:
        QuickAccessNodeDefaultIcons r2 = (QuickAccessNodeDefaultIcons) r1;
        if (r2 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(r2.getResId());
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final DialogFragment s(String r4) {
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        if (e2.a.isPad() == false) goto L5;
        MultiTaskManagementPadDialogFragment r0 = new MultiTaskManagementPadDialogFragment();
        Bundle r2 = new Bundle();
        r2.putString("enter_from", r4);
        r0.setArguments(r2);
        return r0;
    L5:
        MultiTaskManagementDialogFragment r1 = new MultiTaskManagementDialogFragment();
        Bundle r3 = new Bundle();
        r3.putString("enter_from", r4);
        r1.setArguments(r3);
        return r1;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final MultiTaskManagementFullscreenFragment t(String r4) {
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        MultiTaskManagementFullscreenFragment r0 = new MultiTaskManagementFullscreenFragment();
        Bundle r1 = new Bundle();
        r1.putString("enter_from", r4);
        r0.setArguments(r1);
        return r0;
    }

    public static Fragment b(FragmentManager r2, com.larus.business.multitask_management.impl.a r3) {
        Iterator r4 = r2.getFragments().iterator();
    L4:
        if (r4.hasNext() == false) goto L15;
        Fragment r0 = (Fragment) r4.next();
        if (r0.isAdded() == false) goto L4;
        if (r0.isDetached() == true) goto L4;
        Intrinsics.checkNotNull(r0);
        if (((Boolean) r3.invoke(r0)).booleanValue() == true) goto L11;
        Fragment r1 = b(r0.getChildFragmentManager(), r3);
        if (r1 == null) goto L4;
        return r1;
    L11:
        return r0;
    L15:
        return null;
    }
}
