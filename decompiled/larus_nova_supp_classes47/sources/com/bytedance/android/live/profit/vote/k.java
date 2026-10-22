package com.bytedance.android.live.profit.vote;

import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.android.scope.o;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements o, e {
    public final j a;
    public final com.bytedance.android.live.revenue.core.a b;
    public final com.bytedance.android.live.profit.vote.model.f c;
    public final f d;

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.profit.vote.e
    public final boolean fi() {
        com.bytedance.android.live.profit.vote.model.c r0 = (com.bytedance.android.live.profit.vote.model.c) PropertyOwnersKt.a(this.c.a);
        if (r0 != null) goto L7;
        return false;
    L7:
        return d.a(r0);
    }

    public final void onStart() {
        this.b.d(Reflection.getOrCreateKotlinClass(e.class), this.a);
    }

    @Override // com.bytedance.android.live.profit.vote.e
    public final void Ca(Map<String, String> r5, long r6, String r8) {
        Intrinsics.checkNotNullParameter(r5, "extra");
        Intrinsics.checkNotNullParameter(r8, "targetUserId");
        f r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "$this$putSendGiftExtra");
        Intrinsics.checkNotNullParameter(r8, "targetUserId");
        com.bytedance.android.live.profit.vote.model.c r9 = (com.bytedance.android.live.profit.vote.model.c) PropertyOwnersKt.a(r1.a.a);
        if (r9 == null) goto L6;
        VoteUtilsKt.j(r5, r9);
    L6:
        if (r1.c.q() == false) goto L30;
        if (r9 != null) goto L9;
        return;
    L9:
        if (VoteUtilsKt.h(r9) != true) goto L32;
        g r0 = (g) CollectionsKt.getOrNull((List) r9.b.d, 1);
        Long r2 = null;
        if (r0 == null) goto L13;
        Long r3 = Long.valueOf(r0.b);
    L14:
        g r10 = (g) CollectionsKt.getOrNull((List) r9.b.d, 0);
        if (r10 == null) goto L18;
        r2 = Long.valueOf(r10.b);
    L18:
        if (r3 != null) goto L21;
    L23:
        if (r2 != null) goto L26;
    L28:
        VoteUtilsKt.i(r5);
        return;
    L26:
        if (r6 != r2.longValue()) goto L28;
        r5.put("poll_gift_type", "negative");
        goto L28
    L21:
        if (r6 != r3.longValue()) goto L23;
        r5.put("poll_gift_type", "positive");
        goto L28
    L13:
        r3 = null;
        goto L14
    L32:
        return;
    }

    public k(j r2, com.bytedance.android.live.revenue.core.a r3, com.bytedance.android.live.profit.vote.model.f r4, f r5) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "inst");
        Intrinsics.checkNotNullParameter(r4, "voteRepository");
        Intrinsics.checkNotNullParameter(r5, "etHelper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
