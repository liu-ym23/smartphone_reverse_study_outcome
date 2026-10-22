package l7a;

import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h extends LynxResourceCallback<byte[]> {
    public final a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ LynxResourceLoader d;

    @Override // com.lynx.tasm.provider.LynxResourceCallback
    public final void onResponse(LynxResourceResponse<byte[]> r4) {
        boolean r0 = r4.success();
        Throwable r1 = r4.getError();
        a r2 = this.a;
        byte[] r5 = r4.getData();
        if (r1 == null) goto L5;
        String r3 = r1.getMessage();
    L6:
        r2.b(r0, r5, r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public h(LynxResourceLoader r3, String r4, long r5) {
        this.d = r3;
        this.b = r4;
        this.c = r5;
        this.a = new a(this.d, this.b, this.c);
    }
}
