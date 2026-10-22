package com.larus.bmhome.chat.layout.widget.handler;

import com.larus.bmhome.chat.layout.item.LynxBox;
import com.larus.crossplatform.card.impl.LynxRenderDataRepo;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function2 {
    public final /* synthetic */ String a;
    public final /* synthetic */ c b;
    public final /* synthetic */ LynxBox c;

    public /* synthetic */ b(String r1, c r2, LynxBox r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r7, Object r8) {
        String r0 = this.a;
        c r1 = this.b;
        LynxBox r2 = this.c;
        boolean r9 = ((Boolean) r7).booleanValue();
        String r10 = (String) r8;
        Message r3 = r1.a;
        if (r3 == null) goto L5;
        String r4 = r3.getMessageId();
    L7:
        if (Intrinsics.areEqual(r0, r4) == false) goto L16;
        FLogger.a.i("LynxMarkdownWidgetHandler", "fetchLynxDataByHttp msgId:" + r0 + " success:" + r9);
        if (r9 == false) goto L13;
        if (r10 == null) goto L13;
        r1.f(r2, r10);
        r1.e(r2, r10);
        r2.q(LynxBox.LynxShowState.SUCCESS);
        CoroutineScope r11 = LynxRenderDataRepo.a;
        LynxRenderDataRepo.d(r0, r10);
    L15:
        return Unit.INSTANCE;
    L13:
        r2.q(LynxBox.LynxShowState.FAIL);
        LynxRenderDataRepo.a(r0);
        goto L15
    L16:
        return Unit.INSTANCE;
    L5:
        r4 = null;
        goto L7
    }
}
