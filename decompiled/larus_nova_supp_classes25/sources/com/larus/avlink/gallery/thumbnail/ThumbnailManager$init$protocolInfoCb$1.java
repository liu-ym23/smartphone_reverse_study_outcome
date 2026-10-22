package com.larus.avlink.gallery.thumbnail;

import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ThumbnailManager$init$protocolInfoCb$1 implements f49.a {
    public ThumbnailManager$init$protocolInfoCb$1() {
    }

    public final void a() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ThumbnailManager$init$protocolInfoCb$1$onAbilityNegotiationFinished$1(null), 3, null);
    }
}
