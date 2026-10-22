package l7a;

import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f extends LynxResourceCallback<byte[]> {
    public final k a;

    @Override // com.lynx.tasm.provider.LynxResourceCallback
    public final void onResponse(LynxResourceResponse<byte[]> r6) {
        super.onResponse(r6);
        k r0 = this.a;
        boolean r1 = r6.success();
        byte[] r2 = r6.getData();
        if (r6.getError() == null) goto L5;
        String r7 = r6.getError().getMessage();
    L6:
        r0.b(r1, r2, null, r7);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public f(LynxResourceLoader r8, String r9, long r10, LynxResourceRequest.LynxResourceType r12) {
        this.a = new k(r9, r10, r8.f, r12);
    }
}
