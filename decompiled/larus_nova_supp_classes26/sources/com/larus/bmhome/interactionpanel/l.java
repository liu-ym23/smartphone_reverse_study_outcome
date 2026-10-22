package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.callback.IIMCallbackExt;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements IIMCallbackExt<List<? extends Message>> {
    public final /* synthetic */ m a;
    public final /* synthetic */ String b;
    public final /* synthetic */ k c;
    public final /* synthetic */ String d;
    public final /* synthetic */ List<Block> e;
    public final /* synthetic */ int f;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("InputAreaBlockPanelAdapter", "load cmd message failed, key=" + this.a.a + ", messageId=" + this.b, r4.getException());
        this.c.b.e(this.a.a, "cmd_message_load_failed");
    }

    public final /* bridge */ /* synthetic */ void onLocalFinish(Object r1) {
        List r2 = (List) r1;
    }

    public final void onSuccess(Object r9) {
        List r10 = (List) r9;
        Intrinsics.checkNotNullParameter(r10, "result");
        String r0 = this.b;
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r1 = r11.next();
        if (Intrinsics.areEqual(((Message) r1).getMessageId(), r0) == false) goto L4;
    L9:
        Message r5 = (Message) r1;
        if (r5 != null) goto L12;
        FLogger.a.w("InputAreaBlockPanelAdapter", "skip cmd show, message missed, key=" + this.a.a + ", messageId=" + this.b);
        this.c.b.e(this.a.a, "cmd_message_missed");
        return;
    L12:
        this.c.b(this.a, this.d, r5, this.e, this.f);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public l(m r1, String r2, k r3, String r4, List<Block> r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
