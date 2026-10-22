package com.obric.assistant.spi.audio;

import android.app.Activity;
import android.media.AudioTrack;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaOccupyStrategy;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J$\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\"\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J*\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010\u00142\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u00101\u001a\u00020#2\f\u00102\u001a\b\u0012\u0004\u0012\u00020#032\f\u00104\u001a\b\u0012\u0004\u0012\u00020#03H\u0016J\b\u00105\u001a\u00020#H\u0016J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u0016H\u0016J\u0010\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0014H\u0016J\b\u0010A\u001a\u00020\u0005H\u0016J\u0010\u0010B\u001a\u00020#2\u0006\u0010C\u001a\u00020DH\u0016¨\u0006F"}, d2 = {"Lcom/obric/assistant/spi/audio/DefaultObricTtsControlServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricTtsControlService;", "<init>", "()V", "isMessageTtsPlayable", "", "msg", "Lcom/larus/im/bean/message/Message;", "messageList", "", "shouldIgnoreTtsConfig", "shouldPlayInBackground", "stopTtsWhenBackground", "stopTtsWhenPause", "shouldKeepTtsOnPageStop", "stoppedFragment", "Landroidx/fragment/app/Fragment;", "currentActivity", "Landroid/app/Activity;", "conversationId", "", "getBusinessType", "", "getTtsStreamType", "()Ljava/lang/Integer;", "getTtsAudioTrack", "Landroid/media/AudioTrack;", "config", "Lcom/larus/audio/audiov3/config/audio/player/IAudioPlayerConfig;", "bufferSize", "isMessageSilent", "shouldSuppressTtsFailureToast", "shouldStartTtsWhenTtsOpen", "isObricTtsCheckScene", "startByText", "", "content", "messageId", "isNeedUpdateCachedTtsSwitch", "isTtsCanDuck", "isKeyguardLocked", "isInterceptContinuousTalkTTTS", "isSystemCallActive", "interruptCurrentTtsIfNeeded", "currentTaskId", "newTaskId", WindowEvent.Params.REASON, "isFromManual", "shouldBlockAutoTtsInContinuousTalk", "registerBaiduMapNaviTts", "onPause", "Lkotlin/Function0;", "onResume", "unregisterBaiduMapNaviTts", "getMediaOccupyStrategy", "Lcom/larus/media/MediaOccupyStrategy;", "focusChange", "isThirdPartyApp", "applicant", "Lcom/larus/media/audiofocus/AudioSessionScene;", "shouldDisableTtsMixWithExternalApp", "hitOptimizeScene", "isRingtone", "shouldBypassFocusFail", "scene", "shouldSkipTtsMediaNotify", "appendTtsForegroundNotificationExtras", "extras", "Landroid/os/Bundle;", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricTtsControlServiceImpl implements IObricTtsControlService {

    public static final class a {
    }

    static {
    }

    public DefaultObricTtsControlServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final AudioTrack a(u58.a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "config");
        return null;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final Integer c() {
        return null;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean d(Message r2, List<Message> r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r3, "messageList");
        return true;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean e() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean f() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean g() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final int getBusinessType() {
        return 0;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean h(g r2) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        return true;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final void i(Function0<Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onPause");
        Intrinsics.checkNotNullParameter(r3, "onResume");
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean j(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean k() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean l(Fragment r1, Activity r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean m() {
        return true;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean n() {
        return true;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean o() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean p() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final void q(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "extras");
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean r(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean s() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final void t() {
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean u(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean v(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final void w(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "currentTaskId");
        Intrinsics.checkNotNullParameter("startByMessage replace", WindowEvent.Params.REASON);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final MediaOccupyStrategy x(int r1) {
        return null;
    }
}
