package kha;

import android.app.Activity;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.view.Window;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.utils.k;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.debug.api.IObricDebugService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.storage.LowStorageBlockActivity;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.dialog.v2.alert.g;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final e a = null;
    public static long b;
    public static final AtomicLong c = null;
    public static final AtomicBoolean d = null;
    public static final AtomicBoolean e = null;
    public static final AtomicLong f = null;

    public e() {
    }

    static {
        a = new e();
        c = new AtomicLong(0);
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
        f = new AtomicLong(0);
    }

    @JvmStatic
    public static final boolean c() {
        long r3 = SystemClock.elapsedRealtime();
        if ((r3 - c.get()) < 1000) goto L5;
        e r5 = a;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L23
        long r7 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
        int r8 = k.a;     // Catch: Throwable -> L23
        StatFs r9 = new StatFs(Environment.getDataDirectory().getPath());     // Catch: Throwable -> L23
        b = r9.getBlockSizeLong() * r9.getAvailableBlocksLong();     // Catch: Throwable -> L23
        FLogger r10 = FLogger.a;     // Catch: Throwable -> L23
        StringBuilder r11 = new StringBuilder("isLowStorage: check  romAvailableSpace:");     // Catch: Throwable -> L23
        long r12 = b;     // Catch: Throwable -> L23
        r5.getClass();     // Catch: Throwable -> L23
        r11.append(f(r12));     // Catch: Throwable -> L23
        r11.append("MB, cost=");     // Catch: Throwable -> L23
        r11.append(SystemClock.elapsedRealtime() - r7);     // Catch: Throwable -> L23
        r11.append("ms");     // Catch: Throwable -> L23
        r10.d("LowStorageGuard", r11.toString());     // Catch: Throwable -> L23
        boolean r2 = false;
        if (b >= 524288000) goto L10;
        boolean r13 = true;
    L11:
        IObricDebugService r14 = (IObricDebugService) ServiceManager.get().getServiceForReal(IObricDebugService.class);     // Catch: Throwable -> L23
        if (r14 != null) goto L14;
    L16:
        boolean r15 = false;
    L17:
        r10.d("LowStorageGuard", "isLowStorage: realCheckResult=" + r13 + ", debugOpen=" + r15);     // Catch: Throwable -> L23
        if (r13 == true) goto L20;
        if (r15 == true) goto L20;
    L21:
        Object r1 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L23
    L25:
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L28;
        FLogger.a.w("LowStorageGuard", "isLowStorage error: " + r4.getMessage(), r4);
    L28:
        Boolean r0 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L31;
        r1 = r0;
    L31:
        boolean r16 = ((Boolean) r1).booleanValue();
        d.set(r16);
        c.set(r3);
        return r16;
    L20:
        r2 = true;
        goto L21
    L14:
        if (r14.b() != true) goto L16;
        r15 = true;
        goto L17
    L10:
        r13 = false;
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L5:
        return d.get();
    }

    public static void d() {
        f.set(0);
        e.set(false);
    }

    public static boolean g() {
    L2:
        long r0 = SystemClock.elapsedRealtime();
        AtomicLong r2 = f;
        long r3 = r2.get();
        if (r3 == Long.MAX_VALUE) goto L11;
        if (r3 > r0) goto L17;
        if (r2.compareAndSet(r3, r0 + 5000) == false) goto L2;
        return true;
    L17:
        return false;
    L11:
        return false;
    }

    public static com.obric.oui.dialog.v2.alert.c e(Activity r8) {
        String r1 = "activity";
        Intrinsics.checkNotNullParameter(r8, "activity");
        g r2 = new g(r8);
        r2.w = false;
        String r4 = r8.getString(2131912244);
        r2.j = false;
        r2.h = r4;
        r2.i = r8.getString(2131912243);
        r2.g(r8.getString(2131912242), new a(), ButtonStyleController.TextColorType.Negative);
        com.obric.oui.dialog.v2.alert.c r3 = r2.a();
        final d r5 = new d(r8);
        r3.setCancelable(false);
        r3.setCanceledOnTouchOutside(false);
        r3.setOnDismissListener(new b(r5));
        AppHost.a.a().e(r5);
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L28;
        DialogLancet.handleBlockedDialogShow(r3);
    L7:
        f.set(Long.MAX_VALUE);
        if ((r8 instanceof LowStorageBlockActivity) == false) goto L24;
        r1 = "window";
    L24:
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L13
        r6.put("available_space", b);     // Catch: Exception -> L13
        r6.put("show_from", r1);     // Catch: Exception -> L13
        TrackParams r7 = new TrackParams().merge(r6);     // Catch: Exception -> L13
        by7.a r9 = new by7.a("obric_low_storage_dialog_show");     // Catch: Exception -> L13
        r9.a.merge(r7);     // Catch: Exception -> L13
        r9.b();     // Catch: Exception -> L13
        FLogger.a.i("LowStorageGuard", "report dialog show success, params=" + r6);     // Catch: Exception -> L13
    L26:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L17
        a(r3, r8);     // Catch: Throwable -> L17
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L22;
        FLogger.a.w("LowStorageGuard", "configureDialogWindowForLockscreen failed: " + r12.getMessage(), r12);
    L22:
        return r3;
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        e = move-exception;
        FLogger.a.e("LowStorageGuard", "report dialog show failed", e);
        goto L26
    L28:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L6:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        goto L7
    }

    public static double f(long r8) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L4
        return CastDoubleProtector.parseDouble(String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r8 / 1048576)}, 1)));
    L4:
        e = move-exception;
        FLogger.a.e("LowStorageGuard", "toM num=" + r8 + " error " + e);
        return 0.0d;
    }

    public static void a(com.obric.oui.dialog.v2.alert.c r5, Activity r6) {
        boolean r0 = false;
        if ((r6 instanceof LowStorageBlockActivity) == false) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        return;
    L11:
        Window r8 = r5.getWindow();
        if (r8 == null) goto L30;
        a.getClass();
        if (Build.VERSION.SDK_INT >= 30) goto L28;
    L24:
        if (r0 == true) goto L26;
        r8.addFlags(UiType.FLAG_WIFI_QRCODE_CARD);
    L26:
        r8.addFlags(2097280);
        return;
    L28:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L18
        Method r10 = r8.getClass().getMethod("setInheritShowWhenLocked", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L18
        Boolean r2 = Boolean.TRUE;     // Catch: Throwable -> L18
        r10.invoke(r8, new Object[]{r2});     // Catch: Throwable -> L18
        Object r11 = Result.constructor-impl(r2);     // Catch: Throwable -> L18
    L20:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r11) == false) goto L23;
        r11 = r1;
    L23:
        r0 = ((Boolean) r11).booleanValue();
    L18:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L30:
        return;
    L5:
        if (KeyguardService.a.isKeyguardLocked() == true) goto L8;
        r7 = false;
        goto L9
    }

    public static void b(String r4, Function0 r5) {
        if (e.compareAndSet(false, true) == true) goto L6;
        FLogger.a.i("LowStorageGuard", "exitAppFromDialog: already triggered, trigger=".concat(r4));
        return;
    L6:
        FLogger.a.i("LowStorageGuard", "exitAppFromDialog: trigger=".concat(r4));
        d();
        if (r5 == null) goto L24;
        r5.invoke();
    L24:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        AppHost.a.a().k();     // Catch: Throwable -> L11
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L22;
        FLogger.a.w("LowStorageGuard", "finishAllActivitiesSafely failed: " + r8.getMessage(), r8);
    L22:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L19
        r0.put("exit_app_trigger", r4);     // Catch: Exception -> L19
        TrackParams r9 = new TrackParams().merge(r0);     // Catch: Exception -> L19
        by7.a r2 = new by7.a("obric_low_storage_dialog_close_app");     // Catch: Exception -> L19
        r2.a.merge(r9);     // Catch: Exception -> L19
        r2.b();     // Catch: Exception -> L19
        FLogger.a.i("LowStorageGuard", "report button click event success, params=" + r0);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        FLogger.a.e("LowStorageGuard", "report button click event failed", e);
        return;
    L11:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
