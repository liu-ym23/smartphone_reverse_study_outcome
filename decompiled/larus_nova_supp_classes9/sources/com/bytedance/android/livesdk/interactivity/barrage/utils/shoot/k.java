package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements a3.b {
    public final /* synthetic */ q72.d a;
    public final /* synthetic */ r22.a.b b;

    public final void onFail() {
        q72.d r0 = this.a;
        r0.d = true;
        if (r0.e == null) goto L6;
        this.b.a(r0);
        return;
    }

    public final void a(NinePatchDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
        q72.d r0 = this.a;
        r0.c = r2;
        r0.d = true;
        if (r0.e == null) goto L6;
        this.b.a(r0);
        return;
    }

    public k(q72.d r1, r22.a.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
