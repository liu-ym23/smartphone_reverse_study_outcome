package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.net.Uri;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z implements com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ Uri b;

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onRuntimeReady(View r2) {
        this.a.onLoadSuccess(r2);
    }

    public z(a0 r1, Uri r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onLoadFailed(View r3, String r4) {
        this.a.onLoadFail(r3, this.b.toString(), r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f
    public final void onLoadStart(Uri r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        this.a.onLoadStart(r3, true);
    }
}
