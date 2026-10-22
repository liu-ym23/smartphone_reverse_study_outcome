package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle;
import com.obric.assistant.card.utils.i;
import com.obric.assistant.card.utils.j;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/EventTodoMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventTodoMemoryViewHolder extends AbsCardItemScheduleStyle<EventTodoMemoryEntity> {
    public EventTodoMemoryViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemScheduleStyle
    public final AbsCardItemScheduleStyle.a a4(Object r8) {
        EventTodoMemoryEntity r9 = (EventTodoMemoryEntity) r8;
        Intrinsics.checkNotNullParameter(r9, "entity");
        int r0 = a.d;
        a r2 = a.C0099a.a(2131244479);
        String r3 = r9.getContent();
        String r1 = r9.getEndDate();
        if (r1 == null) goto L5;
        String r4 = j.f(r1);
    L6:
        String r10 = i.a(r4, r9.getEndTime(), ' ');
        if (r10.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        String r11 = getContext().getString(2131912069, new Object[]{r10});
    L14:
        return new AbsCardItemScheduleStyle.a(r2, r3, r11, null, 18);
    L12:
        r11 = NameKeys.UnloadStrategy_No_Strategy;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
