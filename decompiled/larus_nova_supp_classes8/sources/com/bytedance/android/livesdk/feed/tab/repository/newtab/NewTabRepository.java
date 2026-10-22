package com.bytedance.android.livesdk.feed.tab.repository.newtab;

import com.bytedance.android.livesdk.feed.tab.repository.l;
import com.bytedance.android.livesdk.feed.tab.repository.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class NewTabRepository extends l {
    public static final Lazy d = null;
    public static final Lazy e = null;

    public static final class a {
    }

    static {
        d = LazyKt.lazy(NewTabRepository$Companion$drawerRepository$2.INSTANCE);
        e = LazyKt.lazy(NewTabRepository$Companion$multiTabRepository$2.INSTANCE);
    }

    public NewTabRepository(s r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "local");
        Intrinsics.checkNotNullParameter(r3, "remote");
        super(r2, r3);
    }
}
