package com.bytedance.forest.chain.fetchers;

import androidx.annotation.Keep;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "", "Lcom/bytedance/forest/Forest;", "forest", "<init>", "(Lcom/bytedance/forest/Forest;)V", "Lcom/bytedance/forest/model/Request;", "request", "Lcom/bytedance/forest/model/w;", "response", "", "fetchSync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;)V", "Lkotlin/Function1;", "callback", "fetchAsync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;Lkotlin/jvm/functions/Function1;)V", "cancel", "()V", "Lcom/bytedance/forest/utils/e;", "context", "Lcom/bytedance/forest/utils/e;", "getContext$forest_release", "()Lcom/bytedance/forest/utils/e;", "setContext$forest_release", "(Lcom/bytedance/forest/utils/e;)V", "Lcom/bytedance/forest/Forest;", "getForest", "()Lcom/bytedance/forest/Forest;", "forest_release"}, k = 1, mv = {1, 4, 0})
public abstract class ResourceFetcher {
    public com.bytedance.forest.utils.e context;
    private final Forest forest;

    public ResourceFetcher(Forest r5) {
        this.forest = r5;
    }

    public abstract void cancel();

    public abstract void fetchAsync(Request r5, w r10, Function1<? super w, Unit> r11);

    public abstract void fetchSync(Request r5, w r10);

    public final com.bytedance.forest.utils.e getContext$forest_release() {
        com.bytedance.forest.utils.e r5 = this.context;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        return r5;
    }

    public final Forest getForest() {
        return this.forest;
    }

    public final void setContext$forest_release(com.bytedance.forest.utils.e r5) {
        this.context = r5;
    }
}
