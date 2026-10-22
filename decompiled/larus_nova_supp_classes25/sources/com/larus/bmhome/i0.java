package com.larus.bmhome;

import android.app.Application;
import android.app.KeyguardManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.presentation.UiPresentationChannel;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hq9.n3;
import hq9.p3;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nr8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 {
    public static final i0 a = null;
    public static volatile boolean b;
    public static WeakReference<b> c;
    public static String d;
    public static final CopyOnWriteArraySet<p3> e = null;

    public static final class a implements nr8.s {
        public final /* synthetic */ int a;
        public final /* synthetic */ i0 b;
        public final /* synthetic */ b c;
        public final /* synthetic */ n3 d;

        public final void a() {
            FLogger.a.i("NotificationControlManager", "system window dialog detached, windowType=" + this.a);
            i0.b(this.b, this.c, 2);
            Function0 r0 = this.d.t;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        public a(int r1, i0 r2, b r3, n3 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public i0() {
    }

    static {
        a = new i0();
        e = new CopyOnWriteArraySet();
    }

    public static void a(b r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static boolean c(final n3 r9) {
        AppCompatActivity r0 = r9.p;
        if (r0 != null) goto L5;
        AppHost.Companion r1 = AppHost.a;
        if ((r1.a().getCurrentActivity() instanceof AppCompatActivity) == true) goto L11;
        return false;
    L11:
        AppCompatActivity r2 = r1.a().getCurrentActivity();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        final AppCompatActivity r3 = r2;
    L12:
        String r4 = "";
        if ((r3 instanceof FlowCommonAppCompatActivity) == false) goto L15;
        String r5 = ((FlowCommonAppCompatActivity) r3).k();
    L16:
        List r6 = r9.i;
        if (r6 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == true) goto L33;
        List r8 = r9.i;
        if (r8 != null) goto L27;
    L29:
        boolean r10 = false;
    L30:
        if (r10 == true) goto L33;
        boolean r11 = false;
    L88:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L53
        if (StringsKt.isBlank(r5) == false) goto L51;
        if (r11 == true) goto L51;
        if ((!r3.getSupportFragmentManager().getFragments().isEmpty()) == false) goto L51;
        Fragment r13 = (Fragment) ListProtector.get(r3.getSupportFragmentManager().getFragments(), 0);     // Catch: Throwable -> L53
        if ((!r13.getChildFragmentManager().getFragments().isEmpty()) == false) goto L51;
        com.larus.trace.tracknode.a r14 = (Fragment) ListProtector.get(r13.getChildFragmentManager().getFragments(), 0);     // Catch: Throwable -> L53
        if ((r14 instanceof com.larus.trace.tracknode.a) == false) goto L44;
        com.larus.trace.tracknode.a r15 = r14;     // Catch: Throwable -> L53
    L45:
        if (r15 == null) goto L50;
        String r16 = r15.k();     // Catch: Throwable -> L53
        if (r16 == null) goto L50;
        r4 = r16;
    L50:
        r5 = r4;
        goto L51
    L44:
        r15 = null;
    L51:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L58;
        FLogger.a.i("NotificationControlManager", "error: " + r18.getMessage());
    L58:
        boolean r19 = AppHost.a.a().isAppBackground();
        if (r9.q == true) goto L78;
        List r20 = r9.i;
        if (r20 != null) goto L64;
    L67:
        boolean r21 = true;
    L68:
        if (r21 == true) goto L78;
        List r22 = r9.i;
        if (r22 != null) goto L72;
    L74:
        boolean r23 = false;
    L75:
        if (r23 == true) goto L78;
        boolean r24 = false;
    L79:
        if (r19 == false) goto L81;
    L87:
        return false;
    L81:
        if (r3.isFinishing() == true) goto L87;
        if (r3.isDestroyed() == true) goto L87;
        if (r24 == false) goto L87;
        a.getClass();
        FLogger.a.i("NotificationControlManager", "buildNotificationAndShow, type " + r9.getType() + ", business:" + r9.h);
        t0.a.post(new f0(r3, r9));
        return true;
    L72:
        if (r22.contains(r5) != true) goto L74;
        r23 = true;
        goto L75
    L64:
        if (r20.isEmpty() == true) goto L67;
        r21 = false;
    L78:
        r24 = true;
    L53:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L27:
        if (r8.contains(r5) != true) goto L29;
        r10 = true;
    L33:
        r11 = true;
        goto L88
    L19:
        if (r6.isEmpty() == true) goto L22;
        r7 = false;
        goto L23
    L15:
        r5 = "";
        goto L16
    L5:
        if ((r0 instanceof AppCompatActivity) == true) goto L7;
        return false;
    L7:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        r3 = r0;
        goto L12
    }

    public static boolean d(final n3 r9) {
        if (r9.s == true) goto L6;
        FLogger.a.i("NotificationControlManager", "triggerSystemWindowFallback skipped, disabled, type=" + r9.getType() + ", business=" + r9.h);
        return false;
    L6:
        final Application r0 = AppHost.a.getApplication();
        Object r4 = r0.getSystemService("keyguard");
        if ((r4 instanceof KeyguardManager) == false) goto L9;
        KeyguardManager r5 = (KeyguardManager) r4;
    L11:
        if (r5 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L18;
    L23:
        if (r6 == false) goto L26;
        final int r3 = 2009;
    L29:
        FLogger.a.i("NotificationControlManager", "triggerSystemWindowFallback, isKeyguardLocked=" + r6 + ", windowType=" + r3 + ", type=" + r9.getType() + ", business=" + r9.h);
        t0.a.post(new e0(r9, r0, r3));
        return true;
    L26:
        if (Build.VERSION.SDK_INT < 26) goto L28;
        r3 = 2038;
        goto L29
    L28:
        r3 = 2002;
        goto L29
    L18:
        if (Build.VERSION.SDK_INT < 23) goto L23;
        if (Settings.canDrawOverlays(r0) == true) goto L23;
        FLogger.a.w("NotificationControlManager", "triggerSystemWindowFallback skipped, overlay permission denied, type=" + r9.getType() + ", business=" + r9.h);
        return false;
    L13:
        if (r5.isKeyguardLocked() != true) goto L15;
        r6 = true;
        goto L16
    L9:
        r5 = null;
        goto L11
    }

    public static void b(i0 r4, b r5, int r6) {
        String r1 = null;
        if ((r6 & 1) == 0) goto L5;
        r5 = null;
    L5:
        boolean r0 = false;
        if ((r6 & 2) == 0) goto L8;
        boolean r7 = true;
    L9:
        monitor-enter(r4);
        if (r5 == null) goto L18;
        WeakReference<b> r3 = c;     // Catch: Throwable -> L39
        if (r3 == null) goto L14;
        b r8 = r3.get();     // Catch: Throwable -> L39
    L15:
        if (r8 == r5) goto L18;
    L21:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(r4);
        if (r0 == false) goto L38;
        if (r1 == null) goto L26;
        n19.a.a.e(UiPresentationChannel.LEGACY_ACTIVITY_NOTIFICATION, r1);
    L26:
        if (r7 == false) goto L51;
        Iterator<p3> r10 = e.iterator();
    L29:
        if (r10.hasNext() == false) goto L52;
        p3 r11 = r10.next();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L33
        r11.a();     // Catch: Throwable -> L33
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L29;
        FLogger.a.e("NotificationControlManager", "notify slot idle failed", r14);
    L33:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L52:
        return;
    L51:
        return;
    L38:
        return;
    L14:
        r8 = null;
    L39:
        th = move-exception;
        throw th;
    L18:
        if (b == false) goto L21;
        b = false;     // Catch: Throwable -> L39
        c = null;     // Catch: Throwable -> L39
        String r16 = d;     // Catch: Throwable -> L39
        d = null;     // Catch: Throwable -> L39
        r1 = r16;
        r0 = true;
        goto L21
    L8:
        r7 = false;
        goto L9
    }
}
