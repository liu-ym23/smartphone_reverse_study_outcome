package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/CallHistoryViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle;", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CallHistoryViewHolder extends AbsCardItemTitleSubTitleStyle<CallHistoryEntity> {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CallTypeEnum.values().length];
            r0[CallTypeEnum.OUTGOING_CALL_ANSWERED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CallTypeEnum.OUTGOING_CALL_MISSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CallTypeEnum.INCOMING_CALL_ANSWERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CallTypeEnum.INCOMING_CALL_MISSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public CallHistoryViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle
    public final AbsCardItemTitleSubTitleStyle.a a4(Object r23) {
        CallHistoryEntity r0 = (CallHistoryEntity) r23;
        Intrinsics.checkNotNullParameter(r0, "entity");
        List r1 = r0.getContacts();
        String r2 = null;
        if (r1 == null) goto L5;
        ContactEntity r3 = (ContactEntity) CollectionsKt.firstOrNull(r1);
    L6:
        boolean r4 = false;
        String r5 = (String) CollectionsKt.getOrNull(r0.getTelephones(), 0);
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
        if (r5 != null) goto L9;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        if (r3 == null) goto L11;
        String r7 = r3.getName();
    L12:
        if (r7 != null) goto L15;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        if (r7.length() <= 0) goto L17;
        boolean r8 = true;
    L18:
        if (r3 == null) goto L31;
        List r9 = r3.getTelephones();
        if (r9 == null) goto L31;
        Iterator r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L27;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((MetaTelephone) r11).getTelephone(), r5) == false) goto L23;
    L28:
        MetaTelephone r12 = (MetaTelephone) r11;
        if (r12 == null) goto L31;
        String r13 = r12.getContactType();
    L32:
        int r14 = a.a[r0.getCallType().ordinal()];
        if (r14 != 1) goto L35;
    L44:
        int r15 = 2131244474;
    L45:
        lca.a r16 = new lca.a(Integer.valueOf(r15), null, 6);
        if (r8 == false) goto L48;
        String r17 = r7;
    L50:
        if (r0.getCallType() != CallTypeEnum.INCOMING_CALL_MISSED) goto L52;
        boolean r18 = true;
    L53:
        if (r13 != null) goto L55;
    L58:
        boolean r19 = true;
    L59:
        if (r19 == false) goto L72;
        List r20 = r0.getCarriers();
        if (r20 == null) goto L63;
        r2 = CollectionsKt.joinToString$default(r20, "、", null, null, 0, null, null, 62, null);
    L63:
        if (r2 == null) goto L67;
        r6 = r2;
    L67:
        if (r6.length() != 0) goto L69;
        r4 = true;
    L69:
        if (r4 == false) goto L71;
        r13 = getContext().getString(2131912640);
        goto L72
    L71:
        String r110 = r6;
    L73:
        int r21 = com.obric.assistant.card.utils.j.a;
        return new AbsCardItemTitleSubTitleStyle.a(r16, r17, r18, r110, com.obric.assistant.card.utils.j.c(((RecyclerView.ViewHolder) this).itemView.getContext(), r0.getCreateTime()), 16);
    L72:
        r110 = r13;
        goto L73
    L55:
        if (r13.length() == 0) goto L58;
        r19 = false;
        goto L59
    L52:
        r18 = false;
        goto L53
    L48:
        r17 = r5;
        goto L50
    L35:
        if (r14 == 2) goto L44;
        if (r14 != 3) goto L39;
        r15 = 2131244472;
        goto L45
    L39:
        if (r14 != 4) goto L42;
        r15 = 2131244473;
        goto L45
    L42:
        throw new NoWhenBranchMatchedException();
    L27:
        r11 = null;
    L31:
        r13 = null;
        goto L32
    L17:
        r8 = false;
        goto L18
    L11:
        r7 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
