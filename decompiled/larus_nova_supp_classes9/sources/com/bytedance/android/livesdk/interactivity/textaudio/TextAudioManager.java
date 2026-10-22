package com.bytedance.android.livesdk.interactivity.textaudio;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IBroadcastPlayer;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IBroadcastStream;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.Error;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\u00020\u0001:\u000212B\u0017\u0012\u0006\u0010,\u001a\u00020\u0018\u0012\u0006\u0010-\u001a\u00020\u0018¢\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0014J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u000f0(j\b\u0012\u0004\u0012\u00020\u000f`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010'R\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010'¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/textaudio/TextAudioManager;", "Lcom/bytedance/android/livesdk/interactivity/api/textaudio/BaseTextAudioManager;", "Lt52/a$a;", "audioInfo", BuildConfig.FLAVOR, "notifyPlayStart", "notifyPlayEnd", "notifyPlayComplete", "checkAndInitPlayer", "Landroid/content/Context;", "context", "checkHeadsetOn", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IBroadcastStream;", "liveStream", "setLiveStream", "Lt52/a$b;", "listener", "register", "unregister", "onCleared", "playAudioByUrl", "playAudioByPath", "stopAudio", "getPlaying", BuildConfig.FLAVOR, "isPlaying", "Lcom/ss/ttvideoengine/TTVideoEngine;", "audienceAudioPlayer", "Lcom/ss/ttvideoengine/TTVideoEngine;", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IBroadcastStream;", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IBroadcastPlayer;", "anchorAudioPlayer", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/IBroadcastPlayer;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "playerClient", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "playingAudio", "Lt52/a$a;", "headsetOn", "Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "listenerList", "Ljava/util/ArrayList;", "isAnchor", "isOBSBroadcast", "<init>", "(ZZ)V", "Companion", "a", "b", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextAudioManager extends BaseTextAudioManager {
    public static final b Companion = null;
    private static final String TTVIDEO_SUBTAG_AUDIO_MESSAGE = null;
    private static final String TTVIDEO_TAG_LIVE = null;
    private IBroadcastPlayer anchorAudioPlayer;
    private TTVideoEngine audienceAudioPlayer;
    private boolean headsetOn;
    private boolean isAnchor;
    private boolean isOBSBroadcast;
    private final ArrayList<t52.a.b> listenerList;
    private IBroadcastStream liveStream;
    private ILivePlayerClient playerClient;
    private t52.a.C0282a playingAudio;

    public static abstract class a implements IBroadcastPlayer.EventListener {
        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c extends ic2.a {
        public final /* synthetic */ TextAudioManager a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                t52.a.C0282a r0 = TextAudioManager.access$getPlayingAudio$p(this.a.a);     // Catch: Throwable -> L4
                TextAudioManager.access$setPlayingAudio$p(this.a.a, null);     // Catch: Throwable -> L4
                TextAudioManager.access$notifyPlayComplete(this.a.a, r0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ c a;

            public b(c r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                t52.a.C0282a r0 = TextAudioManager.access$getPlayingAudio$p(this.a.a);     // Catch: Throwable -> L4
                TextAudioManager.access$setPlayingAudio$p(this.a.a, null);     // Catch: Throwable -> L4
                TextAudioManager.access$notifyPlayEnd(this.a.a, r0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(TextAudioManager r1) {
            this.a = r1;
        }

        public final void onCompletion(TTVideoEngine r2) {
            Intrinsics.checkNotNullParameter(r2, "engine");
            if (TextAudioManager.access$getPlayerClient$p(this.a) == null) goto L7;
            ILivePlayerClient r3 = TextAudioManager.access$getPlayerClient$p(this.a);
            if (r3 == null) goto L7;
            r3.setPlayerVolume(1.0f);
        L7:
            AndroidSchedulers.mainThread().scheduleDirect(new a(this));
        }

        public final void onError(Error r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            AndroidSchedulers.mainThread().scheduleDirect(new b(this));
        }
    }

    public static final class d extends a {
        public final /* synthetic */ TextAudioManager a;

        public static final class a implements Runnable {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                t52.a.C0282a r0 = TextAudioManager.access$getPlayingAudio$p(this.a.a);     // Catch: Throwable -> L4
                TextAudioManager.access$setPlayingAudio$p(this.a.a, null);     // Catch: Throwable -> L4
                TextAudioManager.access$notifyPlayComplete(this.a.a, r0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ d a;

            public b(d r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IBroadcastPlayer r0 = TextAudioManager.access$getAnchorAudioPlayer$p(this.a.a);     // Catch: Throwable -> L7
                if (r0 == null) goto L5;
                r0.stop();     // Catch: Throwable -> L7
            L5:
                t52.a.C0282a r1 = TextAudioManager.access$getPlayingAudio$p(this.a.a);     // Catch: Throwable -> L7
                TextAudioManager.access$setPlayingAudio$p(this.a.a, null);     // Catch: Throwable -> L7
                TextAudioManager.access$notifyPlayEnd(this.a.a, r1);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public static final class c implements Runnable {
            public final /* synthetic */ d a;

            public c(d r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                IBroadcastPlayer r0 = TextAudioManager.access$getAnchorAudioPlayer$p(this.a.a);     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.start();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public final void onCompletion() {
            AndroidSchedulers.mainThread().scheduleDirect(new a(this));
        }

        public d(TextAudioManager r1) {
            this.a = r1;
        }

        public final void onPrepared(int r2) {
            AndroidSchedulers.mainThread().scheduleDirect(new c(this));
        }

        public final void onError(int r1, Exception r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            AndroidSchedulers.mainThread().scheduleDirect(new b(this));
        }
    }

    static {
        Companion = new b();
        TTVIDEO_TAG_LIVE = "livesdk_video";
        TTVIDEO_SUBTAG_AUDIO_MESSAGE = "live_audio_message_play";
    }

    private final void checkAndInitPlayer() {
        boolean r0 = this.isAnchor;
        if (r0 == true) goto L5;
    L22:
        TTVideoEngine r1 = this.audienceAudioPlayer;
        if (r1 == null) goto L25;
        r1.stop();
        r1.release();
        this.audienceAudioPlayer = null;
    L25:
        TTVideoEngine r2 = new TTVideoEngine(jc1.a.b(), 0);
        this.audienceAudioPlayer = r2;
        r2.setListener(new c(this));
        this.anchorAudioPlayer = null;
        return;
    L5:
        if (this.isOBSBroadcast == true) goto L22;
        if (r0 == true) goto L9;
        return;
    L9:
        if (this.anchorAudioPlayer != null) goto L28;
        IBroadcastStream r3 = this.liveStream;
        if (r3 == null) goto L29;
        if (r3 == null) goto L14;
        IBroadcastPlayer r4 = r3.createPlayer();
    L15:
        this.anchorAudioPlayer = r4;
        d r5 = new d(this);
        IBroadcastPlayer r6 = this.anchorAudioPlayer;
        if (r6 == null) goto L18;
        r6.setEventListener(r5);
    L18:
        IBroadcastStream r7 = this.liveStream;
        if (r7 == null) goto L21;
        r7.startAudioPlayer();
    L21:
        this.audienceAudioPlayer = null;
        return;
    L14:
        r4 = null;
        goto L15
    L29:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public boolean isPlaying() {
        if (this.playingAudio == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void onCleared() {
        this.listenerList.clear();
        this.playingAudio = null;
        this.headsetOn = false;
        TTVideoEngine r1 = this.audienceAudioPlayer;
        if (r1 == null) goto L5;
        r1.stop();
        r1.release();
        this.audienceAudioPlayer = null;
    L5:
        IBroadcastPlayer r2 = this.anchorAudioPlayer;
        if (r2 == null) goto L8;
        r2.stop();
        r2.release();
        this.anchorAudioPlayer = null;
    L8:
        ILivePlayerClient r3 = this.playerClient;
        if (r3 == null) goto L12;
        r3.setPlayerVolume(1.0f);
        this.playerClient = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void stopAudio() {
        t52.a.C0282a r0 = this.playingAudio;
        if (r0 != null) goto L5;
        return;
    L5:
        this.playingAudio = null;
        notifyPlayEnd(r0);
        TTVideoEngine r1 = this.audienceAudioPlayer;
        if (r1 == null) goto L12;
        if (r1 == null) goto L9;
        r1.stop();
    L9:
        ILivePlayerClient r2 = this.playerClient;
        if (r2 == null) goto L17;
        r2.setPlayerVolume(1.0f);
        return;
    L17:
        return;
    L12:
        IBroadcastPlayer r3 = this.anchorAudioPlayer;
        if (r3 == null) goto L19;
        if (r3 == null) goto L20;
        r3.stop();
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public t52.a.C0282a getPlaying() {
        return this.playingAudio;
    }

    public static final /* synthetic */ IBroadcastPlayer access$getAnchorAudioPlayer$p(TextAudioManager r0) {
        return r0.anchorAudioPlayer;
    }

    public static final /* synthetic */ ILivePlayerClient access$getPlayerClient$p(TextAudioManager r0) {
        return r0.playerClient;
    }

    public static final /* synthetic */ t52.a.C0282a access$getPlayingAudio$p(TextAudioManager r0) {
        return r0.playingAudio;
    }

    private final void checkHeadsetOn(Context r4) {
        Object r5 = r4.getSystemService("audio");
        if (r5 == null) goto L15;
        AudioManager r6 = (AudioManager) r5;
        boolean r0 = this.headsetOn;
        if (r6.isWiredHeadsetOn() == false) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r0 == r1) goto L16;
        r6.setSpeakerphoneOn(this.headsetOn);
        this.headsetOn = !this.headsetOn;
        return;
    L16:
        return;
    L7:
        if (r6.isBluetoothA2dpOn() == true) goto L10;
        r1 = false;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }

    private final void notifyPlayComplete(t52.a.C0282a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator<T> r0 = this.listenerList.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((t52.a.b) r0.next()).b(r3);
        goto L6
    }

    private final void notifyPlayEnd(t52.a.C0282a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator<T> r0 = this.listenerList.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((t52.a.b) r0.next()).a(r3);
        goto L6
    }

    private final void notifyPlayStart(t52.a.C0282a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator<T> r0 = this.listenerList.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((t52.a.b) r0.next()).c(r3);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void register(t52.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listenerList.add(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void setLiveStream(IBroadcastStream r2) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        this.liveStream = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void unregister(t52.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listenerList.remove(r2);
    }

    public TextAudioManager(boolean r1, boolean r2) {
        this.isAnchor = r1;
        this.isOBSBroadcast = r2;
        this.listenerList = new ArrayList();
    }

    public static final /* synthetic */ void access$notifyPlayComplete(TextAudioManager r0, t52.a.C0282a r1) {
        r0.notifyPlayComplete(r1);
    }

    public static final /* synthetic */ void access$notifyPlayEnd(TextAudioManager r0, t52.a.C0282a r1) {
        r0.notifyPlayEnd(r1);
    }

    public static final /* synthetic */ void access$setAnchorAudioPlayer$p(TextAudioManager r0, IBroadcastPlayer r1) {
        r0.anchorAudioPlayer = r1;
    }

    public static final /* synthetic */ void access$setPlayerClient$p(TextAudioManager r0, ILivePlayerClient r1) {
        r0.playerClient = r1;
    }

    public static final /* synthetic */ void access$setPlayingAudio$p(TextAudioManager r0, t52.a.C0282a r1) {
        r0.playingAudio = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void playAudioByPath(Context r2, t52.a.C0282a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "audioInfo");
        checkAndInitPlayer();
        checkHeadsetOn(r2);
        t52.a.C0282a r4 = this.playingAudio;
        this.playingAudio = r3;
        notifyPlayEnd(r4);
        notifyPlayStart(this.playingAudio);
        TTVideoEngine r5 = this.audienceAudioPlayer;
        String r6 = null;
        if (r5 == null) goto L18;
        if (r5 == null) goto L10;
        r5.stop();
        t52.a.C0282a r0 = this.playingAudio;
        if (r0 == null) goto L8;
        r6 = r0.a;
    L8:
        r5.setLocalURL(r6);
    L10:
        if (this.playerClient != null) goto L12;
        this.playerClient = LivePlatformPlayerManager.f();
    L12:
        ILivePlayerClient r7 = this.playerClient;
        if (r7 == null) goto L15;
        r7.setPlayerVolume(0.1f);
    L15:
        TTVideoEngine r8 = this.audienceAudioPlayer;
        if (r8 == null) goto L27;
        r8.setTag(TTVIDEO_TAG_LIVE);
        r8.setSubTag(TTVIDEO_SUBTAG_AUDIO_MESSAGE);
        r8.play();
        return;
    L27:
        return;
    L18:
        IBroadcastPlayer r9 = this.anchorAudioPlayer;
        if (r9 == null) goto L29;
        if (r9 == null) goto L30;
        r9.stop();
        t52.a.C0282a r1 = this.playingAudio;
        if (r1 == null) goto L24;
        String r10 = r1.a;
    L25:
        r9.setDataSource(null, r10);
        r9.prepareAsync();
        return;
    L24:
        r10 = null;
        goto L25
    L30:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.textaudio.BaseTextAudioManager, t52.a
    public void playAudioByUrl(Context r2, t52.a.C0282a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "audioInfo");
        checkAndInitPlayer();
        checkHeadsetOn(r2);
        t52.a.C0282a r4 = this.playingAudio;
        this.playingAudio = r3;
        notifyPlayEnd(r4);
        notifyPlayStart(this.playingAudio);
        TTVideoEngine r5 = this.audienceAudioPlayer;
        String r6 = null;
        if (r5 == null) goto L18;
        if (r5 == null) goto L10;
        r5.stop();
        t52.a.C0282a r0 = this.playingAudio;
        if (r0 == null) goto L8;
        r6 = r0.a;
    L8:
        r5.setDirectURL(r6);
    L10:
        if (this.playerClient != null) goto L12;
        this.playerClient = LivePlatformPlayerManager.f();
    L12:
        ILivePlayerClient r7 = this.playerClient;
        if (r7 == null) goto L15;
        r7.setPlayerVolume(0.1f);
    L15:
        TTVideoEngine r8 = this.audienceAudioPlayer;
        if (r8 == null) goto L27;
        r8.setTag(TTVIDEO_TAG_LIVE);
        r8.setSubTag(TTVIDEO_SUBTAG_AUDIO_MESSAGE);
        r8.play();
        return;
    L27:
        return;
    L18:
        IBroadcastPlayer r9 = this.anchorAudioPlayer;
        if (r9 == null) goto L29;
        if (r9 == null) goto L30;
        r9.stop();
        t52.a.C0282a r1 = this.playingAudio;
        if (r1 == null) goto L24;
        String r10 = r1.a;
    L25:
        r9.setDataSource(null, r10);
        r9.prepareAsync();
        return;
    L24:
        r10 = null;
        goto L25
    L30:
        return;
    }
}
