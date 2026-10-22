package l7a;

import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i implements e8a.a<h8a.b> {
    public final /* synthetic */ k a;

    public i(k r1) {
        this.a = r1;
    }

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<h8a.b> r6) {
        h8a.b r0 = r6.b;
        String r1 = null;
        if (r0 == null) goto L5;
        byte[] r2 = r0.a;
        TemplateBundle r3 = r0.b;
    L6:
        Throwable r4 = r6.c;
        if (r4 == null) goto L9;
        r1 = r4.getMessage();
    L9:
        k r5 = this.a;
        if (r6.a != LynxResourceResponse.ResponseState.SUCCESS) goto L12;
        boolean r7 = true;
    L13:
        r5.b(r7, r2, r3, r1);
        return;
    L12:
        r7 = false;
        goto L13
    L5:
        r3 = null;
        r2 = null;
        goto L6
    }
}
