package com.bytedance.android.livesdk.feed.squarefeed.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.rank.a;
import com.bytedance.android.live.base.model.rank.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feed/squarefeed/adapter/RankItemComparator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/android/live/base/model/rank/a;", "<init>", "()V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class RankItemComparator extends DiffUtil.ItemCallback<a> {
    public RankItemComparator() {
    }

    public final boolean areContentsTheSame(Object r2, Object r3) {
        a r4 = (a) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        if (r4.c() != null) goto L5;
    L16:
        return false;
    L5:
        if (r5.c() == null) goto L16;
        c r6 = r4.c();
        Long r0 = null;
        if (r6 == null) goto L9;
        Long r7 = r6.b();
    L10:
        c r8 = r5.c();
        if (r8 == null) goto L14;
        r0 = r8.b();
    L14:
        if (Intrinsics.areEqual(r7, r0) == false) goto L16;
        return true;
    L9:
        r7 = null;
        goto L10
    }

    public final boolean areItemsTheSame(Object r2, Object r3) {
        a r4 = (a) r2;
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        if (r4.c() != null) goto L5;
    L16:
        return false;
    L5:
        if (r5.c() == null) goto L16;
        c r6 = r4.c();
        Long r0 = null;
        if (r6 == null) goto L9;
        Long r7 = r6.b();
    L10:
        c r8 = r5.c();
        if (r8 == null) goto L14;
        r0 = r8.b();
    L14:
        if (Intrinsics.areEqual(r7, r0) == false) goto L16;
        return true;
    L9:
        r7 = null;
        goto L10
    }
}
