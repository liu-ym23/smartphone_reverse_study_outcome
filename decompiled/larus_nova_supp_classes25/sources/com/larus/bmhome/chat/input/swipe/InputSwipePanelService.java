package com.larus.bmhome.chat.input.swipe;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.clarification.x1;
import com.larus.bmhome.view.ChatMessageList;
import kotlin.Metadata;
import ze8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\rH&J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\tH&¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/input/swipe/InputSwipePanelService;", "", "show", "Lcom/larus/bmhome/chat/input/swipe/IInputSwipePanelSession;", "fragment", "Landroidx/fragment/app/Fragment;", "mirrorRoot", "Landroid/view/ViewGroup;", "inputDelegate", "Landroid/view/View;", "adapter", "Lcom/larus/bmhome/chat/input/swipe/IInputSwipePanelAdapter;", "jointStyle", "", "maxPanelHeightPx", "", "showIndicator", "isSwipeTransitionActive", "viewInWindow", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface InputSwipePanelService {
    boolean a(ChatMessageList r1);

    b b(Fragment r1, ViewGroup r2, View r3, x1 r4, boolean r5, int r6, boolean r7);
}
