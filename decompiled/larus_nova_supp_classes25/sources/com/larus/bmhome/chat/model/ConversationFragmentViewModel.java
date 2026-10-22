package com.larus.bmhome.chat.model;

import androidx.lifecycle.ViewModel;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/model/ConversationFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "needConversationRequest", "", "getNeedConversationRequest", "()Z", "setNeedConversationRequest", "(Z)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationFragmentViewModel extends ViewModel {
    private boolean needConversationRequest;

    public ConversationFragmentViewModel() {
        this.needConversationRequest = true;
    }

    public final boolean getNeedConversationRequest() {
        return this.needConversationRequest;
    }

    public final void setNeedConversationRequest(boolean r1) {
        this.needConversationRequest = r1;
    }
}
