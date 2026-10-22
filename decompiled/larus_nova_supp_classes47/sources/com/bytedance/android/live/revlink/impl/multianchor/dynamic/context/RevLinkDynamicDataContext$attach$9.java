package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RevLinkDynamicDataContext$attach$9 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
    public RevLinkDynamicDataContext$attach$9(e0 r8) {
        super(2, r8, e0.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
    }

    public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "p1");
        ((e0) ((CallableReference) this).receiver).q.setValue(r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((List) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
