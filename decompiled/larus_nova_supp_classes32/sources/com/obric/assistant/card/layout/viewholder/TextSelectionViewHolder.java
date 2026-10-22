package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.obric.aiagent.assistant.idl.bean.TextEntity;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemIconTextStyle;
import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/TextSelectionViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconTextStyle;", "Lcom/obric/aiagent/assistant/idl/bean/TextEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconTextStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextSelectionViewHolder extends AbsCardItemIconTextStyle<TextEntity> {
    public TextSelectionViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemIconTextStyle
    public final AbsCardItemIconTextStyle.a a4(AppEntity r3) {
        TextEntity r4 = (TextEntity) r3;
        Intrinsics.checkNotNullParameter(r4, "entity");
        int r1 = lca.a.d;
        return new AbsCardItemIconTextStyle.a(lca.a.C0099a.a(2131244467), r4.getText());
    }
}
