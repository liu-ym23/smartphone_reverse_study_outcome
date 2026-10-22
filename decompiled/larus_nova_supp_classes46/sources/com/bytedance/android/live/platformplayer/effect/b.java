package com.bytedance.android.live.platformplayer.effect;

import android.os.Build;
import com.bytedance.android.livesdkapi.roomplayer.PlayerEffectLogLevel;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectCallback;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectMessageListener;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectResourceFinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ VideoEffectInitConfigBuilder a(b r9, String r10, boolean r11, String r12, String r13, PlayerEffectLogLevel r14, VideoEffectMessageListener r15, VideoEffectCallback r16, VrEffectDownloader.d r17, int r18) {
            if ((r18 & 1) == 0) goto L5;
            String r1 = "live";
        L7:
            if ((r18 & 2) == 0) goto L9;
            boolean r2 = true;
        L11:
            if ((r18 & 4) == 0) goto L13;
            String r3 = Build.MODEL;
        L15:
            if ((r18 & 8) == 0) goto L17;
            String r4 = "live_player_sdk";
        L19:
            if ((r18 & 16) == 0) goto L21;
            PlayerEffectLogLevel r5 = PlayerEffectLogLevel.LevelDebug;
        L22:
            VrEffectDownloader.d r7 = null;
            if ((r18 & 32) == 0) goto L25;
            VideoEffectMessageListener r6 = null;
        L27:
            if ((r18 & 64) == 0) goto L29;
            VideoEffectCallback r8 = null;
        L31:
            if ((r18 & 128) != 0) goto L35;
            r7 = r17;
        L35:
            return r9.a(r1, r2, r3, r4, r5, r6, r8, r7);
        L29:
            r8 = r16;
            goto L31
        L25:
            r6 = r15;
            goto L27
        L21:
            r5 = r14;
            goto L22
        L17:
            r4 = r13;
            goto L19
        L13:
            r3 = r12;
            goto L15
        L9:
            r2 = r11;
            goto L11
        L5:
            r1 = r10;
            goto L7
        }
    }

    VideoEffectInitConfigBuilder a(String r1, boolean r2, String r3, String r4, PlayerEffectLogLevel r5, VideoEffectMessageListener r6, VideoEffectCallback r7, VideoEffectResourceFinder r8);

    void prepare();

    void release();
}
