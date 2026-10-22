package com.obric.assistant.component.clicktalk;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c0 implements Runnable {
    public final /* synthetic */ ChatClickTalkComponent a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ Integer d;
    public final /* synthetic */ String e;
    public final /* synthetic */ ChatClickTalkComponent$a f;

    public /* synthetic */ c0(ChatClickTalkComponent r1, int r2, Map r3, Integer r4, String r5, ChatClickTalkComponent$a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatClickTalkComponent r0 = this.a;
        int r1 = this.b;
        Map r2 = this.c;
        Integer r3 = this.d;
        String r4 = this.e;
        ChatClickTalkComponent$a r5 = this.f;
        int r6 = ChatClickTalkComponent.L0;
        r0.k4(r1, r2, r3, r4, r5);
    }
}
