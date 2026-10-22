package com.obric.assistant.onelogin;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.base.api.UserAction;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.login.ObricLoginType;
import com.obric.assistant.login.e0;
import com.obric.assistant.login.f0;
import com.obric.assistant.login.u;
import com.obric.assistant.login.v;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.matrix.platform.sdk.ones.account.AppGlobals;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.account.g;
import com.ss.android.token.TokenFactory;
import com.ss.android.token.p;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import n38.j;
import vaa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0004\u001a!$'\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\tH\u0002R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/onelogin/ObricOneLoginImpl;", "Lcom/obric/assistant/onelogin/IObricOneLogin;", "<init>", "()V", "createObricLoginRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "initOAccountLoginState", "", "isMainActivityStarted", "", "setMainActivityStarted", "getOneLoginActivity", "", "getXttTokenMap", "", "hasInitOAccount", "pendingInitActionLock", "", "pendingInitAction", "", "Lkotlin/Function0;", "waitInitOAccount", "init", "drainPendingInitAction", "registerOAccountStatusListener", "oAccountStatusListener", "com/obric/assistant/onelogin/ObricOneLoginImpl$oAccountStatusListener$1", "Lcom/obric/assistant/onelogin/ObricOneLoginImpl$oAccountStatusListener$1;", "postQueryOLoginAndOneLogin", "registerAccountEventReceiver", "registerLogoutProcessor", "registerNetworkAvailableListener", "logger", "com/obric/assistant/onelogin/ObricOneLoginImpl$logger$1", "Lcom/obric/assistant/onelogin/ObricOneLoginImpl$logger$1;", "bridge", "com/obric/assistant/onelogin/ObricOneLoginImpl$bridge$1", "Lcom/obric/assistant/onelogin/ObricOneLoginImpl$bridge$1;", "doubaoAccountStatusListener", "com/obric/assistant/onelogin/ObricOneLoginImpl$doubaoAccountStatusListener$1", "Lcom/obric/assistant/onelogin/ObricOneLoginImpl$doubaoAccountStatusListener$1;", "doubaoAccountRemovedListener", "Lcom/larus/account/base/api/IMultiAccountService$AccountRemovedListener;", "settingsListener", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "updateEnterpriseAccountSecureSetting", "isEnterpriseAccount", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneLoginImpl implements IObricOneLogin {
    public static final /* synthetic */ int j = 0;
    public volatile boolean a;
    public final Object b;
    public List<Function0<Unit>> c;
    public final e d;
    public final d e;
    public final b f;
    public final c g;
    public final k h;
    public final l i;

    public static final class c implements j {
        public final /* synthetic */ ObricOneLoginImpl a;

        public c(ObricOneLoginImpl r1) {
            this.a = r1;
        }

        public final void a(n38.a r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            ObricOneLoginImpl.f(this.a, false);
            f0.a.getClass();
            Intrinsics.checkNotNullParameter(r10, "event");
            String r0 = r10.b.b;
            u.d.getClass();
            u r1 = u.e;
            ObricLoginType r3 = r1.c;
            FLogger.a.i("ObricLoginStrategyCenter", "handleDoubaoAccountOffline, scene: " + r10.d + ", offlineSecUserId: " + r0 + ", lastLoginType: " + r3);
            Iterator r2 = f0.d.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r4 = r2.next();
            if (((v) r4).a(r3) == false) goto L4;
        L9:
            v r5 = (v) r4;
            FLogger r6 = FLogger.a;
            StringBuilder r7 = new StringBuilder("handleDoubaoAccountOffline, lastLoginType: ");
            r7.append(r3);
            r7.append(", strategy: ");
            if (r5 == null) goto L12;
            String r8 = r5.getClass().getSimpleName();
        L13:
            r7.append(r8);
            r6.i("ObricLoginStrategyCenter", r7.toString());
            if (r5 == null) goto L16;
            r5.c(r10, r1);
        L16:
            u.d.getClass();
            u.a.a();
            IObricNetworkService r11 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
            if (r11 == null) goto L23;
            r11.clearOmniTasks(MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", "logout"), TuplesKt.to("stop_scene", "logout")}), null);
            return;
        L23:
            return;
        L12:
            r8 = null;
            goto L13
        L8:
            r4 = null;
            goto L9
        }

        public final void b(n38.a r11) {
            Intrinsics.checkNotNullParameter(r11, "event");
            q38.a r1 = ILoginService.a.getAccountInfo();
            ObricOneLoginImpl r2 = this.a;
            if (r1.a == true) goto L5;
        L7:
            boolean r3 = false;
        L8:
            ObricOneLoginImpl.f(r2, r3);
            f0.a.getClass();
            Intrinsics.checkNotNullParameter(r11, "event");
            u.d.getClass();
            u r4 = u.a.a();
            Iterator r5 = f0.d.iterator();
        L9:
            Unit r6 = null;
            if (r5.hasNext() == false) goto L14;
            Object r7 = r5.next();
            if (((v) r7).a(r4.c) == false) goto L9;
        L15:
            v r8 = (v) r7;
            FLogger r9 = FLogger.a;
            StringBuilder r10 = new StringBuilder("handleDoubaoAccountOnline, loginType: ");
            r10.append(r4.c);
            r10.append(", strategy: ");
            if (r8 == null) goto L18;
            String r12 = r8.getClass().getSimpleName();
        L19:
            r10.append(r12);
            r10.append(", scene: ");
            r10.append(r11.d);
            r9.i("ObricLoginStrategyCenter", r10.toString());
            if (r8 == null) goto L22;
            r8.b(r11);
        L22:
            IObricNetworkService r13 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
            if (r13 == null) goto L25;
            r13.clearOmniTasks(MapsKt.mapOf(TuplesKt.to("stop_scene", "clear_login_success")), null);
        L25:
            b.a.getClass();
            Intrinsics.checkNotNullParameter(r11, "event");
            if (r11.c == UserAction.ACCOUNT_SWITCH) goto L28;
        L30:
            q38.a r0 = ILoginService.a.getAccountInfo();
            if (r0.a == true) goto L33;
        L35:
            boolean r14 = false;
        L36:
            r9.i("ObricAccountTaskCleaner", "shouldCleanNonMainTasks by current account, shouldClean=" + r14 + ", isLogin=" + r0.a + ", isEnterprise=" + r0.g + ", action=" + r11.c + ", businessScene=" + r11.d);
        L37:
            if (r14 == true) goto L39;
            r9.i("ObricAccountTaskCleaner", "cleanNonMainTasksAfterAccountChanged ignored, action=" + r11.c + ", businessScene=" + r11.d);
            return;
        L39:
            List r15 = AppHost.a.a().g();
            ListIterator r16 = r15.listIterator(r15.size());
        L41:
            if (r16.hasPrevious() == false) goto L51;
            Object r17 = r16.previous();
            String r18 = ((Activity) r17).getClass().getName();
            if (Intrinsics.areEqual(r18, "com.larus.home.impl.MainActivity") == false) goto L45;
        L48:
            boolean r19 = true;
        L49:
            if (r19 == false) goto L41;
        L52:
            Activity r20 = (Activity) r17;
            if (r20 == null) goto L55;
            Integer r21 = Integer.valueOf(r20.getTaskId());
        L56:
            FLogger.a.i("ObricAccountTaskCleaner", "cleanNonMainTasksAfterAccountChanged, mainTaskId=" + r21 + ", activitySize=" + r15.size());
            Iterator r110 = r15.iterator();
        L58:
            if (r110.hasNext() == false) goto L110;
            Activity r22 = (Activity) r110.next();
            int r23 = r22.getTaskId();
            if (r21 == null) goto L65;
            if (r23 == r21.intValue()) goto L58;
        L65:
            if (r22.isFinishing() == true) goto L58;
            FLogger.a.i("ObricAccountTaskCleaner", "finishNonMainActivity, activity=" + r22.getClass().getName() + ", taskId=" + r22.getTaskId() + ", mainTaskId=" + r21);
            Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L69
            r22.finish();     // Catch: Throwable -> L69
            Object r25 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L69
        L71:
            Throwable r26 = Result.exceptionOrNull-impl(r25);
            if (r26 == null) goto L58;
            FLogger.a.w("ObricAccountTaskCleaner", "finishNonMainActivity failed, activity=".concat(r22.getClass().getName()), r26);
        L69:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            r25 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L71
        L110:
            Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L102
            Object r112 = AppHost.a.getApplication().getSystemService("activity");     // Catch: Throwable -> L102
            if ((r112 instanceof ActivityManager) == false) goto L77;
            ActivityManager r113 = (ActivityManager) r112;     // Catch: Throwable -> L102
        L78:
            if (r113 == null) goto L100;
            List<ActivityManager.AppTask> r114 = r113.getAppTasks();     // Catch: Throwable -> L102
            if (r114 == null) goto L100;
            Iterator<T> r115 = r114.iterator();     // Catch: Throwable -> L102
        L83:
            if (r115.hasNext() == false) goto L99;
            ActivityManager.AppTask r28 = (ActivityManager.AppTask) r115.next();     // Catch: Throwable -> L102
            ActivityManager.RecentTaskInfo r29 = r28.getTaskInfo();     // Catch: Throwable -> L102
            if (r29 != null) goto L88;
            Integer r30 = null;
        L91:
            if (r30 != null) goto L92;
            FLogger.a.i("ObricAccountTaskCleaner", "skip finishAndRemoveTask, taskInfo is null, mainTaskId=" + r21);     // Catch: Throwable -> L102
            goto L83
        L92:
            int r31 = r30.intValue();     // Catch: Throwable -> L102
            if (r21 == null) goto L97;
            if (r31 == r21.intValue()) goto L83;
        L97:
            FLogger.a.i("ObricAccountTaskCleaner", "finishAndRemoveTask, taskId=" + r31 + ", mainTaskId=" + r21);     // Catch: Throwable -> L102
            r28.finishAndRemoveTask();     // Catch: Throwable -> L102
            goto L83
        L88:
            if (Build.VERSION.SDK_INT < 29) goto L90;
            r30 = Integer.valueOf(r29.taskId);     // Catch: Throwable -> L102
            goto L91
        L90:
            r30 = Integer.valueOf(r29.id);     // Catch: Throwable -> L102
            goto L91
        L99:
            r6 = Unit.INSTANCE;     // Catch: Throwable -> L102
        L100:
            Object r116 = Result.constructor-impl(r6);     // Catch: Throwable -> L102
        L104:
            Throwable r117 = Result.exceptionOrNull-impl(r116);
            if (r117 == null) goto L139;
            FLogger.a.w("ObricAccountTaskCleaner", "cleanNonMainTasksAfterAccountChanged failed: " + r117.getMessage(), r117);
            return;
        L139:
            return;
        L77:
            r113 = null;
        L102:
            th = move-exception;
            Result.Companion r32 = Result.Companion;
            r116 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L104
        L55:
            r21 = null;
            goto L56
        L45:
            if (Intrinsics.areEqual(r18, "com.larus.bmhome.chat.ChatActivity") == true) goto L48;
            r19 = false;
            goto L49
        L51:
            r17 = null;
            goto L52
        L33:
            if (r0.g == false) goto L35;
            r14 = true;
            goto L36
        L28:
            if (Intrinsics.areEqual(r11.d, "login_by_account_switch") == false) goto L30;
            r9.i("ObricAccountTaskCleaner", "shouldCleanNonMainTasks true by account switch, action=" + r11.c + ", businessScene=" + r11.d);
            r14 = true;
            goto L37
        L18:
            r12 = null;
            goto L19
        L14:
            r7 = null;
            goto L15
        L5:
            if (r1.g == false) goto L7;
            r3 = true;
            goto L8
        }
    }

    public static final class d implements cka.b {
        public d() {
        }

        public final void d(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "tag");
            Intrinsics.checkNotNullParameter(r4, "msg");
            FLogger.a.d(r3, r4 + null);
        }

        public final void i(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "tag");
            Intrinsics.checkNotNullParameter(r4, "msg");
            FLogger.a.i(r3, r4 + null);
        }

        public final void w(String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "tag");
            Intrinsics.checkNotNullParameter(r4, "msg");
            FLogger.a.w(r3, r4, null);
        }

        public final void e(String r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.e(r2, r3, r4);
        }
    }

    public static final class e implements cka.a {
        public e() {
        }

        public final void a() {
            f0 r0 = f0.a;
            Activity r1 = com.bytedance.sdk.account.utils.d.b();
            r0.getClass();
            u.d.getClass();
            u r2 = u.a.a();
            FLogger r3 = FLogger.a;
            r3.i("ObricLoginStrategyCenter", "handleOAccountLogin, context: " + f0.c(r2) + ", topActivity: " + r1);
            if ((r1 instanceof ObricOneLoginActivity) == false) goto L5;
        L8:
            r3.i("ObricLoginStrategyCenter", "handleOAccountLogin ignore, already in one login activity");
            return;
        L5:
            if ((r1 instanceof ObricOneLoginTransparentActivity) == true) goto L8;
            f0.d(r0, "o_account_login", null, null, null, 62);
        }

        public final void b() {
            FLogger.a.i("ObricOneLoginImpl", "onAccountInfoUpdate");
        }

        public final void c(int r8) {
            f0.a.getClass();
            u.d.getClass();
            u r0 = u.a.a();
            FLogger.a.i("ObricLoginStrategyCenter", "handleOAccountLogout, loginType: " + r0.c + ", logoutScene: " + r8);
            String r9 = r0.b.b;
            e0 r1 = new e0();
            List r2 = IMultiAccountService.a.g();
            ArrayList r3 = new ArrayList();
            Iterator r4 = r2.iterator();
        L3:
            boolean r5 = false;
            if (r4.hasNext() == false) goto L12;
            Object r6 = r4.next();
            q38.b r7 = (q38.b) r6;
            if (r7.k() == false) goto L8;
        L10:
            if (r5 == false) goto L3;
            r3.add(r6);
            goto L3
        L8:
            if (Intrinsics.areEqual(r7.g(), r9) == true) goto L10;
            r5 = true;
            goto L10
        L12:
            f0.b(r3, r1, 0);
        }
    }

    static {
    }

    public final q97.a d() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L7;
        return null;
    L7:
        return new a();
    }

    public final void g() {
        Object r0 = this.b;
        monitor-enter(r0);
        this.a = true;     // Catch: Throwable -> L14
        List<Function0<Unit>> r1 = this.c;     // Catch: Throwable -> L14
        this.c = null;     // Catch: Throwable -> L14
        monitor-exit(r0);
        if (r1 != null) goto L9;
        return;
    L9:
        Iterator<T> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        ((Function0) r2.next()).invoke();
        goto L11
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void h() {
        OAccount.a.getClass();
        OAccount.c(true);
        g r0 = OAccount.d;
        ContentProviderClient r1 = null;
        g r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r0 = null;
    L5:
        r0.getClass();
        dka.a.c("AccountSDK_OAccountManager", "getMatrixVersionInfo");
        ContentProviderClient r4 = g.d(AppGlobals.a().getContentResolver());     // Catch: Throwable -> L18 Exception -> L20
        if (r4 != null) goto L55;
        Bundle r3 = null;
    L14:
        if (r3 != null) goto L16;
        r3 = new Bundle();     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = e;
    L51:
        dka.a.a.e("AccountSDK_OAccountManager", "setLoginPhoneNumber error: ", e);     // Catch: Throwable -> L45
        if (r4 == null) goto L25;
        r4.close();
    L25:
        r3 = new Bundle();
    L26:
        boolean r5 = r3.containsKey("supportStaticBroadcast");
        boolean r6 = t9a.b.a().c("obric_feature_matrix_secure_listener");
        boolean r7 = r3.containsKey("supportSecureAccountStatusListener");
        FLogger.a.i("ObricOneLoginImpl", "registerOAccountStatusListener supportStaticAccountStatusListener:" + r5 + ", enableSecureAccountStatusListener:" + r6 + ", supportSecureAccountStatusListener:" + r7);
        if (r5 == false) goto L40;
        OAccount r8 = OAccount.a;
        e r9 = this.d;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "accountStatusListener");
        g r10 = OAccount.d;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
    L32:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "accountStatusListener");
        Set<cka.a> r11 = g.i;
        monitor-enter(r11);
        ((CopyOnWriteArraySet) r11).add(r9);     // Catch: Throwable -> L37
        monitor-exit(r11);
        return;
    L37:
        th = move-exception;
        throw th;
    L31:
        r2 = r10;
        goto L32
    L40:
        if (r6 == false) goto L43;
        if (r7 == false) goto L43;
        OAccount r12 = OAccount.a;
        e r13 = this.d;
        r12.getClass();
        OAccount.b(r13);
        return;
    L43:
        OAccount r14 = OAccount.a;
        e r15 = this.d;
        r14.getClass();
        OAccount.a(r15);
        return;
    L45:
        th = th;
        r1 = r4;
    L47:
        r4 = r1;
    L48:
        if (r4 == null) goto L50;
        r4.close();
    L50:
        throw th;
    L9:
        th = th;
    L16:
        if (r4 == null) goto L26;
        r4.close();
        goto L26
    L55:
        r3 = r4.call("com.obric.common.account.provider", "getMatrixVersionInfo", null, null);     // Catch: Throwable -> L9 Exception -> L11
        goto L14
    L20:
        e = e;
        r4 = null;
    L18:
        th = th;
        goto L47
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.onelogin.k] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.onelogin.l] */
    public ObricOneLoginImpl() {
        this.b = new Object();
        this.c = new ArrayList();
        this.d = new e();
        this.e = new d();
        this.f = new b();
        this.g = new c(this);
        this.h = new k();
        this.i = new l();
    }

    public final void b() {
        boolean r0 = t9a.b.a().b();
        FLogger r1 = FLogger.a;
        r1.i("ObricOneLoginImpl", "initOAccountLoginState supportObricOneLogin:" + r0);
        if (r0 == true) goto L5;
        return;
    L5:
        OAccount r2 = OAccount.a;
        AppHost.Companion r3 = AppHost.a;
        Application r4 = r3.getApplication();
        d r5 = this.e;
        b r6 = this.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "application");
        Intrinsics.checkNotNullParameter(r5, "logger");
        Intrinsics.checkNotNullParameter(r6, "bridge");
        dka.a.c("AccountSDK_OAccount", "init, asyncInit: false");
        AtomicBoolean r7 = OAccount.b;
        monitor-enter(r7);
        ConnectivityManager r8 = null;
        if (OAccount.b.get() == false) goto L12;
        dka.a.f("AccountSDK_OAccount", "Init already.");     // Catch: Throwable -> L44
        monitor-exit(r7);
    L17:
        f0.a.getClass();
        u.d.getClass();
        r1.i("ObricLoginStrategyCenter", "initLoginContext, context: " + f0.c(u.a.a()));
        SettingsManager.registerListener(this.i, true);
        SettingsManager.updateSettings(true);
        h();
        ILoginService r9 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r9 == null) goto L20;
        r9.f(this.g, Boolean.FALSE);
    L20:
        IMultiAccountService.a.i(this.h);
        int r10 = Build.VERSION.SDK_INT;     // Catch: Exception -> L26
        if (r10 < 33) goto L24;
        e(r3.getApplication(), new ObricAccountEventReceiver(), new IntentFilter("com.obric.assistant.onelogin.OBRIC_ACCOUNT_EVENT"));     // Catch: Exception -> L26
    L50:
    L28:
        n r11 = new n();
        if (p.f() == false) goto L33;
        TokenFactory r12 = TokenFactory.j();
        if (r12.h == null) goto L33;
        r12.h.h = r11;
    L33:
        f0.a.getClass();
        f0.a("logout_by_check_account_on_init");
        t0.a(new m());
        Object r13 = AppHost.a.getApplication().getSystemService("connectivity");     // Catch: Exception -> L40
        if ((r13 instanceof ConnectivityManager) == false) goto L37;
        r8 = (ConnectivityManager) r13;     // Catch: Exception -> L40
    L37:
        if (r8 == null) goto L42;
        r8.registerNetworkCallback(new NetworkRequest.Builder().build(), new o());     // Catch: Exception -> L40
    L42:
        FLogger.a.i("ObricOneLoginImpl", "initOAccountLoginState");
        g();
        return;
    L40:
        e = move-exception;
        FLogger.a.e("ObricOneLoginImpl", "registerNetworkAvailableListener failed: " + e);
        goto L42
    L24:
        r1.e("ObricOneLoginImpl", "registerAccountEventReceiver failed, current build sdk: " + r10);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        FLogger.a.e("ObricOneLoginImpl", "registerAccountEventReceiver failed: " + e, e);
        goto L28
    L12:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");     // Catch: Throwable -> L44
        dka.a.b = r5;     // Catch: Throwable -> L44
        OAccount r14 = OAccount.a;     // Catch: Throwable -> L44
        g r15 = g.c;     // Catch: Throwable -> L44
        OAccount.d = r15;     // Catch: Throwable -> L44
        if (r15 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");     // Catch: Throwable -> L44
        r15 = null;
    L15:
        r15.e();     // Catch: Throwable -> L44
        OAccount.b.set(true);     // Catch: Throwable -> L44
        OAccount.c.countDown();     // Catch: Throwable -> L44
        OAccount.d();     // Catch: Throwable -> L44
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r7);
    L44:
        th = move-exception;
        throw th;
    }

    public final String c() {
        if (c0.d() == false) goto L7;
        return ObricOneLoginActivity.class.getName();
    L7:
        return ObricOneLoginTransparentActivity.class.getName();
    }

    public final void a(p r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        Object r0 = this.b;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.a == true) goto L11;
        List<Function0<Unit>> r1 = this.c;     // Catch: Throwable -> L15
        if (r1 == null) goto L10;
        ((ArrayList) r1).add(r3);     // Catch: Throwable -> L15
    L10:
        r3 = null;
    L11:
        monitor-exit(r0);
        if (r3 == null) goto L20;
        r3.invoke();
        return;
    }

    public static final void f(ObricOneLoginImpl r4, boolean r5) {
        r4.getClass();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Boolean.valueOf(Settings.Secure.putInt(AppHost.a.getApplication().getContentResolver(), "doubao_account_is_enterprise", r5 ? 1 : 0)));     // Catch: Throwable -> L5
    L8:
        if (Result.isSuccess-impl(r7) == false) goto L10;
        ((Boolean) r7).booleanValue();
        FLogger.a.i("ObricOneLoginImpl", "updateEnterpriseAccountSecureSetting success, value=" + (r5 ? 1 : 0));
    L10:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L16;
        FLogger.a.e("ObricOneLoginImpl", "updateEnterpriseAccountSecureSetting failed, value=" + (r5 ? 1 : 0), r8);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void e(Application r9, ObricAccountEventReceiver r10, IntentFilter r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L29:
    L23:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L28;
        ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 2);
        return;
    L28:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L9;
    L21:
        r9.registerReceiver(r10, r11, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 2);     // Catch: Exception -> L23
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L21;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r11, 2, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 5, r9).result;     // Catch: Exception -> L23
        if (r0 == 1) goto L19;
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L23
        return;
    L14:
        if (r0 == 3) goto L30;
        r9.registerReceiver(r10, r11, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 2);     // Catch: Exception -> L23
        return;
    L30:
        return;
    L19:
        r9.registerReceiver(r10, r11, "com.obric.assistant.onelogin.permission.OBRIC_ACCOUNT_EVENT_RECEIVER", null, 2);     // Catch: Exception -> L23
    }
}
