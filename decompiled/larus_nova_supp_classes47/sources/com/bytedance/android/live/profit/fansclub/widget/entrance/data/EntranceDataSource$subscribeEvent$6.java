package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import com.bytedance.android.anya.p;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import eu0.c0;
import eu0.x;
import j40.k0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"updateFollow", "", "r", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "invoke"}, k = 3, mv = {1, 4, 3})
final class EntranceDataSource$subscribeEvent$6 extends Lambda implements Function1<IRoom, Unit> {
    final /* synthetic */ i this$0;

    public EntranceDataSource$subscribeEvent$6(i r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(IRoom r5) {
        Intrinsics.checkNotNullParameter(r5, "r");
        if (((Boolean) k0.a.getValue()).booleanValue() == false) goto L7;
        if (this.this$0.A() == false) goto L7;
        return;
    L7:
        if (this.this$0.A() == false) goto L10;
        return;
    L10:
        if (com.bytedance.android.live.profit.fansclub.i.c() == false) goto L13;
        vh6.c.b(br2.a.class).Cc(r5.getOwner(), "EntranceDataSource-subscribeEvent", r5, new AnonymousClass1(this));
        return;
    L13:
        if (this.this$0.A() == false) goto L15;
        return;
    L15:
        boolean r6 = vh6.c.b(br2.a.class).Tg(r5.getOwner(), r5);
        EntranceMVIFacade r0 = fu0.b.b(i.a(this.this$0));
        if (r0 == null) goto L24;
        if (r6 == false) goto L19;
        p r7 = new x(i.a(this.this$0));
    L20:
        r0.a(r7);
        return;
    L19:
        r7 = new c0(i.a(this.this$0));
        goto L20
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IRoom) r1);
        return Unit.INSTANCE;
    }
}
