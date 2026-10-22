package com.larus.bmhome.view.actionbar.edit.creator.sub;

import com.larus.bmhome.instruction.IInstructionSubCreator;
import kotlin.Metadata;
import up8.b;
import xs8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/creator/sub/FeatureSelectorSubCreator;", "Lcom/larus/bmhome/instruction/IInstructionSubCreator;", "<init>", "()V", "getMultiItemType", "", "generateInstructionController", "Lcom/larus/bmhome/instruction/base/AbsInstructionController;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureSelectorSubCreator implements IInstructionSubCreator {
    public FeatureSelectorSubCreator() {
    }

    @Override // com.larus.bmhome.instruction.IInstructionSubCreator
    public final int getMultiItemType() {
        return 2;
    }

    @Override // com.larus.bmhome.instruction.IInstructionSubCreator
    public final b d() {
        return new h();
    }
}
