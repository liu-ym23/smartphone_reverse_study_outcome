package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.livesdk.chatroom.model.y3;
import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final boolean a(KVData r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isWidgetLoaded");
        if ((r1.getData() instanceof y3) == false) goto L12;
        Object r2 = r1.getData();
        if (r2 == null) goto L11;
        if (((y3) r2).a == false) goto L14;
        return false;
    L14:
        return true;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.WidgetLoadedEvent");
    L12:
        return true;
    }
}
