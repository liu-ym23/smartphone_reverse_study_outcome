package com.larus.bmhome.chat.input.swipe;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.clarification.x1;
import com.larus.bmhome.view.ChatMessageList;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ze8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001JC\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/input/swipe/InputSwipePanelDelegate;", "Lcom/larus/bmhome/chat/input/swipe/InputSwipePanelService;", "<init>", "()V", "isSwipeTransitionActive", "", "viewInWindow", "Landroid/view/View;", "show", "Lcom/larus/bmhome/chat/input/swipe/IInputSwipePanelSession;", "fragment", "Landroidx/fragment/app/Fragment;", "mirrorRoot", "Landroid/view/ViewGroup;", "inputDelegate", "adapter", "Lcom/larus/bmhome/chat/input/swipe/IInputSwipePanelAdapter;", "jointStyle", "maxPanelHeightPx", "", "showIndicator", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class InputSwipePanelDelegate implements InputSwipePanelService {
    public static final InputSwipePanelDelegate b = null;
    public final /* synthetic */ InputSwipePanelService a;

    static {
        b = new InputSwipePanelDelegate();
    }

    @Override // com.larus.bmhome.chat.input.swipe.InputSwipePanelService
    public final boolean a(ChatMessageList r2) {
        Intrinsics.checkNotNullParameter(r2, "viewInWindow");
        return this.a.a(r2);
    }

    @Override // com.larus.bmhome.chat.input.swipe.InputSwipePanelService
    public final b b(Fragment r10, ViewGroup r11, View r12, x1 r13, boolean r14, int r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "mirrorRoot");
        Intrinsics.checkNotNullParameter(r12, "inputDelegate");
        Intrinsics.checkNotNullParameter(r13, "adapter");
        return this.a.b(r10, r11, r12, r13, r14, r15, r16);
    }

    private InputSwipePanelDelegate() {
        InputSwipePanelService r0 = (InputSwipePanelService) ServiceManager.get().getService(InputSwipePanelService.class);
        if (r0 != null) goto L5;
        r0 = EmptyInputSwipePanelService.a;
    L5:
        this.a = r0;
    }
}
