package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/CollectStoreMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectStoreMemoryViewHolder extends AbsCardItemTitleContentStyle<CollectStoreMemoryEntity> {
    public CollectStoreMemoryViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r5) {
        CollectStoreMemoryEntity r6 = (CollectStoreMemoryEntity) r5;
        Intrinsics.checkNotNullParameter(r6, "entity");
        a r0 = new a(2131244453, null, 6);
        String r1 = r6.getStoreName();
        String r7 = r6.getAddress();
        if (r7 != null) goto L6;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        if (r7.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        r7 = getContext().getString(2131912246);
    L12:
        return new AbsCardItemTitleContentStyle.a(r0, r1, r7, 18);
    L8:
        r2 = false;
        goto L9
    }
}
