package com.larus.bmhome.miniartifact.product.network;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.network.bean.BizResponse;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreloadMiniArtifactShareHelper {
    public BizResponse<com.larus.bmhome.miniartifact.product.network.a> a;

    public static final class a {
    }

    static {
    }

    public PreloadMiniArtifactShareHelper() {
    }

    public final void a(LifecycleCoroutineScope r8, b r9) {
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r9, "request");
        this.a = null;
        BuildersKt.launch$default(r8, Dispatchers.getIO(), null, new PreloadMiniArtifactShareHelper$preloadShareMessage$1(this, r9, null), 2, null);
    }

    public final Object b(b r4, Continuation<? super BizResponse<com.larus.bmhome.miniartifact.product.network.a>> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PreloadMiniArtifactShareHelper$requestShareMessage$2(this, r4, null), r5);
    }
}
