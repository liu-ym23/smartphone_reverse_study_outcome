package com.larus.bmhome.chat.cotdetail.list;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import ie8.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/list/ThreadMsgCellStateDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/bmhome/chat/cotdetail/list/cellstate/base/ThreadMsgCellState;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "messageSame", "Lcom/larus/im/bean/message/Message;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ThreadMsgCellStateDiffCallback extends DiffUtil.ItemCallback<a> {
    public ThreadMsgCellStateDiffCallback() {
    }

    public final boolean areContentsTheSame(Object r6, Object r7) {
        a r8 = (a) r6;
        a r9 = (a) r7;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        Message r10 = r8.a;
        Message r11 = r9.a;
        if (r10.getContentType() == r11.getContentType()) goto L5;
    L36:
        return false;
    L5:
        if (Intrinsics.areEqual(r10.getContentBlock(), r11.getContentBlock()) == false) goto L36;
        if (r10.getMessageStatus() != r11.getMessageStatus()) goto L36;
        if (r10.getMessageStatusLocal() != r11.getMessageStatusLocal()) goto L36;
        if (r10.getLocalIndex() != r11.getLocalIndex()) goto L36;
        if (r10.getServerIndex() != r11.getServerIndex()) goto L36;
        if (Intrinsics.areEqual(r10.getFeedback(), r11.getFeedback()) == false) goto L36;
        if (Intrinsics.areEqual(r10.getSectionId(), r11.getSectionId()) == false) goto L36;
        if (r11.getContentType() != 2) goto L30;
        List r0 = r10.getSuggestQuestions();
        Integer r1 = null;
        if (r0 == null) goto L23;
        Integer r2 = Integer.valueOf(r0.size());
    L24:
        List r3 = r11.getSuggestQuestions();
        if (r3 == null) goto L28;
        r1 = Integer.valueOf(r3.size());
    L28:
        if (Intrinsics.areEqual(r2, r1) == false) goto L36;
    L23:
        r2 = null;
    L30:
        if (Intrinsics.areEqual(r10.getBusinessExt(), r11.getBusinessExt()) == false) goto L36;
        if (Intrinsics.areEqual(r10.getSectionName(), r11.getSectionName()) == false) goto L36;
        if (Intrinsics.areEqual(r10.getExt(), r11.getExt()) == false) goto L36;
        return true;
    }

    public final boolean areItemsTheSame(Object r3, Object r4) {
        a r5 = (a) r3;
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "oldItem");
        Intrinsics.checkNotNullParameter(r6, "newItem");
        if (Intrinsics.areEqual(r5.getClass(), r6.getClass()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.a.getMessageId(), r6.a.getMessageId()) == false) goto L7;
        return true;
    }
}
