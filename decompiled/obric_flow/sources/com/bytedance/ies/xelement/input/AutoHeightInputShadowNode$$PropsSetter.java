package com.bytedance.ies.xelement.input;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class AutoHeightInputShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public AutoHeightInputShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void b(ShadowNode r5, String r10, y0 r11) {
        AutoHeightInputShadowNode r12 = (AutoHeightInputShadowNode) r5;
        r10.getClass();
        if (r10.equals("font-size") == true) goto L6;
        super.b(r5, r10, r11);
        return;
    L6:
        r12.setFontTextSize(r11.f10815a.getDynamic(r10));
    }
}
