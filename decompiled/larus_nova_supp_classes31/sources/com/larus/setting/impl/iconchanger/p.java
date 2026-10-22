package com.larus.setting.impl.iconchanger;

import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p implements p68.e {
    public final /* synthetic */ ChangeAppIconFragment a;
    public final /* synthetic */ b b;

    public final void onBegin() {
        GlobalAudioObserver r0 = GlobalAudioObserver.a;
        Map<String, SpeakerVoice> r1 = this.b.f;
        if (r1 == null) goto L7;
        SpeakerVoice r2 = r1.get(this.a.u);
        if (r2 == null) goto L7;
        String r3 = r2.getStyleId();
    L8:
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r0.e("trail_listening", r3, ChangeAppIconFragment.U90(this.a));
        r0.c("trail_listening", GlobalAudioStateEnum.PLAYING, ChangeAppIconFragment.U90(this.a));
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void onEnd() {
        GlobalAudioObserver.a.c("trail_listening", GlobalAudioStateEnum.STOPPED, ChangeAppIconFragment.U90(this.a));
    }

    public final void onError() {
        GlobalAudioObserver.a.f("trail_listening", null, null);
    }

    public p(ChangeAppIconFragment r1, b r2) {
        this.a = r1;
        this.b = r2;
    }
}
