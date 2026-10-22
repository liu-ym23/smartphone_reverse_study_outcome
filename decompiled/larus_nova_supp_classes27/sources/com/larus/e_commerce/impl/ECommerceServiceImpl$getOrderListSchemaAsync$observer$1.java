package com.larus.e_commerce.impl;

import androidx.lifecycle.Observer;
import com.larus.e_commerce.impl.order.OrderSchemaService;
import com.larus.network.http.f;
import com.larus.network.http.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/larus/e_commerce/impl/ECommerceServiceImpl$getOrderListSchemaAsync$observer$1", "Landroidx/lifecycle/Observer;", "Lcom/larus/network/http/Async;", "", "onChanged", "", "async", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECommerceServiceImpl$getOrderListSchemaAsync$observer$1 implements Observer<com.larus.network.http.a<? extends String>> {
    public final /* synthetic */ Function1<String, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public ECommerceServiceImpl$getOrderListSchemaAsync$observer$1(Function1<? super String, Unit> r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        y r4 = (com.larus.network.http.a) r3;
        Intrinsics.checkNotNullParameter(r4, "async");
        if ((r4 instanceof y) == false) goto L11;
        OrderSchemaService.b.removeObserver(this);
        String r5 = (String) ((com.larus.network.http.a) r4).b;
        if (r5 != null) goto L7;
    L9:
        this.a.invoke(null);
        return;
    L7:
        if (OrderSchemaService.b() == true) goto L9;
        this.a.invoke(r5);
        return;
    L11:
        if ((r4 instanceof f) == false) goto L16;
        OrderSchemaService.b.removeObserver(this);
        this.a.invoke(null);
        return;
    }
}
