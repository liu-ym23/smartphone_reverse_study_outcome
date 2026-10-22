package com.larus.voice_setting.voice;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class v0 implements Function0 {
    public final /* synthetic */ SingleTtsSpeakerSettingFragment a;

    public /* synthetic */ v0(SingleTtsSpeakerSettingFragment r1) {
        this.a = r1;
    }

    public final Object invoke() {
        SingleTtsSpeakerSettingFragment r0 = this.a;
        int r1 = SingleTtsSpeakerSettingFragment.y;
        p2a.q.a().stopAudio();
        SingleTtsSpeakerSettingFragment.Z90(r0, false, null, null, 15);
        com.larus.voice_setting.voice.base.g1 r2 = com.larus.voice_setting.voice.base.g1.a;
        String r3 = r0.o;
        com.larus.voice_setting.voice.base.g1.c(r3, r0, r3, new JSONObject(), null);
        return Unit.INSTANCE;
    }
}
