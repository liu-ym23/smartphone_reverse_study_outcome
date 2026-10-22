package com.larus.share.impl.view;

import com.larus.share.service.IShareDoubaoForwardService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j0 implements IShareDoubaoForwardService.a {
    public final /* synthetic */ List<Long> a;
    public final /* synthetic */ List<kw9.a> b;
    public final /* synthetic */ tx9.v0.b c;
    public final /* synthetic */ h0 d;

    @Override // com.larus.share.service.IShareDoubaoForwardService.a
    public final void a(kw9.a r10) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("doubao to lark forward attempt, entry=direct_contact, stage=result, success=true, messageCount=");
        r1.append(this.a.size());
        r1.append(", targetCount=");
        r1.append(this.b.size());
        r1.append(", hasTargetInfo=");
        if (r10 == null) goto L5;
        boolean r3 = true;
    L6:
        r1.append(r3);
        r0.i("SharePanelView", r1.toString());
        ConcurrentHashMap<String, tx9.v0.c> r2 = tx9.v0.a;
        tx9.v0.b r4 = this.c;
        h0 r5 = this.d;
        List<kw9.a> r6 = this.b;
        r5.getClass();
        tx9.v0.j(r4, true, h0.j(r6), null, null, 24);
        h0.q(this.d, true, r10, 2);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.larus.share.service.IShareDoubaoForwardService.a
    public final void onFailure(Integer r5, String r6) {
        FLogger.a.e("SharePanelView", "doubao to lark forward attempt, entry=direct_contact, stage=result, success=false, reason=host_forward_failed, messageCount=" + this.a.size() + ", targetCount=" + this.b.size() + ", errorCode=" + r5 + ", errorMessage=" + r6);
        ConcurrentHashMap<String, tx9.v0.c> r0 = tx9.v0.a;
        tx9.v0.b r1 = this.c;
        h0 r2 = this.d;
        List<kw9.a> r3 = this.b;
        r2.getClass();
        List r4 = h0.j(r3);
        if (r5 == null) goto L5;
        String r7 = r5.toString();
    L6:
        tx9.v0.i(r1, false, r4, r7, r6);
        h0.q(this.d, false, null, 4);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public j0(List<Long> r1, List<kw9.a> r2, tx9.v0.b r3, h0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
