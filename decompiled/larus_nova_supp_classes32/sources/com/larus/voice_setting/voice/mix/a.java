package com.larus.voice_setting.voice.mix;

import android.widget.ImageView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.mix.a$a, reason: collision with other inner class name */
    public static final class C0011a {
        public static void a(a r3, int r4) {
            if (r4 != 1) goto L5;
            ImageView r5 = r3.getPlayIcon();
            if (r5 == null) goto L36;
            r5.setVisibility(8);
        L36:
            LottieAdapterView r6 = r3.getPlayLottieView();
            if (r6 == null) goto L39;
            r6.setVisibility(0);
        L39:
            LottieAdapterView r7 = r3.getPlayLottieView();
            if (r7 == null) goto L42;
            r7.cancelAnimation();
        L42:
            LottieAdapterView r8 = r3.getPlayLottieView();
            if (r8 == null) goto L45;
            r8.setAnimation("lottie/text_msg_voice_playing.json");
        L45:
            LottieAdapterView r9 = r3.getPlayLottieView();
            if (r9 == null) goto L53;
            r9.playAnimation();
            return;
        L53:
            return;
        L5:
            if (r4 != 2) goto L7;
            ImageView r10 = r3.getPlayIcon();
            if (r10 == null) goto L21;
            r10.setVisibility(8);
        L21:
            LottieAdapterView r11 = r3.getPlayLottieView();
            if (r11 == null) goto L24;
            r11.setVisibility(0);
        L24:
            LottieAdapterView r12 = r3.getPlayLottieView();
            if (r12 == null) goto L27;
            r12.cancelAnimation();
        L27:
            LottieAdapterView r13 = r3.getPlayLottieView();
            if (r13 == null) goto L30;
            r13.setAnimation("lottie/text_msg_voice_loading.json");
        L30:
            LottieAdapterView r14 = r3.getPlayLottieView();
            if (r14 == null) goto L51;
            r14.playAnimation();
            return;
        L51:
            return;
        L7:
            if (r4 != 3) goto L54;
            ImageView r15 = r3.getPlayIcon();
            if (r15 == null) goto L12;
            r15.setVisibility(0);
        L12:
            LottieAdapterView r16 = r3.getPlayLottieView();
            if (r16 == null) goto L15;
            r16.setVisibility(8);
        L15:
            LottieAdapterView r17 = r3.getPlayLottieView();
            if (r17 == null) goto L49;
            r17.cancelAnimation();
            return;
        L49:
            return;
        }
    }

    ImageView getPlayIcon();

    LottieAdapterView getPlayLottieView();
}
