package com.larus.bmhome.chat.adapter;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.list.cell.text.TextCellCutType;
import com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterListUpdateCallback;
import com.larus.mainbot.api.IFlowMainBot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/chat/adapter/MessageAdapterListUpdateCallback;", "Lcom/larus/bmhome/chat/list/datasource/adapter/PagingAdapterListUpdateCallback;", "messageAdapter", "Lcom/larus/bmhome/chat/adapter/MessageAdapter;", "<init>", "(Lcom/larus/bmhome/chat/adapter/MessageAdapter;)V", "onChanged", "", "position", "", "count", "payload", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageAdapterListUpdateCallback extends PagingAdapterListUpdateCallback {
    public final MessageAdapter b;

    public MessageAdapterListUpdateCallback(MessageAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "messageAdapter");
        super(r2);
        this.b = r2;
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterListUpdateCallback
    public final void onChanged(int r3, int r4, Object r5) {
        TextCellCutType.Companion.getClass();     // Catch: Exception -> L10
        if (TextCellCutType.NewTextCell == TextCellCutType.DeepThinkCutMultipleCell) goto L5;
        super.onChanged(r3, r4, r5);     // Catch: Exception -> L10
    L12:
        return;
    L5:
        if (IFlowMainBot.a.r8(this.b, r3, r4, r5) == false) goto L7;
        a();     // Catch: Exception -> L10
        goto L12
    L7:
        super.onChanged(r3, r4, r5);     // Catch: Exception -> L10
    L10:
        super.onChanged(r3, r4, r5);
    }
}
