package com.bytedance.android.live.profit.vote.model;

import com.bytedance.android.live.profit.vote.VoteState;
import com.bytedance.android.live.profit.vote.VoteUtilsKt;
import com.bytedance.android.live.profit.vote.g;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.revenue.platform.api.core.rx.n;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.live.profit.vote.b {
    public final n<VoteState> a;
    public final n<List<g>> b;
    public final d c;
    public final long d;
    public final long e;

    @Override // com.bytedance.android.live.profit.vote.b
    public final long a() {
        return this.c.a();
    }

    public final String toString() {
        return "Vote(id=" + this.d + ", type=" + this.e + ", state=" + ((VoteState) this.a.d) + ", clock=" + this.c + ", items=" + VoteUtilsKt.d((List) this.b.d) + ')';
    }

    @Override // com.bytedance.android.live.profit.vote.b
    public final n getItems() {
        return this.b;
    }

    @Override // com.bytedance.android.live.profit.vote.b
    public final n getState() {
        return this.a;
    }

    @Override // com.bytedance.android.live.profit.vote.b
    public final long getVoteId() {
        return this.d;
    }

    @Override // com.bytedance.android.live.profit.vote.b
    public final long getVoteType() {
        return this.e;
    }

    public c(long r2, long r4, VoteState r6, List<g> r7) {
        Intrinsics.checkNotNullParameter(r6, "initialState");
        Intrinsics.checkNotNullParameter(r7, "initialItems");
        this.d = r2;
        this.e = r4;
        this.a = PropertyOwnersKt.b(r6);
        this.b = PropertyOwnersKt.b(r7);
        this.c = new d();
    }
}
