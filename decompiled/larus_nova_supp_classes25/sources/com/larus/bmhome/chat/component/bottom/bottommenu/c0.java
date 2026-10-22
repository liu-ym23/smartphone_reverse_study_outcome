package com.larus.bmhome.chat.component.bottom.bottommenu;

import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c0 implements Function2 {
    public final /* synthetic */ BottomMenuComponent a;

    public /* synthetic */ c0(BottomMenuComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        final BottomMenuComponent r0 = this.a;
        final String r5 = (String) r3;
        final MultimodalBizScene r6 = (MultimodalBizScene) r4;
        int r1 = BottomMenuComponent.x1;
        Intrinsics.checkNotNullParameter(r5, "clickFrom");
        Intrinsics.checkNotNullParameter(r6, "bizScene");
        com.obric.assistant.spi.keyguard.a.b(false, new m0(r0, r5, r6), 3);
        return Unit.INSTANCE;
    }
}
