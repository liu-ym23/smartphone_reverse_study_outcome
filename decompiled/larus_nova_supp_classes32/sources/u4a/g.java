package u4a;

import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class g implements i.a {
    public final /* synthetic */ l a;

    public /* synthetic */ g(l r1) {
        this.a = r1;
    }

    public final void a(j r3, String r4) {
        l r0 = this.a;
        if (r3 != null) goto L5;
    L8:
        AnimaXLoaderResponse<Throwable> r5 = AnimaXLoaderResponse.b(new Throwable(r4));
    L9:
        ((AnimaXLoaderCompletionHandler) r0).a(r5);
        return;
    L5:
        if (r4.isEmpty() == false) goto L8;
        r5 = new AnimaXLoaderResponse(AnimaXLoaderResponse.Type.BITMAP, r3);
        goto L9
    }
}
