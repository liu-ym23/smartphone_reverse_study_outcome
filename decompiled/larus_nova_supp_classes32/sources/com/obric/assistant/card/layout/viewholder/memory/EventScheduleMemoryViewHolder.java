package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.assistant.card.utils.i;
import com.obric.assistant.card.utils.j;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/EventScheduleMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/memory/EventScheduleMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventScheduleMemoryViewHolder extends AbsCardItemScheduleStyle<EventScheduleMemoryEntity> {
    public EventScheduleMemoryViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r9) {
        EventScheduleMemoryEntity r10 = (EventScheduleMemoryEntity) r9;
        Intrinsics.checkNotNullParameter(r10, "entity");
        String r0 = r10.getEndDate();
        int r1 = a.d;
        a r2 = a.C0099a.a(2131244477);
        String r3 = r10.getScheduleNme();
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L15:
        int r5 = j.a;
        String r6 = i.a(i.a(j.f(r10.getDate()), r10.getStartTime(), ' '), r10.getEndTime(), '-');
    L16:
        String r7 = r6;
        String r11 = r10.getAddress();
        if (r11 != null) goto L20;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L20:
        return new AbsCardItemScheduleStyle.a(r2, r3, r7, r11, 2);
    L12:
        if (Intrinsics.areEqual(r0, r10.getDate()) == true) goto L15;
        int r8 = j.a;
        r6 = i.a(i.a(j.f(r10.getDate()), r10.getStartTime(), ' '), i.a(j.f(r0), r10.getEndTime(), ' '), '-');
        goto L16
    L5:
        if (r0.length() == 0) goto L8;
        r4 = false;
        goto L10
    }
}
