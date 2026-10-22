package com.obric.assistant.card.layout.viewholder;

import android.net.Uri;
import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleListStyle;
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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/ContactViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleListStyle;", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleListStyle$StyleData;", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContactViewHolder extends AbsCardItemTitleSubTitleListStyle<ContactEntity> {
    public ContactViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.ArrayList] */
    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleListStyle
    public final AbsCardItemTitleSubTitleListStyle.a a4(MessageExtraForViewHolder r12, Object r13) {
        ContactEntity r14 = (ContactEntity) r13;
        Intrinsics.checkNotNullParameter(r12, "messageExtra");
        Intrinsics.checkNotNullParameter(r14, "entity");
        FileEntity r1 = r14.getAvatar();
        String r4 = null;
        if (r1 == null) goto L7;
        Uri r2 = r1.getContentUrl();
        if (r2 == null) goto L7;
        int r5 = PrivilegedUriProvider.b;
        Uri r3 = PrivilegedUriProvider.a.a(r2, r14.getPackageName(), false, false);
    L8:
        lca.a r6 = new lca.a(2131244449, r3, 4);
        String r0 = r14.getName();
        if (r0 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
        String r8 = r14.getName();
    L35:
        if (r8 != null) goto L37;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L37:
        List r9 = r14.getTelephones();
        if (r9 == null) goto L52;
        List r10 = r9;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r15 = r10.iterator();
    L41:
        if (r15.hasNext() == false) goto L43;
        MetaTelephone r16 = (MetaTelephone) r15.next();
        r11.add(com.obric.assistant.card.utils.i.a(r16.getContactType(), r16.getTelephone(), ' '));
        goto L41
    L43:
        ?? r17 = new ArrayList();
        Iterator r18 = r11.iterator();
    L45:
        if (r18.hasNext() == false) goto L53;
        Object r19 = r18.next();
        if (((String) r19).length() <= 0) goto L49;
        boolean r20 = true;
    L50:
        if (r20 == false) goto L45;
        r17.add(r19);
        goto L45
    L49:
        r20 = false;
    L53:
        if (r17 != 0) goto L56;
        r17 = CollectionsKt.emptyList();
    L56:
        if (Intrinsics.areEqual(r12.c, "Phone_Call") == false) goto L58;
        lca.a r110 = new lca.a(2131244322, null, 6);
    L59:
        List r111 = r14.getTelephones();
        if (r111 == null) goto L64;
        MetaTelephone r112 = (MetaTelephone) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L64;
        r4 = r112.getTelephone();
    L64:
        if (r4 != null) goto L66;
        String r113 = NameKeys.UnloadStrategy_No_Strategy;
    L68:
        return new AbsCardItemTitleSubTitleListStyle.a(r6, r8, r17, r110, r113);
    L66:
        r113 = r4;
        goto L68
    L58:
        r110 = null;
        goto L59
    L52:
        r17 = 0;
        goto L53
    L17:
        r8 = r14.getNote();
        if (r8 != null) goto L20;
    L23:
        boolean r21 = true;
    L24:
        if (r21 == false) goto L27;
        r8 = null;
    L27:
        if (r8 != null) goto L35;
        List r22 = r14.getTelephones();
        if (r22 == null) goto L33;
        MetaTelephone r23 = (MetaTelephone) CollectionsKt.firstOrNull(r22);
        if (r23 == null) goto L33;
        r8 = r23.getTelephone();
    L33:
        r8 = null;
        goto L35
    L20:
        if (r8.length() == 0) goto L23;
        r21 = false;
        goto L24
    L11:
        if (r0.length() == 0) goto L14;
        r7 = false;
    L7:
        r3 = null;
        goto L8
    }
}
