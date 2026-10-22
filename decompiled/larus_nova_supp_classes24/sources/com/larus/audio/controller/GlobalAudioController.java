package com.larus.audio.controller;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import e78.a;
import e78.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0014H\u0016J \u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020#H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u00061"}, d2 = {"Lcom/larus/audio/controller/GlobalAudioController;", "Lcom/larus/audio/controller/IGlobalAudioController;", "<init>", "()V", "mGlobalAudioControllerImpl", "getMGlobalAudioControllerImpl", "()Lcom/larus/audio/controller/IGlobalAudioController;", "mGlobalAudioControllerImpl$delegate", "Lkotlin/Lazy;", "participate", "", "participant", "Lcom/larus/audio/controller/IGlobalAudioParticipant;", "abstain", "getCurrentScene", "", "getCurrentBizScene", "getCurrentState", "Lcom/larus/audio/controller/GlobalAudioStateEnum;", "play", "", "scene", "doraScene", "pause", "stop", "playPrevious", "playNext", "increaseSystemVolume", "ratio", "", "decreaseSystemVolume", "setSystemVolume", "getSystemVolumeRatio", "onVolumeChanged", "volume", "", "prevVolume", "releaseMediaSession", "notifySystemFocusGrabbed", "registerVolumeChangedListener", "listener", "Lcom/larus/audio/controller/IAudioVolumeChangedListener;", "unregisterVolumeChangedListener", "setDoraCallStatus", "isInCall", "onDoraBudsEvent", "type", "key", "event", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class GlobalAudioController implements IGlobalAudioController {
    public static final GlobalAudioController a = null;
    public static final Lazy b = null;

    private GlobalAudioController() {
    }

    static {
        a = new GlobalAudioController();
        b = LazyKt.lazy(new a());
    }

    public static IGlobalAudioController o() {
        return (IGlobalAudioController) b.getValue();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final double e() {
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        return r0.e();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final String g() {
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final String getCurrentScene() {
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentScene();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final GlobalAudioStateEnum getCurrentState() {
        IGlobalAudioController r0 = o();
        if (r0 == null) goto L7;
        GlobalAudioStateEnum r1 = r0.getCurrentState();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return GlobalAudioStateEnum.NONE;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void i() {
        IGlobalAudioController r0 = o();
        if (r0 == null) goto L6;
        r0.i();
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean a(String r3) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a(r3) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean b(double r3) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b(r3) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean c(double r3) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c(r3) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "participant");
        IGlobalAudioController r0 = o();
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean f(String r3) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.f(r3) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void h(c r2) {
        Intrinsics.checkNotNullParameter(r2, "participant");
        IGlobalAudioController r0 = o();
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean j(String r3) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.j(r3) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void k(CommonAppletPlugin.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        IGlobalAudioController r0 = o();
        if (r0 == null) goto L6;
        r0.k(r2);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean m(double r3) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.m(r3) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void n(CommonAppletPlugin.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        IGlobalAudioController r0 = o();
        if (r0 == null) goto L6;
        r0.n(r2);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean pause(String r3) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.pause(r3) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean stop(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        IGlobalAudioController r0 = o();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.stop(r2) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void onVolumeChanged(int r2, int r3) {
        IGlobalAudioController r0 = o();
        if (r0 == null) goto L6;
        r0.onVolumeChanged(r2, r3);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void l(int r2, int r3, int r4) {
        IGlobalAudioController r0 = o();
        if (r0 == null) goto L6;
        r0.l(r2, r3, r4);
        return;
    }
}
