package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements w4b.a {
    public a() {
    }

    public final boolean b() {
        return owa.a.c().h();
    }

    public final ValidateResult d() {
        return owa.a.c().c(true);
    }

    public final AuthorizationServiceV2 g() {
        return owa.a.c();
    }

    public final String getUploadAuthorizationTip() {
        return owa.a.b().a();
    }

    public final boolean isAuthorizationPassed(ValidateResult r2) {
        return owa.a.c().isAuthorizationPassed(r2);
    }

    public final void a(ValidateResult r2, AuthorizationServiceV2.AuthorizationType r3) {
        owa.a.c().a(r2, r3);
    }

    public final void auditLinkEvent(String r2, String r3) {
        owa.a.a().b(r3);
        owa.a.a().a(r2, r3);
    }

    public final void c(String r3, String r4) {
        owa.a.a().getClass();
        Intrinsics.checkNotNullParameter(r4, "messageType");
        if (r3 != null) goto L5;
        Log.e("AuditService", "audit copy event, chatId is null");
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.auditsdk.wrapper.d(r3, r4));
    }

    public final void f(String r3, String r4) {
        owa.a.a().getClass();
        Intrinsics.checkNotNullParameter(r4, "imageId");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.auditsdk.wrapper.e(r3, r4));
    }

    public final void e(String r2, String r3, String r4, String r5) {
        owa.a.a().c(r2, r3, r4, r5);
    }
}
