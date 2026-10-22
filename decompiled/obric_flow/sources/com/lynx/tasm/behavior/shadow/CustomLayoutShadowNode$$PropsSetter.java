package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class CustomLayoutShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public CustomLayoutShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void b(ShadowNode r5, String r10, y0 r11) {
        CustomLayoutShadowNode r12 = (CustomLayoutShadowNode) r5;
        r10.getClass();
        if (r10.equals("custom-layout") == true) goto L6;
        super.b(r5, r10, r11);
        return;
    L6:
        r12.setCustomLayout(r11.e(r10, false));
    }
}
