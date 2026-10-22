package com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m;
import com.bytedance.live.datacontext.j;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/awemepaas_adapt/OpenPlatformFlavorServiceForDouyin;", "Lcom/bytedance/android/live/openplatform/impl/base/awemepaas_adapt/IOpenPlatformFlavorService;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformFlavorServiceForDouyin implements IOpenPlatformFlavorService {
    public OpenPlatformFlavorServiceForDouyin() {
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt.IOpenPlatformFlavorService
    public final int a() {
        m r1 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        j r2 = r0.getCompactTbLoader();
        if (r2 == null) goto L7;
        m r3 = (m) r2.getValue();
    L9:
        if ((r3 instanceof m) == false) goto L12;
        r1 = r3;
    L12:
        if (r1 != null) goto L16;
        return -1;
    L16:
        return r1.getComponentIndex(3);
    L7:
        r3 = null;
        goto L9
    }
}
