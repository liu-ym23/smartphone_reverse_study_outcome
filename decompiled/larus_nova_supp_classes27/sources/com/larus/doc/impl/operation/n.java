package com.larus.doc.impl.operation;

import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n implements n39.i {
    public final /* synthetic */ kotlinx.coroutines.i<dm9.a<p>> a;
    public final /* synthetic */ String b;

    @Override // n39.i
    public final void onSuccess(boolean r13) {
        if (this.a.isActive() == false) goto L10;
        FLogger.a.i("DocOpManager", "getDocShareLink: " + this.b + " success");
        kotlinx.coroutines.i<dm9.a<p>> r0 = this.a;
        IDocSdkServiceV2 r2 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r2 == null) goto L7;
        String r3 = r2.getShareLinkUrl(this.b);
    L8:
        r0.resumeWith(Result.constructor-impl(new dm9.a.b(new BizResponse(0, null, null, new p(r3, r13, 4), 7, null), null)));
        return;
    L7:
        r3 = null;
        goto L8
    }

    public n(kotlinx.coroutines.j r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // n39.i
    public final void onError(int r4, Throwable r5) {
        if (this.a.isActive() == false) goto L15;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("getDocShareLink: ");
        r1.append(this.b);
        r1.append(" fail, error: ");
        if (r5 == null) goto L7;
        String r2 = r5.getMessage();
    L8:
        r1.append(r2);
        r0.i("DocOpManager", r1.toString());
        kotlinx.coroutines.i<dm9.a<p>> r3 = this.a;
        if (r5 == null) goto L12;
        String r6 = r5.getMessage();
        if (r6 == null) goto L12;
    L13:
        r3.resumeWith(Result.constructor-impl(new dm9.a.a(r4, r6, r5)));
        return;
    L12:
        r6 = "";
        goto L13
    L7:
        r2 = null;
        goto L8
    }
}
