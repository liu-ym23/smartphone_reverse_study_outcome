package com.larus.bmhome.chat.model.repo;

import com.larus.im.internal.jni.bean.OmniBreakReason;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m1 implements Function1 {
    public final /* synthetic */ ConversationRepo a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ OmniBreakReason f;

    public /* synthetic */ m1(ConversationRepo r1, String r2, int r3, boolean r4, boolean r5, OmniBreakReason r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r9) {
        ConversationRepo r0 = this.a;
        String r1 = this.b;
        int r2 = this.c;
        boolean r4 = this.d;
        boolean r5 = this.e;
        OmniBreakReason r6 = this.f;
        List r3 = (List) r9;
        int r10 = ConversationRepo.f;
        Intrinsics.checkNotNullParameter(r3, "list");
        ConversationRepo.C(r0, r1, r2, r3, r4, r5, r6, 64);
        return Unit.INSTANCE;
    }
}
