package com.obric.assistant.card.layout.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemRemoteCardBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemBaseStyle;
import com.obric.assistant.remote_card_container.widget.RemoteCardContainer;
import com.obric.capabilitykit.common.CardProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/RemoteCardViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/capabilitykit/common/CardProvider;", "Lcom/obric/assistant/card/databinding/ObricCardItemRemoteCardBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteCardViewHolder extends AbsCardItemBaseStyle<CardProvider, ObricCardItemRemoteCardBinding> {

    public static final class a {
    }

    static {
    }

    public RemoteCardViewHolder(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        RemoteCardContainer r5 = LayoutInflater.from(r4.getContext()).inflate(2131563954, r4, false);
        if (r5 == null) goto L7;
        RemoteCardContainer r6 = r5;
        super(new ObricCardItemRemoteCardBinding(r6, r6));
        return;
    L7:
        throw new NullPointerException("rootView");
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r3, Object r4, int r5, boolean r6, boolean r7) {
        CardProvider r8 = (CardProvider) r4;
        Intrinsics.checkNotNullParameter(r3, "messageExtra");
        Intrinsics.checkNotNullParameter(r8, "entity");
        FLogger.a.i("RemoteCardViewHolder", "onBind: messageExtra = " + r3 + ", position = " + r5);
        RemoteCardContainer r9 = ((ObricCardItemRemoteCardBinding) this.a).b;
        String r10 = r8.getCardUri();
        if (r10 != null) goto L5;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        String r11 = r3.e;
        String r0 = r8.getExtraParams();
        Integer r12 = r8.getViewHeight();
        if (r12 == null) goto L8;
        int r13 = r12.intValue();
    L9:
        r9.b(new com.obric.assistant.remote_card_container.widget.a(r10, r11, r0, RangesKt.coerceAtLeast(r13, 0)));
        return;
    L8:
        r13 = 0;
        goto L9
    }
}
