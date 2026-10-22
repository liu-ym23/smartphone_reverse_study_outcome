package com.obric.audio.continuous_talk;

import by7.e;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface b extends m1a.a {
    void B6(String r1);

    boolean I0(JSONObject r1);

    boolean a0();

    String hr(String r1, String r2, Integer r3, Integer r4, String r5, String r6, SpeakerVoice r7, de8.c r8, e r9, String r10, String r11, String r12, boolean r13, RealtimeCallParam.l r14);

    boolean m0();

    void stop(boolean r1);

    ContinuousTalkStatus u10();

    void updateIntentExt(Map<String, String> r1);

    void updateScreenshotForAsr(String r1);
}
