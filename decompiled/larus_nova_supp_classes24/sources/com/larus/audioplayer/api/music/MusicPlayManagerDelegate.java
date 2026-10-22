package com.larus.audioplayer.api.music;

import a88.b;
import a88.c;
import a88.d;
import a88.e;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.platform.api.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0011H\u0096\u0001J\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001bH\u0096\u0001J\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0007H\u0096\u0001J#\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J3\u0010%\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010*\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010+\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J7\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u00102\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u00103\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0096\u0001J\t\u00107\u001a\u00020!H\u0096\u0001J\u0011\u00108\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J!\u00109\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001bH\u0096\u0001J#\u0010<\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?H\u0096\u0001J!\u0010@\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001bH\u0096\u0001J\u0019\u0010A\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u00105\u001a\u000200H\u0096\u0001J\t\u0010B\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010C\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010D\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0096\u0001J#\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006G"}, d2 = {"Lcom/larus/audioplayer/api/music/MusicPlayManagerDelegate;", "Lcom/larus/audioplayer/api/music/IMusicPlayManager;", "<init>", "()V", "addMusicGroup", "", "groupId", "", "musicList", "Ljava/util/ArrayList;", "Lcom/larus/audioplayer/api/music/MusicData;", "configMusicResolution", "targetMusicId", "resolution", "getCurrentGroupId", "getCurrentMusic", "getCurrentMusicStatus", "", "getMusicCurrentPlaybackTime", "getMusicCurrentResolution", "getMusicDuration", "getMusicLoadedProgress", "getMusicPausedReason", "getMusicPlayReason", "getMusicSupportedResolution", "", "getSystemMaxVolume", "", "getSystemVolume", "hasNextMusic", "musicId", "hasPreviousMusic", "onMediaSessionLikeActionTriggered", "", "onMediaSessionMusicActionTriggered", "actionType", "enterMethod", "onMediaSessionSeekToActionTriggered", "position", "", "fromProgress", "toProgress", "pauseMusic", "playMusic", GlobalAudioSceneEnum.MUSIC, "engineCallback", "Lcom/larus/audioplayer/api/music/IMusicPlayEngineCallback;", "nextAndPreviousCallback", "Lcom/larus/audioplayer/api/music/INextAndPreviousMusicHandler;", "isAuto", "playNextMusic", "playPreviousMusic", "registerMediaSessionActionCallback", "callback", "Lcom/larus/audioplayer/api/music/IMusicMediaSessionActionCallback;", "registerMusicPlayEngine", "removeMusicGroup", "setCurrentMusicVolumeByFactor", "left", "right", "setMusicCurrentPlaybackTime", "playbackTime", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "setMusicVolume", "setNextAndPreviousMusicCallback", "stopCurrentMusicForBackgroundAudioTakeover", "stopMusic", "unregisterMediaSessionActionCallback", "updateMusicFavoriteStatus", "status", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MusicPlayManagerDelegate implements IMusicPlayManager {
    public static final MusicPlayManagerDelegate b = null;
    public final /* synthetic */ IMusicPlayManager a;

    static {
        b = new MusicPlayManagerDelegate();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final e a() {
        return this.a.a();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        return this.a.b(r2);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        return this.a.c(r2);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean d() {
        return this.a.d();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final int e() {
        return this.a.e();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final int f() {
        return this.a.f();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void g(e r8, c r9, d r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, GlobalAudioSceneEnum.MUSIC);
        this.a.g(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final String h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        return this.a.h(r2);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final List<String> i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        return this.a.i(r2);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        return this.a.j(r2);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void k(b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.k(r2);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void l() {
        this.a.l();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void m(boolean r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "musicId");
        this.a.m(r2, r3, r4);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final String n() {
        return this.a.n();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean o(String r2, int r3, l0 r4) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        return this.a.o(r2, r3, r4);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean p(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        Intrinsics.checkNotNullParameter(r3, "resolution");
        return this.a.p(r2, r3);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final int q() {
        return this.a.q();
    }

    private MusicPlayManagerDelegate() {
        IMusicPlayManager r0 = (IMusicPlayManager) ServiceManager.get().getService(IMusicPlayManager.class);
        if (r0 != null) goto L5;
        r0 = NoopMusicPlayManager.a;
    L5:
        this.a = r0;
    }
}
