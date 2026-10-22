package com.bytedance.android.live.base.model.user;

import com.bytedance.android.livesdk.utils.d5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p0 implements o0 {
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    @Override // com.bytedance.android.live.base.model.user.o0
    public final long getAwemeUserId() {
        return d5.c(this.b);
    }

    @Override // com.bytedance.android.live.base.model.user.o0
    public final String getOpenUserId() {
        String r0 = this.c;
        if (r0 != null) goto L6;
        return "0";
    L6:
        return r0;
    }

    @Override // com.bytedance.android.live.base.model.user.o0
    public final boolean a() {
        return o0.b.a(this);
    }

    @Override // com.bytedance.android.live.base.model.user.o0
    public final String getUserId() {
        return getOpenUserId();
    }

    public p0(String r1, String r2) {
        this.b = r1;
        this.c = r2;
    }
}
