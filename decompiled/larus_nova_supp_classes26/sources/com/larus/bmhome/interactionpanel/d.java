package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallbackExt;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements IIMCallbackExt<List<? extends Message>> {
    public final /* synthetic */ m a;
    public final /* synthetic */ String b;
    public final /* synthetic */ a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ClarificationPanelAdapter", "load clarification message failed on update, key=" + this.a.a + ", messageId=" + this.b, r4.getException());
        this.c.b.e(this.a.a, "clarification_message_load_failed");
    }

    public final /* bridge */ /* synthetic */ void onLocalFinish(Object r1) {
        List r2 = (List) r1;
    }

    public final void onSuccess(Object r5) {
        List r6 = (List) r5;
        Intrinsics.checkNotNullParameter(r6, "result");
        String r0 = this.b;
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r1 = r7.next();
        if (Intrinsics.areEqual(((Message) r1).getMessageId(), r0) == false) goto L4;
    L9:
        Message r2 = (Message) r1;
        if (r2 != null) goto L12;
        FLogger.a.w("ClarificationPanelAdapter", "skip clarification update, message missed, key=" + this.a.a + ", messageId=" + this.b);
        this.c.b.e(this.a.a, "clarification_message_missed");
        return;
    L12:
        this.c.b(this.a, this.d, r2, this.e);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public d(m r1, String r2, a r3, String r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
