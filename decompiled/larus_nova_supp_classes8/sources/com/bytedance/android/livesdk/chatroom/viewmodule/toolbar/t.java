package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t {
    public static final List<ExtendedToolbarButton> a(List<? extends ToolbarButton> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$extend");
        ArrayList r0 = new ArrayList();
        Iterator<? extends ToolbarButton> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(r3.next().extended());
        goto L4
    L6:
        return r0;
    }
}
