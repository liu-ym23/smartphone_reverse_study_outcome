package com.ss.android.lark.log.trace;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public boolean a;
    public boolean b;
    public final Map<String, String> c;

    public c() {
        this(null);
    }

    public c(Object r3) {
        Map<String, String> r4 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter("", INotificationHitPoint.NoticeType.MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "extras");
        this.a = true;
        this.b = true;
        this.c = r4;
    }
}
