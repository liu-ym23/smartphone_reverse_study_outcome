package com.bytedance.android.live.broadcastgame.opengame.view;

import android.text.TextUtils;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k extends b7.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ e c;

    public final boolean onFallback(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "errorMessage");
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        this.b.invoke();
        return true;
    L5:
        return false;
    }

    public k(String r1, Function0 r2, com.bytedance.android.live.broadcastgame.opengame.s.b.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onLoadFail(View r2, String r3, String r4) {
        e r5 = this.c;
        if (r5 == null) goto L6;
        r5.onError("load Lynx failed: " + r4);
        return;
    }
}
