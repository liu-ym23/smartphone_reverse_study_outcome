package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final void a(DataCenter r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        if (r3 == null) goto L5;
        LayerEventDispatcher r5 = o70.c.a(Integer.valueOf(r3.hashCode()));
    L6:
        if (r5 == null) goto L8;
        r5.b(new o42.c(false, true, r4));
        return;
    L8:
        boolean r6 = TextMessageTracer.a;
        TextMessageTracer.A("try, adjust wh, but dispatcher is null");
        return;
    L5:
        r5 = null;
        goto L6
    }

    @JvmStatic
    public static final void b(DataCenter r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        if (r2 == null) goto L5;
        LayerEventDispatcher r4 = o70.c.a(Integer.valueOf(r2.hashCode()));
    L6:
        if (r4 == null) goto L8;
        r4.b(new o42.c(true, true, r3));
        return;
    L8:
        boolean r5 = TextMessageTracer.a;
        TextMessageTracer.A("try, adjust wh, but dispatcher is null");
        return;
    L5:
        r4 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(DataCenter r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        if (r3 == null) goto L5;
        LayerEventDispatcher r5 = o70.c.a(Integer.valueOf(r3.hashCode()));
    L6:
        if (r5 == null) goto L8;
        r5.b(new o42.c(true, false, r4));
        return;
    L8:
        boolean r6 = TextMessageTracer.a;
        TextMessageTracer.A("try, adjust wh, but dispatcher is null");
        return;
    L5:
        r5 = null;
        goto L6
    }
}
