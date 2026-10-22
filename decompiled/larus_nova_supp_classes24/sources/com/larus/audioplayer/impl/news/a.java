package com.larus.audioplayer.impl.news;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.k4;
import com.larus.platform.api.l0;
import com.larus.platform.api.l4;
import com.larus.platform.api.n;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.utils.logger.FLogger;
import f88.f;
import f88.h;
import f88.i;
import f88.j;
import f88.k;
import f88.l;
import f88.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final a a = null;
    public static final C0089a b = null;
    public static final ArrayList<Function1<f88.a, Unit>> c = null;
    public static final b d = null;
    public static f88.a e;
    public static b88.d f;
    public static com.larus.audioplayer.impl.news.b g;
    public static b88.d h;
    public static int i;
    public static final n j = null;
    public static boolean k;
    public static c l;
    public static final Object m = null;
    public static volatile boolean n;

    /* JADX INFO: renamed from: com.larus.audioplayer.impl.news.a$a, reason: collision with other inner class name */
    public static final class C0089a implements com.larus.audioplayer.impl.news.b.InterfaceC0090b {
        public C0089a() {
        }

        @Override // com.larus.audioplayer.impl.news.b.InterfaceC0090b
        public final void l(String r2, com.larus.audioplayer.impl.news.b r3) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, "player");
            r3.m.release();
        }

        @Override // com.larus.audioplayer.impl.news.b.InterfaceC0090b
        public final void a(String r2, com.larus.audioplayer.impl.news.b r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, "player");
            b88.d r5 = a.f;
            if (r5 == null) goto L5;
            String r6 = r5.c;
        L7:
            if (Intrinsics.areEqual(r6, r2) == true) goto L9;
            return;
        L9:
            if (r4 != 1) goto L11;
            a.n = false;
            a r7 = a.a;
            a.a(new h());
            return;
        L11:
            if (r4 != 2) goto L18;
            a.n = true;
            a r8 = a.a;
            a.a(new i());
            return;
        L18:
            return;
        L5:
            r6 = null;
            goto L7
        }

        @Override // com.larus.audioplayer.impl.news.b.InterfaceC0090b
        public final void b(String r5, com.larus.audioplayer.impl.news.b r6, int r7) {
            Intrinsics.checkNotNullParameter(r5, "url");
            Intrinsics.checkNotNullParameter(r6, "player");
            b88.d r8 = a.f;
            if (r8 == null) goto L5;
            String r9 = r8.c;
        L7:
            if (Intrinsics.areEqual(r9, r5) == false) goto L39;
            a.i = r7;
            if (r7 == 1) goto L15;
            if (r7 == 2) goto L14;
            if (r7 != 3) goto L19;
            a r10 = a.a;
            a.a(new l());
        L19:
            GlobalAudioObserver r11 = GlobalAudioObserver.a;
            int r0 = a.i;
            if (r0 == 1) goto L26;
            if (r0 == 2) goto L25;
            if (r0 == 3) goto L24;
            GlobalAudioStateEnum r12 = GlobalAudioStateEnum.NONE;
        L27:
            LinkedHashMap r13 = new LinkedHashMap();
            b88.d r1 = a.f;
            if (r1 == null) goto L37;
            String r2 = r1.i;
            String r3 = "";
            if (r2 != null) goto L32;
            r2 = "";
        L32:
            r13.put("conversation_id", r2);
            String r4 = r1.j;
            if (r4 == null) goto L36;
            r3 = r4;
        L36:
            r13.put("message_id", r3);
        L37:
            Unit r14 = Unit.INSTANCE;
            r11.c(GlobalAudioSceneEnum.PLUGIN_AUDIO, r12, r13);
            return;
        L24:
            r12 = GlobalAudioStateEnum.PLAYING;
            goto L27
        L25:
            r12 = GlobalAudioStateEnum.PAUSED;
            goto L27
        L26:
            r12 = GlobalAudioStateEnum.STOPPED;
            goto L27
        L14:
            a r15 = a.a;
            a.a(new k());
            goto L19
        L15:
            a r16 = a.a;
            a.f = null;
            a.g = null;
            if (a.h == null) goto L18;
            return;
        L18:
            GlobalAudioController.a.d(a.d);
            a.a(new j());
            goto L19
        L39:
            return;
        L5:
            r9 = null;
            goto L7
        }
    }

    public static final class b implements e78.c {
        public b() {
        }

        @Override // e78.c
        public final boolean b() {
            return false;
        }

        @Override // e78.c
        public final void c() {
        }

        @Override // e78.c
        public final void d() {
        }

        @Override // e78.c
        public final boolean e() {
            return false;
        }

        @Override // e78.c
        public final void a() {
            a r0 = a.a;
            a.a(new m());
        }

        @Override // e78.c
        public final String getBizScene() {
            a r0 = a.a;
            b88.d r1 = a.f;
            if (r1 == null) goto L5;
            String r2 = r1.a;
        L6:
            if (r2 != null) goto L9;
            return "";
        L9:
            return r2;
        L5:
            r2 = null;
            goto L6
        }

        @Override // e78.c
        public final String getScene() {
            b88.d r0 = a.f;
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.a;
        L7:
            if (Intrinsics.areEqual(r2, GlobalAudioSceneEnum.PODCAST) == false) goto L15;
            com.larus.audioplayer.impl.news.b r3 = a.g;
            if (r3 == null) goto L14;
            if (r3.n.a != UrlAudioPlayStatus.PAUSED) goto L14;
            r1 = r3.p;
        L14:
            if (Intrinsics.areEqual(r1, "default") == true) goto L15;
            return GlobalAudioSceneEnum.PODCAST;
        L15:
            return GlobalAudioSceneEnum.PLUGIN_AUDIO;
        L5:
            r2 = null;
            goto L7
        }

        @Override // e78.c
        public final GlobalAudioStateEnum getState() {
            int r0 = a.i;
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
            b88.d r0 = a.f;
            if (r0 == null) goto L7;
            String r1 = r0.c;
            if (r1 == null) goto L7;
            boolean r2 = a.a.d(r1, Integer.valueOf(SOURCE_TYPE.URL.getValue()), "");
        L8:
            FLogger.a.i("NewsUrlAudioManager", "GlobalAudioParticipant pause triggered, result: " + r2 + ", audioUrl: " + r1 + '}');
            return r2;
        L7:
            r2 = false;
            r1 = null;
            goto L8
        }

        @Override // e78.c
        public final boolean play() {
            a r0 = a.a;
            b88.d r1 = a.f;
            String r2 = null;
            if (r1 == null) goto L5;
            r0.e(r1, null);
            boolean r3 = true;
        L6:
            FLogger r4 = FLogger.a;
            StringBuilder r5 = new StringBuilder("GlobalAudioParticipant play triggered, result: ");
            r5.append(r3);
            r5.append(", audioUrl: ");
            if (r1 == null) goto L9;
            r2 = r1.c;
        L9:
            r5.append(r2);
            r5.append('}');
            r4.i("NewsUrlAudioManager", r5.toString());
            return r3;
        L5:
            r3 = false;
            r1 = null;
            goto L6
        }

        @Override // e78.c
        public final boolean stop() {
            a r0 = a.a;
            b88.d r1 = a.f;
            if (r1 == null) goto L7;
            String r2 = r1.c;
            if (r2 == null) goto L7;
            boolean r3 = r0.i(r2, Integer.valueOf(SOURCE_TYPE.URL.getValue()), "");
        L8:
            FLogger.a.i("NewsUrlAudioManager", "GlobalAudioParticipant stop triggered, result: " + r3 + ", audioUrl: " + r2 + '}');
            return r3;
        L7:
            r3 = false;
            r2 = null;
            goto L8
        }
    }

    public static final class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            Intrinsics.checkNotNullParameter(r2, "className");
            Intrinsics.checkNotNullParameter(r3, "service");
            a r4 = a.a;
            NewsPlayService r0 = null;
            if ((r3 instanceof NewsPlayService.d) == false) goto L5;
            NewsPlayService.d r5 = (NewsPlayService.d) r3;
        L6:
            if (r5 == null) goto L14;
            NewsPlayService r6 = r5.a;
            if (r6 == null) goto L14;
            Iterator r7 = new CopyOnWriteArrayList(a.c).iterator();
        L11:
            if (r7.hasNext() == false) goto L13;
            ((Function1) r7.next()).invoke(r6);
            goto L11
        L13:
            r0 = r6;
        L14:
            a.e = r0;
            a.k = false;
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class d implements l4 {
        public final /* synthetic */ b88.d a;
        public final /* synthetic */ b88.a b;

        public d(b88.d r1, b88.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(String r2, com.larus.video.impl.sdk.a r3) {
            if (r3 != null) goto L5;
            FLogger.a.e("NewsUrlAudioManager", "getVideoModel fail");
            return;
        L5:
            a r4 = a.a;
            a.f(this.a, r3, this.b);
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
            a r1 = a.a;
            a.a(new f88.n());
            FLogger.a.i("NewsUrlAudioManager", "seekTo result " + r4 + " with audioUrl: " + this.b);
        }

        public e(l0 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new C0089a();
        c = new ArrayList();
        d = new b();
        i = 1;
        j = new n();
        m = new Object();
    }

    public static void a(Function1 r1) {
        Object r0 = m;
        monitor-enter(r0);
        b(r1);     // Catch: Throwable -> L7
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b(Function1 r5) {
        f88.a r0 = e;
        if (r0 != null) goto L5;
    L12:
        c.add(r5);
        if (k == false) goto L15;
        return;
    L15:
        k = true;
        c r1 = new c();
        AppHost.Companion r2 = AppHost.a;
        r2.getApplication().bindService(new Intent(r2.getApplication(), NewsPlayService.class), r1, 1);
        l = r1;
        return;
    L5:
        if (r0.a() == true) goto L8;
        r5.invoke(r0);
        return;
    L8:
        c r3 = l;
        if (r3 == null) goto L11;
        AppHost.a.getApplication().unbindService(r3);
        l = null;
    L11:
        e = null;
        goto L12
    }

    public static /* synthetic */ void h(String r3, int r4) {
        g(r3, Integer.valueOf(SOURCE_TYPE.URL.getValue()), "", r4, null);
    }

    public final synchronized void e(b88.d r4, b88.a r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "urlData");     // Catch: Throwable -> L11
        if (r4.b != SOURCE_TYPE.VIDEO_MODEL.getValue()) goto L8;
        Lazy r0 = q3.a;     // Catch: Throwable -> L11
        z3 r1 = q3.a();     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        r1.f(r4.d, new d(r4, r5));     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L8:
        f(r4, null, r5);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean c(String r3, Integer r4, String r5) {
        int r0 = SOURCE_TYPE.URL.getValue();
        String r1 = null;
        if (r4 != null) goto L6;
    L7:
        int r2 = SOURCE_TYPE.LOCAL_FILE.getValue();
        if (r4 != null) goto L11;
    L13:
        int r6 = SOURCE_TYPE.VIDEO_MODEL.getValue();
        if (r4 != null) goto L17;
    L22:
        return true;
    L17:
        if (r4.intValue() != r6) goto L22;
        b88.d r7 = f;
        if (r7 == null) goto L28;
        r1 = r7.d;
    L28:
        return Intrinsics.areEqual(r5, r1);
    L11:
        if (r4.intValue() != r2) goto L13;
    L23:
        b88.d r8 = f;
        if (r8 == null) goto L27;
        r1 = r8.c;
    L27:
        return Intrinsics.areEqual(r3, r1);
    L6:
        if (r4.intValue() == r0) goto L23;
        goto L7
    }

    public static void f(final b88.d r25, com.larus.video.impl.sdk.a r26, b88.a r27) {
        com.larus.audioplayer.impl.news.b r1 = g;
        b88.d r2 = f;
        boolean r4 = true;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L22;
        int r5 = r25.b;
        if (r5 != SOURCE_TYPE.URL.getValue()) goto L13;
    L23:
        b88.d r6 = f;
        if (r6 == null) goto L26;
        String r7 = r6.c;
    L27:
        boolean r8 = Intrinsics.areEqual(r7, r25.c);
    L29:
        if (r8 == false) goto L34;
        FLogger.a.i("NewsUrlAudioManager", "playAudio with old audioUrl: " + r25);
        if (r1 == null) goto L59;
        int r0 = com.larus.audioplayer.impl.news.b.B;
        r1.c("default");
        return;
    L59:
        return;
    L34:
        JSONObject r15 = new JSONObject();
        r15.put("scene", r25.a);
        String r9 = r25.c;
        int r10 = r25.b;
        String r12 = r25.d;
        if (Intrinsics.areEqual(r25.a, "news") == false) goto L37;
        String r11 = "NEWS";
    L38:
        String r17 = r11;
        String r13 = r25.e;
        String r14 = r25.f;
        String r16 = r25.c;
        String r19 = r25.i;
        if (r19 != null) goto L41;
        String r21 = "";
    L42:
        String r20 = r25.j;
        if (r20 != null) goto L45;
        String r22 = "";
    L46:
        final com.larus.audioplayer.impl.news.b r23 = new com.larus.audioplayer.impl.news.b(r9, r10, r26, r12, r27, new k4(r17, r13, r14, r16, r21, r22), r15, d, r25.l, null, null, false, false, false, null, 32256);
        C0089a r24 = b;
        Intrinsics.checkNotNullParameter(r24, "callback");
        r23.z = r24;
        n r29 = j;
        int r30 = com.larus.audioplayer.impl.utils.b.a;
        String r31 = r25.a;
        Intrinsics.checkNotNullParameter(r31, "scene");
        r29.a = xg9.b.a().getFloat("play_audio_speed-" + r31, 1.0f);
        if (r1 != null) goto L49;
    L51:
        r4 = false;
    L52:
        if (r4 == false) goto L54;
        h = r25;
        r1.d(new f(r25, r23));
        return;
    L54:
        h = null;
        f = r25;
        g = r23;
        Intrinsics.checkNotNullParameter(r29, "params");
        r23.m.H(r29);
        if (r1 == null) goto L57;
        r1.m.release();
    L57:
        FLogger.a.i("NewsUrlAudioManager", "playAudio directly with new audioUrl: " + r25);
        r23.c("default");
        return;
    L49:
        if (r1.o != true) goto L51;
    L45:
        r22 = r20;
        goto L46
    L41:
        r21 = r19;
        goto L42
    L37:
        r11 = r25.a;
        goto L38
    L26:
        r7 = null;
        goto L27
    L13:
        if (r5 == SOURCE_TYPE.LOCAL_FILE.getValue()) goto L23;
        if (r5 != SOURCE_TYPE.VIDEO_MODEL.getValue()) goto L22;
        b88.d r32 = f;
        if (r32 == null) goto L20;
        String r33 = r32.d;
    L21:
        r8 = Intrinsics.areEqual(r33, r25.d);
        goto L29
    L20:
        r33 = null;
    L22:
        r8 = false;
        goto L29
    L5:
        if (r2.b != r25.b) goto L7;
        r3 = true;
        goto L8
    }

    public final synchronized boolean d(String r4, Integer r5, String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "targetUrl");     // Catch: Throwable -> L15
        if (c(r4, r5, r6) == true) goto L9;
        FLogger.a.i("NewsUrlAudioManager", "pauseAudio fails with wrong audioUrl: " + r4);     // Catch: Throwable -> L15
        monitor-exit(this);
        return false;
    L9:
        FLogger.a.i("NewsUrlAudioManager", "pauseAudio succeeds with audioUrl: " + r4);     // Catch: Throwable -> L15
        com.larus.audioplayer.impl.news.b r7 = g;     // Catch: Throwable -> L15
        if (r7 == null) goto L12;
        int r8 = com.larus.audioplayer.impl.news.b.B;     // Catch: Throwable -> L15
        r7.b(false, "default");     // Catch: Throwable -> L15
    L12:
        monitor-exit(this);
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean i(String r4, Integer r5, String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "targetUrl");     // Catch: Throwable -> L16
        if (c(r4, r5, r6) == true) goto L10;
        FLogger.a.i("NewsUrlAudioManager", "stopAudio fails with wrong audioUrl: " + r4);     // Catch: Throwable -> L16
        monitor-exit(this);
        return false;
    L10:
        FLogger.a.i("NewsUrlAudioManager", "stopAudio succeeds with audioUrl: " + r4);     // Catch: Throwable -> L16
        com.larus.audioplayer.impl.news.b r7 = g;     // Catch: Throwable -> L16
        if (r7 == null) goto L13;
        int r8 = com.larus.audioplayer.impl.news.b.B;     // Catch: Throwable -> L16
        r7.d(null);     // Catch: Throwable -> L16
    L13:
        monitor-exit(this);
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    public static boolean g(String r1, Integer r2, String r3, int r4, l0 r5) {
        Intrinsics.checkNotNullParameter(r1, "targetUrl");
        if (c(r1, r2, r3) == true) goto L6;
        FLogger.a.i("NewsUrlAudioManager", "seekTo fails with wrong audioUrl: " + r1);
        return false;
    L6:
        com.larus.audioplayer.impl.news.b r6 = g;
        if (r6 == null) goto L11;
        r6.m.A(r4, new e(r5, r1));
        return true;
    L11:
        return true;
    }
}
