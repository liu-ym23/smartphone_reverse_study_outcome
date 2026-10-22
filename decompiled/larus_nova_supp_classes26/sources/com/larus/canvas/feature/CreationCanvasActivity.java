package com.larus.canvas.feature;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.canvas.feature.redirect.DirectJump2ImageRemoveHelper;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
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
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0014J\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u001a\u001a\u00020\u0012X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0012X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006!"}, d2 = {"Lcom/larus/canvas/feature/CreationCanvasActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "fg", "Lcom/larus/canvas/feature/CreationCanvasFragment;", "useAlbumExitFlow", "", "getUseAlbumExitFlow", "()Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getBackgroundResource", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "onBackPressed", "finishEnterAnimRes", "getFinishEnterAnimRes", "()I", "finishExitAnimRes", "getFinishExitAnimRes", "finish", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CreationCanvasActivity extends FlowCommonAppCompatActivity {
    public final CreationCanvasFragment g;
    public final int h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.canvas.feature.CreationCanvasActivity$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.CreationCanvasActivity$onCreate$2", f = "CreationCanvasActivity.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationCanvasActivity this$0;

        public AnonymousClass2(CreationCanvasActivity r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [android.app.Activity, com.larus.canvas.feature.CreationCanvasActivity] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            INVOKEVIRTUAL_com_larus_canvas_feature_CreationCanvasActivity$onCreate$2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(this.this$0.getSupportFragmentManager().beginTransaction(), 2131373275, this.this$0.g).commitNowAllowingStateLoss();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DirectJump2ImageRemoveHelper r6 = DirectJump2ImageRemoveHelper.a;
            ?? r2 = this.this$0;
            Intent r3 = r2.getIntent();
            this.label = 1;
            if (r6.b(r2, r3, this) != r0) goto L11;
            return r0;
        }

        public static FragmentTransaction INVOKEVIRTUAL_com_larus_canvas_feature_CreationCanvasActivity$onCreate$2_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_replace(FragmentTransaction r2, int r3, Fragment r4) {
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == false) goto L6;
            return r2;
        L6:
            return r2.replace(r3, r4);
        }
    }

    static {
    }

    public final boolean K1() {
        return false;
    }

    public boolean P1() {
        return false;
    }

    public final boolean H1() {
        return !ObricChatUIDelegate.b.m();
    }

    public final void onBackPressed() {
        CreationCanvasFragment r0 = this.g;
        r0.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new CreationCanvasFragment$onBackPressed$1(r0, null), 3, null);
    }

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public CreationCanvasActivity() {
        this.g = new CreationCanvasFragment();
        this.h = 2130772402;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int C1() {
        return v19.c.b(2130970531, this, 2131102535);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0110 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        overridePendingTransition(0, O1());
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public int O1() {
        return this.h;
    }

    public static View N1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r11) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r11);
        setContentView(2131561787);
        Window r12 = getWindow();
        if (r12 == null) goto L13;
        View r13 = N1(r12);
    L14:
        setRootView(r13);
        L1();
        CreationCanvasFragment r14 = this.g;
        Bundle r1 = new Bundle();
        Bundle r2 = getIntent().getExtras();
        if (r2 == null) goto L17;
        r1.putAll(r2);
    L17:
        r1.putBoolean("use_album_exit_flow", P1());
        r14.setArguments(r1);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(this, null), 2, null);
        if (ObricChatUIDelegate.b.m() == true) goto L27;
        Window r15 = getWindow();
        if (r15 == null) goto L28;
        View r16 = N1(r15);
        if (r16 == null) goto L29;
        int r0 = u.b(this);
        int r3 = r16.getPaddingStart();
        int r4 = r16.getPaddingTop();
        int r5 = r16.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r16.getClass().getSimpleName() + ",source:CreationCanvasActivity,start:" + r3 + ",top:" + r4 + ",end:" + r5 + ",bottom:" + r0);
        r16.setPaddingRelative(r3, r4, r5, r0);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r13 = null;
        goto L14
    }

    public final void onSaveInstanceState(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "outState");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        super.onSaveInstanceState(r4);     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L14;
        FLogger.a.e("CreationCanvasActivity", " onSaveInstanceState error", r6);
        finish();
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void onActivityResult(int r11, int r12, Intent r13) {
        super.onActivityResult(r11, r12, r13);
        CreationCanvasFragment r1 = this.g;
        r1.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1), null, null, new CreationCanvasFragment$onResult$1(r1, r11, r12, r13, null), 3, null);
    }
}
