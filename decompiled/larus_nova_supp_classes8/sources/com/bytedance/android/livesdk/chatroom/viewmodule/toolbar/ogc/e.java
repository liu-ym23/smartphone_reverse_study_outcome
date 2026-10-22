package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ OgcVSWebActivityBehavior a;

    public e(OgcVSWebActivityBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        if (v.a() == false) goto L5;
        r3.printStackTrace();
    L5:
        y3.m(this.a.e).i(ToolbarButton.VS_ACTIVITY_ONE.extended());
    }
}
