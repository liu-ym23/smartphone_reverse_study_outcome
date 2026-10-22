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
import lk9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J$\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H'J\b\u0010\u0013\u001a\u00020\u0014H&J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020\u0012H&J\b\u0010$\u001a\u00020\u0003H&J\b\u0010%\u001a\u00020\u0003H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010(\u001a\u00020\u0003H&J,\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010\u00122\u0006\u0010,\u001a\u00020\u00122\b\b\u0002\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020\u0003H&J$\u0010/\u001a\u00020!2\f\u00100\u001a\b\u0012\u0004\u0012\u00020!012\f\u00102\u001a\b\u0012\u0004\u0012\u00020!01H&J\b\u00103\u001a\u00020!H&J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u0014H&J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u000209H&J\b\u0010:\u001a\u00020\u0003H&J\b\u0010;\u001a\u00020\u0003H&J\b\u0010<\u001a\u00020\u0003H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0012H&J\b\u0010?\u001a\u00020\u0003H&J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020BH&¨\u0006C"}, d2 = {"Lcom/obric/assistant/spi/audio/IObricTtsControlService;", "", "isMessageTtsPlayable", "", "msg", "Lcom/larus/im/bean/message/Message;", "messageList", "", "shouldIgnoreTtsConfig", "shouldPlayInBackground", "stopTtsWhenBackground", "stopTtsWhenPause", "shouldKeepTtsOnPageStop", "stoppedFragment", "Landroidx/fragment/app/Fragment;", "currentActivity", "Landroid/app/Activity;", "conversationId", "", "getBusinessType", "", "getTtsStreamType", "()Ljava/lang/Integer;", "getTtsAudioTrack", "Landroid/media/AudioTrack;", "config", "Lcom/larus/audio/audiov3/config/audio/player/IAudioPlayerConfig;", "bufferSize", "isMessageSilent", "shouldSuppressTtsFailureToast", "shouldStartTtsWhenTtsOpen", "isObricTtsCheckScene", "startByText", "", "content", "messageId", "isNeedUpdateCachedTtsSwitch", "isTtsCanDuck", "isInterceptContinuousTalkTTTS", "shouldBlockAutoTtsInContinuousTalk", "isKeyguardLocked", "interruptCurrentTtsIfNeeded", "currentTaskId", "newTaskId", WindowEvent.Params.REASON, "isFromManual", "isSystemCallActive", "registerBaiduMapNaviTts", "onPause", "Lkotlin/Function0;", "onResume", "unregisterBaiduMapNaviTts", "getMediaOccupyStrategy", "Lcom/larus/media/MediaOccupyStrategy;", "focusChange", "isThirdPartyApp", "applicant", "Lcom/larus/media/audiofocus/AudioSessionScene;", "shouldDisableTtsMixWithExternalApp", "hitOptimizeScene", "isRingtone", "shouldBypassFocusFail", "scene", "shouldSkipTtsMediaNotify", "appendTtsForegroundNotificationExtras", "extras", "Landroid/os/Bundle;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricTtsControlService {

    public static final class a {
        public static /* synthetic */ void a(ObricTtsControlDelegate r1, String r2, String r3) {
            r1.w(r2, r3, false);
        }
    }

    AudioTrack a(u58.a r1, int r2);

    boolean b(String r1);

    Integer c();

    boolean d(Message r1, List<Message> r2);

    boolean e();

    boolean f();

    boolean g();

    int getBusinessType();

    boolean h(g r1);

    void i(Function0<Unit> r1, Function0<Unit> r2);

    boolean j(Message r1);

    boolean k();

    boolean l(Fragment r1, Activity r2, String r3);

    boolean m();

    boolean n();

    boolean o();

    boolean p();

    void q(Bundle r1);

    boolean r(Message r1);

    boolean s();

    void t();

    boolean u(Message r1);

    boolean v(Message r1);

    void w(String r1, String r2, boolean r3);

    MediaOccupyStrategy x(int r1);
}
