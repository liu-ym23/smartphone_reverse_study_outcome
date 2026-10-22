package com.obric.assistant.audio;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanManager;
import com.obric.assistant.spi.account.IObricAccountSPIService;
import com.obric.assistant.spi.audio.IObricEnrollInteropService;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.t1;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.voice.k;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.audio.enroll.VoiceEnrollServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\t2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\u000e\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0002\u0010!J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\tH\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\tH\u0016J\u0010\u00103\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\f\u00105\u001a\u00020\u0007*\u000206H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/assistant/audio/ObricEnrollInteropServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService;", "<init>", "()V", "ipcScope", "Lkotlinx/coroutines/CoroutineScope;", "setAssistantEnrollingStatus", NameKeys.UnloadStrategy_No_Strategy, "enrolling", NameKeys.UnloadStrategy_No_Strategy, "trackEnrollData", "eventId", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "setVoiceWakeupEnabled", "enabled", "setContinueSpeakNoiseReductionEnabled", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted", "uid", "isVoiceWakeupEnabled", "migrateLegacyPhoneWakeupSettingsToPersonalUid", "isBreathWakeupEnabled", "setBreathWakeupEnabled", "applyBreathWakeupEnabled", "isLockedScreenUseEnabled", "saveVoicePrintAuthenticationTypeForLockedUseSettings", "isSetDefaultSettingItems", "currentSettingItems", NameKeys.UnloadStrategy_No_Strategy, "setHelpImproveVoiceWakeupEnabled", "isHelpImproveVoiceWakeupEnabled", "refreshHelpImproveVoiceWakeupEnabled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrateLegacyVoiceWakeupSwitch", "personalUid", "migrateLegacyBreathWakeupSwitch", "storeHelpImproveVoiceWakeupEnabled", "syncHelpImproveVoiceWakeupEnabled", "getHelpImproveVoiceWakeupKeva", "Lcom/bytedance/keva/Keva;", "requestEnrollGuideRecordPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService$EnrollPermissionCallback;", "useSystemDrawableForEnrollGuide", "getDeviceUuid", "buildDoraEngineVersionJson", "buildObricContPvadVersionJson", "isCurrentSessionFromBreathWakeup", "setSvaSdkEnrollingStatus", "reloadVoiceWakeupSamiCore", "safeClose", "Landroid/content/ContentProviderClient;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrollInteropServiceImpl implements IObricEnrollInteropService {
    public static final /* synthetic */ int b = 0;
    public final CoroutineScope a;

    public static final class a {
    }

    public static final class b implements IObricPermissionService.a {
        public final /* synthetic */ IObricEnrollInteropService.a a;

        public b(IObricEnrollInteropService.a r1) {
            this.a = r1;
        }

        public final void a(boolean r2, boolean r3, List<String> r4, List<String> r5) {
            Intrinsics.checkNotNullParameter(r4, "grantedList");
            Intrinsics.checkNotNullParameter(r5, "deniedList");
            this.a.a(r2, r3, r4, r5);
        }
    }

    static {
    }

    public final void p() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        IObricAccountSPIService r2 = (IObricAccountSPIService) ServiceManager.get().getService(IObricAccountSPIService.class);     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        String r3 = r2.a();     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L15;
        FLogger.a.e("ObricEnrollInteropServiceImpl", "migrateLegacyPhoneWakeupSettings get personal uid failed: " + r5.getMessage());
    L15:
        if (Result.isFailure-impl(r4) == true) goto L18;
        r0 = r4;
    L18:
        String r6 = (String) r0;
        if (r6 != null) goto L22;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L22:
        if (StringsKt.isBlank(r6) == false) goto L25;
        FLogger.a.i("ObricEnrollInteropServiceImpl", "migrateLegacyPhoneWakeupSettings skip: personal uid blank");
        return;
    L25:
        Lazy r7 = pia.d.a;
        Intrinsics.checkNotNullParameter(r6, "uid");
        boolean r8 = false;
        if (StringsKt.isBlank(r6) == false) goto L28;
        boolean r9 = false;
    L30:
        if (r9 == false) goto L70;
    L47:
        Intrinsics.checkNotNullParameter(r6, "uid");
        if (StringsKt.isBlank(r6) == false) goto L50;
        boolean r10 = false;
    L51:
        if (r10 == true) goto L74;
    L58:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Object r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L60:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L63;
        FLogger.a.e("ObricEnrollInteropServiceImpl", "migrateLegacyBreathWakeupSwitch read legacy failed: " + r13.getMessage());
    L63:
        Boolean r14 = Boolean.FALSE;
        if (Result.isFailure-impl(r12) == false) goto L66;
        r12 = r14;
    L66:
        boolean r15 = ((Boolean) r12).booleanValue();
        pia.d.n(r6, r15);
        FLogger.a.i("ObricEnrollInteropServiceImpl", "migrateLegacyBreathWakeupSwitch uidLen=" + r6.length() + " enabled=" + r15);
        return;
    L54:
        if (Keva.getRepo("default_sva", 1).getInt("breath_wakeup_status", 0) != 1) goto L56;
        r8 = true;
    L56:
        r12 = Result.constructor-impl(Boolean.valueOf(r8));     // Catch: Throwable -> L58
        goto L60
    L74:
        return;
    L50:
        r10 = pia.d.i().contains("breath_wakeup_enabled_".concat(r6));
        goto L51
    L70:
    L38:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Object r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L43;
        FLogger.a.e("ObricEnrollInteropServiceImpl", "migrateLegacyVoiceWakeupSwitch read legacy failed: " + r18.getMessage());
    L43:
        Boolean r19 = Boolean.FALSE;
        if (Result.isFailure-impl(r17) == false) goto L46;
        r17 = r19;
    L46:
        boolean r20 = ((Boolean) r17).booleanValue();
        pia.d.r(r6, r20);
        FLogger.a.i("ObricEnrollInteropServiceImpl", "migrateLegacyVoiceWakeupSwitch uidLen=" + r6.length() + " enabled=" + r20);
        goto L47
    L33:
        if (Keva.getRepo("default_sva", 1).getInt("voice_assistant_wakeup_status", 0) != 1) goto L35;
        boolean r21 = true;
    L36:
        r17 = Result.constructor-impl(Boolean.valueOf(r21));     // Catch: Throwable -> L38
        goto L40
    L35:
        r21 = false;
        goto L36
    L28:
        r9 = pia.d.i().contains("voice_wakeup_enabled_".concat(r6));
        goto L30
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final String A() {
        String r0 = AccountService.a.getUserId();
        String r1 = obricDeviceManagerDelegate.b.getUuid();
        String r2 = wda.b.a();
        if (r2 != null) goto L5;
        String r3 = r1;
    L6:
        JSONObject r4 = new JSONObject();
        r4.put("engine_version", "1.0.0.100");
        r4.put("voice_print_id", r0 + '-' + r3);
        VoiceEnrollServiceDelegate r5 = VoiceEnrollServiceDelegate.c;
        if (r2 != null) goto L9;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        r4.put("has_feature", r5.r(r2));
        r4.put("default_did", r1);
        return r4.toString();
    L5:
        r3 = r2;
        goto L6
    }

    public final boolean b() {
        return t1.a.b();
    }

    public final String c() {
        return obricDeviceManagerDelegate.b.getUuid();
    }

    public final boolean d() {
        IObricVoiceService.a.getClass();
        IObricVoiceService r0 = IObricVoiceService.a.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d() != true) goto L7;
        return true;
    }

    public final boolean g() {
        IObricUserGuide r0 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.h() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void h() {
        t1.a.y(true);
    }

    public final boolean i() {
        return t1.a.i();
    }

    public final void o() {
        Context r0 = AppHost.a.getApplication().getApplicationContext();
        BuildersKt.launch$default(this.a, null, null, new ObricEnrollInteropServiceImpl$reloadVoiceWakeupSamiCore$1(r0, this, null), 3, null);
    }

    public final void s() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L13;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        if (StringsKt.isBlank(r2) == false) goto L15;
        return;
    L15:
        BuildersKt.launch$default(this.a, null, null, new ObricEnrollInteropServiceImpl$syncHelpImproveVoiceWakeupEnabled$1(true, r2, null), 3, null);
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean t() {
        return t1.a.x0();
    }

    public ObricEnrollInteropServiceImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public final String v() {
        CoWakeupApi r0 = uha.a.a();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
        if (r2 == false) goto L17;
        IDoraWakeupService r4 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r4 != null) goto L13;
    L15:
        if (r1 == false) goto L17;
        return NameKeys.UnloadStrategy_No_Strategy;
    L13:
        if (r4.n() == true) goto L15;
        r1 = true;
    L17:
        String r5 = AccountService.a.getUserId();
        String r6 = obricDeviceManagerDelegate.b.getUuid();
        String r7 = wda.b.a();
        if (r7 != null) goto L20;
        String r8 = r6;
    L21:
        JSONObject r9 = new JSONObject();
        r9.put("engine_version", "1.0.0.100");
        r9.put("voice_print_id", r5 + '-' + r8);
        VoiceEnrollServiceDelegate r10 = VoiceEnrollServiceDelegate.c;
        if (r7 == null) goto L25;
        r3 = r7;
    L25:
        r9.put("has_feature", r10.r(r3));
        r9.put("default_did", r6);
        return r9.toString();
    L20:
        r8 = r7;
        goto L21
    L5:
        if (r0.b() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static void B(ContentProviderClient r2) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r2.close();
        return;
    L5:
        r2.release();
    }

    public final void f(boolean r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L13;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        if ((!StringsKt.isBlank(r2)) == false) goto L15;
        pia.d.r(r2, r3);
    L15:
        t1.a.f(r3);
        return;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(boolean r6) {
        Bundle r1 = new Bundle();
        r1.putBoolean("status", r6);
        ContentProviderClient r7 = 0;
        ContentProviderClient r2 = a(AppHost.a.getApplication().getContentResolver(), k.a);     // Catch: Throwable -> L11 RemoteException -> L13
        if (r2 != null) goto L25;
    L9:
        if (r2 == null) goto L28;
    L17:
        B(r2);
        return;
    L28:
        return;
    L25:
        r2.call("breath-set-status", null, r1);     // Catch: RemoteException -> L7 Throwable -> L19
    L7:
        RemoteException e = e;
    L15:
        FLogger.a.e("ObricEnrollInteropServiceImpl", "applyBreathWakeupEnabled failed: " + e.getMessage());     // Catch: Throwable -> L19
        if (r2 != null) goto L17;
        return;
    L19:
        th = move-exception;
        th = th;
        r7 = "status";
    L21:
        if (r7 == 0) goto L23;
        B(r7);
    L23:
        throw th;
    L13:
        e = move-exception;
        r2 = null;
        e = e;
    L11:
        th = th;
        goto L21
    }

    public final boolean m(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        if (StringsKt.isBlank(r4) == false) goto L21;
        return false;
    L21:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = null;
    L12:
        String r2 = (String) r1;
        if (r2 != null) goto L16;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        if (Intrinsics.areEqual(r4, r2) == false) goto L20;
        return t1.a.x0();
    L20:
        return Keva.getRepo("obric_settings_".concat(r4), 0).getBoolean("voice_wakeup_audio_upload_enable", false);
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final Object q(Continuation<? super Boolean> r5) {
        if ((r5 instanceof ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1) == false) goto L7;
        ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1 r0 = (ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L18:
        return Boxing.boxBoolean(((ObricUserExperiencePlanManager.a) r6).a);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        ObricUserExperiencePlanManager r7 = ObricUserExperiencePlanManager.a;
        r0.label = 1;
        r6 = r7.f(r0);
        if (r6 != r2) goto L18;
        return r2;
    L7:
        r0 = new ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1(this, r5);
        goto L8
    }

    public final boolean u(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        if (StringsKt.isBlank(r5) == false) goto L5;
        return false;
    L5:
        p();
        Lazy r1 = pia.d.a;
        Intrinsics.checkNotNullParameter(r5, "uid");
        if (StringsKt.isBlank(r5) == false) goto L9;
        return false;
    L9:
        return pia.d.i().getBoolean("voice_wakeup_enabled_" + r5, false);
    }

    public final void w(boolean r2) {
        IObricVoiceService.a.getClass();
        IObricVoiceService r0 = IObricVoiceService.a.a();
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }

    public final void x(boolean r11) {
        Bundle r3 = new Bundle();
        r3.putBoolean("status", r11);
        r3.putBinder("owner_token", com.obric.assistant.voice.c.a);
        r3.putLong("ipc_generation", com.obric.assistant.voice.c.b);
        Context r2 = AppHost.a.getApplication().getApplicationContext();
        BuildersKt.launch$default(this.a, null, null, new ObricEnrollInteropServiceImpl$setSvaSdkEnrollingStatus$1(r11, r2, r3, this, null), 3, null);
    }

    public final boolean y(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        if (StringsKt.isBlank(r5) == false) goto L5;
        return false;
    L5:
        p();
        Lazy r1 = pia.d.a;
        Intrinsics.checkNotNullParameter(r5, "uid");
        if (StringsKt.isBlank(r5) == false) goto L9;
        return false;
    L9:
        return pia.d.i().getBoolean("breath_wakeup_enabled_" + r5, false);
    }

    public final void z(String r6) {
        Intrinsics.checkNotNullParameter(r6, "uid");
        if (StringsKt.isBlank(r6) == false) goto L6;
        FLogger.a.i("ObricEnrollInteropServiceImpl", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted skip: blank uid");
        return;
    L6:
        Lazy r1 = pia.d.a;
        Intrinsics.checkNotNullParameter(r6, "uid");
        if (StringsKt.isBlank(r6) == true) goto L25;
        pia.d.i().storeBoolean("locked_auth_type_cleared_".concat(r6), true);
    L25:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r2 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r2) == false) goto L17;
        r2 = null;
    L17:
        String r3 = (String) r2;
        if (r3 != null) goto L21;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L21:
        if (Intrinsics.areEqual(r6, r3) == false) goto L23;
        t1.a.h0();
        return;
    L23:
        FLogger.a.i("ObricEnrollInteropServiceImpl", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted uidLen=" + r6.length() + " currentUidLen=" + r3.length() + ", record only (not current login)");
        return;
    L12:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static ContentProviderClient a(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final void e(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.DATA_KEY);
        IObricVoiceService.a.getClass();
        IObricVoiceService r0 = IObricVoiceService.a.a();
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    public final void k(FragmentActivity r10, IObricEnrollInteropService.a r11) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        Intrinsics.checkNotNullParameter(r11, "callback");
        IObricPermissionService r1 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r1 != null) goto L6;
        r11.a(true, false, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L6:
        IObricPermissionService.a.getClass();
        r1.n(r10, IObricPermissionService.Companion.d, true, false, false, false, new b(r11));
    }

    public final void l(boolean r2, List<String> r3) {
        t1.a.l(r2, r3);
    }

    public final void n(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "uid");
        if (StringsKt.isBlank(r6) == false) goto L6;
        FLogger.a.i("ObricEnrollInteropServiceImpl", "setVoiceWakeupEnabled skip: blank uid enabled=" + r7);
        return;
    L6:
        pia.d.r(r6, r7);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r1) == false) goto L14;
        r1 = null;
    L14:
        String r2 = (String) r1;
        if (r2 != null) goto L18;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        if (Intrinsics.areEqual(r6, r2) == false) goto L20;
        t1.a.f(r7);
        return;
    L20:
        FLogger.a.i("ObricEnrollInteropServiceImpl", "setVoiceWakeupEnabled uidLen=" + r6.length() + " currentUidLen=" + r2.length() + " enabled=" + r7 + ", record only (not current login)");
        return;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void r(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "uid");
        if (StringsKt.isBlank(r6) == false) goto L6;
        FLogger.a.i("ObricEnrollInteropServiceImpl", "setBreathWakeupEnabled skip: blank uid enabled=" + r7);
        return;
    L6:
        pia.d.n(r6, r7);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r1) == false) goto L14;
        r1 = null;
    L14:
        String r2 = (String) r1;
        if (r2 != null) goto L18;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        if (Intrinsics.areEqual(r6, r2) == false) goto L20;
        j(r7);
        return;
    L20:
        FLogger.a.i("ObricEnrollInteropServiceImpl", "setBreathWakeupEnabled uidLen=" + r6.length() + " currentUidLen=" + r2.length() + " enabled=" + r7 + ", record only (not current login)");
        return;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
