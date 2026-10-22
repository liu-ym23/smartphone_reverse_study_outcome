package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import com.bytedance.android.livesdkapi.ILiveLongPressPanelService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\b"}, d2 = {"checkLoginThenDo", "", "item", "Lcom/bytedance/android/live/base/model/longpresspanel/ItemIdentity;", "action", "Lkotlin/Function0;", "invoke", "com/bytedance/android/livesdk/dislike/LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$1$1$2", "com/bytedance/android/livesdk/dislike/LiveLongPressPanelHelper$$special$$inlined$forEach$lambda$1"}, k = 3, mv = {1, 4, 3})
final class LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$$inlined$apply$lambda$1 extends Lambda implements Function2<ItemIdentity, Function0<? extends Unit>, Unit> {
    final /* synthetic */ Map $logExtra$inlined;
    final /* synthetic */ Room $room$inlined;

    public LiveLongPressPanelHelper$getLiveFeedLongPressPanelParams$$inlined$apply$lambda$1(Room r1, Map r2) {
        this.$room$inlined = r1;
        this.$logExtra$inlined = r2;
        super(2);
    }

    public final void invoke(ItemIdentity r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r7, "action");
        ILiveLongPressPanelService r0 = jc1.k.n(ILiveLongPressPanelService.class);
        q61.b.a r8 = r6.entranceBuilder();
        Room r1 = this.$room$inlined;
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = String.valueOf(r1.getRoomId());
        if (r3 == null) goto L6;
    L7:
        r8.a("room_id_live", r3);
        Room r4 = this.$room$inlined;
        if (r4 == null) goto L13;
        String r5 = r4.getAnchorId();
        if (r5 == null) goto L13;
        r2 = r5;
    L13:
        r8.a("anchor_id_live", r2);
        Room r9 = this.$room$inlined;
        if (r9 == null) goto L17;
        String r10 = r9.isEcomCart();
        if (r10 == null) goto L17;
    L18:
        r8.a("is_ecom_live", r10);
        if (r0.needLogin(new q61.c(r8)) == true) goto L22;
        r7.invoke();
        return;
    L22:
        return;
    L17:
        r10 = "0";
    L6:
        r3 = "";
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((ItemIdentity) r1, (Function0) r2);
        return Unit.INSTANCE;
    }
}
