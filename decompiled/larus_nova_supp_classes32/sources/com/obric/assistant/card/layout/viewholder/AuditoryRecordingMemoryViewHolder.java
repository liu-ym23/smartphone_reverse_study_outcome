package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/AuditoryRecordingMemoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuditoryRecordingMemoryViewHolder extends AbsCardItemTitleContentStyle<AuditoryRecordingEntity> {
    public AuditoryRecordingMemoryViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r7) {
        AuditoryRecordingEntity r8 = (AuditoryRecordingEntity) r7;
        Intrinsics.checkNotNullParameter(r8, "entity");
        lca.a r1 = new lca.a(2131244467, null, 6);
        String r2 = r8.getName();
        int r3 = com.obric.assistant.card.utils.j.a;
        return new AbsCardItemTitleContentStyle.a(r1, r2, com.obric.assistant.card.utils.j.c(((RecyclerView.ViewHolder) this).itemView.getContext(), r8.getCreateTime()), 18);
    }
}
