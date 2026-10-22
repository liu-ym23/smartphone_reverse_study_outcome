package com.larus.asr;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class h1 implements Function0 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Message c;

    public /* synthetic */ h1(ChatBottomSpeakerComponent r1, String r2, Message r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        ChatBottomSpeakerComponent r0 = this.a;
        String r1 = this.b;
        Message r2 = this.c;
        Function0 r3 = r0.y;
        if (r3 == null) goto L5;
        r3.invoke();
    L5:
        FLogger.a.i("ChatBottomSpeakerComponent", "setChatSpeakerCancelListener onCancel");
        com.larus.asr.session.o r4 = r0.s;
        if (r4 == null) goto L9;
        r4.qa(r1, r2);
    L9:
        return Unit.INSTANCE;
    }
}
