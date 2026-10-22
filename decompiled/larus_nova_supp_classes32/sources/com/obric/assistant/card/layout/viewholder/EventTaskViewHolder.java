package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemEventTaskStyle;
import com.obric.capabilitykit.entity.app.EventTaskEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/EventTaskViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle;", "Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemEventTaskStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventTaskViewHolder extends AbsCardItemEventTaskStyle<EventTaskEntity> {

    public static final class a {
    }

    static {
    }

    public EventTaskViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemEventTaskStyle
    public final AbsCardItemEventTaskStyle.a a4(Object r8) {
        EventTaskEntity r9 = (EventTaskEntity) r8;
        Intrinsics.checkNotNullParameter(r9, "entity");
        return new AbsCardItemEventTaskStyle.a(r9.getConditionString(), r9.getTaskQuery(), r9.getPeriodString(), AbsCardItemEventTaskStyle.b4(r9, "o_semantic_icon_key"), AbsCardItemEventTaskStyle.b4(r9, "o_semantic_icon_color_key"));
    }
}
