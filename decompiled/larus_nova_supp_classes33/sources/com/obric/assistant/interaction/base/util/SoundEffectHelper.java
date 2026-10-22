package com.obric.assistant.interaction.base.util;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u001dJ\u0006\u0010#\u001a\u00020\u001dJ\u0006\u0010$\u001a\u00020\u001dJ\u0010\u0010%\u001a\u00020\u00112\b\b\u0001\u0010&\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u001dJ\u0018\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0011J\u001e\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00072\u0006\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0011J&\u00105\u001a\u00020\u00112\b\b\u0001\u0010&\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\t2\b\b\u0002\u00103\u001a\u00020\u0011H\u0002J \u00106\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00072\u0006\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010)\u001a\n +*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-¨\u00067"}, d2 = {"Lcom/obric/assistant/interaction/base/util/SoundEffectHelper;", "", "<init>", "()V", "TAG", "", "SOUND_NOT_LOADED", "", "DEFAULT_VOLUME", "", "playingSoundId", "NUM_MEDIA_SOUND_STREAMS", "defaultRawResIds", "", "soundIdToPlayVolume", "loopingStreamId", "shouldLoopToPlay", "", "rawResToSoundId", "Ljava/util/concurrent/ConcurrentHashMap;", "SOUND_EFFECT_WAKE_UP", "SOUND_EFFECT_THINKING", "SOUND_EFFECT_DEACTIVATE", "SOUND_EFFECT_WARNING", "SOUND_EFFECT_RELEASE", "SOUND_EFFECT_LISTENING", "SOUND_EFFECT_EXIT", "SOUND_EFFECT_CALLUSER_CLARIFY_NOTIFY", "playActivate", "", "playRelease", "playSendMessage", "playDeactivate", "playWarning", "playListening", "playExit", "playCallUserClarifyNotify", "playWakeupRaw", "resId", "loadCompleteListener", "Landroid/media/SoundPool$OnLoadCompleteListener;", "soundPool", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "getSoundPool", "()Landroid/media/SoundPool;", "soundPool$delegate", "Lkotlin/Lazy;", "stopAsync", "play", "soundId", "loop", "volume", "playRawRes", "playSound", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SoundEffectHelper {
    private static final float DEFAULT_VOLUME = 1.0f;
    public static final SoundEffectHelper INSTANCE = null;
    private static final int NUM_MEDIA_SOUND_STREAMS = 2;
    private static final int SOUND_EFFECT_CALLUSER_CLARIFY_NOTIFY = 7;
    private static final int SOUND_EFFECT_DEACTIVATE = 2;
    private static final int SOUND_EFFECT_EXIT = 6;
    private static final int SOUND_EFFECT_LISTENING = 5;
    private static final int SOUND_EFFECT_RELEASE = 4;
    private static final int SOUND_EFFECT_THINKING = 1;
    private static final int SOUND_EFFECT_WAKE_UP = 0;
    private static final int SOUND_EFFECT_WARNING = 3;
    private static final int SOUND_NOT_LOADED = -1;
    private static final String TAG = "SoundEffectHelper";
    private static final List<Integer> defaultRawResIds = null;
    private static final SoundPool.OnLoadCompleteListener loadCompleteListener = null;
    private static int loopingStreamId;
    private static int playingSoundId;
    private static final ConcurrentHashMap<Integer, Integer> rawResToSoundId = null;
    private static boolean shouldLoopToPlay;
    private static volatile float soundIdToPlayVolume;
    private static final Lazy soundPool$delegate = null;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.base.util.SoundEffectHelper$stopAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.base.util.SoundEffectHelper$stopAsync$1", f = "SoundEffectHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if (SoundEffectHelper.access$getLoopingStreamId$p() == 0) goto L8;
            SoundEffectHelper.access$getSoundPool(SoundEffectHelper.INSTANCE).stop(SoundEffectHelper.access$getLoopingStreamId$p());
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private SoundEffectHelper() {
    }

    public static /* synthetic */ void a(SoundPool r0, int r1, int r2) {
        loadCompleteListener$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ SoundPool b() {
        return soundPool_delegate$lambda$3();
    }

    public final void stopAsync() {
        playingSoundId = -1;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    static {
        SoundEffectHelper r0 = new SoundEffectHelper();
        INSTANCE = r0;
        playingSoundId = -1;
        defaultRawResIds = CollectionsKt.listOf(new Integer[]{2131820645, 2131820644, 2131820639, 2131820646, 2131820643, 2131820641, 2131820640, 2131820647});
        soundIdToPlayVolume = DEFAULT_VOLUME;
        rawResToSoundId = new ConcurrentHashMap();
        SoundPool.OnLoadCompleteListener r1 = new a();
        loadCompleteListener = r1;
        soundPool$delegate = LazyKt.lazy(new b());
        r0.getSoundPool().setOnLoadCompleteListener(r1);
    }

    private final SoundPool getSoundPool() {
        return (SoundPool) soundPool$delegate.getValue();
    }

    private static final SoundPool soundPool_delegate$lambda$3() {
        SoundPool.Builder r0 = new SoundPool.Builder().setMaxStreams(2);
        AudioAttributes.Builder r1 = new AudioAttributes.Builder();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r2 = 16;
    L7:
        return r0.setAudioAttributes(r1.setUsage(r2).setContentType(1).build()).build();
    L5:
        r2 = 5;
        goto L7
    }

    public final void playActivate() {
        FLogger.a.d(TAG, "play sound:playActivate");
        play$default(this, 0, false, 2, null);
    }

    public final void playCallUserClarifyNotify() {
        FLogger.a.d(TAG, "play sound:playCallUserClarifyNotify");
        play$default(this, 7, false, 2, null);
    }

    public final void playDeactivate() {
        FLogger.a.d(TAG, "play sound:playDeactivate");
        play$default(this, 2, false, 2, null);
    }

    public final void playExit() {
        FLogger.a.d(TAG, "play sound:playExit");
        play$default(this, 6, false, 2, null);
    }

    public final void playListening() {
        FLogger.a.d(TAG, "play sound:playListening");
        play$default(this, 5, false, 2, null);
    }

    public final void playRelease() {
        FLogger.a.d(TAG, "play sound:playRelease");
        play$default(this, 4, false, 2, null);
    }

    public final void playSendMessage() {
        FLogger.a.d(TAG, "play sound:playSendMessage");
        play$default(this, 1, false, 2, null);
    }

    public final void playWarning() {
        FLogger.a.d(TAG, "play sound:playWarning");
        play$default(this, 3, false, 2, null);
    }

    public static final /* synthetic */ int access$getLoopingStreamId$p() {
        return loopingStreamId;
    }

    public static final /* synthetic */ SoundPool access$getSoundPool(SoundEffectHelper r0) {
        return r0.getSoundPool();
    }

    public final boolean playWakeupRaw(int r10) {
        FLogger.a.d(TAG, "play sound:playWakeupRaw resId=" + r10);
        return playRawRes$default(this, r10, 0.0f, false, 6, null);
    }

    public final synchronized void play(int r2, boolean r3) {
        monitor-enter(this);
        play(r2, DEFAULT_VOLUME, r3);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static final void loadCompleteListener$lambda$2(SoundPool r3, int r4, int r5) {
        FLogger r6 = FLogger.a;
        r6.e(TAG, "OnLoadCompleteListener sampleId = " + r4 + " status = " + r5 + ", playingSoundId = " + playingSoundId);
        if (r5 == 0) goto L5;
        r6.e(TAG, "Unable to load sound for playback (status: " + r5 + ')');
        ConcurrentHashMap<Integer, Integer> r7 = rawResToSoundId;
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Integer>> r9 = r7.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L16;
        Map.Entry<Integer, Integer> r0 = r9.next();
        if (r0.getValue().intValue() != r4) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L9;
        r8.put(r0.getKey(), r0.getValue());
        goto L9
    L13:
        r1 = false;
        goto L14
    L16:
        Iterator r10 = r8.keySet().iterator();
    L18:
        if (r10.hasNext() == false) goto L28;
        rawResToSoundId.remove(Integer.valueOf(((Number) r10.next()).intValue()));
        goto L18
    L28:
        return;
    L5:
        if (playingSoundId != r4) goto L20;
        INSTANCE.playSound(r4, soundIdToPlayVolume, shouldLoopToPlay);
        soundIdToPlayVolume = DEFAULT_VOLUME;
        return;
    }

    private final synchronized boolean playRawRes(int r10, float r11, boolean r12) {
        monitor-enter(this);
        ConcurrentHashMap<Integer, Integer> r4 = rawResToSoundId;     // Catch: Throwable -> L20
        Integer r5 = r4.get(Integer.valueOf(r10));     // Catch: Throwable -> L20
        if (r5 == null) goto L7;
        int r6 = r5.intValue();     // Catch: Throwable -> L20
    L9:
        if (r6 != (-1)) goto L17;
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L20
        r2.i(TAG, "raw res " + r10 + " not loaded");     // Catch: Throwable -> L20
        int r3 = getSoundPool().load(AppHost.a.getApplication(), r10, 1);     // Catch: Throwable -> L20
        playingSoundId = r3;     // Catch: Throwable -> L20
        if (r3 != 0) goto L16;
        r2.e(TAG, "soundPool load failed, resId=" + r10);     // Catch: Throwable -> L20
        playingSoundId = -1;     // Catch: Throwable -> L20
        monitor-exit(this);
        return false;
    L16:
        r4.put(Integer.valueOf(r10), Integer.valueOf(playingSoundId));     // Catch: Throwable -> L20
        soundIdToPlayVolume = r11;     // Catch: Throwable -> L20
        shouldLoopToPlay = r12;     // Catch: Throwable -> L20
        r2.e(TAG, "sound id to play with not loaded , need wait load complete = " + playingSoundId);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return true;
    L17:
        playingSoundId = r6;     // Catch: Throwable -> L20
        FLogger.a.i(TAG, "sound id to play with loaded = " + playingSoundId);     // Catch: Throwable -> L20
        playSound(r6, r11, r12);     // Catch: Throwable -> L20
        goto L18
    L7:
        r6 = -1;
    L20:
        th = move-exception;
        throw th;
    }

    private final synchronized void playSound(int r11, float r12, boolean r13) {
        monitor-enter(this);
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L18
        r2.i(TAG, "playSound soundId = " + r11 + ", playingSoundId = " + playingSoundId + ", loop = " + r13);     // Catch: Throwable -> L18
        if (r11 == playingSoundId) goto L8;
        monitor-exit(this);
        return;
    L8:
        r2.i(TAG, "do play sound id = " + r11);     // Catch: Throwable -> L18
        SoundPool r3 = getSoundPool();     // Catch: Throwable -> L18
        int r0 = 0;
        if (r13 == false) goto L11;
        int r8 = -1;
    L12:
        int r14 = r3.play(r11, r12, r12, 0, r8, DEFAULT_VOLUME);     // Catch: Throwable -> L18
        if (r13 == false) goto L15;
        r0 = r14;
    L15:
        loopingStreamId = r0;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L11:
        r8 = 0;
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized void play(int r3, float r4, boolean r5) {
        monitor-enter(this);
        Integer r1 = (Integer) CollectionsKt.getOrNull(defaultRawResIds, r3);     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        playRawRes(r1.intValue(), r4, r5);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L10:
        throw new RuntimeException("Unknown sound requested: " + r3);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void play$default(SoundEffectHelper r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.play(r1, r2);
    }

    public static /* synthetic */ boolean playRawRes$default(SoundEffectHelper r0, int r1, float r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = DEFAULT_VOLUME;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return r0.playRawRes(r1, r2, r3);
    }
}
