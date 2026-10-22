package com.larus.bmhome.chat.model.repo;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g1 implements Function0 {
    public final /* synthetic */ ChatSender a;
    public final /* synthetic */ ic8.w b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Function2 d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ g1(ChatSender r1, ic8.w r2, String r3, Function2 r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke() {
        ChatSender r3 = this.a;
        ic8.w r1 = this.b;
        String r2 = this.c;
        Function2 r4 = this.d;
        boolean r5 = this.e;
        BuildersKt.launch$default(r3.b, null, null, new ChatSender$sendAudioTextNew$sendAction$1$1(r1, r2, r3, r4, r5, null), 3, null);
        return Unit.INSTANCE;
    }
}
