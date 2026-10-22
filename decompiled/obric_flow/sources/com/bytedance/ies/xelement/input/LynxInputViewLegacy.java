package com.bytedance.ies.xelement.input;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/xelement/input/LynxInputViewLegacy;", "Lcom/bytedance/ies/xelement/input/LynxInputView;", "x-element-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxInputViewLegacy extends LynxInputView {
    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void initialize() {
        super.initialize();
        LynxFeatureCounter.a(79, this.mContext.A);
        LynxError r5 = new LynxError(220101, "A deprecated <input> is created!", "Please use <x-input> instead.", "error");
        r5.f9990a = true;
        getLynxContext().b(r5);
    }
}
