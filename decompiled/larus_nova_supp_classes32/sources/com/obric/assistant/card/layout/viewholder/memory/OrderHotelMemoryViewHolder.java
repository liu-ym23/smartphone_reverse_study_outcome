package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.assistant.card.utils.j;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/OrderHotelMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrderHotelMemoryViewHolder extends AbsCardItemScheduleStyle<OrderHotelMemoryEntity> {

    public static final class a {
    }

    static {
    }

    public OrderHotelMemoryViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r9) {
        OrderHotelMemoryEntity r10 = (OrderHotelMemoryEntity) r9;
        Intrinsics.checkNotNullParameter(r10, "entity");
        int r1 = lca.a.d;
        lca.a r2 = lca.a.C0099a.a(2131244464);
        String r3 = r10.getHotelName();
        int r4 = j.a;
        String r5 = r10.getCheckInDate();
        String r6 = r10.getCheckInTime();
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
        if (r6 != null) goto L5;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        String r8 = r10.getCheckOutDate();
        if (r8 != null) goto L8;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        String r11 = r10.getCheckOutTime();
        if (r11 != null) goto L11;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        String r12 = j.a(r5, r6, r8, r11);
        String r13 = r10.getHotelAddress();
        if (r13 == null) goto L16;
        r7 = r13;
    L16:
        return new AbsCardItemScheduleStyle.a(r2, r3, r12, r7, 2);
    }
}
