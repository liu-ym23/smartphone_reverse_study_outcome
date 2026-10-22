package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewModelEx;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewExState;", "<init>", "()V", "setHasAutoOpenedCamera", "", "hasAutoOpenedCamera", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MultimodalInputComponentViewModelEx extends ComponentViewModel<MultimodalInputComponentViewExState> {
    public static final a Companion = null;
    private static final String TAG = "MultimodalInputComponentViewModelEx";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MultimodalInputComponentViewExState No(boolean r0, MultimodalInputComponentViewExState r1) {
        return setHasAutoOpenedCamera$lambda$0(r0, r1);
    }

    public MultimodalInputComponentViewModelEx() {
    }

    public final void setHasAutoOpenedCamera(final boolean r4) {
        FLogger.a.i(TAG, "setHasAutoOpenedCamera: " + r4);
        setStateImmediate(new d1(r4));
    }

    private static final MultimodalInputComponentViewExState setHasAutoOpenedCamera$lambda$0(boolean r1, MultimodalInputComponentViewExState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setStateImmediate");
        return r2.copy(r1);
    }
}
