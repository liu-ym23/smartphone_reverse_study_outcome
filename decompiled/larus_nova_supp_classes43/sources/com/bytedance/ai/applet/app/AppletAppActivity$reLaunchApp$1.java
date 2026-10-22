package com.bytedance.ai.applet.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletAppActivity$reLaunchApp$1", f = "AppletAppActivity.kt", i = {0, 0, 0, 0}, l = {582, 616}, m = "invokeSuspend", n = {"$this$launch", "killApp", "launchUrl", "savedState"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class AppletAppActivity$reLaunchApp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AppletAppActivity this$0;

    public AppletAppActivity$reLaunchApp$1(AppletAppActivity r1, Continuation<? super AppletAppActivity$reLaunchApp$1> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletAppActivity$reLaunchApp$1 r0 = new AppletAppActivity$reLaunchApp$1(this.this$0, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
        ((Result) r15).unbox-impl();
    L75:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        AppletApplication$b r10 = (AppletApplication$b) this.L$3;
        String r11 = (String) this.L$2;
        AppletApplication r12 = (AppletApplication) this.L$1;
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
    L60:
        AppletApplication r16 = (AppletApplication) r15;
        if (r16 != null) goto L64;
        AppletAppActivity r17 = this.this$0;
        com.bytedance.ai.applet.base.log.d r14 = r17.c;
        String r18 = "reLaunchApp: applet " + r12.getAppId() + " is not found";
        AtomicInteger r19 = com.bytedance.ai.applet.base.log.d.d;
        r14.a(r18, null);
        r17.B1();
        return Unit.INSTANCE;
    L64:
        this.this$0.e = r16;
        JobKt.ensureActive(getContext());
        r16.x(r10);
        r16.r(this.this$0);
        if (this.this$0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L68;
        this.this$0.c.c("reLaunchApp: lifecycle is resumed, call onResume for new app");
        r16.y(this.this$0);
    L71:
        this.this$0.c.c("reLaunchApp: lifecycle is active, navigating to " + r11);
        ApplicationRouter r110 = r16.h().d();
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (r110.i(r11, null, this) != r0) goto L75;
        return r0;
    L68:
        if (this.this$0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L70;
        this.this$0.c.c("reLaunchApp: lifecycle is started but not resumed.");
        goto L71
    L70:
        this.this$0.c.c("reLaunchApp: lifecycle is stopped, call onStop for new app");
        r16.B(this.this$0);
        goto L71
    L10:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        AppletAppActivity r20 = this.this$0;
        r12 = r20.e;
        if (r12 != null) goto L14;
        com.bytedance.ai.applet.base.log.d r112 = r20.c;
        AtomicInteger r21 = com.bytedance.ai.applet.base.log.d.d;
        r112.a("reLaunchApp: app is null, cannot reLaunch app", null);
        return Unit.INSTANCE;
    L14:
        r20.c.c("reLaunchApp: " + r12.getAppId());
        if (this.this$0.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L18;
        this.this$0.c.a("reLaunchApp: lifecycle is not resumed, cannot reLaunch app", null);
        return Unit.INSTANCE;
    L18:
        Iterator r22 = this.this$0.getSupportFragmentManager().getFragments().iterator();
    L20:
        if (r22.hasNext() == false) goto L29;
        Object r23 = r22.next();
        Fragment r24 = (Fragment) r23;
        if (r24.getId() == 2131363104) goto L24;
    L26:
        boolean r25 = false;
    L27:
        if (r25 == false) goto L20;
    L30:
        Fragment r26 = (Fragment) r23;
        if (r26 == null) goto L35;
        String r27 = t2.b.c(r26);
        if (r27 == null) goto L35;
    L38:
        r12.B(this.this$0);
        AppletAppActivity r28 = this.this$0;
        r28.getSupportFragmentManager().popBackStackImmediate(null, 1);
        List r29 = r28.getSupportFragmentManager().getFragments();
        ArrayList r113 = new ArrayList();
        Iterator r30 = r29.iterator();
    L40:
        if (r30.hasNext() == false) goto L50;
        Object r114 = r30.next();
        Fragment r115 = (Fragment) r114;
        if (r115.getId() == 2131363104) goto L44;
    L46:
        boolean r116 = false;
    L47:
        if (r116 == false) goto L40;
        r113.add(r114);
        goto L40
    L44:
        if (r115.isAdded() == false) goto L46;
        r116 = true;
        goto L47
    L50:
        if ((!r113.isEmpty()) == false) goto L56;
        FragmentTransaction r31 = r28.getSupportFragmentManager().beginTransaction();
        Iterator r32 = r113.iterator();
    L53:
        if (r32.hasNext() == false) goto L55;
        r31.remove((Fragment) r32.next());
        goto L53
    L55:
        r31.commitNowAllowingStateLoss();
    L56:
        r28.D1();
        r28.i = null;
        r28.g = false;
        r28.h = null;
        AppletApplication$b r33 = new AppletApplication$b();
        r12.z(r33);
        r12.u(this.this$0);
        r12.g();
        AppletAppActivity r34 = this.this$0;
        r34.e = null;
        r34.c.c("reLaunchApp: create new app");
        AppletAppManagerService r35 = AppletAppManagerService.INSTANCE;
        String r36 = r12.getAppId();
        this.L$0 = r111;
        this.L$1 = r12;
        this.L$2 = r27;
        this.L$3 = r33;
        this.label = 1;
        r15 = r35.d(r36, this);
        if (r15 != r0) goto L59;
        return r0;
    L59:
        r11 = r27;
        r10 = r33;
    L35:
        r27 = r12.j().O;
        if (StringsKt.isBlank(r27) == false) goto L38;
        r27 = "index";
        goto L38
    L24:
        if (r24.isAdded() == false) goto L26;
        r25 = true;
        goto L27
    L29:
        r23 = null;
        goto L30
    }
}
