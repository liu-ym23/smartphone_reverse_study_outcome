package com.bytedance.android.live.profit.format.voicechat.view;

import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;
import nu0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ OperationTipView a;

    public d(OperationTipView r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        j.d(this.a, "thinking 超时展示 ui", null);
        OperationTipView r6 = this.a;
        r6.e(r6.g, OperationTipView.a(r6), CollectionsKt.listOf(OperationTipView.b(this.a)));
    }
}
