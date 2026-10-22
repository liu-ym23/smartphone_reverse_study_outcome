package com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/awemepaas_adapt/OpenPlatformFlavorServiceDefault;", "Lcom/bytedance/android/live/openplatform/impl/base/awemepaas_adapt/IOpenPlatformFlavorService;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformFlavorServiceDefault implements IOpenPlatformFlavorService {
    public OpenPlatformFlavorServiceDefault() {
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt.IOpenPlatformFlavorService
    public final int a() {
        x3 r0 = y3.l();
        if (r0 == null) goto L7;
        return r0.v(ToolbarButton.OPEN_PLATFORM_MINI_APP.extended());
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }
}
