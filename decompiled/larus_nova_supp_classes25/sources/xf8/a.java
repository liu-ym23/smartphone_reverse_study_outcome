package xf8;

import com.larus.bmhome.chat.layout.item.LynxBox;
import com.larus.bmhome.chat.list.cell.lynx.LynxCell;
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
    public final /* synthetic */ LynxCell b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(String r1, LynxCell r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r7) {
        final String r0 = this.a;
        final LynxCell r1 = this.b;
        String r2 = this.c;
        String r8 = (String) r7;
        int r3 = LynxCell.l;
        Intrinsics.checkNotNullParameter(r8, "lynxRenderData");
        FLogger.a.i("LynxCell", "readPluginViewCacheData lynxRenderData:" + r8);
        if (o0.d(r8) == false) goto L13;
        i r4 = r1.f;
        if (r4 == null) goto L9;
        Message r5 = r4.e;
        if (r5 == null) goto L9;
        String r6 = r5.getMessageId();
    L11:
        if (Intrinsics.areEqual(r0, r6) == false) goto L13;
        r1.t(r8);
        r1.o(r8);
    L18:
        return Unit.INSTANCE;
    L9:
        r6 = null;
    L13:
        LynxBox r9 = r1.e;
        if (r9 == null) goto L16;
        r9.q(LynxBox.LynxShowState.LOADING);
    L16:
        LynxRenderDataRepo.b(r2, r0, new f(r0, r1));
        goto L18
    }
}
