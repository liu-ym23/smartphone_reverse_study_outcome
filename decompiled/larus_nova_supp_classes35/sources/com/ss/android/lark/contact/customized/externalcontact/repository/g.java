package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements Runnable {
    public final /* synthetic */ GetChatApplicationBadgeResponse a;

    public g(GetChatApplicationBadgeResponse r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r0 = ((List) OfficeExternalContactRepository.a.getValue()).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        ((a) r0.next()).a(this.a.friend_badge.intValue(), this.a.latest_apply_username);     // Catch: Throwable -> L7
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
