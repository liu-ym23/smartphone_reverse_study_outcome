package com.bytedance.android.live.messagewindow.framework.manager;

import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements e71.a {
    public static final f a = null;

    public f() {
    }

    static {
        a = new f();
    }

    public final void dismiss(v61.c r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        if ((r3 instanceof v61.a) == false) goto L10;
        DataCenter r0 = ((v61.a) r3).getDataCenter();
        CardContext.Companion.getClass();
        com.bytedance.android.live.messagewindow.framework.context.c r1 = CardContext.a.a(r0);
        if (r1 == null) goto L11;
        e71.a r2 = r1.windowManager();
        if (r2 == null) goto L12;
        r2.dismiss(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void hide(v61.c r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        if ((r3 instanceof v61.a) == false) goto L10;
        DataCenter r0 = ((v61.a) r3).getDataCenter();
        CardContext.Companion.getClass();
        com.bytedance.android.live.messagewindow.framework.context.c r1 = CardContext.a.a(r0);
        if (r1 == null) goto L11;
        e71.a r2 = r1.windowManager();
        if (r2 == null) goto L12;
        r2.hide(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void show(v61.c r3) {
        Intrinsics.checkNotNullParameter(r3, "msgWindow");
        if ((r3 instanceof v61.a) == false) goto L10;
        DataCenter r0 = ((v61.a) r3).getDataCenter();
        CardContext.Companion.getClass();
        com.bytedance.android.live.messagewindow.framework.context.c r1 = CardContext.a.a(r0);
        if (r1 == null) goto L11;
        e71.a r2 = r1.windowManager();
        if (r2 == null) goto L12;
        r2.show(r3);
        return;
    L12:
        return;
    L11:
        return;
    }
}
