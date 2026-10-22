package com.obric.assistant.component.clicktalk;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e0 implements Function1 {
    public final /* synthetic */ ChatClickTalkComponent a;
    public final /* synthetic */ ChatClickTalkComponent$a b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ String d;

    public /* synthetic */ e0(ChatClickTalkComponent r1, ChatClickTalkComponent$a r2, d0 r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r8) {
        ChatClickTalkComponent r0 = this.a;
        ChatClickTalkComponent$a r1 = this.b;
        Function0 r2 = this.c;
        String r3 = this.d;
        boolean r9 = ((Boolean) r8).booleanValue();
        int r4 = ChatClickTalkComponent.L0;
        FLogger.a.i("ChatClickTalkComponent", "request permission RECORD_AUDIO result: " + r9);
        if (r0.p3(r1) == true) goto L13;
        if (r9 == false) goto L8;
        r2.invoke();
    L12:
        return Unit.INSTANCE;
    L8:
        if (r0.p3(r1) == true) goto L12;
        r0.h4(r1);
        r0.j4(false, "record_audio_denied");
        r0.C3("blocked", "record_audio_denied", r3);
        goto L12
    L13:
        return Unit.INSTANCE;
    }
}
