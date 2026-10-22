package com.larus.chat.search.impl.chat.section;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.api.model.SectionViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/chat/search/impl/chat/section/SectionItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/chat/search/api/model/SectionItemData;", "<init>", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SectionItemCallback extends DiffUtil.ItemCallback<SectionItemData> {
    public SectionItemCallback() {
    }

    public final boolean areContentsTheSame(Object r6, Object r7) {
        SectionItemData r8 = (SectionItemData) r6;
        SectionItemData r9 = (SectionItemData) r7;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        if (r8.getCreateTime() == r9.getCreateTime()) goto L5;
    L23:
        return false;
    L5:
        if (Intrinsics.areEqual(r8.getSectionId(), r9.getSectionId()) == false) goto L23;
        if (Intrinsics.areEqual(r8.getConversationId(), r9.getConversationId()) == false) goto L23;
        if (Intrinsics.areEqual(r8.getSectionName(), r9.getSectionName()) == false) goto L23;
        if (r8.getViewType() != r9.getViewType()) goto L23;
        if (r8.getLocalIndex() != r9.getLocalIndex()) goto L23;
        if (Intrinsics.areEqual(r8.getMessageId(), r9.getMessageId()) == false) goto L23;
        if (r8.isSectionName() != r9.isSectionName()) goto L23;
        if (Intrinsics.areEqual(r8.getUrl(), r9.getUrl()) == false) goto L23;
        if (r8.getUnreadCount() != r9.getUnreadCount()) goto L23;
        return true;
    }

    public final boolean areItemsTheSame(Object r6, Object r7) {
        SectionItemData r8 = (SectionItemData) r6;
        SectionItemData r9 = (SectionItemData) r7;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        if (r8.getViewType() == r9.getViewType()) goto L6;
        return false;
    L6:
        if (r8.getViewType() == SectionViewType.TIME) goto L63;
        String r0 = r8.getConversationId();
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == true) goto L25;
        String r2 = r9.getConversationId();
        if (r2 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == true) goto L25;
        return Intrinsics.areEqual(r8.getConversationId(), r9.getConversationId());
    L19:
        if (r2.length() == 0) goto L22;
        r3 = false;
    L25:
        String r4 = r8.getMessageId();
        if (r4 != null) goto L28;
    L31:
        boolean r5 = true;
    L32:
        if (r5 == true) goto L42;
        String r10 = r9.getMessageId();
        if (r10 != null) goto L36;
    L39:
        boolean r11 = true;
    L40:
        if (r11 == true) goto L42;
        return Intrinsics.areEqual(r8.getMessageId(), r9.getMessageId());
    L36:
        if (r10.length() == 0) goto L39;
        r11 = false;
    L42:
        String r12 = r8.getSectionId();
        if (r12 != null) goto L45;
    L48:
        boolean r13 = true;
    L49:
        if (r13 == true) goto L60;
        String r14 = r9.getSectionId();
        if (r14 != null) goto L53;
    L56:
        boolean r15 = true;
    L57:
        if (r15 == true) goto L60;
        return Intrinsics.areEqual(r8.getSectionId(), r9.getSectionId());
    L53:
        if (r14.length() == 0) goto L56;
        r15 = false;
    L60:
        if (r8.getCreateTime() != r9.getCreateTime()) goto L67;
        return true;
    L67:
        return false;
    L45:
        if (r12.length() == 0) goto L48;
        r13 = false;
        goto L49
    L28:
        if (r4.length() == 0) goto L31;
        r5 = false;
        goto L32
    L11:
        if (r0.length() == 0) goto L14;
        r1 = false;
        goto L15
    L63:
        return Intrinsics.areEqual(r8.getSectionId(), r9.getSectionId());
    }
}
