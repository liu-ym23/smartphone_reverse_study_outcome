package com.bytedance.android.live.revlink.impl.multianchor.widget;

import com.bytedance.android.live.revlink.impl.intercomment.InteractCommentWidget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public InteractCommentWidget a;
    public final WidgetManager b;

    public final void a() {
        InteractCommentWidget r0 = new InteractCommentWidget();
        this.b.load(r0);
        this.a = r0;
    }

    public final void b() {
        InteractCommentWidget r0 = this.a;
        if (r0 == null) goto L6;
        r0.xq();
        return;
    }

    public final void c() {
        this.b.unload(this.a);
        this.a = null;
    }

    public h(WidgetManager r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetManager");
        this.b = r2;
    }
}
