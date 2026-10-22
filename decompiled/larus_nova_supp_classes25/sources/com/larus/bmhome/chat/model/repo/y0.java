package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y0 implements Function0 {
    public final /* synthetic */ ChatSender a;
    public final /* synthetic */ List b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ IIMCallback f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ Long h;
    public final /* synthetic */ wc9.e i;
    public final /* synthetic */ String j;

    public /* synthetic */ y0(ChatSender r1, List r2, String r3, String r4, boolean r5, IIMCallback r6, boolean r7, Long r8, wc9.e r9, String r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public final Object invoke() {
        ChatSender r3 = this.a;
        List r2 = this.b;
        String r4 = this.c;
        String r5 = this.d;
        boolean r6 = this.e;
        IIMCallback r7 = this.f;
        boolean r8 = this.g;
        Long r9 = this.h;
        wc9.e r10 = this.i;
        String r11 = this.j;
        BuildersKt.launch$default(r3.b, null, null, new ChatSender$sendFileAndText$sendAction$1$1(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, null), 3, null);
        return Unit.INSTANCE;
    }
}
