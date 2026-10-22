package u4a;

import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n implements e8a.a<byte[]> {
    public final /* synthetic */ l a;

    public n(l r1) {
        this.a = r1;
    }

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<byte[]> r4) {
        byte[] r0 = r4.b;
        if (r0 != null) goto L5;
    L7:
        l r1 = this.a;
        AnimaXLoaderCompletionHandler r2 = (AnimaXLoaderCompletionHandler) r1;
        r2.a(AnimaXLoaderResponse.b(r4.c));
        return;
    L5:
        if (r4.a != LynxResourceResponse.ResponseState.SUCCESS) goto L7;
        l r5 = this.a;
        AnimaXLoaderCompletionHandler r6 = (AnimaXLoaderCompletionHandler) r5;
        r6.a(AnimaXLoaderResponse.a(r0));
    }
}
