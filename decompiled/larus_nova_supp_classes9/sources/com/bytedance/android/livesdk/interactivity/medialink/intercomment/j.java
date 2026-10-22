package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends hy.f.a {
    public final /* synthetic */ MediaInteractCommentWidget a;

    public j(MediaInteractCommentWidget r1) {
        this.a = r1;
    }

    public final void d(int r2, List<AnchorLinkUser> r3) {
        if (r3 != null) goto L4;
    L5:
        MediaInteractCommentWidget r4 = this.a;
        if (r3 == null) goto L8;
        int r5 = ((CopyOnWriteArrayList) r3).size();
    L9:
        r4.j = r5;
        this.a.i = false;
    L10:
        MediaInteractCommentWidget r6 = this.a;
        int r7 = MediaInteractCommentWidget.p;
        r6.Bq();
        return;
    L8:
        r5 = 0;
        goto L9
    L4:
        if (((CopyOnWriteArrayList) r3).size() == this.a.j) goto L10;
        goto L5
    }
}
