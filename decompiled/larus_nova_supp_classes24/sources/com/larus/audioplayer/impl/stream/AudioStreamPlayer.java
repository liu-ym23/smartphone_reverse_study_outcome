package com.larus.audioplayer.impl.stream;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.http.RequestContext;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.audioplayer.api.stream.IStreamPlayerInterceptor;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class AudioStreamPlayer {
    public static Job A;
    public static boolean B;
    public static Pair<String, Long> C;
    public static float D;
    public static final Lazy E = null;
    public static final c F = null;
    public static com.larus.media.model.a G;
    public static byte[] H;
    public static byte[] I;
    public static byte[] J;
    public static final AudioStreamPlayer a = null;
    public static final List<IStreamPlayerInterceptor> b = null;
    public static Pair<String, String> c;
    public static c88.a d;
    public static Pair<Integer, String> e;
    public static String f;
    public static final String g = null;
    public static volatile com.larus.audioplayer.api.stream.StreamPlayerStatus h;
    public static y78.a i;
    public static z j;
    public static final Lazy k = null;
    public static JSONObject l;
    public static PthreadHandlerThreadV2 m;
    public static Handler n;
    public static long o;
    public static boolean p;
    public static boolean q;
    public static final Queue<v> r = null;
    public static final hq9.t s = null;
    public static boolean t;
    public static long u;
    public static AudioTrack v;
    public static a0 w;
    public static CompletableDeferred<Boolean> x;
    public static Job y;
    public static Job z;

    public static final class a {
        public t a;
        public boolean b;
        public ServiceConnectionC0092a c;
        public final Object d;
        public final ArrayList<Function1<t, Unit>> e;
        public final boolean f;

        /* JADX INFO: renamed from: com.larus.audioplayer.impl.stream.AudioStreamPlayer$a$a, reason: collision with other inner class name */
        public static final class ServiceConnectionC0092a implements ServiceConnection {
            public final /* synthetic */ a a;

            public ServiceConnectionC0092a(a r1) {
                this.a = r1;
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName r3) {
                Intrinsics.checkNotNullParameter(r3, "name");
                int r0 = c68.b.a;
                c68.b.d("AudioStream:Player", "onServiceDisconnected, name: " + r3);
                this.a.a = null;
            }

            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName r3, IBinder r4) {
                Intrinsics.checkNotNullParameter(r3, "className");
                Intrinsics.checkNotNullParameter(r4, "service");
                StreamMediaService r1 = null;
                if ((r4 instanceof StreamMediaService.c) == false) goto L5;
                StreamMediaService.c r5 = (StreamMediaService.c) r4;
            L6:
                if (r5 == null) goto L8;
                r1 = r5.a;
            L8:
                int r6 = c68.b.a;
                c68.b.d("AudioStream:Player", "onServiceConnected, className: " + r3 + ", service: " + r1);
                if (r1 == null) goto L14;
                a r7 = this.a;
                r7.a = r1;
                ArrayList r8 = new ArrayList(r7.e);
                r7.e.clear();
                Iterator r9 = r8.iterator();
            L12:
                if (r9.hasNext() == false) goto L14;
                ((Function1) r9.next()).invoke(r1);
            L14:
                this.a.b = false;
                return;
            L5:
                r5 = null;
                goto L6
            }
        }

        public final void b() {
            ServiceConnectionC0092a r1 = this.c;
            if (r1 == null) goto L12;
            AppHost.a.getApplication().unbindService(r1);     // Catch: Exception -> L6
            c68.b.d("AudioStreamPlayer", "unbind StreamMediaService success");     // Catch: Exception -> L6
        L8:
            this.c = null;
            return;
        L6:
            e = move-exception;
            c68.b.c("AudioStreamPlayer", "unbind StreamMediaService failed", e);
            goto L8
        }

        public a() {
            this.d = new Object();
            this.e = new ArrayList();
            this.f = z2.a.streamPlayerUseMediaSession();
        }

        public final void a(Function1<? super t, Unit> r7) {
            Object r1 = this.d;
            monitor-enter(r1);
            int r2 = c68.b.a;     // Catch: Throwable -> L28
            StringBuilder r3 = new StringBuilder("service isStopped: ");     // Catch: Throwable -> L28
            t r0 = this.a;     // Catch: Throwable -> L28
            if (r0 == null) goto L7;
            Boolean r4 = Boolean.valueOf(r0.a());     // Catch: Throwable -> L28
        L8:
            r3.append(r4);     // Catch: Throwable -> L28
            r3.append(", isWaitingForService: ");     // Catch: Throwable -> L28
            r3.append(this.b);     // Catch: Throwable -> L28
            c68.b.d("AudioStream:Player", r3.toString());     // Catch: Throwable -> L28
            t r5 = this.a;     // Catch: Throwable -> L28
            if (r5 != null) goto L11;
        L16:
            this.e.add(r7);     // Catch: Throwable -> L28
            if (this.b == false) goto L21;
            monitor-exit(r1);
            return;
        L21:
            this.b = true;     // Catch: Throwable -> L28
            ServiceConnectionC0092a r6 = new ServiceConnectionC0092a(this);     // Catch: Throwable -> L28
            this.c = r6;     // Catch: Throwable -> L28
            AppHost.Companion r8 = AppHost.a;     // Catch: Throwable -> L28
            r8.getApplication().bindService(new Intent(r8.getApplication(), StreamMediaService.class), r6, 1);     // Catch: Exception -> L24 Throwable -> L28
        L26:
            monitor-exit(r1);
            return;
        L24:
            e = move-exception;
            c68.b.c("AudioStreamPlayer", "bind StreamMediaService failed", e);     // Catch: Throwable -> L28
            this.b = false;     // Catch: Throwable -> L28
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L28
            goto L26
        L11:
            if (r5.a() == true) goto L15;
            r7.invoke(r5);     // Catch: Throwable -> L28
            monitor-exit(r1);
            return;
        L15:
            b();     // Catch: Throwable -> L28
            this.a = null;     // Catch: Throwable -> L28
            goto L16
        L7:
            r4 = null;
        L28:
            th = move-exception;
            throw th;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[com.larus.audioplayer.api.stream.StreamPlayerStatus.values().length];
            r0[com.larus.audioplayer.api.stream.StreamPlayerStatus.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[com.larus.audioplayer.api.stream.StreamPlayerStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[com.larus.audioplayer.api.stream.StreamPlayerStatus.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[com.larus.audioplayer.api.stream.StreamPlayerStatus.FINISH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[com.larus.audioplayer.api.stream.StreamPlayerStatus.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c implements com.larus.media.v {
        public boolean a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MediaResourceManager.FlowAudioBroadcastEvent.values().length];
                r0[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyBegin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public c() {
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            String r3 = r2.getScene();
            switch(r3.hashCode()) {
                case -1947208172: goto L15;
                case -1943468978: goto L12;
                case -1353089642: goto L9;
                case 3089402: goto L6;
                default: goto L24;
            };
        L24:
            return false;
        L6:
            if (r3.equals("dora") == false) goto L25;
            return true;
        L25:
            return false;
        L9:
            if (r3.equals("TTS_SAMPLE") == true) goto L23;
            return false;
        L23:
            return true;
        L12:
            if (r3.equals("O_CALL") == false) goto L26;
            return true;
        L26:
            return false;
        L15:
            if (r3.equals("NAVIGATION") == false) goto L27;
            return true;
        L27:
            return false;
        }

        public final void e(lk9.g r3) {
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.d(r3);
            AudioStreamPlayer r0 = AudioStreamPlayer.a;
            AudioStreamPlayer.f = r3.getScene();
            AudioStreamPlayer.t = false;
            FLogger.a.i("AudioStreamPlayer", "foucus onMediaInterrupted curPauseReason=" + AudioStreamPlayer.f);
            t0.a.post(new m());
        }

        public final void f(MediaResourceManager.a r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            Intrinsics.checkNotNullParameter(r6, "event");
            if (com.larus.media.o.a() == false) goto L18;
            MediaResourceManager.FlowAudioBroadcastEvent r0 = r6.c;
            if (r0 != null) goto L7;
            int r1 = -1;
        L9:
            if (r1 != 1) goto L11;
            FLogger.a.i("AudioStreamPlayer", "event asrWaitReplyBegin , msgId: " + r6.b);
            this.a = true;
            return;
        L11:
            if (r1 == 2) goto L13;
            FLogger.a.i("AudioStreamPlayer", "else  msgId: " + r6.b);
            this.a = false;
            return;
        L13:
            FLogger.a.i("AudioStreamPlayer", "event asrWaitReplyEnd , msgId: " + r6.b);
            if (this.a == false) goto L20;
            this.a = false;
            t0.a.post(new ru.l());
            return;
        L20:
            return;
        L7:
            r1 = a.a[r0.ordinal()];
            goto L9
        }

        public final void a(lk9.g r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            com.larus.media.v.a.f(r2, r3);
            if (AudioStreamPlayer.t == false) goto L8;
            AudioStreamPlayer.t = false;
            if (this.a == true) goto L9;
            t0.a.post(new n());
            return;
        L9:
            return;
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r2, final float r3) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            com.larus.media.v.a.g(r2, r3);
            t0.a.post(new p(this, r3));
        }

        public final void i(lk9.g r5, lk9.g r6) {
            Intrinsics.checkNotNullParameter(r5, "current");
            Intrinsics.checkNotNullParameter(r6, "applicant");
            com.larus.media.v.a.e(r5, r6);
            AudioStreamPlayer r7 = AudioStreamPlayer.a;     // Catch: IllegalStateException -> L25
            AudioStreamPlayer.f = r6.getScene();     // Catch: IllegalStateException -> L25
            FLogger r8 = FLogger.a;     // Catch: IllegalStateException -> L25
            StringBuilder r9 = new StringBuilder("media focus change onMediaPaused curPauseReason=");     // Catch: IllegalStateException -> L25
            r9.append(AudioStreamPlayer.f);     // Catch: IllegalStateException -> L25
            r9.append(" hasProgress=");     // Catch: IllegalStateException -> L25
            AudioTrack r1 = AudioStreamPlayer.v;     // Catch: IllegalStateException -> L25
            Integer r2 = null;
            if (r1 == null) goto L6;
            AudioStreamPlayer r3 = AudioStreamPlayer.a;     // Catch: IllegalStateException -> L25
            Boolean r4 = Boolean.valueOf(AudioStreamPlayer.n(r1));     // Catch: IllegalStateException -> L25
        L7:
            r9.append(r4);     // Catch: IllegalStateException -> L25
            r9.append(", playState=");     // Catch: IllegalStateException -> L25
            AudioTrack r10 = AudioStreamPlayer.v;     // Catch: IllegalStateException -> L25
            if (r10 == null) goto L10;
            r2 = Integer.valueOf(r10.getPlayState());     // Catch: IllegalStateException -> L25
        L10:
            r9.append(r2);     // Catch: IllegalStateException -> L25
            r8.i("AudioStreamPlayer", r9.toString());     // Catch: IllegalStateException -> L25
            AudioTrack r11 = AudioStreamPlayer.v;     // Catch: IllegalStateException -> L25
            boolean r12 = false;
            if (r11 == null) goto L15;
            AudioStreamPlayer r13 = AudioStreamPlayer.a;     // Catch: IllegalStateException -> L25
            if (AudioStreamPlayer.n(r11) != true) goto L15;
            boolean r14 = true;
        L16:
            if (r14 == false) goto L30;
            AudioTrack r15 = AudioStreamPlayer.v;     // Catch: IllegalStateException -> L25
            if (r15 != null) goto L20;
        L22:
            if (r12 == false) goto L31;
            AudioStreamPlayer.t = true;     // Catch: IllegalStateException -> L25
            t0.a.post(new o());     // Catch: IllegalStateException -> L25
            return;
        L31:
            return;
        L20:
            if (r15.getPlayState() != 3) goto L22;
            r12 = true;
            goto L22
        L30:
            return;
        L15:
            r14 = false;
            goto L16
        L6:
            r4 = null;
        L25:
            e = move-exception;
            FLogger.a.e("AudioStreamPlayer", "illegal is playing check media player", e);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            AudioStreamPlayer r4 = AudioStreamPlayer.a;
            String r5 = r2.getScene();
            boolean r6 = true;
            switch(r5.hashCode()) {
                case -1989469372: goto L28;
                case -1833998801: goto L25;
                case 96896: goto L22;
                case 2060894: goto L19;
                case 3089402: goto L9;
                case 93217264: goto L6;
                default: goto L30;
            };
        L30:
            r6 = false;
        L31:
            if (r6 == false) goto L38;
            if (com.larus.media.o.a() == false) goto L38;
            return MediaOccupyStrategy.PAUSE;
        L38:
            return MediaOccupyStrategy.INTERRUPT;
        L6:
            if (r5.equals("VOICE_COMPONENT") == true) goto L31;
        L9:
            if (r5.equals("dora") == false) goto L30;
            IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r7 == null) goto L30;
            com.larus.home.impl.sdk.s r8 = r7.s0();
            if (r8 == null) goto L30;
            if (r8.c() != true) goto L30;
        L19:
            if (r5.equals("CALL") == true) goto L31;
        L22:
            if (r5.equals("asr") == true) goto L31;
        L25:
            if (r5.equals("SYSTEM") == true) goto L31;
        L28:
            if (r5.equals("UGC_VOICE") == false) goto L30;
            goto L30
        }
    }

    public AudioStreamPlayer() {
    }

    static {
        a = new AudioStreamPlayer();
        b = new ArrayList();
        f = "";
        g = AppHost.a.getApplication().getFilesDir() + "/stream_player/tmp.pcm";
        h = com.larus.audioplayer.api.stream.StreamPlayerStatus.UNKNOWN;
        k = LazyKt.lazy(new com.larus.audioplayer.impl.stream.a());
        r = new ConcurrentLinkedQueue();
        s = z2.a.e0();
        C = new Pair("", 0L);
        D = 1.0f;
        E = LazyKt.lazy(new com.larus.audioplayer.impl.stream.b());
        c r13 = new c();
        F = r13;
        G = new com.larus.media.model.a(null, "NEWS", false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, com.larus.media.o.a(), MediaLevel.PLAY_HIGH.getValue(), false, r13, 1197);
        H = new byte[0];
        I = new byte[0];
    }

    public static final void b() {
        FLogger.a.i("AudioStreamPlayer", "resetAllConfig() exec, reset all config");
        C = new Pair("", 0L);
        I = new byte[0];
        H = new byte[0];
        J = null;
        Job r2 = z;
        if (r2 == null) goto L5;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L5:
        Job r3 = z;
        if (r3 == null) goto L8;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L8:
        z = null;
        Job r4 = y;
        if (r4 == null) goto L11;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L11:
        Job r5 = y;
        if (r5 == null) goto L14;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L14:
        y = null;
        CompletableDeferred<Boolean> r6 = x;
        if (r6 == null) goto L17;
        r6.complete(Boolean.TRUE);
    L17:
        w(null);
        p = false;
        q = false;
    }

    public static final void c() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("AudioStreamPlayer");
        ThreadMethodProxy.start(r0);
        m = r0;
        n = new Handler(r0.getLooper());
        s r1 = new s();
        Handler r2 = n;
        if (r2 == null) goto L6;
        r2.post(r1);
        return;
    }

    public static JSONObject f() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r1 = l;     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        r1 = new JSONObject();     // Catch: Throwable -> L7
    L5:
        return new JSONObject(r1.toString());
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return new JSONObject();
    }

    public static String j() {
        Pair<String, String> r0 = c;
        if (r0 == null) goto L5;
        String r1 = (String) r0.getSecond();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public static a l() {
        return (a) k.getValue();
    }

    public static void x() {
        if (((Boolean) E.getValue()).booleanValue() == false) goto L30;
        AudioTrack r0 = v;
        Unit r1 = null;
        if (r0 == null) goto L9;
        PlaybackParams r2 = r0.getPlaybackParams();
        if (r2 == null) goto L9;
        Float r3 = Float.valueOf(r2.getSpeed());
    L11:
        if (Intrinsics.areEqual(r3, D) == true) goto L31;
        AudioTrack r4 = v;
        if (r4 == null) goto L32;
        PlaybackParams r5 = r4.getPlaybackParams();
        if (r5 == null) goto L33;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L21
        AudioTrack r7 = v;     // Catch: Throwable -> L21
        if (r7 == null) goto L19;
        r7.setPlaybackParams(r5.setSpeed(D));     // Catch: Throwable -> L21
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Object r8 = Result.constructor-impl(r1);     // Catch: Throwable -> L21
    L23:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L26;
        FLogger.a.e("AudioStreamPlayer", "setPlaySpeedToPlayer err=" + r9);
    L26:
        Result.box-impl(r8);
        return;
    L21:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L9:
        r3 = null;
        goto L11
    }

    public static String h(String r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Matcher r4 = PatternProtector.compile("([^/?&=]+_report)").matcher(r3);     // Catch: Throwable -> L8
        if (r4.find() == true) goto L5;
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L15;
        FLogger.a.e("AudioStreamPlayer", "extractResourceId err. msg=" + r6);
    L15:
        return UUID.randomUUID().toString();
    L5:
        return r4.group(1);
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static long i(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uuid");
        a0 r5 = w;
        if (r5 != null) goto L14;
    L11:
        long r0 = 0;
    L13:
        return r0 + u;
    L14:
        AudioTrack r1 = v;     // Catch: Throwable -> L9
        if (r1 == null) goto L11;
        r0 = (((long) r1.getPlaybackHeadPosition()) / ((long) (r5.h * r5.g))) * 1000;
    L9:
        th = move-exception;
        FLogger.a.e("AudioStreamPlayer", "getCurrentPlaybackPosition err=" + th);
        goto L11
    }

    public static String k(String r8) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Iterator r1 = StringsKt.split$default(new URI(r8).getQuery(), new String[]{"&"}, false, 0, 6, null).iterator();     // Catch: Throwable -> L11
    L4:
        if (r1.hasNext() == false) goto L9;
        List r2 = StringsKt.split$default((String) r1.next(), new String[]{"="}, false, 2, 2, null);     // Catch: Throwable -> L11
        String r3 = (String) ListProtector.get(r2, 0);     // Catch: Throwable -> L11
        String r4 = (String) ListProtector.get(r2, 1);     // Catch: Throwable -> L11
        if (Intrinsics.areEqual(r3, "resource_id") == false) goto L4;
        return URLDecoder.decode(r4, "UTF-8");
    L9:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L23;
        FLogger.a.e("AudioStreamPlayer", "getResourceId err=" + r6 + "  input=" + r8);
        return "";
    L23:
        return "";
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static boolean n(AudioTrack r1) {
        if (r1.getPlaybackHeadPosition() > 0) goto L5;
    L7:
        return false;
    L5:
        if (r1.getState() != 1) goto L7;
        return true;
    }

    public static a0 r(byte[] r17) {
        Charset r2 = Charsets.UTF_8;
        return new a0(new String(r17, 0, 4, r2), d(r17, 4), new String(r17, 8, 4, r2), new String(r17, 12, 4, r2), d(r17, 16), e(r17, 20), e(r17, 22), d(r17, 24), d(r17, 28), e(r17, 32), e(r17, 34), new String(r17, 36, 4, r2), d(r17, 40));
    }

    public static void v(com.larus.audioplayer.api.stream.StreamPlayerStatus r12) {
        if ((!StringsKt.isBlank(j())) == false) goto L35;
        FLogger.a.d("AudioStreamPlayer", "change curPlayingStatus from (" + h + ") to (" + r12 + ')');
        y78.a r6 = i;
        if (r6 == null) goto L17;
        String r7 = j();
        Pair<Integer, String> r4 = e;
        if (r4 == null) goto L9;
        Integer r9 = (Integer) r4.getFirst();
    L10:
        Pair<Integer, String> r5 = e;
        if (r5 == null) goto L13;
        String r8 = (String) r5.getSecond();
    L14:
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        r6.a(r7, r12, r9, r8, f);
        goto L17
    L13:
        r8 = null;
        goto L14
    L9:
        r9 = null;
    L17:
        GlobalAudioObserver r10 = GlobalAudioObserver.a;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        int r11 = com.larus.audioplayer.impl.utils.c.a[r12.ordinal()];
        if (r11 == 1) goto L24;
        if (r11 == 2) goto L23;
        if (r11 == 3) goto L22;
        GlobalAudioStateEnum r13 = GlobalAudioStateEnum.NONE;
    L25:
        LinkedHashMap r14 = new LinkedHashMap();
        JSONObject r15 = l;
        if (r15 == null) goto L28;
        r14.put("conversation_id", m(r15, "conversationId"));
        r14.put("message_id", m(r15, "messageId"));
    L28:
        Unit r16 = Unit.INSTANCE;
        r10.c(GlobalAudioSceneEnum.AI_PODCAST, r13, r14);
        if (r12 != com.larus.audioplayer.api.stream.StreamPlayerStatus.ERROR) goto L35;
        Pair<Integer, String> r17 = e;
        if (r17 == null) goto L33;
        Integer r19 = (Integer) r17.getFirst();
    L34:
        r10.f(GlobalAudioSceneEnum.AI_PODCAST, r19, null);
        goto L35
    L33:
        r19 = null;
        goto L34
    L22:
        r13 = GlobalAudioStateEnum.STOPPED;
        goto L25
    L23:
        r13 = GlobalAudioStateEnum.PAUSED;
        goto L25
    L24:
        r13 = GlobalAudioStateEnum.PLAYING;
    L35:
        int r0 = b.a[r12.ordinal()];
        if (r0 != 1) goto L38;
        c68.b.d("AudioStream:Player", "status change to PLAYING, update MediaSession");
        z r1 = j;
        if (r1 == null) goto L62;
        r1.e = true;
    L62:
        a r2 = l();
        if (r2.f == false) goto L66;
        c68.b.d("AudioStream:Player", "StreamMediaSessionManager.updatePlaybackState");
        r2.a(new i());
    L66:
        h = r12;
        return;
    L38:
        if (r0 == 2) goto L52;
        if (r0 != 3) goto L41;
    L45:
        int r3 = c68.b.a;
        c68.b.d("AudioStream:Player", "status change to " + r12 + ", dismiss MediaSession");
        z r20 = j;
        if (r20 == null) goto L48;
        r20.e = false;
    L48:
        a r21 = l();
        if (r21.f == false) goto L66;
        c68.b.d("AudioStream:Player", "StreamMediaSessionManager.dismissMediaSession");
        r21.a(new j());
        goto L66
    L41:
        if (r0 == 4) goto L45;
        if (r0 == 5) goto L45;
    L52:
        c68.b.d("AudioStream:Player", "status change to PAUSED, update MediaSession");
        z r22 = j;
        if (r22 == null) goto L55;
        r22.e = false;
    L55:
        a r23 = l();
        if (r23.f == false) goto L66;
        c68.b.d("AudioStream:Player", "StreamMediaSessionManager.updatePlaybackState");
        r23.a(new i());
        goto L66
    }

    public static void w(CompletableDeferred r2) {
        CompletableDeferred<Boolean> r0 = x;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        CompletableDeferred<Boolean> r3 = x;
        if (r3 == null) goto L12;
        r3.complete(Boolean.FALSE);
    L12:
        x = r2;
        return;
    L5:
        if (r0.isCompleted() == true) goto L7;
        r1 = true;
        goto L8
    }

    public static final void a(String r19, float r110) {
        FLogger.a.i("AudioStreamPlayer", "pre start sse chunk url=" + r19);
        v(com.larus.audioplayer.api.stream.StreamPlayerStatus.PREPARE);
        o = 0;
        String r0 = null;
        e = null;
        String r1 = "";
        f = "";
        PolarisFileWrapper r11 = new PolarisFileWrapper(g);
        File r3 = r11.getParentFile();
        if (r3 == null) goto L6;
        r3.mkdirs();
    L6:
        if (r11.exists() == false) goto L8;
        r11.delete();
    L8:
        r11.createNewFile();
        Ref.IntRef r9 = new Ref.IntRef();
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        ((ConcurrentLinkedQueue) r).clear();
        Ref.LongRef r6 = new Ref.LongRef();
        String r5 = k(r19);
        StringBuilder r4 = new StringBuilder();
        Pair<String, String> r8 = c;
        if (r8 == null) goto L11;
        r0 = (String) r8.getFirst();
    L11:
        if (r0 == null) goto L14;
        r1 = r0;
    L14:
        r4.append(h(r1));
        r4.append("_parsed");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AudioStreamPlayer$playNewStream2$1(r19, r5, r6, r7, r4.toString(), r9, r110, r11, null), 2, null);
    }

    public static int d(byte[] r2, int r3) {
        int r0 = ((r2[r3] & 255) | ((r2[r3 + 1] & 255) << 8)) | ((r2[r3 + 2] & 255) << 16);
        return ((r2[r3 + 3] & 255) << 24) | r0;
    }

    public static short e(byte[] r1, int r2) {
        int r0 = r1[r2] & 255;
        return (short) (((r1[r2 + 1] & 255) << 8) | r0);
    }

    public static String m(JSONObject r1, String r2) {
        if (r1.has(r2) == false) goto L8;
        Object r3 = r1.get(r2);
        if ((r3 instanceof String) == true) goto L7;
        return "";
    L7:
        return (String) r3;
    L8:
        return "";
    }

    public final void B(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        int r0 = c68.b.a;
        c68.b.d("AudioStream:Player", "stop called: uuid=" + r6 + ", reason=" + r7);
        com.larus.audioplayer.api.stream.StreamPlayerStatus r1 = com.larus.audioplayer.api.stream.StreamPlayerStatus.STOPPED;
        q(this, r1, r7);
        FLogger r2 = FLogger.a;
        r2.i("AudioStreamPlayer", "receive stop() call reason=" + r7 + " uuid=" + r6);
        v(r1);
        AudioTrack r8 = v;
        if (r8 != null) goto L5;
    L8:
        com.larus.audioplayer.api.stream.StreamPlayerStatus r9 = com.larus.audioplayer.api.stream.StreamPlayerStatus.UNKNOWN;
        q(this, r9, "release");
        r2.i("AudioStreamPlayer", "exec releasePlayer() call ");
        v(r9);
        AudioTrack r10 = v;
        if (r10 == null) goto L11;
        r10.release();
    L11:
        e = null;
        f = "";
        o = 0;
        AudioTrack r11 = v;
        if (r11 == null) goto L14;
        r11.flush();
    L14:
        v = null;
        c68.b.d("AudioStream:Player", "release MediaSession resources");
        a r12 = l();
        if (r12.f == false) goto L24;
        c68.b.d("AudioStream:Player", "StreamMediaSessionManager.releaseMediaSession");
        Object r3 = r12.d;
        monitor-enter(r3);
        r12.e.clear();     // Catch: Throwable -> L26
        t r4 = r12.a;     // Catch: Throwable -> L26
        if (r4 == null) goto L22;
        r4.stopService();     // Catch: Throwable -> L26
    L22:
        r12.a = null;     // Catch: Throwable -> L26
        r12.b();     // Catch: Throwable -> L26
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r3);
    L26:
        th = move-exception;
        throw th;
    L24:
        j = null;
        c = null;
        d = null;
        r2.i("AudioStreamPlayer", "exec stop() call finished");
        return;
    L5:
        if (fna.g.d() == true) goto L7;
        r8.stop();
        goto L8
    L7:
        r8.stop();
        gna.a.a(r8.hashCode());
        goto L8
    }

    public final void s(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "uuid");
        Intrinsics.checkNotNullParameter(r10, "reason");
        int r0 = c68.b.a;
        c68.b.d("AudioStream:Player", "pause called: uuid=" + r9 + ", reason=" + r10);
        com.larus.audioplayer.api.stream.StreamPlayerStatus r1 = com.larus.audioplayer.api.stream.StreamPlayerStatus.PAUSED;
        q(this, r1, r10);
        AudioTrack r4 = v;
        if (r4 != null) goto L5;
        return;
    L5:
        if (n(r4) == true) goto L7;
    L9:
        boolean r5 = false;
    L11:
        if (r5 == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L26;
        v(r1);
        w(CompletableDeferredKt.CompletableDeferred$default(null, 1, null));
        if (r4.getState() == 1) goto L20;
        c68.b.b("AudioStream:Player", "state is not initialized, pause failed");
        return;
    L20:
        if (fna.g.d() == true) goto L22;
        r4.pause();
    L23:
        c68.b.d("AudioStream:Player", "pause called: uuid=" + r9 + ", reason=" + r10 + ", paused: " + n(r4));
        return;
    L22:
        r4.pause();
        gna.a.a(r4.hashCode());
        goto L23
    L26:
        return;
    L7:
        if (r4.getPlayState() != 3) goto L9;
        r5 = true;
        goto L11
    }

    public final void u(String r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "uuid");
        Intrinsics.checkNotNullParameter(r21, "reason");
        int r2 = c68.b.a;
        c68.b.d("AudioStream:Player", "resume called: uuid=" + r20 + ", reason=" + r21);
        String r6 = null;
        if (h != com.larus.audioplayer.api.stream.StreamPlayerStatus.ERROR) goto L46;
        c88.a r0 = d;
        if (r0 == null) goto L7;
        String r1 = r0.a;
    L9:
        if (r1 != null) goto L11;
        String r8 = "";
    L12:
        z r3 = j;
        if (r3 == null) goto L15;
        String r4 = r3.b;
    L16:
        if (r4 != null) goto L18;
        String r9 = "";
    L19:
        if (r3 == null) goto L21;
        String r5 = r3.c;
    L22:
        if (r5 != null) goto L24;
        String r10 = "";
    L25:
        if (r3 == null) goto L27;
        String r11 = r3.d;
    L28:
        Pair<String, String> r7 = c;
        if (r7 == null) goto L31;
        String r12 = (String) r7.getFirst();
    L32:
        if (r12 != null) goto L34;
        String r13 = "";
    L35:
        Pair<String, String> r14 = c;
        if (r14 == null) goto L38;
        r6 = (String) r14.getSecond();
    L38:
        if (r6 != null) goto L40;
        String r15 = "";
    L41:
        y78.a r16 = i;
        String r17 = G.b;
        JSONObject r19 = l;
        if (r19 != null) goto L44;
        r19 = new JSONObject();
    L44:
        y(r8, r9, r10, r11, r13, r15, r16, 0, r17, r19, "last_error");
        FLogger.a.i("AudioStreamPlayer", "exec resume，but current state is  error， so exec start() directly");
        return;
    L40:
        r15 = r6;
        goto L41
    L34:
        r13 = r12;
        goto L35
    L31:
        r12 = null;
        goto L32
    L27:
        r11 = null;
        goto L28
    L24:
        r10 = r5;
        goto L25
    L21:
        r5 = null;
        goto L22
    L18:
        r9 = r4;
        goto L19
    L15:
        r4 = null;
        goto L16
    L11:
        r8 = r1;
        goto L12
    L7:
        r1 = null;
        goto L9
    L46:
        a r22 = l();
        if (r22.f == false) goto L50;
        c68.b.d("AudioStream:Player", "StreamMediaSessionManager.updateMediaMetadata");
        r22.a(new k());
    L50:
        q(this, com.larus.audioplayer.api.stream.StreamPlayerStatus.RESUME, r21);
        FLogger.a.i("AudioStreamPlayer", "receive resume() call uuid=" + r20);
        AudioTrack r23 = v;
        if (r23 != null) goto L53;
    L62:
        r23 = null;
    L63:
        v(com.larus.audioplayer.api.stream.StreamPlayerStatus.PLAYING);
        CompletableDeferred<Boolean> r24 = x;
        if (r24 == null) goto L66;
        r24.complete(Boolean.TRUE);
    L66:
        w(null);
        if (r23 != null) goto L69;
        return;
    L69:
        if (fna.g.d() == true) goto L71;
        r23.play();
        return;
    L71:
        r23.play();
        gna.a.c(r23.hashCode());
        return;
    L53:
        if (n(r23) == true) goto L55;
    L59:
        boolean r25 = false;
    L60:
        if (r25 == false) goto L62;
    L55:
        if (h != com.larus.audioplayer.api.stream.StreamPlayerStatus.PAUSED) goto L57;
    L58:
        r25 = true;
        goto L60
    L57:
        if (h != com.larus.audioplayer.api.stream.StreamPlayerStatus.PREPARE) goto L59;
        goto L58
    }

    public static void q(AudioStreamPlayer r5, com.larus.audioplayer.api.stream.StreamPlayerStatus r6, String r7) {
        com.larus.audioplayer.api.stream.StreamPlayerStatus r0 = h;
        Pair<String, String> r1 = c;
        if (r1 == null) goto L6;
        String r2 = (String) r1.getFirst();
        if (r2 == null) goto L6;
    L7:
        r5.getClass();
        com.larus.platform.service.o r8 = com.larus.platform.service.o.a;
        JSONObject r3 = f();
        r3.put("cur_status", r0);
        r3.put("newStatus", r6);
        r3.put("cur_playing_url", r2);
        r3.put("new_playing_url", "");
        r3.put("change_reason", r7);
        Unit r9 = Unit.INSTANCE;
        r8.reportEvent("stream_player_status_change", r3);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public static void t(String r15, final Function1 r16, final Function0 r17) {
        if (Intrinsics.areEqual(G.b, r15) == true) goto L5;
        FLogger.a.i("AudioStreamPlayer", "requireAudioFocus change scene from " + G.b + " to " + r15);
        G = new com.larus.media.model.a(null, r15, false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, com.larus.media.o.a(), MediaLevel.PLAY_HIGH.getValue(), false, F, 1197);
    L5:
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.m(G, new g(r16), new h(r17), 0, 8);
    }

    public static void p(String r3, String r4, int r5, long r6) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = f();
        r1.put("resource_id", r3);
        r1.put("loop_index", r5);
        r1.put("url", r4);
        r1.put("total_cos_duration", r6);
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("deep_research_podcast_chunk_success", r1);
    }

    public static void g(Throwable r6, int r7, String r8, String r9, int r10) {
        o(r7, r8, r9, r10, r6.toString(), -1);
        C = new Pair(j(), Long.valueOf(i(j())));
        e = new Pair(2, "start sse error. msg=" + r6);
        v(com.larus.audioplayer.api.stream.StreamPlayerStatus.ERROR);
        FLogger.a.e("AudioStreamPlayer", "catch parse chunk data error, err=" + r6);
    }

    public static void o(int r3, String r4, String r5, int r6, String r7, int r8) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = f();
        r1.put("seq_no", r3);
        r1.put("resource_id", r4);
        r1.put("loop_index", r6);
        r1.put("error_msg", r7);
        r1.put("error_code", r8);
        r1.put("url", r5);
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("deep_research_podcast_chunk_error", r1);
    }

    public final Object z(String r41, String r42, Function1<? super byte[], Integer> r43, Function3<? super Integer, ? super byte[], ? super Continuation<? super Unit>, ? extends Object> r44, Function0<Boolean> r45, int r46, int r47, long r48, boolean r50, Continuation<? super Unit> r51) {
        String r8 = r41;
        String r9 = r42;
        Function3<? super Integer, ? super byte[], ? super Continuation<? super Unit>, ? extends Object> r10 = r44;
        Function0<Boolean> r11 = r45;
        int r12 = r46;
        int r13 = r47;
        if ((r51 instanceof AudioStreamPlayer$startSseChunk$1) == false) goto L7;
        AudioStreamPlayer$startSseChunk$1 r2 = (AudioStreamPlayer$startSseChunk$1) r51;
        int r3 = r2.label;
        if ((r3 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r2.label = r3 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        AudioStreamPlayer$startSseChunk$1 r4 = r2;
        Object r1 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        String r15 = "AudioStreamPlayer";
        if (r6 != 0) goto L11;
        ResultKt.throwOnFailure(r1);
        if (r12 != s.b()) goto L46;
        FLogger.a.e("AudioStreamPlayer", "loopIndex=" + r12 + " sse startSseChunk return directly, auto retry is on limit。finish auto retry");
        return Unit.INSTANCE;
    L46:
        FLogger.a.i("AudioStreamPlayer", "sse request chunk data, seqNo=" + r13 + " loopIndex=" + r12 + " resourceId=" + r9 + " url=" + r8 + ' ');
        if (r43 == null) goto L49;
        int r14 = 1;
    L50:
        JSONObject r7 = new JSONObject();
        Ref.IntRef r16 = new Ref.IntRef();
        r16.element = -1;
        Ref.IntRef r33 = r16;
        String r35 = "StreamChunkParser.parseStream() finished, index=";
        r15 = "AudioStreamPlayer";
        String r37 = "loopIndex=";
        String r36 = "request sse error，bad to get bufferReader。finish the task directly, error msg=";
        String r17 = "sse chunk error. msg=";
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AudioStreamPlayer$mobStartRequest$1(r47, r42, r41, r46, r50, null), 2, null);
        z2 r19 = z2.a;     // Catch: Throwable -> L205 IOException -> L214
        Boolean r20 = r19.e0().d();     // Catch: IOException -> L202 Throwable -> L205
        if (r20 != null) goto L277;
        boolean r21 = true;
    L62:
        if (r21 == true) goto L256;
        long r22 = r48;
        int r110 = r14;
        String r23 = " oldSeqNo=";
        Object r24 = r5;
        AudioStreamPlayer$startSseChunk$1 r25 = r4;
        String r26 = r8 + "&seq_no=" + r13;     // Catch: Throwable -> L198 IOException -> L200
        r25.L$0 = r8;     // Catch: Throwable -> L198 IOException -> L200
        r25.L$1 = r9;     // Catch: Throwable -> L198 IOException -> L200
        r25.L$2 = r43;     // Catch: Throwable -> L198 IOException -> L200
        r25.L$3 = r10;     // Catch: Throwable -> L198 IOException -> L200
        r25.L$4 = r11;     // Catch: Throwable -> L198 IOException -> L200
        r25.L$5 = r33;     // Catch: Throwable -> L198 IOException -> L200
        r25.I$0 = r12;     // Catch: Throwable -> L198 IOException -> L200
        r25.I$1 = r13;     // Catch: Throwable -> L198 IOException -> L200
        r25.J$0 = r22;     // Catch: Throwable -> L198 IOException -> L200
        int r111 = r110;
        r25.I$2 = r111;     // Catch: Throwable -> L198 IOException -> L200
        r25.label = 2;     // Catch: Throwable -> L198 IOException -> L200
        r33 = r33;
        com.larus.network.http.g r0 = HttpExtKt.n(r26, r7, null, 28);     // Catch: Throwable -> L194 IOException -> L196
        if (r0 != r24) goto L103;
        return r24;
    L103:
        Object r27 = r0;
        Ref.IntRef r112 = r33;
        Function1<? super byte[], Integer> r29 = r43;
    L285:
        com.larus.network.http.g r30 = (com.larus.network.http.g) r27;     // Catch: Throwable -> L190 IOException -> L192
        Function1<? super byte[], Integer> r31 = r29;
        int r32 = r111;
        Ref.IntRef r113 = r112;
    L279:
        Throwable r114 = r30.g;     // Catch: Throwable -> L184 IOException -> L187
        if (r114 != null) goto L250;
        String r34 = r15;
        String r115 = r23;
        BufferedReader r38 = r30.f;     // Catch: IOException -> L180 Throwable -> L182
        Ref.IntRef r210 = new Ref.IntRef();     // Catch: IOException -> L180 Throwable -> L182
        Ref.ObjectRef r39 = new Ref.ObjectRef();     // Catch: IOException -> L180 Throwable -> L182
        String r52 = r34;
        r39.element = new byte[0];     // Catch: Throwable -> L175 IOException -> L177
        Ref.ObjectRef r40 = new Ref.ObjectRef();     // Catch: Throwable -> L175 IOException -> L177
        Object r211 = r24;
        r40.element = new byte[0];     // Catch: IOException -> L173 Throwable -> L175
        if (r38 == null) goto L238;
        StreamChunkParser r49 = StreamChunkParser.a;     // Catch: IOException -> L173 Throwable -> L175
        if (r32 == 0) goto L151;
        boolean r212 = true;
    L152:
        AudioStreamPlayer$startSseChunk$2$1 r116 = new AudioStreamPlayer$startSseChunk$2$1(r12, r38, r113, r212, r210, r39, r31, r40, r10, null);     // Catch: IOException -> L173 Throwable -> L175
        r25.L$0 = r8;     // Catch: IOException -> L173 Throwable -> L175
        r25.L$1 = r9;     // Catch: IOException -> L173 Throwable -> L175
        r25.L$2 = r10;     // Catch: IOException -> L173 Throwable -> L175
        r25.L$3 = r11;     // Catch: IOException -> L173 Throwable -> L175
        r25.L$4 = r113;     // Catch: IOException -> L173 Throwable -> L175
        r25.L$5 = null;     // Catch: IOException -> L173 Throwable -> L175
        r25.I$0 = r12;     // Catch: IOException -> L173 Throwable -> L175
        r25.I$1 = r13;     // Catch: IOException -> L173 Throwable -> L175
        r25.J$0 = r22;     // Catch: IOException -> L173 Throwable -> L175
        r25.label = 3;     // Catch: IOException -> L173 Throwable -> L175
        Object r53 = r49.a(r38, r116, r11, r25);     // Catch: IOException -> L173 Throwable -> L175
        Object r54 = r211;
        if (r53 != r54) goto L156;
        return r54;
    L156:
        String r55 = r8;
        int r56 = r13;
        Ref.IntRef r57 = r113;
        Function3<? super Integer, ? super byte[], ? super Continuation<? super Unit>, ? extends Object> r117 = r10;
        int r310 = r12;
        Function0<Boolean> r118 = r11;
        long r119 = r22;
        int r59 = r310;
    L281:
        p(r9, r55, r59, SystemClock.elapsedRealtime() - r119);     // Catch: Throwable -> L167 IOException -> L169
        r15 = r52;
        FLogger.a.i(r15, r35 + r57.element + " end the task。");     // Catch: Throwable -> L163 IOException -> L165
        Job r60 = A;     // Catch: Throwable -> L163 IOException -> L165
        if (r60 == null) goto L238;
        Job.DefaultImpls.cancel$default(r60, null, 1, null);     // Catch: Throwable -> L163 IOException -> L165
    L165:
        e = e;
    L171:
        String r213 = r55;
        r112 = r57;
        Function3<? super Integer, ? super byte[], ? super Continuation<? super Unit>, ? extends Object> r311 = r117;
        r13 = r56;
        Function0<Boolean> r312 = r118;
        r12 = r59;
        r22 = r119;
        r11 = r312;
        r10 = r311;
    L172:
        Function3<? super Integer, ? super byte[], ? super Continuation<? super Unit>, ? extends Object> r61 = r10;
        r113 = r112;
        String r62 = r115;
        long r120 = r22;
        String r121 = r9;
        Function0<Boolean> r122 = r11;
        String r63 = r213;
    L220:
        int r64 = r113.element;
        if (r64 >= 0) goto L223;
        r64 = 0;
    L223:
        FLogger r65 = FLogger.a;
        r65.e(r15, "io error。trigger auto retry isFromTimeOut=" + B + " newSeqNo=" + r64 + r62 + r13);
        if (B == false) goto L236;
        Job r66 = A;
        if (r66 == null) goto L228;
        Job.DefaultImpls.cancel$default(r66, null, 1, null);
    L228:
        int r123 = r12 + 1;
        if (r123 == s.b()) goto L235;
        if (r13 == r64) goto L235;
        com.larus.platform.service.o r67 = com.larus.platform.service.o.a;
        JSONObject r68 = f();
        r68.put("seq_no", r64);
        r68.put("resource_id", r121);
        r68.put("loop_index", r123);
        r68.put("url", r63);
        Unit r69 = Unit.INSTANCE;
        r67.reportEvent("deep_research_podcast_chunk_auto_retry", r68);
        r25.L$0 = null;
        r25.L$1 = null;
        r25.L$2 = null;
        r25.L$3 = null;
        r25.L$4 = null;
        r25.L$5 = null;
        r25.label = 4;
        if (A(this, r63, r121, null, r61, r122, r123, r64, r120, true, r25, 4) != r54) goto L238;
        return r54;
    L235:
        r65.e(r15, r37 + r12 + " on limit， do not retry again. newSeqNo=" + r64);
        g(e, r64, r121, r63, r123);
        goto L238
    L236:
        g(e, r13, r121, r63, r12);
        r65.e(r15, "find io error，but not triggered by timeout task，so finish the whole task directly! newSeqNo=" + r64 + r62 + r13);
    L163:
        th = th;
    L210:
        int r70 = r57.element;
        if (r70 >= 0) goto L213;
        r70 = 0;
    L213:
        g(th, r70, r9, r55, r59);
        FLogger.a.e(r15, "net err. newSeqNo=" + r70 + r115 + r56 + " e=" + th);
        goto L238
    L169:
        e = e;
        r15 = r52;
    L167:
        th = th;
        r15 = r52;
        goto L210
    L151:
        r212 = false;
    L238:
        return Unit.INSTANCE;
    L173:
        e = e;
        r15 = r52;
        r54 = r211;
    L189:
        r120 = r22;
        r61 = r10;
        r62 = r115;
        r121 = r9;
        r122 = r11;
    L219:
        r63 = r8;
    L175:
        th = th;
        r15 = r52;
    L186:
        r55 = r8;
        r59 = r12;
        r56 = r13;
        r57 = r113;
    L177:
        e = e;
        r15 = r52;
    L179:
        r54 = r24;
        goto L189
    L180:
        e = e;
    L140:
        r54 = r24;
        r15 = r34;
    L182:
        th = th;
        r15 = r34;
        goto L186
    L250:
    L131:
        th = th;
        String r71 = r15;
        r115 = r23;
    L138:
        r112 = r113;
    L139:
        r15 = r71;
        r55 = r8;
        r59 = r12;
        r56 = r13;
        r57 = r112;
    L133:
        e = e;
        r34 = r15;
        r115 = r23;
        goto L140
    L248:
        o(r13, r9, r8, r12, String.valueOf(r114), r30.b);     // Catch: Throwable -> L131 IOException -> L133
        C = new Pair(j(), Boxing.boxLong(i(j())));     // Catch: Throwable -> L131 IOException -> L133
        Integer r72 = Boxing.boxInt(2);     // Catch: Throwable -> L131 IOException -> L133
        r115 = r23;
        StringBuilder r124 = new StringBuilder(r17);     // Catch: Throwable -> L127 IOException -> L129
    L125:
        e = e;
        r71 = r15;
    L137:
        r54 = r24;
        r15 = r71;
        r213 = r8;
        r112 = r113;
        goto L172
    L115:
        r124.append(r30.g);     // Catch: Throwable -> L127 IOException -> L129
        e = new Pair(r72, r124.toString());     // Catch: Throwable -> L127 IOException -> L129
        v(com.larus.audioplayer.api.stream.StreamPlayerStatus.ERROR);     // Catch: Throwable -> L127 IOException -> L129
        FLogger r73 = FLogger.a;     // Catch: Throwable -> L127 IOException -> L129
        StringBuilder r74 = new StringBuilder(r36);     // Catch: Throwable -> L127 IOException -> L129
        r74.append(r30.g);     // Catch: Throwable -> L127 IOException -> L129
        r71 = r15;
        r73.e(r71, r74.toString());     // Catch: Throwable -> L121 IOException -> L123
        return Unit.INSTANCE;
    L123:
        e = e;
    L121:
        th = th;
        goto L138
    L129:
        e = e;
        r34 = r15;
    L127:
        th = th;
        r71 = r15;
        goto L138
    L135:
        e = e;
        r71 = r15;
        r115 = r23;
        goto L137
    L187:
        e = e;
        r15 = r15;
        r115 = r23;
    L184:
        th = th;
        r15 = r15;
        r115 = r23;
        goto L186
    L192:
        e = e;
        r15 = r15;
        String r125 = r23;
        r54 = r24;
        r33 = r112;
    L204:
        r62 = r125;
    L216:
        Ref.IntRef r126 = r33;
    L217:
        r61 = r10;
        r122 = r11;
        r113 = r126;
        r120 = r22;
    L218:
        r121 = r9;
    L190:
        th = th;
        r15 = r15;
        r115 = r23;
        Ref.IntRef r75 = r112;
    L208:
        Ref.IntRef r76 = r75;
    L209:
        r55 = r8;
        r59 = r12;
        r56 = r13;
        r57 = r76;
        goto L210
    L196:
        e = e;
        r15 = r15;
        r125 = r23;
        r54 = r24;
    L194:
        th = th;
        r115 = r23;
    L207:
        r75 = r33;
        goto L208
    L200:
        e = e;
        r15 = r15;
        r125 = r23;
        r54 = r24;
        r33 = r33;
    L198:
        th = th;
        r115 = r23;
        r33 = r33;
        goto L207
    L256:
        hq9.s r77 = r19.getAudioStreamPlayerMechanismConfig();     // Catch: Throwable -> L91 IOException -> L94
        RequestContext r79 = new RequestContext();     // Catch: Throwable -> L91 IOException -> L94
        long r80 = r77.b();     // Catch: Throwable -> L91 IOException -> L94
        long r81 = CommandStatus.DORA_TRACE;
        ((BaseRequestContext) r79).timeout_connect = r80 * r81;     // Catch: Throwable -> L91 IOException -> L94
        ((BaseRequestContext) r79).timeout_read = r77.c() * r81;     // Catch: Throwable -> L91 IOException -> L94
        ((BaseRequestContext) r79).timeout_write = r77.d() * r81;     // Catch: Throwable -> L91 IOException -> L94
        ((BaseRequestContext) r79).protect_timeout = r77.a() * r81;     // Catch: Throwable -> L91 IOException -> L94
        String r82 = r8 + "&seq_no=" + r13;     // Catch: Throwable -> L91 IOException -> L94
        r25 = r4;
        r25.L$0 = r8;     // Catch: IOException -> L89 Throwable -> L91
        r25.L$1 = r9;     // Catch: IOException -> L89 Throwable -> L91
        r25.L$2 = r43;     // Catch: IOException -> L89 Throwable -> L91
        r25.L$3 = r10;     // Catch: IOException -> L89 Throwable -> L91
        r25.L$4 = r11;     // Catch: IOException -> L89 Throwable -> L91
        r76 = r33;
        r25.L$5 = r76;     // Catch: Throwable -> L84 IOException -> L86
        r25.I$0 = r12;     // Catch: Throwable -> L84 IOException -> L86
        r25.I$1 = r13;     // Catch: Throwable -> L84 IOException -> L86
        r22 = r48;
        String r83 = " oldSeqNo=";
        r25.J$0 = r22;     // Catch: Throwable -> L80 IOException -> L82
        r25.I$2 = r14;     // Catch: Throwable -> L80 IOException -> L82
        r25.label = 1;     // Catch: Throwable -> L80 IOException -> L82
        int r127 = r14;
        r1 = HttpExtKt.n(r82, r7, r79, 12);     // Catch: Throwable -> L80 IOException -> L82
        r24 = r5;
        if (r1 != r24) goto L73;
        return r24;
    L73:
        Function1<? super byte[], Integer> r128 = r43;
        r213 = r8;
        r32 = r127;
        r112 = r76;
    L263:
        r31 = r128;
        r113 = r112;
        r8 = r213;
        String r313 = r83;
        r30 = (com.larus.network.http.g) r1;     // Catch: Throwable -> L76 IOException -> L78
        r23 = r313;
        goto L279
    L78:
        e = e;
        r15 = r15;
        r115 = r83;
        r54 = r24;
    L76:
        th = th;
        r71 = r15;
        r115 = r83;
        r8 = r213;
        goto L139
    L82:
        e = e;
    L96:
        r15 = r15;
        r54 = r5;
        r126 = r76;
        r62 = r83;
    L80:
        th = th;
    L93:
        r15 = r15;
        r115 = r83;
        goto L209
    L86:
        e = e;
        r22 = r48;
        r83 = " oldSeqNo=";
    L84:
        th = th;
        r83 = " oldSeqNo=";
        goto L93
    L89:
        e = e;
        r22 = r48;
        r83 = " oldSeqNo=";
        r76 = r33;
    L94:
        e = e;
        r22 = r48;
        r83 = " oldSeqNo=";
        r76 = r33;
        r25 = r4;
    L91:
        th = th;
        r83 = " oldSeqNo=";
        r76 = r33;
        goto L93
    L277:
        r21 = r20.booleanValue();     // Catch: Throwable -> L56 IOException -> L58
    L58:
        e = e;
        r120 = r48;
        r15 = r15;
        r61 = r10;
        r122 = r11;
        r62 = " oldSeqNo=";
        r54 = r5;
        r113 = r33;
        r25 = r4;
    L56:
        th = th;
        r71 = r15;
        r115 = " oldSeqNo=";
        r112 = r33;
        goto L139
    L202:
        e = e;
        r22 = r48;
        r15 = r15;
        r125 = " oldSeqNo=";
        r54 = r5;
        r25 = r4;
    L214:
        e = e;
        r22 = r48;
        r15 = r15;
        r62 = " oldSeqNo=";
        r54 = r5;
        r25 = r4;
    L205:
        th = th;
        r115 = " oldSeqNo=";
        goto L207
    L49:
        r14 = 0;
        goto L50
    L11:
        if (r6 != 1) goto L13;
        int r84 = r4.I$2;
        long r85 = r4.J$0;
        r56 = r4.I$1;
        int r129 = r4.I$0;
        Ref.IntRef r130 = (Ref.IntRef) r4.L$5;
        r118 = (Function0) r4.L$4;
        r117 = (Function3) r4.L$3;
        r128 = (Function1) r4.L$2;
        String r131 = (String) r4.L$1;
        r213 = (String) r4.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L36 IOException -> L39
        r25 = r4;
        r35 = "StreamChunkParser.parseStream() finished, index=";
        r37 = "loopIndex=";
        r36 = "request sse error，bad to get bufferReader。finish the task directly, error msg=";
        r32 = r84;
        r24 = r5;
        r17 = "sse chunk error. msg=";
        r22 = r85;
        r112 = r130;
        r11 = r118;
        r15 = "AudioStreamPlayer";
        r9 = r131;
        r12 = r129;
        r10 = r117;
        r13 = r56;
        r83 = " oldSeqNo=";
        goto L263
    L39:
        e = e;
        r59 = r129;
        String r132 = r131;
    L41:
        r54 = r5;
        r25 = r4;
        r37 = "loopIndex=";
        r113 = r130;
        r122 = r118;
        r121 = r132;
        r62 = " oldSeqNo=";
        r12 = r59;
        r120 = r85;
        r63 = r213;
        Function3<? super Integer, ? super byte[], ? super Continuation<? super Unit>, ? extends Object> r314 = r117;
        r13 = r56;
        r61 = r314;
    L36:
        th = th;
        r59 = r129;
        r57 = r130;
        r132 = r131;
        String r133 = r213;
    L38:
        r9 = r132;
        r55 = r133;
        r115 = " oldSeqNo=";
        goto L210
    L13:
        if (r6 == 2) goto L26;
        if (r6 == 3) goto L19;
        if (r6 != 4) goto L18;
        ResultKt.throwOnFailure(r1);
        goto L238
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r119 = r4.J$0;
        r56 = r4.I$1;
        r59 = r4.I$0;
        r57 = (Ref.IntRef) r4.L$4;
        r118 = (Function0) r4.L$3;
        r117 = (Function3) r4.L$2;
        r132 = (String) r4.L$1;
        r133 = (String) r4.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L22 IOException -> L24
        r54 = r5;
        r25 = r4;
        r35 = "StreamChunkParser.parseStream() finished, index=";
        r37 = "loopIndex=";
        r52 = "AudioStreamPlayer";
        r9 = r132;
        r55 = r133;
        r115 = " oldSeqNo=";
        goto L281
    L24:
        e = e;
        r213 = r133;
        r130 = r57;
        r85 = r119;
    L22:
        th = th;
        goto L38
    L26:
        int r86 = r4.I$2;
        long r134 = r4.J$0;
        int r135 = r4.I$1;
        int r136 = r4.I$0;
        r112 = (Ref.IntRef) r4.L$5;
        r122 = (Function0) r4.L$4;
        Function3<? super Integer, ? super byte[], ? super Continuation<? super Unit>, ? extends Object> r214 = (Function3) r4.L$3;
        r29 = (Function1) r4.L$2;
        String r87 = (String) r4.L$1;
        r63 = (String) r4.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L29 IOException -> L31
        r25 = r4;
        r35 = "StreamChunkParser.parseStream() finished, index=";
        r37 = "loopIndex=";
        r36 = "request sse error，bad to get bufferReader。finish the task directly, error msg=";
        r24 = r5;
        r17 = "sse chunk error. msg=";
        r22 = r134;
        r15 = "AudioStreamPlayer";
        r11 = r122;
        r10 = r214;
        r111 = r86;
        r27 = r1;
        r23 = " oldSeqNo=";
        r9 = r87;
        r8 = r63;
        r13 = r135;
        r12 = r136;
        goto L285
    L31:
        e = e;
        r54 = r5;
        r25 = r4;
        r37 = "loopIndex=";
        r113 = r112;
        r61 = r214;
        r62 = " oldSeqNo=";
        r120 = r134;
        r121 = r87;
        r13 = r135;
        r12 = r136;
    L29:
        th = th;
        r71 = "AudioStreamPlayer";
        r115 = " oldSeqNo=";
        r9 = r87;
        r8 = r63;
        r13 = r135;
        r12 = r136;
    L7:
        r2 = new AudioStreamPlayer$startSseChunk$1(this, r51);
        goto L8
    }

    public final void y(final String r22, final String r23, final String r24, final String r25, final String r26, final String r27, final y78.a r29, int r210, String r30, final JSONObject r31, final String r32) {
        Intrinsics.checkNotNullParameter(r22, "appletId");
        Intrinsics.checkNotNullParameter(r23, "title");
        Intrinsics.checkNotNullParameter(r24, "artist");
        Intrinsics.checkNotNullParameter(r26, "url");
        Intrinsics.checkNotNullParameter(r27, "uuid");
        Intrinsics.checkNotNullParameter(r30, "scene");
        Intrinsics.checkNotNullParameter(r31, "extra");
        Intrinsics.checkNotNullParameter(r32, "reason");
        final Ref.LongRef r4 = new Ref.LongRef();
        if (r210 <= 0) goto L6;
        r4.element = r210;
    L11:
        if (Intrinsics.areEqual(r27, j()) == true) goto L13;
    L16:
        String r5 = r31.optString("resourceType");
        FLogger.a.i("AudioStreamPlayer", "checkNeedIntercept type=" + r5);
        IStreamPlayerInterceptor.StreamType[] r13 = IStreamPlayerInterceptor.StreamType.values();
        int r14 = r13.length;
        int r15 = 0;
    L17:
        if (r15 >= r14) goto L38;
        IStreamPlayerInterceptor.StreamType r8 = r13[r15];
        if (Intrinsics.areEqual(r5, r8.getType()) == false) goto L37;
        List<IStreamPlayerInterceptor> r9 = b;
        ArrayList r6 = new ArrayList();
        Iterator r10 = ((ArrayList) r9).iterator();
    L21:
        boolean r19 = true;
        if (r10.hasNext() == false) goto L30;
        Object r11 = r10.next();
        Iterator r20 = r10;
        if (((IStreamPlayerInterceptor) r11).c() == r8) goto L27;
        r19 = false;
    L27:
        if (r19 == false) goto L29;
        r6.add(r11);
    L29:
        r10 = r20;
        goto L21
    L30:
        Iterator r7 = r6.iterator();
    L32:
        if (r7.hasNext() == false) goto L37;
        IStreamPlayerInterceptor r12 = (IStreamPlayerInterceptor) r7.next();
        if (r12.a(r31) == false) goto L32;
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("needIntercept, interceptorTag=DocFragment streamType=");
        r12.b();
        r17.append(r8.getType());
        r16.i("AudioStreamPlayer", r17.toString());
        boolean r110 = true;
    L39:
        if (r110 == false) goto L42;
        FLogger.a.w("AudioStreamPlayer", "play intercepted. url=" + r26 + " scene=" + r30);
        return;
    L42:
        final String r21 = r26 + "&need_wav_header=true&time_offset=" + r4.element;
        if (Intrinsics.areEqual(r27, j()) == true) goto L45;
    L48:
        FLogger.a.i("AudioStreamPlayer", "receive play request timeOffset=" + r4.element + " inputTimeOff=" + r210 + " extra=" + r31 + " url=" + r21);
        q(this, com.larus.audioplayer.api.stream.StreamPlayerStatus.PLAYING, r32);
        if (o0.d(j()) == false) goto L51;
    L52:
        B(j(), "start");
    L53:
        t(r30, new e(r31, r26, r4, r21, r27, r29, r22, r23, r24, r25), new f());
        return;
    L51:
        if (v == null) goto L53;
    L45:
        if (h != com.larus.audioplayer.api.stream.StreamPlayerStatus.PAUSED) goto L48;
        FLogger.a.i("AudioStreamPlayer", "target play resource is same to current, resume directly!");
        v(com.larus.audioplayer.api.stream.StreamPlayerStatus.PREPARE);
        t(r30, new com.larus.audioplayer.impl.stream.c(r27, r23, r24, r25, r32), new d());
        return;
    L37:
        r15 = r15 + 1;
        r5 = r5;
        goto L17
    L38:
        r110 = false;
        goto L39
    L13:
        if (h != com.larus.audioplayer.api.stream.StreamPlayerStatus.PLAYING) goto L16;
        FLogger.a.w("AudioStreamPlayer", "stop replay, because of status is playing and uuid is same");
        return;
    L6:
        if (Intrinsics.areEqual(C.getFirst(), r27) == false) goto L11;
        if (((Number) C.getSecond()).longValue() <= 0) goto L11;
        r4.element = ((Number) C.getSecond()).longValue();
        goto L11
    }

    public static /* synthetic */ Object A(AudioStreamPlayer r13, String r14, String r15, q r16, Function3 r17, Function0 r19, int r110, int r20, long r21, boolean r23, Continuation r24, int r25) {
        if ((r25 & 4) == 0) goto L5;
        q r4 = null;
    L7:
        if ((r25 & 32) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r25 & 64) == 0) goto L13;
        int r8 = 0;
    L15:
        return r13.z(r14, r15, r4, r17, r19, r7, r8, r21, r23, r24);
    L13:
        r8 = r20;
        goto L15
    L9:
        r7 = r110;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }
}
