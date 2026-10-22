package com.larus.shortcuts.impl.pin;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.crash.Npth;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.u;
import com.larus.shortcuts.impl.ShortcutCommonUtil;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import t19.s;
import v19.j5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class PinShortcutProcess {
    public static final /* synthetic */ int h = 0;
    public final tw9.a a;
    public final JSONObject b;
    public volatile int c;
    public final PinShortcutLifecycleObserver d;
    public ShortcutStatusReceiver e;
    public long f;
    public boolean g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/larus/shortcuts/impl/pin/PinShortcutProcess$PinShortcutLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "(Lcom/larus/shortcuts/impl/pin/PinShortcutProcess;)V", "onPause", "", "onResume", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class PinShortcutLifecycleObserver implements LifecycleObserver {
        public final /* synthetic */ PinShortcutProcess a;

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public final void onPause() {
            this.a.c = 1;
            this.a.f = AppHost.a.getAppClock().currentTimeMillis();
            FLogger.a.i("PinShortcutUtil", this + ", page onpause, currentTime: " + this.a.f);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            AppHost.Companion r0 = AppHost.a;
            long r1 = r0.getAppClock().currentTimeMillis();
            PinShortcutProcess r3 = this.a;
            long r4 = r3.f;
            long r2 = r1 - r4;
            if (r4 > 0) goto L5;
        L7:
            if (r4 > 0) goto L9;
        L16:
            this.a.f = -1;
            FLogger.a.i("PinShortcutUtil", this + ", page onResume, currentTime: " + r0.getAppClock().currentTimeMillis());
            return;
        L9:
            if (r2 <= 1000) goto L16;
            FLogger.a.i("PinShortcutUtil", this + ", >1000L");
            this.a.getClass();
            FragmentActivity r5 = PinShortcutProcess.d();
            if (r5 == null) goto L15;
            Lifecycle r6 = r5.getLifecycle();
            if (r6 == null) goto L15;
            r6.removeObserver(this.a.d);
        L15:
            PinShortcutProcess r7 = this.a;
            r7.e(r7.a, r7.b, false);
            goto L16
        L5:
            if (r2 >= 100) goto L7;
            r3.c = 0;
            FLogger.a.i("PinShortcutUtil", this + ", <100L");
            goto L16
        }

        public PinShortcutLifecycleObserver(PinShortcutProcess r1) {
            this.a = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/shortcuts/impl/pin/PinShortcutProcess$ShortcutStatusReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/larus/shortcuts/impl/pin/PinShortcutProcess;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public final class ShortcutStatusReceiver extends BroadcastReceiver {
        public static final /* synthetic */ int b = 0;
        public final /* synthetic */ PinShortcutProcess a;

        public ShortcutStatusReceiver(PinShortcutProcess r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r5, Intent r6) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("onReceive: ");
            String r2 = null;
            if (r6 == null) goto L5;
            String r3 = r6.getAction();
        L6:
            r1.append(r3);
            r0.i("PinShortcutUtil", r1.toString());
        L31:
            e = move-exception;
            FLogger.a.i("PinShortcutUtil", "Receive onException: " + e.getMessage());
            return;
        L8:
            if (this.a.g == false) goto L14;
            StringBuilder r4 = new StringBuilder("has accept receive: ");     // Catch: Exception -> L31
            if (r6 == null) goto L12;
            r2 = r6.getAction();     // Catch: Exception -> L31
        L12:
            r4.append(r2);     // Catch: Exception -> L31
            r0.i("PinShortcutUtil", r4.toString());     // Catch: Exception -> L31
            return;
        L14:
            t0.a.postDelayed(new com.larus.shortcuts.impl.pin.b(), 500);     // Catch: Exception -> L31
            this.a.g(AppHost.a.getApplication());     // Catch: Exception -> L31
            this.a.getClass();     // Catch: Exception -> L31
            FragmentActivity r7 = PinShortcutProcess.d();     // Catch: Exception -> L31
            if (r7 == null) goto L19;
            Lifecycle r8 = r7.getLifecycle();     // Catch: Exception -> L31
            if (r8 == null) goto L19;
            r8.removeObserver(this.a.d);     // Catch: Exception -> L31
        L19:
            PinShortcutProcess r9 = this.a;     // Catch: Exception -> L31
            r9.g = true;     // Catch: Exception -> L31
            r9.c = 1;     // Catch: Exception -> L31
            if (r6 == null) goto L37;
            Bundle r10 = r6.getExtras();     // Catch: Exception -> L31
            if (r10 == null) goto L38;
            String r11 = r10.getString("event_params");     // Catch: Exception -> L31
            if (r11 == null) goto L39;
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L27
            tx9.c.b(Boolean.TRUE, new JSONObject(r11));     // Catch: Throwable -> L27
            Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L29:
            Result.box-impl(r13);     // Catch: Exception -> L31
            return;
        L27:
            th = move-exception;
            Result.Companion r14 = Result.Companion;     // Catch: Exception -> L31
            r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L31
            goto L29
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class a {
    }

    public static final class b implements u {
        public final /* synthetic */ PinShortcutProcess a;
        public final /* synthetic */ JSONObject b;

        public final void cancel() {
            this.a.getClass();
            FragmentActivity r0 = PinShortcutProcess.d();
            if (r0 == null) goto L7;
            Lifecycle r1 = r0.getLifecycle();
            if (r1 == null) goto L7;
            r1.removeObserver(this.a.d);
        L7:
            this.a.getClass();
            FragmentActivity r2 = PinShortcutProcess.d();
            if (r2 == null) goto L12;
            Lifecycle r3 = r2.getLifecycle();
            if (r3 == null) goto L12;
            r3.addObserver(this.a.d);
        L12:
            this.a.getClass();
            FragmentActivity r4 = PinShortcutProcess.d();
            if (r4 == null) goto L64;
            String r5 = com.larus.shortcuts.impl.pin.a.a;
            Intrinsics.checkNotNullParameter(r4, "context");
            String r6 = com.larus.shortcuts.impl.pin.a.a;
            boolean r7 = false;
            if (StringsKt.contains$default(r6, "xiaomi", false, 2, null) == false) goto L36;
            String r8 = DeviceUtils.getSystemProperty("ro.miui.ui.version.name");
            if (TextUtils.isEmpty(r8) == false) goto L19;
        L34:
            Intent r9 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            r9.putExtra("extra_pkgname", r4.getPackageName());
        L68:
            r9.putExtra("start_only_for_android", true);     // Catch: Exception -> L60
            r4.startActivity(r9);     // Catch: Exception -> L60
        L60:
            r4.startActivity(com.larus.shortcuts.impl.pin.a.e(r4));     // Catch: Exception -> L62
        L62:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
            FLogger.a.e("ShortcutPermissionUtil", "goSettingPage error, " + e.getMessage());
            goto L64
        L19:
            if (StringsKt.contains$default(r8, "V7", false, 2, null) == true) goto L34;
            if (StringsKt.contains$default(r8, "V8", false, 2, null) == true) goto L34;
            if (TextUtils.isEmpty(r8) == false) goto L26;
        L33:
            r9 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            r9.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
            r9.putExtra("extra_pkgname", r4.getPackageName());
            goto L68
        L26:
            if (StringsKt.contains$default(r8, "V9", false, 2, null) == true) goto L33;
            if (StringsKt.contains$default(r8, "V10", false, 2, null) == true) goto L33;
            if (StringsKt.contains$default(r8, "V11", false, 2, null) == true) goto L33;
            r9 = com.larus.shortcuts.impl.pin.a.e(r4);
            goto L68
        L36:
            if (StringsKt.contains$default(r6, "oppo", false, 2, null) == false) goto L44;
            r9 = new Intent();
            r9.putExtra("packageName", r4.getPackageName());
            r9.setClassName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity");
            if (r4.getPackageManager().queryIntentActivities(r9, 65536).size() <= 0) goto L40;
            r7 = true;
        L40:
            if (r7 == true) goto L68;
            r9.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
            goto L68
        L44:
            if (StringsKt.contains$default(r6, "vivo", false, 2, null) == false) goto L52;
            r9 = new Intent();
            r9.putExtra("packagename", r4.getPackageName());
            r9.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
            if (r4.getPackageManager().queryIntentActivities(r9, 65536).size() <= 0) goto L48;
            r7 = true;
        L48:
            if (r7 == true) goto L68;
            r9.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
            goto L68
        L52:
            if (StringsKt.contains$default(r6, "meizu", false, 2, null) == true) goto L54;
            r9 = com.larus.shortcuts.impl.pin.a.e(r4);
            goto L68
        L54:
            if (Build.VERSION.SDK_INT < 24) goto L56;
            r9 = com.larus.shortcuts.impl.pin.a.e(r4);
            goto L68
        L56:
            r9 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            r9.putExtra("packageName", r4.getPackageName());
            r9.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        L64:
            JSONObject r10 = this.b;
            if (r10 == null) goto L71;
            Intrinsics.checkNotNullParameter(r10, "params");
            TrackParams r11 = new TrackParams().merge(r10);
            by7.a r12 = new by7.a("add_shortcut_toast_click");
            r12.a.merge(r11);
            r12.b();
            return;
        }

        public b(PinShortcutProcess r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public static FragmentActivity d() {
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final void f(JSONObject r7) {
        FragmentActivity r0 = d();
        if (r0 == null) goto L26;
        FragmentManager r1 = r0.getSupportFragmentManager();
        if (r1 == null) goto L27;
        if (r7 == null) goto L9;
        Intrinsics.checkNotNullParameter(r7, "params");
        TrackParams r2 = new TrackParams().merge(r7);
        by7.a r3 = new by7.a("add_shortcut_toast_show");
        r3.a.merge(r2);
        r3.b();
    L9:
        CommonDialog.a r4 = new CommonDialog.a();
        AppHost.Companion r5 = AppHost.a;
        if (r5.isOversea() == false) goto L12;
        String r6 = j5.a(r5.getApplication(), 2131894310, 2131901955);
    L13:
        r4.i(r6);
        CommonDialog.a.e(r4, new b(this, r7), r5.getApplication().getString(2131899747), 4);
        if (r5.isOversea() == false) goto L16;
        String r8 = j5.a(r5.getApplication(), 2131894310, 2131901954);
    L17:
        r4.g(r8);
        r4.w = true;
        CommonDialog r9 = r4.a();
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, null, r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r9, r10) == true) goto L28;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L21:
        r9.show(r1, null);
        return;
    L28:
        return;
    L16:
        r8 = r5.getApplication().getString(2131901365);
        Intrinsics.checkNotNull(r8);
        goto L17
    L12:
        r6 = r5.getApplication().getString(2131901366);
        Intrinsics.checkNotNull(r6);
        goto L13
    L27:
        return;
    }

    public final void g(Context r3) {
        ShortcutStatusReceiver r0 = this.e;
        if (r0 == null) goto L18;
        if (r3 == null) goto L14;
        ReceiverRegisterLancet.loge(r0, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L16;
        r3.unregisterReceiver(r0);
        goto L14
    L16:
    L11:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r0.toString());
        e.printStackTrace();
        goto L14
    L8:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r0, r3) == false) goto L14;
        r3.unregisterReceiver(r0);     // Catch: Exception -> L11
    L14:
        this.e = null;
        return;
    }

    public PinShortcutProcess(tw9.a r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r6, "flowShortcutInfo");
        this.a = r6;
        this.b = r7;
        this.d = new PinShortcutLifecycleObserver(this);
        FLogger r0 = FLogger.a;
        r0.i("PinShortcutUtil", "start pin, info: " + r6);
        this.c = 0;
        AppHost.Companion r3 = AppHost.a;
        g(r3.getApplication());
        if (((ShortcutManager) e.a.getValue()).isRequestPinShortcutSupported() == true) goto L22;
        f(r7);
    L22:
        String r8 = com.larus.shortcuts.impl.pin.a.a;     // Catch: Throwable -> L7
        int r9 = com.larus.shortcuts.impl.pin.a.d(r3.getApplication());     // Catch: Throwable -> L7
        r0.i("PinShortcutUtil", "tryAddShortCut permission is " + r9);     // Catch: Throwable -> L7
    L9:
        if (r9 != 0) goto L11;
        f(this.b);
    L20:
        this.f = -1;
        return;
    L11:
        if (r9 == 1) goto L18;
        FragmentActivity r10 = d();
        if (r10 == null) goto L17;
        Lifecycle r11 = r10.getLifecycle();
        if (r11 == null) goto L17;
        r11.addObserver(this.d);
    L17:
        e(this.a, this.b, true);
        goto L20
    L18:
        e(this.a, this.b, false);
    L7:
        th = move-exception;
        FLogger.a.e("PinShortcutUtil", "t is " + th.getMessage());
        r9 = 2;
        goto L9
    }

    public static final Object b(PinShortcutProcess r7, Continuation r8) {
        r7.getClass();
        if ((r8 instanceof PinShortcutProcess$pinAfterCheck$1) == false) goto L7;
        PinShortcutProcess$pinAfterCheck$1 r0 = (PinShortcutProcess$pinAfterCheck$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        boolean r4 = r0.Z$0;
        ResultKt.throwOnFailure(r9);
    L24:
        if (r4 == false) goto L26;
    L28:
        if (r4 == false) goto L30;
    L32:
        if (r4 == false) goto L34;
        FLogger.a.i("PinShortcutUtil", "delay 2000, success");
    L36:
        return Unit.INSTANCE;
    L34:
        FLogger.a.i("PinShortcutUtil", "delay 2000， what?");
        goto L36
    L30:
        if (r7.c != 1) goto L32;
        FLogger.a.i("PinShortcutUtil", "delay 2000, has system dialog");
        goto L36
    L26:
        if (r7.c == 1) goto L28;
        FLogger.a.i("PinShortcutUtil", "delay 2000, no system dialog&fail");
        r7.f(r7.b);
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
    L19:
        Lazy r10 = e.a;
        boolean r11 = e.a(r7.a.b());
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        PinShortcutProcess$pinAfterCheck$2 r6 = new PinShortcutProcess$pinAfterCheck$2(r7, null);
        r0.Z$0 = r11;
        r0.label = 2;
        if (BuildersKt.withContext(r5, r6, r0) == r2) goto L38;
        r4 = r11;
        goto L24
    L38:
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        r0.label = 1;
        if (DelayKt.delay(1000, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new PinShortcutProcess$pinAfterCheck$1(r7, r8);
        goto L8
    }

    public static final void c(PinShortcutProcess r11, Context r12) {
        if (r11.e != null) goto L74;
        r11.e = new ShortcutStatusReceiver(r11);
        IntentFilter r0 = new IntentFilter();
        r0.addAction("com.larus.shortcut.action.INSTALL_SHORTCUT");
        if (Build.VERSION.SDK_INT < 33) goto L36;
        if (r12 == null) goto L75;
        ShortcutStatusReceiver r13 = r11.e;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L71;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L71:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.registerReceiver(r13, r0, 2);
        return;
    L35:
        throw e;
    L11:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r0) == false) goto L22;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r13, r0, 2, null, null, 3, r12).result;     // Catch: Exception -> L31
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L70;
        r12.registerReceiver(r13, r0, 2);     // Catch: Exception -> L31
    L70:
        return;
    L19:
        new Intent();     // Catch: Exception -> L31
        goto L70
    L20:
        r12.registerReceiver(r13, r0, 2);     // Catch: Exception -> L31
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r12.registerReceiver(r13, r0, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        goto L70
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r12.registerReceiver(r13, r0, 2);     // Catch: Exception -> L31
        goto L70
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r0) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r12, r13, r0, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L31
        goto L70
    L75:
        return;
    L36:
        if (r12 == null) goto L77;
        ShortcutStatusReceiver r14 = r11.e;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L61:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L65;
        ReceiverRegisterCrashOptimizer.registerReceiver(r14, r0);
        return;
    L65:
        throw e;
    L41:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L52;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r0) == false) goto L52;
        int r2 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r14, r0, 0, null, null, 2, r12).result;     // Catch: Exception -> L61
        if (r2 == 1) goto L50;
        if (r2 == 2) goto L49;
        if (r2 == 3) goto L67;
        r12.registerReceiver(r14, r0);     // Catch: Exception -> L61
    L67:
        return;
    L49:
        new Intent();     // Catch: Exception -> L61
        goto L67
    L50:
        r12.registerReceiver(r14, r0);     // Catch: Exception -> L61
    L52:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L55;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L61
        r12.registerReceiver(r14, r0, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L61
        goto L67
    L55:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L57;
    L59:
        r12.registerReceiver(r14, r0);     // Catch: Exception -> L61
        goto L67
    L57:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r0) == false) goto L59;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L61
        ContextCompat.registerReceiver(r12, r14, r0, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L61
        goto L67
    L77:
        return;
    }

    public static final Object a(PinShortcutProcess r4, tw9.a r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof PinShortcutProcess$buildShortcutInfo$1) == false) goto L7;
        PinShortcutProcess$buildShortcutInfo$1 r0 = (PinShortcutProcess$buildShortcutInfo$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r5 = (tw9.a) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L18:
        if (r5.a != null) goto L23;
        if (o0.d(r5.a()) == false) goto L23;
        s.a.g(AppHost.a.getApplication(), 2131907052, false);
    L39:
        return null;
    L23:
        if (r5.d() == null) goto L39;
        if (r5.g() == null) goto L39;
        Bitmap r9 = r5.a;
        if (r9 != null) goto L30;
    L36:
        Icon r10 = Icon.createWithResource(AppHost.a.getApplication(), 2131240119);
    L37:
        Intrinsics.checkNotNull(r10);
        ShortcutInfo.Builder r11 = new ShortcutInfo.Builder(AppHost.a.getApplication(), r5.b());
        String r12 = r5.d();
        Intrinsics.checkNotNull(r12);
        ShortcutInfo.Builder r13 = r11.setShortLabel(r12).setIcon(r10);
        int r14 = ShortcutCommonUtil.a;
        String r15 = r5.g();
        Intrinsics.checkNotNull(r15);
        return r13.setIntent(ShortcutCommonUtil.b(r15)).build();
    L30:
        if (r9.isRecycled() == true) goto L33;
        r3 = false;
    L33:
        if (r3 == true) goto L36;
        r10 = Icon.createWithBitmap(r5.a);
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r16 = Dispatchers.getIO();
        PinShortcutProcess$buildShortcutInfo$2 r17 = new PinShortcutProcess$buildShortcutInfo$2(r5, null);
        r0.L$0 = r5;
        r0.label = 1;
        if (BuildersKt.withContext(r16, r17, r0) != r8) goto L18;
        return r8;
    L7:
        r0 = new PinShortcutProcess$buildShortcutInfo$1(r4, r6);
        goto L8
    }

    public final void e(tw9.a r11, JSONObject r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new PinShortcutProcess$pinnedShortCut$1(r11, this, r13, r12, null), 2, null);
    }
}
