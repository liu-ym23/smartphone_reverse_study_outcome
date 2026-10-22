package com.bytedance.ies.xelement.text.inlinetruncation;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxInlineTruncationShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public LynxInlineTruncationShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void b(ShadowNode r5, String r10, y0 r11) {
        LynxInlineTruncationShadowNode r12 = (LynxInlineTruncationShadowNode) r5;
        r10.getClass();
        if (r10.equals("stick") == true) goto L6;
        super.b(r5, r10, r11);
        return;
    L6:
        r12.setStick(r11.e(r10, false));
    }
}
