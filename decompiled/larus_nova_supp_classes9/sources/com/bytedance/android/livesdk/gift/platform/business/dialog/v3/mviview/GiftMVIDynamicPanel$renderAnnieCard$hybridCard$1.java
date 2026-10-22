package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.bdlocation.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/b;", BuildConfig.FLAVOR, "invoke", "(Lyy0/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class GiftMVIDynamicPanel$renderAnnieCard$hybridCard$1 extends Lambda implements Function1<yy0.b, Unit> {
    final /* synthetic */ GiftMVIDynamicPanel this$0;

    public GiftMVIDynamicPanel$renderAnnieCard$hybridCard$1(GiftMVIDynamicPanel r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(yy0.b r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.d(new AnonymousClass1(this));
        ca0.e r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ca0.e.class);
        if (r0 == null) goto L10;
        List r1 = r0.getBehaviorList();
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        r3.f((com.lynx.tasm.behavior.a) r2.next());
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yy0.b) r1);
        return Unit.INSTANCE;
    }
}
