package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CustomLayoutShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public CustomLayoutShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r3, String r4, x0 r5) {
        CustomLayoutShadowNode r0 = (CustomLayoutShadowNode) r3;
        r4.getClass();
        if (r4.equals("custom-layout") == true) goto L6;
        super.a(r3, r4, r5);
        return;
    L6:
        r0.setCustomLayout(r5.b(r4, false));
    }
}
