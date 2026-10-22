package com.larus.voicecall.impl.ui;

import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 implements z19.k {
    public final /* synthetic */ VoiceCallContentLayout a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ BotModel e;

    public final void b() {
        VoiceCallContentLayout r0 = this.a;
        r0.i = System.currentTimeMillis();
    }

    public final void a(boolean r7) {
        long r0 = System.currentTimeMillis();
        FLogger.a.i("VoiceCallContentLayout", "onFinalImageSet, isFromCache : " + r7 + " , cost time: " + (r0 - this.a.i) + " , url : " + this.b);
    }

    public final void onFailure(Throwable r5) {
        FLogger.a.e("VoiceCallContentLayout", "onFailure， use forceAvatarUrl onFailure show default, url : " + this.b);
        VoiceCallContentLayout r6 = this.a;
        int r0 = this.c;
        String r1 = this.d;
        BotModel r2 = this.e;
        int r3 = VoiceCallContentLayout.l;
        r6.Z5(r0, r1, r2);
    }

    public c0(VoiceCallContentLayout r1, String r2, int r3, String r4, BotModel r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
