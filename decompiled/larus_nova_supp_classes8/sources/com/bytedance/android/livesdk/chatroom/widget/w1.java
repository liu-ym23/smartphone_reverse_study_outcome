package com.bytedance.android.livesdk.chatroom.widget;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w1 {
    public static final void a(List<com.bytedance.android.livesdk.chatroom.vsplayer.model.c> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$refreshViewPosition");
        Iterator<T> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r2.next()).a();
        goto L4
    }
}
