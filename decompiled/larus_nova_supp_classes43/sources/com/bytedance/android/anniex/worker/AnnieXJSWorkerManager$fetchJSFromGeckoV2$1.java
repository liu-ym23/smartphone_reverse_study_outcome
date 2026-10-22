package com.bytedance.android.anniex.worker;

import com.bytedance.forest.model.RequestParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "_params", "Lcom/bytedance/forest/model/RequestParams;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXJSWorkerManager$fetchJSFromGeckoV2$1 extends Lambda implements Function1<RequestParams, Unit> {
    final /* synthetic */ RequestParams $params;

    public AnnieXJSWorkerManager$fetchJSFromGeckoV2$1(RequestParams r1) {
        this.$params = r1;
        super(1);
    }

    public final void invoke(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "_params");
        RequestParams r0 = this.$params;
        r10.o = r0.o;
        r10.D = r0.D;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((RequestParams) r1);
        return Unit.INSTANCE;
    }
}
