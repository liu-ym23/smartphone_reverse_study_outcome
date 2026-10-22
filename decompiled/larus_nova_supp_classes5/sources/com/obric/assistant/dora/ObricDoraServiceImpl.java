package com.obric.assistant.dora;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import com.larus.audio.call.arch.c;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricAvailableManager;
import com.obric.assistant.common.spi.IObricFeatureService;
import com.obric.assistant.dora.record_minutes.DoraRecordMinutesService;
import com.obric.assistant.multiuser.api.IObricMultiUserService;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.obric.assistant.t1;
import com.obric.audio.dora.IObricDoraPluginProvider;
import com.obric.audio.enroll.IVoiceEnrollService;
import com.obric.audio.rtc_context.IObricDoraContextProvider;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016JF\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0016J2\u0010#\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J$\u0010+\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\u0014\u00102\u001a\u0004\u0018\u0001032\b\u0010\u0017\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u00010 2\b\u00106\u001a\u0004\u0018\u00010 2\b\u00107\u001a\u0004\u0018\u00010 H\u0016¨\u00069"}, d2 = {"Lcom/obric/assistant/dora/ObricDoraServiceImpl;", "Lcom/obric/assistant/spi/dora/IObricDoraService;", "<init>", "()V", "needHideDoraOwenSetting", "", "needHideDoraProactiveSetting", "needHideDoraKeepAliveBalloon", "doraUseObricLogic", "isDoraKeepAliveEnableForObric", "isDoraNewDeviceManageEnable", "hideDoraVoiceWakeupSettingItems", "", "view", "", "Landroid/view/View;", "showDoraVoiceWakeupSettingItems", "listOf", "disableDoraInLiveTutor", "isObricWakeupModelEngine", "isCurrentMainUser", "isObricSmartNotificationEnable", "openDoraGRecordMinutesPage", "context", "Landroid/content/Context;", "handleDoraGRecordMinutes", "state", "", "mode", DownloadConstants.QUERY_KEY, "vuiId", "kw", "", "requestId", "source", "handleDoraGRecordMinutesWakeOff", "shouldInterceptDoraGRecordMinutes", "action", "enableDoraGRecordIntercept", "onMainProcessDoraStarted", "application", "Landroid/app/Application;", "isDoraGOnObric", "getObricContext", "", "roundId", "", "forceUpdateFull", "getPersonalContext", "Lorg/json/JSONObject;", "getDoraObricPlugin", "", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraServiceImpl implements IObricDoraService {
    static {
    }

    public ObricDoraServiceImpl() {
    }

    public final boolean j() {
        return true;
    }

    public final boolean q() {
        return false;
    }

    public final boolean r() {
        return false;
    }

    public final JSONObject c() {
        IObricDoraContextProvider.a.getClass();
        IObricDoraContextProvider r0 = (IObricDoraContextProvider) ServiceManager.get().getService(IObricDoraContextProvider.class, false, false);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public final boolean e() {
        IObricMultiUserService.a.getClass();
        IObricMultiUserService r0 = IObricMultiUserService.a.a();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.a() != true) goto L7;
    L8:
        FLogger.a.i("ObricDoraServiceImpl", "isCurrentMainUser " + r1);
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public final boolean g() {
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r0 = IObricAvailableManager.a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        FLogger.a.i("ObricDoraServiceImpl", "needHideDoraOwenSetting: isDefaultAssistant=" + r1);
        return r1;
    L5:
        r1 = true;
        goto L6
    }

    public final boolean h() {
        boolean r0 = t1.a.S1();
        FLogger.a.i("ObricDoraServiceImpl", "isNewDeviceManageEnable: enabled=" + r0);
        return r0;
    }

    public final boolean k() {
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r0 = IObricAvailableManager.a.a();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.a() != true) goto L7;
    L8:
        FLogger.a.i("ObricDoraServiceImpl", "isDoraGOnObric: isDefaultAssistant=" + r1);
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public final boolean m() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        boolean r2 = false;
        if (AppHost.a.getApplication().getPackageManager().getPackageInfo("com.obric.smartnotification", 0) == null) goto L5;
        r2 = true;
    L5:
        Object r1 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L7
    L9:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = r3;
    L12:
        boolean r4 = ((Boolean) r1).booleanValue();
        FLogger.a.i("ObricDoraServiceImpl", "isObricSmartNotificationEnable " + r4);
        return r4;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final boolean n() {
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r0 = IObricAvailableManager.a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        boolean r2 = m();
        FLogger.a.i("ObricDoraServiceImpl", "needHideDoraProactiveSetting: isDefaultAssistant=" + r1 + ", isObricSmartNotificationEnable=" + r2);
        if (r1 == false) goto L10;
        if (r2 == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = true;
        goto L6
    }

    public final boolean t() {
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r0 = IObricAvailableManager.a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L13;
        DeviceService r3 = r2.device();
        if (r3 == null) goto L13;
        if (r3.S() != true) goto L13;
        boolean r4 = true;
    L14:
        FLogger.a.i("ObricDoraServiceImpl", "doraUseObricLogic: isDefaultAssistant=" + r1 + ", isDoraGWearOn=" + r4);
        if (r1 == false) goto L18;
        if (r4 == true) goto L18;
        return true;
    L18:
        return false;
    L13:
        r4 = false;
        goto L14
    L5:
        r1 = true;
        goto L6
    }

    public static boolean u(String r13) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        DeviceService r2 = r0.device();
        if (r2 == null) goto L9;
        if (r2.M() != true) goto L9;
        boolean r3 = true;
    L10:
        IObricFeatureService r4 = (IObricFeatureService) ServiceManager.get().getService(IObricFeatureService.class);
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r6 = IObricAvailableManager.a.a();
        if (r6 == null) goto L19;
        boolean r7 = r6.a();
    L20:
        if (r3 == false) goto L24;
        if (r5 == false) goto L24;
        if (r7 == false) goto L24;
        boolean r8 = true;
    L25:
        if (r8 == false) goto L53;
        DoraRecordMinutesService.a.getClass();
        Application r9 = AppHost.a.getApplication();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L33
        PackageInfo r11 = r9.getPackageManager().getPackageInfo("com.obric.recorder", 0);     // Catch: Throwable -> L33
        if (Build.VERSION.SDK_INT < 28) goto L30;
        long r12 = r11.getLongVersionCode();     // Catch: Throwable -> L33
    L31:
        Object r14 = Result.constructor-impl(Long.valueOf(r12));     // Catch: Throwable -> L33
    L35:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L42;
        if ((r15 instanceof PackageManager.NameNotFoundException) == false) goto L40;
        FLogger.a.i("DoraRecordMinutesService", "getRecorderAppVersionCode failed, recorder app not installed");
        goto L42
    L40:
        FLogger.a.w("DoraRecordMinutesService", "getRecorderAppVersionCode failed, error=" + r15.getMessage(), r15);
    L42:
        if (Result.isFailure-impl(r14) == false) goto L44;
        r14 = null;
    L44:
        Long r16 = (Long) r14;
        if (r16 != null) goto L47;
    L49:
        boolean r17 = false;
    L50:
        FLogger.a.i("DoraRecordMinutesService", "isRecorderAppVersionSupportedForObricIntercept supported=" + r17 + ", recorderVersionCode=" + r16 + ", minVersionCode=1020600000");
        if (r17 == false) goto L53;
        boolean r18 = true;
    L54:
        if (r8 == false) goto L57;
        if (r18 == false) goto L57;
        r1 = true;
    L57:
        FLogger.a.i("ObricDoraServiceImpl", "shouldInterceptDoraGRecordMinutes action=" + r13 + ", shouldIntercept=" + r1 + ", isDoraG=" + r3 + ", isObricOs=" + r5 + ", isDefaultAssistant=" + r7 + ", isRecorderAppVersionSupported=" + r18);
        return r1;
    L47:
        if (r16.longValue() < 1020600000) goto L49;
        r17 = true;
        goto L50
    L30:
        r12 = r11.versionCode;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L53:
        r18 = false;
    L24:
        r8 = false;
        goto L25
    L19:
        r7 = true;
        goto L20
    L13:
        if (r4.b() != true) goto L15;
        r5 = true;
    L9:
        r3 = false;
        goto L10
    }

    public final void d(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "application");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L5
        r2.i("ObricDoraServiceImpl", "onMainProcessDoraStarted start DoraMainProcessBridgeService");     // Catch: Throwable -> L5
        r5.startService(new Intent(r5, DoraMainProcessBridgeService.class));     // Catch: Throwable -> L5
        r2.i("ObricDoraServiceImpl", "onMainProcessDoraStarted start DoraMainProcessBridgeService success");     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L13;
        FLogger.a.e("ObricDoraServiceImpl", "onMainProcessDoraStarted failed", r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean i(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (u("openPage") == true) goto L6;
        return false;
    L6:
        DoraRecordMinutesService.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        FLogger.a.i("DoraRecordMinutesService", "openRecordMinutesPage start recorder app, targetTab=wearable");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Intent r1 = new Intent();     // Catch: Throwable -> L9
        r1.setPackage("com.obric.recorder");     // Catch: Throwable -> L9
        r1.putExtra("com.obric.recorder.extra.TARGET_TAB", "wearable");     // Catch: Throwable -> L9
        r5.startActivity(r1);     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L9
    L11:
        Throwable r2 = Result.exceptionOrNull-impl(r6);
        if (r2 == null) goto L14;
        FLogger.a.e("DoraRecordMinutesService", "openRecordMinutesPage failed", r2);
    L14:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L18;
        r6 = r3;
    L18:
        return ((Boolean) r6).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void l(List<? extends View> r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r0 = IObricAvailableManager.a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        FLogger.a.i("ObricDoraServiceImpl", "hideDoraVoiceWakeupSettingItems: isDefaultAssistant=" + r1);
        if (r1 == true) goto L9;
        return;
    L9:
        Iterator<T> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        View r2 = (View) r6.next();
        if (r2 == null) goto L11;
        r2.setVisibility(8);
        goto L11
    L15:
        return;
    L5:
        r1 = true;
        goto L6
    }

    public final Object o(Object r5) {
        FLogger.a.i("ObricDoraServiceImpl", "getDoraObricPlugin");
        if ((r5 instanceof c) == false) goto L5;
        c r6 = (c) r5;
    L6:
        if (r6 == null) goto L11;
        IObricDoraPluginProvider.a.getClass();
        IObricDoraPluginProvider r0 = (IObricDoraPluginProvider) ServiceManager.get().getService(IObricDoraPluginProvider.class, false, false);
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.a(r6);
    L11:
        return null;
    L5:
        r6 = null;
        goto L6
    }

    public final void p(List<? extends View> r5) {
        Intrinsics.checkNotNullParameter(r5, "listOf");
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r0 = IObricAvailableManager.a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        FLogger.a.i("ObricDoraServiceImpl", "showDoraVoiceWakeupSettingItems: isDefaultAssistant=" + r1);
        if (r1 == true) goto L9;
        return;
    L9:
        Iterator<T> r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        View r2 = (View) r6.next();
        if (r2 == null) goto L11;
        r2.setVisibility(0);
        goto L11
    L15:
        return;
    L5:
        r1 = true;
        goto L6
    }

    public final Map<String, String> a(long r4, boolean r6) {
        IObricDoraContextProvider.a.getClass();
        IObricDoraContextProvider r0 = (IObricDoraContextProvider) ServiceManager.get().getService(IObricDoraContextProvider.class, false, false);
        if (r0 == null) goto L5;
        Map<String, String> r5 = r0.a(r4, r6);
    L6:
        if (r5 == null) goto L8;
        return r5;
    L8:
        return MapsKt.emptyMap();
    L5:
        r5 = null;
        goto L6
    }

    public final void b(String r5, String r6, String r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("updateBtHeadsetEnrollModelPaths firstKwsLen=");
        int r2 = 0;
        if (r5 == null) goto L5;
        int r3 = r5.length();
    L6:
        r1.append(r3);
        r1.append(" sidEnrollLen=");
        if (r6 == null) goto L9;
        int r4 = r6.length();
    L10:
        r1.append(r4);
        r1.append(" silentLen=");
        if (r7 == null) goto L13;
        r2 = r7.length();
    L13:
        r1.append(r2);
        r0.i("ObricDoraServiceImpl", r1.toString());
        IVoiceEnrollService.a.getClass();
        IVoiceEnrollService r8 = IVoiceEnrollService.a.a();
        if (r8 == null) goto L17;
        r8.b(r5, r6, r7);
        return;
    L17:
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final boolean f(int r13, int r14, int r15, int r16, String r17) {
        FLogger r0 = FLogger.a;
        r0.i("ObricDoraServiceImpl", "handleDoraGRecordMinutesWakeOff state=" + r13 + ", mode=" + r14 + ", query=" + r15 + ", vuiId=" + r16);
        if (u("wakeOff") == true) goto L5;
        return false;
    L5:
        DoraRecordMinutesService.a.getClass();
        DoraRecordMinutesService.c r1 = DoraRecordMinutesService.g;
        if (r1 != null) goto L9;
        r0.i("DoraRecordMinutesService", "handleStopRecordMinutes skipped, no pcm session, state=" + r13 + ", mode=" + r14 + ", query=" + r15 + ", vuiId=" + r16 + ", kw=" + r17);
        return false;
    L9:
        if (Intrinsics.areEqual(r1.b, "recorder_app") == false) goto L13;
        r0.i("DoraRecordMinutesService", "handleStopRecordMinutes stop recorder app pcm only, sessionId=" + r1.a);
        boolean r9 = DoraRecordMinutesService.i("recorder_app_wake_off", true);
        if (r9 == false) goto L16;
        DoraRecordMinutesService.e(FlowRuntime.a().getApplication());
        return r9;
    L16:
        return r9;
    L13:
        boolean r10 = DoraRecordMinutesService.f("结束录音", "wakeOff", r13, r14, r15, r16, r17, false);
        DoraRecordMinutesService.i("stop_record_minutes_query", true);
        return r10;
    }

    public final boolean s(int r10, int r11, int r12, int r13, String r14, String r15, String r16) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("handleDoraGRecordMinutes vuiId=");
        r1.append(r13);
        r1.append(", hasRequestId=");
        if (r15 == null) goto L5;
        boolean r3 = true;
    L6:
        r1.append(r3);
        r1.append(", source=");
        r1.append(r16);
        r0.i("ObricDoraServiceImpl", r1.toString());
        if (Intrinsics.areEqual(r16, "recorder_app") == false) goto L22;
        if (u("wakeUp") == true) goto L19;
        DoraRecordMinutesService.a.getClass();
        if (r15 != null) goto L13;
    L20:
        return true;
    L13:
        if ((!StringsKt.isBlank(r15)) == false) goto L15;
        String r2 = r15;
    L16:
        if (r2 == null) goto L20;
        DoraRecordMinutesService.c(r2, new DoraRecordMinutesService.h(false, r2, null, null, "start record rejected", 12));
        goto L20
    L15:
        r2 = null;
        goto L16
    L19:
        DoraRecordMinutesService.a.d(r10, r11, r12, r13, r14, r15, r16);
        goto L20
    L22:
        if (u("wakeUp") == true) goto L25;
        return false;
    L25:
        return DoraRecordMinutesService.a.d(r10, r11, r12, r13, r14, r15, r16);
    L5:
        r3 = false;
        goto L6
    }
}
