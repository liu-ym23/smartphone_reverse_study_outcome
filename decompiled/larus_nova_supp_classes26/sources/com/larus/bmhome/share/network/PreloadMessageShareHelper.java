package com.larus.bmhome.share.network;

import com.larus.network.bean.BizResponse;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreloadMessageShareHelper {
    public BizResponse<SaveMessageShareInfo> a;

    public static final class a {
    }

    static {
    }

    public PreloadMessageShareHelper() {
    }

    public final void a(CoroutineScope r8, f r9) {
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r9, "request");
        this.a = null;
        BuildersKt.launch$default(r8, Dispatchers.getIO(), null, new PreloadMessageShareHelper$preloadShareMessage$1(r9, this, null), 2, null);
    }

    public final Object b(f r4, Continuation<? super BizResponse<SaveMessageShareInfo>> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PreloadMessageShareHelper$requestShareMessage$2(this, r4, null), r5);
    }
}
