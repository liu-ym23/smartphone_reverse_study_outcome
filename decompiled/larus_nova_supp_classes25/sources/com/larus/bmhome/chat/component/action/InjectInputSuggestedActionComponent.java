package com.larus.bmhome.chat.component.action;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/action/InjectInputSuggestedActionComponent;", "Lcom/larus/bmhome/chat/component/action/SuggestedActionComponent;", "<init>", "()V", "initSuggestedAction", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class InjectInputSuggestedActionComponent extends SuggestedActionComponent {

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.action.SuggestedActionComponent
    public final void D3() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new InjectInputSuggestedActionComponent$initSuggestedAction$1(this, null), 3, null);
    }

    public InjectInputSuggestedActionComponent() {
    }
}
