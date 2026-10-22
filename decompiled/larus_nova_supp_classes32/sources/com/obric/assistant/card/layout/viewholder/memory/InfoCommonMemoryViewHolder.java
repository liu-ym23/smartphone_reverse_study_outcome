package com.obric.assistant.card.layout.viewholder.memory;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lca.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/memory/InfoCommonMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InfoCommonMemoryViewHolder extends AbsCardItemTitleContentStyle<InfoCommonMemoryEntity> {
    public InfoCommonMemoryViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r6) {
        InfoCommonMemoryEntity r7 = (InfoCommonMemoryEntity) r6;
        Intrinsics.checkNotNullParameter(r7, "entity");
        String r0 = r7.getInfoKey();
        switch(r0.hashCode()) {
            case 678376: goto L18;
            case 714256: goto L14;
            case 1129301: goto L10;
            case 31948986: goto L6;
            default: goto L21;
        };
    L21:
        int r1 = 2131244467;
    L23:
        return new AbsCardItemTitleContentStyle.a(new a(Integer.valueOf(r1), null, 6), r7.getInfoValue(), r7.getInfoKey(), 18);
    L6:
        if (r0.equals("纪念日") == false) goto L21;
        r1 = 2131244443;
        goto L23
    L10:
        if (r0.equals("证件") == false) goto L21;
        r1 = 2131244465;
        goto L23
    L14:
        if (r0.equals("地址") == false) goto L21;
        r1 = 2131244442;
        goto L23
    L18:
        if (r0.equals("关系") == false) goto L21;
        r1 = 2131244476;
        goto L23
    }
}
