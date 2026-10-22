package com.obric.sva.sdk.applog;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.api.IExtraParams;
import com.larus.common.apphost.AppHost;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.b0;
import com.obric.assistant.common.spi.ObricConfigServiceDelegate;
import com.obric.assistant.common.spi.ObricContextServiceDelegate;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.logger.SLogger;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.common.applog.g0;
import com.ss.android.common.applog.i0;
import com.ss.android.common.applog.j0;
import com.ss.android.common.applog.m0;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import jta.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v48.d;
import v48.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fJ\u001a\u0010!\u001a\u00020\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0#J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010'J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)J\u0016\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020'J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u000e\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u001bJ\u000e\u00105\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u001bJ>\u00106\u001a\u00020\u001f26\u00107\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001f08J\u0006\u0010=\u001a\u00020\u001fJ\u0006\u0010>\u001a\u00020\u001fJ\u000e\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u0019J\u000e\u0010A\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u0019J\u001e\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u00052\u000e\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014J\u0016\u0010E\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0001J\u000e\u0010G\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u0005J\b\u0010H\u001a\u00020\u001fH\u0002J\b\u0010I\u001a\u00020)H\u0002J\u0010\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0011H\u0002J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u0005H\u0002J\u0010\u0010O\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u0005H\u0002J \u0010P\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u0005H\u0002J!\u0010Q\u001a\u00020\u00052\u0012\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050S\"\u00020\u0005H\u0002¢\u0006\u0002\u0010TJ$\u0010U\u001a\u00020\u001f2\b\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00052\u0006\u0010N\u001a\u00020\u0005H\u0002J \u0010V\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020'2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0001H\u0002J \u0010X\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020)2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0001H\u0002J\u0018\u0010Y\u001a\u00020)2\u000e\u0010W\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030ZH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/obric/sva/sdk/applog/InteractorLegacyAppLogHelper;", "", "<init>", "()V", "TAG", "", "INTERACTOR_DB_NAME", "INTERACTOR_SP_NAME", "INTERACTOR_ENCRYPT_SP_NAME", "ID_FAST_POLLING_ATTEMPTS", "", "ID_FAST_POLLING_INTERVAL_MS", "", "ID_SLOW_POLLING_INTERVAL_MS", "mConfigInfo", "Lcom/larus/applog/api/AppLogConfigInfo;", "initialized", "", "eventCommonParamsGenerators", "", "Lkotlin/Function0;", "eventCommonParamsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "commonParamInterceptors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/applog/api/IEventInterceptor;", "didListenerCallbackList", "Lcom/larus/applog/api/OnGetAppLogIdListener;", "idNotifyScheduled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "init", "", "configInfo", "setBDAccountCallback", "pair", "Landroid/util/Pair;", "reportEvent", EventVerify.TYPE_EVENT_V1, "jsonParams", "Lorg/json/JSONObject;", "bundleParams", "Landroid/os/Bundle;", "onMiscEvent", "logType", "obj", "getDeviceId", "getInstallId", "getSessionId", "getUserUniqueID", "getUserID", "getOpenUDid", "addGetAppLogIdListener", "listener", "removeDidListener", "doWhenIdsReady", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "did", "iid", "openETVerify", "closeETVerify", "addCommonParamInterceptor", "eventInterceptor", "removeCommonParamInterceptor", "addEventCommonParams", "key", "valueGenerator", "putEventCommonParams", "value", "removeEventCommonParams", "updateHeaderInfo", "getHeaderInfo", "buildUrlConfig", "Lcom/ss/android/common/applog/UrlConfig;", "boe", "notifyIdsReadyIfNeeded", "from", "scheduleIdsReadyCheck", "notifyDidListeners", "getStringFromAppLog", "methodNames", "", "([Ljava/lang/String;)Ljava/lang/String;", "updateBdTuringId", "addToJSONObject", "params", "addToBundle", "toBundle", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class InteractorLegacyAppLogHelper {
    private static final int ID_FAST_POLLING_ATTEMPTS = 10;
    private static final long ID_FAST_POLLING_INTERVAL_MS = 500;
    private static final long ID_SLOW_POLLING_INTERVAL_MS = 2000;
    public static final InteractorLegacyAppLogHelper INSTANCE = null;
    private static final String INTERACTOR_DB_NAME = "obric_interactor_legacy_applog.db";
    private static final String INTERACTOR_ENCRYPT_SP_NAME = "obric_interactor_legacy_applog_encrypt";
    private static final String INTERACTOR_SP_NAME = "obric_interactor_legacy_applog_stats";
    private static final String TAG = "InteractorLegacyAppLogHelper";
    private static final CopyOnWriteArrayList<d> commonParamInterceptors = null;
    private static final CopyOnWriteArrayList<e> didListenerCallbackList = null;
    private static final Map<String, Function0<Object>> eventCommonParamsGenerators = null;
    private static final ConcurrentHashMap<String, Object> eventCommonParamsMap = null;
    private static final AtomicBoolean idNotifyScheduled = null;
    private static volatile boolean initialized;
    private static v48.a mConfigInfo;

    private InteractorLegacyAppLogHelper() {
    }

    public static /* synthetic */ Pair a(Pair r0) {
        return setBDAccountCallback$lambda$0(r0);
    }

    public static /* synthetic */ void b() {
        updateHeaderInfo$lambda$9();
    }

    public static /* synthetic */ void c(String r0) {
        scheduleIdsReadyCheck$lambda$12(r0);
    }

    private static final Pair setBDAccountCallback$lambda$0(Pair r0) {
        return r0;
    }

    static {
        INSTANCE = new InteractorLegacyAppLogHelper();
        eventCommonParamsGenerators = new ConcurrentHashMap();
        eventCommonParamsMap = new ConcurrentHashMap();
        commonParamInterceptors = new CopyOnWriteArrayList();
        didListenerCallbackList = new CopyOnWriteArrayList();
        idNotifyScheduled = new AtomicBoolean(false);
    }

    private final Bundle getHeaderInfo() {
        if (AppHost.a.isOversea() == false) goto L5;
        AppLocaleUtils.a.getClass();
        Locale r0 = AppLocaleUtils.c();
    L6:
        Bundle r1 = new Bundle();
        InteractorLegacyAppLogHelper r2 = INSTANCE;
        r1.putAll(r2.toBundle(IExtraParams.a.c()));
        String r3 = b0.a;
        Intrinsics.checkNotNull(r0);
        r1.putString("system_language_detail", b0.f(r0));
        r1.putString("app_language", b0.c(r0));
        Map<?, ?> r4 = ObricConfigServiceDelegate.b.getCommonParams();
        if (r4 == null) goto L9;
        r1.putAll(r2.toBundle(r4));
    L9:
        SLogger.INSTANCE.i(TAG, "getHeaderInfo headerInfo = " + r1);
        return r1;
    L5:
        r0 = Locale.CHINA;
        goto L6
    }

    private final void updateHeaderInfo() {
        ThreadPlus.submitRunnable(new c());
    }

    private static final void updateHeaderInfo$lambda$9() {
        if (AppHost.a.isOversea() == false) goto L5;
        AppLocaleUtils.a.getClass();
        Locale r0 = AppLocaleUtils.c();
    L6:
        Bundle r1 = new Bundle();
        InteractorLegacyAppLogHelper r2 = INSTANCE;
        r1.putAll(r2.toBundle(IExtraParams.a.c()));
        String r3 = b0.a;
        Intrinsics.checkNotNull(r0);
        r1.putString("system_language_detail", b0.f(r0));
        r1.putString("app_language", b0.c(r0));
        Map<?, ?> r4 = ObricConfigServiceDelegate.b.getCommonParams();
        if (r4 == null) goto L9;
        r1.putAll(r2.toBundle(r4));
    L9:
        SLogger.INSTANCE.i(TAG, "interactor set legacy AppLog headerInfo = " + r1);
        AppLog.g0.d(r1);
        return;
    L5:
        r0 = Locale.CHINA;
        goto L6
    }

    public final void closeETVerify() {
        if (mConfigInfo != null) goto L5;
        return;
    L5:
        EventVerify.inst().setEnable(false, AppHost.a.getApplication());
    }

    public final String getDeviceId() {
        return getStringFromAppLog(new String[]{"getDid", "getServerDeviceId"});
    }

    public final String getInstallId() {
        return getStringFromAppLog(new String[]{"getIid", "getInstallId"});
    }

    public final String getOpenUDid() {
        return getStringFromAppLog(new String[]{"getOpenUdid", "getOpenUDID"});
    }

    public final String getSessionId() {
        return getStringFromAppLog(new String[]{"getSessionId", "getCurrentSessionId"});
    }

    public final String getUserID() {
        return getStringFromAppLog(new String[]{"getUserID", "getUserId"});
    }

    public final String getUserUniqueID() {
        return getStringFromAppLog(new String[]{"getUserUniqueID", "getUserUniqueId"});
    }

    public final void openETVerify() {
        if (mConfigInfo != null) goto L5;
        return;
    L5:
        SLogger.INSTANCE.i(TAG, "openETVerify");
        EventVerify.inst().setEventVerifyUrl("https://log.bytedance.net");
        EventVerify.inst().setEnable(true, AppHost.a.getApplication());
    }

    private final m0 buildUrlConfig(boolean r9) {
        if (AppHost.a.isOversea() == true) goto L5;
        if (r9 == false) goto L10;
        return new m0(new String[]{"https://log.snssdk.com.boe-gateway.byted.org/service/2/app_log/"}, new String[]{"https://rtlog.snssdk.com.boe-gateway.byted.org/service/2/app_log/"}, new String[]{"https://log.snssdk.com.boe-gateway.byted.org/service/2/device_register/"}, new String[]{"https://ichannel.snssdk.com.boe-gateway.byted.org/service/2/app_alert_check/"}, "https://log.snssdk.com.boe-gateway.byted.org/service/2/log_settings/", new String[]{"https://log.snssdk.com.boe-gateway.byted.org/service/2/app_log/"}, "https://log.snssdk.com.boe-gateway.byted.org/service/2/log_settings/");
    L10:
        return m0.h;
    L5:
        return m0.i;
    }

    private final String getStringFromAppLog(String... r8) {
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L27;
        String r3 = r8[r2];
        Object r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L11
        Object r6 = AppLog.class.getMethod(r3, new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L11
        if ((r6 instanceof String) == false) goto L8;
        String r7 = (String) r6;     // Catch: Throwable -> L11
    L9:
        Object r9 = Result.constructor-impl(r7);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r9) == true) goto L17;
        r4 = r9;
    L17:
        String r10 = (String) r4;
        if (r10 != null) goto L20;
    L23:
        boolean r11 = true;
    L24:
        if (r11 == false) goto L25;
        r2 = r2 + 1;
        goto L3
    L25:
        return r10;
    L20:
        if (r10.length() == 0) goto L23;
        r11 = false;
        goto L24
    L8:
        r7 = null;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L27:
        return "";
    }

    private final void notifyIdsReadyIfNeeded(String r7) {
        String r0 = getDeviceId();
        String r1 = getInstallId();
        if (r0.length() != 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L12;
        SLogger.INSTANCE.i(TAG, "notifyIdsReadyIfNeeded skipped: did empty, from=" + r7);
        if ((!didListenerCallbackList.isEmpty()) == false) goto L14;
        scheduleIdsReadyCheck(r7);
        return;
    L14:
        return;
    L12:
        SLogger.INSTANCE.i(TAG, "notifyIdsReadyIfNeeded, did=" + r0 + ", iid=" + r1 + ", from=" + r7);
        updateBdTuringId(r0, r1, r7);
        notifyDidListeners(r0, r1, r7);
        return;
    L5:
        r2 = false;
        goto L7
    }

    private final void scheduleIdsReadyCheck(final String r4) {
        if (idNotifyScheduled.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        ThreadPlus.submitRunnable(new b(r4));
    }

    private static final void scheduleIdsReadyCheck$lambda$12(String r13) {
        boolean r3 = false;
        int r4 = 0;
    L55:
        CopyOnWriteArrayList<e> r6 = didListenerCallbackList;     // Catch: Throwable -> L35 InterruptedException -> L37
        if ((!r6.isEmpty()) == false) goto L26;
        r4 = r4 + 1;     // Catch: Throwable -> L35 InterruptedException -> L37
        if (r4 > 10) goto L9;
        long r7 = ID_FAST_POLLING_INTERVAL_MS;
    L10:
        Thread.sleep(r7);     // Catch: Throwable -> L35 InterruptedException -> L37
        InteractorLegacyAppLogHelper r8 = INSTANCE;     // Catch: Throwable -> L35 InterruptedException -> L37
        String r9 = r8.getDeviceId();     // Catch: Throwable -> L35 InterruptedException -> L37
        if (r9.length() <= 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L55;
        if (Intrinsics.areEqual(r9, "0") == true) goto L55;
        String r11 = r8.getInstallId();     // Catch: Throwable -> L35 InterruptedException -> L37
        SLogger.INSTANCE.i(TAG, "ids ready after polling, from=" + r13 + ", retry=" + r4);     // Catch: Throwable -> L35 InterruptedException -> L37
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L35 InterruptedException -> L37
        r5.append("polling:");     // Catch: Throwable -> L35 InterruptedException -> L37
        r5.append(r13);     // Catch: Throwable -> L35 InterruptedException -> L37
        r8.updateBdTuringId(r9, r11, r5.toString());     // Catch: Throwable -> L35 InterruptedException -> L37
        r8.notifyDidListeners(r9, r11, "polling:" + r13);     // Catch: Throwable -> L35 InterruptedException -> L37
        idNotifyScheduled.set(false);
        if ((!r6.isEmpty()) == true) goto L21;
        return;
    L21:
        if (r8.getDeviceId().length() != 0) goto L23;
        r3 = true;
    L23:
        if (r3 == false) goto L63;
        r8.scheduleIdsReadyCheck("reschedule:" + r13);
        return;
    L63:
        return;
    L13:
        r10 = false;
        goto L14
    L9:
        r7 = ID_SLOW_POLLING_INTERVAL_MS;
        goto L10
    L26:
        SLogger.INSTANCE.i(TAG, "ids polling stopped with no listener, from=" + r13);     // Catch: Throwable -> L35 InterruptedException -> L37
        idNotifyScheduled.set(false);
        if ((!r6.isEmpty()) == false) goto L46;
        InteractorLegacyAppLogHelper r0 = INSTANCE;
        if (r0.getDeviceId().length() != 0) goto L32;
        r3 = true;
    L32:
        if (r3 == false) goto L64;
        StringBuilder r1 = new StringBuilder("reschedule:");
    L34:
        r1.append(r13);
        r0.scheduleIdsReadyCheck(r1.toString());
        return;
    L64:
        return;
    L46:
        return;
    L37:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L35
        SLogger.INSTANCE.w(TAG, "ids polling interrupted", e);     // Catch: Throwable -> L35
        idNotifyScheduled.set(false);
        if ((!didListenerCallbackList.isEmpty()) == false) goto L66;
        r0 = INSTANCE;
        if (r0.getDeviceId().length() != 0) goto L44;
        r3 = true;
    L44:
        if (r3 == false) goto L67;
        r1 = new StringBuilder("reschedule:");
        goto L34
    L67:
        return;
    L66:
        return;
    L35:
        th = move-exception;
        idNotifyScheduled.set(false);
        if ((!didListenerCallbackList.isEmpty()) == false) goto L54;
        InteractorLegacyAppLogHelper r2 = INSTANCE;
        if (r2.getDeviceId().length() != 0) goto L52;
        r3 = true;
    L52:
        if (r3 == false) goto L54;
        r2.scheduleIdsReadyCheck("reschedule:" + r13);
    L54:
        throw th;
    }

    private final Bundle toBundle(Map<?, ?> r5) {
        Bundle r0 = new Bundle();
        Iterator<Map.Entry<?, ?>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<?, ?> r1 = r6.next();
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        if (r2 == null) goto L4;
        String r4 = r2.toString();
        if (r4 == null) goto L4;
        if (r3 == null) goto L4;
        INSTANCE.addToBundle(r0, r4, r3);
        goto L4
    L12:
        return r0;
    }

    public final void addCommonParamInterceptor(d r3) {
        Intrinsics.checkNotNullParameter(r3, "eventInterceptor");
        CopyOnWriteArrayList<d> r0 = commonParamInterceptors;
        if (r0.contains(r3) == true) goto L6;
        r0.add(r3);
        return;
    }

    public final void addGetAppLogIdListener(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        didListenerCallbackList.add(r2);
        notifyIdsReadyIfNeeded("addGetAppLogIdListener");
    }

    public final void doWhenIdsReady(Function2<? super String, ? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "action");
        String r0 = getDeviceId();
        String r1 = getInstallId();
        boolean r3 = true;
        if (r0.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L14:
        addGetAppLogIdListener(new doWhenIdsReady.1(r6));
        return;
    L8:
        if (r1.length() > 0) goto L11;
        r3 = false;
    L11:
        if (r3 == false) goto L14;
        updateBdTuringId(r0, r1, "doWhenIdsReady");
        r6.invoke(r0, r1);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final synchronized void init(final v48.a r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "configInfo");     // Catch: Throwable -> L20
        if (initialized == false) goto L9;
        SLogger.INSTANCE.i(TAG, "init skipped: already initialized");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L9:
        ObricContextServiceDelegate r1 = ObricContextServiceDelegate.b;     // Catch: Throwable -> L20
        AppHost.Companion r2 = AppHost.a;     // Catch: Throwable -> L20
        if (r1.a(r2.getApplication().getApplicationContext()) == true) goto L14;
        SLogger.INSTANCE.i(TAG, "init skipped: not interactor process");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L14:
        NetworkClient.setDefault(new px3.a());     // Catch: Throwable -> L20
        SLogger.INSTANCE.i(TAG, "init legacy AppLog: configInfo=" + r6);     // Catch: Throwable -> L20
        mConfigInfo = r6;     // Catch: Throwable -> L20
        AppLog.b0 = 0;     // Catch: Throwable -> L20
        g.d = 0;     // Catch: Throwable -> L20
        AppLog.g0.r();     // Catch: Throwable -> L20
        AppLog.g0.j(r6.i);     // Catch: Throwable -> L20
        AppLog.g0.f(r6.j);     // Catch: Throwable -> L20
        AppLog.g0.B();     // Catch: Throwable -> L20
        if (r2.isDebug() == false) goto L17;
        Logger.setLogLevel(2);     // Catch: Throwable -> L20
        AppLog.g0.n(new InteractorAppLogLogger(TAG));     // Catch: Throwable -> L20
    L17:
        eta.b r0 = new InteractorLegacyAppLogHelper$init$appContext$1(r6);     // Catch: Throwable -> L20
        Context r3 = r2.getApplication().getApplicationContext();     // Catch: Throwable -> L20
        m0 r4 = m0.h;     // Catch: Throwable -> L20
        i0 r5 = new i0();     // Catch: Throwable -> L20
        r5.e = r3;     // Catch: Throwable -> L20
        r5.g = r4;     // Catch: Throwable -> L20
        r5.f = true;     // Catch: Throwable -> L20
        r5.a = r0;     // Catch: Throwable -> L20
        r5.d = new InteractorLegacyAppLogHelper$init$config$1(r6);     // Catch: Throwable -> L20
        r5.b = new j0();     // Catch: Throwable -> L20
        r5.c = getHeaderInfo();     // Catch: Throwable -> L20
        g0.a(r5.a());     // Catch: Throwable -> L20
        initialized = true;     // Catch: Throwable -> L20
        notifyIdsReadyIfNeeded("init");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void removeCommonParamInterceptor(d r2) {
        Intrinsics.checkNotNullParameter(r2, "eventInterceptor");
        commonParamInterceptors.remove(r2);
    }

    public final void removeDidListener(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        didListenerCallbackList.remove(r2);
    }

    public final void removeEventCommonParams(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        eventCommonParamsMap.remove(r2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.sva.sdk.applog.a] */
    public final void setBDAccountCallback(final Pair<Integer, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "pair");
        ?? r0 = new a(r2);
        AppLog.g0.o(r0);
        AppLog.g0.q();
    }

    public final void addEventCommonParams(String r2, Function0<? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "valueGenerator");
        eventCommonParamsGenerators.put(r2, r3);
    }

    public final void onMiscEvent(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "logType");
        Intrinsics.checkNotNullParameter(r5, "obj");
        SLogger.INSTANCE.i(TAG, "onMiscEvent: " + r4 + ": " + r5);
        AppLog.recordMiscLog(AppHost.a.getApplication(), r4, r5);
    }

    public final void putEventCommonParams(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        eventCommonParamsMap.put(r2, r3);
    }

    public final void reportEvent(String r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, EventVerify.TYPE_EVENT_V1);
        SLogger.INSTANCE.d(TAG, r6 + ": " + r7);
        if (r7 != null) goto L5;
        Bundle r0 = new Bundle();
    L26:
        Iterator<T> r1 = commonParamInterceptors.iterator();     // Catch: Exception -> L22
    L8:
        if (r1.hasNext() == false) goto L10;
        ((d) r1.next()).a(r6, r7);     // Catch: Exception -> L22
        goto L8
    L10:
        Iterator<Map.Entry<String, Function0<Object>>> r8 = eventCommonParamsGenerators.entrySet().iterator();     // Catch: Exception -> L22
    L12:
        if (r8.hasNext() == false) goto L17;
        Map.Entry<String, Function0<Object>> r2 = r8.next();     // Catch: Exception -> L22
        String r3 = r2.getKey();     // Catch: Exception -> L22
        Object r4 = r2.getValue().invoke();     // Catch: Exception -> L22
        if (r0.containsKey(r3) == true) goto L12;
        if (r4 == null) goto L12;
        INSTANCE.addToBundle(r0, r3, r4);     // Catch: Exception -> L22
        goto L12
    L17:
        Iterator<Map.Entry<String, Object>> r9 = eventCommonParamsMap.entrySet().iterator();     // Catch: Exception -> L22
    L18:
        if (r9.hasNext() == false) goto L24;
        Map.Entry<String, Object> r5 = r9.next();     // Catch: Exception -> L22
        INSTANCE.addToBundle(r0, r5.getKey(), r5.getValue());     // Catch: Exception -> L22
    L24:
        AppLogNewUtils.onEventV3Bundle(r6, r0);
        return;
    L22:
        e = move-exception;
        SLogger.INSTANCE.e(TAG, "reportEvent: Bundle params error", e);
        goto L24
    L5:
        r0 = r7;
        goto L26
    }

    public final void reportEvent(String r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r6, EventVerify.TYPE_EVENT_V1);
        if (r7 != null) goto L5;
        r7 = new JSONObject();
    L5:
        SLogger.INSTANCE.i(TAG, r6 + ": " + r7);
        Iterator<T> r0 = commonParamInterceptors.iterator();     // Catch: Exception -> L22
    L8:
        if (r0.hasNext() == false) goto L10;
        ((d) r0.next()).intercept(r6, r7);     // Catch: Exception -> L22
        goto L8
    L10:
        Iterator<Map.Entry<String, Function0<Object>>> r1 = eventCommonParamsGenerators.entrySet().iterator();     // Catch: Exception -> L22
    L12:
        if (r1.hasNext() == false) goto L17;
        Map.Entry<String, Function0<Object>> r2 = r1.next();     // Catch: Exception -> L22
        String r3 = r2.getKey();     // Catch: Exception -> L22
        Object r4 = r2.getValue().invoke();     // Catch: Exception -> L22
        if (r7.has(r3) == true) goto L12;
        if (r4 == null) goto L12;
        r7.put(r3, r4);     // Catch: Exception -> L22
        goto L12
    L17:
        Iterator<Map.Entry<String, Object>> r5 = eventCommonParamsMap.entrySet().iterator();     // Catch: Exception -> L22
    L18:
        if (r5.hasNext() == false) goto L24;
        Map.Entry<String, Object> r8 = r5.next();     // Catch: Exception -> L22
        INSTANCE.addToJSONObject(r7, r8.getKey(), r8.getValue());     // Catch: Exception -> L22
    L24:
        AppLogNewUtils.onEventV3(r6, r7);
        return;
    L22:
        e = move-exception;
        SLogger.INSTANCE.e(TAG, "reportEvent: JSONObject params error", e);
        goto L24
    }

    private final void addToBundle(Bundle r3, String r4, Object r5) {
        if (r3.containsKey(r4) == false) goto L6;
        return;
    L6:
        if ((r5 instanceof String) == false) goto L9;
        r3.putString(r4, (String) r5);
        return;
    L9:
        if ((r5 instanceof Integer) == false) goto L12;
        r3.putInt(r4, ((Number) r5).intValue());
        return;
    L12:
        if ((r5 instanceof Long) == false) goto L15;
        r3.putLong(r4, ((Number) r5).longValue());
        return;
    L15:
        if ((r5 instanceof Boolean) == false) goto L18;
        r3.putBoolean(r4, ((Boolean) r5).booleanValue());
        return;
    L18:
        if ((r5 instanceof Float) == false) goto L21;
        r3.putFloat(r4, ((Number) r5).floatValue());
        return;
    L21:
        if ((r5 instanceof Double) == false) goto L24;
        r3.putDouble(r4, ((Number) r5).doubleValue());
        return;
    L24:
        if (AppHost.a.isTestChannel() == true) goto L27;
        return;
    L27:
        throw new IllegalArgumentException("addToBundle -> unsupported type: ".concat(r5.getClass().getName()));
    }

    private final void addToJSONObject(JSONObject r3, String r4, Object r5) {
        if (r3.has(r4) == false) goto L6;
        return;
    L6:
        if ((r5 instanceof String) == false) goto L9;
        r3.put(r4, r5);
        return;
    L9:
        if ((r5 instanceof Integer) == false) goto L12;
        r3.put(r4, ((Number) r5).intValue());
        return;
    L12:
        if ((r5 instanceof Long) == false) goto L15;
        r3.put(r4, ((Number) r5).longValue());
        return;
    L15:
        if ((r5 instanceof Boolean) == false) goto L18;
        r3.put(r4, ((Boolean) r5).booleanValue());
        return;
    L18:
        if ((r5 instanceof Float) == false) goto L21;
        r3.put(r4, r5);
        return;
    L21:
        if ((r5 instanceof Double) == false) goto L24;
        r3.put(r4, ((Number) r5).doubleValue());
        return;
    L24:
        if (AppHost.a.isTestChannel() == true) goto L28;
        Unit r6 = Unit.INSTANCE;
        return;
    L28:
        throw new IllegalArgumentException("addToJSONObject -> unsupported type: ".concat(r5.getClass().getName()));
    }

    private final void notifyDidListeners(String r7, String r8, String r9) {
        String r0 = getStringFromAppLog(new String[]{"getSsid"});
        Iterator<T> r1 = didListenerCallbackList.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        e r2 = (e) r1.next();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        r2.onGetId(r7, r8, r0);     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L4;
        SLogger.INSTANCE.w(TAG, "notify did listener failed, from=" + r9, r5);
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    private final void updateBdTuringId(String r4, String r5, String r6) {
        SLogger.INSTANCE.i(TAG, "updateBdTuringId: " + r6 + ", did=" + r4 + ", iid=" + r5);
        qb4.b r7 = qb4.b.c.a;
        BdTuringConfig r0 = r7.a;
        if (r0 == null) goto L5;
        r0.setDeviceId(r4);
    L5:
        BdTuringConfig r8 = r7.a;
        if (r8 == null) goto L9;
        r8.setInstallId(r5);
        return;
    }

    public static final /* synthetic */ void access$updateBdTuringId(InteractorLegacyAppLogHelper r0, String r1, String r2, String r3) {
        r0.updateBdTuringId(r1, r2, r3);
    }
}
