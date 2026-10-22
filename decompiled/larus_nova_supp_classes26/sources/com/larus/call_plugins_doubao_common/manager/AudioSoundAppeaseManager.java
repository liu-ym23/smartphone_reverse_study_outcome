package com.larus.call_plugins_doubao_common.manager;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.AudioServiceDelegate;
import com.larus.avlink.plugins.q0;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AudioSoundAppeaseManager {
    public static final /* synthetic */ int i = 0;
    public final com.larus.call_plugins_doubao_common.a a;
    public final Function0<String> b;
    public final Lazy c;
    public final Lazy d;
    public ValueAnimator e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;

    public interface a {
    }

    public static final class b {
    }

    static {
    }

    public final float c() {
        if (Intrinsics.areEqual(this.a, com.larus.call_plugins_doubao_common.b.b) == false) goto L6;
        return 1.0f;
    L6:
        return ((Keva) p68.g.a.getValue()).getInt("appease_volume", 10) / 10.0f;
    }

    public final IVideoController d() {
        return (IVideoController) this.c.getValue();
    }

    public final void f() {
        IVideoController r0 = d();
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        IVideoController r1 = d();
        if (r1 == null) goto L8;
        r1.l();
    L8:
        IVideoController r2 = d();
        if (r2 == null) goto L12;
        r2.release();
        return;
    }

    public AudioSoundAppeaseManager(com.larus.call_plugins_doubao_common.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.a = r2;
        this.c = LazyKt.lazy(new i(this));
        this.d = LazyKt.lazy(new j());
    }

    public final void g(final Context r9) {
        IVideoController r0 = d();
        if (r0 == null) goto L5;
        r0.t();
    L5:
        ValueAnimator r1 = this.e;
        if (r1 == null) goto L10;
        boolean r2 = true;
        if (r1.isRunning() != true) goto L10;
    L11:
        if (r2 == false) goto L13;
        FLogger.a.i("AudioSoundSoothingManager", "[playAudio] globalAnimator isRunning ");
        return;
    L13:
        this.g = false;
        if (this.h == false) goto L16;
        final float r3 = 0.3f;
    L17:
        ValueAnimator r10 = tk9.b.a(0.0f, r3, this.a.f, new e(this, r9), new f(this), new g(r3, this));
        ValueAnimator r4 = this.e;
        this.e = r10;
        t0.a(new h(r4, r10));
        return;
    L16:
        r3 = c();
    L10:
        r2 = false;
        goto L11
    }

    public final void i(final Function1<? super Boolean, Unit> r10) {
        FLogger.a.i("AudioSoundSoothingManager", "stopAudioWithAnimal return isPlaying: " + this.f);
        this.g = true;
        this.h = false;
        if (this.f == true) goto L8;
        t0.a(new d(this.e));
        if (r10 == null) goto L14;
        r10.invoke(Boolean.valueOf(this.f));
        return;
    L14:
        return;
    L8:
        IVideoController r0 = d();
        if (r0 == null) goto L11;
        float r1 = r0.g();
    L12:
        ValueAnimator r11 = tk9.b.b(r1, 0.0f, this.a.g, null, new com.larus.call_plugins_doubao_common.manager.a(this), new c(this, r10), 8);
        ValueAnimator r2 = this.e;
        this.e = r11;
        t0.a(new h(r2, r11));
        return;
    L11:
        r1 = 1.0f;
        goto L12
    }

    public AudioSoundAppeaseManager(com.larus.call_plugins_doubao_common.a r2, q0 r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this(r2);
        this.b = r3;
    }

    public final void h(boolean r14, Function1<? super Boolean, Unit> r15) {
        this.g = true;     // Catch: Exception -> L31
        this.h = false;     // Catch: Exception -> L31
        t0.a(new d(this.e));     // Catch: Exception -> L31
        if (this.f == true) goto L9;
        FLogger.a.i("AudioSoundSoothingManager", "stopAudio return isPlaying: " + this.f);     // Catch: Exception -> L31
        if (r15 == null) goto L37;
        r15.invoke(Boolean.valueOf(this.f));     // Catch: Exception -> L31
        return;
    L37:
        return;
    L9:
        this.f = false;     // Catch: Exception -> L31
        if (r14 == false) goto L12;
    L25:
        FLogger.a.i("AudioSoundSoothingManager", "stopImmediately");     // Catch: Exception -> L31
        IVideoController r16 = d();     // Catch: Exception -> L31
        if (r16 == null) goto L28;
        r16.stop();     // Catch: Exception -> L31
    L28:
        if (r15 == null) goto L41;
        r15.invoke(Boolean.FALSE);     // Catch: Exception -> L31
        return;
    L41:
        return;
    L12:
        if (Intrinsics.areEqual(this.a, com.larus.call_plugins_doubao_common.b.b) == false) goto L25;
        IVideoController r17 = d();     // Catch: Exception -> L31
        if (r17 == null) goto L16;
        Number r18 = Integer.valueOf(r17.getWatchedDuration());     // Catch: Exception -> L31
    L17:
        Number r6 = r18;
        long r4 = AudioServiceDelegate.a.w0();     // Catch: Exception -> L31
        FLogger r19 = FLogger.a;     // Catch: Exception -> L31
        r19.i("AudioSoundSoothingManager", "stopAudio currentTime: " + r6 + ", minPlayingTime:" + r4);     // Catch: Exception -> L31
        if (r6.longValue() >= r4) goto L20;
        r19.i("AudioSoundSoothingManager", "stopAudio currentTime: " + r6);     // Catch: Exception -> L31
        BuildersKt.launch$default((CoroutineScope) this.d.getValue(), null, null, new AudioSoundAppeaseManager$stopAudio$1(r4, r6, this, r15, null), 3, null);     // Catch: Exception -> L31
        return;
    L20:
        r19.i("AudioSoundSoothingManager", "stopImmediately currentTime: " + r6);     // Catch: Exception -> L31
        IVideoController r110 = d();     // Catch: Exception -> L31
        if (r110 == null) goto L23;
        r110.stop();     // Catch: Exception -> L31
    L23:
        if (r15 == null) goto L39;
        r15.invoke(Boolean.FALSE);     // Catch: Exception -> L31
        return;
    L39:
        return;
    L16:
        r18 = 0L;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        FLogger.a.i("AudioSoundSoothingManager", "error: stopAudio: " + e);
        if (r15 == null) goto L42;
        r15.invoke(Boolean.valueOf(this.f));
        return;
    }

    public static final Object a(AudioSoundAppeaseManager r9, Context r10, Continuation r11) {
        r9.getClass();
        if ((r11 instanceof AudioSoundAppeaseManager$resolveAudioPath$1) == false) goto L7;
        AudioSoundAppeaseManager$resolveAudioPath$1 r0 = (AudioSoundAppeaseManager$resolveAudioPath$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AudioSoundAppeaseManager$resolveAudioPath$1 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r13 = (String) r6.L$0;
        ResultKt.throwOnFailure(r12);
    L38:
        boolean r14 = ((Boolean) r12).booleanValue();
        if (r14 == false) goto L41;
        FLogger.a.i("AudioSoundSoothingManager", "resolveAudioPath use local asset audio, fileName=" + r9.a.a);
    L41:
        if (r14 == false) goto L44;
        return r13;
    L44:
        return "";
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        Function0<String> r15 = r9.b;
        PolarisFileWrapper r4 = null;
        if (r15 == null) goto L17;
        String r16 = (String) r15.invoke();
    L18:
        if (r16 == null) goto L20;
        r4 = new PolarisFileWrapper(r16);
    L20:
        boolean r5 = false;
        if (r4 != null) goto L23;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == false) goto L28;
        FLogger.a.i("AudioSoundSoothingManager", "resolveAudioPath use preferred audio file, fileName=" + r9.a.a);
        return r4.getAbsolutePath();
    L28:
        if (r16 != null) goto L30;
    L31:
        r5 = true;
    L32:
        if (r5 == true) goto L34;
        FLogger.a.i("AudioSoundSoothingManager", "resolveAudioPath preferred audio invalid, fallback to asset, fileName=" + r9.a.a);
    L34:
        String r17 = AppHost.a.getApplication().getFilesDir().getAbsolutePath() + File.separator + r9.a.a;
        com.larus.call_plugins_doubao_common.a r8 = r9.a;
        String r18 = r8.a;
        String r19 = r8.b;
        r6.L$0 = r17;
        r6.label = 1;
        Object r110 = r9.e(r18, r17, r19, r10, r6);
        if (r110 == r2) goto L47;
        r12 = r110;
        r13 = r17;
        goto L38
    L47:
        return r2;
    L30:
        if (r16.length() != 0) goto L32;
    L23:
        if (r4.isFile() != true) goto L25;
        r7 = true;
        goto L26
    L17:
        r16 = null;
    L7:
        r0 = new AudioSoundAppeaseManager$resolveAudioPath$1(r9, r11);
        goto L8
    }

    public final void b(final float r10, long r11, final String r13) {
        if (this.f == true) goto L6;
        FLogger.a.i("AudioSoundSoothingManager", "[" + r13 + "] ignore volume change, isPlaying: " + this.f);
        t0.a(new d(this.e));
        return;
    L6:
        IVideoController r0 = d();
        if (r0 == null) goto L9;
        float r1 = r0.g();
    L10:
        ValueAnimator r12 = tk9.b.b(r1, r10, r11, null, new k(r13, this), new com.larus.call_plugins_doubao_common.manager.b(r13, r10, this), 8);
        ValueAnimator r14 = this.e;
        this.e = r12;
        t0.a(new h(r14, r12));
        return;
    L9:
        r1 = c();
        goto L10
    }

    public final Object e(String r7, String r8, String r9, Context r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof AudioSoundAppeaseManager$initCheckFile$1) == false) goto L7;
        AudioSoundAppeaseManager$initCheckFile$1 r1 = (AudioSoundAppeaseManager$initCheckFile$1) r11;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L15;
        String r13 = (String) r1.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L27
    L26:
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
        PolarisFileWrapper r14 = new PolarisFileWrapper(r8);     // Catch: Exception -> L27
        if (r14.exists() == true) goto L20;
    L23:
        CoroutineDispatcher r15 = Dispatchers.getIO();     // Catch: Exception -> L27
        AudioSoundAppeaseManager$initCheckFile$2 r16 = new AudioSoundAppeaseManager$initCheckFile$2(r14, r10, r7, null);     // Catch: Exception -> L27
        r1.L$0 = r7;     // Catch: Exception -> L27
        r1.label = 1;     // Catch: Exception -> L27
        r12 = BuildersKt.withContext(r15, r16, r1);     // Catch: Exception -> L27
        if (r12 != r3) goto L26;
        return r3;
    L20:
        if (TextUtils.equals(r9, dx8.a.a(r14)) == false) goto L23;
        FLogger.a.i("AudioSoundSoothingManager", "initCheckFile local cache valid, assetName=" + r7);     // Catch: Exception -> L27
        return Boxing.boxBoolean(true);
    L27:
        e = move-exception;
        FLogger.a.e("AudioSoundSoothingManager", "initCheckFile error, assetName=" + r7 + ", type=" + e.getClass().getSimpleName());
        return Boxing.boxBoolean(false);
    L7:
        r1 = new AudioSoundAppeaseManager$initCheckFile$1(this, r11);
        goto L8
    }
}
