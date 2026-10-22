package com.obric.assistant.util;

import android.R;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.api.AppletService;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.home.obric.ObricChatActivity;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.spi.notification.IObricNotificationIslandService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OrionChatExtensionUtils implements jga.a, IObserveToken {
    public final String a;
    public final String[] b;
    public String c;
    public OrionChatExtensionUtils$onBeforeCreate$2 d;
    public int e;
    public final AtomicBoolean f;
    public final l2 g;
    public final Lazy h;
    public final k2 i;
    public final j2 j;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[KeyguardLockedState.values().length];
            r0[KeyguardLockedState.LOCKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[KeyguardLockedState.UNLOCKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // jga.a
    public final void a(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // jga.a
    public final void d(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public OrionChatExtensionUtils(ObricChatActivity r8) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        this.a = OrionChatExtensionUtils.class.getSimpleName();
        this.b = new String[]{"arg_launch_floating_window", "arg_launch_half_screen", "obric_need_translucent", "all_search", "launch_from_agent", "agent_window_state"};
        this.c = "";
        this.e = AppHost.a.getApplication().getResources().getConfiguration().orientation;
        this.f = new AtomicBoolean(false);
        this.g = new l2(this);
        this.h = LazyKt.lazy(new i2());
        this.i = new k2();
        new WeakReference(r8);
        this.j = new j2(this);
    }

    public static final void l(OrionChatExtensionUtils r6) {
        r6.getClass();
        Object r7 = AppHost.a.getApplication().getSystemService("notification");
        List<String> r1 = null;
        if ((r7 instanceof NotificationManager) == false) goto L5;
        NotificationManager r8 = (NotificationManager) r7;
    L6:
        if (r8 == null) goto L38;
        AppletService r0 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r0 == null) goto L10;
        List r2 = r0.d();
    L11:
        IObricNotificationIslandService r3 = (IObricNotificationIslandService) ServiceManager.get().getService(IObricNotificationIslandService.class);
        if (r3 == null) goto L14;
        r1 = r3.a();
    L14:
        if (r2 != null) goto L16;
        r2 = CollectionsKt.emptyList();
    L16:
        List r4 = r2;
        if (r1 != null) goto L19;
        r1 = CollectionsKt.emptyList();
    L19:
        List r5 = CollectionsKt.distinct(CollectionsKt.plus(r4, r1));
        if (r5.isEmpty() == false) goto L23;
        r8.cancelAll();
        return;
    L23:
        if (Build.VERSION.SDK_INT >= 26) goto L26;
        r8.cancelAll();
        return;
    L26:
        if ((!r5.isEmpty()) == false) goto L33;
        StatusBarNotification[] r9 = r8.getActiveNotifications();
        Intrinsics.checkNotNull(r9);
        int r10 = r9.length;
        int r11 = 0;
    L28:
        if (r11 >= r10) goto L41;
        StatusBarNotification r12 = r9[r11];
        if (r5.contains(r12.getNotification().getChannelId()) == true) goto L32;
        r8.cancel(r12.getId());
    L32:
        r11 = r11 + 1;
        goto L28
    L41:
        return;
    L33:
        r8.cancelAll();
        return;
    L10:
        r2 = null;
        goto L11
    L38:
        return;
    L5:
        r8 = null;
        goto L6
    }

    public static Fragment m(FragmentActivity r1) {
        return r1.getSupportFragmentManager().findFragmentById(2131373275);
    }

    public static laa.d n(FragmentActivity r1) {
        Fragment r2 = m(r1);
        if (r2 == null) goto L7;
        t1a.b r3 = s1a.a.g(r2);
        if (r3 == null) goto L7;
        return r3.getAbility(laa.d.class);
    L7:
        return null;
    }

    public static boolean o(Intent r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L18;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r3.getBooleanExtra("obric_need_translucent", false) != true) goto L13;
        r4 = true;
        goto L14
    L18:
        return true;
    L5:
        if (r3.getBooleanExtra("arg_launch_floating_window", false) != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // jga.a
    public final void b(FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        FLogger.a.i(this.a, "onDestroy, hashCode: " + hashCode());
        OrionChatExtensionUtils$onBeforeCreate$2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("screenReceiver");
        r0 = null;
    L5:
        ReceiverRegisterLancet.loge(r0, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L24;
        r5.unregisterReceiver(r0);
    L16:
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveInteractionKeyguardLockedState(this);
        KeyguardService.a.unregisterDismissKeyguardChangedListener(this.g);
        AppHost.a.a().c(this.j);
        Fragment r6 = m(r5);
        if (r6 == null) goto L26;
        t1a.b r7 = s1a.a.g(r6);
        if (r7 == null) goto L27;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r8 = r7.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r8 == null) goto L28;
        r8.K8(this.i);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L24:
    L11:
        e = move-exception;
        if (r0 == null) goto L14;
        Npth.addTag("unregisterReceiver", r0.toString());
    L14:
        e.printStackTrace();
        goto L16
    L8:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r0, r5) == false) goto L16;
        r5.unregisterReceiver(r0);     // Catch: Exception -> L11
        goto L16
    }

    @Override // jga.a
    public final Integer e(Intent r1) {
        if (o(r1) == true) goto L5;
        return null;
    L5:
        return 2131103786;
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.assistant.util.g2] */
    @Override // jga.a
    public final void g(FragmentActivity r8) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        boolean r0 = IKeyguardStateKt.getKeyguardState().isKeyguardLocked();
        Fragment r1 = m(r8);
        if (r1 == null) goto L7;
        t1a.b r2 = s1a.a.g(r1);
        if (r2 == null) goto L7;
        maa.e r3 = (maa.e) r2.getAbility(maa.e.class);
    L8:
        FLogger.a.i(this.a, "onResume, hashCode: " + hashCode() + ", isKeyguardLocked: " + r0 + ", isDismissFailed: " + this.f + ", currentKeyguardLockedTime: " + IKeyguardStateKt.getKeyguardState().getKeyguardLockTime() + ", isNeedUpdatePageState: " + ObricInteractDelegate.b.isNeedUpdatePageState() + ", intent.extras: " + r8.getIntent().getExtras());
        if (r3 == null) goto L11;
        r3.XB(new g2(this));
    L11:
        Fragment r9 = m(r8);
        if (r9 == null) goto L19;
        t1a.b r10 = s1a.a.g(r9);
        if (r10 == null) goto L20;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r11 = r10.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r11 == null) goto L21;
        r11.A4(this.i);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // jga.a
    public final void h(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        FLogger.a.i(this.a, "finish");
    }

    @Override // jga.a
    public final boolean i(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        laa.d r3 = n(r2);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.JY() != true) goto L7;
        return true;
    }

    @Override // jga.a
    public final boolean k(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        laa.d r3 = n(r2);
        if (r3 == null) goto L9;
        ObricFloatChatPageState r4 = r3.getPageState();
        if (r4 == null) goto L9;
        ObricFloatChatPageData.Companion.getClass();
        if ((r4 instanceof vda.b) != true) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.obric.assistant.util.OrionChatExtensionUtils$onBeforeCreate$2] */
    @Override // jga.a
    public final void c(final FragmentActivity r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        ObricInteractDelegate.b.notifyRelaunchEvent(r14);
        Intent r0 = r13.getIntent();
        if (r0 != null) goto L6;
    L11:
        Object r1 = r13.getSystemService("keyguard");
        if ((r1 instanceof KeyguardManager) == false) goto L14;
        KeyguardManager r2 = (KeyguardManager) r1;
    L14:
        Iterator r3 = AppHost.a.a().g().iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        Object r4 = r3.next();
        if (com.obric.assistant.chat.p.e((Activity) r4) == false) goto L16;
    L21:
        Activity r5 = (Activity) r4;
        FLogger r6 = FLogger.a;
        r6.i(this.a, "chatActivityInStack, " + r5 + ", " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked() + ", " + r13.hashCode());
        if (r5 == null) goto L29;
        if (r5.isFinishing() == true) goto L29;
        if (r5.isDestroyed() == true) goto L29;
        r6.w(this.a, "chatActivityInStack is already in stack, " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
    L29:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L38;
        if (AccountService.a.isLogin().booleanValue() == false) goto L38;
        if (com.obric.assistant.t1.a.i() == false) goto L38;
        if (Build.VERSION.SDK_INT < 27) goto L40;
        r6.i(this.a, "setShowWhenLocked");
        r13.setShowWhenLocked(true);
        r13.setTurnScreenOn(true);
    L40:
        r6.i(this.a, "onBeforeCreate, isKeyguardLocked: " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked() + ", isRelaunch: " + r14 + ", previousKeyguardLockedTime: " + IKeyguardStateKt.getKeyguardState().getKeyguardLockTime());
        IAssistantInteractionServiceKt.getInteractionStateService().observeInteractionKeyguardLockedState(this, new h2(this, r13));
        this.d = new OrionChatExtensionUtils$onBeforeCreate$2(this, r13);
        IntentFilter r7 = new IntentFilter();
        r7.addAction("android.intent.action.SCREEN_OFF");
        r7.addAction("android.intent.action.SCREEN_ON");
        OrionChatExtensionUtils$onBeforeCreate$2 r8 = this.d;
        if (r8 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("screenReceiver");
        r8 = null;
    L44:
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L73;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L73:
    L61:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L72;
        ReceiverRegisterCrashOptimizer.registerReceiver(r8, r7, "android.permission.WRITE_SETTINGS", null);
    L65:
        if (r14 == true) goto L67;
        return;
    L67:
        if (r13.getIntent().hasExtra("arg_launch_floating_window") == false) goto L79;
        r13.getIntent().removeExtra("arg_launch_floating_window");
        if (r13.getIntent().hasExtra("obric_need_translucent") == true) goto L80;
        r13.getIntent().putExtra("obric_need_translucent", true);
        return;
    L80:
        return;
    L79:
        return;
    L72:
        throw e;
    L47:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L49;
    L59:
        r13.registerReceiver(r8, r7, "android.permission.WRITE_SETTINGS", null);     // Catch: Exception -> L61
        goto L65
    L49:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r7) == false) goto L59;
        int r9 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r8, r7, 0, "android.permission.WRITE_SETTINGS", null, 4, r13).result;     // Catch: Exception -> L61
        if (r9 != 1) goto L53;
        r13.registerReceiver(r8, r7, "android.permission.WRITE_SETTINGS", null);     // Catch: Exception -> L61
        goto L65
    L53:
        if (r9 != 2) goto L55;
        new Intent();     // Catch: Exception -> L61
        goto L65
    L55:
        if (r9 == 3) goto L65;
        r13.registerReceiver(r8, r7, "android.permission.WRITE_SETTINGS", null);     // Catch: Exception -> L61
    L38:
        if (Build.VERSION.SDK_INT < 27) goto L40;
        r6.i(this.a, "setShowWhenLocked false");
        r13.setShowWhenLocked(false);
        goto L40
    L20:
        r4 = null;
        goto L21
    L6:
        if (r0.getBooleanExtra("argument_restore_full_screen_on_recreate", false) != true) goto L11;
        String[] r10 = this.b;
        int r11 = r10.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        r0.removeExtra(r10[r12]);
        r12 = r12 + 1;
        goto L9
    }

    @Override // jga.a
    public final void j(FragmentActivity r2, Configuration r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        laa.d r4 = n(r2);
        int r5 = r3.orientation;
        if (r5 == this.e) goto L8;
        this.e = r5;
        if (r4 == null) goto L9;
        r4.refresh();
        return;
    L9:
        return;
    }

    @Override // jga.a
    public final void f(FragmentActivity r6, Bundle r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        r6.overridePendingTransition(0, 0);
        if (r8 == null) goto L9;
        if (r7 == null) goto L6;
        r7.remove("arg_wakeup");
    L6:
        if (r7 == null) goto L9;
        r7.remove("arg_wakeup_not_auto_reset");
    L9:
        if (o(r6.getIntent()) == false) goto L22;
        Window r0 = r6.getWindow();
        if (r0 == null) goto L19;
        View r1 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L17;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L17;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L17:
        if (r1 == null) goto L19;
        r1.setBackgroundColor(r6.getResources().getColor(R.color.transparent));
    L19:
        Window r9 = r6.getWindow();
        if (r9 == null) goto L22;
        r9.setBackgroundDrawableResource(R.color.transparent);
    L22:
        FLogger.a.i(this.a, "onCreate, hashCode: " + hashCode() + ", savedInstanceState: " + r8 + ", extras: " + r7);
        KeyguardService.a.registerDismissKeyguardChangedListener(this.g);
        AppHost.a.a().j(this.j);
    }
}
