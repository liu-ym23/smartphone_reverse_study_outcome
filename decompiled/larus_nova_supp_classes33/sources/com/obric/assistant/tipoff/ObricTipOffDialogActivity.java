package com.obric.assistant.tipoff;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/assistant/tipoff/ObricTipOffDialogActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "tipOffDialogFragment", "Landroidx/fragment/app/DialogFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTipOffDialogActivity extends AppCompatActivity {
    public DialogFragment a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.tipoff.ObricTipOffDialogActivity$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.tipoff.ObricTipOffDialogActivity$onCreate$1", f = "ObricTipOffDialogActivity.kt", i = {1}, l = {44, 56}, m = "invokeSuspend", n = {"msgList"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $msgId;
        final /* synthetic */ String $omniTaskId;
        Object L$0;
        int label;
        final /* synthetic */ ObricTipOffDialogActivity this$0;

        /* JADX INFO: renamed from: com.obric.assistant.tipoff.ObricTipOffDialogActivity$onCreate$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.tipoff.ObricTipOffDialogActivity$onCreate$1$2", f = "ObricTipOffDialogActivity.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Message> $msgList;
            int label;

            public AnonymousClass2(List<Message> r1, Continuation<? super AnonymousClass2> r2) {
                this.$msgList = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.$msgList, r3);
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
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L11:
                FLogger.a.i("ObricTipOffDialogActivity", "generateListAndUploadFornaxToken finish");
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                FLogger.a.i("ObricTipOffDialogActivity", "generateListAndUploadFornaxToken start");
                int r6 = com.larus.security.api.g.a;
                List<Message> r7 = this.$msgList;
                this.label = 1;
                if (com.larus.security.api.g.b(r7, 7, this) != r0) goto L11;
                return r0;
            }
        }

        public AnonymousClass1(String r1, ObricTipOffDialogActivity r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$msgId = r1;
            this.this$0 = r2;
            this.$omniTaskId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$msgId, this.this$0, this.$omniTaskId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            DialogFragment r5 = null;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            List r3 = (List) this.L$0;
            ResultKt.throwOnFailure(r19);
            List r9 = r3;
        L25:
            ObricTipOffDialogActivity r4 = this.this$0;
            IObricTipOffService r6 = (IObricTipOffService) ServiceManager.get().getService(IObricTipOffService.class);
            if (r6 == null) goto L28;
            r5 = IObricTipOffService.a.a(r6, this.this$0.getSupportFragmentManager(), null, r9, false, null, this.$omniTaskId, null, null, null, null, 984);
        L28:
            r4.a = r5;
            DialogFragment r7 = this.this$0.a;
            if (r7 == null) goto L34;
            Lifecycle r8 = r7.getLifecycle();
            if (r8 == null) goto L34;
            final ObricTipOffDialogActivity r10 = this.this$0;
            r8.addObserver(new AnonymousClass3(r10));
        L34:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r19);
            Object r11 = r19;
        L15:
            Message r12 = (Message) r11;
        L17:
            List r13 = CollectionsKt.listOfNotNull(r12);
            if (r13.isEmpty() == false) goto L21;
            FLogger.a.w("ObricTipOffDialogActivity", "showOmniTaskFeedbackDialog: no msg is found");
            this.this$0.finish();
            return Unit.INSTANCE;
        L21:
            FLogger.a.i("ObricTipOffDialogActivity", "showOmniTaskFeedbackDialog: found msg list = " + CollectionsKt.joinToString$default(r13, null, null, null, 0, null, new f(), 31, null));
            CoroutineDispatcher r14 = Dispatchers.getIO();
            AnonymousClass2 r15 = new AnonymousClass2(r13, null);
            this.L$0 = r13;
            this.label = 2;
            if (BuildersKt.withContext(r14, r15, this) != r1) goto L24;
            return r1;
        L24:
            r9 = r13;
            goto L25
        L10:
            ResultKt.throwOnFailure(r19);
            IChatRepoService r16 = (IChatRepoService) ServiceManager.get().getService(IChatRepoService.class);
            if (r16 == null) goto L16;
            String r17 = this.$msgId;
            this.label = 1;
            r11 = r16.E1(r17, this);
            if (r11 != r1) goto L15;
            return r1;
        L16:
            r12 = null;
            goto L17
        }
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricTipOffDialogActivity.class.getName()));
    L5:
        super.onDestroy();
        FLogger.a.i("ObricTipOffDialogActivity", "onDestroy");
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ObricTipOffDialogActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map<Activity, Long> r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        DialogFragment r0 = this.a;
        if (r0 == null) goto L10;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L7;
        Lifecycle.State r2 = r1.getCurrentState();
    L9:
        if (r2 == Lifecycle.State.DESTROYED) goto L10;
    L12:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L23;
        View r3 = getWindow().getDecorView();     // Catch: Throwable -> L20
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L20
        Thread r4 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L20
        if (r4 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");     // Catch: Throwable -> L20
    L18:
        r3.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L20
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r2 = null;
    L10:
        FLogger.a.i("ObricTipOffDialogActivity", "tipOffDialogFragment is null, finish activity");
        finish();
        goto L12
    }

    public ObricTipOffDialogActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        v19.f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r9);
        String r10 = getIntent().getStringExtra("msg_id");
        String r0 = "";
        if (r10 != null) goto L13;
        r10 = "";
    L13:
        String r1 = getIntent().getStringExtra("omni_task_id");
        if (r1 == null) goto L17;
        r0 = r1;
    L17:
        FLogger.a.i("ObricTipOffDialogActivity", "msgId: ".concat(r10));
        if (r10.length() != 0) goto L20;
        boolean r2 = true;
    L21:
        if (r2 == false) goto L23;
        finish();
        return;
    L23:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(r10, this, r0, null), 3, null);
        return;
    L20:
        r2 = false;
        goto L21
    }
}
