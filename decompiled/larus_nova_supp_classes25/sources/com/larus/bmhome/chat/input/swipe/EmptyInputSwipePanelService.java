package com.larus.bmhome.chat.input.swipe;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.clarification.x1;
import com.larus.bmhome.view.ChatMessageList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ze8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/input/swipe/EmptyInputSwipePanelService;", "Lcom/larus/bmhome/chat/input/swipe/InputSwipePanelService;", "<init>", "()V", "show", "Lcom/larus/bmhome/chat/input/swipe/IInputSwipePanelSession;", "fragment", "Landroidx/fragment/app/Fragment;", "mirrorRoot", "Landroid/view/ViewGroup;", "inputDelegate", "Landroid/view/View;", "adapter", "Lcom/larus/bmhome/chat/input/swipe/IInputSwipePanelAdapter;", "jointStyle", "", "maxPanelHeightPx", "", "showIndicator", "isSwipeTransitionActive", "viewInWindow", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class EmptyInputSwipePanelService implements InputSwipePanelService {
    public static final EmptyInputSwipePanelService a = null;

    static {
        a = new EmptyInputSwipePanelService();
    }

    private EmptyInputSwipePanelService() {
    }

    @Override // com.larus.bmhome.chat.input.swipe.InputSwipePanelService
    public final boolean a(ChatMessageList r2) {
        Intrinsics.checkNotNullParameter(r2, "viewInWindow");
        return false;
    }

    @Override // com.larus.bmhome.chat.input.swipe.InputSwipePanelService
    public final b b(Fragment r1, ViewGroup r2, View r3, x1 r4, boolean r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        Intrinsics.checkNotNullParameter(r2, "mirrorRoot");
        Intrinsics.checkNotNullParameter(r3, "inputDelegate");
        Intrinsics.checkNotNullParameter(r4, "adapter");
        return null;
    }
}
