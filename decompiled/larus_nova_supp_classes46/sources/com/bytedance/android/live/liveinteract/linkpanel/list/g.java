package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.graphics.drawable.NinePatchDrawable;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements a3.b {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ py.k b;

    public final void onFail() {
    }

    public final void a(NinePatchDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
        TextView r3 = this.a;
        py.k r0 = this.b;
        if (r0 == null) goto L7;
        py.k.b r1 = r0.getImageContent();
        if (r1 == null) goto L7;
        String r4 = r1.getName();
    L8:
        r3.setText(r4);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public g(TextView r1, py.k r2) {
        this.a = r1;
        this.b = r2;
    }
}
