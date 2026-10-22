package com.larus.bmhome.chat.model.repo;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a1 implements Function0 {
    public final /* synthetic */ ChatSender a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ List d;
    public final /* synthetic */ wc9.e e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ a1(ChatSender r1, String r2, String r3, List r4, wc9.e r5, String r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke() {
        ChatSender r4 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        List r3 = this.d;
        wc9.e r5 = this.e;
        String r6 = this.f;
        boolean r7 = this.g;
        BuildersKt.launch$default(r4.b, null, null, new ChatSender$sendMediaMessage$sendAction$1$1(r1, r2, r3, r4, r5, r6, r7, null), 3, null);
        return Unit.INSTANCE;
    }
}
