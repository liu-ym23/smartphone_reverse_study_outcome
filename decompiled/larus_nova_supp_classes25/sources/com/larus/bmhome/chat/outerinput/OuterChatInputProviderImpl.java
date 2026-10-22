package com.larus.bmhome.chat.outerinput;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/outerinput/OuterChatInputProviderImpl;", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputProvider;", "<init>", "()V", "providerController", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "tabPage", "Landroidx/fragment/app/Fragment;", "tabKey", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class OuterChatInputProviderImpl implements IOuterChatInputProvider {
    public OuterChatInputProviderImpl() {
    }

    @Override // com.larus.bmhome.chat.outerinput.IOuterChatInputProvider
    public final c a(Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tabPage");
        Intrinsics.checkNotNullParameter(r3, "tabKey");
        return new OuterChatInputController(r2, r3);
    }
}
