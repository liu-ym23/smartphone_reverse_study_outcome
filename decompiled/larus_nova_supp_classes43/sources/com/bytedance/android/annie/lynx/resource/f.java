package com.bytedance.android.annie.lynx.resource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements d8a.b.a {
    public final /* synthetic */ LynxTemplateProvider a;
    public final /* synthetic */ d8a.b.a b;

    public final void onFailed(String r10) {
        d8a.b.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFailed(r10);
        return;
    }

    public final void onSuccess(byte[] r10) {
        c r0 = this.a.e;
        if (r0 == null) goto L5;
        r0.a(new com.bytedance.android.annie.card.web.resource.a(false, "unknown", 0, false));
    L5:
        d8a.b.a r1 = this.b;
        if (r1 == null) goto L9;
        r1.onSuccess(r10);
        return;
    }

    public f(LynxTemplateProvider r1, d8a.b.a r10) {
        this.a = r1;
        this.b = r10;
    }
}
