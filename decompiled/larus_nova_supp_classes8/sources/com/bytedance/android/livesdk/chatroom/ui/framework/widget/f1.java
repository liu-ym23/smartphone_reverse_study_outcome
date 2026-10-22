package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f1 extends SimpleShareCallback {
    public final /* synthetic */ ShareCompositeWidget a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Room c;

    public final void onSuccess(String r5, String r6) {
        if (this.b == false) goto L8;
        long r7 = System.currentTimeMillis();
        ShareCompositeWidget r0 = this.a;
        if ((r7 - r0.d) < 2000) goto L9;
        r0.d = System.currentTimeMillis();
        ShareCompositeWidget r8 = this.a;
        Room r9 = this.c;
        ShareCompositeWidget.xq(r8, r9.id, r9.getLabels());
        return;
    L9:
        return;
    }

    public f1(ShareCompositeWidget r1, boolean r2, Room r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
