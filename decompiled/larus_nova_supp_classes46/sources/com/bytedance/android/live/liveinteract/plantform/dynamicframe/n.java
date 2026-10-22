package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements d {
    public final /* synthetic */ o a;
    public final /* synthetic */ String b;

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "errorMessage");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onRelease() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onSuccess() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.d
    public final void onFail() {
        this.a.b(this.b);
    }

    public n(o r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
