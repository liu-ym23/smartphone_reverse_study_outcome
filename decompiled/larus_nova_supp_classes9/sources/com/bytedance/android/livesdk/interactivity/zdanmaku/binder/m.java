package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements com.bytedance.android.livesdk.interactivity.api.publicscreen.e, nf6.a {
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.e a;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long c() {
        return this.a.c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final long getReceiveTime() {
        return this.a.getReceiveTime();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final boolean isSelfSendFake() {
        return this.a.isSelfSendFake();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final boolean isSendReview() {
        return this.a.isSendReview();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.e
    public final String j() {
        return this.a.j();
    }

    public m(com.bytedance.android.livesdk.interactivity.api.publicscreen.e r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
    }
}
