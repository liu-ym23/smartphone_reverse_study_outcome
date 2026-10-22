package com.larksuite.framework.http.v2.internal.main;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "weak", "Ljava/lang/ref/WeakReference;", "Lcom/larksuite/framework/http/v2/LarkHttpClient;", "invoke", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class LarkHttpImpl$removeExpired$1 extends Lambda implements Function1<WeakReference<com.larksuite.framework.http.v2.c>, Boolean> {
    final /* synthetic */ Function1<com.larksuite.framework.http.v2.c, Unit> $action;

    /* JADX WARN: Multi-variable type inference failed */
    public LarkHttpImpl$removeExpired$1(Function1<? super com.larksuite.framework.http.v2.c, Unit> r1) {
        this.$action = r1;
        super(1);
    }

    public final Boolean invoke(WeakReference<com.larksuite.framework.http.v2.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "weak");
        com.larksuite.framework.http.v2.c r3 = r2.get();
        if (r3 == null) goto L5;
        this.$action.invoke(r3);
    L5:
        if (r3 != null) goto L7;
        boolean r4 = true;
    L9:
        return Boolean.valueOf(r4);
    L7:
        r4 = false;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((WeakReference) r1);
    }
}
