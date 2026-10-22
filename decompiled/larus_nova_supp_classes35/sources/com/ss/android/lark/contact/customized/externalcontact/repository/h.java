package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements Runnable {
    public final /* synthetic */ ContactProfile a;

    public h(ContactProfile r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((List) OfficeExternalContactRepository.b.getValue()).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        b r1 = (b) r0.next();     // Catch: Throwable -> L7
        int r2 = mtb.d.l;     // Catch: Throwable -> L7
        r1.a(mtb.d.a.a(this.a));     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
