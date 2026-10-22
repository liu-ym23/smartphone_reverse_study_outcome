package com.bytedance.android.live.openplatform.impl.miniappanchor.openapi;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.openapi.AbsOpenApiHandler;
import kotlin.jvm.internal.Intrinsics;
import tp0.a;
import tp0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniAppAnchorOpenApiHandler extends AbsOpenApiHandler {
    public MiniAppAnchorOpenApiHandler(final OpenPlatformContext r5, final String r6) {
        Intrinsics.checkNotNullParameter(r5, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r6, "appId");
        super(r5, r6);
        b r0 = new b(r5, r6);
        a r1 = new a(r5, r6);
        b("subscribeAudiencesFollowAction", new AnonymousClass1(r5, r6));
        b("unsubscribeAudiencesFollowAction", new AnonymousClass2(r5, r6));
        b("subscribeSpecifiedContentComment", new AnonymousClass3(r5, r6));
        b("unsubscribeAllSpecifiedContentComment", new AnonymousClass4(r5, r6));
        b("subscribeSpecifiedUserComment", new AnonymousClass5(r5, r6));
        b("unsubscribeAllSpecifiedUserComment", new AnonymousClass6(r5, r6));
        ro0.a r7 = r5.getMessageManager();
        if (r7 == null) goto L5;
        r7.a(r0);
    L5:
        ro0.a r8 = r5.getMessageManager();
        if (r8 == null) goto L9;
        r8.a(r1);
        return;
    }
}
