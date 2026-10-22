package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements r22.a.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
    public final /* synthetic */ VSLandscapeCarnivalDanmakuPresenter.a a;

    public k(VSLandscapeCarnivalDanmakuPresenter.a r1) {
        this.a = r1;
    }

    @Override // r22.a.b
    public final void a(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        if (r4.isSelfSendFake() == false) goto L7;
        CarnivalDanmakuPresenter.IView r0 = ((q46.b) this.a.g).a;
        if (r0 == null) goto L9;
        r0.X(r4, r4.isSelfSendFake());
        return;
    L9:
        return;
    L7:
        VSLandscapeCarnivalDanmakuPresenter.a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "danmaku");
        ((LinkedList) r1.c).add(r4);
        r1.k();
    }
}
