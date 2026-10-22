package com.bytedance.ies.xelement.text.inlinetext;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxInlineTextShadowNode$$PropsSetter extends InlineTextShadowNode$$PropsSetter {
    public LynxInlineTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void b(ShadowNode r5, String r10, y0 r11) {
        LynxInlineTextShadowNode r12 = (LynxInlineTextShadowNode) r5;
        r10.getClass();
        if (r10.equals("no-trim") == true) goto L6;
        super.b(r5, r10, r11);
        return;
    L6:
        r12.setNoTrim(r11.e(r10, true));
    }
}
