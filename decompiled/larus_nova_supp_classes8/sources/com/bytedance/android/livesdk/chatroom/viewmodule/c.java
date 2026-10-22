package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements Runnable {
    public final /* synthetic */ AnchorStickerWrapperWidget a;
    public final /* synthetic */ zg1.c3 b;

    public c(AnchorStickerWrapperWidget r1, zg1.c3 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        AnchorStickerWrapperWidget r0 = this.a;
        r0.c[1] = UIUtils.getScreenHeight(((Widget) r0).context) - this.b.a;
        AnchorStickerWrapperWidget r1 = this.a;
        r1.u = r1.c[1];
        int r2 = ((ArrayList) r1.e).size() - 1;
    L3:
        if (r2 < 0) goto L5;
        ((com.bytedance.android.livesdk.chatroom.widget.u) ListProtector.get(this.a.e, r2)).m(this.a.c);
        r2 = r2 - 1;
        goto L3
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
