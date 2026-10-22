package com.obric.assistant.reporter.utils;

import android.bluetooth.BluetoothDevice;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.ObricWakeupSoundConfig;
import com.obric.assistant.ObricWakeupSoundOption;
import com.obric.assistant.common.spi.ObricConfigServiceDelegate;
import com.obric.assistant.common.utils.m;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.interaction.api.ISystemKeySettings;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.multiuser.api.IObricMultiUserService;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.ToggleName;
import com.obric.assistant.t1;
import com.obric.assistant.trace.IObricTraceParam;
import com.obric.assistant.utils.j;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import t9a.b;
import tha.c;
import uha.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.reporter.utils.ObricLaunchReportManager$reportLaunchEventForAssistant$1", f = "ObricLaunchReportManager.kt", i = {0, 2}, l = {293, 349, 352}, m = "invokeSuspend", n = {"$this$launch", "reporter"}, s = {"L$0", "L$0"})
public final class ObricLaunchReportManager$reportLaunchEventForAssistant$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $extraDelayTime;
    final /* synthetic */ boolean $isObricOS;
    final /* synthetic */ JSONObject $jsonParams;
    final /* synthetic */ String $launchMethod;
    final /* synthetic */ String $launchService;
    final /* synthetic */ String $launchWakeup;
    final /* synthetic */ String $sessionId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public ObricLaunchReportManager$reportLaunchEventForAssistant$1(JSONObject r1, String r2, boolean r3, long r4, String r6, String r7, String r8, Continuation<? super ObricLaunchReportManager$reportLaunchEventForAssistant$1> r9) {
        this.$jsonParams = r1;
        this.$launchWakeup = r2;
        this.$isObricOS = r3;
        this.$extraDelayTime = r4;
        this.$launchService = r6;
        this.$launchMethod = r7;
        this.$sessionId = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        ObricLaunchReportManager$reportLaunchEventForAssistant$1 r10 = new ObricLaunchReportManager$reportLaunchEventForAssistant$1(this.$jsonParams, this.$launchWakeup, this.$isObricOS, this.$extraDelayTime, this.$launchService, this.$launchMethod, this.$sessionId, r13);
        r10.L$0 = r12;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r9 = "";
        String r11 = "on";
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        IObricReporter r1 = (IObricReporter) this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r3 = r22;
        String r10 = null;
    L402:
        if (((Boolean) r3).booleanValue() == false) goto L404;
        String r4 = "gui_task";
    L407:
        if (r1 == null) goto L409;
        String r5 = r1.l();
    L410:
        String r6 = this.$launchService;
        if (r6 == null) goto L416;
        String r7 = this.$launchMethod;
        ObricLaunchReportManager r8 = ObricLaunchReportManager.a;
        if (r7 != null) goto L415;
        r7 = "";
    L415:
        String r12 = ObricLaunchReportManager.a(r8, r7, r6);
    L417:
        this.$jsonParams.put("obric_window_mode", r12);
        if (r4 != null) goto L420;
    L427:
        FLogger.a.i("ObricLaunchReportManager", "json params = " + this.$jsonParams);
        by7.g.d.onEvent(ObricLaunchReportManager.b, this.$jsonParams);
        Map r13 = ObricLaunchReportManager.R;
        String r14 = this.$sessionId;
        if (r14 == null) goto L431;
        r9 = r14;
    L431:
        r13.put(r9, this.$jsonParams);
        return Unit.INSTANCE;
    L420:
        if (Intrinsics.areEqual(r4, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER) == true) goto L427;
        if (Intrinsics.areEqual(this.$launchMethod, r4) == true) goto L425;
        this.$jsonParams.put(ObricLaunchReportManager.d, r4);
    L425:
        if (Intrinsics.areEqual(this.$launchService, r5) == true) goto L427;
        this.$jsonParams.put(ObricLaunchReportManager.g, r5);
        goto L427
    L416:
        r12 = r10;
        goto L417
    L409:
        r5 = r10;
        goto L410
    L404:
        if (r1 == null) goto L406;
        r4 = r1.a();
        goto L407
    L406:
        r4 = r10;
        goto L407
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r22);
    L395:
        IObricTraceParam r15 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r15 == null) goto L398;
        r15.g(this.$jsonParams);
    L398:
        IObricReporter.a.getClass();
        r1 = IObricReporter.a.a();
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        r10 = null;
        ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1 r17 = new ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1(null);
        this.L$0 = r1;
        this.label = 3;
        r3 = BuildersKt.withContext(r16, r17, this);
        if (r3 != r2) goto L402;
        return r2;
    L11:
        String r18 = (String) this.L$2;
        JSONObject r19 = (JSONObject) this.L$1;
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r20 = r22;
    L239:
        if (Intrinsics.areEqual(r20, Boxing.boxBoolean(true)) == false) goto L241;
        Object r21 = "on";
    L242:
        r19.put(r18, r21);
        JSONObject r23 = this.$jsonParams;
        String r24 = ObricLaunchReportManager.L;
        IBluetoothHeadSetAPI r25 = c.a();
        if (r25 != null) goto L245;
    L247:
        boolean r26 = false;
    L248:
        if (r26 == false) goto L250;
        String r27 = "yes";
    L251:
        r23.put(r24, r27);
        JSONObject r28 = this.$jsonParams;
        String r29 = ObricLaunchReportManager.N;
        String r30 = b.b().b().a();
        if (r30 != null) goto L254;
        r30 = "";
    L254:
        r28.put(r29, r30);
        m.a.getClass();
        if (m.a() == false) goto L283;
        JSONObject r31 = this.$jsonParams;
        String r32 = ObricLaunchReportManager.O;
        ObricLaunchReportManager.a.getClass();
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L259
        Object r34 = Result.constructor-impl(Integer.valueOf(Settings.Global.getInt(AppHost.a.getApplication().getContentResolver(), "power_button_long_press")));     // Catch: Throwable -> L259
    L262:
        if (Result.isFailure-impl(r34) == false) goto L264;
        r34 = null;
    L264:
        Integer r35 = (Integer) r34;
        String r36 = "not_selected";
        if (r35 != null) goto L268;
    L270:
        if (r35 != null) goto L273;
    L275:
        String r37 = "not_selected";
    L276:
        r31.put(r32, r37);
        JSONObject r38 = this.$jsonParams;
        String r39 = ObricLaunchReportManager.P;
        ObricLaunchReportManager.a.getClass();
        AppHost.Companion r40 = AppHost.a;
        String r41 = j.b(r40.getApplication());
        FLogger.a.i("ObricLaunchReportManager", "getDefaultAssistantValue: " + r41);
        if (Intrinsics.areEqual(r41, r40.getApplication().getPackageName()) == false) goto L280;
        r36 = "doubao_assistant";
    L282:
        r38.put(r39, r36);
        goto L283
    L280:
        if (Intrinsics.areEqual(r41, "com.google.android.googlequicksearchbox") == false) goto L282;
        r36 = "google_assistant";
        goto L282
    L273:
        if (r35.intValue() != 1) goto L275;
        r37 = "power_options";
        goto L276
    L268:
        if (r35.intValue() != 5) goto L270;
        r37 = "wake_default_assistant";
    L259:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
    L283:
        JSONObject r43 = this.$jsonParams;
        ObricLaunchReportManager.a.getClass();
        if (Build.VERSION.SDK_INT >= 25) goto L437;
        boolean r44 = false;
    L314:
        if (r44 == false) goto L316;
        Object r45 = "on";
    L317:
        r43.put("instruction_manage_on_desktop", r45);
        Map r46 = ObricConfigServiceDelegate.b.getCommonParams();
        if (r46 == null) goto L323;
        JSONObject r47 = this.$jsonParams;
        Iterator r48 = r46.entrySet().iterator();
    L321:
        if (r48.hasNext() == false) goto L323;
        Map.Entry r49 = (Map.Entry) r48.next();
        r47.put((String) r49.getKey(), r49.getValue());
    L323:
        JSONObject r50 = this.$jsonParams;
        IObricReporter.a.getClass();
        IObricReporter r51 = IObricReporter.a.a();
        if (r51 == null) goto L327;
        String r52 = r51.j();
        if (r52 == null) goto L327;
    L328:
        r50.put("keep_alive_level_mode", r52);
        IObricUserGuide r53 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r53 == null) goto L336;
        boolean r54 = r53.b();
        JSONObject r55 = this.$jsonParams;
        String r56 = ObricLaunchReportManager.r;
        if (r54 == false) goto L333;
        Object r57 = "on";
    L335:
        if (r55.put(r56, r57) == null) goto L336;
    L337:
        ISystemKeySettings r58 = (ISystemKeySettings) ServiceManager.get().getService(ISystemKeySettings.class);
        if (r58 == null) goto L370;
        JSONObject r59 = this.$jsonParams;
        String r60 = ObricLaunchReportManager.s;
        if (r58.isAiKeyEnabledWhenScreenOff() == true) goto L343;
        r11 = "off";
    L343:
        r59.put(r60, r11);
        long r61 = r58.getPressStartTimeout();
        if (r61 > 300) goto L347;
        String r62 = "high_sensitivity";
    L350:
        r59.put(ObricLaunchReportManager.t, r62);
        int r63 = r58.getSingleClickAction();
        String r64 = "none";
        if (r63 == 0) goto L355;
        if (r63 == 1) goto L354;
        String r65 = "none";
    L356:
        r59.put(ObricLaunchReportManager.u, r65);
        int r66 = r58.getDoubleClickAction();
        if (r66 == 0) goto L367;
        if (r66 != 1) goto L360;
        r64 = "video_call";
    L369:
        if (r59.put(ObricLaunchReportManager.v, r64) == null) goto L370;
    L371:
        ObricLaunchReportManager.a.getClass();
        IBluetoothHeadSetAPI r67 = c.a();
        if (r67 == null) goto L376;
        boolean r111 = true;
        if (r67.a() != true) goto L377;
        boolean r68 = true;
    L378:
        if (r68 == false) goto L388;
        CoWakeupApi r69 = a.a();
        if (r69 != null) goto L382;
    L384:
        boolean r112 = false;
    L385:
        if (r112 == false) goto L387;
        String r70 = "ola_friend";
    L389:
        JSONObject r71 = this.$jsonParams;
        if (o0.d(r70) == false) goto L392;
        r71.put(ObricLaunchReportManager.p, r70);
    L392:
        long r72 = ((long) 300) + this.$extraDelayTime;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        if (DelayKt.delay(r72, this) != r2) goto L395;
        return r2;
    L387:
        r70 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
        goto L389
    L382:
        if (r69.isDoraConnected() != r111) goto L384;
        r112 = true;
        goto L385
    L388:
        r70 = null;
    L377:
        r68 = false;
        goto L378
    L376:
        r111 = true;
        goto L377
    L360:
        if (r66 != 2) goto L362;
        r64 = "screen_share";
        goto L369
    L362:
        if (r66 != 3) goto L369;
        r64 = "doubao_camera";
        goto L369
    L367:
        r64 = "voice_call";
        goto L369
    L354:
        r65 = "open_doubao_app";
        goto L356
    L355:
        r65 = "chat_box";
        goto L356
    L347:
        if (r61 > 600) goto L349;
        r62 = "moderate_sensitivity";
        goto L350
    L349:
        r62 = "low_sensitivity";
    L370:
        JSONObject r73 = this.$jsonParams;
        r73.put(ObricLaunchReportManager.s, "unknown");
        r73.put(ObricLaunchReportManager.t, "unknown");
        r73.put(ObricLaunchReportManager.u, "unknown");
        r73.put(ObricLaunchReportManager.v, "unknown");
        goto L371
    L333:
        r57 = "off";
    L336:
        this.$jsonParams.put(ObricLaunchReportManager.r, "unknown");
    L327:
        r52 = "";
        goto L328
    L316:
        r45 = "off";
        goto L317
    L437:
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L308
        ShortcutManager r75 = (ShortcutManager) FlowRuntime.a().getApplication().getSystemService(ShortcutManager.class);     // Catch: Throwable -> L308
        if (r75 == null) goto L305;
        List<ShortcutInfo> r76 = r75.getPinnedShortcuts();     // Catch: Throwable -> L308
        if (r76 == null) goto L305;
        List<ShortcutInfo> r77 = r76;     // Catch: Throwable -> L308
        if ((r77 instanceof Collection) == true) goto L293;
    L295:
        Iterator<T> r78 = r77.iterator();     // Catch: Throwable -> L308
    L297:
        if (r78.hasNext() == false) goto L301;
        if (TextUtils.equals(((ShortcutInfo) r78.next()).getId(), "launcher_page_icon_shortcut") == false) goto L297;
        boolean r79 = true;
    L303:
        if (r79 != true) goto L305;
        boolean r80 = true;
    L306:
        Object r81 = Result.constructor-impl(Boolean.valueOf(r80));     // Catch: Throwable -> L308
    L310:
        Boolean r82 = Boolean.FALSE;
        if (Result.isFailure-impl(r81) == false) goto L313;
        r81 = r82;
    L313:
        r44 = ((Boolean) r81).booleanValue();
    L301:
        r79 = false;
        goto L303
    L293:
        if (r77.isEmpty() == false) goto L295;
    L305:
        r80 = false;
    L308:
        th = move-exception;
        Result.Companion r83 = Result.Companion;
        r81 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L310
    L250:
        r27 = "no";
        goto L251
    L245:
        if (r25.a() != true) goto L247;
        r26 = true;
        goto L248
    L241:
        r21 = "off";
        goto L242
    L12:
        ResultKt.throwOnFailure(r22);
        CoroutineScope r113 = (CoroutineScope) this.L$0;
        t1 r84 = t1.a;
        if (r84.getAutoGuiEnabledScene() == 1) goto L15;
        boolean r114 = true;
    L16:
        boolean r115 = r84.x0();
        boolean r116 = r84.J0();
        JSONObject r85 = this.$jsonParams;
        String r86 = ObricLaunchReportManager.q;
        if (ObricUpdateSettingDelegate.a.a() == false) goto L19;
        Object r87 = "on";
    L20:
        r85.put(r86, r87);
        JSONObject r88 = this.$jsonParams;
        String r89 = ObricLaunchReportManager.i;
        if (r84.t0() == false) goto L23;
        String r90 = "add_desktop_icon";
    L24:
        r88.put(r89, r90);
        JSONObject r91 = this.$jsonParams;
        String r92 = ObricLaunchReportManager.j;
        if (r84.isTtsPlayBackgroundEnabled() == false) goto L27;
        Object r93 = "on";
    L28:
        r91.put(r92, r93);
        JSONObject r94 = this.$jsonParams;
        String r95 = ObricLaunchReportManager.k;
        if (r84.q() == false) goto L31;
        Object r96 = "on";
    L32:
        r94.put(r95, r96);
        JSONObject r97 = this.$jsonParams;
        String r98 = ObricLaunchReportManager.l;
        if (r84.b() == false) goto L35;
        Object r99 = "on";
    L36:
        r97.put(r98, r99);
        if (Intrinsics.areEqual(this.$launchWakeup, "voice.wakeup") == false) goto L112;
        ObricLaunchReportManager.a.getClass();
        if (Build.VERSION.SDK_INT < 23) goto L67;
        IObricMultiUserService.a.getClass();
        IObricMultiUserService r100 = IObricMultiUserService.a.a();
        if (r100 != null) goto L44;
    L46:
        boolean r101 = false;
    L47:
        if (r101 == false) goto L67;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L51
        Object r103 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(b.a().d(), "pacific")));     // Catch: Throwable -> L51
    L53:
        Throwable r104 = Result.exceptionOrNull-impl(r103);
        if (r104 == null) goto L56;
        FLogger.a.w("ObricLaunchReportManager", "isPacificProduct failed: " + r104.getMessage(), r104);
    L56:
        Boolean r105 = Boolean.FALSE;
        if (Result.isFailure-impl(r103) == false) goto L60;
        r103 = r105;
    L60:
        if (((Boolean) r103).booleanValue() == false) goto L67;
        t1 r106 = t1.a;
        if (r106.b() == false) goto L67;
        ObricWakeupSoundConfig r107 = r106.x1();
        if (r107.getEnable() == false) goto L67;
        List r108 = r107.getOptions();
        if (r108 == null) goto L102;
        List r109 = CollectionsKt.filterNotNull(r108);
        if (r109 == null) goto L102;
        ArrayList r117 = new ArrayList();
        Iterator r118 = r109.iterator();
    L74:
        if (r118.hasNext() == false) goto L95;
        Object r119 = r118.next();
        ObricWakeupSoundOption r120 = (ObricWakeupSoundOption) r119;
        String r121 = r120.getId();
        if (r121 != null) goto L78;
    L81:
        boolean r122 = true;
    L82:
        if (r122 == true) goto L92;
        String r123 = r120.getType();
        if (r123 != null) goto L86;
    L89:
        boolean r124 = true;
    L90:
        if (r124 == true) goto L92;
        boolean r125 = true;
    L93:
        if (r125 == false) goto L74;
        r117.add(r119);
        goto L74
    L86:
        if (StringsKt.isBlank(r123) == true) goto L89;
        r124 = false;
    L92:
        r125 = false;
        goto L93
    L78:
        if (StringsKt.isBlank(r121) == true) goto L81;
        r122 = false;
        goto L82
    L95:
        ArrayList r126 = new ArrayList();
        Iterator r127 = r117.iterator();
    L97:
        if (r127.hasNext() == false) goto L101;
        String r128 = ((ObricWakeupSoundOption) r127.next()).getId();
        if (r128 == null) goto L97;
        r126.add(r128);
        goto L97
    L101:
        Set r129 = CollectionsKt.toSet(r126);
    L103:
        if (r129 != null) goto L105;
        r129 = SetsKt.emptySet();
    L105:
        boolean r130 = r129.containsAll(CollectionsKt.listOf(new String[]{"classic", "smart", "doubao_same_voice"}));
    L106:
        if (r130 == false) goto L112;
        JSONObject r131 = this.$jsonParams;
        ObricLaunchReportManager.a.getClass();
        t1 r132 = t1.a;
        String r133 = r132.d0();
        if ((!StringsKt.isBlank(r133)) == false) goto L110;
        String r134 = ObricLaunchReportManager.d(r133);
    L111:
        r131.put("wakeup_sound_settings", r134);
        goto L112
    L110:
        r134 = ObricLaunchReportManager.d(r132.x1().getDefaultSoundId());
    L102:
        r129 = null;
    L51:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r103 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L44:
        if (r100.a() != true) goto L46;
        r101 = true;
    L67:
        r130 = false;
    L112:
        JSONObject r136 = this.$jsonParams;
        String r137 = ObricLaunchReportManager.J;
        t1 r138 = t1.a;
        if (r138.r1() == false) goto L115;
        Object r139 = "on";
    L116:
        r136.put(r137, r139);
        JSONObject r140 = this.$jsonParams;
        if (r115 == true) goto L121;
        if (r116 == true) goto L121;
        Object r141 = "off";
    L122:
        r140.put("feedback_loop_switch", r141);
        JSONObject r142 = this.$jsonParams;
        String r143 = ObricLaunchReportManager.K;
        if (r115 == false) goto L125;
        Object r144 = "on";
    L126:
        r142.put(r143, r144);
        JSONObject r145 = this.$jsonParams;
        if (r116 == false) goto L129;
        Object r146 = "on";
    L130:
        r145.put("model_training_switch", r146);
        JSONObject r147 = this.$jsonParams;
        String r148 = ObricLaunchReportManager.m;
        if (r138.u0() == false) goto L133;
        Object r149 = "on";
    L134:
        r147.put(r148, r149);
        JSONObject r150 = this.$jsonParams;
        String r151 = ObricLaunchReportManager.n;
        if (r138.i() == false) goto L137;
        Object r152 = "on";
    L138:
        r150.put(r151, r152);
        JSONObject r153 = this.$jsonParams;
        String r154 = ObricLaunchReportManager.o;
        if (r114 == false) goto L141;
        Object r155 = "on";
    L142:
        r153.put(r154, r155);
        JSONObject r156 = this.$jsonParams;
        String r157 = ObricLaunchReportManager.w;
        if (r138.I1() == false) goto L145;
        Object r158 = "on";
    L146:
        r156.put(r157, r158);
        JSONObject r159 = this.$jsonParams;
        String r160 = ObricLaunchReportManager.x;
        if (r138.w1() == false) goto L149;
        Object r161 = "on";
    L150:
        r159.put(r160, r161);
        JSONObject r162 = this.$jsonParams;
        String r163 = ObricLaunchReportManager.y;
        ObricLaunchReportManager r164 = ObricLaunchReportManager.a;
        boolean r165 = r138.getOUseMemoryEnabled();
        r164.getClass();
        String r166 = "unavailable";
        if (r114 == false) goto L155;
        if (r165 == false) goto L154;
        Object r167 = "on";
    L156:
        r162.put(r163, r167);
        JSONObject r168 = this.$jsonParams;
        String r169 = ObricLaunchReportManager.z;
        boolean r170 = r138.v1();
        if (r114 == false) goto L161;
        if (r170 == false) goto L160;
        Object r171 = "on";
    L162:
        r168.put(r169, r171);
        JSONObject r172 = this.$jsonParams;
        Result.Companion r173 = Result.Companion;     // Catch: Throwable -> L165
        Object r174 = Result.constructor-impl(Boolean.valueOf(ObricPersonalContextSettingApiDelegate.b.q()));     // Catch: Throwable -> L165
    L167:
        Throwable r175 = Result.exceptionOrNull-impl(r174);
        if (r175 == null) goto L170;
        FLogger.a.w("ObricLaunchReportManager", "isLocalDataSearchEnabled failed: " + r175.getMessage(), r175);
    L170:
        Boolean r176 = Boolean.FALSE;
        if (Result.isFailure-impl(r174) == false) goto L173;
        r174 = r176;
    L173:
        boolean r177 = ((Boolean) r174).booleanValue();
        if (r177 == false) goto L176;
        Object r178 = "on";
    L177:
        r172.put("local_search_switch", r178);
        Iterator r179 = MapsKt.mapOf(new Pair[]{TuplesKt.to("local_search_switch_contacts", ToggleName.CONTACTS), TuplesKt.to("local_search_switch_calls", ToggleName.CALL_LOGS), TuplesKt.to("local_search_switch_messages", ToggleName.MESSAGE), TuplesKt.to("local_search_switch_photos", ToggleName.ALBUM), TuplesKt.to("local_search_switch_notes", ToggleName.NOTES), TuplesKt.to("local_search_switch_alarms", ToggleName.CLOCK), TuplesKt.to("local_search_switch_files", ToggleName.FILE_MANAGEMENT), TuplesKt.to("local_search_switch_recordings", ToggleName.RECORD), TuplesKt.to("local_search_switch_calendar", ToggleName.CALENDAR), TuplesKt.to("local_search_switch_memory", ToggleName.GLOBAL_MEMORY)}).entrySet().iterator();
    L179:
        if (r179.hasNext() == false) goto L196;
        Map.Entry r180 = (Map.Entry) r179.next();
        String r181 = (String) r180.getKey();
        ToggleName r182 = (ToggleName) r180.getValue();
        ObricLaunchReportManager.a.getClass();
        if (r177 == true) goto L441;
        r177 = r177;
        String r183 = r166;
        r166 = r183;
        r179 = r179;
    L195:
        r172.put(r181, r183);
        r177 = r177;
        r166 = r166;
        r179 = r179;
        goto L179
    L441:
        Result.Companion r184 = Result.Companion;     // Catch: Throwable -> L185
        Object r185 = Result.constructor-impl(ObricPersonalContextSettingApiDelegate.b.s(r182));     // Catch: Throwable -> L185
    L187:
        Throwable r186 = Result.exceptionOrNull-impl(r185);
        if (r186 == null) goto L192;
        FLogger.a.w("ObricLaunchReportManager", "getLocalDataSearchSwitchReportValue failed, toggleName=" + r182, r186);
    L192:
        if (Result.isFailure-impl(r185) == false) goto L194;
        r185 = "reject";
    L194:
        r183 = (String) r185;
    L185:
        th = move-exception;
        Result.Companion r187 = Result.Companion;
        r185 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L187
    L196:
        JSONObject r188 = this.$jsonParams;
        t1 r189 = t1.a;
        if (r189.j0() == false) goto L199;
        Object r190 = "on";
    L200:
        r188.put("omni_skill_switch", r190);
        JSONObject r191 = this.$jsonParams;
        String r192 = ObricLaunchReportManager.A;
        ObricLaunchReportManager r193 = ObricLaunchReportManager.a;
        r191.put(r192, ObricLaunchReportManager.b(r193, "app_custom_permission"));
        this.$jsonParams.put(ObricLaunchReportManager.B, ObricLaunchReportManager.b(r193, "system_setting"));
        this.$jsonParams.put(ObricLaunchReportManager.C, ObricLaunchReportManager.b(r193, "system_install_app"));
        JSONObject r194 = this.$jsonParams;
        String r195 = ObricLaunchReportManager.D;
        String r196 = r189.O();
        switch(r196.hashCode()) {
            case 48: goto L212;
            case 49: goto L209;
            case 50: goto L207;
            case 51: goto L204;
            default: goto L214;
        };
    L207:
        String r197 = "2";
    L213:
        r196.equals(r197);
        goto L214
    L212:
        r197 = "0";
    L214:
        String r198 = "smart_balance";
    L215:
        r194.put(r195, r198);
        JSONObject r199 = this.$jsonParams;
        IObricReporter.a.getClass();
        IObricReporter r200 = IObricReporter.a.a();
        if (r200 == null) goto L218;
        int r201 = r200.q();
    L219:
        r199.put("process_adj", r201);
        if (this.$isObricOS == false) goto L222;
        this.$jsonParams.put(ObricLaunchReportManager.E, ObricLaunchReportManager.c(r193, r189.k1()));
        this.$jsonParams.put(ObricLaunchReportManager.F, ObricLaunchReportManager.c(r193, r189.Q1()));
        this.$jsonParams.put(ObricLaunchReportManager.G, ObricLaunchReportManager.c(r193, r189.W()));
        this.$jsonParams.put(ObricLaunchReportManager.H, ObricLaunchReportManager.c(r193, r189.v0()));
        this.$jsonParams.put(ObricLaunchReportManager.I, ObricLaunchReportManager.c(r193, r189.e1()));
    L222:
        JSONObject r202 = this.$jsonParams;
        String r203 = ObricLaunchReportManager.M;
        this.L$0 = r113;
        this.L$1 = r202;
        this.L$2 = r203;
        this.label = 1;
        IBluetoothHeadSetAPI r204 = c.a();
        if (r204 == null) goto L225;
        BluetoothDevice r205 = r204.g();
    L226:
        IBluetoothHeadSetAPI r206 = c.a();
        if (r206 == null) goto L233;
        if (r205 == null) goto L231;
        String r207 = r205.getAddress();
        if (r207 == null) goto L231;
    L232:
        String r208 = r206.s(r207);
    L234:
        r20 = BuildersKt.withContext(Dispatchers.getIO(), new ObricLaunchReportManager$getVoicePrintEnrollStatus$2(r208, null), this);
        if (r20 != r2) goto L237;
        return r2;
    L237:
        r19 = r202;
        r18 = r203;
    L231:
        r207 = "";
        goto L232
    L233:
        r208 = null;
        goto L234
    L225:
        r205 = null;
        goto L226
    L218:
        r201 = -1;
        goto L219
    L204:
        if (r196.equals("3") == false) goto L214;
        r198 = "autonomous_first";
        goto L215
    L209:
        if (r196.equals("1") == false) goto L214;
        r198 = "confirm_first";
        goto L215
    L199:
        r190 = "off";
        goto L200
    L176:
        r178 = "off";
    L165:
        th = move-exception;
        Result.Companion r209 = Result.Companion;
        r174 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L167
    L160:
        r171 = "off";
        goto L162
    L161:
        r171 = "unavailable";
        goto L162
    L154:
        r167 = "off";
        goto L156
    L155:
        r167 = "unavailable";
        goto L156
    L149:
        r161 = "off";
        goto L150
    L145:
        r158 = "off";
        goto L146
    L141:
        r155 = "off";
        goto L142
    L137:
        r152 = "off";
        goto L138
    L133:
        r149 = "off";
        goto L134
    L129:
        r146 = "off";
        goto L130
    L125:
        r144 = "off";
    L121:
        r141 = "on";
        goto L122
    L115:
        r139 = "off";
        goto L116
    L35:
        r99 = "off";
        goto L36
    L31:
        r96 = "off";
        goto L32
    L27:
        r93 = "off";
        goto L28
    L23:
        r90 = "hide_desktop_icon";
        goto L24
    L19:
        r87 = "off";
        goto L20
    L15:
        r114 = false;
        goto L16
    }
}
