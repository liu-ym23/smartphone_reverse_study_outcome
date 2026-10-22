package com.larus.audioplayer.impl.music;

import a88.b;
import a88.c;
import a88.d;
import a88.e;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audioplayer.api.music.IMusicPlayManager;
import com.larus.platform.api.l0;
import com.larus.platform.api.v0;
import com.larus.platform.service.v1;
import com.larus.utils.logger.FLogger;
import e88.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J6\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010!\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J2\u0010'\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010-\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u00101\u001a\u00020\tH\u0016J\b\u00102\u001a\u00020\tH\u0016J\b\u00103\u001a\u00020\tH\u0016J\"\u00104\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u00105\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u000107H\u0016J \u00108\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0016J \u0010<\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020:H\u0016J\b\u0010>\u001a\u00020:H\u0016J\b\u0010?\u001a\u00020\u0007H\u0016J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00070A2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010B\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0012\u0010C\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010D\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010E\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010F\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006G"}, d2 = {"Lcom/larus/audioplayer/impl/music/MusicPlayManagerService;", "Lcom/larus/audioplayer/api/music/IMusicPlayManager;", "<init>", "()V", "getCurrentMusic", "Lcom/larus/audioplayer/api/music/MusicData;", "getCurrentGroupId", "", "getCurrentMusicStatus", "", "registerMusicPlayEngine", "", "registerMediaSessionActionCallback", "callback", "Lcom/larus/audioplayer/api/music/IMusicMediaSessionActionCallback;", "unregisterMediaSessionActionCallback", "addMusicGroup", "", "groupId", "musicList", "Ljava/util/ArrayList;", "removeMusicGroup", "playMusic", "musicId", "setNextAndPreviousMusicCallback", "Lcom/larus/audioplayer/api/music/INextAndPreviousMusicHandler;", "getMusicPausedReason", "targetMusicId", "getMusicPlayReason", GlobalAudioSceneEnum.MUSIC, "engineCallback", "Lcom/larus/audioplayer/api/music/IMusicPlayEngineCallback;", "nextAndPreviousCallback", "isAuto", "resolution", "stopCurrentMusicForBackgroundAudioTakeover", "pauseMusic", "stopMusic", "onMediaSessionLikeActionTriggered", "onMediaSessionSeekToActionTriggered", "position", "", "fromProgress", "toProgress", "enterMethod", "onMediaSessionMusicActionTriggered", "actionType", "updateMusicFavoriteStatus", "status", "getMusicDuration", "getMusicCurrentPlaybackTime", "getMusicLoadedProgress", "setMusicCurrentPlaybackTime", "playbackTime", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "setMusicVolume", "left", "", "right", "setCurrentMusicVolumeByFactor", "getSystemVolume", "getSystemMaxVolume", "getMusicCurrentResolution", "getMusicSupportedResolution", "", "configMusicResolution", "hasNextMusic", "hasPreviousMusic", "playNextMusic", "playPreviousMusic", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MusicPlayManagerService implements IMusicPlayManager {
    public MusicPlayManagerService() {
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final e a() {
        MusicPlayManager r0 = MusicPlayManager.a;
        return MusicPlayManager.j;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean d() {
        MusicPlayManager r0 = MusicPlayManager.a;
        monitor-enter(r0);
        String r3 = MusicPlayManager.m;     // Catch: Throwable -> L41
        MusicPlayManager.m = null;     // Catch: Throwable -> L41
        if (r3 == null) goto L13;
        e r5 = MusicPlayManager.j;     // Catch: Throwable -> L41
        if (r5 == null) goto L9;
        String r6 = r5.a;     // Catch: Throwable -> L41
    L11:
        if (Intrinsics.areEqual(r3, r6) == true) goto L13;
        MusicPlayManager.l(r3);     // Catch: Throwable -> L41
        goto L13
    L9:
        r6 = null;
    L13:
        e r7 = MusicPlayManager.j;     // Catch: Throwable -> L41
        a r8 = MusicPlayManager.k;     // Catch: Throwable -> L41
        boolean r9 = true;
        if (r7 == null) goto L23;
        if (r8 == null) goto L23;
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L41
        StringBuilder r10 = new StringBuilder("background audio takeover stops applet music. musicId: ");     // Catch: Throwable -> L41
        r10.append(r7.a);     // Catch: Throwable -> L41
        r10.append(", musicTitle: ");     // Catch: Throwable -> L41
        r10.append(r7.c);     // Catch: Throwable -> L41
        r10.append(", waitingMusicId: ");     // Catch: Throwable -> L41
        if (r3 != null) goto L20;
        r3 = "";
    L20:
        r10.append(r3);     // Catch: Throwable -> L41
        r2.i("MusicPlayManager", r10.toString());     // Catch: Throwable -> L41
        MusicPlayManager.m = null;     // Catch: Throwable -> L41
        MusicPlayManager.l = null;     // Catch: Throwable -> L41
        MusicPlayManager.a();     // Catch: Throwable -> L41
        r8.c();     // Catch: Throwable -> L41
        monitor-exit(r0);
    L40:
        return r9;
    L23:
        FLogger r1 = FLogger.a;     // Catch: Throwable -> L41
        StringBuilder r11 = new StringBuilder("background audio takeover skipped. hasWaitingMusic: ");     // Catch: Throwable -> L41
        if (r3 == null) goto L26;
        boolean r12 = true;
    L27:
        r11.append(r12);     // Catch: Throwable -> L41
        r11.append(", hasCurrentMusic: ");     // Catch: Throwable -> L41
        if (r7 == null) goto L30;
        boolean r13 = true;
    L31:
        r11.append(r13);     // Catch: Throwable -> L41
        r11.append(", hasCurrentEngine: ");     // Catch: Throwable -> L41
        if (r8 == null) goto L34;
        boolean r14 = true;
    L35:
        r11.append(r14);     // Catch: Throwable -> L41
        r1.i("MusicPlayManager", r11.toString());     // Catch: Throwable -> L41
        if (r3 != null) goto L39;
        r9 = false;
    L39:
        monitor-exit(r0);
        goto L40
    L34:
        r14 = false;
        goto L35
    L30:
        r13 = false;
        goto L31
    L26:
        r12 = false;
    L41:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final int e() {
        MusicPlayManager r0 = MusicPlayManager.a;
        a r1 = MusicPlayManager.k;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.f.getCurrentPlaybackTime();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final int f() {
        MusicPlayManager r0 = MusicPlayManager.a;
        a r1 = MusicPlayManager.k;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.f.n();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void l() {
        MusicPlayManager r0 = MusicPlayManager.a;
        v0 r1 = (v0) v1.a.getValue();
        if (r1 == null) goto L6;
        ConcurrentHashMap<String, a> r2 = MusicPlayManager.c;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.util.concurrent.ConcurrentHashMap<kotlin.String, com.larus.platform.api.IMediaPlayCallback>");
        r1.c(r2);
        return;
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final String n() {
        MusicPlayManager r0 = MusicPlayManager.a;
        a r1 = MusicPlayManager.k;
        if (r1 == null) goto L6;
        String r2 = r1.f.getCurrentResolution();
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "undefine";
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final int q() {
        MusicPlayManager r0 = MusicPlayManager.a;
        a r1 = MusicPlayManager.k;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.f.o();
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final String b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "targetMusicId");
        MusicPlayManager r1 = MusicPlayManager.a;
        Intrinsics.checkNotNullParameter(r4, "targetMusicId");
        e r0 = MusicPlayManager.j;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L7:
        if (Intrinsics.areEqual(r2, r4) == false) goto L14;
        a r5 = MusicPlayManager.k;
        if (r5 != null) goto L11;
        return null;
    L11:
        if (r5.g == 1) goto L13;
        return null;
    L13:
        return r5.l;
    L14:
        return null;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        return MusicPlayManager.a.n(r2);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final String h(String r4) {
        Intrinsics.checkNotNullParameter(r4, "targetMusicId");
        MusicPlayManager r1 = MusicPlayManager.a;
        Intrinsics.checkNotNullParameter(r4, "targetMusicId");
        e r0 = MusicPlayManager.j;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L7:
        if (Intrinsics.areEqual(r2, r4) == false) goto L14;
        a r5 = MusicPlayManager.k;
        if (r5 != null) goto L11;
        return null;
    L11:
        if (r5.g == 2) goto L13;
        return null;
    L13:
        return r5.k;
    L14:
        return null;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final List<String> i(String r3) {
        Intrinsics.checkNotNullParameter(r3, "targetMusicId");
        MusicPlayManager r1 = MusicPlayManager.a;
        Intrinsics.checkNotNullParameter(r3, "targetMusicId");
        e r0 = MusicPlayManager.j;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L7:
        if (Intrinsics.areEqual(r3, r2) == false) goto L15;
        a r4 = MusicPlayManager.k;
        if (r4 == null) goto L14;
        List<String> r5 = r4.f.u();
        if (r5 == null) goto L14;
        return r5;
    L14:
        return CollectionsKt.emptyList();
    L15:
        return CollectionsKt.emptyList();
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        return MusicPlayManager.a.g(r2);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void k(b r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        MusicPlayManager r0 = MusicPlayManager.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        LinkedList<b> r1 = MusicPlayManager.f;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r1.contains(r3) == false) goto L8;
        monitor-exit(r1);
        return;
    L8:
        r1.add(r3);     // Catch: Throwable -> L11
        monitor-exit(r1);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean p(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "targetMusicId");
        Intrinsics.checkNotNullParameter(r5, "resolution");
        MusicPlayManager r2 = MusicPlayManager.a;
        Intrinsics.checkNotNullParameter(r4, "targetMusicId");
        Intrinsics.checkNotNullParameter(r5, "resolution");
        e r0 = MusicPlayManager.j;
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L7:
        if (Intrinsics.areEqual(r4, r1) == false) goto L12;
        a r6 = MusicPlayManager.k;
        if (r6 == null) goto L12;
        Intrinsics.checkNotNullParameter(r5, "resolution");
        return r6.f.F(r5);
    L12:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void m(boolean r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "musicId");
        MusicPlayManager r1 = MusicPlayManager.a;
        Intrinsics.checkNotNullParameter(r4, "musicId");
        e r0 = MusicPlayManager.j;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L7:
        if (Intrinsics.areEqual(r2, r4) == false) goto L12;
        e r6 = MusicPlayManager.j;
        if (r6 == null) goto L11;
        r6.g = r3;
    L11:
        MusicPlayManager.b(new v());
        return;
    L12:
        if (r5 == null) goto L27;
        ArrayList<e> r7 = MusicPlayManager.b.get(r5);
        if (r7 == null) goto L28;
        Iterator<T> r8 = r7.iterator();
    L17:
        if (r8.hasNext() == false) goto L29;
        e r9 = (e) r8.next();
        if (Intrinsics.areEqual(r9.a, r4) == false) goto L17;
        r9.g = r3;
        goto L17
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final boolean o(String r2, int r3, l0 r4) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        MusicPlayManager r0 = MusicPlayManager.a;
        return MusicPlayManager.m(r2, r3, r4);
    }

    @Override // com.larus.audioplayer.api.music.IMusicPlayManager
    public final void g(e r8, c r9, d r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, GlobalAudioSceneEnum.MUSIC);
        MusicPlayManager.a.h(r8, r9, r10, r11, r12);
    }
}
