package com.larus.share.impl.view;

import com.larus.share.service.IShareDoubaoForwardService;
import com.larus.utils.logger.FLogger;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k0 implements IShareDoubaoForwardService.a {
    public final /* synthetic */ List<kw9.a> a;
    public final /* synthetic */ h0 b;

    @Override // com.larus.share.service.IShareDoubaoForwardService.a
    public final void a(kw9.a r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("host file forward attempt, entry=direct_contact, stage=result, success=true, targetCount=");
        r1.append(this.a.size());
        r1.append(", hasTargetInfo=");
        if (r5 == null) goto L5;
        boolean r3 = true;
    L6:
        r1.append(r3);
        r0.i("SharePanelView", r1.toString());
        h0.q(this.b, true, r5, 2);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public k0(List<kw9.a> r1, h0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.share.service.IShareDoubaoForwardService.a
    public final void onFailure(Integer r3, String r4) {
        FLogger.a.e("SharePanelView", "host file forward attempt, entry=direct_contact, stage=result, success=false, targetCount=" + this.a.size() + ", errorCode=" + r3);
        h0.q(this.b, false, null, 4);
    }
}
