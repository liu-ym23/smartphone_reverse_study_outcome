package com.bytedance.android.live.revenue.platform.container.impl.core;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/b;", "", "invoke", "(Lyy0/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class NativeHostServiceImpl$createAnnieXCard$center$1 extends Lambda implements Function1<yy0.b, Unit> {
    final /* synthetic */ Function0 $onFail;
    final /* synthetic */ NativeHostServiceImpl this$0;

    public NativeHostServiceImpl$createAnnieXCard$center$1(NativeHostServiceImpl r1, Function0 r2) {
        this.this$0 = r1;
        this.$onFail = r2;
        super(1);
    }

    public final void invoke(yy0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        r4.d(new AnonymousClass1(this));
        if (((Boolean) k.c.getValue(null, k.a[1])).booleanValue() == false) goto L5;
        r4.c(AioLinkMessageModule.class, NativeHostServiceImpl.a.a);
    L5:
        Iterator<T> r0 = ((com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a) this.this$0.d.getValue()).Z9().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r4.f((com.lynx.tasm.behavior.a) r0.next());
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yy0.b) r1);
        return Unit.INSTANCE;
    }
}
