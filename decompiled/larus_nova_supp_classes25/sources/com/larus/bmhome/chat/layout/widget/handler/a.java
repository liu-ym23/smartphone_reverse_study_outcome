package com.larus.bmhome.chat.layout.widget.handler;

import com.larus.bmhome.chat.layout.item.LynxBox;
import com.larus.crossplatform.card.impl.LynxRenderDataRepo;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ c b;
    public final /* synthetic */ LynxBox c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(String r1, c r2, LynxBox r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r8) {
        String r0 = this.a;
        c r1 = this.b;
        LynxBox r2 = this.c;
        String r3 = this.d;
        String r9 = (String) r8;
        Intrinsics.checkNotNullParameter(r9, "lynxRenderData");
        FLogger.a.i("LynxMarkdownWidgetHandler", "readPluginViewCacheData lynxRenderData:" + r9);
        if (o0.d(r9) == false) goto L11;
        Message r4 = r1.a;
        if (r4 == null) goto L7;
        String r5 = r4.getMessageId();
    L9:
        if (Intrinsics.areEqual(r0, r5) == false) goto L11;
        r1.f(r2, r9);
        r1.e(r2, r9);
    L13:
        return Unit.INSTANCE;
    L7:
        r5 = null;
    L11:
        r1.getClass();
        r2.q(LynxBox.LynxShowState.LOADING);
        LynxRenderDataRepo.b(r3, r0, new b(r0, r1, r2));
        goto L13
    }
}
