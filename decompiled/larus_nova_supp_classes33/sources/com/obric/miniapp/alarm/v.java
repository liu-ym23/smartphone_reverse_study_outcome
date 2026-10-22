package com.obric.miniapp.alarm;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.d1;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.state.api.multitask.producer.IObricAlarmTtsStateProducerService;
import com.obric.audio.tts.IObricChainTtsService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v implements r {
    public static final /* synthetic */ int c = 0;
    public final d1 a;
    public final CoroutineScope b;

    public static final class a {
    }

    static {
    }

    public v() {
        this.a = AudioServiceDelegate.a.i0();
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    @Override // com.obric.miniapp.alarm.r
    public final void a(String r11) {
        Intrinsics.checkNotNullParameter("obric_alarm_tts", "messageId");
        Intrinsics.checkNotNullParameter(r11, "content");
        FLogger r0 = FLogger.a;
        r0.i("DefaultAlarmTtsPlayer", "play: messageId=obric_alarm_tts, contentLen=" + r11);
        if (com.obric.assistant.utils.j.c(AppHost.a.getApplication()) == true) goto L6;
        r0.i("DefaultAlarmTtsPlayer", "play: exit, cause current app is not an assitant role");
        return;
    L6:
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r4 = true;
        boolean r5 = false;
        if (r2 == null) goto L13;
        com.larus.home.impl.sdk.s r3 = r2.s0();
        if (r3 == null) goto L13;
        if (r3.c() != true) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L26;
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L22;
        DeviceService r8 = r7.device();
        if (r8 == null) goto L22;
        if (r8.S() != true) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L26;
        r0.i("DefaultAlarmTtsPlayer", "play: exit, cause dora call is active, skip to avoid audio overlap");
        return;
    L22:
        r9 = false;
    L26:
        IObricAlarmTtsStateProducerService r10 = (IObricAlarmTtsStateProducerService) ServiceManager.get().getService(IObricAlarmTtsStateProducerService.class);
        if (r10 == null) goto L29;
        r10.a(null);
    L29:
        z2 r12 = z2.a;
        if (r12.enableObricIndependentTts() == false) goto L32;
        IObricChainTtsService.a.getClass();
        IObricChainTtsService r13 = IObricChainTtsService.a.a();
    L33:
        if (r13 == null) goto L37;
        r0.i("DefaultAlarmTtsPlayer", "play: use ObricTtsClient (independent tts pipeline), msgId=obric_alarm_tts");
        r13.a(r11, null, "obric_alarm_tts", false);
        return;
    L37:
        if (r12.enableObricIndependentTts() == false) goto L39;
        r0.i("DefaultAlarmTtsPlayer", "play: IObricChainTtsService not available, fallback to IM tts pipeline");
    L39:
        IFlowTtsClientService.a.getClass();
        PlayStateEnum r14 = IFlowTtsClientService.a.a().m();
        if (r14 != PlayStateEnum.PLAY_STATE_STOPPED) goto L43;
        r4 = false;
    L43:
        if (r4 == false) goto L45;
        r0.i("DefaultAlarmTtsPlayer", "play: already has active tts(state=" + r14 + "), so interrupt current tts and play new alarm");
        IFlowTtsClientService.a.a().f("Alarm tts notification, interrupt current tts and play new alarm");
    L45:
        IObricChatService.a.getClass();
        IObricChatService r15 = IObricChatService.a.a();
        if (r15 == null) goto L48;
        r5 = r15.j();
    L48:
        if (r4 == true) goto L52;
        if (r5 == true) goto L52;
        r0.i("DefaultAlarmTtsPlayer", "play: start tts directly");
        b("obric_alarm_tts", r11);
        return;
    L52:
        BuildersKt.launch$default(this.b, null, null, new DefaultAlarmTtsPlayer$play$1(this, "obric_alarm_tts", r11, null), 3, null);
        return;
    L32:
        r13 = null;
    L13:
        r6 = false;
        goto L14
    }

    public final void b(String r17, String r18) {
        d1.a.a(this.a, "calendar" + System.currentTimeMillis(), null, r18, true, null, r17, null, false, true, null, null, null, null, 3792);
    }
}
