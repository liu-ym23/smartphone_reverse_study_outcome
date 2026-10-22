package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements d {
    public final /* synthetic */ e a;
    public final /* synthetic */ nh0.o b;
    public final /* synthetic */ String c;

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "errorMessage");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onRelease() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onFail() {
        this.a.g(this.c);
        e.b(this.a, this.b, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onSuccess() {
        e.b(this.a, this.b, 1);
    }

    public g(e r1, nh0.o r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
