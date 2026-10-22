package com.larus.asr.view;

import com.larus.utils.logger.FLogger;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ ChatSpeaker a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ b(ChatSpeaker r1, float r2, float r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        ChatSpeaker r0 = this.a;
        float r1 = this.b;
        float r2 = this.c;
        boolean r3 = this.d;
        int r4 = ChatSpeaker.T;
        FLogger.a.i("ChatSpeaker", "[showAudioInvisibleAnim] onStart");
        r0.H6(TuplesKt.to(Float.valueOf(r1), Float.valueOf(r2)), r3);
        return Unit.INSTANCE;
    }
}
