package com.obric.assistant.card.layout.viewholder;

import android.net.Uri;
import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleDropdownListStyle;
import com.obric.assistant.card.provider.PrivilegedUriProvider;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/VirtualContactViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleDropdownListStyle;", "Lcom/obric/assistant/card/layout/bean/wrapper/VirtualContactEntityWrapper;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleDropdownListStyle$StyleData;", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entityWrapper", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VirtualContactViewHolder extends AbsCardItemTitleDropdownListStyle<mca.e> {
    public VirtualContactViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleDropdownListStyle
    public final AbsCardItemTitleDropdownListStyle.b a4(MessageExtraForViewHolder r14, Object r15) {
        mca.e r16 = (mca.e) r15;
        Intrinsics.checkNotNullParameter(r14, "messageExtra");
        Intrinsics.checkNotNullParameter(r16, "entityWrapper");
        ContactEntity r0 = (ContactEntity) r16.a;
        FileEntity r3 = r0.getAvatar();
        boolean r4 = false;
        List r5 = null;
        if (r3 == null) goto L7;
        Uri r6 = r3.getContentUrl();
        if (r6 == null) goto L7;
        int r7 = PrivilegedUriProvider.b;
        Uri r8 = PrivilegedUriProvider.a.a(r6, r0.getPackageName(), false, false);
    L8:
        lca.a r1 = new lca.a(2131244449, r8, 4);
        String r2 = r0.getName();
        if (r2.length() != 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == false) goto L29;
        r2 = r0.getNote();
        if (r2 != null) goto L16;
    L17:
        r4 = true;
    L18:
        if (r4 == false) goto L21;
        r2 = null;
    L21:
        if (r2 != null) goto L29;
        List r10 = r0.getTelephones();
        if (r10 == null) goto L27;
        MetaTelephone r11 = (MetaTelephone) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L27;
        r2 = r11.getTelephone();
    L27:
        r2 = null;
        goto L29
    L16:
        if (r2.length() != 0) goto L18;
    L29:
        if (r2 != null) goto L31;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L31:
        int r17 = r16.b;
        List r12 = r0.getTelephones();
        if (r12 == null) goto L50;
        List r13 = r12;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r19 = r13.iterator();
    L35:
        if (r19.hasNext() == false) goto L49;
        MetaTelephone r20 = (MetaTelephone) r19.next();
        if (Intrinsics.areEqual(r14.c, "Phone_Call") == false) goto L39;
        lca.a r21 = new lca.a(2131244322, null, 6);
    L40:
        String r110 = com.obric.assistant.card.utils.i.a(r20.getContactType(), r20.getTelephone(), ' ');
        MetaTelephone r111 = r0.getLastUsedTelephone();
        if (r111 == null) goto L43;
        String r112 = r111.getTelephone();
    L45:
        if (Intrinsics.areEqual(r112, r20.getTelephone()) == false) goto L47;
        String r113 = getContext().getString(2131912382);
    L48:
        Intrinsics.checkNotNull(r113);
        r18.add(new AbsCardItemTitleDropdownListStyle.a(r21, r110, r113, r20.getTelephone()));
        goto L35
    L47:
        r113 = NameKeys.UnloadStrategy_No_Strategy;
        goto L48
    L43:
        r112 = null;
        goto L45
    L39:
        r21 = null;
        goto L40
    L49:
        r5 = CollectionsKt.toList(r18);
    L50:
        if (r5 != null) goto L53;
        r5 = CollectionsKt.emptyList();
    L53:
        return new AbsCardItemTitleDropdownListStyle.b(r1, r2, r17, r5);
    L11:
        r9 = false;
    L7:
        r8 = null;
        goto L8
    }
}
