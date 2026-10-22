package com.obric.assistant.audio;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.ttsV2.TtsClientDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaOccupyStrategy;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aiagent.assistant.utils.DefaultAssistantStatus;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.audio.service.IObricTtsService;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.common.spi.audio.ObricAudioServiceDelegate;
import com.obric.assistant.common.utils.y;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.obric.assistant.spi.audio.IObricTtsControlService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0016J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J$\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u001dH\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\r\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0017J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\"\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u00105\u001a\u00020\u0016H\u0016J\b\u00106\u001a\u00020\u0016H\u0016J\u0010\u00107\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u00108\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u00109\u001a\u00020\u0016H\u0016J\b\u0010:\u001a\u00020\u0016H\u0016J\b\u0010;\u001a\u00020\u0016H\u0016J\b\u0010<\u001a\u00020\u0016H\u0016J\u0010\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u001dH\u0016J\b\u0010?\u001a\u00020\u0016H\u0016J\u0010\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020BH\u0016J*\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u001d2\b\u0010E\u001a\u0004\u0018\u00010\u001d2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u0016H\u0016J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0005H\u0016J\u0010\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006P"}, d2 = {"Lcom/obric/assistant/audio/ObricTtsControlServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricTtsControlService;", "<init>", "()V", "ttsStreamType", NameKeys.UnloadStrategy_No_Strategy, "getTtsStreamType", "()I", "ttsStreamType$delegate", "Lkotlin/Lazy;", "baiduMapTtsManager", "Lcom/obric/assistant/audio/BaiduMapTtsManager;", "getBaiduMapTtsManager", "()Lcom/obric/assistant/audio/BaiduMapTtsManager;", "baiduMapTtsManager$delegate", "registerBaiduMapNaviTts", NameKeys.UnloadStrategy_No_Strategy, "onPause", "Lkotlin/Function0;", "onResume", "unregisterBaiduMapNaviTts", "isMessageTtsPlayable", NameKeys.UnloadStrategy_No_Strategy, "msg", "Lcom/larus/im/bean/message/Message;", "messageList", NameKeys.UnloadStrategy_No_Strategy, "queryMessageFromDb", "messageId", NameKeys.UnloadStrategy_No_Strategy, "shouldIgnoreTtsConfig", "shouldPlayInBackground", "stopTtsWhenBackground", "stopTtsWhenPause", "shouldKeepTtsOnPageStop", "stoppedFragment", "Landroidx/fragment/app/Fragment;", "currentActivity", "Landroid/app/Activity;", "conversationId", "getBusinessType", "()Ljava/lang/Integer;", "getTtsAudioTrack", "Landroid/media/AudioTrack;", "config", "Lcom/larus/audio/audiov3/config/audio/player/IAudioPlayerConfig;", "bufferSize", "isMessageSilent", "shouldSuppressTtsFailureToast", "shouldStartTtsWhenTtsOpen", "isObricTtsCheckScene", "startByText", LynxAccessibilityModule.MSG_CONTENT, "isNeedUpdateCachedTtsSwitch", "isTtsCanDuck", "isInterceptContinuousTalkTTTS", "shouldBlockAutoTtsInContinuousTalk", "isKeyguardLocked", "isSystemCallActive", "hitOptimizeScene", "isRingtone", "shouldBypassFocusFail", "scene", "shouldSkipTtsMediaNotify", "appendTtsForegroundNotificationExtras", "extras", "Landroid/os/Bundle;", "interruptCurrentTtsIfNeeded", "currentTaskId", "newTaskId", "reason", "isFromManual", "getMediaOccupyStrategy", "Lcom/larus/media/MediaOccupyStrategy;", "focusChange", "isThirdPartyApp", "applicant", "Lcom/larus/media/audiofocus/AudioSessionScene;", "shouldDisableTtsMixWithExternalApp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTtsControlServiceImpl implements IObricTtsControlService {
    public static String c;
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public final boolean e() {
        return true;
    }

    public final boolean g() {
        return true;
    }

    public final int getBusinessType() {
        return 2;
    }

    public final boolean s() {
        return true;
    }

    public final Integer c() {
        return Integer.valueOf(((Number) this.a.getValue()).intValue());
    }

    public final boolean f() {
        int r0 = com.obric.aiagent.assistant.utils.a.a;
        DefaultAssistantStatus r1 = com.obric.aiagent.assistant.utils.a.a(AppHost.a.getApplication());
        if (t1.a.isTtsPlayBackgroundEnabled() == true) goto L15;
        IObricTtsService r2 = (IObricTtsService) ServiceManager.get().getService(IObricTtsService.class);
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        return false;
    L12:
        if (r1 != DefaultAssistantStatus.IsDefaultAssistant) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (r2.a() != true) goto L9;
        r3 = true;
        goto L10
    L15:
        return false;
    }

    public final boolean k() {
        return Intrinsics.areEqual(ObricAudioServiceDelegate.a.c(), "com.android.server.telecom");
    }

    public final boolean m() {
        ISessionAuthenticationService r0 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r0 == null) goto L9;
        i1 r1 = r0.l();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        return false;
    L13:
        return !t1.a.isTtsPlayBackgroundEnabled();
    L9:
        r2 = false;
        goto L10
    }

    public final boolean n() {
        IObricContinuousTalkService r0 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return false;
    L10:
        IObricChatService.a.getClass();
        IObricChatService r3 = IObricChatService.a.a();
        if (r3 == null) goto L16;
        if (r3.j() != true) goto L16;
        r2 = true;
    L16:
        return !r2;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean o() {
        Lazy r0 = s.a;
        String r1 = ObricAudioServiceDelegate.a.c();
        boolean r2 = s.c.contains(r1);
        int r3 = c68.b.a;
        c68.b.d("TtsInterruptManager", "shouldDisableTtsMixWithExternalApp focusOwner: " + r1 + ", shouldDisable: " + r2);
        return r2;
    }

    public final void t() {
        c r0 = (c) this.b.getValue();
        r0.getClass();
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 26) goto L17;
        FLogger.a.i("BaiduMapTtsManager", "[TTS] unregisterAudioPlaybackCallback failed, SDK_INT < " + r1);
        return;
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        AudioManager r3 = (AudioManager) r0.a.getValue();     // Catch: Throwable -> L9
        if (r3 == null) goto L7;
        r3.unregisterAudioPlaybackCallback((AudioManager.AudioPlaybackCallback) r0.i.getValue());     // Catch: Throwable -> L9
    L7:
        r0.f = false;     // Catch: Throwable -> L9
        r0.g = null;     // Catch: Throwable -> L9
        r0.h = null;     // Catch: Throwable -> L9
        FLogger.a.i("BaiduMapTtsManager", "[TTS] unregisterAudioPlaybackCallback");     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L14;
        FLogger.a.e("BaiduMapTtsManager", "[TTS] unregisterAudioPlaybackCallback failed", r5);
    L14:
        Result.box-impl(r4);
        return;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public ObricTtsControlServiceImpl() {
        this.a = LazyKt.lazy(new o());
        this.b = LazyKt.lazy(new p());
    }

    public final boolean p() {
        return y.e();
    }

    public final boolean b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        if (y.f() == false) goto L6;
        FLogger.a.i("ObricTtsControlServiceImpl", "shouldBypassFocusFail skipped: bluetooth connected but concurrent btmic not supported");
        return false;
    L6:
        y.a.getClass();
        if (y.d("ro.obric.assistant.concurrent_mic_in_use") == false) goto L11;
        AudioManager r0 = y.b;
        if (r0 == null) goto L11;
        int r1 = r0.getMode();
        Set<Integer> r4 = y.b();
        if (r1 != 1) goto L15;
    L18:
        boolean r5 = true;
    L19:
        FLogger.a.i("RomWakeupOptimizeUtils", "isSupportMicInUseOpt hitRingtone=" + r5 + ", mode=" + r1);
    L20:
        boolean r2 = y.h();
        FLogger.a.i("ObricTtsControlServiceImpl", "shouldBypassFocusFail scene=" + r9 + ", isRingtone=" + r5 + ", isVoiceCall=" + r2);
        if (r5 == true) goto L25;
        if (r2 == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(r9, "IM_TTS") == false) goto L27;
    L32:
        return true;
    L27:
        if (Intrinsics.areEqual(r9, "o_asr") == true) goto L32;
        if (Intrinsics.areEqual(r9, "CALL_TTS_PLAY") == true) goto L32;
        if (Intrinsics.areEqual(r9, "O_CALL") == true) goto L32;
        return false;
    L15:
        if (r4.contains(6) == true) goto L18;
        r5 = false;
    L11:
        r5 = false;
        goto L20
    }

    public final boolean h(lk9.g r3) {
        Intrinsics.checkNotNullParameter(r3, "applicant");
        Lazy r1 = s.a;
        Intrinsics.checkNotNullParameter(r3, "applicant");
        if (Intrinsics.areEqual(r3.getScene(), "SYSTEM") == true) goto L5;
    L7:
        return false;
    L5:
        if (ObricAudioServiceDelegate.a.d() == true) goto L7;
        return true;
    }

    public final boolean j(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        int r3 = com.obric.aiagent.assistant.utils.a.a;
        if (com.obric.aiagent.assistant.utils.a.a(AppHost.a.getApplication()) == DefaultAssistantStatus.IsDefaultAssistant) goto L7;
        return false;
    L7:
        return t1.a.isTtsPlayBackgroundEnabled();
    }

    public final void q(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "extras");
        r3.putBoolean("obric_foreground_notification_show", false);
    }

    public final boolean r(Message r10) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        String r0 = com.larus.bmhome.chat.bean.d.r(r10);
        boolean r1 = true;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L39;
        ArrayDeque r4 = new ArrayDeque();
        int r5 = 0;
        boolean r6 = false;
    L13:
        if (r5 >= r0.length()) goto L33;
        char r7 = r0.charAt(r5);
        if (r7 == '(') goto L31;
        if (r7 == ')') goto L25;
        switch(r7) {
            case 65288: goto L23;
            case 65289: goto L25;
            default: goto L19;
        };
    L23:
        r4.addLast((char) 65289);
    L32:
        r5 = r5 + 1;
        goto L13
    L19:
        if (CharsKt.isWhitespace(r7) == true) goto L32;
        if (r4.isEmpty() == true) goto L39;
        r6 = true;
    L25:
        Character r8 = (Character) r4.removeLastOrNull();
        if (r8 == null) goto L39;
        if (r8.charValue() == r7) goto L32;
    L31:
        r4.addLast(')');
        goto L32
    L33:
        if (r6 == true) goto L35;
    L37:
        r1 = false;
    L38:
        r2 = r1;
        goto L39
    L35:
        if (r4.isEmpty() == false) goto L37;
    L39:
        if (r2 == false) goto L41;
        FLogger.a.i("ObricTtsControlServiceImpl", "[TTS][SUPPRESS_FAILURE_TOAST][PARENTHESIZED_ONLY_CONTENT] msgId=" + r10.getMessageId());
    L41:
        return r2;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r3 = false;
        goto L9
    }

    public final boolean u(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (v(r5) == false) goto L6;
        FLogger.a.i("ObricTtsControlServiceImpl", "shouldBlockAutoTtsInContinuousTalk false, allow complex or regen msgId=" + r5.getMessageId());
        return false;
    L6:
        IObricChatService r0 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r0 == null) goto L9;
        r0.isContLockScreenQueryReply(r5);
    L9:
        Map r1 = r5.getExt();
        if (r1 == null) goto L12;
        String r2 = (String) r1.get("is_obric_continuous_talk");
    L14:
        if (Intrinsics.areEqual(r2, "1") == true) goto L16;
    L18:
        IObricContinuousTalkService r6 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        if (r6 != null) goto L21;
        return false;
    L21:
        if (r6.isActive() != true) goto L25;
        return true;
    L25:
        return false;
    L16:
        if (com.larus.bmhome.chat.bean.d.C0(r5) == true) goto L18;
        return true;
    L12:
        r2 = null;
        goto L14
    }

    public final boolean v(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (com.obric.assistant.oauto.f.a(r3) == false) goto L6;
        return true;
    L6:
        if (r3.getReplyId() != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r3.getReplyId(), c) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final MediaOccupyStrategy x(int r13) {
        Lazy r0 = s.a;
        String r1 = ObricAudioServiceDelegate.a.c();
        MediaOccupyStrategy r2 = s.b.get(r1);
        if (r13 == (-3)) goto L6;
        if (r13 == (-2)) goto L6;
        r2 = MediaOccupyStrategy.INTERRUPT;
    L25:
        int r3 = c68.b.a;
        c68.b.d("TtsInterruptManager", "getMediaOccupyStrategy focusChange: " + r13 + ", focusOwner: " + r1 + ", strategy: " + r2);
        return r2;
    L6:
        boolean r8 = false;
        if (Intrinsics.areEqual(r1, "com.baidu.BaiduMap") == false) goto L10;
        if (r13 != (-2)) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        r2 = MediaOccupyStrategy.REJECT;
        goto L25
    L13:
        Lazy r5 = s.a;
        if (((AudioManager) r5.getValue()) == null) goto L21;
        int r6 = c68.b.a;
        StringBuilder r7 = new StringBuilder("audioManager.mode: ");
        AudioManager r9 = (AudioManager) r5.getValue();
        if (r9 == null) goto L19;
        Integer r10 = Integer.valueOf(r9.getMode());
    L20:
        r7.append(r10);
        c68.b.d("TtsInterruptManager", r7.toString());
        List r11 = CollectionsKt.listOf(new Integer[]{2, 3, 1, 5, 4, 6});
        AudioManager r12 = (AudioManager) r5.getValue();
        Intrinsics.checkNotNull(r12);
        r8 = r11.contains(Integer.valueOf(r12.getMode()));
        goto L21
    L19:
        r10 = null;
    L21:
        if (r8 == false) goto L23;
        int r14 = c68.b.a;
        c68.b.d("TtsInterruptManager", "getMediaOccupyStrategy focusChange: " + r13 + ", focusOwner: " + r1 + ", strategy: INTERRUPT(in call)");
        r2 = MediaOccupyStrategy.INTERRUPT;
        goto L25
    L23:
        if (r2 != null) goto L25;
        r2 = MediaOccupyStrategy.PAUSE;
    L10:
        r4 = false;
        goto L11
    }

    public final AudioTrack a(u58.a r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "config");
        AudioAttributes r0 = new AudioAttributes.Builder().setUsage(16).setContentType(1).build();
        AudioFormat r7 = new AudioFormat.Builder().setSampleRate(r5.getSampleRate()).setChannelMask(r5.getChannel()).setEncoding(r5.getFormat()).build();
        return new AudioTrack.Builder().setAudioAttributes(r0).setAudioFormat(r7).setBufferSizeInBytes(r6).setTransferMode(1).setPerformanceMode(2).build();
    }

    public final boolean d(Message r11, List<Message> r12) {
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r12, "messageList");
        if (r11.getReplyId() != null) goto L6;
        FLogger.a.i("ObricTtsControlServiceImpl", "reply id is null");
        return true;
    L6:
        String r0 = r11.getConversationId();
        IObricChatService.a.getClass();
        IObricChatService r3 = IObricChatService.a.a();
        String r4 = null;
        if (r3 == null) goto L11;
        wc9.e r5 = r3.h();
        if (r5 == null) goto L11;
        String r6 = r5.a;
    L13:
        if (Intrinsics.areEqual(r0, r6) == true) goto L16;
        FLogger.a.i("ObricTtsControlServiceImpl", "do not block common bot");
        return true;
    L16:
        boolean r1 = com.obric.assistant.oauto.f.a(r11);
        Iterator<T> r13 = r12.iterator();
    L18:
        if (r13.hasNext() == false) goto L22;
        Object r7 = r13.next();
        if (Intrinsics.areEqual(((Message) r7).getMessageId(), r11.getReplyId()) == false) goto L18;
    L23:
        Message r8 = (Message) r7;
        if (r8 != null) goto L41;
        if (r1 == false) goto L40;
        String r9 = r11.getReplyId();
        if (r9 != null) goto L29;
    L32:
        boolean r10 = true;
    L33:
        if (r10 == true) goto L40;
        CountDownLatch r14 = new CountDownLatch(1);
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        com.larus.im.d.e().m(r9, new q(r15, r14));
        r14.await(1, TimeUnit.SECONDS);
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("queryMessageFromDb msgId=");
        r17.append(r9);
        r17.append(", found=");
        if (r15.element == null) goto L38;
        boolean r18 = true;
    L39:
        r17.append(r18);
        r16.i("ObricTtsControlServiceImpl", r17.toString());
        r8 = (Message) r15.element;
        goto L41
    L38:
        r18 = false;
        goto L39
    L29:
        if (r9.length() == 0) goto L32;
        r10 = false;
    L40:
        r8 = null;
    L41:
        if (r8 != null) goto L44;
        FLogger.a.i("ObricTtsControlServiceImpl", "reply message is null, isComplexTask=" + r1);
        return false;
    L44:
        FLogger r19 = FLogger.a;
        r19.i("ObricTtsControlServiceImpl", "message id = " + r11.getMessageId() + ", reply message id = " + r11.getReplyId());
        if (com.larus.bmhome.chat.bean.d.C0(r11) == true) goto L47;
    L50:
        Map r110 = r8.getExt();
        if (r110 == null) goto L53;
        r4 = (String) r110.get("o_did");
    L53:
        r19.i("ObricTtsControlServiceImpl", "did = " + r4);
        return Intrinsics.areEqual(r4, com.larus.platform.service.o.a.getDeviceId());
    L47:
        if (Intrinsics.areEqual(r11.getReplyId(), c) == false) goto L50;
        r19.i("ObricTtsControlServiceImpl", "regen message, do not intercept");
        return true;
    L22:
        r7 = null;
    L11:
        r6 = null;
        goto L13
    }

    public final void i(Function0<Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "onPause");
        Intrinsics.checkNotNullParameter(r7, "onResume");
        c r2 = (c) this.b.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "onPause");
        Intrinsics.checkNotNullParameter(r7, "onResume");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 26) goto L5;
    L20:
        FLogger.a.i("BaiduMapTtsManager", "[TTS] registerAudioPlaybackCallback failed, SDK_INT < " + r0);
        return;
    L5:
        if (Intrinsics.areEqual(ObricAudioServiceDelegate.a.c(), "com.baidu.BaiduMap") == false) goto L20;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        AudioManager r3 = (AudioManager) r2.a.getValue();     // Catch: Throwable -> L14
        if (r3 == null) goto L9;
        r3.unregisterAudioPlaybackCallback((AudioManager.AudioPlaybackCallback) r2.i.getValue());     // Catch: Throwable -> L14
    L9:
        r2.f = false;     // Catch: Throwable -> L14
        r2.g = r6;     // Catch: Throwable -> L14
        r2.h = r7;     // Catch: Throwable -> L14
        AudioManager r8 = (AudioManager) r2.a.getValue();     // Catch: Throwable -> L14
        if (r8 == null) goto L12;
        r8.registerAudioPlaybackCallback((AudioManager.AudioPlaybackCallback) r2.i.getValue(), r2.e);     // Catch: Throwable -> L14
    L12:
        FLogger.a.i("BaiduMapTtsManager", "[TTS] registerAudioPlaybackCallback");     // Catch: Throwable -> L14
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L19;
        FLogger.a.e("BaiduMapTtsManager", "[TTS] registerAudioPlaybackCallback failed", r10);
    L19:
        Result.box-impl(r9);
        return;
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public final boolean l(Fragment r5, Activity r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        HomeService r0 = HomeService.a;
        if (r0.o() == false) goto L33;
        if (r6 != null) goto L6;
        return false;
    L6:
        if (r6.isFinishing() == true) goto L37;
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r7.length() != 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L38;
        Fragment r8 = r0.v(r6);
        if (r8 != null) goto L18;
        return false;
    L18:
        if (r8 != r5) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(r8.getConversationId(), r7) == true) goto L24;
        return false;
    L24:
        if ((r8 instanceof Fragment) == false) goto L26;
        Fragment r9 = r8;
    L27:
        if (r9 != null) goto L30;
        return false;
    L30:
        if (r9.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L36;
        return true;
    L36:
        return false;
    L26:
        r9 = null;
        goto L27
    L38:
        return false;
    L12:
        r1 = false;
        goto L13
    L37:
        return false;
    L33:
        return false;
    }

    public final void w(String r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "currentTaskId");
        Intrinsics.checkNotNullParameter("startByMessage replace", "reason");
        IFlowTtsClientService.a.getClass();
        PlayStateEnum r0 = IFlowTtsClientService.a.a().m();
        if (r7 == null) goto L24;
        boolean r3 = false;
        if (r7.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r7 = null;
    L11:
        if (r7 != null) goto L14;
        return;
    L14:
        if (r6.length() != 0) goto L16;
        r3 = true;
    L16:
        if (r3 == false) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r6, r7) == false) goto L21;
        return;
    L21:
        if (r0 == PlayStateEnum.PLAY_STATE_STOPPED) goto L26;
        TtsClientDelegate.b.cancel("startByMessage replace", r8);
        return;
    L26:
        return;
    L7:
        r2 = false;
        goto L8
    }
}
