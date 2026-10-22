package com.larus.business.floatchat.impl.component;

import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.vm.ComponentViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004JB\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000fJ\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000f¨\u0006\u0016"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateVM;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/business/floatchat/impl/component/AIFloatChatWindowStateVMState;", "<init>", "()V", "updateWindowState", "", "state", "Lcom/larus/bmhome/ability/FloatChatWindowState;", "heightPx", "", "showPercent", "from", "", "needAnim", "", "anchorMessage", "Lcom/larus/im/bean/message/Message;", "autoExpandedFromPreview", "updateWindowHeight", "updateDraggingState", "isDragging", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatWindowStateVM extends ComponentViewModel<AIFloatChatWindowStateVMState> {
    public static /* synthetic */ AIFloatChatWindowStateVMState No(int r0, int r1, AIFloatChatWindowStateVMState r2) {
        return updateWindowHeight$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ AIFloatChatWindowStateVMState Oo(FloatChatWindowState r0, int r1, int r2, String r3, boolean r4, Message r5, boolean r6, AIFloatChatWindowStateVMState r7) {
        return updateWindowState$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ AIFloatChatWindowStateVMState Po(boolean r0, AIFloatChatWindowStateVMState r1) {
        return updateDraggingState$lambda$2(r0, r1);
    }

    public AIFloatChatWindowStateVM() {
    }

    public final void updateDraggingState(final boolean r2) {
        setStateImmediate(new b1(r2));
    }

    private static final AIFloatChatWindowStateVMState updateDraggingState$lambda$2(boolean r13, AIFloatChatWindowStateVMState r14) {
        Intrinsics.checkNotNullParameter(r14, "$this$setStateImmediate");
        if (r14.isDragging() != r13) goto L6;
        return r14;
    L6:
        return AIFloatChatWindowStateVMState.copy$default(r14, null, 0, 0, null, false, null, false, false, r13, 255, null);
    }

    public final void updateWindowHeight(final int r2, final int r3) {
        setStateImmediate(new a1(r2, r3));
    }

    private static final AIFloatChatWindowStateVMState updateWindowHeight$lambda$1(int r13, int r14, AIFloatChatWindowStateVMState r15) {
        Intrinsics.checkNotNullParameter(r15, "$this$setStateImmediate");
        if (r15.getHeightPx() != r13) goto L8;
        if (r15.getShowPercent() != r14) goto L8;
        return r15;
    L8:
        return AIFloatChatWindowStateVMState.copy$default(r15, null, r13, r14, null, false, null, false, true, false, 377, null);
    }

    public final void updateWindowState(final FloatChatWindowState r10, final int r11, final int r12, final String r13, final boolean r14, final Message r15, final boolean r16) {
        Intrinsics.checkNotNullParameter(r10, "state");
        Intrinsics.checkNotNullParameter(r13, "from");
        setStateImmediate(new c1(r10, r11, r12, r13, r14, r15, r16));
    }

    private static final AIFloatChatWindowStateVMState updateWindowState$lambda$0(FloatChatWindowState r11, int r12, int r13, String r14, boolean r15, Message r16, boolean r17, AIFloatChatWindowStateVMState r18) {
        Intrinsics.checkNotNullParameter(r18, "$this$setStateImmediate");
        return r18.copy(r11, r12, r13, r14, r15, r16, r17, false, false);
    }

    public static /* synthetic */ void updateWindowState$default(AIFloatChatWindowStateVM r9, FloatChatWindowState r10, int r11, int r12, String r13, boolean r14, Message r15, boolean r16, int r17, Object r18) {
        if ((r17 & 64) == 0) goto L5;
        boolean r8 = false;
    L6:
        r9.updateWindowState(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }
}
