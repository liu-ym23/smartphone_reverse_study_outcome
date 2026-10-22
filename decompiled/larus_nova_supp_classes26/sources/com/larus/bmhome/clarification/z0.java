package com.larus.bmhome.clarification;

import com.larus.im.bean.message.block.InteractionAskQuestion;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class z0 implements Function1 {
    public final /* synthetic */ InteractionAskQuestion a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ String d;

    public /* synthetic */ z0(InteractionAskQuestion r1, String r2, Ref.BooleanRef r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r22) {
        InteractionAskQuestion r1 = this.a;
        String r10 = this.b;
        Ref.BooleanRef r2 = this.c;
        String r11 = this.d;
        z1 r12 = (z1) r22;
        int r3 = ClarificationComponent.k0;
        Intrinsics.checkNotNullParameter(r12, "pageState");
        boolean r4 = false;
        if (r1 == null) goto L7;
        Integer r5 = r1.getType();
        if (r5 == null) goto L7;
        int r6 = r5.intValue();
    L9:
        if (r6 == 1) goto L11;
    L15:
        if (r4 == false) goto L17;
        List<String> r7 = CollectionsKt.emptyList();
    L18:
        if (r4 == false) goto L21;
        r2.element = true;
    L21:
        return z1.a(r12, r10, r11, r10.length(), r10.length(), false, false, 0, null, i.a(r12.l, r7, r10, null, null, System.currentTimeMillis(), 12), null, 6083);
    L17:
        r7 = r12.l.a;
        goto L18
    L11:
        if ((!StringsKt.isBlank(r10)) == false) goto L15;
        if ((!r12.l.a.isEmpty()) == false) goto L15;
        r4 = true;
    L7:
        r6 = 0;
        goto L9
    }
}
