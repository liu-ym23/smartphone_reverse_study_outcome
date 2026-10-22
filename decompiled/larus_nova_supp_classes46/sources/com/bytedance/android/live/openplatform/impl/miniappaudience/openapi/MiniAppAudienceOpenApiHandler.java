package com.bytedance.android.live.openplatform.impl.miniappaudience.openapi;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.openapi.AbsOpenApiHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniAppAudienceOpenApiHandler extends AbsOpenApiHandler {
    public MiniAppAudienceOpenApiHandler(final OpenPlatformContext r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2, r3);
        b("getSelfCommentCountDuringPluginRunning", new AnonymousClass1(r2, r3));
    }
}
