package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import com.bytedance.badger.collect.impl.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {BuildConfig.BUILD_TYPE, "", "invoke"}, k = 3, mv = {1, 5, 1})
final class RevShareViewServiceImpl$waitSharer$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c $sharer;
    final /* synthetic */ h this$0;

    public RevShareViewServiceImpl$waitSharer$3$1(h r1, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r2) {
        this.this$0 = r1;
        this.$sharer = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m429invoke() {
        this.$sharer.release();
        h r0 = this.this$0;
        r0.a.b.remove(r0.b);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m429invoke();
        return Unit.INSTANCE;
    }
}
