package l7a;

import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements e8a.a<byte[]> {
    public final a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ LynxResourceLoader d;

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<byte[]> r4) {
        if (r4.a != LynxResourceResponse.ResponseState.SUCCESS) goto L5;
        boolean r0 = true;
    L6:
        Throwable r1 = r4.c;
        a r2 = this.a;
        byte[] r5 = r4.b;
        if (r1 == null) goto L9;
        String r3 = r1.getMessage();
    L10:
        r2.b(r0, r5, r3);
        return;
    L9:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public g(LynxResourceLoader r3, String r4, long r5) {
        this.d = r3;
        this.b = r4;
        this.c = r5;
        this.a = new a(this.d, this.b, this.c);
    }
}
