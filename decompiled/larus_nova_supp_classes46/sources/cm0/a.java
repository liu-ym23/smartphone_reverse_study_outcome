package cm0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.messagewindow.builder.card.CardMountingsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements u61.a {
    public com.bytedance.android.live.room.api.messagewindow.builder.card.a a;

    public a() {
    }

    public final dm0.a b() {
        com.bytedance.android.live.room.api.messagewindow.builder.card.a r0 = this.a;
        if (r0 != null) goto L10;
        IllegalStateException r1 = new IllegalStateException("you must call assemble() method before build()");
        i r2 = k.n(IMiddlewareMsgWindowService.class).cardMonitor();
        if (r2 == null) goto L11;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
        Intrinsics.checkNotNullParameter(r1, "tr");
        r3.a = r1;
        Unit r4 = Unit.INSTANCE;
        r2.d(r3.b());
        throw r1;
    L11:
        throw r1;
    L10:
        return new dm0.a(r0);
    }

    public final a a(Function1 r13) {
        Intrinsics.checkNotNullParameter(r13, "init");
        CardMountingsBuilder r0 = new CardMountingsBuilder();
        r13.invoke(r0);
        if (Intrinsics.areEqual(r0.c, CardMountingsBuilder.c.a) == false) goto L5;
    L6:
        Intrinsics.checkNotNullParameter("the identity or priority must be not null, you can call initCard() method to init", "msg");
        Intrinsics.checkNotNullParameter("the identity or priority must be not null, you can call initCard() method to init", "msg");
        IllegalArgumentException r1 = new IllegalArgumentException("the identity or priority must be not null, you can call initCard() method to init");
        ALogger.e("ICardBuildCheck", r1);
        if (v.a() == true) goto L10;
    L8:
        this.a = new com.bytedance.android.live.room.api.messagewindow.builder.card.a(r0.a, r0.c, r0.d, r0.b, r0.e, r0.f, r0.g, r0.h, r0.i);
        return this;
    L10:
        throw r1;
    L5:
        if (r0.d != Integer.MIN_VALUE) goto L8;
        goto L6
    }
}
