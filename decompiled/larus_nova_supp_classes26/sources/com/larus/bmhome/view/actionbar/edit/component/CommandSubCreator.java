package com.larus.bmhome.view.actionbar.edit.component;

import com.larus.bmhome.instruction.IInstructionSubCreator;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/CommandSubCreator;", "Lcom/larus/bmhome/instruction/IInstructionSubCreator;", "<init>", "()V", "getMultiItemType", "", "generateInstructionController", "Lcom/larus/bmhome/instruction/base/AbsInstructionController;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommandSubCreator implements IInstructionSubCreator {
    public CommandSubCreator() {
    }

    @Override // com.larus.bmhome.instruction.IInstructionSubCreator
    public final int getMultiItemType() {
        return 5;
    }

    @Override // com.larus.bmhome.instruction.IInstructionSubCreator
    public final up8.b d() {
        return new xs8.e(0);
    }
}
