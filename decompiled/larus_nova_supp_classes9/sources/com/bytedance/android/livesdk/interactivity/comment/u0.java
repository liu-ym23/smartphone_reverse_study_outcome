package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u0 implements rv2.d {
    public final /* synthetic */ CommentWidget a;

    public final void a() {
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("comment widget load success, try set content visible");
        CommentWidget r0 = this.a;
        int r1 = CommentWidget.V1;
        r0.zr();
    }

    public final void b() {
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("comment widget start load, set content gone");
        UIUtils.setViewVisibility(((Widget) this.a).contentView, 8);
        ALogger.i("CommentWidget", "CommentWidget setWidgetInVisible GONE");
    }

    public u0(CommentWidget r1) {
        this.a = r1;
    }
}
