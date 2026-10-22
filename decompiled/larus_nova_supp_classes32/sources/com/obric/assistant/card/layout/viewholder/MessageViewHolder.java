package com.obric.assistant.card.layout.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle;
import com.obric.assistant.card.provider.PrivilegedUriProvider;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/MessageViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageViewHolder extends AbsCardItemTitleContentStyle<MessageEntity> {
    public static final /* synthetic */ int l = 0;

    public MessageViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleContentStyle
    public final AbsCardItemTitleContentStyle.a a4(Object r15) {
        MessageEntity r16 = (MessageEntity) r15;
        Intrinsics.checkNotNullParameter(r16, "entity");
        List r1 = r16.getContacts();
        boolean r3 = false;
        String r4 = null;
        if (r1 == null) goto L11;
        ContactEntity r2 = (ContactEntity) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L11;
        FileEntity r5 = r2.getAvatar();
        if (r5 == null) goto L11;
        Uri r6 = r5.getContentUrl();
        if (r6 == null) goto L11;
        int r7 = PrivilegedUriProvider.b;
        Uri r8 = PrivilegedUriProvider.a.a(r6, r16.getPackageName(), false, false);
    L12:
        lca.a r9 = new lca.a(2131244449, r8, 4);
        List r10 = r16.getContacts();
        if (r10 == null) goto L15;
        String r11 = CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, new i(), 30, null);
    L16:
        if (r11 != null) goto L18;
    L19:
        r3 = true;
    L20:
        if (r3 == false) goto L26;
        List r12 = r16.getTelephones();
        if (r12 == null) goto L24;
        r4 = CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, null, 62, null);
    L24:
        if (r4 != null) goto L27;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L27:
        String r13 = r16.getText();
        int r14 = com.obric.assistant.card.utils.j.a;
        Context r17 = getContext();
        if (r16.getCreateTime() <= 0) goto L30;
        long r18 = r16.getCreateTime();
    L32:
        return new AbsCardItemTitleContentStyle.a(r9, 2131244508, r4, r13, com.obric.assistant.card.utils.j.c(r17, r18));
    L30:
        r18 = r16.getLastModifiedTime();
    L26:
        r4 = r11;
        goto L27
    L18:
        if (r11.length() != 0) goto L20;
    L15:
        r11 = null;
    L11:
        r8 = null;
        goto L12
    }
}
