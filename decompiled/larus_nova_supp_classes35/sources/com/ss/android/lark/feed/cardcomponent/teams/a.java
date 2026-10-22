package com.ss.android.lark.feed.cardcomponent.teams;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.List;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements Comparator {
    public final /* synthetic */ List a;

    public a(List r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        int r4 = ((Number) r2).intValue();
        Float r5 = Float.valueOf(((FeedTeamView.b) ListProtector.get(this.a, r4)).b);
        int r6 = ((Number) r3).intValue();
        return ComparisonsKt.compareValues(r5, Float.valueOf(((FeedTeamView.b) ListProtector.get(this.a, r6)).b));
    }
}
