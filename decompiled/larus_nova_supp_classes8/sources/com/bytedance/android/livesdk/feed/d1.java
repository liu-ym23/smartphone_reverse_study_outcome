package com.bytedance.android.livesdk.feed;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d1<T1, T2, R> implements BiFunction {
    public static final d1 a = null;

    static {
        a = new d1();
    }

    public d1() {
    }

    public final Object apply(Object r4, Object r5) {
        BaseListResponse r6 = (BaseListResponse) r4;
        FeedItem r7 = (FeedItem) r5;
        Intrinsics.checkNotNullParameter(r6, "recRes");
        Intrinsics.checkNotNullParameter(r7, "historyRes");
        List r0 = r6.data;
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L6:
        if (r1 <= 0) goto L26;
        List r2 = r6.data;
        if (r2 == null) goto L13;
        FeedItem r3 = (FeedItem) ListProtector.get(r2, 0);
        if (r3 == null) goto L13;
        if (r3.type != 1001) goto L13;
    L25:
        ListProtector.add(r6.data, 1, r7);
    L27:
        return r6;
    L13:
        List r8 = r6.data;
        if (r8 == null) goto L19;
        FeedItem r9 = (FeedItem) ListProtector.get(r8, 0);
        if (r9 == null) goto L19;
        if (r9.type == (-1)) goto L25;
    L19:
        List r10 = r6.data;
        if (r10 == null) goto L26;
        FeedItem r11 = (FeedItem) ListProtector.get(r10, 0);
        if (r11 == null) goto L26;
        if (r11.type == 6) goto L25;
    L26:
        ListProtector.add(r6.data, 0, r7);
        goto L27
    L5:
        r1 = 0;
        goto L6
    }
}
