package com.bytedance.android.livesdk.interactivity.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0016J\u0010\u0010\u0004\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/VirtualInteractService;", "Lcom/bytedance/android/livesdk/interactivity/api/IVirtualInteractService;", "Lcom/bytedance/ies/web/jsbridge2/f;", "getCreateActorMethod", "getInteractionCommandMethod", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VirtualInteractService implements IVirtualInteractService {
    public VirtualInteractService() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IVirtualInteractService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> getCreateActorMethod() {
        return new sc2.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.IVirtualInteractService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> getInteractionCommandMethod() {
        return new sc2.d();
    }
}
