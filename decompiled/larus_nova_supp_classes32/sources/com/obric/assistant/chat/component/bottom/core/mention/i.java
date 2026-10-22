package com.obric.assistant.chat.component.bottom.core.mention;

import com.obric.assistant.util.ObricMentionHighlightHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ ObricMentionInputController a;

    public /* synthetic */ i(ObricMentionInputController r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricMentionInputController r0 = this.a;
        r0.d();
        paa.c r1 = r0.c;
        if (r1 == null) goto L12;
        List<paa.e> r2 = r1.Nh();
        if (r2 == null) goto L18;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        paa.e r4 = (paa.e) r3.next();
        r0.b();
        ObricMentionHighlightHelper.a r5 = r0.h;
        if (r5 == null) goto L8;
        r5.l(r4);
        goto L8
    L19:
        return;
    L18:
        return;
    }
}
