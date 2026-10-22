package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemClockStyle;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/CountdownViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle;", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle$StyleData;", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CountdownViewHolder extends AbsCardItemClockStyle<CountdownEntity> {
    public CountdownViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemClockStyle
    public final AbsCardItemClockStyle.a a4(MessageExtraForViewHolder r13, AppEntity r14) {
        CountdownEntity r15 = (CountdownEntity) r14;
        Intrinsics.checkNotNullParameter(r13, "messageExtra");
        Intrinsics.checkNotNullParameter(r15, "entity");
        int r16 = lca.a.d;
        lca.a r1 = lca.a.C0099a.a(2131244454);
        int r17 = com.obric.assistant.card.utils.j.a;
        long r2 = r15.getCountdownSeconds();
        long r4 = 3600;
        long r6 = r2 / r4;
        long r8 = 60;
        long r5 = (r2 % r4) / r8;
        long r3 = r2 % r8;
        boolean r18 = true;
        if (r6 <= 0) goto L5;
        StringCompanionObject r9 = StringCompanionObject.INSTANCE;
        String r7 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r6), Long.valueOf(r5), Long.valueOf(r3)}, 3));
    L6:
        String r19 = r15.getLabel();
        if (r19 != null) goto L10;
        r19 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        if (r19.length() == 0) goto L13;
        r18 = false;
    L13:
        if (r18 == false) goto L15;
        String r10 = getContext().getString(2131912193);
    L17:
        return new AbsCardItemClockStyle.a(r1, r7, r10, NameKeys.UnloadStrategy_No_Strategy, false);
    L15:
        r10 = r19;
        goto L17
    L5:
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        r7 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r5), Long.valueOf(r3)}, 2));
        goto L6
    }
}
