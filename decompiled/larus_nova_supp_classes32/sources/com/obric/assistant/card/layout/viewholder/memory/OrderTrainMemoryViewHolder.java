package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.assistant.card.utils.i;
import com.obric.assistant.card.utils.j;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/OrderTrainMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrderTrainMemoryViewHolder extends AbsCardItemScheduleStyle<OrderTrainMemoryEntity> {

    public static final class a {
    }

    static {
    }

    public OrderTrainMemoryViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r18) {
        OrderTrainMemoryEntity r0 = (OrderTrainMemoryEntity) r18;
        Intrinsics.checkNotNullParameter(r0, "entity");
        int r2 = lca.a.d;
        lca.a r3 = lca.a.C0099a.a(2131244480);
        String r4 = i.a(i.a(r0.getTrainNumber(), r0.getDeparturePlace(), ' '), r0.getDestination(), '-');
        int r5 = j.a;
        String r6 = r0.getDepartureDate();
        String r7 = r0.getDepartureTime();
        String r8 = r0.getArrivalDate();
        if (r8 != null) goto L5;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        String r9 = j.a(r6, r7, r8, r0.getArrivalTime());
        List r1 = r0.getSeatNumber();
        if (r1 == null) goto L8;
        String r10 = CollectionsKt.joinToString$default(r1, " ", null, null, 0, null, null, 62, null);
    L9:
        if (r10 != null) goto L11;
        String r11 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        return new AbsCardItemScheduleStyle.a(r3, r4, r9, r11, 2);
    L11:
        r11 = r10;
        goto L13
    L8:
        r10 = null;
        goto L9
    }
}
