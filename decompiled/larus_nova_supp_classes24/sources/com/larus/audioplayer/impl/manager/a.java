package com.larus.audioplayer.impl.manager;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.applet.aibridge.timer.SetAudioStopTimerMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final Handler a = null;
    public static final ConcurrentHashMap<String, RunnableC0087a> b = null;

    /* JADX INFO: renamed from: com.larus.audioplayer.impl.manager.a$a, reason: collision with other inner class name */
    public static final class RunnableC0087a implements Runnable {
        public final String a;
        public final z78.a b;
        public Long c;

        public final void a() {
            Handler r0 = a.a;
            a.a(this.a);
            String r1 = this.a;
            int r3 = 1;
            boolean r4 = false;
            switch(r1.hashCode()) {
                case -598194362: goto L36;
                case -405568764: goto L17;
                case 3377875: goto L14;
                case 1678448913: goto L10;
                case 2045333017: goto L6;
                default: goto L39;
            };
        L39:
            boolean r2 = false;
        L41:
            if (r2 == false) goto L45;
            GlobalAudioController r5 = GlobalAudioController.a;
            if (r5.getCurrentState() != GlobalAudioStateEnum.PLAYING) goto L45;
            FLogger.a.i("AudioStopTimerManager", "timer stop " + this.a);
            r5.stop("default");
            r3 = 0;
            r4 = true;
        L45:
            z78.a r6 = this.b;
            if (r6 == null) goto L48;
            r6.a(this.a, r3);
        L48:
            FLogger.a.i("AudioStopTimerManager", "timer triggered, scene: " + this.a + ", result: " + r4);
            return;
        L6:
            if (r1.equals(GlobalAudioSceneEnum.PLUGIN_MUSIC) == false) goto L39;
            r2 = Intrinsics.areEqual(GlobalAudioController.a.getCurrentScene(), GlobalAudioSceneEnum.PLUGIN_MUSIC);
            goto L41
        L10:
            if (r1.equals(GlobalAudioSceneEnum.PLUGIN_BACKGROUND_AUDIO) == false) goto L39;
            r2 = Intrinsics.areEqual(GlobalAudioController.a.getCurrentScene(), GlobalAudioSceneEnum.PLUGIN_BACKGROUND_AUDIO);
            goto L41
        L14:
            if (r1.equals("news") == false) goto L39;
        L19:
            GlobalAudioController r7 = GlobalAudioController.a;
            String r8 = null;
            if (Intrinsics.areEqual(r7.getCurrentScene(), GlobalAudioSceneEnum.PLUGIN_AUDIO) == false) goto L28;
            com.larus.audioplayer.impl.news.a r9 = com.larus.audioplayer.impl.news.a.a;
            com.larus.audioplayer.impl.news.b r10 = com.larus.audioplayer.impl.news.a.g;
            if (r10 == null) goto L24;
            String r11 = r10.a();
        L26:
            if (Intrinsics.areEqual(r11, this.a) == false) goto L28;
        L34:
            r2 = true;
            goto L41
        L24:
            r11 = null;
        L28:
            if (Intrinsics.areEqual(r7.getCurrentScene(), GlobalAudioSceneEnum.PODCAST) == false) goto L39;
            com.larus.audioplayer.impl.news.a r12 = com.larus.audioplayer.impl.news.a.a;
            com.larus.audioplayer.impl.news.b r13 = com.larus.audioplayer.impl.news.a.g;
            if (r13 == null) goto L33;
            r8 = r13.a();
        L33:
            if (Intrinsics.areEqual(r8, GlobalAudioSceneEnum.PODCAST) == false) goto L39;
        L17:
            if (r1.equals(GlobalAudioSceneEnum.PODCAST) == true) goto L19;
        L36:
            if (r1.equals(GlobalAudioSceneEnum.QQ_MUSIC) == false) goto L39;
            r2 = Intrinsics.areEqual(GlobalAudioController.a.getCurrentScene(), GlobalAudioSceneEnum.QQ_MUSIC);
            goto L41
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0087a(String r2, SetAudioStopTimerMethod.a r3) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new Handler(Looper.getMainLooper());
        b = new ConcurrentHashMap();
    }

    public static boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        ConcurrentHashMap<String, RunnableC0087a> r0 = b;
        RunnableC0087a r1 = r0.get(r3);
        if (r1 == null) goto L6;
        a.removeCallbacks(r1);
        r0.remove(r3);
        return true;
    L6:
        return false;
    }
}
