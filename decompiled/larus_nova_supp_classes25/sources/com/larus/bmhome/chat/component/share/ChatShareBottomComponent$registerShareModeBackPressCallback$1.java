package com.larus.bmhome.chat.component.share;

import androidx.activity.OnBackPressedCallback;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/component/share/ChatShareBottomComponent$registerShareModeBackPressCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatShareBottomComponent$registerShareModeBackPressCallback$1 extends OnBackPressedCallback {
    public final /* synthetic */ ChatShareBottomComponent a;

    public final void handleOnBackPressed() {
        ChatShareBottomComponent r0 = this.a;
        int r1 = ChatShareBottomComponent.R;
        if (r0.e4().isSelectMode() == false) goto L5;
        this.a.e4().exitSelectMode();
    L5:
        remove();
    }

    public ChatShareBottomComponent$registerShareModeBackPressCallback$1(ChatShareBottomComponent r1) {
        this.a = r1;
        super(true);
    }
}
