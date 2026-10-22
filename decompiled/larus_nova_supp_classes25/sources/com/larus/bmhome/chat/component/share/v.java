package com.larus.bmhome.chat.component.share;

import com.larus.platform.service.i2;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v implements Function2 {
    public final /* synthetic */ ChatShareBottomComponent a;

    public /* synthetic */ v(ChatShareBottomComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        ChatShareBottomComponent r0 = this.a;
        List r5 = (List) r3;
        Function1 r6 = (Function1) r4;
        int r1 = ChatShareBottomComponent.R;
        Intrinsics.checkNotNullParameter(r5, "manifest");
        Intrinsics.checkNotNullParameter(r6, "requestCallBack");
        i2 r2 = i2.b;
        i2.q(s1a.a.c(r0), r5, r6);
        return Unit.INSTANCE;
    }
}
