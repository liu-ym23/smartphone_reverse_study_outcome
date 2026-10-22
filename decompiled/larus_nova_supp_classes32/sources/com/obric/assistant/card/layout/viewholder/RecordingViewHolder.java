package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/RecordingViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle;", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordingViewHolder extends AbsCardItemTitleSubTitleStyle<RecordingEntity> {
    public RecordingViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle
    public final AbsCardItemTitleSubTitleStyle.a a4(Object r12) {
        RecordingEntity r13 = (RecordingEntity) r12;
        Intrinsics.checkNotNullParameter(r13, "entity");
        Long r0 = Long.valueOf(r13.getLastModifiedTime());
        if (r0.longValue() <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        long r2 = r0.longValue();
    L13:
        lca.a r4 = new lca.a(2131244475, null, 6);
        String r5 = r13.getName();
        int r14 = com.obric.assistant.card.utils.j.a;
        return new AbsCardItemTitleSubTitleStyle.a(r4, r5, false, com.obric.assistant.card.utils.j.c(getContext(), r2), null, 52);
    L12:
        r2 = r13.getCreateTime();
        goto L13
    L5:
        r1 = false;
        goto L7
    }
}
