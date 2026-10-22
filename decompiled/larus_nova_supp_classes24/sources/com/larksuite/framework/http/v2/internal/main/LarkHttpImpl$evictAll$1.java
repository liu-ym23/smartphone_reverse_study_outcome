package com.larksuite.framework.http.v2.internal.main;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/larksuite/framework/http/v2/LarkHttpClient;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class LarkHttpImpl$evictAll$1 extends Lambda implements Function1<com.larksuite.framework.http.v2.c, Unit> {
    public static final LarkHttpImpl$evictAll$1 INSTANCE = null;

    static {
        INSTANCE = new LarkHttpImpl$evictAll$1();
    }

    public LarkHttpImpl$evictAll$1() {
        super(1);
    }

    public final void invoke(com.larksuite.framework.http.v2.c r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$removeExpired");
        r2.getOriginal().connectionPool().evictAll();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.larksuite.framework.http.v2.c) r1);
        return Unit.INSTANCE;
    }
}
