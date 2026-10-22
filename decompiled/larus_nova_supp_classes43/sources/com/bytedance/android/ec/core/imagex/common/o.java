package com.bytedance.android.ec.core.imagex.common;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements com.bytedance.android.shopping.api.image.v {
    public final /* synthetic */ ImageUrlParser a;

    public o(ImageUrlParser r1) {
        this.a = r1;
    }

    public final boolean a(String r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.a.q.containsKey(r10) == false) goto L6;
        return true;
    }

    public final String b(String r10) {
        return this.a.q.get(r10);
    }

    public final void appendQueryParameter(String r10, String r11) {
        if (r10 == null) goto L6;
        if (r11 == null) goto L7;
        this.a.q.put(r10, r11);
        return;
    L7:
        return;
    }
}
