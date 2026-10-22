package com.obric.assistant.card.layout.viewholder;

import android.view.ViewGroup;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle;
import com.obric.capabilitykit.entity.app.FileEntity;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/FileViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle;", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle$StyleData;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileViewHolder extends AbsCardItemTitleSubTitleStyle<FileEntity> {
    public FileViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2);
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemTitleSubTitleStyle
    public final AbsCardItemTitleSubTitleStyle.a a4(Object r11) {
        FileEntity r12 = (FileEntity) r11;
        Intrinsics.checkNotNullParameter(r12, "entity");
        String r0 = r12.getMimeType();
        if (r0 == null) goto L5;
        String r1 = r0.toLowerCase();
    L7:
        if (CollectionsKt.contains(SetsKt.setOf("application/pdf"), r1) == false) goto L10;
        int r2 = 2131244458;
    L22:
        lca.a r3 = new lca.a(Integer.valueOf(r2), null, 6);
        String r4 = r12.getFileName();
        int r5 = com.obric.assistant.card.utils.j.a;
        return new AbsCardItemTitleSubTitleStyle.a(r3, r4, false, com.obric.assistant.card.utils.j.c(getContext(), r12.getLastModifiedTime()), null, 52);
    L10:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"}), r1) == false) goto L13;
        r2 = 2131244457;
        goto L22
    L13:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"}), r1) == false) goto L16;
        r2 = 2131244462;
        goto L22
    L16:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation"}), r1) == false) goto L19;
        r2 = 2131244459;
        goto L22
    L19:
        if (CollectionsKt.contains(SetsKt.setOf("text/plain"), r1) == false) goto L21;
        r2 = 2131244460;
        goto L22
    L21:
        r2 = 2131244461;
        goto L22
    L5:
        r1 = null;
        goto L7
    }
}
