package com.lynx.xelement.input;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxUIBaseInputShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public LynxUIBaseInputShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void b(ShadowNode r5, String r10, y0 r11) {
        LynxUIBaseInputShadowNode r12 = (LynxUIBaseInputShadowNode) r5;
        r10.getClass();
        if (r10.equals("line-spacing") == true) goto L6;
        super.b(r5, r10, r11);
        return;
    L6:
        r12.setLineSpacingStr(r11.f10815a.getDynamic(r10));
    }
}
