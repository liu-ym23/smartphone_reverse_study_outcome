package com.larus.bmhome.chat.component.bottom.reference;

import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ReferenceMsgComponent a;

    public d0(ReferenceMsgComponent r1) {
        this.a = r1;
    }

    public final void c(Object r5) {
        wc9.e r6 = (wc9.e) r5;
        Intrinsics.checkNotNullParameter(r6, "new");
        FLogger.a.d("ReferenceMsgComponent", "observeConversationChanged, onChange, new=" + r6);
        ReferenceMsgComponent r0 = this.a;
        String r7 = r6.a;
        if (o0.d(r0.K) == false) goto L8;
        NativeMessageServiceImpl r1 = com.larus.im.d.e();
        String r2 = r0.K;
        if (r2 != null) goto L7;
        r2 = r7;
    L7:
        r1.unregisterOnMessageChangedObserver(r2, r0.L);
    L8:
        com.larus.im.d.e().registerOnMessageChangedObserver(r7, r0.L);
        r0.K = r7;
    }
}
