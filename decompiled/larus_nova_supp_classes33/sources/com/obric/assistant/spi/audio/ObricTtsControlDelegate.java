package com.obric.assistant.spi.audio;

import android.app.Activity;
import android.media.AudioTrack;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaOccupyStrategy;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\tH\u0096\u0001J\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0096\u0001J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0096\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J+\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\u001f\u0010!\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0#H\u0096\u0001J\t\u0010$\u001a\u00020\u0015H\u0096\u0001J\t\u0010%\u001a\u00020\u0015H\u0096\u0001J\t\u0010&\u001a\u00020\u0015H\u0096\u0001J\t\u0010'\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H\u0096\u0001J\t\u0010+\u001a\u00020\u0015H\u0096\u0001J%\u0010,\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050.H\u0096\u0001J\u0011\u00100\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\u0011\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0018H\u0096\u0001J\t\u00103\u001a\u00020\u0015H\u0096\u0001J\u0011\u00104\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J%\u00105\u001a\u00020\u00152\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u0018H\u0097\u0001J\u0011\u0010;\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\t\u0010<\u001a\u00020\u0015H\u0096\u0001J\t\u0010=\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010>\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J#\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00182\b\u0010:\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\u0018H\u0096\u0001J\t\u0010B\u001a\u00020\u0015H\u0096\u0001J\t\u0010C\u001a\u00020\u0015H\u0096\u0001J\t\u0010D\u001a\u00020\u0005H\u0096\u0001¨\u0006E"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricTtsControlDelegate;", "Lcom/obric/assistant/spi/audio/IObricTtsControlService;", "<init>", "()V", "appendTtsForegroundNotificationExtras", "", "extras", "Landroid/os/Bundle;", "getBusinessType", "", "getMediaOccupyStrategy", "Lcom/larus/media/MediaOccupyStrategy;", "focusChange", "getTtsAudioTrack", "Landroid/media/AudioTrack;", "config", "Lcom/larus/audio/audiov3/config/audio/player/IAudioPlayerConfig;", "bufferSize", "getTtsStreamType", "()Ljava/lang/Integer;", "hitOptimizeScene", "", "interruptCurrentTtsIfNeeded", "currentTaskId", "", "newTaskId", WindowEvent.Params.REASON, "isFromManual", "isInterceptContinuousTalkTTTS", "msg", "Lcom/larus/im/bean/message/Message;", "isKeyguardLocked", "isMessageSilent", "isMessageTtsPlayable", "messageList", "", "isNeedUpdateCachedTtsSwitch", "isObricTtsCheckScene", "isRingtone", "isSystemCallActive", "isThirdPartyApp", "applicant", "Lcom/larus/media/audiofocus/AudioSessionScene;", "isTtsCanDuck", "registerBaiduMapNaviTts", "onPause", "Lkotlin/Function0;", "onResume", "shouldBlockAutoTtsInContinuousTalk", "shouldBypassFocusFail", "scene", "shouldDisableTtsMixWithExternalApp", "shouldIgnoreTtsConfig", "shouldKeepTtsOnPageStop", "stoppedFragment", "Landroidx/fragment/app/Fragment;", "currentActivity", "Landroid/app/Activity;", "conversationId", "shouldPlayInBackground", "shouldSkipTtsMediaNotify", "shouldStartTtsWhenTtsOpen", "shouldSuppressTtsFailureToast", "startByText", "content", "messageId", "stopTtsWhenBackground", "stopTtsWhenPause", "unregisterBaiduMapNaviTts", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTtsControlDelegate implements IObricTtsControlService {
    public static final ObricTtsControlDelegate b = null;
    public final /* synthetic */ IObricTtsControlService a;

    static {
        b = new ObricTtsControlDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final AudioTrack a(u58.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return this.a.a(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        return this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final Integer c() {
        return this.a.c();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean d(Message r2, List<Message> r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r3, "messageList");
        return this.a.d(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean e() {
        return this.a.e();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean f() {
        return this.a.f();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean g() {
        return this.a.g();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final int getBusinessType() {
        return this.a.getBusinessType();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean h(g r2) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        return this.a.h(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final void i(Function0<Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onPause");
        Intrinsics.checkNotNullParameter(r3, "onResume");
        this.a.i(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean j(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return this.a.j(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean k() {
        return this.a.k();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean l(Fragment r2, Activity r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        return this.a.l(r2, r3, r4);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean m() {
        return this.a.m();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean n() {
        return this.a.n();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean o() {
        return this.a.o();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean p() {
        return this.a.p();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final void q(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "extras");
        this.a.q(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean r(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return this.a.r(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean s() {
        return this.a.s();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final void t() {
        this.a.t();
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean u(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return this.a.u(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final boolean v(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return this.a.v(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final void w(String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "currentTaskId");
        Intrinsics.checkNotNullParameter("startByMessage replace", WindowEvent.Params.REASON);
        this.a.w(r3, r4, r5);
    }

    @Override // com.obric.assistant.spi.audio.IObricTtsControlService
    public final MediaOccupyStrategy x(int r2) {
        return this.a.x(r2);
    }

    private ObricTtsControlDelegate() {
        IObricTtsControlService r0 = (IObricTtsControlService) ServiceManager.get().getService(IObricTtsControlService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricTtsControlServiceImpl();
    L5:
        this.a = r0;
    }
}
