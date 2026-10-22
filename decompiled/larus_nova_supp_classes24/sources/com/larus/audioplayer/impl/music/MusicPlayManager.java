package com.larus.audioplayer.impl.music;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.l0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.mediaplay.MediaPlayStateChangeUtils;
import e88.a0;
import e88.b0;
import e88.u;
import e88.w;
import e88.x;
import e88.y;
import e88.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MusicPlayManager {
    public static final MusicPlayManager a = null;
    public static final ConcurrentHashMap<String, ArrayList<a88.e>> b = null;
    public static final ConcurrentHashMap<String, com.larus.audioplayer.impl.music.a> c = null;
    public static final c d = null;
    public static final ArrayList<Function1<e88.a, Unit>> e = null;
    public static final LinkedList<a88.b> f = null;
    public static final Handler g = null;
    public static final b h = null;
    public static e88.a i;
    public static a88.e j;
    public static com.larus.audioplayer.impl.music.a k;
    public static a88.d l;
    public static String m;
    public static int n;
    public static a o;
    public static final PlayingMode p = null;
    public static boolean q;
    public static d r;
    public static final Object s = null;
    public static final Object t = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/audioplayer/impl/music/MusicPlayManager$PlayingMode;", "", "<init>", "(Ljava/lang/String;I)V", "LOOP_MODE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PlayingMode extends Enum<PlayingMode> {
        public static final PlayingMode LOOP_MODE = null;
        public static final /* synthetic */ PlayingMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PlayingMode> getEntries() {
            return b;
        }

        static {
            PlayingMode r0 = new PlayingMode();
            LOOP_MODE = r0;
            PlayingMode[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public PlayingMode() {
            super("LOOP_MODE", 0);
        }

        public static PlayingMode[] values() {
            return (PlayingMode[]) a.clone();
        }

        public static PlayingMode valueOf(String r1) {
            return (PlayingMode) r27.a.a(PlayingMode.class, r1);
        }
    }

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MusicPlayManager.o = null;     // Catch: Throwable -> L10
            int r0 = MusicPlayManager.n;     // Catch: Throwable -> L10
            if (r0 != 3) goto L6;
            return;
        L6:
            if (r0 == 2) goto L17;
            MusicPlayManager r1 = MusicPlayManager.a;     // Catch: Throwable -> L10
            MusicPlayManager.b(new w());     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    public static final class b implements e78.c {
        public b() {
        }

        @Override // e78.c
        public final void c() {
        }

        @Override // e78.c
        public final void d() {
        }

        @Override // e78.c
        public final String getBizScene() {
            return GlobalAudioSceneEnum.PLUGIN_MUSIC;
        }

        @Override // e78.c
        public final String getScene() {
            return GlobalAudioSceneEnum.PLUGIN_MUSIC;
        }

        @Override // e78.c
        public final void a() {
            MusicPlayManager r0 = MusicPlayManager.a;
            MusicPlayManager.b(new x());
        }

        @Override // e78.c
        public final boolean b() {
            MusicPlayManager r0 = MusicPlayManager.a;
            a88.e r1 = MusicPlayManager.j;
            String r2 = null;
            boolean r3 = false;
            if (r1 == null) goto L9;
            String r4 = r1.a;
            if (r4 == null) goto L9;
            if (MusicPlayManager.d(r4) == false) goto L10;
            r3 = MusicPlayManager.j(r4, null);
        L10:
            FLogger r5 = FLogger.a;
            StringBuilder r6 = new StringBuilder("GlobalAudioParticipant playNext triggered, result: ");
            r6.append(r3);
            r6.append(", musicId: ");
            r6.append(r4);
            r6.append(", musicTitle: ");
            if (r1 == null) goto L13;
            r2 = r1.c;
        L13:
            r6.append(r2);
            r5.i("MusicPlayManager", r6.toString());
            return r3;
        L9:
            r4 = null;
            goto L10
        }

        @Override // e78.c
        public final boolean e() {
            MusicPlayManager r0 = MusicPlayManager.a;
            a88.e r1 = MusicPlayManager.j;
            String r2 = null;
            boolean r3 = false;
            if (r1 == null) goto L9;
            String r4 = r1.a;
            if (r4 == null) goto L9;
            if (MusicPlayManager.e(r4) == false) goto L10;
            r3 = MusicPlayManager.k(r4, null);
        L10:
            FLogger r5 = FLogger.a;
            StringBuilder r6 = new StringBuilder("GlobalAudioParticipant playPrevious triggered, result: ");
            r6.append(r3);
            r6.append(", musicId: ");
            r6.append(r4);
            r6.append(", musicTitle: ");
            if (r1 == null) goto L13;
            r2 = r1.c;
        L13:
            r6.append(r2);
            r5.i("MusicPlayManager", r6.toString());
            return r3;
        L9:
            r4 = null;
            goto L10
        }

        @Override // e78.c
        public final GlobalAudioStateEnum getState() {
            int r0 = MusicPlayManager.n;
            if (r0 == 1) goto L12;
            if (r0 == 2) goto L15;
            if (r0 == 3) goto L14;
            return GlobalAudioStateEnum.NONE;
        L14:
            return GlobalAudioStateEnum.PLAYING;
        L15:
            return GlobalAudioStateEnum.PAUSED;
        L12:
            return GlobalAudioStateEnum.STOPPED;
        }

        @Override // e78.c
        public final boolean pause() {
            MusicPlayManager r0 = MusicPlayManager.a;
            a88.e r1 = MusicPlayManager.j;
            String r2 = null;
            if (r1 == null) goto L7;
            String r3 = r1.a;
            if (r3 == null) goto L7;
            boolean r4 = r0.g(r3);
        L8:
            FLogger r5 = FLogger.a;
            StringBuilder r6 = new StringBuilder("GlobalAudioParticipant pause triggered, result: ");
            r6.append(r4);
            r6.append(", musicId: ");
            r6.append(r3);
            r6.append(", musicTitle: ");
            if (r1 == null) goto L11;
            r2 = r1.c;
        L11:
            r6.append(r2);
            r5.i("MusicPlayManager", r6.toString());
            return r4;
        L7:
            r4 = false;
            r3 = null;
            goto L8
        }

        @Override // e78.c
        public final boolean play() {
            a88.e r0 = MusicPlayManager.j;
            String r1 = null;
            if (r0 == null) goto L5;
            MusicPlayManager.i(r0);
            boolean r2 = true;
        L6:
            FLogger r3 = FLogger.a;
            StringBuilder r4 = new StringBuilder("GlobalAudioParticipant play triggered, result: ");
            r4.append(r2);
            r4.append(", musicId: ");
            if (r0 == null) goto L9;
            String r5 = r0.a;
        L10:
            r4.append(r5);
            r4.append(", musicTitle: ");
            if (r0 == null) goto L13;
            r1 = r0.c;
        L13:
            r4.append(r1);
            r3.i("MusicPlayManager", r4.toString());
            return r2;
        L9:
            r5 = null;
            goto L10
        L5:
            r2 = false;
            r0 = null;
            goto L6
        }

        @Override // e78.c
        public final boolean stop() {
            MusicPlayManager r0 = MusicPlayManager.a;
            a88.e r1 = MusicPlayManager.j;
            String r2 = null;
            if (r1 == null) goto L7;
            String r3 = r1.a;
            if (r3 == null) goto L7;
            boolean r4 = r0.n(r3);
        L8:
            FLogger r5 = FLogger.a;
            StringBuilder r6 = new StringBuilder("GlobalAudioParticipant stop triggered, result: ");
            r6.append(r4);
            r6.append(", musicId: ");
            r6.append(r3);
            r6.append(", musicTitle: ");
            if (r1 == null) goto L11;
            r2 = r1.c;
        L11:
            r6.append(r2);
            r5.i("MusicPlayManager", r6.toString());
            return r4;
        L7:
            r4 = false;
            r3 = null;
            goto L8
        }
    }

    public static final class c implements com.larus.audioplayer.impl.music.a.b {
        public c() {
        }

        @Override // com.larus.audioplayer.impl.music.a.b
        public final void a(a88.e r2, com.larus.audioplayer.impl.music.a r3) {
            Intrinsics.checkNotNullParameter(r2, GlobalAudioSceneEnum.MUSIC);
            Intrinsics.checkNotNullParameter(r3, "engine");
            MusicPlayManager r4 = MusicPlayManager.a;
            MusicPlayManager.l(r2.a);
        }

        public final void c(a88.e r2, com.larus.audioplayer.impl.music.a r3) {
            Intrinsics.checkNotNullParameter(r2, GlobalAudioSceneEnum.MUSIC);
            Intrinsics.checkNotNullParameter(r3, "engine");
            MusicPlayManager r4 = MusicPlayManager.a;
            MusicPlayManager.l(r2.a);
        }

        @Override // com.larus.audioplayer.impl.music.a.b
        public final void b(a88.e r7, com.larus.audioplayer.impl.music.a r8, int r9) {
            Intrinsics.checkNotNullParameter(r7, GlobalAudioSceneEnum.MUSIC);
            Intrinsics.checkNotNullParameter(r8, "engine");
            a88.e r10 = MusicPlayManager.j;
            if (r10 == null) goto L5;
            String r11 = r10.a;
        L7:
            if (Intrinsics.areEqual(r11, r7.a) == false) goto L38;
            MusicPlayManager.n = r9;
            if (r9 == 1) goto L16;
            if (r9 == 2) goto L14;
            if (r9 != 3) goto L28;
            MusicPlayManager r12 = MusicPlayManager.a;
            MusicPlayManager.a();
            MusicPlayManager.b(new a0());
        L28:
            GlobalAudioObserver r13 = GlobalAudioObserver.a;
            int r0 = MusicPlayManager.n;
            if (r0 == 1) goto L35;
            if (r0 == 2) goto L34;
            if (r0 == 3) goto L33;
            GlobalAudioStateEnum r14 = GlobalAudioStateEnum.NONE;
        L36:
            r13.c(GlobalAudioSceneEnum.PLUGIN_MUSIC, r14, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("conversation_id", r7.k), TuplesKt.to("message_id", r7.l)}));
            return;
        L33:
            r14 = GlobalAudioStateEnum.PLAYING;
            goto L36
        L34:
            r14 = GlobalAudioStateEnum.PAUSED;
            goto L36
        L35:
            r14 = GlobalAudioStateEnum.STOPPED;
            goto L36
        L14:
            MusicPlayManager r15 = MusicPlayManager.a;
            MusicPlayManager.a();
            MusicPlayManager.b(new z());
            goto L28
        L16:
            if (MusicPlayManager.m == null) goto L18;
        L27:
            MusicPlayManager r16 = MusicPlayManager.a;
            MusicPlayManager.a();
            a r17 = new a();
            MusicPlayManager.g.postDelayed(r17, 3000);
            MusicPlayManager.o = r17;
            MusicPlayManager.j = null;
            MusicPlayManager.k = null;
            MusicPlayManager.l = null;
            GlobalAudioController.a.d(MusicPlayManager.h);
            goto L28
        L18:
            if (MusicPlayManager.p != PlayingMode.LOOP_MODE) goto L26;
            MusicPlayManager r19 = MusicPlayManager.a;
            a88.e r20 = MusicPlayManager.j;
            if (r20 == null) goto L22;
            String r21 = r20.a;
        L24:
            if (MusicPlayManager.d(r21) == false) goto L26;
        L22:
            r21 = null;
        L26:
            MusicPlayManager r22 = MusicPlayManager.a;
            MusicPlayManager.j = null;
            MusicPlayManager.k = null;
            MusicPlayManager.l = null;
            GlobalAudioController.a.d(MusicPlayManager.h);
            MusicPlayManager.b(new y());
            goto L28
        L38:
            return;
        L5:
            r11 = null;
            goto L7
        }
    }

    public static final class d implements ServiceConnection {
        public d() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            Intrinsics.checkNotNullParameter(r2, "className");
            Intrinsics.checkNotNullParameter(r3, "service");
            MusicPlayManager r4 = MusicPlayManager.a;
            MusicPlayService r0 = null;
            if ((r3 instanceof MusicPlayService.d) == false) goto L5;
            MusicPlayService.d r5 = (MusicPlayService.d) r3;
        L6:
            if (r5 == null) goto L14;
            MusicPlayService r6 = r5.a;
            if (r6 == null) goto L14;
            Iterator r7 = new CopyOnWriteArrayList(MusicPlayManager.e).iterator();
        L11:
            if (r7.hasNext() == false) goto L13;
            ((Function1) r7.next()).invoke(r6);
            goto L11
        L13:
            r0 = r6;
        L14:
            MusicPlayManager.i = r0;
            MusicPlayManager.q = false;
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class e implements l0 {
        public final /* synthetic */ l0 a;
        public final /* synthetic */ String b;

        public final void onCompletion(boolean r4) {
            l0 r0 = this.a;
            if (r0 == null) goto L5;
            r0.onCompletion(r4);
        L5:
            MusicPlayManager r1 = MusicPlayManager.a;
            MusicPlayManager.b(new b0());
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("seekTo result ");
            r3.append(r4);
            r3.append(" with musicId: ");
            r3.append(this.b);
            r3.append(", musicTitle: ");
            a88.e r5 = MusicPlayManager.j;
            if (r5 == null) goto L8;
            String r6 = r5.c;
        L9:
            r3.append(r6);
            r2.i("MusicPlayManager", r3.toString());
            return;
        L8:
            r6 = null;
            goto L9
        }

        public e(l0 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public MusicPlayManager() {
    }

    static {
        a = new MusicPlayManager();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new c();
        e = new ArrayList();
        f = new LinkedList();
        g = new Handler(Looper.getMainLooper());
        h = new b();
        n = 1;
        p = PlayingMode.LOOP_MODE;
        s = new Object();
        t = new Object();
    }

    public static void a() {
        Object r0 = t;
        monitor-enter(r0);
        a r1 = o;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        g.removeCallbacks(r1);     // Catch: Throwable -> L10
        o = null;     // Catch: Throwable -> L10
    L7:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void b(Function1 r1) {
        Object r0 = s;
        monitor-enter(r0);
        c(r1);     // Catch: Throwable -> L7
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c(Function1 r5) {
        e88.a r0 = i;
        if (r0 != null) goto L5;
    L12:
        e.add(r5);
        if (q == false) goto L15;
        return;
    L15:
        q = true;
        d r1 = new d();
        AppHost.Companion r2 = AppHost.a;
        r2.getApplication().bindService(new Intent(r2.getApplication(), MusicPlayService.class), r1, 1);
        r = r1;
        return;
    L5:
        if (r0.a() == true) goto L8;
        r5.invoke(r0);
        return;
    L8:
        d r3 = r;
        if (r3 == null) goto L11;
        AppHost.a.getApplication().unbindService(r3);
        r = null;
    L11:
        i = null;
        goto L12
    }

    public static boolean d(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        a88.e r1 = j;
        if (r1 == null) goto L8;
        String r3 = r1.a;
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        a88.d r4 = l;
        if (r4 != null) goto L15;
        return false;
    L15:
        return r4.d();
    L8:
        r3 = null;
        goto L10
    }

    public static boolean e(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        a88.e r1 = j;
        if (r1 == null) goto L8;
        String r3 = r1.a;
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        a88.d r4 = l;
        if (r4 != null) goto L15;
        return false;
    L15:
        return r4.b();
    L8:
        r3 = null;
        goto L10
    }

    public static /* synthetic */ void i(a88.e r6) {
        a.h(r6, null, null, false, null);
    }

    public static void l(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<String, com.larus.audioplayer.impl.music.a> r0 = c;
        com.larus.audioplayer.impl.music.a r1 = r0.get(r3);
        if (r1 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(k, r1) == false) goto L9;
        k = null;
    L9:
        r0.remove(r3);
        r1.f.release();
    }

    public final synchronized boolean g(String r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "targetMusicId");     // Catch: Throwable -> L22
        a88.e r2 = j;     // Catch: Throwable -> L22
        String r3 = null;
        if (r2 == null) goto L7;
        String r4 = r2.a;     // Catch: Throwable -> L22
    L9:
        if (Intrinsics.areEqual(r7, r4) == true) goto L13;
        FLogger.a.i("MusicPlayManager", "pauseMusic fails with wrong musicId: ".concat(r7));     // Catch: Throwable -> L22
        monitor-exit(this);
        return false;
    L13:
        FLogger r0 = FLogger.a;     // Catch: Throwable -> L22
        StringBuilder r5 = new StringBuilder("pauseMusic succeeds with musicId: ");     // Catch: Throwable -> L22
        r5.append(r7);     // Catch: Throwable -> L22
        r5.append(", musicTitle: ");     // Catch: Throwable -> L22
        a88.e r8 = j;     // Catch: Throwable -> L22
        if (r8 == null) goto L16;
        r3 = r8.c;     // Catch: Throwable -> L22
    L16:
        r5.append(r3);     // Catch: Throwable -> L22
        r0.i("MusicPlayManager", r5.toString());     // Catch: Throwable -> L22
        com.larus.audioplayer.impl.music.a r9 = k;     // Catch: Throwable -> L22
        if (r9 == null) goto L19;
        int r1 = com.larus.audioplayer.impl.music.a.A;     // Catch: Throwable -> L22
        r9.f(false, "default");     // Catch: Throwable -> L22
    L19:
        monitor-exit(this);
        return true;
    L7:
        r4 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean n(String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "targetMusicId");     // Catch: Throwable -> L24
        a88.e r2 = j;     // Catch: Throwable -> L24
        if (r2 == null) goto L7;
        String r3 = r2.a;     // Catch: Throwable -> L24
    L9:
        if (Intrinsics.areEqual(r6, r3) == true) goto L14;
        FLogger.a.i("MusicPlayManager", "stopMusic fails with wrong musicId: " + r6);     // Catch: Throwable -> L24
        monitor-exit(this);
        return false;
    L14:
        FLogger r0 = FLogger.a;     // Catch: Throwable -> L24
        StringBuilder r4 = new StringBuilder("stopMusic succeeds with musicId: ");     // Catch: Throwable -> L24
        r4.append(r6);     // Catch: Throwable -> L24
        r4.append(", musicTitle: ");     // Catch: Throwable -> L24
        a88.e r7 = j;     // Catch: Throwable -> L24
        if (r7 == null) goto L17;
        String r8 = r7.c;     // Catch: Throwable -> L24
    L18:
        r4.append(r8);     // Catch: Throwable -> L24
        r0.i("MusicPlayManager", r4.toString());     // Catch: Throwable -> L24
        com.larus.audioplayer.impl.music.a r9 = k;     // Catch: Throwable -> L24
        if (r9 == null) goto L21;
        int r1 = com.larus.audioplayer.impl.music.a.A;     // Catch: Throwable -> L24
        r9.h(null);     // Catch: Throwable -> L24
    L21:
        monitor-exit(this);
        return true;
    L17:
        r8 = null;
        goto L18
    L7:
        r3 = null;
    L24:
        th = move-exception;
        throw th;
    }

    public static void f(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "musicId");
        LinkedList<a88.b> r0 = f;
        monitor-enter(r0);
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L8;
        ((a88.b) r1.next()).b(r3, r4);     // Catch: Throwable -> L12
        goto L6
    L8:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        FLogger.a.i("MusicPlayManager", "onMediaSessionMusicActionTriggered with musicId: " + r3);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean j(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "musicId");
        a88.e r0 = j;
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L7:
        if (Intrinsics.areEqual(r3, r1) == true) goto L9;
        return false;
    L9:
        a88.d r5 = l;
        if (r5 == null) goto L13;
        FLogger.a.i("MusicPlayManager", "trigger mNextAndPreviousMusicCallback playNextMusic");
        r5.a(r4);
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public static boolean k(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "musicId");
        a88.e r0 = j;
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L7:
        if (Intrinsics.areEqual(r3, r1) == true) goto L9;
        return false;
    L9:
        a88.d r5 = l;
        if (r5 == null) goto L13;
        FLogger.a.i("MusicPlayManager", "trigger mNextAndPreviousMusicCallback playPreviousMusic");
        r5.c(r4);
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public static boolean m(String r2, int r3, l0 r4) {
        Intrinsics.checkNotNullParameter(r2, "targetMusicId");
        a88.e r0 = j;
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L7:
        if (Intrinsics.areEqual(r2, r1) == true) goto L10;
        FLogger.a.i("MusicPlayManager", "seekTo fails with wrong musicId: ".concat(r2));
        return false;
    L10:
        com.larus.audioplayer.impl.music.a r5 = k;
        if (r5 == null) goto L15;
        e r6 = new e(r4, r2);
        r5.f.A(r3, r6);
        return true;
    L15:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public final synchronized void h(final a88.e r11, a88.c r12, final a88.d r13, final boolean r14, String r15) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, GlobalAudioSceneEnum.MUSIC);     // Catch: Throwable -> L45
        MediaPlayStateChangeUtils.b.b();     // Catch: Throwable -> L45
        a88.e r2 = j;     // Catch: Throwable -> L45
        com.larus.audioplayer.impl.music.a r3 = k;     // Catch: Throwable -> L45
        final String r5 = r11.a;     // Catch: Throwable -> L45
        ConcurrentHashMap<String, com.larus.audioplayer.impl.music.a> r4 = c;     // Catch: Throwable -> L45
        com.larus.audioplayer.impl.music.a r6 = r4.get(r5);     // Catch: Throwable -> L45
        if (r6 != null) goto L7;
        r6 = new com.larus.audioplayer.impl.music.a(r11, null, h);     // Catch: Throwable -> L45
        r4.put(r11.a, r6);     // Catch: Throwable -> L45
    L7:
        final com.larus.audioplayer.impl.music.a r8 = r6;
        if (r12 != null) goto L10;
    L16:
        c r16 = d;     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r16, "callback");     // Catch: Throwable -> L45
        if (r8.d == false) goto L19;
        r16.c(r8.a, r8);     // Catch: Throwable -> L45
    L19:
        r8.p = r16;     // Catch: Throwable -> L45
        if (r15 == null) goto L22;
        Intrinsics.checkNotNullParameter(r15, "resolution");     // Catch: Throwable -> L45
        r8.f.F(r15);     // Catch: Throwable -> L45
    L22:
        if (r2 == null) goto L24;
        String r17 = r2.a;     // Catch: Throwable -> L45
    L26:
        if (Intrinsics.areEqual(r5, r17) == true) goto L28;
    L30:
        if (r3 == null) goto L34;
        boolean r1 = true;
        if (r3.h != true) goto L34;
    L35:
        if (r1 == false) goto L37;
        m = r5;     // Catch: Throwable -> L45
        r3.h(new u(r5, r11, r8, r13, r14));     // Catch: Throwable -> L45
    L43:
        monitor-exit(this);
        return;
    L37:
        j = r11;     // Catch: Throwable -> L45
        k = r8;     // Catch: Throwable -> L45
        l = r13;     // Catch: Throwable -> L45
        if (r2 == null) goto L42;
        String r19 = r2.a;     // Catch: Throwable -> L45
        if (r19 == null) goto L42;
        l(r19);     // Catch: Throwable -> L45
    L42:
        FLogger.a.i("MusicPlayManager", "playMusic directly with new musicId: " + r5 + ", musicTitle: " + r11.c);     // Catch: Throwable -> L45
        com.larus.audioplayer.impl.music.a.g(r8, r14, false, null, 6);     // Catch: Throwable -> L45
    L34:
        r1 = false;
        goto L35
    L28:
        if (Intrinsics.areEqual(r3, r8) == false) goto L30;
        FLogger.a.i("MusicPlayManager", "playMusic with old musicId: " + r5 + ", musicTitle: " + r2.c);     // Catch: Throwable -> L45
        com.larus.audioplayer.impl.music.a.g(r8, r14, false, null, 6);     // Catch: Throwable -> L45
        goto L43
    L24:
        r17 = null;
        goto L26
    L10:
        if (Intrinsics.areEqual(r8.o, r12) == true) goto L16;
        if (r8.d == false) goto L15;
        r12 = null;
    L15:
        r8.o = r12;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }
}
