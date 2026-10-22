package com.lynx.xelement.input;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIBaseInputShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public LynxUIBaseInputShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r3, String r4, x0 r5) {
        LynxUIBaseInputShadowNode r0 = (LynxUIBaseInputShadowNode) r3;
        r4.getClass();
        if (r4.equals("line-spacing") == true) goto L6;
        super.a(r3, r4, r5);
        return;
    L6:
        r0.setLineSpacingStr(r5.d(r4));
    }
}
